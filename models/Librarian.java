package models;

import java.util.Collection;

public class Librarian extends User {
    public Librarian(String id, String name) {
        super(id, name);
    }

    @Override
    public boolean canBorrowBooks() {
        return true; // Librarians have no borrow limits
    }

    /**
     * @return 
     */
    @Override
    public Object getPin() {
        return null;
    }

    /**
     * @return 
     */
    @Override
    public Collection<Object> getBooksBorrowed() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Collection<Object> getNim() {
        return null;
    }
}
