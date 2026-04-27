package I6;

import R5.InterfaceC0851h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: I6.n0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0633n0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f4445e = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0633n0 f4446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final R5.l0 f4447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f4448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f4449d;

    /* JADX INFO: renamed from: I6.n0$a */
    public static final class a {
        public a() {
        }

        public final C0633n0 a(C0633n0 c0633n0, R5.l0 typeAliasDescriptor, List arguments) {
            AbstractC2304t.f(typeAliasDescriptor, "typeAliasDescriptor");
            AbstractC2304t.f(arguments, "arguments");
            List parameters = typeAliasDescriptor.l().getParameters();
            AbstractC2304t.e(parameters, "getParameters(...)");
            ArrayList arrayList = new ArrayList(p5.r.s(parameters, 10));
            Iterator it = parameters.iterator();
            while (it.hasNext()) {
                arrayList.add(((R5.m0) it.next()).a());
            }
            return new C0633n0(c0633n0, typeAliasDescriptor, arguments, p5.M.u(p5.z.O0(arrayList, arguments)), null);
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public C0633n0(C0633n0 c0633n0, R5.l0 l0Var, List list, Map map) {
        this.f4446a = c0633n0;
        this.f4447b = l0Var;
        this.f4448c = list;
        this.f4449d = map;
    }

    public final List a() {
        return this.f4448c;
    }

    public final R5.l0 b() {
        return this.f4447b;
    }

    public final B0 c(v0 constructor) {
        AbstractC2304t.f(constructor, "constructor");
        InterfaceC0851h interfaceC0851hS = constructor.s();
        if (interfaceC0851hS instanceof R5.m0) {
            return (B0) this.f4449d.get(interfaceC0851hS);
        }
        return null;
    }

    public final boolean d(R5.l0 descriptor) {
        AbstractC2304t.f(descriptor, "descriptor");
        if (!AbstractC2304t.b(this.f4447b, descriptor)) {
            C0633n0 c0633n0 = this.f4446a;
            if (!(c0633n0 != null ? c0633n0.d(descriptor) : false)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ C0633n0(C0633n0 c0633n0, R5.l0 l0Var, List list, Map map, AbstractC2296k abstractC2296k) {
        this(c0633n0, l0Var, list, map);
    }
}
