package p5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: p5.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2590l extends AbstractC2589k {

    /* JADX INFO: renamed from: p5.l$a */
    public static final class a extends AbstractC2582d implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f22390b;

        public a(int[] iArr) {
            this.f22390b = iArr;
        }

        public int C(int i8) {
            return AbstractC2592n.W(this.f22390b, i8);
        }

        @Override // p5.AbstractC2580b, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Integer) {
                return f(((Number) obj).intValue());
            }
            return false;
        }

        @Override // p5.AbstractC2580b
        public int d() {
            return this.f22390b.length;
        }

        public boolean f(int i8) {
            return AbstractC2592n.v(this.f22390b, i8);
        }

        @Override // p5.AbstractC2582d, java.util.List
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Integer get(int i8) {
            return Integer.valueOf(this.f22390b[i8]);
        }

        @Override // p5.AbstractC2582d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return n(((Number) obj).intValue());
            }
            return -1;
        }

        @Override // p5.AbstractC2580b, java.util.Collection
        public boolean isEmpty() {
            return this.f22390b.length == 0;
        }

        @Override // p5.AbstractC2582d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return C(((Number) obj).intValue());
            }
            return -1;
        }

        public int n(int i8) {
            return AbstractC2592n.K(this.f22390b, i8);
        }
    }

    public static List c(int[] iArr) {
        AbstractC2304t.f(iArr, "<this>");
        return new a(iArr);
    }

    public static List d(Object[] objArr) {
        AbstractC2304t.f(objArr, "<this>");
        List listA = AbstractC2593o.a(objArr);
        AbstractC2304t.e(listA, "asList(...)");
        return listA;
    }

    public static byte[] e(byte[] bArr, byte[] destination, int i8, int i9, int i10) {
        AbstractC2304t.f(bArr, "<this>");
        AbstractC2304t.f(destination, "destination");
        System.arraycopy(bArr, i9, destination, i8, i10 - i9);
        return destination;
    }

    public static int[] f(int[] iArr, int[] destination, int i8, int i9, int i10) {
        AbstractC2304t.f(iArr, "<this>");
        AbstractC2304t.f(destination, "destination");
        System.arraycopy(iArr, i9, destination, i8, i10 - i9);
        return destination;
    }

    public static long[] g(long[] jArr, long[] destination, int i8, int i9, int i10) {
        AbstractC2304t.f(jArr, "<this>");
        AbstractC2304t.f(destination, "destination");
        System.arraycopy(jArr, i9, destination, i8, i10 - i9);
        return destination;
    }

    public static Object[] h(Object[] objArr, Object[] destination, int i8, int i9, int i10) {
        AbstractC2304t.f(objArr, "<this>");
        AbstractC2304t.f(destination, "destination");
        System.arraycopy(objArr, i9, destination, i8, i10 - i9);
        return destination;
    }

    public static /* synthetic */ byte[] i(byte[] bArr, byte[] bArr2, int i8, int i9, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i8 = 0;
        }
        if ((i11 & 4) != 0) {
            i9 = 0;
        }
        if ((i11 & 8) != 0) {
            i10 = bArr.length;
        }
        return e(bArr, bArr2, i8, i9, i10);
    }

    public static /* synthetic */ int[] j(int[] iArr, int[] iArr2, int i8, int i9, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i8 = 0;
        }
        if ((i11 & 4) != 0) {
            i9 = 0;
        }
        if ((i11 & 8) != 0) {
            i10 = iArr.length;
        }
        return f(iArr, iArr2, i8, i9, i10);
    }

    public static /* synthetic */ Object[] k(Object[] objArr, Object[] objArr2, int i8, int i9, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i8 = 0;
        }
        if ((i11 & 4) != 0) {
            i9 = 0;
        }
        if ((i11 & 8) != 0) {
            i10 = objArr.length;
        }
        return h(objArr, objArr2, i8, i9, i10);
    }

    public static byte[] l(byte[] bArr, int i8, int i9) {
        AbstractC2304t.f(bArr, "<this>");
        AbstractC2588j.b(i9, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i8, i9);
        AbstractC2304t.e(bArrCopyOfRange, "copyOfRange(...)");
        return bArrCopyOfRange;
    }

    public static Object[] m(Object[] objArr, int i8, int i9) {
        AbstractC2304t.f(objArr, "<this>");
        AbstractC2588j.b(i9, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i8, i9);
        AbstractC2304t.e(objArrCopyOfRange, "copyOfRange(...)");
        return objArrCopyOfRange;
    }

    public static final void n(Object[] objArr, Object obj, int i8, int i9) {
        AbstractC2304t.f(objArr, "<this>");
        Arrays.fill(objArr, i8, i9, obj);
    }

    public static byte[] o(byte[] bArr, byte[] elements) {
        AbstractC2304t.f(bArr, "<this>");
        AbstractC2304t.f(elements, "elements");
        int length = bArr.length;
        int length2 = elements.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(elements, 0, bArrCopyOf, length, length2);
        AbstractC2304t.c(bArrCopyOf);
        return bArrCopyOf;
    }

    public static final void p(Object[] objArr) {
        AbstractC2304t.f(objArr, "<this>");
        if (objArr.length > 1) {
            Arrays.sort(objArr);
        }
    }

    public static final void q(Object[] objArr, Comparator comparator) {
        AbstractC2304t.f(objArr, "<this>");
        AbstractC2304t.f(comparator, "comparator");
        if (objArr.length > 1) {
            Arrays.sort(objArr, comparator);
        }
    }
}
