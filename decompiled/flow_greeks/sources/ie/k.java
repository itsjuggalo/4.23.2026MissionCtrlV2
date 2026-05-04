package ie;

import com.google.firebase.analytics.FirebaseAnalytics;
import fe.g1;
import fe.q1;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import qf.k;
import xf.u1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class k extends j {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final fe.e0 f12363i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final fe.f f12364j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final u1 f12365k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public qf.k f12366l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Set f12367m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public fe.d f12368n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(fe.m mVar, ef.f fVar, fe.e0 e0Var, fe.f fVar2, Collection collection, g1 g1Var, boolean z10, wf.n nVar) {
        super(nVar, mVar, fVar, g1Var, z10);
        if (mVar == null) {
            z0(0);
        }
        if (fVar == null) {
            z0(1);
        }
        if (e0Var == null) {
            z0(2);
        }
        if (fVar2 == null) {
            z0(3);
        }
        if (collection == null) {
            z0(4);
        }
        if (g1Var == null) {
            z0(5);
        }
        if (nVar == null) {
            z0(6);
        }
        this.f12363i = e0Var;
        this.f12364j = fVar2;
        this.f12365k = new xf.u(this, Collections.EMPTY_LIST, collection, nVar);
    }

    private static /* synthetic */ void z0(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
                i11 = 2;
                break;
            case 12:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "supertypes";
                break;
            case 5:
                objArr[0] = FirebaseAnalytics.Param.SOURCE;
                break;
            case 6:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "unsubstitutedMemberScope";
                break;
            case 8:
                objArr[0] = "constructors";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 12:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i10) {
            case 9:
                objArr[1] = "getAnnotations";
                break;
            case 10:
                objArr[1] = "getTypeConstructor";
                break;
            case 11:
                objArr[1] = "getConstructors";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 13:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 14:
                objArr[1] = "getStaticScope";
                break;
            case 15:
                objArr[1] = "getKind";
                break;
            case 16:
                objArr[1] = "getModality";
                break;
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                objArr[1] = "getVisibility";
                break;
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i10) {
            case 7:
            case 8:
                objArr[2] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
                break;
            case 12:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
                throw new IllegalStateException(str2);
            case 12:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // fe.e
    public boolean E() {
        return false;
    }

    @Override // fe.d0
    public boolean E0() {
        return false;
    }

    @Override // fe.e
    public boolean H0() {
        return false;
    }

    @Override // ie.z
    public qf.k I(yf.g gVar) {
        if (gVar == null) {
            z0(12);
        }
        qf.k kVar = this.f12366l;
        if (kVar == null) {
            z0(13);
        }
        return kVar;
    }

    @Override // fe.e
    public Collection K() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            z0(19);
        }
        return list;
    }

    public final void K0(qf.k kVar, Set set, fe.d dVar) {
        if (kVar == null) {
            z0(7);
        }
        if (set == null) {
            z0(8);
        }
        this.f12366l = kVar;
        this.f12367m = set;
        this.f12368n = dVar;
    }

    @Override // fe.d0
    public boolean N() {
        return false;
    }

    @Override // fe.i
    public boolean P() {
        return false;
    }

    @Override // fe.e
    public fe.d S() {
        return this.f12368n;
    }

    @Override // fe.e
    public qf.k T() {
        k.b bVar = k.b.f19087b;
        if (bVar == null) {
            z0(14);
        }
        return bVar;
    }

    @Override // fe.e
    public fe.e V() {
        return null;
    }

    @Override // ge.a
    public ge.h getAnnotations() {
        ge.h hVarB = ge.h.L.b();
        if (hVarB == null) {
            z0(9);
        }
        return hVarB;
    }

    @Override // fe.e, fe.d0, fe.q
    public fe.u getVisibility() {
        fe.u uVar = fe.t.f9511e;
        if (uVar == null) {
            z0(17);
        }
        return uVar;
    }

    @Override // fe.e
    public fe.f h() {
        fe.f fVar = this.f12364j;
        if (fVar == null) {
            z0(15);
        }
        return fVar;
    }

    @Override // fe.e
    public boolean isInline() {
        return false;
    }

    @Override // fe.h
    public u1 k() {
        u1 u1Var = this.f12365k;
        if (u1Var == null) {
            z0(10);
        }
        return u1Var;
    }

    @Override // fe.e, fe.d0
    public fe.e0 l() {
        fe.e0 e0Var = this.f12363i;
        if (e0Var == null) {
            z0(16);
        }
        return e0Var;
    }

    @Override // fe.e
    public Collection m() {
        Set set = this.f12367m;
        if (set == null) {
            z0(11);
        }
        return set;
    }

    @Override // fe.e
    public boolean n() {
        return false;
    }

    public String toString() {
        return "class " + getName();
    }

    @Override // fe.e, fe.i
    public List v() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            z0(18);
        }
        return list;
    }

    @Override // fe.e
    public boolean y() {
        return false;
    }

    @Override // fe.e
    public q1 y0() {
        return null;
    }
}
