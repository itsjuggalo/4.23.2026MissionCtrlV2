package U5;

import R5.InterfaceC0856m;
import R5.c0;
import R5.h0;
import R5.u0;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class X extends AbstractC0957n implements u0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public I6.S f8288e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X(InterfaceC0856m interfaceC0856m, S5.h hVar, q6.f fVar, I6.S s8, h0 h0Var) {
        super(interfaceC0856m, hVar, fVar, h0Var);
        if (interfaceC0856m == null) {
            I(0);
        }
        if (hVar == null) {
            I(1);
        }
        if (fVar == null) {
            I(2);
        }
        if (h0Var == null) {
            I(3);
        }
        this.f8288e = s8;
    }

    private static /* synthetic */ void I(int i8) {
        String str;
        int i9;
        switch (i8) {
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
        switch (i8) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                i9 = 2;
                break;
            default:
                i9 = 3;
                break;
        }
        Object[] objArr = new Object[i9];
        switch (i8) {
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
        switch (i8) {
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
        switch (i8) {
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
        switch (i8) {
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

    @Override // R5.InterfaceC0844a
    public boolean G() {
        return false;
    }

    public void H0(I6.S s8) {
        this.f8288e = s8;
    }

    public c0 g0() {
        return null;
    }

    public I6.S getReturnType() {
        I6.S type = getType();
        if (type == null) {
            I(10);
        }
        return type;
    }

    @Override // R5.s0
    public I6.S getType() {
        I6.S s8 = this.f8288e;
        if (s8 == null) {
            I(4);
        }
        return s8;
    }

    public List getTypeParameters() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            I(8);
        }
        return listEmptyList;
    }

    @Override // R5.InterfaceC0844a
    public List k() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            I(6);
        }
        return listEmptyList;
    }

    public c0 l0() {
        return null;
    }
}
