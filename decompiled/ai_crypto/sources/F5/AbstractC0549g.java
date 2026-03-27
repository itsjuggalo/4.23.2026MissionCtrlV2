package F5;

import java.lang.reflect.Array;

/* JADX INFO: renamed from: F5.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0549g {
    public static final Object[] a(Object[] reference, int i7) {
        kotlin.jvm.internal.r.f(reference, "reference");
        Object objNewInstance = Array.newInstance(reference.getClass().getComponentType(), i7);
        kotlin.jvm.internal.r.d(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (Object[]) objNewInstance;
    }

    public static final void b(int i7, int i8) {
        if (i7 <= i8) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i7 + ") is greater than size (" + i8 + ").");
    }
}
