//注册功能
$("#login-btn3").click(function () {
    var name = $("#name").val();
    var pwd = $("#pwd").val();
    var jsonObj = new Object();
    jsonObj.username = name;
    jsonObj.password = pwd;
    $.ajax({
        url: "/registered",
        data: JSON.stringify(jsonObj),
        type: "POST",
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            alert("注册成功");
            if (data.name != "" && data.pwd != "") {
                window.location = "index.html";
            }
        },
        error: function () {
            alert("注册失败")
            window.location = "registered.html"
        }

    });
});
