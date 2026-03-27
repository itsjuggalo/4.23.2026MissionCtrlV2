package com.google.firebase.firestore.remote;

import android.util.Base64;
import com.google.protobuf.AbstractC1062i;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public final class BloomFilter {
    private final int bitCount;
    private final AbstractC1062i bitmap;
    private final int hashCount;
    private final MessageDigest md5HashMessageDigest;

    public static final class BloomFilterCreateException extends Exception {
        public BloomFilterCreateException(String str) {
            super(str);
        }
    }

    public BloomFilter(AbstractC1062i abstractC1062i, int i4, int i5) {
        if (i4 < 0 || i4 >= 8) {
            throw new IllegalArgumentException("Invalid padding: " + i4);
        }
        if (i5 < 0) {
            throw new IllegalArgumentException("Invalid hash count: " + i5);
        }
        if (abstractC1062i.size() > 0 && i5 == 0) {
            throw new IllegalArgumentException("Invalid hash count: " + i5);
        }
        if (abstractC1062i.size() == 0 && i4 != 0) {
            throw new IllegalArgumentException("Expected padding of 0 when bitmap length is 0, but got " + i4);
        }
        this.bitmap = abstractC1062i;
        this.hashCount = i5;
        this.bitCount = (abstractC1062i.size() * 8) - i4;
        this.md5HashMessageDigest = createMd5HashMessageDigest();
    }

    public static BloomFilter create(AbstractC1062i abstractC1062i, int i4, int i5) throws BloomFilterCreateException {
        if (i4 < 0 || i4 >= 8) {
            throw new BloomFilterCreateException("Invalid padding: " + i4);
        }
        if (i5 < 0) {
            throw new BloomFilterCreateException("Invalid hash count: " + i5);
        }
        if (abstractC1062i.size() > 0 && i5 == 0) {
            throw new BloomFilterCreateException("Invalid hash count: " + i5);
        }
        if (abstractC1062i.size() != 0 || i4 == 0) {
            return new BloomFilter(abstractC1062i, i4, i5);
        }
        throw new BloomFilterCreateException("Expected padding of 0 when bitmap length is 0, but got " + i4);
    }

    private static MessageDigest createMd5HashMessageDigest() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e4) {
            throw new RuntimeException("Missing MD5 MessageDigest provider: ", e4);
        }
    }

    private int getBitIndex(long j4, long j5, int i4) {
        return (int) unsignedRemainder(j4 + (j5 * ((long) i4)), this.bitCount);
    }

    private static long getLongLittleEndian(byte[] bArr, int i4) {
        long j4 = 0;
        for (int i5 = 0; i5 < 8; i5++) {
            j4 |= (((long) bArr[i4 + i5]) & 255) << (i5 * 8);
        }
        return j4;
    }

    private boolean isBitSet(int i4) {
        return ((1 << (i4 % 8)) & this.bitmap.k(i4 / 8)) != 0;
    }

    private byte[] md5HashDigest(String str) {
        return this.md5HashMessageDigest.digest(str.getBytes(StandardCharsets.UTF_8));
    }

    private static long unsignedRemainder(long j4, long j5) {
        long j6 = j4 - ((((j4 >>> 1) / j5) << 1) * j5);
        if (j6 < j5) {
            j5 = 0;
        }
        return j6 - j5;
    }

    public int getBitCount() {
        return this.bitCount;
    }

    public boolean mightContain(String str) {
        if (this.bitCount == 0) {
            return false;
        }
        byte[] bArrMd5HashDigest = md5HashDigest(str);
        if (bArrMd5HashDigest.length != 16) {
            throw new RuntimeException("Invalid md5 hash array length: " + bArrMd5HashDigest.length + " (expected 16)");
        }
        long longLittleEndian = getLongLittleEndian(bArrMd5HashDigest, 0);
        long longLittleEndian2 = getLongLittleEndian(bArrMd5HashDigest, 8);
        for (int i4 = 0; i4 < this.hashCount; i4++) {
            if (!isBitSet(getBitIndex(longLittleEndian, longLittleEndian2, i4))) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return "BloomFilter{hashCount=" + this.hashCount + ", size=" + this.bitCount + ", bitmap=\"" + Base64.encodeToString(this.bitmap.G(), 2) + "\"}";
    }
}
