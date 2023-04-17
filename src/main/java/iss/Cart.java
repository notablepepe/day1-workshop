package iss;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class Cart 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to your shopping cart" );
        Scanner sc = new Scanner(System.in);
        ArrayList<String> cart = new ArrayList<>();

        String command = sc.nextLine();
        command = command.toLowerCase();

        while(!command.equals("exit")) {
            if(command.startsWith("add")) {
                String items = command.substring(4);
                String[] itemArray = items.split(", ", 0);

                for(int i = 0 ; i < itemArray.length ; i++) {
                    String item = itemArray[i];
                    if(cart.contains(item)) {
                        System.out.println("You have " + item + " in your cart");
                    }
                    else {
                        cart.add(item);
                        System.out.println(item + " added to cart");
                    }
                }

            } else if (command.startsWith("delete")) {
                Integer index = Integer.parseInt(command.split(" ", 2)[1]);
                System.out.println(index);
                if (index < 1 || index > cart.size()) {
                    System.out.println("Incorrect item index");
                }
                else {
                    String item = cart.get(index - 1);
                    System.out.println(item + " removed from the cart");
                    cart.remove(item);
                }

            } else if (command.startsWith("list")) {
                    if(cart.isEmpty()) {
                        System.out.println("Your cart is empty");
                    } else {
                        for(int i = 0 ; i < cart.size() ; i++) {
                            System.out.println( i+1 + ". " + cart.get(i));
                        }
                    }

            } else {
                System.out.println("Invalid command");
            }

            command = sc.nextLine().toLowerCase();

        }

        sc.close();
    }
}
