package ge;

import com.google.firebase.analytics.FirebaseAnalytics;
import fe.g1;
import ge.c;
import java.util.Map;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r0 f10536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f10537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g1 f10538c;

    public d(r0 r0Var, Map map, g1 g1Var) {
        if (r0Var == null) {
            b(0);
        }
        if (map == null) {
            b(1);
        }
        if (g1Var == null) {
            b(2);
        }
        this.f10536a = r0Var;
        this.f10537b = map;
        this.f10538c = g1Var;
    }

    public static /* synthetic */ void b(int i10) {
        String str = (i10 == 3 || i10 == 4 || i10 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 3 || i10 == 4 || i10 == 5) ? 2 : 3];
        if (i10 == 1) {
            objArr[0] = "valueArguments";
        } else if (i10 == 2) {
            objArr[0] = FirebaseAnalytics.Param.SOURCE;
        } else if (i10 == 3 || i10 == 4 || i10 == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[0] = "annotationType";
        }
        if (i10 == 3) {
            objArr[1] = "getType";
        } else if (i10 == 4) {
            objArr[1] = "getAllValueArguments";
        } else if (i10 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i10 != 3 && i10 != 4 && i10 != 5) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i10 != 3 && i10 != 4 && i10 != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // ge.c
    public Map a() {
        Map map = this.f10537b;
        if (map == null) {
            b(4);
        }
        return map;
    }

    @Override // ge.c
    public ef.c e() {
        return c.a.a(this);
    }

    @Override // ge.c
    public r0 getType() {
        r0 r0Var = this.f10536a;
        if (r0Var == null) {
            b(3);
        }
        return r0Var;
    }

    @Override // ge.c
    public g1 j() {
        g1 g1Var = this.f10538c;
        if (g1Var == null) {
            b(5);
        }
        return g1Var;
    }

    public String toString() {
        return hf.n.f11354h.N(this, null);
    }
}
