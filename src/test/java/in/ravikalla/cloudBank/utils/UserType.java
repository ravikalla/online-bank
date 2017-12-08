package in.ravikalla.cloudBank.utils;

public enum UserType {
    COMMON("User", "password"),
    ADMIN("Admin", "password");
	private String strUserName;
	private String strPWD;

	UserType(String strURL, String strPWD) {
        this.strUserName = strURL;
        this.strPWD = strPWD;
    }

    public String getUserName() {
        return this.strUserName;
    }
    public String getPWD() {
        return this.strPWD;
    }
}
