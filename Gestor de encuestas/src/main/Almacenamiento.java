import java.util.*;
import javax.swing.JOptionPane;
import java.io.*;
import java.awt.event.ItemListener;

public class Almacenamiento  implements Serializable{
    public Vector<String> vc = new Vector<String>();
    public Vector<String> inciso = new Vector<String>();    

    public Vector<String> respuestas = new Vector<String>();

    FileInputStream archivoEntrada=null; 
    FileOutputStream archivoSalida=null;
    ObjectInputStream objetoEntrada=null; 
    ObjectOutputStream objetoSalida=null;

    //Acciones sobre los vectores: 
    public void AgregarReact(String x) {
        vc.addElement(x);
    }
    public void pregNueva(String x) {
        respuestas.addElement(x);
    }
    public void agragarInciso(String x){
        inciso.addElement(x);
    }

    public void modReactivo(String d,int index){
         vc.setElementAt(d, index);
    }

    public void modInciso(String d,int index){
        inciso.setElementAt(d, index);
    }

    public void eliminarInciso(int x){
        inciso.remove(x);
    }

    public void EliminarReact(int x) {
        vc.removeElementAt(x); 
    }

    public void EliminarPreg(int x) {
        inciso.removeElementAt(x); 
    }

    public String pregCorrecta(int pos){
        String p;

        p= inciso.elementAt(pos);

        return p;
    }

    public String mostrar(int posc){
        String cant;

        cant = vc.elementAt(posc);

        return cant;
    }

    public String mostrarResp(int posc){
        String r;

        r = respuestas.elementAt(posc);
        
        return r;
    }

    //Guardar y cargar:
    public void cargar(){
        try{
            archivoEntrada=new FileInputStream("React.dat");
            objetoEntrada=new ObjectInputStream(archivoEntrada);
            vc=(Vector)objetoEntrada.readObject();
            archivoEntrada.close();
            JOptionPane.showMessageDialog(null, "Reactivos cargados! =)");
          }catch(IOException E){ }
           catch(ClassNotFoundException E){ }  
    }

    public void guardar(){
        try{ 
            archivoSalida=new FileOutputStream("React.dat");
            objetoSalida=new ObjectOutputStream(archivoSalida);
            objetoSalida.writeObject(vc); //guarda el objeto en el archivo
            archivoSalida.close();
            JOptionPane.showMessageDialog(null, "Reactivos guardados! =)");
           }catch(IOException E){ }  
    }

    public void cargarInciso(){
        try{
            archivoEntrada=new FileInputStream("Respuestas.dat");
            objetoEntrada=new ObjectInputStream(archivoEntrada);
            inciso=(Vector)objetoEntrada.readObject();
            archivoEntrada.close();
            JOptionPane.showMessageDialog(null, "Respuestas cargadas! =)");
          }catch(IOException E){ }
           catch(ClassNotFoundException E){ }  
    }

    public void guardarInciso(){
        try{ 
            archivoSalida=new FileOutputStream("Respuestas.dat");
            objetoSalida=new ObjectOutputStream(archivoSalida);
            objetoSalida.writeObject(inciso); 
            archivoSalida.close();
            JOptionPane.showMessageDialog(null, "Respuestas guardadas! =)");
           }catch(IOException E){ }  

    }
         
    // Función para saber si hay cosas en el vector:
    public String vac(){
        if(vc.isEmpty()){
            return "Vacío";
        }else{
            return "Con eleméntos";
        }

        
    }   
    
} 