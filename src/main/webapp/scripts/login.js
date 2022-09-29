$('#btn-go-to-sign-up').click(function () {
        $(location).attr('href', "http://localhost:8080/RegistrationAuthentificationServlets/registration.html");
    }
)


$('#btn-login').click(function () {
        $.ajax({
            url: 'login',
            method: "POST",
            data: {"login": $('#email').val(), "password": $('#password').val()},
            success: [function () {
                $(location).attr('href', "http://localhost:8080/RegistrationAuthentificationServlets/index.html");
            }],
            error: [function () {
                alert("Неверный логин или пароль!!!")
            }]
        })
    }
)