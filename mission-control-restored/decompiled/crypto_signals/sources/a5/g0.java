package a5;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public abstract class g0 extends f5.j implements M, Z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p0 f4124d;

    @Override // a5.M
    public final void a() {
        p0 p0VarI = i();
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = p0.f4152a;
            Object obj = atomicReferenceFieldUpdater.get(p0VarI);
            if (obj instanceof g0) {
                if (obj != this) {
                    return;
                }
                O o3 = C.f4081j;
                while (!atomicReferenceFieldUpdater.compareAndSet(p0VarI, obj, o3)) {
                    if (atomicReferenceFieldUpdater.get(p0VarI) != obj) {
                        break;
                    }
                }
                return;
            }
            if (!(obj instanceof Z) || ((Z) obj).c() == null) {
                return;
            }
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f5.j.f6516a;
                Object obj2 = atomicReferenceFieldUpdater2.get(this);
                if (obj2 instanceof f5.o) {
                    f5.j jVar = ((f5.o) obj2).f6528a;
                    return;
                }
                if (obj2 == this) {
                    return;
                }
                kotlin.jvm.internal.j.c(obj2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
                f5.j jVar2 = (f5.j) obj2;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = f5.j.f6518c;
                f5.o oVar = (f5.o) atomicReferenceFieldUpdater3.get(jVar2);
                if (oVar == null) {
                    oVar = new f5.o(jVar2);
                    atomicReferenceFieldUpdater3.set(jVar2, oVar);
                }
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj2, oVar)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj2) {
                        break;
                    }
                }
                jVar2.e();
                return;
            }
        }
    }

    @Override // a5.Z
    public final q0 c() {
        return null;
    }

    public InterfaceC0295c0 getParent() {
        return i();
    }

    public final p0 i() {
        p0 p0Var = this.f4124d;
        if (p0Var != null) {
            return p0Var;
        }
        kotlin.jvm.internal.j.h("job");
        throw null;
    }

    @Override // a5.Z
    public final boolean isActive() {
        return true;
    }

    public abstract boolean j();

    public abstract void k(Throwable th);

    @Override // f5.j
    public final String toString() {
        return getClass().getSimpleName() + '@' + C.j(this) + "[job@" + C.j(i()) + ']';
    }
}
