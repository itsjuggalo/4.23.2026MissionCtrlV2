package o7;

import fa.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c0 implements fa.b, fa.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a.InterfaceC0174a f17542c = new a.InterfaceC0174a() { // from class: o7.z
        @Override // fa.a.InterfaceC0174a
        public final void a(fa.b bVar) {
            c0.d(bVar);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final fa.b f17543d = new fa.b() { // from class: o7.a0
        @Override // fa.b
        public final Object get() {
            return c0.b();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a.InterfaceC0174a f17544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile fa.b f17545b;

    public c0(a.InterfaceC0174a interfaceC0174a, fa.b bVar) {
        this.f17544a = interfaceC0174a;
        this.f17545b = bVar;
    }

    public static /* synthetic */ Object b() {
        return null;
    }

    public static /* synthetic */ void c(a.InterfaceC0174a interfaceC0174a, a.InterfaceC0174a interfaceC0174a2, fa.b bVar) {
        interfaceC0174a.a(bVar);
        interfaceC0174a2.a(bVar);
    }

    public static c0 e() {
        return new c0(f17542c, f17543d);
    }

    public static c0 f(fa.b bVar) {
        return new c0(null, bVar);
    }

    @Override // fa.a
    public void a(final a.InterfaceC0174a interfaceC0174a) {
        fa.b bVar;
        fa.b bVar2;
        fa.b bVar3 = this.f17545b;
        fa.b bVar4 = f17543d;
        if (bVar3 != bVar4) {
            interfaceC0174a.a(bVar3);
            return;
        }
        synchronized (this) {
            bVar = this.f17545b;
            if (bVar != bVar4) {
                bVar2 = bVar;
            } else {
                final a.InterfaceC0174a interfaceC0174a2 = this.f17544a;
                this.f17544a = new a.InterfaceC0174a() { // from class: o7.b0
                    @Override // fa.a.InterfaceC0174a
                    public final void a(fa.b bVar5) {
                        c0.c(interfaceC0174a2, interfaceC0174a, bVar5);
                    }
                };
                bVar2 = null;
            }
        }
        if (bVar2 != null) {
            interfaceC0174a.a(bVar);
        }
    }

    public void g(fa.b bVar) {
        a.InterfaceC0174a interfaceC0174a;
        if (this.f17545b != f17543d) {
            throw new IllegalStateException("provide() can be called only once.");
        }
        synchronized (this) {
            interfaceC0174a = this.f17544a;
            this.f17544a = null;
            this.f17545b = bVar;
        }
        interfaceC0174a.a(bVar);
    }

    @Override // fa.b
    public Object get() {
        return this.f17545b.get();
    }

    public static /* synthetic */ void d(fa.b bVar) {
    }
}
