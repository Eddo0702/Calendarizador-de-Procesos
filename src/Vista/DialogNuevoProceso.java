package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DialogNuevoProceso extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtLlegada;
	private JTextField txtRafaga;
	private JTextField txtPrioridad;
	private JTextField txtQuantum;

	/**
	 * Create the dialog.
	 */
	public DialogNuevoProceso(DefaultTableModel model) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setTitle("Nuevo Proceso");
		setBounds(100, 100, 250, 235);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblLlegada = new JLabel("Llegada");
		lblLlegada.setBounds(10, 11, 70, 14);
		contentPanel.add(lblLlegada);

		txtLlegada = new JTextField();
		txtLlegada.setBounds(90, 8, 134, 20);
		contentPanel.add(txtLlegada);
		txtLlegada.setColumns(10);

		JLabel lblRafaga = new JLabel("Rafaga");
		lblRafaga.setBounds(10, 47, 70, 14);
		contentPanel.add(lblRafaga);

		txtRafaga = new JTextField();
		txtRafaga.setBounds(90, 44, 134, 20);
		contentPanel.add(txtRafaga);
		txtRafaga.setColumns(10);

		JLabel lblPrioridad = new JLabel("Prioridad");
		lblPrioridad.setBounds(10, 85, 70, 14);
		contentPanel.add(lblPrioridad);

		txtPrioridad = new JTextField();
		txtPrioridad.setBounds(90, 82, 134, 20);
		contentPanel.add(txtPrioridad);
		txtPrioridad.setColumns(10);

		JLabel lblQuantum = new JLabel("Quantum");
		lblQuantum.setBounds(10, 120, 70, 14);
		contentPanel.add(lblQuantum);

		txtQuantum = new JTextField();
		txtQuantum.setBounds(90, 117, 134, 20);
		contentPanel.add(txtQuantum);
		txtQuantum.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							Integer.parseInt(txtLlegada.getText());
							Integer.parseInt(txtPrioridad.getText());
							Integer.parseInt(txtQuantum.getText());
							Integer.parseInt(txtRafaga.getText());
							model.addRow(new Object[] { model.getRowCount() + 1, txtLlegada.getText(),
									txtRafaga.getText(), txtPrioridad.getText(), txtQuantum.getText() });
							dispose();
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Los campos deben contener valores numericos");
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
