package jf;

import bb.d0;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.common.events.EventsManager;
import com.revenuecat.purchases.utils.PurchaseParamsValidator;
import fe.a1;
import fe.b;
import fe.b1;
import fe.e0;
import fe.h0;
import fe.h1;
import fe.n0;
import fe.t1;
import fe.u0;
import io.flutter.Build;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import xf.i2;
import xf.r0;
import xf.u1;
import xf.v0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ef.c f14324a = new ef.c("kotlin.jvm.JvmName");

    public static boolean A(fe.m mVar) {
        return D(mVar, fe.f.f9475d);
    }

    public static boolean B(fe.m mVar) {
        if (mVar == null) {
            a(36);
        }
        return D(mVar, fe.f.f9476e);
    }

    public static boolean C(fe.m mVar) {
        return D(mVar, fe.f.f9474c);
    }

    public static boolean D(fe.m mVar, fe.f fVar) {
        if (fVar == null) {
            a(37);
        }
        return (mVar instanceof fe.e) && ((fe.e) mVar).h() == fVar;
    }

    public static boolean E(fe.m mVar) {
        if (mVar == null) {
            a(1);
        }
        while (mVar != null) {
            if (u(mVar) || y(mVar)) {
                return true;
            }
            mVar = mVar.b();
        }
        return false;
    }

    public static boolean F(r0 r0Var, fe.m mVar) {
        if (r0Var == null) {
            a(30);
        }
        if (mVar == null) {
            a(31);
        }
        fe.h hVarB = r0Var.N0().b();
        if (hVarB == null) {
            return false;
        }
        fe.m mVarA = hVarB.a();
        return (mVarA instanceof fe.h) && (mVar instanceof fe.h) && ((fe.h) mVar).k().equals(((fe.h) mVarA).k());
    }

    public static boolean G(fe.m mVar) {
        return (D(mVar, fe.f.f9473b) || D(mVar, fe.f.f9474c)) && ((fe.e) mVar).l() == e0.f9462c;
    }

    public static boolean H(fe.e eVar, fe.e eVar2) {
        if (eVar == null) {
            a(28);
        }
        if (eVar2 == null) {
            a(29);
        }
        return I(eVar.s(), eVar2.a());
    }

    public static boolean I(r0 r0Var, fe.m mVar) {
        if (r0Var == null) {
            a(32);
        }
        if (mVar == null) {
            a(33);
        }
        if (F(r0Var, mVar)) {
            return true;
        }
        Iterator it = r0Var.N0().c().iterator();
        while (it.hasNext()) {
            if (I((r0) it.next(), mVar)) {
                return true;
            }
        }
        return false;
    }

    public static boolean J(fe.m mVar) {
        return mVar != null && (mVar.b() instanceof n0);
    }

    public static boolean K(t1 t1Var, r0 r0Var) {
        if (t1Var == null) {
            a(66);
        }
        if (r0Var == null) {
            a(67);
        }
        if (t1Var.i0() || v0.a(r0Var)) {
            return false;
        }
        if (i2.b(r0Var)) {
            return true;
        }
        ce.i iVarM = nf.e.m(t1Var);
        if (!ce.i.t0(r0Var)) {
            yf.e eVar = yf.e.f25402a;
            if (!eVar.b(iVarM.X(), r0Var) && !eVar.b(iVarM.L().s(), r0Var) && !eVar.b(iVarM.i(), r0Var) && !ce.s.d(r0Var)) {
                return false;
            }
        }
        return true;
    }

    public static fe.b L(fe.b bVar) {
        if (bVar == null) {
            a(59);
        }
        while (bVar.h() == b.a.FAKE_OVERRIDE) {
            Collection collectionF = bVar.f();
            if (collectionF.isEmpty()) {
                throw new IllegalStateException("Fake override should have at least one overridden descriptor: " + bVar);
            }
            bVar = (fe.b) collectionF.iterator().next();
        }
        return bVar;
    }

    public static fe.q M(fe.q qVar) {
        if (qVar == null) {
            a(64);
        }
        if (qVar instanceof fe.b) {
            return L((fe.b) qVar);
        }
        if (qVar == null) {
            a(65);
        }
        return qVar;
    }

    public static /* synthetic */ void a(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case Build.API_LEVELS.API_22 /* 22 */:
            case 40:
            case 42:
            case 43:
            case 47:
            case PurchaseParamsValidator.MAX_NUMBER_OF_ADD_ON_PRODUCTS /* 49 */:
            case EventsManager.EVENTS_TO_CLEAR_ON_LIMIT /* 50 */:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 63:
            case 65:
            case 72:
            case 76:
            case 83:
            case 84:
            case 86:
            case 89:
            case 94:
            case 96:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case Build.API_LEVELS.API_22 /* 22 */:
            case 40:
            case 42:
            case 43:
            case 47:
            case PurchaseParamsValidator.MAX_NUMBER_OF_ADD_ON_PRODUCTS /* 49 */:
            case EventsManager.EVENTS_TO_CLEAR_ON_LIMIT /* 50 */:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 63:
            case 65:
            case 72:
            case 76:
            case 83:
            case 84:
            case 86:
            case 89:
            case 94:
            case 96:
                i11 = 2;
                break;
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
            case 13:
            case 14:
            case 15:
            case Build.API_LEVELS.API_21 /* 21 */:
            case Build.API_LEVELS.API_23 /* 23 */:
            case 24:
            case Build.API_LEVELS.API_34 /* 34 */:
            case Build.API_LEVELS.API_35 /* 35 */:
            case Build.API_LEVELS.API_36 /* 36 */:
            case 57:
            case 58:
            case 59:
            case 61:
            case 64:
            case 82:
            case 95:
            case 97:
                objArr[0] = "descriptor";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case Build.API_LEVELS.API_22 /* 22 */:
            case 40:
            case 42:
            case 43:
            case 47:
            case PurchaseParamsValidator.MAX_NUMBER_OF_ADD_ON_PRODUCTS /* 49 */:
            case EventsManager.EVENTS_TO_CLEAR_ON_LIMIT /* 50 */:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 63:
            case 65:
            case 72:
            case 76:
            case 83:
            case 84:
            case 86:
            case 89:
            case 94:
            case 96:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
            case 16:
                objArr[0] = "first";
                break;
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                objArr[0] = "second";
                break;
            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
                objArr[0] = "aClass";
                break;
            case 20:
                objArr[0] = "kotlinType";
                break;
            case Build.API_LEVELS.API_25 /* 25 */:
                objArr[0] = "declarationDescriptor";
                break;
            case Build.API_LEVELS.API_26 /* 26 */:
            case Build.API_LEVELS.API_28 /* 28 */:
                objArr[0] = "subClass";
                break;
            case Build.API_LEVELS.API_27 /* 27 */:
            case Build.API_LEVELS.API_29 /* 29 */:
            case Build.API_LEVELS.API_33 /* 33 */:
                objArr[0] = "superClass";
                break;
            case Build.API_LEVELS.API_30 /* 30 */:
            case 32:
            case 45:
            case 67:
                objArr[0] = "type";
                break;
            case Build.API_LEVELS.API_31 /* 31 */:
                objArr[0] = "other";
                break;
            case 37:
                objArr[0] = "classKind";
                break;
            case 38:
            case 39:
            case 41:
            case 44:
            case 48:
            case 54:
            case 68:
            case 69:
            case 70:
            case 77:
            case 78:
                objArr[0] = "classDescriptor";
                break;
            case 46:
                objArr[0] = "typeConstructor";
                break;
            case 55:
                objArr[0] = "innerClassName";
                break;
            case 56:
                objArr[0] = FirebaseAnalytics.Param.LOCATION;
                break;
            case 66:
                objArr[0] = "variable";
                break;
            case 71:
                objArr[0] = "f";
                break;
            case 73:
                objArr[0] = "current";
                break;
            case 74:
                objArr[0] = "result";
                break;
            case 75:
                objArr[0] = "memberDescriptor";
                break;
            case 79:
            case 80:
            case 81:
                objArr[0] = "annotated";
                break;
            case 85:
            case 87:
            case 90:
            case 92:
                objArr[0] = "scope";
                break;
            case 88:
            case 91:
            case 93:
                objArr[0] = "name";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i10) {
            case 4:
                objArr[1] = "getFqNameSafe";
                break;
            case 7:
                objArr[1] = "getFqNameUnsafe";
                break;
            case 9:
            case 10:
                objArr[1] = "getFqNameFromTopLevelClass";
                break;
            case 12:
                objArr[1] = "getClassIdForNonLocalClass";
                break;
            case Build.API_LEVELS.API_22 /* 22 */:
                objArr[1] = "getContainingModule";
                break;
            case 40:
                objArr[1] = "getSuperclassDescriptors";
                break;
            case 42:
            case 43:
                objArr[1] = "getSuperClassType";
                break;
            case 47:
                objArr[1] = "getClassDescriptorForTypeConstructor";
                break;
            case PurchaseParamsValidator.MAX_NUMBER_OF_ADD_ON_PRODUCTS /* 49 */:
            case EventsManager.EVENTS_TO_CLEAR_ON_LIMIT /* 50 */:
            case 51:
            case 52:
            case 53:
                objArr[1] = "getDefaultConstructorVisibility";
                break;
            case 60:
                objArr[1] = "unwrapFakeOverride";
                break;
            case 62:
            case 63:
                objArr[1] = "unwrapSubstitutionOverride";
                break;
            case 65:
                objArr[1] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 72:
                objArr[1] = "getAllOverriddenDescriptors";
                break;
            case 76:
                objArr[1] = "getAllOverriddenDeclarations";
                break;
            case 83:
            case 84:
                objArr[1] = "getContainingSourceFile";
                break;
            case 86:
                objArr[1] = "getAllDescriptors";
                break;
            case 89:
                objArr[1] = "getFunctionByName";
                break;
            case 94:
                objArr[1] = "getPropertyByName";
                break;
            case 96:
                objArr[1] = "getDirectMember";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
        }
        switch (i10) {
            case 1:
                objArr[2] = "isLocal";
                break;
            case 2:
                objArr[2] = "getFqName";
                break;
            case 3:
                objArr[2] = "getFqNameSafe";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case Build.API_LEVELS.API_22 /* 22 */:
            case 40:
            case 42:
            case 43:
            case 47:
            case PurchaseParamsValidator.MAX_NUMBER_OF_ADD_ON_PRODUCTS /* 49 */:
            case EventsManager.EVENTS_TO_CLEAR_ON_LIMIT /* 50 */:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 63:
            case 65:
            case 72:
            case 76:
            case 83:
            case 84:
            case 86:
            case 89:
            case 94:
            case 96:
                break;
            case 5:
                objArr[2] = "getFqNameSafeIfPossible";
                break;
            case 6:
                objArr[2] = "getFqNameUnsafe";
                break;
            case 8:
                objArr[2] = "getFqNameFromTopLevelClass";
                break;
            case 11:
                objArr[2] = "getClassIdForNonLocalClass";
                break;
            case 13:
                objArr[2] = "isExtension";
                break;
            case 14:
                objArr[2] = "isOverride";
                break;
            case 15:
                objArr[2] = "isStaticDeclaration";
                break;
            case 16:
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                objArr[2] = "areInSameModule";
                break;
            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
                objArr[2] = "getParentOfType";
                break;
            case 20:
            case Build.API_LEVELS.API_23 /* 23 */:
                objArr[2] = "getContainingModuleOrNull";
                break;
            case Build.API_LEVELS.API_21 /* 21 */:
                objArr[2] = "getContainingModule";
                break;
            case 24:
                objArr[2] = "getContainingClass";
                break;
            case Build.API_LEVELS.API_25 /* 25 */:
                objArr[2] = "isAncestor";
                break;
            case Build.API_LEVELS.API_26 /* 26 */:
            case Build.API_LEVELS.API_27 /* 27 */:
                objArr[2] = "isDirectSubclass";
                break;
            case Build.API_LEVELS.API_28 /* 28 */:
            case Build.API_LEVELS.API_29 /* 29 */:
                objArr[2] = "isSubclass";
                break;
            case Build.API_LEVELS.API_30 /* 30 */:
            case Build.API_LEVELS.API_31 /* 31 */:
                objArr[2] = "isSameClass";
                break;
            case 32:
            case Build.API_LEVELS.API_33 /* 33 */:
                objArr[2] = "isSubtypeOfClass";
                break;
            case Build.API_LEVELS.API_34 /* 34 */:
                objArr[2] = "isAnonymousObject";
                break;
            case Build.API_LEVELS.API_35 /* 35 */:
                objArr[2] = "isAnonymousFunction";
                break;
            case Build.API_LEVELS.API_36 /* 36 */:
                objArr[2] = "isEnumEntry";
                break;
            case 37:
                objArr[2] = "isKindOf";
                break;
            case 38:
                objArr[2] = "hasAbstractMembers";
                break;
            case 39:
                objArr[2] = "getSuperclassDescriptors";
                break;
            case 41:
                objArr[2] = "getSuperClassType";
                break;
            case 44:
                objArr[2] = "getSuperClassDescriptor";
                break;
            case 45:
                objArr[2] = "getClassDescriptorForType";
                break;
            case 46:
                objArr[2] = "getClassDescriptorForTypeConstructor";
                break;
            case 48:
                objArr[2] = "getDefaultConstructorVisibility";
                break;
            case 54:
            case 55:
            case 56:
                objArr[2] = "getInnerClassByName";
                break;
            case 57:
                objArr[2] = "isStaticNestedClass";
                break;
            case 58:
                objArr[2] = "isTopLevelOrInnerClass";
                break;
            case 59:
                objArr[2] = "unwrapFakeOverride";
                break;
            case 61:
                objArr[2] = "unwrapSubstitutionOverride";
                break;
            case 64:
                objArr[2] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 66:
            case 67:
                objArr[2] = "shouldRecordInitializerForProperty";
                break;
            case 68:
                objArr[2] = "classCanHaveAbstractFakeOverride";
                break;
            case 69:
                objArr[2] = "classCanHaveAbstractDeclaration";
                break;
            case 70:
                objArr[2] = "classCanHaveOpenMembers";
                break;
            case 71:
                objArr[2] = "getAllOverriddenDescriptors";
                break;
            case 73:
            case 74:
                objArr[2] = "collectAllOverriddenDescriptors";
                break;
            case 75:
                objArr[2] = "getAllOverriddenDeclarations";
                break;
            case 77:
                objArr[2] = "isSingletonOrAnonymousObject";
                break;
            case 78:
                objArr[2] = "canHaveDeclaredConstructors";
                break;
            case 79:
                objArr[2] = "getJvmName";
                break;
            case 80:
                objArr[2] = "findJvmNameAnnotation";
                break;
            case 81:
                objArr[2] = "hasJvmNameAnnotation";
                break;
            case 82:
                objArr[2] = "getContainingSourceFile";
                break;
            case 85:
                objArr[2] = "getAllDescriptors";
                break;
            case 87:
            case 88:
                objArr[2] = "getFunctionByName";
                break;
            case 90:
            case 91:
                objArr[2] = "getFunctionByNameOrNull";
                break;
            case 92:
            case 93:
                objArr[2] = "getPropertyByName";
                break;
            case 95:
                objArr[2] = "getDirectMember";
                break;
            case 97:
                objArr[2] = "isMethodOfAny";
                break;
            default:
                objArr[2] = "getDispatchReceiverParameterIfNeeded";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case Build.API_LEVELS.API_22 /* 22 */:
            case 40:
            case 42:
            case 43:
            case 47:
            case PurchaseParamsValidator.MAX_NUMBER_OF_ADD_ON_PRODUCTS /* 49 */:
            case EventsManager.EVENTS_TO_CLEAR_ON_LIMIT /* 50 */:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 63:
            case 65:
            case 72:
            case 76:
            case 83:
            case 84:
            case 86:
            case 89:
            case 94:
            case 96:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static boolean b(fe.m mVar, fe.m mVar2) {
        if (mVar == null) {
            a(16);
        }
        if (mVar2 == null) {
            a(17);
        }
        return g(mVar).equals(g(mVar2));
    }

    public static void c(fe.a aVar, Set set) {
        if (aVar == null) {
            a(73);
        }
        if (set == null) {
            a(74);
        }
        if (set.contains(aVar)) {
            return;
        }
        Iterator it = aVar.a().f().iterator();
        while (it.hasNext()) {
            fe.a aVarA = ((fe.a) it.next()).a();
            c(aVarA, set);
            set.add(aVarA);
        }
    }

    public static Set d(fe.a aVar) {
        if (aVar == null) {
            a(71);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        c(aVar.a(), linkedHashSet);
        return linkedHashSet;
    }

    public static fe.e e(r0 r0Var) {
        if (r0Var == null) {
            a(45);
        }
        return f(r0Var.N0());
    }

    public static fe.e f(u1 u1Var) {
        if (u1Var == null) {
            a(46);
        }
        fe.e eVar = (fe.e) u1Var.b();
        if (eVar == null) {
            a(47);
        }
        return eVar;
    }

    public static h0 g(fe.m mVar) {
        if (mVar == null) {
            a(21);
        }
        h0 h0VarH = h(mVar);
        if (h0VarH == null) {
            a(22);
        }
        return h0VarH;
    }

    public static h0 h(fe.m mVar) {
        if (mVar == null) {
            a(23);
        }
        while (mVar != null) {
            if (mVar instanceof h0) {
                return (h0) mVar;
            }
            if (mVar instanceof u0) {
                return ((u0) mVar).u0();
            }
            mVar = mVar.b();
        }
        return null;
    }

    public static h0 i(r0 r0Var) {
        if (r0Var == null) {
            a(20);
        }
        fe.h hVarB = r0Var.N0().b();
        if (hVarB == null) {
            return null;
        }
        return h(hVarB);
    }

    public static h1 j(fe.m mVar) {
        if (mVar == null) {
            a(82);
        }
        if (mVar instanceof a1) {
            mVar = ((a1) mVar).B0();
        }
        if (mVar instanceof fe.p) {
            h1 h1VarA = ((fe.p) mVar).j().a();
            if (h1VarA == null) {
                a(83);
            }
            return h1VarA;
        }
        h1 h1Var = h1.f9484a;
        if (h1Var == null) {
            a(84);
        }
        return h1Var;
    }

    public static fe.u k(fe.e eVar, boolean z10) {
        if (eVar == null) {
            a(48);
        }
        fe.f fVarH = eVar.h();
        if (fVarH == fe.f.f9475d || fVarH.b()) {
            fe.u uVar = fe.t.f9507a;
            if (uVar == null) {
                a(49);
            }
            return uVar;
        }
        if (G(eVar)) {
            if (z10) {
                fe.u uVar2 = fe.t.f9509c;
                if (uVar2 == null) {
                    a(50);
                }
                return uVar2;
            }
            fe.u uVar3 = fe.t.f9507a;
            if (uVar3 == null) {
                a(51);
            }
            return uVar3;
        }
        if (u(eVar)) {
            fe.u uVar4 = fe.t.f9518l;
            if (uVar4 == null) {
                a(52);
            }
            return uVar4;
        }
        fe.u uVar5 = fe.t.f9511e;
        if (uVar5 == null) {
            a(53);
        }
        return uVar5;
    }

    public static b1 l(fe.m mVar) {
        if (mVar == null) {
            a(0);
        }
        if (mVar instanceof fe.e) {
            return ((fe.e) mVar).J0();
        }
        return null;
    }

    public static ef.d m(fe.m mVar) {
        if (mVar == null) {
            a(2);
        }
        ef.c cVarO = o(mVar);
        return cVarO != null ? cVarO.i() : p(mVar);
    }

    public static ef.c n(fe.m mVar) {
        if (mVar == null) {
            a(3);
        }
        ef.c cVarO = o(mVar);
        if (cVarO == null) {
            cVarO = p(mVar).m();
        }
        if (cVarO == null) {
            a(4);
        }
        return cVarO;
    }

    public static ef.c o(fe.m mVar) {
        if (mVar == null) {
            a(5);
        }
        if ((mVar instanceof h0) || zf.l.m(mVar)) {
            return ef.c.f8784d;
        }
        if (mVar instanceof u0) {
            return ((u0) mVar).e();
        }
        if (mVar instanceof n0) {
            return ((n0) mVar).e();
        }
        return null;
    }

    public static ef.d p(fe.m mVar) {
        if (mVar == null) {
            a(6);
        }
        ef.d dVarB = m(mVar.b()).b(mVar.getName());
        if (dVarB == null) {
            a(7);
        }
        return dVarB;
    }

    public static fe.m q(fe.m mVar, Class cls) {
        if (cls == null) {
            a(18);
        }
        return r(mVar, cls, true);
    }

    public static fe.m r(fe.m mVar, Class cls, boolean z10) {
        if (cls == null) {
            a(19);
        }
        if (mVar == null) {
            return null;
        }
        if (z10) {
            mVar = mVar.b();
        }
        while (mVar != null) {
            if (cls.isInstance(mVar)) {
                return mVar;
            }
            mVar = mVar.b();
        }
        return null;
    }

    public static fe.e s(fe.e eVar) {
        if (eVar == null) {
            a(44);
        }
        Iterator it = eVar.k().c().iterator();
        while (it.hasNext()) {
            fe.e eVarE = e((r0) it.next());
            if (eVarE.h() != fe.f.f9474c) {
                return eVarE;
            }
        }
        return null;
    }

    public static boolean t(fe.m mVar) {
        return D(mVar, fe.f.f9477f);
    }

    public static boolean u(fe.m mVar) {
        if (mVar == null) {
            a(34);
        }
        return v(mVar) && mVar.getName().equals(ef.h.f8801b);
    }

    public static boolean v(fe.m mVar) {
        return D(mVar, fe.f.f9473b);
    }

    public static boolean w(fe.m mVar) {
        return v(mVar) || A(mVar);
    }

    public static boolean x(fe.m mVar) {
        return D(mVar, fe.f.f9478g) && ((fe.e) mVar).y();
    }

    public static boolean y(fe.m mVar) {
        return (mVar instanceof fe.q) && ((fe.q) mVar).getVisibility() == fe.t.f9512f;
    }

    public static boolean z(fe.e eVar, fe.e eVar2) {
        if (eVar == null) {
            a(26);
        }
        if (eVar2 == null) {
            a(27);
        }
        Iterator it = eVar.k().c().iterator();
        while (it.hasNext()) {
            if (F((r0) it.next(), eVar2.a())) {
                return true;
            }
        }
        return false;
    }
}
