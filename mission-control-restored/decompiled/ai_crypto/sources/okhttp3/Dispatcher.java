package okhttp3;

import com.google.android.gms.common.api.a;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.RealCall;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes2.dex */
public final class Dispatcher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Runnable f20471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ExecutorService f20472d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20469a = 64;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20470b = 5;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Deque f20473e = new ArrayDeque();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Deque f20474f = new ArrayDeque();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Deque f20475g = new ArrayDeque();

    public synchronized ExecutorService a() {
        try {
            if (this.f20472d == null) {
                this.f20472d = new ThreadPoolExecutor(0, a.e.API_PRIORITY_OTHER, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.F("OkHttp Dispatcher", false));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f20472d;
    }

    public final void b(Deque deque, Object obj) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(obj)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.f20471c;
        }
        if (d() || runnable == null) {
            return;
        }
        runnable.run();
    }

    public void c(RealCall.AsyncCall asyncCall) {
        b(this.f20474f, asyncCall);
    }

    public final boolean d() {
        int i7;
        boolean z7;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator it = this.f20473e.iterator();
                while (it.hasNext()) {
                    RealCall.AsyncCall asyncCall = (RealCall.AsyncCall) it.next();
                    if (this.f20474f.size() >= this.f20469a) {
                        break;
                    }
                    if (f(asyncCall) < this.f20470b) {
                        it.remove();
                        arrayList.add(asyncCall);
                        this.f20474f.add(asyncCall);
                    }
                }
                z7 = e() > 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        int size = arrayList.size();
        for (i7 = 0; i7 < size; i7++) {
            ((RealCall.AsyncCall) arrayList.get(i7)).l(a());
        }
        return z7;
    }

    public synchronized int e() {
        return this.f20474f.size() + this.f20475g.size();
    }

    public final int f(RealCall.AsyncCall asyncCall) {
        int i7 = 0;
        for (RealCall.AsyncCall asyncCall2 : this.f20474f) {
            if (!asyncCall2.m().f20603f && asyncCall2.n().equals(asyncCall.n())) {
                i7++;
            }
        }
        return i7;
    }
}
