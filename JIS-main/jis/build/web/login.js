let loginForm = document.getElementById("login-form");
let signUpForm = document.getElementById("signup-form");
let createAcBtn = document.getElementById("create-ac-btn");
let gotoLoginBtn = document.getElementById("goto-login-btn");
let signupErr = document.getElementById("signup-err");
let loginErr = document.getElementById("login-err");
let email = document.getElementById("signup-email");
let suname = document.getElementById("signup-uname");
let spass = document.getElementById("signup-pass");
let scpass = document.getElementById("signup-cpass");
let stype = document.getElementById("signup-type");


function reqFunc(e, r) {
    let elem = document.getElementById(e);
    let reqtext = document.getElementById(r);
    if (elem.value === "") {
        elem.style.borderColor = "red";
        reqtext.classList.remove("d-none");
    } else {
        elem.style.borderColor = "#034C03";
        reqtext.classList.add("d-none");
    }
}

signUpForm.classList.add("d-none");
createAcBtn.onclick = function () {
    loginForm.classList.add("d-none");
    signUpForm.classList.remove("d-none");
};

gotoLoginBtn.onclick = function () {
    loginForm.classList.remove("d-none");
    signUpForm.classList.add("d-none");
};

let evalEmailUname = async (em, un, pw, st) => {
    let res;
    let b = `/jis/Signup?email=${em}&uname=${un}&pass=${pw}&type=${st}`;
    await fetch(b, {
        method: 'POST'
    })
            .then(response => response.text())
            .then(data => res = data);
    if (res == 0) {
        alert("Your login request has been added.\nYou will get notified once your request gets accepted.");
        window.location.replace("/jis/login.html");
    } else {
        signupErr.textContent = res;
    }
};

let evalLogin = async (u, p) => {
    let res;
    let b = `/jis/Login?uname=${u}&pass=${p}`;
    await fetch(b, {
        method: 'POST'
    })
            .then(response => response.text())
            .then(data => res = data);
    if (res == 0) {
        sessionStorage.setItem("uname", u);
        window.location.replace("./home.html");
    } else {
        loginErr.textContent = res;
    }
};

function signup() {
    if (email.value === "") {
        reqFunc("signup-email", "email-req");
    } else {
        if (suname.value === "") {
            reqFunc("signup-uname", "suname-req");
        } else if (spass.value === "") {
            reqFunc("signup-pass", "spass-req");
        } else if (scpass.value === "") {
            reqFunc("signup-cpass", "scpass-req");
        } else if (spass.value !== scpass.value) {
            signupErr.textContent = "Passwords doesn't match";
        } else {
            signupErr.textContent = "";
            evalEmailUname(email.value, suname.value, spass.value, stype.value);
        }
    }
}

function login() {
    let luname = document.getElementById("login-username");
    let lpass = document.getElementById("login-pass");

    if (luname.value == "") {
        reqFunc("login-username", "uname-req");
    } else if (lpass.value == "") {
        reqFunc("login-pass", "pass-req");
    } else {
        evalLogin(luname.value, lpass.value);
    }
}
