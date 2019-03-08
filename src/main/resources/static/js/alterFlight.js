$(document).ready(function () {
    var flightId = location.search.split("flightId=")[1];
    var jsonObj = new Object();
    jsonObj.flightId = flightId;

    $.ajax({
        url:"flight/flightId",
        contentType:"application/json;charset=utf-8",
        type:"POST",
        data:JSON.stringify(jsonObj),
        success:function (data) {
/*
            "flightId": 1,
                "startTime": "2018-06-08T13:00:50.000+0000",
                "startCity": "shanghai",
                "endCity": "beijing",
                "peopleNumber": 100,
                "leftTicket": 50,
                "ticketPrice": 1000*/
            $("#startTime").val(data.startTime);
            $("#startCity").val(data.startCity);
            $("#endCity").val(data.endCity);
            $("#peopleNum").val(data.peopleNumber);
            $("#leftTicket").val(data.leftTicket);
            $("#price").val(data.ticketPrice);
        }
    });

    $("#submitAltFlight").click(function () {
        jsonObj.startTime = $("#startTime").val();
        jsonObj.startCity = $("#startCity").val();
        jsonObj.endCity = $("#endCity").val();
        jsonObj.peopleNumber = $("#peopleNum").val();
        jsonObj.leftTicket = $("#leftTicket").val();
        jsonObj.ticketPrice = $("#price").val();

        $.ajax({
            url:"/flight/altFlight",
            contentType:"application/json;charset=utf-8",
            type:"POST",
            data:JSON.stringify(jsonObj),
            success:function () {
                alert("修改成功");
            }
        })
    })
})