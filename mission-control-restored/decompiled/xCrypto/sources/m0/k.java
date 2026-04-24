package m0;

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

/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f13512a = {112, 114, 111, 0};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f13513b = {112, 114, 109, 0};

    public static void A(InputStream inputStream) {
        AbstractC1597c.h(inputStream);
        int iJ = AbstractC1597c.j(inputStream);
        if (iJ == 6 || iJ == 7) {
            return;
        }
        while (iJ > 0) {
            AbstractC1597c.j(inputStream);
            for (int iJ2 = AbstractC1597c.j(inputStream); iJ2 > 0; iJ2--) {
                AbstractC1597c.h(inputStream);
            }
            iJ--;
        }
    }

    public static boolean B(OutputStream outputStream, byte[] bArr, C1596b[] c1596bArr) throws IOException {
        if (Arrays.equals(bArr, l.f13514a)) {
            N(outputStream, c1596bArr);
            return true;
        }
        if (Arrays.equals(bArr, l.f13515b)) {
            M(outputStream, c1596bArr);
            return true;
        }
        if (Arrays.equals(bArr, l.f13517d)) {
            K(outputStream, c1596bArr);
            return true;
        }
        if (Arrays.equals(bArr, l.f13516c)) {
            L(outputStream, c1596bArr);
            return true;
        }
        if (!Arrays.equals(bArr, l.f13518e)) {
            return false;
        }
        J(outputStream, c1596bArr);
        return true;
    }

    public static void C(OutputStream outputStream, C1596b c1596b) throws IOException {
        int[] iArr = c1596b.f13495h;
        int length = iArr.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int i6 = iArr[i4];
            AbstractC1597c.p(outputStream, i6 - i5);
            i4++;
            i5 = i6;
        }
    }

    public static m D(C1596b[] c1596bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            AbstractC1597c.p(byteArrayOutputStream, c1596bArr.length);
            int i4 = 2;
            for (C1596b c1596b : c1596bArr) {
                AbstractC1597c.q(byteArrayOutputStream, c1596b.f13490c);
                AbstractC1597c.q(byteArrayOutputStream, c1596b.f13491d);
                AbstractC1597c.q(byteArrayOutputStream, c1596b.f13494g);
                String strJ = j(c1596b.f13488a, c1596b.f13489b, l.f13514a);
                int iK = AbstractC1597c.k(strJ);
                AbstractC1597c.p(byteArrayOutputStream, iK);
                i4 = i4 + 14 + iK;
                AbstractC1597c.n(byteArrayOutputStream, strJ);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i4 == byteArray.length) {
                m mVar = new m(EnumC1598d.DEX_FILES, i4, byteArray, false);
                byteArrayOutputStream.close();
                return mVar;
            }
            throw AbstractC1597c.c("Expected size " + i4 + ", does not match actual size " + byteArray.length);
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
        outputStream.write(f13512a);
        outputStream.write(bArr);
    }

    public static void F(OutputStream outputStream, C1596b c1596b) throws IOException {
        I(outputStream, c1596b);
        C(outputStream, c1596b);
        H(outputStream, c1596b);
    }

    public static void G(OutputStream outputStream, C1596b c1596b, String str) throws IOException {
        AbstractC1597c.p(outputStream, AbstractC1597c.k(str));
        AbstractC1597c.p(outputStream, c1596b.f13492e);
        AbstractC1597c.q(outputStream, c1596b.f13493f);
        AbstractC1597c.q(outputStream, c1596b.f13490c);
        AbstractC1597c.q(outputStream, c1596b.f13494g);
        AbstractC1597c.n(outputStream, str);
    }

    public static void H(OutputStream outputStream, C1596b c1596b) throws IOException {
        byte[] bArr = new byte[k(c1596b.f13494g)];
        for (Map.Entry entry : c1596b.f13496i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            if ((iIntValue2 & 2) != 0) {
                z(bArr, 2, iIntValue, c1596b);
            }
            if ((iIntValue2 & 4) != 0) {
                z(bArr, 4, iIntValue, c1596b);
            }
        }
        outputStream.write(bArr);
    }

    public static void I(OutputStream outputStream, C1596b c1596b) throws IOException {
        int i4 = 0;
        for (Map.Entry entry : c1596b.f13496i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                AbstractC1597c.p(outputStream, iIntValue - i4);
                AbstractC1597c.p(outputStream, 0);
                i4 = iIntValue;
            }
        }
    }

    public static void J(OutputStream outputStream, C1596b[] c1596bArr) throws IOException {
        AbstractC1597c.p(outputStream, c1596bArr.length);
        for (C1596b c1596b : c1596bArr) {
            String strJ = j(c1596b.f13488a, c1596b.f13489b, l.f13518e);
            AbstractC1597c.p(outputStream, AbstractC1597c.k(strJ));
            AbstractC1597c.p(outputStream, c1596b.f13496i.size());
            AbstractC1597c.p(outputStream, c1596b.f13495h.length);
            AbstractC1597c.q(outputStream, c1596b.f13490c);
            AbstractC1597c.n(outputStream, strJ);
            Iterator it = c1596b.f13496i.keySet().iterator();
            while (it.hasNext()) {
                AbstractC1597c.p(outputStream, ((Integer) it.next()).intValue());
            }
            for (int i4 : c1596b.f13495h) {
                AbstractC1597c.p(outputStream, i4);
            }
        }
    }

    public static void K(OutputStream outputStream, C1596b[] c1596bArr) throws IOException {
        AbstractC1597c.r(outputStream, c1596bArr.length);
        for (C1596b c1596b : c1596bArr) {
            int size = c1596b.f13496i.size() * 4;
            String strJ = j(c1596b.f13488a, c1596b.f13489b, l.f13517d);
            AbstractC1597c.p(outputStream, AbstractC1597c.k(strJ));
            AbstractC1597c.p(outputStream, c1596b.f13495h.length);
            AbstractC1597c.q(outputStream, size);
            AbstractC1597c.q(outputStream, c1596b.f13490c);
            AbstractC1597c.n(outputStream, strJ);
            Iterator it = c1596b.f13496i.keySet().iterator();
            while (it.hasNext()) {
                AbstractC1597c.p(outputStream, ((Integer) it.next()).intValue());
                AbstractC1597c.p(outputStream, 0);
            }
            for (int i4 : c1596b.f13495h) {
                AbstractC1597c.p(outputStream, i4);
            }
        }
    }

    public static void L(OutputStream outputStream, C1596b[] c1596bArr) throws IOException {
        byte[] bArrB = b(c1596bArr, l.f13516c);
        AbstractC1597c.r(outputStream, c1596bArr.length);
        AbstractC1597c.m(outputStream, bArrB);
    }

    public static void M(OutputStream outputStream, C1596b[] c1596bArr) throws IOException {
        byte[] bArrB = b(c1596bArr, l.f13515b);
        AbstractC1597c.r(outputStream, c1596bArr.length);
        AbstractC1597c.m(outputStream, bArrB);
    }

    public static void N(OutputStream outputStream, C1596b[] c1596bArr) throws IOException {
        O(outputStream, c1596bArr);
    }

    public static void O(OutputStream outputStream, C1596b[] c1596bArr) throws IOException {
        int length;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(D(c1596bArr));
        arrayList.add(c(c1596bArr));
        arrayList.add(d(c1596bArr));
        long length2 = ((long) l.f13514a.length) + ((long) f13512a.length) + 4 + ((long) (arrayList.size() * 16));
        AbstractC1597c.q(outputStream, arrayList.size());
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            m mVar = (m) arrayList.get(i4);
            AbstractC1597c.q(outputStream, mVar.f13521a.c());
            AbstractC1597c.q(outputStream, length2);
            if (mVar.f13524d) {
                byte[] bArr = mVar.f13523c;
                long length3 = bArr.length;
                byte[] bArrB = AbstractC1597c.b(bArr);
                arrayList2.add(bArrB);
                AbstractC1597c.q(outputStream, bArrB.length);
                AbstractC1597c.q(outputStream, length3);
                length = bArrB.length;
            } else {
                arrayList2.add(mVar.f13523c);
                AbstractC1597c.q(outputStream, mVar.f13523c.length);
                AbstractC1597c.q(outputStream, 0L);
                length = mVar.f13523c.length;
            }
            length2 += (long) length;
        }
        for (int i5 = 0; i5 < arrayList2.size(); i5++) {
            outputStream.write((byte[]) arrayList2.get(i5));
        }
    }

    public static int a(C1596b c1596b) {
        Iterator it = c1596b.f13496i.entrySet().iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue |= ((Integer) ((Map.Entry) it.next()).getValue()).intValue();
        }
        return iIntValue;
    }

    public static byte[] b(C1596b[] c1596bArr, byte[] bArr) throws IOException {
        int i4 = 0;
        int iK = 0;
        for (C1596b c1596b : c1596bArr) {
            iK += AbstractC1597c.k(j(c1596b.f13488a, c1596b.f13489b, bArr)) + 16 + (c1596b.f13492e * 2) + c1596b.f13493f + k(c1596b.f13494g);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(iK);
        if (Arrays.equals(bArr, l.f13516c)) {
            int length = c1596bArr.length;
            while (i4 < length) {
                C1596b c1596b2 = c1596bArr[i4];
                G(byteArrayOutputStream, c1596b2, j(c1596b2.f13488a, c1596b2.f13489b, bArr));
                F(byteArrayOutputStream, c1596b2);
                i4++;
            }
        } else {
            for (C1596b c1596b3 : c1596bArr) {
                G(byteArrayOutputStream, c1596b3, j(c1596b3.f13488a, c1596b3.f13489b, bArr));
            }
            int length2 = c1596bArr.length;
            while (i4 < length2) {
                F(byteArrayOutputStream, c1596bArr[i4]);
                i4++;
            }
        }
        if (byteArrayOutputStream.size() == iK) {
            return byteArrayOutputStream.toByteArray();
        }
        throw AbstractC1597c.c("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + iK);
    }

    public static m c(C1596b[] c1596bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i4 = 0;
        for (int i5 = 0; i5 < c1596bArr.length; i5++) {
            try {
                C1596b c1596b = c1596bArr[i5];
                AbstractC1597c.p(byteArrayOutputStream, i5);
                AbstractC1597c.p(byteArrayOutputStream, c1596b.f13492e);
                i4 = i4 + 4 + (c1596b.f13492e * 2);
                C(byteArrayOutputStream, c1596b);
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
        if (i4 == byteArray.length) {
            m mVar = new m(EnumC1598d.CLASSES, i4, byteArray, true);
            byteArrayOutputStream.close();
            return mVar;
        }
        throw AbstractC1597c.c("Expected size " + i4 + ", does not match actual size " + byteArray.length);
    }

    public static m d(C1596b[] c1596bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i4 = 0;
        for (int i5 = 0; i5 < c1596bArr.length; i5++) {
            try {
                C1596b c1596b = c1596bArr[i5];
                int iA = a(c1596b);
                byte[] bArrE = e(c1596b);
                byte[] bArrF = f(c1596b);
                AbstractC1597c.p(byteArrayOutputStream, i5);
                int length = bArrE.length + 2 + bArrF.length;
                AbstractC1597c.q(byteArrayOutputStream, length);
                AbstractC1597c.p(byteArrayOutputStream, iA);
                byteArrayOutputStream.write(bArrE);
                byteArrayOutputStream.write(bArrF);
                i4 = i4 + 6 + length;
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
        if (i4 == byteArray.length) {
            m mVar = new m(EnumC1598d.METHODS, i4, byteArray, true);
            byteArrayOutputStream.close();
            return mVar;
        }
        throw AbstractC1597c.c("Expected size " + i4 + ", does not match actual size " + byteArray.length);
    }

    public static byte[] e(C1596b c1596b) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            H(byteArrayOutputStream, c1596b);
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

    public static byte[] f(C1596b c1596b) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            I(byteArrayOutputStream, c1596b);
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

    public static C1596b i(C1596b[] c1596bArr, String str) {
        if (c1596bArr.length <= 0) {
            return null;
        }
        String strH = h(str);
        for (int i4 = 0; i4 < c1596bArr.length; i4++) {
            if (c1596bArr[i4].f13489b.equals(strH)) {
                return c1596bArr[i4];
            }
        }
        return null;
    }

    public static String j(String str, String str2, byte[] bArr) {
        String strA = l.a(bArr);
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
        return str + l.a(bArr) + str2;
    }

    public static int k(int i4) {
        return y(i4 * 2) / 8;
    }

    public static int l(int i4, int i5, int i6) {
        if (i4 == 1) {
            throw AbstractC1597c.c("HOT methods are not stored in the bitmap");
        }
        if (i4 == 2) {
            return i5;
        }
        if (i4 == 4) {
            return i5 + i6;
        }
        throw AbstractC1597c.c("Unexpected flag: " + i4);
    }

    public static int[] m(InputStream inputStream, int i4) {
        int[] iArr = new int[i4];
        int iH = 0;
        for (int i5 = 0; i5 < i4; i5++) {
            iH += AbstractC1597c.h(inputStream);
            iArr[i5] = iH;
        }
        return iArr;
    }

    public static int n(BitSet bitSet, int i4, int i5) {
        int i6 = bitSet.get(l(2, i4, i5)) ? 2 : 0;
        return bitSet.get(l(4, i4, i5)) ? i6 | 4 : i6;
    }

    public static byte[] o(InputStream inputStream, byte[] bArr) {
        if (Arrays.equals(bArr, AbstractC1597c.d(inputStream, bArr.length))) {
            return AbstractC1597c.d(inputStream, l.f13515b.length);
        }
        throw AbstractC1597c.c("Invalid magic");
    }

    public static void p(InputStream inputStream, C1596b c1596b) {
        int iAvailable = inputStream.available() - c1596b.f13493f;
        int iH = 0;
        while (inputStream.available() > iAvailable) {
            iH += AbstractC1597c.h(inputStream);
            c1596b.f13496i.put(Integer.valueOf(iH), 1);
            for (int iH2 = AbstractC1597c.h(inputStream); iH2 > 0; iH2--) {
                A(inputStream);
            }
        }
        if (inputStream.available() != iAvailable) {
            throw AbstractC1597c.c("Read too much data during profile line parse");
        }
    }

    public static C1596b[] q(InputStream inputStream, byte[] bArr, byte[] bArr2, C1596b[] c1596bArr) {
        if (Arrays.equals(bArr, l.f13519f)) {
            if (Arrays.equals(l.f13514a, bArr2)) {
                throw AbstractC1597c.c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            }
            return r(inputStream, bArr, c1596bArr);
        }
        if (Arrays.equals(bArr, l.f13520g)) {
            return t(inputStream, bArr2, c1596bArr);
        }
        throw AbstractC1597c.c("Unsupported meta version");
    }

    public static C1596b[] r(InputStream inputStream, byte[] bArr, C1596b[] c1596bArr) throws IOException {
        if (!Arrays.equals(bArr, l.f13519f)) {
            throw AbstractC1597c.c("Unsupported meta version");
        }
        int iJ = AbstractC1597c.j(inputStream);
        byte[] bArrE = AbstractC1597c.e(inputStream, (int) AbstractC1597c.i(inputStream), (int) AbstractC1597c.i(inputStream));
        if (inputStream.read() > 0) {
            throw AbstractC1597c.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            C1596b[] c1596bArrS = s(byteArrayInputStream, iJ, c1596bArr);
            byteArrayInputStream.close();
            return c1596bArrS;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static C1596b[] s(InputStream inputStream, int i4, C1596b[] c1596bArr) {
        if (inputStream.available() == 0) {
            return new C1596b[0];
        }
        if (i4 != c1596bArr.length) {
            throw AbstractC1597c.c("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i4];
        int[] iArr = new int[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            int iH = AbstractC1597c.h(inputStream);
            iArr[i5] = AbstractC1597c.h(inputStream);
            strArr[i5] = AbstractC1597c.f(inputStream, iH);
        }
        for (int i6 = 0; i6 < i4; i6++) {
            C1596b c1596b = c1596bArr[i6];
            if (!c1596b.f13489b.equals(strArr[i6])) {
                throw AbstractC1597c.c("Order of dexfiles in metadata did not match baseline");
            }
            int i7 = iArr[i6];
            c1596b.f13492e = i7;
            c1596b.f13495h = m(inputStream, i7);
        }
        return c1596bArr;
    }

    public static C1596b[] t(InputStream inputStream, byte[] bArr, C1596b[] c1596bArr) throws IOException {
        int iH = AbstractC1597c.h(inputStream);
        byte[] bArrE = AbstractC1597c.e(inputStream, (int) AbstractC1597c.i(inputStream), (int) AbstractC1597c.i(inputStream));
        if (inputStream.read() > 0) {
            throw AbstractC1597c.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            C1596b[] c1596bArrU = u(byteArrayInputStream, bArr, iH, c1596bArr);
            byteArrayInputStream.close();
            return c1596bArrU;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static C1596b[] u(InputStream inputStream, byte[] bArr, int i4, C1596b[] c1596bArr) {
        if (inputStream.available() == 0) {
            return new C1596b[0];
        }
        if (i4 != c1596bArr.length) {
            throw AbstractC1597c.c("Mismatched number of dex files found in metadata");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            AbstractC1597c.h(inputStream);
            String strF = AbstractC1597c.f(inputStream, AbstractC1597c.h(inputStream));
            long jI = AbstractC1597c.i(inputStream);
            int iH = AbstractC1597c.h(inputStream);
            C1596b c1596bI = i(c1596bArr, strF);
            if (c1596bI == null) {
                throw AbstractC1597c.c("Missing profile key: " + strF);
            }
            c1596bI.f13491d = jI;
            int[] iArrM = m(inputStream, iH);
            if (Arrays.equals(bArr, l.f13518e)) {
                c1596bI.f13492e = iH;
                c1596bI.f13495h = iArrM;
            }
        }
        return c1596bArr;
    }

    public static void v(InputStream inputStream, C1596b c1596b) {
        BitSet bitSetValueOf = BitSet.valueOf(AbstractC1597c.d(inputStream, AbstractC1597c.a(c1596b.f13494g * 2)));
        int i4 = 0;
        while (true) {
            int i5 = c1596b.f13494g;
            if (i4 >= i5) {
                return;
            }
            int iN = n(bitSetValueOf, i4, i5);
            if (iN != 0) {
                Integer num = (Integer) c1596b.f13496i.get(Integer.valueOf(i4));
                if (num == null) {
                    num = 0;
                }
                c1596b.f13496i.put(Integer.valueOf(i4), Integer.valueOf(iN | num.intValue()));
            }
            i4++;
        }
    }

    public static C1596b[] w(InputStream inputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, l.f13515b)) {
            throw AbstractC1597c.c("Unsupported version");
        }
        int iJ = AbstractC1597c.j(inputStream);
        byte[] bArrE = AbstractC1597c.e(inputStream, (int) AbstractC1597c.i(inputStream), (int) AbstractC1597c.i(inputStream));
        if (inputStream.read() > 0) {
            throw AbstractC1597c.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            C1596b[] c1596bArrX = x(byteArrayInputStream, str, iJ);
            byteArrayInputStream.close();
            return c1596bArrX;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static C1596b[] x(InputStream inputStream, String str, int i4) {
        if (inputStream.available() == 0) {
            return new C1596b[0];
        }
        C1596b[] c1596bArr = new C1596b[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            int iH = AbstractC1597c.h(inputStream);
            int iH2 = AbstractC1597c.h(inputStream);
            c1596bArr[i5] = new C1596b(str, AbstractC1597c.f(inputStream, iH), AbstractC1597c.i(inputStream), 0L, iH2, (int) AbstractC1597c.i(inputStream), (int) AbstractC1597c.i(inputStream), new int[iH2], new TreeMap());
        }
        for (int i6 = 0; i6 < i4; i6++) {
            C1596b c1596b = c1596bArr[i6];
            p(inputStream, c1596b);
            c1596b.f13495h = m(inputStream, c1596b.f13492e);
            v(inputStream, c1596b);
        }
        return c1596bArr;
    }

    public static int y(int i4) {
        return (i4 + 7) & (-8);
    }

    public static void z(byte[] bArr, int i4, int i5, C1596b c1596b) {
        int iL = l(i4, i5, c1596b.f13494g);
        int i6 = iL / 8;
        bArr[i6] = (byte) ((1 << (iL % 8)) | bArr[i6]);
    }
}
