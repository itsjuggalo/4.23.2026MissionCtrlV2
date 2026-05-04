package rb;

import rb.a;
import rb.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a.c f19566a = a.c.a("internal:io.grpc.config-selector");

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k1 f19567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f19568b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public h f19569c;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f19570a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public h f19571b;

            public b a() {
                p6.n.u(this.f19570a != null, "config is not set");
                return new b(k1.f19592e, this.f19570a, this.f19571b);
            }

            public a b(Object obj) {
                this.f19570a = p6.n.o(obj, "config");
                return this;
            }

            public a() {
            }
        }

        public static a d() {
            return new a();
        }

        public Object a() {
            return this.f19568b;
        }

        public h b() {
            return this.f19569c;
        }

        public k1 c() {
            return this.f19567a;
        }

        public b(k1 k1Var, Object obj, h hVar) {
            this.f19567a = (k1) p6.n.o(k1Var, "status");
            this.f19568b = obj;
            this.f19569c = hVar;
        }
    }

    public abstract b a(r0.g gVar);
}
