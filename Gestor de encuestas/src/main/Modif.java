import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Modif {

	private JFrame frame;
	int i= 0;
	String opcion;	

			public void run() {
				
					Modif mf = new Modif();
					mf.frame.setVisible(true);		
			}

	public Modif() {
		
		initialize();
	}

	private void initialize() {

		
		Almacenamiento al = new Almacenamiento();		
		
		frame = new JFrame("Modificar");
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 520, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
			
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(300, 12, 208, 379);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(54, 42, 96, 25);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Siguiente");
		btnNewButton_2.setBounds(14, 233, 182, 25);
		panel.add(btnNewButton_2);
		
		
		JButton btnNewButton = new JButton("Guardar cambios...");
		btnNewButton.setBounds(17, 270, 179, 25);
		panel.add(btnNewButton);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.setBounds(14, 311, 182, 25);
		panel.add(btnCargar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(46, 177, 117, 25);
		panel.add(btnAceptar);

		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(46, 125, 117, 25);
		panel.add(btnRegresar);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(Color.BLACK);
		textArea.setBackground(Color.WHITE);
		textArea.setFont(new Font("Century Schoolbook L", Font.PLAIN, 15));
		textArea.setBounds(12, 82, 287, 309);
		frame.getContentPane().add(textArea);

		JLabel lblRespuestaCorrecta = new JLabel("Respuesta correcta:");
		lblRespuestaCorrecta.setFont(new Font("Dialog", Font.BOLD, 10));
		lblRespuestaCorrecta.setForeground(Color.WHITE);
		lblRespuestaCorrecta.setBounds(26, 51, 117, 15);
		frame.getContentPane().add(lblRespuestaCorrecta);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(192, 12, 48, 24);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("A");
		comboBox.addItem("B");
		comboBox.addItem("C");
		

		JTextField textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(161, 48, 114, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JTextField txtNumDePregunta = new JTextField();
		txtNumDePregunta.setText("Num de pregunta");
		txtNumDePregunta.setBounds(29, 12, 114, 19);
		frame.getContentPane().add(txtNumDePregunta);
		txtNumDePregunta.setColumns(10);
		
		//Eventos: 

		final ItemListener cambioDeOpcion = new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                
                if(comboBox.getSelectedItem().equals(e.getItem())){       
                    opcion = e.getItem().toString();
                }
            }
        };

		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Menu me = new Menu();
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			int i = Integer.parseInt(txtNumDePregunta.getText())-1;	

			String gt = new String(textArea.getText());
			
			al.modReactivo(gt,i);
			al.modInciso(opcion,i);

			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			al.guardar();	
			al.guardarInciso();
			}
		});
		
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				al.cargar();
				al.cargarInciso();
			}
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(i<al.vc.size() && i>=0 && i<al.inciso.size()) {
					textArea.setText("");

					textArea.setText(al.mostrar(i));
					textField.setText(al.pregCorrecta(i));
																								
					i++;
				}
				else {
					System.out.println("no hay elementos");
				}
				
			}
		});
		btnNewButton_1.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		comboBox.addItemListener(cambioDeOpcion);
	}
}
