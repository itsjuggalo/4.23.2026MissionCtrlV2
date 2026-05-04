package g9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10228b;

    public h1(int i10, int i11) {
        n9.b.d((i10 & 1) == i10, "Generator ID %d contains more than %d reserved bits", Integer.valueOf(i10), 1);
        this.f10228b = i10;
        d(i11);
    }

    public static h1 a() {
        return new h1(1, 1);
    }

    public static h1 b(int i10) {
        h1 h1Var = new h1(0, i10);
        h1Var.c();
        return h1Var;
    }

    public int c() {
        int i10 = this.f10227a;
        this.f10227a = i10 + 2;
        return i10;
    }

    public final void d(int i10) {
        n9.b.d((i10 & 1) == this.f10228b, "Cannot supply target ID from different generator ID", new Object[0]);
        this.f10227a = i10;
    }
}
