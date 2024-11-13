package useradmin;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class system {

    static Scanner scanner = new Scanner (System.in);
    final String FILENAME = "users.txt";
    ArrayList <User> users = new ArrayList<>();

    public User createNewUser() {

        System.out.println("Enter a id number");
        int id = scanner.nextInt();
        System.out.println("Enter a name");
        String name = scanner.next();
        System.out.println("Enter a password");
        String password = scanner.next();
        return adduser(id, name, password);

    }


    public User adduser (int id, String name, String password) {
        User bruger = new User(id, name, password);
        users.add(bruger);
        return bruger;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void viewAllUsers() {
        for(User hej : getUsers()) {
            System.out.println("Array number " + users.size() + " " + hej);
            for(int i = 0; i < 30; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public void deleteAUser() {
        System.out.println("Enter number of what user");
        int userDelete = scanner.nextInt();
        System.out.println("Deleting: " + users.get(userDelete));
        System.out.println("Press Y if you want to delete");
        String userDeleteConfirm = scanner.next();
        if(userDeleteConfirm.equalsIgnoreCase("Y")) {
            users.remove(userDelete);
            System.out.println("User removed");
        }

    }

    public void saveFile() {

        try (FileWriter fw = new FileWriter(FILENAME,true)) {
           PrintWriter output = new PrintWriter(fw);
            for(User str : getUsers()) {
                output.println(str);
            }
            output.close();


            } catch (IOException e) {
             e.printStackTrace();
        }
    }

    public void readFile() {
        try {
            File readFile = new File(FILENAME);
            Scanner read = new Scanner(readFile);
            while(read.hasNextLine()) {
                String data = read.nextLine();
                System.out.println(data);
                System.out.println("------------");
            }
            read.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
