package d7;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import y.AbstractC2965b;

/* JADX INFO: renamed from: d7.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C1655p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17066a = AtomicReferenceFieldUpdater.newUpdater(C1655p.class, Object.class, "_cur$volatile");
    private volatile /* synthetic */ Object _cur$volatile;

    public C1655p(boolean z7) {
        this._cur$volatile = new q(8, z7);
    }

    public final boolean a(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17066a;
        while (true) {
            q qVar = (q) atomicReferenceFieldUpdater.get(this);
            int iA = qVar.a(obj);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                AbstractC2965b.a(f17066a, this, qVar, qVar.l());
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17066a;
        while (true) {
            q qVar = (q) atomicReferenceFieldUpdater.get(this);
            if (qVar.d()) {
                return;
            } else {
                AbstractC2965b.a(f17066a, this, qVar, qVar.l());
            }
        }
    }

    public final int c() {
        return ((q) f17066a.get(this)).g();
    }

    public final Object e() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17066a;
        while (true) {
            q qVar = (q) atomicReferenceFieldUpdater.get(this);
            Object objM = qVar.m();
            if (objM != q.f17070h) {
                return objM;
            }
            AbstractC2965b.a(f17066a, this, qVar, qVar.l());
        }
    }
}
