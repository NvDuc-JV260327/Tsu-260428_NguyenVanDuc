import presentation.Management;
import utils.ConnectionDB;

public class Application {
    public static void main(String[] args) {
        Management management = new Management();

        management.displayMenu();
    }
}