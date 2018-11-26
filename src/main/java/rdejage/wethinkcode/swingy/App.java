package rdejage.wethinkcode.swingy;

public class App {
    public static void main(String[] args) {
        System.out.println("App is working");
        // If there are arguments
        if (args.length > 0) {
            if (args[0].equals("GUI")) {
                // if args = GUI then use swing GUI
                System.out.println(args[0]);
            } else if (args[0].equals("console")) {
                // if args = console then use console
                System.out.println(args[0]);
            } else {
                // exit with error
                System.out.println("Command line argument error: Incorrect argument");
                System.exit(1);
            }
        } else {
            // exit with error
            System.out.println("Command line argument error: Incorrect number of arguments");
            System.exit(1);
        }
    }
}
