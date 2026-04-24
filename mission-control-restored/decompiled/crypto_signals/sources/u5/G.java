package u5;

import java.io.InterruptedIOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class G {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F f10504d = new F();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f10505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f10506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f10507c;

    public G a() {
        this.f10505a = false;
        return this;
    }

    public G b() {
        this.f10507c = 0L;
        return this;
    }

    public long c() {
        if (this.f10505a) {
            return this.f10506b;
        }
        throw new IllegalStateException("No deadline");
    }

    public G d(long j4) {
        this.f10505a = true;
        this.f10506b = j4;
        return this;
    }

    public void e() throws InterruptedIOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.f10505a && this.f10506b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
