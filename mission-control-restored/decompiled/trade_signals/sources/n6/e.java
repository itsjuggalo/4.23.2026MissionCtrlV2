package n6;

import kotlin.jvm.internal.AbstractC2304t;
import s6.AbstractC2722i;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {
    public static final Object a(AbstractC2722i.d dVar, AbstractC2722i.f extension) {
        AbstractC2304t.f(dVar, "<this>");
        AbstractC2304t.f(extension, "extension");
        if (dVar.y(extension)) {
            return dVar.v(extension);
        }
        return null;
    }

    public static final Object b(AbstractC2722i.d dVar, AbstractC2722i.f extension, int i8) {
        AbstractC2304t.f(dVar, "<this>");
        AbstractC2304t.f(extension, "extension");
        if (i8 < dVar.x(extension)) {
            return dVar.w(extension, i8);
        }
        return null;
    }
}
