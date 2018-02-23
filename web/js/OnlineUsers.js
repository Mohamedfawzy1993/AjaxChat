

setInterval(updateOnline, 3000);

function updateOnline() {
    var table = document.getElementById("tableBody");
    $.post("online", function (data) {
        while (table.hasChildNodes()) {
                table.removeChild(table.lastChild);
        }
        console.log(data);
        data = JSON.parse(data);
        data.forEach(param => {
           table.innerHTML = table.innerHTML + "<tr><td>"+param+"</td></tr>" ;
        });
    });
}
