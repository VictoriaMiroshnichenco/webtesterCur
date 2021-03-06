INSERT INTO public."user" VALUES
	(1, 'ivanov', 'ivnov@fake.net', '111', 'Ivanov Ivan', TRUE, now(), NULL),
	(2, 'petrov', 'petrov@fake.net', '222', 'Petrov Ivan', TRUE, now(), NULL),
	(3, 'sidorov', 'sidorov@fake.net', '333', 'Sidorov Ivan', FALSE, now(), NULL),
	(4, 'petrenko', 'petrenko@fake.net', '444', 'Petrenko Ivan', TRUE, now(), NULL),
	(5, 'ivanenko', 'ivanenko@fake.net', '555', 'Ivanenko Ivan', TRUE, now(), NULL),
	(6, 'sidorenko', 'sidorenko@fake.net', '666', 'Sidorenko Ivan', TRUE, now(), NULL),
	(7, 'shutov', 'shutov@fake.net', '777', 'Shutov Ivan', FALSE, now(), NULL),
	(8, 'abram', 'abram@fake.net', '888', 'Abram Ivan', TRUE, now(), NULL),
	(9, 'admin', 'admin@fake.net', 'admin', 'Admin', TRUE, now(), NULL),
	(10, 'bykov', 'bykov@gmail.com', '123456', 'Bykov Ievgen', FALSE, now(), NULL);

    INSERT INTO public."role" VALUES
	(1, 'student'),
	(2, 'tutor'),
	(3, 'advanced tutor'),
	(4, 'administrator');

    INSERT INTO public."user_role" VALUES
	(1, 1, 1),
	(2, 2, 2),
	(3, 3, 3),
	(4, 4, 3),
	(5, 5, 1),
	(6, 6, 1),
	(7, 7, 1),
	(8, 8, 2),
	(9, 9, 4);

    INSERT INTO public."test" VALUES
	(1, 10, 'Java Assessment Test 1', 'Assessment test for Java Beginners 1', 120, TRUE, now(), NULL),
	(2, 3, 'Java Assessment Test 2', 'Assessment test for Java Beginners 2', 120, TRUE, now(), now()),
	(3, 4, 'Java Assessment Test 3', 'Assessment test for Java Beginners 3', 120, TRUE, now(), NULL);

    INSERT INTO public."question" VALUES
	(1, 1, 'Which statement(s) are true? (Choose all that apply.)', TRUE, now(), NULL),
	(2, 1, 'Given:
2. public class Bunnies {
3. static int count = 0;
4. Bunnies() {
5. while(count < 10) new Bunnies(++count);
6. }
7. Bunnies(int x) { super(); }
8. public static void main(String[] args) {
9. new Bunnies();
10. new Bunnies(count);
11. System.out.println(count++);
12. }
13. }
What is the result?', TRUE, now(), NULL),
(3, 1, 'Given:
2. class Feline { }
3. public class BarnCat2 extends Feline {
4. public static void main(String[] args) {
5. Feline ff = new Feline();
6. BarnCat2 b = new BarnCat2();
7. // insert code here
8. }
9. }
Which, inserted independently at line 7, compile? (Choose all that apply.)', TRUE, now(), now());


INSERT INTO public."answer" VALUES
	(1, 1, 'Coupling is the OO principle most closely associated with hiding a class�s implementation details.', FALSE, TRUE, now(), NULL),
	(2, 1, 'Coupling is the OO principle most closely associated with making sure classes know about other classes only through their APIs.', TRUE, TRUE, now(), NULL),
	(3, 1, 'Coupling is the OO principle most closely associated with making sure a class is designed with a single, well-focused purpose.', FALSE, TRUE, now(), now()),
	(4, 1, 'Coupling is the OO principle most closely associated with allowing a single object to be seen as having many types.', FALSE, TRUE, now(), NULL),
	(5, 2, '9', FALSE, TRUE, now(), NULL),
	(6, 2, '10', TRUE, TRUE, now(), NULL),
	(7, 2, '11', FALSE, TRUE, now(), NULL),
	(8, 2, '12', FALSE, TRUE, now(), NULL),
	(9, 2, 'Compilation fails.', FALSE, TRUE, now(), NULL),
	(10, 2, 'An exception is thrown at runtime.', FALSE, TRUE, now(), NULL),
	(11, 3, 'if(b instanceof ff) System.out.print("1 ");', FALSE, TRUE, now(), NULL),
	(12, 3, 'if(b.instanceof(ff)) System.out.print("2 ");', FALSE, TRUE, now(), NULL),
	(13, 3, 'if(b instanceof Feline) System.out.print("3 ");', TRUE, TRUE, now(), NULL),
	(14, 3, 'if(b instanceOf Feline) System.out.print("4 ");', FALSE, TRUE, now(), NULL),
	(15, 3, 'if(b.instanceof(Feline)) System.out.print("5 ");', FALSE, TRUE, now(), NULL);

   /* CREATE TABLE public.result (
    id_result bigint NOT NULL,
    id_student bigint NOT NULL,
    id_test bigint,
    result varchar(30) NOT NULL,
    created timestamp(0) without time zone DEFAULT now() NOT NULL,
    comment text);*/

    INSERT INTO public."result" VALUES
	(1, 1, 1, '1 correct of 3 total', now(), ''),
	(2, 5, 1, '2 correct of 3 total', now(), ''),
	(3, 6, 2, '3 correct of 3 total', now(), ''),
	(4, 7, 2, '6 correct of 7 total', now(), ''),
	(5, 7, 3, '4 correct of 5 total', now(), ''),
	(6, 7, 3, '5 correct of 9 total', now(), '');

    INSERT INTO public."user_registration" VALUES
	(1, 'Some hash 1'),
	(2, 'Some hash 2'),
	(3, 'Some hash 3'),
	(4, 'Some hash 4'),
	(5, 'Some hash 5'),
	(6, 'Some hash 6'),
	(7, 'Some hash 7'),
	(8, 'Some hash 8'),
	(9, 'Some hash 9'),
	(10, 'Some hash 10');

    commit
	