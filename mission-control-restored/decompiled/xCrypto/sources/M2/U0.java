package M2;

/* JADX INFO: loaded from: classes3.dex */
public final class U0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b f2031l = new b(R0.f1954a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final R0 f2032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f2033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f2034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f2035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f2036e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f2037f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f2038g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f2039h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f2040i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final InterfaceC0419f0 f2041j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile long f2042k;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final R0 f2043a;

        public b(R0 r02) {
            this.f2043a = r02;
        }

        public U0 a() {
            return new U0(this.f2043a);
        }
    }

    public interface c {
    }

    public static b a() {
        return f2031l;
    }

    public void b() {
        this.f2037f++;
    }

    public void c() {
        this.f2033b++;
        this.f2034c = this.f2032a.a();
    }

    public void d() {
        this.f2041j.add(1L);
        this.f2042k = this.f2032a.a();
    }

    public void e(int i4) {
        if (i4 == 0) {
            return;
        }
        this.f2039h += (long) i4;
        this.f2040i = this.f2032a.a();
    }

    public void f(boolean z4) {
        if (z4) {
            this.f2035d++;
        } else {
            this.f2036e++;
        }
    }

    public void g(c cVar) {
        this.f2038g = (c) Z1.m.n(cVar);
    }

    public U0(R0 r02) {
        this.f2041j = AbstractC0421g0.a();
        this.f2032a = r02;
    }
}
