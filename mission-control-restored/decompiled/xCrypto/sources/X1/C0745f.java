package X1;

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

/* JADX INFO: renamed from: X1.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0745f {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Map f5554o = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final G f5556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5557c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5561g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Intent f5562h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final N f5563i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ServiceConnection f5567m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public IInterface f5568n;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f5558d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f5559e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f5560f = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final IBinder.DeathRecipient f5565k = new IBinder.DeathRecipient() { // from class: X1.I
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            C0745f.k(this.f5541a);
        }
    };

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicInteger f5566l = new AtomicInteger(0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final WeakReference f5564j = new WeakReference(null);

    public C0745f(Context context, G g4, String str, Intent intent, N n4, M m4) {
        this.f5555a = context;
        this.f5556b = g4;
        this.f5557c = str;
        this.f5562h = intent;
        this.f5563i = n4;
    }

    public static /* synthetic */ void k(C0745f c0745f) {
        c0745f.f5556b.d("reportBinderDeath", new Object[0]);
        android.support.v4.media.session.b.a(c0745f.f5564j.get());
        c0745f.f5556b.d("%s : Binder has died.", c0745f.f5557c);
        Iterator it = c0745f.f5558d.iterator();
        while (it.hasNext()) {
            ((H) it.next()).a(c0745f.w());
        }
        c0745f.f5558d.clear();
        synchronized (c0745f.f5560f) {
            c0745f.x();
        }
    }

    public static /* bridge */ /* synthetic */ void o(final C0745f c0745f, final TaskCompletionSource taskCompletionSource) {
        c0745f.f5559e.add(taskCompletionSource);
        taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: X1.J
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f5542a.u(taskCompletionSource, task);
            }
        });
    }

    public static /* bridge */ /* synthetic */ void q(C0745f c0745f, H h4) {
        if (c0745f.f5568n != null || c0745f.f5561g) {
            if (!c0745f.f5561g) {
                h4.run();
                return;
            } else {
                c0745f.f5556b.d("Waiting to bind to the service.", new Object[0]);
                c0745f.f5558d.add(h4);
                return;
            }
        }
        c0745f.f5556b.d("Initiate binding to the service.", new Object[0]);
        c0745f.f5558d.add(h4);
        ServiceConnectionC0744e serviceConnectionC0744e = new ServiceConnectionC0744e(c0745f, null);
        c0745f.f5567m = serviceConnectionC0744e;
        c0745f.f5561g = true;
        if (c0745f.f5555a.bindService(c0745f.f5562h, serviceConnectionC0744e, 1)) {
            return;
        }
        c0745f.f5556b.d("Failed to bind to the service.", new Object[0]);
        c0745f.f5561g = false;
        Iterator it = c0745f.f5558d.iterator();
        while (it.hasNext()) {
            ((H) it.next()).a(new C0746g());
        }
        c0745f.f5558d.clear();
    }

    public static /* bridge */ /* synthetic */ void r(C0745f c0745f) {
        c0745f.f5556b.d("linkToDeath", new Object[0]);
        try {
            c0745f.f5568n.asBinder().linkToDeath(c0745f.f5565k, 0);
        } catch (RemoteException e4) {
            c0745f.f5556b.c(e4, "linkToDeath failed", new Object[0]);
        }
    }

    public static /* bridge */ /* synthetic */ void s(C0745f c0745f) {
        c0745f.f5556b.d("unlinkToDeath", new Object[0]);
        c0745f.f5568n.asBinder().unlinkToDeath(c0745f.f5565k, 0);
    }

    public final Handler c() {
        Handler handler;
        Map map = f5554o;
        synchronized (map) {
            try {
                if (!map.containsKey(this.f5557c)) {
                    HandlerThread handlerThread = new HandlerThread(this.f5557c, 10);
                    handlerThread.start();
                    map.put(this.f5557c, new Handler(handlerThread.getLooper()));
                }
                handler = (Handler) map.get(this.f5557c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public final IInterface e() {
        return this.f5568n;
    }

    public final void t(H h4, TaskCompletionSource taskCompletionSource) {
        c().post(new K(this, h4.c(), taskCompletionSource, h4));
    }

    public final /* synthetic */ void u(TaskCompletionSource taskCompletionSource, Task task) {
        synchronized (this.f5560f) {
            this.f5559e.remove(taskCompletionSource);
        }
    }

    public final void v(TaskCompletionSource taskCompletionSource) {
        synchronized (this.f5560f) {
            this.f5559e.remove(taskCompletionSource);
        }
        c().post(new L(this));
    }

    public final RemoteException w() {
        return new RemoteException(String.valueOf(this.f5557c).concat(" : Binder has died."));
    }

    public final void x() {
        Iterator it = this.f5559e.iterator();
        while (it.hasNext()) {
            ((TaskCompletionSource) it.next()).trySetException(w());
        }
        this.f5559e.clear();
    }
}
