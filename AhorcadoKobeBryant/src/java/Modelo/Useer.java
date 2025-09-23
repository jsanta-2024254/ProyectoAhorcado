package modelo;

public class Useer {
    private int user_code;
    private String user_name;
    private String user_password;

    public Useer() {
    }

    public Useer(int user_code, String user_name, String user_password) {
        this.user_code = user_code;
        this.user_name = user_name;
        this.user_password = user_password;
    }

    public int getUser_code() {
        return user_code;
    }

    public void setUser_code(int user_code) {
        this.user_code = user_code;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }


}
