package w7;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h implements Closeable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Logger f23702g = Logger.getLogger(h.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RandomAccessFile f23703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f23704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f23705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f23706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f23707e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f23708f = new byte[16];

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f23709a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ StringBuilder f23710b;

        public a(StringBuilder sb2) {
            this.f23710b = sb2;
        }

        @Override // w7.h.d
        public void a(InputStream inputStream, int i10) {
            if (this.f23709a) {
                this.f23709a = false;
            } else {
                this.f23710b.append(", ");
            }
            this.f23710b.append(i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f23712c = new b(0, 0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f23713a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f23714b;

        public b(int i10, int i11) {
            this.f23713a = i10;
            this.f23714b = i11;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.f23713a + ", length = " + this.f23714b + "]";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class c extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f23715a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f23716b;

        public /* synthetic */ c(h hVar, b bVar, a aVar) {
            this(bVar);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            h.O(bArr, "buffer");
            if ((i10 | i11) < 0 || i11 > bArr.length - i10) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i12 = this.f23716b;
            if (i12 <= 0) {
                return -1;
            }
            if (i11 > i12) {
                i11 = i12;
            }
            h.this.e0(this.f23715a, bArr, i10, i11);
            this.f23715a = h.this.i0(this.f23715a + i11);
            this.f23716b -= i11;
            return i11;
        }

        public c(b bVar) {
            this.f23715a = h.this.i0(bVar.f23713a + 4);
            this.f23716b = bVar.f23714b;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.f23716b == 0) {
                return -1;
            }
            h.this.f23703a.seek(this.f23715a);
            int i10 = h.this.f23703a.read();
            this.f23715a = h.this.i0(this.f23715a + 1);
            this.f23716b--;
            return i10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface d {
        void a(InputStream inputStream, int i10);
    }

    public h(File file) throws IOException {
        if (!file.exists()) {
            K(file);
        }
        this.f23703a = R(file);
        a0();
    }

    public static void K(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile randomAccessFileR = R(file2);
        try {
            randomAccessFileR.setLength(4096L);
            randomAccessFileR.seek(0L);
            byte[] bArr = new byte[16];
            l0(bArr, 4096, 0, 0, 0);
            randomAccessFileR.write(bArr);
            randomAccessFileR.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            randomAccessFileR.close();
            throw th;
        }
    }

    public static Object O(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static RandomAccessFile R(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    public static int b0(byte[] bArr, int i10) {
        return ((bArr[i10] & 255) << 24) + ((bArr[i10 + 1] & 255) << 16) + ((bArr[i10 + 2] & 255) << 8) + (bArr[i10 + 3] & 255);
    }

    public static void k0(byte[] bArr, int i10, int i11) {
        bArr[i10] = (byte) (i11 >> 24);
        bArr[i10 + 1] = (byte) (i11 >> 16);
        bArr[i10 + 2] = (byte) (i11 >> 8);
        bArr[i10 + 3] = (byte) i11;
    }

    public static void l0(byte[] bArr, int... iArr) {
        int i10 = 0;
        for (int i11 : iArr) {
            k0(bArr, i10, i11);
            i10 += 4;
        }
    }

    public synchronized void C(byte[] bArr, int i10, int i11) {
        int iI0;
        try {
            O(bArr, "buffer");
            if ((i10 | i11) < 0 || i11 > bArr.length - i10) {
                throw new IndexOutOfBoundsException();
            }
            G(i11);
            boolean zN = N();
            if (zN) {
                iI0 = 16;
            } else {
                b bVar = this.f23707e;
                iI0 = i0(bVar.f23713a + 4 + bVar.f23714b);
            }
            b bVar2 = new b(iI0, i11);
            k0(this.f23708f, 0, i11);
            f0(bVar2.f23713a, this.f23708f, 0, 4);
            f0(bVar2.f23713a + 4, bArr, i10, i11);
            j0(this.f23704b, this.f23705c + 1, zN ? bVar2.f23713a : this.f23706d.f23713a, bVar2.f23713a);
            this.f23707e = bVar2;
            this.f23705c++;
            if (zN) {
                this.f23706d = bVar2;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void E() {
        try {
            j0(4096, 0, 0, 0);
            this.f23705c = 0;
            b bVar = b.f23712c;
            this.f23706d = bVar;
            this.f23707e = bVar;
            if (this.f23704b > 4096) {
                g0(4096);
            }
            this.f23704b = 4096;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void G(int i10) throws IOException {
        int i11 = i10 + 4;
        int iC0 = c0();
        if (iC0 >= i11) {
            return;
        }
        int i12 = this.f23704b;
        do {
            iC0 += i12;
            i12 <<= 1;
        } while (iC0 < i11);
        g0(i12);
        b bVar = this.f23707e;
        int iI0 = i0(bVar.f23713a + 4 + bVar.f23714b);
        if (iI0 < this.f23706d.f23713a) {
            FileChannel channel = this.f23703a.getChannel();
            channel.position(this.f23704b);
            long j10 = iI0 - 4;
            if (channel.transferTo(16L, j10, channel) != j10) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i13 = this.f23707e.f23713a;
        int i14 = this.f23706d.f23713a;
        if (i13 < i14) {
            int i15 = (this.f23704b + i13) - 16;
            j0(i12, this.f23705c, i14, i15);
            this.f23707e = new b(i15, this.f23707e.f23714b);
        } else {
            j0(i12, this.f23705c, i14, i13);
        }
        this.f23704b = i12;
    }

    public synchronized void H(d dVar) {
        int iI0 = this.f23706d.f23713a;
        for (int i10 = 0; i10 < this.f23705c; i10++) {
            b bVarZ = Z(iI0);
            dVar.a(new c(this, bVarZ, null), bVarZ.f23714b);
            iI0 = i0(bVarZ.f23713a + 4 + bVarZ.f23714b);
        }
    }

    public synchronized boolean N() {
        return this.f23705c == 0;
    }

    public final b Z(int i10) throws IOException {
        if (i10 == 0) {
            return b.f23712c;
        }
        this.f23703a.seek(i10);
        return new b(i10, this.f23703a.readInt());
    }

    public final void a0() throws IOException {
        this.f23703a.seek(0L);
        this.f23703a.readFully(this.f23708f);
        int iB0 = b0(this.f23708f, 0);
        this.f23704b = iB0;
        if (iB0 <= this.f23703a.length()) {
            this.f23705c = b0(this.f23708f, 4);
            int iB02 = b0(this.f23708f, 8);
            int iB03 = b0(this.f23708f, 12);
            this.f23706d = Z(iB02);
            this.f23707e = Z(iB03);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.f23704b + ", Actual length: " + this.f23703a.length());
    }

    public final int c0() {
        return this.f23704b - h0();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f23703a.close();
    }

    public synchronized void d0() {
        try {
            if (N()) {
                throw new NoSuchElementException();
            }
            if (this.f23705c == 1) {
                E();
            } else {
                b bVar = this.f23706d;
                int iI0 = i0(bVar.f23713a + 4 + bVar.f23714b);
                e0(iI0, this.f23708f, 0, 4);
                int iB0 = b0(this.f23708f, 0);
                j0(this.f23704b, this.f23705c - 1, iI0, this.f23707e.f23713a);
                this.f23705c--;
                this.f23706d = new b(iI0, iB0);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void e0(int i10, byte[] bArr, int i11, int i12) throws IOException {
        int iI0 = i0(i10);
        int i13 = iI0 + i12;
        int i14 = this.f23704b;
        if (i13 <= i14) {
            this.f23703a.seek(iI0);
            this.f23703a.readFully(bArr, i11, i12);
            return;
        }
        int i15 = i14 - iI0;
        this.f23703a.seek(iI0);
        this.f23703a.readFully(bArr, i11, i15);
        this.f23703a.seek(16L);
        this.f23703a.readFully(bArr, i11 + i15, i12 - i15);
    }

    public final void f0(int i10, byte[] bArr, int i11, int i12) throws IOException {
        int iI0 = i0(i10);
        int i13 = iI0 + i12;
        int i14 = this.f23704b;
        if (i13 <= i14) {
            this.f23703a.seek(iI0);
            this.f23703a.write(bArr, i11, i12);
            return;
        }
        int i15 = i14 - iI0;
        this.f23703a.seek(iI0);
        this.f23703a.write(bArr, i11, i15);
        this.f23703a.seek(16L);
        this.f23703a.write(bArr, i11 + i15, i12 - i15);
    }

    public final void g0(int i10) throws IOException {
        this.f23703a.setLength(i10);
        this.f23703a.getChannel().force(true);
    }

    public int h0() {
        if (this.f23705c == 0) {
            return 16;
        }
        b bVar = this.f23707e;
        int i10 = bVar.f23713a;
        int i11 = this.f23706d.f23713a;
        return i10 >= i11 ? (i10 - i11) + 4 + bVar.f23714b + 16 : (((i10 + 4) + bVar.f23714b) + this.f23704b) - i11;
    }

    public final int i0(int i10) {
        int i11 = this.f23704b;
        return i10 < i11 ? i10 : (i10 + 16) - i11;
    }

    public final void j0(int i10, int i11, int i12, int i13) throws IOException {
        l0(this.f23708f, i10, i11, i12, i13);
        this.f23703a.seek(0L);
        this.f23703a.write(this.f23708f);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append('[');
        sb2.append("fileLength=");
        sb2.append(this.f23704b);
        sb2.append(", size=");
        sb2.append(this.f23705c);
        sb2.append(", first=");
        sb2.append(this.f23706d);
        sb2.append(", last=");
        sb2.append(this.f23707e);
        sb2.append(", element lengths=[");
        try {
            H(new a(sb2));
        } catch (IOException e10) {
            f23702g.log(Level.WARNING, "read error", (Throwable) e10);
        }
        sb2.append("]]");
        return sb2.toString();
    }

    public void u(byte[] bArr) {
        C(bArr, 0, bArr.length);
    }
}
