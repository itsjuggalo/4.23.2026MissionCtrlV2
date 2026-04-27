package N2;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import y.AbstractC2964a;

/* JADX INFO: loaded from: classes.dex */
public class p extends AbstractC2964a implements ScheduledFuture {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ScheduledFuture f5529h;

    public class a implements b {
        public a() {
        }

        @Override // N2.p.b
        public void a(Throwable th) {
            p.this.K(th);
        }

        @Override // N2.p.b
        public void set(Object obj) {
            p.this.J(obj);
        }
    }

    public interface b {
        void a(Throwable th);

        void set(Object obj);
    }

    public interface c {
        ScheduledFuture a(b bVar);
    }

    public p(c cVar) {
        this.f5529h = cVar.a(new a());
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public int compareTo(Delayed delayed) {
        return this.f5529h.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return this.f5529h.getDelay(timeUnit);
    }

    @Override // y.AbstractC2964a
    public void i() {
        this.f5529h.cancel(M());
    }
}
