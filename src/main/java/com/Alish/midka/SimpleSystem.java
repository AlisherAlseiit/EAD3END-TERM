//package com.Alish.midka;
//
//import com.Alish.midka.Dao.product.ProductDao;
//import com.Alish.midka.Dao.user.UserDao;
//import com.Alish.midka.config.SpringConfig;
//import com.Alish.midka.controller.LoginController;
//import com.Alish.midka.controller.ProductController;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class SimpleSystem {
//    private static Boolean bool = true;
//    private static Boolean userBool = true;
//    private static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
//
//    public static void main(String[] args) throws IOException {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
//                SpringConfig.class
//        );
//
//        ProductController productController = context.getBean("productController", ProductController.class);
//        LoginController loginController = context.getBean("loginController", LoginController.class);
//
//        System.out.println("WELCOME TO MY APPLICATION");
//        System.out.println("1. To Login as a ADMIN");
//        System.out.println("2. To Login as an User");
//        System.out.println("3. To Register as an User");
//        String adminOrUser = read.readLine();
//
//
//        if (adminOrUser.equals("1")) {
//
//
//            if (loginController.adminLogin()) {
//
//                System.out.println("WELCOME BACK ADMIN:");
//
//                while (bool) {
//                    System.out.println("1. To Return all Products");
//                    System.out.println("2. To return 1 Product ");
//                    System.out.println("3. To update product");
//                    System.out.println("4. to Add new product");
//                    System.out.println("5. To delete product");
//                    System.out.println("0. To Quit");
//                    String choice = read.readLine();
//
//                    switch (choice) {
//                        case "1":
//                            productController.showAll();
//                            break;
//                        case "2":
//                            productController.showOne();
//                            break;
//                        case "3":
//                            productController.updateProduct();
//                            break;
//                        case "4":
//                            productController.addProduct();
//                            break;
//                        case "5":
//                            productController.deleteProduct();
//                            break;
//                        default:
//                            bool = false;
//
//
//                    }
//                }
//            } else
//                System.out.println("WRONG NAME OR PASSWORD");
//
//        } else if (adminOrUser.equals("2")) {
//
//
//            if (loginController.userLogin()) {
//
//                System.out.println("HELLO USER");
//
//                while (userBool) {
//                    System.out.println("1. To Return all Products");
//                    System.out.println("2. To Buy product");
//                    System.out.println("0. To Quit");
//                    String choice = read.readLine();
//
//                    switch (choice) {
//                        case "1":
//                            productController.showAll();
//                            break;
//                        case "2":
//                            loginController.buyProduct();
//                            break;
//                        default:
//                            userBool = false;
//                    }
//                }
//
//            } else
//                System.out.println("WRONG NAME OR PASSWORD");
//
//        } else if (adminOrUser.equals("3")) {
//            loginController.userRegister();
//        } else
//            System.out.println("exit");
//        return;
//
//
//    }
//}
