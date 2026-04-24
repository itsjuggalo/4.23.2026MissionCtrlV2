package g6;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import v.AbstractC2759b;

/* JADX INFO: renamed from: g6.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1642b extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f14289a = AtomicReferenceFieldUpdater.newUpdater(AbstractC1642b.class, Object.class, "_consensus");
    private volatile Object _consensus = AbstractC1641a.f14288a;

    @Override // g6.y
    public final Object a(Object obj) {
        Object objC = f14289a.get(this);
        if (objC == AbstractC1641a.f14288a) {
            objC = c(d(obj));
        }
        b(obj, objC);
        return objC;
    }

    public abstract void b(Object obj, Object obj2);

    public final Object c(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14289a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        Object obj3 = AbstractC1641a.f14288a;
        return obj2 != obj3 ? obj2 : AbstractC2759b.a(atomicReferenceFieldUpdater, this, obj3, obj) ? obj : atomicReferenceFieldUpdater.get(this);
    }

    public abstract Object d(Object obj);
}
