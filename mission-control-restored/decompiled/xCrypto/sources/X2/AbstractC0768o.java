package X2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: X2.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0768o {
    public static final Object[] a(Object[] objArr, boolean z4) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        if (z4 && kotlin.jvm.internal.r.b(objArr.getClass(), Object[].class)) {
            return objArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length, Object[].class);
        kotlin.jvm.internal.r.e(objArrCopyOf, "copyOf(...)");
        return objArrCopyOf;
    }

    public static List b(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        kotlin.jvm.internal.r.e(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    public static List c(Iterable iterable) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        List listI0 = x.i0(iterable);
        Collections.shuffle(listI0);
        return listI0;
    }

    public static final Object[] d(int i4, Object[] array) {
        kotlin.jvm.internal.r.f(array, "array");
        if (i4 < array.length) {
            array[i4] = null;
        }
        return array;
    }
}
