const pathElements = document.getElementsByClassName('region');
const groupColors = ["#CD5C5C","#F08080","#FA8072","#E9967A","#FFA07A","#DC143C"];

window.onload = async function () {
    try {
        const response = await fetch('/api/colors');
                const groups = await response.json();
                for (let element of pathElements) {
                    let id = element.getAttribute('id');
                    for (let group in groups) {
                        if (id.includes(group)) {
                            element.style.fill = groupColors[groups[group] - 1] ?? null;
                            break;
                        }
                    }
                }

    } catch (error) {
        console.error(error)
    }
}


