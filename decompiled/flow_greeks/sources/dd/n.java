package dd;

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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n extends l {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Iterable, qd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object[] f8017a;

        public a(Object[] objArr) {
            this.f8017a = objArr;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return kotlin.jvm.internal.c.a(this.f8017a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements jg.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object[] f8018a;

        public b(Object[] objArr) {
            this.f8018a = objArr;
        }

        @Override // jg.h
        public Iterator iterator() {
            return kotlin.jvm.internal.c.a(this.f8018a);
        }
    }

    public static List A(Object[] objArr) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        return (List) B(objArr, new ArrayList());
    }

    public static List A0(short[] sArr) {
        kotlin.jvm.internal.t.f(sArr, "<this>");
        int length = sArr.length;
        return length != 0 ? length != 1 ? J0(sArr) : q.e(Short.valueOf(sArr[0])) : r.k();
    }

    public static final Collection B(Object[] objArr, Collection destination) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        kotlin.jvm.internal.t.f(destination, "destination");
        for (Object obj : objArr) {
            if (obj != null) {
                destination.add(obj);
            }
        }
        return destination;
    }

    public static List B0(boolean[] zArr) {
        kotlin.jvm.internal.t.f(zArr, "<this>");
        int length = zArr.length;
        return length != 0 ? length != 1 ? K0(zArr) : q.e(Boolean.valueOf(zArr[0])) : r.k();
    }

    public static Object C(Object[] objArr) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        if (objArr.length != 0) {
            return objArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final List C0(byte[] bArr) {
        kotlin.jvm.internal.t.f(bArr, "<this>");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b10 : bArr) {
            arrayList.add(Byte.valueOf(b10));
        }
        return arrayList;
    }

    public static Object D(Object[] objArr) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        if (objArr.length == 0) {
            return null;
        }
        return objArr[0];
    }

    public static final List D0(char[] cArr) {
        kotlin.jvm.internal.t.f(cArr, "<this>");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c10 : cArr) {
            arrayList.add(Character.valueOf(c10));
        }
        return arrayList;
    }

    public static vd.g E(Object[] objArr) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        return new vd.g(0, G(objArr));
    }

    public static final List E0(double[] dArr) {
        kotlin.jvm.internal.t.f(dArr, "<this>");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d10 : dArr) {
            arrayList.add(Double.valueOf(d10));
        }
        return arrayList;
    }

    public static int F(long[] jArr) {
        kotlin.jvm.internal.t.f(jArr, "<this>");
        return jArr.length - 1;
    }

    public static final List F0(float[] fArr) {
        kotlin.jvm.internal.t.f(fArr, "<this>");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f10 : fArr) {
            arrayList.add(Float.valueOf(f10));
        }
        return arrayList;
    }

    public static int G(Object[] objArr) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        return objArr.length - 1;
    }

    public static final List G0(int[] iArr) {
        kotlin.jvm.internal.t.f(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i10 : iArr) {
            arrayList.add(Integer.valueOf(i10));
        }
        return arrayList;
    }

    public static Integer H(int[] iArr, int i10) {
        kotlin.jvm.internal.t.f(iArr, "<this>");
        if (i10 < 0 || i10 >= iArr.length) {
            return null;
        }
        return Integer.valueOf(iArr[i10]);
    }

    public static final List H0(long[] jArr) {
        kotlin.jvm.internal.t.f(jArr, "<this>");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j10 : jArr) {
            arrayList.add(Long.valueOf(j10));
        }
        return arrayList;
    }

    public static Object I(Object[] objArr, int i10) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        if (i10 < 0 || i10 >= objArr.length) {
            return null;
        }
        return objArr[i10];
    }

    public static final List I0(Object[] objArr) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        return new ArrayList(r.j(objArr, false, 1, null));
    }

    public static final int J(byte[] bArr, byte b10) {
        kotlin.jvm.internal.t.f(bArr, "<this>");
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (b10 == bArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    public static final List J0(short[] sArr) {
        kotlin.jvm.internal.t.f(sArr, "<this>");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s10 : sArr) {
            arrayList.add(Short.valueOf(s10));
        }
        return arrayList;
    }

    public static final int K(int[] iArr, int i10) {
        kotlin.jvm.internal.t.f(iArr, "<this>");
        int length = iArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (i10 == iArr[i11]) {
                return i11;
            }
        }
        return -1;
    }

    public static final List K0(boolean[] zArr) {
        kotlin.jvm.internal.t.f(zArr, "<this>");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z10 : zArr) {
            arrayList.add(Boolean.valueOf(z10));
        }
        return arrayList;
    }

    public static final int L(long[] jArr, long j10) {
        kotlin.jvm.internal.t.f(jArr, "<this>");
        int length = jArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (j10 == jArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    public static Set L0(Object[] objArr) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        int length = objArr.length;
        return length != 0 ? length != 1 ? (Set) s0(objArr, new LinkedHashSet(n0.d(objArr.length))) : t0.c(objArr[0]) : u0.d();
    }

    public static int M(Object[] objArr, Object obj) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        int i10 = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i10 < length) {
                if (objArr[i10] == null) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i10 < length2) {
            if (kotlin.jvm.internal.t.b(obj, objArr[i10])) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static Iterable M0(final Object[] objArr) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        return new h0(new Function0() { // from class: dd.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return n.N0(objArr);
            }
        });
    }

    public static final int N(short[] sArr, short s10) {
        kotlin.jvm.internal.t.f(sArr, "<this>");
        int length = sArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (s10 == sArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    public static final Iterator N0(Object[] objArr) {
        return kotlin.jvm.internal.c.a(objArr);
    }

    public static final Appendable O(byte[] bArr, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, pd.k kVar) throws IOException {
        kotlin.jvm.internal.t.f(bArr, "<this>");
        kotlin.jvm.internal.t.f(buffer, "buffer");
        kotlin.jvm.internal.t.f(separator, "separator");
        kotlin.jvm.internal.t.f(prefix, "prefix");
        kotlin.jvm.internal.t.f(postfix, "postfix");
        kotlin.jvm.internal.t.f(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (byte b10 : bArr) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (kVar != null) {
                buffer.append((CharSequence) kVar.invoke(Byte.valueOf(b10)));
            } else {
                buffer.append(String.valueOf((int) b10));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static List O0(Object[] objArr, Iterable other) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        kotlin.jvm.internal.t.f(other, "other");
        int length = objArr.length;
        ArrayList arrayList = new ArrayList(Math.min(s.u(other, 10), length));
        int i10 = 0;
        for (Object obj : other) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(cd.w.a(objArr[i10], obj));
            i10++;
        }
        return arrayList;
    }

    public static final Appendable P(double[] dArr, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, pd.k kVar) throws IOException {
        kotlin.jvm.internal.t.f(dArr, "<this>");
        kotlin.jvm.internal.t.f(buffer, "buffer");
        kotlin.jvm.internal.t.f(separator, "separator");
        kotlin.jvm.internal.t.f(prefix, "prefix");
        kotlin.jvm.internal.t.f(postfix, "postfix");
        kotlin.jvm.internal.t.f(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (double d10 : dArr) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (kVar != null) {
                buffer.append((CharSequence) kVar.invoke(Double.valueOf(d10)));
            } else {
                buffer.append(String.valueOf(d10));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static List P0(Object[] objArr, Object[] other) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        kotlin.jvm.internal.t.f(other, "other");
        int iMin = Math.min(objArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(cd.w.a(objArr[i10], other[i10]));
        }
        return arrayList;
    }

    public static final Appendable Q(float[] fArr, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, pd.k kVar) throws IOException {
        kotlin.jvm.internal.t.f(fArr, "<this>");
        kotlin.jvm.internal.t.f(buffer, "buffer");
        kotlin.jvm.internal.t.f(separator, "separator");
        kotlin.jvm.internal.t.f(prefix, "prefix");
        kotlin.jvm.internal.t.f(postfix, "postfix");
        kotlin.jvm.internal.t.f(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (float f10 : fArr) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (kVar != null) {
                buffer.append((CharSequence) kVar.invoke(Float.valueOf(f10)));
            } else {
                buffer.append(String.valueOf(f10));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final Appendable R(int[] iArr, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, pd.k kVar) throws IOException {
        kotlin.jvm.internal.t.f(iArr, "<this>");
        kotlin.jvm.internal.t.f(buffer, "buffer");
        kotlin.jvm.internal.t.f(separator, "separator");
        kotlin.jvm.internal.t.f(prefix, "prefix");
        kotlin.jvm.internal.t.f(postfix, "postfix");
        kotlin.jvm.internal.t.f(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (int i12 : iArr) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (kVar != null) {
                buffer.append((CharSequence) kVar.invoke(Integer.valueOf(i12)));
            } else {
                buffer.append(String.valueOf(i12));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final Appendable S(long[] jArr, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, pd.k kVar) throws IOException {
        kotlin.jvm.internal.t.f(jArr, "<this>");
        kotlin.jvm.internal.t.f(buffer, "buffer");
        kotlin.jvm.internal.t.f(separator, "separator");
        kotlin.jvm.internal.t.f(prefix, "prefix");
        kotlin.jvm.internal.t.f(postfix, "postfix");
        kotlin.jvm.internal.t.f(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (long j10 : jArr) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (kVar != null) {
                buffer.append((CharSequence) kVar.invoke(Long.valueOf(j10)));
            } else {
                buffer.append(String.valueOf(j10));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final Appendable T(Object[] objArr, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, pd.k kVar) throws IOException {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        kotlin.jvm.internal.t.f(buffer, "buffer");
        kotlin.jvm.internal.t.f(separator, "separator");
        kotlin.jvm.internal.t.f(prefix, "prefix");
        kotlin.jvm.internal.t.f(postfix, "postfix");
        kotlin.jvm.internal.t.f(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (Object obj : objArr) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            kg.p.a(buffer, obj, kVar);
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final Appendable U(short[] sArr, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, pd.k kVar) throws IOException {
        kotlin.jvm.internal.t.f(sArr, "<this>");
        kotlin.jvm.internal.t.f(buffer, "buffer");
        kotlin.jvm.internal.t.f(separator, "separator");
        kotlin.jvm.internal.t.f(prefix, "prefix");
        kotlin.jvm.internal.t.f(postfix, "postfix");
        kotlin.jvm.internal.t.f(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (short s10 : sArr) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (kVar != null) {
                buffer.append((CharSequence) kVar.invoke(Short.valueOf(s10)));
            } else {
                buffer.append(String.valueOf((int) s10));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final String W(byte[] bArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, pd.k kVar) {
        kotlin.jvm.internal.t.f(bArr, "<this>");
        kotlin.jvm.internal.t.f(separator, "separator");
        kotlin.jvm.internal.t.f(prefix, "prefix");
        kotlin.jvm.internal.t.f(postfix, "postfix");
        kotlin.jvm.internal.t.f(truncated, "truncated");
        return ((StringBuilder) O(bArr, new StringBuilder(), separator, prefix, postfix, i10, truncated, kVar)).toString();
    }

    public static final String X(double[] dArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, pd.k kVar) {
        kotlin.jvm.internal.t.f(dArr, "<this>");
        kotlin.jvm.internal.t.f(separator, "separator");
        kotlin.jvm.internal.t.f(prefix, "prefix");
        kotlin.jvm.internal.t.f(postfix, "postfix");
        kotlin.jvm.internal.t.f(truncated, "truncated");
        return ((StringBuilder) P(dArr, new StringBuilder(), separator, prefix, postfix, i10, truncated, kVar)).toString();
    }

    public static final String Y(float[] fArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, pd.k kVar) {
        kotlin.jvm.internal.t.f(fArr, "<this>");
        kotlin.jvm.internal.t.f(separator, "separator");
        kotlin.jvm.internal.t.f(prefix, "prefix");
        kotlin.jvm.internal.t.f(postfix, "postfix");
        kotlin.jvm.internal.t.f(truncated, "truncated");
        return ((StringBuilder) Q(fArr, new StringBuilder(), separator, prefix, postfix, i10, truncated, kVar)).toString();
    }

    public static final String Z(int[] iArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, pd.k kVar) {
        kotlin.jvm.internal.t.f(iArr, "<this>");
        kotlin.jvm.internal.t.f(separator, "separator");
        kotlin.jvm.internal.t.f(prefix, "prefix");
        kotlin.jvm.internal.t.f(postfix, "postfix");
        kotlin.jvm.internal.t.f(truncated, "truncated");
        return ((StringBuilder) R(iArr, new StringBuilder(), separator, prefix, postfix, i10, truncated, kVar)).toString();
    }

    public static final String a0(long[] jArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, pd.k kVar) {
        kotlin.jvm.internal.t.f(jArr, "<this>");
        kotlin.jvm.internal.t.f(separator, "separator");
        kotlin.jvm.internal.t.f(prefix, "prefix");
        kotlin.jvm.internal.t.f(postfix, "postfix");
        kotlin.jvm.internal.t.f(truncated, "truncated");
        return ((StringBuilder) S(jArr, new StringBuilder(), separator, prefix, postfix, i10, truncated, kVar)).toString();
    }

    public static final String b0(Object[] objArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, pd.k kVar) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        kotlin.jvm.internal.t.f(separator, "separator");
        kotlin.jvm.internal.t.f(prefix, "prefix");
        kotlin.jvm.internal.t.f(postfix, "postfix");
        kotlin.jvm.internal.t.f(truncated, "truncated");
        return ((StringBuilder) T(objArr, new StringBuilder(), separator, prefix, postfix, i10, truncated, kVar)).toString();
    }

    public static final String c0(short[] sArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, pd.k kVar) {
        kotlin.jvm.internal.t.f(sArr, "<this>");
        kotlin.jvm.internal.t.f(separator, "separator");
        kotlin.jvm.internal.t.f(prefix, "prefix");
        kotlin.jvm.internal.t.f(postfix, "postfix");
        kotlin.jvm.internal.t.f(truncated, "truncated");
        return ((StringBuilder) U(sArr, new StringBuilder(), separator, prefix, postfix, i10, truncated, kVar)).toString();
    }

    public static /* synthetic */ String d0(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, pd.k kVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i11 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i11 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i11 & 32) != 0) {
            kVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        pd.k kVar2 = kVar;
        return W(bArr, charSequence, charSequence2, charSequence3, i10, charSequence5, kVar2);
    }

    public static /* synthetic */ String e0(double[] dArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, pd.k kVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i11 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i11 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i11 & 32) != 0) {
            kVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        pd.k kVar2 = kVar;
        return X(dArr, charSequence, charSequence2, charSequence3, i10, charSequence5, kVar2);
    }

    public static /* synthetic */ String f0(float[] fArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, pd.k kVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i11 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i11 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i11 & 32) != 0) {
            kVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        pd.k kVar2 = kVar;
        return Y(fArr, charSequence, charSequence2, charSequence3, i10, charSequence5, kVar2);
    }

    public static /* synthetic */ String g0(int[] iArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, pd.k kVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i11 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i11 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i11 & 32) != 0) {
            kVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        pd.k kVar2 = kVar;
        return Z(iArr, charSequence, charSequence2, charSequence3, i10, charSequence5, kVar2);
    }

    public static /* synthetic */ String h0(long[] jArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, pd.k kVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i11 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i11 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i11 & 32) != 0) {
            kVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        pd.k kVar2 = kVar;
        return a0(jArr, charSequence, charSequence2, charSequence3, i10, charSequence5, kVar2);
    }

    public static /* synthetic */ String i0(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, pd.k kVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i11 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i11 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i11 & 32) != 0) {
            kVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        pd.k kVar2 = kVar;
        return b0(objArr, charSequence, charSequence2, charSequence3, i10, charSequence5, kVar2);
    }

    public static /* synthetic */ String j0(short[] sArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, pd.k kVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i11 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i11 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i11 & 32) != 0) {
            kVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        pd.k kVar2 = kVar;
        return c0(sArr, charSequence, charSequence2, charSequence3, i10, charSequence5, kVar2);
    }

    public static Object k0(Object[] objArr) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        if (objArr.length != 0) {
            return objArr[G(objArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int l0(int[] iArr, int i10) {
        kotlin.jvm.internal.t.f(iArr, "<this>");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i11 = length - 1;
                if (i10 == iArr[length]) {
                    return length;
                }
                if (i11 < 0) {
                    break;
                }
                length = i11;
            }
        }
        return -1;
    }

    public static char m0(char[] cArr) {
        kotlin.jvm.internal.t.f(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static Object n0(Object[] objArr) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        int length = objArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return objArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static Object o0(Object[] objArr) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        if (objArr.length == 1) {
            return objArr[0];
        }
        return null;
    }

    public static final Object[] p0(Object[] objArr, Comparator comparator) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        kotlin.jvm.internal.t.f(comparator, "comparator");
        if (objArr.length == 0) {
            return objArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        kotlin.jvm.internal.t.e(objArrCopyOf, "copyOf(...)");
        l.q(objArrCopyOf, comparator);
        return objArrCopyOf;
    }

    public static List q0(Object[] objArr, Comparator comparator) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        kotlin.jvm.internal.t.f(comparator, "comparator");
        return l.d(p0(objArr, comparator));
    }

    public static final List r0(Object[] objArr, int i10) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return r.k();
        }
        int length = objArr.length;
        if (i10 >= length) {
            return z0(objArr);
        }
        if (i10 == 1) {
            return q.e(objArr[length - 1]);
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = length - i10; i11 < length; i11++) {
            arrayList.add(objArr[i11]);
        }
        return arrayList;
    }

    public static Iterable s(Object[] objArr) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        return objArr.length == 0 ? r.k() : new a(objArr);
    }

    public static final Collection s0(Object[] objArr, Collection destination) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        kotlin.jvm.internal.t.f(destination, "destination");
        for (Object obj : objArr) {
            destination.add(obj);
        }
        return destination;
    }

    public static jg.h t(Object[] objArr) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        return objArr.length == 0 ? jg.q.i() : new b(objArr);
    }

    public static List t0(byte[] bArr) {
        kotlin.jvm.internal.t.f(bArr, "<this>");
        int length = bArr.length;
        return length != 0 ? length != 1 ? C0(bArr) : q.e(Byte.valueOf(bArr[0])) : r.k();
    }

    public static boolean u(byte[] bArr, byte b10) {
        kotlin.jvm.internal.t.f(bArr, "<this>");
        return J(bArr, b10) >= 0;
    }

    public static List u0(char[] cArr) {
        kotlin.jvm.internal.t.f(cArr, "<this>");
        int length = cArr.length;
        return length != 0 ? length != 1 ? D0(cArr) : q.e(Character.valueOf(cArr[0])) : r.k();
    }

    public static boolean v(int[] iArr, int i10) {
        kotlin.jvm.internal.t.f(iArr, "<this>");
        return K(iArr, i10) >= 0;
    }

    public static List v0(double[] dArr) {
        kotlin.jvm.internal.t.f(dArr, "<this>");
        int length = dArr.length;
        return length != 0 ? length != 1 ? E0(dArr) : q.e(Double.valueOf(dArr[0])) : r.k();
    }

    public static boolean w(long[] jArr, long j10) {
        kotlin.jvm.internal.t.f(jArr, "<this>");
        return L(jArr, j10) >= 0;
    }

    public static List w0(float[] fArr) {
        kotlin.jvm.internal.t.f(fArr, "<this>");
        int length = fArr.length;
        return length != 0 ? length != 1 ? F0(fArr) : q.e(Float.valueOf(fArr[0])) : r.k();
    }

    public static boolean x(Object[] objArr, Object obj) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        return M(objArr, obj) >= 0;
    }

    public static List x0(int[] iArr) {
        kotlin.jvm.internal.t.f(iArr, "<this>");
        int length = iArr.length;
        return length != 0 ? length != 1 ? G0(iArr) : q.e(Integer.valueOf(iArr[0])) : r.k();
    }

    public static boolean y(short[] sArr, short s10) {
        kotlin.jvm.internal.t.f(sArr, "<this>");
        return N(sArr, s10) >= 0;
    }

    public static List y0(long[] jArr) {
        kotlin.jvm.internal.t.f(jArr, "<this>");
        int length = jArr.length;
        return length != 0 ? length != 1 ? H0(jArr) : q.e(Long.valueOf(jArr[0])) : r.k();
    }

    public static List z(Object[] objArr, int i10) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        if (i10 >= 0) {
            return r0(objArr, vd.l.b(objArr.length - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    public static List z0(Object[] objArr) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        int length = objArr.length;
        return length != 0 ? length != 1 ? I0(objArr) : q.e(objArr[0]) : r.k();
    }
}
