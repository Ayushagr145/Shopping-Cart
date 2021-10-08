import java.util.ArrayList;
import java.util.Scanner;

public class Ayush_SCart {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> items = new ArrayList<>();
    static ArrayList<Integer> price = new ArrayList<>();
    static ArrayList<String> final_items = new ArrayList<>();
    static ArrayList<Integer> final_price = new ArrayList<>();

    //Adding Products to cart
    public static void Add(){
        char op;
        int ch,i;
        do{
            menu();
            System.out.println("6. Exit from Add Section");
            System.out.println("Please Make your Selection");
            ch = sc.nextInt();
            System.out.println("---> For Multiple Quantity Select the same item again and again <---");
            if(ch==6)
                break;
            if(ch<6) {
                for (i = 1; i <= items.size(); i++) {
                    if (i == ch) {
                        final_items.add(items.get(i - 1));
                        final_price.add(price.get(i - 1));
                    }
                }
            }
            else {
                System.out.println(" ----> Oops!!!! , Wrong Input <----");
                System.out.println(" ----> Select it carefully <----\n");
            }
            System.out.println("Do you want to add more products to the cart Y/N");
            op = sc.next().charAt(0);
        }while(op!='N' && op!='n');
    }

    //Deleting Products From cart
    public static void delete(){

        while (true) {
            int a = 1;
            if (final_items.size() == 0) {
                System.out.println("No Item exists in your Cart");
                break;
            } else {
                System.out.println("Items You have added to your purchase list");
                for (String str : final_items) {
                    System.out.println(a + ". " + str + "  Price -->  " + final_price.get(final_items.indexOf(str)));
                    a++;
                }
                System.out.println(a + ". Exit");
                System.out.println("Select the product you want to delete");
                int ch = sc.nextInt();
                System.out.println("---> For Multiple Quantity Select the same item again and again <---");
                if (ch == a)
                    break;
                if(ch>a){
                    System.out.println(" ----> Oops!!!! , Wrong Input <----");
                    System.out.println(" ----> Select it carefully <----");
                }
                else {
                    final_items.remove(ch - 1);
                    final_price.remove(ch - 1);
                }

            }
        }

    }

    //Displaying The Updated Cart with the Total Amount
    public static void update(){
        int a=1,total=0;
        System.out.println("******* Your Final Updated Cart is *******");
        for(String str: final_items){
            System.out.println(a+". "+str+"  Price -->  "+ final_price.get(final_items.indexOf(str)));
            a++;
            total = total + final_price.get(final_items.indexOf(str));
        }
        if(total==0) {
            System.out.println("You Haven't Added any Product to your Cart");
            System.out.println("******************************************");
        }
        else {
            System.out.println("\nTotal Amount To be Paid is --->  " + total);
            System.out.println("***** THANK YOU FOR SHOPPING WITH US *****");
        }
    }

    public static void menu(){
        System.out.println("****** List Of Items ******");
        System.out.println("1. Dairy Milk  --> 20/-");
        System.out.println("2. KitKat --> 20/-");
        System.out.println("3. Munch Nuts  --> 20/-");
        System.out.println("4. Fuse  -->  20/-");
        System.out.println("5. Ferro Rosher Swiss Choco  -->  150/-");
        System.out.println("********************************************");
    }

    public static void main(String[] args) {
        int ch;
        items.add("Dairy Milk");
        items.add("KitKat");
        items.add("Munch Nuts");
        items.add("Fuse");
        items.add("Ferro Rosher Swiss Choco");
        price.add(20);
        price.add(20);
        price.add(20);
        price.add(20);
        price.add(150);

        System.out.println(" ---> Welcome to the Ayush_SCart <--- ");
        System.out.println("         ---> Since 2021 <---         \n");
        menu();
        while (true) {
            //System.out.println("********************************************");
            System.out.println("\n1. Add Products to cart");
            System.out.println("2. Delete Products from cart");
            System.out.println("3. Updated Cart");
            System.out.println("4. Exit");
            System.out.println("Enter your choice ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    Add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    System.out.println("***** THANK YOU FOR VISITING AND SHOPPING WITH US *****");
                    System.out.println(" ---> Do Visit Our Shop Again , We will be Happy to have you again :) <---");
                    System.out.println(" ----> Have a Good Day <----");
                    System.exit(0);
                default:
                    System.out.println("----> Oops !!!!!!! , You made a Wrong Selection! <----");
            }
        }
    }
}