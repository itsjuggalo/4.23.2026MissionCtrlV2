package t5;

/* JADX INFO: loaded from: classes2.dex */
public final class U0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b f23582l = new b(R0.f23505a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final R0 f23583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f23584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f23585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f23586d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f23587e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f23588f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f23589g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f23590h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f23591i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final InterfaceC2674f0 f23592j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile long f23593k;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final R0 f23594a;

        public b(R0 r02) {
            this.f23594a = r02;
        }

        public U0 a() {
            return new U0(this.f23594a);
        }
    }

    public interface c {
    }

    public static b a() {
        return f23582l;
    }

    public void b() {
        this.f23588f++;
    }

    public void c() {
        this.f23584b++;
        this.f23585c = this.f23583a.a();
    }

    public void d() {
        this.f23592j.a(1L);
        this.f23593k = this.f23583a.a();
    }

    public void e(int i7) {
        if (i7 == 0) {
            return;
        }
        this.f23590h += (long) i7;
        this.f23591i = this.f23583a.a();
    }

    public void f(boolean z7) {
        if (z7) {
            this.f23586d++;
        } else {
            this.f23587e++;
        }
    }

    public void g(c cVar) {
        this.f23589g = (c) H2.m.n(cVar);
    }

    public U0(R0 r02) {
        this.f23592j = AbstractC2676g0.a();
        this.f23583a = r02;
    }
}
