package W0;

import q1.AbstractC2628k;

/* JADX INFO: loaded from: classes.dex */
public class p implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f9201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f9202d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final U0.f f9203e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f9204f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f9205g;

    public interface a {
        void c(U0.f fVar, p pVar);
    }

    public p(v vVar, boolean z7, boolean z8, U0.f fVar, a aVar) {
        this.f9201c = (v) AbstractC2628k.d(vVar);
        this.f9199a = z7;
        this.f9200b = z8;
        this.f9203e = fVar;
        this.f9202d = (a) AbstractC2628k.d(aVar);
    }

    public synchronized void a() {
        if (this.f9205g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f9204f++;
    }

    @Override // W0.v
    public synchronized void b() {
        if (this.f9204f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f9205g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f9205g = true;
        if (this.f9200b) {
            this.f9201c.b();
        }
    }

    @Override // W0.v
    public int c() {
        return this.f9201c.c();
    }

    @Override // W0.v
    public Class d() {
        return this.f9201c.d();
    }

    public v e() {
        return this.f9201c;
    }

    public boolean f() {
        return this.f9199a;
    }

    public void g() {
        boolean z7;
        synchronized (this) {
            int i8 = this.f9204f;
            if (i8 <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z7 = true;
            int i9 = i8 - 1;
            this.f9204f = i9;
            if (i9 != 0) {
                z7 = false;
            }
        }
        if (z7) {
            this.f9202d.c(this.f9203e, this);
        }
    }

    @Override // W0.v
    public Object get() {
        return this.f9201c.get();
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f9199a + ", listener=" + this.f9202d + ", key=" + this.f9203e + ", acquired=" + this.f9204f + ", isRecycled=" + this.f9205g + ", resource=" + this.f9201c + '}';
    }
}
