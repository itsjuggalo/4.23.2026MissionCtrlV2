package p5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2288c;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: p5.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2592n extends AbstractC2590l {

    /* JADX INFO: renamed from: p5.n$a */
    public static final class a implements Iterable, C5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object[] f22392a;

        public a(Object[] objArr) {
            this.f22392a = objArr;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return AbstractC2288c.a(this.f22392a);
        }
    }

    /* JADX INFO: renamed from: p5.n$b */
    public static final class b implements U6.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object[] f22393a;

        public b(Object[] objArr) {
            this.f22393a = objArr;
        }

        @Override // U6.h
        public Iterator iterator() {
            return AbstractC2288c.a(this.f22393a);
        }
    }

    public static List A(Object[] objArr) {
        AbstractC2304t.f(objArr, "<this>");
        return (List) B(objArr, new ArrayList());
    }

    public static List A0(Object[] objArr, Object[] other) {
        AbstractC2304t.f(objArr, "<this>");
        AbstractC2304t.f(other, "other");
        int iMin = Math.min(objArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i8 = 0; i8 < iMin; i8++) {
            arrayList.add(o5.w.a(objArr[i8], other[i8]));
        }
        return arrayList;
    }

    public static final Collection B(Object[] objArr, Collection destination) {
        AbstractC2304t.f(objArr, "<this>");
        AbstractC2304t.f(destination, "destination");
        for (Object obj : objArr) {
            if (obj != null) {
                destination.add(obj);
            }
        }
        return destination;
    }

    public static Object C(Object[] objArr) {
        AbstractC2304t.f(objArr, "<this>");
        if (objArr.length != 0) {
            return objArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static Object D(Object[] objArr) {
        AbstractC2304t.f(objArr, "<this>");
        if (objArr.length == 0) {
            return null;
        }
        return objArr[0];
    }

    public static H5.d E(Object[] objArr) {
        AbstractC2304t.f(objArr, "<this>");
        return new H5.d(0, G(objArr));
    }

    public static int F(long[] jArr) {
        AbstractC2304t.f(jArr, "<this>");
        return jArr.length - 1;
    }

    public static int G(Object[] objArr) {
        AbstractC2304t.f(objArr, "<this>");
        return objArr.length - 1;
    }

    public static Integer H(int[] iArr, int i8) {
        AbstractC2304t.f(iArr, "<this>");
        if (i8 < 0 || i8 >= iArr.length) {
            return null;
        }
        return Integer.valueOf(iArr[i8]);
    }

    public static Object I(Object[] objArr, int i8) {
        AbstractC2304t.f(objArr, "<this>");
        if (i8 < 0 || i8 >= objArr.length) {
            return null;
        }
        return objArr[i8];
    }

    public static final int J(byte[] bArr, byte b8) {
        AbstractC2304t.f(bArr, "<this>");
        int length = bArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            if (b8 == bArr[i8]) {
                return i8;
            }
        }
        return -1;
    }

    public static final int K(int[] iArr, int i8) {
        AbstractC2304t.f(iArr, "<this>");
        int length = iArr.length;
        for (int i9 = 0; i9 < length; i9++) {
            if (i8 == iArr[i9]) {
                return i9;
            }
        }
        return -1;
    }

    public static final int L(long[] jArr, long j8) {
        AbstractC2304t.f(jArr, "<this>");
        int length = jArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            if (j8 == jArr[i8]) {
                return i8;
            }
        }
        return -1;
    }

    public static int M(Object[] objArr, Object obj) {
        AbstractC2304t.f(objArr, "<this>");
        int i8 = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i8 < length) {
                if (objArr[i8] == null) {
                    return i8;
                }
                i8++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i8 < length2) {
            if (AbstractC2304t.b(obj, objArr[i8])) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    public static final int N(short[] sArr, short s8) {
        AbstractC2304t.f(sArr, "<this>");
        int length = sArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            if (s8 == sArr[i8]) {
                return i8;
            }
        }
        return -1;
    }

    public static final Appendable O(byte[] bArr, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i8, CharSequence truncated, B5.k kVar) throws IOException {
        AbstractC2304t.f(bArr, "<this>");
        AbstractC2304t.f(buffer, "buffer");
        AbstractC2304t.f(separator, "separator");
        AbstractC2304t.f(prefix, "prefix");
        AbstractC2304t.f(postfix, "postfix");
        AbstractC2304t.f(truncated, "truncated");
        buffer.append(prefix);
        int i9 = 0;
        for (byte b8 : bArr) {
            i9++;
            if (i9 > 1) {
                buffer.append(separator);
            }
            if (i8 >= 0 && i9 > i8) {
                break;
            }
            buffer.append(kVar != null ? (CharSequence) kVar.invoke(Byte.valueOf(b8)) : String.valueOf((int) b8));
        }
        if (i8 >= 0 && i9 > i8) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final Appendable P(Object[] objArr, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i8, CharSequence truncated, B5.k kVar) throws IOException {
        AbstractC2304t.f(objArr, "<this>");
        AbstractC2304t.f(buffer, "buffer");
        AbstractC2304t.f(separator, "separator");
        AbstractC2304t.f(prefix, "prefix");
        AbstractC2304t.f(postfix, "postfix");
        AbstractC2304t.f(truncated, "truncated");
        buffer.append(prefix);
        int i9 = 0;
        for (Object obj : objArr) {
            i9++;
            if (i9 > 1) {
                buffer.append(separator);
            }
            if (i8 >= 0 && i9 > i8) {
                break;
            }
            V6.q.a(buffer, obj, kVar);
        }
        if (i8 >= 0 && i9 > i8) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final String R(byte[] bArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i8, CharSequence truncated, B5.k kVar) {
        AbstractC2304t.f(bArr, "<this>");
        AbstractC2304t.f(separator, "separator");
        AbstractC2304t.f(prefix, "prefix");
        AbstractC2304t.f(postfix, "postfix");
        AbstractC2304t.f(truncated, "truncated");
        return ((StringBuilder) O(bArr, new StringBuilder(), separator, prefix, postfix, i8, truncated, kVar)).toString();
    }

    public static final String S(Object[] objArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i8, CharSequence truncated, B5.k kVar) {
        AbstractC2304t.f(objArr, "<this>");
        AbstractC2304t.f(separator, "separator");
        AbstractC2304t.f(prefix, "prefix");
        AbstractC2304t.f(postfix, "postfix");
        AbstractC2304t.f(truncated, "truncated");
        return ((StringBuilder) P(objArr, new StringBuilder(), separator, prefix, postfix, i8, truncated, kVar)).toString();
    }

    public static /* synthetic */ String T(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i8, CharSequence charSequence4, B5.k kVar, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i9 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i9 & 4) == 0 ? charSequence3 : "";
        if ((i9 & 8) != 0) {
            i8 = -1;
        }
        int i10 = i8;
        if ((i9 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i9 & 32) != 0) {
            kVar = null;
        }
        return R(bArr, charSequence, charSequence5, charSequence6, i10, charSequence7, kVar);
    }

    public static /* synthetic */ String U(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i8, CharSequence charSequence4, B5.k kVar, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i9 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i9 & 4) == 0 ? charSequence3 : "";
        if ((i9 & 8) != 0) {
            i8 = -1;
        }
        int i10 = i8;
        if ((i9 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i9 & 32) != 0) {
            kVar = null;
        }
        return S(objArr, charSequence, charSequence5, charSequence6, i10, charSequence7, kVar);
    }

    public static Object V(Object[] objArr) {
        AbstractC2304t.f(objArr, "<this>");
        if (objArr.length != 0) {
            return objArr[G(objArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int W(int[] iArr, int i8) {
        AbstractC2304t.f(iArr, "<this>");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i9 = length - 1;
                if (i8 == iArr[length]) {
                    return length;
                }
                if (i9 < 0) {
                    break;
                }
                length = i9;
            }
        }
        return -1;
    }

    public static char X(char[] cArr) {
        AbstractC2304t.f(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static Object Y(Object[] objArr) {
        AbstractC2304t.f(objArr, "<this>");
        int length = objArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return objArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static Object Z(Object[] objArr) {
        AbstractC2304t.f(objArr, "<this>");
        if (objArr.length == 1) {
            return objArr[0];
        }
        return null;
    }

    public static final Object[] a0(Object[] objArr, Comparator comparator) {
        AbstractC2304t.f(objArr, "<this>");
        AbstractC2304t.f(comparator, "comparator");
        if (objArr.length == 0) {
            return objArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        AbstractC2304t.e(objArrCopyOf, "copyOf(...)");
        AbstractC2590l.q(objArrCopyOf, comparator);
        return objArrCopyOf;
    }

    public static List b0(Object[] objArr, Comparator comparator) {
        AbstractC2304t.f(objArr, "<this>");
        AbstractC2304t.f(comparator, "comparator");
        return AbstractC2590l.d(a0(objArr, comparator));
    }

    public static final List c0(Object[] objArr, int i8) {
        AbstractC2304t.f(objArr, "<this>");
        if (i8 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i8 + " is less than zero.").toString());
        }
        if (i8 == 0) {
            return AbstractC2595q.i();
        }
        int length = objArr.length;
        if (i8 >= length) {
            return k0(objArr);
        }
        if (i8 == 1) {
            return AbstractC2594p.e(objArr[length - 1]);
        }
        ArrayList arrayList = new ArrayList(i8);
        for (int i9 = length - i8; i9 < length; i9++) {
            arrayList.add(objArr[i9]);
        }
        return arrayList;
    }

    public static Collection d0(Object[] objArr, Collection destination) {
        AbstractC2304t.f(objArr, "<this>");
        AbstractC2304t.f(destination, "destination");
        for (Object obj : objArr) {
            destination.add(obj);
        }
        return destination;
    }

    public static List e0(byte[] bArr) {
        AbstractC2304t.f(bArr, "<this>");
        int length = bArr.length;
        return length != 0 ? length != 1 ? n0(bArr) : AbstractC2594p.e(Byte.valueOf(bArr[0])) : AbstractC2595q.i();
    }

    public static List f0(char[] cArr) {
        AbstractC2304t.f(cArr, "<this>");
        int length = cArr.length;
        return length != 0 ? length != 1 ? o0(cArr) : AbstractC2594p.e(Character.valueOf(cArr[0])) : AbstractC2595q.i();
    }

    public static List g0(double[] dArr) {
        AbstractC2304t.f(dArr, "<this>");
        int length = dArr.length;
        return length != 0 ? length != 1 ? p0(dArr) : AbstractC2594p.e(Double.valueOf(dArr[0])) : AbstractC2595q.i();
    }

    public static List h0(float[] fArr) {
        AbstractC2304t.f(fArr, "<this>");
        int length = fArr.length;
        return length != 0 ? length != 1 ? q0(fArr) : AbstractC2594p.e(Float.valueOf(fArr[0])) : AbstractC2595q.i();
    }

    public static List i0(int[] iArr) {
        AbstractC2304t.f(iArr, "<this>");
        int length = iArr.length;
        return length != 0 ? length != 1 ? r0(iArr) : AbstractC2594p.e(Integer.valueOf(iArr[0])) : AbstractC2595q.i();
    }

    public static List j0(long[] jArr) {
        AbstractC2304t.f(jArr, "<this>");
        int length = jArr.length;
        return length != 0 ? length != 1 ? s0(jArr) : AbstractC2594p.e(Long.valueOf(jArr[0])) : AbstractC2595q.i();
    }

    public static List k0(Object[] objArr) {
        AbstractC2304t.f(objArr, "<this>");
        int length = objArr.length;
        return length != 0 ? length != 1 ? t0(objArr) : AbstractC2594p.e(objArr[0]) : AbstractC2595q.i();
    }

    public static List l0(short[] sArr) {
        AbstractC2304t.f(sArr, "<this>");
        int length = sArr.length;
        return length != 0 ? length != 1 ? u0(sArr) : AbstractC2594p.e(Short.valueOf(sArr[0])) : AbstractC2595q.i();
    }

    public static List m0(boolean[] zArr) {
        AbstractC2304t.f(zArr, "<this>");
        int length = zArr.length;
        return length != 0 ? length != 1 ? v0(zArr) : AbstractC2594p.e(Boolean.valueOf(zArr[0])) : AbstractC2595q.i();
    }

    public static final List n0(byte[] bArr) {
        AbstractC2304t.f(bArr, "<this>");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b8 : bArr) {
            arrayList.add(Byte.valueOf(b8));
        }
        return arrayList;
    }

    public static final List o0(char[] cArr) {
        AbstractC2304t.f(cArr, "<this>");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c8 : cArr) {
            arrayList.add(Character.valueOf(c8));
        }
        return arrayList;
    }

    public static final List p0(double[] dArr) {
        AbstractC2304t.f(dArr, "<this>");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d8 : dArr) {
            arrayList.add(Double.valueOf(d8));
        }
        return arrayList;
    }

    public static final List q0(float[] fArr) {
        AbstractC2304t.f(fArr, "<this>");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f8 : fArr) {
            arrayList.add(Float.valueOf(f8));
        }
        return arrayList;
    }

    public static final List r0(int[] iArr) {
        AbstractC2304t.f(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i8 : iArr) {
            arrayList.add(Integer.valueOf(i8));
        }
        return arrayList;
    }

    public static Iterable s(Object[] objArr) {
        AbstractC2304t.f(objArr, "<this>");
        return objArr.length == 0 ? AbstractC2595q.i() : new a(objArr);
    }

    public static final List s0(long[] jArr) {
        AbstractC2304t.f(jArr, "<this>");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j8 : jArr) {
            arrayList.add(Long.valueOf(j8));
        }
        return arrayList;
    }

    public static U6.h t(Object[] objArr) {
        AbstractC2304t.f(objArr, "<this>");
        return objArr.length == 0 ? U6.o.g() : new b(objArr);
    }

    public static final List t0(Object[] objArr) {
        AbstractC2304t.f(objArr, "<this>");
        return new ArrayList(AbstractC2595q.h(objArr));
    }

    public static boolean u(byte[] bArr, byte b8) {
        AbstractC2304t.f(bArr, "<this>");
        return J(bArr, b8) >= 0;
    }

    public static final List u0(short[] sArr) {
        AbstractC2304t.f(sArr, "<this>");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s8 : sArr) {
            arrayList.add(Short.valueOf(s8));
        }
        return arrayList;
    }

    public static boolean v(int[] iArr, int i8) {
        AbstractC2304t.f(iArr, "<this>");
        return K(iArr, i8) >= 0;
    }

    public static final List v0(boolean[] zArr) {
        AbstractC2304t.f(zArr, "<this>");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z7 : zArr) {
            arrayList.add(Boolean.valueOf(z7));
        }
        return arrayList;
    }

    public static boolean w(long[] jArr, long j8) {
        AbstractC2304t.f(jArr, "<this>");
        return L(jArr, j8) >= 0;
    }

    public static Set w0(Object[] objArr) {
        AbstractC2304t.f(objArr, "<this>");
        int length = objArr.length;
        return length != 0 ? length != 1 ? (Set) d0(objArr, new LinkedHashSet(L.d(objArr.length))) : Q.c(objArr[0]) : S.d();
    }

    public static boolean x(Object[] objArr, Object obj) {
        AbstractC2304t.f(objArr, "<this>");
        return M(objArr, obj) >= 0;
    }

    public static Iterable x0(final Object[] objArr) {
        AbstractC2304t.f(objArr, "<this>");
        return new C2578G(new Function0() { // from class: p5.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AbstractC2592n.y0(objArr);
            }
        });
    }

    public static boolean y(short[] sArr, short s8) {
        AbstractC2304t.f(sArr, "<this>");
        return N(sArr, s8) >= 0;
    }

    public static final Iterator y0(Object[] objArr) {
        return AbstractC2288c.a(objArr);
    }

    public static List z(Object[] objArr, int i8) {
        AbstractC2304t.f(objArr, "<this>");
        if (i8 >= 0) {
            return c0(objArr, H5.i.b(objArr.length - i8, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i8 + " is less than zero.").toString());
    }

    public static List z0(Object[] objArr, Iterable other) {
        AbstractC2304t.f(objArr, "<this>");
        AbstractC2304t.f(other, "other");
        int length = objArr.length;
        ArrayList arrayList = new ArrayList(Math.min(r.s(other, 10), length));
        int i8 = 0;
        for (Object obj : other) {
            if (i8 >= length) {
                break;
            }
            arrayList.add(o5.w.a(objArr[i8], obj));
            i8++;
        }
        return arrayList;
    }
}
