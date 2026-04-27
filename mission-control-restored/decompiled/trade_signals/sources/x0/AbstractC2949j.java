package x0;

import com.revenuecat.purchases.common.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: renamed from: x0.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2949j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f24133a = {112, 114, 111, 0};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f24134b = {112, 114, 109, 0};

    public static void A(InputStream inputStream) {
        AbstractC2942c.h(inputStream);
        int iJ = AbstractC2942c.j(inputStream);
        if (iJ == 6 || iJ == 7) {
            return;
        }
        while (iJ > 0) {
            AbstractC2942c.j(inputStream);
            for (int iJ2 = AbstractC2942c.j(inputStream); iJ2 > 0; iJ2--) {
                AbstractC2942c.h(inputStream);
            }
            iJ--;
        }
    }

    public static boolean B(OutputStream outputStream, byte[] bArr, C2941b[] c2941bArr) throws IOException {
        if (Arrays.equals(bArr, AbstractC2950k.f24135a)) {
            N(outputStream, c2941bArr);
            return true;
        }
        if (Arrays.equals(bArr, AbstractC2950k.f24136b)) {
            M(outputStream, c2941bArr);
            return true;
        }
        if (Arrays.equals(bArr, AbstractC2950k.f24138d)) {
            K(outputStream, c2941bArr);
            return true;
        }
        if (Arrays.equals(bArr, AbstractC2950k.f24137c)) {
            L(outputStream, c2941bArr);
            return true;
        }
        if (!Arrays.equals(bArr, AbstractC2950k.f24139e)) {
            return false;
        }
        J(outputStream, c2941bArr);
        return true;
    }

    public static void C(OutputStream outputStream, C2941b c2941b) throws IOException {
        int[] iArr = c2941b.f24116h;
        int length = iArr.length;
        int i8 = 0;
        int i9 = 0;
        while (i8 < length) {
            int i10 = iArr[i8];
            AbstractC2942c.p(outputStream, i10 - i9);
            i8++;
            i9 = i10;
        }
    }

    public static C2951l D(C2941b[] c2941bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            AbstractC2942c.p(byteArrayOutputStream, c2941bArr.length);
            int i8 = 2;
            for (C2941b c2941b : c2941bArr) {
                AbstractC2942c.q(byteArrayOutputStream, c2941b.f24111c);
                AbstractC2942c.q(byteArrayOutputStream, c2941b.f24112d);
                AbstractC2942c.q(byteArrayOutputStream, c2941b.f24115g);
                String strJ = j(c2941b.f24109a, c2941b.f24110b, AbstractC2950k.f24135a);
                int iK = AbstractC2942c.k(strJ);
                AbstractC2942c.p(byteArrayOutputStream, iK);
                i8 = i8 + 14 + iK;
                AbstractC2942c.n(byteArrayOutputStream, strJ);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i8 == byteArray.length) {
                C2951l c2951l = new C2951l(EnumC2943d.DEX_FILES, i8, byteArray, false);
                byteArrayOutputStream.close();
                return c2951l;
            }
            throw AbstractC2942c.c("Expected size " + i8 + ", does not match actual size " + byteArray.length);
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static void E(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(f24133a);
        outputStream.write(bArr);
    }

    public static void F(OutputStream outputStream, C2941b c2941b) throws IOException {
        I(outputStream, c2941b);
        C(outputStream, c2941b);
        H(outputStream, c2941b);
    }

    public static void G(OutputStream outputStream, C2941b c2941b, String str) throws IOException {
        AbstractC2942c.p(outputStream, AbstractC2942c.k(str));
        AbstractC2942c.p(outputStream, c2941b.f24113e);
        AbstractC2942c.q(outputStream, c2941b.f24114f);
        AbstractC2942c.q(outputStream, c2941b.f24111c);
        AbstractC2942c.q(outputStream, c2941b.f24115g);
        AbstractC2942c.n(outputStream, str);
    }

    public static void H(OutputStream outputStream, C2941b c2941b) throws IOException {
        byte[] bArr = new byte[k(c2941b.f24115g)];
        for (Map.Entry entry : c2941b.f24117i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            if ((iIntValue2 & 2) != 0) {
                z(bArr, 2, iIntValue, c2941b);
            }
            if ((iIntValue2 & 4) != 0) {
                z(bArr, 4, iIntValue, c2941b);
            }
        }
        outputStream.write(bArr);
    }

    public static void I(OutputStream outputStream, C2941b c2941b) throws IOException {
        int i8 = 0;
        for (Map.Entry entry : c2941b.f24117i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                AbstractC2942c.p(outputStream, iIntValue - i8);
                AbstractC2942c.p(outputStream, 0);
                i8 = iIntValue;
            }
        }
    }

    public static void J(OutputStream outputStream, C2941b[] c2941bArr) throws IOException {
        AbstractC2942c.p(outputStream, c2941bArr.length);
        for (C2941b c2941b : c2941bArr) {
            String strJ = j(c2941b.f24109a, c2941b.f24110b, AbstractC2950k.f24139e);
            AbstractC2942c.p(outputStream, AbstractC2942c.k(strJ));
            AbstractC2942c.p(outputStream, c2941b.f24117i.size());
            AbstractC2942c.p(outputStream, c2941b.f24116h.length);
            AbstractC2942c.q(outputStream, c2941b.f24111c);
            AbstractC2942c.n(outputStream, strJ);
            Iterator it = c2941b.f24117i.keySet().iterator();
            while (it.hasNext()) {
                AbstractC2942c.p(outputStream, ((Integer) it.next()).intValue());
            }
            for (int i8 : c2941b.f24116h) {
                AbstractC2942c.p(outputStream, i8);
            }
        }
    }

    public static void K(OutputStream outputStream, C2941b[] c2941bArr) throws IOException {
        AbstractC2942c.r(outputStream, c2941bArr.length);
        for (C2941b c2941b : c2941bArr) {
            int size = c2941b.f24117i.size() * 4;
            String strJ = j(c2941b.f24109a, c2941b.f24110b, AbstractC2950k.f24138d);
            AbstractC2942c.p(outputStream, AbstractC2942c.k(strJ));
            AbstractC2942c.p(outputStream, c2941b.f24116h.length);
            AbstractC2942c.q(outputStream, size);
            AbstractC2942c.q(outputStream, c2941b.f24111c);
            AbstractC2942c.n(outputStream, strJ);
            Iterator it = c2941b.f24117i.keySet().iterator();
            while (it.hasNext()) {
                AbstractC2942c.p(outputStream, ((Integer) it.next()).intValue());
                AbstractC2942c.p(outputStream, 0);
            }
            for (int i8 : c2941b.f24116h) {
                AbstractC2942c.p(outputStream, i8);
            }
        }
    }

    public static void L(OutputStream outputStream, C2941b[] c2941bArr) throws IOException {
        byte[] bArrB = b(c2941bArr, AbstractC2950k.f24137c);
        AbstractC2942c.r(outputStream, c2941bArr.length);
        AbstractC2942c.m(outputStream, bArrB);
    }

    public static void M(OutputStream outputStream, C2941b[] c2941bArr) throws IOException {
        byte[] bArrB = b(c2941bArr, AbstractC2950k.f24136b);
        AbstractC2942c.r(outputStream, c2941bArr.length);
        AbstractC2942c.m(outputStream, bArrB);
    }

    public static void N(OutputStream outputStream, C2941b[] c2941bArr) throws IOException {
        O(outputStream, c2941bArr);
    }

    public static void O(OutputStream outputStream, C2941b[] c2941bArr) throws IOException {
        int length;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(D(c2941bArr));
        arrayList.add(c(c2941bArr));
        arrayList.add(d(c2941bArr));
        long length2 = ((long) AbstractC2950k.f24135a.length) + ((long) f24133a.length) + 4 + ((long) (arrayList.size() * 16));
        AbstractC2942c.q(outputStream, arrayList.size());
        for (int i8 = 0; i8 < arrayList.size(); i8++) {
            C2951l c2951l = (C2951l) arrayList.get(i8);
            AbstractC2942c.q(outputStream, c2951l.f24142a.b());
            AbstractC2942c.q(outputStream, length2);
            if (c2951l.f24145d) {
                byte[] bArr = c2951l.f24144c;
                long length3 = bArr.length;
                byte[] bArrB = AbstractC2942c.b(bArr);
                arrayList2.add(bArrB);
                AbstractC2942c.q(outputStream, bArrB.length);
                AbstractC2942c.q(outputStream, length3);
                length = bArrB.length;
            } else {
                arrayList2.add(c2951l.f24144c);
                AbstractC2942c.q(outputStream, c2951l.f24144c.length);
                AbstractC2942c.q(outputStream, 0L);
                length = c2951l.f24144c.length;
            }
            length2 += (long) length;
        }
        for (int i9 = 0; i9 < arrayList2.size(); i9++) {
            outputStream.write((byte[]) arrayList2.get(i9));
        }
    }

    public static int a(C2941b c2941b) {
        Iterator it = c2941b.f24117i.entrySet().iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue |= ((Integer) ((Map.Entry) it.next()).getValue()).intValue();
        }
        return iIntValue;
    }

    public static byte[] b(C2941b[] c2941bArr, byte[] bArr) throws IOException {
        int i8 = 0;
        int iK = 0;
        for (C2941b c2941b : c2941bArr) {
            iK += AbstractC2942c.k(j(c2941b.f24109a, c2941b.f24110b, bArr)) + 16 + (c2941b.f24113e * 2) + c2941b.f24114f + k(c2941b.f24115g);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(iK);
        if (Arrays.equals(bArr, AbstractC2950k.f24137c)) {
            int length = c2941bArr.length;
            while (i8 < length) {
                C2941b c2941b2 = c2941bArr[i8];
                G(byteArrayOutputStream, c2941b2, j(c2941b2.f24109a, c2941b2.f24110b, bArr));
                F(byteArrayOutputStream, c2941b2);
                i8++;
            }
        } else {
            for (C2941b c2941b3 : c2941bArr) {
                G(byteArrayOutputStream, c2941b3, j(c2941b3.f24109a, c2941b3.f24110b, bArr));
            }
            int length2 = c2941bArr.length;
            while (i8 < length2) {
                F(byteArrayOutputStream, c2941bArr[i8]);
                i8++;
            }
        }
        if (byteArrayOutputStream.size() == iK) {
            return byteArrayOutputStream.toByteArray();
        }
        throw AbstractC2942c.c("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + iK);
    }

    public static C2951l c(C2941b[] c2941bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i8 = 0;
        for (int i9 = 0; i9 < c2941bArr.length; i9++) {
            try {
                C2941b c2941b = c2941bArr[i9];
                AbstractC2942c.p(byteArrayOutputStream, i9);
                AbstractC2942c.p(byteArrayOutputStream, c2941b.f24113e);
                i8 = i8 + 4 + (c2941b.f24113e * 2);
                C(byteArrayOutputStream, c2941b);
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i8 == byteArray.length) {
            C2951l c2951l = new C2951l(EnumC2943d.CLASSES, i8, byteArray, true);
            byteArrayOutputStream.close();
            return c2951l;
        }
        throw AbstractC2942c.c("Expected size " + i8 + ", does not match actual size " + byteArray.length);
    }

    public static C2951l d(C2941b[] c2941bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i8 = 0;
        for (int i9 = 0; i9 < c2941bArr.length; i9++) {
            try {
                C2941b c2941b = c2941bArr[i9];
                int iA = a(c2941b);
                byte[] bArrE = e(c2941b);
                byte[] bArrF = f(c2941b);
                AbstractC2942c.p(byteArrayOutputStream, i9);
                int length = bArrE.length + 2 + bArrF.length;
                AbstractC2942c.q(byteArrayOutputStream, length);
                AbstractC2942c.p(byteArrayOutputStream, iA);
                byteArrayOutputStream.write(bArrE);
                byteArrayOutputStream.write(bArrF);
                i8 = i8 + 6 + length;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i8 == byteArray.length) {
            C2951l c2951l = new C2951l(EnumC2943d.METHODS, i8, byteArray, true);
            byteArrayOutputStream.close();
            return c2951l;
        }
        throw AbstractC2942c.c("Expected size " + i8 + ", does not match actual size " + byteArray.length);
    }

    public static byte[] e(C2941b c2941b) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            H(byteArrayOutputStream, c2941b);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static byte[] f(C2941b c2941b) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            I(byteArrayOutputStream, c2941b);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static String g(String str, String str2) {
        return "!".equals(str2) ? str.replace(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, "!") : Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR.equals(str2) ? str.replace("!", Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR) : str;
    }

    public static String h(String str) {
        int iIndexOf = str.indexOf("!");
        if (iIndexOf < 0) {
            iIndexOf = str.indexOf(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        }
        return iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
    }

    public static C2941b i(C2941b[] c2941bArr, String str) {
        if (c2941bArr.length <= 0) {
            return null;
        }
        String strH = h(str);
        for (int i8 = 0; i8 < c2941bArr.length; i8++) {
            if (c2941bArr[i8].f24110b.equals(strH)) {
                return c2941bArr[i8];
            }
        }
        return null;
    }

    public static String j(String str, String str2, byte[] bArr) {
        String strA = AbstractC2950k.a(bArr);
        if (str.length() <= 0) {
            return g(str2, strA);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)) {
            return g(str2, strA);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return str + AbstractC2950k.a(bArr) + str2;
    }

    public static int k(int i8) {
        return y(i8 * 2) / 8;
    }

    public static int l(int i8, int i9, int i10) {
        if (i8 == 1) {
            throw AbstractC2942c.c("HOT methods are not stored in the bitmap");
        }
        if (i8 == 2) {
            return i9;
        }
        if (i8 == 4) {
            return i9 + i10;
        }
        throw AbstractC2942c.c("Unexpected flag: " + i8);
    }

    public static int[] m(InputStream inputStream, int i8) {
        int[] iArr = new int[i8];
        int iH = 0;
        for (int i9 = 0; i9 < i8; i9++) {
            iH += AbstractC2942c.h(inputStream);
            iArr[i9] = iH;
        }
        return iArr;
    }

    public static int n(BitSet bitSet, int i8, int i9) {
        int i10 = bitSet.get(l(2, i8, i9)) ? 2 : 0;
        return bitSet.get(l(4, i8, i9)) ? i10 | 4 : i10;
    }

    public static byte[] o(InputStream inputStream, byte[] bArr) {
        if (Arrays.equals(bArr, AbstractC2942c.d(inputStream, bArr.length))) {
            return AbstractC2942c.d(inputStream, AbstractC2950k.f24136b.length);
        }
        throw AbstractC2942c.c("Invalid magic");
    }

    public static void p(InputStream inputStream, C2941b c2941b) {
        int iAvailable = inputStream.available() - c2941b.f24114f;
        int iH = 0;
        while (inputStream.available() > iAvailable) {
            iH += AbstractC2942c.h(inputStream);
            c2941b.f24117i.put(Integer.valueOf(iH), 1);
            for (int iH2 = AbstractC2942c.h(inputStream); iH2 > 0; iH2--) {
                A(inputStream);
            }
        }
        if (inputStream.available() != iAvailable) {
            throw AbstractC2942c.c("Read too much data during profile line parse");
        }
    }

    public static C2941b[] q(InputStream inputStream, byte[] bArr, byte[] bArr2, C2941b[] c2941bArr) {
        if (Arrays.equals(bArr, AbstractC2950k.f24140f)) {
            if (Arrays.equals(AbstractC2950k.f24135a, bArr2)) {
                throw AbstractC2942c.c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            }
            return r(inputStream, bArr, c2941bArr);
        }
        if (Arrays.equals(bArr, AbstractC2950k.f24141g)) {
            return t(inputStream, bArr2, c2941bArr);
        }
        throw AbstractC2942c.c("Unsupported meta version");
    }

    public static C2941b[] r(InputStream inputStream, byte[] bArr, C2941b[] c2941bArr) throws IOException {
        if (!Arrays.equals(bArr, AbstractC2950k.f24140f)) {
            throw AbstractC2942c.c("Unsupported meta version");
        }
        int iJ = AbstractC2942c.j(inputStream);
        byte[] bArrE = AbstractC2942c.e(inputStream, (int) AbstractC2942c.i(inputStream), (int) AbstractC2942c.i(inputStream));
        if (inputStream.read() > 0) {
            throw AbstractC2942c.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            C2941b[] c2941bArrS = s(byteArrayInputStream, iJ, c2941bArr);
            byteArrayInputStream.close();
            return c2941bArrS;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static C2941b[] s(InputStream inputStream, int i8, C2941b[] c2941bArr) {
        if (inputStream.available() == 0) {
            return new C2941b[0];
        }
        if (i8 != c2941bArr.length) {
            throw AbstractC2942c.c("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i8];
        int[] iArr = new int[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            int iH = AbstractC2942c.h(inputStream);
            iArr[i9] = AbstractC2942c.h(inputStream);
            strArr[i9] = AbstractC2942c.f(inputStream, iH);
        }
        for (int i10 = 0; i10 < i8; i10++) {
            C2941b c2941b = c2941bArr[i10];
            if (!c2941b.f24110b.equals(strArr[i10])) {
                throw AbstractC2942c.c("Order of dexfiles in metadata did not match baseline");
            }
            int i11 = iArr[i10];
            c2941b.f24113e = i11;
            c2941b.f24116h = m(inputStream, i11);
        }
        return c2941bArr;
    }

    public static C2941b[] t(InputStream inputStream, byte[] bArr, C2941b[] c2941bArr) throws IOException {
        int iH = AbstractC2942c.h(inputStream);
        byte[] bArrE = AbstractC2942c.e(inputStream, (int) AbstractC2942c.i(inputStream), (int) AbstractC2942c.i(inputStream));
        if (inputStream.read() > 0) {
            throw AbstractC2942c.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            C2941b[] c2941bArrU = u(byteArrayInputStream, bArr, iH, c2941bArr);
            byteArrayInputStream.close();
            return c2941bArrU;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static C2941b[] u(InputStream inputStream, byte[] bArr, int i8, C2941b[] c2941bArr) {
        if (inputStream.available() == 0) {
            return new C2941b[0];
        }
        if (i8 != c2941bArr.length) {
            throw AbstractC2942c.c("Mismatched number of dex files found in metadata");
        }
        for (int i9 = 0; i9 < i8; i9++) {
            AbstractC2942c.h(inputStream);
            String strF = AbstractC2942c.f(inputStream, AbstractC2942c.h(inputStream));
            long jI = AbstractC2942c.i(inputStream);
            int iH = AbstractC2942c.h(inputStream);
            C2941b c2941bI = i(c2941bArr, strF);
            if (c2941bI == null) {
                throw AbstractC2942c.c("Missing profile key: " + strF);
            }
            c2941bI.f24112d = jI;
            int[] iArrM = m(inputStream, iH);
            if (Arrays.equals(bArr, AbstractC2950k.f24139e)) {
                c2941bI.f24113e = iH;
                c2941bI.f24116h = iArrM;
            }
        }
        return c2941bArr;
    }

    public static void v(InputStream inputStream, C2941b c2941b) {
        BitSet bitSetValueOf = BitSet.valueOf(AbstractC2942c.d(inputStream, AbstractC2942c.a(c2941b.f24115g * 2)));
        int i8 = 0;
        while (true) {
            int i9 = c2941b.f24115g;
            if (i8 >= i9) {
                return;
            }
            int iN = n(bitSetValueOf, i8, i9);
            if (iN != 0) {
                Integer num = (Integer) c2941b.f24117i.get(Integer.valueOf(i8));
                if (num == null) {
                    num = 0;
                }
                c2941b.f24117i.put(Integer.valueOf(i8), Integer.valueOf(iN | num.intValue()));
            }
            i8++;
        }
    }

    public static C2941b[] w(InputStream inputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, AbstractC2950k.f24136b)) {
            throw AbstractC2942c.c("Unsupported version");
        }
        int iJ = AbstractC2942c.j(inputStream);
        byte[] bArrE = AbstractC2942c.e(inputStream, (int) AbstractC2942c.i(inputStream), (int) AbstractC2942c.i(inputStream));
        if (inputStream.read() > 0) {
            throw AbstractC2942c.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            C2941b[] c2941bArrX = x(byteArrayInputStream, str, iJ);
            byteArrayInputStream.close();
            return c2941bArrX;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static C2941b[] x(InputStream inputStream, String str, int i8) {
        if (inputStream.available() == 0) {
            return new C2941b[0];
        }
        C2941b[] c2941bArr = new C2941b[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            int iH = AbstractC2942c.h(inputStream);
            int iH2 = AbstractC2942c.h(inputStream);
            c2941bArr[i9] = new C2941b(str, AbstractC2942c.f(inputStream, iH), AbstractC2942c.i(inputStream), 0L, iH2, (int) AbstractC2942c.i(inputStream), (int) AbstractC2942c.i(inputStream), new int[iH2], new TreeMap());
        }
        for (int i10 = 0; i10 < i8; i10++) {
            C2941b c2941b = c2941bArr[i10];
            p(inputStream, c2941b);
            c2941b.f24116h = m(inputStream, c2941b.f24113e);
            v(inputStream, c2941b);
        }
        return c2941bArr;
    }

    public static int y(int i8) {
        return (i8 + 7) & (-8);
    }

    public static void z(byte[] bArr, int i8, int i9, C2941b c2941b) {
        int iL = l(i8, i9, c2941b.f24115g);
        int i10 = iL / 8;
        bArr[i10] = (byte) ((1 << (iL % 8)) | bArr[i10]);
    }
}
