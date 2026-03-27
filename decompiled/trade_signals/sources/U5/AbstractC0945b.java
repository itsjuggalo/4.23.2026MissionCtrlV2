package U5;

import I6.N0;
import R5.InterfaceC0856m;
import R5.h0;
import R5.k0;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: renamed from: U5.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0945b extends AbstractC0951h {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0945b(H6.n nVar, InterfaceC0856m interfaceC0856m, S5.h hVar, q6.f fVar, N0 n02, boolean z7, int i8, h0 h0Var, k0 k0Var) {
        super(nVar, interfaceC0856m, hVar, fVar, n02, z7, i8, h0Var, k0Var);
        if (nVar == null) {
            I(0);
        }
        if (interfaceC0856m == null) {
            I(1);
        }
        if (hVar == null) {
            I(2);
        }
        if (fVar == null) {
            I(3);
        }
        if (n02 == null) {
            I(4);
        }
        if (h0Var == null) {
            I(5);
        }
        if (k0Var == null) {
            I(6);
        }
    }

    public static /* synthetic */ void I(int i8) {
        Object[] objArr = new Object[3];
        switch (i8) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = "name";
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = FirebaseAnalytics.Param.SOURCE;
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor";
        objArr[2] = "<init>";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // U5.AbstractC0956m
    public String toString() {
        String str = "";
        String str2 = F() ? "reified " : "";
        if (p() != N0.f4370e) {
            str = p() + " ";
        }
        return String.format("%s%s%s", str2, str, getName());
    }
}
