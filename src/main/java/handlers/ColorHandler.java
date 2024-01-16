package handlers;

import hidden.Constants;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ColorHandler extends Constants {

	private final int MAX_REGION_VALUE_ALL = 80000;
	private final int MAX_REGION_VALUE_PEOPLE = 70;
	private final int GROUP_COUNT = 8;
	private final int GROUP_SIZE_COLOR = MAX_REGION_VALUE_ALL / GROUP_COUNT;
	private final int GROUP_SIZE_PEOPLE = MAX_REGION_VALUE_PEOPLE / GROUP_COUNT;

	private final Map<String, Map<String, Integer>> groups = new HashMap<>();
	private final Map<String, Map<String, Integer>> colors = new HashMap<>();
	private final Map<String, Map<String, Integer>> people = new HashMap<>();
	private final Map<String, Map<String, Integer>> peopleGroups = new HashMap<>();

	public ColorHandler() throws SQLException, ClassNotFoundException {
		initializeMaps();
		retrieveDataFromDatabase();
	}

	private void initializeMaps() {
		for (int year = 2011; year <= 2022; year++) {
			groups.put("groups_" + year, new HashMap<>());
			colors.put("colors_" + year, new HashMap<>());
			people.put("people_" + year, new HashMap<>());
			peopleGroups.put("people_groups_" + year, new HashMap<>());
		}
	}

	private void retrieveDataFromDatabase() throws SQLException, ClassNotFoundException {
		String query = "SELECT * FROM " + CRIMES_TABLE + ";";
		PreparedStatement statement = DatabaseHandler.getInstance().prepareStatement(query);
		ResultSet result = statement.executeQuery(query);

		while (result.next()) {
			int let = 2;
			String region = result.getString(CRIMES_REGIONS);
			for (int year = 2011; year <= 2022; year++) {
				if (let == 14) break;
				else {
					int value = result.getInt(let++);
					colors.get("colors_" + year).put(region, value);
				}
			}
		}

		query = "SELECT * FROM " + PEOPLE_TABLE + ";";
		statement = DatabaseHandler.getInstance().prepareStatement(query);
		result = statement.executeQuery(query);

		while (result.next()) {
			String region = result.getString(PEOPLE_REGIONS);
			int value;

			int let = 2;
			for (int year = 2011; year <= 2023; year++) {
				if (let == 14) break;
				else {

					int colorValue = colors.get("colors_" + year).get(region);
					int colorGroup = colorValue == 0 ? 0 : Math.min((int) Math.ceil(colorValue / GROUP_SIZE_COLOR) + 1, GROUP_COUNT);
					groups.get("groups_" + year).put(region, colorGroup);

					if (colors.get("colors_" + year).containsKey(region)) {
						value = colors.get("colors_" + year).get(region);
						if (value == 0)
							value = 1;
					} else {
						value = 1;
					}
					int peopleValue = result.getInt(let) * 100 / value;
					people.get("people_" + year).put(region, peopleValue);

					int peopleGroup = peopleValue == 0 ? 0 : Math.min((int) Math.ceil(peopleValue / GROUP_SIZE_PEOPLE) + 1, GROUP_COUNT);
					peopleGroups.get("people_groups_" + year).put(region, peopleGroup);

					let++;
				}
			}
		}
//		System.out.println(colors.get("colors_2017"));
//		System.out.println(groups.get("groups_2017"));
//		System.out.println(people.get("people_2017"));
//		System.out.println(peopleGroups.get("people_groups_2011"));
	}

	public Map<String, Integer> getGroupsByYear(String year) {
		String groupsKey = "groups_" + year;
		if (groups.containsKey(groupsKey)) {
			return groups.get(groupsKey);
		} else {
			return new HashMap<>();
		}
	}

	public Map<String, Integer> getPeopleGroupsByYear(String year) {
		String groupsKey = "people_groups_" + year;
		if (peopleGroups.containsKey(groupsKey)) {
			return peopleGroups.get(groupsKey);
		} else {
			return new HashMap<>();
		}
	}

	public Map<String, Integer> getColorsByYear(String year) {
		String colorsKey = "colors_" + year;
		if (colors.containsKey(colorsKey)) {
			return colors.get(colorsKey);
		} else {
			return new HashMap<>();
		}
	}

	public Map<String, Integer> getPeopleByYear(String year) {
		String peopleKey = "people_" + year;
		if (people.containsKey(peopleKey)) {
			return people.get(peopleKey);
		} else {
			return new HashMap<>();
		}
	}
}