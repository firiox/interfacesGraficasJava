/**
* creador de MANIFEST.MF
*
*/
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
public class Gui2 extends JFrame{
 JTextField versionTF, autorTF, claseMainTF;
 JLabel versionL, autorL, claseMainL;
 JTextArea comentario;
 private void crearTextField(JTextField ts[],int margenX,int margenY,int fieldSize,int regla,int fontSize){
  int i=0;
  for(JTextField t :ts){
   t = new JTextField();
   t.setBounds(margenX+((regla+46)*i),margenY+fontSize+6,regla,fieldSize);
   add(t);
   i++;
  }
 }
 private void crearLabel(JLabel ls[],int margenX,int margenY,int fontSize,int regla){
  //int l = ls.length();
  int i=0;
  for(JLabel l : ls){
   l.setBounds(margenX+(11+3)+((regla+46)*i),margenY,regla,fontSize);
   add(l);
   i++;
  }
 }
 private void crearCampo(JLabel[] ls, JTextField[] ts, int margenX, int margenY, int fontSize, int fieldSize , int regla){
  crearLabel(ls,margenX,margenY,fontSize,regla);
  crearTextField(ts,margenX,margenY,fieldSize,regla,fontSize);
 }
 public Gui2(){
  int fontSize = 9;
  int fieldSize = 22;
  int regla = 100; //medida comun 
  //espacio entre texto y field 6
  int margenX = (int)(33*2.5);
  int margenY = 45;
  //espacio horizontal entre fields 46
  setLayout(null);  
  versionL = new JLabel("Version");
  versionTF = new JTextField(); 
  autorL = new JLabel("Autor");
  autorTF = new JTextField(); 
  claseMainL = new JLabel("Clase main");
  claseMainTF = new JTextField();  
  comentario = new JTextArea();
  comentario.setBounds(margenX,margenY+fontSize+6+fieldSize+6*3,120*2,(9*3)+(4*3));
  add(comentario);
  JLabel ls[] = {versionL,autorL,claseMainL};  
  JTextField ts[] = {versionTF,autorTF,claseMainTF};  
  crearCampo(ls,ts,margenX,margenY,fontSize,fieldSize,regla);
  //config
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  setVisible(true);
  setBounds(0,0,600,300);
  setLocationRelativeTo(null);
 }
 public static void main(String args[]){
  Gui2 g = new Gui2();
 }
}
