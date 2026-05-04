package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.internal.base.zao;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g implements Handler.Callback {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static g f5546s;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.google.android.gms.common.internal.w f5550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.google.android.gms.common.internal.y f5551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f5552e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m5.e f5553f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.google.android.gms.common.internal.i0 f5554g;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Handler f5561n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f5562o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Status f5543p = new Status(4, "Sign-out occurred while this API call was in progress.");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Status f5544q = new Status(4, "The user must be signed in to make this API call.");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Object f5545r = new Object();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static volatile boolean f5547t = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f5548a = 10000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5549b = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicInteger f5555h = new AtomicInteger(1);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicInteger f5556i = new AtomicInteger(0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map f5557j = new ConcurrentHashMap(5, 0.75f, 1);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public z f5558k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Set f5559l = new w.b();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Set f5560m = new w.b();

    public g(Context context, Looper looper, m5.e eVar) {
        this.f5562o = true;
        this.f5552e = context;
        zao zaoVar = new zao(looper, this);
        this.f5561n = zaoVar;
        this.f5553f = eVar;
        this.f5554g = new com.google.android.gms.common.internal.i0(eVar);
        if (t5.i.a(context)) {
            this.f5562o = false;
        }
        zaoVar.sendMessage(zaoVar.obtainMessage(6));
    }

    public static void a() {
        synchronized (f5545r) {
            try {
                g gVar = f5546s;
                if (gVar != null) {
                    gVar.f5556i.incrementAndGet();
                    Handler handler = gVar.f5561n;
                    handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Status k(b bVar, m5.b bVar2) {
        String strB = bVar.b();
        String strValueOf = String.valueOf(bVar2);
        StringBuilder sb2 = new StringBuilder(String.valueOf(strB).length() + 63 + strValueOf.length());
        sb2.append("API: ");
        sb2.append(strB);
        sb2.append(" is not available on this device. Connection failed with: ");
        sb2.append(strValueOf);
        return new Status(bVar2, sb2.toString());
    }

    public static g n(Context context) {
        g gVar;
        synchronized (f5545r) {
            try {
                if (f5546s == null) {
                    f5546s = new g(context.getApplicationContext(), com.google.android.gms.common.internal.i.b().getLooper(), m5.e.n());
                    if (f5547t) {
                        final Handler handler = f5546s.f5561n;
                        Objects.requireNonNull(handler);
                        com.google.android.gms.common.internal.h.zag(new Executor() { // from class: com.google.android.gms.common.api.internal.l0
                            @Override // java.util.concurrent.Executor
                            public final /* synthetic */ void execute(Runnable runnable) {
                                handler.post(runnable);
                            }
                        });
                    }
                }
                gVar = f5546s;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    public final void A(m5.b bVar, int i10) {
        if (z(bVar, i10)) {
            return;
        }
        Handler handler = this.f5561n;
        handler.sendMessage(handler.obtainMessage(5, i10, 0, bVar));
    }

    public final void B(com.google.android.gms.common.internal.p pVar, int i10, long j10, int i11) {
        t0 t0Var = new t0(pVar, i10, j10, i11);
        Handler handler = this.f5561n;
        handler.sendMessage(handler.obtainMessage(18, t0Var));
    }

    public final /* synthetic */ long E() {
        return this.f5548a;
    }

    public final /* synthetic */ void F(boolean z10) {
        this.f5549b = true;
    }

    public final /* synthetic */ Context H() {
        return this.f5552e;
    }

    public final /* synthetic */ m5.e b() {
        return this.f5553f;
    }

    public final /* synthetic */ com.google.android.gms.common.internal.i0 c() {
        return this.f5554g;
    }

    public final /* synthetic */ Map d() {
        return this.f5557j;
    }

    public final /* synthetic */ z e() {
        return this.f5558k;
    }

    public final /* synthetic */ Set f() {
        return this.f5559l;
    }

    public final /* synthetic */ Handler g() {
        return this.f5561n;
    }

    public final /* synthetic */ boolean h() {
        return this.f5562o;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i10 = message.what;
        h0 h0Var = null;
        switch (i10) {
            case 1:
                this.f5548a = true == ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                Handler handler = this.f5561n;
                handler.removeMessages(12);
                Iterator it = this.f5557j.keySet().iterator();
                while (it.hasNext()) {
                    handler.sendMessageDelayed(handler.obtainMessage(12, (b) it.next()), this.f5548a);
                }
                return true;
            case 2:
                android.support.v4.media.session.b.a(message.obj);
                throw null;
            case 3:
                for (h0 h0Var2 : this.f5557j.values()) {
                    h0Var2.v();
                    h0Var2.z();
                }
                return true;
            case 4:
            case 8:
            case 13:
                v0 v0Var = (v0) message.obj;
                Map map = this.f5557j;
                com.google.android.gms.common.api.f fVar = v0Var.f5647c;
                h0 h0VarI = (h0) map.get(fVar.getApiKey());
                if (h0VarI == null) {
                    h0VarI = i(fVar);
                }
                if (!h0VarI.A() || this.f5556i.get() == v0Var.f5646b) {
                    h0VarI.r(v0Var.f5645a);
                } else {
                    v0Var.f5645a.a(f5543p);
                    h0VarI.s();
                }
                return true;
            case 5:
                int i11 = message.arg1;
                m5.b bVar = (m5.b) message.obj;
                Iterator it2 = this.f5557j.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        h0 h0Var3 = (h0) it2.next();
                        if (h0Var3.B() == i11) {
                            h0Var = h0Var3;
                        }
                    }
                }
                if (h0Var == null) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(i11).length() + 65);
                    sb2.append("Could not find API instance ");
                    sb2.append(i11);
                    sb2.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb2.toString(), new Exception());
                } else if (bVar.R() == 13) {
                    String strE = this.f5553f.e(bVar.R());
                    String strS = bVar.S();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(strE).length() + 69 + String.valueOf(strS).length());
                    sb3.append("Error resolution was canceled by the user, original error message: ");
                    sb3.append(strE);
                    sb3.append(": ");
                    sb3.append(strS);
                    h0Var.G(new Status(17, sb3.toString()));
                } else {
                    h0Var.G(k(h0Var.a(), bVar));
                }
                return true;
            case 6:
                Context context = this.f5552e;
                if (context.getApplicationContext() instanceof Application) {
                    c.c((Application) context.getApplicationContext());
                    c.b().a(new c0(this));
                    if (!c.b().e(true)) {
                        this.f5548a = 300000L;
                    }
                }
                return true;
            case 7:
                i((com.google.android.gms.common.api.f) message.obj);
                return true;
            case 9:
                Map map2 = this.f5557j;
                if (map2.containsKey(message.obj)) {
                    ((h0) map2.get(message.obj)).w();
                }
                return true;
            case 10:
                Set set = this.f5560m;
                Iterator it3 = set.iterator();
                while (it3.hasNext()) {
                    h0 h0Var4 = (h0) this.f5557j.remove((b) it3.next());
                    if (h0Var4 != null) {
                        h0Var4.s();
                    }
                }
                set.clear();
                return true;
            case 11:
                Map map3 = this.f5557j;
                if (map3.containsKey(message.obj)) {
                    ((h0) map3.get(message.obj)).x();
                }
                return true;
            case 12:
                Map map4 = this.f5557j;
                if (map4.containsKey(message.obj)) {
                    ((h0) map4.get(message.obj)).y();
                }
                return true;
            case 14:
                a0 a0Var = (a0) message.obj;
                b bVarA = a0Var.a();
                Map map5 = this.f5557j;
                if (map5.containsKey(bVarA)) {
                    a0Var.b().setResult(Boolean.valueOf(((h0) map5.get(bVarA)).H(false)));
                } else {
                    a0Var.b().setResult(Boolean.FALSE);
                }
                return true;
            case 15:
                i0 i0Var = (i0) message.obj;
                Map map6 = this.f5557j;
                if (map6.containsKey(i0Var.a())) {
                    ((h0) map6.get(i0Var.a())).I(i0Var);
                }
                return true;
            case 16:
                i0 i0Var2 = (i0) message.obj;
                Map map7 = this.f5557j;
                if (map7.containsKey(i0Var2.a())) {
                    ((h0) map7.get(i0Var2.a())).J(i0Var2);
                }
                return true;
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                l();
                return true;
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                t0 t0Var = (t0) message.obj;
                long j10 = t0Var.f5630c;
                if (j10 == 0) {
                    m().c(new com.google.android.gms.common.internal.w(t0Var.f5629b, Arrays.asList(t0Var.f5628a)));
                } else {
                    com.google.android.gms.common.internal.w wVar = this.f5550c;
                    if (wVar != null) {
                        List listS = wVar.S();
                        if (wVar.R() != t0Var.f5629b || (listS != null && listS.size() >= t0Var.f5631d)) {
                            this.f5561n.removeMessages(17);
                            l();
                        } else {
                            this.f5550c.T(t0Var.f5628a);
                        }
                    }
                    if (this.f5550c == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(t0Var.f5628a);
                        this.f5550c = new com.google.android.gms.common.internal.w(t0Var.f5629b, arrayList);
                        Handler handler2 = this.f5561n;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), j10);
                    }
                }
                return true;
            case 19:
                this.f5549b = false;
                return true;
            default:
                StringBuilder sb4 = new StringBuilder(String.valueOf(i10).length() + 20);
                sb4.append("Unknown message id: ");
                sb4.append(i10);
                Log.w("GoogleApiManager", sb4.toString());
                return false;
        }
    }

    public final h0 i(com.google.android.gms.common.api.f fVar) {
        Map map = this.f5557j;
        b apiKey = fVar.getApiKey();
        h0 h0Var = (h0) map.get(apiKey);
        if (h0Var == null) {
            h0Var = new h0(this, fVar);
            map.put(apiKey, h0Var);
        }
        if (h0Var.A()) {
            this.f5560m.add(apiKey);
        }
        h0Var.z();
        return h0Var;
    }

    public final void j(TaskCompletionSource taskCompletionSource, int i10, com.google.android.gms.common.api.f fVar) {
        s0 s0VarA;
        if (i10 == 0 || (s0VarA = s0.a(this, i10, fVar.getApiKey())) == null) {
            return;
        }
        Task task = taskCompletionSource.getTask();
        final Handler handler = this.f5561n;
        Objects.requireNonNull(handler);
        task.addOnCompleteListener(new Executor() { // from class: com.google.android.gms.common.api.internal.m0
            @Override // java.util.concurrent.Executor
            public final /* synthetic */ void execute(Runnable runnable) {
                handler.post(runnable);
            }
        }, s0VarA);
    }

    public final void l() {
        com.google.android.gms.common.internal.w wVar = this.f5550c;
        if (wVar != null) {
            if (wVar.R() > 0 || x()) {
                m().c(wVar);
            }
            this.f5550c = null;
        }
    }

    public final com.google.android.gms.common.internal.y m() {
        if (this.f5551d == null) {
            this.f5551d = com.google.android.gms.common.internal.x.a(this.f5552e);
        }
        return this.f5551d;
    }

    public final int o() {
        return this.f5555h.getAndIncrement();
    }

    public final void p(com.google.android.gms.common.api.f fVar) {
        Handler handler = this.f5561n;
        handler.sendMessage(handler.obtainMessage(7, fVar));
    }

    public final void q(z zVar) {
        synchronized (f5545r) {
            try {
                if (this.f5558k != zVar) {
                    this.f5558k = zVar;
                    this.f5559l.clear();
                }
                this.f5559l.addAll(zVar.j());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void r(z zVar) {
        synchronized (f5545r) {
            try {
                if (this.f5558k == zVar) {
                    this.f5558k = null;
                    this.f5559l.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final h0 s(b bVar) {
        return (h0) this.f5557j.get(bVar);
    }

    public final void t() {
        Handler handler = this.f5561n;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final Task u(com.google.android.gms.common.api.f fVar) {
        a0 a0Var = new a0(fVar.getApiKey());
        Handler handler = this.f5561n;
        handler.sendMessage(handler.obtainMessage(14, a0Var));
        return a0Var.b().getTask();
    }

    public final void v(com.google.android.gms.common.api.f fVar, int i10, d dVar) {
        v0 v0Var = new v0(new g1(i10, dVar), this.f5556i.get(), fVar);
        Handler handler = this.f5561n;
        handler.sendMessage(handler.obtainMessage(4, v0Var));
    }

    public final void w(com.google.android.gms.common.api.f fVar, int i10, v vVar, TaskCompletionSource taskCompletionSource, t tVar) {
        j(taskCompletionSource, vVar.e(), fVar);
        v0 v0Var = new v0(new h1(i10, vVar, taskCompletionSource, tVar), this.f5556i.get(), fVar);
        Handler handler = this.f5561n;
        handler.sendMessage(handler.obtainMessage(4, v0Var));
    }

    public final boolean x() {
        if (this.f5549b) {
            return false;
        }
        com.google.android.gms.common.internal.u uVarA = com.google.android.gms.common.internal.t.b().a();
        if (uVarA != null && !uVarA.T()) {
            return false;
        }
        int iB = this.f5554g.b(this.f5552e, 203400000);
        return iB == -1 || iB == 0;
    }

    public final Task y(com.google.android.gms.common.api.f fVar, l.a aVar, int i10) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        j(taskCompletionSource, i10, fVar);
        v0 v0Var = new v0(new i1(aVar, taskCompletionSource), this.f5556i.get(), fVar);
        Handler handler = this.f5561n;
        handler.sendMessage(handler.obtainMessage(13, v0Var));
        return taskCompletionSource.getTask();
    }

    public final boolean z(m5.b bVar, int i10) {
        return this.f5553f.t(this.f5552e, bVar, i10);
    }
}
