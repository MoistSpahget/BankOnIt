import java.io.Serializable;

public abstract class User implements HasMenu, Serializable {
    private static final long serialVersionUID = 1L;

    private String userName;
    private String PIN;

    public User(String userName, String PIN) {
        this.userName = userName;
        this.PIN = PIN;
    }

    public String getUserName() { return userName; }
    public String getPIN()      { return PIN; }
    public void setPIN(String PIN) { this.PIN = PIN; }

    public boolean login(String name, String pin) {
        return userName.equalsIgnoreCase(name) && PIN.equals(pin);
    }

    public boolean login() {
        System.out.print("User name: ");
        String name = input.nextLine().trim();
        System.out.print("PIN: ");
        String pin = input.nextLine().trim();
        boolean ok = login(name, pin);
        if (!ok) {
            System.out.println("Login failed.");
        }
        return ok;
    }

    public static boolean isValidPIN(String pin) {
        return pin.matches("\\d{4}");
    }

    public abstract String getReport();
}
