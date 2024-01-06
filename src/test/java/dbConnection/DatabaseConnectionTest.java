package dbConnection;

import handlers.DatabaseHandler;
import hidden.Constants;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DatabaseConnectionTest extends Constants {

    static private int maxRegionValue = 80000;
    final private static int groupCount = 8;
    static final private Map<String, Integer> groups_2011 = new HashMap<>();
    static final private Map<String, Integer> groups_2012 = new HashMap<>();
    static final private Map<String, Integer> groups_2013 = new HashMap<>();
    static final private Map<String, Integer> groups_2014 = new HashMap<>();
    static final private Map<String, Integer> groups_2015 = new HashMap<>();
    static final private Map<String, Integer> groups_2016 = new HashMap<>();
    static final private Map<String, Integer> groups_2017 = new HashMap<>();
    static final private Map<String, Integer> groups_2018 = new HashMap<>();
    static final private Map<String, Integer> groups_2019 = new HashMap<>();
    static final private Map<String, Integer> groups_2020 = new HashMap<>();
    static final private Map<String, Integer> groups_2021 = new HashMap<>();
    static final private Map<String, Integer> groups_2022 = new HashMap<>();

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM " + CRIMES_TABLE + ";";
        PreparedStatement statement = DatabaseHandler.getInstance().prepareStatement(query);
        ResultSet result = statement.executeQuery(query);

        Map<String, Integer> colors_2011 = new HashMap<>();
        Map<String, Integer> colors_2012 = new HashMap<>();
        Map<String, Integer> colors_2013 = new HashMap<>();
        Map<String, Integer> colors_2014 = new HashMap<>();
        Map<String, Integer> colors_2015 = new HashMap<>();
        Map<String, Integer> colors_2016 = new HashMap<>();
        Map<String, Integer> colors_2017 = new HashMap<>();
        Map<String, Integer> colors_2018 = new HashMap<>();
        Map<String, Integer> colors_2019 = new HashMap<>();
        Map<String, Integer> colors_2020 = new HashMap<>();
        Map<String, Integer> colors_2021 = new HashMap<>();
        Map<String, Integer> colors_2022 = new HashMap<>();

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

        // Разделение максимального значения на количество групп
//        maxRegionValue = 0;
//        for (Integer value : colors.values()) {
//            if (value > maxRegionValue) {
//                maxRegionValue = value;
//            }
//        }

        int groupSize = maxRegionValue / groupCount;

        // Присваиваем айди группы каждому региону
        for (String region : colors_2011.keySet()) {
            int regionValue = colors_2011.get(region);
            int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSize) + 1, groupCount);
            groups_2011.put(region, group);
        }
        for (String region : colors_2012.keySet()) {
            int regionValue = colors_2012.get(region);
            int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSize) + 1, groupCount);
            groups_2012.put(region, group);
        }
        for (String region : colors_2013.keySet()) {
            int regionValue = colors_2013.get(region);
            int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSize) + 1, groupCount);
            groups_2013.put(region, group);
        }
        for (String region : colors_2014.keySet()) {
            int regionValue = colors_2014.get(region);
            int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSize) + 1, groupCount);
            groups_2014.put(region, group);
        }
        for (String region : colors_2015.keySet()) {
            int regionValue = colors_2015.get(region);
            int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSize) + 1, groupCount);
            groups_2015.put(region, group);
        }
        for (String region : colors_2016.keySet()) {
            int regionValue = colors_2016.get(region);
            int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSize) + 1, groupCount);
            groups_2016.put(region, group);
        }
        for (String region : colors_2017.keySet()) {
            int regionValue = colors_2017.get(region);
            int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSize) + 1, groupCount);
            groups_2017.put(region, group);
        }
        for (String region : colors_2018.keySet()) {
            int regionValue = colors_2018.get(region);
            int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSize) + 1, groupCount);
            groups_2018.put(region, group);
        }
        for (String region : colors_2019.keySet()) {
            int regionValue = colors_2019.get(region);
            int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSize) + 1, groupCount);
            groups_2019.put(region, group);
        }
        for (String region : colors_2020.keySet()) {
            int regionValue = colors_2020.get(region);
            int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSize) + 1, groupCount);
            groups_2020.put(region, group);
        }
        for (String region : colors_2021.keySet()) {
            int regionValue = colors_2021.get(region);
            int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSize) + 1, groupCount);
            groups_2021.put(region, group);
        }
        for (String region : colors_2022.keySet()) {
            int regionValue = colors_2022.get(region);
            int group = regionValue == 0 ? 0 : Math.min((int) Math.ceil(regionValue / groupSize) + 1, groupCount);
            groups_2022.put(region, group);
        }

    }

}
