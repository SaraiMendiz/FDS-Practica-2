
package vectores;

public class Complejidad {
    private int iteraciones;
    
    private vectores vectorParaInversionFuerzaBrutaMejorCaso;
    private vectores vectorParaInversionFuerzaBrutaPeorCaso;
    private vectores vectorParaInversionFuerzaBrutaCasoAleatorio;
    private vectores vectorParaInversionDivideVencerasMejorCaso;
    private vectores vectorParaInversionDivideVencerasPeorCaso;
    private vectores vectorParaInversionDivideVencerasCasoAleatorio;
    
    private String[] titulos = {"Inversion Fuerza Bruta Mejor Caso","Inversion Fuerza Bruta Caso Aleatorio","Inversion Fuerza Bruta Peor Caso","Inversion Divide y Venceras Mejor Caso","Inversion Divide y Venceras Caso Aleatorio","Inversion Divide y Venceras Peor Caso"};
    
    private MatrizDeTiempos m;
    
    public Complejidad(int N){
        iteraciones = N;
    }
    
    public void ejecutarAlgoritmos(){
        m = new MatrizDeTiempos(titulos.length, iteraciones, titulos);
        
        for(int j = 0; j < titulos.length; j++){
            int ini = 1;
            for(int i = 0; i < iteraciones; i++){
                switch(j){
                    case 0:
                           vectorParaInversionFuerzaBrutaMejorCaso = new vectores(ini);
                           vectorParaInversionFuerzaBrutaMejorCaso.rellenarEnOrden();
                           m.asignaValor(j, i, vectorParaInversionFuerzaBrutaMejorCaso.inversion());
                           break;
                    case 1:
                           vectorParaInversionFuerzaBrutaCasoAleatorio = new vectores(ini);
                           vectorParaInversionFuerzaBrutaCasoAleatorio.rellenarAleatorio();
                           m.asignaValor(j, i, vectorParaInversionFuerzaBrutaCasoAleatorio.inversion());
                           break;
                    case 2:
                           vectorParaInversionFuerzaBrutaPeorCaso = new vectores(ini);
                           vectorParaInversionFuerzaBrutaPeorCaso.rellenarEnOrdenInverso();
                           m.asignaValor(j, i, vectorParaInversionFuerzaBrutaCasoAleatorio.inversion());
                           break;
                    case 3:
                        vectorParaInversionDivideVencerasMejorCaso = new vectores(ini);
                        vectorParaInversionDivideVencerasMejorCaso.rellenarEnOrden();
                        m.asignaValor(j, i, vectorParaInversionDivideVencerasMejorCaso.inversionDV());
                        break;
                    case 4:
                        vectorParaInversionDivideVencerasCasoAleatorio = new vectores(ini);
                        vectorParaInversionDivideVencerasCasoAleatorio.rellenarAleatorio();
                        m.asignaValor(j, i, vectorParaInversionDivideVencerasCasoAleatorio.inversionDV());
                        break;
                    case 5:
                        vectorParaInversionDivideVencerasPeorCaso = new vectores(ini);
                        vectorParaInversionDivideVencerasPeorCaso.rellenarEnOrdenInverso();
                        m.asignaValor(j, i, vectorParaInversionDivideVencerasPeorCaso.inversionDV());
                        break;
                }
                ini++;
            }
        }
    }
    public void guardarDatos(String t){
        m.guardaTiempos(t);
    }
    public void imprimirTiempos(){
        m.imprimeTiempos();
    }
}
