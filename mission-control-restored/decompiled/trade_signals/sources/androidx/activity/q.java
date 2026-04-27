package androidx.activity;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.q;
import androidx.lifecycle.AbstractC1157i;
import androidx.lifecycle.InterfaceC1159k;
import androidx.lifecycle.InterfaceC1161m;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2302q;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import o5.C2470H;
import p5.C2587i;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f10335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final S.a f10336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C2587i f10337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p f10338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OnBackInvokedCallback f10339e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OnBackInvokedDispatcher f10340f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f10341g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10342h;

    public static final class a extends AbstractC2306v implements B5.k {
        public a() {
            super(1);
        }

        public final void a(androidx.activity.b backEvent) {
            AbstractC2304t.f(backEvent, "backEvent");
            q.this.m(backEvent);
        }

        @Override // B5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((androidx.activity.b) obj);
            return C2470H.f21956a;
        }
    }

    public static final class b extends AbstractC2306v implements B5.k {
        public b() {
            super(1);
        }

        public final void a(androidx.activity.b backEvent) {
            AbstractC2304t.f(backEvent, "backEvent");
            q.this.l(backEvent);
        }

        @Override // B5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((androidx.activity.b) obj);
            return C2470H.f21956a;
        }
    }

    public static final class c extends AbstractC2306v implements Function0 {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m1invoke();
            return C2470H.f21956a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m1invoke() {
            q.this.k();
        }
    }

    public static final class d extends AbstractC2306v implements Function0 {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m2invoke();
            return C2470H.f21956a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m2invoke() {
            q.this.j();
        }
    }

    public static final class e extends AbstractC2306v implements Function0 {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m3invoke();
            return C2470H.f21956a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m3invoke() {
            q.this.k();
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f10348a = new f();

        public static final void c(Function0 onBackInvoked) {
            AbstractC2304t.f(onBackInvoked, "$onBackInvoked");
            onBackInvoked.invoke();
        }

        public final OnBackInvokedCallback b(final Function0 onBackInvoked) {
            AbstractC2304t.f(onBackInvoked, "onBackInvoked");
            return new OnBackInvokedCallback() { // from class: androidx.activity.r
                public final void onBackInvoked() {
                    q.f.c(onBackInvoked);
                }
            };
        }

        public final void d(Object dispatcher, int i8, Object callback) {
            AbstractC2304t.f(dispatcher, "dispatcher");
            AbstractC2304t.f(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).registerOnBackInvokedCallback(i8, (OnBackInvokedCallback) callback);
        }

        public final void e(Object dispatcher, Object callback) {
            AbstractC2304t.f(dispatcher, "dispatcher");
            AbstractC2304t.f(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).unregisterOnBackInvokedCallback((OnBackInvokedCallback) callback);
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f10349a = new g();

        public static final class a implements OnBackAnimationCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ B5.k f10350a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ B5.k f10351b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Function0 f10352c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Function0 f10353d;

            public a(B5.k kVar, B5.k kVar2, Function0 function0, Function0 function02) {
                this.f10350a = kVar;
                this.f10351b = kVar2;
                this.f10352c = function0;
                this.f10353d = function02;
            }

            public void onBackCancelled() {
                this.f10353d.invoke();
            }

            public void onBackInvoked() {
                this.f10352c.invoke();
            }

            public void onBackProgressed(BackEvent backEvent) {
                AbstractC2304t.f(backEvent, "backEvent");
                this.f10351b.invoke(new androidx.activity.b(backEvent));
            }

            public void onBackStarted(BackEvent backEvent) {
                AbstractC2304t.f(backEvent, "backEvent");
                this.f10350a.invoke(new androidx.activity.b(backEvent));
            }
        }

        public final OnBackInvokedCallback a(B5.k onBackStarted, B5.k onBackProgressed, Function0 onBackInvoked, Function0 onBackCancelled) {
            AbstractC2304t.f(onBackStarted, "onBackStarted");
            AbstractC2304t.f(onBackProgressed, "onBackProgressed");
            AbstractC2304t.f(onBackInvoked, "onBackInvoked");
            AbstractC2304t.f(onBackCancelled, "onBackCancelled");
            return new a(onBackStarted, onBackProgressed, onBackInvoked, onBackCancelled);
        }
    }

    public final class h implements InterfaceC1159k, androidx.activity.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC1157i f10354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p f10355b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public androidx.activity.c f10356c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ q f10357d;

        public h(q qVar, AbstractC1157i lifecycle, p onBackPressedCallback) {
            AbstractC2304t.f(lifecycle, "lifecycle");
            AbstractC2304t.f(onBackPressedCallback, "onBackPressedCallback");
            this.f10357d = qVar;
            this.f10354a = lifecycle;
            this.f10355b = onBackPressedCallback;
            lifecycle.a(this);
        }

        @Override // androidx.lifecycle.InterfaceC1159k
        public void b(InterfaceC1161m source, AbstractC1157i.a event) {
            AbstractC2304t.f(source, "source");
            AbstractC2304t.f(event, "event");
            if (event == AbstractC1157i.a.ON_START) {
                this.f10356c = this.f10357d.i(this.f10355b);
                return;
            }
            if (event != AbstractC1157i.a.ON_STOP) {
                if (event == AbstractC1157i.a.ON_DESTROY) {
                    cancel();
                }
            } else {
                androidx.activity.c cVar = this.f10356c;
                if (cVar != null) {
                    cVar.cancel();
                }
            }
        }

        @Override // androidx.activity.c
        public void cancel() {
            this.f10354a.c(this);
            this.f10355b.removeCancellable(this);
            androidx.activity.c cVar = this.f10356c;
            if (cVar != null) {
                cVar.cancel();
            }
            this.f10356c = null;
        }
    }

    public final class i implements androidx.activity.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p f10358a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q f10359b;

        public i(q qVar, p onBackPressedCallback) {
            AbstractC2304t.f(onBackPressedCallback, "onBackPressedCallback");
            this.f10359b = qVar;
            this.f10358a = onBackPressedCallback;
        }

        @Override // androidx.activity.c
        public void cancel() {
            this.f10359b.f10337c.remove(this.f10358a);
            if (AbstractC2304t.b(this.f10359b.f10338d, this.f10358a)) {
                this.f10358a.handleOnBackCancelled();
                this.f10359b.f10338d = null;
            }
            this.f10358a.removeCancellable(this);
            Function0 enabledChangedCallback$activity_release = this.f10358a.getEnabledChangedCallback$activity_release();
            if (enabledChangedCallback$activity_release != null) {
                enabledChangedCallback$activity_release.invoke();
            }
            this.f10358a.setEnabledChangedCallback$activity_release(null);
        }
    }

    public /* synthetic */ class j extends AbstractC2302q implements Function0 {
        public j(Object obj) {
            super(0, obj, q.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m();
            return C2470H.f21956a;
        }

        public final void m() {
            ((q) this.receiver).p();
        }
    }

    public /* synthetic */ class k extends AbstractC2302q implements Function0 {
        public k(Object obj) {
            super(0, obj, q.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m();
            return C2470H.f21956a;
        }

        public final void m() {
            ((q) this.receiver).p();
        }
    }

    public q(Runnable runnable) {
        this(runnable, null);
    }

    public final void h(InterfaceC1161m owner, p onBackPressedCallback) {
        AbstractC2304t.f(owner, "owner");
        AbstractC2304t.f(onBackPressedCallback, "onBackPressedCallback");
        AbstractC1157i lifecycle = owner.getLifecycle();
        if (lifecycle.b() == AbstractC1157i.b.DESTROYED) {
            return;
        }
        onBackPressedCallback.addCancellable(new h(this, lifecycle, onBackPressedCallback));
        p();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new j(this));
    }

    public final androidx.activity.c i(p onBackPressedCallback) {
        AbstractC2304t.f(onBackPressedCallback, "onBackPressedCallback");
        this.f10337c.add(onBackPressedCallback);
        i iVar = new i(this, onBackPressedCallback);
        onBackPressedCallback.addCancellable(iVar);
        p();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new k(this));
        return iVar;
    }

    public final void j() {
        Object objPrevious;
        p pVar = this.f10338d;
        if (pVar == null) {
            C2587i c2587i = this.f10337c;
            ListIterator<E> listIterator = c2587i.listIterator(c2587i.size());
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
        this.f10338d = null;
        if (pVar != null) {
            pVar.handleOnBackCancelled();
        }
    }

    public final void k() {
        Object objPrevious;
        p pVar = this.f10338d;
        if (pVar == null) {
            C2587i c2587i = this.f10337c;
            ListIterator<E> listIterator = c2587i.listIterator(c2587i.size());
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
        this.f10338d = null;
        if (pVar != null) {
            pVar.handleOnBackPressed();
            return;
        }
        Runnable runnable = this.f10335a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void l(androidx.activity.b bVar) {
        Object objPrevious;
        p pVar = this.f10338d;
        if (pVar == null) {
            C2587i c2587i = this.f10337c;
            ListIterator<E> listIterator = c2587i.listIterator(c2587i.size());
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
        C2587i c2587i = this.f10337c;
        ListIterator<E> listIterator = c2587i.listIterator(c2587i.size());
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
        this.f10338d = pVar;
        if (pVar != null) {
            pVar.handleOnBackStarted(bVar);
        }
    }

    public final void n(OnBackInvokedDispatcher invoker) {
        AbstractC2304t.f(invoker, "invoker");
        this.f10340f = invoker;
        o(this.f10342h);
    }

    public final void o(boolean z7) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f10340f;
        OnBackInvokedCallback onBackInvokedCallback = this.f10339e;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        if (z7 && !this.f10341g) {
            f.f10348a.d(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f10341g = true;
        } else {
            if (z7 || !this.f10341g) {
                return;
            }
            f.f10348a.e(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f10341g = false;
        }
    }

    public final void p() {
        boolean z7 = this.f10342h;
        C2587i c2587i = this.f10337c;
        boolean z8 = false;
        if (!(c2587i instanceof Collection) || !c2587i.isEmpty()) {
            Iterator<E> it = c2587i.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((p) it.next()).isEnabled()) {
                    z8 = true;
                    break;
                }
            }
        }
        this.f10342h = z8;
        if (z8 != z7) {
            S.a aVar = this.f10336b;
            if (aVar != null) {
                aVar.accept(Boolean.valueOf(z8));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                o(z8);
            }
        }
    }

    public q(Runnable runnable, S.a aVar) {
        this.f10335a = runnable;
        this.f10336b = aVar;
        this.f10337c = new C2587i();
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 33) {
            this.f10339e = i8 >= 34 ? g.f10349a.a(new a(), new b(), new c(), new d()) : f.f10348a.b(new e());
        }
    }
}
