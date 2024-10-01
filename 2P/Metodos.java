package Ejercicio;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
    private List <String> listaRegistro= new ArrayList<>();
    private JTextArea mostrarDatos; 
    private JTextArea listaCompleta;
    private JScrollPane scrollPaneLista;
    

    public Metodos(){        
        setBounds(600, 250, 800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Aplicaion EPS");

        IniciarComponentes();
    }

    private void IniciarComponentes(){
        panel();
        ingresoDatos();
        botones();
        timer();
        mostrar();
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
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarDatos();
            }
        });

    }

    private void registrarDatos() {

        String cedulaTexto = cedula.getText();
        String categoriaSeleccionada = (String) categoria.getSelectedItem();
        String servicioSeleccionado = (String) servicio.getSelectedItem();

        if (cedulaTexto.isEmpty() || categoriaSeleccionada == null || servicioSeleccionado == null) {
            System.out.println("Por favor complete todos los campos.");
            return;
        }

    String horaAtencion = obtenerHoraActual();

    String registroConHora = String.format("Cédula: %s, Categoría: %s, Servicio: %s, Hora: %s",
            cedulaTexto, categoriaSeleccionada, servicioSeleccionado, horaAtencion);

    if (listaRegistro.isEmpty()) {
        mostrarDatos.setText(registroConHora);
    } else {
        listaCompleta.append(registroConHora + "\n");
    }

    listaRegistro.add(registroConHora);


    cedula.setText("");
    categoria.setSelectedIndex(-1);
    servicio.setSelectedIndex(-1);
}

    private String obtenerHoraActual() {
        int horas = segundos / 3600;
        int minutos = (segundos % 3600) / 60;
        int seg = segundos % 60;
        return String.format("%02d:%02d:%02d", horas, minutos, seg);
    }

    private void mostrar(){
        mostrarDatos = new JTextArea();
        listaCompleta = new JTextArea();
        listaCompleta.setEditable(false);
        listaCompleta.setLineWrap(true); 
        listaCompleta.setWrapStyleWord(true); 

        mostrarDatos.setBounds(320, 32, 200, 150);
        scrollPaneLista = new JScrollPane(listaCompleta);
        scrollPaneLista.setBounds(250, 200, 400, 300);

        panel.add(mostrarDatos);
        panel.add(scrollPaneLista);

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