var jsonObj = new Object();

$(document).ready(function () {
    var url = location.search;
    var flightId = url.split("flightId=")[1];
    var i = 1;

    $("#addBtn").click(function () {
        i++;
        var div = document.createElement('div');
        div.className = "form-group";
        var label = document.createElement('label');
        label.innerText = "乘客姓名";
        var input = document.createElement('input');
        input.type = "text";
        input.className = "form-control";
        input.id = "passengerName" + i;
        div.append(label);
        div.append(input);
        $("#formOrder").append(div);
    });

/*    {
        "username":"admin",
        "flightId":"1",
        "ticketNumber":"2",
        "passengerNames":[{
        "passengerName":"liu"
    },{
        "passengerName":"zhao"
    }]
    }*/

    $("#submit").click(function () {
        jsonObj.username = $.cookie("username");
        jsonObj.flightId = flightId;
        jsonObj.ticketNumber = i;
        jsonObj.passengerNames = new Array();
        for(var j = 0; j < i; j++){
            jsonObj.passengerNames[j] = new Object();
            jsonObj.passengerNames[j].passengerName = $("#passengerName" + (j+1)).val();
        }
        $.ajax({
            url:"/form/price",
            contentType:"application/json;charset=utf-8",
            data:JSON.stringify(jsonObj),
            type:"POST",
            success:function (data) {
                var con = confirm("总价格为" + data.totalPrice + "是否支付？");
                if(con == true)
                    order();
            }
        })
    })
});

function order() {
    $.ajax({
        url:"/form/order",
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify(jsonObj),
        type:"POST",
        success:function (data) {
            alert("支付成功");
        }
    })
}