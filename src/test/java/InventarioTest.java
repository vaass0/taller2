import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventarioTest {
    Inventario inventario = new Inventario();
    Object[][] listaProductos = inventario.crearMatriz();
    @BeforeEach
    public void llenarLista(){
        listaProductos[0] = new Object[] {101,"Pan",10};
        listaProductos[1] = new Object[] {102,"Alfajor",25};
        listaProductos[2] = new Object[] {103,"Flan",15};
        listaProductos[3] = new Object[] {104,"Mantequilla",8};
        listaProductos[4] = new Object[] {105,"Sandia",5};
    }

    @Test
    void agregarProducto() {
        //revisa que el producto se haya agregado correctamente

        assertTrue(inventario.agregarProductos(listaProductos,106,20,"Papas Fritas"));
        assertEquals(106,listaProductos[5][0]);
        assertEquals("Papas Fritas",listaProductos[5][1]);
        assertEquals(20,listaProductos[5][2]);


        System.out.println("La prueba ha sido realizada sin ningun problema...");
    }
    @Test
    void actualizarProducto() {
        assertTrue(inventario.agregarProductos(listaProductos, 101, 20,""));
        assertEquals(30,listaProductos[0][2]);

        System.out.println("La prueba ha sido realizada sin ningun problema...");
    }
    @Test
    void restarProducto(){
        assertFalse(inventario.restarProductos(listaProductos, 101, 12));  //resta negativa
        assertTrue(inventario.restarProductos(listaProductos, 101, 10));  //resta posible

        System.out.println("La prueba ha sido realizada sin ningun problema...");
    }
    @Test
    void consultarDisponibilidad(){
        assertEquals(10,inventario.consultarDisponibilidad(listaProductos,101));
        assertEquals(25,inventario.consultarDisponibilidad(listaProductos,102));
        assertEquals(15,inventario.consultarDisponibilidad(listaProductos,103));
        assertEquals(8,inventario.consultarDisponibilidad(listaProductos,104));
        assertEquals(5,inventario.consultarDisponibilidad(listaProductos,105));

        System.out.println("La prueba ha sido realizada sin ningun problema...");


    }
    @Test
    void listarProductos(){
        inventario.listarProductos(listaProductos);
    }
    @Test
    void validadorId(){
        assertFalse(inventario.validadorId(listaProductos,106));
        assertTrue(inventario.validadorId(listaProductos,103));

        System.out.println("La prueba ha sido realizada sin ningun problema...");
    }
}