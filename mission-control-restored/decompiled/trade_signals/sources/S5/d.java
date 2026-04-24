package S5;

import I6.S;
import R5.h0;
import S5.c;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f7642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f7643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h0 f7644c;

    public d(S s8, Map map, h0 h0Var) {
        if (s8 == null) {
            b(0);
        }
        if (map == null) {
            b(1);
        }
        if (h0Var == null) {
            b(2);
        }
        this.f7642a = s8;
        this.f7643b = map;
        this.f7644c = h0Var;
    }

    public static /* synthetic */ void b(int i8) {
        String str = (i8 == 3 || i8 == 4 || i8 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i8 == 3 || i8 == 4 || i8 == 5) ? 2 : 3];
        if (i8 == 1) {
            objArr[0] = "valueArguments";
        } else if (i8 == 2) {
            objArr[0] = FirebaseAnalytics.Param.SOURCE;
        } else if (i8 == 3 || i8 == 4 || i8 == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[0] = "annotationType";
        }
        if (i8 == 3) {
            objArr[1] = "getType";
        } else if (i8 == 4) {
            objArr[1] = "getAllValueArguments";
        } else if (i8 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i8 != 3 && i8 != 4 && i8 != 5) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i8 != 3 && i8 != 4 && i8 != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // S5.c
    public Map a() {
        Map map = this.f7643b;
        if (map == null) {
            b(4);
        }
        return map;
    }

    @Override // S5.c
    public q6.c e() {
        return c.a.a(this);
    }

    @Override // S5.c
    public S getType() {
        S s8 = this.f7642a;
        if (s8 == null) {
            b(3);
        }
        return s8;
    }

    @Override // S5.c
    public h0 j() {
        h0 h0Var = this.f7644c;
        if (h0Var == null) {
            b(5);
        }
        return h0Var;
    }

    public String toString() {
        return t6.n.f23386h.N(this, null);
    }
}
