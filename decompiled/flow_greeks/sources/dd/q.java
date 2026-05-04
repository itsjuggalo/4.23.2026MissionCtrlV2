package dd;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q {
    public static List a(List builder) {
        kotlin.jvm.internal.t.f(builder, "builder");
        return ((ed.b) builder).A();
    }

    public static final Object[] b(Object[] objArr, boolean z10) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        if (z10 && kotlin.jvm.internal.t.b(objArr.getClass(), Object[].class)) {
            return objArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length, Object[].class);
        kotlin.jvm.internal.t.e(objArrCopyOf, "copyOf(...)");
        return objArrCopyOf;
    }

    public static List c() {
        return new ed.b(0, 1, null);
    }

    public static List d(int i10) {
        return new ed.b(i10);
    }

    public static List e(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        kotlin.jvm.internal.t.e(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    public static List f(Iterable iterable) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        List listK0 = a0.K0(iterable);
        Collections.shuffle(listK0);
        return listK0;
    }

    public static Object[] g(int i10, Object[] array) {
        kotlin.jvm.internal.t.f(array, "array");
        if (i10 < array.length) {
            array[i10] = null;
        }
        return array;
    }
}
