package vd;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends h implements d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f23404e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j f23405f = new j(1, 0);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public j(long j10, long j11) {
        super(j10, j11, 1L);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        if (isEmpty() && ((j) obj).isEmpty()) {
            return true;
        }
        j jVar = (j) obj;
        return e() == jVar.e() && f() == jVar.f();
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((((long) 31) * (e() ^ (e() >>> 32))) + (f() ^ (f() >>> 32)));
    }

    @Override // vd.d
    public boolean isEmpty() {
        return e() > f();
    }

    @Override // vd.d
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public Long c() {
        return Long.valueOf(f());
    }

    @Override // vd.d
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public Long a() {
        return Long.valueOf(e());
    }

    public String toString() {
        return e() + ".." + f();
    }
}
