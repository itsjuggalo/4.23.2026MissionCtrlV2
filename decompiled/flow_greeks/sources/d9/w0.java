package d9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class w0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final w0 f7961g = new w0(0, 0, 0, 0, null, a.SUCCESS);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f7964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f7965d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f7966e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Exception f7967f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum a {
        ERROR,
        RUNNING,
        SUCCESS
    }

    public w0(int i10, int i11, long j10, long j11, Exception exc, a aVar) {
        this.f7962a = i10;
        this.f7963b = i11;
        this.f7964c = j10;
        this.f7965d = j11;
        this.f7966e = aVar;
        this.f7967f = exc;
    }

    public static w0 a(f9.e eVar) {
        return new w0(0, eVar.e(), 0L, eVar.d(), null, a.RUNNING);
    }

    public static w0 b(f9.e eVar) {
        return new w0(eVar.e(), eVar.e(), eVar.d(), eVar.d(), null, a.SUCCESS);
    }

    public long c() {
        return this.f7964c;
    }

    public int d() {
        return this.f7962a;
    }

    public a e() {
        return this.f7966e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && w0.class == obj.getClass()) {
            w0 w0Var = (w0) obj;
            if (this.f7962a != w0Var.f7962a || this.f7963b != w0Var.f7963b || this.f7964c != w0Var.f7964c || this.f7965d != w0Var.f7965d || this.f7966e != w0Var.f7966e) {
                return false;
            }
            Exception exc = this.f7967f;
            Exception exc2 = w0Var.f7967f;
            if (exc != null) {
                return exc.equals(exc2);
            }
            if (exc2 == null) {
                return true;
            }
        }
        return false;
    }

    public long f() {
        return this.f7965d;
    }

    public int g() {
        return this.f7963b;
    }

    public int hashCode() {
        int i10 = ((this.f7962a * 31) + this.f7963b) * 31;
        long j10 = this.f7964c;
        int i11 = (i10 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.f7965d;
        int iHashCode = (((i11 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + this.f7966e.hashCode()) * 31;
        Exception exc = this.f7967f;
        return iHashCode + (exc != null ? exc.hashCode() : 0);
    }
}
