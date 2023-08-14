package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("\n===teste numero 01===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n===teste numero 02===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);

        for (Seller obj: list
        ) {
            System.out.println(obj);
        }

        System.out.println("\n===teste numero 03===");
        List<Seller> list2 = sellerDao.findAll();

        for (Seller obj: list2
        ) {
            System.out.println(obj);
        }

        System.out.println("\n===teste numero 04===");
        Seller newSeller = new Seller(null, "greff", "greff@gmail",new Date(), 4000.00, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted new ID = " + newSeller.getId());

        System.out.println("\n===teste numero 05===");
        seller = sellerDao.findById(1);
        seller.setName("martha wayne");
        sellerDao.update(seller);
        System.out.println("Updated!!");

        System.out.println("\n===teste numero 06===");
        System.out.print("Enter the id for deletion: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        sc.close();
        System.out.println("Deletion completed!");

    }
}

