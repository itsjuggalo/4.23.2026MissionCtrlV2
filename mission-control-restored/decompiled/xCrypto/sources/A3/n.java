package A3;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.F;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f104b = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "lastScheduledTask");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f105c = AtomicIntegerFieldUpdater.newUpdater(n.class, "producerIndex");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f106d = AtomicIntegerFieldUpdater.newUpdater(n.class, "consumerIndex");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f107e = AtomicIntegerFieldUpdater.newUpdater(n.class, "blockingTasksInBuffer");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray f108a = new AtomicReferenceArray(UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
    private volatile int blockingTasksInBuffer;
    private volatile int consumerIndex;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;

    public final h a(h hVar, boolean z4) {
        if (z4) {
            return b(hVar);
        }
        h hVar2 = (h) f104b.getAndSet(this, hVar);
        if (hVar2 == null) {
            return null;
        }
        return b(hVar2);
    }

    public final h b(h hVar) {
        if (d() == 127) {
            return hVar;
        }
        if (hVar.f92b.b() == 1) {
            f107e.incrementAndGet(this);
        }
        int i4 = f105c.get(this) & 127;
        while (this.f108a.get(i4) != null) {
            Thread.yield();
        }
        this.f108a.lazySet(i4, hVar);
        f105c.incrementAndGet(this);
        return null;
    }

    public final void c(h hVar) {
        if (hVar == null || hVar.f92b.b() != 1) {
            return;
        }
        f107e.decrementAndGet(this);
    }

    public final int d() {
        return f105c.get(this) - f106d.get(this);
    }

    public final int e() {
        return f104b.get(this) != null ? d() + 1 : d();
    }

    public final void f(d dVar) {
        h hVar = (h) f104b.getAndSet(this, null);
        if (hVar != null) {
            dVar.a(hVar);
        }
        while (j(dVar)) {
        }
    }

    public final h g() {
        h hVar = (h) f104b.getAndSet(this, null);
        return hVar == null ? i() : hVar;
    }

    public final h h() {
        return k(true);
    }

    public final h i() {
        h hVar;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f106d;
            int i4 = atomicIntegerFieldUpdater.get(this);
            if (i4 - f105c.get(this) == 0) {
                return null;
            }
            int i5 = i4 & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i4, i4 + 1) && (hVar = (h) this.f108a.getAndSet(i5, null)) != null) {
                c(hVar);
                return hVar;
            }
        }
    }

    public final boolean j(d dVar) {
        h hVarI = i();
        if (hVarI == null) {
            return false;
        }
        dVar.a(hVarI);
        return true;
    }

    public final h k(boolean z4) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        h hVar;
        do {
            atomicReferenceFieldUpdater = f104b;
            hVar = (h) atomicReferenceFieldUpdater.get(this);
            if (hVar != null) {
                if ((hVar.f92b.b() == 1) == z4) {
                }
            }
            int i4 = f106d.get(this);
            int i5 = f105c.get(this);
            while (i4 != i5) {
                if (z4 && f107e.get(this) == 0) {
                    return null;
                }
                i5--;
                h hVarM = m(i5, z4);
                if (hVarM != null) {
                    return hVarM;
                }
            }
            return null;
        } while (!androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, hVar, null));
        return hVar;
    }

    public final h l(int i4) {
        int i5 = f106d.get(this);
        int i6 = f105c.get(this);
        boolean z4 = i4 == 1;
        while (i5 != i6) {
            if (z4 && f107e.get(this) == 0) {
                return null;
            }
            int i7 = i5 + 1;
            h hVarM = m(i5, z4);
            if (hVarM != null) {
                return hVarM;
            }
            i5 = i7;
        }
        return null;
    }

    public final h m(int i4, boolean z4) {
        int i5 = i4 & 127;
        h hVar = (h) this.f108a.get(i5);
        if (hVar != null) {
            if ((hVar.f92b.b() == 1) == z4 && v3.i.a(this.f108a, i5, hVar, null)) {
                if (z4) {
                    f107e.decrementAndGet(this);
                }
                return hVar;
            }
        }
        return null;
    }

    public final long n(int i4, F f4) {
        h hVarI = i4 == 3 ? i() : l(i4);
        if (hVarI == null) {
            return o(i4, f4);
        }
        f4.f13410a = hVarI;
        return -1L;
    }

    public final long o(int i4, F f4) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        h hVar;
        do {
            atomicReferenceFieldUpdater = f104b;
            hVar = (h) atomicReferenceFieldUpdater.get(this);
            if (hVar == null) {
                return -2L;
            }
            if (((hVar.f92b.b() != 1 ? 2 : 1) & i4) == 0) {
                return -2L;
            }
            long jA = l.f100f.a() - hVar.f91a;
            long j4 = l.f96b;
            if (jA < j4) {
                return j4 - jA;
            }
        } while (!androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, hVar, null));
        f4.f13410a = hVar;
        return -1L;
    }
}
