const btn = document.getElementById('button');

document.getElementById('form')
  .addEventListener('submit', function (event) {
    event.preventDefault();
    let name = document.getElementById('name');// es el componente nombre pero no es el valor del campo nombre
    let numtel = document.getElementById('phone');// es el componente nombre pero no es el valor del campo nombre
    let mail = document.getElementById('email');
    let contra1 = document.getElementById('contraseña1');
    let contra2 = document.getElementById('contraseña2');
    console.log(contra1.value);
    console.log(contra2.value);
    // comienzan validaciones
    if (/[\d]/.test(name.value) === true) {
      alert('Porfavor coloque un nombre sin numeros ');
      //enviamos la variable que hace referencia al componente
      cleanAndFocus(name);
      // document.getElementById("name").value = "";
      //document.getElementById("name").focus();
    }
    else if (/[`!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/.test(name.value) === true) {
      alert('Porfavor coloque un nombre sin caracteres especiales ');
      cleanAndFocus(name);
    } else if (numtel.value.length != 10) {
      alert('Porfavor coloque un número de telefono valido');
      cleanAndFocus(numtel);
    } else if (contra1.value != contra2.value || contra1.value === "" || contra2.value === "") {
      alert('Verifique que las contaseñas sean iguales');
      contra1.value = "";
      contra2.value = "";
    }
    else {
      btn.value = 'Registrando...';

      let records = new Array();
      records = JSON.parse(localStorage.getItem("Usuarios"))?JSON.parse(localStorage.getItem("Usuarios")) : [];
      console.log("lo que trae el records: ",records);
      if (records.some((v)=>{return v.Email == email.value})) {
        alert("email ya registrado");
      } else {
        records.push({
          "Nombre": name.value, "Telefono": phone.value,
          "Email": email.value, "Contraseña": contraseña1.value
        })
        localStorage.setItem("Usuarios", JSON.stringify(records));
        alert("Usuario registrado");
        btn.value = 'Registrarse';
        window.location.href="logIn.html";
      }


    }
  });


// //  obtención de localStorage
// let localStorageGet = localStorage.getItem("Usarios");
// console.log(localStorageGet);
//    alert('Usuario registrado!');
//    document.getElementById('form').reset();


function cleanAndFocus(component) {
  component.value = "";
  component.focus();
}