package A3;

/* JADX INFO: loaded from: classes.dex */
public final class X {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final X f151g = new X(0, 0, 0, 0, null, a.SUCCESS);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Exception f157f;

    public enum a {
        ERROR,
        RUNNING,
        SUCCESS
    }

    public X(int i7, int i8, long j7, long j8, Exception exc, a aVar) {
        this.f152a = i7;
        this.f153b = i8;
        this.f154c = j7;
        this.f155d = j8;
        this.f156e = aVar;
        this.f157f = exc;
    }

    public static X a(C3.e eVar) {
        return new X(0, eVar.e(), 0L, eVar.d(), null, a.RUNNING);
    }

    public static X b(C3.e eVar) {
        return new X(eVar.e(), eVar.e(), eVar.d(), eVar.d(), null, a.SUCCESS);
    }

    public long c() {
        return this.f154c;
    }

    public int d() {
        return this.f152a;
    }

    public a e() {
        return this.f156e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || X.class != obj.getClass()) {
            return false;
        }
        X x7 = (X) obj;
        if (this.f152a != x7.f152a || this.f153b != x7.f153b || this.f154c != x7.f154c || this.f155d != x7.f155d || this.f156e != x7.f156e) {
            return false;
        }
        Exception exc = this.f157f;
        Exception exc2 = x7.f157f;
        return exc != null ? exc.equals(exc2) : exc2 == null;
    }

    public long f() {
        return this.f155d;
    }

    public int g() {
        return this.f153b;
    }

    public int hashCode() {
        int i7 = ((this.f152a * 31) + this.f153b) * 31;
        long j7 = this.f154c;
        int i8 = (i7 + ((int) (j7 ^ (j7 >>> 32)))) * 31;
        long j8 = this.f155d;
        int iHashCode = (((i8 + ((int) (j8 ^ (j8 >>> 32)))) * 31) + this.f156e.hashCode()) * 31;
        Exception exc = this.f157f;
        return iHashCode + (exc != null ? exc.hashCode() : 0);
    }
}
