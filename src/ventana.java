

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ventana extends JFrame {
    public ventana(){
        setSize(700,200);
        setTitle("Convertidor de temperatura");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciarComponentes();
    }
    private void iniciarComponentes(){
        //Panel
        JPanel panel = new JPanel();
        this.getContentPane().add(panel);
        panel.setLayout(null);
        //Etiquetas
        JLabel celsiusText = new JLabel("Celsius");
        panel.add(celsiusText);
        celsiusText.setBounds(25, 30, 80,40);

        JLabel convetirText = new JLabel("Convertir a: ");
        panel.add(convetirText);
        convetirText.setBounds(180, 30, 120, 40);

        JLabel resultadoText = new JLabel("Resultado: ");
        panel.add(resultadoText);
        resultadoText.setBounds(400, 30, 90, 40);

        JLabel textResultado = new JLabel("0");
        panel.add(textResultado);
        textResultado.setBounds(480,30,90,40);

        //Boton
        JButton boton1 = new JButton("Calcular");
        boton1.setEnabled(true);
        panel.add(boton1);
        boton1.setBounds(580, 30, 100, 40);

        //Cajas de texto
        JTextField celsiusArea = new JTextField();
        panel.add(celsiusArea);
        celsiusArea.setBounds(80, 30, 80, 40);

        //Lista desplegable
        String [] medidas = {"Fahrenheit","Kelvin"};
        JComboBox listaConversion = new JComboBox<>(medidas);
        panel.add(listaConversion);
        listaConversion.setBounds(270, 30, 100, 40);

        //Programa 
        final ActionListener oyente = new ActionListener(){
            
            @Override
            public void actionPerformed(final ActionEvent ae){
                Float celsiusNumero = Float.parseFloat(celsiusArea.getText());
                int opcion = listaConversion.getSelectedIndex();
                switch(opcion){
                    //Fahe
                    case 0:
                    celsiusNumero = celsiusNumero * (float)(1.8)+32;
                    textResultado.setText("" + celsiusNumero + "°");
                        break;

                    //Kelvin
                    case 1:
                    celsiusNumero= celsiusNumero + (float) (273.15);
                    textResultado.setText("" + celsiusNumero + "°");
                        break;
                }
            }
        };

        boton1.addActionListener(oyente);

    }
}
