import java.util.Scanner
public class BasicBlender implements Blender {
    private boolean encendido;
    private boolean llena;
    private String contenido;
    private int velocidad;

    // Constructor
    public BasicBlender() {
        this.encendido = false;
        this.llena = false;
        this.contenido = "";
        this.velocidad = 0;
    }

    @Override
    public void encender() {
        if (!llena) {
            System.out.println("No se puede encender la licuadora porque está vacía.");
        } else {
            encendido = true;
            System.out.println("Licuadora encendida.");
        }
    }

    @Override
    public void apagar() {
        encendido = false;
        velocidad = 0;
        System.out.println("Licuadora apagada. Velocidad reducida a 0.");
    }

    @Override
    public void llenar(String content) {
        if (llena) {
            System.out.println("La licuadora ya está llena.");
        } else {
            llena = true;
            contenido = content;
            System.out.println("Licuadora llena con: " + content);
        }
    }

    @Override
    public void vaciar() {
        llena = false;
        contenido = "";
        System.out.println("Licuadora vaciada.");
    }

    @Override
    public void aumentarVelocidad() {
        if (!encendido) {
            System.out.println("No se puede aumentar la velocidad porque la licuadora está apagada.");
        } else if (velocidad < 5) {
            velocidad++;
            System.out.println("Velocidad aumentada a: " + velocidad);
        } else {
            System.out.println("Velocidad máxima alcanzada.");
        }
    }

    @Override
    public void reducirVelocidad() {
        if (!encendido) {
            System.out.println("No se puede reducir la velocidad porque la licuadora está apagada.");
        } else if (velocidad > 0) {
            velocidad--;
            System.out.println("Velocidad reducida a: " + velocidad);
        } else {
            System.out.println("La licuadora ya está en la velocidad mínima.");
        }
    }

    @Override
    public boolean estaLlena() {
        System.out.println("Estado de la licuadora: " + (llena ? "Llena" : "Vacía"));
        return llena;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public static void main(String[] args){
        BasicBlender blender = new BasicBlender();
        Scanner scanner = new Scanner;
        int opcion;
        do{
            System.out.println("\n--- Menú de la Licuadora ---");
            System.out.println("1. Encender");
            System.out.println("2. Apagar");
            System.out.println("3. Llenar");
            System.out.println("4. Vaciar");
            System.out.println("5. Aumentar Velocidad");
            System.out.println("6. Reducir Velocidad");
            System.out.println("7. Verificar si está llena");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    blender.encender();
                    break;
                case 2:
                    blender.apagar();
                    break;
                case 3:
                    System.out.print("Ingrese el contenido para llenar la licuadora: ");
                    String contenido = scanner.nextLine();
                    blender.llenar(contenido);
                    break;
                case 4:
                    blender.vaciar();
                    break;
                case 5:
                    blender.aumentarVelocidad();
                    break;
                case 6:
                    blender.reducirVelocidad();
                    break;
                case 7:
                    blender.estaLlena();
                    break;
                case 8:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 8);
        scanner.close();
    }
        
}
