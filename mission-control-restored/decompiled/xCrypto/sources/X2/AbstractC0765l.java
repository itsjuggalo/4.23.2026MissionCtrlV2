package X2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1577b;
import o3.AbstractC1681l;
import o3.C1676g;

/* JADX INFO: renamed from: X2.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0765l extends AbstractC0763j {
    public static final int A(byte[] bArr, byte b4) {
        kotlin.jvm.internal.r.f(bArr, "<this>");
        int length = bArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (b4 == bArr[i4]) {
                return i4;
            }
        }
        return -1;
    }

    public static final int B(int[] iArr, int i4) {
        kotlin.jvm.internal.r.f(iArr, "<this>");
        int length = iArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (i4 == iArr[i5]) {
                return i5;
            }
        }
        return -1;
    }

    public static final int C(long[] jArr, long j4) {
        kotlin.jvm.internal.r.f(jArr, "<this>");
        int length = jArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (j4 == jArr[i4]) {
                return i4;
            }
        }
        return -1;
    }

    public static int D(Object[] objArr, Object obj) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        int i4 = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i4 < length) {
                if (objArr[i4] == null) {
                    return i4;
                }
                i4++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i4 < length2) {
            if (kotlin.jvm.internal.r.b(obj, objArr[i4])) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    public static final int E(short[] sArr, short s4) {
        kotlin.jvm.internal.r.f(sArr, "<this>");
        int length = sArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (s4 == sArr[i4]) {
                return i4;
            }
        }
        return -1;
    }

    public static final Appendable F(byte[] bArr, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i4, CharSequence truncated, i3.k kVar) throws IOException {
        kotlin.jvm.internal.r.f(bArr, "<this>");
        kotlin.jvm.internal.r.f(buffer, "buffer");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        buffer.append(prefix);
        int i5 = 0;
        for (byte b4 : bArr) {
            i5++;
            if (i5 > 1) {
                buffer.append(separator);
            }
            if (i4 >= 0 && i5 > i4) {
                break;
            }
            if (kVar != null) {
                buffer.append((CharSequence) kVar.invoke(Byte.valueOf(b4)));
            } else {
                buffer.append(String.valueOf((int) b4));
            }
        }
        if (i4 >= 0 && i5 > i4) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final Appendable G(double[] dArr, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i4, CharSequence truncated, i3.k kVar) throws IOException {
        kotlin.jvm.internal.r.f(dArr, "<this>");
        kotlin.jvm.internal.r.f(buffer, "buffer");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        buffer.append(prefix);
        int i5 = 0;
        for (double d4 : dArr) {
            i5++;
            if (i5 > 1) {
                buffer.append(separator);
            }
            if (i4 >= 0 && i5 > i4) {
                break;
            }
            if (kVar != null) {
                buffer.append((CharSequence) kVar.invoke(Double.valueOf(d4)));
            } else {
                buffer.append(String.valueOf(d4));
            }
        }
        if (i4 >= 0 && i5 > i4) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final Appendable H(float[] fArr, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i4, CharSequence truncated, i3.k kVar) throws IOException {
        kotlin.jvm.internal.r.f(fArr, "<this>");
        kotlin.jvm.internal.r.f(buffer, "buffer");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        buffer.append(prefix);
        int i5 = 0;
        for (float f4 : fArr) {
            i5++;
            if (i5 > 1) {
                buffer.append(separator);
            }
            if (i4 >= 0 && i5 > i4) {
                break;
            }
            if (kVar != null) {
                buffer.append((CharSequence) kVar.invoke(Float.valueOf(f4)));
            } else {
                buffer.append(String.valueOf(f4));
            }
        }
        if (i4 >= 0 && i5 > i4) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final Appendable I(int[] iArr, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i4, CharSequence truncated, i3.k kVar) throws IOException {
        kotlin.jvm.internal.r.f(iArr, "<this>");
        kotlin.jvm.internal.r.f(buffer, "buffer");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        buffer.append(prefix);
        int i5 = 0;
        for (int i6 : iArr) {
            i5++;
            if (i5 > 1) {
                buffer.append(separator);
            }
            if (i4 >= 0 && i5 > i4) {
                break;
            }
            if (kVar != null) {
                buffer.append((CharSequence) kVar.invoke(Integer.valueOf(i6)));
            } else {
                buffer.append(String.valueOf(i6));
            }
        }
        if (i4 >= 0 && i5 > i4) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final Appendable J(long[] jArr, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i4, CharSequence truncated, i3.k kVar) throws IOException {
        kotlin.jvm.internal.r.f(jArr, "<this>");
        kotlin.jvm.internal.r.f(buffer, "buffer");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        buffer.append(prefix);
        int i5 = 0;
        for (long j4 : jArr) {
            i5++;
            if (i5 > 1) {
                buffer.append(separator);
            }
            if (i4 >= 0 && i5 > i4) {
                break;
            }
            if (kVar != null) {
                buffer.append((CharSequence) kVar.invoke(Long.valueOf(j4)));
            } else {
                buffer.append(String.valueOf(j4));
            }
        }
        if (i4 >= 0 && i5 > i4) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final Appendable K(Object[] objArr, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i4, CharSequence truncated, i3.k kVar) throws IOException {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        kotlin.jvm.internal.r.f(buffer, "buffer");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        buffer.append(prefix);
        int i5 = 0;
        for (Object obj : objArr) {
            i5++;
            if (i5 > 1) {
                buffer.append(separator);
            }
            if (i4 >= 0 && i5 > i4) {
                break;
            }
            r3.n.a(buffer, obj, kVar);
        }
        if (i4 >= 0 && i5 > i4) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final Appendable L(short[] sArr, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i4, CharSequence truncated, i3.k kVar) throws IOException {
        kotlin.jvm.internal.r.f(sArr, "<this>");
        kotlin.jvm.internal.r.f(buffer, "buffer");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        buffer.append(prefix);
        int i5 = 0;
        for (short s4 : sArr) {
            i5++;
            if (i5 > 1) {
                buffer.append(separator);
            }
            if (i4 >= 0 && i5 > i4) {
                break;
            }
            if (kVar != null) {
                buffer.append((CharSequence) kVar.invoke(Short.valueOf(s4)));
            } else {
                buffer.append(String.valueOf((int) s4));
            }
        }
        if (i4 >= 0 && i5 > i4) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final String M(byte[] bArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i4, CharSequence truncated, i3.k kVar) {
        kotlin.jvm.internal.r.f(bArr, "<this>");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        return ((StringBuilder) F(bArr, new StringBuilder(), separator, prefix, postfix, i4, truncated, kVar)).toString();
    }

    public static final String N(double[] dArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i4, CharSequence truncated, i3.k kVar) {
        kotlin.jvm.internal.r.f(dArr, "<this>");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        return ((StringBuilder) G(dArr, new StringBuilder(), separator, prefix, postfix, i4, truncated, kVar)).toString();
    }

    public static final String O(float[] fArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i4, CharSequence truncated, i3.k kVar) {
        kotlin.jvm.internal.r.f(fArr, "<this>");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        return ((StringBuilder) H(fArr, new StringBuilder(), separator, prefix, postfix, i4, truncated, kVar)).toString();
    }

    public static final String P(int[] iArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i4, CharSequence truncated, i3.k kVar) {
        kotlin.jvm.internal.r.f(iArr, "<this>");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        return ((StringBuilder) I(iArr, new StringBuilder(), separator, prefix, postfix, i4, truncated, kVar)).toString();
    }

    public static final String Q(long[] jArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i4, CharSequence truncated, i3.k kVar) {
        kotlin.jvm.internal.r.f(jArr, "<this>");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        return ((StringBuilder) J(jArr, new StringBuilder(), separator, prefix, postfix, i4, truncated, kVar)).toString();
    }

    public static final String R(Object[] objArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i4, CharSequence truncated, i3.k kVar) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        return ((StringBuilder) K(objArr, new StringBuilder(), separator, prefix, postfix, i4, truncated, kVar)).toString();
    }

    public static final String S(short[] sArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i4, CharSequence truncated, i3.k kVar) {
        kotlin.jvm.internal.r.f(sArr, "<this>");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        return ((StringBuilder) L(sArr, new StringBuilder(), separator, prefix, postfix, i4, truncated, kVar)).toString();
    }

    public static /* synthetic */ String T(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i4, CharSequence charSequence4, i3.k kVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i5 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i5 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i5 & 8) != 0) {
            i4 = -1;
        }
        if ((i5 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i5 & 32) != 0) {
            kVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        i3.k kVar2 = kVar;
        return M(bArr, charSequence, charSequence2, charSequence3, i4, charSequence5, kVar2);
    }

    public static /* synthetic */ String U(double[] dArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i4, CharSequence charSequence4, i3.k kVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i5 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i5 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i5 & 8) != 0) {
            i4 = -1;
        }
        if ((i5 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i5 & 32) != 0) {
            kVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        i3.k kVar2 = kVar;
        return N(dArr, charSequence, charSequence2, charSequence3, i4, charSequence5, kVar2);
    }

    public static /* synthetic */ String V(float[] fArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i4, CharSequence charSequence4, i3.k kVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i5 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i5 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i5 & 8) != 0) {
            i4 = -1;
        }
        if ((i5 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i5 & 32) != 0) {
            kVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        i3.k kVar2 = kVar;
        return O(fArr, charSequence, charSequence2, charSequence3, i4, charSequence5, kVar2);
    }

    public static /* synthetic */ String W(int[] iArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i4, CharSequence charSequence4, i3.k kVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i5 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i5 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i5 & 8) != 0) {
            i4 = -1;
        }
        if ((i5 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i5 & 32) != 0) {
            kVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        i3.k kVar2 = kVar;
        return P(iArr, charSequence, charSequence2, charSequence3, i4, charSequence5, kVar2);
    }

    public static /* synthetic */ String X(long[] jArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i4, CharSequence charSequence4, i3.k kVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i5 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i5 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i5 & 8) != 0) {
            i4 = -1;
        }
        if ((i5 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i5 & 32) != 0) {
            kVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        i3.k kVar2 = kVar;
        return Q(jArr, charSequence, charSequence2, charSequence3, i4, charSequence5, kVar2);
    }

    public static /* synthetic */ String Y(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i4, CharSequence charSequence4, i3.k kVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i5 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i5 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i5 & 8) != 0) {
            i4 = -1;
        }
        if ((i5 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i5 & 32) != 0) {
            kVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        i3.k kVar2 = kVar;
        return R(objArr, charSequence, charSequence2, charSequence3, i4, charSequence5, kVar2);
    }

    public static /* synthetic */ String Z(short[] sArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i4, CharSequence charSequence4, i3.k kVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i5 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i5 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i5 & 8) != 0) {
            i4 = -1;
        }
        if ((i5 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i5 & 32) != 0) {
            kVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        i3.k kVar2 = kVar;
        return S(sArr, charSequence, charSequence2, charSequence3, i4, charSequence5, kVar2);
    }

    public static char a0(char[] cArr) {
        kotlin.jvm.internal.r.f(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static Object b0(Object[] objArr) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        if (objArr.length == 1) {
            return objArr[0];
        }
        return null;
    }

    public static final List c0(Object[] objArr, int i4) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        if (i4 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i4 + " is less than zero.").toString());
        }
        if (i4 == 0) {
            return AbstractC0769p.g();
        }
        int length = objArr.length;
        if (i4 >= length) {
            return j0(objArr);
        }
        if (i4 == 1) {
            return AbstractC0768o.b(objArr[length - 1]);
        }
        ArrayList arrayList = new ArrayList(i4);
        for (int i5 = length - i4; i5 < length; i5++) {
            arrayList.add(objArr[i5]);
        }
        return arrayList;
    }

    public static final Collection d0(Object[] objArr, Collection destination) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        kotlin.jvm.internal.r.f(destination, "destination");
        for (Object obj : objArr) {
            destination.add(obj);
        }
        return destination;
    }

    public static List e0(byte[] bArr) {
        kotlin.jvm.internal.r.f(bArr, "<this>");
        int length = bArr.length;
        return length != 0 ? length != 1 ? l0(bArr) : AbstractC0768o.b(Byte.valueOf(bArr[0])) : AbstractC0769p.g();
    }

    public static List f0(double[] dArr) {
        kotlin.jvm.internal.r.f(dArr, "<this>");
        int length = dArr.length;
        return length != 0 ? length != 1 ? m0(dArr) : AbstractC0768o.b(Double.valueOf(dArr[0])) : AbstractC0769p.g();
    }

    public static List g0(float[] fArr) {
        kotlin.jvm.internal.r.f(fArr, "<this>");
        int length = fArr.length;
        return length != 0 ? length != 1 ? n0(fArr) : AbstractC0768o.b(Float.valueOf(fArr[0])) : AbstractC0769p.g();
    }

    public static List h0(int[] iArr) {
        kotlin.jvm.internal.r.f(iArr, "<this>");
        int length = iArr.length;
        return length != 0 ? length != 1 ? o0(iArr) : AbstractC0768o.b(Integer.valueOf(iArr[0])) : AbstractC0769p.g();
    }

    public static List i0(long[] jArr) {
        kotlin.jvm.internal.r.f(jArr, "<this>");
        int length = jArr.length;
        return length != 0 ? length != 1 ? p0(jArr) : AbstractC0768o.b(Long.valueOf(jArr[0])) : AbstractC0769p.g();
    }

    public static List j0(Object[] objArr) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        int length = objArr.length;
        return length != 0 ? length != 1 ? q0(objArr) : AbstractC0768o.b(objArr[0]) : AbstractC0769p.g();
    }

    public static List k0(short[] sArr) {
        kotlin.jvm.internal.r.f(sArr, "<this>");
        int length = sArr.length;
        return length != 0 ? length != 1 ? r0(sArr) : AbstractC0768o.b(Short.valueOf(sArr[0])) : AbstractC0769p.g();
    }

    public static final List l0(byte[] bArr) {
        kotlin.jvm.internal.r.f(bArr, "<this>");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b4 : bArr) {
            arrayList.add(Byte.valueOf(b4));
        }
        return arrayList;
    }

    public static final List m0(double[] dArr) {
        kotlin.jvm.internal.r.f(dArr, "<this>");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d4 : dArr) {
            arrayList.add(Double.valueOf(d4));
        }
        return arrayList;
    }

    public static boolean n(byte[] bArr, byte b4) {
        kotlin.jvm.internal.r.f(bArr, "<this>");
        return A(bArr, b4) >= 0;
    }

    public static final List n0(float[] fArr) {
        kotlin.jvm.internal.r.f(fArr, "<this>");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f4 : fArr) {
            arrayList.add(Float.valueOf(f4));
        }
        return arrayList;
    }

    public static boolean o(int[] iArr, int i4) {
        kotlin.jvm.internal.r.f(iArr, "<this>");
        return B(iArr, i4) >= 0;
    }

    public static final List o0(int[] iArr) {
        kotlin.jvm.internal.r.f(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i4 : iArr) {
            arrayList.add(Integer.valueOf(i4));
        }
        return arrayList;
    }

    public static boolean p(long[] jArr, long j4) {
        kotlin.jvm.internal.r.f(jArr, "<this>");
        return C(jArr, j4) >= 0;
    }

    public static final List p0(long[] jArr) {
        kotlin.jvm.internal.r.f(jArr, "<this>");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j4 : jArr) {
            arrayList.add(Long.valueOf(j4));
        }
        return arrayList;
    }

    public static boolean q(Object[] objArr, Object obj) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        return D(objArr, obj) >= 0;
    }

    public static final List q0(Object[] objArr) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        return new ArrayList(AbstractC0769p.f(objArr));
    }

    public static boolean r(short[] sArr, short s4) {
        kotlin.jvm.internal.r.f(sArr, "<this>");
        return E(sArr, s4) >= 0;
    }

    public static final List r0(short[] sArr) {
        kotlin.jvm.internal.r.f(sArr, "<this>");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s4 : sArr) {
            arrayList.add(Short.valueOf(s4));
        }
        return arrayList;
    }

    public static List s(Object[] objArr, int i4) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        if (i4 >= 0) {
            return c0(objArr, AbstractC1681l.b(objArr.length - i4, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i4 + " is less than zero.").toString());
    }

    public static final Set s0(Object[] objArr) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        int length = objArr.length;
        return length != 0 ? length != 1 ? (Set) d0(objArr, new LinkedHashSet(K.b(objArr.length))) : P.a(objArr[0]) : Q.b();
    }

    public static List t(Object[] objArr) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        return (List) u(objArr, new ArrayList());
    }

    public static Iterable t0(final Object[] objArr) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        return new E(new Function0() { // from class: X2.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AbstractC0765l.u0(objArr);
            }
        });
    }

    public static final Collection u(Object[] objArr, Collection destination) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        kotlin.jvm.internal.r.f(destination, "destination");
        for (Object obj : objArr) {
            if (obj != null) {
                destination.add(obj);
            }
        }
        return destination;
    }

    public static final Iterator u0(Object[] objArr) {
        return AbstractC1577b.a(objArr);
    }

    public static Object v(Object[] objArr) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        if (objArr.length != 0) {
            return objArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static List v0(Object[] objArr, Object[] other) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        kotlin.jvm.internal.r.f(other, "other");
        int iMin = Math.min(objArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i4 = 0; i4 < iMin; i4++) {
            arrayList.add(W2.t.a(objArr[i4], other[i4]));
        }
        return arrayList;
    }

    public static C1676g w(Object[] objArr) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        return new C1676g(0, y(objArr));
    }

    public static int x(long[] jArr) {
        kotlin.jvm.internal.r.f(jArr, "<this>");
        return jArr.length - 1;
    }

    public static final int y(Object[] objArr) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        return objArr.length - 1;
    }

    public static Object z(Object[] objArr, int i4) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        if (i4 < 0 || i4 >= objArr.length) {
            return null;
        }
        return objArr[i4];
    }
}
