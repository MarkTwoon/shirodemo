 /*������֤  ר���Զ��崥��js*/
/*�޸ĺ�˷���URL  ��id�󶨱��*/
$.ajax({
        url: "admin/GeetestOnLoad?t=" + (new Date()).getTime(), // ���������ֹ����
        type: "get",
        dataType: "json",
        success: function (data) {
            // ���� initGeetest ��ʼ������
            // ����1�����ò���
            // ����2���ص����ص��ĵ�һ��������֤�����֮�����ʹ����������Ӧ�Ľӿ�
            initGeetest({
                gt: data.gt,
                challenge: data.challenge,
                new_captcha: data.new_captcha, // ����崻�ʱ��ʾ������֤���崻�
                offline: !data.success, // ��ʾ�û���̨��⼫��������Ƿ�崻���һ�㲻��Ҫ��ע
                product: "popup", // ��Ʒ��ʽ��������float��popup
                width: "100%"
                // �������ò�����μ���http://www.geetest.com/install/sections/idx-client-sdk.html#config
            }, handler2);
        }
    });
    
 
 

  var handler2 = function (captchaObj) {
      /*   $("#submit2").click(function () {*/
       /*����ƴͼ�¼��ĳɹ��ص����� ����*/
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

      // ����֤��ӵ�idΪcaptcha��Ԫ���ͬʱ��������input��ֵ���ڱ��ύ
        captchaObj.appendTo("#captcha2");
        captchaObj.onReady(function () {
            $("#wait2").hide();
        });
        // ����ӿڲο���http://www.geetest.com/install/sections/idx-client-sdk.html
    };
 