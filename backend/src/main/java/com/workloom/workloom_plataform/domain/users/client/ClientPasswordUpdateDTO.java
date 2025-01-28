package com.workloom.workloom_plataform.domain.users.client;

public class ClientPasswordUpdateDTO {
    public String newPassword;
    public String oldPassword;


    public String getNewPassword() {
        return this.newPassword;
    }
    public void setPassword(String newPassword){
        this.newPassword = newPassword;
    }
}
