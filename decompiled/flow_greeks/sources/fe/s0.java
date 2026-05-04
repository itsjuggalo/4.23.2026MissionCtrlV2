package fe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s0 {
    public static final void a(o0 o0Var, ef.c fqName, Collection packageFragments) {
        kotlin.jvm.internal.t.f(o0Var, "<this>");
        kotlin.jvm.internal.t.f(fqName, "fqName");
        kotlin.jvm.internal.t.f(packageFragments, "packageFragments");
        if (o0Var instanceof t0) {
            ((t0) o0Var).b(fqName, packageFragments);
        } else {
            packageFragments.addAll(o0Var.c(fqName));
        }
    }

    public static final boolean b(o0 o0Var, ef.c fqName) {
        kotlin.jvm.internal.t.f(o0Var, "<this>");
        kotlin.jvm.internal.t.f(fqName, "fqName");
        return o0Var instanceof t0 ? ((t0) o0Var).a(fqName) : c(o0Var, fqName).isEmpty();
    }

    public static final List c(o0 o0Var, ef.c fqName) {
        kotlin.jvm.internal.t.f(o0Var, "<this>");
        kotlin.jvm.internal.t.f(fqName, "fqName");
        ArrayList arrayList = new ArrayList();
        a(o0Var, fqName, arrayList);
        return arrayList;
    }
}
