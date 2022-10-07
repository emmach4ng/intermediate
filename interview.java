import java.util.Scanner;

class Interview {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 

        System.out.println("Hi! What is your name?");

        String name = scan.nextLine();
        System.out.println("Hi, " + name + "! What is your favorite ice cream flavor?");

        String iceCream = scan.nextLine();

        if (iceCream.equals("vanilla")) {
            System.out.println("I love vanilla too!");
        } else {
            System.out.println("Personally, I don't like " + iceCream + ".");
        }
    }
}