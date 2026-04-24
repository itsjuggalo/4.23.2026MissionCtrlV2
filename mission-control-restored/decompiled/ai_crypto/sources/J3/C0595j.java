package J3;

import J3.InterfaceC0599n;
import K3.AbstractC0612b;
import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: J3.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0595j implements InterfaceC0599n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f3236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Runnable f3237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f3238d = new ArrayList();

    /* JADX INFO: renamed from: J3.j$c */
    public class c extends ConnectivityManager.NetworkCallback {
        public c() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            C0595j.this.k(true);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            C0595j.this.k(false);
        }

        public /* synthetic */ c(C0595j c0595j, a aVar) {
            this();
        }
    }

    public C0595j(Context context) {
        AbstractC0612b.d(context != null, "Context must be non-null", new Object[0]);
        this.f3235a = context;
        this.f3236b = (ConnectivityManager) context.getSystemService("connectivity");
        f();
        g();
    }

    @Override // J3.InterfaceC0599n
    public void a(K3.n nVar) {
        synchronized (this.f3238d) {
            this.f3238d.add(nVar);
        }
    }

    public final void f() {
        Application application = (Application) this.f3235a.getApplicationContext();
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        application.registerActivityLifecycleCallbacks(new a(atomicBoolean));
        application.registerComponentCallbacks(new b(atomicBoolean));
    }

    public final void g() {
        a aVar = null;
        if (this.f3236b != null) {
            final c cVar = new c(this, aVar);
            this.f3236b.registerDefaultNetworkCallback(cVar);
            this.f3237c = new Runnable() { // from class: J3.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f3231a.i(cVar);
                }
            };
        } else {
            final d dVar = new d(this, aVar);
            this.f3235a.registerReceiver(dVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f3237c = new Runnable() { // from class: J3.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f3233a.j(dVar);
                }
            };
        }
    }

    public final boolean h() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f3235a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final /* synthetic */ void i(c cVar) {
        this.f3236b.unregisterNetworkCallback(cVar);
    }

    public final /* synthetic */ void j(d dVar) {
        this.f3235a.unregisterReceiver(dVar);
    }

    public final void k(boolean z7) {
        synchronized (this.f3238d) {
            try {
                Iterator it = this.f3238d.iterator();
                while (it.hasNext()) {
                    ((K3.n) it.next()).accept(z7 ? InterfaceC0599n.a.REACHABLE : InterfaceC0599n.a.UNREACHABLE);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void l() {
        K3.x.a("AndroidConnectivityMonitor", "App has entered the foreground.", new Object[0]);
        if (h()) {
            k(true);
        }
    }

    @Override // J3.InterfaceC0599n
    public void shutdown() {
        Runnable runnable = this.f3237c;
        if (runnable != null) {
            runnable.run();
            this.f3237c = null;
        }
    }

    /* JADX INFO: renamed from: J3.j$d */
    public class d extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f3244a;

        public d() {
            this.f3244a = false;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean zH = C0595j.this.h();
            if (C0595j.this.h() && !this.f3244a) {
                C0595j.this.k(true);
            } else if (!zH && this.f3244a) {
                C0595j.this.k(false);
            }
            this.f3244a = zH;
        }

        public /* synthetic */ d(C0595j c0595j, a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: J3.j$b */
    public class b implements ComponentCallbacks2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f3241a;

        public b(AtomicBoolean atomicBoolean) {
            this.f3241a = atomicBoolean;
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i7) {
            if (i7 == 20) {
                this.f3241a.set(true);
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }
    }

    /* JADX INFO: renamed from: J3.j$a */
    public class a implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f3239a;

        public a(AtomicBoolean atomicBoolean) {
            this.f3239a = atomicBoolean;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (this.f3239a.compareAndSet(true, false)) {
                C0595j.this.l();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (this.f3239a.compareAndSet(true, false)) {
                C0595j.this.l();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f3239a.compareAndSet(true, false)) {
                C0595j.this.l();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}
