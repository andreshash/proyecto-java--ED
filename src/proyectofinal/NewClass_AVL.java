
package proyectofinal;

import javax.swing.*;                                //DEFINIMOS LAS LIBRERIAS
    import java.awt.*;
    
     class arbolGrafico extends Frame              //DEFINIMOS LA CLASE ARBOL GRAFICO Y LLAMAMOS A FRAME QUE ES PARA EL MODO GRAFICO
    {
    arbol a;                                             //DEFINIMOS UNA VARIABLE DE TIPO ARBOL A
    
    public arbolGrafico (arbol p)                        //DEFINIMOS UN METODO DE TIPO ARBOL GRAFICO  QUE ME RECIBE UNA VARIABLE P DE TIPO ARBOL
    {
    a = p;                                               //IGUALAMOS LA VARIABLE A = P, DONDE A ES DE TIPO ARBOL AL IGUAL QUE P
    setTitle (" ·····ARBOL GRAFICO····· ");              //LE COLOCAMOS EL TITULO QUE ES ARBOL GRAFICO
    setSize (1024, 768);                                 //LE DAMOS EL GRANDOR DE LA VENTANA
    setBackground(Color.gray);                           //DEFINIMOS EL FONDO DE LA VENTANA
    }
    
    public void paint(Graphics g)                        //CREO UN METODO DE TIPO PAINT QUE ME RECCIBE UN GRAPHICS G y me pinta las hojas, ESTE ME AYUDA A LA REALIZACION DEL GRAFICO
                                                            
    { 
    pintarHoja(a, g, 500, true, 500);                    //llama el metodo pintarHoja y envia el arbol ,la funcion graphics,
                                                         //una coordenada de tipo entero un booleano y otra coordenada
    }
    
    public void pintarHoja(arbol b, Graphics g, int x, boolean primera, int cambio)//CREAMOS UN METODO LLAMADO PINTAR HOJA QUE RECIBE UN ARBOL DE TIPO b, un graphics g ,
                                                                                   //un entero de tipo x que sera la posicion, una variable de tipo boolean llamado primera
                                                                                   //y una variable de tipo entero llamado cambio
    {
    int prof = darProfundidad(b.info);                   //defino una variable entera  prof como darprofundidad cogiendo la informacion que esta en b
    if (b!=null)                                         //si b es diferente de null
    {
    if (b.rojo)                                          //si el dato es rojo(todos los datos ingresados son rojos)
    {
    g.setColor(Color.black);                                //DEFINO EL COLOR DE LOS CIRCULOS DONDE VAN A INGRESAR LOS NUMEROS EN ESTE CASO AZUL
    }
    else
    {
    g.setColor(Color.black);                               //DEFINO EL COLOR DE LOS CIRCULOS DONDE VAN A INGRESAR LOS NUMEROS EN ESTE CASO AZUL
    }
    g.fillOval(x,(100*prof),35,35);                       //en esta parte del programa creamos la figura redonda donde recibe una posicion, la profundidad la multiplica
                                                          //por 100 , para saber la distancia y el radio
    g.setColor(Color.white);                              //DEFINO EL COLOR DE LOS NUMEROS A INGRESAR EN ESTE CASO BLANCO
    g.drawString(""+b.info,x+10,(100*prof)+19);           //pinte dentro de el circulo los numeros de color blanco 
    
    }
    if (b.izq!=null)                                      //si b.izq es diferente de null
    {
    g.setColor (Color.white);                               //DEFINO EL COLOR DE LAS ARISTAS EN ESTE CASO ROJO
    if (!primera)                                         //si es diferente de primera
    {
    g.drawLine(x+15,(100*prof)+35,x-(cambio/2)+15,(100*(prof+1)));     //dibuja una linea de color rojo donde recibe las posiciones x1,y1,x2,y2
    pintarHoja(b.izq,g,x-(cambio/2),false, cambio/2);                  //pinta la hoja en estas posiciones hacia la izquierda 
    }
    else
    {
    g.drawLine(x+15,(100*prof)+35,315,(100*(prof+1)));
    pintarHoja(b.izq,g,300,false,cambio/2);
    }
    }
    if (b.der!=null)                                      //si lo que hay en b a la derecha es diferente de null
    {
    g.setColor (Color.white);                               //pinte de  color rojo
    if (!primera)                                         //si es diferente de primera
    {
    g.drawLine(x+15,(100*prof)+35,x+(cambio/2)+15,(100*(prof+1))); //dibuja una linea de color rojo donde recibe las posiciones x1,y1,x2,y2
    pintarHoja(b.der,g,x+(cambio/2),true,cambio/2);                //pinta la hoja en estas posiciones hacia la derecha
    }
    else
    {
    g.drawLine(x+15,(100*prof)+35,715,(100*(prof+1)));
    pintarHoja(b.der,g,700,false,cambio/2);
    }
    
    }
    }
    public int darProfundidad (int b)                                 //defino un metodo llamado profundidad que recibe una variable de tipo entero b
    {
    arbol j = a;                                                      //definimos una variable de tipo arbol j que lo igualamos a a
    int p = 1;                                                        //definimos una variable de tipo entero p que es igual a 1 que seria como un contador
    if (b == j.info)                                                  //si b es igual a la informacion que se encuentra en j  entonces
    {
    return p;                                                         //retorno p
    }
    while (j.info != b)                                               //pero mientras la informacion que hay en j sea diferente de b entonces
    {
    if (j.info>b)                                                     //si la informacion de j es mayor que la que hay en b entonces
    {
    j = j.izq;                                                        //entonces empiece a recorrer por la izq
    p++;                                                              //y p que es como un contador aumenta en 1
    }
    else                                                              //si no
    {
    j = j.der;                                                        //recorro el arbol por la derecha
    p++;                                                              //y p que es como un contador aumenta en 1
    }
    }
    return p;                                                         //retorno el contador en este caso p
    }  
    
    
    public boolean handleEvent(Event e)                               //este es el evento para cuando damos clic en la x
    { 
    if(e.id==Event.WINDOW_DESTROY)
    System.exit(0);
    return super.handleEvent(e);
    }
    
    public static void main( String[] args )                         //DEFINIMOS LA CLASE PRINCIPAL
    {
    arbolGrafico a = new arbolGrafico (new arbol(2));                //CREAMOS UN OBJETO ARBOLGRAFICO DE TIPO A, QUE ES IGUAL A ARBOL GRAFICO QUE RECIBE UN NUEVO ARBOL 2
    a.setVisible(true);                                              //Y LO MOSTRAMOS EN PANTALLA
                                                   
    }
    
    
    
    
    }
