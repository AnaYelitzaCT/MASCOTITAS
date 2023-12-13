emailjs.init('lWoM7i5rmAA-HDtbS');
let txtNombre = document.getElementById("Name");
let txtNumber = document.getElementById("Number");
let txtCorreo = document.getElementById("Correo");
let mensaje = document.getElementById("Mensaje");
const btn = document.getElementById('button');
let alertValidaciones = document.getElementById("alertValidaciones");



function validarCantidad() {
    if (txtNumber.value.length == 0) {
        alert("Teléfono inválido");
        return false;

    }
    if (isNaN(txtNumber.value)) {
        alert("Teléfono inválido");
        return false;
    }

    if (parseFloat(txtNumber.value <= 0)) {
        alert("Teléfono inválido");
        return false;
    }
    if (txtNumber.value.length < 10) {
        alert("Teléfono inválido");
        return false;

    }

    return true;
}



function validarCorreo(){
    let regEmail = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    if(! regEmail.test(txtCorreo.value)){
        alert("Correo inválido");
        return false;
    }
    return true;
}

function validarNombre(){
    let regNombre = /^[A-Za-z]+$/;
   
    if (!regNombre.test(txtNombre.value.trim())) {
        alert("Ingrese solo letras en el campo Nombre");
        return false;
    }

    return true;
}


function validarMensaje(){
    if(mensaje.value == null || mensaje.value == 0 || mensaje.value ==""){
        return false

    }
    return true;
}



document.getElementById('form')
.addEventListener('submit', function (event) {
    let isValid = true;
    event.preventDefault();
    alertValidaciones.innerHTML = "";
    alertValidaciones.style.display = "none";


    if (!validarNombre()) {  
        alertValidaciones.innerHTML = "El campo <strong>Nombre</strong> es invalido </br>"
        alertValidaciones.style.display = "block";
        txtNombre.style.border = "solid thin red";
        isValid = false;
    }
   

    if (!validarCantidad()) {
        alertValidaciones.innerHTML += "El campo <strong>Teléfono</strong> es requerido </br>"
        alertValidaciones.style.display = "block";
        txtNumber.style.border = "solid thin red";
        isValid = false;
    }

    if (!validarMensaje()) {
        alertValidaciones.innerHTML += "El campo <strong>Mensaje</strong> es requerido </br>"
        alertValidaciones.style.display = "block";
        mensaje.style.border = "solid thin red";
        isValid = false;
    }

    if (!validarCorreo()) {
        alertValidaciones.innerHTML += "El campo <strong>Correo</strong> es requerido </br>"
        alertValidaciones.style.display = "block";
        txtCorreo.style.border = "solid thin red";
        isValid = false;
    }

    if (isValid){
        btn.value = 'Enviando mensaje...';
     const serviceID = 'default_service';
    const templateID = 'template_n7cj7q6';
     emailjs.sendForm(serviceID, templateID, this)
      .then(() => {
        btn.value = 'Send Email';
        alert('Mensaje enviado gracias por contactarnos!');
        document.getElementById('form').reset();
     }, (err) => {
        btn.value = 'Send Email';

       alert(JSON.stringify(err));
      });
    }


});


















// btnAgregar click

// btnClear.addEventListener("click", function (event) {
//     event.preventDefault();
//     alertValidaciones.innerHTML = "";
//     alertValidaciones.style.display = "none";
//     txtNombre.style.border = "";
//     txtNumber.style.border = "";
//     txtCorreo.style.border = "";
   
    
//     txtNombre.value = "";
//     txtNumber.value = "";
//     txtCorreo.value = "";
//     mensaje.value = "";
   

// });










// emailjs.init('lWoM7i5rmAA-HDtbS');
// const btn = document.getElementById('button');

// document.getElementById('form')
//  .addEventListener('submit', function(event) {
//    event.preventDefault();
//   let name = document.getElementById('name');// es el componente nombre pero no es el valor del campo nombre
//   let numtel = document.getElementById('phone');// es el componente nombre pero no es el valor del campo nombre
//   // comienzan validaciones
//   if(/[\d]/.test(name.value)===true){
//     alert('Porfavor coloque un nombre sin numeros ');
//     //enviamos la variable que hace referencia al componente
//     cleanAndFocus(name);
//    // document.getElementById("name").value = "";
//     //document.getElementById("name").focus();
//   }
//   else if(/[`!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/.test(name.value)===true){
//     alert('Porfavor coloque un nombre sin caracteres especiales ');
//     cleanAndFocus(name);
//   }else if(numtel.value.length !=10){
//     alert('Porfavor coloque un número de telefono valido');
//     cleanAndFocus(numtel);
//   }
//   else{
//     button.value = 'Enviando mensaje...';
//     const serviceID = 'default_service';
//     const templateID = 'template_n7cj7q6';
//     emailjs.sendForm(serviceID, templateID, this)
//      .then(() => {
//        btn.value = 'Send Email';
//        alert('Mensaje enviado gracias por contactarnos!');
//        document.getElementById('form').reset();
//      }, (err) => {
//        btn.value = 'Send Email';

//        alert(JSON.stringify(err));
//      });
    
//   }
   
// });

// function cleanAndFocus(component){
//   component.value ="";
//   component.focus();
// }