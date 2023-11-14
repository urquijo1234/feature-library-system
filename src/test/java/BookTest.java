import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;


public class BookTest {
    private Book book;

    @Before
    public void setUp() {
        book = new Book("123", "The Great Gatsby", "F. Scott Fitzgerald");
    }

    @Test
    public void testBookConstructor() {
        assertEquals("123", book.getId());
        assertEquals("The Great Gatsby", book.getTitle());
        assertEquals("F. Scott Fitzgerald", book.getAuthor());
        assertTrue(book.isAvailable());
    }

    @Test
    public void testMarkAsUnavailable() {
        book.markAsUnavailable();
        assertFalse(book.isAvailable());
    }

    @Test
    public void testMarkAsAvailable() {
        book.markAsUnavailable();
        book.markAsAvailable();
        assertTrue(book.isAvailable());
    }

    @Test
    public void testGetId() {
        assertEquals("123", book.getId());
    }

    @Test
    public void testIsAvailable() {
        assertTrue(book.isAvailable());
    }
}


