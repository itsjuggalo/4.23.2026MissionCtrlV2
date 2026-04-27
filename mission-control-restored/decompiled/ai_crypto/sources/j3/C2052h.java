package j3;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: j3.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2052h implements Closeable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Logger f17394g = Logger.getLogger(C2052h.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RandomAccessFile f17395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f17396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f17398d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f17399e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f17400f = new byte[16];

    /* JADX INFO: renamed from: j3.h$a */
    public class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f17401a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ StringBuilder f17402b;

        public a(StringBuilder sb) {
            this.f17402b = sb;
        }

        @Override // j3.C2052h.d
        public void a(InputStream inputStream, int i7) {
            if (this.f17401a) {
                this.f17401a = false;
            } else {
                this.f17402b.append(", ");
            }
            this.f17402b.append(i7);
        }
    }

    /* JADX INFO: renamed from: j3.h$b */
    public static class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f17404c = new b(0, 0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f17406b;

        public b(int i7, int i8) {
            this.f17405a = i7;
            this.f17406b = i8;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.f17405a + ", length = " + this.f17406b + "]";
        }
    }

    /* JADX INFO: renamed from: j3.h$c */
    public final class c extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f17407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f17408b;

        public /* synthetic */ c(C2052h c2052h, b bVar, a aVar) {
            this(bVar);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i7, int i8) throws IOException {
            C2052h.c0(bArr, "buffer");
            if ((i7 | i8) < 0 || i8 > bArr.length - i7) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i9 = this.f17408b;
            if (i9 <= 0) {
                return -1;
            }
            if (i8 > i9) {
                i8 = i9;
            }
            C2052h.this.D0(this.f17407a, bArr, i7, i8);
            this.f17407a = C2052h.this.H0(this.f17407a + i8);
            this.f17408b -= i8;
            return i8;
        }

        public c(b bVar) {
            this.f17407a = C2052h.this.H0(bVar.f17405a + 4);
            this.f17408b = bVar.f17406b;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.f17408b == 0) {
                return -1;
            }
            C2052h.this.f17395a.seek(this.f17407a);
            int i7 = C2052h.this.f17395a.read();
            this.f17407a = C2052h.this.H0(this.f17407a + 1);
            this.f17408b--;
            return i7;
        }
    }

    /* JADX INFO: renamed from: j3.h$d */
    public interface d {
        void a(InputStream inputStream, int i7);
    }

    public C2052h(File file) throws IOException {
        if (!file.exists()) {
            V(file);
        }
        this.f17395a = i0(file);
        z0();
    }

    public static int A0(byte[] bArr, int i7) {
        return ((bArr[i7] & 255) << 24) + ((bArr[i7 + 1] & 255) << 16) + ((bArr[i7 + 2] & 255) << 8) + (bArr[i7 + 3] & 255);
    }

    public static void J0(byte[] bArr, int i7, int i8) {
        bArr[i7] = (byte) (i8 >> 24);
        bArr[i7 + 1] = (byte) (i8 >> 16);
        bArr[i7 + 2] = (byte) (i8 >> 8);
        bArr[i7 + 3] = (byte) i8;
    }

    public static void K0(byte[] bArr, int... iArr) {
        int i7 = 0;
        for (int i8 : iArr) {
            J0(bArr, i7, i8);
            i7 += 4;
        }
    }

    public static void V(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile randomAccessFileI0 = i0(file2);
        try {
            randomAccessFileI0.setLength(4096L);
            randomAccessFileI0.seek(0L);
            byte[] bArr = new byte[16];
            K0(bArr, 4096, 0, 0, 0);
            randomAccessFileI0.write(bArr);
            randomAccessFileI0.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            randomAccessFileI0.close();
            throw th;
        }
    }

    public static Object c0(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static RandomAccessFile i0(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    public final int B0() {
        return this.f17396b - G0();
    }

    public synchronized void C0() {
        try {
            if (X()) {
                throw new NoSuchElementException();
            }
            if (this.f17397c == 1) {
                M();
            } else {
                b bVar = this.f17398d;
                int iH0 = H0(bVar.f17405a + 4 + bVar.f17406b);
                D0(iH0, this.f17400f, 0, 4);
                int iA0 = A0(this.f17400f, 0);
                I0(this.f17396b, this.f17397c - 1, iH0, this.f17399e.f17405a);
                this.f17397c--;
                this.f17398d = new b(iH0, iA0);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void D0(int i7, byte[] bArr, int i8, int i9) throws IOException {
        int iH0 = H0(i7);
        int i10 = iH0 + i9;
        int i11 = this.f17396b;
        if (i10 <= i11) {
            this.f17395a.seek(iH0);
            this.f17395a.readFully(bArr, i8, i9);
            return;
        }
        int i12 = i11 - iH0;
        this.f17395a.seek(iH0);
        this.f17395a.readFully(bArr, i8, i12);
        this.f17395a.seek(16L);
        this.f17395a.readFully(bArr, i8 + i12, i9 - i12);
    }

    public final void E0(int i7, byte[] bArr, int i8, int i9) throws IOException {
        int iH0 = H0(i7);
        int i10 = iH0 + i9;
        int i11 = this.f17396b;
        if (i10 <= i11) {
            this.f17395a.seek(iH0);
            this.f17395a.write(bArr, i8, i9);
            return;
        }
        int i12 = i11 - iH0;
        this.f17395a.seek(iH0);
        this.f17395a.write(bArr, i8, i12);
        this.f17395a.seek(16L);
        this.f17395a.write(bArr, i8 + i12, i9 - i12);
    }

    public final void F0(int i7) throws IOException {
        this.f17395a.setLength(i7);
        this.f17395a.getChannel().force(true);
    }

    public int G0() {
        if (this.f17397c == 0) {
            return 16;
        }
        b bVar = this.f17399e;
        int i7 = bVar.f17405a;
        int i8 = this.f17398d.f17405a;
        return i7 >= i8 ? (i7 - i8) + 4 + bVar.f17406b + 16 : (((i7 + 4) + bVar.f17406b) + this.f17396b) - i8;
    }

    public void H(byte[] bArr) {
        K(bArr, 0, bArr.length);
    }

    public final int H0(int i7) {
        int i8 = this.f17396b;
        return i7 < i8 ? i7 : (i7 + 16) - i8;
    }

    public final void I0(int i7, int i8, int i9, int i10) throws IOException {
        K0(this.f17400f, i7, i8, i9, i10);
        this.f17395a.seek(0L);
        this.f17395a.write(this.f17400f);
    }

    public synchronized void K(byte[] bArr, int i7, int i8) {
        int iH0;
        try {
            c0(bArr, "buffer");
            if ((i7 | i8) < 0 || i8 > bArr.length - i7) {
                throw new IndexOutOfBoundsException();
            }
            O(i8);
            boolean zX = X();
            if (zX) {
                iH0 = 16;
            } else {
                b bVar = this.f17399e;
                iH0 = H0(bVar.f17405a + 4 + bVar.f17406b);
            }
            b bVar2 = new b(iH0, i8);
            J0(this.f17400f, 0, i8);
            E0(bVar2.f17405a, this.f17400f, 0, 4);
            E0(bVar2.f17405a + 4, bArr, i7, i8);
            I0(this.f17396b, this.f17397c + 1, zX ? bVar2.f17405a : this.f17398d.f17405a, bVar2.f17405a);
            this.f17399e = bVar2;
            this.f17397c++;
            if (zX) {
                this.f17398d = bVar2;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void M() {
        try {
            I0(4096, 0, 0, 0);
            this.f17397c = 0;
            b bVar = b.f17404c;
            this.f17398d = bVar;
            this.f17399e = bVar;
            if (this.f17396b > 4096) {
                F0(4096);
            }
            this.f17396b = 4096;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void O(int i7) throws IOException {
        int i8 = i7 + 4;
        int iB0 = B0();
        if (iB0 >= i8) {
            return;
        }
        int i9 = this.f17396b;
        do {
            iB0 += i9;
            i9 <<= 1;
        } while (iB0 < i8);
        F0(i9);
        b bVar = this.f17399e;
        int iH0 = H0(bVar.f17405a + 4 + bVar.f17406b);
        if (iH0 < this.f17398d.f17405a) {
            FileChannel channel = this.f17395a.getChannel();
            channel.position(this.f17396b);
            long j7 = iH0 - 4;
            if (channel.transferTo(16L, j7, channel) != j7) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i10 = this.f17399e.f17405a;
        int i11 = this.f17398d.f17405a;
        if (i10 < i11) {
            int i12 = (this.f17396b + i10) - 16;
            I0(i9, this.f17397c, i11, i12);
            this.f17399e = new b(i12, this.f17399e.f17406b);
        } else {
            I0(i9, this.f17397c, i11, i10);
        }
        this.f17396b = i9;
    }

    public synchronized void T(d dVar) {
        int iH0 = this.f17398d.f17405a;
        for (int i7 = 0; i7 < this.f17397c; i7++) {
            b bVarY0 = y0(iH0);
            dVar.a(new c(this, bVarY0, null), bVarY0.f17406b);
            iH0 = H0(bVarY0.f17405a + 4 + bVarY0.f17406b);
        }
    }

    public synchronized boolean X() {
        return this.f17397c == 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f17395a.close();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.f17396b);
        sb.append(", size=");
        sb.append(this.f17397c);
        sb.append(", first=");
        sb.append(this.f17398d);
        sb.append(", last=");
        sb.append(this.f17399e);
        sb.append(", element lengths=[");
        try {
            T(new a(sb));
        } catch (IOException e7) {
            f17394g.log(Level.WARNING, "read error", (Throwable) e7);
        }
        sb.append("]]");
        return sb.toString();
    }

    public final b y0(int i7) throws IOException {
        if (i7 == 0) {
            return b.f17404c;
        }
        this.f17395a.seek(i7);
        return new b(i7, this.f17395a.readInt());
    }

    public final void z0() throws IOException {
        this.f17395a.seek(0L);
        this.f17395a.readFully(this.f17400f);
        int iA0 = A0(this.f17400f, 0);
        this.f17396b = iA0;
        if (iA0 <= this.f17395a.length()) {
            this.f17397c = A0(this.f17400f, 4);
            int iA02 = A0(this.f17400f, 8);
            int iA03 = A0(this.f17400f, 12);
            this.f17398d = y0(iA02);
            this.f17399e = y0(iA03);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.f17396b + ", Actual length: " + this.f17395a.length());
    }
}
