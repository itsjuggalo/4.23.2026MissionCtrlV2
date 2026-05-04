package ie;

import com.google.firebase.analytics.FirebaseAnalytics;
import fe.g1;
import fe.q1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import qf.k;
import xf.u1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class g0 extends j {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final fe.f f12324i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f12325j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public fe.e0 f12326k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public fe.u f12327l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public u1 f12328m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List f12329n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Collection f12330o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final wf.n f12331p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(fe.m mVar, fe.f fVar, boolean z10, boolean z11, ef.f fVar2, g1 g1Var, wf.n nVar) {
        super(nVar, mVar, fVar2, g1Var, z11);
        if (mVar == null) {
            z0(0);
        }
        if (fVar == null) {
            z0(1);
        }
        if (fVar2 == null) {
            z0(2);
        }
        if (g1Var == null) {
            z0(3);
        }
        if (nVar == null) {
            z0(4);
        }
        this.f12330o = new ArrayList();
        this.f12331p = nVar;
        this.f12324i = fVar;
        this.f12325j = z10;
    }

    private static /* synthetic */ void z0(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
                i11 = 2;
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "kind";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = FirebaseAnalytics.Param.SOURCE;
                break;
            case 4:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 6:
                objArr[0] = "modality";
                break;
            case 9:
                objArr[0] = "visibility";
                break;
            case 12:
                objArr[0] = "supertype";
                break;
            case 14:
                objArr[0] = "typeParameters";
                break;
            case 16:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i10) {
            case 5:
                objArr[1] = "getAnnotations";
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 7:
                objArr[1] = "getModality";
                break;
            case 8:
                objArr[1] = "getKind";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getTypeConstructor";
                break;
            case 13:
                objArr[1] = "getConstructors";
                break;
            case 15:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                objArr[1] = "getStaticScope";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i10) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
                break;
            case 6:
                objArr[2] = "setModality";
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 12:
                objArr[2] = "addSupertype";
                break;
            case 14:
                objArr[2] = "setTypeParameterDescriptors";
                break;
            case 16:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
                throw new IllegalStateException(str2);
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
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
            z0(16);
        }
        k.b bVar = k.b.f19087b;
        if (bVar == null) {
            z0(17);
        }
        return bVar;
    }

    @Override // fe.e
    public Collection K() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            z0(19);
        }
        return list;
    }

    public void K0() {
        this.f12328m = new xf.u(this, this.f12329n, this.f12330o, this.f12331p);
        Iterator it = m().iterator();
        while (it.hasNext()) {
            ((i) ((fe.z) it.next())).g1(s());
        }
    }

    @Override // fe.e
    /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
    public Set m() {
        Set set = Collections.EMPTY_SET;
        if (set == null) {
            z0(13);
        }
        return set;
    }

    public void M0(fe.e0 e0Var) {
        if (e0Var == null) {
            z0(6);
        }
        this.f12326k = e0Var;
    }

    @Override // fe.d0
    public boolean N() {
        return false;
    }

    public void N0(List list) {
        if (list == null) {
            z0(14);
        }
        if (this.f12329n == null) {
            this.f12329n = new ArrayList(list);
            return;
        }
        throw new IllegalStateException("Type parameters are already set for " + getName());
    }

    public void O0(fe.u uVar) {
        if (uVar == null) {
            z0(9);
        }
        this.f12327l = uVar;
    }

    @Override // fe.i
    public boolean P() {
        return this.f12325j;
    }

    @Override // fe.e
    public fe.d S() {
        return null;
    }

    @Override // fe.e
    public qf.k T() {
        k.b bVar = k.b.f19087b;
        if (bVar == null) {
            z0(18);
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
            z0(5);
        }
        return hVarB;
    }

    @Override // fe.e, fe.d0, fe.q
    public fe.u getVisibility() {
        fe.u uVar = this.f12327l;
        if (uVar == null) {
            z0(10);
        }
        return uVar;
    }

    @Override // fe.e
    public fe.f h() {
        fe.f fVar = this.f12324i;
        if (fVar == null) {
            z0(8);
        }
        return fVar;
    }

    @Override // fe.e
    public boolean isInline() {
        return false;
    }

    @Override // fe.h
    public u1 k() {
        u1 u1Var = this.f12328m;
        if (u1Var == null) {
            z0(11);
        }
        return u1Var;
    }

    @Override // fe.e, fe.d0
    public fe.e0 l() {
        fe.e0 e0Var = this.f12326k;
        if (e0Var == null) {
            z0(7);
        }
        return e0Var;
    }

    @Override // fe.e
    public boolean n() {
        return false;
    }

    public String toString() {
        return m.I(this);
    }

    @Override // fe.e, fe.i
    public List v() {
        List list = this.f12329n;
        if (list == null) {
            z0(15);
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
