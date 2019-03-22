$(function () {
    var common = new Common();
    common.RegisterKeydown("ibtnLogin");
    $("#txtUserName").focusin(function () {


        if ($("#txtUserName").val() == '用户名') {
            $("#txtUserName").val('').css('color', 'Gray');
        } else {
            $("#txtUserName").css('color', '#000');
        }
    })

    $("input").focusin(function () {

        $('input').css("background-color", "#fff");
        $(this).css("background-color", "#FFFFCC");
        $(this).css('color', '#000');
    });
    $("input").focusout(function () {

        if ($("#txtUserName").val() == '') {
            $("#txtUserName").val('用户名');
            $("#txtUserName").css('color', 'Gray');
        }
        $('input').css("background-color", "#fff");
    });

    if ($("#txtUserName").val() == '用户名') {
        $("#txtUserName").css('color', 'Gray');
    } else {
        $("#txtUserName").css('color', '#000');
    }
  
    
        
        
       
   
       

  
})



function submitLogin() {
   
    if ($("#txtUserName").val() == '') {
        alert("账号不能为空！");
        return false;
    }

    if ($("#txtPassword").val() == '') {
        alert("密码不能为空！");
        return false;
    }
/*
    if ($("#txtCheckImageValue").val() == '') {
        alert("验证码不能为空！");
        return false;
    }
 */    
  //  encryptPassword();
    $("#form1").submit();
}
 

