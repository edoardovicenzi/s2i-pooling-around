package solutions.vdesign.util;

public class UserEntity {

    private static UserEntity instance = null;

    private Boolean isAdmin = false;
    // For demonstration purposes only!
    private String adminPassword = "adminadmin";

    private UserEntity() {

    }

    public static UserEntity getInstance() {
        if (instance == null) {
            instance = new UserEntity();
        }
        return instance;
    }

    // Getters
    public Boolean getIsAdmin() {
        return getInstance().isAdmin;
    }

    // For demonstration purposes only!
    public String getAdminPassword() {
        return getInstance().adminPassword;
    }

    // Setters
    public void setIsAdmin(Boolean newValue) {
        getInstance().isAdmin = newValue;
    }

    // For demonstration purposes only!
    public void setAdminPassword(String newValue) {
        getInstance().adminPassword = newValue;
    }

}
