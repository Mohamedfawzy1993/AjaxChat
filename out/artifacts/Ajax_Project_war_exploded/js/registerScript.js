
function register() {

    var name = document.getElementById("username").value;
    var pass = document.getElementById("pass").value;
    var jsonData = {"username": name, "pass": pass};
    $.post("Register", jsonData , function (data) {

        document.getElementById("resultText").innerText = data;
        // document.getElementById("resultText").style.color="red";

    });
}
