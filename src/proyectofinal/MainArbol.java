/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectofinal;

import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Dialog.*;
import javax.swing.JOptionPane;

class Principal extends JFrame implements ActionListener
{
    private JMenuBar bar;
    private Dibujo_Arboles canv_arbol;
    JButton botoningresar = new JButton("Añadir");
    JButton botonbuscar = new JButton("Buscar");
    JButton botonnuevo = new JButton("Cerrar");
    JButton botonivel = new JButton("Nivel?");
    
    int ver,op,op1,op2;
    Arbol_binario x=new Arbol_binario();
    binario cab;        
    String a = JOptionPane.showInputDialog("Ingrese el primer dato");

    public Principal()
        {
            if(a != null)
            {
                try
                {    
                    cab = new binario(Integer.parseInt( a ));
                }
                catch(NumberFormatException e)
                {
                    System.exit( 0 );
                }
            }
            else
            {
                System.exit(0);
            }
        }
        
        public void actionPerformed(ActionEvent e)
    {    
        if(e.getSource() == botoningresar)
        {
            a=JOptionPane.showInputDialog ("Escriba el dato");
            if(a != null)
            {
               try
                {
                   cab=x.insertar(Integer.parseInt( a ),cab);
                   canv_arbol.repintar(cab);
                } 
                catch(NumberFormatException exc)
                {
                    JOptionPane.showMessageDialog(null," el dato " +a+ " no es valido");
                }
            }
        }
            else if(e.getSource() == botonbuscar)
            {
                a=JOptionPane.showInputDialog("Digite el dato a buscar");
                if(a != null)
                {
                    try
                    {
                        if(x.busqueda (Integer.parseInt( a ),cab))
                        {
                            JOptionPane.showMessageDialog(null, "Dato encontrado: " +Integer.parseInt( a ));
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, " " +a+ " no se encuentra en el arbol" );
                        }
                    } 
                    catch(NumberFormatException exc)
                    {
                        JOptionPane.showMessageDialog(null, " El elemento "+a+ ", no corresponde, Ingrese un numero Valido");
                    }
                }
            }
        
            if(e.getSource()==botonivel )
        { 
          
                   
                  
                     int y =x.altura(cab);
                    JOptionPane.showMessageDialog(null, "El nivel del arbol es  "+ y);
                    }          
        
                  
          if(e.getSource() ==botonnuevo )
        {
          
          System.exit(0);
          }
                 
    }

    public void dibujar() 
    {
        JPanel pan1 = new JPanel();
        JPanel pan2 = new JPanel();
        bar = new JMenuBar();
                  
        JMenu archivo = new JMenu("Archivo");
         JMenuItem cerrar=new JMenuItem("Salir");
        
        archivo.add(cerrar);
        bar.add(archivo);
        setJMenuBar(bar);

        canv_arbol = new Dibujo_Arboles(cab);
        
        botoningresar.addActionListener(this);// los eventos del boton
        botonbuscar.addActionListener(this);
        botonnuevo.addActionListener(this);
        botonivel.addActionListener(this);
        
        pan1 = new JPanel(new FlowLayout(FlowLayout.CENTER));// centrar botones
        pan1.add(botoningresar);// pane de botones
        pan1.add(botonbuscar);
        pan1.add(botonivel);;
        pan2.add(canv_arbol);// pane del dibujo del arbol

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        add("North", pan1);
        add("Center", canv_arbol);
        setTitle("Estructura de Datos");
        setVisible(true);
        cerrar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        
        
    }

    public static void main(String a[]) 
    {
        Principal ejecucion = new Principal();
        ejecucion.dibujar();
    }
}