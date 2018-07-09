function checkAddU(form) {
	var snumber = form.snumber.value.trim();
	if (snumber == "" || snumber == null) {
		// 获取焦点
		form.snumber.focus();
		return false;
	}
	
	var username = form.username.value.trim();
	if (username == "" || username == null) {
		// 获取焦点
		form.username.focus();
		return false;
	}
	
	var password = form.password.value.trim();
	if (password == "" || password == null) {
		// 获取焦点
		form.password.focus();
		return false;
	}
	
	return true;
}