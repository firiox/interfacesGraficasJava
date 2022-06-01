/**
* Gui de VentanaAC
*/
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
public class Gui extends JFrame{
 JButton boton1;
 JTextArea areaTexto1;
 JTextField nombre;
 JCheckBox isMain;
 JCheckBox configCB;
 JTextField dimensionTF;
 public Gui(){
  setLayout(null);
  //Ventanas
  boton1 = new JButton("Crear Ventana");
  boton1.setBounds(20,20,150,50);
  add(boton1);
  areaTexto1 = new JTextArea();
  areaTexto1.setBounds(20,90,250,200);
  add(areaTexto1);
  areaTexto1.setEditable(false);  
  nombre = new JTextField();
  nombre.setBounds(200,40,100,22);
  add(nombre);
  isMain = new JCheckBox("main");
  isMain.setBounds(340,40,70,22);
  add(isMain);
  configCB = new JCheckBox("config");
  configCB.setBounds(410,40,70,22);
  add(configCB);
  dimensionTF = new JTextField();
  dimensionTF.setBounds(410,85,100,22);
  dimensionTF.setVisible(false);
  add(dimensionTF);
  //Eventos
  ActionListener ac = new VentanaAC(areaTexto1,nombre,isMain,configCB,dimensionTF);
  boton1.addActionListener(ac);
  configCB.addActionListener(ac);
  //config
  this.setVisible(true);
  this.setBounds(0,0,600,400);
  this.setLocationRelativeTo(null);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
 public static void main(String args[]){
  //Aqui va el cod
  Gui Ventana = new Gui();
  
 }
}