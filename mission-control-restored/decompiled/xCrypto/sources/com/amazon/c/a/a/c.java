package com.amazon.c.a.a;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f8928a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f8929b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f8930c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f8931d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f8932e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f8933f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f8934g = 16;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f8935h = 32;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final /* synthetic */ boolean f8936i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f8937j = 76;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f8940m = "US-ASCII";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final byte f8942o = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final byte[] f8943p = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final byte f8941n = -5;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final byte f8938k = 61;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final byte f8939l = 10;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final byte[] f8944q = {-9, -9, -9, -9, -9, -9, -9, -9, -9, f8941n, f8941n, -9, -9, f8941n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, f8941n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, f8938k, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, f8939l, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final byte[] f8945r = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final byte[] f8946s = {-9, -9, -9, -9, -9, -9, -9, -9, -9, f8941n, f8941n, -9, -9, f8941n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, f8941n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, f8938k, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, f8939l, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final byte[] f8947t = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final byte[] f8948u = {-9, -9, -9, -9, -9, -9, -9, -9, -9, f8941n, f8941n, -9, -9, f8941n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, f8941n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, f8939l, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, f8938k, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    public static class a extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f8949a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f8950b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private byte[] f8951c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f8952d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f8953e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f8954f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f8955g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f8956h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private byte[] f8957i;

        public a(InputStream inputStream) {
            this(inputStream, 0);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i4;
            if (this.f8950b < 0) {
                if (this.f8949a) {
                    byte[] bArr = new byte[3];
                    int i5 = 0;
                    for (int i6 = 0; i6 < 3; i6++) {
                        int i7 = ((FilterInputStream) this).in.read();
                        if (i7 < 0) {
                            break;
                        }
                        bArr[i6] = (byte) i7;
                        i5++;
                    }
                    if (i5 <= 0) {
                        return -1;
                    }
                    c.b(bArr, 0, i5, this.f8951c, 0, this.f8956h);
                    this.f8950b = 0;
                    this.f8953e = 4;
                } else {
                    byte[] bArr2 = new byte[4];
                    int i8 = 0;
                    while (i8 < 4) {
                        do {
                            i4 = ((FilterInputStream) this).in.read();
                            if (i4 < 0) {
                                break;
                            }
                        } while (this.f8957i[i4 & 127] <= -5);
                        if (i4 < 0) {
                            break;
                        }
                        bArr2[i8] = (byte) i4;
                        i8++;
                    }
                    if (i8 != 4) {
                        if (i8 == 0) {
                            return -1;
                        }
                        throw new IOException("Improperly padded Base64 input.");
                    }
                    this.f8953e = c.b(bArr2, 0, this.f8951c, 0, this.f8956h);
                    this.f8950b = 0;
                }
            }
            int i9 = this.f8950b;
            if (i9 < 0) {
                throw new IOException("Error in Base64 code reading stream.");
            }
            if (i9 >= this.f8953e) {
                return -1;
            }
            if (this.f8949a && this.f8955g && this.f8954f >= c.f8937j) {
                this.f8954f = 0;
                return 10;
            }
            this.f8954f++;
            byte[] bArr3 = this.f8951c;
            int i10 = i9 + 1;
            this.f8950b = i10;
            byte b4 = bArr3[i9];
            if (i10 >= this.f8952d) {
                this.f8950b = -1;
            }
            return b4 & 255;
        }

        public a(InputStream inputStream, int i4) {
            super(inputStream);
            this.f8956h = i4;
            this.f8955g = (i4 & 8) > 0;
            boolean z4 = (i4 & 1) > 0;
            this.f8949a = z4;
            int i5 = z4 ? 4 : 3;
            this.f8952d = i5;
            this.f8951c = new byte[i5];
            this.f8950b = -1;
            this.f8954f = 0;
            this.f8957i = c.c(i4);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i4, int i5) throws IOException {
            int i6 = 0;
            while (true) {
                if (i6 >= i5) {
                    break;
                }
                int i7 = read();
                if (i7 >= 0) {
                    bArr[i4 + i6] = (byte) i7;
                    i6++;
                } else if (i6 == 0) {
                    return -1;
                }
            }
            return i6;
        }
    }

    public static class b extends FilterOutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f8958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f8959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private byte[] f8960c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f8961d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f8962e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f8963f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private byte[] f8964g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f8965h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f8966i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private byte[] f8967j;

        public b(OutputStream outputStream) {
            this(outputStream, 1);
        }

        public void a() throws IOException {
            int i4 = this.f8959b;
            if (i4 > 0) {
                if (!this.f8958a) {
                    throw new IOException("Base64 input not properly padded.");
                }
                ((FilterOutputStream) this).out.write(c.b(this.f8964g, this.f8960c, i4, this.f8966i));
                this.f8959b = 0;
            }
        }

        public void b() throws IOException {
            a();
            this.f8965h = true;
        }

        public void c() {
            this.f8965h = false;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a();
            super.close();
            this.f8960c = null;
            ((FilterOutputStream) this).out = null;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i4) throws IOException {
            if (this.f8965h) {
                ((FilterOutputStream) this).out.write(i4);
                return;
            }
            if (!this.f8958a) {
                byte b4 = this.f8967j[i4 & 127];
                if (b4 <= -5) {
                    if (b4 != -5) {
                        throw new IOException("Invalid character in Base64 data.");
                    }
                    return;
                }
                byte[] bArr = this.f8960c;
                int i5 = this.f8959b;
                int i6 = i5 + 1;
                this.f8959b = i6;
                bArr[i5] = (byte) i4;
                if (i6 >= this.f8961d) {
                    ((FilterOutputStream) this).out.write(this.f8964g, 0, c.b(bArr, 0, this.f8964g, 0, this.f8966i));
                    this.f8959b = 0;
                    return;
                }
                return;
            }
            byte[] bArr2 = this.f8960c;
            int i7 = this.f8959b;
            int i8 = i7 + 1;
            this.f8959b = i8;
            bArr2[i7] = (byte) i4;
            int i9 = this.f8961d;
            if (i8 >= i9) {
                ((FilterOutputStream) this).out.write(c.b(this.f8964g, bArr2, i9, this.f8966i));
                int i10 = this.f8962e + 4;
                this.f8962e = i10;
                if (this.f8963f && i10 >= c.f8937j) {
                    ((FilterOutputStream) this).out.write(10);
                    this.f8962e = 0;
                }
                this.f8959b = 0;
            }
        }

        public b(OutputStream outputStream, int i4) {
            super(outputStream);
            this.f8963f = (i4 & 8) != 0;
            boolean z4 = (i4 & 1) != 0;
            this.f8958a = z4;
            int i5 = z4 ? 3 : 4;
            this.f8961d = i5;
            this.f8960c = new byte[i5];
            this.f8959b = 0;
            this.f8962e = 0;
            this.f8965h = false;
            this.f8964g = new byte[4];
            this.f8966i = i4;
            this.f8967j = c.c(i4);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i4, int i5) throws IOException {
            if (this.f8965h) {
                ((FilterOutputStream) this).out.write(bArr, i4, i5);
                return;
            }
            for (int i6 = 0; i6 < i5; i6++) {
                write(bArr[i4 + i6]);
            }
        }
    }

    private c() {
    }

    private static final byte[] b(int i4) {
        return (i4 & 16) == 16 ? f8945r : (i4 & 32) == 32 ? f8947t : f8943p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] c(int i4) {
        return (i4 & 16) == 16 ? f8946s : (i4 & 32) == 32 ? f8948u : f8944q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(byte[] bArr, byte[] bArr2, int i4, int i5) {
        b(bArr2, 0, i4, bArr, 0, i5);
        return bArr;
    }

    public static byte[] c(byte[] bArr) {
        return c(bArr, 0, bArr.length, 0);
    }

    public static void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int iMin = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, iMin);
            b(bArr2, bArr, iMin, 0);
            byteBuffer2.put(bArr2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(byte[] bArr, int i4, int i5, byte[] bArr2, int i6, int i7) {
        byte[] bArrB = b(i7);
        int i8 = (i5 > 0 ? (bArr[i4] << 24) >>> 8 : 0) | (i5 > 1 ? (bArr[i4 + 1] << 24) >>> 16 : 0) | (i5 > 2 ? (bArr[i4 + 2] << 24) >>> 24 : 0);
        if (i5 == 1) {
            bArr2[i6] = bArrB[i8 >>> 18];
            bArr2[i6 + 1] = bArrB[(i8 >>> 12) & 63];
            bArr2[i6 + 2] = f8938k;
            bArr2[i6 + 3] = f8938k;
            return bArr2;
        }
        if (i5 == 2) {
            bArr2[i6] = bArrB[i8 >>> 18];
            bArr2[i6 + 1] = bArrB[(i8 >>> 12) & 63];
            bArr2[i6 + 2] = bArrB[(i8 >>> 6) & 63];
            bArr2[i6 + 3] = f8938k;
            return bArr2;
        }
        if (i5 != 3) {
            return bArr2;
        }
        bArr2[i6] = bArrB[i8 >>> 18];
        bArr2[i6 + 1] = bArrB[(i8 >>> 12) & 63];
        bArr2[i6 + 2] = bArrB[(i8 >>> 6) & 63];
        bArr2[i6 + 3] = bArrB[i8 & 63];
        return bArr2;
    }

    public static byte[] c(byte[] bArr, int i4, int i5, int i6) throws IOException {
        int i7;
        if (bArr != null) {
            if (i4 < 0 || (i7 = i4 + i5) > bArr.length) {
                throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i4), Integer.valueOf(i5)));
            }
            if (i5 == 0) {
                return new byte[0];
            }
            if (i5 >= 4) {
                byte[] bArrC = c(i6);
                byte[] bArr2 = new byte[(i5 * 3) / 4];
                byte[] bArr3 = new byte[4];
                int i8 = 0;
                int iB = 0;
                while (i4 < i7) {
                    byte b4 = bArr[i4];
                    byte b5 = bArrC[b4 & 255];
                    if (b5 < -5) {
                        throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", Integer.valueOf(bArr[i4] & 255), Integer.valueOf(i4)));
                    }
                    if (b5 >= -1) {
                        int i9 = i8 + 1;
                        bArr3[i8] = b4;
                        if (i9 > 3) {
                            iB += b(bArr3, 0, bArr2, iB, i6);
                            if (bArr[i4] == 61) {
                                break;
                            }
                            i8 = 0;
                        } else {
                            i8 = i9;
                        }
                    }
                    i4++;
                }
                byte[] bArr4 = new byte[iB];
                System.arraycopy(bArr2, 0, bArr4, 0, iB);
                return bArr4;
            }
            throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + i5);
        }
        throw new NullPointerException("Cannot decode null source array.");
    }

    public static void a(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int iMin = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, iMin);
            b(bArr2, bArr, iMin, 0);
            for (int i4 = 0; i4 < 4; i4++) {
                charBuffer.put((char) (bArr2[i4] & 255));
            }
        }
    }

    public static String a(Serializable serializable) {
        return a(serializable, 0);
    }

    public static byte[] b(byte[] bArr) {
        try {
            return b(bArr, 0, bArr.length, 0);
        } catch (IOException e4) {
            if (f8936i) {
                return null;
            }
            throw new AssertionError("IOExceptions only come from GZipping, which is turned off: " + e4.getMessage());
        }
    }

    public static String a(Serializable serializable, int i4) throws Throwable {
        OutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        b bVar;
        ObjectOutputStream objectOutputStream;
        if (serializable != null) {
            ObjectOutputStream objectOutputStream2 = null;
            objectOutputStream2 = null;
            objectOutputStream2 = null;
            objectOutputStream2 = null;
            objectOutputStream2 = null;
            objectOutputStream2 = null;
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bVar = new b(byteArrayOutputStream, i4 | 1);
                    try {
                        if ((i4 & 2) != 0) {
                            gZIPOutputStream = new GZIPOutputStream(bVar);
                            try {
                                objectOutputStream2 = new ObjectOutputStream(gZIPOutputStream);
                                gZIPOutputStream = gZIPOutputStream;
                            } catch (IOException e4) {
                                e = e4;
                                objectOutputStream = objectOutputStream2;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                gZIPOutputStream = gZIPOutputStream;
                                try {
                                    throw e;
                                } catch (Throwable th) {
                                    th = th;
                                    ObjectOutputStream objectOutputStream3 = objectOutputStream;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    objectOutputStream2 = objectOutputStream3;
                                    try {
                                        objectOutputStream2.close();
                                    } catch (Exception unused) {
                                    }
                                    try {
                                        gZIPOutputStream.close();
                                    } catch (Exception unused2) {
                                    }
                                    try {
                                        bVar.close();
                                    } catch (Exception unused3) {
                                    }
                                    try {
                                        byteArrayOutputStream.close();
                                        throw th;
                                    } catch (Exception unused4) {
                                        throw th;
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                objectOutputStream2.close();
                                gZIPOutputStream.close();
                                bVar.close();
                                byteArrayOutputStream.close();
                                throw th;
                            }
                        } else {
                            objectOutputStream2 = new ObjectOutputStream(bVar);
                            gZIPOutputStream = null;
                        }
                        objectOutputStream2.writeObject(serializable);
                        try {
                            objectOutputStream2.close();
                        } catch (Exception unused5) {
                        }
                        try {
                            gZIPOutputStream.close();
                        } catch (Exception unused6) {
                        }
                        try {
                            bVar.close();
                        } catch (Exception unused7) {
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused8) {
                        }
                        try {
                            return new String(byteArrayOutputStream.toByteArray(), f8940m);
                        } catch (UnsupportedEncodingException unused9) {
                            return new String(byteArrayOutputStream.toByteArray());
                        }
                    } catch (IOException e5) {
                        e = e5;
                        ObjectOutputStream objectOutputStream4 = objectOutputStream2;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        objectOutputStream = objectOutputStream4;
                        gZIPOutputStream = objectOutputStream4;
                    } catch (Throwable th3) {
                        th = th3;
                        gZIPOutputStream = objectOutputStream2;
                    }
                } catch (IOException e6) {
                    e = e6;
                    gZIPOutputStream = null;
                    bVar = null;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    objectOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    gZIPOutputStream = null;
                    bVar = null;
                }
            } catch (IOException e7) {
                e = e7;
                gZIPOutputStream = null;
                objectOutputStream = null;
                bVar = null;
            } catch (Throwable th5) {
                th = th5;
                gZIPOutputStream = null;
                byteArrayOutputStream = null;
                bVar = null;
            }
        } else {
            throw new NullPointerException("Cannot serialize a null object.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] b(byte[] bArr, int i4, int i5, int i6) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        b bVar;
        GZIPOutputStream gZIPOutputStream;
        byte[] bArr2 = bArr;
        if (bArr2 == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i4);
        }
        if (i5 >= 0) {
            if (i4 + i5 > bArr2.length) {
                throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(bArr2.length)));
            }
            if ((i6 & 2) != 0) {
                GZIPOutputStream gZIPOutputStream2 = null;
                gZIPOutputStream2 = null;
                gZIPOutputStream2 = null;
                ByteArrayOutputStream byteArrayOutputStream2 = null;
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        bVar = new b(byteArrayOutputStream, i6 | 1);
                        try {
                            gZIPOutputStream = new GZIPOutputStream(bVar);
                        } catch (IOException e4) {
                            e = e4;
                            gZIPOutputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            try {
                                gZIPOutputStream2.close();
                            } catch (Exception unused) {
                            }
                            try {
                                bVar.close();
                            } catch (Exception unused2) {
                            }
                            try {
                                byteArrayOutputStream.close();
                                throw th;
                            } catch (Exception unused3) {
                                throw th;
                            }
                        }
                    } catch (IOException e5) {
                        e = e5;
                        bVar = null;
                        gZIPOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        bVar = null;
                    }
                } catch (IOException e6) {
                    e = e6;
                    bVar = null;
                    gZIPOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                    bVar = null;
                }
                try {
                    gZIPOutputStream.write(bArr2, i4, i5);
                    gZIPOutputStream.close();
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception unused4) {
                    }
                    try {
                        bVar.close();
                    } catch (Exception unused5) {
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception unused6) {
                    }
                    return byteArrayOutputStream.toByteArray();
                } catch (IOException e7) {
                    e = e7;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    try {
                        throw e;
                    } catch (Throwable th4) {
                        th = th4;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        gZIPOutputStream2 = gZIPOutputStream;
                        gZIPOutputStream2.close();
                        bVar.close();
                        byteArrayOutputStream.close();
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    gZIPOutputStream2 = gZIPOutputStream;
                    gZIPOutputStream2.close();
                    bVar.close();
                    byteArrayOutputStream.close();
                    throw th;
                }
            }
            Object[] objArr = (i6 & 8) != 0;
            int i7 = ((i5 / 3) * 4) + (i5 % 3 > 0 ? 4 : 0);
            if (objArr != false) {
                i7 += i7 / f8937j;
            }
            int i8 = i7;
            byte[] bArr3 = new byte[i8];
            int i9 = i5 - 2;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (i11 < i9) {
                b(bArr2, i11 + i4, 3, bArr3, i10, i6);
                i12 += 4;
                if (objArr != false && i12 >= f8937j) {
                    bArr3[i10 + 4] = f8939l;
                    i10++;
                    i12 = 0;
                }
                i11 += 3;
                i10 += 4;
                bArr2 = bArr;
            }
            if (i11 < i5) {
                b(bArr, i11 + i4, i5 - i11, bArr3, i10, i6);
                i10 += 4;
            }
            if (i10 > i8 - 1) {
                return bArr3;
            }
            byte[] bArr4 = new byte[i10];
            System.arraycopy(bArr3, 0, bArr4, 0, i10);
            return bArr4;
        }
        throw new IllegalArgumentException("Cannot have length offset: " + i5);
    }

    public static String c(String str) throws Throwable {
        a aVar = null;
        try {
            try {
                File file = new File(str);
                byte[] bArr = new byte[Math.max((int) ((file.length() * 1.4d) + 1.0d), 40)];
                a aVar2 = new a(new BufferedInputStream(new FileInputStream(file)), 1);
                int i4 = 0;
                while (true) {
                    try {
                        int i5 = aVar2.read(bArr, i4, 4096);
                        if (i5 < 0) {
                            break;
                        }
                        i4 += i5;
                    } catch (IOException e4) {
                        aVar = aVar2;
                        throw e4;
                    } catch (Throwable th) {
                        th = th;
                        aVar = aVar2;
                        try {
                            aVar.close();
                        } catch (Exception unused) {
                        }
                        throw th;
                    }
                }
                String str2 = new String(bArr, 0, i4, f8940m);
                try {
                    aVar2.close();
                } catch (Exception unused2) {
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            throw e5;
        }
    }

    public static void c(String str, String str2) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        byte[] bArrB = b(str);
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
            } catch (Throwable th) {
                th = th;
            }
            try {
                bufferedOutputStream.write(bArrB);
                try {
                    bufferedOutputStream.close();
                } catch (Exception unused) {
                }
            } catch (IOException e4) {
                bufferedOutputStream2 = bufferedOutputStream;
                throw e4;
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream2 = bufferedOutputStream;
                try {
                    bufferedOutputStream2.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (IOException e5) {
        }
    }

    public static String a(byte[] bArr) throws Throwable {
        String strA;
        try {
            strA = a(bArr, 0, bArr.length, 0);
        } catch (IOException e4) {
            if (!f8936i) {
                throw new AssertionError(e4.getMessage());
            }
            strA = null;
        }
        if (f8936i || strA != null) {
            return strA;
        }
        throw new AssertionError();
    }

    public static String a(byte[] bArr, int i4) {
        return a(bArr, 0, bArr.length, i4);
    }

    public static String a(byte[] bArr, int i4, int i5) throws Throwable {
        String strA;
        try {
            strA = a(bArr, i4, i5, 0);
        } catch (IOException e4) {
            if (!f8936i) {
                throw new AssertionError(e4.getMessage());
            }
            strA = null;
        }
        if (f8936i || strA != null) {
            return strA;
        }
        throw new AssertionError();
    }

    public static String a(byte[] bArr, int i4, int i5, int i6) throws Throwable {
        byte[] bArrB = b(bArr, i4, i5, i6);
        try {
            return new String(bArrB, f8940m);
        } catch (UnsupportedEncodingException unused) {
            return new String(bArrB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(byte[] bArr, int i4, byte[] bArr2, int i5, int i6) {
        int i7;
        int i8;
        if (bArr == null) {
            throw new NullPointerException("Source array was null.");
        }
        if (bArr2 != null) {
            if (i4 >= 0 && (i7 = i4 + 3) < bArr.length) {
                if (i5 >= 0 && (i8 = i5 + 2) < bArr2.length) {
                    byte[] bArrC = c(i6);
                    byte b4 = bArr[i4 + 2];
                    if (b4 == 61) {
                        bArr2[i5] = (byte) ((((bArrC[bArr[i4 + 1]] & 255) << 12) | ((bArrC[bArr[i4]] & 255) << 18)) >>> 16);
                        return 1;
                    }
                    byte b5 = bArr[i7];
                    if (b5 == 61) {
                        int i9 = ((bArrC[bArr[i4 + 1]] & 255) << 12) | ((bArrC[bArr[i4]] & 255) << 18) | ((bArrC[b4] & 255) << 6);
                        bArr2[i5] = (byte) (i9 >>> 16);
                        bArr2[i5 + 1] = (byte) (i9 >>> 8);
                        return 2;
                    }
                    int i10 = ((bArrC[bArr[i4 + 1]] & 255) << 12) | ((bArrC[bArr[i4]] & 255) << 18) | ((bArrC[b4] & 255) << 6) | (bArrC[b5] & 255);
                    bArr2[i5] = (byte) (i10 >> 16);
                    bArr2[i5 + 1] = (byte) (i10 >> 8);
                    bArr2[i8] = (byte) i10;
                    return 3;
                }
                throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i5)));
            }
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i4)));
        }
        throw new NullPointerException("Destination array was null.");
    }

    public static byte[] a(String str) {
        return a(str, 0);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:16|(3:72|17|(4:83|18|81|19))|(8:79|20|(1:22)(1:85)|71|76|29|63|30)|27|28|71|76|29|63|30) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] a(java.lang.String r5, int r6) throws java.lang.Throwable {
        /*
            if (r5 == 0) goto L8e
            java.lang.String r0 = "US-ASCII"
            byte[] r5 = r5.getBytes(r0)     // Catch: java.io.UnsupportedEncodingException -> L9
            goto Ld
        L9:
            byte[] r5 = r5.getBytes()
        Ld:
            int r0 = r5.length
            r1 = 0
            byte[] r5 = c(r5, r1, r0, r6)
            r0 = 4
            r6 = r6 & r0
            r2 = 1
            if (r6 == 0) goto L1a
            r6 = r2
            goto L1b
        L1a:
            r6 = r1
        L1b:
            if (r5 == 0) goto L8d
            int r3 = r5.length
            if (r3 < r0) goto L8d
            if (r6 != 0) goto L8d
            r6 = r5[r1]
            r6 = r6 & 255(0xff, float:3.57E-43)
            r0 = r5[r2]
            int r0 = r0 << 8
            r2 = 65280(0xff00, float:9.1477E-41)
            r0 = r0 & r2
            r6 = r6 | r0
            r0 = 35615(0x8b1f, float:4.9907E-41)
            if (r0 != r6) goto L8d
            r6 = 2048(0x800, float:2.87E-42)
            byte[] r6 = new byte[r6]
            r0 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L78
            r2.<init>()     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L78
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L70
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L70
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L69
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L69
        L48:
            int r0 = r4.read(r6)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L55
            if (r0 < 0) goto L58
            r2.write(r6, r1, r0)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L55
            goto L48
        L52:
            r5 = move-exception
        L53:
            r0 = r2
            goto L83
        L55:
            r6 = move-exception
        L56:
            r0 = r2
            goto L7b
        L58:
            byte[] r5 = r2.toByteArray()     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L55
            r2.close()     // Catch: java.lang.Exception -> L5f
        L5f:
            r4.close()     // Catch: java.lang.Exception -> L62
        L62:
            r3.close()     // Catch: java.lang.Exception -> L8d
            goto L8d
        L66:
            r5 = move-exception
            r4 = r0
            goto L53
        L69:
            r6 = move-exception
            r4 = r0
            goto L56
        L6c:
            r5 = move-exception
            r3 = r0
            r4 = r3
            goto L53
        L70:
            r6 = move-exception
            r3 = r0
            r4 = r3
            goto L56
        L74:
            r5 = move-exception
            r3 = r0
            r4 = r3
            goto L83
        L78:
            r6 = move-exception
            r3 = r0
            r4 = r3
        L7b:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L82
            r0.close()     // Catch: java.lang.Exception -> L5f
            goto L5f
        L82:
            r5 = move-exception
        L83:
            r0.close()     // Catch: java.lang.Exception -> L86
        L86:
            r4.close()     // Catch: java.lang.Exception -> L89
        L89:
            r3.close()     // Catch: java.lang.Exception -> L8c
        L8c:
            throw r5
        L8d:
            return r5
        L8e:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "Input string was null."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazon.c.a.a.c.a(java.lang.String, int):byte[]");
    }

    public static byte[] b(String str) throws Throwable {
        a aVar = null;
        try {
            try {
                File file = new File(str);
                if (file.length() <= 2147483647L) {
                    byte[] bArr = new byte[(int) file.length()];
                    a aVar2 = new a(new BufferedInputStream(new FileInputStream(file)), 0);
                    int i4 = 0;
                    while (true) {
                        try {
                            int i5 = aVar2.read(bArr, i4, 4096);
                            if (i5 < 0) {
                                break;
                            }
                            i4 += i5;
                        } catch (IOException e4) {
                            throw e4;
                        } catch (Throwable th) {
                            th = th;
                            aVar = aVar2;
                            try {
                                aVar.close();
                            } catch (Exception unused) {
                            }
                            throw th;
                        }
                    }
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(bArr, 0, bArr2, 0, i4);
                    try {
                        aVar2.close();
                    } catch (Exception unused2) {
                    }
                    return bArr2;
                }
                throw new IOException("File is too big for this convenience method (" + file.length() + " bytes).");
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            throw e5;
        }
    }

    public static void a(byte[] bArr, String str) throws Throwable {
        b bVar;
        if (bArr != null) {
            b bVar2 = null;
            try {
                try {
                    bVar = new b(new FileOutputStream(str), 1);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    bVar.write(bArr);
                    try {
                        bVar.close();
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                } catch (IOException e4) {
                    bVar2 = bVar;
                    throw e4;
                } catch (Throwable th2) {
                    th = th2;
                    bVar2 = bVar;
                    try {
                        bVar2.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (IOException e5) {
                throw e5;
            }
        }
        throw new NullPointerException("Data to encode was null.");
    }

    public static void a(String str, String str2) throws Throwable {
        b bVar;
        b bVar2 = null;
        try {
            try {
                bVar = new b(new FileOutputStream(str2), 0);
            } catch (IOException e4) {
                throw e4;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bVar.write(str.getBytes(f8940m));
            try {
                bVar.close();
            } catch (Exception unused) {
            }
        } catch (IOException e5) {
        } catch (Throwable th2) {
            th = th2;
            bVar2 = bVar;
            try {
                bVar2.close();
            } catch (Exception unused2) {
            }
            throw th;
        }
    }

    public static void b(String str, String str2) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        String strC = c(str);
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
            } catch (Throwable th) {
                th = th;
            }
            try {
                bufferedOutputStream.write(strC.getBytes(f8940m));
                try {
                    bufferedOutputStream.close();
                } catch (Exception unused) {
                }
            } catch (IOException e4) {
                bufferedOutputStream2 = bufferedOutputStream;
                throw e4;
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream2 = bufferedOutputStream;
                try {
                    bufferedOutputStream2.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (IOException e5) {
        }
    }
}
