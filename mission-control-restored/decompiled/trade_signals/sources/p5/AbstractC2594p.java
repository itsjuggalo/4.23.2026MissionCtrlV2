package p5;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import q5.C2635b;

/* JADX INFO: renamed from: p5.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2594p {
    public static List a(List builder) {
        AbstractC2304t.f(builder, "builder");
        return ((C2635b) builder).M();
    }

    public static final Object[] b(Object[] objArr, boolean z7) {
        AbstractC2304t.f(objArr, "<this>");
        if (z7 && AbstractC2304t.b(objArr.getClass(), Object[].class)) {
            return objArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length, Object[].class);
        AbstractC2304t.e(objArrCopyOf, "copyOf(...)");
        return objArrCopyOf;
    }

    public static List c() {
        return new C2635b(0, 1, null);
    }

    public static List d(int i8) {
        return new C2635b(i8);
    }

    public static List e(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        AbstractC2304t.e(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    public static Object[] f(int i8, Object[] array) {
        AbstractC2304t.f(array, "array");
        if (i8 < array.length) {
            array[i8] = null;
        }
        return array;
    }
}
