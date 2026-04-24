package X2;

import java.lang.reflect.Array;

/* JADX INFO: renamed from: X2.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0761h {
    public static final Object[] a(Object[] reference, int i4) {
        kotlin.jvm.internal.r.f(reference, "reference");
        Object objNewInstance = Array.newInstance(reference.getClass().getComponentType(), i4);
        kotlin.jvm.internal.r.d(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (Object[]) objNewInstance;
    }

    public static final void b(int i4, int i5) {
        if (i4 <= i5) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i4 + ") is greater than size (" + i5 + ").");
    }
}
