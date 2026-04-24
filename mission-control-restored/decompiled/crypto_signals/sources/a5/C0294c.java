package a5;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: a5.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0294c extends g0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f4109l = AtomicReferenceFieldUpdater.newUpdater(C0294c.class, Object.class, "_disposer$volatile");
    private volatile /* synthetic */ Object _disposer$volatile;
    public final C0307n e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public M f4110f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ C0298e f4111k;

    public C0294c(C0298e c0298e, C0307n c0307n) {
        this.f4111k = c0298e;
        this.e = c0307n;
    }

    @Override // a5.g0
    public final boolean j() {
        return false;
    }

    @Override // a5.g0
    public final void k(Throwable th) {
        C0307n c0307n = this.e;
        if (th != null) {
            c0307n.getClass();
            f5.t tVarC = c0307n.C(new C0315w(th, false), null);
            if (tVarC != null) {
                c0307n.e(tVarC);
                C0296d c0296d = (C0296d) f4109l.get(this);
                if (c0296d != null) {
                    c0296d.b();
                    return;
                }
                return;
            }
            return;
        }
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = C0298e.f4114b;
        C0298e c0298e = this.f4111k;
        if (atomicIntegerFieldUpdater.decrementAndGet(c0298e) == 0) {
            F[] fArr = c0298e.f4115a;
            ArrayList arrayList = new ArrayList(fArr.length);
            for (F f6 : fArr) {
                arrayList.add(f6.getCompleted());
            }
            c0307n.resumeWith(arrayList);
        }
    }
}
