package L2;

import K2.AbstractC0359g;
import K2.AbstractC0377z;
import K2.C0355c;
import K2.EnumC0368p;
import K2.L;
import K2.V;
import K2.W;
import K2.X;
import K2.a0;
import N2.g;
import Z1.m;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.util.Log;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends AbstractC0377z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final X f1424c = j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final W f1425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f1426b;

    public static final class b extends V {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final V f1427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f1428b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ConnectivityManager f1429c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f1430d = new Object();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Runnable f1431e;

        /* JADX INFO: renamed from: L2.a$b$a, reason: collision with other inner class name */
        public class RunnableC0037a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f1432a;

            public RunnableC0037a(c cVar) {
                this.f1432a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f1429c.unregisterNetworkCallback(this.f1432a);
            }
        }

        /* JADX INFO: renamed from: L2.a$b$b, reason: collision with other inner class name */
        public class RunnableC0038b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f1434a;

            public RunnableC0038b(d dVar) {
                this.f1434a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f1428b.unregisterReceiver(this.f1434a);
            }
        }

        public class c extends ConnectivityManager.NetworkCallback {
            public c() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                b.this.f1427a.k();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onBlockedStatusChanged(Network network, boolean z4) {
                if (z4) {
                    return;
                }
                b.this.f1427a.k();
            }
        }

        public class d extends BroadcastReceiver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f1437a;

            public d() {
                this.f1437a = false;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                boolean z4 = this.f1437a;
                boolean z5 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
                this.f1437a = z5;
                if (!z5 || z4) {
                    return;
                }
                b.this.f1427a.k();
            }
        }

        public b(V v4, Context context) {
            this.f1427a = v4;
            this.f1428b = context;
            if (context == null) {
                this.f1429c = null;
                return;
            }
            this.f1429c = (ConnectivityManager) context.getSystemService("connectivity");
            try {
                s();
            } catch (SecurityException e4) {
                Log.w("AndroidChannelBuilder", "Failed to configure network monitoring. Does app have ACCESS_NETWORK_STATE permission?", e4);
            }
        }

        @Override // K2.AbstractC0356d
        public String a() {
            return this.f1427a.a();
        }

        @Override // K2.AbstractC0356d
        public AbstractC0359g g(a0 a0Var, C0355c c0355c) {
            return this.f1427a.g(a0Var, c0355c);
        }

        @Override // K2.V
        public boolean j(long j4, TimeUnit timeUnit) {
            return this.f1427a.j(j4, timeUnit);
        }

        @Override // K2.V
        public void k() {
            this.f1427a.k();
        }

        @Override // K2.V
        public EnumC0368p l(boolean z4) {
            return this.f1427a.l(z4);
        }

        @Override // K2.V
        public void m(EnumC0368p enumC0368p, Runnable runnable) {
            this.f1427a.m(enumC0368p, runnable);
        }

        @Override // K2.V
        public V n() {
            t();
            return this.f1427a.n();
        }

        @Override // K2.V
        public V o() {
            t();
            return this.f1427a.o();
        }

        public final void s() {
            if (this.f1429c != null) {
                c cVar = new c();
                this.f1429c.registerDefaultNetworkCallback(cVar);
                this.f1431e = new RunnableC0037a(cVar);
            } else {
                d dVar = new d();
                this.f1428b.registerReceiver(dVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.f1431e = new RunnableC0038b(dVar);
            }
        }

        public final void t() {
            synchronized (this.f1430d) {
                try {
                    Runnable runnable = this.f1431e;
                    if (runnable != null) {
                        runnable.run();
                        this.f1431e = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public a(W w4) {
        this.f1425a = (W) m.o(w4, "delegateBuilder");
    }

    /* JADX WARN: Unreachable blocks removed: 3, instructions: 4 */
    public static X j() {
        try {
            try {
                X x4 = (X) g.class.asSubclass(X.class).getConstructor(new Class[0]).newInstance(new Object[0]);
                if (L.a(x4)) {
                    return x4;
                }
                Log.w("AndroidChannelBuilder", "OkHttpChannelProvider.isAvailable() returned false");
                return null;
            } catch (Exception e4) {
                Log.w("AndroidChannelBuilder", "Failed to construct OkHttpChannelProvider", e4);
                return null;
            }
        } catch (ClassCastException e5) {
            Log.w("AndroidChannelBuilder", "Couldn't cast OkHttpChannelProvider to ManagedChannelProvider", e5);
            return null;
        }
    }

    public static a k(W w4) {
        return new a(w4);
    }

    @Override // K2.AbstractC0376y, K2.W
    public V a() {
        return new b(this.f1425a.a(), this.f1426b);
    }

    @Override // K2.AbstractC0377z, K2.AbstractC0376y
    public W e() {
        return this.f1425a;
    }

    public a i(Context context) {
        this.f1426b = context;
        return this;
    }
}
