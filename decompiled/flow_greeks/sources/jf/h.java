package jf;

import bb.d0;
import com.google.firebase.analytics.FirebaseAnalytics;
import fe.b;
import fe.b1;
import fe.e0;
import fe.f1;
import fe.g1;
import fe.h0;
import fe.y0;
import fe.z;
import ge.h;
import ie.k0;
import ie.l0;
import ie.m0;
import ie.n0;
import ie.o0;
import io.flutter.Build;
import java.util.Collections;
import java.util.List;
import xf.c1;
import xf.c2;
import xf.m2;
import xf.q1;
import xf.r0;
import xf.u0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends ie.i {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(fe.e eVar, g1 g1Var, boolean z10) {
            super(eVar, null, ge.h.L.b(), true, b.a.DECLARATION, g1Var);
            if (eVar == null) {
                w(0);
            }
            if (g1Var == null) {
                w(1);
            }
            q1(Collections.EMPTY_LIST, i.k(eVar, z10));
        }

        private static /* synthetic */ void w(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "containingClass";
            } else {
                objArr[0] = FirebaseAnalytics.Param.SOURCE;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory$DefaultClassConstructorDescriptor";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }
    }

    public static /* synthetic */ void a(int i10) {
        String str = (i10 == 12 || i10 == 23 || i10 == 25) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 12 || i10 == 23 || i10 == 25) ? 2 : 3];
        switch (i10) {
            case 1:
            case 4:
            case 8:
            case 14:
            case 16:
            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case Build.API_LEVELS.API_31 /* 31 */:
            case Build.API_LEVELS.API_33 /* 33 */:
            case Build.API_LEVELS.API_35 /* 35 */:
                objArr[0] = "annotations";
                break;
            case 2:
            case 5:
            case 9:
                objArr[0] = "parameterAnnotations";
                break;
            case 3:
            case 7:
            case 13:
            case 15:
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            default:
                objArr[0] = "propertyDescriptor";
                break;
            case 6:
            case 11:
            case 19:
                objArr[0] = "sourceElement";
                break;
            case 10:
                objArr[0] = "visibility";
                break;
            case 12:
            case Build.API_LEVELS.API_23 /* 23 */:
            case Build.API_LEVELS.API_25 /* 25 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
                break;
            case 20:
                objArr[0] = "containingClass";
                break;
            case Build.API_LEVELS.API_21 /* 21 */:
                objArr[0] = FirebaseAnalytics.Param.SOURCE;
                break;
            case Build.API_LEVELS.API_22 /* 22 */:
            case 24:
            case Build.API_LEVELS.API_26 /* 26 */:
                objArr[0] = "enumClass";
                break;
            case Build.API_LEVELS.API_27 /* 27 */:
            case Build.API_LEVELS.API_28 /* 28 */:
            case Build.API_LEVELS.API_29 /* 29 */:
                objArr[0] = "descriptor";
                break;
            case Build.API_LEVELS.API_30 /* 30 */:
            case 32:
            case Build.API_LEVELS.API_34 /* 34 */:
                objArr[0] = "owner";
                break;
        }
        if (i10 == 12) {
            objArr[1] = "createSetter";
        } else if (i10 == 23) {
            objArr[1] = "createEnumValuesMethod";
        } else if (i10 != 25) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
        } else {
            objArr[1] = "createEnumValueOfMethod";
        }
        switch (i10) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "createSetter";
                break;
            case 12:
            case Build.API_LEVELS.API_23 /* 23 */:
            case Build.API_LEVELS.API_25 /* 25 */:
                break;
            case 13:
            case 14:
                objArr[2] = "createDefaultGetter";
                break;
            case 15:
            case 16:
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
                objArr[2] = "createGetter";
                break;
            case 20:
            case Build.API_LEVELS.API_21 /* 21 */:
                objArr[2] = "createPrimaryConstructorForObject";
                break;
            case Build.API_LEVELS.API_22 /* 22 */:
                objArr[2] = "createEnumValuesMethod";
                break;
            case 24:
                objArr[2] = "createEnumValueOfMethod";
                break;
            case Build.API_LEVELS.API_26 /* 26 */:
                objArr[2] = "createEnumEntriesProperty";
                break;
            case Build.API_LEVELS.API_27 /* 27 */:
                objArr[2] = "isEnumValuesMethod";
                break;
            case Build.API_LEVELS.API_28 /* 28 */:
                objArr[2] = "isEnumValueOfMethod";
                break;
            case Build.API_LEVELS.API_29 /* 29 */:
                objArr[2] = "isEnumSpecialMethod";
                break;
            case Build.API_LEVELS.API_30 /* 30 */:
            case Build.API_LEVELS.API_31 /* 31 */:
                objArr[2] = "createExtensionReceiverParameterForCallable";
                break;
            case 32:
            case Build.API_LEVELS.API_33 /* 33 */:
                objArr[2] = "createContextReceiverParameterForCallable";
                break;
            case Build.API_LEVELS.API_34 /* 34 */:
            case Build.API_LEVELS.API_35 /* 35 */:
                objArr[2] = "createContextReceiverParameterForClass";
                break;
            default:
                objArr[2] = "createDefaultSetter";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 12 && i10 != 23 && i10 != 25) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static b1 b(fe.a aVar, r0 r0Var, ef.f fVar, ge.h hVar, int i10) {
        if (aVar == null) {
            a(32);
        }
        if (hVar == null) {
            a(33);
        }
        if (r0Var == null) {
            return null;
        }
        return new n0(aVar, new rf.c(aVar, r0Var, fVar, null), hVar, ef.g.a(i10));
    }

    public static b1 c(fe.e eVar, r0 r0Var, ef.f fVar, ge.h hVar, int i10) {
        if (eVar == null) {
            a(34);
        }
        if (hVar == null) {
            a(35);
        }
        if (r0Var == null) {
            return null;
        }
        return new n0(eVar, new rf.b(eVar, r0Var, fVar, null), hVar, ef.g.a(i10));
    }

    public static l0 d(y0 y0Var, ge.h hVar) {
        if (y0Var == null) {
            a(13);
        }
        if (hVar == null) {
            a(14);
        }
        return j(y0Var, hVar, true, false, false);
    }

    public static m0 e(y0 y0Var, ge.h hVar, ge.h hVar2) {
        if (y0Var == null) {
            a(0);
        }
        if (hVar == null) {
            a(1);
        }
        if (hVar2 == null) {
            a(2);
        }
        return n(y0Var, hVar, hVar2, true, false, false, y0Var.j());
    }

    public static y0 f(fe.e eVar) {
        if (eVar == null) {
            a(26);
        }
        h0 h0VarG = i.g(eVar);
        fe.e eVarA = v.a(h0VarG).a(h0VarG);
        if (eVarA == null) {
            return null;
        }
        h.a aVar = ge.h.L;
        ge.h hVarB = aVar.b();
        e0 e0Var = e0.f9461b;
        fe.u uVar = fe.t.f9511e;
        ef.f fVar = ce.o.f3951e;
        b.a aVar2 = b.a.SYNTHESIZED;
        k0 k0VarO0 = k0.O0(eVar, hVarB, e0Var, uVar, false, fVar, aVar2, eVar.j(), false, false, false, false, false, false);
        l0 l0Var = new l0(k0VarO0, aVar.b(), e0Var, uVar, false, false, false, aVar2, null, eVar.j());
        k0VarO0.U0(l0Var, null);
        c1 c1VarI = u0.i(q1.f25042b.k(), eVarA.k(), Collections.singletonList(new c2(eVar.s())), false);
        List list = Collections.EMPTY_LIST;
        k0VarO0.b1(c1VarI, list, null, null, list);
        l0Var.P0(k0VarO0.getReturnType());
        return k0VarO0;
    }

    public static f1 g(fe.e eVar) {
        if (eVar == null) {
            a(24);
        }
        h.a aVar = ge.h.L;
        o0 o0VarL1 = o0.l1(eVar, aVar.b(), ce.o.f3952f, b.a.SYNTHESIZED, eVar.j());
        ie.u0 u0Var = new ie.u0(o0VarL1, null, 0, aVar.b(), ef.f.k("value"), nf.e.m(eVar).X(), false, false, false, null, eVar.j());
        List list = Collections.EMPTY_LIST;
        o0 o0VarN1 = o0VarL1.R0(null, null, list, list, Collections.singletonList(u0Var), eVar.s(), e0.f9461b, fe.t.f9511e);
        if (o0VarN1 == null) {
            a(25);
        }
        return o0VarN1;
    }

    public static f1 h(fe.e eVar) {
        if (eVar == null) {
            a(22);
        }
        o0 o0VarL1 = o0.l1(eVar, ge.h.L.b(), ce.o.f3950d, b.a.SYNTHESIZED, eVar.j());
        List list = Collections.EMPTY_LIST;
        o0 o0VarN1 = o0VarL1.R0(null, null, list, list, list, nf.e.m(eVar).m(m2.f25015e, eVar.s()), e0.f9461b, fe.t.f9511e);
        if (o0VarN1 == null) {
            a(23);
        }
        return o0VarN1;
    }

    public static b1 i(fe.a aVar, r0 r0Var, ge.h hVar) {
        if (aVar == null) {
            a(30);
        }
        if (hVar == null) {
            a(31);
        }
        if (r0Var == null) {
            return null;
        }
        return new n0(aVar, new rf.d(aVar, r0Var, null), hVar);
    }

    public static l0 j(y0 y0Var, ge.h hVar, boolean z10, boolean z11, boolean z12) {
        if (y0Var == null) {
            a(15);
        }
        if (hVar == null) {
            a(16);
        }
        return k(y0Var, hVar, z10, z11, z12, y0Var.j());
    }

    public static l0 k(y0 y0Var, ge.h hVar, boolean z10, boolean z11, boolean z12, g1 g1Var) {
        if (y0Var == null) {
            a(17);
        }
        if (hVar == null) {
            a(18);
        }
        if (g1Var == null) {
            a(19);
        }
        return new l0(y0Var, hVar, y0Var.l(), y0Var.getVisibility(), z10, z11, z12, b.a.DECLARATION, null, g1Var);
    }

    public static ie.i l(fe.e eVar, g1 g1Var) {
        if (eVar == null) {
            a(20);
        }
        if (g1Var == null) {
            a(21);
        }
        return new a(eVar, g1Var, false);
    }

    public static m0 m(y0 y0Var, ge.h hVar, ge.h hVar2, boolean z10, boolean z11, boolean z12, fe.u uVar, g1 g1Var) {
        if (y0Var == null) {
            a(7);
        }
        if (hVar == null) {
            a(8);
        }
        if (hVar2 == null) {
            a(9);
        }
        if (uVar == null) {
            a(10);
        }
        if (g1Var == null) {
            a(11);
        }
        m0 m0Var = new m0(y0Var, hVar, y0Var.l(), uVar, z10, z11, z12, b.a.DECLARATION, null, g1Var);
        m0Var.Q0(m0.O0(m0Var, y0Var.getType(), hVar2));
        return m0Var;
    }

    public static m0 n(y0 y0Var, ge.h hVar, ge.h hVar2, boolean z10, boolean z11, boolean z12, g1 g1Var) {
        if (y0Var == null) {
            a(3);
        }
        if (hVar == null) {
            a(4);
        }
        if (hVar2 == null) {
            a(5);
        }
        if (g1Var == null) {
            a(6);
        }
        return m(y0Var, hVar, hVar2, z10, z11, z12, y0Var.getVisibility(), g1Var);
    }

    public static boolean o(z zVar) {
        if (zVar == null) {
            a(29);
        }
        return zVar.h() == b.a.SYNTHESIZED && i.A(zVar.b());
    }

    public static boolean p(z zVar) {
        if (zVar == null) {
            a(28);
        }
        return zVar.getName().equals(ce.o.f3952f) && o(zVar);
    }

    public static boolean q(z zVar) {
        if (zVar == null) {
            a(27);
        }
        return zVar.getName().equals(ce.o.f3950d) && o(zVar);
    }
}
