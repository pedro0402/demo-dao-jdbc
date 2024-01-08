package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: ===");
		Department dep = departmentDao.findById(2);
		System.out.println(dep);
		
		System.out.println("=== TEST 2: ===");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}
		
		//System.out.println("=== TEST 3: ===");
		//Department newDep = new Department(null, "Music");
		//departmentDao.insert(newDep);
		//System.out.println("inserted! new department: " + newDep.getName());
		
		System.out.println("=== TEST 4: ===");
		Department dep2 = departmentDao.findById(6);
		dep2.setName("Movies");
		departmentDao.update(dep2);
		System.out.println("update completed!");
		
		System.out.println("=== TEST 5: ===");
		System.out.print("enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("completed delete!");
		
		sc.close();
	}

}
