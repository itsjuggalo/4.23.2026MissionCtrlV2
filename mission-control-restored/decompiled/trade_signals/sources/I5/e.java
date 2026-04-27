package I5;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {
    public static final Object a(d dVar, Object obj) {
        AbstractC2304t.f(dVar, "<this>");
        if (dVar.s(obj)) {
            AbstractC2304t.d(obj, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.cast");
            return obj;
        }
        throw new ClassCastException("Value cannot be cast to " + dVar.q());
    }
}
