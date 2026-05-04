package ie;

import com.google.firebase.analytics.FirebaseAnalytics;
import fe.g1;
import fe.j1;
import fe.l1;
import io.flutter.Build;
import java.util.ArrayList;
import java.util.List;
import xf.m2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class t0 extends h {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final pd.k f12483k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List f12484l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f12485m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t0(fe.m mVar, ge.h hVar, boolean z10, m2 m2Var, ef.f fVar, int i10, g1 g1Var, pd.k kVar, j1 j1Var, wf.n nVar) {
        super(nVar, mVar, hVar, fVar, m2Var, z10, i10, g1Var, j1Var);
        if (mVar == null) {
            w(19);
        }
        if (hVar == null) {
            w(20);
        }
        if (m2Var == null) {
            w(21);
        }
        if (fVar == null) {
            w(22);
        }
        if (g1Var == null) {
            w(23);
        }
        if (j1Var == null) {
            w(24);
        }
        if (nVar == null) {
            w(25);
        }
        this.f12484l = new ArrayList(1);
        this.f12485m = false;
        this.f12483k = kVar;
    }

    public static t0 P0(fe.m mVar, ge.h hVar, boolean z10, m2 m2Var, ef.f fVar, int i10, g1 g1Var, pd.k kVar, j1 j1Var, wf.n nVar) {
        if (mVar == null) {
            w(12);
        }
        if (hVar == null) {
            w(13);
        }
        if (m2Var == null) {
            w(14);
        }
        if (fVar == null) {
            w(15);
        }
        if (g1Var == null) {
            w(16);
        }
        if (j1Var == null) {
            w(17);
        }
        if (nVar == null) {
            w(18);
        }
        return new t0(mVar, hVar, z10, m2Var, fVar, i10, g1Var, kVar, j1Var, nVar);
    }

    public static t0 Q0(fe.m mVar, ge.h hVar, boolean z10, m2 m2Var, ef.f fVar, int i10, g1 g1Var, wf.n nVar) {
        if (mVar == null) {
            w(6);
        }
        if (hVar == null) {
            w(7);
        }
        if (m2Var == null) {
            w(8);
        }
        if (fVar == null) {
            w(9);
        }
        if (g1Var == null) {
            w(10);
        }
        if (nVar == null) {
            w(11);
        }
        return P0(mVar, hVar, z10, m2Var, fVar, i10, g1Var, null, j1.a.f9488a, nVar);
    }

    public static l1 R0(fe.m mVar, ge.h hVar, boolean z10, m2 m2Var, ef.f fVar, int i10, wf.n nVar) {
        if (mVar == null) {
            w(0);
        }
        if (hVar == null) {
            w(1);
        }
        if (m2Var == null) {
            w(2);
        }
        if (fVar == null) {
            w(3);
        }
        if (nVar == null) {
            w(4);
        }
        t0 t0VarQ0 = Q0(mVar, hVar, z10, m2Var, fVar, i10, g1.f9483a, nVar);
        t0VarQ0.M0(nf.e.m(mVar).z());
        t0VarQ0.V0();
        return t0VarQ0;
    }

    private static /* synthetic */ void w(int i10) {
        String str = (i10 == 5 || i10 == 28) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 5 || i10 == 28) ? 2 : 3];
        switch (i10) {
            case 1:
            case 7:
            case 13:
            case 20:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 14:
            case Build.API_LEVELS.API_21 /* 21 */:
                objArr[0] = "variance";
                break;
            case 3:
            case 9:
            case 15:
            case Build.API_LEVELS.API_22 /* 22 */:
                objArr[0] = "name";
                break;
            case 4:
            case 11:
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case Build.API_LEVELS.API_25 /* 25 */:
                objArr[0] = "storageManager";
                break;
            case 5:
            case Build.API_LEVELS.API_28 /* 28 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 16:
            case Build.API_LEVELS.API_23 /* 23 */:
                objArr[0] = FirebaseAnalytics.Param.SOURCE;
                break;
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                objArr[0] = "supertypeLoopsResolver";
                break;
            case 24:
                objArr[0] = "supertypeLoopsChecker";
                break;
            case Build.API_LEVELS.API_26 /* 26 */:
                objArr[0] = "bound";
                break;
            case Build.API_LEVELS.API_27 /* 27 */:
                objArr[0] = "type";
                break;
        }
        if (i10 == 5) {
            objArr[1] = "createWithDefaultBound";
        } else if (i10 != 28) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
        } else {
            objArr[1] = "resolveUpperBounds";
        }
        switch (i10) {
            case 5:
            case Build.API_LEVELS.API_28 /* 28 */:
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                objArr[2] = "createForFurtherModification";
                break;
            case 19:
            case 20:
            case Build.API_LEVELS.API_21 /* 21 */:
            case Build.API_LEVELS.API_22 /* 22 */:
            case Build.API_LEVELS.API_23 /* 23 */:
            case 24:
            case Build.API_LEVELS.API_25 /* 25 */:
                objArr[2] = "<init>";
                break;
            case Build.API_LEVELS.API_26 /* 26 */:
                objArr[2] = "addUpperBound";
                break;
            case Build.API_LEVELS.API_27 /* 27 */:
                objArr[2] = "reportSupertypeLoopError";
                break;
            default:
                objArr[2] = "createWithDefaultBound";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 5 && i10 != 28) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // ie.h
    public void K0(xf.r0 r0Var) {
        if (r0Var == null) {
            w(27);
        }
        pd.k kVar = this.f12483k;
        if (kVar == null) {
            return;
        }
        kVar.invoke(r0Var);
    }

    @Override // ie.h
    public List L0() {
        N0();
        List list = this.f12484l;
        if (list == null) {
            w(28);
        }
        return list;
    }

    public void M0(xf.r0 r0Var) {
        if (r0Var == null) {
            w(26);
        }
        O0();
        S0(r0Var);
    }

    public final void N0() {
        if (this.f12485m) {
            return;
        }
        throw new IllegalStateException("Type parameter descriptor is not initialized: " + U0());
    }

    public final void O0() {
        if (this.f12485m) {
            throw new IllegalStateException("Type parameter descriptor is already initialized: " + U0());
        }
    }

    public final void S0(xf.r0 r0Var) {
        if (xf.v0.a(r0Var)) {
            return;
        }
        this.f12484l.add(r0Var);
    }

    public boolean T0() {
        return this.f12485m;
    }

    public final String U0() {
        return getName() + " declared in " + jf.i.m(b());
    }

    public void V0() {
        O0();
        this.f12485m = true;
    }
}
