package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.util.List;

public class Program2 {
    public static void main(String[] args) {
        DepartmentDao depDao = DaoFactory.createDepartmentDao();

        System.out.println("\n===teste numero 01===");
        List<Department> list = depDao.findAll();
        for (Department dep: list
             ) {
            System.out.println(dep);
        }

        System.out.println("\n===teste numero 02===");
        Department dep1 = depDao.findById(2);
        System.out.println(dep1);

//        System.out.println("\n===teste numero 03===");
//        depDao.deleteById(2);
//        System.out.println("Successful deletion!!");

        System.out.println("\n===teste numero 04===");
        Department dep2 = new Department(2, "bebidas");
        depDao.update(dep2);
        System.out.println("Update done!");

        System.out.println("\n===teste numero 05===");
        Department dep3 = new Department(null, "videogames");
        depDao.insert(dep3);
        System.out.println("Insertion done!");
    }
}
