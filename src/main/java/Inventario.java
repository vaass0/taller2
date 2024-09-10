import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Inventario {
    public boolean agregarProductos(Object[][] listaProductos, int idProducto, int cantidad,String nombre){
        int stock;
        for (Object[] listaProducto : listaProductos){
            if(listaProducto[0] == null ){
                listaProducto[0] = idProducto;
                listaProducto[1] = nombre;
                listaProducto[2] = cantidad;
                return true;
                    }
            if(listaProducto[0].equals(idProducto) || listaProducto[1].equals(nombre)) {
                stock = (Integer) listaProducto[2];
                stock = stock + cantidad;
                listaProducto[2] = stock;
                return true;
            }
        }return false;
    }
    public Object[][] crearMatriz(){
        Object[][] lista = new Object[10][3];
        return lista;
    }
    public static String leerString(){
        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();
    }
    public static int leerNum(){
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }
    public boolean restarProductos(Object[][] listaProductos, int idProducto, int cantidad){
        int stock;
        for (Object[] listaProducto : listaProductos){
            if(listaProducto[0].equals(idProducto)){
                stock = (Integer) listaProducto[2];
                stock = stock - cantidad;
                if (stock >=0){
                    listaProducto[2] = stock;
                    return true;
                }
                return false;
            }
        }
        return false;
    }
    public int consultarDisponibilidad(Object[][] listaProductos,int idProducto){
        for (Object[] listaProducto : listaProductos) {
            if (listaProducto[0].equals(idProducto)) {
                int cantidad = (Integer) listaProducto[2];
                return cantidad;
            }
        }
        return 0;
    }
    public void listarProductos(Object[][] listaProductos){
        for (Object[] listaProducto : listaProductos) {
           if( listaProducto[0] != null) {
               System.out.println("////////////////////////////");
               System.out.println("identificador del producto: " + listaProducto[0]);
               System.out.println("Nombre del producto: " + listaProducto[1]);
               System.out.println("Cantidad del producto: " + listaProducto[2]);
           }
        }
    }
    public boolean validadorId(Object[][] listaProductos, int id){
        for (Object[] listaProducto : listaProductos) {
            if(listaProducto[0] == null){
                return false;
            }
            if(listaProducto[0].equals(id)){
                return true;
            }
        }
        return false;
    }
    public void menu(Object[][] listaProductos) {
        int op = 0;
        while (op != 5) {
            try {
                System.out.println("========== Menú ==========");
                System.out.println("1. Opción 1: Agregar producto");
                System.out.println("2. Opción 2: Restar producto");
                System.out.println("3. Opción 3: Mostrar stock de producto");
                System.out.println("4. Opción 4: Mostrar productos");
                System.out.println("5. Opción 5: Salir");
                System.out.print("Elige una opción: ");

                op = leerNum();

                switch (op){
                    case 1:
                        try {
                            System.out.println("----Agregar producto---- ");
                            System.out.println("Ingrese id del producto: ");
                            int id = leerNum();
                            System.out.println("Ingrese cantidad del producto: ");
                            int cantidad = leerNum();
                            while(true) {
                                if (cantidad >= 0) {
                                    if (validadorId(listaProductos, id)) {
                                        if (agregarProductos(listaProductos, id, cantidad, "")) {
                                            System.out.println("Se ha agregado el producto correctamente...");
                                        } else {
                                            System.out.println("No se ha podido agregar el producto...");
                                        }
                                    } else {
                                        System.out.println("Ingrese nombre del producto: ");
                                        String nombre = leerString();
                                        if (agregarProductos(listaProductos, id, cantidad, nombre)) {
                                            System.out.println("Se ha agregado el producto correctamente...");
                                        } else {
                                            System.out.println("No se ha podido agregar el producto...");
                                        }
                                    }
                                    break;
                                } else {
                                    System.out.println("Ingrese un numero positivo...");
                                }
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println(" Por favor ingresa un número valido....");
                        }
                        break;
                    case 2:
                        try {

                            while (true) {
                                System.out.println("----Restar producto---- ");
                                System.out.println("Ingrese id del producto: ");
                                int id = leerNum();
                                System.out.println("Ingrese cantidad a restar del producto: ");
                                int cantidad = leerNum();
                                if (cantidad >= 0) {
                                    if (validadorId(listaProductos, id)) {
                                        if (restarProductos(listaProductos, id, cantidad)) {
                                            System.out.println("Se ha restado el producto correctamente...");
                                            break;
                                        } else {
                                            System.out.println("No se ha podido agregar el producto...");
                                        }
                                    } else {
                                        System.out.println("Ingrese un id valido... ");
                                    }
                                }
                            }
                        }catch (InputMismatchException e) {
                            System.out.println(" Por favor ingresa un número valido....");
                        }
                        break;
                    case 3:
                        while (true) {
                                System.out.println("----Mostrar cantidad producto---- ");
                                System.out.println("Ingrese id del producto: ");
                                int id = leerNum();
                                if (validadorId(listaProductos, id)) {
                                    System.out.println("El item consultando tiene un stock de :" + consultarDisponibilidad(listaProductos,id));
                                    break;
                                }
                                else {
                                    System.out.println("Ingrese un id valido... ");
                                }
                        }
                        break;
                    case 4:
                        listarProductos(listaProductos);
                        break;
                    case 5:
                        System.out.println("Gracias por su preferencia...");
                        System.out.println("By Eduardo Huidobro...");
                        break;
            }
            }

                    catch (InputMismatchException e){
                    System.out.println(" Por favor ingresa un número valido....");
                        }
        }
    }

    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Object[][] listaProductos = inventario.crearMatriz();
        inventario.menu(listaProductos);
    }
}

