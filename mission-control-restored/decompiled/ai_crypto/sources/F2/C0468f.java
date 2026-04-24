package F2;

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

/* JADX INFO: renamed from: F2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0468f {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Map f1911o = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final G f1913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1914c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1918g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Intent f1919h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final N f1920i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ServiceConnection f1924m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public IInterface f1925n;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f1915d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f1916e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f1917f = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final IBinder.DeathRecipient f1922k = new IBinder.DeathRecipient() { // from class: F2.I
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            C0468f.k(this.f1898a);
        }
    };

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicInteger f1923l = new AtomicInteger(0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final WeakReference f1921j = new WeakReference(null);

    public C0468f(Context context, G g7, String str, Intent intent, N n7, M m7) {
        this.f1912a = context;
        this.f1913b = g7;
        this.f1914c = str;
        this.f1919h = intent;
        this.f1920i = n7;
    }

    public static /* synthetic */ void k(C0468f c0468f) {
        c0468f.f1913b.d("reportBinderDeath", new Object[0]);
        android.support.v4.media.session.b.a(c0468f.f1921j.get());
        c0468f.f1913b.d("%s : Binder has died.", c0468f.f1914c);
        Iterator it = c0468f.f1915d.iterator();
        while (it.hasNext()) {
            ((H) it.next()).a(c0468f.w());
        }
        c0468f.f1915d.clear();
        synchronized (c0468f.f1917f) {
            c0468f.x();
        }
    }

    public static /* bridge */ /* synthetic */ void o(final C0468f c0468f, final TaskCompletionSource taskCompletionSource) {
        c0468f.f1916e.add(taskCompletionSource);
        taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: F2.J
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f1899a.u(taskCompletionSource, task);
            }
        });
    }

    public static /* bridge */ /* synthetic */ void q(C0468f c0468f, H h7) {
        if (c0468f.f1925n != null || c0468f.f1918g) {
            if (!c0468f.f1918g) {
                h7.run();
                return;
            } else {
                c0468f.f1913b.d("Waiting to bind to the service.", new Object[0]);
                c0468f.f1915d.add(h7);
                return;
            }
        }
        c0468f.f1913b.d("Initiate binding to the service.", new Object[0]);
        c0468f.f1915d.add(h7);
        ServiceConnectionC0467e serviceConnectionC0467e = new ServiceConnectionC0467e(c0468f, null);
        c0468f.f1924m = serviceConnectionC0467e;
        c0468f.f1918g = true;
        if (c0468f.f1912a.bindService(c0468f.f1919h, serviceConnectionC0467e, 1)) {
            return;
        }
        c0468f.f1913b.d("Failed to bind to the service.", new Object[0]);
        c0468f.f1918g = false;
        Iterator it = c0468f.f1915d.iterator();
        while (it.hasNext()) {
            ((H) it.next()).a(new C0469g());
        }
        c0468f.f1915d.clear();
    }

    public static /* bridge */ /* synthetic */ void r(C0468f c0468f) {
        c0468f.f1913b.d("linkToDeath", new Object[0]);
        try {
            c0468f.f1925n.asBinder().linkToDeath(c0468f.f1922k, 0);
        } catch (RemoteException e7) {
            c0468f.f1913b.c(e7, "linkToDeath failed", new Object[0]);
        }
    }

    public static /* bridge */ /* synthetic */ void s(C0468f c0468f) {
        c0468f.f1913b.d("unlinkToDeath", new Object[0]);
        c0468f.f1925n.asBinder().unlinkToDeath(c0468f.f1922k, 0);
    }

    public final Handler c() {
        Handler handler;
        Map map = f1911o;
        synchronized (map) {
            try {
                if (!map.containsKey(this.f1914c)) {
                    HandlerThread handlerThread = new HandlerThread(this.f1914c, 10);
                    handlerThread.start();
                    map.put(this.f1914c, new Handler(handlerThread.getLooper()));
                }
                handler = (Handler) map.get(this.f1914c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public final IInterface e() {
        return this.f1925n;
    }

    public final void t(H h7, TaskCompletionSource taskCompletionSource) {
        c().post(new K(this, h7.c(), taskCompletionSource, h7));
    }

    public final /* synthetic */ void u(TaskCompletionSource taskCompletionSource, Task task) {
        synchronized (this.f1917f) {
            this.f1916e.remove(taskCompletionSource);
        }
    }

    public final void v(TaskCompletionSource taskCompletionSource) {
        synchronized (this.f1917f) {
            this.f1916e.remove(taskCompletionSource);
        }
        c().post(new L(this));
    }

    public final RemoteException w() {
        return new RemoteException(String.valueOf(this.f1914c).concat(" : Binder has died."));
    }

    public final void x() {
        Iterator it = this.f1916e.iterator();
        while (it.hasNext()) {
            ((TaskCompletionSource) it.next()).trySetException(w());
        }
        this.f1916e.clear();
    }
}
