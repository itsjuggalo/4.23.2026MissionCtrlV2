package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C0909m;
import com.google.android.gms.common.internal.AbstractC0931i;
import com.google.android.gms.common.internal.AbstractC0945x;
import com.google.android.gms.common.internal.C0938p;
import com.google.android.gms.common.internal.C0941t;
import com.google.android.gms.common.internal.C0942u;
import com.google.android.gms.common.internal.C0944w;
import com.google.android.gms.common.internal.InterfaceC0946y;
import com.google.android.gms.internal.base.zau;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import p2.C1698D;
import u.C1854b;
import z1.C1984b;
import z1.C1988f;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0904h implements Handler.Callback {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Status f9771p = new Status(4, "Sign-out occurred while this API call was in progress.");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Status f9772q = new Status(4, "The user must be signed in to make this API call.");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Object f9773r = new Object();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static C0904h f9774s;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C0944w f9777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InterfaceC0946y f9778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f9779e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C1988f f9780f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.google.android.gms.common.internal.K f9781g;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Handler f9788n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f9789o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f9775a = 10000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9776b = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicInteger f9782h = new AtomicInteger(1);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicInteger f9783i = new AtomicInteger(0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map f9784j = new ConcurrentHashMap(5, 0.75f, 1);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public F f9785k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Set f9786l = new C1854b();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Set f9787m = new C1854b();

    public C0904h(Context context, Looper looper, C1988f c1988f) {
        this.f9789o = true;
        this.f9779e = context;
        zau zauVar = new zau(looper, this);
        this.f9788n = zauVar;
        this.f9780f = c1988f;
        this.f9781g = new com.google.android.gms.common.internal.K(c1988f);
        if (G1.h.a(context)) {
            this.f9789o = false;
        }
        zauVar.sendMessage(zauVar.obtainMessage(6));
    }

    public static void a() {
        synchronized (f9773r) {
            try {
                C0904h c0904h = f9774s;
                if (c0904h != null) {
                    c0904h.f9783i.incrementAndGet();
                    Handler handler = c0904h.f9788n;
                    handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Status g(C0898c c0898c, C1984b c1984b) {
        return new Status(c1984b, "API: " + c0898c.b() + " is not available on this device. Connection failed with: " + String.valueOf(c1984b));
    }

    public static C0904h u(Context context) {
        C0904h c0904h;
        synchronized (f9773r) {
            try {
                if (f9774s == null) {
                    f9774s = new C0904h(context.getApplicationContext(), AbstractC0931i.c().getLooper(), C1988f.n());
                }
                c0904h = f9774s;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0904h;
    }

    public final void C(com.google.android.gms.common.api.e eVar, int i4, AbstractC0901e abstractC0901e) {
        this.f9788n.sendMessage(this.f9788n.obtainMessage(4, new d0(new p0(i4, abstractC0901e), this.f9783i.get(), eVar)));
    }

    public final void D(com.google.android.gms.common.api.e eVar, int i4, AbstractC0920y abstractC0920y, TaskCompletionSource taskCompletionSource, InterfaceC0918w interfaceC0918w) {
        k(taskCompletionSource, abstractC0920y.d(), eVar);
        this.f9788n.sendMessage(this.f9788n.obtainMessage(4, new d0(new q0(i4, abstractC0920y, taskCompletionSource, interfaceC0918w), this.f9783i.get(), eVar)));
    }

    public final void E(C0938p c0938p, int i4, long j4, int i5) {
        this.f9788n.sendMessage(this.f9788n.obtainMessage(18, new C0899c0(c0938p, i4, j4, i5)));
    }

    public final void F(C1984b c1984b, int i4) {
        if (f(c1984b, i4)) {
            return;
        }
        Handler handler = this.f9788n;
        handler.sendMessage(handler.obtainMessage(5, i4, 0, c1984b));
    }

    public final void G() {
        Handler handler = this.f9788n;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void H(com.google.android.gms.common.api.e eVar) {
        Handler handler = this.f9788n;
        handler.sendMessage(handler.obtainMessage(7, eVar));
    }

    public final void b(F f4) {
        synchronized (f9773r) {
            try {
                if (this.f9785k != f4) {
                    this.f9785k = f4;
                    this.f9786l.clear();
                }
                this.f9786l.addAll(f4.i());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(F f4) {
        synchronized (f9773r) {
            try {
                if (this.f9785k == f4) {
                    this.f9785k = null;
                    this.f9786l.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean e() {
        if (this.f9776b) {
            return false;
        }
        C0942u c0942uA = C0941t.b().a();
        if (c0942uA != null && !c0942uA.l()) {
            return false;
        }
        int iA = this.f9781g.a(this.f9779e, 203400000);
        return iA == -1 || iA == 0;
    }

    public final boolean f(C1984b c1984b, int i4) {
        return this.f9780f.x(this.f9779e, c1984b, i4);
    }

    public final P h(com.google.android.gms.common.api.e eVar) {
        Map map = this.f9784j;
        C0898c apiKey = eVar.getApiKey();
        P p4 = (P) map.get(apiKey);
        if (p4 == null) {
            p4 = new P(this, eVar);
            this.f9784j.put(apiKey, p4);
        }
        if (p4.a()) {
            this.f9787m.add(apiKey);
        }
        p4.E();
        return p4;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i4 = message.what;
        P p4 = null;
        switch (i4) {
            case 1:
                this.f9775a = true == ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.f9788n.removeMessages(12);
                for (C0898c c0898c : this.f9784j.keySet()) {
                    Handler handler = this.f9788n;
                    handler.sendMessageDelayed(handler.obtainMessage(12, c0898c), this.f9775a);
                }
                return true;
            case 2:
                android.support.v4.media.session.b.a(message.obj);
                throw null;
            case 3:
                for (P p5 : this.f9784j.values()) {
                    p5.D();
                    p5.E();
                }
                return true;
            case 4:
            case 8:
            case 13:
                d0 d0Var = (d0) message.obj;
                P pH = (P) this.f9784j.get(d0Var.f9766c.getApiKey());
                if (pH == null) {
                    pH = h(d0Var.f9766c);
                }
                if (!pH.a() || this.f9783i.get() == d0Var.f9765b) {
                    pH.F(d0Var.f9764a);
                } else {
                    d0Var.f9764a.a(f9771p);
                    pH.K();
                }
                return true;
            case 5:
                int i5 = message.arg1;
                C1984b c1984b = (C1984b) message.obj;
                Iterator it = this.f9784j.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        P p6 = (P) it.next();
                        if (p6.s() == i5) {
                            p4 = p6;
                        }
                    }
                }
                if (p4 == null) {
                    Log.wtf("GoogleApiManager", "Could not find API instance " + i5 + " while trying to fail enqueued calls.", new Exception());
                } else if (c1984b.i() == 13) {
                    p4.h(new Status(17, "Error resolution was canceled by the user, original error message: " + this.f9780f.e(c1984b.i()) + ": " + c1984b.k()));
                } else {
                    p4.h(g(p4.f9720c, c1984b));
                }
                return true;
            case 6:
                if (this.f9779e.getApplicationContext() instanceof Application) {
                    ComponentCallbacks2C0900d.c((Application) this.f9779e.getApplicationContext());
                    ComponentCallbacks2C0900d.b().a(new K(this));
                    if (!ComponentCallbacks2C0900d.b().e(true)) {
                        this.f9775a = 300000L;
                    }
                }
                return true;
            case 7:
                h((com.google.android.gms.common.api.e) message.obj);
                return true;
            case 9:
                if (this.f9784j.containsKey(message.obj)) {
                    ((P) this.f9784j.get(message.obj)).J();
                }
                return true;
            case 10:
                Iterator it2 = this.f9787m.iterator();
                while (it2.hasNext()) {
                    P p7 = (P) this.f9784j.remove((C0898c) it2.next());
                    if (p7 != null) {
                        p7.K();
                    }
                }
                this.f9787m.clear();
                return true;
            case 11:
                if (this.f9784j.containsKey(message.obj)) {
                    ((P) this.f9784j.get(message.obj)).L();
                }
                return true;
            case 12:
                if (this.f9784j.containsKey(message.obj)) {
                    ((P) this.f9784j.get(message.obj)).d();
                }
                return true;
            case 14:
                G g4 = (G) message.obj;
                C0898c c0898cA = g4.a();
                if (this.f9784j.containsKey(c0898cA)) {
                    g4.b().setResult(Boolean.valueOf(((P) this.f9784j.get(c0898cA)).r(false)));
                } else {
                    g4.b().setResult(Boolean.FALSE);
                }
                return true;
            case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                S s4 = (S) message.obj;
                if (this.f9784j.containsKey(s4.f9731a)) {
                    P.B((P) this.f9784j.get(s4.f9731a), s4);
                }
                return true;
            case 16:
                S s5 = (S) message.obj;
                if (this.f9784j.containsKey(s5.f9731a)) {
                    P.C((P) this.f9784j.get(s5.f9731a), s5);
                }
                return true;
            case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                j();
                return true;
            case C1698D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                C0899c0 c0899c0 = (C0899c0) message.obj;
                if (c0899c0.f9757c == 0) {
                    i().a(new C0944w(c0899c0.f9756b, Arrays.asList(c0899c0.f9755a)));
                } else {
                    C0944w c0944w = this.f9777c;
                    if (c0944w != null) {
                        List listK = c0944w.k();
                        if (c0944w.i() != c0899c0.f9756b || (listK != null && listK.size() >= c0899c0.f9758d)) {
                            this.f9788n.removeMessages(17);
                            j();
                        } else {
                            this.f9777c.l(c0899c0.f9755a);
                        }
                    }
                    if (this.f9777c == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(c0899c0.f9755a);
                        this.f9777c = new C0944w(c0899c0.f9756b, arrayList);
                        Handler handler2 = this.f9788n;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), c0899c0.f9757c);
                    }
                }
                return true;
            case 19:
                this.f9776b = false;
                return true;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + i4);
                return false;
        }
    }

    public final InterfaceC0946y i() {
        if (this.f9778d == null) {
            this.f9778d = AbstractC0945x.a(this.f9779e);
        }
        return this.f9778d;
    }

    public final void j() {
        C0944w c0944w = this.f9777c;
        if (c0944w != null) {
            if (c0944w.i() > 0 || e()) {
                i().a(c0944w);
            }
            this.f9777c = null;
        }
    }

    public final void k(TaskCompletionSource taskCompletionSource, int i4, com.google.android.gms.common.api.e eVar) {
        C0897b0 c0897b0A;
        if (i4 == 0 || (c0897b0A = C0897b0.a(this, i4, eVar.getApiKey())) == null) {
            return;
        }
        Task task = taskCompletionSource.getTask();
        final Handler handler = this.f9788n;
        handler.getClass();
        task.addOnCompleteListener(new Executor() { // from class: com.google.android.gms.common.api.internal.J
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        }, c0897b0A);
    }

    public final int l() {
        return this.f9782h.getAndIncrement();
    }

    public final P t(C0898c c0898c) {
        return (P) this.f9784j.get(c0898c);
    }

    public final Task w(com.google.android.gms.common.api.e eVar) {
        G g4 = new G(eVar.getApiKey());
        this.f9788n.sendMessage(this.f9788n.obtainMessage(14, g4));
        return g4.b().getTask();
    }

    public final Task x(com.google.android.gms.common.api.e eVar, C0909m.a aVar, int i4) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        k(taskCompletionSource, i4, eVar);
        this.f9788n.sendMessage(this.f9788n.obtainMessage(13, new d0(new r0(aVar, taskCompletionSource), this.f9783i.get(), eVar)));
        return taskCompletionSource.getTask();
    }
}
