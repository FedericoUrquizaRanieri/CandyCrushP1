package GUI;

import javax.swing.*;

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
    protected JLabel objetivoC;
    protected JLabel movimientos;
    protected JLabel objetivoG;
    protected JLabel objetivoEyG;

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
        NivelActual.setHorizontalAlignment(SwingConstants.CENTER);
        NivelActual.setFont(new Font("TimesRoman", Font.BOLD, 65));
        labelInfo.add(NivelActual);



        ImageIcon imagenVida = new ImageIcon("Candy Crush/Imagenes/Extras/Vidas.png");
        JLabel vidas = new JLabel();
        vidas.setBounds(35, 200, 80, 80);
        vidas.setIcon(new ImageIcon(imagenVida.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
        labelInfo.add(vidas);

        JLabel textoVidas = new JLabel();
        textoVidas.setText(String.valueOf(n.getVidas()));
        textoVidas.setBounds(150, 190, 80, 80);
        textoVidas.setHorizontalAlignment(SwingConstants.CENTER);
        textoVidas.setForeground(Color.black);
        textoVidas.setOpaque(false);
        textoVidas.setFont(new Font("TimesRoman", Font.BOLD, 65));
        //textoVidas.setBackground(Color.BLACK);
        labelInfo.add(textoVidas);



        ImageIcon imagenCaramelo = new ImageIcon("Candy Crush/Imagenes/Rayados/RayadosH/AMARILLO.png");
        JLabel objetivos = new JLabel();
        objetivos.setBounds(35, 333, 80, 80);
        objetivos.setIcon(new ImageIcon(imagenCaramelo.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
        objetivos.setOpaque(false);
        //objetivos.setBackground(Color.black);
        labelInfo.add(objetivos);

        JLabel textoObjetivos = new JLabel();
        if(n.getObjetivoCaramelo()!=3){
            textoObjetivos.setText(String.valueOf(n.getObjetivoCaramelo()));
            textoObjetivos.setBounds(150, 328, 80, 80);
            textoObjetivos.setHorizontalAlignment(SwingConstants.CENTER);
            textoObjetivos.setForeground(Color.black);
            textoObjetivos.setOpaque(false);
            textoObjetivos.setFont(new Font("TimesRoman", Font.BOLD, 65));
            //textoObjetivos.setBackground(Color.BLACK);
            labelInfo.add(textoObjetivos);
        }

        JLabel textoMovimientos = new JLabel();
        textoMovimientos.setText("Mov:");
        textoMovimientos.setBounds(30, 430, 120, 120);
        textoMovimientos.setHorizontalAlignment(SwingConstants.CENTER);
        textoMovimientos.setForeground(Color.black);
        textoMovimientos.setOpaque(false);
        textoMovimientos.setFont(new Font("TimesRoman", Font.BOLD, 40));
        //textoMovimientos.setBackground(Color.BLACK);
        labelInfo.add(textoMovimientos);
        

        getContentPane().add(labelInfo, BorderLayout.EAST);
        getContentPane().add(panel, BorderLayout.CENTER);
        pack();
        getContentPane().add(new JLabel(new ImageIcon("Candy Crush/Imagenes/fondo.png")));
        setVisible(true);



    
    
        























            /*this.juego = juego;
    
            setResizable(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLayout(new BorderLayout());
    
            jugador = new JLabel();
            jugador.setOpaque(false);
            jugador.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED,8));
            jugador.setBounds(Utils.labelSpacing, Utils.labelSpacing, Utils.labelWidth, Utils.labelHeight);

            panel = new Panel(juego, jugador);
            panel.add(jugador);

            JLabel objetivos = new JLabel();
            objetivos.setPreferredSize(new Dimension(Utils.panelWidth()/2, Utils.panelHeight()));
            objetivos.setOpaque(true);
            objetivos.setBackground(Color.PINK);

            labelInfo = new JPanel();
            labelInfo.setPreferredSize(new Dimension(Utils.panelWidth()/2, Utils.panelHeight()));
            labelInfo.setOpaque(true);
            tiempo=new JLabel();
            tiempo.setSize(labelInfo.getWidth(), HEIGHT);
            tiempo.setOpaque(true);

            tiempo.setBackground(Color.BLACK);
            labelInfo.add(tiempo,BorderLayout.PAGE_START);

            vidas=new JLabel();
            labelInfo.add(vidas);
            setVisible(true);

            movimientos=new JLabel();
            labelInfo.add(movimientos);
            setVisible(true);

            objetivoEyG=new JLabel();
            labelInfo.add(objetivoEyG);
            setVisible(true);

            objetivoG=new JLabel();
            labelInfo.add(objetivoG);
            setVisible(true);

            objetivoC=new JLabel();
            labelInfo.add(objetivoC);
            setVisible(true);

            getContentPane().add(objetivos, BorderLayout.EAST);
            getContentPane().add(panel, BorderLayout.CENTER);
            pack();
            getContentPane().add(new JLabel(new ImageIcon("Candy Crush/Imagenes/fondo.png")));
            setVisible(true);
    }*/
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

    public void notificarMovimiento(){
        /*Nivel n = juego.getNivel();
        movimientos.setText("Movimientos Restantes: "+String.valueOf(n.getMov()));
        vidas.setText("Vidas: "+String.valueOf(n.getVidas()));

        objetivoEyG.setText("Candy Crush/Gelatinas/Envueltos: "+String.valueOf(n.getObjetivoGelOEnv()));
        objetivoG.setText("Glaseados: "+String.valueOf(n.getObjetivoGlaseado()));

        JLabel obj = new JLabel();
        ImageIcon ico = new ImageIcon("Candy Crush/Imagenes/Caramelos/"+ n.getColorObjetivo().toString().toLowerCase()+".png");
        Image img = ico.getImage();
        Image new_img = img.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        obj.setIcon(new ImageIcon(new_img));
        objetivoC.setText("Caramelos: "+String.valueOf(n.getObjetivoCaramelo()));
        labelInfo.add(obj);
        */
    }

    public void notificarTiempo(int t){
        /*
        tiempo.setText(String.valueOf(t/60)+":"+String.valueOf(t%60));
        tiempo.setHorizontalTextPosition(SwingConstants.CENTER);
        */
    }
}
