package m9;

import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.protobuf.i f16210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f16211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MessageDigest f16212d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public m(com.google.protobuf.i iVar, int i10, int i11) {
        if (i10 < 0 || i10 >= 8) {
            throw new IllegalArgumentException("Invalid padding: " + i10);
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("Invalid hash count: " + i11);
        }
        if (iVar.size() > 0 && i11 == 0) {
            throw new IllegalArgumentException("Invalid hash count: " + i11);
        }
        if (iVar.size() == 0 && i10 != 0) {
            throw new IllegalArgumentException("Expected padding of 0 when bitmap length is 0, but got " + i10);
        }
        this.f16210b = iVar;
        this.f16211c = i11;
        this.f16209a = (iVar.size() * 8) - i10;
        this.f16212d = b();
    }

    public static m a(com.google.protobuf.i iVar, int i10, int i11) throws a {
        if (i10 < 0 || i10 >= 8) {
            throw new a("Invalid padding: " + i10);
        }
        if (i11 < 0) {
            throw new a("Invalid hash count: " + i11);
        }
        if (iVar.size() > 0 && i11 == 0) {
            throw new a("Invalid hash count: " + i11);
        }
        if (iVar.size() != 0 || i10 == 0) {
            return new m(iVar, i10, i11);
        }
        throw new a("Expected padding of 0 when bitmap length is 0, but got " + i10);
    }

    public static MessageDigest b() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException("Missing MD5 MessageDigest provider: ", e10);
        }
    }

    public static long e(byte[] bArr, int i10) {
        long j10 = 0;
        for (int i11 = 0; i11 < 8; i11++) {
            j10 |= (((long) bArr[i10 + i11]) & 255) << (i11 * 8);
        }
        return j10;
    }

    public static long i(long j10, long j11) {
        long j12 = j10 - ((((j10 >>> 1) / j11) << 1) * j11);
        if (j12 < j11) {
            j11 = 0;
        }
        return j12 - j11;
    }

    public int c() {
        return this.f16209a;
    }

    public final int d(long j10, long j11, int i10) {
        return (int) i(j10 + (j11 * ((long) i10)), this.f16209a);
    }

    public final boolean f(int i10) {
        return ((1 << (i10 % 8)) & this.f16210b.e(i10 / 8)) != 0;
    }

    public final byte[] g(String str) {
        return this.f16212d.digest(str.getBytes(StandardCharsets.UTF_8));
    }

    public boolean h(String str) {
        if (this.f16209a == 0) {
            return false;
        }
        byte[] bArrG = g(str);
        if (bArrG.length != 16) {
            throw new RuntimeException("Invalid md5 hash array length: " + bArrG.length + " (expected 16)");
        }
        long jE = e(bArrG, 0);
        long jE2 = e(bArrG, 8);
        for (int i10 = 0; i10 < this.f16211c; i10++) {
            if (!f(d(jE, jE2, i10))) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return "BloomFilter{hashCount=" + this.f16211c + ", size=" + this.f16209a + ", bitmap=\"" + Base64.encodeToString(this.f16210b.Y(), 2) + "\"}";
    }
}
