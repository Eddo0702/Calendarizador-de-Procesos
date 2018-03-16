package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controlador.Controller;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.GrayFilter;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VtnPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	
	private Controller controller;

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
		controller = Controller.getInstance();
		
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
		cbAlgoritmos.setBounds(10, 36, 275, 20);
		cbAlgoritmos.addItem("FIFO");
		cbAlgoritmos.addItem("Short Job First");
		cbAlgoritmos.addItem("Short Remaining Time First");
		cbAlgoritmos.addItem("Por Prioridad");
		cbAlgoritmos.addItem("Round Robin");
		contentPane.add(cbAlgoritmos);

		String[] names = { "Nombre", "Llegada", "Rafaga", "Prioridad", "Quantum" };

		JTable table = new JTable();
		table.setFillsViewportHeight(true);
		DefaultTableModel model = new DefaultTableModel(0, 0);
		model.setColumnIdentifiers(names);
		table.setModel(model);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 67, 275, 190);
		contentPane.add(scrollPane);

		JButton btnAnadir = new JButton("A\u00F1adir");
		btnAnadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new DialogNuevoProceso(model);
			}
		});
		btnAnadir.setBounds(10, 268, 105, 23);
		contentPane.add(btnAnadir);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					model.removeRow(table.getSelectedRow());
				} catch (Exception e) {
				}
			}
		});
		btnRemover.setBounds(180, 268, 105, 23);
		contentPane.add(btnRemover);

		JButton btnGenerar = new JButton("Generar resultados");
		btnGenerar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.GenerarResultados(textArea, table, cbAlgoritmos.getSelectedIndex());
			}
		});
		btnGenerar.setBounds(10, 302, 275, 23);
		contentPane.add(btnGenerar);

		textArea = new JTextArea();
		textArea.setEditable(false);

		JLabel lblResultados = new JLabel("Resultados");
		lblResultados.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblResultados.setBounds(317, 37, 160, 14);
		contentPane.add(lblResultados);

		JScrollPane scrollPane_1 = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(317, 67, 367, 190);
		contentPane.add(scrollPane_1);
	}
}
