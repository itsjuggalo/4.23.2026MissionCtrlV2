package xd;

import bg.m;
import cd.o;
import dd.r;
import dd.s;
import fe.h;
import fe.l1;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import wd.f;
import wd.q;
import wd.t;
import xf.c1;
import xf.c2;
import xf.j1;
import xf.m2;
import xf.q1;
import xf.r0;
import xf.u0;
import xf.u1;
import zd.t2;
import zd.x0;
import zd.x2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24812a;

        static {
            int[] iArr = new int[t.values().length];
            try {
                iArr[t.f23912a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[t.f23913b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[t.f23914c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f24812a = iArr;
        }
    }

    public static final c1 a(q1 q1Var, u1 u1Var, List list, boolean z10) {
        m j1Var;
        List parameters = u1Var.getParameters();
        kotlin.jvm.internal.t.e(parameters, "getParameters(...)");
        ArrayList arrayList = new ArrayList(s.u(list, 10));
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                r.t();
            }
            wd.s sVar = (wd.s) obj;
            t2 t2Var = (t2) sVar.c();
            r0 r0VarX = t2Var != null ? t2Var.x() : null;
            t tVarD = sVar.d();
            int i12 = tVarD == null ? -1 : a.f24812a[tVarD.ordinal()];
            if (i12 == -1) {
                Object obj2 = parameters.get(i10);
                kotlin.jvm.internal.t.e(obj2, "get(...)");
                j1Var = new j1((l1) obj2);
            } else if (i12 == 1) {
                m2 m2Var = m2.f25015e;
                kotlin.jvm.internal.t.c(r0VarX);
                j1Var = new c2(m2Var, r0VarX);
            } else if (i12 == 2) {
                m2 m2Var2 = m2.f25016f;
                kotlin.jvm.internal.t.c(r0VarX);
                j1Var = new c2(m2Var2, r0VarX);
            } else {
                if (i12 != 3) {
                    throw new o();
                }
                m2 m2Var3 = m2.f25017g;
                kotlin.jvm.internal.t.c(r0VarX);
                j1Var = new c2(m2Var3, r0VarX);
            }
            arrayList.add(j1Var);
            i10 = i11;
        }
        return u0.k(q1Var, u1Var, arrayList, z10, null, 16, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final q b(f fVar, List arguments, boolean z10, List annotations) {
        h descriptor;
        kotlin.jvm.internal.t.f(fVar, "<this>");
        kotlin.jvm.internal.t.f(arguments, "arguments");
        kotlin.jvm.internal.t.f(annotations, "annotations");
        Function0 function0 = null;
        Object[] objArr = 0;
        x0 x0Var = fVar instanceof x0 ? (x0) fVar : null;
        if (x0Var == null || (descriptor = x0Var.getDescriptor()) == null) {
            throw new x2("Cannot create type for an unsupported classifier: " + fVar + " (" + fVar.getClass() + ')');
        }
        u1 u1VarK = descriptor.k();
        kotlin.jvm.internal.t.e(u1VarK, "getTypeConstructor(...)");
        List parameters = u1VarK.getParameters();
        kotlin.jvm.internal.t.e(parameters, "getParameters(...)");
        if (parameters.size() == arguments.size()) {
            return new t2(a(annotations.isEmpty() ? q1.f25042b.k() : q1.f25042b.k(), u1VarK, arguments, z10), function0, 2, objArr == true ? 1 : 0);
        }
        throw new IllegalArgumentException("Class declares " + parameters.size() + " type parameters, but " + arguments.size() + " were provided.");
    }
}
