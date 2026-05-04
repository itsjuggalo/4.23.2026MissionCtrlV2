package tb;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f21236c = Logger.getLogger(g.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicLong f21238b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f21239a;

        public void a() {
            long j10 = this.f21239a;
            long jMax = Math.max(2 * j10, j10);
            if (g.this.f21238b.compareAndSet(this.f21239a, jMax)) {
                g.f21236c.log(Level.WARNING, "Increased {0} to {1}", new Object[]{g.this.f21237a, Long.valueOf(jMax)});
            }
        }

        public long b() {
            return this.f21239a;
        }

        public b(long j10) {
            this.f21239a = j10;
        }
    }

    public g(String str, long j10) {
        AtomicLong atomicLong = new AtomicLong();
        this.f21238b = atomicLong;
        p6.n.e(j10 > 0, "value must be positive");
        this.f21237a = str;
        atomicLong.set(j10);
    }

    public b d() {
        return new b(this.f21238b.get());
    }
}
