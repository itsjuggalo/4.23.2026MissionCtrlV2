package rb;

import rb.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k extends n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c.C0344c f19580a = c.C0344c.b("io.grpc.ClientStreamTracer.NAME_RESOLUTION_DELAYED");

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class a {
        public abstract k a(b bVar, y0 y0Var);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f19581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f19582b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f19583c;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public c f19584a = c.f19494k;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f19585b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f19586c;

            public b a() {
                return new b(this.f19584a, this.f19585b, this.f19586c);
            }

            public a b(c cVar) {
                this.f19584a = (c) p6.n.o(cVar, "callOptions cannot be null");
                return this;
            }

            public a c(boolean z10) {
                this.f19586c = z10;
                return this;
            }

            public a d(int i10) {
                this.f19585b = i10;
                return this;
            }
        }

        public b(c cVar, int i10, boolean z10) {
            this.f19581a = (c) p6.n.o(cVar, "callOptions");
            this.f19582b = i10;
            this.f19583c = z10;
        }

        public static a a() {
            return new a();
        }

        public String toString() {
            return p6.h.b(this).d("callOptions", this.f19581a).b("previousAttempts", this.f19582b).e("isTransparentRetry", this.f19583c).toString();
        }
    }

    public void j() {
    }

    public void k() {
    }

    public void m() {
    }

    public void l(y0 y0Var) {
    }

    public void n(rb.a aVar, y0 y0Var) {
    }
}
