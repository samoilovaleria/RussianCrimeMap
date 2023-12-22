package handlers;

import java.util.HashMap;
import java.util.Map;

public class ColorHandler {

    private static int groupCount = 6;

    public static void main(String[] args) {
        Map<String, Integer> data = new HashMap<>();

        data.put("Altay", 39177);
        data.put("Amur", 16253);
        data.put("Arkhangel'sk", 16786);
        data.put("Astrakhan'", 13062);
        data.put("Belgorod", 14588);
        data.put("Bryansk", 13549);
        data.put("Vladimir", 16254);
        data.put("Volgograd", 36031);
        data.put("Vologda", 17411);
        data.put("Voronezh", 30460);
        data.put("Yevrey", 3164);
        data.put("Chita", 20816);
        data.put("Ivanovo", 11791);
        data.put("Irkutsk", 37867);
        data.put("Kabardin-Balkar", 7416);
        data.put("Kaliningrad", 12645);
        data.put("Kaluga", 14656);
        data.put("Kamchatka", 5450);
        data.put("Karachay-Cherkess", 4436);
        data.put("Kemerovo", 47071);
        data.put("Kirov", 18519);
        data.put("Kostroma", 8188);
        data.put("Krasnodar", 77125);
        data.put("Krasnoyarsk", 45561);
        data.put("Kurgan", 13456);
        data.put("Kursk", 13448);
        data.put("Leningrad", 28569);
        data.put("Lipetsk", 13940);
        data.put("Magadan", 2386);
        data.put("Moskovsskaya", 74054);
        data.put("Murmansk", 12075);
        data.put("Nenets", 686);
        data.put("Nizhegorod", 39404);
        data.put("Novgorod", 10615);
        data.put("Novosibirsk", 46814);
        data.put("Omsk", 23074);
        data.put("Orenburg", 21742);
        data.put("Orel", 8243);
        data.put("Penza", 13274);
        data.put("Perm'", 41027);
        data.put("Primor'ye", 33604);
        data.put("Pskov", 8714);
        data.put("Adygey", 4388);
        data.put("Gorno-Altay", 4586);
        data.put("Bashkortostan", 50751);
        data.put("Buryat", 19955);
        data.put("Dagestan", 14357);
        data.put("Ingush", 2233);
        data.put("Kalmyk", 2693);
        data.put("Karelia", 11850);
        data.put("Komi", 14797);
        data.put("Crimea", 20779);
        data.put("Mariy-El", 7741);
        data.put("Mordovia", 8107);
        data.put("Sakha (Yakutia)", 13000);
        data.put("North Ossetia", 8065);
        data.put("Tatarstan", 52189);
        data.put("Tuva", 6619);

        Map<String, Integer> regionGroups = new HashMap<>();

        // Разделение максимального значения на количество групп
        int maxRegionValue = 0;
        for (Integer value : data.values()) {
            if (value > maxRegionValue) {
                maxRegionValue = value;
            }
        }
        int groupSize = maxRegionValue / groupCount;

        // Присваиваем айди группы каждому региону
        for (String key : data.keySet()) {
            String region = key;
            int regionValue = data.get(region);
            int group = (int)Math.ceil(regionValue / groupSize) + 1;
            if (group > groupCount) group = groupCount;
            regionGroups.put(region, group);
        }

    }
}