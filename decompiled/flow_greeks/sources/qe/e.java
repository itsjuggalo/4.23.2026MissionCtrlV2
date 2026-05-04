package qe;

import bb.d0;
import cd.q;
import com.google.firebase.analytics.FirebaseAnalytics;
import eg.s;
import fe.a;
import fe.b;
import fe.b1;
import fe.e0;
import fe.f1;
import fe.g1;
import fe.m;
import fe.u;
import fe.z;
import ie.o0;
import io.flutter.Build;
import java.util.List;
import java.util.Map;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class e extends o0 implements qe.a {
    public static final a.InterfaceC0175a G = new a();
    public static final a.InterfaceC0175a H = new b();
    public c E;
    public final boolean F;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements a.InterfaceC0175a {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b implements a.InterfaceC0175a {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum c {
        NON_STABLE_DECLARED(false, false),
        STABLE_DECLARED(true, false),
        NON_STABLE_SYNTHESIZED(false, true),
        STABLE_SYNTHESIZED(true, true);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f19038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f19039b;

        c(boolean z10, boolean z11) {
            this.f19038a = z10;
            this.f19039b = z11;
        }

        public static /* synthetic */ void a(int i10) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus", com.amazon.a.a.o.b.au));
        }

        public static c b(boolean z10, boolean z11) {
            c cVar = z10 ? z11 ? STABLE_SYNTHESIZED : STABLE_DECLARED : z11 ? NON_STABLE_SYNTHESIZED : NON_STABLE_DECLARED;
            if (cVar == null) {
                a(0);
            }
            return cVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(m mVar, f1 f1Var, ge.h hVar, ef.f fVar, b.a aVar, g1 g1Var, boolean z10) {
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
        this.E = null;
        this.F = z10;
    }

    public static e p1(m mVar, ge.h hVar, ef.f fVar, g1 g1Var, boolean z10) {
        if (mVar == null) {
            w(5);
        }
        if (hVar == null) {
            w(6);
        }
        if (fVar == null) {
            w(7);
        }
        if (g1Var == null) {
            w(8);
        }
        return new e(mVar, null, hVar, fVar, b.a.DECLARATION, g1Var, z10);
    }

    private static /* synthetic */ void w(int i10) {
        String str = (i10 == 13 || i10 == 18 || i10 == 21) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 13 || i10 == 18 || i10 == 21) ? 2 : 3];
        switch (i10) {
            case 1:
            case 6:
            case 16:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 15:
                objArr[0] = "kind";
                break;
            case 4:
            case 8:
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                objArr[0] = FirebaseAnalytics.Param.SOURCE;
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 9:
                objArr[0] = "contextReceiverParameters";
                break;
            case 10:
                objArr[0] = "typeParameters";
                break;
            case 11:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
                objArr[0] = "visibility";
                break;
            case 13:
            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case Build.API_LEVELS.API_21 /* 21 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
            case 14:
                objArr[0] = "newOwner";
                break;
            case 19:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i10 == 13) {
            objArr[1] = "initialize";
        } else if (i10 == 18) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i10 != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i10) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "createJavaMethod";
                break;
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "initialize";
                break;
            case 13:
            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case Build.API_LEVELS.API_21 /* 21 */:
                break;
            case 14:
            case 15:
            case 16:
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 13 && i10 != 18 && i10 != 21) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // ie.s, fe.a
    public boolean H() {
        return this.E.f19039b;
    }

    @Override // ie.s
    public boolean Q0() {
        return this.E.f19038a;
    }

    @Override // ie.o0
    public o0 o1(b1 b1Var, b1 b1Var2, List list, List list2, List list3, r0 r0Var, e0 e0Var, u uVar, Map map) {
        if (list == null) {
            w(9);
        }
        if (list2 == null) {
            w(10);
        }
        if (list3 == null) {
            w(11);
        }
        if (uVar == null) {
            w(12);
        }
        o0 o0VarO1 = super.o1(b1Var, b1Var2, list, list2, list3, r0Var, e0Var, uVar, map);
        f1(s.f8915a.a(o0VarO1).a());
        if (o0VarO1 == null) {
            w(13);
        }
        return o0VarO1;
    }

    @Override // ie.o0, ie.s
    /* JADX INFO: renamed from: q1, reason: merged with bridge method [inline-methods] */
    public e L0(m mVar, z zVar, b.a aVar, ef.f fVar, ge.h hVar, g1 g1Var) {
        if (mVar == null) {
            w(14);
        }
        if (aVar == null) {
            w(15);
        }
        if (hVar == null) {
            w(16);
        }
        if (g1Var == null) {
            w(17);
        }
        f1 f1Var = (f1) zVar;
        if (fVar == null) {
            fVar = getName();
        }
        e eVar = new e(mVar, f1Var, hVar, fVar, aVar, g1Var, this.F);
        eVar.s1(Q0(), H());
        return eVar;
    }

    @Override // qe.a
    /* JADX INFO: renamed from: r1, reason: merged with bridge method [inline-methods] */
    public e M(r0 r0Var, List list, r0 r0Var2, q qVar) {
        if (list == null) {
            w(19);
        }
        if (r0Var2 == null) {
            w(20);
        }
        e eVar = (e) u().b(h.a(list, i(), this)).g(r0Var2).c(r0Var == null ? null : jf.h.i(this, r0Var, ge.h.L.b())).a().e().build();
        if (qVar != null) {
            eVar.U0((a.InterfaceC0175a) qVar.c(), qVar.d());
        }
        if (eVar == null) {
            w(21);
        }
        return eVar;
    }

    public void s1(boolean z10, boolean z11) {
        this.E = c.b(z10, z11);
    }
}
