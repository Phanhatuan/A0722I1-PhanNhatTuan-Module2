package ss12.Bai_tap;

import caseStudy.models.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager {
    Scanner sc = new Scanner(System.in);
    public static ArrayList<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product("cafe",1200));
        productList.add(new Product("milk tea",1000));
        productList.add(new Product("wine",3000));
    }

    public Product inputInfo(){
        System.out.print("Input name of product: ");
        String name = sc.nextLine();
        System.out.print("Input cost of drink: ");
        double cost = Double.parseDouble(sc.nextLine());
        return new Product(name,cost);
    }

    public void add(){
        Product temp = inputInfo();
        productList.add(temp);
    }

    public void display(){
        if(productList.size()==0){
            System.out.println("The list is empty");
        }
        else{
            for (Product product : productList) {
                System.out.println(product.toString());
            }
        }
    }
    public boolean checkValidId(int id){
        boolean checkValid = false;
        for (int i = 0; i < productList.size(); i++) {
            if(id == productList.get(i).getProductId()){
                checkValid = true;
                break;
            }
        }
        return checkValid;
    }
    public boolean checkValidName(String name){
        boolean checkValid = false;
        for (int i = 0; i < productList.size(); i++) {
            if(name.equals(productList.get(i).getName())){
                checkValid = true;
                break;
            }
        }
        return checkValid;
    }
    public int returnId(String name){
        int id = 0;
        for (int i = 0; i < productList.size(); i++) {
            if(name.equals(productList.get(i).getName())){
                id = productList.get(i).getProductId();
            }
        }
        return id;
    }

    public void update(){
        System.out.print("Input id product: ");
        int idTemp = Integer.parseInt(sc.nextLine());
        boolean checkValid = checkValidId(idTemp);
        if(checkValid == true){
            System.out.println("Input new product name: ");
            String name = sc.nextLine();
            productList.get(idTemp).setName(name);
            System.out.println("Input new product cost: ");
            double cost = Double.parseDouble(sc.nextLine());
            productList.get(idTemp).setCost(cost);
        }
        else{
            System.out.println("Id is not exist");
        }
    }
    public void delete(){
        System.out.print("Input id product: ");
        int idTemp = Integer.parseInt(sc.nextLine());
        boolean checkValid = checkValidId(idTemp);
        if(checkValid == true){
           productList.remove(idTemp);
        }
        else{
            System.out.println("Id is not exist");
        }
    }
    public void searchByName(){
        System.out.print("Input product name: ");
        String name = sc.nextLine();
        boolean checkValid = checkValidName(name);
        if(checkValid == true){
            int id = returnId(name);
            System.out.println("Name: " + productList.get(id).getName());
            System.out.println("Cost: " + productList.get(id).getCost());
        }
        else{
            System.out.println("Invalid name");
        }
    }

    public void sort(){
        CostComparator costComparator = new CostComparator();
        //Collections.sort(productList,Collections.reverseOrder(costComparator)); // Giảm dần
        Collections.sort(productList,costComparator); // Tang dần
        System.out.println("Sort by cost: ");
        for(Product st : productList){
            System.out.println(st.toString());
        }
    }
    public static void main(String[] args) {
        ProductManager a = new ProductManager();
        a.display();
        a.sort();

    }
}
