-- �׷��̵�_������Ʈ
DROP SCHEMA gradle_jdbc;

-- �׷��̵�_������Ʈ
CREATE SCHEMA gradle_jdbc;

-- ��å
CREATE TABLE gradle_jdbc.title (
	title_no   INTEGER     NOT NULL COMMENT '��å��ȣ', -- ��å��ȣ
	title_name VARCHAR(20) NOT NULL COMMENT '��å��' -- ��å��
)
COMMENT '��å';

-- ��å
ALTER TABLE gradle_jdbc.title
	ADD CONSTRAINT PK_title -- ��å �⺻Ű
		PRIMARY KEY (
			title_no -- ��å��ȣ
		);

-- �μ�
CREATE TABLE gradle_jdbc.department (
	dept_no   INTEGER     NOT NULL COMMENT '�μ���ȣ', -- �μ���ȣ
	dept_name VARCHAR(20) NULL     COMMENT '�μ���', -- �μ���
	floor     INTEGER     NULL     COMMENT '��ġ' -- ��ġ
)
COMMENT '�μ�';

-- �μ�
ALTER TABLE gradle_jdbc.department
	ADD CONSTRAINT PK_department -- �μ� �⺻Ű
		PRIMARY KEY (
			dept_no -- �μ���ȣ
		);

-- ���
CREATE TABLE gradle_jdbc.employee (
	emp_no   INTEGER            NOT NULL COMMENT '�����ȣ', -- �����ȣ
	emp_name VARCHAR(20)        NULL     COMMENT '�����', -- �����
	title    INTEGER            NULL     COMMENT '��å', -- ��å
	salary   INTEGER            NULL     COMMENT '�޿�', -- �޿�
	pic      VARBINARY          NULL     COMMENT '�������', -- �������
	manager  INTEGER            NULL     COMMENT '���ӻ��', -- ���ӻ��
	pass     CHAR(41)           NULL     COMMENT '��й�ȣ', -- ��й�ȣ
	id       <������ Ÿ�� ����> NULL     COMMENT 'id', -- id
	dept_no  INTEGER            NULL     COMMENT '�μ���ȣ' -- �μ���ȣ
)
COMMENT '���';

-- ���
ALTER TABLE gradle_jdbc.employee
	ADD CONSTRAINT PK_employee -- ��� �⺻Ű
		PRIMARY KEY (
			emp_no -- �����ȣ
		);

-- ���
ALTER TABLE gradle_jdbc.employee
	ADD CONSTRAINT FK_title_TO_employee -- ��å -> ���
		FOREIGN KEY (
			title -- ��å
		)
		REFERENCES gradle_jdbc.title ( -- ��å
			title_no -- ��å��ȣ
		);

-- ���
ALTER TABLE gradle_jdbc.employee
	ADD CONSTRAINT FK_department_TO_employee -- �μ� -> ���
		FOREIGN KEY (
			dept_no -- �μ���ȣ
		)
		REFERENCES gradle_jdbc.department ( -- �μ�
			dept_no -- �μ���ȣ
		);