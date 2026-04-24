package O3;

import java.io.InterruptedIOException;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public abstract class u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f3362d = new b(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final u f3363e = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f3365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f3366c;

    public static final class b {
        public /* synthetic */ b(AbstractC1585j abstractC1585j) {
            this();
        }

        public b() {
        }
    }

    public long a() {
        if (this.f3364a) {
            return this.f3365b;
        }
        throw new IllegalStateException("No deadline");
    }

    public boolean b() {
        return this.f3364a;
    }

    public void c() throws InterruptedIOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.f3364a && this.f3365b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public long d() {
        return this.f3366c;
    }

    public static final class a extends u {
        @Override // O3.u
        public void c() {
        }
    }
}
