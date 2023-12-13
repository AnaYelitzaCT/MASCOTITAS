var navbar = document.getElementById("parteNavbar");

let user=new Array();
user=JSON.parse(localStorage.getItem("Usuarios"))?JSON.parse(localStorage.getItem("Usuarios")):[]
console.log(user);  
if(user.length !=0)
  {
    for(let i=0;i<user.length;i++)
    {

      navbar.innerHTML = `        
      <header class="header">
            <nav class="navbar navbar-expand-lg fixed-top">
              <div class="container-fluid" >
                <a class=" aElementsMascotitas" ><img class="logo" src="./src/fon_do.png " alt="" > Mascotitas</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03" >
                <span class="navbar-toggler-icon"></span>
              </button>
                <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                  <ul class="navbar-nav me-auto mb-2 mb-lg-0 ulElements">
                    <li class="nav-item ">
                      <a class="nav-link" aria-current="page" href="./index.html">Inicio</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="./QuienesSomos.html">¿Quiénes somos?</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="./servicios.html">Servicios</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="./productos.html">Tienda</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="./contacto.html">Contacto</a>
                    </li>
                    <li class="nav-item">
                    <a  href="./logIn.html" class="iconoUsuario"><iconify-icon icon="bxs:user" style="color: white;" width="30px"></iconify-icon></a>
                    <a  href="./logIn.html" class="iconoUsuario">`+user[i].Nombre+`</a>
                    </li>
                    <li class="nav-item">
                    <a  href="./productos.html" class="iconoCarrito"><iconify-icon icon="zondicons:shopping-cart" style="color: white;" width="30px"></iconify-icon></a>
                    </li>
                    </div>
                    </ul>
      
                  <div >
                 
                
      
              </div>
                  
                  
                </div>
              </div>
            </nav>
          </header>`;
 
    }
}else{
  navbar.innerHTML = `        
      <header class="header">
            <nav class="navbar navbar-expand-lg fixed-top">
              <div class="container-fluid" >
                <a class=" aElementsMascotitas" ><img class="logo" src="./src/fon_do.png " alt="" > Mascotitas</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03" >
                <span class="navbar-toggler-icon"></span>
              </button>
                <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                  <ul class="navbar-nav me-auto mb-2 mb-lg-0 ulElements">
                    <li class="nav-item ">
                      <a class="nav-link" aria-current="page" href="./index.html">Inicio</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="./QuienesSomos.html">¿Quiénes somos?</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="./servicios.html">Servicios</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="./productos.html">Tienda</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="./contacto.html">Contacto</a>
                    </li>
                    <li class="nav-item">
                    <a  href="./logIn.html" class="iconoUsuario"><iconify-icon icon="bxs:user" style="color: white;" width="30px"></iconify-icon></a>
                    
                    </li>
                    <li class="nav-item">
                    <a  href="./productos.html" class="iconoCarrito"><iconify-icon icon="zondicons:shopping-cart" style="color: white;" width="30px"></iconify-icon></a>
                    </li>
                    </div>
                    </ul>
      
                  <div >
                 
                
      
              </div>
                  
                  
                </div>
              </div>
            </nav>
          </header>`;
  
}