import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

public class LoanManagerTest {
    private LibraryDatabase libraryDatabase;
    private LoanManager loanManager;

    @Before
    public void setUp() {
        libraryDatabase = mock(LibraryDatabase.class);
        loanManager = new LoanManager(libraryDatabase);
    }

    @Test
    public void testAddBook() {
        Book book = new Book("456", "To Kill a Mockingbird", "Harper Lee");
        loanManager.addBook(book);
        verify(libraryDatabase).saveBookData(book);
    }

    @Test
    public void testRegisterStudent() {
        Student student = new Student("789", "John Doe");
        loanManager.registerStudent(student);
        verify(libraryDatabase).saveStudentData(student);
    }

    @Test
    public void testLendBook() {
        Book book = new Book("123", "The Great Gatsby", "F. Scott Fitzgerald");
        Student student = new Student("456", "John Doe");
        when(libraryDatabase.getBookById("123")).thenReturn(book);
        when(libraryDatabase.getStudentById("456")).thenReturn(student);
        assertTrue(loanManager.lendBook("123", "456"));
        verify(libraryDatabase).saveBookData(book);
        verify(libraryDatabase).saveStudentData(student);
    }

    @Test
    public void testReceiveReturnedBook() {
        Book book = new Book("123", "The Great Gatsby", "F. Scott Fitzgerald");
        Student student = new Student("456", "John Doe");
        student.borrowBook(book);
        when(libraryDatabase.getBookById("123")).thenReturn(book);
        when(libraryDatabase.getStudentById("456")).thenReturn(student);
        loanManager.receiveReturnedBook("123", "456");
        verify(libraryDatabase).saveBookData(book);
        verify(libraryDatabase).saveStudentData(student);
    }

    @Test
    public void testGetBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("123", "The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book("456", "To Kill a Mockingbird", "Harper Lee"));
        when(libraryDatabase.getBooks()).thenReturn(books);
        assertEquals(books, loanManager.getBooks());
    }

    @Test
    public void testGetStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("789", "John Doe"));
        students.add(new Student("012", "Jane Smith"));
        when(libraryDatabase.getStudents()).thenReturn(students);
        assertEquals(students, loanManager.getStudents());
    }
}






