package N4;

import F4.EnumC0502p;
import F4.P;
import N4.g;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import v2.AbstractC2842h;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public class j extends g {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicInteger f5873m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public P.j f5874n;

    public static final class a extends P.j {
        @Override // F4.P.j
        public P.f a(P.g gVar) {
            return P.f.g();
        }

        public boolean equals(Object obj) {
            return obj instanceof a;
        }

        public int hashCode() {
            return a.class.hashCode();
        }
    }

    public static class b extends P.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f5875a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f5876b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f5877c;

        public b(List list, AtomicInteger atomicInteger) {
            AbstractC2848n.e(!list.isEmpty(), "empty list");
            this.f5875a = list;
            this.f5876b = (AtomicInteger) AbstractC2848n.o(atomicInteger, FirebaseAnalytics.Param.INDEX);
            Iterator it = list.iterator();
            int iHashCode = 0;
            while (it.hasNext()) {
                iHashCode += ((P.j) it.next()).hashCode();
            }
            this.f5877c = iHashCode;
        }

        @Override // F4.P.j
        public P.f a(P.g gVar) {
            return ((P.j) this.f5875a.get(b())).a(gVar);
        }

        public final int b() {
            return (this.f5876b.getAndIncrement() & Integer.MAX_VALUE) % this.f5875a.size();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (bVar == this) {
                return true;
            }
            return this.f5877c == bVar.f5877c && this.f5876b == bVar.f5876b && this.f5875a.size() == bVar.f5875a.size() && new HashSet(this.f5875a).containsAll(bVar.f5875a);
        }

        public int hashCode() {
            return this.f5877c;
        }

        public String toString() {
            return AbstractC2842h.a(b.class).d("subchannelPickers", this.f5875a).toString();
        }
    }

    public j(P.e eVar) {
        super(eVar);
        this.f5873m = new AtomicInteger(new Random().nextInt());
        this.f5874n = new a();
    }

    private void x(EnumC0502p enumC0502p, P.j jVar) {
        if (enumC0502p == this.f5783k && jVar.equals(this.f5874n)) {
            return;
        }
        p().f(enumC0502p, jVar);
        this.f5783k = enumC0502p;
        this.f5874n = jVar;
    }

    @Override // N4.g
    public void v() {
        List listR = r();
        if (!listR.isEmpty()) {
            x(EnumC0502p.READY, w(listR));
            return;
        }
        Iterator it = n().iterator();
        while (it.hasNext()) {
            EnumC0502p enumC0502pI = ((g.c) it.next()).i();
            EnumC0502p enumC0502p = EnumC0502p.CONNECTING;
            if (enumC0502pI == enumC0502p || enumC0502pI == EnumC0502p.IDLE) {
                x(enumC0502p, new a());
                return;
            }
        }
        x(EnumC0502p.TRANSIENT_FAILURE, w(n()));
    }

    public P.j w(Collection collection) {
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((g.c) it.next()).h());
        }
        return new b(arrayList, this.f5873m);
    }
}
