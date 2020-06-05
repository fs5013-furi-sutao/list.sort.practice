package com.sort.list;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        // 従業員一覧を作成
        List<Employee> emps = new ArrayList<Employee>();
        emps.add(new Employee().id(1).firstName("Yamada").lastName("Taro").age(35).salary(5000));
        emps.add(new Employee().id(3).firstName("Yamamoto").lastName("Ichiro").age(15).salary(120000));
        emps.add(new Employee().id(2).firstName("Asai").lastName("Asao").age(18).salary(1000));

        System.out.println("並び替え前:");
        Employee.showAllEmpsWithProps(emps);

        System.out.println();
        System.out.println("年齢順に並び替え：");
        List<Employee> empsSortedByAgeAsc = Employee.sortByAgeAsc(emps);
        Employee.showAllEmpsWithProps(empsSortedByAgeAsc);

        
        System.out.println();
        System.out.println("名前順に並び替え：");
        List<Employee> empsSortedByNameAsc = Employee.sortByNameAsc(emps);
        Employee.showAllEmpsWithProps(empsSortedByNameAsc);

        System.out.println("並び替え前:");
        Employee.showAllEmpsWithProps(emps);
    }
}
