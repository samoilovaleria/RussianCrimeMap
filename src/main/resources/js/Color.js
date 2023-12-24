const pathElements = document.getElementsByClassName('region');
const colorElements = document.getElementsByClassName('color');
const nameDisplay = document.getElementById('nameOfRegion');
const groupColors = ['#ffdedb', '#fccec8', '#fabeb6', '#f69f9f', '#f38f8d', '#f07f7b', '#ed6f69', '#dc143c'];

window.onload = async function () {
  try {
    const response = await fetch('/api/colors');
    const groups = await response.json();
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

// Обработчик события наведения на регион
function handleMouseOver(event) {
    const id = event.target.getAttribute('id');
    const region = event.target;

    if (id === 'Sevastopol' || id === 'Moskva' || id === 'City of St. Petersburg') {
      region.style.transform = 'scale(1.005)';
    } else {
      region.style.transform = 'scale(1.015)';
    }

    region.parentNode.appendChild(region);
    nameDisplay.textContent = id;
}

// Обработчик события ухода курсора с региона
function handleMouseOut(event) {
  const region = event.target;
  region.style.transform = 'scale(1)';
  nameDisplay.textContent = 'Российская Федерация';
}