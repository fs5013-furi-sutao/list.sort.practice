package com.sort.list;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 従業員クラス
 */
public class Employee {
    private int id; // ID
    private String firstName; // 姓
    private String lastName; // 名
    private int age; // 年齢
    private int salaryMonthly; // 給与

    public Employee() {
        this.id = 0;
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        this.salaryMonthly = 0;
    }

    /* 
    * 自身のインスタンスを返す setter をプロパティごとに用意 
    */

    public Employee id(int id) {
        this.id = id;
        return this;
    }

    public Employee firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Employee lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Employee age(int age) {
        this.age = age;
        return this;
    }

    public Employee salary(int salary) {
        this.salaryMonthly = salary;
        return this;
    }

    /* 
    * private getter を用意
    */

    private Integer getAge() {
        return this.age;
    }

    private String getFullName() {

        return this.firstName + this.lastName;
    }

    private String getAllProps() {

        return String.format("{ID:%d, 名前:%s %s, 年齢:%d, 月給:%d}", 
            this.id, this.firstName, this.lastName, this.age, this.salaryMonthly);
    }

    /**
     * 従業員リストを順に表示
     * @param emps 従業員リスト
     */
    public static void showAllEmpsWithProps(List<Employee> emps) {

        emps.forEach(e -> {
            System.out.println(e.getAllProps());
        });
    }

    /**
     * 従業員リストを年齢の昇順に並べる
     * @param emps 従業員リスト
     * @return 並べ替えた従業員リスト
     */
    public static List<Employee> sortByAgeAsc(List<Employee> emps) {

        return emps.stream().sorted((emp1, emp2) -> emp1.getAge().compareTo(emp2.getAge()))
                .collect(Collectors.toList());
    }

    /**
     * 従業員リストを名前の昇順に並べる
     * @param emps 従業員リスト
     * @return 並べ替えた従業員リスト
     */
    public static List<Employee> sortByNameAsc(List<Employee> emps) {

        return emps.stream()
                .sorted((emp1, emp2) -> emp1.getFullName().compareTo(emp2.getFullName()))
                .collect(Collectors.toList());
    }
}
