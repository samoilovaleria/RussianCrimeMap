package handlers;

import hidden.Constants;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ColorHandler extends Constants {

	private int maxRegionValueAll = 80000;
	private int maxRegionValuePeople = 70;
	final private static int groupCount = 8;
	final private Map<String, Integer> groups_2011 = new HashMap<>();
	final private Map<String, Integer> groups_2012 = new HashMap<>();
	final private Map<String, Integer> groups_2013 = new HashMap<>();
	final private Map<String, Integer> groups_2014 = new HashMap<>();
	final private Map<String, Integer> groups_2015 = new HashMap<>();
	final private Map<String, Integer> groups_2016 = new HashMap<>();
	final private Map<String, Integer> groups_2017 = new HashMap<>();
	final private Map<String, Integer> groups_2018 = new HashMap<>();
	final private Map<String, Integer> groups_2019 = new HashMap<>();
	final private Map<String, Integer> groups_2020 = new HashMap<>();
	final private Map<String, Integer> groups_2021 = new HashMap<>();
	final private Map<String, Integer> groups_2022 = new HashMap<>();
	final private Map<String, Integer> colors_2011 = new HashMap<>();
	final private Map<String, Integer> colors_2012 = new HashMap<>();
	final private Map<String, Integer> colors_2013 = new HashMap<>();
	final private Map<String, Integer> colors_2014 = new HashMap<>();
	final private Map<String, Integer> colors_2015 = new HashMap<>();
	final private Map<String, Integer> colors_2016 = new HashMap<>();
	final private Map<String, Integer> colors_2017 = new HashMap<>();
	final private Map<String, Integer> colors_2018 = new HashMap<>();
	final private Map<String, Integer> colors_2019 = new HashMap<>();
	final private Map<String, Integer> colors_2020 = new HashMap<>();
	final private Map<String, Integer> colors_2021 = new HashMap<>();
	final private Map<String, Integer> colors_2022 = new HashMap<>();
	final private Map<String, Integer> people_2011 = new HashMap<>();
	final private Map<String, Integer> people_2012 = new HashMap<>();
	final private Map<String, Integer> people_2013 = new HashMap<>();
	final private Map<String, Integer> people_2014 = new HashMap<>();
	final private Map<String, Integer> people_2015 = new HashMap<>();
	final private Map<String, Integer> people_2016 = new HashMap<>();
	final private Map<String, Integer> people_2017 = new HashMap<>();
	final private Map<String, Integer> people_2018 = new HashMap<>();
	final private Map<String, Integer> people_2019 = new HashMap<>();
	final private Map<String, Integer> people_2020 = new HashMap<>();
	final private Map<String, Integer> people_2021 = new HashMap<>();
	final private Map<String, Integer> people_2022 = new HashMap<>();
	final private Map<String, Integer> people_groups_2011 = new HashMap<>();
	final private Map<String, Integer> people_groups_2012 = new HashMap<>();
	final private Map<String, Integer> people_groups_2013 = new HashMap<>();
	final private Map<String, Integer> people_groups_2014 = new HashMap<>();
	final private Map<String, Integer> people_groups_2015 = new HashMap<>();
	final private Map<String, Integer> people_groups_2016 = new HashMap<>();
	final private Map<String, Integer> people_groups_2017 = new HashMap<>();
	final private Map<String, Integer> people_groups_2018 = new HashMap<>();
	final private Map<String, Integer> people_groups_2019 = new HashMap<>();
	final private Map<String, Integer> people_groups_2020 = new HashMap<>();
	final private Map<String, Integer> people_groups_2021 = new HashMap<>();
	final private Map<String, Integer> people_groups_2022 = new HashMap<>();

	public ColorHandler() throws SQLException, ClassNotFoundException {
		String query = "SELECT * FROM " + CRIMES_TABLE + ";";
		PreparedStatement statement = DatabaseHandler.getInstance().prepareStatement(query);
		ResultSet result = statement.executeQuery(query);
		while (result.next()) {
			colors_2011.put(result.getString(CRIMES_REGIONS), result.getInt(CRIMES_2011));
			colors_2012.put(result.getString(CRIMES_REGIONS), result.getInt(CRIMES_2012));
			colors_2013.put(result.getString(CRIMES_REGIONS), result.getInt(CRIMES_2013));
			colors_2014.put(result.getString(CRIMES_REGIONS), result.getInt(CRIMES_2014));
			colors_2015.put(result.getString(CRIMES_REGIONS), result.getInt(CRIMES_2015));
			colors_2016.put(result.getString(CRIMES_REGIONS), result.getInt(CRIMES_2016));
			colors_2017.put(result.getString(CRIMES_REGIONS), result.getInt(CRIMES_2017));
			colors_2018.put(result.getString(CRIMES_REGIONS), result.getInt(CRIMES_2018));
			colors_2019.put(result.getString(CRIMES_REGIONS), result.getInt(CRIMES_2019));
			colors_2020.put(result.getString(CRIMES_REGIONS), result.getInt(CRIMES_2020));
			colors_2021.put(result.getString(CRIMES_REGIONS), result.getInt(CRIMES_2021));
			colors_2022.put(result.getString(CRIMES_REGIONS), result.getInt(CRIMES_2022));
		}

		query = "SELECT * FROM " + PEOPLE_TABLE + ";";
		statement = DatabaseHandler.getInstance().prepareStatement(query);
		result = statement.executeQuery(query);

		while (result.next()) {

			String region = result.getString(PEOPLE_REGIONS);
			int value2011, value2012, value2013, value2014, value2015, value2016, value2017, value2018, value2019, value2020, value2021, value2022;

			if (colors_2011.get(region) == 0) value2011 = 1; else value2011 = colors_2011.get(region);
			if (colors_2012.get(region) == 0) value2012 = 1; else value2012 = colors_2012.get(region);
			if (colors_2013.get(region) == 0) value2013 = 1; else value2013 = colors_2013.get(region);
			if (colors_2014.get(region) == 0) value2014 = 1; else value2014 = colors_2014.get(region);
			if (colors_2015.get(region) == 0) value2015 = 1; else value2015 = colors_2015.get(region);
			if (colors_2016.get(region) == 0) value2016 = 1; else value2016 = colors_2016.get(region);
			if (colors_2017.get(region) == 0) value2017 = 1; else value2017 = colors_2017.get(region);
			if (colors_2018.get(region) == 0) value2018 = 1; else value2018 = colors_2018.get(region);
			if (colors_2019.get(region) == 0) value2019 = 1; else value2019 = colors_2019.get(region);
			if (colors_2020.get(region) == 0) value2020 = 1; else value2020 = colors_2020.get(region);
			if (colors_2021.get(region) == 0) value2021 = 1; else value2021 = colors_2021.get(region);
			if (colors_2022.get(region) == 0) value2022 = 1; else value2022 = colors_2022.get(region);

			people_2011.put(region, result.getInt(PEOPLE_2011) * 100 / value2011);
			people_2012.put(region, result.getInt(PEOPLE_2012) * 100 / value2012);
			people_2013.put(region, result.getInt(PEOPLE_2013) * 100 / value2013);
			people_2014.put(region, result.getInt(PEOPLE_2014) * 100 / value2014);
			people_2015.put(region, result.getInt(PEOPLE_2015) * 100 / value2015);
			people_2016.put(region, result.getInt(PEOPLE_2016) * 100 / value2016);
			people_2017.put(region, result.getInt(PEOPLE_2017) * 100 / value2017);
			people_2018.put(region, result.getInt(PEOPLE_2018) * 100 / value2018);
			people_2019.put(region, result.getInt(PEOPLE_2019) * 100 / value2019);
			people_2020.put(region, result.getInt(PEOPLE_2020) * 100 / value2020);
			people_2021.put(region, result.getInt(PEOPLE_2021) * 100 / value2021);
			people_2022.put(region, result.getInt(PEOPLE_2022) * 100 / value2022);
		}

		int groupSizeAll = maxRegionValueAll / groupCount;
		int groupSizePeople = maxRegionValuePeople / groupCount;

		// Присваиваем айди группы каждому региону
		for (String region : colors_2011.keySet()) {
			int regionValue = colors_2011.get(region);
			int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSizeAll) + 1, groupCount);
			groups_2011.put(region, group);
		}
		for (String region : colors_2012.keySet()) {
			int regionValue = colors_2012.get(region);
			int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSizeAll) + 1, groupCount);
			groups_2012.put(region, group);
		}
		for (String region : colors_2013.keySet()) {
			int regionValue = colors_2013.get(region);
			int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSizeAll) + 1, groupCount);
			groups_2013.put(region, group);
		}
		for (String region : colors_2014.keySet()) {
			int regionValue = colors_2014.get(region);
			int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSizeAll) + 1, groupCount);
			groups_2014.put(region, group);
		}
		for (String region : colors_2015.keySet()) {
			int regionValue = colors_2015.get(region);
			int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSizeAll) + 1, groupCount);
			groups_2015.put(region, group);
		}
		for (String region : colors_2016.keySet()) {
			int regionValue = colors_2016.get(region);
			int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSizeAll) + 1, groupCount);
			groups_2016.put(region, group);
		}
		for (String region : colors_2017.keySet()) {
			int regionValue = colors_2017.get(region);
			int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSizeAll) + 1, groupCount);
			groups_2017.put(region, group);
		}
		for (String region : colors_2018.keySet()) {
			int regionValue = colors_2018.get(region);
			int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSizeAll) + 1, groupCount);
			groups_2018.put(region, group);
		}
		for (String region : colors_2019.keySet()) {
			int regionValue = colors_2019.get(region);
			int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSizeAll) + 1, groupCount);
			groups_2019.put(region, group);
		}
		for (String region : colors_2020.keySet()) {
			int regionValue = colors_2020.get(region);
			int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSizeAll) + 1, groupCount);
			groups_2020.put(region, group);
		}
		for (String region : colors_2021.keySet()) {
			int regionValue = colors_2021.get(region);
			int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSizeAll) + 1, groupCount);
			groups_2021.put(region, group);
		}
		for (String region : colors_2022.keySet()) {
			int regionValue = colors_2022.get(region);
			int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSizeAll) + 1, groupCount);
			groups_2022.put(region, group);
		}

		for (String region : people_2011.keySet()) {
			int regionValue = people_2011.get(region);
			int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSizePeople) + 1, groupCount);
			people_groups_2011.put(region, group);
		}
		for (String region : people_2012.keySet()) {
			int regionValue = people_2012.get(region);
			int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSizePeople) + 1, groupCount);
			people_groups_2012.put(region, group);
		}
		for (String region : people_2013.keySet()) {
			int regionValue = people_2013.get(region);
			int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSizePeople) + 1, groupCount);
			people_groups_2013.put(region, group);
		}
		for (String region : people_2014.keySet()) {
			int regionValue = people_2014.get(region);
			int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSizePeople) + 1, groupCount);
			people_groups_2014.put(region, group);
		}
		for (String region : people_2015.keySet()) {
			int regionValue = people_2015.get(region);
			int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSizePeople) + 1, groupCount);
			people_groups_2015.put(region, group);
		}
		for (String region : people_2016.keySet()) {
			int regionValue = people_2016.get(region);
			int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSizePeople) + 1, groupCount);
			people_groups_2016.put(region, group);
		}
		for (String region : people_2017.keySet()) {
			int regionValue = people_2017.get(region);
			int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSizePeople) + 1, groupCount);
			people_groups_2017.put(region, group);
		}
		for (String region : people_2018.keySet()) {
			int regionValue = people_2018.get(region);
			int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSizePeople) + 1, groupCount);
			people_groups_2018.put(region, group);
		}
		for (String region : people_2019.keySet()) {
			int regionValue = people_2019.get(region);
			int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSizePeople) + 1, groupCount);
			people_groups_2019.put(region, group);
		}
		for (String region : people_2020.keySet()) {
			int regionValue = people_2020.get(region);
			int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSizePeople) + 1, groupCount);
			people_groups_2020.put(region, group);
		}
		for (String region : people_2021.keySet()) {
			int regionValue = people_2021.get(region);
			int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSizePeople) + 1, groupCount);
			people_groups_2021.put(region, group);
		}
		for (String region : people_2022.keySet()) {
			int regionValue = people_2022.get(region);
			int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSizePeople) + 1, groupCount);
			people_groups_2022.put(region, group);
		}
	}

	public Map<String, Integer> getGroups_2011() {
		return groups_2011;
	}

	public Map<String, Integer> getGroups_2012() {
		return groups_2012;
	}

	public Map<String, Integer> getGroups_2013() {
		return groups_2013;
	}

	public Map<String, Integer> getGroups_2014() {
		return groups_2014;
	}

	public Map<String, Integer> getGroups_2015() {
		return groups_2015;
	}

	public Map<String, Integer> getGroups_2016() {
		return groups_2016;
	}

	public Map<String, Integer> getGroups_2017() {
		return groups_2017;
	}

	public Map<String, Integer> getGroups_2018() {
		return groups_2018;
	}

	public Map<String, Integer> getGroups_2019() {
		return groups_2019;
	}

	public Map<String, Integer> getGroups_2020() {
		return groups_2020;
	}

	public Map<String, Integer> getGroups_2021() {
		return groups_2021;
	}
	public Map<String, Integer> getGroups_2022() {
		return groups_2022;
	}

	public Map<String, Integer> getColors_2011() {
		return colors_2011;
	}

	public Map<String, Integer> getColors_2012() {
		return colors_2012;
	}

	public Map<String, Integer> getColors_2013() {
		return colors_2013;
	}

	public Map<String, Integer> getColors_2014() {
		return colors_2014;
	}

	public Map<String, Integer> getColors_2015() {
		return colors_2015;
	}

	public Map<String, Integer> getColors_2016() {
		return colors_2016;
	}

	public Map<String, Integer> getColors_2017() {
		return colors_2017;
	}

	public Map<String, Integer> getColors_2018() {
		return colors_2018;
	}

	public Map<String, Integer> getColors_2019() {
		return colors_2019;
	}

	public Map<String, Integer> getColors_2020() {
		return colors_2020;
	}

	public Map<String, Integer> getColors_2021() {
		return colors_2021;
	}

	public Map<String, Integer> getColors_2022() {
		return colors_2022;
	}

	public Map<String, Integer> getPeople_2011() {
		return people_2011;
	}

	public Map<String, Integer> getPeople_2012() {
		return people_2012;
	}

	public Map<String, Integer> getPeople_2013() {
		return people_2013;
	}

	public Map<String, Integer> getPeople_2014() {
		return people_2014;
	}

	public Map<String, Integer> getPeople_2015() {
		return people_2015;
	}

	public Map<String, Integer> getPeople_2016() {
		return people_2016;
	}

	public Map<String, Integer> getPeople_2017() {
		return people_2017;
	}

	public Map<String, Integer> getPeople_2018() {
		return people_2018;
	}

	public Map<String, Integer> getPeople_2019() {
		return people_2019;
	}

	public Map<String, Integer> getPeople_2020() {
		return people_2020;
	}

	public Map<String, Integer> getPeople_2021() {
		return people_2021;
	}

	public Map<String, Integer> getPeople_2022() {
		return people_2022;
	}

	public Map<String, Integer> getPeople_groups_2011() {
		return people_groups_2011;
	}

	public Map<String, Integer> getPeople_groups_2012() {
		return people_groups_2012;
	}

	public Map<String, Integer> getPeople_groups_2013() {
		return people_groups_2013;
	}

	public Map<String, Integer> getPeople_groups_2014() {
		return people_groups_2014;
	}

	public Map<String, Integer> getPeople_groups_2015() {
		return people_groups_2015;
	}

	public Map<String, Integer> getPeople_groups_2016() {
		return people_groups_2016;
	}

	public Map<String, Integer> getPeople_groups_2017() {
		return people_groups_2017;
	}

	public Map<String, Integer> getPeople_groups_2018() {
		return people_groups_2018;
	}

	public Map<String, Integer> getPeople_groups_2019() {
		return people_groups_2019;
	}

	public Map<String, Integer> getPeople_groups_2020() {
		return people_groups_2020;
	}

	public Map<String, Integer> getPeople_groups_2021() {
		return people_groups_2021;
	}

	public Map<String, Integer> getPeople_groups_2022() {
		return people_groups_2022;
	}
}