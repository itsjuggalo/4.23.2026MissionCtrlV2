package U2;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public class h implements Closeable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Logger f8116g = Logger.getLogger(h.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RandomAccessFile f8117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f8120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f8121e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f8122f = new byte[16];

    public class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f8123a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ StringBuilder f8124b;

        public a(StringBuilder sb) {
            this.f8124b = sb;
        }

        @Override // U2.h.d
        public void a(InputStream inputStream, int i8) {
            if (this.f8123a) {
                this.f8123a = false;
            } else {
                this.f8124b.append(", ");
            }
            this.f8124b.append(i8);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f8126c = new b(0, 0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8128b;

        public b(int i8, int i9) {
            this.f8127a = i8;
            this.f8128b = i9;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.f8127a + ", length = " + this.f8128b + "]";
        }
    }

    public final class c extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8130b;

        public c(b bVar) {
            this.f8129a = h.this.m0(bVar.f8127a + 4);
            this.f8130b = bVar.f8128b;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.f8130b == 0) {
                return -1;
            }
            h.this.f8117a.seek(this.f8129a);
            int i8 = h.this.f8117a.read();
            this.f8129a = h.this.m0(this.f8129a + 1);
            this.f8130b--;
            return i8;
        }

        public /* synthetic */ c(h hVar, b bVar, a aVar) {
            this(bVar);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i8, int i9) throws IOException {
            h.N(bArr, "buffer");
            if ((i8 | i9) < 0 || i9 > bArr.length - i8) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i10 = this.f8130b;
            if (i10 <= 0) {
                return -1;
            }
            if (i9 > i10) {
                i9 = i10;
            }
            h.this.W(this.f8129a, bArr, i8, i9);
            this.f8129a = h.this.m0(this.f8129a + i9);
            this.f8130b -= i9;
            return i9;
        }
    }

    public interface d {
        void a(InputStream inputStream, int i8);
    }

    public h(File file) throws IOException {
        if (!file.exists()) {
            K(file);
        }
        this.f8117a = O(file);
        R();
    }

    public static void K(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile randomAccessFileO = O(file2);
        try {
            randomAccessFileO.setLength(4096L);
            randomAccessFileO.seek(0L);
            byte[] bArr = new byte[16];
            v0(bArr, 4096, 0, 0, 0);
            randomAccessFileO.write(bArr);
            randomAccessFileO.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            randomAccessFileO.close();
            throw th;
        }
    }

    public static Object N(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static RandomAccessFile O(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    public static int S(byte[] bArr, int i8) {
        return ((bArr[i8] & 255) << 24) + ((bArr[i8 + 1] & 255) << 16) + ((bArr[i8 + 2] & 255) << 8) + (bArr[i8 + 3] & 255);
    }

    public static void s0(byte[] bArr, int i8, int i9) {
        bArr[i8] = (byte) (i9 >> 24);
        bArr[i8 + 1] = (byte) (i9 >> 16);
        bArr[i8 + 2] = (byte) (i9 >> 8);
        bArr[i8 + 3] = (byte) i9;
    }

    public static void v0(byte[] bArr, int... iArr) {
        int i8 = 0;
        for (int i9 : iArr) {
            s0(bArr, i8, i9);
            i8 += 4;
        }
    }

    public synchronized void B() {
        try {
            r0(4096, 0, 0, 0);
            this.f8119c = 0;
            b bVar = b.f8126c;
            this.f8120d = bVar;
            this.f8121e = bVar;
            if (this.f8118b > 4096) {
                b0(4096);
            }
            this.f8118b = 4096;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void D(int i8) throws IOException {
        int i9 = i8 + 4;
        int iT = T();
        if (iT >= i9) {
            return;
        }
        int i10 = this.f8118b;
        do {
            iT += i10;
            i10 <<= 1;
        } while (iT < i9);
        b0(i10);
        b bVar = this.f8121e;
        int iM0 = m0(bVar.f8127a + 4 + bVar.f8128b);
        if (iM0 < this.f8120d.f8127a) {
            FileChannel channel = this.f8117a.getChannel();
            channel.position(this.f8118b);
            long j8 = iM0 - 4;
            if (channel.transferTo(16L, j8, channel) != j8) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i11 = this.f8121e.f8127a;
        int i12 = this.f8120d.f8127a;
        if (i11 < i12) {
            int i13 = (this.f8118b + i11) - 16;
            r0(i10, this.f8119c, i12, i13);
            this.f8121e = new b(i13, this.f8121e.f8128b);
        } else {
            r0(i10, this.f8119c, i12, i11);
        }
        this.f8118b = i10;
    }

    public synchronized void E(d dVar) {
        int iM0 = this.f8120d.f8127a;
        for (int i8 = 0; i8 < this.f8119c; i8++) {
            b bVarQ = Q(iM0);
            dVar.a(new c(this, bVarQ, null), bVarQ.f8128b);
            iM0 = m0(bVarQ.f8127a + 4 + bVarQ.f8128b);
        }
    }

    public synchronized boolean M() {
        return this.f8119c == 0;
    }

    public final b Q(int i8) throws IOException {
        if (i8 == 0) {
            return b.f8126c;
        }
        this.f8117a.seek(i8);
        return new b(i8, this.f8117a.readInt());
    }

    public final void R() throws IOException {
        this.f8117a.seek(0L);
        this.f8117a.readFully(this.f8122f);
        int iS = S(this.f8122f, 0);
        this.f8118b = iS;
        if (iS <= this.f8117a.length()) {
            this.f8119c = S(this.f8122f, 4);
            int iS2 = S(this.f8122f, 8);
            int iS3 = S(this.f8122f, 12);
            this.f8120d = Q(iS2);
            this.f8121e = Q(iS3);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.f8118b + ", Actual length: " + this.f8117a.length());
    }

    public final int T() {
        return this.f8118b - i0();
    }

    public synchronized void U() {
        try {
            if (M()) {
                throw new NoSuchElementException();
            }
            if (this.f8119c == 1) {
                B();
            } else {
                b bVar = this.f8120d;
                int iM0 = m0(bVar.f8127a + 4 + bVar.f8128b);
                W(iM0, this.f8122f, 0, 4);
                int iS = S(this.f8122f, 0);
                r0(this.f8118b, this.f8119c - 1, iM0, this.f8121e.f8127a);
                this.f8119c--;
                this.f8120d = new b(iM0, iS);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void W(int i8, byte[] bArr, int i9, int i10) throws IOException {
        RandomAccessFile randomAccessFile;
        int iM0 = m0(i8);
        int i11 = iM0 + i10;
        int i12 = this.f8118b;
        if (i11 <= i12) {
            this.f8117a.seek(iM0);
            randomAccessFile = this.f8117a;
        } else {
            int i13 = i12 - iM0;
            this.f8117a.seek(iM0);
            this.f8117a.readFully(bArr, i9, i13);
            this.f8117a.seek(16L);
            randomAccessFile = this.f8117a;
            i9 += i13;
            i10 -= i13;
        }
        randomAccessFile.readFully(bArr, i9, i10);
    }

    public final void X(int i8, byte[] bArr, int i9, int i10) throws IOException {
        RandomAccessFile randomAccessFile;
        int iM0 = m0(i8);
        int i11 = iM0 + i10;
        int i12 = this.f8118b;
        if (i11 <= i12) {
            this.f8117a.seek(iM0);
            randomAccessFile = this.f8117a;
        } else {
            int i13 = i12 - iM0;
            this.f8117a.seek(iM0);
            this.f8117a.write(bArr, i9, i13);
            this.f8117a.seek(16L);
            randomAccessFile = this.f8117a;
            i9 += i13;
            i10 -= i13;
        }
        randomAccessFile.write(bArr, i9, i10);
    }

    public final void b0(int i8) throws IOException {
        this.f8117a.setLength(i8);
        this.f8117a.getChannel().force(true);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f8117a.close();
    }

    public int i0() {
        if (this.f8119c == 0) {
            return 16;
        }
        b bVar = this.f8121e;
        int i8 = bVar.f8127a;
        int i9 = this.f8120d.f8127a;
        return i8 >= i9 ? (i8 - i9) + 4 + bVar.f8128b + 16 : (((i8 + 4) + bVar.f8128b) + this.f8118b) - i9;
    }

    public final int m0(int i8) {
        int i9 = this.f8118b;
        return i8 < i9 ? i8 : (i8 + 16) - i9;
    }

    public void n(byte[] bArr) {
        r(bArr, 0, bArr.length);
    }

    public synchronized void r(byte[] bArr, int i8, int i9) {
        int iM0;
        try {
            N(bArr, "buffer");
            if ((i8 | i9) < 0 || i9 > bArr.length - i8) {
                throw new IndexOutOfBoundsException();
            }
            D(i9);
            boolean zM = M();
            if (zM) {
                iM0 = 16;
            } else {
                b bVar = this.f8121e;
                iM0 = m0(bVar.f8127a + 4 + bVar.f8128b);
            }
            b bVar2 = new b(iM0, i9);
            s0(this.f8122f, 0, i9);
            X(bVar2.f8127a, this.f8122f, 0, 4);
            X(bVar2.f8127a + 4, bArr, i8, i9);
            r0(this.f8118b, this.f8119c + 1, zM ? bVar2.f8127a : this.f8120d.f8127a, bVar2.f8127a);
            this.f8121e = bVar2;
            this.f8119c++;
            if (zM) {
                this.f8120d = bVar2;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void r0(int i8, int i9, int i10, int i11) throws IOException {
        v0(this.f8122f, i8, i9, i10, i11);
        this.f8117a.seek(0L);
        this.f8117a.write(this.f8122f);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.f8118b);
        sb.append(", size=");
        sb.append(this.f8119c);
        sb.append(", first=");
        sb.append(this.f8120d);
        sb.append(", last=");
        sb.append(this.f8121e);
        sb.append(", element lengths=[");
        try {
            E(new a(sb));
        } catch (IOException e8) {
            f8116g.log(Level.WARNING, "read error", (Throwable) e8);
        }
        sb.append("]]");
        return sb.toString();
    }
}
