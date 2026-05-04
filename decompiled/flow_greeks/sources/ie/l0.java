package ie;

import com.google.firebase.analytics.FirebaseAnalytics;
import fe.b;
import fe.g1;
import fe.y0;
import fe.z0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class l0 extends j0 implements z0 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public xf.r0 f12402m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final z0 f12403n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(y0 y0Var, ge.h hVar, fe.e0 e0Var, fe.u uVar, boolean z10, boolean z11, boolean z12, b.a aVar, z0 z0Var, g1 g1Var) {
        super(e0Var, uVar, y0Var, hVar, ef.f.o("<get-" + y0Var.getName() + ">"), z10, z11, z12, aVar, g1Var);
        if (y0Var == null) {
            w(0);
        }
        if (hVar == null) {
            w(1);
        }
        if (e0Var == null) {
            w(2);
        }
        if (uVar == null) {
            w(3);
        }
        if (aVar == null) {
            w(4);
        }
        if (g1Var == null) {
            w(5);
        }
        this.f12403n = z0Var != null ? z0Var : this;
    }

    private static /* synthetic */ void w(int i10) {
        String str = (i10 == 6 || i10 == 7 || i10 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 6 || i10 == 7 || i10 == 8) ? 2 : 3];
        switch (i10) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "visibility";
                break;
            case 4:
                objArr[0] = "kind";
                break;
            case 5:
                objArr[0] = FirebaseAnalytics.Param.SOURCE;
                break;
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        if (i10 == 6) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i10 == 7) {
            objArr[1] = "getValueParameters";
        } else if (i10 != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i10 != 6 && i10 != 7 && i10 != 8) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i10 != 6 && i10 != 7 && i10 != 8) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // ie.n
    /* JADX INFO: renamed from: O0, reason: merged with bridge method [inline-methods] */
    public z0 a() {
        z0 z0Var = this.f12403n;
        if (z0Var == null) {
            w(8);
        }
        return z0Var;
    }

    public void P0(xf.r0 r0Var) {
        if (r0Var == null) {
            r0Var = B0().getType();
        }
        this.f12402m = r0Var;
    }

    @Override // fe.z, fe.b, fe.a
    public Collection f() {
        Collection collectionK0 = super.K0(true);
        if (collectionK0 == null) {
            w(6);
        }
        return collectionK0;
    }

    @Override // fe.a
    public xf.r0 getReturnType() {
        return this.f12402m;
    }

    @Override // fe.a
    public List i() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            w(7);
        }
        return list;
    }

    @Override // fe.m
    public Object t0(fe.o oVar, Object obj) {
        return oVar.k(this, obj);
    }
}
