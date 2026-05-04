package zd;

import java.io.IOException;
import java.util.List;
import wd.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d3 f25708a = new d3();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final hf.n f25709b = hf.n.f11354h;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25710a;

        static {
            int[] iArr = new int[l.a.values().length];
            try {
                iArr[l.a.f23903b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[l.a.f23902a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[l.a.f23904c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f25710a = iArr;
        }
    }

    public static final CharSequence g(fe.s1 s1Var) {
        d3 d3Var = f25708a;
        xf.r0 type = s1Var.getType();
        kotlin.jvm.internal.t.e(type, "getType(...)");
        return d3Var.l(type);
    }

    public static final CharSequence i(fe.s1 s1Var) {
        d3 d3Var = f25708a;
        xf.r0 type = s1Var.getType();
        kotlin.jvm.internal.t.e(type, "getType(...)");
        return d3Var.l(type);
    }

    public final void c(StringBuilder sb2, fe.b1 b1Var) {
        if (b1Var != null) {
            xf.r0 type = b1Var.getType();
            kotlin.jvm.internal.t.e(type, "getType(...)");
            sb2.append(l(type));
            sb2.append(".");
        }
    }

    public final void d(StringBuilder sb2, fe.a aVar) {
        fe.b1 b1VarI = i3.i(aVar);
        fe.b1 b1VarK0 = aVar.k0();
        c(sb2, b1VarI);
        boolean z10 = (b1VarI == null || b1VarK0 == null) ? false : true;
        if (z10) {
            sb2.append("(");
        }
        c(sb2, b1VarK0);
        if (z10) {
            sb2.append(")");
        }
    }

    public final String e(fe.a aVar) {
        if (aVar instanceof fe.y0) {
            return k((fe.y0) aVar);
        }
        if (aVar instanceof fe.z) {
            return f((fe.z) aVar);
        }
        throw new IllegalStateException(("Illegal callable: " + aVar).toString());
    }

    public final String f(fe.z descriptor) throws IOException {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("fun ");
        d3 d3Var = f25708a;
        d3Var.d(sb2, descriptor);
        hf.n nVar = f25709b;
        ef.f name = descriptor.getName();
        kotlin.jvm.internal.t.e(name, "getName(...)");
        sb2.append(nVar.R(name, true));
        List listI = descriptor.i();
        kotlin.jvm.internal.t.e(listI, "getValueParameters(...)");
        dd.a0.f0(listI, sb2, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : "(", (124 & 8) == 0 ? ")" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : b3.f25685a);
        sb2.append(": ");
        xf.r0 returnType = descriptor.getReturnType();
        kotlin.jvm.internal.t.c(returnType);
        sb2.append(d3Var.l(returnType));
        return sb2.toString();
    }

    public final String h(fe.z invoke) throws IOException {
        kotlin.jvm.internal.t.f(invoke, "invoke");
        StringBuilder sb2 = new StringBuilder();
        d3 d3Var = f25708a;
        d3Var.d(sb2, invoke);
        List listI = invoke.i();
        kotlin.jvm.internal.t.e(listI, "getValueParameters(...)");
        dd.a0.f0(listI, sb2, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : "(", (124 & 8) == 0 ? ")" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : c3.f25701a);
        sb2.append(" -> ");
        xf.r0 returnType = invoke.getReturnType();
        kotlin.jvm.internal.t.c(returnType);
        sb2.append(d3Var.l(returnType));
        return sb2.toString();
    }

    public final String j(x1 parameter) {
        kotlin.jvm.internal.t.f(parameter, "parameter");
        StringBuilder sb2 = new StringBuilder();
        int i10 = a.f25710a[parameter.h().ordinal()];
        if (i10 == 1) {
            sb2.append("extension receiver parameter");
        } else if (i10 == 2) {
            sb2.append("instance parameter");
        } else {
            if (i10 != 3) {
                throw new cd.o();
            }
            sb2.append("parameter #" + parameter.getIndex() + ' ' + parameter.getName());
        }
        sb2.append(" of ");
        sb2.append(f25708a.e(parameter.s().W()));
        return sb2.toString();
    }

    public final String k(fe.y0 descriptor) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(descriptor.i0() ? "var " : "val ");
        d3 d3Var = f25708a;
        d3Var.d(sb2, descriptor);
        hf.n nVar = f25709b;
        ef.f name = descriptor.getName();
        kotlin.jvm.internal.t.e(name, "getName(...)");
        sb2.append(nVar.R(name, true));
        sb2.append(": ");
        xf.r0 type = descriptor.getType();
        kotlin.jvm.internal.t.e(type, "getType(...)");
        sb2.append(d3Var.l(type));
        return sb2.toString();
    }

    public final String l(xf.r0 type) {
        kotlin.jvm.internal.t.f(type, "type");
        return f25709b.S(type);
    }
}
