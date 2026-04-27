package androidx.activity;

import W2.E;
import X2.C0760g;
import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.q;
import androidx.lifecycle.AbstractC0846i;
import androidx.lifecycle.InterfaceC0848k;
import androidx.lifecycle.InterfaceC0850m;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f6292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final G.a f6293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0760g f6294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p f6295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OnBackInvokedCallback f6296e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OnBackInvokedDispatcher f6297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f6298g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6299h;

    public static final class a extends kotlin.jvm.internal.s implements i3.k {
        public a() {
            super(1);
        }

        public final void a(androidx.activity.b backEvent) {
            kotlin.jvm.internal.r.f(backEvent, "backEvent");
            q.this.m(backEvent);
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((androidx.activity.b) obj);
            return E.f5463a;
        }
    }

    public static final class b extends kotlin.jvm.internal.s implements i3.k {
        public b() {
            super(1);
        }

        public final void a(androidx.activity.b backEvent) {
            kotlin.jvm.internal.r.f(backEvent, "backEvent");
            q.this.l(backEvent);
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((androidx.activity.b) obj);
            return E.f5463a;
        }
    }

    public static final class c extends kotlin.jvm.internal.s implements Function0 {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m2invoke();
            return E.f5463a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m2invoke() {
            q.this.k();
        }
    }

    public static final class d extends kotlin.jvm.internal.s implements Function0 {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m3invoke();
            return E.f5463a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m3invoke() {
            q.this.j();
        }
    }

    public static final class e extends kotlin.jvm.internal.s implements Function0 {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m4invoke();
            return E.f5463a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m4invoke() {
            q.this.k();
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f6305a = new f();

        public static final void c(Function0 onBackInvoked) {
            kotlin.jvm.internal.r.f(onBackInvoked, "$onBackInvoked");
            onBackInvoked.invoke();
        }

        public final OnBackInvokedCallback b(final Function0 onBackInvoked) {
            kotlin.jvm.internal.r.f(onBackInvoked, "onBackInvoked");
            return new OnBackInvokedCallback() { // from class: androidx.activity.r
                public final void onBackInvoked() {
                    q.f.c(onBackInvoked);
                }
            };
        }

        public final void d(Object dispatcher, int i4, Object callback) {
            kotlin.jvm.internal.r.f(dispatcher, "dispatcher");
            kotlin.jvm.internal.r.f(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).registerOnBackInvokedCallback(i4, (OnBackInvokedCallback) callback);
        }

        public final void e(Object dispatcher, Object callback) {
            kotlin.jvm.internal.r.f(dispatcher, "dispatcher");
            kotlin.jvm.internal.r.f(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).unregisterOnBackInvokedCallback((OnBackInvokedCallback) callback);
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f6306a = new g();

        public static final class a implements OnBackAnimationCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ i3.k f6307a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ i3.k f6308b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Function0 f6309c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Function0 f6310d;

            public a(i3.k kVar, i3.k kVar2, Function0 function0, Function0 function02) {
                this.f6307a = kVar;
                this.f6308b = kVar2;
                this.f6309c = function0;
                this.f6310d = function02;
            }

            public void onBackCancelled() {
                this.f6310d.invoke();
            }

            public void onBackInvoked() {
                this.f6309c.invoke();
            }

            public void onBackProgressed(BackEvent backEvent) {
                kotlin.jvm.internal.r.f(backEvent, "backEvent");
                this.f6308b.invoke(new androidx.activity.b(backEvent));
            }

            public void onBackStarted(BackEvent backEvent) {
                kotlin.jvm.internal.r.f(backEvent, "backEvent");
                this.f6307a.invoke(new androidx.activity.b(backEvent));
            }
        }

        public final OnBackInvokedCallback a(i3.k onBackStarted, i3.k onBackProgressed, Function0 onBackInvoked, Function0 onBackCancelled) {
            kotlin.jvm.internal.r.f(onBackStarted, "onBackStarted");
            kotlin.jvm.internal.r.f(onBackProgressed, "onBackProgressed");
            kotlin.jvm.internal.r.f(onBackInvoked, "onBackInvoked");
            kotlin.jvm.internal.r.f(onBackCancelled, "onBackCancelled");
            return new a(onBackStarted, onBackProgressed, onBackInvoked, onBackCancelled);
        }
    }

    public final class h implements InterfaceC0848k, androidx.activity.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC0846i f6311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p f6312b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public androidx.activity.c f6313c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ q f6314d;

        public h(q qVar, AbstractC0846i lifecycle, p onBackPressedCallback) {
            kotlin.jvm.internal.r.f(lifecycle, "lifecycle");
            kotlin.jvm.internal.r.f(onBackPressedCallback, "onBackPressedCallback");
            this.f6314d = qVar;
            this.f6311a = lifecycle;
            this.f6312b = onBackPressedCallback;
            lifecycle.a(this);
        }

        @Override // androidx.lifecycle.InterfaceC0848k
        public void a(InterfaceC0850m source, AbstractC0846i.a event) {
            kotlin.jvm.internal.r.f(source, "source");
            kotlin.jvm.internal.r.f(event, "event");
            if (event == AbstractC0846i.a.ON_START) {
                this.f6313c = this.f6314d.i(this.f6312b);
                return;
            }
            if (event != AbstractC0846i.a.ON_STOP) {
                if (event == AbstractC0846i.a.ON_DESTROY) {
                    cancel();
                }
            } else {
                androidx.activity.c cVar = this.f6313c;
                if (cVar != null) {
                    cVar.cancel();
                }
            }
        }

        @Override // androidx.activity.c
        public void cancel() {
            this.f6311a.c(this);
            this.f6312b.removeCancellable(this);
            androidx.activity.c cVar = this.f6313c;
            if (cVar != null) {
                cVar.cancel();
            }
            this.f6313c = null;
        }
    }

    public final class i implements androidx.activity.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p f6315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q f6316b;

        public i(q qVar, p onBackPressedCallback) {
            kotlin.jvm.internal.r.f(onBackPressedCallback, "onBackPressedCallback");
            this.f6316b = qVar;
            this.f6315a = onBackPressedCallback;
        }

        @Override // androidx.activity.c
        public void cancel() {
            this.f6316b.f6294c.remove(this.f6315a);
            if (kotlin.jvm.internal.r.b(this.f6316b.f6295d, this.f6315a)) {
                this.f6315a.handleOnBackCancelled();
                this.f6316b.f6295d = null;
            }
            this.f6315a.removeCancellable(this);
            Function0 enabledChangedCallback$activity_release = this.f6315a.getEnabledChangedCallback$activity_release();
            if (enabledChangedCallback$activity_release != null) {
                enabledChangedCallback$activity_release.invoke();
            }
            this.f6315a.setEnabledChangedCallback$activity_release(null);
        }
    }

    public /* synthetic */ class j extends kotlin.jvm.internal.o implements Function0 {
        public j(Object obj) {
            super(0, obj, q.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        public final void d() {
            ((q) this.receiver).p();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            d();
            return E.f5463a;
        }
    }

    public /* synthetic */ class k extends kotlin.jvm.internal.o implements Function0 {
        public k(Object obj) {
            super(0, obj, q.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        public final void d() {
            ((q) this.receiver).p();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            d();
            return E.f5463a;
        }
    }

    public q(Runnable runnable, G.a aVar) {
        this.f6292a = runnable;
        this.f6293b = aVar;
        this.f6294c = new C0760g();
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 33) {
            this.f6296e = i4 >= 34 ? g.f6306a.a(new a(), new b(), new c(), new d()) : f.f6305a.b(new e());
        }
    }

    public final void h(InterfaceC0850m owner, p onBackPressedCallback) {
        kotlin.jvm.internal.r.f(owner, "owner");
        kotlin.jvm.internal.r.f(onBackPressedCallback, "onBackPressedCallback");
        AbstractC0846i lifecycle = owner.getLifecycle();
        if (lifecycle.b() == AbstractC0846i.b.DESTROYED) {
            return;
        }
        onBackPressedCallback.addCancellable(new h(this, lifecycle, onBackPressedCallback));
        p();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new j(this));
    }

    public final androidx.activity.c i(p onBackPressedCallback) {
        kotlin.jvm.internal.r.f(onBackPressedCallback, "onBackPressedCallback");
        this.f6294c.add(onBackPressedCallback);
        i iVar = new i(this, onBackPressedCallback);
        onBackPressedCallback.addCancellable(iVar);
        p();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new k(this));
        return iVar;
    }

    public final void j() {
        Object objPrevious;
        p pVar = this.f6295d;
        if (pVar == null) {
            C0760g c0760g = this.f6294c;
            ListIterator<E> listIterator = c0760g.listIterator(c0760g.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                } else {
                    objPrevious = listIterator.previous();
                    if (((p) objPrevious).isEnabled()) {
                        break;
                    }
                }
            }
            pVar = (p) objPrevious;
        }
        this.f6295d = null;
        if (pVar != null) {
            pVar.handleOnBackCancelled();
        }
    }

    public final void k() {
        Object objPrevious;
        p pVar = this.f6295d;
        if (pVar == null) {
            C0760g c0760g = this.f6294c;
            ListIterator<E> listIterator = c0760g.listIterator(c0760g.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                } else {
                    objPrevious = listIterator.previous();
                    if (((p) objPrevious).isEnabled()) {
                        break;
                    }
                }
            }
            pVar = (p) objPrevious;
        }
        this.f6295d = null;
        if (pVar != null) {
            pVar.handleOnBackPressed();
            return;
        }
        Runnable runnable = this.f6292a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void l(androidx.activity.b bVar) {
        Object objPrevious;
        p pVar = this.f6295d;
        if (pVar == null) {
            C0760g c0760g = this.f6294c;
            ListIterator<E> listIterator = c0760g.listIterator(c0760g.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                } else {
                    objPrevious = listIterator.previous();
                    if (((p) objPrevious).isEnabled()) {
                        break;
                    }
                }
            }
            pVar = (p) objPrevious;
        }
        if (pVar != null) {
            pVar.handleOnBackProgressed(bVar);
        }
    }

    public final void m(androidx.activity.b bVar) {
        Object objPrevious;
        C0760g c0760g = this.f6294c;
        ListIterator<E> listIterator = c0760g.listIterator(c0760g.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            } else {
                objPrevious = listIterator.previous();
                if (((p) objPrevious).isEnabled()) {
                    break;
                }
            }
        }
        p pVar = (p) objPrevious;
        this.f6295d = pVar;
        if (pVar != null) {
            pVar.handleOnBackStarted(bVar);
        }
    }

    public final void n(OnBackInvokedDispatcher invoker) {
        kotlin.jvm.internal.r.f(invoker, "invoker");
        this.f6297f = invoker;
        o(this.f6299h);
    }

    public final void o(boolean z4) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f6297f;
        OnBackInvokedCallback onBackInvokedCallback = this.f6296e;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        if (z4 && !this.f6298g) {
            f.f6305a.d(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f6298g = true;
        } else {
            if (z4 || !this.f6298g) {
                return;
            }
            f.f6305a.e(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f6298g = false;
        }
    }

    public final void p() {
        boolean z4 = this.f6299h;
        C0760g c0760g = this.f6294c;
        boolean z5 = false;
        if (c0760g == null || !c0760g.isEmpty()) {
            Iterator<E> it = c0760g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((p) it.next()).isEnabled()) {
                    z5 = true;
                    break;
                }
            }
        }
        this.f6299h = z5;
        if (z5 != z4) {
            G.a aVar = this.f6293b;
            if (aVar != null) {
                aVar.accept(Boolean.valueOf(z5));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                o(z5);
            }
        }
    }

    public q(Runnable runnable) {
        this(runnable, null);
    }
}
