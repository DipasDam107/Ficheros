/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam107t7e19;

public class MovilPlus extends cMovilPrepago{
    private static final int DATOS_SEGUNDO_VIDEOLLAMADA=2; // Son dos megas de datos
    MovilPlus(long nM, float cML, float cMB, float s){
        super(nM,0,cML, cMB,s);
    }
    
    public void videollamada(int segundos){
        this.navegar(segundos*DATOS_SEGUNDO_VIDEOLLAMADA);
    }
    
    
    @Override
    public boolean equals(Object movil){
        if(movil instanceof movilPlus)
             if(((movilPlus)movil).numeroMovil==this.numeroMovil) return true;
             else return false;
        else return false;
    }
   
}