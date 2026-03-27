package J3;

import android.util.Base64;
import com.google.protobuf.AbstractC1240i;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: renamed from: J3.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0598m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC1240i f3257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MessageDigest f3259d;

    /* JADX INFO: renamed from: J3.m$a */
    public static final class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public C0598m(AbstractC1240i abstractC1240i, int i7, int i8) {
        if (i7 < 0 || i7 >= 8) {
            throw new IllegalArgumentException("Invalid padding: " + i7);
        }
        if (i8 < 0) {
            throw new IllegalArgumentException("Invalid hash count: " + i8);
        }
        if (abstractC1240i.size() > 0 && i8 == 0) {
            throw new IllegalArgumentException("Invalid hash count: " + i8);
        }
        if (abstractC1240i.size() == 0 && i7 != 0) {
            throw new IllegalArgumentException("Expected padding of 0 when bitmap length is 0, but got " + i7);
        }
        this.f3257b = abstractC1240i;
        this.f3258c = i8;
        this.f3256a = (abstractC1240i.size() * 8) - i7;
        this.f3259d = b();
    }

    public static C0598m a(AbstractC1240i abstractC1240i, int i7, int i8) throws a {
        if (i7 < 0 || i7 >= 8) {
            throw new a("Invalid padding: " + i7);
        }
        if (i8 < 0) {
            throw new a("Invalid hash count: " + i8);
        }
        if (abstractC1240i.size() > 0 && i8 == 0) {
            throw new a("Invalid hash count: " + i8);
        }
        if (abstractC1240i.size() != 0 || i7 == 0) {
            return new C0598m(abstractC1240i, i7, i8);
        }
        throw new a("Expected padding of 0 when bitmap length is 0, but got " + i7);
    }

    public static MessageDigest b() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e7) {
            throw new RuntimeException("Missing MD5 MessageDigest provider: ", e7);
        }
    }

    public static long e(byte[] bArr, int i7) {
        long j7 = 0;
        for (int i8 = 0; i8 < 8; i8++) {
            j7 |= (((long) bArr[i7 + i8]) & 255) << (i8 * 8);
        }
        return j7;
    }

    public static long i(long j7, long j8) {
        long j9 = j7 - ((((j7 >>> 1) / j8) << 1) * j8);
        if (j9 < j8) {
            j8 = 0;
        }
        return j9 - j8;
    }

    public int c() {
        return this.f3256a;
    }

    public final int d(long j7, long j8, int i7) {
        return (int) i(j7 + (j8 * ((long) i7)), this.f3256a);
    }

    public final boolean f(int i7) {
        return ((1 << (i7 % 8)) & this.f3257b.g(i7 / 8)) != 0;
    }

    public final byte[] g(String str) {
        return this.f3259d.digest(str.getBytes(StandardCharsets.UTF_8));
    }

    public boolean h(String str) {
        if (this.f3256a == 0) {
            return false;
        }
        byte[] bArrG = g(str);
        if (bArrG.length != 16) {
            throw new RuntimeException("Invalid md5 hash array length: " + bArrG.length + " (expected 16)");
        }
        long jE = e(bArrG, 0);
        long jE2 = e(bArrG, 8);
        for (int i7 = 0; i7 < this.f3258c; i7++) {
            if (!f(d(jE, jE2, i7))) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return "BloomFilter{hashCount=" + this.f3258c + ", size=" + this.f3256a + ", bitmap=\"" + Base64.encodeToString(this.f3257b.F(), 2) + "\"}";
    }
}
