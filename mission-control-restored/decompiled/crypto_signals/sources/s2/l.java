package s2;

import P3.u;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class l implements Closeable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Logger f9560k = Logger.getLogger(l.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RandomAccessFile f9561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C1006i f9564d;
    public C1006i e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f9565f;

    public l(File file) throws IOException {
        byte[] bArr = new byte[16];
        this.f9565f = bArr;
        if (!file.exists()) {
            File file2 = new File(file.getPath() + ".tmp");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rwd");
            try {
                randomAccessFile.setLength(4096L);
                randomAccessFile.seek(0L);
                byte[] bArr2 = new byte[16];
                int[] iArr = {4096, 0, 0, 0};
                int i = 0;
                for (int i6 = 0; i6 < 4; i6++) {
                    q(bArr2, i, iArr[i6]);
                    i += 4;
                }
                randomAccessFile.write(bArr2);
                randomAccessFile.close();
                if (!file2.renameTo(file)) {
                    throw new IOException("Rename failed!");
                }
            } catch (Throwable th) {
                randomAccessFile.close();
                throw th;
            }
        }
        RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rwd");
        this.f9561a = randomAccessFile2;
        randomAccessFile2.seek(0L);
        randomAccessFile2.readFully(bArr);
        int iJ = j(bArr, 0);
        this.f9562b = iJ;
        if (iJ > randomAccessFile2.length()) {
            throw new IOException("File is truncated. Expected length: " + this.f9562b + ", Actual length: " + randomAccessFile2.length());
        }
        this.f9563c = j(bArr, 4);
        int iJ2 = j(bArr, 8);
        int iJ3 = j(bArr, 12);
        this.f9564d = i(iJ2);
        this.e = i(iJ3);
    }

    public static int j(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
    }

    public static void q(byte[] bArr, int i, int i6) {
        bArr[i] = (byte) (i6 >> 24);
        bArr[i + 1] = (byte) (i6 >> 16);
        bArr[i + 2] = (byte) (i6 >> 8);
        bArr[i + 3] = (byte) i6;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f9561a.close();
    }

    public final void d(byte[] bArr) {
        int iO;
        int length = bArr.length;
        synchronized (this) {
            if (length >= 0) {
                if (length <= bArr.length) {
                    f(length);
                    boolean zH = h();
                    if (zH) {
                        iO = 16;
                    } else {
                        C1006i c1006i = this.e;
                        iO = o(c1006i.f9555a + 4 + c1006i.f9556b);
                    }
                    C1006i c1006i2 = new C1006i(iO, length);
                    q(this.f9565f, 0, length);
                    m(this.f9565f, iO, 4);
                    m(bArr, iO + 4, length);
                    p(this.f9562b, this.f9563c + 1, zH ? iO : this.f9564d.f9555a, iO);
                    this.e = c1006i2;
                    this.f9563c++;
                    if (zH) {
                        this.f9564d = c1006i2;
                    }
                }
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public final void f(int i) throws IOException {
        int i6 = i + 4;
        int iN = this.f9562b - n();
        if (iN >= i6) {
            return;
        }
        int i7 = this.f9562b;
        do {
            iN += i7;
            i7 <<= 1;
        } while (iN < i6);
        RandomAccessFile randomAccessFile = this.f9561a;
        randomAccessFile.setLength(i7);
        randomAccessFile.getChannel().force(true);
        C1006i c1006i = this.e;
        int iO = o(c1006i.f9555a + 4 + c1006i.f9556b);
        if (iO < this.f9564d.f9555a) {
            FileChannel channel = randomAccessFile.getChannel();
            channel.position(this.f9562b);
            long j4 = iO - 4;
            if (channel.transferTo(16L, j4, channel) != j4) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i8 = this.e.f9555a;
        int i9 = this.f9564d.f9555a;
        if (i8 < i9) {
            int i10 = (this.f9562b + i8) - 16;
            p(i7, this.f9563c, i9, i10);
            this.e = new C1006i(i10, this.e.f9556b);
        } else {
            p(i7, this.f9563c, i9, i8);
        }
        this.f9562b = i7;
    }

    public final synchronized void g(InterfaceC1008k interfaceC1008k) {
        int iO = this.f9564d.f9555a;
        for (int i = 0; i < this.f9563c; i++) {
            C1006i c1006iI = i(iO);
            interfaceC1008k.a(new C1007j(this, c1006iI), c1006iI.f9556b);
            iO = o(c1006iI.f9555a + 4 + c1006iI.f9556b);
        }
    }

    public final synchronized boolean h() {
        return this.f9563c == 0;
    }

    public final C1006i i(int i) throws IOException {
        if (i == 0) {
            return C1006i.f9554c;
        }
        RandomAccessFile randomAccessFile = this.f9561a;
        randomAccessFile.seek(i);
        return new C1006i(i, randomAccessFile.readInt());
    }

    public final synchronized void k() {
        if (h()) {
            throw new NoSuchElementException();
        }
        if (this.f9563c == 1) {
            synchronized (this) {
                p(4096, 0, 0, 0);
                this.f9563c = 0;
                C1006i c1006i = C1006i.f9554c;
                this.f9564d = c1006i;
                this.e = c1006i;
                if (this.f9562b > 4096) {
                    RandomAccessFile randomAccessFile = this.f9561a;
                    randomAccessFile.setLength(4096);
                    randomAccessFile.getChannel().force(true);
                }
                this.f9562b = 4096;
            }
        } else {
            C1006i c1006i2 = this.f9564d;
            int iO = o(c1006i2.f9555a + 4 + c1006i2.f9556b);
            l(iO, this.f9565f, 0, 4);
            int iJ = j(this.f9565f, 0);
            p(this.f9562b, this.f9563c - 1, iO, this.e.f9555a);
            this.f9563c--;
            this.f9564d = new C1006i(iO, iJ);
        }
    }

    public final void l(int i, byte[] bArr, int i6, int i7) throws IOException {
        int iO = o(i);
        int i8 = iO + i7;
        int i9 = this.f9562b;
        RandomAccessFile randomAccessFile = this.f9561a;
        if (i8 <= i9) {
            randomAccessFile.seek(iO);
            randomAccessFile.readFully(bArr, i6, i7);
            return;
        }
        int i10 = i9 - iO;
        randomAccessFile.seek(iO);
        randomAccessFile.readFully(bArr, i6, i10);
        randomAccessFile.seek(16L);
        randomAccessFile.readFully(bArr, i6 + i10, i7 - i10);
    }

    public final void m(byte[] bArr, int i, int i6) throws IOException {
        int iO = o(i);
        int i7 = iO + i6;
        int i8 = this.f9562b;
        RandomAccessFile randomAccessFile = this.f9561a;
        if (i7 <= i8) {
            randomAccessFile.seek(iO);
            randomAccessFile.write(bArr, 0, i6);
            return;
        }
        int i9 = i8 - iO;
        randomAccessFile.seek(iO);
        randomAccessFile.write(bArr, 0, i9);
        randomAccessFile.seek(16L);
        randomAccessFile.write(bArr, i9, i6 - i9);
    }

    public final int n() {
        if (this.f9563c == 0) {
            return 16;
        }
        C1006i c1006i = this.e;
        int i = c1006i.f9555a;
        int i6 = this.f9564d.f9555a;
        return i >= i6 ? (i - i6) + 4 + c1006i.f9556b + 16 : (((i + 4) + c1006i.f9556b) + this.f9562b) - i6;
    }

    public final int o(int i) {
        int i6 = this.f9562b;
        return i < i6 ? i : (i + 16) - i6;
    }

    public final void p(int i, int i6, int i7, int i8) throws IOException {
        int[] iArr = {i, i6, i7, i8};
        byte[] bArr = this.f9565f;
        int i9 = 0;
        for (int i10 = 0; i10 < 4; i10++) {
            q(bArr, i9, iArr[i10]);
            i9 += 4;
        }
        RandomAccessFile randomAccessFile = this.f9561a;
        randomAccessFile.seek(0L);
        randomAccessFile.write(bArr);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(l.class.getSimpleName());
        sb.append("[fileLength=");
        sb.append(this.f9562b);
        sb.append(", size=");
        sb.append(this.f9563c);
        sb.append(", first=");
        sb.append(this.f9564d);
        sb.append(", last=");
        sb.append(this.e);
        sb.append(", element lengths=[");
        try {
            g(new u(sb, 9));
        } catch (IOException e) {
            f9560k.log(Level.WARNING, "read error", (Throwable) e);
        }
        sb.append("]]");
        return sb.toString();
    }
}
