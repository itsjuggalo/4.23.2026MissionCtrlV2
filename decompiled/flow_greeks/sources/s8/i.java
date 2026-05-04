package s8;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BlockingQueue f20103a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f20107e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WritableByteChannel f20108f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Random f20104b = new Random();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f20105c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f20106d = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Thread f20109g = c.j().newThread(new a());

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.f();
        }
    }

    public i(c cVar, String str, int i10) {
        c.i().a(d(), str + "Writer-" + i10);
        this.f20107e = cVar;
        this.f20103a = new LinkedBlockingQueue();
    }

    public final ByteBuffer b(byte b10, boolean z10, byte[] bArr) {
        int i10 = z10 ? 6 : 2;
        int length = bArr.length;
        if (length >= 126) {
            i10 = length <= 65535 ? i10 + 2 : i10 + 8;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + i10);
        byteBufferAllocate.put((byte) (b10 | (-128)));
        if (length < 126) {
            if (z10) {
                length |= 128;
            }
            byteBufferAllocate.put((byte) length);
        } else if (length <= 65535) {
            byteBufferAllocate.put((byte) (z10 ? 254 : 126));
            byteBufferAllocate.putShort((short) length);
        } else {
            byteBufferAllocate.put((byte) (z10 ? 255 : 127));
            byteBufferAllocate.putInt(0);
            byteBufferAllocate.putInt(length);
        }
        if (z10) {
            byte[] bArrC = c();
            byteBufferAllocate.put(bArrC);
            for (int i11 = 0; i11 < bArr.length; i11++) {
                byteBufferAllocate.put((byte) (bArr[i11] ^ bArrC[i11 % 4]));
            }
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public final byte[] c() {
        byte[] bArr = new byte[4];
        this.f20104b.nextBytes(bArr);
        return bArr;
    }

    public Thread d() {
        return this.f20109g;
    }

    public final void e(e eVar) {
        this.f20107e.k(eVar);
    }

    public final void f() {
        while (!this.f20105c && !Thread.interrupted()) {
            try {
                j();
            } catch (IOException e10) {
                e(new e("IO Exception", e10));
                return;
            } catch (InterruptedException unused) {
                return;
            }
        }
        for (int i10 = 0; i10 < this.f20103a.size(); i10++) {
            j();
        }
    }

    public synchronized void g(byte b10, boolean z10, byte[] bArr) {
        try {
            ByteBuffer byteBufferB = b(b10, z10, bArr);
            if (this.f20105c && (this.f20106d || b10 != 8)) {
                throw new e("Shouldn't be sending");
            }
            if (b10 == 8) {
                this.f20106d = true;
            }
            this.f20103a.add(byteBufferB);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void h(OutputStream outputStream) {
        this.f20108f = Channels.newChannel(outputStream);
    }

    public void i() {
        this.f20105c = true;
    }

    public final void j() throws IOException {
        this.f20108f.write((ByteBuffer) this.f20103a.take());
    }
}
