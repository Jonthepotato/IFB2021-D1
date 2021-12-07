package ibf2021workshopday1;

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCartMain {
    public static void main(String[] args) {

        System.out.println("Welcome to your shopping cart");
        System.out.println("Please use only 'list', 'delete','exit', 'add item', if adding multiple items, please seperate by using ','");
        // establish list
        ArrayList<String> shoppinglist = new ArrayList<String>();

        // establish array size
        int i = shoppinglist.size();

        // establish scanner
        Scanner scan = new Scanner(System.in);

        // scan to establish list or add
       
        String command = scan.next();
        String Argument = scan.nextLine();
         //E.g @123456, scan.next will read only @, nextLine will read 123456

        while (!command.equals("list") && !command.equals("add") &&!command.equals("delete") &&!command.equals("exit")) {
            System.out.println("Please use only the following commands listed above");
            command = scan.next();
        }
        

        while(!command.equals("exit")){
            if(command.equals("list")){
                if (i==0) {
                    System.out.println("Shopping cart is empty");
            }
                    else {
                        for (i = 0; i < shoppinglist.size(); i++) {
                            System.out.println((i+1) + "." + shoppinglist.get(i));
                        }
                    }
                }
            
            if (command.equals("add")) {
                //Establish string array after split Argument
                String[] items = Argument.split(",");
                for (i = 0; i < items.length; i++) {
                    String item = items[i].trim();
                    if (shoppinglist.contains(item)) {
                        System.out.println("Item already added, do not put duplicate items");
                    }   
                    else{
                    shoppinglist.add(item);
                    System.out.println(item + " is added to the cart");
                    }
                }    
            }  
            
            if (command.equals("delete")){
                int position = 0;
                try {
                    position = Integer.parseInt(Argument.trim());
                    String removeditem = shoppinglist.get(position-1);
                    System.out.println(removeditem + " is removed from the cart");
                    shoppinglist.remove(position-1);          

                } catch (NumberFormatException NFE) {
                    System.out.println("Please key in a number");
                } catch (IndexOutOfBoundsException IOOBE){
                    System.out.println(("Please key in a number within the list"));
                }
                }
                //Need to have this such that the while loop will not run infinitely
                command = scan.next();
                Argument = scan.nextLine();
                }

            }

}
