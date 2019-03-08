$(document).ready(function () {
    $("#submitAddFlight").click(function () {
        var jsonObj = new Object();
        jsonObj.startCity = $("#startCity").val();
        jsonObj.endCity = $("#endCity").val();
        jsonObj.startTime = $("#startTime").val();
        jsonObj.peopleNumber = $("#peopleNum").val();
        jsonObj.leftTicket = $("#leftTicket").val();
        jsonObj.ticketPrice = $("#price").val();

        $.ajax({
            url:"/flight/add",
            contentType:"application/json;charset=utf-8",
            type:"POST",
            data:JSON.stringify(jsonObj),
            success:function () {
                alert("提交成功")
            }
        })
    })
})