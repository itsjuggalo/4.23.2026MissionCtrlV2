package S1;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: S1.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0236e {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final HashMap f2859o = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f2861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2862c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2865g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Intent f2866h;
    public final E i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ServiceConnectionC0235d f2870m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public IInterface f2871n;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f2863d = new ArrayList();
    public final HashSet e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f2864f = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final B f2868k = new IBinder.DeathRecipient() { // from class: S1.B
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            C0236e c0236e = this.f2845a;
            c0236e.f2861b.b("reportBinderDeath", new Object[0]);
            if (c0236e.f2867j.get() != null) {
                throw new ClassCastException();
            }
            c0236e.f2861b.b("%s : Binder has died.", c0236e.f2862c);
            Iterator it = c0236e.f2863d.iterator();
            while (it.hasNext()) {
                ((A) it.next()).a(new RemoteException(String.valueOf(c0236e.f2862c).concat(" : Binder has died.")));
            }
            c0236e.f2863d.clear();
            synchronized (c0236e.f2864f) {
                c0236e.e();
            }
        }
    };

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicInteger f2869l = new AtomicInteger(0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final WeakReference f2867j = new WeakReference(null);

    /* JADX WARN: Type inference failed for: r0v3, types: [S1.B] */
    public C0236e(Context context, z zVar, String str, Intent intent, E e) {
        this.f2860a = context;
        this.f2861b = zVar;
        this.f2862c = str;
        this.f2866h = intent;
        this.i = e;
    }

    public static void b(C0236e c0236e, A a6) {
        IInterface iInterface = c0236e.f2871n;
        ArrayList arrayList = c0236e.f2863d;
        z zVar = c0236e.f2861b;
        if (iInterface != null || c0236e.f2865g) {
            if (!c0236e.f2865g) {
                a6.run();
                return;
            } else {
                zVar.b("Waiting to bind to the service.", new Object[0]);
                arrayList.add(a6);
                return;
            }
        }
        zVar.b("Initiate binding to the service.", new Object[0]);
        arrayList.add(a6);
        ServiceConnectionC0235d serviceConnectionC0235d = new ServiceConnectionC0235d(c0236e);
        c0236e.f2870m = serviceConnectionC0235d;
        c0236e.f2865g = true;
        if (c0236e.f2860a.bindService(c0236e.f2866h, serviceConnectionC0235d, 1)) {
            return;
        }
        zVar.b("Failed to bind to the service.", new Object[0]);
        c0236e.f2865g = false;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((A) it.next()).a(new f("Failed to bind to the service."));
        }
        arrayList.clear();
    }

    public final Handler a() {
        Handler handler;
        HashMap map = f2859o;
        synchronized (map) {
            try {
                if (!map.containsKey(this.f2862c)) {
                    HandlerThread handlerThread = new HandlerThread(this.f2862c, 10);
                    handlerThread.start();
                    map.put(this.f2862c, new Handler(handlerThread.getLooper()));
                }
                handler = (Handler) map.get(this.f2862c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public final void c(A a6, TaskCompletionSource taskCompletionSource) {
        a().post(new D(this, a6.c(), taskCompletionSource, a6));
    }

    public final void d(TaskCompletionSource taskCompletionSource) {
        synchronized (this.f2864f) {
            this.e.remove(taskCompletionSource);
        }
        a().post(new C0234c(this, 1));
    }

    public final void e() {
        HashSet hashSet = this.e;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((TaskCompletionSource) it.next()).trySetException(new RemoteException(String.valueOf(this.f2862c).concat(" : Binder has died.")));
        }
        hashSet.clear();
    }
}
