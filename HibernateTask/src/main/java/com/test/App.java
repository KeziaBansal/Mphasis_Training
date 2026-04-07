package com.test;

public class App {

    public static void main(String[] args) {

        DemoService service = new DemoService();

        service.insertData();

        System.out.println("\n=== HQL ===");
        service.getAllUsingHQL().forEach(p -> System.out.println(p.getName()));

        System.out.println("\n=== Criteria ===");
        service.getByNameUsingCriteria("Alice").forEach(p -> System.out.println(p.getName()));

        System.out.println("\n=== Named Query ===");
        service.getUsingNamedQuery().forEach(p -> System.out.println(p.getName()));
    }
}
