
package proyectofinal;


import java.io.*;
import javax.swing.JOptionPane;
import java.awt.Dialog.*;
import java.awt.*;
class binario
{
    int info;
    binario izq;
    binario der;
    binario (int info)
    {
        this.info=info;
        izq=der=null;
    }
}

public class Arbol_binario
{
    public String quitar_espacios_seguidos(String texto)
    {
        String nuevo = "";
        for(int a = 0; a < texto.length() - 1; a++) // longitu de cadena compara
        {
            if(texto.charAt(a) != 32 || texto.charAt(a+1) != 32)
                nuevo += texto.charAt(a);
        }
        nuevo += texto.charAt(texto.length()-1);
        return nuevo;
    }

    
    public boolean busqueda (int x,binario t)
    {
       
        int q=0;
        while ((q!=1) && t!=null)
        {
            if (t.info==x)
            {
                q=1;
            }
            else
            {
                if (t.info<x)
                {
                    t=t.der;
                }
                else
                {
                    t=t.izq;
                }
            }
        }
        if (q==0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public binario insertar (int x,binario t)
    {
        if (t.info==x)
        {
            JOptionPane.showMessageDialog(null, "El elemento " +x+" ya se encuentra, Ingrese un nuevo elemento");
        }
        else
        {
            if (t.info>x)
            {
                if (t.izq==null)
                {
                    binario q=new binario (x);
                    t.izq=q;
                }
                else
                {
                    insertar (x,t.izq);
                }
            }
            else
            {
                if (t.der==null)
                {
                    binario q=new binario (x);
                    t.der=q;
                }
                else
                {
                    insertar (x,t.der);
                }
            }
        }
        return t;
    }

    
    
    public int verificar (binario j,int x)
    {
        int r=0;
        if (x>j.info)
        {
            r=1;
        }
        else
        {
            r=0;
        }
        return r;
    }
    public int altura(binario x)
    {
        int alturaizq =0;
        int alturader=0;
        binario p=x;
        if(p.izq != null && p.der!= null)
        {
            alturaizq+= 1+altura(p.izq);
            alturader+= 1+altura(p.der);
        }
        else if(p.der !=null)
        //(p.izq== null)   p.der !=null)
        {
            alturader+= 1+altura(p.der);
        }
        else if( p.izq!= null)
        //(p.der==null) && p.izq!= null)
        {
            alturaizq+= 1+altura(p.izq);
        }
        else
        {
            return 1;
        }
        if(alturaizq>alturader)
        return alturaizq;
        else
        return alturader;
    }
    {
        String a;
        int ver,b,op,op1,op2;
    }
}
