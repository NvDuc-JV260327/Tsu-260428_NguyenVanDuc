package business.model;

import java.sql.Timestamp;

public class BorrowCard {
    private Long id;
    private String bookTitle;
    private String borrowerName;
    private Timestamp borrowDate;
    private Timestamp returnDeadline;
    private int quantity;
    private String status;

    public BorrowCard() {
    }

    public BorrowCard(Long id, String bookTitle, String borrowerName, Timestamp borrowDate, Timestamp returnDeadline, int quantity, String status) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.borrowerName = borrowerName;
        this.borrowDate = borrowDate;
        this.returnDeadline = returnDeadline;
        this.quantity = quantity;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public Timestamp getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Timestamp borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Timestamp getReturnDeadline() {
        return returnDeadline;
    }

    public void setReturnDeadline(Timestamp returnDeadline) {
        this.returnDeadline = returnDeadline;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BorrowCard{" +
                "id=" + id +
                ", bookTitle='" + bookTitle + '\'' +
                ", borrowerName='" + borrowerName + '\'' +
                ", borrowDate=" + borrowDate +
                ", returnDeadline=" + returnDeadline +
                ", quantity=" + quantity +
                ", status='" + status + '\'' +
                '}';
    }
}
