var code;
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
    if (checkCode) 
    {
        
        checkCode.innerHTML = code;
    }
}



function validateCode() 
        {
            var inputCode = document.getElementById("inputCheckCode").value;
            if (inputCode.length <= 0) 
            {
                alert("请输入验证码！");
				return false;
            }
            else if (inputCode.toUpperCase() != code.toUpperCase()) 
            {
                alert("验证码错误！");
                createCode();
				return false;
            }
			else
			{
				return true;
			}
                  
        }     