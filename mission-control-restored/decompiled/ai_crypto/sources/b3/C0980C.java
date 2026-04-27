package b3;

import N3.a;

/* JADX INFO: renamed from: b3.C, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0980C implements N3.b, N3.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a.InterfaceC0058a f8503c = new a.InterfaceC0058a() { // from class: b3.z
        @Override // N3.a.InterfaceC0058a
        public final void a(N3.b bVar) {
            C0980C.f(bVar);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final N3.b f8504d = new N3.b() { // from class: b3.A
        @Override // N3.b
        public final Object get() {
            return C0980C.g();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a.InterfaceC0058a f8505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile N3.b f8506b;

    public C0980C(a.InterfaceC0058a interfaceC0058a, N3.b bVar) {
        this.f8505a = interfaceC0058a;
        this.f8506b = bVar;
    }

    public static C0980C e() {
        return new C0980C(f8503c, f8504d);
    }

    public static /* synthetic */ Object g() {
        return null;
    }

    public static /* synthetic */ void h(a.InterfaceC0058a interfaceC0058a, a.InterfaceC0058a interfaceC0058a2, N3.b bVar) {
        interfaceC0058a.a(bVar);
        interfaceC0058a2.a(bVar);
    }

    public static C0980C i(N3.b bVar) {
        return new C0980C(null, bVar);
    }

    @Override // N3.a
    public void a(final a.InterfaceC0058a interfaceC0058a) {
        N3.b bVar;
        N3.b bVar2;
        N3.b bVar3 = this.f8506b;
        N3.b bVar4 = f8504d;
        if (bVar3 != bVar4) {
            interfaceC0058a.a(bVar3);
            return;
        }
        synchronized (this) {
            bVar = this.f8506b;
            if (bVar != bVar4) {
                bVar2 = bVar;
            } else {
                final a.InterfaceC0058a interfaceC0058a2 = this.f8505a;
                this.f8505a = new a.InterfaceC0058a() { // from class: b3.B
                    @Override // N3.a.InterfaceC0058a
                    public final void a(N3.b bVar5) {
                        C0980C.h(interfaceC0058a2, interfaceC0058a, bVar5);
                    }
                };
                bVar2 = null;
            }
        }
        if (bVar2 != null) {
            interfaceC0058a.a(bVar);
        }
    }

    @Override // N3.b
    public Object get() {
        return this.f8506b.get();
    }

    public void j(N3.b bVar) {
        a.InterfaceC0058a interfaceC0058a;
        if (this.f8506b != f8504d) {
            throw new IllegalStateException("provide() can be called only once.");
        }
        synchronized (this) {
            interfaceC0058a = this.f8505a;
            this.f8505a = null;
            this.f8506b = bVar;
        }
        interfaceC0058a.a(bVar);
    }

    public static /* synthetic */ void f(N3.b bVar) {
    }
}
