package aa;

import android.text.TextUtils;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.inappmessaging.model.MessageType;
import hb.c;
import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executor;
import q9.z;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hc.a f425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final hc.a f426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final da.a f428d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f429e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k3 f430f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final s0 f431g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i3 f432h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ea.m f433i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f434j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final n3 f435k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f436l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ga.h f437m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final n f438n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Executor f439o;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f440a;

        static {
            int[] iArr = new int[z.b.values().length];
            f440a = iArr;
            try {
                iArr[z.b.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f440a[z.b.IMAGE_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f440a[z.b.MODAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f440a[z.b.CARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public e2(hc.a aVar, hc.a aVar2, k kVar, da.a aVar3, d dVar, c cVar, k3 k3Var, s0 s0Var, i3 i3Var, ea.m mVar, n3 n3Var, ga.h hVar, n nVar, b bVar, Executor executor) {
        this.f425a = aVar;
        this.f426b = aVar2;
        this.f427c = kVar;
        this.f428d = aVar3;
        this.f429e = dVar;
        this.f434j = cVar;
        this.f430f = k3Var;
        this.f431g = s0Var;
        this.f432h = i3Var;
        this.f433i = mVar;
        this.f435k = n3Var;
        this.f438n = nVar;
        this.f437m = hVar;
        this.f436l = bVar;
        this.f439o = executor;
    }

    public static /* synthetic */ boolean A(Boolean bool) {
        return !bool.booleanValue();
    }

    public static /* synthetic */ void D(Task task, Executor executor, final cc.k kVar) {
        task.addOnSuccessListener(executor, new OnSuccessListener() { // from class: aa.v1
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                e2.m(kVar, obj);
            }
        });
        task.addOnFailureListener(executor, new OnFailureListener() { // from class: aa.w1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                e2.f(kVar, exc);
            }
        });
    }

    public static ib.e H() {
        return (ib.e) ib.e.e0().x(1L).n();
    }

    public static int I(hb.c cVar, hb.c cVar2) {
        if (cVar.d0() && !cVar2.d0()) {
            return -1;
        }
        if (!cVar2.d0() || cVar.d0()) {
            return Integer.compare(cVar.f0().b0(), cVar2.f0().b0());
        }
        return 1;
    }

    public static boolean J(String str, hb.c cVar) {
        if (Q(str) && cVar.d0()) {
            return true;
        }
        for (q9.h hVar : cVar.g0()) {
            if (O(hVar, str) || N(hVar, str)) {
                h2.a(String.format("The event %s is contained in the list of triggers", str));
                return true;
            }
        }
        return false;
    }

    public static boolean N(q9.h hVar, String str) {
        return hVar.a0().b0().equals(str);
    }

    public static boolean O(q9.h hVar, String str) {
        return hVar.b0().toString().equals(str);
    }

    public static boolean P(da.a aVar, hb.c cVar) {
        long jD0;
        long jA0;
        if (!cVar.e0().equals(c.EnumC0206c.VANILLA_PAYLOAD)) {
            if (cVar.e0().equals(c.EnumC0206c.EXPERIMENTAL_PAYLOAD)) {
                jD0 = cVar.c0().d0();
                jA0 = cVar.c0().a0();
            }
        }
        jD0 = cVar.h0().d0();
        jA0 = cVar.h0().a0();
        long jA = aVar.a();
        return jA > jD0 && jA < jA0;
    }

    public static boolean Q(String str) {
        return str.equals("ON_FOREGROUND");
    }

    public static void R(hb.c cVar, Boolean bool) {
        if (cVar.e0().equals(c.EnumC0206c.VANILLA_PAYLOAD)) {
            h2.c(String.format("Already impressed campaign %s ? : %s", cVar.h0().c0(), bool));
        } else if (cVar.e0().equals(c.EnumC0206c.EXPERIMENTAL_PAYLOAD)) {
            h2.c(String.format("Already impressed experiment %s ? : %s", cVar.c0().c0(), bool));
        }
    }

    public static cc.j T(final Task task, final Executor executor) {
        return cc.j.b(new cc.m() { // from class: aa.a1
            @Override // cc.m
            public final void a(cc.k kVar) {
                e2.D(task, executor, kVar);
            }
        });
    }

    public static boolean V(g2 g2Var) {
        return (TextUtils.isEmpty(g2Var.b()) || TextUtils.isEmpty(g2Var.c().b())) ? false : true;
    }

    public static /* synthetic */ cc.j a(final e2 e2Var, cc.j jVar, final ib.b bVar) {
        if (!e2Var.f438n.b()) {
            h2.c("Automatic data collection is disabled, not attempting campaign fetch from service.");
            return cc.j.n(H());
        }
        cc.j jVarF = jVar.h(new ic.g() { // from class: aa.b1
            @Override // ic.g
            public final boolean test(Object obj) {
                return e2.V((g2) obj);
            }
        }).o(new ic.e() { // from class: aa.c1
            @Override // ic.e
            public final Object apply(Object obj) {
                return this.f394a.f429e.c((g2) obj, bVar);
            }
        }).x(cc.j.n(H())).f(new ic.d() { // from class: aa.d1
            @Override // ic.d
            public final void accept(Object obj) {
                h2.c(String.format(Locale.US, "Successfully fetched %d messages from backend", Integer.valueOf(((ib.e) obj).d0().size())));
            }
        }).f(new ic.d() { // from class: aa.e1
            @Override // ic.d
            public final void accept(Object obj) {
                this.f424a.f431g.h((ib.e) obj).l();
            }
        });
        final c cVar = e2Var.f434j;
        Objects.requireNonNull(cVar);
        cc.j jVarF2 = jVarF.f(new ic.d() { // from class: aa.g1
            @Override // ic.d
            public final void accept(Object obj) {
                cVar.e((ib.e) obj);
            }
        });
        final n3 n3Var = e2Var.f435k;
        Objects.requireNonNull(n3Var);
        return jVarF2.f(new ic.d() { // from class: aa.h1
            @Override // ic.d
            public final void accept(Object obj) {
                n3Var.c((ib.e) obj);
            }
        }).e(new ic.d() { // from class: aa.i1
            @Override // ic.d
            public final void accept(Object obj) {
                h2.d("Service fetch error: " + ((Throwable) obj).getMessage());
            }
        }).q(cc.j.g());
    }

    public static /* synthetic */ cc.j b(hb.c cVar) {
        int i10 = a.f440a[cVar.a0().e0().ordinal()];
        if (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) {
            return cc.j.n(cVar);
        }
        h2.a("Filtering non-displayable message");
        return cc.j.g();
    }

    public static /* synthetic */ cc.j c(e2 e2Var, final hb.c cVar) {
        e2Var.getClass();
        return cVar.d0() ? cc.j.n(cVar) : e2Var.f431g.l(cVar).d(new ic.d() { // from class: aa.m1
            @Override // ic.d
            public final void accept(Object obj) {
                h2.d("Impression store read fail: " + ((Throwable) obj).getMessage());
            }
        }).h(cc.s.g(Boolean.FALSE)).e(new ic.d() { // from class: aa.n1
            @Override // ic.d
            public final void accept(Object obj) {
                e2.R(cVar, (Boolean) obj);
            }
        }).f(new ic.g() { // from class: aa.o1
            @Override // ic.g
            public final boolean test(Object obj) {
                return e2.A((Boolean) obj);
            }
        }).o(new ic.e() { // from class: aa.p1
            @Override // ic.e
            public final Object apply(Object obj) {
                return e2.C(cVar, (Boolean) obj);
            }
        });
    }

    public static /* synthetic */ kh.a e(final e2 e2Var, final String str) {
        cc.j jVarQ = e2Var.f427c.f().f(new ic.d() { // from class: aa.q1
            @Override // ic.d
            public final void accept(Object obj) {
                h2.a("Fetched from cache");
            }
        }).e(new ic.d() { // from class: aa.x1
            @Override // ic.d
            public final void accept(Object obj) {
                h2.d("Cache read error: " + ((Throwable) obj).getMessage());
            }
        }).q(cc.j.g());
        ic.d dVar = new ic.d() { // from class: aa.y1
            @Override // ic.d
            public final void accept(Object obj) {
                this.f600a.f427c.h((ib.e) obj).d(new ic.a() { // from class: aa.j1
                    @Override // ic.a
                    public final void run() {
                        h2.a("Wrote to cache");
                    }
                }).e(new ic.d() { // from class: aa.k1
                    @Override // ic.d
                    public final void accept(Object obj2) {
                        h2.d("Cache write error: " + ((Throwable) obj2).getMessage());
                    }
                }).k(new ic.e() { // from class: aa.l1
                    @Override // ic.e
                    public final Object apply(Object obj2) {
                        return cc.b.c();
                    }
                }).l();
            }
        };
        final ic.e eVar = new ic.e() { // from class: aa.z1
            @Override // ic.e
            public final Object apply(Object obj) {
                return e2.c(this.f603a, (hb.c) obj);
            }
        };
        final ic.e eVar2 = new ic.e() { // from class: aa.a2
            @Override // ic.e
            public final Object apply(Object obj) {
                return this.f383a.L(str, (hb.c) obj);
            }
        };
        final ic.e eVar3 = new ic.e() { // from class: aa.b2
            @Override // ic.e
            public final Object apply(Object obj) {
                return e2.b((hb.c) obj);
            }
        };
        ic.e eVar4 = new ic.e() { // from class: aa.c2
            @Override // ic.e
            public final Object apply(Object obj) {
                return this.f396a.M(str, eVar, eVar2, eVar3, (ib.e) obj);
            }
        };
        cc.j jVarQ2 = e2Var.f431g.j().e(new ic.d() { // from class: aa.d2
            @Override // ic.d
            public final void accept(Object obj) {
                h2.d("Impressions store read fail: " + ((Throwable) obj).getMessage());
            }
        }).d(ib.b.e0()).q(cc.j.n(ib.b.e0()));
        final cc.j jVarP = cc.j.z(T(e2Var.f437m.getId(), e2Var.f439o), T(e2Var.f437m.a(false), e2Var.f439o), new ic.b() { // from class: aa.v0
            @Override // ic.b
            public final Object apply(Object obj, Object obj2) {
                return g2.a((String) obj, (ga.m) obj2);
            }
        }).p(e2Var.f430f.a());
        ic.e eVar5 = new ic.e() { // from class: aa.w0
            @Override // ic.e
            public final Object apply(Object obj) {
                return e2.a(this.f595a, jVarP, (ib.b) obj);
            }
        };
        if (e2Var.S(str)) {
            h2.c(String.format("Forcing fetch from service rather than cache. Test Device: %s | App Fresh Install: %s", Boolean.valueOf(e2Var.f435k.b()), Boolean.valueOf(e2Var.f435k.a())));
            return jVarQ2.i(eVar5).i(eVar4).y();
        }
        h2.a("Attempting to fetch campaigns using cache");
        return jVarQ.x(jVarQ2.i(eVar5).f(dVar)).i(eVar4).y();
    }

    public static /* synthetic */ void f(cc.k kVar, Exception exc) {
        kVar.onError(exc);
        kVar.onComplete();
    }

    public static /* synthetic */ boolean g(Boolean bool) {
        return !bool.booleanValue();
    }

    public static /* synthetic */ void m(cc.k kVar, Object obj) {
        kVar.onSuccess(obj);
        kVar.onComplete();
    }

    public static /* synthetic */ boolean r(e2 e2Var, hb.c cVar) {
        return e2Var.f435k.b() || P(e2Var.f428d, cVar);
    }

    public cc.f K() {
        return cc.f.v(this.f425a, this.f434j.d(), this.f426b).g(new ic.d() { // from class: aa.u0
            @Override // ic.d
            public final void accept(Object obj) {
                h2.a("Event Triggered: " + ((String) obj));
            }
        }).w(this.f430f.a()).c(new ic.e() { // from class: aa.f1
            @Override // ic.e
            public final Object apply(Object obj) {
                return e2.e(this.f444a, (String) obj);
            }
        }).w(this.f430f.b());
    }

    public final cc.j L(String str, final hb.c cVar) {
        return (cVar.d0() || !Q(str)) ? cc.j.n(cVar) : this.f432h.p(this.f433i).e(new ic.d() { // from class: aa.x0
            @Override // ic.d
            public final void accept(Object obj) {
                h2.c("App foreground rate limited ? : " + ((Boolean) obj));
            }
        }).h(cc.s.g(Boolean.FALSE)).f(new ic.g() { // from class: aa.y0
            @Override // ic.g
            public final boolean test(Object obj) {
                return e2.g((Boolean) obj);
            }
        }).o(new ic.e() { // from class: aa.z0
            @Override // ic.e
            public final Object apply(Object obj) {
                return e2.o(cVar, (Boolean) obj);
            }
        });
    }

    public final cc.j M(final String str, ic.e eVar, ic.e eVar2, ic.e eVar3, ib.e eVar4) {
        return cc.f.s(eVar4.d0()).j(new ic.g() { // from class: aa.r1
            @Override // ic.g
            public final boolean test(Object obj) {
                return e2.r(this.f569a, (hb.c) obj);
            }
        }).j(new ic.g() { // from class: aa.s1
            @Override // ic.g
            public final boolean test(Object obj) {
                return e2.J(str, (hb.c) obj);
            }
        }).p(eVar).p(eVar2).p(eVar3).E(new Comparator() { // from class: aa.t1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return e2.I((hb.c) obj, (hb.c) obj2);
            }
        }).k().i(new ic.e() { // from class: aa.u1
            @Override // ic.e
            public final Object apply(Object obj) {
                return this.f581a.U((hb.c) obj, str);
            }
        });
    }

    public final boolean S(String str) {
        return this.f435k.a() ? Q(str) : this.f435k.b();
    }

    public final cc.j U(hb.c cVar, String str) {
        String strB0;
        String strC0;
        if (cVar.e0().equals(c.EnumC0206c.VANILLA_PAYLOAD)) {
            strB0 = cVar.h0().b0();
            strC0 = cVar.h0().c0();
        } else {
            if (!cVar.e0().equals(c.EnumC0206c.EXPERIMENTAL_PAYLOAD)) {
                return cc.j.g();
            }
            strB0 = cVar.c0().b0();
            strC0 = cVar.c0().c0();
            if (!cVar.d0()) {
                this.f436l.b(cVar.c0().f0());
            }
        }
        ea.i iVarC = ea.k.c(cVar.a0(), strB0, strC0, cVar.d0(), cVar.b0());
        return iVarC.c().equals(MessageType.UNSUPPORTED) ? cc.j.g() : cc.j.n(new ea.o(iVarC, str));
    }

    public static /* synthetic */ hb.c C(hb.c cVar, Boolean bool) {
        return cVar;
    }

    public static /* synthetic */ hb.c o(hb.c cVar, Boolean bool) {
        return cVar;
    }
}
