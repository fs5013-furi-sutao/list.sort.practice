package com.sort.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    private Integer getSalaryMonthly() {

        return this.salaryMonthly;
    }

    private String getAllProps() {

        return String.format("{ID:%d, 名前:%s %s, 年齢:%d, 月給:%d}", 
            this.id, this.firstName, this.lastName, this.age, this.salaryMonthly);
    }

    /**
     * 従業員リストをラムダ式で順に表示
     * @param emps 従業員リスト
     */
    public static void showAllEmpsWithProps(final List<Employee> emps) {

        emps.forEach(e -> {
            System.out.println(e.getAllProps());
        });
    }

    /**
     * 従業員リストを年齢の昇順に並べる
     * （STREAM API を使ったソート）
     * @param emps 従業員リスト
     * @return 並べ替えた従業員リスト
     */
    public static List<Employee> sortByAgeAsc(final List<Employee> emps) {

        return emps.stream().sorted((emp1, emp2) -> emp1.getAge().compareTo(emp2.getAge()))
                .collect(Collectors.toList());
    }

    /**
     * 従業員リストを名前の昇順に並べる
     * （STREAM API を使ったソート）
     * @param emps 従業員リスト
     * @return 並べ替えた従業員リスト
     */
    public static List<Employee> sortByNameAsc(final List<Employee> emps) {

        return emps.stream()
                .sorted((emp1, emp2) -> emp1.getFullName().compareTo(emp2.getFullName()))
                .collect(Collectors.toList());
    }

    /**
     * 
     * 従業員リストを月給の昇順に並べる
     * （匿名クラスでソートを実装）
     * @param emps 従業員リスト
     * @return 並べ替えた従業員リスト
     */
    public static List<Employee> sortBySalaryMonthlyAsc(final List<Employee> emps) {

        // 従業員リストの deepCopy を取得
        List<Employee> empsCopy = getDeepCopiedEmps(emps);

        Collections.sort(empsCopy, new Comparator<Employee>() {

            @Override
            public int compare(Employee emp1, Employee emp2) {
                return emp1.getSalaryMonthly().compareTo(emp2.getSalaryMonthly());
            }
        });

        return(empsCopy);
    }

    /**
     * 従業員リストの deepCopy を返却
     * @param emps 従業員リスト
     * @return deepCopyした従業員リスト
     */
     private static List<Employee> getDeepCopiedEmps(List<Employee> emps) {

         return new ArrayList<Employee>(emps);
     }
}
