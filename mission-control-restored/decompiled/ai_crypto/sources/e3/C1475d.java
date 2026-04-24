package e3;

import N3.a;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;
import k3.AbstractC2074F;
import k3.AbstractC2075G;

/* JADX INFO: renamed from: e3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1475d implements InterfaceC1472a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f13594c = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final N3.a f13595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f13596b = new AtomicReference(null);

    /* JADX INFO: renamed from: e3.d$b */
    public static final class b implements h {
        public b() {
        }

        @Override // e3.h
        public File a() {
            return null;
        }

        @Override // e3.h
        public File b() {
            return null;
        }

        @Override // e3.h
        public File c() {
            return null;
        }

        @Override // e3.h
        public AbstractC2074F.a d() {
            return null;
        }

        @Override // e3.h
        public File e() {
            return null;
        }

        @Override // e3.h
        public File f() {
            return null;
        }

        @Override // e3.h
        public File g() {
            return null;
        }
    }

    public C1475d(N3.a aVar) {
        this.f13595a = aVar;
        aVar.a(new a.InterfaceC0058a() { // from class: e3.b
            @Override // N3.a.InterfaceC0058a
            public final void a(N3.b bVar) {
                this.f13589a.g(bVar);
            }
        });
    }

    public static /* synthetic */ void h(String str, String str2, long j7, AbstractC2075G abstractC2075G, N3.b bVar) {
        ((InterfaceC1472a) bVar.get()).d(str, str2, j7, abstractC2075G);
    }

    @Override // e3.InterfaceC1472a
    public h a(String str) {
        InterfaceC1472a interfaceC1472a = (InterfaceC1472a) this.f13596b.get();
        return interfaceC1472a == null ? f13594c : interfaceC1472a.a(str);
    }

    @Override // e3.InterfaceC1472a
    public boolean b() {
        InterfaceC1472a interfaceC1472a = (InterfaceC1472a) this.f13596b.get();
        return interfaceC1472a != null && interfaceC1472a.b();
    }

    @Override // e3.InterfaceC1472a
    public boolean c(String str) {
        InterfaceC1472a interfaceC1472a = (InterfaceC1472a) this.f13596b.get();
        return interfaceC1472a != null && interfaceC1472a.c(str);
    }

    @Override // e3.InterfaceC1472a
    public void d(final String str, final String str2, final long j7, final AbstractC2075G abstractC2075G) {
        C1478g.f().i("Deferring native open session: " + str);
        this.f13595a.a(new a.InterfaceC0058a() { // from class: e3.c
            @Override // N3.a.InterfaceC0058a
            public final void a(N3.b bVar) {
                C1475d.h(str, str2, j7, abstractC2075G, bVar);
            }
        });
    }

    public final /* synthetic */ void g(N3.b bVar) {
        C1478g.f().b("Crashlytics native component now available.");
        this.f13596b.set((InterfaceC1472a) bVar.get());
    }
}
