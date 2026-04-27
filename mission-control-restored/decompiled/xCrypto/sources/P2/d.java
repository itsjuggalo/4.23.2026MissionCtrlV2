package P2;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final O3.g f3468d = O3.g.g(":status");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final O3.g f3469e = O3.g.g(":method");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final O3.g f3470f = O3.g.g(":path");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final O3.g f3471g = O3.g.g(":scheme");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final O3.g f3472h = O3.g.g(":authority");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final O3.g f3473i = O3.g.g(":host");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final O3.g f3474j = O3.g.g(":version");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final O3.g f3475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final O3.g f3476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3477c;

    public d(String str, String str2) {
        this(O3.g.g(str), O3.g.g(str2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.f3475a.equals(dVar.f3475a) && this.f3476b.equals(dVar.f3476b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f3475a.hashCode()) * 31) + this.f3476b.hashCode();
    }

    public String toString() {
        return String.format("%s: %s", this.f3475a.z(), this.f3476b.z());
    }

    public d(O3.g gVar, String str) {
        this(gVar, O3.g.g(str));
    }

    public d(O3.g gVar, O3.g gVar2) {
        this.f3475a = gVar;
        this.f3476b = gVar2;
        this.f3477c = gVar.v() + 32 + gVar2.v();
    }
}
