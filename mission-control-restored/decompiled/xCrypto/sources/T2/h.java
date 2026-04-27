package T2;

import K2.AbstractC0358f;
import K2.AbstractC0363k;
import K2.C0353a;
import K2.C0369q;
import K2.C0375x;
import K2.EnumC0368p;
import K2.S;
import K2.Z;
import K2.l0;
import K2.p0;
import M2.K0;
import M2.R0;
import Z1.m;
import a2.k;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends S {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final C0353a.c f5144p = C0353a.c.a("addressTrackerKey");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f5145g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p0 f5146h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final S.e f5147i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final T2.e f5148j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public R0 f5149k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ScheduledExecutorService f5150l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public p0.d f5151m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Long f5152n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AbstractC0358f f5153o;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g f5154a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile a f5155b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a f5156c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f5157d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f5158e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Set f5159f = new HashSet();

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public AtomicLong f5160a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public AtomicLong f5161b;

            public a() {
                this.f5160a = new AtomicLong();
                this.f5161b = new AtomicLong();
            }

            public void a() {
                this.f5160a.set(0L);
                this.f5161b.set(0L);
            }
        }

        public b(g gVar) {
            this.f5155b = new a();
            this.f5156c = new a();
            this.f5154a = gVar;
        }

        public boolean b(i iVar) {
            if (m() && !iVar.o()) {
                iVar.n();
            } else if (!m() && iVar.o()) {
                iVar.q();
            }
            iVar.p(this);
            return this.f5159f.add(iVar);
        }

        public void c() {
            int i4 = this.f5158e;
            this.f5158e = i4 == 0 ? 0 : i4 - 1;
        }

        public void d(long j4) {
            this.f5157d = Long.valueOf(j4);
            this.f5158e++;
            Iterator it = this.f5159f.iterator();
            while (it.hasNext()) {
                ((i) it.next()).n();
            }
        }

        public double e() {
            return this.f5156c.f5161b.get() / f();
        }

        public long f() {
            return this.f5156c.f5160a.get() + this.f5156c.f5161b.get();
        }

        public void g(boolean z4) {
            g gVar = this.f5154a;
            if (gVar.f5174e == null && gVar.f5175f == null) {
                return;
            }
            if (z4) {
                this.f5155b.f5160a.getAndIncrement();
            } else {
                this.f5155b.f5161b.getAndIncrement();
            }
        }

        public boolean h(long j4) {
            return j4 > this.f5157d.longValue() + Math.min(this.f5154a.f5171b.longValue() * ((long) this.f5158e), Math.max(this.f5154a.f5171b.longValue(), this.f5154a.f5172c.longValue()));
        }

        public boolean i(i iVar) {
            iVar.m();
            return this.f5159f.remove(iVar);
        }

        public void j() {
            this.f5155b.a();
            this.f5156c.a();
        }

        public void k() {
            this.f5158e = 0;
        }

        public void l(g gVar) {
            this.f5154a = gVar;
        }

        public boolean m() {
            return this.f5157d != null;
        }

        public double n() {
            return this.f5156c.f5160a.get() / f();
        }

        public void o() {
            this.f5156c.a();
            a aVar = this.f5155b;
            this.f5155b = this.f5156c;
            this.f5156c = aVar;
        }

        public void p() {
            m.u(this.f5157d != null, "not currently ejected");
            this.f5157d = null;
            Iterator it = this.f5159f.iterator();
            while (it.hasNext()) {
                ((i) it.next()).q();
            }
        }

        public String toString() {
            return "AddressTracker{subchannels=" + this.f5159f + '}';
        }
    }

    public static class c extends a2.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f5162a = new HashMap();

        @Override // a2.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map a() {
            return this.f5162a;
        }

        public void d() {
            for (b bVar : this.f5162a.values()) {
                if (bVar.m()) {
                    bVar.p();
                }
                bVar.k();
            }
        }

        public double e() {
            if (this.f5162a.isEmpty()) {
                return 0.0d;
            }
            Iterator it = this.f5162a.values().iterator();
            int i4 = 0;
            int i5 = 0;
            while (it.hasNext()) {
                i5++;
                if (((b) it.next()).m()) {
                    i4++;
                }
            }
            return (((double) i4) / ((double) i5)) * 100.0d;
        }

        public void f(Long l4) {
            for (b bVar : this.f5162a.values()) {
                if (!bVar.m()) {
                    bVar.c();
                }
                if (bVar.m() && bVar.h(l4.longValue())) {
                    bVar.p();
                }
            }
        }

        public void g(g gVar, Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                SocketAddress socketAddress = (SocketAddress) it.next();
                if (!this.f5162a.containsKey(socketAddress)) {
                    this.f5162a.put(socketAddress, new b(gVar));
                }
            }
        }

        public void h() {
            Iterator it = this.f5162a.values().iterator();
            while (it.hasNext()) {
                ((b) it.next()).j();
            }
        }

        public void i() {
            Iterator it = this.f5162a.values().iterator();
            while (it.hasNext()) {
                ((b) it.next()).o();
            }
        }

        public void j(g gVar) {
            Iterator it = this.f5162a.values().iterator();
            while (it.hasNext()) {
                ((b) it.next()).l(gVar);
            }
        }
    }

    public class d extends T2.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public S.e f5163a;

        public d(S.e eVar) {
            this.f5163a = new T2.f(eVar);
        }

        @Override // T2.c, K2.S.e
        public S.i a(S.b bVar) {
            i iVar = h.this.new i(bVar, this.f5163a);
            List listA = bVar.a();
            if (h.m(listA) && h.this.f5145g.containsKey(((C0375x) listA.get(0)).a().get(0))) {
                b bVar2 = (b) h.this.f5145g.get(((C0375x) listA.get(0)).a().get(0));
                bVar2.b(iVar);
                if (bVar2.f5157d != null) {
                    iVar.n();
                }
            }
            return iVar;
        }

        @Override // T2.c, K2.S.e
        public void f(EnumC0368p enumC0368p, S.j jVar) {
            this.f5163a.f(enumC0368p, h.this.new C0070h(jVar));
        }

        @Override // T2.c
        public S.e g() {
            return this.f5163a;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g f5165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AbstractC0358f f5166b;

        public e(g gVar, AbstractC0358f abstractC0358f) {
            this.f5165a = gVar;
            this.f5166b = abstractC0358f;
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.f5152n = Long.valueOf(hVar.f5149k.a());
            h.this.f5145g.i();
            for (j jVar : j.b(this.f5165a, this.f5166b)) {
                h hVar2 = h.this;
                jVar.a(hVar2.f5145g, hVar2.f5152n.longValue());
            }
            h hVar3 = h.this;
            hVar3.f5145g.f(hVar3.f5152n);
        }
    }

    public static class f implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f5168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC0358f f5169b;

        public f(g gVar, AbstractC0358f abstractC0358f) {
            this.f5168a = gVar;
            this.f5169b = abstractC0358f;
        }

        @Override // T2.h.j
        public void a(c cVar, long j4) {
            List<b> listN = h.n(cVar, this.f5168a.f5175f.f5187d.intValue());
            if (listN.size() < this.f5168a.f5175f.f5186c.intValue() || listN.size() == 0) {
                return;
            }
            for (b bVar : listN) {
                if (cVar.e() >= this.f5168a.f5173d.intValue()) {
                    return;
                }
                if (bVar.f() >= this.f5168a.f5175f.f5187d.intValue()) {
                    if (bVar.e() > ((double) this.f5168a.f5175f.f5184a.intValue()) / 100.0d) {
                        this.f5169b.b(AbstractC0358f.a.DEBUG, "FailurePercentage algorithm detected outlier: {0}, failureRate={1}", bVar, Double.valueOf(bVar.e()));
                        if (new Random().nextInt(100) < this.f5168a.f5175f.f5185b.intValue()) {
                            bVar.d(j4);
                        }
                    }
                }
            }
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Long f5170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Long f5171b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Long f5172c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f5173d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final c f5174e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final b f5175f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final K0.b f5176g;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Long f5177a = 10000000000L;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Long f5178b = 30000000000L;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Long f5179c = 300000000000L;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Integer f5180d = 10;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public c f5181e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public b f5182f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public K0.b f5183g;

            public g a() {
                m.t(this.f5183g != null);
                return new g(this.f5177a, this.f5178b, this.f5179c, this.f5180d, this.f5181e, this.f5182f, this.f5183g);
            }

            public a b(Long l4) {
                m.d(l4 != null);
                this.f5178b = l4;
                return this;
            }

            public a c(K0.b bVar) {
                m.t(bVar != null);
                this.f5183g = bVar;
                return this;
            }

            public a d(b bVar) {
                this.f5182f = bVar;
                return this;
            }

            public a e(Long l4) {
                m.d(l4 != null);
                this.f5177a = l4;
                return this;
            }

            public a f(Integer num) {
                m.d(num != null);
                this.f5180d = num;
                return this;
            }

            public a g(Long l4) {
                m.d(l4 != null);
                this.f5179c = l4;
                return this;
            }

            public a h(c cVar) {
                this.f5181e = cVar;
                return this;
            }
        }

        public static class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Integer f5184a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Integer f5185b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Integer f5186c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final Integer f5187d;

            public static class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public Integer f5188a = 85;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public Integer f5189b = 100;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public Integer f5190c = 5;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public Integer f5191d = 50;

                public b a() {
                    return new b(this.f5188a, this.f5189b, this.f5190c, this.f5191d);
                }

                public a b(Integer num) {
                    boolean z4 = false;
                    m.d(num != null);
                    if (num.intValue() >= 0 && num.intValue() <= 100) {
                        z4 = true;
                    }
                    m.d(z4);
                    this.f5189b = num;
                    return this;
                }

                public a c(Integer num) {
                    m.d(num != null);
                    m.d(num.intValue() >= 0);
                    this.f5190c = num;
                    return this;
                }

                public a d(Integer num) {
                    m.d(num != null);
                    m.d(num.intValue() >= 0);
                    this.f5191d = num;
                    return this;
                }

                public a e(Integer num) {
                    boolean z4 = false;
                    m.d(num != null);
                    if (num.intValue() >= 0 && num.intValue() <= 100) {
                        z4 = true;
                    }
                    m.d(z4);
                    this.f5188a = num;
                    return this;
                }
            }

            public b(Integer num, Integer num2, Integer num3, Integer num4) {
                this.f5184a = num;
                this.f5185b = num2;
                this.f5186c = num3;
                this.f5187d = num4;
            }
        }

        public static class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Integer f5192a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Integer f5193b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Integer f5194c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final Integer f5195d;

            public static final class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public Integer f5196a = 1900;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public Integer f5197b = 100;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public Integer f5198c = 5;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public Integer f5199d = 100;

                public c a() {
                    return new c(this.f5196a, this.f5197b, this.f5198c, this.f5199d);
                }

                public a b(Integer num) {
                    boolean z4 = false;
                    m.d(num != null);
                    if (num.intValue() >= 0 && num.intValue() <= 100) {
                        z4 = true;
                    }
                    m.d(z4);
                    this.f5197b = num;
                    return this;
                }

                public a c(Integer num) {
                    m.d(num != null);
                    m.d(num.intValue() >= 0);
                    this.f5198c = num;
                    return this;
                }

                public a d(Integer num) {
                    m.d(num != null);
                    m.d(num.intValue() >= 0);
                    this.f5199d = num;
                    return this;
                }

                public a e(Integer num) {
                    m.d(num != null);
                    this.f5196a = num;
                    return this;
                }
            }

            public c(Integer num, Integer num2, Integer num3, Integer num4) {
                this.f5192a = num;
                this.f5193b = num2;
                this.f5194c = num3;
                this.f5195d = num4;
            }
        }

        public boolean a() {
            return (this.f5174e == null && this.f5175f == null) ? false : true;
        }

        public g(Long l4, Long l5, Long l6, Integer num, c cVar, b bVar, K0.b bVar2) {
            this.f5170a = l4;
            this.f5171b = l5;
            this.f5172c = l6;
            this.f5173d = num;
            this.f5174e = cVar;
            this.f5175f = bVar;
            this.f5176g = bVar2;
        }
    }

    /* JADX INFO: renamed from: T2.h$h, reason: collision with other inner class name */
    public class C0070h extends S.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final S.j f5200a;

        /* JADX INFO: renamed from: T2.h$h$a */
        public class a extends AbstractC0363k.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final b f5202a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final AbstractC0363k.a f5203b;

            /* JADX INFO: renamed from: T2.h$h$a$a, reason: collision with other inner class name */
            public class C0071a extends T2.a {

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ AbstractC0363k f5205b;

                public C0071a(AbstractC0363k abstractC0363k) {
                    this.f5205b = abstractC0363k;
                }

                @Override // K2.o0
                public void i(l0 l0Var) {
                    a.this.f5202a.g(l0Var.o());
                    o().i(l0Var);
                }

                @Override // T2.a
                public AbstractC0363k o() {
                    return this.f5205b;
                }
            }

            /* JADX INFO: renamed from: T2.h$h$a$b */
            public class b extends AbstractC0363k {
                public b() {
                }

                @Override // K2.o0
                public void i(l0 l0Var) {
                    a.this.f5202a.g(l0Var.o());
                }
            }

            public a(b bVar, AbstractC0363k.a aVar) {
                this.f5202a = bVar;
                this.f5203b = aVar;
            }

            @Override // K2.AbstractC0363k.a
            public AbstractC0363k a(AbstractC0363k.b bVar, Z z4) {
                AbstractC0363k.a aVar = this.f5203b;
                return aVar != null ? new C0071a(aVar.a(bVar, z4)) : new b();
            }
        }

        public C0070h(S.j jVar) {
            this.f5200a = jVar;
        }

        @Override // K2.S.j
        public S.f a(S.g gVar) {
            S.f fVarA = this.f5200a.a(gVar);
            S.i iVarC = fVarA.c();
            return iVarC != null ? S.f.i(iVarC, new a((b) iVarC.c().b(h.f5144p), fVarA.b())) : fVarA;
        }
    }

    public class i extends T2.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final S.i f5208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f5209b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f5210c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public C0369q f5211d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public S.k f5212e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AbstractC0358f f5213f;

        public class a implements S.k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final S.k f5215a;

            public a(S.k kVar) {
                this.f5215a = kVar;
            }

            @Override // K2.S.k
            public void a(C0369q c0369q) {
                i.this.f5211d = c0369q;
                if (i.this.f5210c) {
                    return;
                }
                this.f5215a.a(c0369q);
            }
        }

        public i(S.b bVar, S.e eVar) {
            S.b.C0028b c0028b = S.f1059c;
            S.k kVar = (S.k) bVar.c(c0028b);
            if (kVar != null) {
                this.f5212e = kVar;
                this.f5208a = eVar.a(bVar.e().b(c0028b, new a(kVar)).c());
            } else {
                this.f5208a = eVar.a(bVar);
            }
            this.f5213f = this.f5208a.d();
        }

        @Override // T2.d, K2.S.i
        public C0353a c() {
            return this.f5209b != null ? this.f5208a.c().d().d(h.f5144p, this.f5209b).a() : this.f5208a.c();
        }

        @Override // T2.d, K2.S.i
        public void g() {
            b bVar = this.f5209b;
            if (bVar != null) {
                bVar.i(this);
            }
            super.g();
        }

        @Override // T2.d, K2.S.i
        public void h(S.k kVar) {
            if (this.f5212e != null) {
                super.h(kVar);
            } else {
                this.f5212e = kVar;
                super.h(new a(kVar));
            }
        }

        @Override // T2.d, K2.S.i
        public void i(List list) {
            if (h.m(b()) && h.m(list)) {
                if (h.this.f5145g.containsValue(this.f5209b)) {
                    this.f5209b.i(this);
                }
                SocketAddress socketAddress = (SocketAddress) ((C0375x) list.get(0)).a().get(0);
                if (h.this.f5145g.containsKey(socketAddress)) {
                    ((b) h.this.f5145g.get(socketAddress)).b(this);
                }
            } else if (!h.m(b()) || h.m(list)) {
                if (!h.m(b()) && h.m(list)) {
                    SocketAddress socketAddress2 = (SocketAddress) ((C0375x) list.get(0)).a().get(0);
                    if (h.this.f5145g.containsKey(socketAddress2)) {
                        ((b) h.this.f5145g.get(socketAddress2)).b(this);
                    }
                }
            } else if (h.this.f5145g.containsKey(a().a().get(0))) {
                b bVar = (b) h.this.f5145g.get(a().a().get(0));
                bVar.i(this);
                bVar.j();
            }
            this.f5208a.i(list);
        }

        @Override // T2.d
        public S.i j() {
            return this.f5208a;
        }

        public void m() {
            this.f5209b = null;
        }

        public void n() {
            this.f5210c = true;
            this.f5212e.a(C0369q.b(l0.f1230t));
            this.f5213f.b(AbstractC0358f.a.INFO, "Subchannel ejected: {0}", this);
        }

        public boolean o() {
            return this.f5210c;
        }

        public void p(b bVar) {
            this.f5209b = bVar;
        }

        public void q() {
            this.f5210c = false;
            C0369q c0369q = this.f5211d;
            if (c0369q != null) {
                this.f5212e.a(c0369q);
                this.f5213f.b(AbstractC0358f.a.INFO, "Subchannel unejected: {0}", this);
            }
        }

        @Override // T2.d
        public String toString() {
            return "OutlierDetectionSubchannel{addresses=" + this.f5208a.b() + '}';
        }
    }

    public interface j {
        static List b(g gVar, AbstractC0358f abstractC0358f) {
            k.a aVarP = a2.k.p();
            if (gVar.f5174e != null) {
                aVarP.a(new k(gVar, abstractC0358f));
            }
            if (gVar.f5175f != null) {
                aVarP.a(new f(gVar, abstractC0358f));
            }
            return aVarP.k();
        }

        void a(c cVar, long j4);
    }

    public static class k implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f5217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC0358f f5218b;

        public k(g gVar, AbstractC0358f abstractC0358f) {
            m.e(gVar.f5174e != null, "success rate ejection config is null");
            this.f5217a = gVar;
            this.f5218b = abstractC0358f;
        }

        public static double c(Collection collection) {
            Iterator it = collection.iterator();
            double dDoubleValue = 0.0d;
            while (it.hasNext()) {
                dDoubleValue += ((Double) it.next()).doubleValue();
            }
            return dDoubleValue / ((double) collection.size());
        }

        public static double d(Collection collection, double d4) {
            Iterator it = collection.iterator();
            double d5 = 0.0d;
            while (it.hasNext()) {
                double dDoubleValue = ((Double) it.next()).doubleValue() - d4;
                d5 += dDoubleValue * dDoubleValue;
            }
            return Math.sqrt(d5 / ((double) collection.size()));
        }

        @Override // T2.h.j
        public void a(c cVar, long j4) {
            List<b> listN = h.n(cVar, this.f5217a.f5174e.f5195d.intValue());
            if (listN.size() < this.f5217a.f5174e.f5194c.intValue() || listN.size() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = listN.iterator();
            while (it.hasNext()) {
                arrayList.add(Double.valueOf(((b) it.next()).n()));
            }
            double dC = c(arrayList);
            double d4 = d(arrayList, dC);
            double dIntValue = dC - (((double) (this.f5217a.f5174e.f5192a.intValue() / 1000.0f)) * d4);
            for (b bVar : listN) {
                if (cVar.e() >= this.f5217a.f5173d.intValue()) {
                    return;
                }
                if (bVar.n() < dIntValue) {
                    this.f5218b.b(AbstractC0358f.a.DEBUG, "SuccessRate algorithm detected outlier: {0}. Parameters: successRate={1}, mean={2}, stdev={3}, requiredSuccessRate={4}", bVar, Double.valueOf(bVar.n()), Double.valueOf(dC), Double.valueOf(d4), Double.valueOf(dIntValue));
                    if (new Random().nextInt(100) < this.f5217a.f5174e.f5193b.intValue()) {
                        bVar.d(j4);
                    }
                }
            }
        }
    }

    public h(S.e eVar, R0 r02) {
        AbstractC0358f abstractC0358fB = eVar.b();
        this.f5153o = abstractC0358fB;
        d dVar = new d((S.e) m.o(eVar, "helper"));
        this.f5147i = dVar;
        this.f5148j = new T2.e(dVar);
        this.f5145g = new c();
        this.f5146h = (p0) m.o(eVar.d(), "syncContext");
        this.f5150l = (ScheduledExecutorService) m.o(eVar.c(), "timeService");
        this.f5149k = r02;
        abstractC0358fB.a(AbstractC0358f.a.DEBUG, "OutlierDetection lb created.");
    }

    public static boolean m(List list) {
        Iterator it = list.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((C0375x) it.next()).a().size();
            if (size > 1) {
                return false;
            }
        }
        return true;
    }

    public static List n(c cVar, int i4) {
        ArrayList arrayList = new ArrayList();
        for (b bVar : cVar.values()) {
            if (bVar.f() >= i4) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // K2.S
    public l0 a(S.h hVar) {
        this.f5153o.b(AbstractC0358f.a.DEBUG, "Received resolution result: {0}", hVar);
        g gVar = (g) hVar.c();
        ArrayList arrayList = new ArrayList();
        Iterator it = hVar.a().iterator();
        while (it.hasNext()) {
            arrayList.addAll(((C0375x) it.next()).a());
        }
        this.f5145g.keySet().retainAll(arrayList);
        this.f5145g.j(gVar);
        this.f5145g.g(gVar, arrayList);
        this.f5148j.r(gVar.f5176g.b());
        if (gVar.a()) {
            Long lValueOf = this.f5152n == null ? gVar.f5170a : Long.valueOf(Math.max(0L, gVar.f5170a.longValue() - (this.f5149k.a() - this.f5152n.longValue())));
            p0.d dVar = this.f5151m;
            if (dVar != null) {
                dVar.a();
                this.f5145g.h();
            }
            this.f5151m = this.f5146h.d(new e(gVar, this.f5153o), lValueOf.longValue(), gVar.f5170a.longValue(), TimeUnit.NANOSECONDS, this.f5150l);
        } else {
            p0.d dVar2 = this.f5151m;
            if (dVar2 != null) {
                dVar2.a();
                this.f5152n = null;
                this.f5145g.d();
            }
        }
        this.f5148j.d(hVar.e().d(gVar.f5176g.a()).a());
        return l0.f1215e;
    }

    @Override // K2.S
    public void c(l0 l0Var) {
        this.f5148j.c(l0Var);
    }

    @Override // K2.S
    public void f() {
        this.f5148j.f();
    }
}
