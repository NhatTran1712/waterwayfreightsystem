function btnSubmit() {
    var username = document.getElementById("username").length;
    var password = document.getElementById("password").length;
    var fullname = document.getElementById("fullname").length;
    var phoneNumber = document.getElementById("phoneNumber").value;
    var phone_regex = /((09|03|07|08|05)+([0-9]{8})\b)/g;
    var idCard = document.getElementById("idCard").length;
    
	errorMess="";
    submitOK = "true";

    if (username < 3 || username > 25) {
        errorMess = errorMess + "Username tu 4 den 24 ky tu.\n";
        submitOK = "false";
    } 
    if (password < 8 || password > 32){
        errorMess = errorMess + "Password tu 9 den 31 ky tu.\n";
        submitOK = "false";
    }
    if (fullname < 2 || fullname > 25) {
		errorMess = errorMess + "Fullname tu 3 den 24 ky tu.\n";
        submitOK = "false";
    } 
    if(phoneNumber != null && phone_regex.test(phoneNumber) == false) {
		errorMess = errorMess + "So dien thoai khong hop le.\n";
        submitOK = "false";
    } 
   if (idCard != null && idCard < 9) {
		errorMess = errorMess + "CMND qua ngan.\n";
        submitOK = "false";
    }
   if(submitOK =="false"){
		alert("Dang ky that bai!");
  }
   if(submitOK =="true"){
		alert("Dang ky thanh cong!");
   }
}