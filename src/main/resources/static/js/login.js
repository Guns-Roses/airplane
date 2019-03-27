$(document).ready(function () {
    $("#login-btn").click(function () {
        var name = $("#name").val();
        var pwd = $("#pwd").val();
        var jsonObj = new Object();
        jsonObj.username = name;
        jsonObj.password = pwd;
        if (name == "" || pwd == "") {
            alert("账号密码不能为空")
        } else {
            $.ajax({
                url: "/user",
                data: JSON.stringify(jsonObj),
                type: "POST",
                // async:false,
                // dataType:"json",
                contentType: "application/json; charset=utf-8",
                success: function (data) {

                    alert("登录成功");
                    $.cookie("username", name);
                    if (data.isManager == 1)
                        window.location = "managerFlight.html";
                    else if (data.isVip == 1) {
                        window.location = "showFlight.html";
                        alert("尊敬的会员，您可以享受八折优惠");
                    } else {
                        window.location = "showFlight.html";
                    }
                },
                error:function(){
                    alert("登录失败")
                }

            });
        }
    })

});
