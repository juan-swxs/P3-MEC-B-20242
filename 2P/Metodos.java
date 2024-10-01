package Ejercicio;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Metodos extends JFrame{
    
    private JPanel panel;
    private JTextField cedula;
    private JComboBox <String> categoria;
    private JComboBox <String> servicio;
    private JButton button;
    private JLabel time;
    private Timer cronometro;
    private int segundos = 0;
    

    public Metodos(){        
        setBounds(600, 250, 400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Aplicaion EPS");

        IniciarComponentes();
    }

    private void IniciarComponentes(){
        panel();
        ingresoDatos();
        botones();
        timer();
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

    private void botones(){
        button = new JButton("Registrar");
        button.setBounds(20, 250, 90, 25);
        panel.add(button);

    }

    private void timer(){
        time = new JLabel("00:00:00");
        time.setFont(new Font("Serif", Font.BOLD, 19));
        time.setBounds(120, 236, 195, 50);
        
        cronometro = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                segundos ++;
                Actualizartiempo();
            }
            
        });
        panel.add(time);
        cronometro.start();

    }

    private void Actualizartiempo(){

        int horas = segundos / 3600;
        int minutos = (segundos % 3600) / 60;
        int seg = segundos % 60;

        String tiempoFormat = String.format("%02d:%02d:%02d", horas, minutos, seg);
        time.setText(tiempoFormat);
    }
}