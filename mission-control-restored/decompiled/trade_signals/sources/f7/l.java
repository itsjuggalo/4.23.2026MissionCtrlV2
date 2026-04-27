package f7;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.N;
import y.AbstractC2965b;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17645b = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "lastScheduledTask$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f17646c = AtomicIntegerFieldUpdater.newUpdater(l.class, "producerIndex$volatile");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f17647d = AtomicIntegerFieldUpdater.newUpdater(l.class, "consumerIndex$volatile");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f17648e = AtomicIntegerFieldUpdater.newUpdater(l.class, "blockingTasksInBuffer$volatile");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray f17649a = new AtomicReferenceArray(128);
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;

    public final h a(h hVar, boolean z7) {
        if (z7) {
            return b(hVar);
        }
        h hVar2 = (h) f17645b.getAndSet(this, hVar);
        if (hVar2 == null) {
            return null;
        }
        return b(hVar2);
    }

    public final h b(h hVar) {
        if (e() == 127) {
            return hVar;
        }
        if (hVar.f17636b) {
            f17648e.incrementAndGet(this);
        }
        int i8 = f17646c.get(this) & 127;
        while (this.f17649a.get(i8) != null) {
            Thread.yield();
        }
        this.f17649a.lazySet(i8, hVar);
        f17646c.incrementAndGet(this);
        return null;
    }

    public final void c(h hVar) {
        if (hVar == null || !hVar.f17636b) {
            return;
        }
        f17648e.decrementAndGet(this);
    }

    public final int e() {
        return f17646c.get(this) - f17647d.get(this);
    }

    public final int i() {
        return f17645b.get(this) != null ? e() + 1 : e();
    }

    public final void j(d dVar) {
        h hVar = (h) f17645b.getAndSet(this, null);
        if (hVar != null) {
            dVar.a(hVar);
        }
        while (n(dVar)) {
        }
    }

    public final h k() {
        h hVar = (h) f17645b.getAndSet(this, null);
        return hVar == null ? m() : hVar;
    }

    public final h l() {
        return o(true);
    }

    public final h m() {
        h hVar;
        while (true) {
            int i8 = f17647d.get(this);
            if (i8 - f17646c.get(this) == 0) {
                return null;
            }
            int i9 = i8 & 127;
            if (f17647d.compareAndSet(this, i8, i8 + 1) && (hVar = (h) this.f17649a.getAndSet(i9, null)) != null) {
                c(hVar);
                return hVar;
            }
        }
    }

    public final boolean n(d dVar) {
        h hVarM = m();
        if (hVarM == null) {
            return false;
        }
        dVar.a(hVarM);
        return true;
    }

    public final h o(boolean z7) {
        h hVar;
        do {
            hVar = (h) f17645b.get(this);
            if (hVar == null || hVar.f17636b != z7) {
                int i8 = f17647d.get(this);
                int i9 = f17646c.get(this);
                while (i8 != i9) {
                    if (z7 && f17648e.get(this) == 0) {
                        return null;
                    }
                    i9--;
                    h hVarQ = q(i9, z7);
                    if (hVarQ != null) {
                        return hVarQ;
                    }
                }
                return null;
            }
        } while (!AbstractC2965b.a(f17645b, this, hVar, null));
        return hVar;
    }

    public final h p(int i8) {
        int i9 = f17647d.get(this);
        int i10 = f17646c.get(this);
        boolean z7 = i8 == 1;
        while (i9 != i10) {
            if (z7 && f17648e.get(this) == 0) {
                return null;
            }
            int i11 = i9 + 1;
            h hVarQ = q(i9, z7);
            if (hVarQ != null) {
                return hVarQ;
            }
            i9 = i11;
        }
        return null;
    }

    public final h q(int i8, boolean z7) {
        int i9 = i8 & 127;
        h hVar = (h) this.f17649a.get(i9);
        if (hVar == null || hVar.f17636b != z7 || !a7.l.a(this.f17649a, i9, hVar, null)) {
            return null;
        }
        if (z7) {
            f17648e.decrementAndGet(this);
        }
        return hVar;
    }

    public final long r(int i8, N n8) {
        h hVarM = i8 == 3 ? m() : p(i8);
        if (hVarM == null) {
            return s(i8, n8);
        }
        n8.f20469a = hVarM;
        return -1L;
    }

    public final long s(int i8, N n8) {
        h hVar;
        do {
            hVar = (h) f17645b.get(this);
            if (hVar == null) {
                return -2L;
            }
            if (((hVar.f17636b ? 1 : 2) & i8) == 0) {
                return -2L;
            }
            long jA = j.f17643f.a() - hVar.f17635a;
            long j8 = j.f17639b;
            if (jA < j8) {
                return j8 - jA;
            }
        } while (!AbstractC2965b.a(f17645b, this, hVar, null));
        n8.f20469a = hVar;
        return -1L;
    }
}
