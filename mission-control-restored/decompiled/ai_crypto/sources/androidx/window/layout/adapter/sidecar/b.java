package androidx.window.layout.adapter.sidecar;

import E5.E;
import F5.AbstractC0556n;
import O0.k;
import R0.j;
import android.app.Activity;
import android.content.Context;
import androidx.window.layout.adapter.sidecar.a;
import androidx.window.layout.adapter.sidecar.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class b implements S0.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile b f8461d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public androidx.window.layout.adapter.sidecar.a f8463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f8464b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f8460c = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReentrantLock f8462e = new ReentrantLock();

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final b a(Context context) {
            r.f(context, "context");
            if (b.f8461d == null) {
                ReentrantLock reentrantLock = b.f8462e;
                reentrantLock.lock();
                try {
                    if (b.f8461d == null) {
                        b.f8461d = new b(b.f8460c.b(context));
                    }
                    E e7 = E.f1657a;
                    reentrantLock.unlock();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
            b bVar = b.f8461d;
            r.c(bVar);
            return bVar;
        }

        public final androidx.window.layout.adapter.sidecar.a b(Context context) {
            r.f(context, "context");
            try {
                if (!c(SidecarCompat.f8448f.c())) {
                    return null;
                }
                SidecarCompat sidecarCompat = new SidecarCompat(context);
                if (sidecarCompat.n()) {
                    return sidecarCompat;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        public final boolean c(k kVar) {
            return kVar != null && kVar.compareTo(k.f4037f.a()) >= 0;
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: androidx.window.layout.adapter.sidecar.b$b, reason: collision with other inner class name */
    public final class C0142b implements a.InterfaceC0141a {
        public C0142b() {
        }

        @Override // androidx.window.layout.adapter.sidecar.a.InterfaceC0141a
        public void a(Activity activity, j newLayout) {
            r.f(activity, "activity");
            r.f(newLayout, "newLayout");
            for (c cVar : b.this.g()) {
                if (r.b(cVar.d(), activity)) {
                    cVar.b(newLayout);
                }
            }
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f8466a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f8467b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final P.a f8468c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public j f8469d;

        public c(Activity activity, Executor executor, P.a callback) {
            r.f(activity, "activity");
            r.f(executor, "executor");
            r.f(callback, "callback");
            this.f8466a = activity;
            this.f8467b = executor;
            this.f8468c = callback;
        }

        public static final void c(c this$0, j newLayoutInfo) {
            r.f(this$0, "this$0");
            r.f(newLayoutInfo, "$newLayoutInfo");
            this$0.f8468c.accept(newLayoutInfo);
        }

        public final void b(final j newLayoutInfo) {
            r.f(newLayoutInfo, "newLayoutInfo");
            this.f8469d = newLayoutInfo;
            this.f8467b.execute(new Runnable() { // from class: U0.c
                @Override // java.lang.Runnable
                public final void run() {
                    b.c.c(this.f4758a, newLayoutInfo);
                }
            });
        }

        public final Activity d() {
            return this.f8466a;
        }

        public final P.a e() {
            return this.f8468c;
        }

        public final j f() {
            return this.f8469d;
        }
    }

    public b(androidx.window.layout.adapter.sidecar.a aVar) {
        this.f8463a = aVar;
        androidx.window.layout.adapter.sidecar.a aVar2 = this.f8463a;
        if (aVar2 != null) {
            aVar2.a(new C0142b());
        }
    }

    @Override // S0.a
    public void a(Context context, Executor executor, P.a callback) {
        Object next;
        r.f(context, "context");
        r.f(executor, "executor");
        r.f(callback, "callback");
        E e7 = null;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            ReentrantLock reentrantLock = f8462e;
            reentrantLock.lock();
            try {
                androidx.window.layout.adapter.sidecar.a aVar = this.f8463a;
                if (aVar == null) {
                    callback.accept(new j(AbstractC0556n.g()));
                    return;
                }
                boolean zH = h(activity);
                c cVar = new c(activity, executor, callback);
                this.f8464b.add(cVar);
                if (zH) {
                    Iterator it = this.f8464b.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        } else {
                            next = it.next();
                            if (r.b(activity, ((c) next).d())) {
                                break;
                            }
                        }
                    }
                    c cVar2 = (c) next;
                    j jVarF = cVar2 != null ? cVar2.f() : null;
                    if (jVarF != null) {
                        cVar.b(jVarF);
                    }
                } else {
                    aVar.b(activity);
                }
                E e8 = E.f1657a;
                reentrantLock.unlock();
                e7 = E.f1657a;
            } finally {
                reentrantLock.unlock();
            }
        }
        if (e7 == null) {
            callback.accept(new j(AbstractC0556n.g()));
        }
    }

    @Override // S0.a
    public void b(P.a callback) {
        r.f(callback, "callback");
        synchronized (f8462e) {
            try {
                if (this.f8463a == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (c callbackWrapper : this.f8464b) {
                    if (callbackWrapper.e() == callback) {
                        r.e(callbackWrapper, "callbackWrapper");
                        arrayList.add(callbackWrapper);
                    }
                }
                this.f8464b.removeAll(arrayList);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    f(((c) it.next()).d());
                }
                E e7 = E.f1657a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f(Activity activity) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f8464b;
        if (copyOnWriteArrayList == null || !copyOnWriteArrayList.isEmpty()) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (r.b(((c) it.next()).d(), activity)) {
                    return;
                }
            }
        }
        androidx.window.layout.adapter.sidecar.a aVar = this.f8463a;
        if (aVar != null) {
            aVar.c(activity);
        }
    }

    public final CopyOnWriteArrayList g() {
        return this.f8464b;
    }

    public final boolean h(Activity activity) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f8464b;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (r.b(((c) it.next()).d(), activity)) {
                return true;
            }
        }
        return false;
    }
}
