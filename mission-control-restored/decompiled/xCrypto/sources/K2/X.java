package K2;

/* JADX INFO: loaded from: classes3.dex */
public abstract class X {

    public static final class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    public static X d() {
        X xD = Y.b().d();
        if (xD != null) {
            return xD;
        }
        throw new a("No functional channel service provider found. Try adding a dependency on the grpc-okhttp, grpc-netty, or grpc-netty-shaded artifact");
    }

    public abstract W a(String str);

    public abstract boolean b();

    public abstract int c();
}
