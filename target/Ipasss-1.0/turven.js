function fetchPersonen() {
    fetch("https://ipass-pieter.azurewebsites.net/restservices/personen")
        .then(function(response) {
            return response.json();
        })
        .then(function(personen) {
            let placeholder = document.querySelector("#data-output");
            let out = "";
            for (let persoon of personen) {
                out += `
                    <tr>
                        <td>${persoon.naam}</td>
                        <td>${persoon.rol}</td>
                        <td>${persoon.geslacht}</td>
                        <td id="aantal-${persoon.id}">${persoon.aantal}</td>
                        <td>${persoon.id}</td>
                        <td><button onclick="verhoogAantal('${persoon.id}')">+</button></td>
                    </tr>
                `;
            }

            placeholder.innerHTML = out;
        });
}

function verhoogAantal(id) {
    let aantalElement = document.querySelector(`#aantal-${id}`);
    let aantal = parseInt(aantalElement.textContent);
    aantal += 1;
    aantalElement.textContent = aantal;

    // Stuur de wijziging naar de backend
    fetch(`https://ipass-pieter.azurewebsites.net/restservices/personen/update-person`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id: id,
            aantal: aantal
        })
    })
        .then(function(response) {
            // Handel de respons van de backend af indien nodig
            console.log(response);
        })
        .catch(function(error) {
            // Handel eventuele fouten af
            console.error('Er is een fout opgetreden:', error);
        });
}

fetchPersonen();
