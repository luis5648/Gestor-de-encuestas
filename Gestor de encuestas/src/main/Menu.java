import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class Menu extends JFrame{

    private JButton nuevo,modific,elimi;
    private JPanel btnCont1;
    public Menu(){
        super("Menu");
        btnCont1 = new JPanel(new FlowLayout());
        nuevo = new JButton("Nuevo");
        modific = new JButton("Modificar");
        elimi = new JButton("Eliminar");
      

        Almacenamiento al = new Almacenamiento();

        btnCont1.add(nuevo);
        btnCont1.add(modific);
        btnCont1.add(elimi);


        nuevo.addActionListener(new ActionListener(){
        
            
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                Nuev nv = new Nuev();
                JOptionPane.showMessageDialog(nv,"Presione siguiente para agregar "+
                "un nuevo reactivo.\nPresione aceptar al terminar de añadir cada pregunta\ncon sus opciones.");
                
                JOptionPane.showMessageDialog(nv, "Escriba la pregunta a agregar junto con sus "+
                "respectivas opciones (3) enumeradas.\nHaga click en siguiente antes de comenzar.");
                
            }
        });

        modific.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Modif nv = new Modif();
                nv.run();

                JOptionPane.showMessageDialog(null, "Haga click en 'cargar' para acceder al "+
                "registro de preguntas.\npuede navegar entre las preguntas disponibles con "+
                "el boton 'Siguiente'.\n"+"En la casilla 'num pregunta' debe ingresar el numero"+
                "de la pregunta que se esta modificando"
                +"Presione 'Aceptar' para guardar los cambios de cada "+
                "reactivo.");

                
            }
        });

        elimi.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                Eliminar el = new Eliminar();
                el.run();
                JOptionPane.showMessageDialog(null, "Ingrese en la casilla de texto el n\u00famero "+
                "de reactivo que desea eliminar y haga click en el bot\u00f3n para completar la acci\u00f3n.");
                JOptionPane.showMessageDialog(null, "Presione 'guardar' para que tome efecto en el archivo .dat.");
            }
        });

        add(btnCont1);
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(300,90);
      	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

}
