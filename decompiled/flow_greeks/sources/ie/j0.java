package ie;

import com.google.firebase.analytics.FirebaseAnalytics;
import fe.a;
import fe.b;
import fe.b1;
import fe.g1;
import fe.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import xf.f2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j0 extends n implements fe.x0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f12355e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f12356f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final fe.e0 f12357g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final y0 f12358h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f12359i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b.a f12360j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public fe.u f12361k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public fe.z f12362l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(fe.e0 e0Var, fe.u uVar, y0 y0Var, ge.h hVar, ef.f fVar, boolean z10, boolean z11, boolean z12, b.a aVar, g1 g1Var) {
        super(y0Var.b(), hVar, fVar, g1Var);
        if (e0Var == null) {
            w(0);
        }
        if (uVar == null) {
            w(1);
        }
        if (y0Var == null) {
            w(2);
        }
        if (hVar == null) {
            w(3);
        }
        if (fVar == null) {
            w(4);
        }
        if (g1Var == null) {
            w(5);
        }
        this.f12362l = null;
        this.f12357g = e0Var;
        this.f12361k = uVar;
        this.f12358h = y0Var;
        this.f12355e = z10;
        this.f12356f = z11;
        this.f12359i = z12;
        this.f12360j = aVar;
    }

    private static /* synthetic */ void w(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 7:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                i11 = 2;
                break;
            case 7:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "visibility";
                break;
            case 2:
                objArr[0] = "correspondingProperty";
                break;
            case 3:
                objArr[0] = "annotations";
                break;
            case 4:
                objArr[0] = "name";
                break;
            case 5:
                objArr[0] = FirebaseAnalytics.Param.SOURCE;
                break;
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 7:
                objArr[0] = "substitutor";
                break;
            case 16:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "modality";
                break;
        }
        switch (i10) {
            case 6:
                objArr[1] = "getKind";
                break;
            case 7:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 8:
                objArr[1] = "substitute";
                break;
            case 9:
                objArr[1] = "getTypeParameters";
                break;
            case 10:
                objArr[1] = "getModality";
                break;
            case 11:
                objArr[1] = "getVisibility";
                break;
            case 12:
                objArr[1] = "getCorrespondingVariable";
                break;
            case 13:
                objArr[1] = "getCorrespondingProperty";
                break;
            case 14:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 15:
                objArr[1] = "getOverriddenDescriptors";
                break;
        }
        switch (i10) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                break;
            case 7:
                objArr[2] = "substitute";
                break;
            case 16:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                throw new IllegalStateException(str2);
            case 7:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // fe.x0
    public y0 B0() {
        y0 y0Var = this.f12358h;
        if (y0Var == null) {
            w(13);
        }
        return y0Var;
    }

    @Override // fe.z
    public boolean C0() {
        return false;
    }

    @Override // fe.d0
    public boolean E0() {
        return false;
    }

    @Override // fe.b
    /* JADX INFO: renamed from: F0, reason: merged with bridge method [inline-methods] */
    public fe.x0 L(fe.m mVar, fe.e0 e0Var, fe.u uVar, b.a aVar, boolean z10) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @Override // fe.a
    public boolean H() {
        return false;
    }

    public Collection K0(boolean z10) {
        ArrayList arrayList = new ArrayList(0);
        for (y0 y0Var : B0().f()) {
            ge.a aVarD = z10 ? y0Var.d() : y0Var.g();
            if (aVarD != null) {
                arrayList.add(aVarD);
            }
        }
        return arrayList;
    }

    public void L0(boolean z10) {
        this.f12355e = z10;
    }

    public void M0(fe.z zVar) {
        this.f12362l = zVar;
    }

    @Override // fe.d0
    public boolean N() {
        return false;
    }

    public void N0(fe.u uVar) {
        this.f12361k = uVar;
    }

    @Override // fe.z
    public boolean R() {
        return false;
    }

    @Override // fe.x0
    public boolean W() {
        return this.f12355e;
    }

    @Override // fe.i1
    public fe.z c(f2 f2Var) {
        if (f2Var == null) {
            w(7);
        }
        return this;
    }

    @Override // fe.z
    public fe.z d0() {
        return this.f12362l;
    }

    @Override // fe.a
    public b1 e0() {
        return B0().e0();
    }

    @Override // fe.a
    public List getTypeParameters() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            w(9);
        }
        return list;
    }

    @Override // fe.q
    public fe.u getVisibility() {
        fe.u uVar = this.f12361k;
        if (uVar == null) {
            w(11);
        }
        return uVar;
    }

    @Override // fe.b
    public b.a h() {
        b.a aVar = this.f12360j;
        if (aVar == null) {
            w(6);
        }
        return aVar;
    }

    @Override // fe.d0
    public boolean isExternal() {
        return this.f12356f;
    }

    @Override // fe.z
    public boolean isInfix() {
        return false;
    }

    @Override // fe.z
    public boolean isInline() {
        return this.f12359i;
    }

    @Override // fe.z
    public boolean isOperator() {
        return false;
    }

    @Override // fe.z
    public boolean isSuspend() {
        return false;
    }

    @Override // fe.a
    public b1 k0() {
        return B0().k0();
    }

    @Override // fe.d0
    public fe.e0 l() {
        fe.e0 e0Var = this.f12357g;
        if (e0Var == null) {
            w(10);
        }
        return e0Var;
    }

    @Override // fe.a
    public List p0() {
        List listP0 = B0().p0();
        if (listP0 == null) {
            w(14);
        }
        return listP0;
    }

    @Override // fe.z
    public boolean v0() {
        return false;
    }

    @Override // fe.b
    public void w0(Collection collection) {
        if (collection == null) {
            w(16);
        }
    }

    @Override // fe.a
    public Object z(a.InterfaceC0175a interfaceC0175a) {
        return null;
    }
}
