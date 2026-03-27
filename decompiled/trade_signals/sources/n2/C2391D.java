package n2;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import l2.AbstractC2328l;
import l2.C2329m;
import l2.InterfaceC2322f;
import m2.C2364q;

/* JADX INFO: renamed from: n2.D, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2391D {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Map f21561o = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2412s f21563b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f21568g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Intent f21569h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ServiceConnection f21573l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public IInterface f21574m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final C2364q f21575n;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f21565d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f21566e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f21567f = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final IBinder.DeathRecipient f21571j = new IBinder.DeathRecipient() { // from class: n2.v
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            C2391D.j(this.f21598a);
        }
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicInteger f21572k = new AtomicInteger(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f21564c = "AppUpdateService";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final WeakReference f21570i = new WeakReference(null);

    public C2391D(Context context, C2412s c2412s, String str, Intent intent, C2364q c2364q, InterfaceC2418y interfaceC2418y) {
        this.f21562a = context;
        this.f21563b = c2412s;
        this.f21569h = intent;
        this.f21575n = c2364q;
    }

    public static /* synthetic */ void j(C2391D c2391d) {
        c2391d.f21563b.d("reportBinderDeath", new Object[0]);
        android.support.v4.media.session.b.a(c2391d.f21570i.get());
        c2391d.f21563b.d("%s : Binder has died.", c2391d.f21564c);
        Iterator it = c2391d.f21565d.iterator();
        while (it.hasNext()) {
            ((AbstractRunnableC2413t) it.next()).c(c2391d.v());
        }
        c2391d.f21565d.clear();
        synchronized (c2391d.f21567f) {
            c2391d.w();
        }
    }

    public static /* bridge */ /* synthetic */ void n(final C2391D c2391d, final C2329m c2329m) {
        c2391d.f21566e.add(c2329m);
        c2329m.a().c(new InterfaceC2322f() { // from class: n2.u
            @Override // l2.InterfaceC2322f
            public final void a(AbstractC2328l abstractC2328l) {
                this.f21596a.t(c2329m, abstractC2328l);
            }
        });
    }

    public static /* bridge */ /* synthetic */ void p(C2391D c2391d, AbstractRunnableC2413t abstractRunnableC2413t) {
        if (c2391d.f21574m != null || c2391d.f21568g) {
            if (!c2391d.f21568g) {
                abstractRunnableC2413t.run();
                return;
            } else {
                c2391d.f21563b.d("Waiting to bind to the service.", new Object[0]);
                c2391d.f21565d.add(abstractRunnableC2413t);
                return;
            }
        }
        c2391d.f21563b.d("Initiate binding to the service.", new Object[0]);
        c2391d.f21565d.add(abstractRunnableC2413t);
        ServiceConnectionC2390C serviceConnectionC2390C = new ServiceConnectionC2390C(c2391d, null);
        c2391d.f21573l = serviceConnectionC2390C;
        c2391d.f21568g = true;
        if (c2391d.f21562a.bindService(c2391d.f21569h, serviceConnectionC2390C, 1)) {
            return;
        }
        c2391d.f21563b.d("Failed to bind to the service.", new Object[0]);
        c2391d.f21568g = false;
        Iterator it = c2391d.f21565d.iterator();
        while (it.hasNext()) {
            ((AbstractRunnableC2413t) it.next()).c(new C2392E());
        }
        c2391d.f21565d.clear();
    }

    public static /* bridge */ /* synthetic */ void q(C2391D c2391d) {
        c2391d.f21563b.d("linkToDeath", new Object[0]);
        try {
            c2391d.f21574m.asBinder().linkToDeath(c2391d.f21571j, 0);
        } catch (RemoteException e8) {
            c2391d.f21563b.c(e8, "linkToDeath failed", new Object[0]);
        }
    }

    public static /* bridge */ /* synthetic */ void r(C2391D c2391d) {
        c2391d.f21563b.d("unlinkToDeath", new Object[0]);
        c2391d.f21574m.asBinder().unlinkToDeath(c2391d.f21571j, 0);
    }

    public final Handler c() {
        Handler handler;
        Map map = f21561o;
        synchronized (map) {
            try {
                if (!map.containsKey(this.f21564c)) {
                    HandlerThread handlerThread = new HandlerThread(this.f21564c, 10);
                    handlerThread.start();
                    map.put(this.f21564c, new Handler(handlerThread.getLooper()));
                }
                handler = (Handler) map.get(this.f21564c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public final IInterface e() {
        return this.f21574m;
    }

    public final void s(AbstractRunnableC2413t abstractRunnableC2413t, C2329m c2329m) {
        c().post(new C2416w(this, abstractRunnableC2413t.b(), c2329m, abstractRunnableC2413t));
    }

    public final /* synthetic */ void t(C2329m c2329m, AbstractC2328l abstractC2328l) {
        synchronized (this.f21567f) {
            this.f21566e.remove(c2329m);
        }
    }

    public final void u(C2329m c2329m) {
        synchronized (this.f21567f) {
            this.f21566e.remove(c2329m);
        }
        c().post(new C2417x(this));
    }

    public final RemoteException v() {
        return new RemoteException(String.valueOf(this.f21564c).concat(" : Binder has died."));
    }

    public final void w() {
        Iterator it = this.f21566e.iterator();
        while (it.hasNext()) {
            ((C2329m) it.next()).d(v());
        }
        this.f21566e.clear();
    }
}
