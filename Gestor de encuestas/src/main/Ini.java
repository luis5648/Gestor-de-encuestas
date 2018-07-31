

import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;


public class Ini implements ActionListener{
    
    private JFrame vLogin;
    private JButton acept,cancel,contest;
    private JPanel cp,cpb;
    private JLabel et1,et2;
    private JTextField txt1;
    private JPasswordField pss1;

    
    public Ini(){
        vLogin = new JFrame("Inicio de sesion"); 
        cp = new JPanel(new FlowLayout());
        cpb = new JPanel();
        acept = new JButton("Aceptar");
        cancel = new JButton("Cancelar");
        contest = new JButton("Contestar examen");
        et1 = new JLabel("Usuario:        ");
        et2 = new JLabel("Contraseña: ");
        txt1 = new JTextField(25);
        pss1 = new JPasswordField(25);

        //prueba de estilos
        Estilos e = new Estilos();

        cp.setBackground(e.gris);
        cpb.setBackground(e.gris);

        cp.add(et1);
        cp.add(txt1);
        cp.add(et2);
        cp.add(pss1);
        
        cpb.add(acept);
        cpb.add(cancel);
        cpb.add(contest);

        acept.addActionListener(this);
        cancel.addActionListener(this);
        contest.addActionListener(this);

        vLogin.add(cpb,BorderLayout.SOUTH);
        vLogin.add(cp);
        vLogin.setSize(400,300);
        vLogin.setLocation(300, 300);
        vLogin.setVisible(true);
        vLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){

        String Usuario = "Luis";
        String Contra = "Administrad0r";

        String pass = new String(pss1.getPassword());

        if(e.getSource().equals(acept)){
           if(pass.equals(Contra)&&txt1.getText().equals(Usuario)){
             vLogin.dispose();
              Menu m = new Menu();
              JOptionPane.showMessageDialog(m, "Con las siguientes opciones se podra:\n "+
              "agregar nuevos reactivos, modificar los existentes y eliminar.");
            
           }else{
               JOptionPane.showMessageDialog(cp, "usuario o clave incorrectos!");
           }
        } else if(e.getSource().equals(cancel)){

            vLogin.dispose();

        } else if(e.getSource().equals(contest)){
            vLogin.dispose();
            Generador ge = new Generador();
            ge.run();
            
        }
    }
    public static void main(String[] args){
        Ini in = new Ini();
    }

}
