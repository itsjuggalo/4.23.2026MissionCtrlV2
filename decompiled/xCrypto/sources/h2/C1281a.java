package h2;

import g2.g;
import java.util.Arrays;

/* JADX INFO: renamed from: h2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1281a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f12165a;

    public C1281a(byte[] bArr, int i4, int i5) {
        byte[] bArr2 = new byte[i5];
        this.f12165a = bArr2;
        System.arraycopy(bArr, i4, bArr2, 0, i5);
    }

    public static C1281a a(byte[] bArr) {
        if (bArr != null) {
            return b(bArr, 0, bArr.length);
        }
        throw new NullPointerException("data must be non-null");
    }

    public static C1281a b(byte[] bArr, int i4, int i5) {
        if (bArr != null) {
            return new C1281a(bArr, i4, i5);
        }
        throw new NullPointerException("data must be non-null");
    }

    public byte[] c() {
        byte[] bArr = this.f12165a;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1281a) {
            return Arrays.equals(((C1281a) obj).f12165a, this.f12165a);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f12165a);
    }

    public String toString() {
        return "Bytes(" + g.a(this.f12165a) + ")";
    }
}
