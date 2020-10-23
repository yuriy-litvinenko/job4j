package ru.job4j.generic;

public abstract class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> values;

    AbstractStore(int size) {
        values = new SimpleArray<>(size);
    }

    @Override
    public void add(T model) {
        values.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        for (int index = 0; index != values.length(); index++) {
            if (values.get(index).getId().equals(id)) {
                values.set(index, model);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        for (int index = 0; index != values.length(); index++) {
            if (values.get(index).getId().equals(id)) {
                values.remove(index);
                return true;
            }
        }
        return false;
    }

    @Override
    public T findById(String id) {
        for (int index = 0; index != values.length(); index++) {
            if (values.get(index).getId().equals(id)) {
                return values.get(index);
            }
        }
        return null;
    }
}
