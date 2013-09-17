/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectofinal;

    class nodo_avl             //CREO UNA CLASE NODO
    {
    int info;              //DEFINO UNA VARIABLE DE TIPO ENTERO LLAMADA INFO
    boolean rojo=false;    //DEFINO UNA VARIABLE DE TIPO BOOLEAN LLAMADO ROJO EL CUAL ES DE TIPO FALSE
    public nodo_avl(int info)  //DEFINO N CONSTRUCTOR DE TIPO NODO QUE ME RECIBE LA VARIABLE DE TIPO INFO AQUI EMPEZAMOS A DEFINIR EL CONSTRUCTOR DE LA PILA
    {
        this.info=info;    //EN ESTA PARTE LLAMAMOS LA INFORMACION DE TIPO INFO
    }
    nodo_avl sig;              //AQUI REALIZAMOS UNA ASIGNACION DE TIPO SIGUIENTE
    }