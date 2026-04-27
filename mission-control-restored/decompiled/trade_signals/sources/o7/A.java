package o7;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2592n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class A {
    public static final k7.b a(String serialName, Enum[] values, String[] names, Annotation[][] entryAnnotations, Annotation[] annotationArr) {
        AbstractC2304t.f(serialName, "serialName");
        AbstractC2304t.f(values, "values");
        AbstractC2304t.f(names, "names");
        AbstractC2304t.f(entryAnnotations, "entryAnnotations");
        C2531x c2531x = new C2531x(serialName, values.length);
        if (annotationArr != null) {
            for (Annotation annotation : annotationArr) {
                c2531x.x(annotation);
            }
        }
        int length = values.length;
        int i8 = 0;
        int i9 = 0;
        while (i8 < length) {
            Enum r42 = values[i8];
            int i10 = i9 + 1;
            String strName = (String) AbstractC2592n.I(names, i9);
            if (strName == null) {
                strName = r42.name();
            }
            C2514k0.q(c2531x, strName, false, 2, null);
            Annotation[] annotationArr2 = (Annotation[]) AbstractC2592n.I(entryAnnotations, i9);
            if (annotationArr2 != null) {
                for (Annotation annotation2 : annotationArr2) {
                    c2531x.w(annotation2);
                }
            }
            i8++;
            i9 = i10;
        }
        return new C2533z(serialName, values, c2531x);
    }

    public static final k7.b b(String serialName, Enum[] values) {
        AbstractC2304t.f(serialName, "serialName");
        AbstractC2304t.f(values, "values");
        return new C2533z(serialName, values);
    }
}
