package P2;

import S3.a;
import V2.F;
import V2.G;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class d implements P2.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f6351c = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S3.a f6352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f6353b = new AtomicReference(null);

    public static final class b implements h {
        public b() {
        }

        @Override // P2.h
        public File a() {
            return null;
        }

        @Override // P2.h
        public File b() {
            return null;
        }

        @Override // P2.h
        public File c() {
            return null;
        }

        @Override // P2.h
        public F.a d() {
            return null;
        }

        @Override // P2.h
        public File e() {
            return null;
        }

        @Override // P2.h
        public File f() {
            return null;
        }

        @Override // P2.h
        public File g() {
            return null;
        }
    }

    public d(S3.a aVar) {
        this.f6352a = aVar;
        aVar.a(new a.InterfaceC0108a() { // from class: P2.b
            @Override // S3.a.InterfaceC0108a
            public final void a(S3.b bVar) {
                this.f6346a.g(bVar);
            }
        });
    }

    public static /* synthetic */ void h(String str, String str2, long j8, G g8, S3.b bVar) {
        ((P2.a) bVar.get()).c(str, str2, j8, g8);
    }

    @Override // P2.a
    public h a(String str) {
        P2.a aVar = (P2.a) this.f6353b.get();
        return aVar == null ? f6351c : aVar.a(str);
    }

    @Override // P2.a
    public boolean b() {
        P2.a aVar = (P2.a) this.f6353b.get();
        return aVar != null && aVar.b();
    }

    @Override // P2.a
    public void c(final String str, final String str2, final long j8, final G g8) {
        g.f().i("Deferring native open session: " + str);
        this.f6352a.a(new a.InterfaceC0108a() { // from class: P2.c
            @Override // S3.a.InterfaceC0108a
            public final void a(S3.b bVar) {
                d.h(str, str2, j8, g8, bVar);
            }
        });
    }

    @Override // P2.a
    public boolean d(String str) {
        P2.a aVar = (P2.a) this.f6353b.get();
        return aVar != null && aVar.d(str);
    }

    public final /* synthetic */ void g(S3.b bVar) {
        g.f().b("Crashlytics native component now available.");
        this.f6353b.set((P2.a) bVar.get());
    }
}
