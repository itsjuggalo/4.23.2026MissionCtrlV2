package X5;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k {
    public static final C0991g a(Annotation[] annotationArr, q6.c fqName) {
        Annotation annotation;
        AbstractC2304t.f(annotationArr, "<this>");
        AbstractC2304t.f(fqName, "fqName");
        int length = annotationArr.length;
        int i8 = 0;
        while (true) {
            if (i8 >= length) {
                annotation = null;
                break;
            }
            annotation = annotationArr[i8];
            if (AbstractC2304t.b(AbstractC0990f.e(A5.a.b(A5.a.a(annotation))).a(), fqName)) {
                break;
            }
            i8++;
        }
        if (annotation != null) {
            return new C0991g(annotation);
        }
        return null;
    }

    public static final List b(Annotation[] annotationArr) {
        AbstractC2304t.f(annotationArr, "<this>");
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation annotation : annotationArr) {
            arrayList.add(new C0991g(annotation));
        }
        return arrayList;
    }
}
