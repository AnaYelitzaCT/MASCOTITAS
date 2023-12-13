var localStorageGet = localStorage.getItem("Usuarios");
console.log(localStorageGet)

var bienvenida = document.getElementById("bienvenidaUsuario");
if (localStorageGet != null) {
  let user_records = new Array();
  user_records = JSON.parse(localStorage.getItem("Usuarios")) ? JSON.parse(localStorage.getItem("Usuarios")) : []
  if (user_records) {
    for (let i = 0; i < user_records.length; i++) {

      bienvenida.innerHTML = ` <h1>BIENVENIDO A MASCOTITAS:  ` + user_records[i].Nombre + ` . <span>&#160;</span> </h1>`;

    }
  }

} else {
  bienvenida.innerHTML = ` <h1>BIENVENIDO A MASCOTITAS. <span>&#160;</span> </h1>`;
}