package M2;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: M2.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0420g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f2212c = Logger.getLogger(C0420g.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicLong f2214b;

    /* JADX INFO: renamed from: M2.g$b */
    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f2215a;

        public void a() {
            long j4 = this.f2215a;
            long jMax = Math.max(2 * j4, j4);
            if (C0420g.this.f2214b.compareAndSet(this.f2215a, jMax)) {
                C0420g.f2212c.log(Level.WARNING, "Increased {0} to {1}", new Object[]{C0420g.this.f2213a, Long.valueOf(jMax)});
            }
        }

        public long b() {
            return this.f2215a;
        }

        public b(long j4) {
            this.f2215a = j4;
        }
    }

    public C0420g(String str, long j4) {
        AtomicLong atomicLong = new AtomicLong();
        this.f2214b = atomicLong;
        Z1.m.e(j4 > 0, "value must be positive");
        this.f2213a = str;
        atomicLong.set(j4);
    }

    public b d() {
        return new b(this.f2214b.get());
    }
}
