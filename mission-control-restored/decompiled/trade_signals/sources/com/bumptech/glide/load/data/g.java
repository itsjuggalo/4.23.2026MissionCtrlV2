package com.bumptech.glide.load.data;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class g extends FilterInputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f14837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f14838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f14839e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f14840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14841b;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        f14837c = bArr;
        int length = bArr.length;
        f14838d = length;
        f14839e = length + 2;
    }

    public g(InputStream inputStream, int i8) {
        super(inputStream);
        if (i8 >= -1 && i8 <= 8) {
            this.f14840a = (byte) i8;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i8);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i8) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int i8;
        int i9 = this.f14841b;
        int i10 = (i9 < 2 || i9 > (i8 = f14839e)) ? super.read() : i9 == i8 ? this.f14840a : f14837c[i9 - 2] & 255;
        if (i10 != -1) {
            this.f14841b++;
        }
        return i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j8) throws IOException {
        long jSkip = super.skip(j8);
        if (jSkip > 0) {
            this.f14841b = (int) (((long) this.f14841b) + jSkip);
        }
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i8, int i9) throws IOException {
        int i10;
        int i11 = this.f14841b;
        int i12 = f14839e;
        if (i11 > i12) {
            i10 = super.read(bArr, i8, i9);
        } else if (i11 == i12) {
            bArr[i8] = this.f14840a;
            i10 = 1;
        } else if (i11 < 2) {
            i10 = super.read(bArr, i8, 2 - i11);
        } else {
            int iMin = Math.min(i12 - i11, i9);
            System.arraycopy(f14837c, this.f14841b - 2, bArr, i8, iMin);
            i10 = iMin;
        }
        if (i10 > 0) {
            this.f14841b += i10;
        }
        return i10;
    }
}
