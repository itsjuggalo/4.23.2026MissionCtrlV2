package r6;

import F5.AbstractC0552j;
import java.lang.annotation.Annotation;

/* JADX INFO: renamed from: r6.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2637y {
    public static final n6.b a(String serialName, Enum[] values, String[] names, Annotation[][] entryAnnotations, Annotation[] annotationArr) {
        kotlin.jvm.internal.r.f(serialName, "serialName");
        kotlin.jvm.internal.r.f(values, "values");
        kotlin.jvm.internal.r.f(names, "names");
        kotlin.jvm.internal.r.f(entryAnnotations, "entryAnnotations");
        C2635w c2635w = new C2635w(serialName, values.length);
        if (annotationArr != null) {
            for (Annotation annotation : annotationArr) {
                c2635w.s(annotation);
            }
        }
        int length = values.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            Enum r42 = values[i7];
            int i9 = i8 + 1;
            String strName = (String) AbstractC0552j.y(names, i8);
            if (strName == null) {
                strName = r42.name();
            }
            C2613b0.m(c2635w, strName, false, 2, null);
            Annotation[] annotationArr2 = (Annotation[]) AbstractC0552j.y(entryAnnotations, i8);
            if (annotationArr2 != null) {
                for (Annotation annotation2 : annotationArr2) {
                    c2635w.r(annotation2);
                }
            }
            i7++;
            i8 = i9;
        }
        return new C2636x(serialName, values, c2635w);
    }

    public static final n6.b b(String serialName, Enum[] values) {
        kotlin.jvm.internal.r.f(serialName, "serialName");
        kotlin.jvm.internal.r.f(values, "values");
        return new C2636x(serialName, values);
    }
}
