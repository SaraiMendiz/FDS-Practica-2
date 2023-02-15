
package vectores;

public class vectores {
    
    private int[]vector;
    private int numeroElementos;
    public vectores(int N){
        numeroElementos = N;
        vector = new int [numeroElementos];
    }
    
    public void rellenarEnOrden(){
        for(int i = 0; i < numeroElementos; i++){
            vector[i] = i+1;
        }
    }
    public void rellenarManualmente(int n, int i){
        this.vector[i] = n;
    }
    public void rellenarEnOrdenInverso(){
        for(int i = vector.length - 1; i >= 0; i--){
            this.vector[i] = i+1;
        }
    }
    public void rellenarAleatorio(){
        int r = 0;
        for(int i = 0; i < numeroElementos; i++){     
                boolean x = false;
                r = (int) (Math.random() * numeroElementos + 1);
                for(int k = 0; k < numeroElementos; k++){
                if(vector[k] == r){
                    x = true;
                }
                }
                if(!x){
                vector[i] = r;
            }
                else i--;
            }
        }

    public long inversion(){
        long tiempo;
        long inicio = System.nanoTime();
        int numero_inversiones = 0;
        for(int i = 0; i < numeroElementos; i++){
            for(int j = i; j < numeroElementos; j++){
                    if(this.vector[j] < this.vector[i]){
                        numero_inversiones++;
                    }                
            }
        }
        tiempo = System.nanoTime() - inicio;
        //System.out.println("Inversiones: "+numero_inversiones);
        return tiempo;

    }
    public int inversiones(){
    int numero_inversiones = 0;
        for(int i = 0; i < numeroElementos; i++){
            for(int j = i; j < numeroElementos; j++){
                    if(this.vector[j] < this.vector[i]){
                        numero_inversiones++;
                    }                
            }
        }
        return numero_inversiones;
    }

         
         public long inversionDV(){
         long tiempo;
         long inicio = System.nanoTime();
            int medio = (this.vector.length / 2);
            this.inversionDivideVenceras(medio,0,0,0);           
         tiempo = System.nanoTime() - inicio;
         
         return tiempo;
     }
    public int inversionDivideVenceras(int medio,int k,int numero_inversiones, int x){
         for(int i = k; i < medio; i++){
             for(int j = i; j < medio; j++){
                 if(this.vector[i] > this.vector[j]){
                     numero_inversiones++;
                 }
             }
         }
         if(x == 0){
             this.ordenaPorMezcla(medio,0);

             return inversionDivideVenceras(this.vector.length, medio, numero_inversiones, 1);            
         }
         
         if(x ==1 ){
            this.ordenaPorMezcla(this.vector.length,this.vector.length /2);
            return inversionDivideVenceras(medio,0,numero_inversiones,2);
         }  
             return numero_inversiones;
    }
    public void imprimir(){
        for(int i = 0; i < numeroElementos; i++){
            System.out.print(this.vector[i]+" ");
        }
        System.out.println();
    }
     public void ordenaPorMezcla(int medio,int e){
        sort(vector,e,medio-1);
    }
    
    public void merge(int arr[], int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;
        
        int L[] = new int[n1];
        int R[] = new int[n2];
        
        for(int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for(int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];
        
        int i = 0, j = 0;
        
        int k = l; 
        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
    public void sort(int arr[], int l, int r){
        if(l < r){
            int m =l+ (r-l)/2;
 
            sort(arr, l, m);
            sort(arr, m + 1, r);
 
            merge(arr, l, m, r);
        }
    }
    
    
    
    
    
   /* public long inversion2(int m, int numero_inversiones){
        long tiempo = 0;
        long inicio = System.nanoTime();
        if(m < numeroElementos){
            for(int i = m; i < numeroElementos; i++){
                    if(this.vector[m] > this.vector[i]){
                        numero_inversiones++;
                    }
            }
            m++;
            inversion2(m,numero_inversiones);
            return -1;
        }
        else{
            tiempo = System.nanoTime() - inicio;
            return tiempo;
        }
    }*/
}