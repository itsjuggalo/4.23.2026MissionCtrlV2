package sb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import p6.n;
import rb.g;
import rb.l0;
import rb.p;
import rb.u0;
import rb.v0;
import rb.w0;
import rb.z;
import rb.z0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final w0 f20181c = j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v0 f20182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f20183b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends u0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u0 f20184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f20185b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ConnectivityManager f20186c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f20187d = new Object();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Runnable f20188e;

        /* JADX INFO: renamed from: sb.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class RunnableC0357a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f20189a;

            public RunnableC0357a(c cVar) {
                this.f20189a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f20186c.unregisterNetworkCallback(this.f20189a);
            }
        }

        /* JADX INFO: renamed from: sb.a$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class RunnableC0358b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f20191a;

            public RunnableC0358b(d dVar) {
                this.f20191a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f20185b.unregisterReceiver(this.f20191a);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class c extends ConnectivityManager.NetworkCallback {
            public c() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                b.this.f20184a.j();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onBlockedStatusChanged(Network network, boolean z10) {
                if (z10) {
                    return;
                }
                b.this.f20184a.j();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class d extends BroadcastReceiver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f20194a;

            public d() {
                this.f20194a = false;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                boolean z10 = this.f20194a;
                boolean z11 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
                this.f20194a = z11;
                if (!z11 || z10) {
                    return;
                }
                b.this.f20184a.j();
            }
        }

        public b(u0 u0Var, Context context) {
            this.f20184a = u0Var;
            this.f20185b = context;
            if (context == null) {
                this.f20186c = null;
                return;
            }
            this.f20186c = (ConnectivityManager) context.getSystemService("connectivity");
            try {
                r();
            } catch (SecurityException e10) {
                Log.w("AndroidChannelBuilder", "Failed to configure network monitoring. Does app have ACCESS_NETWORK_STATE permission?", e10);
            }
        }

        @Override // rb.d
        public String a() {
            return this.f20184a.a();
        }

        @Override // rb.d
        public g e(z0 z0Var, rb.c cVar) {
            return this.f20184a.e(z0Var, cVar);
        }

        @Override // rb.u0
        public boolean i(long j10, TimeUnit timeUnit) {
            return this.f20184a.i(j10, timeUnit);
        }

        @Override // rb.u0
        public void j() {
            this.f20184a.j();
        }

        @Override // rb.u0
        public p k(boolean z10) {
            return this.f20184a.k(z10);
        }

        @Override // rb.u0
        public void l(p pVar, Runnable runnable) {
            this.f20184a.l(pVar, runnable);
        }

        @Override // rb.u0
        public u0 m() {
            s();
            return this.f20184a.m();
        }

        @Override // rb.u0
        public u0 n() {
            s();
            return this.f20184a.n();
        }

        public final void r() {
            if (this.f20186c != null) {
                c cVar = new c();
                this.f20186c.registerDefaultNetworkCallback(cVar);
                this.f20188e = new RunnableC0357a(cVar);
            } else {
                d dVar = new d();
                this.f20185b.registerReceiver(dVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.f20188e = new RunnableC0358b(dVar);
            }
        }

        public final void s() {
            synchronized (this.f20187d) {
                try {
                    Runnable runnable = this.f20188e;
                    if (runnable != null) {
                        runnable.run();
                        this.f20188e = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public a(v0 v0Var) {
        this.f20182a = (v0) n.o(v0Var, "delegateBuilder");
    }

    /* JADX WARN: Unreachable blocks removed: 3, instructions: 4 */
    public static w0 j() {
        try {
            try {
                w0 w0Var = (w0) ub.g.class.asSubclass(w0.class).getConstructor(null).newInstance(null);
                if (l0.a(w0Var)) {
                    return w0Var;
                }
                Log.w("AndroidChannelBuilder", "OkHttpChannelProvider.isAvailable() returned false");
                return null;
            } catch (Exception e10) {
                Log.w("AndroidChannelBuilder", "Failed to construct OkHttpChannelProvider", e10);
                return null;
            }
        } catch (ClassCastException e11) {
            Log.w("AndroidChannelBuilder", "Couldn't cast OkHttpChannelProvider to ManagedChannelProvider", e11);
            return null;
        }
    }

    public static a k(v0 v0Var) {
        return new a(v0Var);
    }

    @Override // rb.y, rb.v0
    public u0 a() {
        return new b(this.f20182a.a(), this.f20183b);
    }

    @Override // rb.z, rb.y
    public v0 e() {
        return this.f20182a;
    }

    public a i(Context context) {
        this.f20183b = context;
        return this;
    }
}
