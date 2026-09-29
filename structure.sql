USE db_library_management;

CREATE TABLE borrow_cards(
    card_id SERIAL PRIMARY KEY ,
    book_title VARCHAR(150) NOT NULL ,
    borrower_name VARCHAR(100) NOT NULL ,
    borrower_date TIMESTAMP NOT NULL ,
    return_deadline TIMESTAMP NOT NULL ,
    quantity INT NOT NULL ,
    status VARCHAR(30) NOT NULL
);

DELIMITER //

CREATE PROCEDURE get_all_borrow_cards()
BEGIN
    SELECT * FROM borrow_cards;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE add_borrow_card(
    IN in_book_title VARCHAR(150),
    IN in_borrower_name VARCHAR(100),
    IN in_borrower_date TIMESTAMP,
    IN in_return_deadline TIMESTAMP,
    IN in_quantity INT,
    IN in_status VARCHAR(30)
)
BEGIN
    INSERT INTO borrow_cards(book_title, borrower_name, borrower_date, return_deadline, quantity, borrow_cards.status)
    VALUES (in_book_title, in_borrower_name, in_borrower_date, in_return_deadline, in_quantity, in_status);
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE get_borrow_card_by_borrower_name(IN in_borrower_name VARCHAR(100))
BEGIN
    SELECT * FROM borrow_cards
    WHERE borrower_name = in_borrower_name;
END //

DELIMITER ;

DELIMITER //
CREATE PROCEDURE update_borrower_card(
    IN in_card_id SERIAL,
    IN in_book_title VARCHAR(150),
    IN in_borrower_name VARCHAR(100),
    IN in_borrower_date TIMESTAMP,
    IN in_return_deadline TIMESTAMP,
    IN in_quantity INT,
    IN in_status VARCHAR(30)
)
BEGIN
    UPDATE borrow_cards
    SET
        book_title = in_book_title,
        borrower_name = in_borrower_name,
        borrower_date = in_borrower_date,
        return_deadline = in_return_deadline,
        quantity = in_quantity,
        status = in_status
    WHERE card_id = in_card_id;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE delete_borrow_card_by_id(IN delete_id SERIAL)
BEGIN
    DELETE FROM borrow_cards
    WHERE card_id = delete_id;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE find_by_book_title(IN in_book_title VARCHAR(150))
BEGIN
    SELECT * FROM borrow_cards
    WHERE book_title LIKE ('%', in_book_title, '%');
END //

DELIMITER ;