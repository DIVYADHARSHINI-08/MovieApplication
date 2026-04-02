import entity.Users;
import entity.Movies;
import service.UsersService;
import service.MoviesService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UsersService userService = new UsersService();
        MoviesService movieService = new MoviesService();

        System.out.println("Welcome to Movie CLI App");

        // ================= START MENU =================
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("Choose: ");
        int choice = sc.nextInt();
        sc.nextLine();

        Users loggedInUser = null;

        // ================= REGISTER =================
        if (choice == 2) {

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Phone No: ");
            String phnNo = sc.nextLine();

            System.out.print("Enter City: ");
            String city = sc.nextLine();

            userService.registerUser(
                    System.currentTimeMillis(),
                    name,
                    password,
                    email,
                    phnNo,
                    city
            );

            System.out.println("Please login now.\n");

            // After register → login
            System.out.print("Username: ");
            String username = sc.nextLine();

            System.out.print("Password: ");
            String pass = sc.nextLine();

            loggedInUser = userService.login(username, pass);
        }

        // ================= LOGIN =================
        else if (choice == 1) {

            System.out.print("Username: ");
            String username = sc.nextLine();

            System.out.print("Password: ");
            String password = sc.nextLine();

            loggedInUser = userService.login(username, password);
        }

        else {
            System.out.println("Invalid choice!");
            return;
        }

        if (loggedInUser == null) {
            System.out.println("Login failed!");
            return;
        }

        // ================= MAIN LOOP =================
        while (true) {

            System.out.println("\n===== MENU =====");

            // ================= ADMIN =================
            if (loggedInUser.getRole().equalsIgnoreCase("ADMIN")) {

                System.out.println("1.Add 2.Search 3.Filter 4.Trending 5.All 6.Update 7.Delete 8.Users 9.Exit");
                int ch = sc.nextInt();
                sc.nextLine();

                switch (ch) {

                    case 1:
                        System.out.print("Title: ");
                        String t = sc.nextLine();

                        System.out.print("Genre: ");
                        String g = sc.nextLine();

                        System.out.print("Year: ");
                        int y = sc.nextInt();

                        System.out.print("Duration: ");
                        int d = sc.nextInt();

                        System.out.print("Rating: ");
                        double r = sc.nextDouble();
                        sc.nextLine();

                        movieService.addMovie(new Movies(
                                System.currentTimeMillis(),
                                t, d, g, y, r,
                                loggedInUser.getUserId()
                        ));
                        break;

                    case 2:
                        System.out.print("Title: ");
                        movieService.searchMovie(sc.nextLine());
                        break;

                    case 3:
                        System.out.print("Genre: ");
                        movieService.filterByGenre(sc.nextLine());
                        break;

                    case 4:
                        movieService.showTrending();
                        break;

                    case 5:
                        movieService.showAllMovies();
                        break;

                    case 6:
                        System.out.print("Title: ");
                        String ut = sc.nextLine();

                        System.out.print("New Genre: ");
                        String ng = sc.nextLine();

                        System.out.print("Year: ");
                        int ny = sc.nextInt();

                        System.out.print("Duration: ");
                        int nd = sc.nextInt();

                        System.out.print("Rating: ");
                        double nr = sc.nextDouble();
                        sc.nextLine();

                        movieService.updateMovie(ut, nd, ng, ny, nr);
                        break;

                    case 7:
                        System.out.print("Title: ");
                        movieService.deleteMovie(sc.nextLine());
                        break;

                    case 8:
                        userService.showAllUsers();
                        break;

                    case 9:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            }

            // ================= USER =================
            else {

                System.out.println("1.Search 2.Filter 3.Trending 4.All 5.Exit");
                int ch = sc.nextInt();
                sc.nextLine();

                switch (ch) {

                    case 1:
                        System.out.print("Title: ");
                        movieService.searchMovie(sc.nextLine());
                        break;

                    case 2:
                        System.out.print("Genre: ");
                        movieService.filterByGenre(sc.nextLine());
                        break;

                    case 3:
                        movieService.showTrending();
                        break;

                    case 4:
                        movieService.showAllMovies();
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            }
        }
    }
}