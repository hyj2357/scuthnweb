var code ; //在全局定义验证码   
 



function cheklogname(){  
    var inputCode = document.getElementById("userName").value; //取得输入的用户名       
    if(inputCode.length <= 0) { //若输入用户名长度为0  
        alert("请输入用户名!"); //则弹出请输入用户名 
    }         
    else if(inputCode.length>4) { //若输入的用户名大于4个字符 
		alert("用户名大于4个字符!"); 
    }         
    else { //输入正确时  
        document.getElementById("login-name-inform").value="正确"
    }             
}  
function cheklogpassword(){  
    var inputCode = document.getElementById("password").value; //取得输入的密码       
    if(inputCode.length<5||inputCode.length>20) { //若输入密码长度小于5或大于20  
        document.getElementById("passInform").value="密码不合法"; //则弹出密码不合法 
    }         
       
    else { //输入正确时  
        document.getElementById("passInform").value="正确"
    }             
} 


function createCode() {
    code = "";
    var codeLength = 6; 
    var checkCode = document.getElementById("checkCode");
    var codeChars = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 
    'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'); 
    for (var i = 0; i < codeLength; i++) 
    {
        var charNum = Math.floor(Math.random() * 62);//产生0~61的随机数，floor用于最近取整
        code += codeChars[charNum];//逐个产生验证码
    }
    if (login-code) 
    {
        login-code.className = "code";
        login-code.innerHTML = code;
    }
}
function validateCode() //检查合法性
{
    var inputCode = document.getElementById("inputCode").value;
    if (inputCode.length <= 0) 
    {
        alert("Please input checkcode!");
    }
    else if (inputCode.toUpperCase() != code.toUpperCase()) //转换成大写判断
    {
        alert("Checkcode wrong!");
        createCode();
    }
    else 
    {
        alert("Checkcode correct!");
    }        
}    
