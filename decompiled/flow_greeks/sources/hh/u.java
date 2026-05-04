package hh;

import java.io.InterruptedIOException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f11510d = new b(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final u f11511e = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f11512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f11513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f11514c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        public b() {
        }
    }

    public long a() {
        if (this.f11512a) {
            return this.f11513b;
        }
        throw new IllegalStateException("No deadline");
    }

    public boolean b() {
        return this.f11512a;
    }

    public void c() throws InterruptedIOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.f11512a && this.f11513b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public long d() {
        return this.f11514c;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends u {
        @Override // hh.u
        public void c() {
        }
    }
}
