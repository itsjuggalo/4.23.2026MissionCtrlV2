package wb;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final hh.g f23817d = hh.g.c(":status");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final hh.g f23818e = hh.g.c(":method");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final hh.g f23819f = hh.g.c(":path");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final hh.g f23820g = hh.g.c(":scheme");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final hh.g f23821h = hh.g.c(":authority");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final hh.g f23822i = hh.g.c(":host");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final hh.g f23823j = hh.g.c(":version");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hh.g f23824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final hh.g f23825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f23826c;

    public d(String str, String str2) {
        this(hh.g.c(str), hh.g.c(str2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.f23824a.equals(dVar.f23824a) && this.f23825b.equals(dVar.f23825b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f23824a.hashCode()) * 31) + this.f23825b.hashCode();
    }

    public String toString() {
        return String.format("%s: %s", this.f23824a.K(), this.f23825b.K());
    }

    public d(hh.g gVar, String str) {
        this(gVar, hh.g.c(str));
    }

    public d(hh.g gVar, hh.g gVar2) {
        this.f23824a = gVar;
        this.f23825b = gVar2;
        this.f23826c = gVar.B() + 32 + gVar2.B();
    }
}
