package pokedexPackage;

import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.DebugGraphics;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Pokedex extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Pokedex frame = new Pokedex();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pokedex() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(76, 50, 46, 14);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(76, 74, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(277, 50, 46, 14);
		contentPane.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(277, 74, 86, 20);
		contentPane.add(textField_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(76, 183, 46, 14);
		contentPane.add(lblNewLabel_2);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(76, 207, 86, 20);
		contentPane.add(textField_2);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(277, 183, 46, 14);
		contentPane.add(lblNewLabel_3);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(277, 207, 86, 20);
		contentPane.add(textField_3);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(76, 138, 86, 22);
		contentPane.add(comboBox);

		JLabel lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setBounds(76, 113, 46, 14);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("New label");
		lblNewLabel_2_1_1.setBounds(277, 113, 46, 14);
		contentPane.add(lblNewLabel_2_1_1);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(277, 138, 86, 22);
		contentPane.add(comboBox_1);

		JLabel lblNewLabel_2_1_2 = new JLabel("New label");
		lblNewLabel_2_1_2.setBounds(76, 250, 46, 14);
		contentPane.add(lblNewLabel_2_1_2);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(76, 275, 86, 22);
		contentPane.add(comboBox_2);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("New label");
		lblNewLabel_2_1_1_1.setBounds(277, 250, 46, 14);
		contentPane.add(lblNewLabel_2_1_1_1);

		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(277, 275, 86, 22);
		contentPane.add(comboBox_1_1);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(0, 0, 179, 39);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(255, 0, 179, 39);
		contentPane.add(btnNewButton_1);

		DefaultTableModel mt = new DefaultTableModel();
		String[] ids = { "Calificacion", "Calificacion2" };
		Object[][] filas = { { "DATO1", "dATO2" }, { "DATO1", "DATO2" } };
		mt.setColumnIdentifiers(ids);

		JPanel panel = new JPanel();
		panel.setBounds(71, 340, 292, 102);
		contentPane.add(panel);
		panel.setLayout(null);

		table_1 = new JTable();
		table_1.setVisible(false);
		table_1.setName("hvhj");
		table_1.setInheritsPopupMenu(true);
		table_1.setDragEnabled(true);
		table_1.setDoubleBuffered(true);
		table_1.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		table_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table_1.setBounds(new Rectangle(13, 13, 14, 13));
		table_1.setFillsViewportHeight(true);
		table_1.setColumnSelectionAllowed(true);
		table_1.setBounds(0, 0, 292, 102);
		panel.add(table_1);
		table_1.setModel(
				new DefaultTableModel(new Object[][] { { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, }, new String[] { "New column", "New column", "New column" }));







	}
}
