package A5;

import A5.g;
import H2.m;
import com.google.android.gms.common.api.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import r5.EnumC2600p;
import r5.S;

/* JADX INFO: loaded from: classes2.dex */
public class j extends g {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicInteger f382m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public S.j f383n;

    public static final class a extends S.j {
        @Override // r5.S.j
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
        public final List f384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f385b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f386c;

        public b(List list, AtomicInteger atomicInteger) {
            m.e(!list.isEmpty(), "empty list");
            this.f384a = list;
            this.f385b = (AtomicInteger) m.o(atomicInteger, "index");
            Iterator it = list.iterator();
            int iHashCode = 0;
            while (it.hasNext()) {
                iHashCode += ((S.j) it.next()).hashCode();
            }
            this.f386c = iHashCode;
        }

        @Override // r5.S.j
        public S.f a(S.g gVar) {
            return ((S.j) this.f384a.get(c())).a(gVar);
        }

        public final int c() {
            return (this.f385b.getAndIncrement() & a.e.API_PRIORITY_OTHER) % this.f384a.size();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (bVar == this) {
                return true;
            }
            return this.f386c == bVar.f386c && this.f385b == bVar.f385b && this.f384a.size() == bVar.f384a.size() && new HashSet(this.f384a).containsAll(bVar.f384a);
        }

        public int hashCode() {
            return this.f386c;
        }

        public String toString() {
            return H2.g.a(b.class).d("subchannelPickers", this.f384a).toString();
        }
    }

    public j(S.e eVar) {
        super(eVar);
        this.f382m = new AtomicInteger(new Random().nextInt());
        this.f383n = new a();
    }

    private void x(EnumC2600p enumC2600p, S.j jVar) {
        if (enumC2600p == this.f292k && jVar.equals(this.f383n)) {
            return;
        }
        p().f(enumC2600p, jVar);
        this.f292k = enumC2600p;
        this.f383n = jVar;
    }

    @Override // A5.g
    public void v() {
        List listR = r();
        if (!listR.isEmpty()) {
            x(EnumC2600p.READY, w(listR));
            return;
        }
        Iterator it = n().iterator();
        while (it.hasNext()) {
            EnumC2600p enumC2600pI = ((g.c) it.next()).i();
            EnumC2600p enumC2600p = EnumC2600p.CONNECTING;
            if (enumC2600pI == enumC2600p || enumC2600pI == EnumC2600p.IDLE) {
                x(enumC2600p, new a());
                return;
            }
        }
        x(EnumC2600p.TRANSIENT_FAILURE, w(n()));
    }

    public S.j w(Collection collection) {
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((g.c) it.next()).h());
        }
        return new b(arrayList, this.f382m);
    }
}
