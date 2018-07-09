function checkRegister(form) {
	var name = form.project_name.value.trim();
	if (name == "" || name == null) {
		// 获取焦点
		form.project_name.focus();
		return false;
	}
	
	var t_Name = form.t_Name.value.trim();
	if (t_Name == "" || t_Name == null) {
		// 获取焦点
		form.t_Name.focus();
		return false;
	}
	
	var snumber = form.snumber.value.trim();
	if (snumber == "" || snumber == null) {
		// 获取焦点
		form.snumber.focus();
		return false;
	}
	
	var student_name = form.student_name.value.trim();
	if (student_name == "" || student_name == null) {
		// 获取焦点
		form.student_name.focus();
		return false;
	}
	
	var createtime = form.createtime.value.trim();
	if (createtime == "" || createtime == null) {
		// 获取焦点
		form.createtime.focus();
		return false;
	}
	
	var result = form.result.value.trim();
	if (result == "" || result == null) {
		// 获取焦点
		form.result.focus();
		return false;
	}
	
	var funds = form.funds.value.trim();
	if (funds == "" || funds == null) {
		// 获取焦点
		form.funds.focus();
		return false;
	}
	
	var team = form.team.value.trim();
	if (team == "" || team == null) {
		// 获取焦点
		form.team.focus();
		return false;
	}
	
	var introduction = form.introduction.value.trim();
	if (introduction == "" || introduction == null) {
		// 获取焦点
		form.introduction.focus();
		return false;
	}
	
	var research_contents = form.research_contents.value.trim();
	if (research_contents == "" || research_contents == null) {
		// 获取焦点
		form.research_contents.focus();
		return false;
	}
	
	var plan = form.plan.value.trim();
	if (plan == "" || plan == null) {
		// 获取焦点
		form.plan.focus();
		return false;
	}

	return true;

}
