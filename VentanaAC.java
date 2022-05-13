import java.awt.event.*;
import javax.swing.JTextArea;
import java.lang.String;
public class VentanaAC implements ActionListener{
 JTextArea ventana; //Donde se va a mostrar
 public void actionPerformed(ActionEvent e){
  //Codigo  
  crearClase();
  //claseMain(); //crear checkbox
  
 }
 public VentanaAC(JTextArea t){
  //Codigo
  ventana = t;
 }
 private void crearClase(String nombre){
  ventana.setText("public class "+nombre+" extends JFrame{"
                   +"\n//Constructor"
                   +"\n public "+nombre+"(){"
                   +"\n  "
                   +"\n }"
                   +"\n}"                               
   );
 }
 private void crearClase(){
  crearClase("Ventana");
 }
 private void claseMain(){
  String clase = ventana.getText();
  //clase.buscar("//Constructor");
  boolean constructor = false;
  boolean open = false;
  boolean close = false;
  int l = clase.length();
  for(int i =0; i<l; i++){
   if(!constructor){
    if(i>(l-11)){ //11 es el tamaño de "Constructor"
     //Error
    }
    else{
     if(clase.charAt(i)=='C'&&clase.charAt(i+1)=='o'&&clase.charAt(i+2)=='n'&&clase.charAt(i+3)=='s'
        &&clase.charAt(i+4)=='t'&&clase.charAt(i+5)=='r'&&clase.charAt(i+6)=='u'
        &&clase.charAt(i+7)=='c'&&clase.charAt(i+8)=='t'&&clase.charAt(i+9)=='o'
        &&clase.charAt(i+10)=='r'){
      constructor = true;
     }
    }
    
   }
   else if(!open){
    if(clase.charAt(i)=='{'){
     open = true;
    }
   }
   else if(!close){
    if(clase.charAt(i)=='}'){
     close = true;
    }
   }
   else{
    //añadir
    String start = clase.substring(0,i);
    String end = "\n"+clase.substring(i+1,l); //añadimos salto de linea
    String add = "\n//Main"
                 +"\n public static void main(String args[]){"
                 +"\n  "
                 +"\n }"
                 ;
    String newo = start + add + end;
    ventana.setText(newo);
    i=l; //Terminamos el for  
   }
  }
  
 }
 public static void main(String args[]){
  //Codigo
 }
}