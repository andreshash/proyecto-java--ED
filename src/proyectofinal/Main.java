package proyectofinal;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.math.*;
import java.awt.Toolkit;
import java.applet.Applet;
import java.awt.Image;


public class Main extends JFrame{

    // <editor-fold defaultstate="collapsed" desc=" Declaracion de Variables ">
    //Machetazo
    Main a;
    //fin-Machetazo

    Dibujo canvas = new Dibujo();
    int count_push=0;
    int count_add=0;

    JPanel panel_canvas = new JPanel();
    JPanel panel_principal = new JPanel();
    JPanel panel_botones = new JPanel();
    JMenuBar bar = new JMenuBar();
    Canvas lienzo = new Canvas();
    JButton jButton1 = new javax.swing.JButton();

    JMenu Menu_arch = new JMenu("Archivo");
    JMenu Menu_est =new JMenu("Estructuras");
    JMenu Menu_op =new JMenu("Operaciones");
    JMenu Menu_ayud =new JMenu("Ayuda");

    JMenu Menu_list = new JMenu("Listas");
    JMenuItem Item_cerrar = new JMenuItem("Salir");
    JMenuItem Item_volver = new JMenuItem("Volver");
    JMenuItem Item_acerca = new JMenuItem("Acerca de");
    JMenuItem Item_contenidos = new JMenuItem("Contenido");

    JMenuItem Item_crear_simple = new JMenuItem("Crear Lista Simple");
    JMenuItem Item_crear_doble = new JMenuItem("Crear Lista Doble");
    JMenuItem Item_crear_circular = new JMenuItem("Crear Lista Circular");
    JMenuItem Item_crear_pila = new JMenuItem("Crear Pila");
    JMenuItem Item_crear_cola = new JMenuItem("Crear Cola");
    JMenuItem Item_arbol = new JMenuItem("Crear Arbol");
    JMenuItem Item_AVL = new JMenuItem("Crear Arbol AVL");

    JMenuItem Item_op_add = new JMenuItem("Añadir nodo");
    JMenuItem Item_op_buscar = new JMenuItem("Buscar nodo");
    JMenuItem Item_op_mod = new JMenuItem("Editar nodo");
    JMenuItem Item_op_del = new JMenuItem("Eliminar nodo");
    JMenuItem Item_op_inv = new JMenuItem("Invertir");
    JMenuItem Item_op_push = new JMenuItem("Push");
    JMenuItem Item_op_pop = new JMenuItem("Pop");
    JMenuItem Item_op_invp = new JMenuItem("Invertir Pila");


    nodosimple cab_simp = inicabsi();//declaracion cabeza lista circular
    nodosimple cab_circ =volver_cabeza_circular();//declaracion cabeza lista circular
    nododoble cab_doble= iniciar_cab_d();// Declaracion de la cabeza de la lista doble(By Khukho)
    nodopila cab_pila=volverpila();
    nodosimple cab_cola=volvercola();
    nodosimple busq_circ =cab_circ;//declaracion nodo busqueda lista circular
    nodosimple busq_simp =cab_simp;//declaracion nodo busqueda lista simple
    nododoble busq_d =cab_doble;//declaracion nodo busqueda lista doble
    nodosimple busq_cola =cab_cola;//declaracion nodo busqueda cola

    


    int func=0; /**
                 * 0= No selecionado
                 * 1=Lista Simple
                 * 2=lista Circular
                 * 3=lista Doble
                 * 4=Cola
                 */
    boolean dibuja_circ=false;
    boolean encontro_circ=false;
    boolean dibuja_simp=false;
    boolean encontro_simp=false;
    boolean dibuja_d=false;
    boolean encontro_d=false;
    boolean dibuja_credit=true;
    boolean dibuja_p=false;
    boolean dibuja_c=false;
    boolean encontro_c=false;

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Declaracion de Estructuras ">

        // <editor-fold defaultstate="collapsed" desc=" Nodo Simple ">
        public class nodosimple{
            int dato;
            String desc;

            //declaramos el constructor de la estructura
            public void nodosimple(){}
            public void nodosimple(int dato,String desc){
                this.dato=dato;
                this.desc=desc;
            }

            nodosimple sig=null;
        }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc=" Nodo Doble ">
        public class nododoble{
            int dato;
            String desc;

            //declaramos el constructor de la estructura
            public void nododoble(){}
            public void nododoble(int dato,String desc){
                this.dato=dato;
                this.desc=desc;
            }

