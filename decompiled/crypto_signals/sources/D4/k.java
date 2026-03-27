package D4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import s3.D;
import u4.C1230l;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f305a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f308d;
    public int e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile A.c f306b = new A.c(5);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public A.c f307c = new A.c(5);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashSet f309f = new HashSet();

    public k(o oVar) {
        this.f305a = oVar;
    }

    public final void a(s sVar) {
        if (d() && !sVar.f331c) {
            sVar.r();
        } else if (!d() && sVar.f331c) {
            sVar.f331c = false;
            C1230l c1230l = sVar.f332d;
            if (c1230l != null) {
                sVar.e.a(c1230l);
                sVar.f333f.n(2, "Subchannel unejected: {0}", sVar);
            }
        }
        sVar.f330b = this;
        this.f309f.add(sVar);
    }

    public final void b(long j4) {
        this.f308d = Long.valueOf(j4);
        this.e++;
        Iterator it = this.f309f.iterator();
        while (it.hasNext()) {
            ((s) it.next()).r();
        }
    }

    public final long c() {
        return ((AtomicLong) this.f307c.f8c).get() + ((AtomicLong) this.f307c.f7b).get();
    }

    public final boolean d() {
        return this.f308d != null;
    }

    public final void e() {
        D.p("not currently ejected", this.f308d != null);
        this.f308d = null;
        for (s sVar : this.f309f) {
            sVar.f331c = false;
            C1230l c1230l = sVar.f332d;
            if (c1230l != null) {
                sVar.e.a(c1230l);
                sVar.f333f.n(2, "Subchannel unejected: {0}", sVar);
            }
        }
    }

    public final String toString() {
        return "AddressTracker{subchannels=" + this.f309f + '}';
    }
}
