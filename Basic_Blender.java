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
}