            nododoble ant;
            nododoble sig;
        }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc=" Nodo Pila ">
        public class nodopila{
            int dato;
            String desc;

            //declaramos el constructor de la estructura
            public void nodopila(){}
            public void nodopila(int dato,String desc){
                this.dato=dato;
                this.desc=desc;
            }

            nodopila sig;
        }
        // </editor-fold>


    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Listas simples ">  
        public nodosimple inicabsi(){
            nodosimple nuevo = new nodosimple();
            nuevo.dato=0;
            nuevo.desc="";
            nuevo.sig=null;
            
            return nuevo;
        }
        
        public void insertar_s (int dato , String desc){
            nodosimple p;
            p=cab_simp;
            while(p.sig!=null){
                p=p.sig;
            }
            nodosimple nuevo = new nodosimple();
            nuevo.dato=dato;
            nuevo.desc=desc;
            nuevo.sig=null;
            p.sig=nuevo;
            
        }

        public nodosimple buscar_s (int dato){
            nodosimple p=cab_simp,q=p;
            int f=0;
            q.dato=-1;
            while(p!=null){
                if(p.dato==dato && f!=1){
                    q=p;
                    f=1;
                }
                p=p.sig;
            }

            return q;
        }

        public void modificar_s(nodosimple t,int dato,String descripcion){
           t.dato=dato;
           t.desc=descripcion;
               }

        public void eliminar_s (nodosimple t){
           nodosimple p;
           p=cab_simp;

           while(p.sig!=t){
                p=p.sig;
           }
           p.sig=t.sig;
           t.sig=null;
           }

        
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Espacio de Trabajo de KhuKho ">

    public nododoble iniciar_cab_d(){   //funcion iniciar cabeza(By khukho)
    nododoble cab= new nododoble();
    cab.dato=0;
    cab.desc="";
    cab.ant=null;
    cab.sig=null;
    return cab;
    }


public void insertar_d(int dato, String desc){

    nododoble p;
    p= cab_doble;
    nododoble q=p;
    nododoble nuevo;
    q=q.sig;

    while(p.sig != null){
        p=p.sig;
    }
    q=p.ant;
     nuevo = new nododoble();
     nuevo.dato=dato;
     nuevo.desc=desc;

     p.sig=nuevo;
     nuevo.sig=null;
     nuevo.ant=p;
     
    }




public nododoble buscar_lista_d(int dato)
  {
    nododoble p,q=cab_doble;
    p=cab_doble;
    int ban=0;

    q.dato=-1;
   while(p!=null && ban==0)
   {if(p.dato==dato)
     {
        System.out.println("existe"+p.dato);
        q=p;
        p=p.sig;

      }
 else {p =p.sig;
      }
   }
    return q;
   }


public void modificar_lista_d(nododoble t,int dato,String desc){
   t.dato=dato;
   t.desc=desc;
       }

public void eliminar_d(nododoble t){

    t.ant.sig=t.sig;
    t.sig.ant=t.ant;
    t.sig=null;
    t.ant=null;

       }

        // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" Espacio de Trabajo de Galvis ">


    public nodosimple volver_cabeza_circular(){
    nodosimple cab= new nodosimple();
    cab.sig=cab;
    cab.dato = -1;
    return cab;
    }

    /*Esta funcion(insertar) inserta un nuevo nodo a cab_circ es decir, cab_circ es
 simplemente el nodo que une a todos los demas,entonces cuando lo vaya a dibujar.
 lo tendra que empezar desde cab_cir.sig*/

    public void insertar_ci (int dato,String descripcion){
    nodosimple p;
    p=cab_circ;
    while (p.sig != cab_circ ) {
    p=p.sig;
        }
   nodosimple nuevo=new nodosimple();
   nuevo.dato= dato;
   nuevo.desc=descripcion;
   nuevo.sig=p.sig;
   p.sig=nuevo;
         }

   public nodosimple buscar_ci(int dato){
   nodosimple s,p;
   int ban =0;
   s=p=cab_circ;
   p=p.sig;
   while(p!= cab_circ && ban != 1){
   if(p.dato==dato){
   s= p;
   ban =1;
      }
   p=p.sig;
      }
   return s;
      }

   public void modificar_ci(nodosimple t,int dato,String descripcion){
   t.dato=dato;
   t.desc=descripcion;
       }

   public void eliminar_ci (nodosimple t){
   nodosimple p;
   p=cab_circ;

   while(p.sig!=t){
   p=p.sig;
    }
   p.sig=t.sig;
   t.sig=null;
   }

