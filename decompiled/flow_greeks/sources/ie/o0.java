package ie;

import com.google.firebase.analytics.FirebaseAnalytics;
import fe.b;
import fe.b1;
import fe.f1;
import fe.g1;
import fe.z;
import io.flutter.Build;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class o0 extends s implements f1 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(fe.m mVar, f1 f1Var, ge.h hVar, ef.f fVar, b.a aVar, g1 g1Var) {
        super(mVar, f1Var, hVar, fVar, aVar, g1Var);
        if (mVar == null) {
            w(0);
        }
        if (hVar == null) {
            w(1);
        }
        if (fVar == null) {
            w(2);
        }
        if (aVar == null) {
            w(3);
        }
        if (g1Var == null) {
            w(4);
        }
    }

    public static o0 l1(fe.m mVar, ge.h hVar, ef.f fVar, b.a aVar, g1 g1Var) {
        if (mVar == null) {
            w(5);
        }
        if (hVar == null) {
            w(6);
        }
        if (fVar == null) {
            w(7);
        }
        if (aVar == null) {
            w(8);
        }
        if (g1Var == null) {
            w(9);
        }
        return new o0(mVar, null, hVar, fVar, aVar, g1Var);
    }

    private static /* synthetic */ void w(int i10) {
        String str = (i10 == 13 || i10 == 18 || i10 == 23 || i10 == 24 || i10 == 29 || i10 == 30) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 13 || i10 == 18 || i10 == 23 || i10 == 24 || i10 == 29 || i10 == 30) ? 2 : 3];
        switch (i10) {
            case 1:
            case 6:
            case Build.API_LEVELS.API_27 /* 27 */:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 8:
            case Build.API_LEVELS.API_26 /* 26 */:
                objArr[0] = "kind";
                break;
            case 4:
            case 9:
            case Build.API_LEVELS.API_28 /* 28 */:
                objArr[0] = FirebaseAnalytics.Param.SOURCE;
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 15:
            case 20:
                objArr[0] = "typeParameters";
                break;
            case 11:
            case 16:
            case Build.API_LEVELS.API_21 /* 21 */:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case Build.API_LEVELS.API_22 /* 22 */:
                objArr[0] = "visibility";
                break;
            case 13:
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case Build.API_LEVELS.API_23 /* 23 */:
            case 24:
            case Build.API_LEVELS.API_29 /* 29 */:
            case Build.API_LEVELS.API_30 /* 30 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
                break;
            case 14:
            case 19:
                objArr[0] = "contextReceiverParameters";
                break;
            case Build.API_LEVELS.API_25 /* 25 */:
                objArr[0] = "newOwner";
                break;
        }
        if (i10 == 13 || i10 == 18 || i10 == 23) {
            objArr[1] = "initialize";
        } else if (i10 == 24) {
            objArr[1] = "getOriginal";
        } else if (i10 == 29) {
            objArr[1] = "copy";
        } else if (i10 != 30) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
        } else {
            objArr[1] = "newCopyBuilder";
        }
        switch (i10) {
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[2] = "create";
                break;
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case 19:
            case 20:
            case Build.API_LEVELS.API_21 /* 21 */:
            case Build.API_LEVELS.API_22 /* 22 */:
                objArr[2] = "initialize";
                break;
            case 13:
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case Build.API_LEVELS.API_23 /* 23 */:
            case 24:
            case Build.API_LEVELS.API_29 /* 29 */:
            case Build.API_LEVELS.API_30 /* 30 */:
                break;
            case Build.API_LEVELS.API_25 /* 25 */:
            case Build.API_LEVELS.API_26 /* 26 */:
            case Build.API_LEVELS.API_27 /* 27 */:
            case Build.API_LEVELS.API_28 /* 28 */:
                objArr[2] = "createSubstitutedCopy";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 13 && i10 != 18 && i10 != 23 && i10 != 24 && i10 != 29 && i10 != 30) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // ie.s
    public s L0(fe.m mVar, fe.z zVar, b.a aVar, ef.f fVar, ge.h hVar, g1 g1Var) {
        if (mVar == null) {
            w(25);
        }
        if (aVar == null) {
            w(26);
        }
        if (hVar == null) {
            w(27);
        }
        if (g1Var == null) {
            w(28);
        }
        f1 f1Var = (f1) zVar;
        if (fVar == null) {
            fVar = getName();
        }
        return new o0(mVar, f1Var, hVar, fVar, aVar, g1Var);
    }

    @Override // fe.b
    /* JADX INFO: renamed from: k1 */
    public f1 L(fe.m mVar, fe.e0 e0Var, fe.u uVar, b.a aVar, boolean z10) {
        f1 f1Var = (f1) super.K0(mVar, e0Var, uVar, aVar, z10);
        if (f1Var == null) {
            w(29);
        }
        return f1Var;
    }

    @Override // ie.n
    /* JADX INFO: renamed from: m1, reason: merged with bridge method [inline-methods] */
    public f1 a() {
        f1 f1Var = (f1) super.a();
        if (f1Var == null) {
            w(24);
        }
        return f1Var;
    }

    @Override // ie.s
    /* JADX INFO: renamed from: n1, reason: merged with bridge method [inline-methods] */
    public o0 R0(b1 b1Var, b1 b1Var2, List list, List list2, List list3, xf.r0 r0Var, fe.e0 e0Var, fe.u uVar) {
        if (list == null) {
            w(14);
        }
        if (list2 == null) {
            w(15);
        }
        if (list3 == null) {
            w(16);
        }
        if (uVar == null) {
            w(17);
        }
        o0 o0VarO1 = o1(b1Var, b1Var2, list, list2, list3, r0Var, e0Var, uVar, null);
        if (o0VarO1 == null) {
            w(18);
        }
        return o0VarO1;
    }

    public o0 o1(b1 b1Var, b1 b1Var2, List list, List list2, List list3, xf.r0 r0Var, fe.e0 e0Var, fe.u uVar, Map map) {
        if (list == null) {
            w(19);
        }
        if (list2 == null) {
            w(20);
        }
        if (list3 == null) {
            w(21);
        }
        if (uVar == null) {
            w(22);
        }
        super.R0(b1Var, b1Var2, list, list2, list3, r0Var, e0Var, uVar);
        if (map != null && !map.isEmpty()) {
            this.D = new LinkedHashMap(map);
        }
        return this;
    }

    @Override // ie.s, fe.z
    public z.a u() {
        z.a aVarU = super.u();
        if (aVarU == null) {
            w(30);
        }
        return aVarU;
    }
}
