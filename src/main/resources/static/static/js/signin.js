var signin = new Vue({
    el: "#login",
});

function login() {
    var username = $("#loginName").val();
    var password = $("#password").val();
    if (username && password){
        // layer.load(1);
        $.ajax({
            url: '/login/login',
            type: "POST",
            data:{
                username: username,
                pawassord: password,
            },
            success:function(data){
                layer.closeAll();
                var json = JSON.parse(data);
                if (json.signin_status === "成功"){
                    window.location.href = "/welcome.html";
                }
                else {
                    //提示用户名或密码不正确
                    $('.info_empty').hide();
                    $('.info_error').show();
                }
            }
        });
    }
    else {
        //提示用户名或密码不能为空
        $('.info_error').hide();
        $('.info_empty').show();
    }
}

function cancle() {
    $("#loginName").val("");
    $("#password").val("");
}