   public void embutir_ci(nodosimple t,int dato,String descripcion){
   nodosimple nuevo= new nodosimple();
   nuevo.dato=dato;
   nuevo.desc=descripcion;
   nuevo.sig=t.sig;
   t.sig=nuevo;
        }

  public void invertir_ci(){
       nodosimple d,e,f,g;
       d =cab_circ.sig;
       e=new nodosimple();
       g=new nodosimple();
       e.sig=null;
      while(d!=cab_circ){
      nodosimple nuevo=new nodosimple();
      nuevo.dato=d.dato;
      nuevo.desc=d.desc;
      nuevo.sig=e;
      e=nuevo;
      d=d.sig;
         }
      f=e;
      while(f.sig.sig !=null){
      f=f.sig;
      }
      f.sig=null;
      g.sig=e;
      f.sig=g;
      cab_circ=g;
       }


        // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" Espacio de Trabajo de Galvis II ">

        public nodopila volverpila(){
nodopila s=new nodopila();
    s.dato=0;
    s.desc=null;
    s.sig=null;
    return s;
  }
public void push (int dato, String descripcion){
   if(cab_pila.dato==0){
       cab_pila.dato=dato;
       cab_pila.desc=descripcion;
   }else{
    nodopila nuevo=new nodopila();
    nuevo.dato=dato;
    nuevo.desc=descripcion;
    nuevo.sig=cab_pila;
    cab_pila=nuevo;
    }
}
public nodopila pop (){
    nodopila b=cab_pila,c=cab_pila.sig;
    cab_pila=c;
    b.sig=null;
    return b;
}
public void invertirpila (){
    nodopila b=new nodopila(),c=cab_pila;
    nodopila nuevo;
    while(cab_pila !=null){
        nuevo=pop();
      nuevo.sig=b;
      b=nuevo;
    }
    c=b;
    while(c.sig.sig !=null){
        c=c.sig;
            }
    c.sig=null;
    cab_pila= b;
       }
 public void imprepil(){
      nodopila w=cab_pila;
      System.out.print( "\n");
      while(w!=null){
      System.out.print(w.dato + "  ");
      w=w.sig;
         }
      System.out.print( "\n");
         }
public nodosimple volvercola(){
nodosimple s=new nodosimple();
    s.dato=0;
    s.desc=null;
    s.sig=null;
    return s;
}
public void insertarcola(int dato,String descripcion){
nodosimple n= cab_cola;
if(cab_cola.dato==0){
       cab_cola.dato=dato;
       cab_cola.desc=descripcion;
   }else{
while(n.sig !=null){
    n= n.sig;
    }
nodosimple vo=new nodosimple();
vo.dato=dato;
vo.desc=descripcion;
n.sig=vo;
    }
}


public nodosimple buscarcola(int dato){
    nodosimple b=cab_cola,c=cab_cola;
    int ban =0;
    while(b !=null && ban ==0){
     if(b.dato==dato){
     c=b;
     ban=1;
     }
     b=b.sig;
    }
    return c;
    }
public void modificarcola (nodosimple nodo, int dato, String descripcion){
  nodo.dato=dato;
   nodo.desc=descripcion;
    }
public void eliminarcola (nodosimple t){
    nodosimple p=cab_cola;
    while(p.sig!=t){
   p=p.sig;
    }
   p.sig=t.sig;
   t.sig=null;
}

public void invertircola (){
    nodosimple b=new nodosimple();
    nodosimple u=cab_cola,t=u;
    while(u !=null){
     nodosimple nuevo= new nodosimple();
      nuevo.dato=u.dato;
      nuevo.desc=u.desc;
      nuevo.sig=b;
      b=nuevo;
      u=u.sig;
    }
    t=b;
    while(t.sig.sig !=null){
        t=t.sig;
    }
    t.sig=null;
    cab_cola=b;
        }
public void imprecol(){
      nodosimple w=cab_cola;
      System.out.print( "\n");
      while(w!=null){
      System.out.print(w.dato + "  ");
      w=w.sig;
         }
      System.out.print( "\n");
         }
        // </editor-fold>

    
    public class Dibujo extends Canvas{
        

