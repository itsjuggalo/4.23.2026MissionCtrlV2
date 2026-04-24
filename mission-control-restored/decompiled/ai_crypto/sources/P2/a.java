package P2;

import O2.g;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f4324a;

    public a(byte[] bArr, int i7, int i8) {
        byte[] bArr2 = new byte[i8];
        this.f4324a = bArr2;
        System.arraycopy(bArr, i7, bArr2, 0, i8);
    }

    public static a a(byte[] bArr) {
        if (bArr != null) {
            return b(bArr, 0, bArr.length);
        }
        throw new NullPointerException("data must be non-null");
    }

    public static a b(byte[] bArr, int i7, int i8) {
        if (bArr != null) {
            return new a(bArr, i7, i8);
        }
        throw new NullPointerException("data must be non-null");
    }

    public byte[] c() {
        byte[] bArr = this.f4324a;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return Arrays.equals(((a) obj).f4324a, this.f4324a);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f4324a);
    }

    public String toString() {
        return "Bytes(" + g.a(this.f4324a) + ")";
    }
}
