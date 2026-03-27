package L5;

import I5.l;
import R5.InterfaceC0844a;
import R5.InterfaceC0868z;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2487o;

/* JADX INFO: loaded from: classes2.dex */
public final class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e1 f5164a = new e1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t6.n f5165b = t6.n.f23386h;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5166a;

        static {
            int[] iArr = new int[l.a.values().length];
            try {
                iArr[l.a.f4292b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[l.a.f4291a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[l.a.f4293c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f5166a = iArr;
        }
    }

    public static final CharSequence g(R5.t0 t0Var) {
        e1 e1Var = f5164a;
        I6.S type = t0Var.getType();
        AbstractC2304t.e(type, "getType(...)");
        return e1Var.l(type);
    }

    public static final CharSequence i(R5.t0 t0Var) {
        e1 e1Var = f5164a;
        I6.S type = t0Var.getType();
        AbstractC2304t.e(type, "getType(...)");
        return e1Var.l(type);
    }

    public final void c(StringBuilder sb, R5.c0 c0Var) {
        if (c0Var != null) {
            I6.S type = c0Var.getType();
            AbstractC2304t.e(type, "getType(...)");
            sb.append(l(type));
            sb.append(".");
        }
    }

    public final void d(StringBuilder sb, InterfaceC0844a interfaceC0844a) {
        R5.c0 c0VarI = j1.i(interfaceC0844a);
        R5.c0 c0VarL0 = interfaceC0844a.l0();
        c(sb, c0VarI);
        boolean z7 = (c0VarI == null || c0VarL0 == null) ? false : true;
        if (z7) {
            sb.append("(");
        }
        c(sb, c0VarL0);
        if (z7) {
            sb.append(")");
        }
    }

    public final String e(InterfaceC0844a interfaceC0844a) {
        if (interfaceC0844a instanceof R5.Z) {
            return k((R5.Z) interfaceC0844a);
        }
        if (interfaceC0844a instanceof InterfaceC0868z) {
            return f((InterfaceC0868z) interfaceC0844a);
        }
        throw new IllegalStateException(("Illegal callable: " + interfaceC0844a).toString());
    }

    public final String f(InterfaceC0868z descriptor) throws IOException {
        AbstractC2304t.f(descriptor, "descriptor");
        StringBuilder sb = new StringBuilder();
        sb.append("fun ");
        e1 e1Var = f5164a;
        e1Var.d(sb, descriptor);
        t6.n nVar = f5165b;
        q6.f name = descriptor.getName();
        AbstractC2304t.e(name, "getName(...)");
        sb.append(nVar.R(name, true));
        List listK = descriptor.k();
        AbstractC2304t.e(listK, "getValueParameters(...)");
        p5.z.e0(listK, sb, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : "(", (124 & 8) == 0 ? ")" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : c1.f5147a);
        sb.append(": ");
        I6.S returnType = descriptor.getReturnType();
        AbstractC2304t.c(returnType);
        sb.append(e1Var.l(returnType));
        return sb.toString();
    }

    public final String h(InterfaceC0868z invoke) throws IOException {
        AbstractC2304t.f(invoke, "invoke");
        StringBuilder sb = new StringBuilder();
        e1 e1Var = f5164a;
        e1Var.d(sb, invoke);
        List listK = invoke.k();
        AbstractC2304t.e(listK, "getValueParameters(...)");
        p5.z.e0(listK, sb, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : "(", (124 & 8) == 0 ? ")" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : d1.f5161a);
        sb.append(" -> ");
        I6.S returnType = invoke.getReturnType();
        AbstractC2304t.c(returnType);
        sb.append(e1Var.l(returnType));
        return sb.toString();
    }

    public final String j(C0695y0 parameter) {
        String str;
        AbstractC2304t.f(parameter, "parameter");
        StringBuilder sb = new StringBuilder();
        int i8 = a.f5166a[parameter.i().ordinal()];
        if (i8 == 1) {
            str = "extension receiver parameter";
        } else if (i8 == 2) {
            str = "instance parameter";
        } else {
            if (i8 != 3) {
                throw new C2487o();
            }
            str = "parameter #" + parameter.g() + ' ' + parameter.getName();
        }
        sb.append(str);
        sb.append(" of ");
        sb.append(f5164a.e(parameter.t().X()));
        return sb.toString();
    }

    public final String k(R5.Z descriptor) {
        AbstractC2304t.f(descriptor, "descriptor");
        StringBuilder sb = new StringBuilder();
        sb.append(descriptor.j0() ? "var " : "val ");
        e1 e1Var = f5164a;
        e1Var.d(sb, descriptor);
        t6.n nVar = f5165b;
        q6.f name = descriptor.getName();
        AbstractC2304t.e(name, "getName(...)");
        sb.append(nVar.R(name, true));
        sb.append(": ");
        I6.S type = descriptor.getType();
        AbstractC2304t.e(type, "getType(...)");
        sb.append(e1Var.l(type));
        return sb.toString();
    }

    public final String l(I6.S type) {
        AbstractC2304t.f(type, "type");
        return f5165b.S(type);
    }
}
