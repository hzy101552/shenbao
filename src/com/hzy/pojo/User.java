package com.hzy.pojo;

public class User {
   
	private Integer id;

    private Integer snumber;
    
    private String username;

    private String password;

    private String userType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getSnumber() {
		return snumber;
	}

	public void setSnumber(Integer snumber) {
		this.snumber = snumber;
	}
    
    
}