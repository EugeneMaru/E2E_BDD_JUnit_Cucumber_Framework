select * from books;

select count(*) as borrowedBooks from users u
inner join book_borrow b on u.id = b.user_id where is_returned = 0;

select count(*) as Total_Number_Of_Librarian from users
where user_group_id = 2 and status = 'Active';

select count(*) as borrowedBooks from users u
inner join book_borrow b on u.id = b.user_id where is_returned = 0;

select bc.name,count(*) from book_borrow bb
                                 inner join books b on bb.book_id = b.id
                                 inner join book_categories bc on b.book_category_id = bc.id
                                 group by bc.name
                                 order by 2 desc;
