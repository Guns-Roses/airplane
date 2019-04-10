$(document).ready(function () {
//注册功能
    $("#login-btn3").click(function () {
        var name = $("#name").val();
        var pwd = $("#pwd").val();
        var jsonObj = new Object();
        jsonObj.username = name;
        jsonObj.password = pwd;
        if (name == null || name == "") {
            alert("用户名不能为空！")
        } else if (pwd == "" || pwd == null) {
            alert("密码不能为空！")
        } else {
            $.ajax({
                url: "/registered",
                data: JSON.stringify(jsonObj),
                type: "POST",
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    alert("注册成功");
                    if (data.name != "" && data.pwd != "") {
                        window.location.href = "/";
                        window.event.returnValue = false;
                    }
                },
                error: function () {
                    alert("注册失败")
                    window.location = "registered.html"
                }

            });
        }
    });
});