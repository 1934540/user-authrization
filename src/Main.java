import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();


        User user = getUserByLoginAndPassword(login, password);


        validateUser(user);
        System.out.println("User: "+user.getLogin()+" "+ user.getEmail());

        System.out.println("Доступ предоставлен");
    }


    public static User[] getUsers() {
        User user1 = new User("jhon", "jhon@gmail.com", "pass", 16);
        User user2 = new User("baglan", "turalievbaglan@gmail.com", "pass", 20);
        User user3 = new User("amir", "amirkenesbay@gmail.com", "pass", 24);
        return new User[]{user1, user2, user3};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User userList : users) {
            if (login.equals(userList.getLogin()) && password.equals(userList.getPassword())) {
                return userList;
            }
        }
        throw new UserNotFoundException("User not found " + login);
    }

    public static void validateUser(User user) throws AccessDeniedException {
        User[] users = getUsers();

        if (user.getAge() < 18) {
            throw new AccessDeniedException("Access Denied");

        } else {
            getUsers();
        }


    }
}

