package y3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: y3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1948b extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15975a = AtomicReferenceFieldUpdater.newUpdater(AbstractC1948b.class, Object.class, "_consensus");
    private volatile Object _consensus = AbstractC1947a.f15974a;

    @Override // y3.y
    public final Object a(Object obj) {
        Object objC = f15975a.get(this);
        if (objC == AbstractC1947a.f15974a) {
            objC = c(d(obj));
        }
        b(obj, objC);
        return objC;
    }

    public abstract void b(Object obj, Object obj2);

    public final Object c(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15975a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        Object obj3 = AbstractC1947a.f15974a;
        return obj2 != obj3 ? obj2 : androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, obj3, obj) ? obj : atomicReferenceFieldUpdater.get(this);
    }

    public abstract Object d(Object obj);
}
