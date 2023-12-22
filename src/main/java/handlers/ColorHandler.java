package handlers;

import java.util.HashMap;
import java.util.Map;

public class ColorHandler {

    final private static int groupCount = 6;
    final private Map<String, Integer> groups;

    private int maxRegionValue = 80000;

    public ColorHandler() {
        Map<String, Integer> colors = new HashMap<>();

        colors.put("Altay", 39177);
        colors.put("Amur", 16253);
        colors.put("Arkhangel'sk", 16786);
        colors.put("Astrakhan'", 13062);
        colors.put("Belgorod", 14588);
        colors.put("Bryansk", 13549);
        colors.put("Vladimir", 16254);
        colors.put("Volgograd", 36031);
        colors.put("Vologda", 17411);
        colors.put("Voronezh", 30460);
        colors.put("Yevrey", 3164);
        colors.put("Chita", 20816);
        colors.put("Ivanovo", 11791);
        colors.put("Irkutsk", 37867);
        colors.put("Kabardin-Balkar", 7416);
        colors.put("Kaliningrad", 12645);
        colors.put("Kaluga", 14656);
        colors.put("Kamchatka", 5450);
        colors.put("Karachay-Cherkess", 4436);
        colors.put("Kemerovo", 47071);
        colors.put("Kirov", 18519);
        colors.put("Kostroma", 8188);
        colors.put("Krasnodar", 77125);
        colors.put("Krasnoyarsk", 45561);
        colors.put("Kurgan", 13456);
        colors.put("Kursk", 13448);
        colors.put("Leningrad", 24665);
        colors.put("Lipetsk", 15376);
        colors.put("Magadan", 3220);
        colors.put("Moskovsskaya", 113869);
        colors.put("Murmansk", 15970);
        colors.put("Nenets", 772);
        colors.put("Nizhegorod", 65614);
        colors.put("Novgorod", 11193);
        colors.put("Novosibirsk", 56541);
        colors.put("Omsk", 29855);
        colors.put("Orenburg", 31032);
        colors.put("Orel", 12614);
        colors.put("Penza", 14969);
        colors.put("Perm'", 58394);
        colors.put("Primor'ye", 45637);
        colors.put("Pskov", 11301);
        colors.put("Adygey", 4566);
        colors.put("Gorno-Altay", 4921);
        colors.put("Bashkortostan", 68471);
        colors.put("Buryat", 24137);
        colors.put("Dagestan", 12550);
        colors.put("Ingush", 1933);
        colors.put("Kalmyk", 3799);
        colors.put("Karelia", 14258);
        colors.put("Komi", 17247);
        colors.put("Crimea", 0);
        colors.put("Mariy-El", 10842);
        colors.put("Mordovia", 7767);
        colors.put("Sakha (Yakutia)", 15098);
        colors.put("North Ossetia", 6618);
        colors.put("Tatarstan", 55318);
        colors.put("Tuva", 5554);
        colors.put("Khakass", 10799);
        colors.put("Rostov", 56282);
        colors.put("Ryazan'", 9716);
        colors.put("Samara", 62445);
        colors.put("Saratov", 32740);
        colors.put("Sakhalin", 10026);
        colors.put("Sverdlovsk", 77347);
        colors.put("Smolensk", 13754);
        colors.put("Stavropol'", 33476);
        colors.put("Tambov", 11473);
        colors.put("Tver'", 20292);
        colors.put("Tomsk", 20616);
        colors.put("Tula", 12281);
        colors.put("Tyumen'", 30248);
        colors.put("Udmurt", 26875);
        colors.put("Ul'yanovsk", 15431);
        colors.put("Khabarovsk", 29598);
        colors.put("Khanty-Mansiy", 24140);
        colors.put("Chelyabinsk", 62708);
        colors.put("Chechnya", 3500);
        colors.put("Chuvash", 13782);
        colors.put("Chukchi Autonomous Okrug", 645);
        colors.put("Yamal-Nenets", 9008);
        colors.put("Yaroslavl'", 15512);
        colors.put("Moskva", 182873);
        colors.put("City of St. Petersburg", 56463);
        colors.put("Sevastopol", 5703);

        groups = new HashMap<>();

        // Разделение максимального значения на количество групп
//        maxRegionValue = 0;
//        for (Integer value : colors.values()) {
//            if (value > maxRegionValue) {
//                maxRegionValue = value;
//            }
//        }
        int groupSize = maxRegionValue / groupCount;

        // Присваиваем айди группы каждому региону
        for (String region : colors.keySet()) {
            int regionValue = colors.get(region);
            int group = (int) Math.ceil(regionValue / groupSize) + 1;
            if (group > groupCount) group = groupCount;
            groups.put(region, group);
        }
        System.out.println(groups);

    }

    public Map<String, Integer> getGroups() {
        return groups;
    }
}