package s5;

import H2.m;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import r5.AbstractC2591g;
import r5.AbstractC2609z;
import r5.C2587c;
import r5.EnumC2600p;
import r5.L;
import r5.V;
import r5.W;
import r5.X;
import r5.a0;
import u5.g;

/* JADX INFO: renamed from: s5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2646a extends AbstractC2609z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final X f22998c = j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final W f22999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f23000b;

    /* JADX INFO: renamed from: s5.a$b */
    public static final class b extends V {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final V f23001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f23002b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ConnectivityManager f23003c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f23004d = new Object();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Runnable f23005e;

        /* JADX INFO: renamed from: s5.a$b$a, reason: collision with other inner class name */
        public class RunnableC0357a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f23006a;

            public RunnableC0357a(c cVar) {
                this.f23006a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f23003c.unregisterNetworkCallback(this.f23006a);
            }
        }

        /* JADX INFO: renamed from: s5.a$b$b, reason: collision with other inner class name */
        public class RunnableC0358b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f23008a;

            public RunnableC0358b(d dVar) {
                this.f23008a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f23002b.unregisterReceiver(this.f23008a);
            }
        }

        /* JADX INFO: renamed from: s5.a$b$c */
        public class c extends ConnectivityManager.NetworkCallback {
            public c() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                b.this.f23001a.k();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onBlockedStatusChanged(Network network, boolean z7) {
                if (z7) {
                    return;
                }
                b.this.f23001a.k();
            }
        }

        /* JADX INFO: renamed from: s5.a$b$d */
        public class d extends BroadcastReceiver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f23011a;

            public d() {
                this.f23011a = false;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                boolean z7 = this.f23011a;
                boolean z8 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
                this.f23011a = z8;
                if (!z8 || z7) {
                    return;
                }
                b.this.f23001a.k();
            }
        }

        public b(V v7, Context context) {
            this.f23001a = v7;
            this.f23002b = context;
            if (context == null) {
                this.f23003c = null;
                return;
            }
            this.f23003c = (ConnectivityManager) context.getSystemService("connectivity");
            try {
                s();
            } catch (SecurityException e7) {
                Log.w("AndroidChannelBuilder", "Failed to configure network monitoring. Does app have ACCESS_NETWORK_STATE permission?", e7);
            }
        }

        @Override // r5.AbstractC2588d
        public String a() {
            return this.f23001a.a();
        }

        @Override // r5.AbstractC2588d
        public AbstractC2591g g(a0 a0Var, C2587c c2587c) {
            return this.f23001a.g(a0Var, c2587c);
        }

        @Override // r5.V
        public boolean j(long j7, TimeUnit timeUnit) {
            return this.f23001a.j(j7, timeUnit);
        }

        @Override // r5.V
        public void k() {
            this.f23001a.k();
        }

        @Override // r5.V
        public EnumC2600p l(boolean z7) {
            return this.f23001a.l(z7);
        }

        @Override // r5.V
        public void m(EnumC2600p enumC2600p, Runnable runnable) {
            this.f23001a.m(enumC2600p, runnable);
        }

        @Override // r5.V
        public V n() {
            t();
            return this.f23001a.n();
        }

        @Override // r5.V
        public V o() {
            t();
            return this.f23001a.o();
        }

        public final void s() {
            if (this.f23003c != null) {
                c cVar = new c();
                this.f23003c.registerDefaultNetworkCallback(cVar);
                this.f23005e = new RunnableC0357a(cVar);
            } else {
                d dVar = new d();
                this.f23002b.registerReceiver(dVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.f23005e = new RunnableC0358b(dVar);
            }
        }

        public final void t() {
            synchronized (this.f23004d) {
                try {
                    Runnable runnable = this.f23005e;
                    if (runnable != null) {
                        runnable.run();
                        this.f23005e = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public C2646a(W w7) {
        this.f22999a = (W) m.o(w7, "delegateBuilder");
    }

    /* JADX WARN: Unreachable blocks removed: 3, instructions: 4 */
    public static X j() {
        try {
            try {
                X x7 = (X) g.class.asSubclass(X.class).getConstructor(null).newInstance(null);
                if (L.a(x7)) {
                    return x7;
                }
                Log.w("AndroidChannelBuilder", "OkHttpChannelProvider.isAvailable() returned false");
                return null;
            } catch (Exception e7) {
                Log.w("AndroidChannelBuilder", "Failed to construct OkHttpChannelProvider", e7);
                return null;
            }
        } catch (ClassCastException e8) {
            Log.w("AndroidChannelBuilder", "Couldn't cast OkHttpChannelProvider to ManagedChannelProvider", e8);
            return null;
        }
    }

    public static C2646a k(W w7) {
        return new C2646a(w7);
    }

    @Override // r5.AbstractC2608y, r5.W
    public V a() {
        return new b(this.f22999a.a(), this.f23000b);
    }

    @Override // r5.AbstractC2609z, r5.AbstractC2608y
    public W e() {
        return this.f22999a;
    }

    public C2646a i(Context context) {
        this.f23000b = context;
        return this;
    }
}
