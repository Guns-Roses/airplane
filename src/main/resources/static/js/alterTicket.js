$(document).ready(function () {
    var ticketId = location.search.split("ticketId=")[1];
    var jsonObj = new Object();
    jsonObj.ticketId = ticketId;

    $.ajax({
        url:"/ticket/ticketId",
        contentType:"application/json;charset=utf-8",
        type:"POST",
        data:JSON.stringify(jsonObj),
        success:function (data) {
            $("#flightId").val(data.flightId);
            $("#passengerName").val(data.passengerName);
            $("#price").val(data.price);
        }
    });

    $("#submitAltTicket").click(function () {
        jsonObj.flightId = $("#flightId").val();
        jsonObj.passengerName = $("#passengerName").val();
        jsonObj.price = $("#price").val();

        $.ajax({
            url:"/ticket/altTicket",
            type:"POST",
            contentType:"application/json;charset=utf8",
            data:JSON.stringify(jsonObj),
            success:function () {
                alert("修改成功");
            }
        })
    })
})