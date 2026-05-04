package oe;

import fe.b;
import fe.y0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class o {
    public static /* synthetic */ void a(int i10) {
        Object[] objArr = new Object[3];
        if (i10 == 1 || i10 == 2) {
            objArr[0] = "companionObject";
        } else if (i10 != 3) {
            objArr[0] = "propertyDescriptor";
        } else {
            objArr[0] = "memberDescriptor";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/DescriptorsJvmAbiUtil";
        if (i10 == 1) {
            objArr[2] = "isClassCompanionObjectWithBackingFieldsInOuter";
        } else if (i10 == 2) {
            objArr[2] = "isMappedIntrinsicCompanionObject";
        } else if (i10 != 3) {
            objArr[2] = "isPropertyWithBackingFieldInOuterClass";
        } else {
            objArr[2] = "hasJvmFieldAnnotation";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static boolean b(fe.b bVar) {
        fe.w wVarO0;
        if (bVar == null) {
            a(3);
        }
        if ((bVar instanceof y0) && (wVarO0 = ((y0) bVar).o0()) != null && wVarO0.getAnnotations().E(h0.f17976b)) {
            return true;
        }
        return bVar.getAnnotations().E(h0.f17976b);
    }

    public static boolean c(fe.m mVar) {
        if (mVar == null) {
            a(1);
        }
        return jf.i.x(mVar) && jf.i.w(mVar.b()) && !d((fe.e) mVar);
    }

    public static boolean d(fe.e eVar) {
        if (eVar == null) {
            a(2);
        }
        return ce.e.a(ce.d.f3895a, eVar);
    }

    public static boolean e(y0 y0Var) {
        if (y0Var == null) {
            a(0);
        }
        if (y0Var.h() == b.a.FAKE_OVERRIDE) {
            return false;
        }
        if (c(y0Var.b())) {
            return true;
        }
        return jf.i.x(y0Var.b()) && b(y0Var);
    }
}
