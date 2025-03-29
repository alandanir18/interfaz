
package com.mycompany.main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

interface JuegoWii {
    String getTitulo();
    String getGenero();
    double getCalificacion();
}

class MarioGalaxy implements JuegoWii {
    public String getTitulo() { return "Super Mario Galaxy"; }
    public String getGenero() { return "Plataformas"; }
    public double getCalificacion() { return 9.7; }
}

class ZeldaTwilightPrincess implements JuegoWii {
    public String getTitulo() { return "The Legend of Zelda: Twilight Princess"; }
    public String getGenero() { return "Aventura"; }
    public double getCalificacion() { return 9.8; }
}

public class Main extends JFrame {
    private JTextArea areaTexto;
    private JButton btnMostrar;

    public Main() {
        setTitle("Mejores Juegos de Wii");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(40, 40, 40));

        JLabel titulo = new JLabel(" Mejores Juegos de Wii", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setForeground(Color.WHITE);
        add(titulo, BorderLayout.NORTH);

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Arial", Font.PLAIN, 16));
        areaTexto.setForeground(Color.WHITE);
        areaTexto.setBackground(new Color(80, 80, 80));
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        btnMostrar = new JButton("Mostrar Juegos");
        btnMostrar.setFont(new Font("Arial", Font.BOLD, 18));
        btnMostrar.setForeground(Color.WHITE);
        btnMostrar.setBackground(new Color(0, 150, 255));
        btnMostrar.setFocusPainted(false);
        add(btnMostrar, BorderLayout.SOUTH);

        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarJuegos();
            }
        });
    }

    private void mostrarJuegos() {
        JuegoWii mario = new MarioGalaxy();
        JuegoWii zelda = new ZeldaTwilightPrincess();

        String resultado = "";
        resultado += mostrarInfoJuego(mario);
        resultado += mostrarInfoJuego(zelda);

        areaTexto.setText(resultado);
    }

    private String mostrarInfoJuego(JuegoWii juego) {
        return "Título: " + juego.getTitulo() + "\n" +
               "Género: " + juego.getGenero() + "\n" +
               "Calificación: " + juego.getCalificacion() + "\n\n";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}
