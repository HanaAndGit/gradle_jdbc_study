package gradle_jdbc_study.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import gradle_jdbc_study.dao.impl.DepartmentDaoImpl;
import gradle_jdbc_study.dao.impl.EmployeeDaoImpl;
import gradle_jdbc_study.dao.impl.TitleDaoImpl;
import gradle_jdbc_study.dto.Department;
import gradle_jdbc_study.dto.Employee;
import gradle_jdbc_study.dto.Title;
import gradle_jdbc_study.ui.list.DepartmentTblPanel;
import gradle_jdbc_study.ui.list.EmployeeDnoTblPanel;
import gradle_jdbc_study.ui.list.TitleTblPanel;


public class TestTableFrame {

	private static TestTableFrame testFrame;
	
	public static void main(String[] args) {
		titleTableFrame();
		DeptTableFrame();
		EmployeeDnoTableFrame();
	
	}


	private static void EmployeeDnoTableFrame() {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		etp = new EmployeeDnoTblPanel();
		frame.add(etp);
		List<Employee> list = EmployeeDaoImpl.getInstance().selectEmployeeByDno(etp.getSelectedItem());
		etp.loadData(list);
		etp.setPopupMenu(createDeptPopupMenu());
		frame.setVisible(true);
		
	}


	public static void DeptTableFrame() {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		tp = new DepartmentTblPanel();
		frame.add(tp);
		List<Department> list = DepartmentDaoImpl.getInstance().selectDepartmentByAll();
		tp.loadData(list);
		
		tp.setPopupMenu(createDeptPopupMenu());
		frame.setVisible(true);
		
	}


	public static void titleTableFrame() {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		titleP = new TitleTblPanel();
		frame.add(titleP);
		List<Title> list = TitleDaoImpl.getInstance().selectTitleByAll();
		titleP.loadData(list);
		
		titleP.setPopupMenu(createTitlePopupMenu());
		frame.setVisible(true);
	}
	
	static ActionListener myPopTitmeMenuListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("수정")) {
				Title updateTitle = new Title(1, "이사장");
				System.out.println(titleP.getSelectedRowIdx());
				titleP.updateRow(updateTitle, titleP.getSelectedRowIdx());
				
			}
			if (e.getActionCommand().equals("삭제")) {
				Title selectedDept = titleP.getSelectedItem();
				JOptionPane.showMessageDialog(null, selectedDept);
				titleP.removeRow();
			
			}
			if (e.getActionCommand().equals("추가")) {
				Title insTitle = new Title(5, "인턴");
				titleP.addItem(insTitle);
			}
			
		}
	};
	
	private static JPopupMenu createTitlePopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(myPopTitmeMenuListener);
		popMenu.add(updateItem);
		
		JMenuItem deleteItem = new JMenuItem("삭제");
		deleteItem.addActionListener(myPopTitmeMenuListener);
		popMenu.add(deleteItem);
		
		JMenuItem addItem = new JMenuItem("추가");
		addItem.addActionListener(myPopTitmeMenuListener);
		popMenu.add(addItem);
		
		return popMenu;
	}


	private static JPopupMenu createDeptPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(myPopMenuListener);
		popMenu.add(updateItem);
		
		JMenuItem deleteItem = new JMenuItem("삭제");
		deleteItem.addActionListener(myPopMenuListener);
		popMenu.add(deleteItem);
		
		JMenuItem showEmployee = new JMenuItem("소속사원");
		showEmployee.addActionListener(myPopMenuListener);
		popMenu.add(showEmployee);
		
		return popMenu;
	}
	
	static ActionListener myPopMenuListener = new ActionListener() {
		

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("수정")) {
				Department updateDept = new Department(5, "마케팅", 10);
				tp.updateRow(updateDept, tp.getSelectedRowIdx());
				
			}
			if (e.getActionCommand().equals("삭제")) {
				Department selectedDept = tp.getSelectedItem();
				JOptionPane.showMessageDialog(null, selectedDept);
				tp.removeRow();
			}
			if (e.getActionCommand().equals("소속사원")) {
				
				
			}
			
			
			
		}
	};
	private static DepartmentTblPanel tp;
	private static TitleTblPanel titleP;
	private static EmployeeDnoTblPanel etp;

	
}
