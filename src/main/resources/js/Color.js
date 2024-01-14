const pathElements = document.getElementsByClassName('region');
const colorElements = document.getElementsByClassName('color');
const nameDisplay = document.getElementById('nameOfRegion');
const textDisplay = document.getElementById('textOfRegion');
const nameText = document.getElementById('name');
const cityText = document.getElementById('city');
const messageText = document.getElementById('message');
const storyText = document.getElementById('story-text');
var groupColors = ['#ffdedb', '#fccec8', '#fabeb6', '#f69f9f', '#f38f8d', '#f07f7b', '#ed6f69', '#dc143c'];
var year = '2022';
var crime = 'all';

window.onload = async function () {
	try {
		var responseColors = await fetch('/api/' + crime + '_colors' + year);
		var groups = await responseColors.json();

		for (let element of pathElements) {
			element.addEventListener('mouseover', handleMouseOver);
			element.addEventListener('mouseout', handleMouseOut);
			let id = element.getAttribute('id');
			for (let group in groups) {
				if (id.includes(group)) {
					element.style.fill = groupColors[groups[group] - 1] ?? null;
					break;
				}
			}
		}

		let count = 0;
		for (let color of colorElements) {
			color.style.backgroundColor = groupColors[count];
			count++;
		}

	} catch (error) {
		console.error(error);
	}
};

// Обработка селекта года
async function readSelectedYear() {

	var selectElement = document.getElementById("year-select");
	var selectedValue = selectElement.value;
    year = selectedValue;

	var responseColors = await fetch('/api/' + crime + '_colors' + year);
    var groups = await responseColors.json();

    for (let element of pathElements) {
        let id = element.getAttribute('id');
        for (let group in groups) {
            if (id.includes(group)) {
                element.style.fill = groupColors[groups[group] - 1] ?? null;
                break;
            }
        }
    }

}

// Обработка селекта преступления
async function readSelectedCrime() {

	var selectElement = document.getElementById("crime-select");
	var selectedValue = selectElement.value;
    crime = selectedValue;

	var responseColors = await fetch('/api/' + crime + '_colors' + year);
    var groups = await responseColors.json();

    if (crime === 'people') {
            groupColors = ['#dc143c', '#ed6f69', '#f07f7b', '#f38f8d', '#f69f9f', '#fabeb6', '#fccec8', '#ffdedb'];
        }
    if (crime === 'all') {
        groupColors = ['#ffdedb', '#fccec8', '#fabeb6', '#f69f9f', '#f38f8d', '#f07f7b', '#ed6f69', '#dc143c'];
    }

    for (let element of pathElements) {
        let id = element.getAttribute('id');
        for (let group in groups) {
            if (id.includes(group)) {
                element.style.fill = groupColors[groups[group] - 1] ?? null;
                break;
            }
        }
    }

    let count = 0;
    for (let color of colorElements) {
        color.style.backgroundColor = groupColors[count];
        count++;
    }


}

// Обработчик события наведения на регион
async function handleMouseOver(event) {

	const id = event.target.getAttribute('id');
	const region = event.target;
	region.parentNode.appendChild(region);

	if (
		id === 'Sevastopol' ||
		id === 'Moskva' ||
		id === 'City of St. Petersburg' ||
		id === 'Moskovsskaya' ||
		id === 'Kaliningrad' ||
		id === 'Crimea') {
		region.style.transform = 'scale(1.005)';
	} else if (id === 'Leningrad') {
		region.style.transform = 'scale(1.002)';
	} else {
		region.style.transform = 'scale(1.03)';
	}


    var responseValues = await fetch('/api/' + crime + '_values' + year);
    var values = await responseValues.json();

    let dataText = '';
    if (crime === 'people') {
            dataText = 'В этот год тут было поймано ' + values[id] + '% преступников относительно общего количества преступлений. Если вы хотите узнать более подробную информацию и прочитать истории нажмите на выбранный регион.'
        }

        if (crime === 'all') {
            dataText = 'В этот год тут было совершено ' + values[id] + ' преступлений. Если вы хотите узнать более подробную информацию и прочитать истории нажмите на выбранный регион.'
        }

	let dataName = event.target.getAttribute('data-name');
	nameDisplay.textContent = dataName;
	textDisplay.textContent = dataText;

}

// Обработчик события ухода курсора с региона
function handleMouseOut(event) {

	const region = event.target;
	region.style.transform = 'scale(1)';
	nameDisplay.textContent = 'Российская Федерация';
	textDisplay.textContent = 'Наведитесь на интересующий регион.';

    const regionAdygey = document.getElementById('Adygey').target;
    regionAdygey.parentNode.appendChild(region);

}

// Плавный скролл

gsap.registerPlugin(ScrollTrigger, ScrollSmoother)

if (ScrollTrigger.isTouch !== 1) {

	ScrollSmoother.create({
		wrapper: '.wrapper',
		content: '.content',
		smooth: 1,
		effects: true
	})

	gsap.fromTo('.main-title-section', { opacity: 1 }, {
		opacity: 0,
		scrollTrigger: {
			trigger: '.main-title-section',
			start: 'center',
			end: '820',
			scrub: true
		}
	})

	let itemsL = gsap.utils.toArray('.preview-information-left .object')

	itemsL.forEach(item => {
		gsap.fromTo(item, { opacity: 0, x: -50 }, {
			opacity: 1, x: 0,
			scrollTrigger: {
				trigger: item,
				start: '-850',
				end: '-100',
				scrub: true
			}
		})
	})

	let itemsR = gsap.utils.toArray('.preview-information-right .object')

	itemsR.forEach(item => {
		gsap.fromTo(item, { opacity: 0, x: 50 }, {
			opacity: 1, x: 0,
			scrollTrigger: {
				trigger: item,
				start: '-750',
				end: 'top',
				scrub: true
			}
		})
	})

}

// При отправке фидбек формы якорь
function submitForm(event) {
    event.preventDefault();

    // Сохраняем текущую позицию прокрутки
    var scrollPosition = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop;

    var form = event.target;
    var formData = new FormData(form);
    var xhr = new XMLHttpRequest();
    xhr.open(form.method, form.action);

    xhr.onload = function() {
        if (xhr.status === 200) {
            // Восстанавливаем позицию прокрутки после перенаправления
            window.scrollTo(0, scrollPosition);

            window.history.back();
        }
    };

    nameText.value = "";
    cityText.value = "";
    messageText.value = "";
    let textForGratitude = 'Спасибо за то, что поделелись с нами своим мнением!';
    storyText.textContent = textForGratitude;

    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
    xhr.send(new URLSearchParams(formData));
}