var code ; //��ȫ�ֶ�����֤��   
 



function cheklogname(){  
    var inputCode = document.getElementById("userName").value; //ȡ��������û���       
    if(inputCode.length <= 0) { //�������û�������Ϊ0  
        alert("�������û���!"); //�򵯳��������û��� 
    }         
    else if(inputCode.length>4) { //��������û�������4���ַ� 
		alert("�û�������4���ַ�!"); 
    }         
    else { //������ȷʱ  
        document.getElementById("login-name-inform").value="��ȷ"
    }             
}  
function cheklogpassword(){  
    var inputCode = document.getElementById("password").value; //ȡ�����������       
    if(inputCode.length<5||inputCode.length>20) { //���������볤��С��5�����20  
        document.getElementById("passInform").value="���벻�Ϸ�"; //�򵯳����벻�Ϸ� 
    }         
       
    else { //������ȷʱ  
        document.getElementById("passInform").value="��ȷ"
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
        var charNum = Math.floor(Math.random() * 62);//����0~61���������floor�������ȡ��
        code += codeChars[charNum];//���������֤��
    }
    if (login-code) 
    {
        login-code.className = "code";
        login-code.innerHTML = code;
    }
}
function validateCode() //���Ϸ���
{
    var inputCode = document.getElementById("inputCode").value;
    if (inputCode.length <= 0) 
    {
        alert("Please input checkcode!");
    }
    else if (inputCode.toUpperCase() != code.toUpperCase()) //ת���ɴ�д�ж�
    {
        alert("Checkcode wrong!");
        createCode();
    }
    else 
    {
        alert("Checkcode correct!");
    }        
}    
