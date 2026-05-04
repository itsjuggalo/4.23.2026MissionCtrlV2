package ie;

import com.google.firebase.analytics.FirebaseAnalytics;
import fe.g1;
import fe.j1;
import xf.m2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends h {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(wf.n nVar, fe.m mVar, ge.h hVar, ef.f fVar, m2 m2Var, boolean z10, int i10, g1 g1Var, j1 j1Var) {
        super(nVar, mVar, hVar, fVar, m2Var, z10, i10, g1Var, j1Var);
        if (nVar == null) {
            w(0);
        }
        if (mVar == null) {
            w(1);
        }
        if (hVar == null) {
            w(2);
        }
        if (fVar == null) {
            w(3);
        }
        if (m2Var == null) {
            w(4);
        }
        if (g1Var == null) {
            w(5);
        }
        if (j1Var == null) {
            w(6);
        }
    }

    public static /* synthetic */ void w(int i10) {
        Object[] objArr = new Object[3];
        switch (i10) {
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

    @Override // ie.m
    public String toString() {
        String str = "";
        String str2 = G() ? "reified " : "";
        if (o() != m2.f25015e) {
            str = o() + " ";
        }
        return String.format("%s%s%s", str2, str, getName());
    }
}
