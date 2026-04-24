package j1;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.util.Log;
import j1.InterfaceC2199b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import q1.AbstractC2623f;
import q1.AbstractC2629l;

/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile r f19969d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f19970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f19971b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f19972c;

    public class a implements AbstractC2623f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f19973a;

        public a(Context context) {
            this.f19973a = context;
        }

        @Override // q1.AbstractC2623f.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ConnectivityManager get() {
            return (ConnectivityManager) this.f19973a.getSystemService("connectivity");
        }
    }

    public class b implements InterfaceC2199b.a {
        public b() {
        }

        @Override // j1.InterfaceC2199b.a
        public void a(boolean z7) {
            ArrayList arrayList;
            AbstractC2629l.a();
            synchronized (r.this) {
                arrayList = new ArrayList(r.this.f19971b);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((InterfaceC2199b.a) it.next()).a(z7);
            }
        }
    }

    public interface c {
        boolean a();

        void unregister();
    }

    public static final class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f19976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InterfaceC2199b.a f19977b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AbstractC2623f.b f19978c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ConnectivityManager.NetworkCallback f19979d = new a();

        public class a extends ConnectivityManager.NetworkCallback {

            /* JADX INFO: renamed from: j1.r$d$a$a, reason: collision with other inner class name */
            public class RunnableC0326a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ boolean f19981a;

                public RunnableC0326a(boolean z7) {
                    this.f19981a = z7;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(this.f19981a);
                }
            }

            public a() {
            }

            public void a(boolean z7) {
                AbstractC2629l.a();
                d dVar = d.this;
                boolean z8 = dVar.f19976a;
                dVar.f19976a = z7;
                if (z8 != z7) {
                    dVar.f19977b.a(z7);
                }
            }

            public final void b(boolean z7) {
                AbstractC2629l.u(new RunnableC0326a(z7));
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

        public d(AbstractC2623f.b bVar, InterfaceC2199b.a aVar) {
            this.f19978c = bVar;
            this.f19977b = aVar;
        }

        @Override // j1.r.c
        public boolean a() {
            this.f19976a = ((ConnectivityManager) this.f19978c.get()).getActiveNetwork() != null;
            try {
                ((ConnectivityManager) this.f19978c.get()).registerDefaultNetworkCallback(this.f19979d);
                return true;
            } catch (RuntimeException e8) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to register callback", e8);
                }
                return false;
            }
        }

        @Override // j1.r.c
        public void unregister() {
            ((ConnectivityManager) this.f19978c.get()).unregisterNetworkCallback(this.f19979d);
        }
    }

    public r(Context context) {
        this.f19970a = new d(AbstractC2623f.a(new a(context)), new b());
    }

    public static r a(Context context) {
        if (f19969d == null) {
            synchronized (r.class) {
                try {
                    if (f19969d == null) {
                        f19969d = new r(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return f19969d;
    }

    public final void b() {
        if (this.f19972c || this.f19971b.isEmpty()) {
            return;
        }
        this.f19972c = this.f19970a.a();
    }

    public final void c() {
        if (this.f19972c && this.f19971b.isEmpty()) {
            this.f19970a.unregister();
            this.f19972c = false;
        }
    }

    public synchronized void d(InterfaceC2199b.a aVar) {
        this.f19971b.add(aVar);
        b();
    }

    public synchronized void e(InterfaceC2199b.a aVar) {
        this.f19971b.remove(aVar);
        c();
    }
}
