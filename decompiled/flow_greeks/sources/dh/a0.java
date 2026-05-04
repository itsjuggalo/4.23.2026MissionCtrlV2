package dh;

import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a0 {
    public static final zg.b a(String serialName, Enum[] values, String[] names, Annotation[][] entryAnnotations, Annotation[] annotationArr) {
        kotlin.jvm.internal.t.f(serialName, "serialName");
        kotlin.jvm.internal.t.f(values, "values");
        kotlin.jvm.internal.t.f(names, "names");
        kotlin.jvm.internal.t.f(entryAnnotations, "entryAnnotations");
        x xVar = new x(serialName, values.length);
        if (annotationArr != null) {
            for (Annotation annotation : annotationArr) {
                xVar.x(annotation);
            }
        }
        int length = values.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            Enum r42 = values[i10];
            int i12 = i11 + 1;
            String strName = (String) dd.n.I(names, i11);
            if (strName == null) {
                strName = r42.name();
            }
            j1.q(xVar, strName, false, 2, null);
            Annotation[] annotationArr2 = (Annotation[]) dd.n.I(entryAnnotations, i11);
            if (annotationArr2 != null) {
                for (Annotation annotation2 : annotationArr2) {
                    xVar.w(annotation2);
                }
            }
            i10++;
            i11 = i12;
        }
        return new z(serialName, values, xVar);
    }

    public static final zg.b b(String serialName, Enum[] values) {
        kotlin.jvm.internal.t.f(serialName, "serialName");
        kotlin.jvm.internal.t.f(values, "values");
        return new z(serialName, values);
    }
}
