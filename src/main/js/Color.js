// Анимация для всей группы, а не одной страны

const pathElement = document.getElementsByClassName('county');

pathElement.addEventListener('mouseover', function() {
  const parentGroup = pathElement.parentNode;
  parentGroup.classList.add('group-animation');
});

pathElement.addEventListener('mouseout', function() {
  const parentGroup = pathElement.parentNode;
  parentGroup.classList.remove('group-animation');
});

// Обозначение цветов для групп

var firstGroup = "#CD5C5C";
var secondGroup = "#F08080";
var thirdGroup = "#FA8072";
var fourthGroup = "#E9967A";
var fifthGroup = "#FFA07A";
var sixthGroup = "#DC143C";

// Обозначение переменных

var altayPath = document.getElementById("Altay");
var amurPath = document.getElementById("Amur")
var arkhangelPath = document.getElementById("Arkhangel'sk")
var astrakhanPath = document.getElementById("Astrakhan")
var belgorodPath = document.getElementById("Belgorod")
var bryanskPath = document.getElementById("Bryansk")
var vladimirPath = document.getElementById("Vladimir")
var volgogradPath = document.getElementById("Volgograd")
var vologdaPath = document.getElementById("Vologda")
var voronezhPath = document.getElementById("Voronezh")
var yevreyPath = document.getElementById("Yevrey")
var chitaPath = document.getElementById("Chita")
var ivanovoPath = document.getElementById("Ivanovo")
var irkutskPath = document.getElementById("Irkutsk")
var kabardinBalkarPath = document.getElementById("Kabardin-Balkar")
var kaliningradPath = document.getElementById("Kaliningrad")
var kalugaPath = document.getElementById("Kaluga")
var kamchatkaPath = document.getElementById("Kamchatka")
var karachayCherkessPath = document.getElementById("Karachay-Cherkess")
var kemerovoPath = document.getElementById("Kemerovo")
var kirovPath = document.getElementById("Kirov")
var kostromaPath = document.getElementById("Kostroma")
var krasnodarPath = document.getElementById("Krasnodar")
var krasnoyarskPath = document.getElementById("Krasnoyarsk")
var kurganPath = document.getElementById("Kurgan")
var kurskPath = document.getElementById("Kursk")
var leningradPath = document.getElementById("Leningrad")
var lipetskPath = document.getElementById("Lipetsk")
var magadanPath = document.getElementById("Magadan")
var moskovsskayaPath = document.getElementById("Moskovsskaya")
var murmanskPath = document.getElementById("Murmansk")
var nenetsPath = document.getElementById("Nenets")
var nizhegorodPath = document.getElementById("Nizhegorod")
var novgorodPath = document.getElementById("Novgorod")
var novosibirskPath = document.getElementById("Novosibirsk")
var omskPath = document.getElementById("Omsk")
var orenburgPath = document.getElementById("Orenburg")
var orelPath = document.getElementById("Orel")
var penzaPath = document.getElementById("Penza")
var permPath = document.getElementById("Perm")
var primoryePath = document.getElementById("Primor'ye")
var pskovPath = document.getElementById("Pskov")
var adygeyPath = document.getElementById("Adygey")
var gornoAltayPath = document.getElementById("Gorno-Altay")
var bashkortostanPath = document.getElementById("Bashkortostan")
var buryatPath = document.getElementById("Buryat")
var dagestanPath = document.getElementById("Dagestan")
var ingushPath = document.getElementById("Ingush")
var kalmykPath = document.getElementById("Kalmyk")
var kareliaPath = document.getElementById("Karelia")
var komiPath = document.getElementById("Komi")
var crimeaPath = document.getElementById("Crimea")
var mariyElPath = document.getElementById("Mariy-El")
var mordoviaPath = document.getElementById("Mordovia")
var yakutiaPath = document.getElementById("Sakha (Yakutia)")
var northOssetiaPath = document.getElementById("North Ossetia")
var tatarstanPath = document.getElementById("Tatarstan")
var tuvaPath = document.getElementById("Tuva")
var khakassPath = document.getElementById("Khakass")
var rostovPath = document.getElementById("Rostov")
var ryazanPath = document.getElementById("Ryazan")
var samaraPath = document.getElementById("Samara")
var saratovPath = document.getElementById("Saratov")
var sakhalinPath = document.getElementById("Sakhalin")
var sverdlovskPath = document.getElementById("Sverdlovsk")
var smolenskPath = document.getElementById("Smolensk")
var stavropolPath = document.getElementById("Stavropol")
var tambovPath = document.getElementById("Tambov")
var tverPath = document.getElementById("Tver")
var tomskPath = document.getElementById("Tomsk")
var tulaPath = document.getElementById("Tula")
var tyumenPath = document.getElementById("Tyumen")
var udmurtPath = document.getElementById("Udmurt")
var ulyanovskPath = document.getElementById("Ulyanovsk")
var khabarovskPath = document.getElementById("Khabarovsk")
var khantyMansiyPath = document.getElementById("Khanty-Mansiy")
var chelyabinskPath = document.getElementById("Chelyabinsk")
var chechnyaPath = document.getElementById("Chechnya")
var chuvashPath = document.getElementById("Chuvash")
var chukchiPath = document.getElementById("Chukchi Autonomous Okrug")
var yamalNenetsPath = document.getElementById("Yamal-Nenets")
var yaroslavlPath = document.getElementById("Yaroslavl")
var moskvaPath = document.getElementById("Moskva")
var petersburgPath = document.getElementById("City of St. Petersburg")
var sevastopolPath = document.getElementById("Sevastopol")
