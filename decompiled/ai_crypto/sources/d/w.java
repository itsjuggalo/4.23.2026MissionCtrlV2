package d;

import E5.E;
import F5.C0548f;
import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.AbstractC0963i;
import androidx.lifecycle.InterfaceC0965k;
import androidx.lifecycle.InterfaceC0967m;
import d.w;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f13123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final P.a f13124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0548f f13125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public v f13126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OnBackInvokedCallback f13127e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OnBackInvokedDispatcher f13128f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f13129g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f13130h;

    public static final class a extends kotlin.jvm.internal.s implements Q5.k {
        public a() {
            super(1);
        }

        public final void a(C1386b backEvent) {
            kotlin.jvm.internal.r.f(backEvent, "backEvent");
            w.this.m(backEvent);
        }

        @Override // Q5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C1386b) obj);
            return E.f1657a;
        }
    }

    public static final class b extends kotlin.jvm.internal.s implements Q5.k {
        public b() {
            super(1);
        }

        public final void a(C1386b backEvent) {
            kotlin.jvm.internal.r.f(backEvent, "backEvent");
            w.this.l(backEvent);
        }

        @Override // Q5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C1386b) obj);
            return E.f1657a;
        }
    }

    public static final class c extends kotlin.jvm.internal.s implements Function0 {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m185invoke();
            return E.f1657a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m185invoke() {
            w.this.k();
        }
    }

    public static final class d extends kotlin.jvm.internal.s implements Function0 {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m186invoke();
            return E.f1657a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m186invoke() {
            w.this.j();
        }
    }

    public static final class e extends kotlin.jvm.internal.s implements Function0 {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m187invoke();
            return E.f1657a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m187invoke() {
            w.this.k();
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f13136a = new f();

        public static final void c(Function0 onBackInvoked) {
            kotlin.jvm.internal.r.f(onBackInvoked, "$onBackInvoked");
            onBackInvoked.invoke();
        }

        public final OnBackInvokedCallback b(final Function0 onBackInvoked) {
            kotlin.jvm.internal.r.f(onBackInvoked, "onBackInvoked");
            return new OnBackInvokedCallback() { // from class: d.x
                public final void onBackInvoked() {
                    w.f.c(onBackInvoked);
                }
            };
        }

        public final void d(Object dispatcher, int i7, Object callback) {
            kotlin.jvm.internal.r.f(dispatcher, "dispatcher");
            kotlin.jvm.internal.r.f(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).registerOnBackInvokedCallback(i7, (OnBackInvokedCallback) callback);
        }

        public final void e(Object dispatcher, Object callback) {
            kotlin.jvm.internal.r.f(dispatcher, "dispatcher");
            kotlin.jvm.internal.r.f(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).unregisterOnBackInvokedCallback((OnBackInvokedCallback) callback);
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f13137a = new g();

        public static final class a implements OnBackAnimationCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Q5.k f13138a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Q5.k f13139b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Function0 f13140c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Function0 f13141d;

            public a(Q5.k kVar, Q5.k kVar2, Function0 function0, Function0 function02) {
                this.f13138a = kVar;
                this.f13139b = kVar2;
                this.f13140c = function0;
                this.f13141d = function02;
            }

            public void onBackCancelled() {
                this.f13141d.invoke();
            }

            public void onBackInvoked() {
                this.f13140c.invoke();
            }

            public void onBackProgressed(BackEvent backEvent) {
                kotlin.jvm.internal.r.f(backEvent, "backEvent");
                this.f13139b.invoke(new C1386b(backEvent));
            }

            public void onBackStarted(BackEvent backEvent) {
                kotlin.jvm.internal.r.f(backEvent, "backEvent");
                this.f13138a.invoke(new C1386b(backEvent));
            }
        }

        public final OnBackInvokedCallback a(Q5.k onBackStarted, Q5.k onBackProgressed, Function0 onBackInvoked, Function0 onBackCancelled) {
            kotlin.jvm.internal.r.f(onBackStarted, "onBackStarted");
            kotlin.jvm.internal.r.f(onBackProgressed, "onBackProgressed");
            kotlin.jvm.internal.r.f(onBackInvoked, "onBackInvoked");
            kotlin.jvm.internal.r.f(onBackCancelled, "onBackCancelled");
            return new a(onBackStarted, onBackProgressed, onBackInvoked, onBackCancelled);
        }
    }

    public final class h implements InterfaceC0965k, InterfaceC1387c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC0963i f13142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final v f13143b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public InterfaceC1387c f13144c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ w f13145d;

        public h(w wVar, AbstractC0963i lifecycle, v onBackPressedCallback) {
            kotlin.jvm.internal.r.f(lifecycle, "lifecycle");
            kotlin.jvm.internal.r.f(onBackPressedCallback, "onBackPressedCallback");
            this.f13145d = wVar;
            this.f13142a = lifecycle;
            this.f13143b = onBackPressedCallback;
            lifecycle.a(this);
        }

        @Override // androidx.lifecycle.InterfaceC0965k
        public void a(InterfaceC0967m source, AbstractC0963i.a event) {
            kotlin.jvm.internal.r.f(source, "source");
            kotlin.jvm.internal.r.f(event, "event");
            if (event == AbstractC0963i.a.ON_START) {
                this.f13144c = this.f13145d.i(this.f13143b);
                return;
            }
            if (event != AbstractC0963i.a.ON_STOP) {
                if (event == AbstractC0963i.a.ON_DESTROY) {
                    cancel();
                }
            } else {
                InterfaceC1387c interfaceC1387c = this.f13144c;
                if (interfaceC1387c != null) {
                    interfaceC1387c.cancel();
                }
            }
        }

        @Override // d.InterfaceC1387c
        public void cancel() {
            this.f13142a.c(this);
            this.f13143b.i(this);
            InterfaceC1387c interfaceC1387c = this.f13144c;
            if (interfaceC1387c != null) {
                interfaceC1387c.cancel();
            }
            this.f13144c = null;
        }
    }

    public final class i implements InterfaceC1387c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final v f13146a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ w f13147b;

        public i(w wVar, v onBackPressedCallback) {
            kotlin.jvm.internal.r.f(onBackPressedCallback, "onBackPressedCallback");
            this.f13147b = wVar;
            this.f13146a = onBackPressedCallback;
        }

        @Override // d.InterfaceC1387c
        public void cancel() {
            this.f13147b.f13125c.remove(this.f13146a);
            if (kotlin.jvm.internal.r.b(this.f13147b.f13126d, this.f13146a)) {
                this.f13146a.c();
                this.f13147b.f13126d = null;
            }
            this.f13146a.i(this);
            Function0 function0B = this.f13146a.b();
            if (function0B != null) {
                function0B.invoke();
            }
            this.f13146a.k(null);
        }
    }

    public /* synthetic */ class j extends kotlin.jvm.internal.o implements Function0 {
        public j(Object obj) {
            super(0, obj, w.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        public final void e() {
            ((w) this.receiver).p();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            e();
            return E.f1657a;
        }
    }

    public /* synthetic */ class k extends kotlin.jvm.internal.o implements Function0 {
        public k(Object obj) {
            super(0, obj, w.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        public final void e() {
            ((w) this.receiver).p();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            e();
            return E.f1657a;
        }
    }

    public w(Runnable runnable, P.a aVar) {
        this.f13123a = runnable;
        this.f13124b = aVar;
        this.f13125c = new C0548f();
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 33) {
            this.f13127e = i7 >= 34 ? g.f13137a.a(new a(), new b(), new c(), new d()) : f.f13136a.b(new e());
        }
    }

    public final void h(InterfaceC0967m owner, v onBackPressedCallback) {
        kotlin.jvm.internal.r.f(owner, "owner");
        kotlin.jvm.internal.r.f(onBackPressedCallback, "onBackPressedCallback");
        AbstractC0963i abstractC0963iA = owner.a();
        if (abstractC0963iA.b() == AbstractC0963i.b.DESTROYED) {
            return;
        }
        onBackPressedCallback.a(new h(this, abstractC0963iA, onBackPressedCallback));
        p();
        onBackPressedCallback.k(new j(this));
    }

    public final InterfaceC1387c i(v onBackPressedCallback) {
        kotlin.jvm.internal.r.f(onBackPressedCallback, "onBackPressedCallback");
        this.f13125c.add(onBackPressedCallback);
        i iVar = new i(this, onBackPressedCallback);
        onBackPressedCallback.a(iVar);
        p();
        onBackPressedCallback.k(new k(this));
        return iVar;
    }

    public final void j() {
        Object objPrevious;
        v vVar = this.f13126d;
        if (vVar == null) {
            C0548f c0548f = this.f13125c;
            ListIterator<E> listIterator = c0548f.listIterator(c0548f.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                } else {
                    objPrevious = listIterator.previous();
                    if (((v) objPrevious).g()) {
                        break;
                    }
                }
            }
            vVar = (v) objPrevious;
        }
        this.f13126d = null;
        if (vVar != null) {
            vVar.c();
        }
    }

    public final void k() {
        Object objPrevious;
        v vVar = this.f13126d;
        if (vVar == null) {
            C0548f c0548f = this.f13125c;
            ListIterator<E> listIterator = c0548f.listIterator(c0548f.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                } else {
                    objPrevious = listIterator.previous();
                    if (((v) objPrevious).g()) {
                        break;
                    }
                }
            }
            vVar = (v) objPrevious;
        }
        this.f13126d = null;
        if (vVar != null) {
            vVar.d();
            return;
        }
        Runnable runnable = this.f13123a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void l(C1386b c1386b) {
        Object objPrevious;
        v vVar = this.f13126d;
        if (vVar == null) {
            C0548f c0548f = this.f13125c;
            ListIterator<E> listIterator = c0548f.listIterator(c0548f.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                } else {
                    objPrevious = listIterator.previous();
                    if (((v) objPrevious).g()) {
                        break;
                    }
                }
            }
            vVar = (v) objPrevious;
        }
        if (vVar != null) {
            vVar.e(c1386b);
        }
    }

    public final void m(C1386b c1386b) {
        Object objPrevious;
        C0548f c0548f = this.f13125c;
        ListIterator<E> listIterator = c0548f.listIterator(c0548f.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            } else {
                objPrevious = listIterator.previous();
                if (((v) objPrevious).g()) {
                    break;
                }
            }
        }
        v vVar = (v) objPrevious;
        if (this.f13126d != null) {
            j();
        }
        this.f13126d = vVar;
        if (vVar != null) {
            vVar.f(c1386b);
        }
    }

    public final void n(OnBackInvokedDispatcher invoker) {
        kotlin.jvm.internal.r.f(invoker, "invoker");
        this.f13128f = invoker;
        o(this.f13130h);
    }

    public final void o(boolean z7) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f13128f;
        OnBackInvokedCallback onBackInvokedCallback = this.f13127e;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        if (z7 && !this.f13129g) {
            f.f13136a.d(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f13129g = true;
        } else {
            if (z7 || !this.f13129g) {
                return;
            }
            f.f13136a.e(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f13129g = false;
        }
    }

    public final void p() {
        boolean z7 = this.f13130h;
        C0548f c0548f = this.f13125c;
        boolean z8 = false;
        if (c0548f == null || !c0548f.isEmpty()) {
            Iterator<E> it = c0548f.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((v) it.next()).g()) {
                    z8 = true;
                    break;
                }
            }
        }
        this.f13130h = z8;
        if (z8 != z7) {
            P.a aVar = this.f13124b;
            if (aVar != null) {
                aVar.accept(Boolean.valueOf(z8));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                o(z8);
            }
        }
    }

    public w(Runnable runnable) {
        this(runnable, null);
    }
}
