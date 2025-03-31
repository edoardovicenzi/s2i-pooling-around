package solutions.vdesign.util;

public class AdminLoginStrategy implements IStrategy {

    @Override
    public void execute() {

        try {
            ConsoleTable.printBanner("Admin login");

            String password = ConsoleUtil.getInputString("Password: ").trim();

            if (password.equals(UserEntity.getInstance().getAdminPassword())) {
                UserEntity.getInstance().setIsAdmin(true);
                ConsoleTable.printBanner("Login effettuato!");
            }
            else{
                ConsoleTable.printBanner("Password errata!");
            }


        } catch (Exception e) {
            ConsoleTable.printBanner("Errore visualizzando gli utenti: " + e.getMessage());
        }
    }
}