        @Override
        public void paint (Graphics g){


            getClass().getResource("/proyectofinal/utp.JPG");

            if(dibuja_credit)initComponents(g);
            g.setColor(Color.blue);
            //g.drawOval(20, 20, 520, 520);
            if(dibuja_circ)dibuja_nodo_circ(g);
            if(encontro_circ)encontrar_circular(g);
            if(dibuja_simp)dibujar_simple(g);
            if(encontro_simp)encontrar_simple(g);
            if(dibuja_d)dibujar_doble(g);
            if(encontro_d)encontrar_doble(g);
            if(dibuja_p)dibujar_pila(g);
            if(dibuja_c)dibujar_cola(g);
            if(encontro_c)encontrar_cola(g);

        }


        public void initComponents (Graphics g){
            g.drawString("Estructuras de Datos", 300, 110);
            g.drawString("Estructuras de Datos", 301, 110);
            g.drawString("Este programa permite manejar las diferentes estructuras de datos",210, 135);
            g.drawString("de una forma grafica simple.", 210, 155);

            g.drawString("Creado Por:", 210, 190);
            g.drawString("Creado Por:", 211, 190);
            g.drawString("Oscar Eduardo Bernal Sánchez", 210, 210);
            g.drawString("Julian Andres Galvis", 210, 230);
            g.drawString("Juan de Jesus Fernandez Graciano", 210, 250);
            g.drawString("Luis Stiven Ponce Perlaza", 210, 270);
            g.drawString("Copyright © 2011 Todos los derechos reservados", 210, 295);
            
        }

        public void dibuja_nodo_circ (Graphics g){
            int numnodos=0;
            int ite=0;
            int ct1,ct2;
            int rad=180;
            double angulo= 0;
            nodosimple p,q;
            p=cab_circ;
            q=p;
            while(p.sig!=q){
                p=p.sig;
                numnodos++;
            }
            angulo= 2*Math.PI/numnodos;
            g.setColor(Color.BLACK);
            g.drawOval(50, 50, rad*2, rad*2 );
            g.drawOval(50+1, 50, rad*2, rad*2 );
            g.drawOval(50, 50+1, rad*2, rad*2 );
            p=cab_circ.sig;
            while(ite<numnodos){
                ct1=(rad+50 + (int)((rad*Math.cos(angulo*ite))));
                ct2 = (rad+50 + (int)((rad*Math.sin(angulo*ite))));
                g.setColor(new java.awt.Color(4, 0, 87));
                g.fillOval(  ct1-25, ct2-25, 50, 50);
                g.setColor(Color.cyan);
                g.drawOval(  ct1-25, ct2-25, 50, 50);
                g.setColor(Color.WHITE);
                g.drawString("" + p.dato, ct1 -15, ct2);
                p=p.sig;
                ite++;
            }
            ct1=(rad+50 + (int)((rad*Math.cos(angulo*ite))));
            ct2 = (rad+50 + (int)((rad*Math.sin(angulo*ite))));

            g.setColor(Color.BLACK);
            g.drawLine( ct1-35 , ct2-25, ct1-35, ct2+25);
            g.drawLine( ct1-40, ct2+15, ct1-35, ct2+25);
            g.drawLine( ct1-30, ct2+15, ct1-35, ct2+25);

            g.drawLine( ct1-35+1 , ct2-25, ct1-35+1, ct2+25);
            g.drawLine( ct1-40+1, ct2+15, ct1-35+1, ct2+25);
            g.drawLine( ct1-30+1, ct2+15, ct1-35+1, ct2+25);

            g.drawLine( ct1-35 , ct2-25+1, ct1-35, ct2+25+1);
            g.drawLine( ct1-40, ct2+15+1, ct1-35, ct2+25+1);
            g.drawLine( ct1-30, ct2+15+1, ct1-35, ct2+25+1);

            g.drawString("Lista Circular", 10, 20);

        }
        public void encontrar_circular(Graphics g){
           int numnodos=0;
            int ite=0,ban=0;
            int ct1,ct2;
            int rad=180;
            double angulo= 0;
            nodosimple p,q;
            p=cab_circ;
            q=p;
            while(p.sig!=q){
                p=p.sig;
                numnodos++;
            }
            angulo= 2*Math.PI/numnodos;
            p=cab_circ.sig;
            while(ite<numnodos){
                ct1=(rad+50 + (int)((rad*Math.cos(angulo*ite))));
                ct2 = (rad+50 + (int)((rad*Math.sin(angulo*ite))));
                
                if(p.dato==busq_circ.dato && ban==0){
                   g.setColor(Color.blue);
                   ct1=(rad+50 + (int)((rad*Math.cos(angulo*ite))));
                   ct2 = (rad+50 + (int)((rad*Math.sin(angulo*ite))));
                   g.fillOval(  ct1-27 , ct2-27 , 15, 15);
                   g.setColor(Color.cyan);
                   g.drawOval(  ct1-27 , ct2-27 , 15, 15);
                   ban=1;
                   }

                p=p.sig;
                ite++;
            }
        }

