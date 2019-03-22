//提交验证 
function sumbit() {
        if (!(CheckRegisterEmail() && CheckRegisterPassWord('') && CheckSex() && CheckName() &&CheckIDNumber())) {
            return false;
        } else {
            var email = $('#user_name').val();
            if (email) {
                $('#pemail').html(email);
                popup('popDiv');
            } else {
                alert("请确认电子邮箱是否填写！");
            }
            return false;
        }
    }

    function popup(popupName) {
        $('.modueldiv').show();
        var _scrollHeight = $(document).scrollTop(), //获取当前窗口距离页面顶部高度
            _windowHeight = $(window).height(), //获取当前窗口高度
            _windowWidth = $(window).width(), //获取当前窗口宽度
            _popupHeight = $('#' + popupName).height(), //获取弹出层高度
            _popupWeight = $('#' + popupName).width(); //获取弹出层宽度
        _posiTop = (_windowHeight - _popupHeight) / 2;
        _posiLeft = (_windowWidth - _popupWeight) / 2;
        $('#' + popupName).css({ "left": _posiLeft + "px", "top": _posiTop + "px", "display": "block" }); //设置position
    }

    function btn_cancel() {
        $('#popDiv').hide();
        $('.modueldiv').hide();
    }

    function btn_sure() {
        $('#popDiv').hide();
        $('.modueldiv').hide();
        $('#form1').submit();
    }
    
//验证邮箱
function CheckRegisterEmail()
{
    var registerEmail = $.trim($("#user_name").val());
    //电子邮箱不能为空
    if (registerEmail == "") {
        alert("未输入电子邮箱！");
        return false;
    }
    //是否有效的邮箱
    if (!registerEmail.isEmail())
    {
        alert("电子邮箱格式不符！");
        return false;
    }
    if (registerEmail.length>35) {
        alert("电子邮箱超长");
        return false;
    }
    //*以NEEA为后缀的不能注册
    var extStart = registerEmail.lastIndexOf(".");
    var ext = registerEmail.substring(extStart, registerEmail.length).toUpperCase();
    if (ext == ".NEEA") {
        alert("*以NEEA为后缀的不能注册！");
        return false;
    }
    return true;
}


//验证密码和确认密码

function CheckRegisterPassWord(alertTitle)
{
    var password= $.trim($("#password").val())
    if (password == "") {
        alert(alertTitle+"密码不能为空！");
        return false;
    }
    //密码需长度在8~18之间
    if (password.length < 8 || password.length > 20)
    {
        alert(alertTitle + "密码需长度在8~20之间，且必须同时包含：字母、数字");
        return false;
    }
    //确认密码不能为空
    var  passwordRepeat=$.trim($("#txtPasswordRepeat").val());
    if (passwordRepeat == "") {
        alert("确认密码不能为空！");
        return false;
    }
  

    //判断密码与确认密码是否相等
    if (password != passwordRepeat) {
        alert(alertTitle+"密码和确认密码不一致！");
        return false;
    }
    //判断密码强度
   // var wordRegex = new RegExp("^(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&*_-]).{8,18}$");
    var wordRegex = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,20}$/;
    if (!wordRegex.test(password)) {
        alert("您的密码长度不能小于8位或大于20位，且必须同时包含：字母、数字");
        return false;
    }
    return true;
}
/***
验证证件号
1：如果没有选择证件类型，直接跳过
1：如果选择为身份证，需要判断身份证是否正常
*/
function CheckSex() {
    var checkIndex = $("#sex").get(0).selectedIndex;
    if (checkIndex == 0) {
    	alert("请选择性别");
        return false;
    }
    return true;
}
function CheckIDNumber() {
    var idNumber = $.trim($("#ID_number").val());
    if (idNumber == "") {
        alert("证件号为空！");
        return false;
    }
    if (!idNumber.isIDCard()) {
        alert("身份证格式不正确！");
        return false;
    }
    return true;
}

/**
判断姓名是否正确
*/
function CheckName() {
    var name = $.trim($("#name").val());
        if (!name) {
            alert("姓名不能为空！");
            return false;
        }
        if (!name.isName())
    {
        alert("姓名只能包含中文字符、字母、不连续不在首尾的·号！");
        return false;
    }
    return true;
}
