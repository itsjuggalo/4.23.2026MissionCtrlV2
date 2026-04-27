package com.google.android.gms.common.api.internal;

import P1.C0648b;
import P1.C0652f;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C1175l;
import com.google.android.gms.common.internal.AbstractC1198i;
import com.google.android.gms.common.internal.AbstractC1212x;
import com.google.android.gms.common.internal.C1205p;
import com.google.android.gms.common.internal.C1208t;
import com.google.android.gms.common.internal.C1209u;
import com.google.android.gms.common.internal.C1211w;
import com.google.android.gms.common.internal.InterfaceC1213y;
import com.google.android.gms.internal.base.zau;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import k4.C2105D;
import u.C2737b;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1170g implements Handler.Callback {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Status f10954p = new Status(4, "Sign-out occurred while this API call was in progress.");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Status f10955q = new Status(4, "The user must be signed in to make this API call.");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Object f10956r = new Object();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static C1170g f10957s;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C1211w f10960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InterfaceC1213y f10961d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f10962e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C0652f f10963f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.google.android.gms.common.internal.K f10964g;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Handler f10971n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f10972o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f10958a = 10000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10959b = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicInteger f10965h = new AtomicInteger(1);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicInteger f10966i = new AtomicInteger(0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map f10967j = new ConcurrentHashMap(5, 0.75f, 1);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public D f10968k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Set f10969l = new C2737b();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Set f10970m = new C2737b();

    public C1170g(Context context, Looper looper, C0652f c0652f) {
        this.f10972o = true;
        this.f10962e = context;
        zau zauVar = new zau(looper, this);
        this.f10971n = zauVar;
        this.f10963f = c0652f;
        this.f10964g = new com.google.android.gms.common.internal.K(c0652f);
        if (W1.h.a(context)) {
            this.f10972o = false;
        }
        zauVar.sendMessage(zauVar.obtainMessage(6));
    }

    public static void a() {
        synchronized (f10956r) {
            try {
                C1170g c1170g = f10957s;
                if (c1170g != null) {
                    c1170g.f10966i.incrementAndGet();
                    Handler handler = c1170g.f10971n;
                    handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Status g(C1165b c1165b, C0648b c0648b) {
        return new Status(c0648b, "API: " + c1165b.b() + " is not available on this device. Connection failed with: " + String.valueOf(c0648b));
    }

    public static C1170g u(Context context) {
        C1170g c1170g;
        synchronized (f10956r) {
            try {
                if (f10957s == null) {
                    f10957s = new C1170g(context.getApplicationContext(), AbstractC1198i.c().getLooper(), C0652f.n());
                }
                c1170g = f10957s;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c1170g;
    }

    public final void C(com.google.android.gms.common.api.e eVar, int i7, AbstractC1167d abstractC1167d) {
        this.f10971n.sendMessage(this.f10971n.obtainMessage(4, new a0(new m0(i7, abstractC1167d), this.f10966i.get(), eVar)));
    }

    public final void D(com.google.android.gms.common.api.e eVar, int i7, AbstractC1186x abstractC1186x, TaskCompletionSource taskCompletionSource, InterfaceC1184v interfaceC1184v) {
        k(taskCompletionSource, abstractC1186x.d(), eVar);
        this.f10971n.sendMessage(this.f10971n.obtainMessage(4, new a0(new n0(i7, abstractC1186x, taskCompletionSource, interfaceC1184v), this.f10966i.get(), eVar)));
    }

    public final void E(C1205p c1205p, int i7, long j7, int i8) {
        this.f10971n.sendMessage(this.f10971n.obtainMessage(18, new Z(c1205p, i7, j7, i8)));
    }

    public final void F(C0648b c0648b, int i7) {
        if (f(c0648b, i7)) {
            return;
        }
        Handler handler = this.f10971n;
        handler.sendMessage(handler.obtainMessage(5, i7, 0, c0648b));
    }

    public final void G() {
        Handler handler = this.f10971n;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void H(com.google.android.gms.common.api.e eVar) {
        Handler handler = this.f10971n;
        handler.sendMessage(handler.obtainMessage(7, eVar));
    }

    public final void b(D d7) {
        synchronized (f10956r) {
            try {
                if (this.f10968k != d7) {
                    this.f10968k = d7;
                    this.f10969l.clear();
                }
                this.f10969l.addAll(d7.i());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(D d7) {
        synchronized (f10956r) {
            try {
                if (this.f10968k == d7) {
                    this.f10968k = null;
                    this.f10969l.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean e() {
        if (this.f10959b) {
            return false;
        }
        C1209u c1209uA = C1208t.b().a();
        if (c1209uA != null && !c1209uA.C()) {
            return false;
        }
        int iA = this.f10964g.a(this.f10962e, 203400000);
        return iA == -1 || iA == 0;
    }

    public final boolean f(C0648b c0648b, int i7) {
        return this.f10963f.x(this.f10962e, c0648b, i7);
    }

    public final M h(com.google.android.gms.common.api.e eVar) {
        Map map = this.f10967j;
        C1165b apiKey = eVar.getApiKey();
        M m7 = (M) map.get(apiKey);
        if (m7 == null) {
            m7 = new M(this, eVar);
            this.f10967j.put(apiKey, m7);
        }
        if (m7.a()) {
            this.f10970m.add(apiKey);
        }
        m7.E();
        return m7;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i7 = message.what;
        M m7 = null;
        switch (i7) {
            case 1:
                this.f10958a = true == ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.f10971n.removeMessages(12);
                for (C1165b c1165b : this.f10967j.keySet()) {
                    Handler handler = this.f10971n;
                    handler.sendMessageDelayed(handler.obtainMessage(12, c1165b), this.f10958a);
                }
                return true;
            case 2:
                android.support.v4.media.session.b.a(message.obj);
                throw null;
            case 3:
                for (M m8 : this.f10967j.values()) {
                    m8.D();
                    m8.E();
                }
                return true;
            case 4:
            case 8:
            case 13:
                a0 a0Var = (a0) message.obj;
                M mH = (M) this.f10967j.get(a0Var.f10932c.getApiKey());
                if (mH == null) {
                    mH = h(a0Var.f10932c);
                }
                if (!mH.a() || this.f10966i.get() == a0Var.f10931b) {
                    mH.F(a0Var.f10930a);
                } else {
                    a0Var.f10930a.a(f10954p);
                    mH.K();
                }
                return true;
            case 5:
                int i8 = message.arg1;
                C0648b c0648b = (C0648b) message.obj;
                Iterator it = this.f10967j.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        M m9 = (M) it.next();
                        if (m9.s() == i8) {
                            m7 = m9;
                        }
                    }
                }
                if (m7 == null) {
                    Log.wtf("GoogleApiManager", "Could not find API instance " + i8 + " while trying to fail enqueued calls.", new Exception());
                } else if (c0648b.A() == 13) {
                    m7.h(new Status(17, "Error resolution was canceled by the user, original error message: " + this.f10963f.e(c0648b.A()) + ": " + c0648b.B()));
                } else {
                    m7.h(g(m7.f10895c, c0648b));
                }
                return true;
            case 6:
                if (this.f10962e.getApplicationContext() instanceof Application) {
                    ComponentCallbacks2C1166c.c((Application) this.f10962e.getApplicationContext());
                    ComponentCallbacks2C1166c.b().a(new H(this));
                    if (!ComponentCallbacks2C1166c.b().e(true)) {
                        this.f10958a = 300000L;
                    }
                }
                return true;
            case 7:
                h((com.google.android.gms.common.api.e) message.obj);
                return true;
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                if (this.f10967j.containsKey(message.obj)) {
                    ((M) this.f10967j.get(message.obj)).J();
                }
                return true;
            case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                Iterator it2 = this.f10970m.iterator();
                while (it2.hasNext()) {
                    M m10 = (M) this.f10967j.remove((C1165b) it2.next());
                    if (m10 != null) {
                        m10.K();
                    }
                }
                this.f10970m.clear();
                return true;
            case 11:
                if (this.f10967j.containsKey(message.obj)) {
                    ((M) this.f10967j.get(message.obj)).L();
                }
                return true;
            case 12:
                if (this.f10967j.containsKey(message.obj)) {
                    ((M) this.f10967j.get(message.obj)).d();
                }
                return true;
            case 14:
                E e7 = (E) message.obj;
                C1165b c1165bA = e7.a();
                if (this.f10967j.containsKey(c1165bA)) {
                    e7.b().setResult(Boolean.valueOf(((M) this.f10967j.get(c1165bA)).r(false)));
                } else {
                    e7.b().setResult(Boolean.FALSE);
                }
                return true;
            case 15:
                O o7 = (O) message.obj;
                if (this.f10967j.containsKey(o7.f10906a)) {
                    M.B((M) this.f10967j.get(o7.f10906a), o7);
                }
                return true;
            case com.amazon.c.a.a.c.f10119g /* 16 */:
                O o8 = (O) message.obj;
                if (this.f10967j.containsKey(o8.f10906a)) {
                    M.C((M) this.f10967j.get(o8.f10906a), o8);
                }
                return true;
            case C2105D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                j();
                return true;
            case C2105D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                Z z7 = (Z) message.obj;
                if (z7.f10928c == 0) {
                    i().a(new C1211w(z7.f10927b, Arrays.asList(z7.f10926a)));
                } else {
                    C1211w c1211w = this.f10960c;
                    if (c1211w != null) {
                        List listB = c1211w.B();
                        if (c1211w.A() != z7.f10927b || (listB != null && listB.size() >= z7.f10929d)) {
                            this.f10971n.removeMessages(17);
                            j();
                        } else {
                            this.f10960c.C(z7.f10926a);
                        }
                    }
                    if (this.f10960c == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(z7.f10926a);
                        this.f10960c = new C1211w(z7.f10927b, arrayList);
                        Handler handler2 = this.f10971n;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), z7.f10928c);
                    }
                }
                return true;
            case 19:
                this.f10959b = false;
                return true;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + i7);
                return false;
        }
    }

    public final InterfaceC1213y i() {
        if (this.f10961d == null) {
            this.f10961d = AbstractC1212x.a(this.f10962e);
        }
        return this.f10961d;
    }

    public final void j() {
        C1211w c1211w = this.f10960c;
        if (c1211w != null) {
            if (c1211w.A() > 0 || e()) {
                i().a(c1211w);
            }
            this.f10960c = null;
        }
    }

    public final void k(TaskCompletionSource taskCompletionSource, int i7, com.google.android.gms.common.api.e eVar) {
        Y yA;
        if (i7 == 0 || (yA = Y.a(this, i7, eVar.getApiKey())) == null) {
            return;
        }
        Task task = taskCompletionSource.getTask();
        final Handler handler = this.f10971n;
        handler.getClass();
        task.addOnCompleteListener(new Executor() { // from class: com.google.android.gms.common.api.internal.G
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        }, yA);
    }

    public final int l() {
        return this.f10965h.getAndIncrement();
    }

    public final M t(C1165b c1165b) {
        return (M) this.f10967j.get(c1165b);
    }

    public final Task w(com.google.android.gms.common.api.e eVar) {
        E e7 = new E(eVar.getApiKey());
        this.f10971n.sendMessage(this.f10971n.obtainMessage(14, e7));
        return e7.b().getTask();
    }

    public final Task x(com.google.android.gms.common.api.e eVar, C1175l.a aVar, int i7) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        k(taskCompletionSource, i7, eVar);
        this.f10971n.sendMessage(this.f10971n.obtainMessage(13, new a0(new o0(aVar, taskCompletionSource), this.f10966i.get(), eVar)));
        return taskCompletionSource.getTask();
    }
}
