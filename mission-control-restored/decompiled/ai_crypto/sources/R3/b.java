package R3;

/* JADX INFO: loaded from: classes.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f4682a;

    public static b b() {
        if (f4682a == null) {
            f4682a = new b();
        }
        return f4682a;
    }

    @Override // R3.a
    public long a() {
        return System.currentTimeMillis();
    }
}
