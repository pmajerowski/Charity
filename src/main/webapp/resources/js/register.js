const pass_check = document.getElementById("pass-check");
const btn = document.getElementById("register_btn");

const pass1 = document.querySelector("#pass");
const pass2 = document.querySelector("#pass2");

btn.addEventListener('click', function (event){
    if (pass1.value !== pass2.value) {
        event.preventDefault();
        pass_check.removeAttribute("hidden");
        return;
    }

    if (pass1.value == pass2.value) {
        pass_check.setAttribute("hidden", "hidden");
    }

})