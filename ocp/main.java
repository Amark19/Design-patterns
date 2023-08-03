package solid.live.ocp;

public class main {
    public static void main(String[] args) {
        ResourceAllocator ok = new ResourceAllocator();
        ok.allocate(new Time());
        ok.free(0);
    }
}
