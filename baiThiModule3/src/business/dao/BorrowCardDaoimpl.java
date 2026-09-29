package business.dao;

import business.model.BorrowCard;
import utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowCardDaoimpl implements IBorrowCardDao {
    @Override
    public List<BorrowCard> getAllBorrowCard() {
        List<BorrowCard> borrowCardList = new ArrayList<>();
        Connection connection = ConnectionDB.openConnection();

        try {
            CallableStatement call = connection.prepareCall("{call get_all_borrow_cards}");
            ResultSet result = call.executeQuery();
            while (result.next()) {
                BorrowCard borrowCard = new BorrowCard(
                        result.getLong("card_id"),
                        result.getString("book_title"),
                        result.getString("borrower_name"),
                        result.getTimestamp("borrow_date"),
                        result.getTimestamp("return_deadline"),
                        result.getInt("quantity"),
                        result.getString("status")
                );
                borrowCardList.add(borrowCard);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return borrowCardList;
    }

    @Override
    public void addBorrowCard(BorrowCard borrowCard) {
        Connection connection = ConnectionDB.openConnection();

        try {
            CallableStatement call = connection.prepareCall("{call add_borrow_card(?,?,?,?,?,?)}");
                call.setString(1, borrowCard.getBookTitle());
                call.setString(2, borrowCard.getBorrowerName());
                call.setTimestamp(3, borrowCard.getBorrowDate());
                call.setTimestamp(4, borrowCard.getReturnDeadline());
                call.setInt(5, borrowCard.getQuantity());
                call.setString(6, borrowCard.getStatus());
                call.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    @Override
    public List<BorrowCard> getBorrowCardByborrowerName(String borrowerName) {
        List<BorrowCard> borrowCardByborrowerName = new ArrayList<>();
        Connection connection = ConnectionDB.openConnection();

        try {
            CallableStatement call = connection.prepareCall("{call get_borrow_card_by_borrower_name}");
            ResultSet result = call.executeQuery();
            while (result.next()) {
                BorrowCard borrowCard = new BorrowCard(
                        result.getLong("card_id"),
                        result.getString("book_title"),
                        result.getString("borrower_name"),
                        result.getTimestamp("borrow_date"),
                        result.getTimestamp("return_deadline"),
                        result.getInt("quantity"),
                        result.getString("status")
                );
                borrowCardByborrowerName.add(borrowCard);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return borrowCardByborrowerName;
    }

    @Override
    public void updateBorrowCard(BorrowCard borrowCard) {
        Connection connection = ConnectionDB.openConnection();

        try {
            CallableStatement call = connection.prepareCall("{call update_borrower_card(?,?,?,?,?,?,?)}");
            call.setLong(1, borrowCard.getId());
            call.setString(2, borrowCard.getBookTitle());
            call.setString(3, borrowCard.getBorrowerName());
            call.setTimestamp(4, borrowCard.getBorrowDate());
            call.setTimestamp(5, borrowCard.getReturnDeadline());
            call.setInt(6, borrowCard.getQuantity());
            call.setString(7, borrowCard.getStatus());
            call.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    @Override
    public void deleteBorrowCard(Long borrowCardId) {
        Connection connection = ConnectionDB.openConnection();

        try {
            CallableStatement call = connection.prepareCall("{call delete_borrow_card_by_id(?)}");
            call.setLong(1, borrowCardId);
            call.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    @Override
    public List<BorrowCard> getBorrowCardByBookName(String bookName) {
        List<BorrowCard> BorrowCardByBookName = new ArrayList<>();
        Connection connection = ConnectionDB.openConnection();

        try {
            CallableStatement call = connection.prepareCall("{call find_by_book_title}");
            ResultSet result = call.executeQuery();
            while (result.next()) {
                BorrowCard borrowCard = new BorrowCard(
                        result.getLong("card_id"),
                        result.getString("book_title"),
                        result.getString("borrower_name"),
                        result.getTimestamp("borrow_date"),
                        result.getTimestamp("return_deadline"),
                        result.getInt("quantity"),
                        result.getString("status")
                );
                BorrowCardByBookName.add(borrowCard);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return BorrowCardByBookName;
    }
}
