function checkLogin(form) {
	var name = form.username.value.trim();
	if (name == "" || name == null) {
		//alert("用户名不为空");
		// 获取焦点
		form.username.focus();
		return false;
	}

	var password = form.password.value;
	if (password == null || password == "") {
		//alert("密码不能为空");
		form.password.focus();
		return false;
	} 
	
	var authCode = form.authCode.value;
	if (authCode == null || authCode == "") {
		//alert("验证码不能为空");
		form.authCode.focus();
		return false;
	}
	
	return true;

}
