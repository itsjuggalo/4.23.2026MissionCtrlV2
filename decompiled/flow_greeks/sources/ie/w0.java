package ie;

import com.google.firebase.analytics.FirebaseAnalytics;
import fe.b1;
import fe.g1;
import fe.t1;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w0 extends n implements t1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public xf.r0 f12498e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w0(fe.m mVar, ge.h hVar, ef.f fVar, xf.r0 r0Var, g1 g1Var) {
        super(mVar, hVar, fVar, g1Var);
        if (mVar == null) {
            w(0);
        }
        if (hVar == null) {
            w(1);
        }
        if (fVar == null) {
            w(2);
        }
        if (g1Var == null) {
            w(3);
        }
        this.f12498e = r0Var;
    }

    private static /* synthetic */ void w(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                i11 = 2;
                break;
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = FirebaseAnalytics.Param.SOURCE;
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i10) {
            case 4:
                objArr[1] = "getType";
                break;
            case 5:
                objArr[1] = "getOriginal";
                break;
            case 6:
                objArr[1] = "getValueParameters";
                break;
            case 7:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 10:
                objArr[1] = "getReturnType";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public void F0(xf.r0 r0Var) {
        this.f12498e = r0Var;
    }

    @Override // fe.a
    public boolean H() {
        return false;
    }

    public b1 e0() {
        return null;
    }

    public xf.r0 getReturnType() {
        xf.r0 type = getType();
        if (type == null) {
            w(10);
        }
        return type;
    }

    @Override // fe.r1
    public xf.r0 getType() {
        xf.r0 r0Var = this.f12498e;
        if (r0Var == null) {
            w(4);
        }
        return r0Var;
    }

    public List getTypeParameters() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            w(8);
        }
        return list;
    }

    @Override // fe.a
    public List i() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            w(6);
        }
        return list;
    }

    public b1 k0() {
        return null;
    }
}
