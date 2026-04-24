package t5;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: t5.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2675g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f23763c = Logger.getLogger(C2675g.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicLong f23765b;

    /* JADX INFO: renamed from: t5.g$b */
    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f23766a;

        public void a() {
            long j7 = this.f23766a;
            long jMax = Math.max(2 * j7, j7);
            if (C2675g.this.f23765b.compareAndSet(this.f23766a, jMax)) {
                C2675g.f23763c.log(Level.WARNING, "Increased {0} to {1}", new Object[]{C2675g.this.f23764a, Long.valueOf(jMax)});
            }
        }

        public long b() {
            return this.f23766a;
        }

        public b(long j7) {
            this.f23766a = j7;
        }
    }

    public C2675g(String str, long j7) {
        AtomicLong atomicLong = new AtomicLong();
        this.f23765b = atomicLong;
        H2.m.e(j7 > 0, "value must be positive");
        this.f23764a = str;
        atomicLong.set(j7);
    }

    public b d() {
        return new b(this.f23765b.get());
    }
}
