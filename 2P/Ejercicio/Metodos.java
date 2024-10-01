package Ejercicio;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Metodos extends JFrame{
    
    private JPanel panel;
    private JTextField cedula;
    private JComboBox <String> categoria;
    private JComboBox <String> servicio;

    public Metodos(){        
        setBounds(600, 250, 400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Aplicaion EPS");

        IniciarComponentes();
    }

    private void IniciarComponentes(){
        panel();
        ingresoDatos();
    }
    private void panel(){
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    private void ingresoDatos(){
        categoria =  new JComboBox<>(new String[]{"Menor de 60", "Adulto mayor", "Discapacidad" });
        categoria.setSelectedIndex(-1);
        categoria.setBounds(20, 120, 140, 25);
        servicio =  new JComboBox<>(new String[]{"Medicina general", "Medicina especializada", "Laboratorio", "Imagenes diagnosticas"});
        servicio.setSelectedIndex(-1);
        servicio.setBounds(20, 200, 140, 25);
        cedula= new JTextField();
        cedula.setBounds(20, 40, 140, 25);
        panel.add(cedula);
        panel.add(categoria);
        panel.add(servicio);
    }
}
