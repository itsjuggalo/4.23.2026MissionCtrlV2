package l6;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Map f15510n = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f15512b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f15517g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Intent f15518h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ServiceConnection f15522l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public IInterface f15523m;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f15514d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f15515e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f15516f = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final IBinder.DeathRecipient f15520j = new IBinder.DeathRecipient() { // from class: l6.k
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            t.j(this.f15499a);
        }
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicInteger f15521k = new AtomicInteger(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f15513c = "com.google.android.finsky.inappreviewservice.InAppReviewService";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final WeakReference f15519i = new WeakReference(null);

    public t(Context context, i iVar, String str, Intent intent, k6.i iVar2, o oVar) {
        this.f15511a = context;
        this.f15512b = iVar;
        this.f15518h = intent;
    }

    public static /* synthetic */ void j(t tVar) {
        tVar.f15512b.c("reportBinderDeath", new Object[0]);
        android.support.v4.media.session.b.a(tVar.f15519i.get());
        tVar.f15512b.c("%s : Binder has died.", tVar.f15513c);
        Iterator it = tVar.f15514d.iterator();
        while (it.hasNext()) {
            ((j) it.next()).c(tVar.v());
        }
        tVar.f15514d.clear();
        synchronized (tVar.f15516f) {
            tVar.w();
        }
    }

    public static /* bridge */ /* synthetic */ void n(final t tVar, final TaskCompletionSource taskCompletionSource) {
        tVar.f15515e.add(taskCompletionSource);
        taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: l6.l
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f15500a.t(taskCompletionSource, task);
            }
        });
    }

    public static /* bridge */ /* synthetic */ void p(t tVar, j jVar) {
        if (tVar.f15523m != null || tVar.f15517g) {
            if (!tVar.f15517g) {
                jVar.run();
                return;
            } else {
                tVar.f15512b.c("Waiting to bind to the service.", new Object[0]);
                tVar.f15514d.add(jVar);
                return;
            }
        }
        tVar.f15512b.c("Initiate binding to the service.", new Object[0]);
        tVar.f15514d.add(jVar);
        r rVar = new r(tVar, null);
        tVar.f15522l = rVar;
        tVar.f15517g = true;
        if (tVar.f15511a.bindService(tVar.f15518h, rVar, 1)) {
            return;
        }
        tVar.f15512b.c("Failed to bind to the service.", new Object[0]);
        tVar.f15517g = false;
        Iterator it = tVar.f15514d.iterator();
        while (it.hasNext()) {
            ((j) it.next()).c(new u());
        }
        tVar.f15514d.clear();
    }

    public static /* bridge */ /* synthetic */ void q(t tVar) {
        tVar.f15512b.c("linkToDeath", new Object[0]);
        try {
            tVar.f15523m.asBinder().linkToDeath(tVar.f15520j, 0);
        } catch (RemoteException e10) {
            tVar.f15512b.b(e10, "linkToDeath failed", new Object[0]);
        }
    }

    public static /* bridge */ /* synthetic */ void r(t tVar) {
        tVar.f15512b.c("unlinkToDeath", new Object[0]);
        tVar.f15523m.asBinder().unlinkToDeath(tVar.f15520j, 0);
    }

    public final Handler c() {
        Handler handler;
        Map map = f15510n;
        synchronized (map) {
            try {
                if (!map.containsKey(this.f15513c)) {
                    HandlerThread handlerThread = new HandlerThread(this.f15513c, 10);
                    handlerThread.start();
                    map.put(this.f15513c, new Handler(handlerThread.getLooper()));
                }
                handler = (Handler) map.get(this.f15513c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public final IInterface e() {
        return this.f15523m;
    }

    public final void s(j jVar, TaskCompletionSource taskCompletionSource) {
        c().post(new m(this, jVar.b(), taskCompletionSource, jVar));
    }

    public final /* synthetic */ void t(TaskCompletionSource taskCompletionSource, Task task) {
        synchronized (this.f15516f) {
            this.f15515e.remove(taskCompletionSource);
        }
    }

    public final void u(TaskCompletionSource taskCompletionSource) {
        synchronized (this.f15516f) {
            this.f15515e.remove(taskCompletionSource);
        }
        c().post(new n(this));
    }

    public final RemoteException v() {
        return new RemoteException(String.valueOf(this.f15513c).concat(" : Binder has died."));
    }

    public final void w() {
        Iterator it = this.f15515e.iterator();
        while (it.hasNext()) {
            ((TaskCompletionSource) it.next()).trySetException(v());
        }
        this.f15515e.clear();
    }
}
