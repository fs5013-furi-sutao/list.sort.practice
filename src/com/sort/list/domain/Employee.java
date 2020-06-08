package com.sort.list.domain;

/**
 * 従業員クラス（ドメインオブジェクト）
 */
public class Employee {
    private int id; // ID
    private String firstName; // 姓
    private String lastName; // 名
    private int age; // 年齢
    private int salaryMonthly; // 月給

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
     * getter を用意 
     * アクセス修飾子を付けないことで、パッケージ内からしかアクセスできないようにする
     */

    Integer getAge() {
        return this.age;
    }

    String getFullName() {

        return this.firstName + this.lastName;
    }

    Integer getSalaryMonthly() {

        return this.salaryMonthly;
    }

    @Override
    public String toString() {

        return String.format("{ID:%d, 名前:%s %s, 年齢:%d, 月給:%d}", this.id, this.firstName,
                this.lastName, this.age, this.salaryMonthly);
    }
}
