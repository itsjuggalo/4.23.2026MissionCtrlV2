package G4;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;
import v2.AbstractC2848n;

/* JADX INFO: renamed from: G4.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0528g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f2800c = Logger.getLogger(C0528g.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicLong f2802b;

    /* JADX INFO: renamed from: G4.g$b */
    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f2803a;

        public b(long j8) {
            this.f2803a = j8;
        }

        public void a() {
            long j8 = this.f2803a;
            long jMax = Math.max(2 * j8, j8);
            if (C0528g.this.f2802b.compareAndSet(this.f2803a, jMax)) {
                C0528g.f2800c.log(Level.WARNING, "Increased {0} to {1}", new Object[]{C0528g.this.f2801a, Long.valueOf(jMax)});
            }
        }

        public long b() {
            return this.f2803a;
        }
    }

    public C0528g(String str, long j8) {
        AtomicLong atomicLong = new AtomicLong();
        this.f2802b = atomicLong;
        AbstractC2848n.e(j8 > 0, "value must be positive");
        this.f2801a = str;
        atomicLong.set(j8);
    }

    public b d() {
        return new b(this.f2802b.get());
    }
}
