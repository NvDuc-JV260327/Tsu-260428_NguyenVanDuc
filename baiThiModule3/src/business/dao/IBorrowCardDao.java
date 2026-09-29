package business.dao;

import business.model.BorrowCard;

import java.util.List;

public interface IBorrowCardDao {
    List<BorrowCard> getAllBorrowCard();
    void addBorrowCard(BorrowCard borrowCard);
    List<BorrowCard> getBorrowCardByborrowerName(String borrowerName);
    void updateBorrowCard(BorrowCard borrowCard);
    void deleteBorrowCard(Long borrowCardId);
    List<BorrowCard> getBorrowCardByBookName(String bookName);
}
