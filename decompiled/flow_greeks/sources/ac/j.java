package ac;

import ac.g;
import com.google.android.gms.common.api.a;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import p6.n;
import rb.p;
import rb.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class j extends g {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicInteger f726m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public r0.j f727n;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends r0.j {
        @Override // rb.r0.j
        public r0.f a(r0.g gVar) {
            return r0.f.g();
        }

        public boolean equals(Object obj) {
            return obj instanceof a;
        }

        public int hashCode() {
            return a.class.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends r0.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f729b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f730c;

        public b(List list, AtomicInteger atomicInteger) {
            n.e(!list.isEmpty(), "empty list");
            this.f728a = list;
            this.f729b = (AtomicInteger) n.o(atomicInteger, FirebaseAnalytics.Param.INDEX);
            Iterator it = list.iterator();
            int iHashCode = 0;
            while (it.hasNext()) {
                iHashCode += ((r0.j) it.next()).hashCode();
            }
            this.f730c = iHashCode;
        }

        @Override // rb.r0.j
        public r0.f a(r0.g gVar) {
            return ((r0.j) this.f728a.get(c())).a(gVar);
        }

        public final int c() {
            return (this.f729b.getAndIncrement() & a.e.API_PRIORITY_OTHER) % this.f728a.size();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (bVar == this) {
                return true;
            }
            return this.f730c == bVar.f730c && this.f729b == bVar.f729b && this.f728a.size() == bVar.f728a.size() && new HashSet(this.f728a).containsAll(bVar.f728a);
        }

        public int hashCode() {
            return this.f730c;
        }

        public String toString() {
            return p6.h.a(b.class).d("subchannelPickers", this.f728a).toString();
        }
    }

    public j(r0.e eVar) {
        super(eVar);
        this.f726m = new AtomicInteger(new Random().nextInt());
        this.f727n = new a();
    }

    private void x(p pVar, r0.j jVar) {
        if (pVar == this.f636k && jVar.equals(this.f727n)) {
            return;
        }
        p().f(pVar, jVar);
        this.f636k = pVar;
        this.f727n = jVar;
    }

    @Override // ac.g
    public void v() {
        List listR = r();
        if (!listR.isEmpty()) {
            x(p.READY, w(listR));
            return;
        }
        Iterator it = n().iterator();
        while (it.hasNext()) {
            p pVarI = ((g.c) it.next()).i();
            p pVar = p.CONNECTING;
            if (pVarI == pVar || pVarI == p.IDLE) {
                x(pVar, new a());
                return;
            }
        }
        x(p.TRANSIENT_FAILURE, w(n()));
    }

    public r0.j w(Collection collection) {
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((g.c) it.next()).h());
        }
        return new b(arrayList, this.f726m);
    }
}
