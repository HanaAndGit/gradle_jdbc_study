select password('1234'), length(password('1234'));
select password('Ȳ�ϳ�abcdabcdqwerqwer'), length(password('Ȳ�ϳ�asdfasdfqweorqwer'));
/* � ���ڸ� � ���̸�ŭ �ִ��� ���̴� 41*/

select password('1234') = password('12342');  