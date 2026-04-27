package S6;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {
    public static final boolean a(Throwable th) {
        AbstractC2304t.f(th, "<this>");
        Class<?> superclass = th.getClass();
        while (!AbstractC2304t.b(superclass.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                return false;
            }
        }
        return true;
    }

    public static final RuntimeException b(Throwable e8) throws Throwable {
        AbstractC2304t.f(e8, "e");
        throw e8;
    }
}
