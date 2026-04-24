package r5;

import r5.C2585a;
import r5.S;

/* JADX INFO: loaded from: classes2.dex */
public abstract class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2585a.c f22536a = C2585a.c.a("internal:io.grpc.config-selector");

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l0 f22537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f22538b;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f22539a;

            /* JADX WARN: Multi-variable type inference failed */
            public b a() {
                H2.m.u(this.f22539a != null, "config is not set");
                return new b(l0.f22705e, this.f22539a, null);
            }

            public a b(Object obj) {
                this.f22539a = H2.m.o(obj, "config");
                return this;
            }

            public a() {
            }
        }

        public static a d() {
            return new a();
        }

        public Object a() {
            return this.f22538b;
        }

        public InterfaceC2592h b() {
            return null;
        }

        public l0 c() {
            return this.f22537a;
        }

        public b(l0 l0Var, Object obj, InterfaceC2592h interfaceC2592h) {
            this.f22537a = (l0) H2.m.o(l0Var, "status");
            this.f22538b = obj;
        }
    }

    public abstract b a(S.g gVar);
}
