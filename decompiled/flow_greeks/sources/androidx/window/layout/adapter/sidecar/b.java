package androidx.window.layout.adapter.sidecar;

import android.app.Activity;
import android.content.Context;
import androidx.window.layout.adapter.sidecar.a;
import androidx.window.layout.adapter.sidecar.b;
import cd.h0;
import dd.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import t2.l;
import w2.s;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements x2.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile b f2888d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public androidx.window.layout.adapter.sidecar.a f2890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f2891b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f2887c = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReentrantLock f2889e = new ReentrantLock();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(k kVar) {
            this();
        }

        public final b a(Context context) {
            t.f(context, "context");
            if (b.f2888d == null) {
                ReentrantLock reentrantLock = b.f2889e;
                reentrantLock.lock();
                try {
                    if (b.f2888d == null) {
                        b.f2888d = new b(b.f2887c.b(context));
                    }
                    h0 h0Var = h0.f3852a;
                    reentrantLock.unlock();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
            b bVar = b.f2888d;
            t.c(bVar);
            return bVar;
        }

        public final androidx.window.layout.adapter.sidecar.a b(Context context) {
            t.f(context, "context");
            try {
                if (c(SidecarCompat.f2875f.c())) {
                    SidecarCompat sidecarCompat = new SidecarCompat(context);
                    if (sidecarCompat.n()) {
                        return sidecarCompat;
                    }
                    return null;
                }
            } catch (Throwable unused) {
            }
            return null;
        }

        public final boolean c(l lVar) {
            return lVar != null && lVar.compareTo(l.f20667f.a()) >= 0;
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: androidx.window.layout.adapter.sidecar.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class C0044b implements a.InterfaceC0043a {
        public C0044b() {
        }

        @Override // androidx.window.layout.adapter.sidecar.a.InterfaceC0043a
        public void a(Activity activity, s newLayout) {
            t.f(activity, "activity");
            t.f(newLayout, "newLayout");
            Iterator it = b.this.g().iterator();
            t.e(it, "iterator(...)");
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (t.b(cVar.d(), activity)) {
                    cVar.b(newLayout);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f2893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f2894b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final s0.a f2895c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public s f2896d;

        public c(Activity activity, Executor executor, s0.a callback) {
            t.f(activity, "activity");
            t.f(executor, "executor");
            t.f(callback, "callback");
            this.f2893a = activity;
            this.f2894b = executor;
            this.f2895c = callback;
        }

        public static final void c(c cVar, s sVar) {
            cVar.f2895c.accept(sVar);
        }

        public final void b(final s newLayoutInfo) {
            t.f(newLayoutInfo, "newLayoutInfo");
            this.f2896d = newLayoutInfo;
            this.f2894b.execute(new Runnable() { // from class: z2.g
                @Override // java.lang.Runnable
                public final void run() {
                    b.c.c(this.f25589a, newLayoutInfo);
                }
            });
        }

        public final Activity d() {
            return this.f2893a;
        }

        public final s0.a e() {
            return this.f2895c;
        }

        public final s f() {
            return this.f2896d;
        }
    }

    public b(androidx.window.layout.adapter.sidecar.a aVar) {
        this.f2890a = aVar;
        androidx.window.layout.adapter.sidecar.a aVar2 = this.f2890a;
        if (aVar2 != null) {
            aVar2.a(new C0044b());
        }
    }

    @Override // x2.a
    public void a(s0.a callback) {
        t.f(callback, "callback");
        synchronized (f2889e) {
            try {
                if (this.f2890a == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = this.f2891b.iterator();
                t.e(it, "iterator(...)");
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar.e() == callback) {
                        t.c(cVar);
                        arrayList.add(cVar);
                    }
                }
                this.f2891b.removeAll(arrayList);
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    f(((c) it2.next()).d());
                }
                h0 h0Var = h0.f3852a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // x2.a
    public void b(Context context, Executor executor, s0.a callback) {
        Object next;
        t.f(context, "context");
        t.f(executor, "executor");
        t.f(callback, "callback");
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            callback.accept(new s(r.k()));
            return;
        }
        ReentrantLock reentrantLock = f2889e;
        reentrantLock.lock();
        try {
            androidx.window.layout.adapter.sidecar.a aVar = this.f2890a;
            if (aVar == null) {
                callback.accept(new s(r.k()));
                return;
            }
            boolean zH = h(activity);
            c cVar = new c(activity, executor, callback);
            this.f2891b.add(cVar);
            if (zH) {
                Iterator it = this.f2891b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (t.b(activity, ((c) next).d())) {
                            break;
                        }
                    }
                }
                c cVar2 = (c) next;
                s sVarF = cVar2 != null ? cVar2.f() : null;
                if (sVarF != null) {
                    cVar.b(sVarF);
                }
            } else {
                aVar.b(activity);
            }
            h0 h0Var = h0.f3852a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void f(Activity activity) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f2891b;
        if (copyOnWriteArrayList == null || !copyOnWriteArrayList.isEmpty()) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (t.b(((c) it.next()).d(), activity)) {
                    return;
                }
            }
        }
        androidx.window.layout.adapter.sidecar.a aVar = this.f2890a;
        if (aVar != null) {
            aVar.c(activity);
        }
    }

    public final CopyOnWriteArrayList g() {
        return this.f2891b;
    }

    public final boolean h(Activity activity) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f2891b;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (t.b(((c) it.next()).d(), activity)) {
                return true;
            }
        }
        return false;
    }
}
