package X2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: renamed from: X2.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0763j extends AbstractC0762i {
    public static List c(Object[] objArr) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        List listA = AbstractC0766m.a(objArr);
        kotlin.jvm.internal.r.e(listA, "asList(...)");
        return listA;
    }

    public static byte[] d(byte[] bArr, byte[] destination, int i4, int i5, int i6) {
        kotlin.jvm.internal.r.f(bArr, "<this>");
        kotlin.jvm.internal.r.f(destination, "destination");
        System.arraycopy(bArr, i5, destination, i4, i6 - i5);
        return destination;
    }

    public static final Object[] e(Object[] objArr, Object[] destination, int i4, int i5, int i6) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        kotlin.jvm.internal.r.f(destination, "destination");
        System.arraycopy(objArr, i5, destination, i4, i6 - i5);
        return destination;
    }

    public static /* synthetic */ byte[] f(byte[] bArr, byte[] bArr2, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i4 = 0;
        }
        if ((i7 & 4) != 0) {
            i5 = 0;
        }
        if ((i7 & 8) != 0) {
            i6 = bArr.length;
        }
        return d(bArr, bArr2, i4, i5, i6);
    }

    public static /* synthetic */ Object[] g(Object[] objArr, Object[] objArr2, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i4 = 0;
        }
        if ((i7 & 4) != 0) {
            i5 = 0;
        }
        if ((i7 & 8) != 0) {
            i6 = objArr.length;
        }
        return e(objArr, objArr2, i4, i5, i6);
    }

    public static byte[] h(byte[] bArr, int i4, int i5) {
        kotlin.jvm.internal.r.f(bArr, "<this>");
        AbstractC0761h.b(i5, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i4, i5);
        kotlin.jvm.internal.r.e(bArrCopyOfRange, "copyOfRange(...)");
        return bArrCopyOfRange;
    }

    public static Object[] i(Object[] objArr, int i4, int i5) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        AbstractC0761h.b(i5, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i4, i5);
        kotlin.jvm.internal.r.e(objArrCopyOfRange, "copyOfRange(...)");
        return objArrCopyOfRange;
    }

    public static final void j(Object[] objArr, Object obj, int i4, int i5) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        Arrays.fill(objArr, i4, i5, obj);
    }

    public static byte[] k(byte[] bArr, byte[] elements) {
        kotlin.jvm.internal.r.f(bArr, "<this>");
        kotlin.jvm.internal.r.f(elements, "elements");
        int length = bArr.length;
        int length2 = elements.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(elements, 0, bArrCopyOf, length, length2);
        kotlin.jvm.internal.r.c(bArrCopyOf);
        return bArrCopyOf;
    }

    public static final void l(Object[] objArr, Comparator comparator) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        kotlin.jvm.internal.r.f(comparator, "comparator");
        if (objArr.length > 1) {
            Arrays.sort(objArr, comparator);
        }
    }
}
