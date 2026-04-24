package r5;

import r5.C2587c;

/* JADX INFO: renamed from: r5.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2595k extends o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2587c.C0351c f22695a = C2587c.C0351c.b("io.grpc.ClientStreamTracer.NAME_RESOLUTION_DELAYED");

    /* JADX INFO: renamed from: r5.k$a */
    public static abstract class a {
        public abstract AbstractC2595k a(b bVar, Z z7);
    }

    /* JADX INFO: renamed from: r5.k$b */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C2587c f22696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f22697b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f22698c;

        /* JADX INFO: renamed from: r5.k$b$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public C2587c f22699a = C2587c.f22630k;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f22700b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f22701c;

            public b a() {
                return new b(this.f22699a, this.f22700b, this.f22701c);
            }

            public a b(C2587c c2587c) {
                this.f22699a = (C2587c) H2.m.o(c2587c, "callOptions cannot be null");
                return this;
            }

            public a c(boolean z7) {
                this.f22701c = z7;
                return this;
            }

            public a d(int i7) {
                this.f22700b = i7;
                return this;
            }
        }

        public b(C2587c c2587c, int i7, boolean z7) {
            this.f22696a = (C2587c) H2.m.o(c2587c, "callOptions");
            this.f22697b = i7;
            this.f22698c = z7;
        }

        public static a a() {
            return new a();
        }

        public String toString() {
            return H2.g.b(this).d("callOptions", this.f22696a).b("previousAttempts", this.f22697b).e("isTransparentRetry", this.f22698c).toString();
        }
    }

    public void j() {
    }

    public void k() {
    }

    public void m() {
    }

    public void l(Z z7) {
    }

    public void n(C2585a c2585a, Z z7) {
    }
}
