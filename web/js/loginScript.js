

function sendLog() {
    var name = document.getElementById("username").value;
    var pass = document.getElementById("pass").value;
    var jsonData = {"username": name, "pass": pass};
    $.post("Login", jsonData , function (data) {

        if(data === "true")
        {
            window.location.replace('chat.jsp');
        }
        else
        {
            document.getElementById("resultText").innerText = data;
            document.getElementById("resultText").style.color="red";
        }

    });
}
