package F4;

import F4.C0489c;
import v2.AbstractC2842h;
import v2.AbstractC2848n;

/* JADX INFO: renamed from: F4.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0497k extends m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0489c.C0029c f1841a = C0489c.C0029c.b("io.grpc.ClientStreamTracer.NAME_RESOLUTION_DELAYED");

    /* JADX INFO: renamed from: F4.k$a */
    public static abstract class a {
        public abstract AbstractC0497k a(b bVar, X x8);
    }

    /* JADX INFO: renamed from: F4.k$b */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0489c f1842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1843b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f1844c;

        /* JADX INFO: renamed from: F4.k$b$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public C0489c f1845a = C0489c.f1753k;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f1846b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f1847c;

            public b a() {
                return new b(this.f1845a, this.f1846b, this.f1847c);
            }

            public a b(C0489c c0489c) {
                this.f1845a = (C0489c) AbstractC2848n.o(c0489c, "callOptions cannot be null");
                return this;
            }

            public a c(boolean z7) {
                this.f1847c = z7;
                return this;
            }

            public a d(int i8) {
                this.f1846b = i8;
                return this;
            }
        }

        public b(C0489c c0489c, int i8, boolean z7) {
            this.f1842a = (C0489c) AbstractC2848n.o(c0489c, "callOptions");
            this.f1843b = i8;
            this.f1844c = z7;
        }

        public static a a() {
            return new a();
        }

        public String toString() {
            return AbstractC2842h.b(this).d("callOptions", this.f1842a).b("previousAttempts", this.f1843b).e("isTransparentRetry", this.f1844c).toString();
        }
    }

    public void j() {
    }

    public void k() {
    }

    public void m() {
    }

    public void l(X x8) {
    }

    public void n(C0487a c0487a, X x8) {
    }
}
