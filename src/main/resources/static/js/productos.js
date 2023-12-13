/*let productos;
// Aquí se debe cambiar el URL del servicio en el BackEnd
const URL_MAIN ='/api/productos/';
function addItems(div_Productos) {
    fetch(URL_MAIN, {
        method: 'get'
    }).then(function(response) {
        response.json().then(function (json) {
            console.log(json);
            console.log(json.length);
            productos=json;
            Array.from(json).forEach((p, index) => {
                div_Productos.innerHTML += `
                <div class="card" style="width: 18rem;">
                <img src=${p.img} class="card-img-top" alt="image">
                <div class="card-body">
                    <h5 class="card-title">${p.Nombre}</h5>
                    <p class="card-text">${p.Descripción}</p>
                    <p class="card-text1">${p.Precio}</p>
                </div>
                    <a href="#" class="btn btn-primary configBtn">Agregar</a>
            </div>
            <br/>
                `;
            }); // foreach
        });//then
    }).catch(function(err) {
        console.log(err);
    });
    console.log(document.getElementById("list-items"));
   
}// addItems

window.addEventListener("load", function (){
    let div = document.getElementById("list-items");
    addItems(div);
   
});
*/
