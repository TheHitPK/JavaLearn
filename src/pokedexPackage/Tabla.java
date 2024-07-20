package pokedexPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Tabla extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	// private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					JFrame frame = new JFrame("xd");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setBounds(100, 100, 450, 300);
					contentPane = new JPanel();
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

					frame.setContentPane(contentPane);
					contentPane.setLayout(null);

					String[] filas = { "uno", "Dos" };
					Object[][] columnas = { { "ejje", "jaja" }, { "Probando", "pRODANB" } };
					DefaultTableModel modelo = new DefaultTableModel(columnas, filas);
					JTable table = new JTable(modelo);
					JScrollPane scroll = new JScrollPane(table);
					table.setBounds(54, 42, 312, 154);
					contentPane.add(table);
					frame.getContentPane().add(scroll);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
