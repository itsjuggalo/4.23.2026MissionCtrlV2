package lf;

import fe.h0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xf.c1;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f15656a = new i();

    public static final r0 d(ce.l lVar, h0 it) {
        kotlin.jvm.internal.t.f(it, "it");
        c1 c1VarP = it.p().P(lVar);
        kotlin.jvm.internal.t.e(c1VarP, "getPrimitiveArrayKotlinType(...)");
        return c1VarP;
    }

    public static /* synthetic */ g f(i iVar, Object obj, h0 h0Var, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            h0Var = null;
        }
        return iVar.e(obj, h0Var);
    }

    public final b b(List list, h0 h0Var, ce.l lVar) {
        List listI0 = dd.a0.I0(list);
        ArrayList arrayList = new ArrayList();
        Iterator it = listI0.iterator();
        while (it.hasNext()) {
            g gVarF = f(this, it.next(), null, 2, null);
            if (gVarF != null) {
                arrayList.add(gVarF);
            }
        }
        if (h0Var == null) {
            return new b(arrayList, new h(lVar));
        }
        c1 c1VarP = h0Var.p().P(lVar);
        kotlin.jvm.internal.t.e(c1VarP, "getPrimitiveArrayKotlinType(...)");
        return new z(arrayList, c1VarP);
    }

    public final b c(List value, r0 type) {
        kotlin.jvm.internal.t.f(value, "value");
        kotlin.jvm.internal.t.f(type, "type");
        return new z(value, type);
    }

    public final g e(Object obj, h0 h0Var) {
        if (obj instanceof Byte) {
            return new d(((Number) obj).byteValue());
        }
        if (obj instanceof Short) {
            return new w(((Number) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return new n(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return new t(((Number) obj).longValue());
        }
        if (obj instanceof Character) {
            return new e(((Character) obj).charValue());
        }
        if (obj instanceof Float) {
            return new m(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new j(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return new c(((Boolean) obj).booleanValue());
        }
        if (obj instanceof String) {
            return new x((String) obj);
        }
        if (obj instanceof byte[]) {
            return b(dd.n.t0((byte[]) obj), h0Var, ce.l.f3921i);
        }
        if (obj instanceof short[]) {
            return b(dd.n.A0((short[]) obj), h0Var, ce.l.f3922j);
        }
        if (obj instanceof int[]) {
            return b(dd.n.x0((int[]) obj), h0Var, ce.l.f3923k);
        }
        if (obj instanceof long[]) {
            return b(dd.n.y0((long[]) obj), h0Var, ce.l.f3925m);
        }
        if (obj instanceof char[]) {
            return b(dd.n.u0((char[]) obj), h0Var, ce.l.f3920h);
        }
        if (obj instanceof float[]) {
            return b(dd.n.w0((float[]) obj), h0Var, ce.l.f3924l);
        }
        if (obj instanceof double[]) {
            return b(dd.n.v0((double[]) obj), h0Var, ce.l.f3926n);
        }
        if (obj instanceof boolean[]) {
            return b(dd.n.B0((boolean[]) obj), h0Var, ce.l.f3919g);
        }
        if (obj == null) {
            return new u();
        }
        return null;
    }
}
