package i3;

import d4.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class u implements v, a.f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final s0.c f11760e = d4.a.d(20, new a());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d4.c f11761a = d4.c.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v f11762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11764d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements a.d {
        @Override // d4.a.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public u a() {
            return new u();
        }
    }

    public static u e(v vVar) {
        u uVar = (u) c4.k.e((u) f11760e.b());
        uVar.a(vVar);
        return uVar;
    }

    private void f() {
        this.f11762b = null;
        f11760e.a(this);
    }

    public final void a(v vVar) {
        this.f11764d = false;
        this.f11763c = true;
        this.f11762b = vVar;
    }

    @Override // i3.v
    public synchronized void b() {
        this.f11761a.c();
        this.f11764d = true;
        if (!this.f11763c) {
            this.f11762b.b();
            f();
        }
    }

    @Override // i3.v
    public int c() {
        return this.f11762b.c();
    }

    @Override // i3.v
    public Class d() {
        return this.f11762b.d();
    }

    public synchronized void g() {
        this.f11761a.c();
        if (!this.f11763c) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f11763c = false;
        if (this.f11764d) {
            b();
        }
    }

    @Override // i3.v
    public Object get() {
        return this.f11762b.get();
    }

    @Override // d4.a.f
    public d4.c i() {
        return this.f11761a;
    }
}
