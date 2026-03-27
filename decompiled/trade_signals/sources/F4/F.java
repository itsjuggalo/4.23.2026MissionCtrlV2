package F4;

import F4.C0487a;
import F4.P;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes.dex */
public abstract class F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0487a.c f1633a = C0487a.c.a("internal:io.grpc.config-selector");

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j0 f1634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f1635b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public InterfaceC0494h f1636c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f1637a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public InterfaceC0494h f1638b;

            public a() {
            }

            public b a() {
                AbstractC2848n.u(this.f1637a != null, "config is not set");
                return new b(j0.f1797e, this.f1637a, this.f1638b);
            }

            public a b(Object obj) {
                this.f1637a = AbstractC2848n.o(obj, "config");
                return this;
            }
        }

        public b(j0 j0Var, Object obj, InterfaceC0494h interfaceC0494h) {
            this.f1634a = (j0) AbstractC2848n.o(j0Var, "status");
            this.f1635b = obj;
            this.f1636c = interfaceC0494h;
        }

        public static a d() {
            return new a();
        }

        public Object a() {
            return this.f1635b;
        }

        public InterfaceC0494h b() {
            return this.f1636c;
        }

        public j0 c() {
            return this.f1634a;
        }
    }

    public abstract b a(P.g gVar);
}
