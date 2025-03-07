document.addEventListener("DOMContentLoaded", function () {
    let loginBtn = document.getElementById("loginBtn");

    loginBtn.addEventListener("click", function (event) {
        event.preventDefault(); // Evita el envío inmediato del formulario
        loginBtn.classList.add("bounce");

        setTimeout(() => {
            loginBtn.classList.remove("bounce");
            loginBtn.closest("form").submit(); // Envía el formulario después de la animación
        }, 300);
    });
});
