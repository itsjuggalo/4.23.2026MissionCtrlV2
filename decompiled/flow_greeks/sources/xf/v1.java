package xf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class v1 extends d2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f25085c = new a(null);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: xf.v1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0461a extends v1 {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Map f25086d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ boolean f25087e;

            public C0461a(Map map, boolean z10) {
                this.f25086d = map;
                this.f25087e = z10;
            }

            @Override // xf.d2
            public boolean a() {
                return this.f25087e;
            }

            @Override // xf.d2
            public boolean f() {
                return this.f25086d.isEmpty();
            }

            @Override // xf.v1
            public a2 k(u1 key) {
                kotlin.jvm.internal.t.f(key, "key");
                return (a2) this.f25086d.get(key);
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public static /* synthetic */ v1 e(a aVar, Map map, boolean z10, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            return aVar.d(map, z10);
        }

        public final d2 a(r0 kotlinType) {
            kotlin.jvm.internal.t.f(kotlinType, "kotlinType");
            return b(kotlinType.N0(), kotlinType.L0());
        }

        public final d2 b(u1 typeConstructor, List arguments) {
            kotlin.jvm.internal.t.f(typeConstructor, "typeConstructor");
            kotlin.jvm.internal.t.f(arguments, "arguments");
            List parameters = typeConstructor.getParameters();
            kotlin.jvm.internal.t.e(parameters, "getParameters(...)");
            fe.l1 l1Var = (fe.l1) dd.a0.m0(parameters);
            if (l1Var == null || !l1Var.m0()) {
                return new m0(parameters, arguments);
            }
            List parameters2 = typeConstructor.getParameters();
            kotlin.jvm.internal.t.e(parameters2, "getParameters(...)");
            ArrayList arrayList = new ArrayList(dd.s.u(parameters2, 10));
            Iterator it = parameters2.iterator();
            while (it.hasNext()) {
                arrayList.add(((fe.l1) it.next()).k());
            }
            return e(this, dd.o0.t(dd.a0.S0(arrayList, arguments)), false, 2, null);
        }

        public final v1 c(Map map) {
            kotlin.jvm.internal.t.f(map, "map");
            return e(this, map, false, 2, null);
        }

        public final v1 d(Map map, boolean z10) {
            kotlin.jvm.internal.t.f(map, "map");
            return new C0461a(map, z10);
        }

        public a() {
        }
    }

    public static final d2 i(u1 u1Var, List list) {
        return f25085c.b(u1Var, list);
    }

    public static final v1 j(Map map) {
        return f25085c.c(map);
    }

    @Override // xf.d2
    public a2 e(r0 key) {
        kotlin.jvm.internal.t.f(key, "key");
        return k(key.N0());
    }

    public abstract a2 k(u1 u1Var);
}
