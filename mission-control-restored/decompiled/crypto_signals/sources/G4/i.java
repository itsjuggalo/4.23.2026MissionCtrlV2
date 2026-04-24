package G4;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class i implements c, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f533c = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "b");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile R4.a f534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f535b;

    @Override // G4.c
    public final Object getValue() {
        Object obj = this.f535b;
        k kVar = k.f539a;
        if (obj != kVar) {
            return obj;
        }
        R4.a aVar = this.f534a;
        if (aVar != null) {
            Object objInvoke = aVar.invoke();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f533c;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, kVar, objInvoke)) {
                if (atomicReferenceFieldUpdater.get(this) != kVar) {
                }
            }
            this.f534a = null;
            return objInvoke;
        }
        return this.f535b;
    }

    public final String toString() {
        return this.f535b != k.f539a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
