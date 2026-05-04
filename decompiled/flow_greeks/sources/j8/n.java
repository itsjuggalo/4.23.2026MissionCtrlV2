package j8;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import e8.e;
import e8.r;
import h8.h;
import j8.b0;
import j8.n;
import j8.v;
import j8.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import m8.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class n implements h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j8.q f14019a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h8.h f14021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j8.u f14022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j8.v f14023e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public m8.k f14024f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o8.g f14026h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final j8.g f14027i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final q8.c f14028j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final q8.c f14029k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final q8.c f14030l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public j8.y f14033o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public j8.y f14034p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public e8.h f14035q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m8.f f14020b = new m8.f(new m8.b(), 0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f14025g = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f14031m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f14032n = 1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f14036r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f14037s = 0;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements h8.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j8.l f14038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f14039b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e.InterfaceC0157e f14040c;

        public a(j8.l lVar, long j10, e.InterfaceC0157e interfaceC0157e) {
            this.f14038a = lVar;
            this.f14039b = j10;
            this.f14040c = interfaceC0157e;
        }

        @Override // h8.p
        public void a(String str, String str2) {
            e8.c cVarJ = n.J(str, str2);
            n.this.s0("updateChildren", this.f14038a, cVarJ);
            n.this.D(this.f14039b, this.f14038a, cVarJ);
            n.this.H(this.f14040c, cVarJ, this.f14038a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum a0 {
        INITIALIZING,
        RUN,
        SENT,
        COMPLETED,
        SENT_NEEDS_ABORT,
        NEEDS_ABORT
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements h8.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j8.l f14049a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ r8.n f14050b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e.InterfaceC0157e f14051c;

        public b(j8.l lVar, r8.n nVar, e.InterfaceC0157e interfaceC0157e) {
            this.f14049a = lVar;
            this.f14050b = nVar;
            this.f14051c = interfaceC0157e;
        }

        @Override // h8.p
        public void a(String str, String str2) {
            e8.c cVarJ = n.J(str, str2);
            n.this.s0("onDisconnect().setValue", this.f14049a, cVarJ);
            if (cVarJ == null) {
                n.this.f14023e.d(this.f14049a, this.f14050b);
            }
            n.this.H(this.f14051c, cVarJ, this.f14049a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements h8.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j8.l f14053a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f14054b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e.InterfaceC0157e f14055c;

        public c(j8.l lVar, Map map, e.InterfaceC0157e interfaceC0157e) {
            this.f14053a = lVar;
            this.f14054b = map;
            this.f14055c = interfaceC0157e;
        }

        @Override // h8.p
        public void a(String str, String str2) {
            e8.c cVarJ = n.J(str, str2);
            n.this.s0("onDisconnect().updateChildren", this.f14053a, cVarJ);
            if (cVarJ == null) {
                for (Map.Entry entry : this.f14054b.entrySet()) {
                    n.this.f14023e.d(this.f14053a.u((j8.l) entry.getKey()), (r8.n) entry.getValue());
                }
            }
            n.this.H(this.f14055c, cVarJ, this.f14053a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements h8.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j8.l f14057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e.InterfaceC0157e f14058b;

        public d(j8.l lVar, e.InterfaceC0157e interfaceC0157e) {
            this.f14057a = lVar;
            this.f14058b = interfaceC0157e;
        }

        @Override // h8.p
        public void a(String str, String str2) {
            e8.c cVarJ = n.J(str, str2);
            if (cVarJ == null) {
                n.this.f14023e.c(this.f14057a);
            }
            n.this.H(this.f14058b, cVarJ, this.f14057a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class e implements v.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f14060a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f14061b;

        public e(Map map, List list) {
            this.f14060a = map;
            this.f14061b = list;
        }

        @Override // j8.v.d
        public void a(j8.l lVar, r8.n nVar) {
            this.f14061b.addAll(n.this.f14034p.A(lVar, j8.t.i(nVar, n.this.f14034p.J(lVar, new ArrayList()), this.f14060a)));
            n.this.f0(n.this.g(lVar, -9));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r.b f14064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e8.c f14065b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e8.b f14066c;

        public g(r.b bVar, e8.c cVar, e8.b bVar2) {
            this.f14064a = bVar;
            this.f14065b = cVar;
            this.f14066c = bVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14064a.onComplete(this.f14065b, false, this.f14066c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class h implements k.c {
        public h() {
        }

        @Override // m8.k.c
        public void a(m8.k kVar) {
            n.this.m0(kVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class i implements h8.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j8.l f14069a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f14070b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ n f14071c;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ z f14073a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e8.b f14074b;

            public a(z zVar, e8.b bVar) {
                this.f14073a = zVar;
                this.f14074b = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f14073a.f14117b.onComplete(null, true, this.f14074b);
            }
        }

        public i(j8.l lVar, List list, n nVar) {
            this.f14069a = lVar;
            this.f14070b = list;
            this.f14071c = nVar;
        }

        @Override // h8.p
        public void a(String str, String str2) {
            e8.c cVarJ = n.J(str, str2);
            n.this.s0("Transaction", this.f14069a, cVarJ);
            ArrayList arrayList = new ArrayList();
            if (cVarJ != null) {
                if (cVarJ.f() == -1) {
                    for (z zVar : this.f14070b) {
                        if (zVar.f14119d == a0.SENT_NEEDS_ABORT) {
                            zVar.f14119d = a0.NEEDS_ABORT;
                        } else {
                            zVar.f14119d = a0.RUN;
                        }
                    }
                } else {
                    for (z zVar2 : this.f14070b) {
                        zVar2.f14119d = a0.NEEDS_ABORT;
                        zVar2.f14123h = cVarJ;
                    }
                }
                n.this.f0(this.f14069a);
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            for (z zVar3 : this.f14070b) {
                zVar3.f14119d = a0.COMPLETED;
                arrayList.addAll(n.this.f14034p.s(zVar3.f14124i, false, false, n.this.f14020b));
                arrayList2.add(new a(zVar3, e8.k.a(e8.k.c(this.f14071c, zVar3.f14116a), r8.i.c(zVar3.f14127l))));
                n nVar = n.this;
                nVar.d0(new e0(nVar, zVar3.f14118c, o8.i.a(zVar3.f14116a)));
            }
            n nVar2 = n.this;
            nVar2.b0(nVar2.f14024f.k(this.f14069a));
            n.this.l0();
            this.f14071c.a0(arrayList);
            for (int i10 = 0; i10 < arrayList2.size(); i10++) {
                n.this.Z((Runnable) arrayList2.get(i10));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class j implements k.c {
        public j() {
        }

        @Override // m8.k.c
        public void a(m8.k kVar) {
            n.this.b0(kVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.I();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z f14078a;

        public l(z zVar) {
            this.f14078a = zVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            n nVar = n.this;
            nVar.d0(new e0(nVar, this.f14078a.f14118c, o8.i.a(this.f14078a.f14116a)));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z f14080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e8.c f14081b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e8.b f14082c;

        public m(z zVar, e8.c cVar, e8.b bVar) {
            this.f14080a = zVar;
            this.f14081b = cVar;
            this.f14082c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14080a.f14117b.onComplete(this.f14081b, false, this.f14082c);
        }
    }

    /* JADX INFO: renamed from: j8.n$n, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class C0246n implements k.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f14084a;

        public C0246n(List list) {
            this.f14084a = list;
        }

        @Override // m8.k.c
        public void a(m8.k kVar) {
            n.this.F(this.f14084a, kVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class o implements k.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f14086a;

        public o(int i10) {
            this.f14086a = i10;
        }

        @Override // m8.k.b
        public boolean a(m8.k kVar) {
            n.this.h(kVar, this.f14086a);
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class p implements k.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f14088a;

        public p(int i10) {
            this.f14088a = i10;
        }

        @Override // m8.k.c
        public void a(m8.k kVar) {
            n.this.h(kVar, this.f14088a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class q implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z f14090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e8.c f14091b;

        public q(z zVar, e8.c cVar) {
            this.f14090a = zVar;
            this.f14091b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14090a.f14117b.onComplete(this.f14091b, false, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class r implements b0.b {
        public r() {
        }

        @Override // j8.b0.b
        public void a(String str) {
            n.this.f14028j.b("Auth token changed, triggering auth token refresh", new Object[0]);
            n.this.f14021c.n(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class s implements b0.b {
        public s() {
        }

        @Override // j8.b0.b
        public void a(String str) {
            n.this.f14028j.b("App check token changed, triggering app check token refresh", new Object[0]);
            n.this.f14021c.r(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class u implements y.s {

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements h8.p {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ y.p f14100a;

            public a(y.p pVar) {
                this.f14100a = pVar;
            }

            @Override // h8.p
            public void a(String str, String str2) {
                n.this.a0(this.f14100a.c(n.J(str, str2)));
            }
        }

        public u() {
        }

        @Override // j8.y.s
        public void a(o8.i iVar, j8.z zVar) {
            n.this.f14021c.t(iVar.e().s(), iVar.d().k());
        }

        @Override // j8.y.s
        public void b(o8.i iVar, j8.z zVar, h8.g gVar, y.p pVar) {
            n.this.f14021c.q(iVar.e().s(), iVar.d().k(), gVar, zVar != null ? Long.valueOf(zVar.a()) : null, new a(pVar));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class v implements h8.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c0 f14102a;

        public v(c0 c0Var) {
            this.f14102a = c0Var;
        }

        @Override // h8.p
        public void a(String str, String str2) {
            e8.c cVarJ = n.J(str, str2);
            n.this.s0("Persisted write", this.f14102a.c(), cVarJ);
            n.this.D(this.f14102a.d(), this.f14102a.c(), cVarJ);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class w implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e.InterfaceC0157e f14104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e8.c f14105b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e8.e f14106c;

        public w(e.InterfaceC0157e interfaceC0157e, e8.c cVar, e8.e eVar) {
            this.f14104a = interfaceC0157e;
            this.f14105b = cVar;
            this.f14106c = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14104a.a(this.f14105b, this.f14106c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class x implements h8.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j8.l f14108a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f14109b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e.InterfaceC0157e f14110c;

        public x(j8.l lVar, long j10, e.InterfaceC0157e interfaceC0157e) {
            this.f14108a = lVar;
            this.f14109b = j10;
            this.f14110c = interfaceC0157e;
        }

        @Override // h8.p
        public void a(String str, String str2) {
            e8.c cVarJ = n.J(str, str2);
            n.this.s0("setValue", this.f14108a, cVarJ);
            n.this.D(this.f14109b, this.f14108a, cVarJ);
            n.this.H(this.f14110c, cVarJ, this.f14108a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class y implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e8.p f14112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource f14113b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ n f14114c;

        public y(e8.p pVar, TaskCompletionSource taskCompletionSource, n nVar) {
            this.f14112a = pVar;
            this.f14113b = taskCompletionSource;
            this.f14114c = nVar;
        }

        public static /* synthetic */ void a(y yVar, TaskCompletionSource taskCompletionSource, e8.b bVar, e8.p pVar, n nVar, Task task) {
            yVar.getClass();
            if (taskCompletionSource.getTask().isComplete()) {
                return;
            }
            if (task.isSuccessful()) {
                r8.n nVarA = r8.o.a(task.getResult());
                o8.i iVarU = pVar.u();
                n.this.T(iVarU, true, true);
                nVar.a0(iVarU.g() ? n.this.f14034p.A(iVarU.e(), nVarA) : n.this.f14034p.F(iVarU.e(), nVarA, n.this.P().a0(iVarU)));
                taskCompletionSource.setResult(e8.k.a(pVar.t(), r8.i.d(nVarA, pVar.u().c())));
                n.this.T(iVarU, false, true);
                return;
            }
            if (bVar.b()) {
                taskCompletionSource.setResult(bVar);
                return;
            }
            Exception exception = task.getException();
            Objects.requireNonNull(exception);
            taskCompletionSource.setException(exception);
        }

        @Override // java.lang.Runnable
        public void run() {
            r8.n nVarN = n.this.f14034p.N(this.f14112a.u());
            if (nVarN != null) {
                this.f14113b.setResult(e8.k.a(this.f14112a.t(), r8.i.c(nVarN)));
                return;
            }
            n.this.f14034p.Y(this.f14112a.u());
            final e8.b bVarP = n.this.f14034p.P(this.f14112a);
            if (bVarP.b()) {
                n nVar = n.this;
                final TaskCompletionSource taskCompletionSource = this.f14113b;
                nVar.j0(new Runnable() { // from class: j8.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        taskCompletionSource.trySetResult(bVarP);
                    }
                }, 3000L);
            }
            Task taskB = n.this.f14021c.b(this.f14112a.s().s(), this.f14112a.u().d().k());
            ScheduledExecutorService scheduledExecutorServiceD = ((m8.c) n.this.f14027i.v()).d();
            final TaskCompletionSource taskCompletionSource2 = this.f14113b;
            final e8.p pVar = this.f14112a;
            final n nVar2 = this.f14114c;
            taskB.addOnCompleteListener(scheduledExecutorServiceD, new OnCompleteListener() { // from class: j8.p
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    n.y.a(this.f14130a, taskCompletionSource2, bVarP, pVar, nVar2, task);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class z implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public j8.l f14116a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public r.b f14117b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public e8.s f14118c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a0 f14119d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f14120e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f14121f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f14122g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public e8.c f14123h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f14124i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public r8.n f14125j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public r8.n f14126k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public r8.n f14127l;

        public /* synthetic */ z(j8.l lVar, r.b bVar, e8.s sVar, a0 a0Var, boolean z10, long j10, k kVar) {
            this(lVar, bVar, sVar, a0Var, z10, j10);
        }

        public static /* synthetic */ int u(z zVar) {
            int i10 = zVar.f14122g;
            zVar.f14122g = i10 + 1;
            return i10;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
        public int compareTo(z zVar) {
            long j10 = this.f14120e;
            long j11 = zVar.f14120e;
            if (j10 < j11) {
                return -1;
            }
            return j10 == j11 ? 0 : 1;
        }

        public z(j8.l lVar, r.b bVar, e8.s sVar, a0 a0Var, boolean z10, long j10) {
            this.f14116a = lVar;
            this.f14117b = bVar;
            this.f14118c = sVar;
            this.f14119d = a0Var;
            this.f14122g = 0;
            this.f14121f = z10;
            this.f14120e = j10;
            this.f14123h = null;
            this.f14125j = null;
            this.f14126k = null;
            this.f14127l = null;
        }
    }

    public n(j8.q qVar, j8.g gVar, e8.h hVar) {
        this.f14019a = qVar;
        this.f14027i = gVar;
        this.f14035q = hVar;
        this.f14028j = gVar.q("RepoOperation");
        this.f14029k = gVar.q("Transaction");
        this.f14030l = gVar.q("DataOperation");
        this.f14026h = new o8.g(gVar);
        k0(new k());
    }

    public static e8.c J(String str, String str2) {
        if (str != null) {
            return e8.c.d(str, str2);
        }
        return null;
    }

    public final void D(long j10, j8.l lVar, e8.c cVar) {
        if (cVar == null || cVar.f() != -25) {
            List listS = this.f14034p.s(j10, !(cVar == null), true, this.f14020b);
            if (listS.size() > 0) {
                f0(lVar);
            }
            a0(listS);
        }
    }

    public void E(j8.i iVar) {
        r8.b bVarK = iVar.e().e().K();
        a0((bVarK == null || !bVarK.equals(j8.c.f13956a)) ? this.f14034p.t(iVar) : this.f14033o.t(iVar));
    }

    public final void F(List list, m8.k kVar) {
        List list2 = (List) kVar.g();
        if (list2 != null) {
            list.addAll(list2);
        }
        kVar.c(new C0246n(list));
    }

    public final List G(m8.k kVar) {
        ArrayList arrayList = new ArrayList();
        F(arrayList, kVar);
        Collections.sort(arrayList);
        return arrayList;
    }

    public void H(e.InterfaceC0157e interfaceC0157e, e8.c cVar, j8.l lVar) {
        if (interfaceC0157e != null) {
            r8.b bVarA = lVar.A();
            Z(new w(interfaceC0157e, cVar, (bVarA == null || !bVarA.s()) ? e8.k.c(this, lVar) : e8.k.c(this, lVar.L())));
        }
    }

    public final void I() {
        j8.q qVar = this.f14019a;
        this.f14021c = this.f14027i.D(new h8.f(qVar.f14135a, qVar.f14137c, qVar.f14136b), this);
        this.f14027i.m().b(((m8.c) this.f14027i.v()).d(), new r());
        this.f14027i.l().b(((m8.c) this.f14027i.v()).d(), new s());
        this.f14021c.a();
        l8.e eVarT = this.f14027i.t(this.f14019a.f14135a);
        this.f14022d = new j8.u();
        this.f14023e = new j8.v();
        this.f14024f = new m8.k();
        this.f14033o = new j8.y(this.f14027i, new l8.d(), new t());
        this.f14034p = new j8.y(this.f14027i, eVarT, new u());
        g0(eVarT);
        r8.b bVar = j8.c.f13958c;
        Boolean bool = Boolean.FALSE;
        r0(bVar, bool);
        r0(j8.c.f13959d, bool);
    }

    public final m8.k K(j8.l lVar) {
        m8.k kVarK = this.f14024f;
        while (!lVar.isEmpty() && kVarK.g() == null) {
            kVarK = kVarK.k(new j8.l(lVar.K()));
            lVar = lVar.S();
        }
        return kVarK;
    }

    public final r8.n L(j8.l lVar) {
        return M(lVar, new ArrayList());
    }

    public final r8.n M(j8.l lVar, List list) {
        r8.n nVarJ = this.f14034p.J(lVar, list);
        return nVarJ == null ? r8.g.y() : nVarJ;
    }

    public final long N() {
        long j10 = this.f14032n;
        this.f14032n = 1 + j10;
        return j10;
    }

    public j8.q O() {
        return this.f14019a;
    }

    public j8.y P() {
        return this.f14034p;
    }

    public Task Q(e8.p pVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        k0(new y(pVar, taskCompletionSource, this));
        return taskCompletionSource.getTask();
    }

    public void R() {
        this.f14021c.f("repo_interrupt");
    }

    public void S(o8.i iVar, boolean z10) {
        T(iVar, z10, false);
    }

    public void T(o8.i iVar, boolean z10, boolean z11) {
        m8.m.f(iVar.e().isEmpty() || !iVar.e().K().equals(j8.c.f13956a));
        this.f14034p.O(iVar, z10, z11);
    }

    public final long U() {
        long j10 = this.f14037s;
        this.f14037s = 1 + j10;
        return j10;
    }

    public void V(j8.l lVar, e.InterfaceC0157e interfaceC0157e) {
        this.f14021c.p(lVar.s(), new d(lVar, interfaceC0157e));
    }

    public void W(j8.l lVar, r8.n nVar, e.InterfaceC0157e interfaceC0157e) {
        this.f14021c.k(lVar.s(), nVar.N(true), new b(lVar, nVar, interfaceC0157e));
    }

    public void X(j8.l lVar, Map map, e.InterfaceC0157e interfaceC0157e, Map map2) {
        this.f14021c.e(lVar.s(), map2, new c(lVar, map, interfaceC0157e));
    }

    public void Y(r8.b bVar, Object obj) {
        r0(bVar, obj);
    }

    public void Z(Runnable runnable) {
        this.f14027i.E();
        this.f14027i.o().b(runnable);
    }

    @Override // h8.h.a
    public void a(List list, Object obj, boolean z10, Long l10) {
        List listA;
        j8.l lVar = new j8.l(list);
        if (this.f14028j.f()) {
            this.f14028j.b("onDataUpdate: " + lVar, new Object[0]);
        }
        if (this.f14030l.f()) {
            this.f14028j.b("onDataUpdate: " + lVar + " " + obj, new Object[0]);
        }
        this.f14031m++;
        try {
            if (l10 != null) {
                j8.z zVar = new j8.z(l10.longValue());
                if (z10) {
                    HashMap map = new HashMap();
                    for (Map.Entry entry : ((Map) obj).entrySet()) {
                        map.put(new j8.l((String) entry.getKey()), r8.o.a(entry.getValue()));
                    }
                    listA = this.f14034p.E(lVar, map, zVar);
                } else {
                    listA = this.f14034p.F(lVar, r8.o.a(obj), zVar);
                }
            } else if (z10) {
                HashMap map2 = new HashMap();
                for (Map.Entry entry2 : ((Map) obj).entrySet()) {
                    map2.put(new j8.l((String) entry2.getKey()), r8.o.a(entry2.getValue()));
                }
                listA = this.f14034p.z(lVar, map2);
            } else {
                listA = this.f14034p.A(lVar, r8.o.a(obj));
            }
            if (listA.size() > 0) {
                f0(lVar);
            }
            a0(listA);
        } catch (e8.d e10) {
            this.f14028j.c("FIREBASE INTERNAL ERROR", e10);
        }
    }

    public final void a0(List list) {
        if (list.isEmpty()) {
            return;
        }
        this.f14026h.b(list);
    }

    @Override // h8.h.a
    public void b(boolean z10) {
        Y(j8.c.f13958c, Boolean.valueOf(z10));
    }

    public final void b0(m8.k kVar) {
        List list = (List) kVar.g();
        if (list != null) {
            int i10 = 0;
            while (i10 < list.size()) {
                if (((z) list.get(i10)).f14119d == a0.COMPLETED) {
                    list.remove(i10);
                } else {
                    i10++;
                }
            }
            if (list.size() > 0) {
                kVar.j(list);
            } else {
                kVar.j(null);
            }
        }
        kVar.c(new j());
    }

    @Override // h8.h.a
    public void c() {
        Y(j8.c.f13959d, Boolean.TRUE);
    }

    public void c0() {
        if (this.f14028j.f()) {
            this.f14028j.b("Purging writes", new Object[0]);
        }
        a0(this.f14034p.T());
        g(j8.l.G(), -25);
        this.f14021c.c();
    }

    @Override // h8.h.a
    public void d(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            r0(r8.b.h((String) entry.getKey()), entry.getValue());
        }
    }

    public void d0(j8.i iVar) {
        a0(j8.c.f13956a.equals(iVar.e().e().K()) ? this.f14033o.U(iVar) : this.f14034p.U(iVar));
    }

    @Override // h8.h.a
    public void e() {
        Y(j8.c.f13959d, Boolean.FALSE);
        i0();
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0153 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0033 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e0(java.util.List r27, j8.l r28) {
        /*
            Method dump skipped, instruction units count: 409
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j8.n.e0(java.util.List, j8.l):void");
    }

    @Override // h8.h.a
    public void f(List list, List list2, Long l10) {
        j8.l lVar = new j8.l(list);
        if (this.f14028j.f()) {
            this.f14028j.b("onRangeMergeUpdate: " + lVar, new Object[0]);
        }
        if (this.f14030l.f()) {
            this.f14028j.b("onRangeMergeUpdate: " + lVar + " " + list2, new Object[0]);
        }
        this.f14031m++;
        ArrayList arrayList = new ArrayList(list2.size());
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new r8.s((h8.o) it.next()));
        }
        List listG = l10 != null ? this.f14034p.G(lVar, arrayList, new j8.z(l10.longValue())) : this.f14034p.B(lVar, arrayList);
        if (listG.size() > 0) {
            f0(lVar);
        }
        a0(listG);
    }

    public final j8.l f0(j8.l lVar) {
        m8.k kVarK = K(lVar);
        j8.l lVarF = kVarK.f();
        e0(G(kVarK), lVarF);
        return lVarF;
    }

    public final j8.l g(j8.l lVar, int i10) {
        j8.l lVarF = K(lVar).f();
        if (this.f14029k.f()) {
            this.f14028j.b("Aborting transactions for path: " + lVar + ". Affected: " + lVarF, new Object[0]);
        }
        m8.k kVarK = this.f14024f.k(lVar);
        kVarK.a(new o(i10));
        h(kVarK, i10);
        kVarK.d(new p(i10));
        return lVarF;
    }

    public final void g0(l8.e eVar) {
        List<c0> listD = eVar.d();
        Map mapC = j8.t.c(this.f14020b);
        long jD = Long.MIN_VALUE;
        for (c0 c0Var : listD) {
            v vVar = new v(c0Var);
            if (jD >= c0Var.d()) {
                throw new IllegalStateException("Write ids were not in order.");
            }
            jD = c0Var.d();
            this.f14032n = c0Var.d() + 1;
            if (c0Var.e()) {
                if (this.f14028j.f()) {
                    this.f14028j.b("Restoring overwrite with id " + c0Var.d(), new Object[0]);
                }
                this.f14021c.l(c0Var.c().s(), c0Var.b().N(true), vVar);
                this.f14034p.I(c0Var.c(), c0Var.b(), j8.t.g(c0Var.b(), this.f14034p, c0Var.c(), mapC), c0Var.d(), true, false);
            } else {
                if (this.f14028j.f()) {
                    this.f14028j.b("Restoring merge with id " + c0Var.d(), new Object[0]);
                }
                this.f14021c.i(c0Var.c().s(), c0Var.a().w(true), vVar);
                this.f14034p.H(c0Var.c(), c0Var.a(), j8.t.f(c0Var.a(), this.f14034p, c0Var.c(), mapC), c0Var.d(), false);
            }
        }
    }

    public final void h(m8.k kVar, int i10) {
        e8.c cVarA;
        List list = (List) kVar.g();
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            if (i10 == -9) {
                cVarA = e8.c.c("overriddenBySet");
            } else {
                m8.m.g(i10 == -25, "Unknown transaction abort reason: " + i10);
                cVarA = e8.c.a(-25);
            }
            int i11 = -1;
            for (int i12 = 0; i12 < list.size(); i12++) {
                z zVar = (z) list.get(i12);
                a0 a0Var = zVar.f14119d;
                a0 a0Var2 = a0.SENT_NEEDS_ABORT;
                if (a0Var != a0Var2) {
                    if (zVar.f14119d == a0.SENT) {
                        m8.m.f(i11 == i12 + (-1));
                        zVar.f14119d = a0Var2;
                        zVar.f14123h = cVarA;
                        i11 = i12;
                    } else {
                        m8.m.f(zVar.f14119d == a0.RUN);
                        d0(new e0(this, zVar.f14118c, o8.i.a(zVar.f14116a)));
                        if (i10 == -9) {
                            arrayList.addAll(this.f14034p.s(zVar.f14124i, true, false, this.f14020b));
                        } else {
                            m8.m.g(i10 == -25, "Unknown transaction abort reason: " + i10);
                        }
                        arrayList2.add(new q(zVar, cVarA));
                    }
                }
            }
            if (i11 == -1) {
                kVar.j(null);
            } else {
                kVar.j(list.subList(0, i11 + 1));
            }
            a0(arrayList);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                Z((Runnable) it.next());
            }
        }
    }

    public void h0() {
        this.f14021c.h("repo_interrupt");
    }

    public final void i0() {
        Map mapC = j8.t.c(this.f14020b);
        ArrayList arrayList = new ArrayList();
        this.f14023e.b(j8.l.G(), new e(mapC, arrayList));
        this.f14023e = new j8.v();
        a0(arrayList);
    }

    public void j0(Runnable runnable, long j10) {
        this.f14027i.E();
        this.f14027i.v().c(runnable, j10);
    }

    public void k0(Runnable runnable) {
        this.f14027i.E();
        this.f14027i.v().b(runnable);
    }

    public final void l0() {
        m8.k kVar = this.f14024f;
        b0(kVar);
        m0(kVar);
    }

    public final void m0(m8.k kVar) {
        if (((List) kVar.g()) == null) {
            if (kVar.h()) {
                kVar.c(new h());
                return;
            }
            return;
        }
        List listG = G(kVar);
        m8.m.f(listG.size() > 0);
        Boolean bool = Boolean.TRUE;
        Iterator it = listG.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (((z) it.next()).f14119d != a0.RUN) {
                bool = Boolean.FALSE;
                break;
            }
        }
        if (bool.booleanValue()) {
            n0(listG, kVar.f());
        }
    }

    public final void n0(List list, j8.l lVar) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((z) it.next()).f14124i));
        }
        r8.n nVarM = M(lVar, arrayList);
        String strQ = !this.f14025g ? nVarM.Q() : "badhash";
        Iterator it2 = list.iterator();
        while (true) {
            boolean z10 = true;
            if (!it2.hasNext()) {
                this.f14021c.o(lVar.s(), nVarM.N(true), strQ, new i(lVar, list, this));
                return;
            }
            z zVar = (z) it2.next();
            if (zVar.f14119d != a0.RUN) {
                z10 = false;
            }
            m8.m.f(z10);
            zVar.f14119d = a0.SENT;
            z.u(zVar);
            nVarM = nVarM.I(j8.l.R(lVar, zVar.f14116a), zVar.f14126k);
        }
    }

    public void o0(j8.l lVar, r8.n nVar, e.InterfaceC0157e interfaceC0157e) {
        if (this.f14028j.f()) {
            this.f14028j.b("set: " + lVar, new Object[0]);
        }
        if (this.f14030l.f()) {
            this.f14030l.b("set: " + lVar + " " + nVar, new Object[0]);
        }
        r8.n nVarI = j8.t.i(nVar, this.f14034p.J(lVar, new ArrayList()), j8.t.c(this.f14020b));
        long jN = N();
        a0(this.f14034p.I(lVar, nVar, nVarI, jN, true, true));
        this.f14021c.l(lVar.s(), nVar.N(true), new x(lVar, jN, interfaceC0157e));
        f0(g(lVar, -9));
    }

    public void p0(j8.l lVar, r.b bVar, boolean z10) {
        e8.c cVarB;
        r.c cVarA;
        if (this.f14028j.f()) {
            this.f14028j.b("transaction: " + lVar, new Object[0]);
        }
        if (this.f14030l.f()) {
            this.f14028j.b("transaction: " + lVar, new Object[0]);
        }
        if (this.f14027i.C() && !this.f14036r) {
            this.f14036r = true;
            this.f14029k.e("runTransaction() usage detected while persistence is enabled. Please be aware that transactions *will not* be persisted across database restarts.  See https://www.firebase.com/docs/android/guide/offline-capabilities.html#section-handling-transactions-offline for more details.");
        }
        e8.e eVarC = e8.k.c(this, lVar);
        f fVar = new f();
        E(new e0(this, fVar, eVarC.u()));
        z zVar = new z(lVar, bVar, fVar, a0.INITIALIZING, z10, U(), null);
        r8.n nVarL = L(lVar);
        zVar.f14125j = nVarL;
        try {
            cVarA = bVar.doTransaction(e8.k.b(nVarL));
            if (cVarA == null) {
                throw new NullPointerException("Transaction returned null as result");
            }
            cVarB = null;
        } catch (Throwable th) {
            this.f14028j.c("Caught Throwable.", th);
            cVarB = e8.c.b(th);
            cVarA = e8.r.a();
        }
        if (!cVarA.b()) {
            zVar.f14126k = null;
            zVar.f14127l = null;
            Z(new g(bVar, cVarB, e8.k.a(eVarC, r8.i.c(zVar.f14125j))));
            return;
        }
        zVar.f14119d = a0.RUN;
        m8.k kVarK = this.f14024f.k(lVar);
        List arrayList = (List) kVarK.g();
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        arrayList.add(zVar);
        kVarK.j(arrayList);
        Map mapC = j8.t.c(this.f14020b);
        r8.n nVarA = cVarA.a();
        r8.n nVarI = j8.t.i(nVarA, zVar.f14125j, mapC);
        zVar.f14126k = nVarA;
        zVar.f14127l = nVarI;
        zVar.f14124i = N();
        a0(this.f14034p.I(lVar, nVarA, nVarI, zVar.f14124i, z10, false));
        l0();
    }

    public void q0(j8.l lVar, j8.b bVar, e.InterfaceC0157e interfaceC0157e, Map map) {
        if (this.f14028j.f()) {
            this.f14028j.b("update: " + lVar, new Object[0]);
        }
        if (this.f14030l.f()) {
            this.f14030l.b("update: " + lVar + " " + map, new Object[0]);
        }
        if (bVar.isEmpty()) {
            if (this.f14028j.f()) {
                this.f14028j.b("update called with no changes. No-op", new Object[0]);
            }
            H(interfaceC0157e, null, lVar);
            return;
        }
        j8.b bVarF = j8.t.f(bVar, this.f14034p, lVar, j8.t.c(this.f14020b));
        long jN = N();
        a0(this.f14034p.H(lVar, bVar, bVarF, jN, true));
        this.f14021c.i(lVar.s(), map, new a(lVar, jN, interfaceC0157e));
        Iterator it = bVar.iterator();
        while (it.hasNext()) {
            f0(g(lVar.u((j8.l) ((Map.Entry) it.next()).getKey()), -9));
        }
    }

    public final void r0(r8.b bVar, Object obj) {
        if (bVar.equals(j8.c.f13957b)) {
            this.f14020b.a(((Long) obj).longValue());
        }
        j8.l lVar = new j8.l(j8.c.f13956a, bVar);
        try {
            r8.n nVarA = r8.o.a(obj);
            this.f14022d.c(lVar, nVarA);
            a0(this.f14033o.A(lVar, nVarA));
        } catch (e8.d e10) {
            this.f14028j.c("Failed to parse info update", e10);
        }
    }

    public final void s0(String str, j8.l lVar, e8.c cVar) {
        if (cVar == null || cVar.f() == -1 || cVar.f() == -25) {
            return;
        }
        this.f14028j.i(str + " at " + lVar.toString() + " failed: " + cVar.toString());
    }

    public String toString() {
        return this.f14019a.toString();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class f implements e8.s {
        public f() {
        }

        @Override // e8.s
        public void onCancelled(e8.c cVar) {
        }

        @Override // e8.s
        public void onDataChange(e8.b bVar) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class t implements y.s {

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ o8.i f14096a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ y.p f14097b;

            public a(o8.i iVar, y.p pVar) {
                this.f14096a = iVar;
                this.f14097b = pVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                r8.n nVarA = n.this.f14022d.a(this.f14096a.e());
                if (nVarA.isEmpty()) {
                    return;
                }
                n.this.a0(n.this.f14033o.A(this.f14096a.e(), nVarA));
                this.f14097b.c(null);
            }
        }

        public t() {
        }

        @Override // j8.y.s
        public void b(o8.i iVar, j8.z zVar, h8.g gVar, y.p pVar) {
            n.this.k0(new a(iVar, pVar));
        }

        @Override // j8.y.s
        public void a(o8.i iVar, j8.z zVar) {
        }
    }
}
