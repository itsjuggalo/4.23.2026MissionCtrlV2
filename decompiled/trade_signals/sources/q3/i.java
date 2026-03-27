package q3;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BlockingQueue f22586a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f22590e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WritableByteChannel f22591f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Random f22587b = new Random();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f22588c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f22589d = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Thread f22592g = c.j().newThread(new a());

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.f();
        }
    }

    public i(c cVar, String str, int i8) {
        c.i().a(d(), str + "Writer-" + i8);
        this.f22590e = cVar;
        this.f22586a = new LinkedBlockingQueue();
    }

    public final ByteBuffer b(byte b8, boolean z7, byte[] bArr) {
        int i8 = z7 ? 6 : 2;
        int length = bArr.length;
        if (length >= 126) {
            i8 = length <= 65535 ? i8 + 2 : i8 + 8;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + i8);
        byteBufferAllocate.put((byte) (b8 | (-128)));
        if (length < 126) {
            if (z7) {
                length |= 128;
            }
            byteBufferAllocate.put((byte) length);
        } else if (length <= 65535) {
            byteBufferAllocate.put((byte) (z7 ? 254 : 126));
            byteBufferAllocate.putShort((short) length);
        } else {
            byteBufferAllocate.put((byte) (z7 ? 255 : 127));
            byteBufferAllocate.putInt(0);
            byteBufferAllocate.putInt(length);
        }
        if (z7) {
            byte[] bArrC = c();
            byteBufferAllocate.put(bArrC);
            for (int i9 = 0; i9 < bArr.length; i9++) {
                byteBufferAllocate.put((byte) (bArr[i9] ^ bArrC[i9 % 4]));
            }
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public final byte[] c() {
        byte[] bArr = new byte[4];
        this.f22587b.nextBytes(bArr);
        return bArr;
    }

    public Thread d() {
        return this.f22592g;
    }

    public final void e(e eVar) {
        this.f22590e.k(eVar);
    }

    public final void f() {
        while (!this.f22588c && !Thread.interrupted()) {
            try {
                j();
            } catch (IOException e8) {
                e(new e("IO Exception", e8));
                return;
            } catch (InterruptedException unused) {
                return;
            }
        }
        for (int i8 = 0; i8 < this.f22586a.size(); i8++) {
            j();
        }
    }

    public synchronized void g(byte b8, boolean z7, byte[] bArr) {
        try {
            ByteBuffer byteBufferB = b(b8, z7, bArr);
            if (this.f22588c && (this.f22589d || b8 != 8)) {
                throw new e("Shouldn't be sending");
            }
            if (b8 == 8) {
                this.f22589d = true;
            }
            this.f22586a.add(byteBufferB);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void h(OutputStream outputStream) {
        this.f22591f = Channels.newChannel(outputStream);
    }

    public void i() {
        this.f22588c = true;
    }

    public final void j() throws IOException {
        this.f22591f.write((ByteBuffer) this.f22586a.take());
    }
}
