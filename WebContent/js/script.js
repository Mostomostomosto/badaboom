window.onload = function() {
    $('#compra-form').hide();
    $('.items-pedido').hide();

    $('#user').after('<label id="invalid-user" class="fail">El campo usuario no puede estar vacio</label>');
    $('#invalid-user').hide();
    $('#pwd').after('<label id="invalid-password" class="fail">Debe introducir una contraseña de al menos 6 caracteres</label>');
    $('#invalid-password').hide();
    $('#dni').after('<label id="invalid-dni" class="fail">El dni introducido no es correcto</label>');
    $('#invalid-dni').hide();
    $('#email').after('<label id="invalid-email" class="fail">Por favor, introduzca un email válido</label>');
    $('#invalid-email').hide();
    $('#edad').after('<label id="invalid-edad" class="fail">Por favor, introduzca una edad entre 18 y 100 años</label>');
    $('#invalid-edad').hide();
    $('#nombre').after('<label id="invalid-nombre" class="fail">Por favor, introduzca un nombre</label>');
    $('#invalid-nombre').hide();
    $('#apellido1').after('<label id="invalid-apellido1" class="fail">Por favor, introduzca un nombre</label>');
    $('#invalid-apellido1').hide();
	$('#apellido2').after('<label id="invalid-apellido2" class="fail">Por favor, introduzca un nombre</label>');
    $('#invalid-apellido2').hide();
    $('#direccion').after('<label id="invalid-direccion" class="fail">Por favor, introduzca una direccion</label>');
    $('#invalid-direccion').hide();


    $('#compra-boton').on('click', function() {
        $('#compra-form').fadeToggle();
    });
    $('.header').on('click', function() {
        $(this).parent().find('.items-pedido').fadeToggle();
    });



    $('#insert-form').submit(function() {
        var success = false;
        //nombre
        var nombre = $('#nombre').val();
         if(nombre.length == 0){
        	$('#invalid-nombre').show();
        }else{
        	$('#invalid-nombre').hide();
        	success= true;
        }
        //apellido1
        var apellido1 = $('#apellido1').val();
         if(apellido1.length == 0){
        	$('#invalid-apellido1').show();
        	success = false;
        }else{
        	$('#invalid-apellido1').hide();
        }
        //apellido2
        var apellido2 = $('#apellido2').val();
         if(apellido2.length == 0){
        	$('#invalid-apellido2').show();
        	success = false;
        }else{
        	$('#invalid-apellido2').hide();
        }
        //direccion
        var direccion = $('#direccion').val();
         if(direccion.length == 0){
        	$('#invalid-direccion').show();
        	success = false;
        }else{
        	$('#invalid-direccion').hide();
        }
        
        //dni
        var numero, letter, letra;
        var expresion_regular_dni = /^[XYZ]?\d{5,8}[A-Z]$/;
        var dni = $('#dni').val();

        if (expresion_regular_dni.test(dni) === true) {
            numero = dni.substr(0, dni.length - 1);
            numero = numero.replace('X', 0);
            numero = numero.replace('Y', 1);
            numero = numero.replace('Z', 2);
            letter = dni.substr(dni.length - 1, 1);
            numero = numero % 23;
            letra = 'TRWAGMYFPDXBNJZSQVHLCKET';
            letra = letra.substring(numero, numero + 1);
            if (letra != letter) {
                $('#invalid-dni').show();
                success = false;

            } else {
                $('#invalid-dni').hide();
                
            }
        } else {
            $('#invalid-dni').show();
            success = false;

        }

        //email
        var email = $('#email').val();
        if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)) {
            $('#invalid-email').hide();
        } else {
            $('#invalid-email').show();
            success = false;
        }

        //user
        var user = $('#user').val();
        if(user.length == 0){
        	$('#invalid-user').show();
        }else{
        	$('#invalid-user').hide();
        }

        //password
        var password = $('#pwd').val();
        if(password.length < 6){
        	$('#invalid-password').show();
        	success=false;
        }else{
        	$('#invalid-password').hide();
        	
        }

        return success;
    });

};