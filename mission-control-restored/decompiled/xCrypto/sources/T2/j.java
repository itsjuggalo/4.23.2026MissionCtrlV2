package T2;

import K2.EnumC0368p;
import K2.S;
import T2.g;
import Z1.m;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class j extends g {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicInteger f5219m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public S.j f5220n;

    public static final class a extends S.j {
        @Override // K2.S.j
        public S.f a(S.g gVar) {
            return S.f.g();
        }

        public boolean equals(Object obj) {
            return obj instanceof a;
        }

        public int hashCode() {
            return a.class.hashCode();
        }
    }

    public static class b extends S.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f5221a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f5222b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f5223c;

        public b(List list, AtomicInteger atomicInteger) {
            m.e(!list.isEmpty(), "empty list");
            this.f5221a = list;
            this.f5222b = (AtomicInteger) m.o(atomicInteger, FirebaseAnalytics.Param.INDEX);
            Iterator it = list.iterator();
            int iHashCode = 0;
            while (it.hasNext()) {
                iHashCode += ((S.j) it.next()).hashCode();
            }
            this.f5223c = iHashCode;
        }

        @Override // K2.S.j
        public S.f a(S.g gVar) {
            return ((S.j) this.f5221a.get(c())).a(gVar);
        }

        public final int c() {
            return (this.f5222b.getAndIncrement() & Integer.MAX_VALUE) % this.f5221a.size();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (bVar == this) {
                return true;
            }
            return this.f5223c == bVar.f5223c && this.f5222b == bVar.f5222b && this.f5221a.size() == bVar.f5221a.size() && new HashSet(this.f5221a).containsAll(bVar.f5221a);
        }

        public int hashCode() {
            return this.f5223c;
        }

        public String toString() {
            return Z1.g.a(b.class).d("subchannelPickers", this.f5221a).toString();
        }
    }

    public j(S.e eVar) {
        super(eVar);
        this.f5219m = new AtomicInteger(new Random().nextInt());
        this.f5220n = new a();
    }

    private void x(EnumC0368p enumC0368p, S.j jVar) {
        if (enumC0368p == this.f5129k && jVar.equals(this.f5220n)) {
            return;
        }
        p().f(enumC0368p, jVar);
        this.f5129k = enumC0368p;
        this.f5220n = jVar;
    }

    @Override // T2.g
    public void v() {
        List listR = r();
        if (!listR.isEmpty()) {
            x(EnumC0368p.READY, w(listR));
            return;
        }
        Iterator it = n().iterator();
        while (it.hasNext()) {
            EnumC0368p enumC0368pI = ((g.c) it.next()).i();
            EnumC0368p enumC0368p = EnumC0368p.CONNECTING;
            if (enumC0368pI == enumC0368p || enumC0368pI == EnumC0368p.IDLE) {
                x(enumC0368p, new a());
                return;
            }
        }
        x(EnumC0368p.TRANSIENT_FAILURE, w(n()));
    }

    public S.j w(Collection collection) {
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((g.c) it.next()).h());
        }
        return new b(arrayList, this.f5219m);
    }
}
