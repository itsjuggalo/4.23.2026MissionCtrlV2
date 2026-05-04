package m9;

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
import m9.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f16181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f16182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Runnable f16183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f16184d = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c extends ConnectivityManager.NetworkCallback {
        public c() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            j.this.i(true);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            j.this.i(false);
        }

        public /* synthetic */ c(j jVar, a aVar) {
            this();
        }
    }

    public j(Context context) {
        n9.b.d(context != null, "Context must be non-null", new Object[0]);
        this.f16181a = context;
        this.f16182b = (ConnectivityManager) context.getSystemService("connectivity");
        f();
        g();
    }

    @Override // m9.n
    public void a(n9.n nVar) {
        synchronized (this.f16184d) {
            this.f16184d.add(nVar);
        }
    }

    public final void f() {
        Application application = (Application) this.f16181a.getApplicationContext();
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        application.registerActivityLifecycleCallbacks(new a(atomicBoolean));
        application.registerComponentCallbacks(new b(atomicBoolean));
    }

    public final void g() {
        a aVar = null;
        if (this.f16182b != null) {
            final c cVar = new c(this, aVar);
            this.f16182b.registerDefaultNetworkCallback(cVar);
            this.f16183c = new Runnable() { // from class: m9.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16169a.f16182b.unregisterNetworkCallback(cVar);
                }
            };
        } else {
            final d dVar = new d(this, aVar);
            this.f16181a.registerReceiver(dVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f16183c = new Runnable() { // from class: m9.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16179a.f16181a.unregisterReceiver(dVar);
                }
            };
        }
    }

    public final boolean h() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f16181a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final void i(boolean z10) {
        synchronized (this.f16184d) {
            try {
                Iterator it = this.f16184d.iterator();
                while (it.hasNext()) {
                    ((n9.n) it.next()).accept(z10 ? n.a.REACHABLE : n.a.UNREACHABLE);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void j() {
        n9.v.a("AndroidConnectivityMonitor", "App has entered the foreground.", new Object[0]);
        if (h()) {
            i(true);
        }
    }

    @Override // m9.n
    public void shutdown() {
        Runnable runnable = this.f16183c;
        if (runnable != null) {
            runnable.run();
            this.f16183c = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f16190a;

        public d() {
            this.f16190a = false;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean zH = j.this.h();
            if (j.this.h() && !this.f16190a) {
                j.this.i(true);
            } else if (!zH && this.f16190a) {
                j.this.i(false);
            }
            this.f16190a = zH;
        }

        public /* synthetic */ d(j jVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements ComponentCallbacks2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f16187a;

        public b(AtomicBoolean atomicBoolean) {
            this.f16187a = atomicBoolean;
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i10) {
            if (i10 == 20) {
                this.f16187a.set(true);
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f16185a;

        public a(AtomicBoolean atomicBoolean) {
            this.f16185a = atomicBoolean;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (this.f16185a.compareAndSet(true, false)) {
                j.this.j();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (this.f16185a.compareAndSet(true, false)) {
                j.this.j();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f16185a.compareAndSet(true, false)) {
                j.this.j();
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
