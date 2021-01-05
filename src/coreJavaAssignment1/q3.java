package coreJavaAssignment1;

import java.util.Scanner;

class Book {
    private String book_title = "m";
    private Double book_price = 0.0;

    public String getTitle() {
        return book_title;
    }

    public Double getPrice() {
        return book_price;
    }


    public void setPrice(Double book_price) {
        this.book_price = book_price;
    }

    public void setTitle(String book_title) {
        this.book_title = book_title;
    }
}

public class q3 {
    public static Scanner in = new Scanner(System.in);

    public static void createBooks(Book[] b, int n) {

        for (int i = 0; i < n; i++) {
            Book book = new Book();
            in.nextLine();
            book.setTitle(in.nextLine());
            book.setPrice(in.nextDouble());
            b[i] = book;
        }
    }

    public static void showBooks(Book[] b, int n) {
        String titleHeader = "Book Title", priceHeader = "Price";
        System.out.printf("%-20s %s\n", titleHeader, priceHeader);

        for (int i = 0; i < n; i++) {
            System.out.printf("%-20s %f\n", b[i].getTitle(), b[i].getPrice());
        }
    }

    public static void main(String[] args) {

        System.out.println("enter number of books : ");
        int n = in.nextInt();
        Book[] books = new Book[n];

        createBooks(books, n);
        showBooks(books, n);

    }
}
