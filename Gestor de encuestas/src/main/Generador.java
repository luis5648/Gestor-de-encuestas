
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Generador {

    private JFrame frame;
    int i = 0;
    String opc;
    
    Almacenamiento al = new Almacenamiento();

    Cronometro crono=new Cronometro();
    int numPreguntas = al.vc.size();

            public void run() {
                    Generador gn = new Generador();
                    gn.frame.setVisible(true);
                }

    public Generador() {
        al.cargar();
        al.cargarInciso();
        initialize();
        
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 576, 357);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        
        frame.getContentPane().add(crono);
        crono.setBounds(429, 297, 137, 34);
        

        
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 256, 331);
        frame.getContentPane().add(scrollPane);
        
        JTextArea txtrPreguntas = new JTextArea();
        txtrPreguntas.setText("Preguntas");
        scrollPane.setViewportView(txtrPreguntas);
        
        JButton btnSiguientePregunta = new JButton("Siguiente pregunta");       
        btnSiguientePregunta.setBounds(320, 0, 193, 25);
        frame.getContentPane().add(btnSiguientePregunta);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(407, 94, 106, 24);
        frame.getContentPane().add(comboBox);
        comboBox.addItem("A");
		comboBox.addItem("B");
		comboBox.addItem("C");
        
        JLabel lblRespuesta = new JLabel("Respuesta:");
        lblRespuesta.setBounds(290, 99, 99, 15);
        frame.getContentPane().add(lblRespuesta);
        

        //Eventos:

        final ItemListener cambioDeOpcion = new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                
                if(comboBox.getSelectedItem().equals(e.getItem())){       
                    opc = e.getItem().toString();
                }
            }
        };


        btnSiguientePregunta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crono.start();
               
                if(i<al.vc.size() && i>=0) {
                    txtrPreguntas.setText("");
                    
                    txtrPreguntas.setText(al.mostrar(i));
                    al.pregNueva(opc);
                                                                                                
                    i++;
                }
                else {
                    crono.stop();
                    JOptionPane.showMessageDialog(null, "Fin Del examen!");
                    int cont =0;
                    float resultado;
                    for(int k = 0;k<=al.vc.size();k++){
                        if(al.mostrarResp(i) == al.pregCorrecta(i)){
                            cont++;
                        }
                    }
                    if(i<al.vc.size() && i>=0){
                        resultado = cont/al.vc.size();
                        JOptionPane.showMessageDialog(null,"Tu calificación es de:"+
                        resultado);
                    }
                }
            }
    
        });
        
    }
}
