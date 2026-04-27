package F5;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: F5.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0555m {
    public static final Object[] a(Object[] objArr, boolean z7) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        if (z7 && kotlin.jvm.internal.r.b(objArr.getClass(), Object[].class)) {
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
        List listJ0 = v.j0(iterable);
        Collections.shuffle(listJ0);
        return listJ0;
    }

    public static final Object[] d(int i7, Object[] array) {
        kotlin.jvm.internal.r.f(array, "array");
        if (i7 < array.length) {
            array[i7] = null;
        }
        return array;
    }
}
