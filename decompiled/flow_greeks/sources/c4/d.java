package c4;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends InputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Queue f3578c = l.f(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InputStream f3579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IOException f3580b;

    public static d c(InputStream inputStream) {
        d dVar;
        Queue queue = f3578c;
        synchronized (queue) {
            dVar = (d) queue.poll();
        }
        if (dVar == null) {
            dVar = new d();
        }
        dVar.o(inputStream);
        return dVar;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f3579a.available();
    }

    public IOException b() {
        return this.f3580b;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3579a.close();
    }

    public void e() {
        this.f3580b = null;
        this.f3579a = null;
        Queue queue = f3578c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    @Override // java.io.InputStream
    public void mark(int i10) {
        this.f3579a.mark(i10);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f3579a.markSupported();
    }

    public void o(InputStream inputStream) {
        this.f3579a = inputStream;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.f3579a.read();
        } catch (IOException e10) {
            this.f3580b = e10;
            throw e10;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f3579a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j10) throws IOException {
        try {
            return this.f3579a.skip(j10);
        } catch (IOException e10) {
            this.f3580b = e10;
            throw e10;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            return this.f3579a.read(bArr);
        } catch (IOException e10) {
            this.f3580b = e10;
            throw e10;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        try {
            return this.f3579a.read(bArr, i10, i11);
        } catch (IOException e10) {
            this.f3580b = e10;
            throw e10;
        }
    }
}
