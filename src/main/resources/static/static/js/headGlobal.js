$(function () {
    var signInName;
    $.ajax({
        url: '/admin/isSignin', type: "POST",
        success: function (data) {
            var json = JSON.parse(data);
            if (json.signinStatus === "success") {
                signInName = json.signInName;
                $("#signIn-name").append($('<span>'+signInName+'</span>'))
            } else {
                if (!window.location.href.replace(/https?:\/\/[a-zA-Z0-9.]*(:\d+)?/g, "").startsWith("/signin")) {
                    window.location.href = "/login.html";
                }
            }
        }
    });

    $("#logout").click(function () {
        $.ajax({
            url: '/user/logout', type: "POST",
            success: function (data) {
                var json = JSON.parse(data);
                if (json.logoutStatus === "success") {
                    window.location.href = "/signin.html";
                }
            }
        });
    });
});