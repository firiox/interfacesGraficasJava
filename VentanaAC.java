import java.awt.event.*;
import javax.swing.JTextArea;
public class VentanaAC implements ActionListener{
 JTextArea ventana; //Donde se va a mostrar
 public void actionPerformed(ActionEvent e){
  //Codigo  
  ventana.setText("public class ventana extends JFrame{"
                  +"\n//Codigo"
                  +"\n}"                               
   );
 }
 public VentanaAC(JTextArea t){
  //Codigo
  ventana = t;
 }
 public static void main(String args[]){
  //Codigo
 }
}