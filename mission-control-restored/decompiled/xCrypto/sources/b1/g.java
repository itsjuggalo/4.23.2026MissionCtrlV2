package b1;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    public enum a {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR,
        INVALID_PAYLOAD
    }

    public static g a() {
        return new C0858b(a.FATAL_ERROR, -1L);
    }

    public static g d() {
        return new C0858b(a.INVALID_PAYLOAD, -1L);
    }

    public static g e(long j4) {
        return new C0858b(a.OK, j4);
    }

    public static g f() {
        return new C0858b(a.TRANSIENT_ERROR, -1L);
    }

    public abstract long b();

    public abstract a c();
}
