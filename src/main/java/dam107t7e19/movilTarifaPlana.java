/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam107t7e19;
public class movilTarifaPlana extends cMovilPrepago {
    movilTarifaPlana(long nM, float cEL, float cML, float s){
        super(nM,cEL,cML, 0,s);
    }
    
    @Override
    public void navegar(int mb){System.out.println("No hago nada");}
}