package m9;

import bb.a0;
import bb.d;
import bb.h;
import bb.w;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLHandshakeException;
import m9.a1;
import m9.b1;
import m9.y;
import rb.k1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set f16245d = new HashSet(Arrays.asList("date", "x-google-backends", "x-google-netmon-label", "x-google-service", "x-google-gfe-request-trace"));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0 f16246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n9.g f16247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f16248c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends y.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f16249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f16250b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource f16251c;

        public a(List list, List list2, TaskCompletionSource taskCompletionSource) {
            this.f16249a = list;
            this.f16250b = list2;
            this.f16251c = taskCompletionSource;
        }

        @Override // m9.y.e
        public void a(k1 k1Var) {
            if (k1Var.p()) {
                this.f16251c.trySetResult(Collections.EMPTY_LIST);
                return;
            }
            com.google.firebase.firestore.f fVarS = n9.g0.s(k1Var);
            if (fVarS.a() == f.a.UNAUTHENTICATED) {
                q.this.f16248c.h();
            }
            this.f16251c.trySetException(fVarS);
        }

        @Override // m9.y.e
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(bb.e eVar) {
            this.f16249a.add(eVar);
            if (this.f16249a.size() == this.f16250b.size()) {
                HashMap map = new HashMap();
                Iterator it = this.f16249a.iterator();
                while (it.hasNext()) {
                    j9.r rVarM = q.this.f16246a.m((bb.e) it.next());
                    map.put(rVarM.getKey(), rVarM);
                }
                ArrayList arrayList = new ArrayList();
                Iterator it2 = this.f16250b.iterator();
                while (it2.hasNext()) {
                    arrayList.add((j9.r) map.get((j9.k) it2.next()));
                }
                this.f16251c.trySetResult(arrayList);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16253a;

        static {
            int[] iArr = new int[f.a.values().length];
            f16253a = iArr;
            try {
                iArr[f.a.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16253a[f.a.CANCELLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16253a[f.a.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16253a[f.a.DEADLINE_EXCEEDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16253a[f.a.RESOURCE_EXHAUSTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16253a[f.a.INTERNAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f16253a[f.a.UNAVAILABLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f16253a[f.a.UNAUTHENTICATED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f16253a[f.a.INVALID_ARGUMENT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f16253a[f.a.NOT_FOUND.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f16253a[f.a.ALREADY_EXISTS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f16253a[f.a.PERMISSION_DENIED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f16253a[f.a.FAILED_PRECONDITION.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f16253a[f.a.ABORTED.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f16253a[f.a.OUT_OF_RANGE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f16253a[f.a.UNIMPLEMENTED.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f16253a[f.a.DATA_LOSS.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public q(n9.g gVar, o0 o0Var, y yVar) {
        this.f16247b = gVar;
        this.f16246a = o0Var;
        this.f16248c = yVar;
    }

    public static /* synthetic */ List a(q qVar, Task task) throws Exception {
        qVar.getClass();
        if (!task.isSuccessful()) {
            if ((task.getException() instanceof com.google.firebase.firestore.f) && ((com.google.firebase.firestore.f) task.getException()).a() == f.a.UNAUTHENTICATED) {
                qVar.f16248c.h();
            }
            throw task.getException();
        }
        bb.i iVar = (bb.i) task.getResult();
        j9.v vVarY = qVar.f16246a.y(iVar.a0());
        int iD0 = iVar.d0();
        ArrayList arrayList = new ArrayList(iD0);
        for (int i10 = 0; i10 < iD0; i10++) {
            arrayList.add(qVar.f16246a.p(iVar.c0(i10), vVarY));
        }
        return arrayList;
    }

    public static /* synthetic */ Map b(q qVar, HashMap map, Task task) throws Exception {
        qVar.getClass();
        if (!task.isSuccessful()) {
            if ((task.getException() instanceof com.google.firebase.firestore.f) && ((com.google.firebase.firestore.f) task.getException()).a() == f.a.UNAUTHENTICATED) {
                qVar.f16248c.h();
            }
            throw task.getException();
        }
        HashMap map2 = new HashMap();
        for (Map.Entry entry : ((bb.x) task.getResult()).b0().a0().entrySet()) {
            n9.b.d(map.containsKey(entry.getKey()), "%s not present in aliasMap", entry.getKey());
            map2.put((String) map.get(entry.getKey()), (bb.d0) entry.getValue());
        }
        return map2;
    }

    public static boolean g(k1 k1Var) {
        k1Var.n();
        Throwable thM = k1Var.m();
        if (!(thM instanceof SSLHandshakeException)) {
            return false;
        }
        thM.getMessage().contains("no ciphers available");
        return false;
    }

    public static boolean h(f.a aVar) {
        switch (b.f16253a[aVar.ordinal()]) {
            case 1:
                throw new IllegalArgumentException("Treated status OK as error");
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return false;
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return true;
            default:
                throw new IllegalArgumentException("Unknown gRPC status code: " + aVar);
        }
    }

    public static boolean i(k1 k1Var) {
        return h(f.a.c(k1Var.n().c()));
    }

    public static boolean j(k1 k1Var) {
        return i(k1Var) && !k1Var.n().equals(k1.b.ABORTED);
    }

    public Task d(List list) {
        h.b bVarF0 = bb.h.f0();
        bVarF0.y(this.f16246a.a());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            bVarF0.x(this.f16246a.O((k9.f) it.next()));
        }
        return this.f16248c.k(bb.r.b(), (bb.h) bVarF0.n()).continueWith(this.f16247b.o(), new Continuation() { // from class: m9.p
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return q.a(this.f16243a, task);
            }
        });
    }

    public a1 e(a1.a aVar) {
        return new a1(this.f16248c, this.f16247b, this.f16246a, aVar);
    }

    public b1 f(b1.a aVar) {
        return new b1(this.f16248c, this.f16247b, this.f16246a, aVar);
    }

    public Task k(List list) {
        d.b bVarF0 = bb.d.f0();
        bVarF0.y(this.f16246a.a());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            bVarF0.x(this.f16246a.L((j9.k) it.next()));
        }
        ArrayList arrayList = new ArrayList();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f16248c.l(bb.r.a(), (bb.d) bVarF0.n(), new a(arrayList, list, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public Task l(g9.b1 b1Var, List list) {
        a0.d dVarS = this.f16246a.S(b1Var.C());
        final HashMap map = new HashMap();
        bb.y yVarU = this.f16246a.U(dVarS, list, map);
        w.b bVarD0 = bb.w.d0();
        bVarD0.x(dVarS.d0());
        bVarD0.y(yVarU);
        return this.f16248c.k(bb.r.d(), (bb.w) bVarD0.n()).continueWith(this.f16247b.o(), new Continuation() { // from class: m9.o
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return q.b(this.f16226a, map, task);
            }
        });
    }

    public void m() {
        this.f16248c.n();
    }
}
