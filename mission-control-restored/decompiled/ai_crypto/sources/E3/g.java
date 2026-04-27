package E3;

import com.google.protobuf.AbstractC1240i;
import java.math.RoundingMode;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[][] f1634c = {new byte[]{0, 0}, new byte[]{-128, 0}, new byte[]{-64, 0}, new byte[]{-32, 0}, new byte[]{-16, 0}, new byte[]{-8, 0}, new byte[]{-4, 0}, new byte[]{-2, 0}, new byte[]{-1, 0}, new byte[]{-1, -128}, new byte[]{-1, -64}};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1636b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f1635a = new byte[1024];

    public byte[] a() {
        return Arrays.copyOf(this.f1635a, this.f1636b);
    }

    public final void b(int i7) {
        int i8 = i7 + this.f1636b;
        byte[] bArr = this.f1635a;
        if (i8 <= bArr.length) {
            return;
        }
        int length = bArr.length * 2;
        if (length >= i8) {
            i8 = length;
        }
        this.f1635a = Arrays.copyOf(bArr, i8);
    }

    public void c(byte[] bArr) {
        b(bArr.length);
        for (byte b7 : bArr) {
            byte[] bArr2 = this.f1635a;
            int i7 = this.f1636b;
            this.f1636b = i7 + 1;
            bArr2[i7] = b7;
        }
    }

    public final int d(long j7) {
        if (j7 < 0) {
            j7 = ~j7;
        }
        return f.a(65 - Long.numberOfLeadingZeros(j7), 7, RoundingMode.UP);
    }

    public final int e(long j7) {
        return f.a(64 - Long.numberOfLeadingZeros(j7), 8, RoundingMode.UP);
    }

    public final void f(byte b7) {
        if (b7 == 0) {
            l((byte) 0);
            l((byte) -1);
        } else if (b7 != -1) {
            l(b7);
        } else {
            l((byte) -1);
            l((byte) 0);
        }
    }

    public final void g(byte b7) {
        if (b7 == 0) {
            m((byte) 0);
            m((byte) -1);
        } else if (b7 != -1) {
            m(b7);
        } else {
            m((byte) -1);
            m((byte) 0);
        }
    }

    public void h(AbstractC1240i abstractC1240i) {
        for (int i7 = 0; i7 < abstractC1240i.size(); i7++) {
            f(abstractC1240i.g(i7));
        }
        p();
    }

    public void i(AbstractC1240i abstractC1240i) {
        for (int i7 = 0; i7 < abstractC1240i.size(); i7++) {
            g(abstractC1240i.g(i7));
        }
        q();
    }

    public void j(double d7) {
        long jDoubleToLongBits = Double.doubleToLongBits(d7);
        t(jDoubleToLongBits ^ (jDoubleToLongBits < 0 ? -1L : Long.MIN_VALUE));
    }

    public void k(double d7) {
        long jDoubleToLongBits = Double.doubleToLongBits(d7);
        u(jDoubleToLongBits ^ (jDoubleToLongBits < 0 ? -1L : Long.MIN_VALUE));
    }

    public final void l(byte b7) {
        b(1);
        byte[] bArr = this.f1635a;
        int i7 = this.f1636b;
        this.f1636b = i7 + 1;
        bArr[i7] = b7;
    }

    public final void m(byte b7) {
        b(1);
        byte[] bArr = this.f1635a;
        int i7 = this.f1636b;
        this.f1636b = i7 + 1;
        bArr[i7] = (byte) (~b7);
    }

    public void n() {
        l((byte) -1);
        l((byte) -1);
    }

    public void o() {
        m((byte) -1);
        m((byte) -1);
    }

    public final void p() {
        l((byte) 0);
        l((byte) 1);
    }

    public final void q() {
        m((byte) 0);
        m((byte) 1);
    }

    public void r(long j7) {
        int i7;
        long j8 = j7 < 0 ? ~j7 : j7;
        if (j8 < 64) {
            b(1);
            byte[] bArr = this.f1635a;
            int i8 = this.f1636b;
            this.f1636b = i8 + 1;
            bArr[i8] = (byte) (j7 ^ ((long) f1634c[1][0]));
            return;
        }
        int iD = d(j8);
        b(iD);
        if (iD < 2) {
            throw new AssertionError(String.format("Invalid length (%d) returned by signedNumLength", Integer.valueOf(iD)));
        }
        byte b7 = j7 < 0 ? (byte) -1 : (byte) 0;
        int i9 = this.f1636b;
        if (iD == 10) {
            i7 = i9 + 2;
            byte[] bArr2 = this.f1635a;
            bArr2[i9] = b7;
            bArr2[i9 + 1] = b7;
        } else if (iD == 9) {
            i7 = i9 + 1;
            this.f1635a[i9] = b7;
        } else {
            i7 = i9;
        }
        for (int i10 = (iD - 1) + i9; i10 >= i7; i10--) {
            this.f1635a[i10] = (byte) (255 & j7);
            j7 >>= 8;
        }
        byte[] bArr3 = this.f1635a;
        int i11 = this.f1636b;
        byte b8 = bArr3[i11];
        byte[] bArr4 = f1634c[iD];
        bArr3[i11] = (byte) (b8 ^ bArr4[0]);
        int i12 = i11 + 1;
        bArr3[i12] = (byte) (bArr4[1] ^ bArr3[i12]);
        this.f1636b = i11 + iD;
    }

    public void s(long j7) {
        r(~j7);
    }

    public void t(long j7) {
        int iE = e(j7);
        b(iE + 1);
        byte[] bArr = this.f1635a;
        int i7 = this.f1636b;
        int i8 = i7 + 1;
        this.f1636b = i8;
        bArr[i7] = (byte) iE;
        int i9 = i8 + iE;
        while (true) {
            i9--;
            int i10 = this.f1636b;
            if (i9 < i10) {
                this.f1636b = i10 + iE;
                return;
            } else {
                this.f1635a[i9] = (byte) (255 & j7);
                j7 >>>= 8;
            }
        }
    }

    public void u(long j7) {
        int iE = e(j7);
        b(iE + 1);
        byte[] bArr = this.f1635a;
        int i7 = this.f1636b;
        int i8 = i7 + 1;
        this.f1636b = i8;
        bArr[i7] = (byte) (~iE);
        int i9 = i8 + iE;
        while (true) {
            i9--;
            int i10 = this.f1636b;
            if (i9 < i10) {
                this.f1636b = i10 + iE;
                return;
            } else {
                this.f1635a[i9] = (byte) (~(255 & j7));
                j7 >>>= 8;
            }
        }
    }

    public void v(CharSequence charSequence) {
        int length = charSequence.length();
        int i7 = 0;
        while (i7 < length) {
            char cCharAt = charSequence.charAt(i7);
            if (cCharAt < 128) {
                f((byte) cCharAt);
            } else if (cCharAt < 2048) {
                f((byte) ((cCharAt >>> 6) | 960));
                f((byte) ((cCharAt & '?') | 128));
            } else if (cCharAt < 55296 || 57343 < cCharAt) {
                f((byte) ((cCharAt >>> '\f') | 480));
                f((byte) (((cCharAt >>> 6) & 63) | 128));
                f((byte) ((cCharAt & '?') | 128));
            } else {
                int iCodePointAt = Character.codePointAt(charSequence, i7);
                i7++;
                f((byte) ((iCodePointAt >>> 18) | 240));
                f((byte) (((iCodePointAt >>> 12) & 63) | 128));
                f((byte) (((iCodePointAt >>> 6) & 63) | 128));
                f((byte) ((iCodePointAt & 63) | 128));
            }
            i7++;
        }
        p();
    }

    public void w(CharSequence charSequence) {
        int length = charSequence.length();
        int i7 = 0;
        while (i7 < length) {
            char cCharAt = charSequence.charAt(i7);
            if (cCharAt < 128) {
                g((byte) cCharAt);
            } else if (cCharAt < 2048) {
                g((byte) ((cCharAt >>> 6) | 960));
                g((byte) ((cCharAt & '?') | 128));
            } else if (cCharAt < 55296 || 57343 < cCharAt) {
                g((byte) ((cCharAt >>> '\f') | 480));
                g((byte) (((cCharAt >>> 6) & 63) | 128));
                g((byte) ((cCharAt & '?') | 128));
            } else {
                int iCodePointAt = Character.codePointAt(charSequence, i7);
                i7++;
                g((byte) ((iCodePointAt >>> 18) | 240));
                g((byte) (((iCodePointAt >>> 12) & 63) | 128));
                g((byte) (((iCodePointAt >>> 6) & 63) | 128));
                g((byte) ((iCodePointAt & 63) | 128));
            }
            i7++;
        }
        q();
    }
}
