package S0;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class c implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f7326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Charset f7327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f7328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7330e;

    public class a extends ByteArrayOutputStream {
        public a(int i8) {
            super(i8);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i8 = ((ByteArrayOutputStream) this).count;
            if (i8 > 0 && ((ByteArrayOutputStream) this).buf[i8 - 1] == 13) {
                i8--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i8, c.this.f7327b.name());
            } catch (UnsupportedEncodingException e8) {
                throw new AssertionError(e8);
            }
        }
    }

    public c(InputStream inputStream, int i8, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i8 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(d.f7332a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f7326a = inputStream;
        this.f7327b = charset;
        this.f7328c = new byte[i8];
    }

    public final void c() throws IOException {
        InputStream inputStream = this.f7326a;
        byte[] bArr = this.f7328c;
        int i8 = inputStream.read(bArr, 0, bArr.length);
        if (i8 == -1) {
            throw new EOFException();
        }
        this.f7329d = 0;
        this.f7330e = i8;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f7326a) {
            try {
                if (this.f7328c != null) {
                    this.f7328c = null;
                    this.f7326a.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean e() {
        return this.f7330e == -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String f() {
        /*
            r7 = this;
            java.io.InputStream r0 = r7.f7326a
            monitor-enter(r0)
            byte[] r1 = r7.f7328c     // Catch: java.lang.Throwable -> L11
            if (r1 == 0) goto L83
            int r1 = r7.f7329d     // Catch: java.lang.Throwable -> L11
            int r2 = r7.f7330e     // Catch: java.lang.Throwable -> L11
            if (r1 < r2) goto L14
            r7.c()     // Catch: java.lang.Throwable -> L11
            goto L14
        L11:
            r1 = move-exception
            goto L8b
        L14:
            int r1 = r7.f7329d     // Catch: java.lang.Throwable -> L11
        L16:
            int r2 = r7.f7330e     // Catch: java.lang.Throwable -> L11
            r3 = 10
            if (r1 == r2) goto L45
            byte[] r2 = r7.f7328c     // Catch: java.lang.Throwable -> L11
            r4 = r2[r1]     // Catch: java.lang.Throwable -> L11
            if (r4 != r3) goto L42
            int r3 = r7.f7329d     // Catch: java.lang.Throwable -> L11
            if (r1 == r3) goto L2f
            int r4 = r1 + (-1)
            r5 = r2[r4]     // Catch: java.lang.Throwable -> L11
            r6 = 13
            if (r5 != r6) goto L2f
            goto L30
        L2f:
            r4 = r1
        L30:
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Throwable -> L11
            int r4 = r4 - r3
            java.nio.charset.Charset r6 = r7.f7327b     // Catch: java.lang.Throwable -> L11
            java.lang.String r6 = r6.name()     // Catch: java.lang.Throwable -> L11
            r5.<init>(r2, r3, r4, r6)     // Catch: java.lang.Throwable -> L11
            int r1 = r1 + 1
            r7.f7329d = r1     // Catch: java.lang.Throwable -> L11
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L11
            return r5
        L42:
            int r1 = r1 + 1
            goto L16
        L45:
            S0.c$a r1 = new S0.c$a     // Catch: java.lang.Throwable -> L11
            int r2 = r7.f7330e     // Catch: java.lang.Throwable -> L11
            int r4 = r7.f7329d     // Catch: java.lang.Throwable -> L11
            int r2 = r2 - r4
            int r2 = r2 + 80
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L11
        L51:
            byte[] r2 = r7.f7328c     // Catch: java.lang.Throwable -> L11
            int r4 = r7.f7329d     // Catch: java.lang.Throwable -> L11
            int r5 = r7.f7330e     // Catch: java.lang.Throwable -> L11
            int r5 = r5 - r4
            r1.write(r2, r4, r5)     // Catch: java.lang.Throwable -> L11
            r2 = -1
            r7.f7330e = r2     // Catch: java.lang.Throwable -> L11
            r7.c()     // Catch: java.lang.Throwable -> L11
            int r2 = r7.f7329d     // Catch: java.lang.Throwable -> L11
        L63:
            int r4 = r7.f7330e     // Catch: java.lang.Throwable -> L11
            if (r2 == r4) goto L51
            byte[] r4 = r7.f7328c     // Catch: java.lang.Throwable -> L11
            r5 = r4[r2]     // Catch: java.lang.Throwable -> L11
            if (r5 != r3) goto L80
            int r3 = r7.f7329d     // Catch: java.lang.Throwable -> L11
            if (r2 == r3) goto L76
            int r5 = r2 - r3
            r1.write(r4, r3, r5)     // Catch: java.lang.Throwable -> L11
        L76:
            int r2 = r2 + 1
            r7.f7329d = r2     // Catch: java.lang.Throwable -> L11
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L11
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L11
            return r1
        L80:
            int r2 = r2 + 1
            goto L63
        L83:
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> L11
            java.lang.String r2 = "LineReader is closed"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L11
            throw r1     // Catch: java.lang.Throwable -> L11
        L8b:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L11
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: S0.c.f():java.lang.String");
    }

    public c(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }
}
