package xf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class m1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f25010e = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m1 f25011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fe.k1 f25012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f25013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f25014d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final m1 a(m1 m1Var, fe.k1 typeAliasDescriptor, List arguments) {
            kotlin.jvm.internal.t.f(typeAliasDescriptor, "typeAliasDescriptor");
            kotlin.jvm.internal.t.f(arguments, "arguments");
            List parameters = typeAliasDescriptor.k().getParameters();
            kotlin.jvm.internal.t.e(parameters, "getParameters(...)");
            ArrayList arrayList = new ArrayList(dd.s.u(parameters, 10));
            Iterator it = parameters.iterator();
            while (it.hasNext()) {
                arrayList.add(((fe.l1) it.next()).a());
            }
            return new m1(m1Var, typeAliasDescriptor, arguments, dd.o0.t(dd.a0.S0(arrayList, arguments)), null);
        }

        public a() {
        }
    }

    public /* synthetic */ m1(m1 m1Var, fe.k1 k1Var, List list, Map map, kotlin.jvm.internal.k kVar) {
        this(m1Var, k1Var, list, map);
    }

    public final List a() {
        return this.f25013c;
    }

    public final fe.k1 b() {
        return this.f25012b;
    }

    public final a2 c(u1 constructor) {
        kotlin.jvm.internal.t.f(constructor, "constructor");
        fe.h hVarB = constructor.b();
        if (hVarB instanceof fe.l1) {
            return (a2) this.f25014d.get(hVarB);
        }
        return null;
    }

    public final boolean d(fe.k1 descriptor) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        if (kotlin.jvm.internal.t.b(this.f25012b, descriptor)) {
            return true;
        }
        m1 m1Var = this.f25011a;
        return m1Var != null ? m1Var.d(descriptor) : false;
    }

    public m1(m1 m1Var, fe.k1 k1Var, List list, Map map) {
        this.f25011a = m1Var;
        this.f25012b = k1Var;
        this.f25013c = list;
        this.f25014d = map;
    }
}
