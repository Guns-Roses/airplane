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

})
/*
$(document).ready(function () {
    $("#login-btn").click(function(){
        var name=$("#name").val();
        var pwd=$("#pwd").val();
            if(userName!=""&&userPass!=""){
                $.ajax({
                    url:url+"/login",
                    data:{
                        username:userName,
                        password:userPass
                    },
                    async:true,
                    type:"POST",
                    success:function(result){
                        if(result.errCode==0){
                            localStorage.tokenID=result.tokenID;
                            localStorage.username=result.username;
                            if(data.isManager == 1)
                                window.location = "managerFlight.html";
                            else if(data.isVip == 1) {
                                window.location = "showFlight.html";
                                alert("尊敬的会员，您可以享受八折优惠");
                            }else {
                                window.location = "showFlight.html";
                            }
                        }else{
                            $("#tip").html("用户名或密码错误！")
                        }
                    }});
            }else{
                $("#tip").html("用户名和密码必须填写")
            }
    })
})*/
