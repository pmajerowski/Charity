const pass_check = document.getElementById("pass-check");
const btn = document.getElementById("register_btn");

const error = document.getElementById("error");
const form = document.getElementById("form");

const pass1 = document.querySelector("#pass");
const pass2 = document.querySelector("#pass2");

const pattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}$/;

const inputs = form.querySelectorAll('div input')

    inputs.forEach(input => input.onfocus = function(){
    error.style.display = "none"});


pass1.onfocus = function () {
    document.getElementById("message").style.display = "block";
}

pass1.onblur = function () {
    document.getElementById("message").style.display = "none";
    pass1.style.backgroundColor = "rgb(255,255,255)";
}

pass1.onkeyup = function() {
    pass1.style.backgroundColor = "rgba(245,137,137,0.75)";

    if(pattern.test(pass1.value)) {
        pass1.style.backgroundColor = "rgba(240,250,161,0.75)";
        btn.disabled = false;
    } else {
        btn.disabled = true;
    }

}



btn.addEventListener('click', function (event) {
    pass_check.setAttribute("hidden", "hidden");

    if (pass1.value !== pass2.value) {
        event.preventDefault();
        pass_check.removeAttribute("hidden");
        return;
    }

    if (pass1.value == pass2.value) {
        pass_check.setAttribute("hidden", "hidden");
    }

})