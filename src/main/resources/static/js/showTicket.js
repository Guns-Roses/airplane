$(document).ready(function () {
    var orderFormId = location.search.split("orderFormId=")[1];
    var jsonObj = new Object();
    jsonObj.orderFormId = orderFormId;
    $.ajax({
        url:"/ticket/formId",
        contentType:"application/json;charset=utf-8",
        type:"POST",
        data:JSON.stringify(jsonObj),
        success:function (data) {
            showData(data);
        }
    })
});


function showData(data){
    /*"ticketId": 1,
        "flightId": 1,
        "orderFormId": 1,
        "price": 1000,
        "discount": 1,
        "passengerName": "liu",
        "passengeId": null*/
    for(var i = 0; i < data.length; i++){
        var tr = document.createElement("tr");
        var flightIdTd = document.createElement("td");
        flightIdTd.append(data[i].flightId);
        var priceTd = document.createElement("td");
        priceTd.append(data[i].price);
        var passengerName = document.createElement("td");
        passengerName.append(data[i].passengerName);
        var operateTd = document.createElement("td");
        tr.appendChild(flightIdTd);
        tr.appendChild(passengerName);
        tr.appendChild(priceTd);
        $("#tbody-ticket").append(tr);
    }
}
