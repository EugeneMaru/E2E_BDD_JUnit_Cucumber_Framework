select * from books;

select count(*) as borrowedBooks from users u
inner join book_borrow b on u.id = b.user_id where is_returned = 0;