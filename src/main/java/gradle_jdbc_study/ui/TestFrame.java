package gradle_jdbc_study.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gradle_jdbc_study.dto.Title;
import gradle_jdbc_study.ui.content.TitlePanel;
import gradle_jdbc_study.ui.service.DepartmentUIService;

public class TestFrame {

	public static void main(String[] args) {
		//contentPanelTest();
		
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		DepartmentPanelUI tp = new DepartmentPanelUI();
		frame.add(tp);
		frame.setVisible(true);
		
	}

	private static void contentPanelTest() {
		JFrame frame = new JFrame();
		TitlePanel tp = new TitlePanel();
		frame.add(tp);
		
		
		JButton btn1 = new JButton("Ȯ��");
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Title title = tp.getItem();
				JOptionPane.showMessageDialog(null, title);
				
			}
		});

		JButton btn2 = new JButton("���");
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tp.clearTf();
			}
		});
		
		
		JButton btn3 = new JButton("�߰�");
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Title t = new Title(2, "����");
				tp.setItem(t);
			}
		});
		
		JPanel btns = new JPanel();
		btns.add(btn1);
		btns.add(btn2);
		btns.add(btn3);
		
		frame.add(btns, BorderLayout.SOUTH);
		frame.setBounds(100, 100, 450, 300);
		frame.setVisible(true);
	}

}
