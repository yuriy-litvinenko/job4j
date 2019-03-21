package ru.job4j.department;

import org.junit.Test;

import java.util.ArrayList;

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
        ArrayList<String> result = new ArrayList<>();
        result.add("K1");
        result.add("K1\\SK1");
        result.add("K1\\SK1\\SSK1");
        result.add("K1\\SK1\\SSK2");
        result.add("K1\\SK2");
        result.add("K2");
        result.add("K2\\SK1");
        result.add("K2\\SK1\\SSK1");
        result.add("K2\\SK1\\SSK2");
        assertThat(departmentSort.sortDepsAsc(), is(result));
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
        ArrayList<String> result = new ArrayList<>();
        result.add("K2");
        result.add("K2\\SK1");
        result.add("K2\\SK1\\SSK2");
        result.add("K2\\SK1\\SSK1");
        result.add("K1");
        result.add("K1\\SK2");
        result.add("K1\\SK1");
        result.add("K1\\SK1\\SSK2");
        result.add("K1\\SK1\\SSK1");
        assertThat(departmentSort.sortDepsDesc(), is(result));
    }
}
