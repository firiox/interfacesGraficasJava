import java.awt.event.*;
import javax.swing.JTextArea;
import java.lang.String;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
public class VentanaAC implements ActionListener{
 JTextArea ventana; //Donde se va a mostrar
 JTextField nombre; //Donde pone el nombre de la clase
 JCheckBox isMain; //verifica si tiene clase main
 JCheckBox configCB;//CheckBox configuracion de la ventana
 public void actionPerformed(ActionEvent e){
  if(nombre.getText().strip().equals("")){
   crearClase();
   if(configCB.isSelected()){
    startConfig();
   }
   if(isMain.isSelected()){
    claseMain();
   }
  }
  else{
   String n = nombre.getText().strip();
   crearClase(n);
   if(configCB.isSelected()){
    startConfig();
   }
   if(isMain.isSelected()){
    claseMain();
   }
  }    
 }
 public VentanaAC(JTextArea ta, JTextField tf, JCheckBox cbMain, JCheckBox cbConfig){
  ventana = ta;
  nombre = tf;
  isMain = cbMain;
  configCB = cbConfig;
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
 private void startConfig(){
  String t = ventana.getText();
  if(t.equals("")){
   System.out.println("Error");
  }
  else{
   int l = t.length();
   Boolean constructor=false;
   Boolean dentro = false;
   for(int i=0;i<l;i++){
    if(!constructor){     
     if(t.substring(i,i+13).equals("//Constructor")){
      constructor = true;
     }
    }
    else{
     
     if(!dentro){
      if(t.charAt(i) == '{'){
       dentro = true;
      }
     }   
     else{
      String s1 = t.substring(0,i);
      String s2 = t.substring(i+1,l);
      String add =
       ""//"\n  setBounds(0,0,600,400)"
       +"\n  setLocationRelativeTo(null)"
       +"\n  setVisible(true)"
       +"\n  setDefaulsCloseOperation(EXIT_ON_CLOSE)"       
       +"\n"
       ;
      String r = s1+add+s2;
      ventana.setText(r);
      i=l;
     }
    }
   }
  }
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