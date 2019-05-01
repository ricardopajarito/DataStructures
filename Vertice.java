

public class Vertice {

    private int MAX=1000;
    private int padre[]=new int[MAX];

    private int V;
    private int E;

    private nodo lista;
    private int size;

    Vertice(int v, int e){
        this.lista=null;
        this.size=0;
        this.V=v;
        this.E=e;
    }
    //Metodos para el arreglo
    private void inicializar(int n){
        for(int i=0;i<n;i++)
            padre[i]=i;
    }
    private int encontrarRaiz(int x){
        if(x==padre[x])
            return x;
        else return padre[x]=encontrarRaiz(padre[x]);
    }
    private void union(int x, int y){
        int raizX=encontrarRaiz(x);
        int raizY=encontrarRaiz(y);
        //if(!mismaComponente(x,y)){
        padre[raizX]=raizY;
        //}
    }
    private boolean mismaComponente(int x, int y){
        if(encontrarRaiz(x)==encontrarRaiz(y))
            return true;
        return false;
    }
    //NODO
    public class nodo {
        private int origen;
        private int destino;
        private int peso;
        private nodo ref;

        public nodo() {
            this.peso = 0;
            this.ref = null;
        }

        public void inOrigen(int origen) {
            this.origen = origen;
        }

        public int exOrigen() {
            return origen;
        }

        public void inDestino(int destino) {
            this.destino = destino;
        }

        public int exDestino() {
            return destino;
        }

        public void InValor(int valor) {
            this.peso = valor;
        }

        public void InRef(nodo r) {
            this.ref = r;
        }
        public int ExValor () {
            return peso;
        }
        public nodo ExRef () {
            return ref;
        }

    }

        //fin de nodo
        public void insertar(int origen, int destino, int valor) {
            //nodo temp=lista; //raiz
            //nodo temp1=null;
            //nuevo.InRef(null);
            nodo nuevo = new nodo();
            nuevo.InValor(valor);
            nuevo.inDestino(destino);
            nuevo.inOrigen(origen);
            size++;
            if (lista == null) {//raiz==null
                //aquí
                lista = nuevo;
            } else {

                if (valor < lista.ExValor()) {
                    nuevo.InRef(lista);
                    lista = nuevo;
                } else {
                    nodo reco = lista;
                    nodo atras = lista;
                    while (reco.ExRef() != null && valor >= reco.ExValor()) {
                        atras = reco;
                        reco = reco.ExRef();
                    }
                    if (valor >= reco.ExValor()) {
                        //
                        reco.InRef(nuevo);
                    } else {
                        nuevo.InRef(reco);
                        atras.InRef(nuevo);
                    }
                }
            }
        }

        //fin del metodo insertar

        public void recorrer() {
            nodo temp = lista;
            while (temp != null) {
                System.out.println("El valor es:" + temp.ExValor());
                temp = temp.ExRef();
            }
        }

        public void CaminoMinimo() {
            nodo MST[] = new nodo[MAX];
            int origen, destino, peso;
            int total = 0; //peso total del camino
            int numAristas = 0; //numero de aristass del camino

            inicializar(V);
            //hace el recorrido

            nodo temp = lista;

            while (temp != null) {
                origen = temp.origen;
                destino = temp.destino;
                peso = temp.peso;
                if (!mismaComponente(origen, destino)) {
                    total += peso;
                    MST[numAristas++] = temp;
                    union(origen, destino);
                }
                temp = temp.ExRef();
            }

            if (V - 1 != numAristas) {
                System.out.println("No existe camino válido para el grafo ingresado");
                return;
            }
            System.out.println("El camino encontrado contiene las siguientes aristas");
            for (int i = 0; i < numAristas; ++i)
                System.out.printf("(%d,%d): %d\n", MST[i].origen, MST[i].destino, MST[i].peso);
            System.out.printf("El costo minimo de todas las aristas del camino es: %d\n", total);
        }
}
