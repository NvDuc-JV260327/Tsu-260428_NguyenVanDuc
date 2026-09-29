package presentation;

import business.dao.BorrowCardDaoimpl;
import business.dao.IBorrowCardDao;
import business.model.BorrowCard;
import utils.InputData;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Management {
    Scanner sc = new Scanner(System.in);
    private IBorrowCardDao borrowCardDao = new BorrowCardDaoimpl();

    public void displayMenu() {
        do {
            System.out.println("""
                ================== LIBRARY MANAGEMENT ==================
                1. Danh sách tất cả phiếu mượn
                2. Thêm mới phiếu mượn
                3. Cập nhật thông tin phiếu mượn
                4. Xóa phiếu mượn
                5. Tìm kiếm phiếu mượn theo tên độc giả
                6. Tìm kiếm phiếu mượn theo tên sách
                7. Thoát
                """);
            int choice = InputData.getInt(sc, "Lựa chọn của bạn: ");

            switch (choice) {
                case 1:
                    List<BorrowCard> borrowCards = new ArrayList<>();
                    borrowCards = borrowCardDao.getAllBorrowCard();
                    if(borrowCards.size()==0){
                        System.out.println("Danh sách trống!");
                    } else {
                        borrowCards.forEach(System.out::println);
                    }
                    break;

                case 2:
                    String bookTitle = InputData.getString(sc, "Nhập tên sách: ");
                    String borrowerName = InputData.getString(sc, "Nhập tên độc giả: ");
                    Timestamp borrowerDate = InputData.getTimeStamp(sc, "Nhập thời gian mượn sách(dd/MM/yyyy HH:mm:ss)");
                    Timestamp returnDeadline = InputData.getTimeStamp(sc, "Nhập thời gian mượn sách(dd/MM/yyyy HH:mm:ss)");
                    int quantity = InputData.getInt(sc, "Nhập số lượng: ");
                    String status = InputData.getStatus(sc, "Nhập trạng thái: ");
                    borrowCardDao.addBorrowCard(new BorrowCard(null, bookTitle, borrowerName, borrowerDate, returnDeadline, quantity, status));
                    System.out.println("Thêm thành công!");
                    break;

                case 3:
                    Long updateId = InputData.getLong(sc, "Nhập id cần sửa: ");
                    for (int i = 0; i < borrowCardDao.getAllBorrowCard().size(); i++) {
                        boolean isExist = false;
                        if(borrowCardDao.getAllBorrowCard().get(i).getId() == updateId) {
                            isExist = true;
                            break;
                        }
                        if(!isExist){
                            System.out.println("Id không tồn tại!");
                        } else {
                            String newBookTitle = InputData.getString(sc, "Nhập tên sách: ");
                            String newBorrowerName = InputData.getString(sc, "Nhập tên độc giả: ");
                            Timestamp newBorrowerDate = InputData.getTimeStamp(sc, "Nhập thời gian mượn sách(dd/MM/yyyy HH:mm:ss)");
                            Timestamp newReturnDeadline = InputData.getTimeStamp(sc, "Nhập thời gian mượn sách(dd/MM/yyyy HH:mm:ss)");
                            int newQuantity = InputData.getInt(sc, "Nhập số lượng: ");
                            String newStatus = InputData.getStatus(sc, "Nhập trạng thái: ");
                            BorrowCard borrowCard = new BorrowCard(updateId, newBookTitle, newBorrowerName, newBorrowerDate, newReturnDeadline, newQuantity, newStatus);
                            borrowCardDao.updateBorrowCard(borrowCard);
                            System.out.println("Sửa thông tin thành công!");
                        }
                    }

                    break;

                case 4:
                    Long deleteId = InputData.getLong(sc, "Nhập id cần sửa: ");
                    for (int i = 0; i < borrowCardDao.getAllBorrowCard().size(); i++) {
                        boolean check = false;
                        if(borrowCardDao.getAllBorrowCard().get(i).getId() == deleteId) {
                            check = true;
                            break;
                        }
                        if(!check){
                            System.out.println("Id không tồn tại!");
                        } else {
                            String yn = InputData.getString(sc,"Nhập y để xác nhận xóa, n để hủy: ");
                            if(yn.equals("n")){
                                break;
                            } else if(yn.equals("y")){
                                borrowCardDao.deleteBorrowCard(deleteId);
                            } else {
                                System.out.println("Lựa chọn không hợp lệ!");
                            }
                        }
                    }
                    break;

                case 5:
                    String findByBorrowerName = InputData.getString(sc, "Nhập tên độc giả để tìm kiếm: ");
                    List<BorrowCard> cardByBorrowerName = new ArrayList<>();
                    cardByBorrowerName = borrowCardDao.getBorrowCardByborrowerName(findByBorrowerName);
                    if(cardByBorrowerName.size()==0){
                        System.out.println("Không có thẻ mượn nào!");
                    } else {
                        cardByBorrowerName.forEach(System.out::println);
                    }
                    break;

                case 6:

                    break;

                case 7:
                    sc.nextLine();
                    System.out.println("Kết thúc chương trình!");
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}
