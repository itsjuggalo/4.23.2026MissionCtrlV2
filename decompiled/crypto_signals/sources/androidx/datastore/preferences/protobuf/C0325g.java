package androidx.datastore.preferences.protobuf;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import s3.AbstractC1024h;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0325g implements Iterable, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0325g f4550c = new C0325g(AbstractC0341x.f4617b);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0323e f4551d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4552a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f4553b;

    static {
        f4551d = AbstractC0321c.a() ? new C0323e(1) : new C0323e(0);
    }

    public C0325g(byte[] bArr) {
        bArr.getClass();
        this.f4553b = bArr;
    }

    public static int b(int i, int i6, int i7) {
        int i8 = i6 - i;
        if ((i | i6 | i8 | (i7 - i6)) >= 0) {
            return i8;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(a3.d.i("Beginning index: ", i, " < 0"));
        }
        if (i6 < i) {
            throw new IndexOutOfBoundsException(a3.d.h("Beginning index larger than ending index: ", i, i6, ", "));
        }
        throw new IndexOutOfBoundsException(a3.d.h("End index: ", i6, i7, " >= "));
    }

    public static C0325g c(byte[] bArr, int i, int i6) {
        byte[] bArrCopyOfRange;
        b(i, i + i6, bArr.length);
        switch (f4551d.f4547a) {
            case 0:
                bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i6 + i);
                break;
            default:
                bArrCopyOfRange = new byte[i6];
                System.arraycopy(bArr, i, bArrCopyOfRange, 0, i6);
                break;
        }
        return new C0325g(bArrCopyOfRange);
    }

    public byte a(int i) {
        return this.f4553b[i];
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0325g) || size() != ((C0325g) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof C0325g)) {
            return obj.equals(this);
        }
        C0325g c0325g = (C0325g) obj;
        int i = this.f4552a;
        int i6 = c0325g.f4552a;
        if (i != 0 && i6 != 0 && i != i6) {
            return false;
        }
        int size = size();
        if (size > c0325g.size()) {
            throw new IllegalArgumentException("Length too large: " + size + size());
        }
        if (size > c0325g.size()) {
            StringBuilder sbO = a3.d.o("Ran off end of other: 0, ", size, ", ");
            sbO.append(c0325g.size());
            throw new IllegalArgumentException(sbO.toString());
        }
        int iH = h() + size;
        int iH2 = h();
        int iH3 = c0325g.h();
        while (iH2 < iH) {
            if (this.f4553b[iH2] != c0325g.f4553b[iH3]) {
                return false;
            }
            iH2++;
            iH3++;
        }
        return true;
    }

    public void f(byte[] bArr, int i) {
        System.arraycopy(this.f4553b, 0, bArr, 0, i);
    }

    public int h() {
        return 0;
    }

    public final int hashCode() {
        int i = this.f4552a;
        if (i != 0) {
            return i;
        }
        int size = size();
        int iH = h();
        int i6 = size;
        for (int i7 = iH; i7 < iH + size; i7++) {
            i6 = (i6 * 31) + this.f4553b[i7];
        }
        if (i6 == 0) {
            i6 = 1;
        }
        this.f4552a = i6;
        return i6;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new C0322d(this);
    }

    public byte k(int i) {
        return this.f4553b[i];
    }

    public int size() {
        return this.f4553b.length;
    }

    public final String toString() {
        C0325g c0324f;
        String string;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int size = size();
        if (size() <= 50) {
            string = s3.D.I(this);
        } else {
            StringBuilder sb = new StringBuilder();
            int iB = b(0, 47, size());
            if (iB == 0) {
                c0324f = f4550c;
            } else {
                c0324f = new C0324f(this.f4553b, h(), iB);
            }
            sb.append(s3.D.I(c0324f));
            sb.append("...");
            string = sb.toString();
        }
        StringBuilder sb2 = new StringBuilder("<ByteString@");
        sb2.append(hexString);
        sb2.append(" size=");
        sb2.append(size);
        sb2.append(" contents=\"");
        return AbstractC1024h.d(sb2, string, "\">");
    }
}
