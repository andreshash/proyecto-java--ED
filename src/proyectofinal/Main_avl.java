
package proyectofinal;

import java.io.*;                                            //DEFINO LAS LIBRERIAS
    import javax.swing.JOptionPane;
    
     class arbol
    {
    int info;                 //DEFINO UNA VARIABLE TIPO INFO                
    arbol izq=null;           //DEFINO UNA VARIABLE IZQ DE TIPO ARBOL QUE ES IGUAL A NULL
    arbol der=null;           //DEFINO UNA VARIABLE DE TIPO ARBOL QUE ES IGUAL A NULL
    boolean rojo=false;       //DEFINO UNA VARIABLE DE TIPO BOOLEAN  ROJO DE TIPON FALSE
    public arbol(int info)    //CREAMOS UN CONSTRUCTOR DE TIPO ARBOL QUE ME RECIBE UNA VARIABLE DE TIPO ENTERO LLAMADA INFO 
    {
        this.info=info;       //EN ESTE PASO ESTA LLAMANDO EL DATO 
    }
    }

    
    
    
    
   class arbol_AVL {
       public int pop=0;                                            //DEFINO UNA VARIABLE DE TIPO PUBLICO  Y ENTERO LLAMADA POP Y LA IGUALAMOS A CERO
    public boolean band=true;                                    //DEFINO UNA VARIABLE PUBLICA DE TIPO BOOLEANO COMO UNA BANDERA VERDADERA
    public int mnodos = 0;                                       //DEFINO UNA VARIABLE DE TIPO PUBLICO Y ENTERO LLAMADO mnodos
    
    public void insertar(arbol p, int dato , boolean rojo)       //DEFINO UN METODO DE TIPO INSERTAR  ESTE ME RECIBE UN ARBOL DE TIPO P o nodo_avl, UN ENTERO LLAMADO DATO Y UN BOOLEANO ROJO
    {
    if(dato < p.info)                                            //si el dato es menor que la cabeza que es p.info entonces se recorre por la izquierda
    {
    if(p.izq == null)                                            //si la informacion que hay en el arbol al lado izquierdo es igual o esta apuntando a null entonces
    {                     
    arbol q=new arbol(dato);                                     //creo un objeto de tipo arbol que va a ser q y que me recibe una informacion de tipo dato
    
    p.izq=q;                                                     //y si p al lado izquierdo es igual a null este tomara el valor de q
    }
    else                                                         // de lo contrario
    {
    insertar(p.izq,dato,rojo);                                   //volvemos a llamar a la funcion insertar que ahora nos recibe la informacion que esta en p al lado izquierdo
    }
    }
    else                                                        //de lo contrario miramos
    if(dato > p.info)                                           //si el dato es mayor a la informacion que hay en el arbol p
    {
    
    if(p.der == null)                                           //si la informacion que hay en el arbol al lado derecho es igual o esta apuntando a null entonces
    {
    arbol q=new arbol(dato);                                    //creo un objeto de tipo arbol que va a ser q y que me recibe una informacion de tipo dato
    
    p.der=q;                                                   //y si p al lado derecho es igual a null este tomara el valor de q
    }
    else                                                       // de lo contrario         
    {
    insertar(p.der,dato,rojo);                                 //volvemos a llamar a la funcion insertar que ahora nos recibe la informacion que esta en p al lado derecho
    }
    }
    else                                                       
    {   
    JOptionPane.showMessageDialog(null, "El elemento " +dato+" ya se encuentra");//se muestra en la pantalla un cuadro de dialogo que nos dice que
                                                               //el elemento ya existe para no volverlo a ingresar
    
    }
    }

    
    int nhojas = 0;                                           // defino una variable de tipo entero llamada nhojas y lo inicializamos en 0 
    int hojaact = 0;                                          // defino una variable de tipo entero llamada hojaact y lo inicializamos en 0 
    arbol hojabuscada;                                        // creamor un arbol llamado hojabuscada
    
    public void buscarHoja (int b, arbol p)                   // creamos un metodo de tipo buscarHoja que me recibe dos datos uno de tipo entero b y uno de tipo arbol p
    {
    if(p!=null)                                               // si la cabeza  es diferente de null
    {
    if(p.izq==null&&p.der==null)                              // si la informacion por la izquierda apunta a null y la informacion por la derecha apunta a null 
    {
    hojaact++;                                                //hojaact aqui funciona como un contador y aumenta en 1
    if(b==hojaact)                                            // si b que es la informacion introducida es igual a hojaact
    {
    hojabuscada = p;                                          //entonces hoja buscada que es la posicion
    }
    }
    else                                                      // si no es igual entonces
    {
    buscarHoja (b, p.izq);                                    //volvemos a llamar  al metodo buscarhoja  que me recibe el entero b y empieza a buscar por la izquierda
    buscarHoja (b, p.der);                                    //volvemos a llamar  al metodo buscarhoja  que me recibe el entero b y empieza a buscar por la derecha
    }
    }
    }
    
    public void contarHojas (arbol p)                         //defino el metodo contar hojas que me recibe una variable p de tipo arbol
    {
    if (p!=null)                                              //si p es diferente de null
    {
    if(p.izq==null&&p.der==null)                              // si la informacion por la izquierda apunta a null y la informacion por la derecha apunta a null 
    {
    nhojas++;                                                 //nhojas que funciona como contador va aumentando en 1
    }
    else
    {
    contarHojas (p.izq);                                     //volvemos a llamar  al metodo contarhoja  que me recibe el entero b y empieza a buscar por la izquierda          
    contarHojas (p.der);                                     //volvemos a llamar  al metodo contarhoja  que me recibe el entero b y empieza a buscar por la derecha
    }
    }
    }
    
        
    public int contarHasta (arbol p, int b)                  //creo un metodo contar hasta que recibe una variable p de tipo arbol y una variable de tipo entero  b
    {
    int nodos = 0;                                           //defino una variable tipo entero llamada nodos y la inicializo en 0
    boolean bandera1 = false;                                //defino una variable de tipo booleano que es una bandera1 que la igualamos a false
    while(!bandera1 && p!=null)                              //mientras p sea diferente de null y bandera1 sea  diferente tambien
    {
    if(p.info>b)                                             // si la informacion que hay en p es mayor a b
    {
    
    nodos++;                                                 //nodos que funciona como contador aumenta en 1
    p = p.izq;                                               // y p toma el valor de lo que hay a la izquierda de p
    }
    else if(p.info<b)                                        //sino entonces la informacion que hay en p es menor que b entonces
    {
    nodos++;                                                 //nodos que funciona como un contador aumenta en 1
    p = p.der;                                               // y p toma el valor de lo que hay a la derecha de p
    }
    else                                                     // de lo contrario
    {
    nodos++;                                                 // nodos aumenta en 1
    bandera1 = true;                                         //y la bandera1 cambia a true
    }
    }
    return nodos;                                            //retorna el valor de tipo entero nodos
    }
    
    public void insertar2(arbol p,int dato)                  // definimos el metodo insertar2 que me recibe un arbol p y un entero llamado dato
    {
    if(dato < p.info)                                        //si el dato es menor que la informacion que se encuentra en p
    {
    if(p.izq == null)                                        //si p al lado izquierdo esta apuntando a null entonces
    {
    arbol q=new arbol(dato);                                 //defino un objeto de tipo arbol con la variable q que me recibe una variable de tipo dato
    p.izq=q;                                                 //p a la izquierda toma el valor de q
    }
    else                                                     //sino 
    {
    insertar2(p.izq,dato);                                   //vuelvo a llamar la funcion insertar2 que me recibe el dato que esta a la izquierda, y la variable de tipo dato
    }
    }
    else                                                     //de contrario
    if(dato > p.info)                                        //si el dato es mayor a la informacion que se encuentra en p entonces
    {
    if(p.der == null)                                        //si p al lado derecho esta apuntando a null entonces
    {
    arbol q=new arbol(dato);                                 //defino un objeto de tipo arbol con la variable q que me recibe una variable de tipo dato 
    p.der=q;                                                 //p a la derecha toma el valor de q      
    }
    else
    {
    insertar2(p.der,dato);                                   //vuelvo a llamar la funcion insertar2 que me recibe el dato que esta a la derecha, y la variable de tipo dato
    }
    }
    }
    
    
    public arbol buscar(arbol p,int dato)                   // defino el metodo buscar
    {                                   
    boolean band=true;                                      //creo una variable de tipo booleano llamada bandera que es igual a true
    arbol q=new arbol(0);                                   //creo un objeto de tipo arbol llamada q que recibe una variable 0
    while(p.info != dato && ((p.der != null || p.izq != null) && band)) //si la informacion de la derecha o de la izquierda es diferente de null y bandera es igual a true
                                                            //si la informacion que hay en p es diferente de dato y se cumplen las condiciones anteriores.
    {
    if(dato < p.info)                                       //si el dato es menor a la informacion que hay en p
    {
    if(p.izq == null)                                       //si el dato que hay a la izquierda es igual a null
    {
    band=false;                                             //si el dato que hay a la izquierda es igual a null bandera es igual a false
    }
    else                                                    //si no
    {
    p=p.izq;                                                //p toma el valor que hay en p izquierdo
    }
    }
    else                                                    //sino
    if(dato > p.info)                                       //si el dato es mayor que la informacion que hay en p
    {
    if(p.der == null)                                       //si la informacion que hay en p a la derecha es igual a null
    {
    band=false;                                             //bandera es igual a false
    }
    else                                                    //si no
    {
    p=p.der;                                                //p toma el valor que hay en p a la derecha
    }
    }
    }
    if(p.info == dato)                                      //si lo que hay en p informacion es igual al dato
    {
    q=p;                                                    //q toma el valor de p
    }
    else                                                    //si no
    {
    JOptionPane.showMessageDialog(null, "El elemento " +dato+" no se encuentra, Ingrese un nuevo elemento"); // el mostrara un mensaje que dice 
                                                            //"El elemento dato no se encuentra"
    
    }
    return q;                                               //retorna el valor de q
    }
    
    public arbol buscarPadre(arbol p,int dato)              //creo un metodo buscarPadre que me recibe un p que de tipo arbol y un entero llamado dato
    {          
    arbol q = p;                                            //lo que hay en q que es de tipo arbol se lo asigno a p
    if (p.info>dato)                                        //si la informacion que hay en p es mayor que el dato
    {
    q = q.izq;                                              //lo que hay el q a la izquierda lo recibe q
    }
    else                                                    //si no
    {
    q = q.der;                                              //q recibe el valor de lo que hay en la derecha
    }
    
    while (q.info!=dato)                                    // mientras la informacion que hay en q es diferente de el dato                                                                                    
    {
    if (q.info>dato)                                        //si la informacion que hay en q es mayor que el dato
    {
    p = q;                                                  //p es igual a q
    q = q.izq;                                              //q toma el valor de lo que hay en q a la izquierda
    }
    else                                                    //si no
    {
    p = q;                                                  //p toma el valor de q
    q = q.der;                                              //q toma el valor de lo que hay en q a la derecha
    }
    }
    return p;                                               //retorna p
    }
    
    
    public void imprimir_preorden(arbol p)                  //creo un metodo de tipo imprimir_preorden que recibe una variable p de tipo arbol
    {
    if(p != null)                                           // si p es diferente de null
    {
    
    JOptionPane.showMessageDialog(null, "RECORRIDO EN PREORDEN " +p.info+" "); // muestra un mensaje que dice "RECORRIDO EN PREORDEN " y muestra el dato
    imprimir_preorden(p.izq);                               //vuelve a llamar el metodo imprimir_preorden que recibe un dato p izquierda
    imprimir_preorden(p.der);                               //vuelve a llamar el metodo imprimir_preorden que recibe un dato p derecha
    }
    }
    
    public void imprimir_posorden(arbol p)                 //creo un metodo llamado imprimir_posorden
    {
    if(p != null)                                          //si p es diferente de null
    {
    imprimir_posorden(p.izq);                              //vuelve a llamar el metodo imprimir_posorden que recibe un dato p izquierda
    imprimir_posorden(p.der);                              //vuelve a llamar el metodo imprimir_posorden que recibe un dato p derecho
    JOptionPane.showMessageDialog(null, "RECORRIDO EN POSORDEN " +p.info+" "); // muestra un mensaje que dice "RECORRIDO EN POSORDEN " y muestra el dato
    
    
    }
    }
    
    public void imprimir_inorden(arbol p)                  //creo un metodo de tipo imprimir_inorden que recibe una variable p de tipo arbol
    {
    if(p != null)                                          //si p es diferente de null
    {
    imprimir_inorden(p.izq);                               //vuelve a llamar el metodo imprimir_inorden que recibe un dato p izquierda
    JOptionPane.showMessageDialog(null, "RECORRIDO EN INORDEN " +p.info+" ");// muestra un mensaje que dice "RECORRIDO EN INORDEN " y muestra el dato
    imprimir_inorden(p.der);                               //vuelve a llamar el metodo imprimir_inorden que recibe un dato p derecho
    }
    }
    
    
    
    public int tamaño(arbol p)                            //creo un metodo llamado tamaño
    {
    if(p == null)                                         //si p es igual a null
    {
    return 0;                                             //retorno 0
    }
    else                                                  // si no
    {
    return(1+ tamaño(p.izq) +tamaño(p.der));              //retorno la suma de 1 y vuelvo a llamar a la funcion tamaño por la derecha
                                                          //y por la izquierda para hacer el conteo de padres y hijos
    }
    }
    
    
    public int altura(arbol p)                           //creo un metodo llamado altura que me recibe una variable p de tipo arbol
    {
    if(p==null)                                          // si p es igual a null
    {
    return -1;                                           //retorno -1
    }
    else                                                 // si no
    {
    return(1+Math.max(altura(p.izq),altura(p.der)));     //me devuelve el valor maximo de los dos
    }
    }
    
    
    public int valor_hoja(arbol z)                       //creo un metodo llamado valor_hoja que recibe una variable de tipo arbol
    {
    int num=0;                                           //recibo un entero llamado num que esta igualado a 0, es decir esta inicializado
    while(z.izq != null || z.der != null)                //mientras lo que hay en z a la derecha o a la izquierda sea diferente de null
    {
    if(z.izq == null && z.der != null)                    //mientras lo que hay en z a la derecha y a la izquierda sea diferente de null
    {
    z=z.der;                                              //z toma el valor que hay en z a la derecha
    }
    else                                                  // sino
    if(z.izq != null && z.der == null)                    //mientras lo que hay en z a la derecha y a la izquierda es igual a null
    {
    z=z.izq;                                              //z toma el valor que hay en z a la izquierda         
    }
    else                                                  //si no
    {
    z=z.izq;                                              //z toma el valor que hay en z a la izquierda 
    }
    }
    num=z.info;                                           //num toma el valor de la informacion que hay en z
    return num;                                           //retorna num
    }
    
    public nodo_avl desojar(arbol w)                          //creo un metodo no do llamado desojar que recibe una variable w de tipo arbol
    {
    int t=tamaño(w);                                      //defino una variable de tipo entero t que es igual a tamaño que recibe w
    int num;                                              //defino una variable de tipo entero que se llama num
    nodo_avl pila=new nodo_avl(0);                                //creo un objeto de tipo nodo_avl llamado pila que me recibe un 0
    while( t != 1)                                        //mientras t sea diferente de 1
    {
    nodo_avl q=new nodo_avl(0);                                   //creo un objeto de tipo nodo_avl llamado q que me recibe un 0
    num=valor_hoja(w);                                    // definimos que num es igual a valor_hoja que recibe w
    q.rojo=(buscar(w,num)).rojo;                          //
    q.info=num;
    q.sig=pila;
    pila=q;
    eliminar_hoja(w,num);
    t=tamaño(w);
    }
    nodo_avl q=new nodo_avl(w.info);
    q.rojo=w.rojo;
    q.sig=pila;
    pila=q;
    return pila;
    }
    
    public void eliminar(arbol p)                          
    {
    arbol q=p;
    int cab = 0;
    if(q.der!=null)
    {
    cab = menor_de_mayores(q);
    }
    else
    {
    cab = mayor_de_menores(q);
    }
    nodo_avl r = desojar(q);
    r = r.sig;
    q.info = cab;
    while (r.info!=0)
    {
    if(r.info!=cab)
    {
    insertar(q,r.info,r.rojo);
    }
    r = r.sig;
    }
    }
    
    public int menor_de_mayores(arbol p)                       //me escoje el menor valor de lapila,metodo auxiliar de eliminar padre
    {
    p = p.der;
    while (p.izq != null)
    {
    p = p.izq;
    }
    return p.info;
    }
    
    public int mayor_de_menores(arbol p)                       //me escoje el mayor valor de lapila,metodo auxiliar de eliminar padre
    {
    p = p.izq;
    while (p.der != null)
    {
    p = p.der;
    }
    return p.info;
    }
    
    //...........................................................................................................................................................
    
    public void eliminar_hoja(arbol p,int dato)                //me elimina una hoja
    {
    arbol q=p;
    if(dato < p.info)
    {
    q=q.izq;
    }
    else
    if(dato > p.info)
    {
    q=q.der;
    }
    while(q.info != dato)
    {
    if(dato < q.info)
    {
    q=q.izq;
    }
    else
    if(dato > q.info)
    {
    q=q.der;
    }
    }
    while(p.izq != q && p.der != q)
    {
    if(dato < p.info)
    {
    p=p.izq;
    }
    else
    if(dato > p.info)
    {
    p=p.der;
    }
    }
    if(p.der == q)
    {
    p.der=null;
    }
    else
    if(p.izq == q)
    {
    p.izq=null;
    }
    }
    
    //..........................................................................................................................................................
    //funciones para balancear un arbol
    
    public int contar_nodosizq(arbol p)                      //funcion que me dice cuantos nodos hay hacia la izquierda siempre a la izquierda
    {
    int maxval = 0;
    nhojas = 0;
    contarHojas(p.izq);
    for (int i = 1; i!=(nhojas+1); i++)
    {
    hojaact = 0;
    buscarHoja(i, p);
    int temp = contarHasta(p.izq, hojabuscada.info);
    if(temp>maxval)
    {
    maxval = temp;
    }
    }
    return maxval;
    }
    
    public int contar_nodosder(arbol p)                       //funcion que me dice cuantos nodos hay a la derecha siempre hacia la derecha
    {        
    int maxval = 0;
    nhojas = 0;
    contarHojas(p.der);
    for (int i = 1; i!=(nhojas+1); i++)
    {
    hojaact = 0;
    buscarHoja(i, p.der);
    int temp = contarHasta(p.der, hojabuscada.info);
    if(temp>maxval)
    {
    maxval = temp;
    }
    }
    return maxval;
    }
    
    public int esta_desbalanceado(arbol p)                      //me dice si el arbol esta balanceado o no
    {
    if(p != null)
    {
    if((contar_nodosizq(p)-contar_nodosder(p)) >= -1 && (contar_nodosizq(p)-contar_nodosder(p)) <= 1 && band)
    {
    JOptionPane.showMessageDialog(null, "Esta Balanceado" +p.info+" Digite enter para continuar");  //System.out.println("esta balanceado con respecto a "+p.info);
    esta_desbalanceado(p.izq);
    esta_desbalanceado(p.der);
    }
    else
    if(band)
    {
    JOptionPane.showMessageDialog(null, "NO esta BALANCEADO con respecto a " +p.info+" ");
    pop=p.info;
    band=false;
    }
    }
    return pop;
    }
    
    public void balancear(arbol p, boolean raiz)            //me balancea el arbol
    {
    if(p != null)
    {
    balancear(p.izq, true);
    balancear(p.der, true);
    if((contar_nodosizq(p)-contar_nodosder(p)) >= -1 &&  
    (contar_nodosizq(p)-contar_nodosder(p)) <= 1)
    {
    }
    else
    {
    if((contar_nodosizq(p)-contar_nodosder(p)) <= -1)
    {
    if (raiz)
    {   
    int tm = menor_de_mayores(p);
    nodo_avl n = desojar(p);
    p.info = tm;
    while (n.info != 0)
    {
    if (n.info != tm)
    {
    insertar(p, n.info, n.rojo);
    }
    n = n.sig;
    }            
    }
    else
    {
    int temp = p.der.info;
    nodo_avl n = desojar(p);
    p.info = temp;
    while (n.info != 0)
    {
    if (n.info != temp)
    {
    insertar(p, n.info, n.rojo);
    }
    n = n.sig;
    }                  
    }
    }
    else
    {
    if (raiz)
    {   
    int tm = mayor_de_menores(p);
    nodo_avl n = desojar(p);
    p.info = tm;
    while (n.info != 0)
    {
    if (n.info != tm)
    {
    insertar(p, n.info, n.rojo);
    }
    n = n.sig;
    }            
    }
    else
    {
    int temp = p.izq.info;
    nodo_avl n = desojar(p);
    p.info = temp;
    while (n.info != 0)
    {   
    if (n.info != temp)
    {
    insertar(p, n.info, n.rojo);
    }
    n = n.sig;
    }     
    }
    }
    }
    
    }
    
    }
    
    //............................................................................................................................................................
    
    public void Principal_avl()                          //llamado a los metodos
    {
    String a, b;                                                    //creo unas variables a y b de tipo string
    int num,dato,op,op1;
    boolean termino = false;                                        // creo un booleano llamado termino que es de tipo false
    boolean rojor = false;                                          //creo un booleano llamado rojor que es de tipo false                        
    arbol_AVL x=new arbol_AVL();                                    //creo un objeto de tipo arvol_AVL llamado x
    a=JOptionPane.showInputDialog("ingrese la raiz del arbol");     //me permite ingresar la raiz y me muestra un mensaje que dice "ingrese la raiz del arbol"
    num=Integer.parseInt(a);                                        //convierto a a un entero y lo guardo en num
    arbol raiz=new arbol(num);                                      //creo un objeto de tipo arbol llamado raiz que me recibe el dato anterior, es decir num
    raiz.rojo = false;                                              //como todos los datos que entran son rojos en este caso como los definimos entonces lo igualamos a un false
    raiz.der=raiz.izq=null;                                         //si el dato de la raiz a la derecha y el de la izquierda son null
    arbolGrafico a1 = new arbolGrafico (raiz);                      //creo un objeto de tipo arbolGrafico llamado al que me recibe una raiz
    a1.setVisible(true);                                            //y lo vuelvo visible , lo vemos en la pantalla
    do                                                              //hacer
    {
    a=JOptionPane.showInputDialog(".........MENU PRINCIPAL..........\n"+"1.insertar \n"+"2.buscar un dato y imprimir un subarbol con ese dato como raiz \n"+"3.imprimir \n"+"4.tamaño del arbol \n"+"5.altura del arbol\n"+"6.eliminar \n"+"7.SALIR \n"+"ESCOJA LA OPCION");
   
                                                                    //me muestra un cuadro de dialogo o menu principal con las opciones anteriores
    
    op=Integer.parseInt(a);                                         //paso el dato a un entero y lo guardo en op
    switch(op)                                 //switch es el evento que nos va a recivir las diferentes opciones para ejecutarlas de acuerdo con lo requerido por el usuario
    {
    case 1:{                                   //caso 1
    a=JOptionPane.showInputDialog("digite el dato que va ingresar"); //muestra un dialogo que dice "digite el dato que va ingresar"
    dato=Integer.parseInt(a);                                        //pasa el dato que se ingreso a un numero entero y lo guarda en dato
    termino = false;                                                 //defino termino como false
    if(dato == 0)                                                    // si el dato es igual a 0
    {
     JOptionPane.showMessageDialog(null, " no se puede agregar el cero,ya que es un valor propio del diseño");  
    //System.out.println("no se puede agregar el cero, es un valor recervado del programa \n"+"que se utiliza para indicar un vacio. Ingrese un \n"+"dato diferente"); 
    
    //aparecera un letrero que dice "no se puede agregar el cero, es un valor recervado del programa \n"+"que se utiliza para indicar un vacio. Ingrese un \n"+"dato diferente"
    }                                                        
    else                                                             //si no
    
    if(dato <= -1000000  || dato >= 1000000)                         //si el dato es menor o igual a -1000000 o el dato es mayor o igual a 1000000
    {
    System.out.println("no se puede agregar el dato, este programa trabaja con numeros entre -1000000 y \n"+"10000000 ingrese un numero diferente");
    
    //aparecera un letrero que dice "no se puede agregar el dato, este programa trabaja con numeros entre -1000000 y \n"+"10000000 ingrese un numero diferente"
    
    }
    else                                                            //si no
    {
    x.insertar(raiz, dato, true);                                   //
    
    }
    int i = 0;                                                      //defino una variable de tipo entero llamada i y esta inicializada en 0
    while(i!=x.tamaño(raiz))                                           
    {
    x.balancear(raiz, true);                                                  
    i++;
    }
    
    break;
    }
    case 2:{
    a=JOptionPane.showInputDialog("digite el dato a buscar");      //me aparece un cuadro de dialogo que me dice "digite el dato a buscar"
    dato=Integer.parseInt(a);                                      //paso el dato ingresado a entero y lo guardo en dato
    arbol aux=new arbol(0);                                        //creo un objeto de tipo arbol llamado aux que me recibe una variable 0
    aux=x.buscar(raiz,dato);                                      
    System.out.println("             ");
    x.imprimir_preorden(aux);
    break;
    }
    case 3:{
    a=JOptionPane.showInputDialog("..ESCOJA EL METODO PARA IMPRIMIR EL ARBOL.. \n"+"1.en preorden \n"+"2.en posorden \n"+"3.eninorden \n"+"escoja la opcion");
                                                                  //muestra un menu de opciones donde le pide al usuario la manera en la que quiere imprimir
                                                                  //si en posorden , inorden o preorden
    op1=Integer.parseInt(a);                                      //paso dicha opcion a un entero y lo guardo en op1
    switch(op1)                                                   //este switch maneja los casos de este tercer caso
    {
    case 1:{                                                      // CASO 1
    System.out.println("el arbol impreso en PREORDEN");           //imprime en la pantalla "el arbol impreso en PREORDEN"
    x.imprimir_preorden(raiz);                                    //
    break;                                                        // SE SALE
    }
    case 2:{                                                      // CASO 2
    System.out.println("el arbol impreso en POSORDEN");           //imprime en la pantalla "el arbol impreso en POSORDEN"
    
    x.imprimir_posorden(raiz);
    break;                                                        //SALIR
    }
    case 3:{                                                      //CASO3
    System.out.println("el arbol impreso en INORDEN");            //imprime en la pantalla "el arbol impreso en INORDEN"
    
    x.imprimir_inorden(raiz);
    break;                                                        //SALIR
    }
    }
    break;                                                        //SALIR
    }
    case 4:{                                                      //CASO 4
    int t;                                                        //defino una variable de tipo entero t
    t=x.tamaño(raiz);                                            //                                                  
    
    JOptionPane.showMessageDialog(null, "EL TAMAÑO ES: " + t+" "); //imprime un mensaje que me dice "EL TAMAÑO ES: " y muestra el valor que esta en t
    
    System.out.println("       ");                                //
    break;                                                        // se sale
    }
    case 5:{                                                      //caso 5
    int al=0;                                                     //defino una variable de tipo entero llamada al que esta inicializada en 0
    al=x.altura(raiz);                                            //
    
    JOptionPane.showMessageDialog(null, "LA ALTURA DEL ARBOL " +al+" ");   // muestra un letrero en pantalla  "LA ALTURA DEL ARBOL " y muestra el dato que esta en al
    System.out.println("la altura del arbol es "+al);                      //imprimo en pantalla "la altura del arbol es " y muestro es dato que esta en al
    break;
    }
    case 6:{
    a=JOptionPane.showInputDialog("ingrese el dato a eliminar");           //muestra un mensaje de dialogo que dice "ingrese el dato a eliminar"
    dato=Integer.parseInt(a);                                              //paso el dato ingresado a entero y lo guardo en dato
    arbol aux=new arbol(0);                                                //creo un objeto de tipo arbol que me recibe como parametro un 0
    aux=x.buscar(raiz,dato);                                               //
    if(aux.info== 0)                                                       //el cero indica que la pila esta vacia
    {
    
    JOptionPane.showMessageDialog(null, "EL VALOR NO EXISTE EN EL ARBOL"); //muestra un mensaje de dialogo que dice "EL VALOR NO EXISTE EN EL ARBOL"
    }  
    else
    {
    arbol p = x.buscar(raiz,dato);
    if(p.izq == null && p.der == null)
    {
    arbol q = x.buscarPadre(raiz,p.info);
    if (q.izq.info == p.info)
    {
    q.izq = null;
    }
    else
    {                                      
    q.der = null;
    }
    }
    else
    {
    x.eliminar(p);
    }
    }
    
    x.balancear(raiz,true);
    
    
    JOptionPane.showMessageDialog(null, " EL ARBOL ESTA BALANCEADO" );  //muestra un dialogo que dice " EL ARBOL ESTA BALANCEADO"
    System.out.println("");                                              
    break;
    }
    
    
    }
    
    
    a1.repaint();                               //pinta el modo grafico
    }while( op != 7);                           //mientras el dato ingresado es diferente de 7 no se sale cuando sea igual a 7 se sale.
    }
    }
    
    
