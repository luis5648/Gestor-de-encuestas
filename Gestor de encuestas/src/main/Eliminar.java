import java.awt. * ; 
import java.awt.event. * ; 
import javax.swing. * ; 

public class Eliminar {

	private JFrame frmEliminar; 
	private JTextField textField; 
	private JButton btnGuardar; 

	Almacenamiento al = new Almacenamiento();
	
		public void run() {
	
			Eliminar elm = new Eliminar(); 
			elm.frmEliminar.setVisible(true); 
	
		}
			
	public Eliminar() {
		initialize(); 
	}

	private void initialize() {
		frmEliminar = new JFrame(); 
		frmEliminar.setTitle("Eliminar"); 
		frmEliminar.setResizable(false); 
		frmEliminar.setBounds(100, 100, 450, 300); 
		frmEliminar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frmEliminar.getContentPane().setLayout(null); 
		
		textField = new JTextField(); 
		textField.setHorizontalAlignment(SwingConstants.CENTER); 
		textField.setFont(new Font("SansSerif", Font.BOLD, 14)); 
		textField.setBounds(131, 61, 177, 31); 
		frmEliminar.getContentPane().add(textField); 
		textField.setColumns(10); 
		
		JButton btnEliminarPregunta = new JButton("Eliminar pregunta"); 		
		btnEliminarPregunta.setBounds(12, 169, 185, 48); 
		frmEliminar.getContentPane().add(btnEliminarPregunta); 
		
		JButton btnGuardar = new JButton("Guardar"); 
		btnGuardar.setBounds(253, 169, 185, 48); 
		frmEliminar.getContentPane().add(btnGuardar); 

		JButton btnCargar = new JButton("Cargar");
		btnCargar.setBounds(168, 239, 117, 25);
		frmEliminar.getContentPane().add(btnCargar);

		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(168, 117, 117, 25);
		frmEliminar.getContentPane().add(btnRegresar);


		//Eventos:
		btnEliminarPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n;
				String s = new String(textField.getText());
				
				n = Integer.parseInt(s);
				if(n<=al.vc.size()){
					
					al.EliminarReact(n-1);
					al.EliminarPreg(n-1);

				}else{
					JOptionPane.showMessageDialog(null, "No existe esa pregunta!");
				}
			}
		}); 
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				al.guardar();
			}
		}); 

		btnCargar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				al.cargar();
				al.cargarInciso();
			}
		});

		btnRegresar.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frmEliminar.dispose();
				Menu me = new Menu();
			}
		});
	}
}
