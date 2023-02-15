
package vectores;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class MatrizDeTiempos {
    private int filas;
    private int columnas;
    private long[][] datos;
    private String[] titulos;
    
    public MatrizDeTiempos(int f, int c, String[] t){
        filas = f;
        columnas = c;
        titulos = t;
        datos = new long[filas][columnas];
    }
    public void asignaValor(int f, int c, long dato){
        datos[f][c] = dato;
    }
    public void imprimeTiempos(){
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                System.out.println(datos[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void guardaTiempos(String titulo){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(titulo))) {
            for(int i=0;i<this.filas;i++){
                String fila = "";
                fila += this.titulos[i] + ";";
                for(int j=0;j<this.columnas;j++){
                    fila += this.datos[i][j] + ";";
                }
                fila += "\n";
                writer.write(fila);
            }
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}