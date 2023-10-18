package GUI;

import javax.swing.*;

import Entidad.Entidad;
import Juego.Juego;
import Nivel.Nivel;
import utils.Utils;
import java.awt.*;

public class GUI extends JFrame{
    protected Panel panel;
    protected JLabel labelInfo;
    protected JLabel jugador;
    protected Juego juego;
    protected JLabel NivelActual;
    protected JLabel tiempo;
    protected JLabel vidas;
    protected JLabel objetivo;
    protected JLabel movimientos;
    protected JLabel FotoObjetivo;

    public GUI(Juego juego) {

        Nivel n = juego.getNivel();
        this.juego = juego;

        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        jugador = new JLabel();
        jugador.setOpaque(false);
        jugador.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED,8));
        jugador.setBounds(Utils.labelSpacing, Utils.labelSpacing, Utils.labelWidth, Utils.labelHeight);

        panel = new Panel(juego, jugador);
        panel.add(jugador);
  
        labelInfo = new JLabel();
        labelInfo.setLayout(null);
        labelInfo.setPreferredSize(new Dimension(Utils.panelWidth()/2, Utils.panelHeight()));
        labelInfo.setOpaque(false);
        ImageIcon fondoInfo = new ImageIcon("Candy Crush/Imagenes/Tierra.png");
        labelInfo.setIcon(new ImageIcon(fondoInfo.getImage().getScaledInstance(1308, Utils.panelHeight(), Image.SCALE_SMOOTH)));
        

        NivelActual = new JLabel();
        NivelActual.setText(String.valueOf(n.getNivel()));
        NivelActual.setBounds(250, 0, 80, 80);
        NivelActual.setForeground(Color.WHITE);
        NivelActual.setHorizontalAlignment(SwingConstants.CENTER);
        NivelActual.setFont(new Font("TimesRoman", Font.BOLD, 65));
        labelInfo.add(NivelActual);

        tiempo = new JLabel();
        tiempo.setText("00:00");
        tiempo.setBounds(47, 0, 250, 250);
        tiempo.setHorizontalAlignment(SwingConstants.CENTER);
        tiempo.setForeground(Color.WHITE);
        tiempo.setOpaque(false);
        tiempo.setFont(new Font("TimesRoman", Font.BOLD, 85));
        labelInfo.add(tiempo);


        ImageIcon imagenVida = new ImageIcon("Candy Crush/Imagenes/Extras/Vidas.png");
        JLabel fotoVidas = new JLabel();
        fotoVidas.setBounds(35, 200, 80, 80);
        fotoVidas.setIcon(new ImageIcon(imagenVida.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
        labelInfo.add(fotoVidas);

        vidas = new JLabel();
        vidas.setText(String.valueOf(n.getVidas()));
        vidas.setBounds(150, 190, 80, 80);
        vidas.setHorizontalAlignment(SwingConstants.CENTER);
        vidas.setForeground(Color.WHITE);
        vidas.setOpaque(false);
        vidas.setFont(new Font("TimesRoman", Font.BOLD, 65));
        labelInfo.add(vidas);
        
     
        JLabel textoMovimientos = new JLabel();
        textoMovimientos.setText("Mov:");
        textoMovimientos.setBounds(30, 430, 120, 120);
        textoMovimientos.setHorizontalAlignment(SwingConstants.CENTER);
        textoMovimientos.setForeground(Color.white);
        textoMovimientos.setOpaque(false);
        textoMovimientos.setFont(new Font("TimesRoman", Font.BOLD, 40));
        labelInfo.add(textoMovimientos);

        movimientos = new JLabel();
        movimientos.setText("7");
        movimientos.setBounds(150, 430, 120, 120);
        movimientos.setHorizontalAlignment(SwingConstants.CENTER);
        movimientos.setForeground(Color.white);
        movimientos.setOpaque(false);
        movimientos.setFont(new Font("TimesRoman", Font.BOLD, 40));
        labelInfo.add(movimientos);
        
       


        getContentPane().add(labelInfo, BorderLayout.EAST);
        getContentPane().add(panel, BorderLayout.CENTER);
        pack();
        getContentPane().add(new JLabel(new ImageIcon("Candy Crush/Imagenes/fondo.png")));
        setVisible(true);


        ImageIcon imagenCaramelo = new ImageIcon("Candy Crush/Imagenes/Caramelos/amarillo.png");
        FotoObjetivo = new JLabel();
        FotoObjetivo.setBounds(35, 333, 80, 80);
        FotoObjetivo.setIcon(new ImageIcon(imagenCaramelo.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
        FotoObjetivo.setOpaque(false);
        labelInfo.add(FotoObjetivo);

        objetivo = new JLabel();
        objetivo.setText(String.valueOf(2));
        objetivo.setBounds(150, 328, 80, 80);
        objetivo.setHorizontalAlignment(SwingConstants.CENTER);
        objetivo.setForeground(Color.WHITE);
        objetivo.setOpaque(false);
        objetivo.setFont(new Font("TimesRoman", Font.BOLD, 65));
        labelInfo.add(objetivo);
    
    }
    
    public void insertarEntidadGrafica(EntidadGrafica eg) {
        if(eg != null) {
            int eg_X = eg.getX();
            int eg_Y = eg.getY();
            eg.setLocation(eg_X, eg_Y); // Para la animacion poner donde va eg_Y el valor -50
            panel.add(eg);
//            AnimadorCaida animadorCaida = new AnimadorCaida(eg, eg_X, eg_Y, 1);
//            animadorCaida.start();
        }
    }

    public Panel getPanel() {
        return panel;
    }

    Nivel n;
    public void notificarMovimiento(){
        n = juego.getNivel();
        movimientos.setText(String.valueOf(n.getMov()));
        vidas.setText(String.valueOf(n.getVidas()));

        ImageIcon ico = new ImageIcon("Candy Crush/Imagenes/Caramelos/"+ n.getColorObjetivo().toString().toLowerCase()+".png");
        Image img = ico.getImage();
        Image new_img = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        FotoObjetivo.setIcon(new ImageIcon(new_img));

        if(n.getObjetivoCaramelo()>0){
            ImageIcon iconoCaramelo = new ImageIcon("Candy Crush/Imagenes/Caramelos/"+ n.getColorObjetivo().toString().toLowerCase()+".png");
            Image imgagenCaramlo = ico.getImage();
            Image new_imgCaramelo = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            FotoObjetivo.setIcon(new ImageIcon(new_img));
            objetivo.setText(String.valueOf(n.getObjetivoCaramelo()));
        }
        else{
            if(n.getObjetivoGelOEnv()>0){
                ImageIcon iconoCaramelo = new ImageIcon("Candy Crush/Imagenes/Extras/Gelatina.png");
                Image imgagenCaramlo = ico.getImage();
                Image new_imgCaramelo = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                FotoObjetivo.setIcon(new ImageIcon(new_img));
                objetivo.setText(String.valueOf(n.getObjetivoGelOEnv()));
            }
            else{
                ImageIcon iconoCaramelo = new ImageIcon("Candy Crush/Imagenes/Extras/Merengue.png");
                Image imgagenCaramlo = ico.getImage();
                Image new_imgCaramelo = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                FotoObjetivo.setIcon(new ImageIcon(new_img));
                objetivo.setText(String.valueOf(n.getObjetivoGlaseado()));
            }
        }        
    }

    public void notificarTiempo(int t){
        tiempo.setText(String.valueOf(t/60)+":"+String.valueOf(t%60));
        tiempo.setHorizontalTextPosition(SwingConstants.CENTER);
    }
}