        public void dibujar_simple(Graphics g){
            nodosimple p=cab_simp;
            int numnodos = 0;
            while(p.sig!=null){
                p=p.sig;
                numnodos++;
            }
            
            g.setColor(Color.BLACK);
            // dibujo 10-680
            g.drawLine(100, 150, 700, 150);
            g.drawLine(100, 151, 700, 151);
            g.drawLine(700, 150, 690, 145);
            g.drawLine(700, 151, 691, 146);
            g.drawLine(700, 150, 690, 155);
            g.drawLine(700, 151, 690, 156);
            g.fillOval(95, 145, 10, 10);

            int espace = 580/numnodos;
            int ite=0;
            p=cab_simp.sig;
            
            while(ite<numnodos){
                g.setColor(new java.awt.Color(4, 0, 87));
                g.fillRect( (ite * espace) + 110 , 135 , 30, 30);
                g.setColor(Color.cyan);
                g.drawRect( (ite * espace) + 110 , 135 , 30, 30);
                g.setColor(Color.white);
                g.drawString("" + p.dato, (ite * espace) + 115 , 155);
                p=p.sig;
                ite++;
            }
            g.setColor(Color.black);
            g.drawString("null", 710, 155);

            g.drawString("Lista Simple", 10, 20);

        }
        public void encontrar_simple(Graphics g){
            nodosimple p=cab_simp;
            int flag=0;
            int ite=0;
            int numnodos = 0;
            while(p.sig!=null){
                p=p.sig;
                numnodos++;
            }
            int espace = 580/numnodos;
            p=cab_simp.sig;
            while(p!=null){
                g.setColor(Color.blue);
                if(p.dato == busq_simp.dato && flag == 0){
                    g.fillOval((ite * espace) + 110, 130, 10, 10);
                    g.setColor(Color.cyan);
                    g.drawOval((ite * espace) + 110, 130, 10, 10);
                    flag=1;
                }
                
                p=p.sig;
                ite++;
            }

        }

        public void dibujar_doble(Graphics g){
            nododoble p=cab_doble;
            int numnodos = 0;
            while(p.sig!=null){
                p=p.sig;
                numnodos++;
            }
            
            g.setColor(Color.BLACK);
            // dibujo 10-680
            g.drawLine(100, 140, 700, 140);
            g.drawLine(100, 141, 700, 141);
            g.drawLine(700, 140, 690, 135);
            g.drawLine(700, 140, 691, 136);
            g.drawLine(700, 140, 690, 145);
            g.drawLine(700, 140, 690, 146);

            g.drawLine(100, 160, 700, 160);
            g.drawLine(100, 161, 700, 161);
            g.drawLine(100, 160,110, 155);
            g.drawLine(100, 161,110, 156);
            g.drawLine(100, 160,110, 165);
            g.drawLine(100, 161,110, 166);

            int espace = 580/numnodos;
            int ite=0;
            p=cab_doble.sig;

            while(ite<numnodos){
                g.setColor(new java.awt.Color(4, 0, 87));
                g.fillRect( (ite * espace) + 120 , 135 , 30, 30);
                g.setColor(Color.cyan);
                g.drawRect( (ite * espace) + 120 , 135 , 30, 30);
                g.drawRect( (ite * espace) + 120, 135 , 30, 30);
                g.setColor(Color.white);
                g.drawString("" + p.dato, (ite * espace) + 125 , 155);
                p=p.sig;
                ite++;
            }
            g.setColor(Color.black);
            g.drawString("null", 710, 155);
            g.drawString("null", 70, 155);

            g.drawString("Lista Doble", 10, 20);

        }
        public void encontrar_doble(Graphics g){
            nododoble p=cab_doble;
            
            int flag=0;
            int ite=0;
            int numnodos = 0;
            while(p.sig!=null){
                p=p.sig;
                numnodos++;
            }
            int espace = 580/numnodos;
            p=cab_doble.sig;
            while(p!=null){
                g.setColor(Color.blue);
                
                if(p.dato == busq_d.dato && flag == 0){
                    g.fillOval((ite * espace) + 115, 130, 10, 10);
                    g.setColor(Color.cyan);
                    g.drawOval((ite * espace) + 115, 130, 10, 10);
                    flag=1;
                }

                p=p.sig;
                ite++;
            }

        }

