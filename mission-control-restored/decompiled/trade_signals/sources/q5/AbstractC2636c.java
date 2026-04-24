package q5;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: q5.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2636c {
    public static final Object[] d(int i8) {
        if (i8 >= 0) {
            return new Object[i8];
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    public static final Object[] e(Object[] objArr, int i8) {
        AbstractC2304t.f(objArr, "<this>");
        Object[] objArrCopyOf = Arrays.copyOf(objArr, i8);
        AbstractC2304t.e(objArrCopyOf, "copyOf(...)");
        return objArrCopyOf;
    }

    public static final void f(Object[] objArr, int i8) {
        AbstractC2304t.f(objArr, "<this>");
        objArr[i8] = null;
    }

    public static final void g(Object[] objArr, int i8, int i9) {
        AbstractC2304t.f(objArr, "<this>");
        while (i8 < i9) {
            f(objArr, i8);
            i8++;
        }
    }

    public static final boolean h(Object[] objArr, int i8, int i9, List list) {
        if (i9 != list.size()) {
            return false;
        }
        for (int i10 = 0; i10 < i9; i10++) {
            if (!AbstractC2304t.b(objArr[i8 + i10], list.get(i10))) {
                return false;
            }
        }
        return true;
    }

    public static final int i(Object[] objArr, int i8, int i9) {
        int iHashCode = 1;
        for (int i10 = 0; i10 < i9; i10++) {
            Object obj = objArr[i8 + i10];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public static final String j(Object[] objArr, int i8, int i9, Collection collection) {
        StringBuilder sb = new StringBuilder((i9 * 3) + 2);
        sb.append("[");
        for (int i10 = 0; i10 < i9; i10++) {
            if (i10 > 0) {
                sb.append(", ");
            }
            Object obj = objArr[i8 + i10];
            if (obj == collection) {
                sb.append("(this Collection)");
            } else {
                sb.append(obj);
            }
        }
        sb.append("]");
        String string = sb.toString();
        AbstractC2304t.e(string, "toString(...)");
        return string;
    }
}
