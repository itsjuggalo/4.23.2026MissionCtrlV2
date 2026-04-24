package J3;

import X2.AbstractC0765l;
import java.lang.annotation.Annotation;

/* JADX INFO: renamed from: J3.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0351y {
    public static final F3.b a(String serialName, Enum[] values, String[] names, Annotation[][] entryAnnotations, Annotation[] annotationArr) {
        kotlin.jvm.internal.r.f(serialName, "serialName");
        kotlin.jvm.internal.r.f(values, "values");
        kotlin.jvm.internal.r.f(names, "names");
        kotlin.jvm.internal.r.f(entryAnnotations, "entryAnnotations");
        C0349w c0349w = new C0349w(serialName, values.length);
        if (annotationArr != null) {
            for (Annotation annotation : annotationArr) {
                c0349w.s(annotation);
            }
        }
        int length = values.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            Enum r4 = values[i4];
            int i6 = i5 + 1;
            String strName = (String) AbstractC0765l.z(names, i5);
            if (strName == null) {
                strName = r4.name();
            }
            C0327b0.m(c0349w, strName, false, 2, null);
            Annotation[] annotationArr2 = (Annotation[]) AbstractC0765l.z(entryAnnotations, i5);
            if (annotationArr2 != null) {
                for (Annotation annotation2 : annotationArr2) {
                    c0349w.r(annotation2);
                }
            }
            i4++;
            i5 = i6;
        }
        return new C0350x(serialName, values, c0349w);
    }

    public static final F3.b b(String serialName, Enum[] values) {
        kotlin.jvm.internal.r.f(serialName, "serialName");
        kotlin.jvm.internal.r.f(values, "values");
        return new C0350x(serialName, values);
    }
}
