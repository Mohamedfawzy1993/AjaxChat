

setInterval(updateMsg, 500);

function updateMsg() {

    var msgIndex = document.getElementById("msgIndex").value;
    var msgTable = document.getElementById("msgTable");

    $.post("chat", {"ID": msgIndex}, function (data) {

        data = JSON.parse(data);
        console.log(data);
        // alert(data);
        data.forEach(param => {
            msgTable.innerHTML = msgTable.innerHTML + "<tr>" +
            "<td>" + param.sender + "</td>" +
            "<td>" + param.msg + "</td>" +
            "</tr>";
        document.getElementById("msgIndex").value = param.ids;
        console.log(msgIndex.value);
        window.scrollTo(0,document.body.scrollHeight);
    });
    });

}


function sendMsg()
{
    var msg = document.getElementById("msg").value;
    if(msg)
        $.get("chat" , {"msg":msg} , function () {});
    document.getElementById("msg").value = "";

}
