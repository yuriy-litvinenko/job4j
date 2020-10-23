package ru.job4j.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoreSQL implements AutoCloseable {
    private final Config config;
    private Connection connect;
    private static final String CREATE_TABLE_SQL = String.join("",
            "create table if not exists entry(field integer)");
    private static final String ADD_VALUE_SQL = String.join("",
            "insert into entry (field) values (?)");
    private static final String DELETE_ALL_SQL = String.join("",
            "delete from entry");
    private static final String SELECT_ALL_SQL = String.join("",
            "select * from entry");

    StoreSQL(Config config) {
        this.config = config;
        this.init();
    }

    private void init() {
        try {
            connect = DriverManager.getConnection(config.get("url"));
            connect.setAutoCommit(false);
            try (Statement st = connect.createStatement()) {
                st.execute(CREATE_TABLE_SQL);
                connect.commit();
            } catch (SQLException se) {
                connect.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void generate(int size) {
        try (Statement st = connect.createStatement();
             PreparedStatement ps = connect.prepareStatement(ADD_VALUE_SQL)) {
            try {
                st.execute(DELETE_ALL_SQL);
                for (int i = 1; i <= size; i++) {
                    ps.setInt(1, i);
                    ps.addBatch();
                }
                ps.executeBatch();
                connect.commit();
            } catch (SQLException se) {
                connect.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    List<Entry> load() {
        List<Entry> result = new ArrayList<>();
        try (Statement st = connect.createStatement()) {
            ResultSet rs = st.executeQuery(SELECT_ALL_SQL);
            while (rs.next()) {
                result.add(new Entry(rs.getInt("field")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        if (connect != null) {
            connect.close();
        }
    }
}
