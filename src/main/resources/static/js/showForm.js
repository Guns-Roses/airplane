$(document).ready(function () {
    var jsonObj = new Object();
    jsonObj.username = $.cookie("username");//cookie
    $.ajax({
        url: "/form/all",
        data: JSON.stringify(jsonObj),
        type: "POST",
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            showData(data);
        }
    })

});

Date.prototype.format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, // 月份
        "d+": this.getDate(), // 日
        "h+": this.getHours(), // 小时
        "m+": this.getMinutes(), // 分
        "s+": this.getSeconds(), // 秒
        "q+": Math.floor((this.getMonth() + 3) / 3), // 季度
        "S": this.getMilliseconds() // 毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};

function showData(data) {
    /*"orderFormId": 1,
        "userId": 1,
        "ticketNumber": 1,
        "totalPrice": 1000,
        "orderTime": "2018-06-03T07:47:54.000+0000"*/
    for (var i = 0; i < data.length; i++) {
        var tr = document.createElement('tr');
        var orderTTd = document.createElement('td');
        orderTTd.append(new Date(data[i].orderTime).format("yyyy-MM-dd hh:mm:ss"));
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