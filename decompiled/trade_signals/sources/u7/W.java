package u7;

import java.io.InterruptedIOException;
import kotlin.jvm.internal.AbstractC2296k;

/* JADX INFO: loaded from: classes2.dex */
public abstract class W {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f23610d = new b(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final W f23611e = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f23612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f23613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f23614c;

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public long a() {
        if (this.f23612a) {
            return this.f23613b;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    public boolean b() {
        return this.f23612a;
    }

    public void c() throws InterruptedIOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.f23612a && this.f23613b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public long d() {
        return this.f23614c;
    }

    public static final class a extends W {
        @Override // u7.W
        public void c() {
        }
    }
}
