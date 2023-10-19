package com.example.secondproject.action;

import com.example.secondproject.dao.LoginDao;
import com.example.secondproject.model.Login;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
    private String userName;
    private String password;



    public String execute(){
       Login login = LoginDao.getLoginByUsernameAndPassword(userName,password);
       if(userName.equals( login.getUserName()) && password.equals(login.getPassword())){
           return SUCCESS;
       }else {
           return INPUT;
       }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
