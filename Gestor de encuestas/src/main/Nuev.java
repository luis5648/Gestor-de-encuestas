import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Nuev extends JFrame{

    private JPanel cpNuev, cpBtnN;
    private JLabel lblNuev;
    private JTextArea txtPreg;
    private JButton btnNuev1, btnNuev2, btnNuev3, btnNuev4, btnNuev5, btnNuev6;
    private JComboBox cmbRespuestas;
    int i = 1;

    String opcion;
   
    public Nuev() {
        super("Nuevo");        

        cpNuev = new JPanel();
        cpBtnN = new JPanel();
        txtPreg = new JTextArea();
        lblNuev = new JLabel("Respuesta correcta: ");

        btnNuev1 = new JButton("Aceptar"); //Guardar todo con el vector
        btnNuev2 = new JButton("Cancelar");
        btnNuev3 = new JButton("Regresar");
        btnNuev4 = new JButton("Siguiente"); //Dar paso a la sig. preg.
        btnNuev5 = new JButton("Guardar cambios...");
        btnNuev6 = new JButton("Cargar preguntas...");

        cmbRespuestas = new JComboBox();

        cmbRespuestas.addItem("A");
        cmbRespuestas.addItem("B");
        cmbRespuestas.addItem("C");

        Almacenamiento al = new Almacenamiento();        

        final ItemListener cambioDeOpcion = new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                
                if(cmbRespuestas.getSelectedItem().equals(e.getItem())){       
                    opcion = e.getItem().toString();
                }
            }
        };
        cmbRespuestas.addItemListener(cambioDeOpcion);
        

        btnNuev1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                
                String r = new String(txtPreg.getText());               
                
                al.AgregarReact(r);     
                al.agragarInciso(opcion);                   

            }
        });

        btnNuev2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
            }
        });
        btnNuev3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                Menu m = new Menu();
                dispose();               

            }
        });

        btnNuev4.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent arg0) {
                              
                txtPreg.setText("");
                
            }
        });

        btnNuev5.addActionListener(new ActionListener(){
            
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    al.guardar();
                    al.guardarInciso();
                }
            });

            btnNuev6.addActionListener(new ActionListener(){
            
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    al.cargar();
                    al.cargarInciso();
                }
            });
            
        cpNuev.add(lblNuev);

        cpNuev.add(cmbRespuestas);

        cpBtnN.add(btnNuev1);
        cpBtnN.add(btnNuev2);
        cpBtnN.add(btnNuev3);
        cpBtnN.add(btnNuev4);
        cpBtnN.add(btnNuev5);
        cpBtnN.add(btnNuev6);

        add(cpNuev,BorderLayout.EAST);
        add(txtPreg, BorderLayout.CENTER);
        add(cpBtnN, BorderLayout.SOUTH);

        setVisible(true);
       
        setSize(650, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
