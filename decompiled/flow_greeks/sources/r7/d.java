package r7;

import fa.a;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;
import x7.f0;
import x7.g0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements r7.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f19369c = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fa.a f19370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f19371b = new AtomicReference(null);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements h {
        public b() {
        }

        @Override // r7.h
        public File a() {
            return null;
        }

        @Override // r7.h
        public File b() {
            return null;
        }

        @Override // r7.h
        public File c() {
            return null;
        }

        @Override // r7.h
        public f0.a d() {
            return null;
        }

        @Override // r7.h
        public File e() {
            return null;
        }

        @Override // r7.h
        public File f() {
            return null;
        }

        @Override // r7.h
        public File g() {
            return null;
        }
    }

    public d(fa.a aVar) {
        this.f19370a = aVar;
        aVar.a(new a.InterfaceC0174a() { // from class: r7.b
            @Override // fa.a.InterfaceC0174a
            public final void a(fa.b bVar) {
                d.f(this.f19364a, bVar);
            }
        });
    }

    public static /* synthetic */ void f(d dVar, fa.b bVar) {
        dVar.getClass();
        g.f().b("Crashlytics native component now available.");
        dVar.f19371b.set((r7.a) bVar.get());
    }

    @Override // r7.a
    public h a(String str) {
        r7.a aVar = (r7.a) this.f19371b.get();
        return aVar == null ? f19369c : aVar.a(str);
    }

    @Override // r7.a
    public void b(final String str, final String str2, final long j10, final g0 g0Var) {
        g.f().i("Deferring native open session: " + str);
        this.f19370a.a(new a.InterfaceC0174a() { // from class: r7.c
            @Override // fa.a.InterfaceC0174a
            public final void a(fa.b bVar) {
                ((a) bVar.get()).b(str, str2, j10, g0Var);
            }
        });
    }

    @Override // r7.a
    public boolean c() {
        r7.a aVar = (r7.a) this.f19371b.get();
        return aVar != null && aVar.c();
    }

    @Override // r7.a
    public boolean d(String str) {
        r7.a aVar = (r7.a) this.f19371b.get();
        return aVar != null && aVar.d(str);
    }
}
