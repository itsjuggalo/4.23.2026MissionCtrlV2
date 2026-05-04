package tb;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class t2 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b f21745l = new b(q2.f21623a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q2 f21746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f21747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f21748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f21749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f21750e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f21751f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f21752g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f21753h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f21754i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e1 f21755j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile long f21756k;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q2 f21757a;

        public b(q2 q2Var) {
            this.f21757a = q2Var;
        }

        public t2 a() {
            return new t2(this.f21757a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface c {
    }

    public static b a() {
        return f21745l;
    }

    public void b() {
        this.f21751f++;
    }

    public void c() {
        this.f21747b++;
        this.f21748c = this.f21746a.a();
    }

    public void d() {
        this.f21755j.add(1L);
        this.f21756k = this.f21746a.a();
    }

    public void e(int i10) {
        if (i10 == 0) {
            return;
        }
        this.f21753h += (long) i10;
        this.f21754i = this.f21746a.a();
    }

    public void f(boolean z10) {
        if (z10) {
            this.f21749d++;
        } else {
            this.f21750e++;
        }
    }

    public void g(c cVar) {
        this.f21752g = (c) p6.n.n(cVar);
    }

    public t2(q2 q2Var) {
        this.f21755j = f1.a();
        this.f21746a = q2Var;
    }
}
