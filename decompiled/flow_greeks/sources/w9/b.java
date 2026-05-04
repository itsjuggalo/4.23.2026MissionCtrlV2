package w9;

import android.app.Application;
import java.util.Map;
import u9.g;
import u9.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: w9.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0415b implements w9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0415b f23748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public t9.e f23749b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public t9.e f23750c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public t9.e f23751d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public t9.e f23752e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public t9.e f23753f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public t9.e f23754g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public t9.e f23755h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public t9.e f23756i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public t9.e f23757j;

        /* JADX INFO: renamed from: w9.b$b$a */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a implements t9.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final f f23758a;

            public a(f fVar) {
                this.f23758a = fVar;
            }

            @Override // bd.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public g get() {
                return (g) t9.d.c(this.f23758a.a());
            }
        }

        /* JADX INFO: renamed from: w9.b$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0416b implements t9.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final f f23759a;

            public C0416b(f fVar) {
                this.f23759a = fVar;
            }

            @Override // bd.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public u9.a get() {
                return (u9.a) t9.d.c(this.f23759a.d());
            }
        }

        /* JADX INFO: renamed from: w9.b$b$c */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class c implements t9.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final f f23760a;

            public c(f fVar) {
                this.f23760a = fVar;
            }

            @Override // bd.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map get() {
                return (Map) t9.d.c(this.f23760a.c());
            }
        }

        /* JADX INFO: renamed from: w9.b$b$d */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class d implements t9.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final f f23761a;

            public d(f fVar) {
                this.f23761a = fVar;
            }

            @Override // bd.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Application get() {
                return (Application) t9.d.c(this.f23761a.b());
            }
        }

        @Override // w9.a
        public s9.b a() {
            return (s9.b) this.f23757j.get();
        }

        public final void b(x9.e eVar, x9.c cVar, f fVar) {
            this.f23749b = t9.b.a(x9.f.a(eVar));
            this.f23750c = new c(fVar);
            d dVar = new d(fVar);
            this.f23751d = dVar;
            t9.e eVarA = t9.b.a(x9.d.a(cVar, dVar));
            this.f23752e = eVarA;
            this.f23753f = t9.b.a(u9.f.a(eVarA));
            this.f23754g = new a(fVar);
            this.f23755h = new C0416b(fVar);
            this.f23756i = t9.b.a(u9.d.a());
            this.f23757j = t9.b.a(s9.d.a(this.f23749b, this.f23750c, this.f23753f, n.a(), n.a(), this.f23754g, this.f23751d, this.f23755h, this.f23756i));
        }

        public C0415b(x9.e eVar, x9.c cVar, f fVar) {
            this.f23748a = this;
            b(eVar, cVar, fVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public x9.e f23762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public x9.c f23763b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public f f23764c;

        public w9.a a() {
            t9.d.a(this.f23762a, x9.e.class);
            if (this.f23763b == null) {
                this.f23763b = new x9.c();
            }
            t9.d.a(this.f23764c, f.class);
            return new C0415b(this.f23762a, this.f23763b, this.f23764c);
        }

        public c b(x9.e eVar) {
            this.f23762a = (x9.e) t9.d.b(eVar);
            return this;
        }

        public c c(f fVar) {
            this.f23764c = (f) t9.d.b(fVar);
            return this;
        }

        public c() {
        }
    }

    public static c a() {
        return new c();
    }
}