        public void dibujar_pila(Graphics g){

            nodopila p=cab_pila;
            int numnodos = 1;
            while(p.sig!=null){
                p=p.sig;
                numnodos++;
            }

            g.setColor(Color.BLACK);
            // dibujo 10-680
            g.drawLine(400, 50, 400, 450);
            g.drawLine(401, 50, 401, 450);
            g.drawLine(399, 50, 399, 450);
            g.fillRect(350,450,100,20);


            int espace = 380/numnodos;
            int ite=0;
            p=cab_pila;

            while(ite<numnodos){
                g.setColor(new java.awt.Color(4, 0, 87));
                g.fillRect( 375 , (ite * espace)+ 65 , 50, 30);
                g.setColor(Color.cyan);
                g.drawRect( 375 , (ite * espace) +  65 , 50, 30);

                g.setColor(Color.white);
                g.drawString("" + p.dato, 392 , (ite * espace) +  85);
                p=p.sig;
                ite++;
            }

            g.drawString("Pila", 10, 20);
        }

        public void dibujar_cola(Graphics g){
            nodosimple p=cab_cola;
            int numnodos = 1;
            while(p.sig!=null){
                p=p.sig;
                numnodos++;
            }

            g.setColor(Color.BLACK);
            // dibujo 10-680
            //g.drawLine(100, 150, 700, 150);
            //g.drawLine(100, 151, 700, 151);

            //g.drawLine(100, 150, 690, 145);
            //g.drawLine(700, 151, 691, 146);
            //g.drawLine(700, 150, 690, 155);
            //g.drawLine(700, 151, 690, 156);

            g.drawLine(100, 150, 700, 150);
            g.drawLine(100, 151, 700, 151);
            g.drawLine(100, 150,110, 145);
            g.drawLine(100, 151,110, 146);
            g.drawLine(100, 150,110, 155);
            g.drawLine(100, 151,110, 156);

            g.fillOval(695, 145, 10, 10);

            int espace = 580/numnodos;
            int ite=0;
            p=cab_cola;

            while(ite<numnodos){
                g.setColor(new java.awt.Color(4, 0, 87));
                g.fillRect( (ite * espace) + 120 , 135 , 30, 30);
                g.setColor(Color.cyan);
                g.drawRect( (ite * espace) + 120 , 135 , 30, 30);
                g.setColor(Color.white);
                g.drawString("" + p.dato, (ite * espace) + 125 , 155);
                p=p.sig;
                ite++;
            }
            g.setColor(Color.black);
            g.drawString("null", 70, 155);

            g.drawString("Cola", 10, 20);

        }
        public void encontrar_cola(Graphics g){
            nodosimple p=cab_cola;
            int flag=0;
            int ite=0;
            int numnodos = 0;
            while(p.sig!=null){
                p=p.sig;
                numnodos++;
            }
            int espace = 580/numnodos;
            p=cab_cola;
            while(p!=null){
                g.setColor(Color.blue);
                if(p.dato == busq_simp.dato && flag == 0){
                    g.fillOval((ite * espace) + 110, 130, 10, 10);
                    g.setColor(Color.cyan);
                    g.drawOval((ite * espace) + 110, 130, 10, 10);
                    flag=1;
                }

                p=p.sig;
                ite++;
            }

        }

        public void repintar(){
            repaint();
        }
    }

