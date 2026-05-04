package le;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k {
    public static final g a(Annotation[] annotationArr, ef.c fqName) {
        Annotation annotation;
        kotlin.jvm.internal.t.f(annotationArr, "<this>");
        kotlin.jvm.internal.t.f(fqName, "fqName");
        int length = annotationArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                annotation = null;
                break;
            }
            annotation = annotationArr[i10];
            if (kotlin.jvm.internal.t.b(f.e(od.a.b(od.a.a(annotation))).a(), fqName)) {
                break;
            }
            i10++;
        }
        if (annotation != null) {
            return new g(annotation);
        }
        return null;
    }

    public static final List b(Annotation[] annotationArr) {
        kotlin.jvm.internal.t.f(annotationArr, "<this>");
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation annotation : annotationArr) {
            arrayList.add(new g(annotation));
        }
        return arrayList;
    }
}
