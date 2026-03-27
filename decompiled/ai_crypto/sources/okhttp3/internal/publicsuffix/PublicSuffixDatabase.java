package okhttp3.internal.publicsuffix;

import com.amazon.a.a.o.c.a.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import w6.C2802o;
import w6.InterfaceC2794g;
import w6.L;

/* JADX INFO: loaded from: classes2.dex */
public final class PublicSuffixDatabase {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f21085e = {42};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f21086f = new String[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f21087g = {"*"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final PublicSuffixDatabase f21088h = new PublicSuffixDatabase();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f21089a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CountDownLatch f21090b = new CountDownLatch(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f21091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f21092d;

    public static String a(byte[] bArr, byte[][] bArr2, int i7) {
        int i8;
        boolean z7;
        int i9;
        int i10;
        int length = bArr.length;
        int i11 = 0;
        while (i11 < length) {
            int i12 = (i11 + length) / 2;
            while (i12 > -1 && bArr[i12] != 10) {
                i12--;
            }
            int i13 = i12 + 1;
            int i14 = 1;
            while (true) {
                i8 = i13 + i14;
                if (bArr[i8] == 10) {
                    break;
                }
                i14++;
            }
            int i15 = i8 - i13;
            int i16 = i7;
            boolean z8 = false;
            int i17 = 0;
            int i18 = 0;
            while (true) {
                if (z8) {
                    i9 = 46;
                    z7 = false;
                } else {
                    z7 = z8;
                    i9 = bArr2[i16][i17] & 255;
                }
                i10 = i9 - (bArr[i13 + i18] & 255);
                if (i10 == 0) {
                    i18++;
                    i17++;
                    if (i18 == i15) {
                        break;
                    }
                    if (bArr2[i16].length != i17) {
                        z8 = z7;
                    } else {
                        if (i16 == bArr2.length - 1) {
                            break;
                        }
                        i16++;
                        i17 = -1;
                        z8 = true;
                    }
                } else {
                    break;
                }
            }
            if (i10 >= 0) {
                if (i10 <= 0) {
                    int i19 = i15 - i18;
                    int length2 = bArr2[i16].length - i17;
                    while (true) {
                        i16++;
                        if (i16 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i16].length;
                    }
                    if (length2 >= i19) {
                        if (length2 <= i19) {
                            return new String(bArr, i13, i15, Util.f20679j);
                        }
                    }
                }
                i11 = i8 + 1;
            }
            length = i12;
        }
        return null;
    }

    public static PublicSuffixDatabase c() {
        return f21088h;
    }

    public final String[] b(String[] strArr) {
        String str;
        String strA;
        String strA2;
        int i7 = 0;
        if (this.f21089a.get() || !this.f21089a.compareAndSet(false, true)) {
            try {
                this.f21090b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            f();
        }
        synchronized (this) {
            if (this.f21091c == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length][];
        for (int i8 = 0; i8 < strArr.length; i8++) {
            bArr[i8] = strArr[i8].getBytes(Util.f20679j);
        }
        int i9 = 0;
        while (true) {
            str = null;
            if (i9 >= length) {
                strA = null;
                break;
            }
            strA = a(this.f21091c, bArr, i9);
            if (strA != null) {
                break;
            }
            i9++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i10 = 0; i10 < bArr2.length - 1; i10++) {
                bArr2[i10] = f21085e;
                strA2 = a(this.f21091c, bArr2, i10);
                if (strA2 != null) {
                    break;
                }
            }
            strA2 = null;
        } else {
            strA2 = null;
        }
        if (strA2 != null) {
            while (true) {
                if (i7 >= length - 1) {
                    break;
                }
                String strA3 = a(this.f21092d, bArr, i7);
                if (strA3 != null) {
                    str = strA3;
                    break;
                }
                i7++;
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        }
        if (strA == null && strA2 == null) {
            return f21087g;
        }
        String[] strArrSplit = strA != null ? strA.split("\\.") : f21086f;
        String[] strArrSplit2 = strA2 != null ? strA2.split("\\.") : f21086f;
        return strArrSplit.length > strArrSplit2.length ? strArrSplit : strArrSplit2;
    }

    public String d(String str) {
        int length;
        int length2;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] strArrSplit = IDN.toUnicode(str).split("\\.");
        String[] strArrB = b(strArrSplit);
        if (strArrSplit.length == strArrB.length && strArrB[0].charAt(0) != '!') {
            return null;
        }
        if (strArrB[0].charAt(0) == '!') {
            length = strArrSplit.length;
            length2 = strArrB.length;
        } else {
            length = strArrSplit.length;
            length2 = strArrB.length + 1;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArrSplit2 = str.split("\\.");
        for (int i7 = length - length2; i7 < strArrSplit2.length; i7++) {
            sb.append(strArrSplit2[i7]);
            sb.append(b.f10001a);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public final void e() {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        InterfaceC2794g interfaceC2794gD = L.d(new C2802o(L.l(resourceAsStream)));
        try {
            byte[] bArr = new byte[interfaceC2794gD.readInt()];
            interfaceC2794gD.readFully(bArr);
            byte[] bArr2 = new byte[interfaceC2794gD.readInt()];
            interfaceC2794gD.readFully(bArr2);
            synchronized (this) {
                this.f21091c = bArr;
                this.f21092d = bArr2;
            }
            this.f21090b.countDown();
        } finally {
            Util.f(interfaceC2794gD);
        }
    }

    public final void f() {
        boolean z7 = false;
        while (true) {
            try {
                try {
                    e();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z7 = true;
                } catch (IOException e7) {
                    Platform.l().s(5, "Failed to read public suffix list", e7);
                    if (z7) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z7) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z7) {
            Thread.currentThread().interrupt();
        }
    }
}
