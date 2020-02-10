select password('1234'), length(password('1234'));
select password('황하나abcdabcdqwerqwer'), length(password('황하나asdfasdfqweorqwer'));
/* 어떤 글자를 어떤 길이만큼 넣더라도 길이는 41*/

select password('1234') = password('12342');  