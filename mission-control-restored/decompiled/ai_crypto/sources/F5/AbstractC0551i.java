package F5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: renamed from: F5.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0551i extends AbstractC0550h {
    public static List c(Object[] objArr) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        List listA = AbstractC0553k.a(objArr);
        kotlin.jvm.internal.r.e(listA, "asList(...)");
        return listA;
    }

    public static byte[] d(byte[] bArr, byte[] destination, int i7, int i8, int i9) {
        kotlin.jvm.internal.r.f(bArr, "<this>");
        kotlin.jvm.internal.r.f(destination, "destination");
        System.arraycopy(bArr, i8, destination, i7, i9 - i8);
        return destination;
    }

    public static final Object[] e(Object[] objArr, Object[] destination, int i7, int i8, int i9) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        kotlin.jvm.internal.r.f(destination, "destination");
        System.arraycopy(objArr, i8, destination, i7, i9 - i8);
        return destination;
    }

    public static /* synthetic */ byte[] f(byte[] bArr, byte[] bArr2, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i7 = 0;
        }
        if ((i10 & 4) != 0) {
            i8 = 0;
        }
        if ((i10 & 8) != 0) {
            i9 = bArr.length;
        }
        return d(bArr, bArr2, i7, i8, i9);
    }

    public static /* synthetic */ Object[] g(Object[] objArr, Object[] objArr2, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i7 = 0;
        }
        if ((i10 & 4) != 0) {
            i8 = 0;
        }
        if ((i10 & 8) != 0) {
            i9 = objArr.length;
        }
        return e(objArr, objArr2, i7, i8, i9);
    }

    public static byte[] h(byte[] bArr, int i7, int i8) {
        kotlin.jvm.internal.r.f(bArr, "<this>");
        AbstractC0549g.b(i8, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i7, i8);
        kotlin.jvm.internal.r.e(bArrCopyOfRange, "copyOfRange(...)");
        return bArrCopyOfRange;
    }

    public static Object[] i(Object[] objArr, int i7, int i8) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        AbstractC0549g.b(i8, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i7, i8);
        kotlin.jvm.internal.r.e(objArrCopyOfRange, "copyOfRange(...)");
        return objArrCopyOfRange;
    }

    public static final void j(Object[] objArr, Object obj, int i7, int i8) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        Arrays.fill(objArr, i7, i8, obj);
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
