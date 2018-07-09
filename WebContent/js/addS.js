function checkAddS(form) {
	var snumber = form.snumber.value.trim();
	if (snumber == "" || snumber == null) {
		// 获取焦点
		form.snumber.focus();
		return false;
	}
		
	var name = form.name.value.trim();
	if (name == "" || name == null) {
		// 获取焦点
		form.name.focus();
		return false;
	}
	
	var tutor = form.tutor.value.trim();
	if (tutor == "" || tutor == null) {
		// 获取焦点
		form.tutor.focus();
		return false;
	}
	
	var phone = form.phone.value.trim();
	if (phone == "" || phone == null) {
		// 获取焦点
		form.phone.focus();
		return false;
	}
	
	var email = form.email.value.trim();
	if (email == "" || email == null) {
		// 获取焦点
		form.email.focus();
		return false;
	}
	
	return true;
}