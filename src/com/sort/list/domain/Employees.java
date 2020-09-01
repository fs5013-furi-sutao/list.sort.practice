package com.sort.list.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 従業員リスト（ファーストクラスコレクション）
 */
final public class Employees {

    private List<Employee> emps;

    public Employees() {
        
        this.emps = new ArrayList<Employee>();
    }

    private Employees(List<Employee> emps) {

        this.emps = emps;
    }

    public void add(Employee emp) {

        this.emps.add(emp);
    }

    /**
     * 従業員リストをメソッド参照で順に表示
     */
    public void showAllEmpsWithProps() {

        this.emps.forEach(System.out::println);
    }

    /**
     * 従業員リストを年齢の昇順に並べる （Stream API を使ったソート）
     * @return 並べ替えた従業員リスト
     */
    public Employees sortByAgeAsc() {

        List<Employee> retEmps =
                this.emps.stream().sorted((emp1, emp2) -> emp1.getAge().compareTo(emp2.getAge()))
                        .collect(Collectors.toList());

        return new Employees(retEmps);
    }

    /**
     * 従業員リストを名前の昇順に並べる （Stream API を使ったソート）
     * @return 並べ替えた従業員リスト
     */
    public Employees sortByNameAsc() {

        List<Employee> retEmps = this.emps.stream()
                .sorted((emp1, emp2) -> emp1.getFullName().compareTo(emp2.getFullName()))
                .collect(Collectors.toList());

        return new Employees(retEmps);
    }

    /**
     * 
     * 従業員リストを月給の昇順に並べる （匿名クラスでソートを実装）
     * @return 並べ替えた従業員リスト
     */
    public Employees sortBySalaryMonthlyAsc() {

        // 従業員リストの deepCopy を取得
        List<Employee> empsCopy = getDeepCopiedEmps();

        // 匿名クラス
        Collections.sort(empsCopy, new Comparator<Employee>() {

            @Override
            public int compare(Employee emp1, Employee emp2) {
                return emp1.getSalaryMonthly().compareTo(emp2.getSalaryMonthly());
            }
        });

        return new Employees(empsCopy);
    }

    /**
     * 従業員リストの deepCopy を返却
     * @return deepCopyした従業員リスト
     */
    private List<Employee> getDeepCopiedEmps() {

        return new ArrayList<Employee>(this.emps);
    }
}
