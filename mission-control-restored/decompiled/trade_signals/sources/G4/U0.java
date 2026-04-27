package G4;

import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public final class U0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b f2619l = new b(R0.f2542a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final R0 f2620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f2621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f2622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f2623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f2624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f2625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f2626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f2627h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f2628i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final InterfaceC0527f0 f2629j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile long f2630k;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final R0 f2631a;

        public b(R0 r02) {
            this.f2631a = r02;
        }

        public U0 a() {
            return new U0(this.f2631a);
        }
    }

    public interface c {
    }

    public U0(R0 r02) {
        this.f2629j = AbstractC0529g0.a();
        this.f2620a = r02;
    }

    public static b a() {
        return f2619l;
    }

    public void b() {
        this.f2625f++;
    }

    public void c() {
        this.f2621b++;
        this.f2622c = this.f2620a.a();
    }

    public void d() {
        this.f2629j.a(1L);
        this.f2630k = this.f2620a.a();
    }

    public void e(int i8) {
        if (i8 == 0) {
            return;
        }
        this.f2627h += (long) i8;
        this.f2628i = this.f2620a.a();
    }

    public void f(boolean z7) {
        if (z7) {
            this.f2623d++;
        } else {
            this.f2624e++;
        }
    }

    public void g(c cVar) {
        this.f2626g = (c) AbstractC2848n.n(cVar);
    }
}
