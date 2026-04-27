package S1;

import Q1.C0790b;
import Q1.C0794f;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC1288h;
import com.google.android.gms.common.internal.AbstractC1298s;
import com.google.android.gms.common.internal.C1292l;
import com.google.android.gms.common.internal.C1295o;
import com.google.android.gms.common.internal.C1296p;
import com.google.android.gms.common.internal.InterfaceC1299t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import l2.AbstractC2328l;
import l2.C2329m;

/* JADX INFO: renamed from: S1.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0873e implements Handler.Callback {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Status f7405p = new Status(4, "Sign-out occurred while this API call was in progress.");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Status f7406q = new Status(4, "The user must be signed in to make this API call.");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Object f7407r = new Object();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static C0873e f7408s;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.google.android.gms.common.internal.r f7411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InterfaceC1299t f7412d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f7413e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C0794f f7414f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.google.android.gms.common.internal.E f7415g;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Handler f7422n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f7423o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f7409a = 10000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7410b = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicInteger f7416h = new AtomicInteger(1);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicInteger f7417i = new AtomicInteger(0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map f7418j = new ConcurrentHashMap(5, 0.75f, 1);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public C0885q f7419k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Set f7420l = new w.b();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Set f7421m = new w.b();

    public C0873e(Context context, Looper looper, C0794f c0794f) {
        this.f7423o = true;
        this.f7413e = context;
        c2.h hVar = new c2.h(looper, this);
        this.f7422n = hVar;
        this.f7414f = c0794f;
        this.f7415g = new com.google.android.gms.common.internal.E(c0794f);
        if (W1.i.a(context)) {
            this.f7423o = false;
        }
        hVar.sendMessage(hVar.obtainMessage(6));
    }

    public static Status f(C0870b c0870b, C0790b c0790b) {
        return new Status(c0790b, "API: " + c0870b.b() + " is not available on this device. Connection failed with: " + String.valueOf(c0790b));
    }

    public static C0873e t(Context context) {
        C0873e c0873e;
        synchronized (f7407r) {
            try {
                if (f7408s == null) {
                    f7408s = new C0873e(context.getApplicationContext(), AbstractC1288h.b().getLooper(), C0794f.n());
                }
                c0873e = f7408s;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0873e;
    }

    public final void A(C1292l c1292l, int i8, long j8, int i9) {
        this.f7422n.sendMessage(this.f7422n.obtainMessage(18, new I(c1292l, i8, j8, i9)));
    }

    public final void B(C0790b c0790b, int i8) {
        if (e(c0790b, i8)) {
            return;
        }
        Handler handler = this.f7422n;
        handler.sendMessage(handler.obtainMessage(5, i8, 0, c0790b));
    }

    public final void C() {
        Handler handler = this.f7422n;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void D(R1.e eVar) {
        Handler handler = this.f7422n;
        handler.sendMessage(handler.obtainMessage(7, eVar));
    }

    public final void a(C0885q c0885q) {
        synchronized (f7407r) {
            try {
                if (this.f7419k != c0885q) {
                    this.f7419k = c0885q;
                    this.f7420l.clear();
                }
                this.f7420l.addAll(c0885q.t());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(C0885q c0885q) {
        synchronized (f7407r) {
            try {
                if (this.f7419k == c0885q) {
                    this.f7419k = null;
                    this.f7420l.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean d() {
        if (this.f7410b) {
            return false;
        }
        C1296p c1296pA = C1295o.b().a();
        if (c1296pA != null && !c1296pA.e()) {
            return false;
        }
        int iA = this.f7415g.a(this.f7413e, 203400000);
        return iA == -1 || iA == 0;
    }

    public final boolean e(C0790b c0790b, int i8) {
        return this.f7414f.x(this.f7413e, c0790b, i8);
    }

    public final C0892y g(R1.e eVar) {
        Map map = this.f7418j;
        C0870b c0870bE = eVar.e();
        C0892y c0892y = (C0892y) map.get(c0870bE);
        if (c0892y == null) {
            c0892y = new C0892y(this, eVar);
            this.f7418j.put(c0870bE, c0892y);
        }
        if (c0892y.a()) {
            this.f7421m.add(c0870bE);
        }
        c0892y.B();
        return c0892y;
    }

    public final InterfaceC1299t h() {
        if (this.f7412d == null) {
            this.f7412d = AbstractC1298s.a(this.f7413e);
        }
        return this.f7412d;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i8 = message.what;
        C0892y c0892y = null;
        switch (i8) {
            case 1:
                this.f7409a = true == ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.f7422n.removeMessages(12);
                for (C0870b c0870b : this.f7418j.keySet()) {
                    Handler handler = this.f7422n;
                    handler.sendMessageDelayed(handler.obtainMessage(12, c0870b), this.f7409a);
                }
                return true;
            case 2:
                android.support.v4.media.session.b.a(message.obj);
                throw null;
            case 3:
                for (C0892y c0892y2 : this.f7418j.values()) {
                    c0892y2.A();
                    c0892y2.B();
                }
                return true;
            case 4:
            case 8:
            case 13:
                J j8 = (J) message.obj;
                C0892y c0892yG = (C0892y) this.f7418j.get(j8.f7358c.e());
                if (c0892yG == null) {
                    c0892yG = g(j8.f7358c);
                }
                if (!c0892yG.a() || this.f7417i.get() == j8.f7357b) {
                    c0892yG.C(j8.f7356a);
                } else {
                    j8.f7356a.a(f7405p);
                    c0892yG.H();
                }
                return true;
            case 5:
                int i9 = message.arg1;
                C0790b c0790b = (C0790b) message.obj;
                Iterator it = this.f7418j.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        C0892y c0892y3 = (C0892y) it.next();
                        if (c0892y3.p() == i9) {
                            c0892y = c0892y3;
                        }
                    }
                }
                if (c0892y == null) {
                    Log.wtf("GoogleApiManager", "Could not find API instance " + i9 + " while trying to fail enqueued calls.", new Exception());
                } else if (c0790b.a() == 13) {
                    c0892y.e(new Status(17, "Error resolution was canceled by the user, original error message: " + this.f7414f.e(c0790b.a()) + ": " + c0790b.d()));
                } else {
                    c0892y.e(f(c0892y.f7449c, c0790b));
                }
                return true;
            case 6:
                if (this.f7413e.getApplicationContext() instanceof Application) {
                    ComponentCallbacks2C0871c.c((Application) this.f7413e.getApplicationContext());
                    ComponentCallbacks2C0871c.b().a(new C0887t(this));
                    if (!ComponentCallbacks2C0871c.b().e(true)) {
                        this.f7409a = 300000L;
                    }
                }
                return true;
            case 7:
                g((R1.e) message.obj);
                return true;
            case 9:
                if (this.f7418j.containsKey(message.obj)) {
                    ((C0892y) this.f7418j.get(message.obj)).G();
                }
                return true;
            case 10:
                Iterator it2 = this.f7421m.iterator();
                while (it2.hasNext()) {
                    C0892y c0892y4 = (C0892y) this.f7418j.remove((C0870b) it2.next());
                    if (c0892y4 != null) {
                        c0892y4.H();
                    }
                }
                this.f7421m.clear();
                return true;
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                if (this.f7418j.containsKey(message.obj)) {
                    ((C0892y) this.f7418j.get(message.obj)).I();
                }
                return true;
            case 12:
                if (this.f7418j.containsKey(message.obj)) {
                    ((C0892y) this.f7418j.get(message.obj)).b();
                }
                return true;
            case 14:
                android.support.v4.media.session.b.a(message.obj);
                throw null;
            case 15:
                A a8 = (A) message.obj;
                if (this.f7418j.containsKey(a8.f7334a)) {
                    C0892y.y((C0892y) this.f7418j.get(a8.f7334a), a8);
                }
                return true;
            case com.amazon.c.a.a.c.f14230g /* 16 */:
                A a9 = (A) message.obj;
                if (this.f7418j.containsKey(a9.f7334a)) {
                    C0892y.z((C0892y) this.f7418j.get(a9.f7334a), a9);
                }
                return true;
            case 17:
                i();
                return true;
            case 18:
                I i10 = (I) message.obj;
                if (i10.f7354c == 0) {
                    h().a(new com.google.android.gms.common.internal.r(i10.f7353b, Arrays.asList(i10.f7352a)));
                } else {
                    com.google.android.gms.common.internal.r rVar = this.f7411c;
                    if (rVar != null) {
                        List listD = rVar.d();
                        if (rVar.a() != i10.f7353b || (listD != null && listD.size() >= i10.f7355d)) {
                            this.f7422n.removeMessages(17);
                            i();
                        } else {
                            this.f7411c.e(i10.f7352a);
                        }
                    }
                    if (this.f7411c == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(i10.f7352a);
                        this.f7411c = new com.google.android.gms.common.internal.r(i10.f7353b, arrayList);
                        Handler handler2 = this.f7422n;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), i10.f7354c);
                    }
                }
                return true;
            case 19:
                this.f7410b = false;
                return true;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + i8);
                return false;
        }
    }

    public final void i() {
        com.google.android.gms.common.internal.r rVar = this.f7411c;
        if (rVar != null) {
            if (rVar.a() > 0 || d()) {
                h().a(rVar);
            }
            this.f7411c = null;
        }
    }

    public final void j(C2329m c2329m, int i8, R1.e eVar) {
        H hB;
        if (i8 == 0 || (hB = H.b(this, i8, eVar.e())) == null) {
            return;
        }
        AbstractC2328l abstractC2328lA = c2329m.a();
        final Handler handler = this.f7422n;
        handler.getClass();
        abstractC2328lA.b(new Executor() { // from class: S1.s
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        }, hB);
    }

    public final int k() {
        return this.f7416h.getAndIncrement();
    }

    public final C0892y s(C0870b c0870b) {
        return (C0892y) this.f7418j.get(c0870b);
    }

    public final void z(R1.e eVar, int i8, AbstractC0882n abstractC0882n, C2329m c2329m, InterfaceC0881m interfaceC0881m) {
        j(c2329m, abstractC0882n.d(), eVar);
        this.f7422n.sendMessage(this.f7422n.obtainMessage(4, new J(new S(i8, abstractC0882n, c2329m, interfaceC0881m), this.f7417i.get(), eVar)));
    }
}
