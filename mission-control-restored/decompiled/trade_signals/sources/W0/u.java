package W0;

import q1.AbstractC2628k;
import r1.AbstractC2670a;
import r1.AbstractC2672c;

/* JADX INFO: loaded from: classes.dex */
public final class u implements v, AbstractC2670a.f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final S.d f9221e = AbstractC2670a.d(20, new a());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC2672c f9222a = AbstractC2672c.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v f9223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9225d;

    public class a implements AbstractC2670a.d {
        @Override // r1.AbstractC2670a.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public u a() {
            return new u();
        }
    }

    public static u f(v vVar) {
        u uVar = (u) AbstractC2628k.d((u) f9221e.b());
        uVar.e(vVar);
        return uVar;
    }

    private void g() {
        this.f9223b = null;
        f9221e.a(this);
    }

    @Override // r1.AbstractC2670a.f
    public AbstractC2672c a() {
        return this.f9222a;
    }

    @Override // W0.v
    public synchronized void b() {
        this.f9222a.c();
        this.f9225d = true;
        if (!this.f9224c) {
            this.f9223b.b();
            g();
        }
    }

    @Override // W0.v
    public int c() {
        return this.f9223b.c();
    }

    @Override // W0.v
    public Class d() {
        return this.f9223b.d();
    }

    public final void e(v vVar) {
        this.f9225d = false;
        this.f9224c = true;
        this.f9223b = vVar;
    }

    @Override // W0.v
    public Object get() {
        return this.f9223b.get();
    }

    public synchronized void h() {
        this.f9222a.c();
        if (!this.f9224c) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f9224c = false;
        if (this.f9225d) {
            b();
        }
    }
}
