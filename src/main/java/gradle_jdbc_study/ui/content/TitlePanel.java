package gradle_jdbc_study.ui.content;

import gradle_jdbc_study.dto.Title;
import gradle_jdbc_study.ui.exception.InvalidCheckException;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TitlePanel extends AbsItemPanel<Title> {
	private JTextField tfNo;
	private JTextField tfName;

	public TitlePanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblNo = new JLabel("\uBC88\uD638");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNo);
		
		tfNo = new JTextField();
		add(tfNo);
		tfNo.setColumns(10);
		
		JLabel lblName = new JLabel("\uC9C1\uCC45\uBA85");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblName);
		
		tfName = new JTextField();
		add(tfName);
		tfName.setColumns(10);
	}

	@Override
	public Title getItem() {
		int titleNo = Integer.parseInt(tfNo.getText().trim());
		String titleName = tfName.getText().trim();
		return new Title(titleNo, titleName);
	}

	@Override
	public void setItem(Title item) {
		tfNo.setText(item.getTitleNo()+"");
		tfName.setText(item.getTitleName());
		
	}

	@Override
	public void clearTf() {
		tfNo.setText("");
		tfName.setText("");
		
	}
	@Override
	public void validCheck() {
		if(tfNo.getText().contentEquals("") || tfName.getText().contains("")) {
			throw new InvalidCheckException();
		}
		 
	}

}
