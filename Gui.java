import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
public class Gui extends JFrame{
 JButton boton1;
 JTextArea areaTexto1;
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
  //Eventos
  boton1.addActionListener(new VentanaAC(areaTexto1));
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