$(document).ready(function () {
    var jsonObj = new Object();
    jsonObj.username = $.cookie("username");//cookie
    $.ajax({
        url:"/form/all",
        data:JSON.stringify(jsonObj),
        type:"POST",
        contentType:"application/json;charset=utf-8",
        success:function (data) {
            showData(data);
        }
    })

});

function showData(data) {
    /*"orderFormId": 1,
        "userId": 1,
        "ticketNumber": 1,
        "totalPrice": 1000,
        "orderTime": "2018-06-03T07:47:54.000+0000"*/
    for(var i = 0;i < data.length; i++){
        var tr = document.createElement('tr');
        var orderTTd = document.createElement('td');
        orderTTd.append(data[i].orderTime);
        var ticketNTd = document.createElement('td');
        ticketNTd.append(data[i].ticketNumber);
        var totalPTd = document.createElement('td');
        totalPTd.append(data[i].totalPrice);
        var operateTd = document.createElement("td");
        var orderOpe = document.createElement('a');
        orderOpe.innerText = "查看";
        orderOpe.href = "showTicket.html?orderFormId=" + data[i].orderFormId;
        operateTd.append(orderOpe);
        tr.appendChild(orderTTd);
        tr.appendChild(ticketNTd);
        tr.appendChild(totalPTd);
        tr.appendChild(operateTd);
        $("#tbody-form").append(tr);
    }
}