package q1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: renamed from: q1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2621d extends InputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Queue f22520c = AbstractC2629l.f(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InputStream f22521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IOException f22522b;

    public static C2621d c(InputStream inputStream) {
        C2621d c2621d;
        Queue queue = f22520c;
        synchronized (queue) {
            c2621d = (C2621d) queue.poll();
        }
        if (c2621d == null) {
            c2621d = new C2621d();
        }
        c2621d.f(inputStream);
        return c2621d;
    }

    public IOException a() {
        return this.f22522b;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f22521a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f22521a.close();
    }

    public void e() {
        this.f22522b = null;
        this.f22521a = null;
        Queue queue = f22520c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    public void f(InputStream inputStream) {
        this.f22521a = inputStream;
    }

    @Override // java.io.InputStream
    public void mark(int i8) {
        this.f22521a.mark(i8);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f22521a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.f22521a.read();
        } catch (IOException e8) {
            this.f22522b = e8;
            throw e8;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f22521a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j8) throws IOException {
        try {
            return this.f22521a.skip(j8);
        } catch (IOException e8) {
            this.f22522b = e8;
            throw e8;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            return this.f22521a.read(bArr);
        } catch (IOException e8) {
            this.f22522b = e8;
            throw e8;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i8, int i9) throws IOException {
        try {
            return this.f22521a.read(bArr, i8, i9);
        } catch (IOException e8) {
            this.f22522b = e8;
            throw e8;
        }
    }
}
