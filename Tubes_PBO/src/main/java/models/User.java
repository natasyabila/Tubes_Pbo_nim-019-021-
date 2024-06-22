package models;

import java.util.Collection;

public abstract class User {
    private String id;
    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(String id, String name, String admin) {

    }

    public User() {

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract boolean canBorrowBooks();

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public abstract Object getPin();

    public abstract Collection<Object> getBooksBorrowed();

    public abstract Collection<Object> getNim();

    public Collection<Object> getProgram() {
        return null;
    }

    public Object getFaculty() {
        return null;
    }
}
