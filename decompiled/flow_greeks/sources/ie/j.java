package ie;

import com.google.firebase.analytics.FirebaseAnalytics;
import fe.g1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j extends a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final fe.m f12352f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g1 f12353g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f12354h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(wf.n nVar, fe.m mVar, ef.f fVar, g1 g1Var, boolean z10) {
        super(nVar, fVar);
        if (nVar == null) {
            z0(0);
        }
        if (mVar == null) {
            z0(1);
        }
        if (fVar == null) {
            z0(2);
        }
        if (g1Var == null) {
            z0(3);
        }
        this.f12352f = mVar;
        this.f12353g = g1Var;
        this.f12354h = z10;
    }

    private static /* synthetic */ void z0(int i10) {
        String str = (i10 == 4 || i10 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 4 || i10 == 5) ? 2 : 3];
        if (i10 == 1) {
            objArr[0] = "containingDeclaration";
        } else if (i10 == 2) {
            objArr[0] = "name";
        } else if (i10 == 3) {
            objArr[0] = FirebaseAnalytics.Param.SOURCE;
        } else if (i10 == 4 || i10 == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[0] = "storageManager";
        }
        if (i10 == 4) {
            objArr[1] = "getContainingDeclaration";
        } else if (i10 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[1] = "getSource";
        }
        if (i10 != 4 && i10 != 5) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i10 != 4 && i10 != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // fe.e, fe.n, fe.m
    public fe.m b() {
        fe.m mVar = this.f12352f;
        if (mVar == null) {
            z0(4);
        }
        return mVar;
    }

    public boolean isExternal() {
        return this.f12354h;
    }

    @Override // fe.p
    public g1 j() {
        g1 g1Var = this.f12353g;
        if (g1Var == null) {
            z0(5);
        }
        return g1Var;
    }
}
