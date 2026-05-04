package n6;

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
public final class f {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Map f16647o = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f16648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v0 f16649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16650c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f16654g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Intent f16655h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c1 f16656i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ServiceConnection f16660m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public IInterface f16661n;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f16651d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f16652e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f16653f = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final IBinder.DeathRecipient f16658k = new IBinder.DeathRecipient() { // from class: n6.x0
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            f.k(this.f16682a);
        }
    };

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicInteger f16659l = new AtomicInteger(0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final WeakReference f16657j = new WeakReference(null);

    public f(Context context, v0 v0Var, String str, Intent intent, c1 c1Var, b1 b1Var) {
        this.f16648a = context;
        this.f16649b = v0Var;
        this.f16650c = str;
        this.f16655h = intent;
        this.f16656i = c1Var;
    }

    public static /* synthetic */ void k(f fVar) {
        fVar.f16649b.d("reportBinderDeath", new Object[0]);
        android.support.v4.media.session.b.a(fVar.f16657j.get());
        fVar.f16649b.d("%s : Binder has died.", fVar.f16650c);
        Iterator it = fVar.f16651d.iterator();
        while (it.hasNext()) {
            ((w0) it.next()).a(fVar.w());
        }
        fVar.f16651d.clear();
        synchronized (fVar.f16653f) {
            fVar.x();
        }
    }

    public static /* bridge */ /* synthetic */ void o(final f fVar, final TaskCompletionSource taskCompletionSource) {
        fVar.f16652e.add(taskCompletionSource);
        taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: n6.y0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f16686a.u(taskCompletionSource, task);
            }
        });
    }

    public static /* bridge */ /* synthetic */ void q(f fVar, w0 w0Var) {
        if (fVar.f16661n != null || fVar.f16654g) {
            if (!fVar.f16654g) {
                w0Var.run();
                return;
            } else {
                fVar.f16649b.d("Waiting to bind to the service.", new Object[0]);
                fVar.f16651d.add(w0Var);
                return;
            }
        }
        fVar.f16649b.d("Initiate binding to the service.", new Object[0]);
        fVar.f16651d.add(w0Var);
        e eVar = new e(fVar, null);
        fVar.f16660m = eVar;
        fVar.f16654g = true;
        if (fVar.f16648a.bindService(fVar.f16655h, eVar, 1)) {
            return;
        }
        fVar.f16649b.d("Failed to bind to the service.", new Object[0]);
        fVar.f16654g = false;
        Iterator it = fVar.f16651d.iterator();
        while (it.hasNext()) {
            ((w0) it.next()).a(new g());
        }
        fVar.f16651d.clear();
    }

    public static /* bridge */ /* synthetic */ void r(f fVar) {
        fVar.f16649b.d("linkToDeath", new Object[0]);
        try {
            fVar.f16661n.asBinder().linkToDeath(fVar.f16658k, 0);
        } catch (RemoteException e10) {
            fVar.f16649b.c(e10, "linkToDeath failed", new Object[0]);
        }
    }

    public static /* bridge */ /* synthetic */ void s(f fVar) {
        fVar.f16649b.d("unlinkToDeath", new Object[0]);
        fVar.f16661n.asBinder().unlinkToDeath(fVar.f16658k, 0);
    }

    public final Handler c() {
        Handler handler;
        Map map = f16647o;
        synchronized (map) {
            try {
                if (!map.containsKey(this.f16650c)) {
                    HandlerThread handlerThread = new HandlerThread(this.f16650c, 10);
                    handlerThread.start();
                    map.put(this.f16650c, new Handler(handlerThread.getLooper()));
                }
                handler = (Handler) map.get(this.f16650c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public final IInterface e() {
        return this.f16661n;
    }

    public final void t(w0 w0Var, TaskCompletionSource taskCompletionSource) {
        c().post(new z0(this, w0Var.c(), taskCompletionSource, w0Var));
    }

    public final /* synthetic */ void u(TaskCompletionSource taskCompletionSource, Task task) {
        synchronized (this.f16653f) {
            this.f16652e.remove(taskCompletionSource);
        }
    }

    public final void v(TaskCompletionSource taskCompletionSource) {
        synchronized (this.f16653f) {
            this.f16652e.remove(taskCompletionSource);
        }
        c().post(new a1(this));
    }

    public final RemoteException w() {
        return new RemoteException(String.valueOf(this.f16650c).concat(" : Binder has died."));
    }

    public final void x() {
        Iterator it = this.f16652e.iterator();
        while (it.hasNext()) {
            ((TaskCompletionSource) it.next()).trySetException(w());
        }
        this.f16652e.clear();
    }
}
