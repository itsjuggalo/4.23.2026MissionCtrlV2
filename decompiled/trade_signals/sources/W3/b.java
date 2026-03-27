package W3;

/* JADX INFO: loaded from: classes.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f9279a;

    public static b b() {
        if (f9279a == null) {
            f9279a = new b();
        }
        return f9279a;
    }

    @Override // W3.a
    public long a() {
        return System.currentTimeMillis();
    }
}
