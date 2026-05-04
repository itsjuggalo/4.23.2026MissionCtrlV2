package g9;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.f;
import g9.v0;
import g9.w1;
import g9.y1;
import i9.n4;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import m9.s0;
import rb.k1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f1 implements s0.c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f10190o = "f1";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i9.k0 f10191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m9.s0 f10192b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10195e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public e9.j f10203m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public c f10204n;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f10193c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f10194d = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedHashSet f10196f = new LinkedHashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map f10197g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f10198h = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final i9.n1 f10199i = new i9.n1();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map f10200j = new HashMap();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final h1 f10202l = h1.a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map f10201k = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10205a;

        static {
            int[] iArr = new int[v0.a.values().length];
            f10205a = iArr;
            try {
                iArr[v0.a.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10205a[v0.a.REMOVED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j9.k f10206a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f10207b;

        public b(j9.k kVar) {
            this.f10206a = kVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface c {
        void a(z0 z0Var);

        void b(b1 b1Var, rb.k1 k1Var);

        void c(List list);
    }

    public f1(i9.k0 k0Var, m9.s0 s0Var, e9.j jVar, int i10) {
        this.f10191a = k0Var;
        this.f10192b = s0Var;
        this.f10195e = i10;
        this.f10203m = jVar;
    }

    public void A(b1 b1Var) {
        h("stopListeningToRemoteStore");
        d1 d1Var = (d1) this.f10193c.get(b1Var);
        n9.b.d(d1Var != null, "Trying to stop listening to a query not found", new Object[0]);
        int iB = d1Var.b();
        List list = (List) this.f10194d.get(Integer.valueOf(iB));
        list.remove(b1Var);
        if (list.isEmpty()) {
            this.f10192b.Q(iB);
        }
    }

    public final void B(v0 v0Var) {
        j9.k kVarA = v0Var.a();
        if (this.f10197g.containsKey(kVarA) || this.f10196f.contains(kVarA)) {
            return;
        }
        n9.v.a(f10190o, "New document in limbo: %s", kVarA);
        this.f10196f.add(kVarA);
        s();
    }

    public Task C(n9.g gVar, d9.w1 w1Var, n9.t tVar) {
        return new o1(gVar, this.f10192b, w1Var, tVar).f();
    }

    public final void D(List list, int i10) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            v0 v0Var = (v0) it.next();
            int i11 = a.f10205a[v0Var.b().ordinal()];
            if (i11 == 1) {
                this.f10199i.a(v0Var.a(), i10);
                B(v0Var);
            } else {
                if (i11 != 2) {
                    throw n9.b.a("Unknown limbo change type: %s", v0Var.b());
                }
                n9.v.a(f10190o, "Document no longer in limbo: %s", v0Var.a());
                j9.k kVarA = v0Var.a();
                this.f10199i.f(kVarA, i10);
                if (!this.f10199i.c(kVarA)) {
                    v(kVarA);
                }
            }
        }
    }

    public void E(List list, TaskCompletionSource taskCompletionSource) {
        h("writeMutations");
        i9.n nVarB0 = this.f10191a.b0(list);
        g(nVarB0.b(), taskCompletionSource);
        i(nVarB0.c(), null);
        this.f10192b.t();
    }

    @Override // m9.s0.c
    public void a(z0 z0Var) {
        h("handleOnlineStateChange");
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f10193c.entrySet().iterator();
        while (it.hasNext()) {
            x1 x1VarE = ((d1) ((Map.Entry) it.next()).getValue()).c().e(z0Var);
            n9.b.d(x1VarE.a().isEmpty(), "OnlineState should not affect limbo documents.", new Object[0]);
            if (x1VarE.b() != null) {
                arrayList.add(x1VarE.b());
            }
        }
        this.f10204n.c(arrayList);
        this.f10204n.a(z0Var);
    }

    @Override // m9.s0.c
    public g8.e b(int i10) {
        b bVar = (b) this.f10198h.get(Integer.valueOf(i10));
        if (bVar != null && bVar.f10207b) {
            return j9.k.h().e(bVar.f10206a);
        }
        g8.e eVarH = j9.k.h();
        if (this.f10194d.containsKey(Integer.valueOf(i10))) {
            for (b1 b1Var : (List) this.f10194d.get(Integer.valueOf(i10))) {
                if (this.f10193c.containsKey(b1Var)) {
                    eVarH = eVarH.p(((d1) this.f10193c.get(b1Var)).c().k());
                }
            }
        }
        return eVarH;
    }

    @Override // m9.s0.c
    public void c(k9.h hVar) {
        h("handleSuccessfulWrite");
        r(hVar.b().e(), null);
        w(hVar.b().e());
        i(this.f10191a.v(hVar), null);
    }

    @Override // m9.s0.c
    public void d(m9.n0 n0Var) {
        h("handleRemoteEvent");
        for (Map.Entry entry : n0Var.d().entrySet()) {
            Integer num = (Integer) entry.getKey();
            m9.v0 v0Var = (m9.v0) entry.getValue();
            b bVar = (b) this.f10198h.get(num);
            if (bVar != null) {
                n9.b.d((v0Var.b().size() + v0Var.c().size()) + v0Var.d().size() <= 1, "Limbo resolution for single document contains multiple changes.", new Object[0]);
                if (v0Var.b().size() > 0) {
                    bVar.f10207b = true;
                } else if (v0Var.c().size() > 0) {
                    n9.b.d(bVar.f10207b, "Received change for limbo target document without add.", new Object[0]);
                } else if (v0Var.d().size() > 0) {
                    n9.b.d(bVar.f10207b, "Received remove for limbo target document without add.", new Object[0]);
                    bVar.f10207b = false;
                }
            }
        }
        i(this.f10191a.x(n0Var), n0Var);
    }

    @Override // m9.s0.c
    public void e(int i10, rb.k1 k1Var) {
        h("handleRejectedListen");
        b bVar = (b) this.f10198h.get(Integer.valueOf(i10));
        j9.k kVar = bVar != null ? bVar.f10206a : null;
        if (kVar == null) {
            this.f10191a.U(i10);
            u(i10, k1Var);
            return;
        }
        this.f10197g.remove(kVar);
        this.f10198h.remove(Integer.valueOf(i10));
        s();
        j9.v vVar = j9.v.f14278b;
        Map mapSingletonMap = Collections.singletonMap(kVar, j9.r.r(kVar, vVar));
        Set setSingleton = Collections.singleton(kVar);
        Map map = Collections.EMPTY_MAP;
        d(new m9.n0(vVar, map, map, mapSingletonMap, setSingleton));
    }

    @Override // m9.s0.c
    public void f(int i10, rb.k1 k1Var) {
        h("handleRejectedWrite");
        g8.c cVarT = this.f10191a.T(i10);
        if (!cVarT.isEmpty()) {
            q(k1Var, "Write failed at %s", ((j9.k) cVarT.f()).s());
        }
        r(i10, k1Var);
        w(i10);
        i(cVarT, null);
    }

    public final void g(int i10, TaskCompletionSource taskCompletionSource) {
        Map map = (Map) this.f10200j.get(this.f10203m);
        if (map == null) {
            map = new HashMap();
            this.f10200j.put(this.f10203m, map);
        }
        map.put(Integer.valueOf(i10), taskCompletionSource);
    }

    public final void h(String str) {
        n9.b.d(this.f10204n != null, "Trying to call %s before setting callback", str);
    }

    public final void i(g8.c cVar, m9.n0 n0Var) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = this.f10193c.entrySet().iterator();
        while (it.hasNext()) {
            d1 d1Var = (d1) ((Map.Entry) it.next()).getValue();
            w1 w1VarC = d1Var.c();
            w1.b bVarH = w1VarC.h(cVar);
            boolean z10 = false;
            if (bVarH.b()) {
                bVarH = w1VarC.i(this.f10191a.C(d1Var.a(), false).a(), bVarH);
            }
            m9.v0 v0Var = n0Var == null ? null : (m9.v0) n0Var.d().get(Integer.valueOf(d1Var.b()));
            if (n0Var != null && n0Var.e().get(Integer.valueOf(d1Var.b())) != null) {
                z10 = true;
            }
            x1 x1VarD = d1Var.c().d(bVarH, v0Var, z10);
            D(x1VarD.a(), d1Var.b());
            if (x1VarD.b() != null) {
                arrayList.add(x1VarD.b());
                arrayList2.add(i9.l0.a(d1Var.b(), x1VarD.b()));
            }
        }
        this.f10204n.c(arrayList);
        this.f10191a.Q(arrayList2);
    }

    public final boolean j(rb.k1 k1Var) {
        k1.b bVarN = k1Var.n();
        return (bVarN == k1.b.FAILED_PRECONDITION && (k1Var.o() != null ? k1Var.o() : "").contains("requires an index")) || bVarN == k1.b.PERMISSION_DENIED;
    }

    public final void k() {
        Iterator it = this.f10201k.entrySet().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((List) ((Map.Entry) it.next()).getValue()).iterator();
            while (it2.hasNext()) {
                ((TaskCompletionSource) it2.next()).setException(new com.google.firebase.firestore.f("'waitForPendingWrites' task is cancelled due to User change.", f.a.CANCELLED));
            }
        }
        this.f10201k.clear();
    }

    public void l(e9.j jVar) {
        boolean zEquals = this.f10203m.equals(jVar);
        this.f10203m = jVar;
        if (!zEquals) {
            k();
            i(this.f10191a.M(jVar), null);
        }
        this.f10192b.u();
    }

    public final y1 m(b1 b1Var, int i10, com.google.protobuf.i iVar) {
        i9.l1 l1VarC = this.f10191a.C(b1Var, true);
        y1.a aVarJ = y1.a.NONE;
        if (this.f10194d.get(Integer.valueOf(i10)) != null) {
            aVarJ = ((d1) this.f10193c.get((b1) ((List) this.f10194d.get(Integer.valueOf(i10))).get(0))).c().j();
        }
        m9.v0 v0VarA = m9.v0.a(aVarJ == y1.a.SYNCED, iVar);
        w1 w1Var = new w1(b1Var, l1VarC.b());
        x1 x1VarC = w1Var.c(w1Var.h(l1VarC.a()), v0VarA);
        D(x1VarC.a(), i10);
        this.f10193c.put(b1Var, new d1(b1Var, i10, w1Var));
        if (!this.f10194d.containsKey(Integer.valueOf(i10))) {
            this.f10194d.put(Integer.valueOf(i10), new ArrayList(1));
        }
        ((List) this.f10194d.get(Integer.valueOf(i10))).add(b1Var);
        return x1VarC.b();
    }

    public int n(b1 b1Var, boolean z10) {
        h("listen");
        n9.b.d(!this.f10193c.containsKey(b1Var), "We already listen to query: %s", b1Var);
        n4 n4VarW = this.f10191a.w(b1Var.D());
        this.f10204n.c(Collections.singletonList(m(b1Var, n4VarW.h(), n4VarW.d())));
        if (z10) {
            this.f10192b.D(n4VarW);
        }
        return n4VarW.h();
    }

    public void o(b1 b1Var) {
        h("listenToRemoteStore");
        n9.b.d(this.f10193c.containsKey(b1Var), "This is the first listen to query: %s", b1Var);
        this.f10192b.D(this.f10191a.w(b1Var.D()));
    }

    public void p(f9.f fVar, d9.v0 v0Var) {
        try {
            try {
                f9.e eVarD = fVar.d();
                if (this.f10191a.N(eVarD)) {
                    v0Var.e(d9.w0.b(eVarD));
                    try {
                        return;
                    } catch (IOException e10) {
                        return;
                    }
                }
                v0Var.f(d9.w0.a(eVarD));
                f9.d dVar = new f9.d(this.f10191a, eVarD);
                long j10 = 0;
                while (true) {
                    f9.c cVarF = fVar.f();
                    if (cVarF == null) {
                        i(dVar.b(), null);
                        this.f10191a.c(eVarD);
                        v0Var.e(d9.w0.b(eVarD));
                        try {
                            fVar.b();
                            return;
                        } catch (IOException e11) {
                            n9.v.e("SyncEngine", "Exception while closing bundle", e11);
                            return;
                        }
                    }
                    long jE = fVar.e();
                    d9.w0 w0VarA = dVar.a(cVarF, jE - j10);
                    if (w0VarA != null) {
                        v0Var.f(w0VarA);
                    }
                    j10 = jE;
                }
            } catch (Exception e12) {
                n9.v.e("Firestore", "Loading bundle failed : %s", e12);
                v0Var.d(new com.google.firebase.firestore.f("Bundle failed to load", f.a.INVALID_ARGUMENT, e12));
                try {
                    fVar.b();
                } catch (IOException e13) {
                    n9.v.e("SyncEngine", "Exception while closing bundle", e13);
                }
            }
        } finally {
            try {
                fVar.b();
            } catch (IOException e102) {
                n9.v.e("SyncEngine", "Exception while closing bundle", e102);
            }
        }
    }

    public final void q(rb.k1 k1Var, String str, Object... objArr) {
        if (j(k1Var)) {
            n9.v.e("Firestore", "%s: %s", String.format(str, objArr), k1Var);
        }
    }

    public final void r(int i10, rb.k1 k1Var) {
        Map map = (Map) this.f10200j.get(this.f10203m);
        if (map != null) {
            Integer numValueOf = Integer.valueOf(i10);
            TaskCompletionSource taskCompletionSource = (TaskCompletionSource) map.get(numValueOf);
            if (taskCompletionSource != null) {
                if (k1Var != null) {
                    taskCompletionSource.setException(n9.g0.s(k1Var));
                } else {
                    taskCompletionSource.setResult(null);
                }
                map.remove(numValueOf);
            }
        }
    }

    public final void s() {
        while (!this.f10196f.isEmpty() && this.f10197g.size() < this.f10195e) {
            Iterator it = this.f10196f.iterator();
            j9.k kVar = (j9.k) it.next();
            it.remove();
            int iC = this.f10202l.c();
            this.f10198h.put(Integer.valueOf(iC), new b(kVar));
            this.f10197g.put(kVar, Integer.valueOf(iC));
            this.f10192b.D(new n4(b1.b(kVar.s()).D(), iC, -1L, i9.k1.LIMBO_RESOLUTION));
        }
    }

    public void t(TaskCompletionSource taskCompletionSource) {
        if (!this.f10192b.n()) {
            n9.v.a(f10190o, "The network is disabled. The task returned by 'awaitPendingWrites()' will not complete until the network is enabled.", new Object[0]);
        }
        int iD = this.f10191a.D();
        if (iD == -1) {
            taskCompletionSource.setResult(null);
            return;
        }
        if (!this.f10201k.containsKey(Integer.valueOf(iD))) {
            this.f10201k.put(Integer.valueOf(iD), new ArrayList());
        }
        ((List) this.f10201k.get(Integer.valueOf(iD))).add(taskCompletionSource);
    }

    public final void u(int i10, rb.k1 k1Var) {
        for (b1 b1Var : (List) this.f10194d.get(Integer.valueOf(i10))) {
            this.f10193c.remove(b1Var);
            if (!k1Var.p()) {
                this.f10204n.b(b1Var, k1Var);
                q(k1Var, "Listen for %s failed", b1Var);
            }
        }
        this.f10194d.remove(Integer.valueOf(i10));
        g8.e<j9.k> eVarD = this.f10199i.d(i10);
        this.f10199i.h(i10);
        for (j9.k kVar : eVarD) {
            if (!this.f10199i.c(kVar)) {
                v(kVar);
            }
        }
    }

    public final void v(j9.k kVar) {
        this.f10196f.remove(kVar);
        Integer num = (Integer) this.f10197g.get(kVar);
        if (num != null) {
            this.f10192b.Q(num.intValue());
            this.f10197g.remove(kVar);
            this.f10198h.remove(num);
            s();
        }
    }

    public final void w(int i10) {
        if (this.f10201k.containsKey(Integer.valueOf(i10))) {
            Iterator it = ((List) this.f10201k.get(Integer.valueOf(i10))).iterator();
            while (it.hasNext()) {
                ((TaskCompletionSource) it.next()).setResult(null);
            }
            this.f10201k.remove(Integer.valueOf(i10));
        }
    }

    public Task x(b1 b1Var, List list) {
        return this.f10192b.H(b1Var, list);
    }

    public void y(c cVar) {
        this.f10204n = cVar;
    }

    public void z(b1 b1Var, boolean z10) {
        h("stopListening");
        d1 d1Var = (d1) this.f10193c.get(b1Var);
        n9.b.d(d1Var != null, "Trying to stop listening to a query not found", new Object[0]);
        this.f10193c.remove(b1Var);
        int iB = d1Var.b();
        List list = (List) this.f10194d.get(Integer.valueOf(iB));
        list.remove(b1Var);
        if (list.isEmpty()) {
            this.f10191a.U(iB);
            if (z10) {
                this.f10192b.Q(iB);
            }
            u(iB, rb.k1.f19592e);
        }
    }
}
