import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.lang.String;
public class ManifestAC implements ActionListener{
 JTextField version, autor, claseMain;
 JTextArea comentario;
 public ManifestAC(JTextField v, JTextField a, JTextField m, JTextArea ta){
  version = v;
  autor = a;  
  claseMain = m;
  comentario = ta;
 }
 public void actionPerformed(ActionEvent e){
  Boolean obligatorio = true; //bandera
  String a,v,m;
  v = version.getText();
  a = autor.getText();  
  m = claseMain.getText();
  //verificamos input
  
  if(v.strip().equals("")||a.strip().equals("")||m.strip().equals("")){
   obligatorio = false;
  } 
  String r="";
  if(obligatorio){   
   r = "Manifest-Version: "
    +version.getText().strip()+"\n"
    +"Created-By: "
    +autor.getText().strip()+"\n"
    +"Main-Class: "
    +claseMain.getText().strip()+"\n"
    ;//fin del string
  }
  else{
   r="campos obligatorios Version, Autor, clase main";
  }
  System.out.println(r);//debug
 }
 
}