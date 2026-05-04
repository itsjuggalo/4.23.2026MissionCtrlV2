package v3;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.util.Log;
import c4.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import v3.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile r f23118d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f23119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f23120b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f23121c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f23122a;

        public a(Context context) {
            this.f23122a = context;
        }

        @Override // c4.f.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ConnectivityManager get() {
            return (ConnectivityManager) this.f23122a.getSystemService("connectivity");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements b.a {
        public b() {
        }

        @Override // v3.b.a
        public void a(boolean z10) {
            ArrayList arrayList;
            c4.l.a();
            synchronized (r.this) {
                arrayList = new ArrayList(r.this.f23120b);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((b.a) it.next()).a(z10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface c {
        boolean a();

        void unregister();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f23125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b.a f23126b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final f.b f23127c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ConnectivityManager.NetworkCallback f23128d = new a();

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a extends ConnectivityManager.NetworkCallback {

            /* JADX INFO: renamed from: v3.r$d$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public class RunnableC0400a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ boolean f23130a;

                public RunnableC0400a(boolean z10) {
                    this.f23130a = z10;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(this.f23130a);
                }
            }

            public a() {
            }

            public void a(boolean z10) {
                c4.l.a();
                d dVar = d.this;
                boolean z11 = dVar.f23125a;
                dVar.f23125a = z10;
                if (z11 != z10) {
                    dVar.f23126b.a(z10);
                }
            }

            public final void b(boolean z10) {
                c4.l.v(new RunnableC0400a(z10));
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                b(true);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                b(false);
            }
        }

        public d(f.b bVar, b.a aVar) {
            this.f23127c = bVar;
            this.f23126b = aVar;
        }

        @Override // v3.r.c
        public boolean a() {
            this.f23125a = ((ConnectivityManager) this.f23127c.get()).getActiveNetwork() != null;
            try {
                ((ConnectivityManager) this.f23127c.get()).registerDefaultNetworkCallback(this.f23128d);
                return true;
            } catch (RuntimeException e10) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to register callback", e10);
                }
                return false;
            }
        }

        @Override // v3.r.c
        public void unregister() {
            ((ConnectivityManager) this.f23127c.get()).unregisterNetworkCallback(this.f23128d);
        }
    }

    public r(Context context) {
        this.f23119a = new d(c4.f.a(new a(context)), new b());
    }

    public static r a(Context context) {
        if (f23118d == null) {
            synchronized (r.class) {
                try {
                    if (f23118d == null) {
                        f23118d = new r(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return f23118d;
    }

    public final void b() {
        if (this.f23121c || this.f23120b.isEmpty()) {
            return;
        }
        this.f23121c = this.f23119a.a();
    }

    public final void c() {
        if (this.f23121c && this.f23120b.isEmpty()) {
            this.f23119a.unregister();
            this.f23121c = false;
        }
    }

    public synchronized void d(b.a aVar) {
        this.f23120b.add(aVar);
        b();
    }

    public synchronized void e(b.a aVar) {
        this.f23120b.remove(aVar);
        c();
    }
}
