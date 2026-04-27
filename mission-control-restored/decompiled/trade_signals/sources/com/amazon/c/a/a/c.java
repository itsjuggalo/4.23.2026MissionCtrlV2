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
    public static final int f14224a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f14225b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f14226c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f14227d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f14228e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f14229f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f14230g = 16;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f14231h = 32;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final /* synthetic */ boolean f14232i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f14233j = 76;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f14236m = "US-ASCII";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final byte[] f14239p = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final byte f14237n = -5;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final byte f14234k = 61;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final byte f14238o = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final byte f14235l = 10;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final byte[] f14240q = {-9, -9, -9, -9, -9, -9, -9, -9, -9, f14237n, f14237n, -9, -9, f14237n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, f14237n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, f14234k, -9, -9, -9, f14238o, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, f14235l, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final byte[] f14241r = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final byte[] f14242s = {-9, -9, -9, -9, -9, -9, -9, -9, -9, f14237n, f14237n, -9, -9, f14237n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, f14237n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, f14234k, -9, -9, -9, f14238o, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, f14235l, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final byte[] f14243t = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final byte[] f14244u = {-9, -9, -9, -9, -9, -9, -9, -9, -9, f14237n, f14237n, -9, -9, f14237n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, f14237n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, f14235l, -9, -9, -9, f14238o, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, f14234k, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    public static class a extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f14245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f14246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private byte[] f14247c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f14248d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f14249e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f14250f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f14251g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f14252h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private byte[] f14253i;

        public a(InputStream inputStream) {
            this(inputStream, 0);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i8;
            if (this.f14246b < 0) {
                if (this.f14245a) {
                    byte[] bArr = new byte[3];
                    int i9 = 0;
                    for (int i10 = 0; i10 < 3; i10++) {
                        int i11 = ((FilterInputStream) this).in.read();
                        if (i11 < 0) {
                            break;
                        }
                        bArr[i10] = (byte) i11;
                        i9++;
                    }
                    if (i9 <= 0) {
                        return -1;
                    }
                    c.b(bArr, 0, i9, this.f14247c, 0, this.f14252h);
                    this.f14246b = 0;
                    this.f14249e = 4;
                } else {
                    byte[] bArr2 = new byte[4];
                    int i12 = 0;
                    while (i12 < 4) {
                        do {
                            i8 = ((FilterInputStream) this).in.read();
                            if (i8 < 0) {
                                break;
                            }
                        } while (this.f14253i[i8 & 127] <= -5);
                        if (i8 < 0) {
                            break;
                        }
                        bArr2[i12] = (byte) i8;
                        i12++;
                    }
                    if (i12 != 4) {
                        if (i12 == 0) {
                            return -1;
                        }
                        throw new IOException("Improperly padded Base64 input.");
                    }
                    this.f14249e = c.b(bArr2, 0, this.f14247c, 0, this.f14252h);
                    this.f14246b = 0;
                }
            }
            int i13 = this.f14246b;
            if (i13 < 0) {
                throw new IOException("Error in Base64 code reading stream.");
            }
            if (i13 >= this.f14249e) {
                return -1;
            }
            if (this.f14245a && this.f14251g && this.f14250f >= c.f14233j) {
                this.f14250f = 0;
                return 10;
            }
            this.f14250f++;
            byte[] bArr3 = this.f14247c;
            int i14 = i13 + 1;
            this.f14246b = i14;
            byte b8 = bArr3[i13];
            if (i14 >= this.f14248d) {
                this.f14246b = -1;
            }
            return b8 & c.f14238o;
        }

        public a(InputStream inputStream, int i8) {
            super(inputStream);
            this.f14252h = i8;
            this.f14251g = (i8 & 8) > 0;
            boolean z7 = (i8 & 1) > 0;
            this.f14245a = z7;
            int i9 = z7 ? 4 : 3;
            this.f14248d = i9;
            this.f14247c = new byte[i9];
            this.f14246b = -1;
            this.f14250f = 0;
            this.f14253i = c.c(i8);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i8, int i9) throws IOException {
            int i10 = 0;
            while (true) {
                if (i10 >= i9) {
                    break;
                }
                int i11 = read();
                if (i11 >= 0) {
                    bArr[i8 + i10] = (byte) i11;
                    i10++;
                } else if (i10 == 0) {
                    return -1;
                }
            }
            return i10;
        }
    }

    public static class b extends FilterOutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f14254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f14255b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private byte[] f14256c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f14257d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f14258e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f14259f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private byte[] f14260g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f14261h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f14262i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private byte[] f14263j;

        public b(OutputStream outputStream) {
            this(outputStream, 1);
        }

        public void a() throws IOException {
            int i8 = this.f14255b;
            if (i8 > 0) {
                if (!this.f14254a) {
                    throw new IOException("Base64 input not properly padded.");
                }
                ((FilterOutputStream) this).out.write(c.b(this.f14260g, this.f14256c, i8, this.f14262i));
                this.f14255b = 0;
            }
        }

        public void b() throws IOException {
            a();
            this.f14261h = true;
        }

        public void c() {
            this.f14261h = false;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a();
            super.close();
            this.f14256c = null;
            ((FilterOutputStream) this).out = null;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i8) throws IOException {
            if (this.f14261h) {
                ((FilterOutputStream) this).out.write(i8);
                return;
            }
            if (this.f14254a) {
                byte[] bArr = this.f14256c;
                int i9 = this.f14255b;
                int i10 = i9 + 1;
                this.f14255b = i10;
                bArr[i9] = (byte) i8;
                int i11 = this.f14257d;
                if (i10 < i11) {
                    return;
                }
                ((FilterOutputStream) this).out.write(c.b(this.f14260g, bArr, i11, this.f14262i));
                int i12 = this.f14258e + 4;
                this.f14258e = i12;
                if (this.f14259f && i12 >= c.f14233j) {
                    ((FilterOutputStream) this).out.write(10);
                    this.f14258e = 0;
                }
            } else {
                byte b8 = this.f14263j[i8 & 127];
                if (b8 <= -5) {
                    if (b8 != -5) {
                        throw new IOException("Invalid character in Base64 data.");
                    }
                    return;
                }
                byte[] bArr2 = this.f14256c;
                int i13 = this.f14255b;
                int i14 = i13 + 1;
                this.f14255b = i14;
                bArr2[i13] = (byte) i8;
                if (i14 < this.f14257d) {
                    return;
                }
                ((FilterOutputStream) this).out.write(this.f14260g, 0, c.b(bArr2, 0, this.f14260g, 0, this.f14262i));
            }
            this.f14255b = 0;
        }

        public b(OutputStream outputStream, int i8) {
            super(outputStream);
            this.f14259f = (i8 & 8) != 0;
            boolean z7 = (i8 & 1) != 0;
            this.f14254a = z7;
            int i9 = z7 ? 3 : 4;
            this.f14257d = i9;
            this.f14256c = new byte[i9];
            this.f14255b = 0;
            this.f14258e = 0;
            this.f14261h = false;
            this.f14260g = new byte[4];
            this.f14262i = i8;
            this.f14263j = c.c(i8);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i8, int i9) throws IOException {
            if (this.f14261h) {
                ((FilterOutputStream) this).out.write(bArr, i8, i9);
                return;
            }
            for (int i10 = 0; i10 < i9; i10++) {
                write(bArr[i8 + i10]);
            }
        }
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(byte[] bArr, int i8, byte[] bArr2, int i9, int i10) {
        int i11;
        int i12;
        if (bArr == null) {
            throw new NullPointerException("Source array was null.");
        }
        if (bArr2 == null) {
            throw new NullPointerException("Destination array was null.");
        }
        if (i8 < 0 || (i11 = i8 + 3) >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i8)));
        }
        if (i9 < 0 || (i12 = i9 + 2) >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i9)));
        }
        byte[] bArrC = c(i10);
        byte b8 = bArr[i8 + 2];
        if (b8 == 61) {
            bArr2[i9] = (byte) ((((bArrC[bArr[i8 + 1]] & f14238o) << 12) | ((bArrC[bArr[i8]] & f14238o) << 18)) >>> 16);
            return 1;
        }
        byte b9 = bArr[i11];
        if (b9 == 61) {
            int i13 = ((bArrC[bArr[i8 + 1]] & f14238o) << 12) | ((bArrC[bArr[i8]] & f14238o) << 18) | ((bArrC[b8] & f14238o) << 6);
            bArr2[i9] = (byte) (i13 >>> 16);
            bArr2[i9 + 1] = (byte) (i13 >>> 8);
            return 2;
        }
        int i14 = ((bArrC[bArr[i8 + 1]] & f14238o) << 12) | ((bArrC[bArr[i8]] & f14238o) << 18) | ((bArrC[b8] & f14238o) << 6) | (bArrC[b9] & f14238o);
        bArr2[i9] = (byte) (i14 >> 16);
        bArr2[i9 + 1] = (byte) (i14 >> 8);
        bArr2[i12] = (byte) i14;
        return 3;
    }

    public static String c(String str) throws Throwable {
        a aVar = null;
        try {
            try {
                File file = new File(str);
                byte[] bArr = new byte[Math.max((int) ((file.length() * 1.4d) + 1.0d), 40)];
                a aVar2 = new a(new BufferedInputStream(new FileInputStream(file)), 1);
                int i8 = 0;
                while (true) {
                    try {
                        int i9 = aVar2.read(bArr, i8, 4096);
                        if (i9 < 0) {
                            break;
                        }
                        i8 += i9;
                    } catch (IOException e8) {
                        aVar = aVar2;
                        throw e8;
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
                String str2 = new String(bArr, 0, i8, f14236m);
                try {
                    aVar2.close();
                } catch (Exception unused2) {
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e9) {
            throw e9;
        }
    }

    public static String a(Serializable serializable) {
        return a(serializable, 0);
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
                bufferedOutputStream.write(strC.getBytes(f14236m));
                try {
                    bufferedOutputStream.close();
                } catch (Exception unused) {
                }
            } catch (IOException e8) {
                bufferedOutputStream2 = bufferedOutputStream;
                throw e8;
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream2 = bufferedOutputStream;
                try {
                    bufferedOutputStream2.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (IOException e9) {
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
            } catch (IOException e8) {
                bufferedOutputStream2 = bufferedOutputStream;
                throw e8;
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream2 = bufferedOutputStream;
                try {
                    bufferedOutputStream2.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (IOException e9) {
        }
    }

    public static String a(Serializable serializable, int i8) throws Throwable {
        OutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        b bVar;
        ObjectOutputStream objectOutputStream;
        if (serializable == null) {
            throw new NullPointerException("Cannot serialize a null object.");
        }
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
                bVar = new b(byteArrayOutputStream, i8 | 1);
                try {
                    if ((i8 & 2) != 0) {
                        gZIPOutputStream = new GZIPOutputStream(bVar);
                        try {
                            objectOutputStream2 = new ObjectOutputStream(gZIPOutputStream);
                            gZIPOutputStream = gZIPOutputStream;
                        } catch (IOException e8) {
                            e = e8;
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
                        return new String(byteArrayOutputStream.toByteArray(), f14236m);
                    } catch (UnsupportedEncodingException unused9) {
                        return new String(byteArrayOutputStream.toByteArray());
                    }
                } catch (IOException e9) {
                    e = e9;
                    ObjectOutputStream objectOutputStream4 = objectOutputStream2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    objectOutputStream = objectOutputStream4;
                    gZIPOutputStream = objectOutputStream4;
                } catch (Throwable th3) {
                    th = th3;
                    gZIPOutputStream = objectOutputStream2;
                }
            } catch (IOException e10) {
                e = e10;
                gZIPOutputStream = null;
                bVar = null;
                byteArrayOutputStream2 = byteArrayOutputStream;
                objectOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                gZIPOutputStream = null;
                bVar = null;
            }
        } catch (IOException e11) {
            e = e11;
            gZIPOutputStream = null;
            objectOutputStream = null;
            bVar = null;
        } catch (Throwable th5) {
            th = th5;
            gZIPOutputStream = null;
            byteArrayOutputStream = null;
            bVar = null;
        }
    }

    private static final byte[] b(int i8) {
        return (i8 & 16) == 16 ? f14241r : (i8 & 32) == 32 ? f14243t : f14239p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] c(int i8) {
        return (i8 & 16) == 16 ? f14242s : (i8 & 32) == 32 ? f14244u : f14240q;
    }

    public static String a(byte[] bArr) throws Throwable {
        String strA;
        try {
            strA = a(bArr, 0, bArr.length, 0);
        } catch (IOException e8) {
            if (!f14232i) {
                throw new AssertionError(e8.getMessage());
            }
            strA = null;
        }
        if (f14232i || strA != null) {
            return strA;
        }
        throw new AssertionError();
    }

    public static byte[] b(String str) throws Throwable {
        a aVar = null;
        try {
            try {
                File file = new File(str);
                if (file.length() > 2147483647L) {
                    throw new IOException("File is too big for this convenience method (" + file.length() + " bytes).");
                }
                byte[] bArr = new byte[(int) file.length()];
                a aVar2 = new a(new BufferedInputStream(new FileInputStream(file)), 0);
                int i8 = 0;
                while (true) {
                    try {
                        int i9 = aVar2.read(bArr, i8, 4096);
                        if (i9 < 0) {
                            break;
                        }
                        i8 += i9;
                    } catch (IOException e8) {
                        throw e8;
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
                byte[] bArr2 = new byte[i8];
                System.arraycopy(bArr, 0, bArr2, 0, i8);
                try {
                    aVar2.close();
                } catch (Exception unused2) {
                }
                return bArr2;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e9) {
            throw e9;
        }
    }

    public static byte[] c(byte[] bArr) {
        return c(bArr, 0, bArr.length, 0);
    }

    public static String a(byte[] bArr, int i8) {
        return a(bArr, 0, bArr.length, i8);
    }

    public static byte[] b(byte[] bArr) {
        try {
            return b(bArr, 0, bArr.length, 0);
        } catch (IOException e8) {
            if (f14232i) {
                return null;
            }
            throw new AssertionError("IOExceptions only come from GZipping, which is turned off: " + e8.getMessage());
        }
    }

    public static byte[] c(byte[] bArr, int i8, int i9, int i10) throws IOException {
        int i11;
        if (bArr == null) {
            throw new NullPointerException("Cannot decode null source array.");
        }
        if (i8 < 0 || (i11 = i8 + i9) > bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i8), Integer.valueOf(i9)));
        }
        if (i9 == 0) {
            return new byte[0];
        }
        if (i9 < 4) {
            throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + i9);
        }
        byte[] bArrC = c(i10);
        byte[] bArr2 = new byte[(i9 * 3) / 4];
        byte[] bArr3 = new byte[4];
        int i12 = 0;
        int iB = 0;
        while (i8 < i11) {
            byte b8 = bArr[i8];
            byte b9 = bArrC[b8 & f14238o];
            if (b9 < -5) {
                throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", Integer.valueOf(bArr[i8] & f14238o), Integer.valueOf(i8)));
            }
            if (b9 >= -1) {
                int i13 = i12 + 1;
                bArr3[i12] = b8;
                if (i13 > 3) {
                    iB += b(bArr3, 0, bArr2, iB, i10);
                    if (bArr[i8] == 61) {
                        break;
                    }
                    i12 = 0;
                } else {
                    i12 = i13;
                }
            }
            i8++;
        }
        byte[] bArr4 = new byte[iB];
        System.arraycopy(bArr2, 0, bArr4, 0, iB);
        return bArr4;
    }

    public static String a(byte[] bArr, int i8, int i9) throws Throwable {
        String strA;
        try {
            strA = a(bArr, i8, i9, 0);
        } catch (IOException e8) {
            if (!f14232i) {
                throw new AssertionError(e8.getMessage());
            }
            strA = null;
        }
        if (f14232i || strA != null) {
            return strA;
        }
        throw new AssertionError();
    }

    public static byte[] b(byte[] bArr, int i8, int i9, int i10) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        b bVar;
        GZIPOutputStream gZIPOutputStream;
        if (bArr == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        }
        if (i8 < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i8);
        }
        if (i9 < 0) {
            throw new IllegalArgumentException("Cannot have length offset: " + i9);
        }
        if (i8 + i9 > bArr.length) {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(bArr.length)));
        }
        if ((i10 & 2) == 0) {
            boolean z7 = (i10 & 8) != 0;
            int i11 = ((i9 / 3) * 4) + (i9 % 3 > 0 ? 4 : 0);
            if (z7) {
                i11 += i11 / f14233j;
            }
            int i12 = i11;
            byte[] bArr2 = new byte[i12];
            int i13 = i9 - 2;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            while (i14 < i13) {
                int i17 = i14;
                b(bArr, i14 + i8, 3, bArr2, i15, i10);
                int i18 = i16 + 4;
                if (!z7 || i18 < f14233j) {
                    i16 = i18;
                } else {
                    bArr2[i15 + 4] = f14235l;
                    i15++;
                    i16 = 0;
                }
                i14 = i17 + 3;
                i15 += 4;
            }
            int i19 = i14;
            if (i19 < i9) {
                b(bArr, i19 + i8, i9 - i19, bArr2, i15, i10);
                i15 += 4;
            }
            int i20 = i15;
            if (i20 > i12 - 1) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i20];
            System.arraycopy(bArr2, 0, bArr3, 0, i20);
            return bArr3;
        }
        GZIPOutputStream gZIPOutputStream2 = null;
        gZIPOutputStream2 = null;
        gZIPOutputStream2 = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bVar = new b(byteArrayOutputStream, i10 | 1);
                try {
                    gZIPOutputStream = new GZIPOutputStream(bVar);
                } catch (IOException e8) {
                    e = e8;
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
            } catch (IOException e9) {
                e = e9;
                bVar = null;
                gZIPOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                bVar = null;
            }
        } catch (IOException e10) {
            e = e10;
            bVar = null;
            gZIPOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            bVar = null;
        }
        try {
            gZIPOutputStream.write(bArr, i8, i9);
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
        } catch (IOException e11) {
            e = e11;
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

    public static String a(byte[] bArr, int i8, int i9, int i10) throws Throwable {
        byte[] bArrB = b(bArr, i8, i9, i10);
        try {
            return new String(bArrB, f14236m);
        } catch (UnsupportedEncodingException unused) {
            return new String(bArrB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(byte[] bArr, int i8, int i9, byte[] bArr2, int i10, int i11) {
        byte[] bArrB = b(i11);
        int i12 = (i9 > 0 ? (bArr[i8] << 24) >>> 8 : 0) | (i9 > 1 ? (bArr[i8 + 1] << 24) >>> 16 : 0) | (i9 > 2 ? (bArr[i8 + 2] << 24) >>> 24 : 0);
        if (i9 == 1) {
            bArr2[i10] = bArrB[i12 >>> 18];
            bArr2[i10 + 1] = bArrB[(i12 >>> 12) & 63];
            bArr2[i10 + 2] = f14234k;
            bArr2[i10 + 3] = f14234k;
            return bArr2;
        }
        if (i9 == 2) {
            bArr2[i10] = bArrB[i12 >>> 18];
            bArr2[i10 + 1] = bArrB[(i12 >>> 12) & 63];
            bArr2[i10 + 2] = bArrB[(i12 >>> 6) & 63];
            bArr2[i10 + 3] = f14234k;
            return bArr2;
        }
        if (i9 != 3) {
            return bArr2;
        }
        bArr2[i10] = bArrB[i12 >>> 18];
        bArr2[i10 + 1] = bArrB[(i12 >>> 12) & 63];
        bArr2[i10 + 2] = bArrB[(i12 >>> 6) & 63];
        bArr2[i10 + 3] = bArrB[i12 & 63];
        return bArr2;
    }

    public static void a(String str, String str2) throws Throwable {
        b bVar;
        b bVar2 = null;
        try {
            try {
                bVar = new b(new FileOutputStream(str2), 0);
            } catch (IOException e8) {
                throw e8;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bVar.write(str.getBytes(f14236m));
            try {
                bVar.close();
            } catch (Exception unused) {
            }
        } catch (IOException e9) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(byte[] bArr, byte[] bArr2, int i8, int i9) {
        b(bArr2, 0, i8, bArr, 0, i9);
        return bArr;
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

    public static void a(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int iMin = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, iMin);
            b(bArr2, bArr, iMin, 0);
            for (int i8 = 0; i8 < 4; i8++) {
                charBuffer.put((char) (bArr2[i8] & f14238o));
            }
        }
    }

    public static void a(byte[] bArr, String str) throws Throwable {
        b bVar;
        if (bArr == null) {
            throw new NullPointerException("Data to encode was null.");
        }
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
                } catch (Exception unused) {
                }
            } catch (IOException e8) {
                bVar2 = bVar;
                throw e8;
            } catch (Throwable th2) {
                th = th2;
                bVar2 = bVar;
                try {
                    bVar2.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (IOException e9) {
        }
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
}