    public void principal(){

        setJMenuBar(bar);
        
        bar.add(Menu_arch);
        bar.add(Menu_est);
        bar.add(Menu_op);
        bar.add(Menu_ayud);
        
        Menu_est.add(Menu_list);
        Menu_arch.add(Item_volver);
        Menu_arch.add(Item_cerrar);
        Menu_ayud.add(Item_acerca);
        Menu_ayud.add(Item_contenidos);
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal/utp.JPG")));
        
        Menu_list.add(Item_crear_simple);
        Menu_list.add(Item_crear_doble);
        Menu_list.add(Item_crear_circular);
        Menu_est.add(Item_crear_pila);
        Menu_est.add(Item_crear_cola);
        Menu_est.add(Item_arbol);
        Menu_est.add(Item_AVL);
        
        Menu_op.add(Item_op_add);
        Menu_op.add(Item_op_buscar);
        Menu_op.add(Item_op_mod);
        Menu_op.add(Item_op_del);
        Menu_op.add(Item_op_inv);
        Menu_op.add(Item_op_push);
        Menu_op.add(Item_op_pop);
        Menu_op.add(Item_op_invp);
        Item_op_push.setVisible(false);
        Item_op_pop.setVisible(false);
        Item_op_invp.setVisible(false);
        Item_op_inv.setVisible(false);
        Item_op_inv.setEnabled(false);
        Item_op_buscar.setEnabled(false);
        
        panel_canvas.add(canvas);
        panel_botones.add(jButton1);
        Menu_op.setEnabled(false);
        Item_op_mod.setEnabled(false);
        Item_op_del.setEnabled(false);



        setSize(800, 600);
        Dimension d = new Dimension(800,600);
        setMaximumSize(d);
        setMinimumSize(d);
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //panel_principal.add(panel_botones);
        panel_principal.add(panel_canvas);


        add("North", panel_principal);
        add("Center", canvas);
        setTitle("Estructuras de Datos");
        setVisible(true);

        a=this;
        Item_volver.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                a.setVisible(false);
                Main ejecucion = new Main();
                ejecucion.principal();
            }
        });

        Item_cerrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(1);
            }
        });

        Item_crear_circular.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Menu_op.setEnabled(true);
                Menu_est.setEnabled(false);
                func=2;
            }
        });

        Item_crear_pila.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Menu_op.setEnabled(true);
                Menu_est.setEnabled(false);
                Item_op_buscar.setVisible(false);
                Item_op_mod.setVisible(false);
                Item_op_del.setVisible(false);
                Item_op_add.setVisible(false);
                Item_op_push.setVisible(true);
                Item_op_pop.setVisible(true);
                Item_op_invp.setVisible(true);
                Item_op_push.setEnabled(true);
                Item_op_pop.setEnabled(false);
                Item_op_invp.setEnabled(false);
            }
        });

        Item_crear_simple.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Menu_op.setEnabled(true);
                Menu_est.setEnabled(false);
                func=1;
            }
        });

        Item_crear_cola.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Menu_op.setEnabled(true);
                Menu_est.setEnabled(false);
                Item_op_inv.setVisible(true);
                func=4;
            }
        });

        Item_crear_doble.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Menu_op.setEnabled(true);
                Menu_est.setEnabled(false);
                func=3;
            }
        });

        Item_arbol.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Principal ejecucion = new Principal();
                ejecucion.dibujar();
            }
        });

        Item_op_buscar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                switch(func){

                    case 1: //lista simple

                        busq_simp = buscar_s(Integer.parseInt(JOptionPane.showInputDialog("Ingrese Dato a Buscar")));
                        if(busq_simp.dato!=-1){
                            Item_op_mod.setEnabled(true);
                            if(count_add>1)Item_op_del.setEnabled(true);
                        }
                        dibuja_simp=true;
                        encontro_simp=true;
                        canvas.repintar();
                        break;

                    case 2: //lista circular

                        busq_circ = buscar_ci(Integer.parseInt(JOptionPane.showInputDialog("Ingrese Dato a Buscar")));
                        if(busq_circ.dato!=-1){
                            Item_op_mod.setEnabled(true);
                            if(count_add>1)Item_op_del.setEnabled(true);
                        }
                        dibuja_circ=true;
                        encontro_circ=true;
                        canvas.repintar();
                        break;

                    case 3: //lista circular

                        busq_d = buscar_lista_d(Integer.parseInt(JOptionPane.showInputDialog("Ingrese Dato a Buscar")));
                        if(busq_d.dato!=-1){
                            Item_op_mod.setEnabled(true);
                            if(count_add>1)Item_op_del.setEnabled(true);
                        }
                        dibuja_d=true;
                        encontro_d=true;
                        canvas.repintar();
                        break;

                    case 4: //cola

                        busq_cola = buscarcola(Integer.parseInt(JOptionPane.showInputDialog("Ingrese Dato a Buscar")));
                        if(busq_cola.dato!=-1){
                            Item_op_mod.setEnabled(true);
                            if(count_add>1)Item_op_del.setEnabled(true);
                        }
                        dibuja_c=true;
                        encontro_c=true;
                        canvas.repintar();
                        break;
                }

            }
        });

        Item_op_mod.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Item_op_mod.setEnabled(false);
                Item_op_del.setEnabled(false);

                switch(func){

                    case 1: //lista simp

                        modificar_ci(busq_simp,Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo dato")),JOptionPane.showInputDialog("Ingrese la nueva Descripcion"));
                        dibuja_simp=true;
                        encontro_simp=false;
                        canvas.repintar();
                        break;

                    case 2: //lista circular

                        modificar_ci(busq_circ,Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo dato")),JOptionPane.showInputDialog("Ingrese la nueva Descripcion"));
                        dibuja_circ=true;
                        encontro_circ=false;
                        canvas.repintar();
                        break;

                    case 3: //lista doble

                        modificar_lista_d(busq_d,Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo dato")),JOptionPane.showInputDialog("Ingrese la nueva Descripcion"));
                        dibuja_d=true;
                        encontro_d=false;
                        canvas.repintar();
                        break;

                   case 4: //cola

                        modificarcola(busq_simp,Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo dato")),JOptionPane.showInputDialog("Ingrese la nueva Descripcion"));
                        dibuja_c=true;
                        encontro_c=false;
                        canvas.repintar();
                        break;
                }

            }
        });

        Item_op_del.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Item_op_mod.setEnabled(false);
                Item_op_del.setEnabled(false);
                count_add--;
                switch(func){

                    case 1: //lista simple

                        eliminar_s(busq_simp);
                        dibuja_simp=true;
                        encontro_simp=false;
                        canvas.repintar();
                        break;

                    case 2: //lista circular

                        eliminar_ci(busq_circ);
                        dibuja_circ=true;
                        encontro_circ=false;
                        canvas.repintar();
                        break;

                    case 3: //lista doble

                        eliminar_d(busq_d);
                        dibuja_d=true;
                        encontro_d=false;
                        canvas.repintar();
                        break;

                   case 4: //cola

                        eliminarcola(busq_cola);
                        dibuja_c=true;
                        encontro_c=false;
                        canvas.repintar();
                        break;

                }

            }
        });

        Item_AVL.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

		arbol_AVL x = new arbol_AVL();
		x.Principal_avl();

            }
        });

        Item_op_add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Item_op_buscar.setEnabled(true);
                count_add++;
                switch(func){

                    case 1: //lista simple
                        insertar_s(Integer.parseInt(JOptionPane.showInputDialog("Ingrese Dato")),JOptionPane.showInputDialog("Ingrese Descripcion"));
                        dibuja_simp=true;
                        canvas.repintar();
                        break;

                    case 2: //lista circular
                        insertar_ci(Integer.parseInt(JOptionPane.showInputDialog("Ingrese Dato")),JOptionPane.showInputDialog("Ingrese Descripcion"));
                        dibuja_circ=true;
                        canvas.repintar();
                        break;
                
                
                case 3: //lista doble
                        insertar_d(Integer.parseInt(JOptionPane.showInputDialog("Ingrese Dato")),JOptionPane.showInputDialog("Ingrese Descripcion"));
                        dibuja_d=true;
                        canvas.repintar();
                        break;

                case 4: //cola
                        insertarcola(Integer.parseInt(JOptionPane.showInputDialog("Ingrese Dato")),JOptionPane.showInputDialog("Ingrese Descripcion"));
                        dibuja_c=true;
                        Item_op_inv.setEnabled(true);
                        canvas.repintar();
                        break;
                }
                dibuja_credit=false;
            }
        });

        Item_op_push.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

		push(Integer.parseInt(JOptionPane.showInputDialog("Ingrese Dato")),JOptionPane.showInputDialog("Ingrese Descripcion"));
                dibuja_p=true;
                dibuja_credit=false;
                if(count_push>=1){
                    Item_op_pop.setEnabled(true);
                    Item_op_invp.setEnabled(true);
                }else{
                    Item_op_pop.setEnabled(false);
                    Item_op_invp.setEnabled(false);
                }
                count_push++;
                canvas.repintar();
            }
        });

        Item_op_pop.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

		pop();
                dibuja_p=true;
                dibuja_credit=false;
                count_push--;
                if(count_push<=1){
                    Item_op_pop.setEnabled(false);
                    Item_op_invp.setEnabled(false);
                }else{
                    Item_op_pop.setEnabled(true);
                    Item_op_invp.setEnabled(true);
                }
                canvas.repintar();
            }
        });

        Item_op_invp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

		invertirpila();
                dibuja_p=true;
                dibuja_credit=false;
                canvas.repintar();
            }
        });

        Item_op_inv.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

		invertircola();
                dibuja_c=true;
                dibuja_credit=false;
                canvas.repintar();
            }
        });

        Item_acerca.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                new Acerca_de().setVisible(true);
            }
        });

        Item_contenidos.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                new Contenidos().setVisible(true);
            }
        });

    }

    public static void main(String[] args) {
        new Welcome().setVisible(true);
        
    }

}
