package ie;

import com.google.firebase.analytics.FirebaseAnalytics;
import fe.a1;
import fe.b;
import fe.g1;
import fe.s1;
import fe.y0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import xf.c1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class m0 extends j0 implements a1 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public s1 f12405m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a1 f12406n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(y0 y0Var, ge.h hVar, fe.e0 e0Var, fe.u uVar, boolean z10, boolean z11, boolean z12, b.a aVar, a1 a1Var, g1 g1Var) {
        super(e0Var, uVar, y0Var, hVar, ef.f.o("<set-" + y0Var.getName() + ">"), z10, z11, z12, aVar, g1Var);
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
        this.f12406n = a1Var != null ? a1Var : this;
    }

    public static u0 O0(a1 a1Var, xf.r0 r0Var, ge.h hVar) {
        if (a1Var == null) {
            w(7);
        }
        if (r0Var == null) {
            w(8);
        }
        if (hVar == null) {
            w(9);
        }
        return new u0(a1Var, null, 0, hVar, ef.h.f8814o, r0Var, false, false, false, null, g1.f9483a);
    }

    private static /* synthetic */ void w(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 10:
            case 11:
            case 12:
            case 13:
                i11 = 2;
                break;
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
            case 9:
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
                objArr[0] = "parameter";
                break;
            case 7:
                objArr[0] = "setterDescriptor";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        switch (i10) {
            case 10:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 11:
                objArr[1] = "getValueParameters";
                break;
            case 12:
                objArr[1] = "getReturnType";
                break;
            case 13:
                objArr[1] = "getOriginal";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
        }
        switch (i10) {
            case 6:
                objArr[2] = "initialize";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSetterParameter";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // ie.n
    /* JADX INFO: renamed from: P0, reason: merged with bridge method [inline-methods] */
    public a1 a() {
        a1 a1Var = this.f12406n;
        if (a1Var == null) {
            w(13);
        }
        return a1Var;
    }

    public void Q0(s1 s1Var) {
        if (s1Var == null) {
            w(6);
        }
        this.f12405m = s1Var;
    }

    @Override // fe.z, fe.b, fe.a
    public Collection f() {
        Collection collectionK0 = super.K0(false);
        if (collectionK0 == null) {
            w(10);
        }
        return collectionK0;
    }

    @Override // fe.a
    public xf.r0 getReturnType() {
        c1 c1VarA0 = nf.e.m(this).a0();
        if (c1VarA0 == null) {
            w(12);
        }
        return c1VarA0;
    }

    @Override // fe.a
    public List i() {
        s1 s1Var = this.f12405m;
        if (s1Var == null) {
            throw new IllegalStateException();
        }
        List listSingletonList = Collections.singletonList(s1Var);
        if (listSingletonList == null) {
            w(11);
        }
        return listSingletonList;
    }

    @Override // fe.m
    public Object t0(fe.o oVar, Object obj) {
        return oVar.c(this, obj);
    }
}
