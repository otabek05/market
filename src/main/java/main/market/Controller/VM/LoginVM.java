package otash1998.api.VM;

import javax.validation.constraints.NotNull;

public class LoginVM {
    @NotNull
    private String login;
    @NotNull
    private String password;

    public String getLogin(){
        return this.login;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }

}
