document.addEventListener('DOMContentLoaded', function() {
    // Elementen ophalen
    var gebruikerSelect = document.getElementById('gebruikerselect');
    var takenlijst = document.getElementById('takenlijst');

    // Aanroepen van de TaakVerdeelResource om gebruikers op te halen
    fetch('https://ipass-pieter.azurewebsites.net/restservices/taakverdeling')
        .then(function(response) {
            if (!response.ok) {
                throw new Error('Er is een fout opgetreden bij het ophalen van de gebruikers.');
            }
            return response.json();
        })
        .then(function(taakVerdeling) {
            // Unieke gebruikers filteren
            var gebruikers = [...new Map(taakVerdeling.map(function(verdeling) {
                return [verdeling.persoon.id, verdeling.persoon];
            })).values()];

            // Gebruikers weergeven in de gebruikersselectie
            gebruikers.forEach(function(gebruiker) {
                var option = document.createElement('option');
                option.value = gebruiker.id;
                option.textContent = gebruiker.naam;
                gebruikerSelect.appendChild(option);
            });

            // Controleren op gebruikers zonder taken
            var gebruikersMetTaken = taakVerdeling.map(function(verdeling) {
                return verdeling.persoon.id;
            });
            gebruikers.forEach(function(gebruiker) {
                if (!gebruikersMetTaken.includes(gebruiker.id)) {
                    var option = document.createElement('option');
                    option.value = gebruiker.id;
                    option.textContent = gebruiker.naam + ' (Hoeft niks te doen)';
                    gebruikerSelect.appendChild(option);
                }
            });
        })
        .catch(function(error) {
            console.error(error);
        });

    gebruikerSelect.addEventListener('change', function() {
        var gebruikerId = gebruikerSelect.value;

        fetch('https://ipass-pieter.azurewebsites.net/restservices/taakverdeling')
            .then(function(response) {
                if (!response.ok) {
                    throw new Error('Er is een fout opgetreden bij het ophalen van de taken.');
                }
                return response.json();
            })
            .then(function(taakVerdeling) {
                // Filteren van de taken voor de geselecteerde gebruiker
                var taken = taakVerdeling.filter(function(verdeling) {
                    return verdeling.persoon.id === gebruikerId;
                });

                // Takenlijst leegmaken
                takenlijst.innerHTML = '';

                if (taken.length > 0) {
                    taken.forEach(function(verdeling) {
                        var taak = verdeling.taak;
                        var taakItem = document.createElement('li');
                        taakItem.innerHTML = '<strong>Naam:</strong> ' + taak.naam + '<br>' +
                            '<strong>Duur:</strong> ' + taak.duur + '<br>' +
                            '<strong>Beschrijving:</strong> ' + taak.omschrijving;
                        takenlijst.appendChild(taakItem);
                    });
                } else {
                    var geenTakenItem = document.createElement('li');
                    geenTakenItem.textContent = 'Gebruiker heeft geen taken.';
                    takenlijst.appendChild(geenTakenItem);
                }
            })
            .catch(function(error) {
                console.error(error);
            });
    });
});
