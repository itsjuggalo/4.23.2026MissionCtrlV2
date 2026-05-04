package ug;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.m0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f23035b = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "lastScheduledTask$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f23036c = AtomicIntegerFieldUpdater.newUpdater(l.class, "producerIndex$volatile");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f23037d = AtomicIntegerFieldUpdater.newUpdater(l.class, "consumerIndex$volatile");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f23038e = AtomicIntegerFieldUpdater.newUpdater(l.class, "blockingTasksInBuffer$volatile");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray f23039a = new AtomicReferenceArray(128);
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;

    public final h a(h hVar, boolean z10) {
        if (z10) {
            return b(hVar);
        }
        h hVar2 = (h) f23035b.getAndSet(this, hVar);
        if (hVar2 == null) {
            return null;
        }
        return b(hVar2);
    }

    public final h b(h hVar) {
        if (e() == 127) {
            return hVar;
        }
        if (hVar.f23026b) {
            f23038e.incrementAndGet(this);
        }
        int i10 = f23036c.get(this) & 127;
        while (this.f23039a.get(i10) != null) {
            Thread.yield();
        }
        this.f23039a.lazySet(i10, hVar);
        f23036c.incrementAndGet(this);
        return null;
    }

    public final void c(h hVar) {
        if (hVar == null || !hVar.f23026b) {
            return;
        }
        f23038e.decrementAndGet(this);
    }

    public final int e() {
        return f23036c.get(this) - f23037d.get(this);
    }

    public final int i() {
        return f23035b.get(this) != null ? e() + 1 : e();
    }

    public final void j(d dVar) {
        h hVar = (h) f23035b.getAndSet(this, null);
        if (hVar != null) {
            dVar.a(hVar);
        }
        while (n(dVar)) {
        }
    }

    public final h k() {
        h hVar = (h) f23035b.getAndSet(this, null);
        return hVar == null ? m() : hVar;
    }

    public final h l() {
        return o(true);
    }

    public final h m() {
        h hVar;
        while (true) {
            int i10 = f23037d.get(this);
            if (i10 - f23036c.get(this) == 0) {
                return null;
            }
            int i11 = i10 & 127;
            if (f23037d.compareAndSet(this, i10, i10 + 1) && (hVar = (h) this.f23039a.getAndSet(i11, null)) != null) {
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

    public final h o(boolean z10) {
        h hVar;
        do {
            hVar = (h) f23035b.get(this);
            if (hVar == null || hVar.f23026b != z10) {
                int i10 = f23037d.get(this);
                int i11 = f23036c.get(this);
                while (i10 != i11) {
                    if (z10 && f23038e.get(this) == 0) {
                        return null;
                    }
                    i11--;
                    h hVarQ = q(i11, z10);
                    if (hVarQ != null) {
                        return hVarQ;
                    }
                }
                return null;
            }
        } while (!y.b.a(f23035b, this, hVar, null));
        return hVar;
    }

    public final h p(int i10) {
        int i11 = f23037d.get(this);
        int i12 = f23036c.get(this);
        boolean z10 = i10 == 1;
        while (i11 != i12) {
            if (z10 && f23038e.get(this) == 0) {
                return null;
            }
            int i13 = i11 + 1;
            h hVarQ = q(i11, z10);
            if (hVarQ != null) {
                return hVarQ;
            }
            i11 = i13;
        }
        return null;
    }

    public final h q(int i10, boolean z10) {
        int i11 = i10 & 127;
        h hVar = (h) this.f23039a.get(i11);
        if (hVar == null || hVar.f23026b != z10 || !pg.l.a(this.f23039a, i11, hVar, null)) {
            return null;
        }
        if (z10) {
            f23038e.decrementAndGet(this);
        }
        return hVar;
    }

    public final long r(int i10, m0 m0Var) {
        h hVarM = i10 == 3 ? m() : p(i10);
        if (hVarM == null) {
            return s(i10, m0Var);
        }
        m0Var.f14947a = hVarM;
        return -1L;
    }

    public final long s(int i10, m0 m0Var) {
        h hVar;
        do {
            hVar = (h) f23035b.get(this);
            if (hVar == null) {
                return -2L;
            }
            if (((hVar.f23026b ? 1 : 2) & i10) == 0) {
                return -2L;
            }
            long jA = j.f23033f.a() - hVar.f23025a;
            long j10 = j.f23029b;
            if (jA < j10) {
                return j10 - jA;
            }
        } while (!y.b.a(f23035b, this, hVar, null));
        m0Var.f14947a = hVar;
        return -1L;
    }
}
