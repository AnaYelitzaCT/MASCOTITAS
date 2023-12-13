let txtexampleInputNombre = document.getElementById("exampleInputNombre");
let txtexampleInputEmail1 = document.getElementById("exampleInputEmail1");
let txtexampleInputTel= document.getElementById("exampleInputTel");
let txtexampleInputMessage= document.getElementById("exampleInputMessage");

let btnAgregar = document.getElementById("btnAgregar");
let alertValidaciones = document.getElementById("alertValidaciones");



function validaEntradaTelefono (){
    if (txtexampleInputTel.value.length == 0) {
        return false;

    }
    if (isNaN(txtexampleInputTel.value)) {
        return false;
    }

    if (parseFloat(txtexampleInputTel.value <= 0)) {
        return false;
    }

    return true;
}

function validaEntradaNombre () {
    if(txtexampleInputNombre.value.lenght < 2){
        return false;
    }
    if((txtexampleInputNombre.value == null)){
        return false;
    }
    if(txtexampleInputNombre.value == " "){
        return false;
    }

    return true;
}

function validaEntradaCorreo () {
    if(txtexampleInputEmail1.value.lenght < 2){
        return false;
    }
    if((txtexampleInputEmail1.value == null)){
        return false;
    }
    if(txtexampleInputEmail1.value == " "){
        return false;
    }

    return true;
}


function validaEntradaMensaje () {
    if(txtexampleInputMessage.value.lenght < 2){
        return false;
    }
    if((txtexampleInputMessage.value == null)){
        return false;
    }
    if(txtexampleInputMessage.value == " "){
        return false;
    }

    return true;
}


btnAgregar.addEventListener("click", function (event) {
    event.preventDefault();
    alertValidaciones.innerHTML = "";
    alertValidaciones.style.display = "none";

    txtexampleInputNombre.style.border = "";
    txtexampleInputEmail1.style.border = "";
    txtexampleInputTel.style.border = "";
    txtexampleInputMessage.style.border = "";


    if(!validaEntradaNombre()){
        alertValidaciones.innerHTML = "El campo <strong>Nombre</strong> es requerido";
        alertValidaciones.style.display = "block";
        txtexampleInputNombre.style.border = "solid thin red";
        
    }
    if(!validaEntradaCorreo()){
        alertValidaciones.innerHTML += "El campo <strong>Dirección Email</strong> es requerido";
        alertValidaciones.style.display = "block";
        txtexampleInputEmail1.style.border = "solid thin red";
        
    }
    if (!validaEntradaTelefono()) {
        alertValidaciones.innerHTML += "El campo <strong>Teléfono</strong> es requerido </br>"
        alertValidaciones.style.display = "block";
        txtexampleInputTel.style.border = "solid thin red";
        
    }
    if(!validaEntradaMensaje){
        alertValidaciones.innerHTML += "El campo <strong>Mensaje</strong> es requerido";
        alertValidaciones.style.display = "block";
        txtexampleInputMessage.style.border = "solid thin red";
    
    }

});


/*

btnClear.addEventListener("click", function (event) {
    event.preventDefault();
    alertValidaciones.innerHTML = "";
    alertValidaciones.style.display = "none";

    txtexampleInputNombre.style.border = "";
    txtexampleInputEmail1.style.border = "";
    txtexampleInputTel.style.border = "";
    txtexampleInputMessage.style.border = "";
   
});*/




emailjs.init('lWoM7i5rmAA-HDtbS')
const btn = document.getElementById('button');

document.getElementById('form')
 .addEventListener('submit', function(event) {
   event.preventDefault();

   btn.value = 'Sending...';

   const serviceID = 'default_service';
   const templateID = 'template_n7cj7q6';

   emailjs.sendForm(serviceID, templateID, this)
    .then(() => {
      btn.value = 'Send Email';
      alert('Sent!');
    }, (err) => {
      btn.value = 'Send Email';
      alert(JSON.stringify(err));
    });
});