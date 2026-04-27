package K2;

import K2.C0355c;

/* JADX INFO: renamed from: K2.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0363k extends o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0355c.C0031c f1205a = C0355c.C0031c.b("io.grpc.ClientStreamTracer.NAME_RESOLUTION_DELAYED");

    /* JADX INFO: renamed from: K2.k$a */
    public static abstract class a {
        public abstract AbstractC0363k a(b bVar, Z z4);
    }

    /* JADX INFO: renamed from: K2.k$b */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0355c f1206a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1207b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f1208c;

        /* JADX INFO: renamed from: K2.k$b$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public C0355c f1209a = C0355c.f1140k;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f1210b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f1211c;

            public b a() {
                return new b(this.f1209a, this.f1210b, this.f1211c);
            }

            public a b(C0355c c0355c) {
                this.f1209a = (C0355c) Z1.m.o(c0355c, "callOptions cannot be null");
                return this;
            }

            public a c(boolean z4) {
                this.f1211c = z4;
                return this;
            }

            public a d(int i4) {
                this.f1210b = i4;
                return this;
            }
        }

        public b(C0355c c0355c, int i4, boolean z4) {
            this.f1206a = (C0355c) Z1.m.o(c0355c, "callOptions");
            this.f1207b = i4;
            this.f1208c = z4;
        }

        public static a a() {
            return new a();
        }

        public String toString() {
            return Z1.g.b(this).d("callOptions", this.f1206a).b("previousAttempts", this.f1207b).e("isTransparentRetry", this.f1208c).toString();
        }
    }

    public void j() {
    }

    public void k() {
    }

    public void m() {
    }

    public void l(Z z4) {
    }

    public void n(C0353a c0353a, Z z4) {
    }
}
