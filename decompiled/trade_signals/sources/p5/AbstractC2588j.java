package p5;

import java.lang.reflect.Array;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: p5.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2588j {
    public static final Object[] a(Object[] reference, int i8) {
        AbstractC2304t.f(reference, "reference");
        Object objNewInstance = Array.newInstance(reference.getClass().getComponentType(), i8);
        AbstractC2304t.d(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (Object[]) objNewInstance;
    }

    public static final void b(int i8, int i9) {
        if (i8 <= i9) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i8 + ") is greater than size (" + i9 + ").");
    }
}
