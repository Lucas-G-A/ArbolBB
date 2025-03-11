/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolbb;

/**
 *
 * @author lucasgarcia
 */
public class NodoBB <T extends Comparable <T>>{
    private T elem;
    private NodoBB<T> izq, der, papa;
    
    public NodoBB() {
        elem=null;
        izq=null;
        der=null;
        papa=null;
    }
    public NodoBB(T elem) {
        this();
        this.elem = elem;
    }
    public NodoBB(T elem, NodoBB<T> izq, NodoBB<T> der, NodoBB<T> papa) {
        this.elem = elem;
        this.izq = izq;
        this.der = der;
        this.papa = papa;
    }

    public T getElem() {
        return elem;
    }

    public void setElem(T elem) {
        this.elem = elem;
    }

    public NodoBB<T> getIzq() {
        return izq;
    }

    public void setIzq(NodoBB<T> izq) {
        this.izq = izq;
    }

    public NodoBB<T> getDer() {
        return der;
    }

    public void setDer(NodoBB<T> der) {
        this.der = der;
    }

    public NodoBB<T> getPapa() {
        return papa;
    }

    public void setPapa(NodoBB<T> papa) {
        this.papa = papa;
    }
    
    
    public boolean agrega(NodoBB<T> a, T dato){
        NodoBB<T> nuevo = new NodoBB<>(dato);
        while(a!=null){
            if(a.getElem().equals(dato)){
                if(a.getIzq()==null)
                    a=a.getIzq();
                else{
                    
                }
            }
            else{
                if(a.getElem().compareTo(dato)>0)
                    a=a.getIzq();
                else
                    a=a.getDer();
            }
                
        }
        a=nuevo;
        return true;
    }
    public boolean busqueda(NodoBB<T> a, T dato){
        if(a==null)
            return false;
        if(a.getElem().equals(dato))
            return true;
        else{
            if(a.getElem().compareTo(dato)>0)
                return busqueda(a.getIzq(),dato);
            else
                return busqueda(a.getDer(), dato);
        }
    }
    public int calculaAltura(){
        return calculaAltura(this, 0);
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
    public static int calculaFe(NodoBB actual){
        if(actual.getIzq()!=null && actual.getDer()!=null){
            return actual.getDer().calculaAltura()-actual.getIzq().calculaAltura();
        }
        if(actual.getIzq()==null && actual.getDer()==null)
            return 0;
        if(actual.getIzq()==null)
            return actual.getDer().calculaAltura();
        return actual.getIzq().calculaAltura();
    }
}

