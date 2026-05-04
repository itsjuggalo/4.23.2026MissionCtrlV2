package zd;

import ae.i;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import zd.j2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class o2 {
    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final ae.h b(zd.j2.a r7, boolean r8) {
        /*
            Method dump skipped, instruction units count: 587
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: zd.o2.b(zd.j2$a, boolean):ae.h");
    }

    public static final ae.i c(j2.a aVar, boolean z10, Field field) {
        return (g(aVar.o().W()) || !Modifier.isStatic(field.getModifiers())) ? z10 ? aVar.U() ? new i.f.a(field, f(aVar)) : new i.f.c(field) : aVar.U() ? new i.g.a(field, e(aVar), f(aVar)) : new i.g.c(field, e(aVar)) : d(aVar) ? z10 ? aVar.U() ? new i.f.b(field) : new i.f.d(field) : aVar.U() ? new i.g.b(field, e(aVar)) : new i.g.d(field, e(aVar)) : z10 ? new i.f.e(field) : new i.g.e(field, e(aVar));
    }

    public static final boolean d(j2.a aVar) {
        return aVar.o().W().getAnnotations().E(i3.j());
    }

    public static final boolean e(j2.a aVar) {
        return !xf.i2.l(aVar.o().W().getType());
    }

    public static final Object f(j2.a aVar) {
        kotlin.jvm.internal.t.f(aVar, "<this>");
        return aVar.o().b0();
    }

    public static final boolean g(fe.y0 y0Var) {
        fe.m mVarB = y0Var.b();
        kotlin.jvm.internal.t.e(mVarB, "getContainingDeclaration(...)");
        if (!jf.i.x(mVarB)) {
            return false;
        }
        fe.m mVarB2 = mVarB.b();
        if (jf.i.C(mVarB2) || jf.i.t(mVarB2)) {
            return (y0Var instanceof vf.n0) && df.i.f(((vf.n0) y0Var).F());
        }
        return true;
    }
}
