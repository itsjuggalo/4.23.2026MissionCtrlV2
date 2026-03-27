package androidx.window.layout.adapter.sidecar;

import A0.j;
import W2.E;
import X2.AbstractC0769p;
import android.app.Activity;
import android.content.Context;
import androidx.window.layout.adapter.sidecar.a;
import androidx.window.layout.adapter.sidecar.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import x0.C1922k;

/* JADX INFO: loaded from: classes.dex */
public final class b implements B0.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile b f8226d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public androidx.window.layout.adapter.sidecar.a f8228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f8229b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f8225c = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReentrantLock f8227e = new ReentrantLock();

    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b a(Context context) {
            r.f(context, "context");
            if (b.f8226d == null) {
                ReentrantLock reentrantLock = b.f8227e;
                reentrantLock.lock();
                try {
                    if (b.f8226d == null) {
                        b.f8226d = new b(b.f8225c.b(context));
                    }
                    E e4 = E.f5463a;
                    reentrantLock.unlock();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
            b bVar = b.f8226d;
            r.c(bVar);
            return bVar;
        }

        public final androidx.window.layout.adapter.sidecar.a b(Context context) {
            r.f(context, "context");
            try {
                if (c(SidecarCompat.f8213f.c())) {
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

        public final boolean c(C1922k c1922k) {
            return c1922k != null && c1922k.compareTo(C1922k.f15722f.a()) >= 0;
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: androidx.window.layout.adapter.sidecar.b$b, reason: collision with other inner class name */
    public final class C0120b implements a.InterfaceC0119a {
        public C0120b() {
        }

        @Override // androidx.window.layout.adapter.sidecar.a.InterfaceC0119a
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
        public final Activity f8231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f8232b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final G.a f8233c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public j f8234d;

        public c(Activity activity, Executor executor, G.a callback) {
            r.f(activity, "activity");
            r.f(executor, "executor");
            r.f(callback, "callback");
            this.f8231a = activity;
            this.f8232b = executor;
            this.f8233c = callback;
        }

        public static final void c(c this$0, j newLayoutInfo) {
            r.f(this$0, "this$0");
            r.f(newLayoutInfo, "$newLayoutInfo");
            this$0.f8233c.accept(newLayoutInfo);
        }

        public final void b(final j newLayoutInfo) {
            r.f(newLayoutInfo, "newLayoutInfo");
            this.f8234d = newLayoutInfo;
            this.f8232b.execute(new Runnable() { // from class: D0.c
                @Override // java.lang.Runnable
                public final void run() {
                    b.c.c(this.f312a, newLayoutInfo);
                }
            });
        }

        public final Activity d() {
            return this.f8231a;
        }

        public final G.a e() {
            return this.f8233c;
        }

        public final j f() {
            return this.f8234d;
        }
    }

    public b(androidx.window.layout.adapter.sidecar.a aVar) {
        this.f8228a = aVar;
        androidx.window.layout.adapter.sidecar.a aVar2 = this.f8228a;
        if (aVar2 != null) {
            aVar2.a(new C0120b());
        }
    }

    @Override // B0.a
    public void a(G.a callback) {
        r.f(callback, "callback");
        synchronized (f8227e) {
            try {
                if (this.f8228a == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (c callbackWrapper : this.f8229b) {
                    if (callbackWrapper.e() == callback) {
                        r.e(callbackWrapper, "callbackWrapper");
                        arrayList.add(callbackWrapper);
                    }
                }
                this.f8229b.removeAll(arrayList);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    f(((c) it.next()).d());
                }
                E e4 = E.f5463a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // B0.a
    public void b(Context context, Executor executor, G.a callback) {
        Object next;
        r.f(context, "context");
        r.f(executor, "executor");
        r.f(callback, "callback");
        E e4 = null;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            ReentrantLock reentrantLock = f8227e;
            reentrantLock.lock();
            try {
                androidx.window.layout.adapter.sidecar.a aVar = this.f8228a;
                if (aVar == null) {
                    callback.accept(new j(AbstractC0769p.g()));
                    return;
                }
                boolean zH = h(activity);
                c cVar = new c(activity, executor, callback);
                this.f8229b.add(cVar);
                if (zH) {
                    Iterator it = this.f8229b.iterator();
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
                E e5 = E.f5463a;
                reentrantLock.unlock();
                e4 = E.f5463a;
            } finally {
                reentrantLock.unlock();
            }
        }
        if (e4 == null) {
            callback.accept(new j(AbstractC0769p.g()));
        }
    }

    public final void f(Activity activity) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f8229b;
        if (copyOnWriteArrayList == null || !copyOnWriteArrayList.isEmpty()) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (r.b(((c) it.next()).d(), activity)) {
                    return;
                }
            }
        }
        androidx.window.layout.adapter.sidecar.a aVar = this.f8228a;
        if (aVar != null) {
            aVar.c(activity);
        }
    }

    public final CopyOnWriteArrayList g() {
        return this.f8229b;
    }

    public final boolean h(Activity activity) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f8229b;
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
