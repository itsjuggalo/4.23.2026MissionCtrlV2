package U5;

import R5.InterfaceC0856m;
import R5.InterfaceC0857n;
import R5.InterfaceC0859p;
import R5.h0;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: renamed from: U5.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0957n extends AbstractC0956m implements InterfaceC0857n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC0856m f8337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h0 f8338d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0957n(InterfaceC0856m interfaceC0856m, S5.h hVar, q6.f fVar, h0 h0Var) {
        super(hVar, fVar);
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
        this.f8337c = interfaceC0856m;
        this.f8338d = h0Var;
    }

    private static /* synthetic */ void I(int i8) {
        String str = (i8 == 4 || i8 == 5 || i8 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i8 == 4 || i8 == 5 || i8 == 6) ? 2 : 3];
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
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i8 == 4) {
            objArr[1] = "getOriginal";
        } else if (i8 == 5) {
            objArr[1] = "getContainingDeclaration";
        } else if (i8 != 6) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i8 != 4 && i8 != 5 && i8 != 6) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i8 != 4 && i8 != 5 && i8 != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // U5.AbstractC0956m, R5.InterfaceC0856m
    /* JADX INFO: renamed from: C0, reason: merged with bridge method [inline-methods] */
    public InterfaceC0859p a() {
        InterfaceC0859p interfaceC0859p = (InterfaceC0859p) super.a();
        if (interfaceC0859p == null) {
            I(4);
        }
        return interfaceC0859p;
    }

    public InterfaceC0856m b() {
        InterfaceC0856m interfaceC0856m = this.f8337c;
        if (interfaceC0856m == null) {
            I(5);
        }
        return interfaceC0856m;
    }

    public h0 j() {
        h0 h0Var = this.f8338d;
        if (h0Var == null) {
            I(6);
        }
        return h0Var;
    }
}
