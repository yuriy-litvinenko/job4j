package ru.job4j.tracker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrackerSQL implements ITracker, AutoCloseable {
    private final Connection connection;
    private static final String CREATE_TABLE_SQL = String.join("",
            "create table if not exists items(",
            "id serial primary key, ",
            "name varchar(2000), ",
            "description varchar(2000), ",
            "create_date timestamptz)");
    private static final String ADD_VALUE_SQL = String.join("",
            "insert into items (name, description, create_date) ",
            "values (?, ?, current_timestamp)");
    private static final String SELECT_BY_ID_SQL = String.join("",
            "select * from items where id = ?");
    private static final String SELECT_BY_NAME_SQL = String.join("",
            "select * from items where name = ?");
    private static final String SELECT_ALL_SQL = String.join("",
            "select * from items");
    private static final String DELETE_BY_ID_SQL = String.join("",
            "delete from items where id = ?");
    private static final String REPLACE_VALUE_SQL = String.join("",
            "update items set name = ?, description = ? where id = ?");

    TrackerSQL(Connection connection) {
        this.connection = connection;
    }

    boolean prepare() {
        try (Statement st = connection.createStatement()) {
            st.execute(CREATE_TABLE_SQL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement ps = connection.prepareStatement(ADD_VALUE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getName());
            ps.setString(2, item.getDescription());
            ps.executeUpdate();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getString(1));
                    return item;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Could not create new item");
    }

    @Override
    public boolean replace(String id, Item item) {
        try (PreparedStatement ps = connection.prepareStatement(REPLACE_VALUE_SQL)) {
            ps.setString(1, item.getName());
            ps.setString(2, item.getDescription());
            ps.setInt(3, Integer.valueOf(id));
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean delete(String id) {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_BY_ID_SQL)) {
            ps.setInt(1, Integer.valueOf(id));
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List<Item> getAll() {
        List<Item> result = new ArrayList<>();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(SELECT_ALL_SQL);
            while (rs.next()) {
                result.add(new Item(
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getTimestamp("create_date").getTime()
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_BY_NAME_SQL)) {
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new Item(
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getTimestamp("create_date").getTime()
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Item findById(String id) {
        Item result = null;
        try (PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, Integer.valueOf(id));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = new Item(
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getTimestamp("create_date").getTime()
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
