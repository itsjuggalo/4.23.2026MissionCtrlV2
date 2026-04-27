package M2;

import S3.a;

/* JADX INFO: loaded from: classes.dex */
public class C implements S3.b, S3.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a.InterfaceC0108a f5270c = new a.InterfaceC0108a() { // from class: M2.z
        @Override // S3.a.InterfaceC0108a
        public final void a(S3.b bVar) {
            C.f(bVar);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final S3.b f5271d = new S3.b() { // from class: M2.A
        @Override // S3.b
        public final Object get() {
            return C.g();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a.InterfaceC0108a f5272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile S3.b f5273b;

    public C(a.InterfaceC0108a interfaceC0108a, S3.b bVar) {
        this.f5272a = interfaceC0108a;
        this.f5273b = bVar;
    }

    public static C e() {
        return new C(f5270c, f5271d);
    }

    public static /* synthetic */ Object g() {
        return null;
    }

    public static /* synthetic */ void h(a.InterfaceC0108a interfaceC0108a, a.InterfaceC0108a interfaceC0108a2, S3.b bVar) {
        interfaceC0108a.a(bVar);
        interfaceC0108a2.a(bVar);
    }

    public static C i(S3.b bVar) {
        return new C(null, bVar);
    }

    @Override // S3.a
    public void a(final a.InterfaceC0108a interfaceC0108a) {
        S3.b bVar;
        S3.b bVar2;
        S3.b bVar3 = this.f5273b;
        S3.b bVar4 = f5271d;
        if (bVar3 != bVar4) {
            interfaceC0108a.a(bVar3);
            return;
        }
        synchronized (this) {
            bVar = this.f5273b;
            if (bVar != bVar4) {
                bVar2 = bVar;
            } else {
                final a.InterfaceC0108a interfaceC0108a2 = this.f5272a;
                this.f5272a = new a.InterfaceC0108a() { // from class: M2.B
                    @Override // S3.a.InterfaceC0108a
                    public final void a(S3.b bVar5) {
                        C.h(interfaceC0108a2, interfaceC0108a, bVar5);
                    }
                };
                bVar2 = null;
            }
        }
        if (bVar2 != null) {
            interfaceC0108a.a(bVar);
        }
    }

    @Override // S3.b
    public Object get() {
        return this.f5273b.get();
    }

    public void j(S3.b bVar) {
        a.InterfaceC0108a interfaceC0108a;
        if (this.f5273b != f5271d) {
            throw new IllegalStateException("provide() can be called only once.");
        }
        synchronized (this) {
            interfaceC0108a = this.f5272a;
            this.f5272a = null;
            this.f5273b = bVar;
        }
        interfaceC0108a.a(bVar);
    }

    public static /* synthetic */ void f(S3.b bVar) {
    }
}
