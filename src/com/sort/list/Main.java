package com.sort.list;

import com.sort.list.domain.Employee;
import com.sort.list.domain.Employees;

public class Main {
    public static void main(String[] args) {

        // 従業員一覧を作成
        Employees emps = makeEmps();

        br();
        System.out.println("並び替え前:");
        out(emps);

        br();
        System.out.println("年齢順：");
        out(emps.sortByAgeAsc());

        br();
        System.out.println("名前順：");
        out(emps.sortByNameAsc());

        br();
        System.out.println("月給順：");
        out(emps.sortBySalaryMonthlyAsc());

        br();
        System.out.println("並び替え前:");
        out(emps);

        br();
    }

    // 従業員一覧を作成
    private static Employees makeEmps() {

        Employees emps = new Employees();
        emps.add(new Employee().id(1).firstName("Yamada").lastName("Taro").age(35).salary(5000));
        emps.add(new Employee().id(3).firstName("Yamamoto").lastName("Ichiro").age(15).salary(120000));
        emps.add(new Employee().id(2).firstName("Asai").lastName("Asao").age(18).salary(9000));

        return emps;
    }

    // 委譲で従業員リストを一覧表示
    private static void out(final Employees emps) {

        emps.showAllEmpsWithProps();
    }

    // 改行表示
    private static void br() {

        System.out.println();
    }
}
