package androidx.activity;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.p;
import androidx.lifecycle.i;
import cd.h0;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.v;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s0.a f921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dd.i f922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public o f923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OnBackInvokedCallback f924e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OnBackInvokedDispatcher f925f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f926g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f927h;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends v implements pd.k {
        public a() {
            super(1);
        }

        public final void a(androidx.activity.b backEvent) {
            kotlin.jvm.internal.t.f(backEvent, "backEvent");
            p.this.m(backEvent);
        }

        @Override // pd.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((androidx.activity.b) obj);
            return h0.f3852a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends v implements pd.k {
        public b() {
            super(1);
        }

        public final void a(androidx.activity.b backEvent) {
            kotlin.jvm.internal.t.f(backEvent, "backEvent");
            p.this.l(backEvent);
        }

        @Override // pd.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((androidx.activity.b) obj);
            return h0.f3852a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends v implements Function0 {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m0invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m0invoke() {
            p.this.k();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends v implements Function0 {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m1invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m1invoke() {
            p.this.j();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e extends v implements Function0 {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m2invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m2invoke() {
            p.this.k();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f933a = new f();

        public static final void c(Function0 onBackInvoked) {
            kotlin.jvm.internal.t.f(onBackInvoked, "$onBackInvoked");
            onBackInvoked.invoke();
        }

        public final OnBackInvokedCallback b(final Function0 onBackInvoked) {
            kotlin.jvm.internal.t.f(onBackInvoked, "onBackInvoked");
            return new OnBackInvokedCallback() { // from class: androidx.activity.q
                public final void onBackInvoked() {
                    p.f.c(onBackInvoked);
                }
            };
        }

        public final void d(Object dispatcher, int i10, Object callback) {
            kotlin.jvm.internal.t.f(dispatcher, "dispatcher");
            kotlin.jvm.internal.t.f(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).registerOnBackInvokedCallback(i10, (OnBackInvokedCallback) callback);
        }

        public final void e(Object dispatcher, Object callback) {
            kotlin.jvm.internal.t.f(dispatcher, "dispatcher");
            kotlin.jvm.internal.t.f(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).unregisterOnBackInvokedCallback((OnBackInvokedCallback) callback);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f934a = new g();

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a implements OnBackAnimationCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ pd.k f935a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ pd.k f936b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Function0 f937c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Function0 f938d;

            public a(pd.k kVar, pd.k kVar2, Function0 function0, Function0 function02) {
                this.f935a = kVar;
                this.f936b = kVar2;
                this.f937c = function0;
                this.f938d = function02;
            }

            public void onBackCancelled() {
                this.f938d.invoke();
            }

            public void onBackInvoked() {
                this.f937c.invoke();
            }

            public void onBackProgressed(BackEvent backEvent) {
                kotlin.jvm.internal.t.f(backEvent, "backEvent");
                this.f936b.invoke(new androidx.activity.b(backEvent));
            }

            public void onBackStarted(BackEvent backEvent) {
                kotlin.jvm.internal.t.f(backEvent, "backEvent");
                this.f935a.invoke(new androidx.activity.b(backEvent));
            }
        }

        public final OnBackInvokedCallback a(pd.k onBackStarted, pd.k onBackProgressed, Function0 onBackInvoked, Function0 onBackCancelled) {
            kotlin.jvm.internal.t.f(onBackStarted, "onBackStarted");
            kotlin.jvm.internal.t.f(onBackProgressed, "onBackProgressed");
            kotlin.jvm.internal.t.f(onBackInvoked, "onBackInvoked");
            kotlin.jvm.internal.t.f(onBackCancelled, "onBackCancelled");
            return new a(onBackStarted, onBackProgressed, onBackInvoked, onBackCancelled);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class h implements androidx.lifecycle.k, androidx.activity.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.lifecycle.i f939a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final o f940b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public androidx.activity.c f941c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ p f942d;

        public h(p pVar, androidx.lifecycle.i lifecycle, o onBackPressedCallback) {
            kotlin.jvm.internal.t.f(lifecycle, "lifecycle");
            kotlin.jvm.internal.t.f(onBackPressedCallback, "onBackPressedCallback");
            this.f942d = pVar;
            this.f939a = lifecycle;
            this.f940b = onBackPressedCallback;
            lifecycle.a(this);
        }

        @Override // androidx.lifecycle.k
        public void b(androidx.lifecycle.m source, i.a event) {
            kotlin.jvm.internal.t.f(source, "source");
            kotlin.jvm.internal.t.f(event, "event");
            if (event == i.a.ON_START) {
                this.f941c = this.f942d.i(this.f940b);
                return;
            }
            if (event != i.a.ON_STOP) {
                if (event == i.a.ON_DESTROY) {
                    cancel();
                }
            } else {
                androidx.activity.c cVar = this.f941c;
                if (cVar != null) {
                    cVar.cancel();
                }
            }
        }

        @Override // androidx.activity.c
        public void cancel() {
            this.f939a.c(this);
            this.f940b.removeCancellable(this);
            androidx.activity.c cVar = this.f941c;
            if (cVar != null) {
                cVar.cancel();
            }
            this.f941c = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class i implements androidx.activity.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o f943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p f944b;

        public i(p pVar, o onBackPressedCallback) {
            kotlin.jvm.internal.t.f(onBackPressedCallback, "onBackPressedCallback");
            this.f944b = pVar;
            this.f943a = onBackPressedCallback;
        }

        @Override // androidx.activity.c
        public void cancel() {
            this.f944b.f922c.remove(this.f943a);
            if (kotlin.jvm.internal.t.b(this.f944b.f923d, this.f943a)) {
                this.f943a.handleOnBackCancelled();
                this.f944b.f923d = null;
            }
            this.f943a.removeCancellable(this);
            Function0 enabledChangedCallback$activity_release = this.f943a.getEnabledChangedCallback$activity_release();
            if (enabledChangedCallback$activity_release != null) {
                enabledChangedCallback$activity_release.invoke();
            }
            this.f943a.setEnabledChangedCallback$activity_release(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class j extends kotlin.jvm.internal.q implements Function0 {
        public j(Object obj) {
            super(0, obj, p.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            o();
            return h0.f3852a;
        }

        public final void o() {
            ((p) this.receiver).p();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class k extends kotlin.jvm.internal.q implements Function0 {
        public k(Object obj) {
            super(0, obj, p.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            o();
            return h0.f3852a;
        }

        public final void o() {
            ((p) this.receiver).p();
        }
    }

    public p(Runnable runnable, s0.a aVar) {
        this.f920a = runnable;
        this.f921b = aVar;
        this.f922c = new dd.i();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 33) {
            this.f924e = i10 >= 34 ? g.f934a.a(new a(), new b(), new c(), new d()) : f.f933a.b(new e());
        }
    }

    public final void h(androidx.lifecycle.m owner, o onBackPressedCallback) {
        kotlin.jvm.internal.t.f(owner, "owner");
        kotlin.jvm.internal.t.f(onBackPressedCallback, "onBackPressedCallback");
        androidx.lifecycle.i lifecycle = owner.getLifecycle();
        if (lifecycle.b() == i.b.DESTROYED) {
            return;
        }
        onBackPressedCallback.addCancellable(new h(this, lifecycle, onBackPressedCallback));
        p();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new j(this));
    }

    public final androidx.activity.c i(o onBackPressedCallback) {
        kotlin.jvm.internal.t.f(onBackPressedCallback, "onBackPressedCallback");
        this.f922c.add(onBackPressedCallback);
        i iVar = new i(this, onBackPressedCallback);
        onBackPressedCallback.addCancellable(iVar);
        p();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new k(this));
        return iVar;
    }

    public final void j() {
        Object objPrevious;
        o oVar = this.f923d;
        if (oVar == null) {
            dd.i iVar = this.f922c;
            ListIterator<E> listIterator = iVar.listIterator(iVar.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                } else {
                    objPrevious = listIterator.previous();
                    if (((o) objPrevious).isEnabled()) {
                        break;
                    }
                }
            }
            oVar = (o) objPrevious;
        }
        this.f923d = null;
        if (oVar != null) {
            oVar.handleOnBackCancelled();
        }
    }

    public final void k() {
        Object objPrevious;
        o oVar = this.f923d;
        if (oVar == null) {
            dd.i iVar = this.f922c;
            ListIterator<E> listIterator = iVar.listIterator(iVar.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                } else {
                    objPrevious = listIterator.previous();
                    if (((o) objPrevious).isEnabled()) {
                        break;
                    }
                }
            }
            oVar = (o) objPrevious;
        }
        this.f923d = null;
        if (oVar != null) {
            oVar.handleOnBackPressed();
            return;
        }
        Runnable runnable = this.f920a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void l(androidx.activity.b bVar) {
        Object objPrevious;
        o oVar = this.f923d;
        if (oVar == null) {
            dd.i iVar = this.f922c;
            ListIterator<E> listIterator = iVar.listIterator(iVar.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                } else {
                    objPrevious = listIterator.previous();
                    if (((o) objPrevious).isEnabled()) {
                        break;
                    }
                }
            }
            oVar = (o) objPrevious;
        }
        if (oVar != null) {
            oVar.handleOnBackProgressed(bVar);
        }
    }

    public final void m(androidx.activity.b bVar) {
        Object objPrevious;
        dd.i iVar = this.f922c;
        ListIterator<E> listIterator = iVar.listIterator(iVar.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            } else {
                objPrevious = listIterator.previous();
                if (((o) objPrevious).isEnabled()) {
                    break;
                }
            }
        }
        o oVar = (o) objPrevious;
        this.f923d = oVar;
        if (oVar != null) {
            oVar.handleOnBackStarted(bVar);
        }
    }

    public final void n(OnBackInvokedDispatcher invoker) {
        kotlin.jvm.internal.t.f(invoker, "invoker");
        this.f925f = invoker;
        o(this.f927h);
    }

    public final void o(boolean z10) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f925f;
        OnBackInvokedCallback onBackInvokedCallback = this.f924e;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        if (z10 && !this.f926g) {
            f.f933a.d(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f926g = true;
        } else {
            if (z10 || !this.f926g) {
                return;
            }
            f.f933a.e(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f926g = false;
        }
    }

    public final void p() {
        boolean z10 = this.f927h;
        dd.i iVar = this.f922c;
        boolean z11 = false;
        if (iVar == null || !iVar.isEmpty()) {
            Iterator<E> it = iVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((o) it.next()).isEnabled()) {
                    z11 = true;
                    break;
                }
            }
        }
        this.f927h = z11;
        if (z11 != z10) {
            s0.a aVar = this.f921b;
            if (aVar != null) {
                aVar.accept(Boolean.valueOf(z11));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                o(z11);
            }
        }
    }

    public p(Runnable runnable) {
        this(runnable, null);
    }
}
