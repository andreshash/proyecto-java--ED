
package proyectofinal;

import java.math.*;
import javax.swing.*;
import java.awt.*;

 class Dibujo_Arboles extends Canvas  // funcion canvas
{
    Arbol_binario bin = new Arbol_binario(); 
    private int X = 600;
    private int Y = 20;
    private int SeparacionVertical = 45;
    private int SeparacionHorizontal = 25;
    private int diametro = 35;
    private int N;
    binario raiz;
   
    Dibujo_Arboles(binario cab)
    {
       this.N = bin.altura(cab);
        this.raiz = cab;
    }
    
    public void paint(Graphics g)
    {  
        recorrer_y_pintar(g,raiz);
    }
    
    public void repintar(binario cab)
    {
        this.N = bin.altura(cab);
        this.raiz = cab;
        X = 600;
        Y = 20;
        repaint();
    }
    
    public void pintar_nodo(Graphics g, int dato)
    {   g.setColor(new java.awt.Color(4, 0, 87));
        g.fillOval(X,Y,diametro,diametro);
        g.setColor(Color.cyan);
        g.drawOval(X,Y,diametro,diametro);// pinta  ovalo con relleno color e
       // g.drawOval(X,Y,diametro,diametro);// pinta  ovalo sin color e
        g.setColor(Color.white);
        //g.setFont( new Font( "Serif", Font.BOLD, 16 ) );
        g.drawString(""+dato,X+10,Y+20);
    }
    
    public void pintar_linea_izq(Graphics g)
    {   g.setColor(Color.black);
        g.drawLine(X+diametro/2,Y+diametro,(int)(X-(Math.pow(2,N-2)*SeparacionHorizontal)+diametro/2),Y+SeparacionVertical);
    }
    
    public void pintar_linea_der(Graphics g)
    {    
        g.setColor(Color.black);
        g.drawLine(X+diametro/2,Y+diametro,(int)(X+(Math.pow(2,N-2)*SeparacionHorizontal)+diametro/2),Y+SeparacionVertical);
    }
    
    public void recorrer_y_pintar(Graphics g, binario cab)
    {
        if(cab.izq != null && cab.der != null)
        {
            pintar_nodo(g, cab.info);
            pintar_linea_izq(g);
            pintar_linea_der(g);
            
            X -= Math.pow(2,N-2)*SeparacionHorizontal;
            N--;
            Y += SeparacionVertical;
            pintar_nodo(g, cab.izq.info);
            recorrer_y_pintar(g,cab.izq);
            
            X += Math.pow(2,N-1)*SeparacionHorizontal*2;
            pintar_nodo(g, cab.der.info);
            recorrer_y_pintar(g,cab.der);
            
            X -= Math.pow(2,N-1)*SeparacionHorizontal;
            Y -= SeparacionVertical;
            N++;
        }
        else if(cab.izq == null && cab.der != null)
        {
            pintar_nodo(g, cab.info);
            pintar_linea_der(g);
            
            X += Math.pow(2,N-2)*SeparacionHorizontal;
            N--;
            Y += SeparacionVertical;
            pintar_nodo(g, cab.der.info);
            recorrer_y_pintar(g,cab.der);
            
            X -= Math.pow(2,N-1)*SeparacionHorizontal;
            Y -= SeparacionVertical;
            N++;
        }
        else if(cab.izq != null && cab.der == null)
        {
            pintar_nodo(g, cab.info);
            pintar_linea_izq(g);
            
            X -= Math.pow(2,N-2)*SeparacionHorizontal;
            N--;
            Y += SeparacionVertical;
            pintar_nodo(g, cab.izq.info);
            recorrer_y_pintar(g,cab.izq);
            
            X += Math.pow(2,N-1)*SeparacionHorizontal;
            Y -= SeparacionVertical;
            N++;
        }
        else
        {
            pintar_nodo(g, cab.info);
        }
    }
}
