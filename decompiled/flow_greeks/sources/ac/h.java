package ac;

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
import p6.n;
import q6.k;
import rb.a;
import rb.f;
import rb.k;
import rb.k1;
import rb.o1;
import rb.p;
import rb.q;
import rb.r0;
import rb.x;
import rb.y0;
import tb.j2;
import tb.q2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends r0 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a.c f651p = a.c.a("addressTrackerKey");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f652g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o1 f653h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final r0.e f654i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ac.e f655j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public q2 f656k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ScheduledExecutorService f657l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public o1.d f658m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Long f659n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final rb.f f660o;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g f661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile a f662b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a f663c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f664d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f665e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Set f666f = new HashSet();

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public AtomicLong f667a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public AtomicLong f668b;

            public a() {
                this.f667a = new AtomicLong();
                this.f668b = new AtomicLong();
            }

            public void a() {
                this.f667a.set(0L);
                this.f668b.set(0L);
            }
        }

        public b(g gVar) {
            this.f662b = new a();
            this.f663c = new a();
            this.f661a = gVar;
        }

        public boolean b(i iVar) {
            if (m() && !iVar.o()) {
                iVar.n();
            } else if (!m() && iVar.o()) {
                iVar.q();
            }
            iVar.p(this);
            return this.f666f.add(iVar);
        }

        public void c() {
            int i10 = this.f665e;
            this.f665e = i10 == 0 ? 0 : i10 - 1;
        }

        public void d(long j10) {
            this.f664d = Long.valueOf(j10);
            this.f665e++;
            Iterator it = this.f666f.iterator();
            while (it.hasNext()) {
                ((i) it.next()).n();
            }
        }

        public double e() {
            return this.f663c.f668b.get() / f();
        }

        public long f() {
            return this.f663c.f667a.get() + this.f663c.f668b.get();
        }

        public void g(boolean z10) {
            g gVar = this.f661a;
            if (gVar.f681e == null && gVar.f682f == null) {
                return;
            }
            if (z10) {
                this.f662b.f667a.getAndIncrement();
            } else {
                this.f662b.f668b.getAndIncrement();
            }
        }

        public boolean h(long j10) {
            return j10 > this.f664d.longValue() + Math.min(this.f661a.f678b.longValue() * ((long) this.f665e), Math.max(this.f661a.f678b.longValue(), this.f661a.f679c.longValue()));
        }

        public boolean i(i iVar) {
            iVar.m();
            return this.f666f.remove(iVar);
        }

        public void j() {
            this.f662b.a();
            this.f663c.a();
        }

        public void k() {
            this.f665e = 0;
        }

        public void l(g gVar) {
            this.f661a = gVar;
        }

        public boolean m() {
            return this.f664d != null;
        }

        public double n() {
            return this.f663c.f667a.get() / f();
        }

        public void o() {
            this.f663c.a();
            a aVar = this.f662b;
            this.f662b = this.f663c;
            this.f663c = aVar;
        }

        public void p() {
            n.u(this.f664d != null, "not currently ejected");
            this.f664d = null;
            Iterator it = this.f666f.iterator();
            while (it.hasNext()) {
                ((i) it.next()).q();
            }
        }

        public String toString() {
            return "AddressTracker{subchannels=" + this.f666f + '}';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c extends q6.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f669a = new HashMap();

        @Override // q6.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map a() {
            return this.f669a;
        }

        public void c() {
            for (b bVar : this.f669a.values()) {
                if (bVar.m()) {
                    bVar.p();
                }
                bVar.k();
            }
        }

        public double e() {
            if (this.f669a.isEmpty()) {
                return 0.0d;
            }
            Iterator it = this.f669a.values().iterator();
            int i10 = 0;
            int i11 = 0;
            while (it.hasNext()) {
                i11++;
                if (((b) it.next()).m()) {
                    i10++;
                }
            }
            return (((double) i10) / ((double) i11)) * 100.0d;
        }

        public void f(Long l10) {
            for (b bVar : this.f669a.values()) {
                if (!bVar.m()) {
                    bVar.c();
                }
                if (bVar.m() && bVar.h(l10.longValue())) {
                    bVar.p();
                }
            }
        }

        public void g(g gVar, Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                SocketAddress socketAddress = (SocketAddress) it.next();
                if (!this.f669a.containsKey(socketAddress)) {
                    this.f669a.put(socketAddress, new b(gVar));
                }
            }
        }

        public void h() {
            Iterator it = this.f669a.values().iterator();
            while (it.hasNext()) {
                ((b) it.next()).j();
            }
        }

        public void i() {
            Iterator it = this.f669a.values().iterator();
            while (it.hasNext()) {
                ((b) it.next()).o();
            }
        }

        public void j(g gVar) {
            Iterator it = this.f669a.values().iterator();
            while (it.hasNext()) {
                ((b) it.next()).l(gVar);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d extends ac.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public r0.e f670a;

        public d(r0.e eVar) {
            this.f670a = new ac.f(eVar);
        }

        @Override // ac.c, rb.r0.e
        public r0.i a(r0.b bVar) {
            i iVar = h.this.new i(bVar, this.f670a);
            List listA = bVar.a();
            if (h.m(listA) && h.this.f652g.containsKey(((x) listA.get(0)).a().get(0))) {
                b bVar2 = (b) h.this.f652g.get(((x) listA.get(0)).a().get(0));
                bVar2.b(iVar);
                if (bVar2.f664d != null) {
                    iVar.n();
                }
            }
            return iVar;
        }

        @Override // ac.c, rb.r0.e
        public void f(p pVar, r0.j jVar) {
            this.f670a.f(pVar, h.this.new C0007h(jVar));
        }

        @Override // ac.c
        public r0.e g() {
            return this.f670a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g f672a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public rb.f f673b;

        public e(g gVar, rb.f fVar) {
            this.f672a = gVar;
            this.f673b = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.f659n = Long.valueOf(hVar.f656k.a());
            h.this.f652g.i();
            for (j jVar : j.b(this.f672a, this.f673b)) {
                h hVar2 = h.this;
                jVar.a(hVar2.f652g, hVar2.f659n.longValue());
            }
            h hVar3 = h.this;
            hVar3.f652g.f(hVar3.f659n);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class f implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final rb.f f676b;

        public f(g gVar, rb.f fVar) {
            this.f675a = gVar;
            this.f676b = fVar;
        }

        @Override // ac.h.j
        public void a(c cVar, long j10) {
            List<b> listN = h.n(cVar, this.f675a.f682f.f694d.intValue());
            if (listN.size() < this.f675a.f682f.f693c.intValue() || listN.size() == 0) {
                return;
            }
            for (b bVar : listN) {
                if (cVar.e() >= this.f675a.f680d.intValue()) {
                    return;
                }
                if (bVar.f() >= this.f675a.f682f.f694d.intValue()) {
                    if (bVar.e() > ((double) this.f675a.f682f.f691a.intValue()) / 100.0d) {
                        this.f676b.b(f.a.DEBUG, "FailurePercentage algorithm detected outlier: {0}, failureRate={1}", bVar, Double.valueOf(bVar.e()));
                        if (new Random().nextInt(100) < this.f675a.f682f.f692b.intValue()) {
                            bVar.d(j10);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Long f677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Long f678b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Long f679c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f680d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final c f681e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final b f682f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final j2.b f683g;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Long f684a = 10000000000L;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Long f685b = 30000000000L;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Long f686c = 300000000000L;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Integer f687d = 10;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public c f688e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public b f689f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public j2.b f690g;

            public g a() {
                n.t(this.f690g != null);
                return new g(this.f684a, this.f685b, this.f686c, this.f687d, this.f688e, this.f689f, this.f690g);
            }

            public a b(Long l10) {
                n.d(l10 != null);
                this.f685b = l10;
                return this;
            }

            public a c(j2.b bVar) {
                n.t(bVar != null);
                this.f690g = bVar;
                return this;
            }

            public a d(b bVar) {
                this.f689f = bVar;
                return this;
            }

            public a e(Long l10) {
                n.d(l10 != null);
                this.f684a = l10;
                return this;
            }

            public a f(Integer num) {
                n.d(num != null);
                this.f687d = num;
                return this;
            }

            public a g(Long l10) {
                n.d(l10 != null);
                this.f686c = l10;
                return this;
            }

            public a h(c cVar) {
                this.f688e = cVar;
                return this;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Integer f691a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Integer f692b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Integer f693c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final Integer f694d;

            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public static class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public Integer f695a = 85;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public Integer f696b = 100;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public Integer f697c = 5;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public Integer f698d = 50;

                public b a() {
                    return new b(this.f695a, this.f696b, this.f697c, this.f698d);
                }

                public a b(Integer num) {
                    boolean z10 = false;
                    n.d(num != null);
                    if (num.intValue() >= 0 && num.intValue() <= 100) {
                        z10 = true;
                    }
                    n.d(z10);
                    this.f696b = num;
                    return this;
                }

                public a c(Integer num) {
                    n.d(num != null);
                    n.d(num.intValue() >= 0);
                    this.f697c = num;
                    return this;
                }

                public a d(Integer num) {
                    n.d(num != null);
                    n.d(num.intValue() >= 0);
                    this.f698d = num;
                    return this;
                }

                public a e(Integer num) {
                    boolean z10 = false;
                    n.d(num != null);
                    if (num.intValue() >= 0 && num.intValue() <= 100) {
                        z10 = true;
                    }
                    n.d(z10);
                    this.f695a = num;
                    return this;
                }
            }

            public b(Integer num, Integer num2, Integer num3, Integer num4) {
                this.f691a = num;
                this.f692b = num2;
                this.f693c = num3;
                this.f694d = num4;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Integer f699a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Integer f700b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Integer f701c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final Integer f702d;

            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public static final class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public Integer f703a = 1900;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public Integer f704b = 100;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public Integer f705c = 5;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public Integer f706d = 100;

                public c a() {
                    return new c(this.f703a, this.f704b, this.f705c, this.f706d);
                }

                public a b(Integer num) {
                    boolean z10 = false;
                    n.d(num != null);
                    if (num.intValue() >= 0 && num.intValue() <= 100) {
                        z10 = true;
                    }
                    n.d(z10);
                    this.f704b = num;
                    return this;
                }

                public a c(Integer num) {
                    n.d(num != null);
                    n.d(num.intValue() >= 0);
                    this.f705c = num;
                    return this;
                }

                public a d(Integer num) {
                    n.d(num != null);
                    n.d(num.intValue() >= 0);
                    this.f706d = num;
                    return this;
                }

                public a e(Integer num) {
                    n.d(num != null);
                    this.f703a = num;
                    return this;
                }
            }

            public c(Integer num, Integer num2, Integer num3, Integer num4) {
                this.f699a = num;
                this.f700b = num2;
                this.f701c = num3;
                this.f702d = num4;
            }
        }

        public boolean a() {
            return (this.f681e == null && this.f682f == null) ? false : true;
        }

        public g(Long l10, Long l11, Long l12, Integer num, c cVar, b bVar, j2.b bVar2) {
            this.f677a = l10;
            this.f678b = l11;
            this.f679c = l12;
            this.f680d = num;
            this.f681e = cVar;
            this.f682f = bVar;
            this.f683g = bVar2;
        }
    }

    /* JADX INFO: renamed from: ac.h$h, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class C0007h extends r0.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r0.j f707a;

        /* JADX INFO: renamed from: ac.h$h$a */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a extends k.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final b f709a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final k.a f710b;

            /* JADX INFO: renamed from: ac.h$h$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public class C0008a extends ac.a {

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ rb.k f712b;

                public C0008a(rb.k kVar) {
                    this.f712b = kVar;
                }

                @Override // rb.n1
                public void i(k1 k1Var) {
                    a.this.f709a.g(k1Var.p());
                    o().i(k1Var);
                }

                @Override // ac.a
                public rb.k o() {
                    return this.f712b;
                }
            }

            /* JADX INFO: renamed from: ac.h$h$a$b */
            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public class b extends rb.k {
                public b() {
                }

                @Override // rb.n1
                public void i(k1 k1Var) {
                    a.this.f709a.g(k1Var.p());
                }
            }

            public a(b bVar, k.a aVar) {
                this.f709a = bVar;
                this.f710b = aVar;
            }

            @Override // rb.k.a
            public rb.k a(k.b bVar, y0 y0Var) {
                k.a aVar = this.f710b;
                return aVar != null ? new C0008a(aVar.a(bVar, y0Var)) : new b();
            }
        }

        public C0007h(r0.j jVar) {
            this.f707a = jVar;
        }

        @Override // rb.r0.j
        public r0.f a(r0.g gVar) {
            r0.f fVarA = this.f707a.a(gVar);
            r0.i iVarC = fVarA.c();
            return iVarC != null ? r0.f.i(iVarC, new a((b) iVarC.c().b(h.f651p), fVarA.b())) : fVarA;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class i extends ac.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r0.i f715a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f716b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f717c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public q f718d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public r0.k f719e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final rb.f f720f;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements r0.k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final r0.k f722a;

            public a(r0.k kVar) {
                this.f722a = kVar;
            }

            @Override // rb.r0.k
            public void a(q qVar) {
                i.this.f718d = qVar;
                if (i.this.f717c) {
                    return;
                }
                this.f722a.a(qVar);
            }
        }

        public i(r0.b bVar, r0.e eVar) {
            r0.b.C0345b c0345b = r0.f19692c;
            r0.k kVar = (r0.k) bVar.c(c0345b);
            if (kVar != null) {
                this.f719e = kVar;
                this.f715a = eVar.a(bVar.e().b(c0345b, new a(kVar)).c());
            } else {
                this.f715a = eVar.a(bVar);
            }
            this.f720f = this.f715a.d();
        }

        @Override // ac.d, rb.r0.i
        public rb.a c() {
            return this.f716b != null ? this.f715a.c().d().d(h.f651p, this.f716b).a() : this.f715a.c();
        }

        @Override // ac.d, rb.r0.i
        public void g() {
            b bVar = this.f716b;
            if (bVar != null) {
                bVar.i(this);
            }
            super.g();
        }

        @Override // ac.d, rb.r0.i
        public void h(r0.k kVar) {
            if (this.f719e != null) {
                super.h(kVar);
            } else {
                this.f719e = kVar;
                super.h(new a(kVar));
            }
        }

        @Override // ac.d, rb.r0.i
        public void i(List list) {
            if (h.m(b()) && h.m(list)) {
                if (h.this.f652g.containsValue(this.f716b)) {
                    this.f716b.i(this);
                }
                SocketAddress socketAddress = (SocketAddress) ((x) list.get(0)).a().get(0);
                if (h.this.f652g.containsKey(socketAddress)) {
                    ((b) h.this.f652g.get(socketAddress)).b(this);
                }
            } else if (!h.m(b()) || h.m(list)) {
                if (!h.m(b()) && h.m(list)) {
                    SocketAddress socketAddress2 = (SocketAddress) ((x) list.get(0)).a().get(0);
                    if (h.this.f652g.containsKey(socketAddress2)) {
                        ((b) h.this.f652g.get(socketAddress2)).b(this);
                    }
                }
            } else if (h.this.f652g.containsKey(a().a().get(0))) {
                b bVar = (b) h.this.f652g.get(a().a().get(0));
                bVar.i(this);
                bVar.j();
            }
            this.f715a.i(list);
        }

        @Override // ac.d
        public r0.i j() {
            return this.f715a;
        }

        public void m() {
            this.f716b = null;
        }

        public void n() {
            this.f717c = true;
            this.f719e.a(q.b(k1.f19607t));
            this.f720f.b(f.a.INFO, "Subchannel ejected: {0}", this);
        }

        public boolean o() {
            return this.f717c;
        }

        public void p(b bVar) {
            this.f716b = bVar;
        }

        public void q() {
            this.f717c = false;
            q qVar = this.f718d;
            if (qVar != null) {
                this.f719e.a(qVar);
                this.f720f.b(f.a.INFO, "Subchannel unejected: {0}", this);
            }
        }

        @Override // ac.d
        public String toString() {
            return "OutlierDetectionSubchannel{addresses=" + this.f715a.b() + '}';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface j {
        static List b(g gVar, rb.f fVar) {
            k.a aVarR = q6.k.r();
            if (gVar.f681e != null) {
                aVarR.a(new k(gVar, fVar));
            }
            if (gVar.f682f != null) {
                aVarR.a(new f(gVar, fVar));
            }
            return aVarR.k();
        }

        void a(c cVar, long j10);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class k implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f724a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final rb.f f725b;

        public k(g gVar, rb.f fVar) {
            n.e(gVar.f681e != null, "success rate ejection config is null");
            this.f724a = gVar;
            this.f725b = fVar;
        }

        public static double c(Collection collection) {
            Iterator it = collection.iterator();
            double dDoubleValue = 0.0d;
            while (it.hasNext()) {
                dDoubleValue += ((Double) it.next()).doubleValue();
            }
            return dDoubleValue / ((double) collection.size());
        }

        public static double d(Collection collection, double d10) {
            Iterator it = collection.iterator();
            double d11 = 0.0d;
            while (it.hasNext()) {
                double dDoubleValue = ((Double) it.next()).doubleValue() - d10;
                d11 += dDoubleValue * dDoubleValue;
            }
            return Math.sqrt(d11 / ((double) collection.size()));
        }

        @Override // ac.h.j
        public void a(c cVar, long j10) {
            List<b> listN = h.n(cVar, this.f724a.f681e.f702d.intValue());
            if (listN.size() < this.f724a.f681e.f701c.intValue() || listN.size() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = listN.iterator();
            while (it.hasNext()) {
                arrayList.add(Double.valueOf(((b) it.next()).n()));
            }
            double dC = c(arrayList);
            double d10 = d(arrayList, dC);
            double dIntValue = dC - (((double) (this.f724a.f681e.f699a.intValue() / 1000.0f)) * d10);
            for (b bVar : listN) {
                if (cVar.e() >= this.f724a.f680d.intValue()) {
                    return;
                }
                if (bVar.n() < dIntValue) {
                    this.f725b.b(f.a.DEBUG, "SuccessRate algorithm detected outlier: {0}. Parameters: successRate={1}, mean={2}, stdev={3}, requiredSuccessRate={4}", bVar, Double.valueOf(bVar.n()), Double.valueOf(dC), Double.valueOf(d10), Double.valueOf(dIntValue));
                    if (new Random().nextInt(100) < this.f724a.f681e.f700b.intValue()) {
                        bVar.d(j10);
                    }
                }
            }
        }
    }

    public h(r0.e eVar, q2 q2Var) {
        rb.f fVarB = eVar.b();
        this.f660o = fVarB;
        d dVar = new d((r0.e) n.o(eVar, "helper"));
        this.f654i = dVar;
        this.f655j = new ac.e(dVar);
        this.f652g = new c();
        this.f653h = (o1) n.o(eVar.d(), "syncContext");
        this.f657l = (ScheduledExecutorService) n.o(eVar.c(), "timeService");
        this.f656k = q2Var;
        fVarB.a(f.a.DEBUG, "OutlierDetection lb created.");
    }

    public static boolean m(List list) {
        Iterator it = list.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((x) it.next()).a().size();
            if (size > 1) {
                return false;
            }
        }
        return true;
    }

    public static List n(c cVar, int i10) {
        ArrayList arrayList = new ArrayList();
        for (b bVar : cVar.values()) {
            if (bVar.f() >= i10) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // rb.r0
    public k1 a(r0.h hVar) {
        this.f660o.b(f.a.DEBUG, "Received resolution result: {0}", hVar);
        g gVar = (g) hVar.c();
        ArrayList arrayList = new ArrayList();
        Iterator it = hVar.a().iterator();
        while (it.hasNext()) {
            arrayList.addAll(((x) it.next()).a());
        }
        this.f652g.keySet().retainAll(arrayList);
        this.f652g.j(gVar);
        this.f652g.g(gVar, arrayList);
        this.f655j.r(gVar.f683g.b());
        if (gVar.a()) {
            Long lValueOf = this.f659n == null ? gVar.f677a : Long.valueOf(Math.max(0L, gVar.f677a.longValue() - (this.f656k.a() - this.f659n.longValue())));
            o1.d dVar = this.f658m;
            if (dVar != null) {
                dVar.a();
                this.f652g.h();
            }
            this.f658m = this.f653h.e(new e(gVar, this.f660o), lValueOf.longValue(), gVar.f677a.longValue(), TimeUnit.NANOSECONDS, this.f657l);
        } else {
            o1.d dVar2 = this.f658m;
            if (dVar2 != null) {
                dVar2.a();
                this.f659n = null;
                this.f652g.c();
            }
        }
        this.f655j.d(hVar.e().d(gVar.f683g.a()).a());
        return k1.f19592e;
    }

    @Override // rb.r0
    public void c(k1 k1Var) {
        this.f655j.c(k1Var);
    }

    @Override // rb.r0
    public void f() {
        this.f655j.f();
    }
}
