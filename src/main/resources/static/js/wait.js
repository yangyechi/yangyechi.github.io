
var Interval_Wait;
var WaitSecond = 60;
$(function () {
    if (getCookie("waiting") > 0) {
        wait(getCookie("waiting"));
    }
    if (getQueryString("waiting")!=null) {
        alert(getQueryString("waiting"))
        wait(getQueryString("waiting"))
    }
    //alert(getQueryString("waiting"))
})
function wait(s) {
   
    if (s != null) {
        WaitSecond = s;
    }
    setCookie("waiting", s, s);
    clearInterval(Interval_Wait);

  
    var btn = findActionControlButton();
    $("#divActionControlText").remove();
    $(btn).after("<div id='divActionControlText' style='color: Red;display:inline;  width:200px;text-align: center'>")
    $(btn).hide();
    

    Interval_Wait = setInterval("waiting()", 1000)



}

function findActionControlButton() {
 
    var btn;
 
    $(":submit").each(function (i) {
        if ($(this).attr("ActionControl") == "1") {


            btn = this;
            return;
        }
    });

    $(":input").each(function (i) {
        if ($(this).attr("ActionControl") == "1") {

            btn = this;
            return;

        }
    });
 
    $("div").each(function (i) {
        if ($(this).attr("ActionControl") == "1") {

            btn = this;
            return;

        }
    });
 
    $("button").each(function (i) {
       
        if ($(this).attr("ActionControl") == "1") {
           
            btn = this;
            return;

        }
    });
    return btn

}
function waiting() {
    
    if (WaitSecond > 0) {
       
        
        $("#divActionControlText").text("等待" + WaitSecond-- + "秒，可以重试！");
        setCookie("waiting", WaitSecond, WaitSecond);

    } else {

        delCookie("waiting");

        $("#divActionControlText").remove();


        clearInterval(Interval_Wait);
        var btn = findActionControlButton();
        $(btn).show();


    }

}
