const pathElements = document.getElementsByClassName('region');
const colorElements = document.getElementsByClassName('color');
const nameDisplay = document.getElementById('nameOfRegion');
const groupColors = ['#ffdedb', '#fccec8', '#fabeb6', '#f69f9f', '#f38f8d', '#f07f7b', '#ed6f69', '#dc143c'];

window.onload = async function () {
	try {
	let year = "2022";
		var response = await fetch('/api/colors' + year);
		var groups = await response.json();
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
async function readSelectedValue() {
	var selectElement = document.getElementById("year-select");
	var selectedValue = selectElement.value;
    var response = await fetch('/api/colors' + selectedValue);
    var groups = await response.json();
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

// Обработчик события наведения на регион
function handleMouseOver(event) {
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
		region.style.transform = 'scale(1.02)';
	}

	let dataName = event.target.getAttribute('data-name');
	nameDisplay.textContent = dataName;
}

// Обработчик события ухода курсора с региона
function handleMouseOut(event) {
	const region = event.target;
	region.style.transform = 'scale(1)';
	nameDisplay.textContent = 'Российская Федерация';
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