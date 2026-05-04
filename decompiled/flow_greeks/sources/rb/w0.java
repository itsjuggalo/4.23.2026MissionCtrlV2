package rb;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w0 {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    public static w0 d() {
        w0 w0VarD = x0.b().d();
        if (w0VarD != null) {
            return w0VarD;
        }
        throw new a("No functional channel service provider found. Try adding a dependency on the grpc-okhttp, grpc-netty, or grpc-netty-shaded artifact");
    }

    public abstract v0 a(String str);

    public abstract boolean b();

    public abstract int c();
}
