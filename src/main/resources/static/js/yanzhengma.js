 /*极验验证  专属自定义触发js*/
/*修改后端访问URL  及id绑定编号*/
$.ajax({
        url: "admin/GeetestOnLoad?t=" + (new Date()).getTime(), // 加随机数防止缓存
        type: "get",
        dataType: "json",
        success: function (data) {
            // 调用 initGeetest 初始化参数
            // 参数1：配置参数
            // 参数2：回调，回调的第一个参数验证码对象，之后可以使用它调用相应的接口
            initGeetest({
                gt: data.gt,
                challenge: data.challenge,
                new_captcha: data.new_captcha, // 用于宕机时表示是新验证码的宕机
                offline: !data.success, // 表示用户后台检测极验服务器是否宕机，一般不需要关注
                product: "popup", // 产品形式，包括：float，popup
                width: "100%"
                // 更多配置参数请参见：http://www.geetest.com/install/sections/idx-client-sdk.html#config
            }, handler2);
        }
    });
    
 
 

  var handler2 = function (captchaObj) {
      /*   $("#submit2").click(function () {*/
       /*改由拼图事件的成功回调函数 触发*/
       captchaObj.onSuccess(function(){
            var result = captchaObj.getValidate();
            if (!result) {
                $("#notice2").show();
                setTimeout(function () {
                    $("#notice2").hide();
                }, 2000);
            } else {
                $.ajax({
                    url: 'admin/login',
                    type: 'POST',
                    dataType: 'json',
                    data: {
                        userName: $('#userName').val(),
                        passWord: $('#passWord').val(),
                        geetest_challenge: result.geetest_challenge,
                        geetest_validate: result.geetest_validate,
                        geetest_seccode: result.geetest_seccode
                    },
                    success: function (data) {
                        if (data.LoginStatus>0&&data.status == 'success') {
                            //$("#form1").submit();
                            location.href="index.html";
                        } else {
                            alert('Login error');
                            location.reload();
                        }
                    }
                })
            }
           // e.preventDefault();
        });
     /* $("#submit2").click(function (e){
          captchaObj.show();
      });*/

      // 将验证码加到id为captcha的元素里，同时会有三个input的值用于表单提交
        captchaObj.appendTo("#captcha2");
        captchaObj.onReady(function () {
            $("#wait2").hide();
        });
        // 更多接口参考：http://www.geetest.com/install/sections/idx-client-sdk.html
    };
 