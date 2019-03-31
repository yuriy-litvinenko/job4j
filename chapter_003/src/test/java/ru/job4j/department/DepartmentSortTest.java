package ru.job4j.department;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DepartmentSortTest {
    @Test
    public void sortDepsAsc() {
        DepartmentSort departmentSort = new DepartmentSort();
        departmentSort.addDepartment("K1\\SK1");
        departmentSort.addDepartment("K1\\SK2");
        departmentSort.addDepartment("K1\\SK1\\SSK1");
        departmentSort.addDepartment("K1\\SK1\\SSK2");
        departmentSort.addDepartment("K2");
        departmentSort.addDepartment("K2\\SK1\\SSK1");
        departmentSort.addDepartment("K2\\SK1\\SSK2");
        ArrayList<String> result = new ArrayList<>(departmentSort.sortDepsAsc());
        List<String> expect = List.of(
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        );
        assertThat(result, is(expect));
    }

    @Test
    public void sortDepsDesc() {
        DepartmentSort departmentSort = new DepartmentSort();
        departmentSort.addDepartment("K1\\SK1");
        departmentSort.addDepartment("K1\\SK2");
        departmentSort.addDepartment("K1\\SK1\\SSK1");
        departmentSort.addDepartment("K1\\SK1\\SSK2");
        departmentSort.addDepartment("K2");
        departmentSort.addDepartment("K2\\SK1\\SSK1");
        departmentSort.addDepartment("K2\\SK1\\SSK2");
        ArrayList<String> result = new ArrayList<>(departmentSort.sortDepsDesc());
        List<String> expect = List.of(
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"
        );
                assertThat(result, is(expect));
    }
}
