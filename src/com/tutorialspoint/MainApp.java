package com.tutorialspoint;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

      StudentDAO studentDAO = 
         (StudentDAO)context.getBean("studentJDBCTemplate");
     
      System.out.println("------Records Creation--------" );
      studentDAO.create("Zara", 11);
      studentDAO.create("Nuha", 2);
      studentDAO.create("Ayan", 15);

      System.out.println("------Listing Multiple Records--------" );
      List<Student> students = studentDAO.listStudents();
      
      for (Student record : students) {
         System.out.print("ID : " + record.getId() );
         System.out.print(", Name : " + record.getName() );
         System.out.println(", Age : " + record.getAge());
      }

      System.out.println("----Updating Record with ID = 2 -----" );
      studentDAO.update(2, 20);

      System.out.println("----Listing Record with ID = 2 -----" );
      Student student = studentDAO.getStudent(2);
      System.out.print("ID : " + student.getId() );
      System.out.print(", Name : " + student.getName() );
      System.out.println(", Age : " + student.getAge());

   }
}