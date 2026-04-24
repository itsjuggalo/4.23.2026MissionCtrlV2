package F5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2140b;

/* JADX INFO: renamed from: F5.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0552j extends AbstractC0551i {

    /* JADX INFO: renamed from: F5.j$a */
    public static final class a extends kotlin.jvm.internal.s implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object[] f2381a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Object[] objArr) {
            super(0);
            this.f2381a = objArr;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Iterator invoke() {
            return AbstractC2140b.a(this.f2381a);
        }
    }

    public static final int A(int[] iArr, int i7) {
        kotlin.jvm.internal.r.f(iArr, "<this>");
        int length = iArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            if (i7 == iArr[i8]) {
                return i8;
            }
        }
        return -1;
    }

    public static final int B(long[] jArr, long j7) {
        kotlin.jvm.internal.r.f(jArr, "<this>");
        int length = jArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (j7 == jArr[i7]) {
                return i7;
            }
        }
        return -1;
    }

    public static int C(Object[] objArr, Object obj) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        int i7 = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i7 < length) {
                if (objArr[i7] == null) {
                    return i7;
                }
                i7++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i7 < length2) {
            if (kotlin.jvm.internal.r.b(obj, objArr[i7])) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    public static final int D(short[] sArr, short s7) {
        kotlin.jvm.internal.r.f(sArr, "<this>");
        int length = sArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (s7 == sArr[i7]) {
                return i7;
            }
        }
        return -1;
    }

    public static final Appendable E(byte[] bArr, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i7, CharSequence truncated, Q5.k kVar) throws IOException {
        kotlin.jvm.internal.r.f(bArr, "<this>");
        kotlin.jvm.internal.r.f(buffer, "buffer");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        buffer.append(prefix);
        int i8 = 0;
        for (byte b7 : bArr) {
            i8++;
            if (i8 > 1) {
                buffer.append(separator);
            }
            if (i7 >= 0 && i8 > i7) {
                break;
            }
            if (kVar != null) {
                buffer.append((CharSequence) kVar.invoke(Byte.valueOf(b7)));
            } else {
                buffer.append(String.valueOf((int) b7));
            }
        }
        if (i7 >= 0 && i8 > i7) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final Appendable F(double[] dArr, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i7, CharSequence truncated, Q5.k kVar) throws IOException {
        kotlin.jvm.internal.r.f(dArr, "<this>");
        kotlin.jvm.internal.r.f(buffer, "buffer");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        buffer.append(prefix);
        int i8 = 0;
        for (double d7 : dArr) {
            i8++;
            if (i8 > 1) {
                buffer.append(separator);
            }
            if (i7 >= 0 && i8 > i7) {
                break;
            }
            if (kVar != null) {
                buffer.append((CharSequence) kVar.invoke(Double.valueOf(d7)));
            } else {
                buffer.append(String.valueOf(d7));
            }
        }
        if (i7 >= 0 && i8 > i7) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final Appendable G(float[] fArr, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i7, CharSequence truncated, Q5.k kVar) throws IOException {
        kotlin.jvm.internal.r.f(fArr, "<this>");
        kotlin.jvm.internal.r.f(buffer, "buffer");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        buffer.append(prefix);
        int i8 = 0;
        for (float f7 : fArr) {
            i8++;
            if (i8 > 1) {
                buffer.append(separator);
            }
            if (i7 >= 0 && i8 > i7) {
                break;
            }
            if (kVar != null) {
                buffer.append((CharSequence) kVar.invoke(Float.valueOf(f7)));
            } else {
                buffer.append(String.valueOf(f7));
            }
        }
        if (i7 >= 0 && i8 > i7) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final Appendable H(int[] iArr, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i7, CharSequence truncated, Q5.k kVar) throws IOException {
        kotlin.jvm.internal.r.f(iArr, "<this>");
        kotlin.jvm.internal.r.f(buffer, "buffer");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        buffer.append(prefix);
        int i8 = 0;
        for (int i9 : iArr) {
            i8++;
            if (i8 > 1) {
                buffer.append(separator);
            }
            if (i7 >= 0 && i8 > i7) {
                break;
            }
            if (kVar != null) {
                buffer.append((CharSequence) kVar.invoke(Integer.valueOf(i9)));
            } else {
                buffer.append(String.valueOf(i9));
            }
        }
        if (i7 >= 0 && i8 > i7) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final Appendable I(long[] jArr, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i7, CharSequence truncated, Q5.k kVar) throws IOException {
        kotlin.jvm.internal.r.f(jArr, "<this>");
        kotlin.jvm.internal.r.f(buffer, "buffer");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        buffer.append(prefix);
        int i8 = 0;
        for (long j7 : jArr) {
            i8++;
            if (i8 > 1) {
                buffer.append(separator);
            }
            if (i7 >= 0 && i8 > i7) {
                break;
            }
            if (kVar != null) {
                buffer.append((CharSequence) kVar.invoke(Long.valueOf(j7)));
            } else {
                buffer.append(String.valueOf(j7));
            }
        }
        if (i7 >= 0 && i8 > i7) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final Appendable J(Object[] objArr, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i7, CharSequence truncated, Q5.k kVar) throws IOException {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        kotlin.jvm.internal.r.f(buffer, "buffer");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        buffer.append(prefix);
        int i8 = 0;
        for (Object obj : objArr) {
            i8++;
            if (i8 > 1) {
                buffer.append(separator);
            }
            if (i7 >= 0 && i8 > i7) {
                break;
            }
            Z5.l.a(buffer, obj, kVar);
        }
        if (i7 >= 0 && i8 > i7) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final Appendable K(short[] sArr, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i7, CharSequence truncated, Q5.k kVar) throws IOException {
        kotlin.jvm.internal.r.f(sArr, "<this>");
        kotlin.jvm.internal.r.f(buffer, "buffer");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        buffer.append(prefix);
        int i8 = 0;
        for (short s7 : sArr) {
            i8++;
            if (i8 > 1) {
                buffer.append(separator);
            }
            if (i7 >= 0 && i8 > i7) {
                break;
            }
            if (kVar != null) {
                buffer.append((CharSequence) kVar.invoke(Short.valueOf(s7)));
            } else {
                buffer.append(String.valueOf((int) s7));
            }
        }
        if (i7 >= 0 && i8 > i7) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final String L(byte[] bArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i7, CharSequence truncated, Q5.k kVar) {
        kotlin.jvm.internal.r.f(bArr, "<this>");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        String string = ((StringBuilder) E(bArr, new StringBuilder(), separator, prefix, postfix, i7, truncated, kVar)).toString();
        kotlin.jvm.internal.r.e(string, "toString(...)");
        return string;
    }

    public static final String M(double[] dArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i7, CharSequence truncated, Q5.k kVar) {
        kotlin.jvm.internal.r.f(dArr, "<this>");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        String string = ((StringBuilder) F(dArr, new StringBuilder(), separator, prefix, postfix, i7, truncated, kVar)).toString();
        kotlin.jvm.internal.r.e(string, "toString(...)");
        return string;
    }

    public static final String N(float[] fArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i7, CharSequence truncated, Q5.k kVar) {
        kotlin.jvm.internal.r.f(fArr, "<this>");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        String string = ((StringBuilder) G(fArr, new StringBuilder(), separator, prefix, postfix, i7, truncated, kVar)).toString();
        kotlin.jvm.internal.r.e(string, "toString(...)");
        return string;
    }

    public static final String O(int[] iArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i7, CharSequence truncated, Q5.k kVar) {
        kotlin.jvm.internal.r.f(iArr, "<this>");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        String string = ((StringBuilder) H(iArr, new StringBuilder(), separator, prefix, postfix, i7, truncated, kVar)).toString();
        kotlin.jvm.internal.r.e(string, "toString(...)");
        return string;
    }

    public static final String P(long[] jArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i7, CharSequence truncated, Q5.k kVar) {
        kotlin.jvm.internal.r.f(jArr, "<this>");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        String string = ((StringBuilder) I(jArr, new StringBuilder(), separator, prefix, postfix, i7, truncated, kVar)).toString();
        kotlin.jvm.internal.r.e(string, "toString(...)");
        return string;
    }

    public static final String Q(Object[] objArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i7, CharSequence truncated, Q5.k kVar) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        String string = ((StringBuilder) J(objArr, new StringBuilder(), separator, prefix, postfix, i7, truncated, kVar)).toString();
        kotlin.jvm.internal.r.e(string, "toString(...)");
        return string;
    }

    public static final String R(short[] sArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i7, CharSequence truncated, Q5.k kVar) {
        kotlin.jvm.internal.r.f(sArr, "<this>");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        String string = ((StringBuilder) K(sArr, new StringBuilder(), separator, prefix, postfix, i7, truncated, kVar)).toString();
        kotlin.jvm.internal.r.e(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String S(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i7, CharSequence charSequence4, Q5.k kVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i8 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i8 & 4) == 0 ? charSequence3 : "";
        if ((i8 & 8) != 0) {
            i7 = -1;
        }
        int i9 = i7;
        if ((i8 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i8 & 32) != 0) {
            kVar = null;
        }
        return L(bArr, charSequence, charSequence5, charSequence6, i9, charSequence7, kVar);
    }

    public static /* synthetic */ String T(double[] dArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i7, CharSequence charSequence4, Q5.k kVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i8 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i8 & 4) == 0 ? charSequence3 : "";
        if ((i8 & 8) != 0) {
            i7 = -1;
        }
        int i9 = i7;
        if ((i8 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i8 & 32) != 0) {
            kVar = null;
        }
        return M(dArr, charSequence, charSequence5, charSequence6, i9, charSequence7, kVar);
    }

    public static /* synthetic */ String U(float[] fArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i7, CharSequence charSequence4, Q5.k kVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i8 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i8 & 4) == 0 ? charSequence3 : "";
        if ((i8 & 8) != 0) {
            i7 = -1;
        }
        int i9 = i7;
        if ((i8 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i8 & 32) != 0) {
            kVar = null;
        }
        return N(fArr, charSequence, charSequence5, charSequence6, i9, charSequence7, kVar);
    }

    public static /* synthetic */ String V(int[] iArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i7, CharSequence charSequence4, Q5.k kVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i8 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i8 & 4) == 0 ? charSequence3 : "";
        if ((i8 & 8) != 0) {
            i7 = -1;
        }
        int i9 = i7;
        if ((i8 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i8 & 32) != 0) {
            kVar = null;
        }
        return O(iArr, charSequence, charSequence5, charSequence6, i9, charSequence7, kVar);
    }

    public static /* synthetic */ String W(long[] jArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i7, CharSequence charSequence4, Q5.k kVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i8 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i8 & 4) == 0 ? charSequence3 : "";
        if ((i8 & 8) != 0) {
            i7 = -1;
        }
        int i9 = i7;
        if ((i8 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i8 & 32) != 0) {
            kVar = null;
        }
        return P(jArr, charSequence, charSequence5, charSequence6, i9, charSequence7, kVar);
    }

    public static /* synthetic */ String X(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i7, CharSequence charSequence4, Q5.k kVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i8 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i8 & 4) == 0 ? charSequence3 : "";
        if ((i8 & 8) != 0) {
            i7 = -1;
        }
        int i9 = i7;
        if ((i8 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i8 & 32) != 0) {
            kVar = null;
        }
        return Q(objArr, charSequence, charSequence5, charSequence6, i9, charSequence7, kVar);
    }

    public static /* synthetic */ String Y(short[] sArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i7, CharSequence charSequence4, Q5.k kVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i8 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i8 & 4) == 0 ? charSequence3 : "";
        if ((i8 & 8) != 0) {
            i7 = -1;
        }
        int i9 = i7;
        if ((i8 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i8 & 32) != 0) {
            kVar = null;
        }
        return R(sArr, charSequence, charSequence5, charSequence6, i9, charSequence7, kVar);
    }

    public static char Z(char[] cArr) {
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

    public static Object a0(Object[] objArr) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        if (objArr.length == 1) {
            return objArr[0];
        }
        return null;
    }

    public static final List b0(Object[] objArr, int i7) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        if (i7 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return AbstractC0556n.g();
        }
        int length = objArr.length;
        if (i7 >= length) {
            return i0(objArr);
        }
        if (i7 == 1) {
            return AbstractC0555m.b(objArr[length - 1]);
        }
        ArrayList arrayList = new ArrayList(i7);
        for (int i8 = length - i7; i8 < length; i8++) {
            arrayList.add(objArr[i8]);
        }
        return arrayList;
    }

    public static final Collection c0(Object[] objArr, Collection destination) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        kotlin.jvm.internal.r.f(destination, "destination");
        for (Object obj : objArr) {
            destination.add(obj);
        }
        return destination;
    }

    public static List d0(byte[] bArr) {
        kotlin.jvm.internal.r.f(bArr, "<this>");
        int length = bArr.length;
        return length != 0 ? length != 1 ? k0(bArr) : AbstractC0555m.b(Byte.valueOf(bArr[0])) : AbstractC0556n.g();
    }

    public static List e0(double[] dArr) {
        kotlin.jvm.internal.r.f(dArr, "<this>");
        int length = dArr.length;
        return length != 0 ? length != 1 ? l0(dArr) : AbstractC0555m.b(Double.valueOf(dArr[0])) : AbstractC0556n.g();
    }

    public static List f0(float[] fArr) {
        kotlin.jvm.internal.r.f(fArr, "<this>");
        int length = fArr.length;
        return length != 0 ? length != 1 ? m0(fArr) : AbstractC0555m.b(Float.valueOf(fArr[0])) : AbstractC0556n.g();
    }

    public static List g0(int[] iArr) {
        kotlin.jvm.internal.r.f(iArr, "<this>");
        int length = iArr.length;
        return length != 0 ? length != 1 ? n0(iArr) : AbstractC0555m.b(Integer.valueOf(iArr[0])) : AbstractC0556n.g();
    }

    public static List h0(long[] jArr) {
        kotlin.jvm.internal.r.f(jArr, "<this>");
        int length = jArr.length;
        return length != 0 ? length != 1 ? o0(jArr) : AbstractC0555m.b(Long.valueOf(jArr[0])) : AbstractC0556n.g();
    }

    public static List i0(Object[] objArr) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        int length = objArr.length;
        return length != 0 ? length != 1 ? p0(objArr) : AbstractC0555m.b(objArr[0]) : AbstractC0556n.g();
    }

    public static List j0(short[] sArr) {
        kotlin.jvm.internal.r.f(sArr, "<this>");
        int length = sArr.length;
        return length != 0 ? length != 1 ? q0(sArr) : AbstractC0555m.b(Short.valueOf(sArr[0])) : AbstractC0556n.g();
    }

    public static final List k0(byte[] bArr) {
        kotlin.jvm.internal.r.f(bArr, "<this>");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b7 : bArr) {
            arrayList.add(Byte.valueOf(b7));
        }
        return arrayList;
    }

    public static final List l0(double[] dArr) {
        kotlin.jvm.internal.r.f(dArr, "<this>");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d7 : dArr) {
            arrayList.add(Double.valueOf(d7));
        }
        return arrayList;
    }

    public static boolean m(byte[] bArr, byte b7) {
        kotlin.jvm.internal.r.f(bArr, "<this>");
        return z(bArr, b7) >= 0;
    }

    public static final List m0(float[] fArr) {
        kotlin.jvm.internal.r.f(fArr, "<this>");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f7 : fArr) {
            arrayList.add(Float.valueOf(f7));
        }
        return arrayList;
    }

    public static boolean n(int[] iArr, int i7) {
        kotlin.jvm.internal.r.f(iArr, "<this>");
        return A(iArr, i7) >= 0;
    }

    public static final List n0(int[] iArr) {
        kotlin.jvm.internal.r.f(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i7 : iArr) {
            arrayList.add(Integer.valueOf(i7));
        }
        return arrayList;
    }

    public static boolean o(long[] jArr, long j7) {
        kotlin.jvm.internal.r.f(jArr, "<this>");
        return B(jArr, j7) >= 0;
    }

    public static final List o0(long[] jArr) {
        kotlin.jvm.internal.r.f(jArr, "<this>");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j7 : jArr) {
            arrayList.add(Long.valueOf(j7));
        }
        return arrayList;
    }

    public static boolean p(Object[] objArr, Object obj) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        return C(objArr, obj) >= 0;
    }

    public static final List p0(Object[] objArr) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        return new ArrayList(AbstractC0556n.f(objArr));
    }

    public static boolean q(short[] sArr, short s7) {
        kotlin.jvm.internal.r.f(sArr, "<this>");
        return D(sArr, s7) >= 0;
    }

    public static final List q0(short[] sArr) {
        kotlin.jvm.internal.r.f(sArr, "<this>");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s7 : sArr) {
            arrayList.add(Short.valueOf(s7));
        }
        return arrayList;
    }

    public static List r(Object[] objArr, int i7) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        if (i7 >= 0) {
            return b0(objArr, W5.l.b(objArr.length - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    public static final Set r0(Object[] objArr) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        int length = objArr.length;
        return length != 0 ? length != 1 ? (Set) c0(objArr, new LinkedHashSet(I.b(objArr.length))) : N.a(objArr[0]) : O.b();
    }

    public static List s(Object[] objArr) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        return (List) t(objArr, new ArrayList());
    }

    public static Iterable s0(Object[] objArr) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        return new C(new a(objArr));
    }

    public static final Collection t(Object[] objArr, Collection destination) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        kotlin.jvm.internal.r.f(destination, "destination");
        for (Object obj : objArr) {
            if (obj != null) {
                destination.add(obj);
            }
        }
        return destination;
    }

    public static List t0(Object[] objArr, Object[] other) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        kotlin.jvm.internal.r.f(other, "other");
        int iMin = Math.min(objArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(E5.t.a(objArr[i7], other[i7]));
        }
        return arrayList;
    }

    public static Object u(Object[] objArr) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        if (objArr.length != 0) {
            return objArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static W5.g v(Object[] objArr) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        return new W5.g(0, x(objArr));
    }

    public static int w(long[] jArr) {
        kotlin.jvm.internal.r.f(jArr, "<this>");
        return jArr.length - 1;
    }

    public static final int x(Object[] objArr) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        return objArr.length - 1;
    }

    public static Object y(Object[] objArr, int i7) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        if (i7 < 0 || i7 >= objArr.length) {
            return null;
        }
        return objArr[i7];
    }

    public static final int z(byte[] bArr, byte b7) {
        kotlin.jvm.internal.r.f(bArr, "<this>");
        int length = bArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (b7 == bArr[i7]) {
                return i7;
            }
        }
        return -1;
    }
}
