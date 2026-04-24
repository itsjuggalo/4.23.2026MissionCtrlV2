package f5;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6501a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_next$volatile");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6502b = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_prev$volatile");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    public b(r rVar) {
        this._prev$volatile = rVar;
    }

    public final void b() {
        f6502b.set(this, null);
    }

    public final b c() {
        Object obj = f6501a.get(this);
        if (obj == a.f6495a) {
            return null;
        }
        return (b) obj;
    }

    public abstract boolean d();

    public final void e() {
        b bVarC;
        if (c() == null) {
            return;
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6502b;
            b bVar = (b) atomicReferenceFieldUpdater.get(this);
            while (bVar != null && bVar.d()) {
                bVar = (b) atomicReferenceFieldUpdater.get(bVar);
            }
            b bVarC2 = c();
            kotlin.jvm.internal.j.b(bVarC2);
            while (bVarC2.d() && (bVarC = bVarC2.c()) != null) {
                bVarC2 = bVarC;
            }
            while (true) {
                Object obj = atomicReferenceFieldUpdater.get(bVarC2);
                b bVar2 = ((b) obj) == null ? null : bVar;
                while (!atomicReferenceFieldUpdater.compareAndSet(bVarC2, obj, bVar2)) {
                    if (atomicReferenceFieldUpdater.get(bVarC2) != obj) {
                        break;
                    }
                }
            }
            if (bVar != null) {
                f6501a.set(bVar, bVarC2);
            }
            if (!bVarC2.d() || bVarC2.c() == null) {
                if (bVar == null || !bVar.d()) {
                    return;
                }
            }
        }
    }
}
