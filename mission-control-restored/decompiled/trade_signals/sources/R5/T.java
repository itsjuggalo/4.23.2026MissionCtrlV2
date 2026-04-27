package R5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class T {
    public static final void a(O o8, q6.c fqName, Collection packageFragments) {
        AbstractC2304t.f(o8, "<this>");
        AbstractC2304t.f(fqName, "fqName");
        AbstractC2304t.f(packageFragments, "packageFragments");
        if (o8 instanceof U) {
            ((U) o8).b(fqName, packageFragments);
        } else {
            packageFragments.addAll(o8.c(fqName));
        }
    }

    public static final boolean b(O o8, q6.c fqName) {
        AbstractC2304t.f(o8, "<this>");
        AbstractC2304t.f(fqName, "fqName");
        return o8 instanceof U ? ((U) o8).a(fqName) : c(o8, fqName).isEmpty();
    }

    public static final List c(O o8, q6.c fqName) {
        AbstractC2304t.f(o8, "<this>");
        AbstractC2304t.f(fqName, "fqName");
        ArrayList arrayList = new ArrayList();
        a(o8, fqName, arrayList);
        return arrayList;
    }
}
