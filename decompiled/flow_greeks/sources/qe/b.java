package qe;

import bb.d0;
import cd.q;
import com.google.firebase.analytics.FirebaseAnalytics;
import dd.r;
import fe.a;
import fe.b;
import fe.g1;
import fe.m;
import fe.z;
import ie.i;
import java.util.List;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class b extends i implements a {
    public Boolean F;
    public Boolean G;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(fe.e eVar, b bVar, ge.h hVar, boolean z10, b.a aVar, g1 g1Var) {
        super(eVar, bVar, hVar, z10, aVar, g1Var);
        if (eVar == null) {
            w(0);
        }
        if (hVar == null) {
            w(1);
        }
        if (aVar == null) {
            w(2);
        }
        if (g1Var == null) {
            w(3);
        }
        this.F = null;
        this.G = null;
    }

    public static b t1(fe.e eVar, ge.h hVar, boolean z10, g1 g1Var) {
        if (eVar == null) {
            w(4);
        }
        if (hVar == null) {
            w(5);
        }
        if (g1Var == null) {
            w(6);
        }
        return new b(eVar, null, hVar, z10, b.a.DECLARATION, g1Var);
    }

    private static /* synthetic */ void w(int i10) {
        String str = (i10 == 11 || i10 == 18) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 11 || i10 == 18) ? 2 : 3];
        switch (i10) {
            case 1:
            case 5:
            case 9:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 13:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 10:
                objArr[0] = FirebaseAnalytics.Param.SOURCE;
                break;
            case 4:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 7:
            case 12:
                objArr[0] = "newOwner";
                break;
            case 11:
            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
                break;
            case 14:
                objArr[0] = "sourceElement";
                break;
            case 16:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i10 == 11) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i10 != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "createJavaConstructor";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 11:
            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                break;
            case 12:
            case 13:
            case 14:
            case 15:
                objArr[2] = "createDescriptor";
                break;
            case 16:
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 11 && i10 != 18) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // ie.s, fe.a
    public boolean H() {
        return this.G.booleanValue();
    }

    @Override // ie.s
    public boolean Q0() {
        return this.F.booleanValue();
    }

    @Override // ie.s
    public void Y0(boolean z10) {
        this.F = Boolean.valueOf(z10);
    }

    @Override // ie.s
    public void Z0(boolean z10) {
        this.G = Boolean.valueOf(z10);
    }

    public b s1(fe.e eVar, b bVar, b.a aVar, g1 g1Var, ge.h hVar) {
        if (eVar == null) {
            w(12);
        }
        if (aVar == null) {
            w(13);
        }
        if (g1Var == null) {
            w(14);
        }
        if (hVar == null) {
            w(15);
        }
        return new b(eVar, bVar, hVar, this.E, aVar, g1Var);
    }

    @Override // ie.i
    /* JADX INFO: renamed from: u1, reason: merged with bridge method [inline-methods] */
    public b L0(m mVar, z zVar, b.a aVar, ef.f fVar, ge.h hVar, g1 g1Var) {
        if (mVar == null) {
            w(7);
        }
        if (aVar == null) {
            w(8);
        }
        if (hVar == null) {
            w(9);
        }
        if (g1Var == null) {
            w(10);
        }
        if (aVar == b.a.DECLARATION || aVar == b.a.SYNTHESIZED) {
            b bVarS1 = s1((fe.e) mVar, (b) zVar, aVar, g1Var, hVar);
            bVarS1.Y0(Q0());
            bVarS1.Z0(H());
            return bVarS1;
        }
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + mVar + "\nkind: " + aVar);
    }

    @Override // qe.a
    /* JADX INFO: renamed from: v1, reason: merged with bridge method [inline-methods] */
    public b M(r0 r0Var, List list, r0 r0Var2, q qVar) {
        if (list == null) {
            w(16);
        }
        if (r0Var2 == null) {
            w(17);
        }
        b bVarL0 = L0(b(), null, h(), null, getAnnotations(), j());
        bVarL0.R0(r0Var == null ? null : jf.h.i(bVarL0, r0Var, ge.h.L.b()), e0(), r.k(), getTypeParameters(), h.a(list, i(), bVarL0), r0Var2, l(), getVisibility());
        if (qVar != null) {
            bVarL0.U0((a.InterfaceC0175a) qVar.c(), qVar.d());
        }
        return bVarL0;
    }
}
