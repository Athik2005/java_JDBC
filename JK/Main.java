package com.JK;

import java.util.*;

public class Main {

    private static String id;

    public static void main(String[] args) {
        List<Login_SignUp> l1 = new ArrayList<>();
        Login_SignUp s;
        Inventory I = new Inventory(); 
        Esteem e1, e2;
        int cond;
        Scanner sc = new Scanner(System.in);
        Esteem e3 = new Esteem();
        int condition;

        do {
            System.out.println("Welcome to JK Esteem Shoe Mart\n***********1.Login***********\n***********2.SignUp***********\n***********3.Logout***********\nEnter your option:");
            condition = sc.nextInt();

            switch (condition) {
                case 2:
                    s = new Login_SignUp();
                    System.out.println("Enter your ID:");
                    s.setId(sc.next() + sc.nextLine());
                    System.out.println("\nEnter your role:");
                    s.setType(sc.next() + sc.nextLine());
                    System.out.println("\nEnter a strong passcode:");
                    s.setPasscode(sc.next() + sc.nextLine());
                    if (s.getPasscode().length() < 8) {
                        System.out.println("\nNot a strong password:");
                        int size = 8 - s.getPasscode().length();
                        System.out.println("Your password requires " + size + " Characters");
                        break;
                    }
                    System.out.println("Re-Enter your password:");
                    s.setConfirm_password(sc.next() + sc.nextLine());
                    id = s.getId();
                    int flag = 0;
                    for (Login_SignUp loginSignUp : l1) {
                        if (loginSignUp.getId().equals(id)) {
                            flag = 1;
                            System.out.println("This ID has an existing account.");
                            break;
                        }
                    }
                    if (flag == 1)
                        break;
                    if (s.getConfirm_password().equals(s.getPasscode())) {
                        l1.add(s);
                        System.out.println("New Account Added!!");
                    }
                    break;
                case 1:
                    System.out.println("Enter your ID:");
                    String id1 = sc.next() + sc.nextLine();
                    System.out.println("\nEnter your passcode:");
                    String passcode = sc.next() + sc.nextLine();
                    boolean idExists = false;

                    for (Login_SignUp loginSignUp : l1) {
                        if (id1.equals(loginSignUp.getId())) {
                            idExists = true;

                            if (passcode.equals(loginSignUp.getPasscode())) {
                                if (loginSignUp.getType().equals("Owner")) {
                                    do {
                                        System.out.println("1.Add new product\n2.Update details of the product\n3.Search for the party details by entering his business id \n4.Remove the party from business\n5.Show the client");
                                        int opt = sc.nextInt();

                                        switch (opt) {
                                            case 1:
                                               e1 = new Esteem();
                                                System.out.println("Enter Brand Type: ");
                                                e1.setBrand(sc.next() + sc.nextLine());
                                                System.out.println("Enter your Prefered Shoe size: ");
                                                e1.setSize(sc.nextInt());
                                                System.out.println("Enter Type of Shoes:");
                                                e1.setType(sc.next() + sc.nextLine());
                                                System.out.println("Enter the No of Shoes:");
                                                e1.setNo_of_shoes(sc.nextInt());
                                                
                                                I.add(e1); // Add product to inventory
                                                System.out.println("New Product Added! \nProducts So far:");
                                                I.show_products();
                                                break;

                                            case 2:
                                            	System.out.println("Enter 1 to perform updation on customer details\n Else 2 to perform updation on product\nEnter your Option: ");
                                            	I.showID();
                                                id1 = sc.next();
                                                I.update(id1);
                                            	/*int c = sc.nextInt();
                                            	if(c==1) {
                                                System.out.println("Enter the ID of the Party to perform updation:");
                                                
                                                
                                                //e2 = I.search(id1);
                                                /*if (e2 != null) {
                                                    System.out.println("1.To Update the balance amount \n2.To Update Brand Type \n3.To Update Shoe Size \n4.To Update type of shoes \n5.To Update the no of shoes \n Enter your Option:");
                                                    int op = sc.nextInt();
                                                    switch (op) {
                                                        case 1:
                                                            System.out.println("Enter new amount (or) Balance amount: ");
                                                            e2.setAmt(sc.nextInt());
                                                            I.update(id1);
                                                            break;
                                                        case 2:
                                                            System.out.println("Enter Brand Type: ");
                                                            e2.setO_brand(sc.next() + sc.nextLine());
                                                            I.update(e2);
                                                            break;
                                                        case 3:
                                                            System.out.println("Enter your Prefered Shoe size: ");
                                                            e2.setO_size(sc.nextInt());
                                                            I.update(e2);
                                                            break;
                                                        case 4:
                                                            System.out.println("Enter Type of Shoes:");
                                                            e2.setO_type(sc.next() + sc.nextLine());
                                                            I.update(e2);
                                                            break;
                                                        case 5:
                                                            System.out.println("Enter the No of Shoes:");
                                                            e2.setO_no_of_shoes(sc.nextInt());
                                                            I.update(e2);
                                                            break;
                                                        default:
                                                            System.out.println("Invalid Updation!");
                                                    }
                                                } else {
                                                    System.out.println("Invalid User Id!");
                                                }}
                                            	else if(c==2) {
                                            		System.out.println("Enter the brand details of the product: ");
                                            		id1 = sc.next();
                                                    e2 = I.search(id1);
                                                    if (e2 != null) {
                                                        System.out.println("1.To Update Brand type \n2.To Update Shoe Size \n3.To Update type of shoes \n4.To Update the no of shoes \n Enter your Option:");
                                                        int op = sc.nextInt();
                                                        switch (op) {
                                                            case 1:
                                                            	System.out.println("Enter Brand Type: ");
                                                                e2.setBrand(sc.next() + sc.nextLine());
                                                                I.update(e2);
                                                                break;
                                                            case 2:
                                                            	System.out.println("Enter your Prefered Shoe size: ");
                                                                e2.setSize(sc.nextInt());
                                                                I.update(e2);
                                                                break;
                                                            case 3:
                                                            	System.out.println("Enter Type of Shoes:");
                                                                e2.setType(sc.next() + sc.nextLine());
                                                                I.update(e2);
                                                                break;
                                                            case 4:
                                                            	System.out.println("Enter 1 to Add the quantity of shoes or 2 to update the quantity of shoes\nEnter your option:");
                                                            	int a = sc.nextInt();
                                                            	if(a==2) {
                                                            		System.out.println("Enter the No of Shoes:");
                                                                   	e2.setNo_of_shoes(sc.nextInt());
                                                            	}
                                                            	else if(a==1) {
                                                            		System.out.println("Enter the No of Shoes that is to be added with the existing one: ");
                                                            		e2.setNo_of_shoes(e2.getNo_of_shoes()+sc.nextInt());
                                                            	}
                                                                I.update(e2);
                                                                break;
                                                            default:
                                                                System.out.println("Invalid Updation!");
                                                        }
                                                    } else {
                                                        System.out.println("Invalid User Id!");
                                                    }
                                            	}
                                                I.show_products();*/
                                                break;
                                            case 3:
                                                System.out.println("Enter the ID that your are looking for:");
                                                id1 = sc.next();
                                                e1 = I.search(id1);
                                                if (e1 != null)
                                                    System.out.println(e1);
                                                else
                                                    System.out.println("No such record found 404!");
                                                break;
                                            case 4:
                                                System.out.println("Enter the BRAND of the Party that you want to stop your business:");
                                                id1 = sc.next();
                                                I.delete(id1);
                                                I.show_orders();
                                                break;
                                            case 5:
                                                I.show_orders();
                                                break;
                                            default:
                                                System.out.println("Invalid Option!");
                                        }
                                        System.out.println("Enter 0 to exit:");
                                        cond = sc.nextInt();
                                    } while (cond != 0);
                                } else {
                                    do {
                                        System.out.println("1.View Products \n2.Place Orders\n3.Exit\nEnter your option:");
                                        int opt = sc.nextInt();
                                        switch (opt) {
                                            case 1:
                                                I.show_products();
                                                break;
                                            case 2:
                                                e1 = new Esteem();
                                                System.out.println("******Welcomes you to the ordering place******");
                                                System.out.println("Enter your name: ");
                                                e1.setO_name(sc.next() + sc.nextLine());
                                                System.out.println("Enter Brand Type: ");
                                                String brand = sc.next() + sc.nextLine();
                                                e1.setO_brand(brand);
                                                System.out.println("Enter your Prefered Shoe size: ");
                                                int size = sc.nextInt();
                                                e1.setO_size(size);
                                                System.out.println("Enter Type of Shoes:");
                                                String type = sc.next() + sc.nextLine();
                                                e1.setO_type(type);
                                                System.out.println("Enter the No of Shoes:");
                                                int count = sc.nextInt();
                                                e1.setO_no_of_shoes(count);
                                                e1.setId(I.generate_id(e1));
                                                e2 = I.search(brand);
                                                if (e2 != null) {
                                                    if (e2.getNo_of_shoes() < count) {
                                                        System.out.println("Out of Stock!");
                                                    } else if (e2.getSize() != size) {
                                                        System.out.println("The Size that your looking for is not available");
                                                    } else {
                                                        I.add(e1);
                                                        System.out.println("Your Order is placed");
                                                        e2.setNo_of_shoes(e2.getNo_of_shoes() - count);
                                                    }
                                                } else {
                                                    System.out.println("The Product does not exist");
                                                }
                                                break;
                                            case 3:
                                                condition = 0;
                                                break;
                                            default:
                                                System.out.println("Invalid Option!");
                                        }
                                    } while (condition != 0);
                                }
                            } else {
                                System.out.println("Invalid Password");
                            }
                        }
                    }
                    if (!idExists) {
                        System.out.println("Invalid ID");
                    }
                    break;
            }
        } while (condition != 3);
        System.out.println("Thank you for visiting JK Mart!");
    }
}
