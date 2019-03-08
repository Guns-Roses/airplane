$(document).ready(function () {
    $("#login-btn").click(function () {
        var name = $("#name").val();
        var pwd = $("#pwd").val();
        var jsonObj = new Object();
        jsonObj.username = name;
        jsonObj.password = pwd;
        $.ajax({
            url:"/user",
            data:JSON.stringify(jsonObj),
            type:"POST",
            contentType:"application/json; charset=utf-8",
            success:function (data) {
                if(data == null)
                    alert("登录失败");
                else{
                    alert("登录成功");
                    $.cookie("username",name);
                    if(data.isManager == 1)
                        window.location = "managerFlight.html";
                    else if(data.isVip == 1) {
                        window.location = "showFlight.html";
                        alert("尊敬的会员，您可以享受八折优惠");
                    }else {
                        window.location = "showFlight.html";
                    }
                }
            }
        });
        //这里的post地址是本地的，记得后面修改
    })
})