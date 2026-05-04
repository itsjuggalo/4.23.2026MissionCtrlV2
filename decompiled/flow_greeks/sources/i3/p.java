package i3;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class p implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f11740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f11741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g3.f f11742e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11743f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f11744g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        void a(g3.f fVar, p pVar);
    }

    public p(v vVar, boolean z10, boolean z11, g3.f fVar, a aVar) {
        this.f11740c = (v) c4.k.e(vVar);
        this.f11738a = z10;
        this.f11739b = z11;
        this.f11742e = fVar;
        this.f11741d = (a) c4.k.e(aVar);
    }

    public synchronized void a() {
        if (this.f11744g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f11743f++;
    }

    @Override // i3.v
    public synchronized void b() {
        if (this.f11743f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f11744g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f11744g = true;
        if (this.f11739b) {
            this.f11740c.b();
        }
    }

    @Override // i3.v
    public int c() {
        return this.f11740c.c();
    }

    @Override // i3.v
    public Class d() {
        return this.f11740c.d();
    }

    public v e() {
        return this.f11740c;
    }

    public boolean f() {
        return this.f11738a;
    }

    public void g() {
        boolean z10;
        synchronized (this) {
            int i10 = this.f11743f;
            if (i10 <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z10 = true;
            int i11 = i10 - 1;
            this.f11743f = i11;
            if (i11 != 0) {
                z10 = false;
            }
        }
        if (z10) {
            this.f11741d.a(this.f11742e, this);
        }
    }

    @Override // i3.v
    public Object get() {
        return this.f11740c.get();
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f11738a + ", listener=" + this.f11741d + ", key=" + this.f11742e + ", acquired=" + this.f11743f + ", isRecycled=" + this.f11744g + ", resource=" + this.f11740c + '}';
    }
}
