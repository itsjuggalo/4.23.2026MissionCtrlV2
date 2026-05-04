package ja;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f14301a;

    public static b b() {
        if (f14301a == null) {
            f14301a = new b();
        }
        return f14301a;
    }

    @Override // ja.a
    public long a() {
        return System.currentTimeMillis();
    }
}
