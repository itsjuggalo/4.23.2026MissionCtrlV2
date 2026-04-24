package K4;

import android.util.LongSparseArray;
import android.view.MotionEvent;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public final class N {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static N f3564c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LongSparseArray f3565a = new LongSparseArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PriorityQueue f3566b = new PriorityQueue();

    public static class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final AtomicLong f3567b = new AtomicLong(0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f3568a;

        public a(long j7) {
            this.f3568a = j7;
        }

        public static a b() {
            return c(f3567b.incrementAndGet());
        }

        public static a c(long j7) {
            return new a(j7);
        }

        public long d() {
            return this.f3568a;
        }
    }

    public static N a() {
        if (f3564c == null) {
            f3564c = new N();
        }
        return f3564c;
    }

    public MotionEvent b(a aVar) {
        while (!this.f3566b.isEmpty() && ((Long) this.f3566b.peek()).longValue() < aVar.f3568a) {
            this.f3565a.remove(((Long) this.f3566b.poll()).longValue());
        }
        if (!this.f3566b.isEmpty() && ((Long) this.f3566b.peek()).longValue() == aVar.f3568a) {
            this.f3566b.poll();
        }
        MotionEvent motionEvent = (MotionEvent) this.f3565a.get(aVar.f3568a);
        this.f3565a.remove(aVar.f3568a);
        return motionEvent;
    }

    public a c(MotionEvent motionEvent) {
        a aVarB = a.b();
        this.f3565a.put(aVarB.f3568a, MotionEvent.obtain(motionEvent));
        this.f3566b.add(Long.valueOf(aVarB.f3568a));
        return aVarB;
    }
}
