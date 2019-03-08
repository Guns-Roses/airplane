$(document).ready(function () {
    var orderFormId = location.search.split("orderFormId=")[1];
    var jsonObj = new Object();
    jsonObj.orderFormId = orderFormId;
    $.get("/ticket/all",function (data) {
        showData(data);
    })
});


function showData(data){
    /*"ticketId": 1,
        "flightId": 1,
        "orderFormId": 1,
        "price": 1000,
        "discount": 1,
        "passengerName": "liu"*/
    for(var i = 0; i < data.length; i++){
        var tr = document.createElement("tr");
        var flightIdTd = document.createElement("td");
        flightIdTd.append(data[i].flightId);
        var priceTd = document.createElement("td");
        priceTd.append(data[i].price);
        var passengerName = document.createElement("td");
        passengerName.append(data[i].passengerName);
        var discountTd = document.createElement('td');
        if(data[i].discount == 0.8)
            discountTd.append("是");
        else discountTd.append("否");
        var operateTd = document.createElement("td");
        var addA = document.createElement('a');
        addA.innerText = "修改";
        addA.href = "alterTicket.html?ticketId=" + data[i].ticketId;
        var delA = document.createElement('a');
        delA.innerText = "删除";
        delA.id = "del" + data[i].ticketId;
        delA.href = "#";
        operateTd.append(addA);
        operateTd.append(" ");
        operateTd.append(delA);
        tr.appendChild(flightIdTd);
        tr.appendChild(passengerName);
        tr.appendChild(priceTd);
        tr.appendChild(discountTd);
        tr.appendChild(operateTd);
        $("#tbody-ticket").append(tr);
        $("#del" + data[i].ticketId).attr("onclick","deleteTicket(" + data[i].ticketId + ")");
    }
}



function deleteTicket(ticketId) {
    var jsonObj = new Object();
    jsonObj.ticketId = ticketId;

    $.ajax({
        url:"ticket/deleteById",
        contentType:"application/json;charset=utf-8",
        type:"POST",
        data:JSON.stringify(jsonObj),
        success:function () {
            var con = confirm("是否删除?");
            if(con == true){
                alert("删除成功");
                window.location.reload();
            }
        }
    })
}