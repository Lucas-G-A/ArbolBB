/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbolbb;

import java.util.ArrayList;

/**
 *
 * @author lucasgarcia
 */
public class ArbolBB <T extends Comparable <T>>{
    private NodoBB<T> raiz;
    private NodoBB<T> papa;
    private int cont;

    public ArbolBB() {
    }

    public ArbolBB(NodoBB<T> raiz) {
        this.raiz = raiz;
        papa=raiz.getPapa();
    }
    
    public void inserta(T elem){
        NodoBB<T> actual = raiz;
        if(raiz==null){
            raiz=new NodoBB(elem);
            cont++;
            return;
        }
        NodoBB<T> padre=null;
        while(actual!=null){
            padre=actual;
            if(elem.compareTo(actual.getElem())<0)
                actual=actual.getIzq();
            else
                actual=actual.getDer();
        }
        NodoBB<T> nuevo = new NodoBB(elem);
        if(elem.compareTo(padre.getElem())<0)
            padre.setIzq(nuevo);
        else
            padre.setDer(nuevo);
        cont++;
        nuevo.setPapa(padre);
    }
    
    public void preOrden(){
        ArrayList<T> datos = new ArrayList<>();
        preOrden(raiz, datos);
        for(T es: datos){
            System.out.println(es);
        }       
    }
    private void preOrden(NodoBB<T> act, ArrayList<T> lista){
        if(act==null){
            return;
        }
        lista.add(act.getElem());
        preOrden(act.getIzq(), lista);
        preOrden(act.getDer(), lista);
    }
    public void postOrden(){
        ArrayList<T> datos = new ArrayList<>();
        postOrden(raiz, datos);
        for(T es: datos){
            System.out.println(es);
        }       
    }
    private void postOrden(NodoBB<T> act, ArrayList<T> lista){
        if(act==null){
            return;
        }
        postOrden(act.getIzq(), lista);
        postOrden(act.getDer(), lista);
        lista.add(act.getElem());
    }    
    public int calculaAltura(){
        return calculaAltura(raiz, 0);
    }
    private int calculaAltura(NodoBB<T> a, int n){
        if(a==null){
            return n;
        }
        int a1,a2;
        a1=calculaAltura(a.getIzq(),n+1);
        a2=calculaAltura(a.getDer(), n+1);
        if(a1>a2)
            return a1;
        return a2;
    }
    public NodoBB<T> busqueda(T dato){
        return busqueda(raiz, dato);
    }
    private NodoBB<T> busqueda(NodoBB<T> a, T dato){
        if(a==null)
            return null;
        if(a.getElem().equals(dato))
            return a;
        else{
            if(a.getElem().compareTo(dato)>0)
                return busqueda(a.getIzq(),dato);
            else
                return busqueda(a.getDer(), dato);
        }
    }
    
    public void borrar(T elem){
        NodoBB<T> actual = busqueda(raiz, elem);
        if(actual == null){
            return;
        }
        if(actual.getIzq()==null && actual.getDer()==null){ //cero hijos
            if(actual.equals(raiz)){
                raiz=null;
            }
            else{
                NodoBB<T> padre = actual.getPapa();
                if(padre.getIzq() != null && padre.getIzq().equals(actual))
                    padre.setIzq(null);
                else
                    padre.setDer(null);
            }
            cont--;
        }
        else{
            if(actual.getIzq()!=null && actual.getDer()!=null){ //dos hijos
                NodoBB<T> suc=actual.getDer();
                while(suc.getIzq()!=null)
                    suc=suc.getIzq();
                T temp = suc.getElem();
                actual.setElem(temp);
                NodoBB<T> padreSuc = suc.getPapa();
                if(suc.getDer() != null) {
                    NodoBB<T> hijoSucDer = suc.getDer();
                    if(padreSuc.getIzq().equals(suc)) {
                        padreSuc.setIzq(hijoSucDer);
                    }
                    else {
                        padreSuc.setDer(hijoSucDer);
                    }
                    hijoSucDer.setPapa(padreSuc);
                }
                else {
                    if(padreSuc.getIzq().equals(suc)) {
                        padreSuc.setIzq(null);
                    } 
                    else {
                        padreSuc.setDer(null);
                    }
                }
            }
            else{ //un hijo
                NodoBB<T> hijo;
                if(actual.getIzq()!=null){ //solo izq
                    hijo=actual.getIzq();
                }
                else{ // solo der
                    hijo=actual.getDer();
                }
                if(actual.equals(raiz)){
                    raiz=hijo;
                }
                else{
                    NodoBB<T> padre = actual.getPapa();
                    if(padre.getIzq() != null && padre.getIzq().equals(actual))
                        padre.setIzq(hijo);
                    else
                        padre.setDer(hijo);
                    hijo.setPapa(padre);
                }
                cont--;
            }
        }
    }
}

