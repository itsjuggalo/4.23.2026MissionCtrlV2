package t2;

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
import s2.C2694i;

/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Map f23307n = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f23308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2742i f23309b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f23314g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Intent f23315h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ServiceConnection f23319l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public IInterface f23320m;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f23311d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f23312e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f23313f = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final IBinder.DeathRecipient f23317j = new IBinder.DeathRecipient() { // from class: t2.k
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            t.j(this.f23296a);
        }
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicInteger f23318k = new AtomicInteger(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f23310c = "com.google.android.finsky.inappreviewservice.InAppReviewService";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final WeakReference f23316i = new WeakReference(null);

    public t(Context context, C2742i c2742i, String str, Intent intent, C2694i c2694i, o oVar) {
        this.f23308a = context;
        this.f23309b = c2742i;
        this.f23315h = intent;
    }

    public static /* synthetic */ void j(t tVar) {
        tVar.f23309b.c("reportBinderDeath", new Object[0]);
        android.support.v4.media.session.b.a(tVar.f23316i.get());
        tVar.f23309b.c("%s : Binder has died.", tVar.f23310c);
        Iterator it = tVar.f23311d.iterator();
        while (it.hasNext()) {
            ((j) it.next()).c(tVar.v());
        }
        tVar.f23311d.clear();
        synchronized (tVar.f23313f) {
            tVar.w();
        }
    }

    public static /* bridge */ /* synthetic */ void n(final t tVar, final C2329m c2329m) {
        tVar.f23312e.add(c2329m);
        c2329m.a().c(new InterfaceC2322f() { // from class: t2.l
            @Override // l2.InterfaceC2322f
            public final void a(AbstractC2328l abstractC2328l) {
                this.f23297a.t(c2329m, abstractC2328l);
            }
        });
    }

    public static /* bridge */ /* synthetic */ void p(t tVar, j jVar) {
        if (tVar.f23320m != null || tVar.f23314g) {
            if (!tVar.f23314g) {
                jVar.run();
                return;
            } else {
                tVar.f23309b.c("Waiting to bind to the service.", new Object[0]);
                tVar.f23311d.add(jVar);
                return;
            }
        }
        tVar.f23309b.c("Initiate binding to the service.", new Object[0]);
        tVar.f23311d.add(jVar);
        r rVar = new r(tVar, null);
        tVar.f23319l = rVar;
        tVar.f23314g = true;
        if (tVar.f23308a.bindService(tVar.f23315h, rVar, 1)) {
            return;
        }
        tVar.f23309b.c("Failed to bind to the service.", new Object[0]);
        tVar.f23314g = false;
        Iterator it = tVar.f23311d.iterator();
        while (it.hasNext()) {
            ((j) it.next()).c(new u());
        }
        tVar.f23311d.clear();
    }

    public static /* bridge */ /* synthetic */ void q(t tVar) {
        tVar.f23309b.c("linkToDeath", new Object[0]);
        try {
            tVar.f23320m.asBinder().linkToDeath(tVar.f23317j, 0);
        } catch (RemoteException e8) {
            tVar.f23309b.b(e8, "linkToDeath failed", new Object[0]);
        }
    }

    public static /* bridge */ /* synthetic */ void r(t tVar) {
        tVar.f23309b.c("unlinkToDeath", new Object[0]);
        tVar.f23320m.asBinder().unlinkToDeath(tVar.f23317j, 0);
    }

    public final Handler c() {
        Handler handler;
        Map map = f23307n;
        synchronized (map) {
            try {
                if (!map.containsKey(this.f23310c)) {
                    HandlerThread handlerThread = new HandlerThread(this.f23310c, 10);
                    handlerThread.start();
                    map.put(this.f23310c, new Handler(handlerThread.getLooper()));
                }
                handler = (Handler) map.get(this.f23310c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public final IInterface e() {
        return this.f23320m;
    }

    public final void s(j jVar, C2329m c2329m) {
        c().post(new m(this, jVar.b(), c2329m, jVar));
    }

    public final /* synthetic */ void t(C2329m c2329m, AbstractC2328l abstractC2328l) {
        synchronized (this.f23313f) {
            this.f23312e.remove(c2329m);
        }
    }

    public final void u(C2329m c2329m) {
        synchronized (this.f23313f) {
            this.f23312e.remove(c2329m);
        }
        c().post(new n(this));
    }

    public final RemoteException v() {
        return new RemoteException(String.valueOf(this.f23310c).concat(" : Binder has died."));
    }

    public final void w() {
        Iterator it = this.f23312e.iterator();
        while (it.hasNext()) {
            ((C2329m) it.next()).d(v());
        }
        this.f23312e.clear();
    }
}
