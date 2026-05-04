package qe;

import bb.d0;
import cd.q;
import ce.i;
import com.google.firebase.analytics.FirebaseAnalytics;
import dd.r;
import fe.a;
import fe.a1;
import fe.b;
import fe.e0;
import fe.g1;
import fe.j;
import fe.m;
import fe.s1;
import fe.u;
import fe.y0;
import ie.k0;
import ie.l0;
import ie.m0;
import io.flutter.Build;
import java.util.List;
import kotlin.jvm.functions.Function0;
import we.r1;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class f extends k0 implements a {
    public final boolean C;
    public final q D;
    public r0 E;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(m mVar, ge.h hVar, e0 e0Var, u uVar, boolean z10, ef.f fVar, g1 g1Var, y0 y0Var, b.a aVar, boolean z11, q qVar) {
        super(mVar, y0Var, hVar, e0Var, uVar, z10, fVar, aVar, g1Var, false, false, false, false, false, false);
        if (mVar == null) {
            w(0);
        }
        if (hVar == null) {
            w(1);
        }
        if (e0Var == null) {
            w(2);
        }
        if (uVar == null) {
            w(3);
        }
        if (fVar == null) {
            w(4);
        }
        if (g1Var == null) {
            w(5);
        }
        if (aVar == null) {
            w(6);
        }
        this.E = null;
        this.C = z11;
        this.D = qVar;
    }

    public static f f1(m mVar, ge.h hVar, e0 e0Var, u uVar, boolean z10, ef.f fVar, g1 g1Var, boolean z11) {
        if (mVar == null) {
            w(7);
        }
        if (hVar == null) {
            w(8);
        }
        if (e0Var == null) {
            w(9);
        }
        if (uVar == null) {
            w(10);
        }
        if (fVar == null) {
            w(11);
        }
        if (g1Var == null) {
            w(12);
        }
        return new f(mVar, hVar, e0Var, uVar, z10, fVar, g1Var, null, b.a.DECLARATION, z11, null);
    }

    private static /* synthetic */ void w(int i10) {
        String str = i10 != 21 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i10 != 21 ? 3 : 2];
        switch (i10) {
            case 1:
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = "name";
                break;
            case 5:
            case 12:
            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                objArr[0] = FirebaseAnalytics.Param.SOURCE;
                break;
            case 6:
            case 16:
                objArr[0] = "kind";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 14:
                objArr[0] = "newModality";
                break;
            case 15:
                objArr[0] = "newVisibility";
                break;
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                objArr[0] = "newName";
                break;
            case 19:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
            case Build.API_LEVELS.API_21 /* 21 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
                break;
            case Build.API_LEVELS.API_22 /* 22 */:
                objArr[0] = "inType";
                break;
        }
        if (i10 != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i10) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "create";
                break;
            case 13:
            case 14:
            case 15:
            case 16:
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            case Build.API_LEVELS.API_21 /* 21 */:
                break;
            case Build.API_LEVELS.API_22 /* 22 */:
                objArr[2] = "setInType";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 == 21) {
            throw new IllegalStateException(str2);
        }
    }

    @Override // ie.k0, fe.t1
    public boolean A() {
        r0 type = getType();
        if (this.C && j.a(type)) {
            return !r1.i(type) || i.w0(type);
        }
        return false;
    }

    @Override // ie.w0, fe.a
    public boolean H() {
        return false;
    }

    @Override // qe.a
    public a M(r0 r0Var, List list, r0 r0Var2, q qVar) {
        l0 l0Var;
        m0 m0Var;
        if (list == null) {
            w(19);
        }
        if (r0Var2 == null) {
            w(20);
        }
        y0 y0VarA = a() == this ? null : a();
        f fVar = new f(b(), getAnnotations(), l(), getVisibility(), i0(), getName(), j(), y0VarA, h(), this.C, qVar);
        l0 l0VarD = d();
        if (l0VarD != null) {
            l0 l0Var2 = new l0(fVar, l0VarD.getAnnotations(), l0VarD.l(), l0VarD.getVisibility(), l0VarD.W(), l0VarD.isExternal(), l0VarD.isInline(), h(), y0VarA == null ? null : y0VarA.d(), l0VarD.j());
            l0Var2.M0(l0VarD.d0());
            l0Var2.P0(r0Var2);
            l0Var = l0Var2;
        } else {
            l0Var = null;
        }
        a1 a1VarG = g();
        if (a1VarG != null) {
            m0Var = new m0(fVar, a1VarG.getAnnotations(), a1VarG.l(), a1VarG.getVisibility(), a1VarG.W(), a1VarG.isExternal(), a1VarG.isInline(), h(), y0VarA == null ? null : y0VarA.g(), a1VarG.j());
            m0Var.M0(m0Var.d0());
            m0Var.Q0((s1) a1VarG.i().get(0));
        } else {
            m0Var = null;
        }
        fVar.V0(l0Var, m0Var, o0(), l0());
        fVar.a1(W0());
        Function0 function0 = this.f12507h;
        if (function0 != null) {
            fVar.K0(this.f12506g, function0);
        }
        fVar.w0(f());
        fVar.b1(r0Var2, getTypeParameters(), e0(), r0Var != null ? jf.h.i(this, r0Var, ge.h.L.b()) : null, r.k());
        return fVar;
    }

    @Override // ie.k0
    public k0 P0(m mVar, e0 e0Var, u uVar, y0 y0Var, b.a aVar, ef.f fVar, g1 g1Var) {
        if (mVar == null) {
            w(13);
        }
        if (e0Var == null) {
            w(14);
        }
        if (uVar == null) {
            w(15);
        }
        if (aVar == null) {
            w(16);
        }
        if (fVar == null) {
            w(17);
        }
        if (g1Var == null) {
            w(18);
        }
        return new f(mVar, getAnnotations(), e0Var, uVar, i0(), fVar, g1Var, y0Var, aVar, this.C, this.D);
    }

    @Override // ie.k0
    public void Z0(r0 r0Var) {
        if (r0Var == null) {
            w(22);
        }
        this.E = r0Var;
    }

    @Override // ie.k0, fe.a
    public Object z(a.InterfaceC0175a interfaceC0175a) {
        q qVar = this.D;
        if (qVar == null || !((a.InterfaceC0175a) qVar.c()).equals(interfaceC0175a)) {
            return null;
        }
        return this.D.d();
    }
}
