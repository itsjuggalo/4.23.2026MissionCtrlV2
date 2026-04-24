package c3;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import v.AbstractC2758a;

/* JADX INFO: loaded from: classes.dex */
public class p extends AbstractC2758a implements ScheduledFuture {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ScheduledFuture f9408h;

    public class a implements b {
        public a() {
        }

        @Override // c3.p.b
        public void a(Throwable th) {
            p.this.t(th);
        }

        @Override // c3.p.b
        public void set(Object obj) {
            p.this.s(obj);
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
        this.f9408h = cVar.a(new a());
    }

    @Override // v.AbstractC2758a
    public void c() {
        this.f9408h.cancel(v());
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return this.f9408h.getDelay(timeUnit);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public int compareTo(Delayed delayed) {
        return this.f9408h.compareTo(delayed);
    }
}
