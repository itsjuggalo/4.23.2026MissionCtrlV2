package ie;

import com.google.firebase.analytics.FirebaseAnalytics;
import fe.g1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n extends m implements fe.n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fe.m f12407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g1 f12408d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(fe.m mVar, ge.h hVar, ef.f fVar, g1 g1Var) {
        super(hVar, fVar);
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
        this.f12407c = mVar;
        this.f12408d = g1Var;
    }

    private static /* synthetic */ void w(int i10) {
        String str = (i10 == 4 || i10 == 5 || i10 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 4 || i10 == 5 || i10 == 6) ? 2 : 3];
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
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i10 == 4) {
            objArr[1] = "getOriginal";
        } else if (i10 == 5) {
            objArr[1] = "getContainingDeclaration";
        } else if (i10 != 6) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i10 != 4 && i10 != 5 && i10 != 6) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i10 != 4 && i10 != 5 && i10 != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public fe.m b() {
        fe.m mVar = this.f12407c;
        if (mVar == null) {
            w(5);
        }
        return mVar;
    }

    public g1 j() {
        g1 g1Var = this.f12408d;
        if (g1Var == null) {
            w(6);
        }
        return g1Var;
    }

    @Override // ie.m, fe.m
    /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
    public fe.p a() {
        fe.p pVar = (fe.p) super.a();
        if (pVar == null) {
            w(4);
        }
        return pVar;
    }
}
