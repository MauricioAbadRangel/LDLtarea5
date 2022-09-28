public class ListaDoblementeLigada<T> {

    NodoDoble<T> cabeza;

    public ListaDoblementeLigada {
        this.cabeza = null;
        this.tamano = 0;
    }

    public boolean estaVacia() {
        return this.cabeza == null;
    }

    public int Tamano() {
        int Tamano;
        return Tamano;
    }

    public void agregarAlFinal(T valor) {
        NodoDoble<T> Nuevo = new NodoDoble(valor);
        if (this.estaVacia()) {
            this.cabeza = Nuevo;
        } else {
            NodoDoble<T> Aux = this.cabeza;
            while (Aux.getSiguiente() != null) {
                Aux = (NodoDoble<T>) Aux.getSiguiente();
                Nuevo.setAnterior(Aux);
            }
            Aux.setSiguiente(Nuevo);
            Aux = null;
            Nuevo = null;
        }
    }

    public void agregarAlInicio(T valor) {
        NodoDoble<T> Aux = new NodoDoble(valor);
        if (this.estaVacia()) {
            this.cabeza = Aux;
        } else {
            Aux.setSiguiente(cabeza);
            cabeza = Aux;
        }
    }

    public void agregarSiguiente(int posición, T valor) {
        NodoDoble Aux = new NodoDoble(valor);
        NodoDoble Tem = this.cabeza;
        for (var contador = 1; contador <= posición - 1; contador++) {
            Tem = (NodoDoble) Tem.getSiguiente();
        }
        Aux.setSiguiente(Tem.getSiguiente());
        Tem.setSiguiente(Aux);
        Tem.setAnterior(Tem.getAnterior());
    }

    public void eliminar(int posición) {
        NodoDoble Aux = cabeza;
        if (this.estaVacia()) {
            System.out.println("Lista vacia, llénala primero alcornoque");
        } else {
            if (posición > cabeza.toString().length()) {
                System.out.println("La posición introducida no existe en esta lista, alcornoque");
            } else {
                for (int contador = 1; contador < posición - 1; contador++) {
                    Aux = (NodoDoble) Aux.getSiguiente();
                }
            }
        }

        Aux.setSiguiente(Aux.getSiguiente().getSiguiente());
        Aux.setAnterior(Aux.getAnterior());
    }

    public void eliminarElPrimero() {
        NodoDoble Aux = cabeza;
        if (this.estaVacia()) {
            cabeza = Aux;
        } else {
            cabeza = (NodoDoble<T>) Aux.getSiguiente();
        }
    }

    public void eliminarElFinal() {
        NodoDoble Aux = cabeza;
        if (this.estaVacia()) {
            cabeza = Aux;
        } else {
            while (Aux.getSiguiente().getSiguiente() != null) {
                Aux = (NodoDoble) Aux.getSiguiente();
            }
            Aux.setSiguiente(null);
        }
    }

    public int buscarValor(T valor) {
        NodoDoble Aux = cabeza;
        int posición = 1;
        if (this.estaVacia()) {
            System.out.println("No hay valor, la cadena está vacía.");
        } else {
            while (Aux.getDato() != valor) {
                Aux = (NodoDoble) Aux.getSiguiente();
                posición++;
            }
        }
        return posición;
    }

    public void actualizarValor(T valor, T actualizado) {
        NodoDoble Aux = cabeza;
        while (Aux.getDato() != valor) {
            Aux = (NodoDoble) Aux.getSiguiente();
        }
        Aux.setDato(actualizado);
    }

    public void transversal() {
        NodoDoble nodo_actual = this.cabeza;
        while (nodo_actual != null) {
            System.out.print(nodo_actual);
            nodo_actual = (NodoDoble) nodo_actual.getSiguiente();
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        ListaDoblementeLigada Cabeza = new ListaDoblementeLigada();
        Cabeza.agregarAlFinal(1);
        Cabeza.agregarAlFinal(5);
        Cabeza.agregarAlFinal(54);
        Cabeza.agregarAlFinal(100);
        Cabeza.transversal();
        Cabeza.eliminarElFinal();
        Cabeza.actualizarValor(2, 988);
        Cabeza.transversal();
        Cabeza.eliminarElPrimero();
        Cabeza.transversal();
        Cabeza.eliminar(2);
        Cabeza.transversal();
        Cabeza.agregarSiguiente(1, 6);
        Cabeza.transversal();
        Cabeza.agregarAlFinal(4);
        Cabeza.agregarAlInicio(2);
        Cabeza.transversal();
        System.out.println(Cabeza.buscarValor(27));
    }

}