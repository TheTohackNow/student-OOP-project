import menu.menu;
import menu.GymSettings;
import java.sql.Connection;
import java.sql.DriverManager;

public class main_gym {
    public static void main(String[] args) {
        GymSettings gym = new GymSettings();
        gym.run();
    }
}