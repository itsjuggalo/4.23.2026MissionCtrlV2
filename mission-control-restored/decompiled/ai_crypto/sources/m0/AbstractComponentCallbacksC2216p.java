package m0;

import Q.AbstractC0679u;
import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.AbstractC0963i;
import androidx.lifecycle.AbstractC0970p;
import androidx.lifecycle.C0968n;
import androidx.lifecycle.InterfaceC0961g;
import androidx.lifecycle.InterfaceC0965k;
import androidx.lifecycle.InterfaceC0967m;
import androidx.lifecycle.K;
import com.revenuecat.purchases.common.Constants;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import s0.AbstractC2640a;
import t0.AbstractC2648a;

/* JADX INFO: renamed from: m0.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractComponentCallbacksC2216p implements ComponentCallbacks, View.OnCreateContextMenuListener, InterfaceC0967m, androidx.lifecycle.N, InterfaceC0961g, F0.f {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final Object f18834d0 = new Object();

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public String f18835A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public boolean f18836B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public boolean f18837C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public boolean f18838D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public boolean f18839E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public boolean f18840F;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public boolean f18842H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public ViewGroup f18843I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public View f18844J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public boolean f18845K;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public g f18847M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public Handler f18848N;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public boolean f18850P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public LayoutInflater f18851Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public boolean f18852R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public String f18853S;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public C0968n f18855U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public U f18856V;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public K.b f18858X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public F0.e f18859Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public int f18860Z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bundle f18863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SparseArray f18865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bundle f18867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f18868e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bundle f18870g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AbstractComponentCallbacksC2216p f18871h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f18873j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f18875l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f18876m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f18877n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f18878o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f18879p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f18880q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f18881r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f18882s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f18883t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AbstractC2190H f18884u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public AbstractC2226z f18885v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public AbstractComponentCallbacksC2216p f18887x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f18888y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f18889z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f18861a = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f18869f = UUID.randomUUID().toString();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f18872i = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Boolean f18874k = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public AbstractC2190H f18886w = new C2191I();

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public boolean f18841G = true;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public boolean f18846L = true;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public Runnable f18849O = new a();

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public AbstractC0963i.b f18854T = AbstractC0963i.b.RESUMED;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public androidx.lifecycle.r f18857W = new androidx.lifecycle.r();

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final AtomicInteger f18862a0 = new AtomicInteger();

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final ArrayList f18864b0 = new ArrayList();

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final i f18866c0 = new b();

    /* JADX INFO: renamed from: m0.p$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractComponentCallbacksC2216p.this.D1();
        }
    }

    /* JADX INFO: renamed from: m0.p$b */
    public class b extends i {
        public b() {
            super(null);
        }

        @Override // m0.AbstractComponentCallbacksC2216p.i
        public void a() {
            AbstractComponentCallbacksC2216p.this.f18859Y.c();
            androidx.lifecycle.D.c(AbstractComponentCallbacksC2216p.this);
            Bundle bundle = AbstractComponentCallbacksC2216p.this.f18863b;
            AbstractComponentCallbacksC2216p.this.f18859Y.d(bundle != null ? bundle.getBundle("registryState") : null);
        }
    }

    /* JADX INFO: renamed from: m0.p$c */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractComponentCallbacksC2216p.this.i(false);
        }
    }

    /* JADX INFO: renamed from: m0.p$d */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Y f18893a;

        public d(Y y7) {
            this.f18893a = y7;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f18893a.w()) {
                this.f18893a.n();
            }
        }
    }

    /* JADX INFO: renamed from: m0.p$e */
    public class e extends AbstractC2223w {
        public e() {
        }

        @Override // m0.AbstractC2223w
        public View j(int i7) {
            View view = AbstractComponentCallbacksC2216p.this.f18844J;
            if (view != null) {
                return view.findViewById(i7);
            }
            throw new IllegalStateException("Fragment " + AbstractComponentCallbacksC2216p.this + " does not have a view");
        }

        @Override // m0.AbstractC2223w
        public boolean r() {
            return AbstractComponentCallbacksC2216p.this.f18844J != null;
        }
    }

    /* JADX INFO: renamed from: m0.p$f */
    public class f implements InterfaceC0965k {
        public f() {
        }

        @Override // androidx.lifecycle.InterfaceC0965k
        public void a(InterfaceC0967m interfaceC0967m, AbstractC0963i.a aVar) {
            View view;
            if (aVar != AbstractC0963i.a.ON_STOP || (view = AbstractComponentCallbacksC2216p.this.f18844J) == null) {
                return;
            }
            view.cancelPendingInputEvents();
        }
    }

    /* JADX INFO: renamed from: m0.p$g */
    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f18897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f18898b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f18899c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f18900d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f18901e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f18902f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f18903g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ArrayList f18904h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public ArrayList f18905i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f18906j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f18907k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f18908l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f18909m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Object f18910n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Object f18911o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Boolean f18912p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Boolean f18913q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public float f18914r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public View f18915s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f18916t;

        public g() {
            Object obj = AbstractComponentCallbacksC2216p.f18834d0;
            this.f18907k = obj;
            this.f18908l = null;
            this.f18909m = obj;
            this.f18910n = null;
            this.f18911o = obj;
            this.f18914r = 1.0f;
            this.f18915s = null;
        }
    }

    /* JADX INFO: renamed from: m0.p$h */
    public static class h extends RuntimeException {
        public h(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* JADX INFO: renamed from: m0.p$i */
    public static abstract class i {
        public i() {
        }

        public abstract void a();

        public /* synthetic */ i(a aVar) {
            this();
        }
    }

    public AbstractComponentCallbacksC2216p() {
        X();
    }

    public static AbstractComponentCallbacksC2216p Z(Context context, String str, Bundle bundle) {
        try {
            AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p = (AbstractComponentCallbacksC2216p) AbstractC2225y.d(context.getClassLoader(), str).getConstructor(null).newInstance(null);
            if (bundle != null) {
                bundle.setClassLoader(abstractComponentCallbacksC2216p.getClass().getClassLoader());
                abstractComponentCallbacksC2216p.w1(bundle);
            }
            return abstractComponentCallbacksC2216p;
        } catch (IllegalAccessException e7) {
            throw new h("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e7);
        } catch (InstantiationException e8) {
            throw new h("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e8);
        } catch (NoSuchMethodException e9) {
            throw new h("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e9);
        } catch (InvocationTargetException e10) {
            throw new h("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e10);
        }
    }

    public F.w A() {
        g gVar = this.f18847M;
        if (gVar == null) {
            return null;
        }
        gVar.getClass();
        return null;
    }

    public void A0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.f18842H = true;
    }

    public void A1(float f7) {
        l().f18914r = f7;
    }

    public View B() {
        g gVar = this.f18847M;
        if (gVar == null) {
            return null;
        }
        return gVar.f18915s;
    }

    public void B0(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.f18842H = true;
        AbstractC2226z abstractC2226z = this.f18885v;
        Activity activityS = abstractC2226z == null ? null : abstractC2226z.s();
        if (activityS != null) {
            this.f18842H = false;
            A0(activityS, attributeSet, bundle);
        }
    }

    public void B1(ArrayList arrayList, ArrayList arrayList2) {
        l();
        g gVar = this.f18847M;
        gVar.f18904h = arrayList;
        gVar.f18905i = arrayList2;
    }

    public final Object C() {
        AbstractC2226z abstractC2226z = this.f18885v;
        if (abstractC2226z == null) {
            return null;
        }
        return abstractC2226z.y();
    }

    public void C1(Intent intent, int i7, Bundle bundle) {
        if (this.f18885v != null) {
            H().V0(this, intent, i7, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public LayoutInflater D(Bundle bundle) {
        AbstractC2226z abstractC2226z = this.f18885v;
        if (abstractC2226z == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater layoutInflaterZ = abstractC2226z.z();
        AbstractC0679u.a(layoutInflaterZ, this.f18886w.w0());
        return layoutInflaterZ;
    }

    public boolean D0(MenuItem menuItem) {
        return false;
    }

    public void D1() {
        if (this.f18847M == null || !l().f18916t) {
            return;
        }
        if (this.f18885v == null) {
            l().f18916t = false;
        } else if (Looper.myLooper() != this.f18885v.w().getLooper()) {
            this.f18885v.w().postAtFrontOfQueue(new c());
        } else {
            i(true);
        }
    }

    public final int E() {
        AbstractC0963i.b bVar = this.f18854T;
        return (bVar == AbstractC0963i.b.INITIALIZED || this.f18887x == null) ? bVar.ordinal() : Math.min(bVar.ordinal(), this.f18887x.E());
    }

    public int F() {
        g gVar = this.f18847M;
        if (gVar == null) {
            return 0;
        }
        return gVar.f18903g;
    }

    public void F0() {
        this.f18842H = true;
    }

    public final AbstractComponentCallbacksC2216p G() {
        return this.f18887x;
    }

    public final AbstractC2190H H() {
        AbstractC2190H abstractC2190H = this.f18884u;
        if (abstractC2190H != null) {
            return abstractC2190H;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public boolean I() {
        g gVar = this.f18847M;
        if (gVar == null) {
            return false;
        }
        return gVar.f18898b;
    }

    public int J() {
        g gVar = this.f18847M;
        if (gVar == null) {
            return 0;
        }
        return gVar.f18901e;
    }

    public int K() {
        g gVar = this.f18847M;
        if (gVar == null) {
            return 0;
        }
        return gVar.f18902f;
    }

    public void K0() {
        this.f18842H = true;
    }

    public float L() {
        g gVar = this.f18847M;
        if (gVar == null) {
            return 1.0f;
        }
        return gVar.f18914r;
    }

    public Object M() {
        g gVar = this.f18847M;
        if (gVar == null) {
            return null;
        }
        Object obj = gVar.f18909m;
        return obj == f18834d0 ? z() : obj;
    }

    public void M0() {
        this.f18842H = true;
    }

    public final Resources N() {
        return q1().getResources();
    }

    public void N0() {
        this.f18842H = true;
    }

    public Object O() {
        g gVar = this.f18847M;
        if (gVar == null) {
            return null;
        }
        Object obj = gVar.f18907k;
        return obj == f18834d0 ? w() : obj;
    }

    public Object P() {
        g gVar = this.f18847M;
        if (gVar == null) {
            return null;
        }
        return gVar.f18910n;
    }

    public void P0(Bundle bundle) {
        this.f18842H = true;
    }

    public Object Q() {
        g gVar = this.f18847M;
        if (gVar == null) {
            return null;
        }
        Object obj = gVar.f18911o;
        return obj == f18834d0 ? P() : obj;
    }

    public void Q0(Bundle bundle) {
        this.f18886w.X0();
        this.f18861a = 3;
        this.f18842H = false;
        j0(bundle);
        if (this.f18842H) {
            t1();
            this.f18886w.x();
        } else {
            throw new a0("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
    }

    public ArrayList R() {
        ArrayList arrayList;
        g gVar = this.f18847M;
        return (gVar == null || (arrayList = gVar.f18904h) == null) ? new ArrayList() : arrayList;
    }

    public void R0() {
        Iterator it = this.f18864b0.iterator();
        while (it.hasNext()) {
            ((i) it.next()).a();
        }
        this.f18864b0.clear();
        this.f18886w.l(this.f18885v, j(), this);
        this.f18861a = 0;
        this.f18842H = false;
        m0(this.f18885v.t());
        if (this.f18842H) {
            this.f18884u.H(this);
            this.f18886w.y();
        } else {
            throw new a0("Fragment " + this + " did not call through to super.onAttach()");
        }
    }

    public ArrayList S() {
        ArrayList arrayList;
        g gVar = this.f18847M;
        return (gVar == null || (arrayList = gVar.f18905i) == null) ? new ArrayList() : arrayList;
    }

    public void S0(Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    public final String T(int i7) {
        return N().getString(i7);
    }

    public boolean T0(MenuItem menuItem) {
        if (this.f18836B) {
            return false;
        }
        if (o0(menuItem)) {
            return true;
        }
        return this.f18886w.A(menuItem);
    }

    public final AbstractComponentCallbacksC2216p U(boolean z7) {
        String str;
        if (z7) {
            n0.c.h(this);
        }
        AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p = this.f18871h;
        if (abstractComponentCallbacksC2216p != null) {
            return abstractComponentCallbacksC2216p;
        }
        AbstractC2190H abstractC2190H = this.f18884u;
        if (abstractC2190H == null || (str = this.f18872i) == null) {
            return null;
        }
        return abstractC2190H.f0(str);
    }

    public void U0(Bundle bundle) {
        this.f18886w.X0();
        this.f18861a = 1;
        this.f18842H = false;
        this.f18855U.a(new f());
        p0(bundle);
        this.f18852R = true;
        if (this.f18842H) {
            this.f18855U.h(AbstractC0963i.a.ON_CREATE);
            return;
        }
        throw new a0("Fragment " + this + " did not call through to super.onCreate()");
    }

    public View V() {
        return this.f18844J;
    }

    public boolean V0(Menu menu, MenuInflater menuInflater) {
        boolean z7 = false;
        if (this.f18836B) {
            return false;
        }
        if (this.f18840F && this.f18841G) {
            s0(menu, menuInflater);
            z7 = true;
        }
        return z7 | this.f18886w.C(menu, menuInflater);
    }

    public AbstractC0970p W() {
        return this.f18857W;
    }

    public void W0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f18886w.X0();
        this.f18882s = true;
        this.f18856V = new U(this, f(), new Runnable() { // from class: m0.o
            @Override // java.lang.Runnable
            public final void run() {
                this.f18833a.h0();
            }
        });
        View viewT0 = t0(layoutInflater, viewGroup, bundle);
        this.f18844J = viewT0;
        if (viewT0 == null) {
            if (this.f18856V.e()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.f18856V = null;
            return;
        }
        this.f18856V.d();
        if (AbstractC2190H.I0(3)) {
            Log.d("FragmentManager", "Setting ViewLifecycleOwner on View " + this.f18844J + " for Fragment " + this);
        }
        androidx.lifecycle.O.a(this.f18844J, this.f18856V);
        androidx.lifecycle.P.a(this.f18844J, this.f18856V);
        F0.g.a(this.f18844J, this.f18856V);
        this.f18857W.n(this.f18856V);
    }

    public final void X() {
        this.f18855U = new C0968n(this);
        this.f18859Y = F0.e.a(this);
        this.f18858X = null;
        if (this.f18864b0.contains(this.f18866c0)) {
            return;
        }
        o1(this.f18866c0);
    }

    public void X0() {
        this.f18886w.D();
        this.f18855U.h(AbstractC0963i.a.ON_DESTROY);
        this.f18861a = 0;
        this.f18842H = false;
        this.f18852R = false;
        u0();
        if (this.f18842H) {
            return;
        }
        throw new a0("Fragment " + this + " did not call through to super.onDestroy()");
    }

    public void Y() {
        X();
        this.f18853S = this.f18869f;
        this.f18869f = UUID.randomUUID().toString();
        this.f18875l = false;
        this.f18876m = false;
        this.f18879p = false;
        this.f18880q = false;
        this.f18881r = false;
        this.f18883t = 0;
        this.f18884u = null;
        this.f18886w = new C2191I();
        this.f18885v = null;
        this.f18888y = 0;
        this.f18889z = 0;
        this.f18835A = null;
        this.f18836B = false;
        this.f18837C = false;
    }

    public void Y0() {
        this.f18886w.E();
        if (this.f18844J != null && this.f18856V.a().b().b(AbstractC0963i.b.CREATED)) {
            this.f18856V.b(AbstractC0963i.a.ON_DESTROY);
        }
        this.f18861a = 1;
        this.f18842H = false;
        w0();
        if (this.f18842H) {
            AbstractC2648a.b(this).d();
            this.f18882s = false;
        } else {
            throw new a0("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    public void Z0() {
        this.f18861a = -1;
        this.f18842H = false;
        x0();
        this.f18851Q = null;
        if (this.f18842H) {
            if (this.f18886w.H0()) {
                return;
            }
            this.f18886w.D();
            this.f18886w = new C2191I();
            return;
        }
        throw new a0("Fragment " + this + " did not call through to super.onDetach()");
    }

    @Override // androidx.lifecycle.InterfaceC0967m
    public AbstractC0963i a() {
        return this.f18855U;
    }

    public final boolean a0() {
        return this.f18885v != null && this.f18875l;
    }

    public LayoutInflater a1(Bundle bundle) {
        LayoutInflater layoutInflaterY0 = y0(bundle);
        this.f18851Q = layoutInflaterY0;
        return layoutInflaterY0;
    }

    public final boolean b0() {
        AbstractC2190H abstractC2190H;
        return this.f18836B || ((abstractC2190H = this.f18884u) != null && abstractC2190H.L0(this.f18887x));
    }

    public void b1() {
        onLowMemory();
    }

    @Override // androidx.lifecycle.InterfaceC0961g
    public AbstractC2640a c() {
        Application application;
        Context applicationContext = q1().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        if (application == null && AbstractC2190H.I0(3)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + q1().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        s0.b bVar = new s0.b();
        if (application != null) {
            bVar.c(K.a.f7749h, application);
        }
        bVar.c(androidx.lifecycle.D.f7725a, this);
        bVar.c(androidx.lifecycle.D.f7726b, this);
        if (r() != null) {
            bVar.c(androidx.lifecycle.D.f7727c, r());
        }
        return bVar;
    }

    public final boolean c0() {
        return this.f18883t > 0;
    }

    public void c1(boolean z7) {
        C0(z7);
    }

    public final boolean d0() {
        AbstractC2190H abstractC2190H;
        return this.f18841G && ((abstractC2190H = this.f18884u) == null || abstractC2190H.M0(this.f18887x));
    }

    public boolean d1(MenuItem menuItem) {
        if (this.f18836B) {
            return false;
        }
        if (this.f18840F && this.f18841G && D0(menuItem)) {
            return true;
        }
        return this.f18886w.J(menuItem);
    }

    public boolean e0() {
        g gVar = this.f18847M;
        if (gVar == null) {
            return false;
        }
        return gVar.f18916t;
    }

    public void e1(Menu menu) {
        if (this.f18836B) {
            return;
        }
        if (this.f18840F && this.f18841G) {
            E0(menu);
        }
        this.f18886w.K(menu);
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // androidx.lifecycle.N
    public androidx.lifecycle.M f() {
        if (this.f18884u == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (E() != AbstractC0963i.b.INITIALIZED.ordinal()) {
            return this.f18884u.D0(this);
        }
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    }

    public final boolean f0() {
        return this.f18876m;
    }

    public void f1() {
        this.f18886w.M();
        if (this.f18844J != null) {
            this.f18856V.b(AbstractC0963i.a.ON_PAUSE);
        }
        this.f18855U.h(AbstractC0963i.a.ON_PAUSE);
        this.f18861a = 6;
        this.f18842H = false;
        F0();
        if (this.f18842H) {
            return;
        }
        throw new a0("Fragment " + this + " did not call through to super.onPause()");
    }

    public final boolean g0() {
        AbstractC2190H abstractC2190H = this.f18884u;
        if (abstractC2190H == null) {
            return false;
        }
        return abstractC2190H.P0();
    }

    public void g1(boolean z7) {
        G0(z7);
    }

    public final /* synthetic */ void h0() {
        this.f18856V.g(this.f18867d);
        this.f18867d = null;
    }

    public boolean h1(Menu menu) {
        boolean z7 = false;
        if (this.f18836B) {
            return false;
        }
        if (this.f18840F && this.f18841G) {
            H0(menu);
            z7 = true;
        }
        return z7 | this.f18886w.O(menu);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void i(boolean z7) {
        ViewGroup viewGroup;
        AbstractC2190H abstractC2190H;
        g gVar = this.f18847M;
        if (gVar != null) {
            gVar.f18916t = false;
        }
        if (this.f18844J == null || (viewGroup = this.f18843I) == null || (abstractC2190H = this.f18884u) == null) {
            return;
        }
        Y yU = Y.u(viewGroup, abstractC2190H);
        yU.x();
        if (z7) {
            this.f18885v.w().post(new d(yU));
        } else {
            yU.n();
        }
        Handler handler = this.f18848N;
        if (handler != null) {
            handler.removeCallbacks(this.f18849O);
            this.f18848N = null;
        }
    }

    public void i0() {
        this.f18886w.X0();
    }

    public void i1() {
        boolean zN0 = this.f18884u.N0(this);
        Boolean bool = this.f18874k;
        if (bool == null || bool.booleanValue() != zN0) {
            this.f18874k = Boolean.valueOf(zN0);
            I0(zN0);
            this.f18886w.P();
        }
    }

    public AbstractC2223w j() {
        return new e();
    }

    public void j0(Bundle bundle) {
        this.f18842H = true;
    }

    public void j1() {
        this.f18886w.X0();
        this.f18886w.a0(true);
        this.f18861a = 7;
        this.f18842H = false;
        K0();
        if (!this.f18842H) {
            throw new a0("Fragment " + this + " did not call through to super.onResume()");
        }
        C0968n c0968n = this.f18855U;
        AbstractC0963i.a aVar = AbstractC0963i.a.ON_RESUME;
        c0968n.h(aVar);
        if (this.f18844J != null) {
            this.f18856V.b(aVar);
        }
        this.f18886w.Q();
    }

    public void k(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f18888y));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f18889z));
        printWriter.print(" mTag=");
        printWriter.println(this.f18835A);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f18861a);
        printWriter.print(" mWho=");
        printWriter.print(this.f18869f);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f18883t);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f18875l);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f18876m);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f18879p);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f18880q);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f18836B);
        printWriter.print(" mDetached=");
        printWriter.print(this.f18837C);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f18841G);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f18840F);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f18838D);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f18846L);
        if (this.f18884u != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f18884u);
        }
        if (this.f18885v != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f18885v);
        }
        if (this.f18887x != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f18887x);
        }
        if (this.f18870g != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f18870g);
        }
        if (this.f18863b != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f18863b);
        }
        if (this.f18865c != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f18865c);
        }
        if (this.f18867d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.f18867d);
        }
        AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216pU = U(false);
        if (abstractComponentCallbacksC2216pU != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(abstractComponentCallbacksC2216pU);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f18873j);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(I());
        if (u() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(u());
        }
        if (y() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(y());
        }
        if (J() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(J());
        }
        if (K() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(K());
        }
        if (this.f18843I != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f18843I);
        }
        if (this.f18844J != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f18844J);
        }
        if (q() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(q());
        }
        if (t() != null) {
            AbstractC2648a.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.f18886w + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        this.f18886w.W(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public void k0(int i7, int i8, Intent intent) {
        if (AbstractC2190H.I0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i7 + " resultCode: " + i8 + " data: " + intent);
        }
    }

    public void k1(Bundle bundle) {
        L0(bundle);
    }

    public final g l() {
        if (this.f18847M == null) {
            this.f18847M = new g();
        }
        return this.f18847M;
    }

    public void l0(Activity activity) {
        this.f18842H = true;
    }

    public void l1() {
        this.f18886w.X0();
        this.f18886w.a0(true);
        this.f18861a = 5;
        this.f18842H = false;
        M0();
        if (!this.f18842H) {
            throw new a0("Fragment " + this + " did not call through to super.onStart()");
        }
        C0968n c0968n = this.f18855U;
        AbstractC0963i.a aVar = AbstractC0963i.a.ON_START;
        c0968n.h(aVar);
        if (this.f18844J != null) {
            this.f18856V.b(aVar);
        }
        this.f18886w.R();
    }

    public AbstractComponentCallbacksC2216p m(String str) {
        return str.equals(this.f18869f) ? this : this.f18886w.j0(str);
    }

    public void m0(Context context) {
        this.f18842H = true;
        AbstractC2226z abstractC2226z = this.f18885v;
        Activity activityS = abstractC2226z == null ? null : abstractC2226z.s();
        if (activityS != null) {
            this.f18842H = false;
            l0(activityS);
        }
    }

    public void m1() {
        this.f18886w.T();
        if (this.f18844J != null) {
            this.f18856V.b(AbstractC0963i.a.ON_STOP);
        }
        this.f18855U.h(AbstractC0963i.a.ON_STOP);
        this.f18861a = 4;
        this.f18842H = false;
        N0();
        if (this.f18842H) {
            return;
        }
        throw new a0("Fragment " + this + " did not call through to super.onStop()");
    }

    public final AbstractActivityC2221u n() {
        AbstractC2226z abstractC2226z = this.f18885v;
        if (abstractC2226z == null) {
            return null;
        }
        return (AbstractActivityC2221u) abstractC2226z.s();
    }

    public void n1() {
        Bundle bundle = this.f18863b;
        O0(this.f18844J, bundle != null ? bundle.getBundle("savedInstanceState") : null);
        this.f18886w.U();
    }

    public boolean o() {
        Boolean bool;
        g gVar = this.f18847M;
        if (gVar == null || (bool = gVar.f18913q) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean o0(MenuItem menuItem) {
        return false;
    }

    public final void o1(i iVar) {
        if (this.f18861a >= 0) {
            iVar.a();
        } else {
            this.f18864b0.add(iVar);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.f18842H = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        p1().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.f18842H = true;
    }

    public boolean p() {
        Boolean bool;
        g gVar = this.f18847M;
        if (gVar == null || (bool = gVar.f18912p) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void p0(Bundle bundle) {
        this.f18842H = true;
        s1();
        if (this.f18886w.O0(1)) {
            return;
        }
        this.f18886w.B();
    }

    public final AbstractActivityC2221u p1() {
        AbstractActivityC2221u abstractActivityC2221uN = n();
        if (abstractActivityC2221uN != null) {
            return abstractActivityC2221uN;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public View q() {
        g gVar = this.f18847M;
        if (gVar == null) {
            return null;
        }
        return gVar.f18897a;
    }

    public Animation q0(int i7, boolean z7, int i8) {
        return null;
    }

    public final Context q1() {
        Context contextT = t();
        if (contextT != null) {
            return contextT;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final Bundle r() {
        return this.f18870g;
    }

    public Animator r0(int i7, boolean z7, int i8) {
        return null;
    }

    public final View r1() {
        View viewV = V();
        if (viewV != null) {
            return viewV;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public final AbstractC2190H s() {
        if (this.f18885v != null) {
            return this.f18886w;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public void s1() {
        Bundle bundle;
        Bundle bundle2 = this.f18863b;
        if (bundle2 == null || (bundle = bundle2.getBundle("childFragmentManager")) == null) {
            return;
        }
        this.f18886w.k1(bundle);
        this.f18886w.B();
    }

    public void startActivityForResult(Intent intent, int i7) {
        C1(intent, i7, null);
    }

    public Context t() {
        AbstractC2226z abstractC2226z = this.f18885v;
        if (abstractC2226z == null) {
            return null;
        }
        return abstractC2226z.t();
    }

    public View t0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i7 = this.f18860Z;
        if (i7 != 0) {
            return layoutInflater.inflate(i7, viewGroup, false);
        }
        return null;
    }

    public final void t1() {
        if (AbstractC2190H.I0(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.f18844J != null) {
            Bundle bundle = this.f18863b;
            u1(bundle != null ? bundle.getBundle("savedInstanceState") : null);
        }
        this.f18863b = null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.f18869f);
        if (this.f18888y != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f18888y));
        }
        if (this.f18835A != null) {
            sb.append(" tag=");
            sb.append(this.f18835A);
        }
        sb.append(")");
        return sb.toString();
    }

    public int u() {
        g gVar = this.f18847M;
        if (gVar == null) {
            return 0;
        }
        return gVar.f18899c;
    }

    public void u0() {
        this.f18842H = true;
    }

    public final void u1(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.f18865c;
        if (sparseArray != null) {
            this.f18844J.restoreHierarchyState(sparseArray);
            this.f18865c = null;
        }
        this.f18842H = false;
        P0(bundle);
        if (this.f18842H) {
            if (this.f18844J != null) {
                this.f18856V.b(AbstractC0963i.a.ON_CREATE);
            }
        } else {
            throw new a0("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    @Override // F0.f
    public final F0.d v() {
        return this.f18859Y.b();
    }

    public void v1(int i7, int i8, int i9, int i10) {
        if (this.f18847M == null && i7 == 0 && i8 == 0 && i9 == 0 && i10 == 0) {
            return;
        }
        l().f18899c = i7;
        l().f18900d = i8;
        l().f18901e = i9;
        l().f18902f = i10;
    }

    public Object w() {
        g gVar = this.f18847M;
        if (gVar == null) {
            return null;
        }
        return gVar.f18906j;
    }

    public void w0() {
        this.f18842H = true;
    }

    public void w1(Bundle bundle) {
        if (this.f18884u != null && g0()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.f18870g = bundle;
    }

    public F.w x() {
        g gVar = this.f18847M;
        if (gVar == null) {
            return null;
        }
        gVar.getClass();
        return null;
    }

    public void x0() {
        this.f18842H = true;
    }

    public void x1(View view) {
        l().f18915s = view;
    }

    public int y() {
        g gVar = this.f18847M;
        if (gVar == null) {
            return 0;
        }
        return gVar.f18900d;
    }

    public LayoutInflater y0(Bundle bundle) {
        return D(bundle);
    }

    public void y1(int i7) {
        if (this.f18847M == null && i7 == 0) {
            return;
        }
        l();
        this.f18847M.f18903g = i7;
    }

    public Object z() {
        g gVar = this.f18847M;
        if (gVar == null) {
            return null;
        }
        return gVar.f18908l;
    }

    public void z1(boolean z7) {
        if (this.f18847M == null) {
            return;
        }
        l().f18898b = z7;
    }

    public void v0() {
    }

    public void C0(boolean z7) {
    }

    public void E0(Menu menu) {
    }

    public void G0(boolean z7) {
    }

    public void H0(Menu menu) {
    }

    public void I0(boolean z7) {
    }

    public void L0(Bundle bundle) {
    }

    public void n0(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
    }

    public void z0(boolean z7) {
    }

    public void O0(View view, Bundle bundle) {
    }

    public void s0(Menu menu, MenuInflater menuInflater) {
    }

    public void J0(int i7, String[] strArr, int[] iArr) {
    }
}
