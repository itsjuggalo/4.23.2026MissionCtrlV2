package dd;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l extends k {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends d implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f8015b;

        public a(int[] iArr) {
            this.f8015b = iArr;
        }

        @Override // dd.b
        public int c() {
            return this.f8015b.length;
        }

        @Override // dd.b, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Integer) {
                return f(((Number) obj).intValue());
            }
            return false;
        }

        public boolean f(int i10) {
            return n.v(this.f8015b, i10);
        }

        @Override // dd.d, java.util.List
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Integer get(int i10) {
            return Integer.valueOf(this.f8015b[i10]);
        }

        @Override // dd.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return p(((Number) obj).intValue());
            }
            return -1;
        }

        @Override // dd.b, java.util.Collection
        public boolean isEmpty() {
            return this.f8015b.length == 0;
        }

        @Override // dd.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return q(((Number) obj).intValue());
            }
            return -1;
        }

        public int p(int i10) {
            return n.K(this.f8015b, i10);
        }

        public int q(int i10) {
            return n.l0(this.f8015b, i10);
        }
    }

    public static List c(int[] iArr) {
        kotlin.jvm.internal.t.f(iArr, "<this>");
        return new a(iArr);
    }

    public static List d(Object[] objArr) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        List listA = o.a(objArr);
        kotlin.jvm.internal.t.e(listA, "asList(...)");
        return listA;
    }

    public static byte[] e(byte[] bArr, byte[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.t.f(bArr, "<this>");
        kotlin.jvm.internal.t.f(destination, "destination");
        System.arraycopy(bArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    public static int[] f(int[] iArr, int[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.t.f(iArr, "<this>");
        kotlin.jvm.internal.t.f(destination, "destination");
        System.arraycopy(iArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    public static long[] g(long[] jArr, long[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.t.f(jArr, "<this>");
        kotlin.jvm.internal.t.f(destination, "destination");
        System.arraycopy(jArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    public static Object[] h(Object[] objArr, Object[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        kotlin.jvm.internal.t.f(destination, "destination");
        System.arraycopy(objArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    public static /* synthetic */ byte[] i(byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = bArr.length;
        }
        return e(bArr, bArr2, i10, i11, i12);
    }

    public static /* synthetic */ int[] j(int[] iArr, int[] iArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = iArr.length;
        }
        return f(iArr, iArr2, i10, i11, i12);
    }

    public static /* synthetic */ Object[] k(Object[] objArr, Object[] objArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = objArr.length;
        }
        return h(objArr, objArr2, i10, i11, i12);
    }

    public static byte[] l(byte[] bArr, int i10, int i11) {
        kotlin.jvm.internal.t.f(bArr, "<this>");
        j.b(i11, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i10, i11);
        kotlin.jvm.internal.t.e(bArrCopyOfRange, "copyOfRange(...)");
        return bArrCopyOfRange;
    }

    public static Object[] m(Object[] objArr, int i10, int i11) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        j.b(i11, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i10, i11);
        kotlin.jvm.internal.t.e(objArrCopyOfRange, "copyOfRange(...)");
        return objArrCopyOfRange;
    }

    public static final void n(Object[] objArr, Object obj, int i10, int i11) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        Arrays.fill(objArr, i10, i11, obj);
    }

    public static byte[] o(byte[] bArr, byte[] elements) {
        kotlin.jvm.internal.t.f(bArr, "<this>");
        kotlin.jvm.internal.t.f(elements, "elements");
        int length = bArr.length;
        int length2 = elements.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(elements, 0, bArrCopyOf, length, length2);
        kotlin.jvm.internal.t.c(bArrCopyOf);
        return bArrCopyOf;
    }

    public static final void p(Object[] objArr) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        if (objArr.length > 1) {
            Arrays.sort(objArr);
        }
    }

    public static final void q(Object[] objArr, Comparator comparator) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        kotlin.jvm.internal.t.f(comparator, "comparator");
        if (objArr.length > 1) {
            Arrays.sort(objArr, comparator);
        }
    }
}
