
// La map Leaflet
let mymap = L.map('carte').setView([48.202047, -2.932644], 8);
// Ajout d'un layer sur la map pour afficher des tuiles avec les routes
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    tileSize: 512,
    zoomOffset: -1,
    maxZoom: 18
}).addTo(mymap);
/**
 * Ajoute un marqueur sur la carte.
 *
 * @param {number} lat Latitude du marqueur.
 * @param {number} lon Longitude du marqueur.
 * @param {string} festivalName Le nom du festival à afficher dans la popup.
 * @param {string} festivalVille La ville du festival à afficher dans la popup.
 */
function addMarkerOnMap(lat, lon, nom, ville) {
    // On ajoute une marque aux coordonnées fournies en paramètre
    marker = L.marker([lat, lon]).addTo(mymap);
    // Un popup qui s'affichera au-dessus du marqueur
    let popup = L.popup().setContent('<h2>'+nom+'</h2>'+ville);
    marker.bindPopup(popup);
    marker.addEventListener('click', (event) => {
        popup.openOn(mymap);
    });
}

const buttonAjout = document.getElementById("ajout");
function allerVersAjout(){
    window.location.href="/formulaire_ajout";
}
buttonAjout.addEventListener('click', allerVersAjout);

const buttonsEditer = document.querySelectorAll(".edit");
for (let i=0; i <buttonsEditer.length; i++){
    let buttonEditer = buttonsEditer[i];
    buttonEditer.addEventListener('click', event => allerVersEditer(event));
}
function allerVersEditer(event){
    console.log(event)
    let idFest = event.target.attributes['idfestival'].nodeValue;
    window.location.href=`/formulaire_edit/${idFest}`;
}