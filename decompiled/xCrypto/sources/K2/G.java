package K2;

import K2.C0353a;
import K2.S;

/* JADX INFO: loaded from: classes3.dex */
public abstract class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0353a.c f1046a = C0353a.c.a("internal:io.grpc.config-selector");

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l0 f1047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f1048b;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f1049a;

            /* JADX WARN: Multi-variable type inference failed */
            public b a() {
                Z1.m.u(this.f1049a != null, "config is not set");
                return new b(l0.f1215e, this.f1049a, null);
            }

            public a b(Object obj) {
                this.f1049a = Z1.m.o(obj, "config");
                return this;
            }

            public a() {
            }
        }

        public static a d() {
            return new a();
        }

        public Object a() {
            return this.f1048b;
        }

        public InterfaceC0360h b() {
            return null;
        }

        public l0 c() {
            return this.f1047a;
        }

        public b(l0 l0Var, Object obj, InterfaceC0360h interfaceC0360h) {
            this.f1047a = (l0) Z1.m.o(l0Var, "status");
            this.f1048b = obj;
        }
    }

    public abstract b a(S.g gVar);
}
