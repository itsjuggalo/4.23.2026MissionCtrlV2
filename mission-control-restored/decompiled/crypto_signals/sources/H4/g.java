package H4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import t2.u0;

/* JADX INFO: loaded from: classes.dex */
public abstract class g extends u0 {
    public static List c0(Object[] objArr) {
        kotlin.jvm.internal.j.e(objArr, "<this>");
        List listAsList = Arrays.asList(objArr);
        kotlin.jvm.internal.j.d(listAsList, "asList(...)");
        return listAsList;
    }

    public static boolean d0(Object[] objArr, Object obj) {
        int i;
        kotlin.jvm.internal.j.e(objArr, "<this>");
        if (obj == null) {
            int length = objArr.length;
            i = 0;
            while (i < length) {
                if (objArr[i] == null) {
                    break;
                }
                i++;
            }
            i = -1;
        } else {
            int length2 = objArr.length;
            for (int i6 = 0; i6 < length2; i6++) {
                if (obj.equals(objArr[i6])) {
                    i = i6;
                    break;
                }
            }
            i = -1;
        }
        return i >= 0;
    }

    public static void e0(byte[] bArr, int i, byte[] destination, int i6, int i7) {
        kotlin.jvm.internal.j.e(bArr, "<this>");
        kotlin.jvm.internal.j.e(destination, "destination");
        System.arraycopy(bArr, i6, destination, i, i7 - i6);
    }

    public static final void f0(Object[] objArr, int i, Object[] destination, int i6, int i7) {
        kotlin.jvm.internal.j.e(objArr, "<this>");
        kotlin.jvm.internal.j.e(destination, "destination");
        System.arraycopy(objArr, i6, destination, i, i7 - i6);
    }

    public static final void g0(Object[] objArr, int i, int i6) {
        kotlin.jvm.internal.j.e(objArr, "<this>");
        Arrays.fill(objArr, i, i6, (Object) null);
    }

    public static Object h0(Object[] objArr) {
        kotlin.jvm.internal.j.e(objArr, "<this>");
        if (objArr.length != 0) {
            return objArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static String i0(Object[] objArr) {
        kotlin.jvm.internal.j.e(objArr, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "[");
        int i = 0;
        for (Object obj : objArr) {
            i++;
            if (i > 1) {
                sb.append((CharSequence) ",");
            }
            android.support.v4.media.session.a.a(sb, obj, null);
        }
        sb.append((CharSequence) "]");
        return sb.toString();
    }

    public static List j0(long[] jArr) {
        kotlin.jvm.internal.j.e(jArr, "<this>");
        int length = jArr.length;
        if (length == 0) {
            return p.f577a;
        }
        if (length == 1) {
            return y5.a.D(Long.valueOf(jArr[0]));
        }
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j4 : jArr) {
            arrayList.add(Long.valueOf(j4));
        }
        return arrayList;
    }

    public static List k0(Object[] objArr) {
        kotlin.jvm.internal.j.e(objArr, "<this>");
        int length = objArr.length;
        return length != 0 ? length != 1 ? new ArrayList(new e(objArr, false)) : y5.a.D(objArr[0]) : p.f577a;
    }
}
