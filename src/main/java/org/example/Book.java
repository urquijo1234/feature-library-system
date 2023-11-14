package org.example;

public class Book {
    private String id;
    private String title;
    private String author;
    private boolean isAvailable;

    public <String> Book(String id, String title, String author) {
        this.id = (java.lang.String) id;
        this.title = (java.lang.String) title;
        this.author = (java.lang.String) author;
        this.isAvailable = true;
    }

    // Getters and setters


    // ...

    // Additional methods
    public void markAsUnavailable() {
        this.isAvailable = false;
    }

    public void markAsAvailable() {
        this.isAvailable = true;
    }

    public String getId() {
        return id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
