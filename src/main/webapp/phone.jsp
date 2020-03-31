<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.msgs1 {
    -webkit-border-radius: .5em;
    -moz-border-radius: .5em;
    border-radius: .5em;
    display: inline-block;
    width: 200px;
    color: #fff;
    font-size: 14px;
    border: 1px solid #0697DA;
    text-align: center;
    height: 30px;
    line-height: 30px;
    background: #818080;
    cursor: pointer;
}

.msgs {
    -webkit-border-radius: .5em;
    -moz-border-radius: .5em;
    border-radius: .5em;
    display: inline-block;
    width: 200px;
    color: #fff;
    font-size: 14px;
    border: 1px solid #0697DA;
    text-align: center;
    height: 30px;
    line-height: 30px;
    background: #0697DA;
    cursor: pointer;
}

</style>
  <script src="<%=basePath %>/js/jquery-3.1.1.min.js"></script>
  <script>
    function getBasePath(){
        return '<%=basePath%>';
    }
  </script>
</head>
<body>
   <form>
       <div>
           账号: <input name="userId">
       </div>
       <div>
           密码: <input name="password">
       </div>
       <div>
           手机号: <input name="number">
       </div>
       <div>
           <input type="button"  class="msgs" id="fsdmsg2" value="获取手机验证码" onclick="sendRand_oldMobile()">          
       </div>
       <div><button type="button" class="sub-btn">提交</button></div>
   </form>
</body>
</html>
<script>
$(function(){ 
    //提交
    $(".sub-btn").on("click", function(){
        var data = {};
        data.userId = $.trim($("input[name=userId]").val());
        data.password = $.trim($("input[name=password]").val());
        data.number = $.trim($("input[name=number]").val());
        data.verifyCode = $.trim($("input[name=verifyCode]").val());
        $.ajax({
            url: getBasePath()+"/register.do",
            async : true,
            type: "post",
            dataType: "json",
            data: data,
            success: function (data) {
                if(data == 'fail'){
                    alert("注册失败");
                    return ;
                }
                alert("注册成功");
            }
        });
    })
});


//发送验证码
function sendRand_oldMobile(){
	 /* var number = $("input[name=number]").val();
     $.ajax({
         url: getBasePath()+"/sendSms.do",
         async : true,
         type: "post",
         dataType: "json",
         data: {"number":number},
         success: function (data) {
             if(data == 'fail'){
                 alert("发送验证码失败");
                 return ;
             }
         }
     }); */
    var number = $("input[name=number]").val();
     if(number==""){
    	 alert("请输入手机号");
    	 return
     }
	$.ajax({
        type : "POST", // post提交方式,默认是get
        url : getBasePath()+"/sendSms.do", // 请求的数据源
        data: {"number":number},
        success : function(data) {
           // var result = $.parseJSON(response);
            alert(data);
           // if(result.code=="0109" || result.code=="0110"){
            if(data=="success"){
                var time = 60;
                // var code = $(this);
                $("#fsdmsg2").removeClass("msgs");
                $("#fsdmsg2").addClass("msgs1");
                $("#fsdmsg2").removeAttr("onclick");
                var t = setInterval(function() {
                            time--;
                            $("#fsdmsg2").val(time  + "秒后重新获取");
                            if (time == 0) {
                                clearInterval(t);
                                $("#fsdmsg2").val("重新获取");
                                $("#fsdmsg2").removeClass("msgs1");
                                $("#fsdmsg2").addClass("msgs");
                                $("#fsdmsg2").attr("onclick","sendRand_oldMobile();");
                            }
                        }, 1000)
            }
        }
    })

}
</script>