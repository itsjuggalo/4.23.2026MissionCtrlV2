package vd;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends e implements d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f23394e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g f23395f = new g(1, 0);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final g a() {
            return g.f23395f;
        }

        public a() {
        }
    }

    public g(int i10, int i11) {
        super(i10, i11, 1);
    }

    @Override // vd.e
    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        if (isEmpty() && ((g) obj).isEmpty()) {
            return true;
        }
        g gVar = (g) obj;
        return e() == gVar.e() && f() == gVar.f();
    }

    @Override // vd.e
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (e() * 31) + f();
    }

    @Override // vd.e, vd.d
    public boolean isEmpty() {
        return e() > f();
    }

    @Override // vd.d
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public Integer c() {
        return Integer.valueOf(f());
    }

    @Override // vd.d
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public Integer a() {
        return Integer.valueOf(e());
    }

    @Override // vd.e
    public String toString() {
        return e() + ".." + f();
    }
}
