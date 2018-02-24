package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class VtnPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VtnPrincipal frame = new VtnPrincipal();
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
	public VtnPrincipal() {
		setResizable(false);
		setTitle("Calendarizador de Procesos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSeleccionaElAlgoritmo = new JLabel("Selecciona el algoritmo a utilizar");
		lblSeleccionaElAlgoritmo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSeleccionaElAlgoritmo.setBounds(10, 11, 183, 14);
		contentPane.add(lblSeleccionaElAlgoritmo);

		JComboBox cbAlgoritmos = new JComboBox();
		cbAlgoritmos.setBounds(10, 36, 183, 20);
		cbAlgoritmos.addItem("Short Remaining Time First");
		cbAlgoritmos.addItem("Round Robin");
		contentPane.add(cbAlgoritmos);

		String[] names = { "Nombre", "Rafaga", "Llegada", "Quantum" };
		Object[][] data = {};

		JTable table = new JTable();
		table.setFillsViewportHeight(true);
		DefaultTableModel model = new DefaultTableModel(0, 0);
		model.setColumnIdentifiers(names);
		table.setModel(model);

		model.addRow(new Object[] { "P1", "2", "3", "4" });
		model.addRow(new Object[] { "P2", "5", "6", "7" });

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 67, 230, 190);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.setBounds(10, 268, 105, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remover");
		btnNewButton_1.setBounds(135, 268, 105, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Actualizar resultados");
		btnNewButton_2.setBounds(10, 302, 230, 23);
		contentPane.add(btnNewButton_2);
	}
}
