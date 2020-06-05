package com.sort.list;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 従業員一覧を作成
        List<Employee> emps = makeEmps();

        System.out.println("並び替え前:");
        out(emps);

        System.out.println();
        System.out.println("年齢順に並び替え：");
        List<Employee> empsSortedByAgeAsc = Employee.sortByAgeAsc(emps);
        out(empsSortedByAgeAsc);


        System.out.println();
        System.out.println("名前順に並び替え：");
        List<Employee> empsSortedByNameAsc = Employee.sortByNameAsc(emps);
        out(empsSortedByNameAsc);

        System.out.println();
        System.out.println("月給順に並び替え：");
        List<Employee> empsSortedBySalaryMonthlyAsc = Employee.sortBySalaryMonthlyAsc(emps);
        out(empsSortedBySalaryMonthlyAsc);

        System.out.println();
        System.out.println("並び替え前:");
        out(emps);
    }

    // 従業員一覧を作成
    private static List<Employee> makeEmps() {
        List<Employee> emps = new ArrayList<Employee>();
        emps.add(new Employee().id(1).firstName("Yamada").lastName("Taro").age(35).salary(5000));
        emps.add(new Employee().id(3).firstName("Yamamoto").lastName("Ichiro").age(15).salary(120000));
        emps.add(new Employee().id(2).firstName("Asai").lastName("Asao").age(18).salary(9000));
        return emps;
    }

    // 委譲で従業員リストを一覧表示
    private static void out(final List<Employee> emps) {
        Employee.showAllEmpsWithProps(emps);
    }
}
