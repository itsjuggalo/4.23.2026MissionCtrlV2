package F4;

/* JADX INFO: loaded from: classes.dex */
public abstract class V {

    public static final class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    public static V d() {
        V vD = W.b().d();
        if (vD != null) {
            return vD;
        }
        throw new a("No functional channel service provider found. Try adding a dependency on the grpc-okhttp, grpc-netty, or grpc-netty-shaded artifact");
    }

    public abstract U a(String str);

    public abstract boolean b();

    public abstract int c();
}
