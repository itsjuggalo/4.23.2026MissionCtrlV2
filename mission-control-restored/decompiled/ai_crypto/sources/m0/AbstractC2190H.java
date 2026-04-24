package m0;

import F0.d;
import Q.InterfaceC0681w;
import Q.InterfaceC0684z;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentContainerView;
import androidx.lifecycle.AbstractC0963i;
import androidx.lifecycle.InterfaceC0967m;
import com.revenuecat.purchases.common.Constants;
import d.C1386b;
import f.AbstractC1536c;
import f.AbstractC1538e;
import f.C1534a;
import f.C1540g;
import f.InterfaceC1535b;
import f.InterfaceC1539f;
import g.AbstractC1624a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import l0.AbstractC2153b;
import m0.AbstractC2198P;
import n0.c;

/* JADX INFO: renamed from: m0.H, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2190H {

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public static boolean f18521U = false;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public static boolean f18522V = true;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public AbstractComponentCallbacksC2216p f18523A;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public AbstractC1536c f18528F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public AbstractC1536c f18529G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public AbstractC1536c f18530H;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f18532J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public boolean f18533K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public boolean f18534L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public boolean f18535M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public boolean f18536N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public ArrayList f18537O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public ArrayList f18538P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public ArrayList f18539Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public C2193K f18540R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public c.C0312c f18541S;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f18544b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f18547e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d.w f18549g;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public AbstractC2226z f18566x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public AbstractC2223w f18567y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public AbstractComponentCallbacksC2216p f18568z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f18543a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C2197O f18545c = new C2197O();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f18546d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LayoutInflaterFactory2C2183A f18548f = new LayoutInflaterFactory2C2183A(this);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public C2201a f18550h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f18551i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d.v f18552j = new b(false);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicInteger f18553k = new AtomicInteger();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map f18554l = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map f18555m = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map f18556n = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList f18557o = new ArrayList();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final C2184B f18558p = new C2184B(this);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final CopyOnWriteArrayList f18559q = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final P.a f18560r = new P.a() { // from class: m0.C
        @Override // P.a
        public final void accept(Object obj) {
            this.f18516a.R0((Configuration) obj);
        }
    };

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final P.a f18561s = new P.a() { // from class: m0.D
        @Override // P.a
        public final void accept(Object obj) {
            this.f18517a.S0((Integer) obj);
        }
    };

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final P.a f18562t = new P.a() { // from class: m0.E
        @Override // P.a
        public final void accept(Object obj) {
            this.f18518a.T0((F.i) obj);
        }
    };

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final P.a f18563u = new P.a() { // from class: m0.F
        @Override // P.a
        public final void accept(Object obj) {
            this.f18519a.U0((F.u) obj);
        }
    };

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final InterfaceC0684z f18564v = new c();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f18565w = -1;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public AbstractC2225y f18524B = null;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public AbstractC2225y f18525C = new d();

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public Z f18526D = null;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public Z f18527E = new e();

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public ArrayDeque f18531I = new ArrayDeque();

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public Runnable f18542T = new f();

    /* JADX INFO: renamed from: m0.H$a */
    public class a implements InterfaceC1535b {
        public a() {
        }

        @Override // f.InterfaceC1535b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Map map) {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                iArr[i7] = ((Boolean) arrayList.get(i7)).booleanValue() ? 0 : -1;
            }
            k kVar = (k) AbstractC2190H.this.f18531I.pollFirst();
            if (kVar == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            String str = kVar.f18579a;
            int i8 = kVar.f18580b;
            AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216pI = AbstractC2190H.this.f18545c.i(str);
            if (abstractComponentCallbacksC2216pI != null) {
                abstractComponentCallbacksC2216pI.J0(i8, strArr, iArr);
                return;
            }
            Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
        }
    }

    /* JADX INFO: renamed from: m0.H$b */
    public class b extends d.v {
        public b(boolean z7) {
            super(z7);
        }

        @Override // d.v
        public void c() {
            if (AbstractC2190H.I0(3)) {
                Log.d("FragmentManager", "handleOnBackCancelled. PREDICTIVE_BACK = " + AbstractC2190H.f18522V + " fragment manager " + AbstractC2190H.this);
            }
            if (AbstractC2190H.f18522V) {
                AbstractC2190H.this.o();
                AbstractC2190H.this.f18550h = null;
            }
        }

        @Override // d.v
        public void d() {
            if (AbstractC2190H.I0(3)) {
                Log.d("FragmentManager", "handleOnBackPressed. PREDICTIVE_BACK = " + AbstractC2190H.f18522V + " fragment manager " + AbstractC2190H.this);
            }
            AbstractC2190H.this.E0();
        }

        @Override // d.v
        public void e(C1386b c1386b) {
            if (AbstractC2190H.I0(2)) {
                Log.v("FragmentManager", "handleOnBackProgressed. PREDICTIVE_BACK = " + AbstractC2190H.f18522V + " fragment manager " + AbstractC2190H.this);
            }
            AbstractC2190H abstractC2190H = AbstractC2190H.this;
            if (abstractC2190H.f18550h != null) {
                Iterator it = abstractC2190H.u(new ArrayList(Collections.singletonList(AbstractC2190H.this.f18550h)), 0, 1).iterator();
                while (it.hasNext()) {
                    ((Y) it.next()).y(c1386b);
                }
                Iterator it2 = AbstractC2190H.this.f18557o.iterator();
                if (it2.hasNext()) {
                    android.support.v4.media.session.b.a(it2.next());
                    throw null;
                }
            }
        }

        @Override // d.v
        public void f(C1386b c1386b) {
            if (AbstractC2190H.I0(3)) {
                Log.d("FragmentManager", "handleOnBackStarted. PREDICTIVE_BACK = " + AbstractC2190H.f18522V + " fragment manager " + AbstractC2190H.this);
            }
            if (AbstractC2190H.f18522V) {
                AbstractC2190H.this.X();
                AbstractC2190H.this.g1();
            }
        }
    }

    /* JADX INFO: renamed from: m0.H$c */
    public class c implements InterfaceC0684z {
        public c() {
        }

        @Override // Q.InterfaceC0684z
        public boolean a(MenuItem menuItem) {
            return AbstractC2190H.this.J(menuItem);
        }

        @Override // Q.InterfaceC0684z
        public void b(Menu menu) {
            AbstractC2190H.this.K(menu);
        }

        @Override // Q.InterfaceC0684z
        public void c(Menu menu, MenuInflater menuInflater) {
            AbstractC2190H.this.C(menu, menuInflater);
        }

        @Override // Q.InterfaceC0684z
        public void d(Menu menu) {
            AbstractC2190H.this.O(menu);
        }
    }

    /* JADX INFO: renamed from: m0.H$d */
    public class d extends AbstractC2225y {
        public d() {
        }

        @Override // m0.AbstractC2225y
        public AbstractComponentCallbacksC2216p a(ClassLoader classLoader, String str) {
            return AbstractC2190H.this.v0().c(AbstractC2190H.this.v0().t(), str, null);
        }
    }

    /* JADX INFO: renamed from: m0.H$e */
    public class e implements Z {
        public e() {
        }

        @Override // m0.Z
        public Y a(ViewGroup viewGroup) {
            return new C2206f(viewGroup);
        }
    }

    /* JADX INFO: renamed from: m0.H$f */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC2190H.this.a0(true);
        }
    }

    /* JADX INFO: renamed from: m0.H$g */
    public class g implements InterfaceC2194L {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractComponentCallbacksC2216p f18575a;

        public g(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
            this.f18575a = abstractComponentCallbacksC2216p;
        }

        @Override // m0.InterfaceC2194L
        public void b(AbstractC2190H abstractC2190H, AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
            this.f18575a.n0(abstractComponentCallbacksC2216p);
        }
    }

    /* JADX INFO: renamed from: m0.H$h */
    public class h implements InterfaceC1535b {
        public h() {
        }

        @Override // f.InterfaceC1535b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C1534a c1534a) {
            k kVar = (k) AbstractC2190H.this.f18531I.pollLast();
            if (kVar == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = kVar.f18579a;
            int i7 = kVar.f18580b;
            AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216pI = AbstractC2190H.this.f18545c.i(str);
            if (abstractComponentCallbacksC2216pI != null) {
                abstractComponentCallbacksC2216pI.k0(i7, c1534a.c(), c1534a.a());
                return;
            }
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }
    }

    /* JADX INFO: renamed from: m0.H$i */
    public class i implements InterfaceC1535b {
        public i() {
        }

        @Override // f.InterfaceC1535b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C1534a c1534a) {
            k kVar = (k) AbstractC2190H.this.f18531I.pollFirst();
            if (kVar == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = kVar.f18579a;
            int i7 = kVar.f18580b;
            AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216pI = AbstractC2190H.this.f18545c.i(str);
            if (abstractComponentCallbacksC2216pI != null) {
                abstractComponentCallbacksC2216pI.k0(i7, c1534a.c(), c1534a.a());
                return;
            }
            Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
        }
    }

    /* JADX INFO: renamed from: m0.H$j */
    public static class j extends AbstractC1624a {
        @Override // g.AbstractC1624a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(Context context, C1540g c1540g) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent intentA = c1540g.a();
            if (intentA != null && (bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (intentA.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    c1540g = new C1540g.a(c1540g.e()).b(null).c(c1540g.d(), c1540g.c()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", c1540g);
            if (AbstractC2190H.I0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // g.AbstractC1624a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public C1534a c(int i7, Intent intent) {
            return new C1534a(i7, intent);
        }
    }

    /* JADX INFO: renamed from: m0.H$l */
    public interface l {
        boolean a(ArrayList arrayList, ArrayList arrayList2);
    }

    /* JADX INFO: renamed from: m0.H$m */
    public class m implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f18581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f18582b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f18583c;

        public m(String str, int i7, int i8) {
            this.f18581a = str;
            this.f18582b = i7;
            this.f18583c = i8;
        }

        @Override // m0.AbstractC2190H.l
        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p = AbstractC2190H.this.f18523A;
            if (abstractComponentCallbacksC2216p == null || this.f18582b >= 0 || this.f18581a != null || !abstractComponentCallbacksC2216p.s().b1()) {
                return AbstractC2190H.this.e1(arrayList, arrayList2, this.f18581a, this.f18582b, this.f18583c);
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: m0.H$n */
    public class n implements l {
        public n() {
        }

        @Override // m0.AbstractC2190H.l
        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            boolean zF1 = AbstractC2190H.this.f1(arrayList, arrayList2);
            AbstractC2190H abstractC2190H = AbstractC2190H.this;
            abstractC2190H.f18551i = true;
            if (!abstractC2190H.f18557o.isEmpty() && arrayList.size() > 0) {
                ((Boolean) arrayList2.get(arrayList.size() - 1)).booleanValue();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    linkedHashSet.addAll(AbstractC2190H.this.n0((C2201a) it.next()));
                }
                Iterator it2 = AbstractC2190H.this.f18557o.iterator();
                while (it2.hasNext()) {
                    android.support.v4.media.session.b.a(it2.next());
                    Iterator it3 = linkedHashSet.iterator();
                    if (it3.hasNext()) {
                        throw null;
                    }
                }
            }
            return zF1;
        }
    }

    public static AbstractComponentCallbacksC2216p C0(View view) {
        Object tag = view.getTag(AbstractC2153b.f18281a);
        if (tag instanceof AbstractComponentCallbacksC2216p) {
            return (AbstractComponentCallbacksC2216p) tag;
        }
        return null;
    }

    public static boolean I0(int i7) {
        return f18521U || Log.isLoggable("FragmentManager", i7);
    }

    public static void c0(ArrayList arrayList, ArrayList arrayList2, int i7, int i8) {
        while (i7 < i8) {
            C2201a c2201a = (C2201a) arrayList.get(i7);
            if (((Boolean) arrayList2.get(i7)).booleanValue()) {
                c2201a.p(-1);
                c2201a.u();
            } else {
                c2201a.p(1);
                c2201a.t();
            }
            i7++;
        }
    }

    public static AbstractC2190H k0(View view) {
        AbstractActivityC2221u abstractActivityC2221u;
        AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216pL0 = l0(view);
        if (abstractComponentCallbacksC2216pL0 != null) {
            if (abstractComponentCallbacksC2216pL0.a0()) {
                return abstractComponentCallbacksC2216pL0.s();
            }
            throw new IllegalStateException("The Fragment " + abstractComponentCallbacksC2216pL0 + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        Context context = view.getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                abstractActivityC2221u = null;
                break;
            }
            if (context instanceof AbstractActivityC2221u) {
                abstractActivityC2221u = (AbstractActivityC2221u) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (abstractActivityC2221u != null) {
            return abstractActivityC2221u.a0();
        }
        throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
    }

    public static AbstractComponentCallbacksC2216p l0(View view) {
        while (view != null) {
            AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216pC0 = C0(view);
            if (abstractComponentCallbacksC2216pC0 != null) {
                return abstractComponentCallbacksC2216pC0;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    public static int l1(int i7) {
        int i8 = 4097;
        if (i7 == 4097) {
            return 8194;
        }
        if (i7 != 8194) {
            i8 = 8197;
            if (i7 == 8197) {
                return 4100;
            }
            if (i7 == 4099) {
                return 4099;
            }
            if (i7 != 4100) {
                return 0;
            }
        }
        return i8;
    }

    public boolean A(MenuItem menuItem) {
        if (this.f18565w < 1) {
            return false;
        }
        for (AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p : this.f18545c.o()) {
            if (abstractComponentCallbacksC2216p != null && abstractComponentCallbacksC2216p.T0(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public Z A0() {
        Z z7 = this.f18526D;
        if (z7 != null) {
            return z7;
        }
        AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p = this.f18568z;
        return abstractComponentCallbacksC2216p != null ? abstractComponentCallbacksC2216p.f18884u.A0() : this.f18527E;
    }

    public void B() {
        this.f18533K = false;
        this.f18534L = false;
        this.f18540R.q(false);
        S(1);
    }

    public c.C0312c B0() {
        return this.f18541S;
    }

    public boolean C(Menu menu, MenuInflater menuInflater) {
        if (this.f18565w < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z7 = false;
        for (AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p : this.f18545c.o()) {
            if (abstractComponentCallbacksC2216p != null && M0(abstractComponentCallbacksC2216p) && abstractComponentCallbacksC2216p.V0(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(abstractComponentCallbacksC2216p);
                z7 = true;
            }
        }
        if (this.f18547e != null) {
            for (int i7 = 0; i7 < this.f18547e.size(); i7++) {
                AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p2 = (AbstractComponentCallbacksC2216p) this.f18547e.get(i7);
                if (arrayList == null || !arrayList.contains(abstractComponentCallbacksC2216p2)) {
                    abstractComponentCallbacksC2216p2.v0();
                }
            }
        }
        this.f18547e = arrayList;
        return z7;
    }

    public void D() {
        this.f18535M = true;
        a0(true);
        X();
        s();
        S(-1);
        Object obj = this.f18566x;
        if (obj instanceof G.d) {
            ((G.d) obj).q(this.f18561s);
        }
        Object obj2 = this.f18566x;
        if (obj2 instanceof G.c) {
            ((G.c) obj2).d(this.f18560r);
        }
        Object obj3 = this.f18566x;
        if (obj3 instanceof F.q) {
            ((F.q) obj3).k(this.f18562t);
        }
        Object obj4 = this.f18566x;
        if (obj4 instanceof F.r) {
            ((F.r) obj4).i(this.f18563u);
        }
        Object obj5 = this.f18566x;
        if ((obj5 instanceof InterfaceC0681w) && this.f18568z == null) {
            ((InterfaceC0681w) obj5).o(this.f18564v);
        }
        this.f18566x = null;
        this.f18567y = null;
        this.f18568z = null;
        if (this.f18549g != null) {
            this.f18552j.h();
            this.f18549g = null;
        }
        AbstractC1536c abstractC1536c = this.f18528F;
        if (abstractC1536c != null) {
            abstractC1536c.c();
            this.f18529G.c();
            this.f18530H.c();
        }
    }

    public androidx.lifecycle.M D0(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
        return this.f18540R.n(abstractComponentCallbacksC2216p);
    }

    public void E() {
        S(1);
    }

    public void E0() {
        a0(true);
        if (!f18522V || this.f18550h == null) {
            if (this.f18552j.g()) {
                if (I0(3)) {
                    Log.d("FragmentManager", "Calling popBackStackImmediate via onBackPressed callback");
                }
                b1();
                return;
            } else {
                if (I0(3)) {
                    Log.d("FragmentManager", "Calling onBackPressed via onBackPressed callback");
                }
                this.f18549g.k();
                return;
            }
        }
        if (!this.f18557o.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(n0(this.f18550h));
            Iterator it = this.f18557o.iterator();
            while (it.hasNext()) {
                android.support.v4.media.session.b.a(it.next());
                Iterator it2 = linkedHashSet.iterator();
                if (it2.hasNext()) {
                    throw null;
                }
            }
        }
        Iterator it3 = this.f18550h.f18630c.iterator();
        while (it3.hasNext()) {
            AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p = ((AbstractC2198P.a) it3.next()).f18648b;
            if (abstractComponentCallbacksC2216p != null) {
                abstractComponentCallbacksC2216p.f18877n = false;
            }
        }
        Iterator it4 = u(new ArrayList(Collections.singletonList(this.f18550h)), 0, 1).iterator();
        while (it4.hasNext()) {
            ((Y) it4.next()).f();
        }
        this.f18550h = null;
        v1();
        if (I0(3)) {
            Log.d("FragmentManager", "Op is being set to null");
            Log.d("FragmentManager", "OnBackPressedCallback enabled=" + this.f18552j.g() + " for  FragmentManager " + this);
        }
    }

    public void F(boolean z7) {
        if (z7 && (this.f18566x instanceof G.d)) {
            u1(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p : this.f18545c.o()) {
            if (abstractComponentCallbacksC2216p != null) {
                abstractComponentCallbacksC2216p.b1();
                if (z7) {
                    abstractComponentCallbacksC2216p.f18886w.F(true);
                }
            }
        }
    }

    public void F0(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
        if (I0(2)) {
            Log.v("FragmentManager", "hide: " + abstractComponentCallbacksC2216p);
        }
        if (abstractComponentCallbacksC2216p.f18836B) {
            return;
        }
        abstractComponentCallbacksC2216p.f18836B = true;
        abstractComponentCallbacksC2216p.f18850P = true ^ abstractComponentCallbacksC2216p.f18850P;
        r1(abstractComponentCallbacksC2216p);
    }

    public void G(boolean z7, boolean z8) {
        if (z8 && (this.f18566x instanceof F.q)) {
            u1(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p : this.f18545c.o()) {
            if (abstractComponentCallbacksC2216p != null) {
                abstractComponentCallbacksC2216p.c1(z7);
                if (z8) {
                    abstractComponentCallbacksC2216p.f18886w.G(z7, true);
                }
            }
        }
    }

    public void G0(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
        if (abstractComponentCallbacksC2216p.f18875l && J0(abstractComponentCallbacksC2216p)) {
            this.f18532J = true;
        }
    }

    public void H(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
        Iterator it = this.f18559q.iterator();
        while (it.hasNext()) {
            ((InterfaceC2194L) it.next()).b(this, abstractComponentCallbacksC2216p);
        }
    }

    public boolean H0() {
        return this.f18535M;
    }

    public void I() {
        for (AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p : this.f18545c.l()) {
            if (abstractComponentCallbacksC2216p != null) {
                abstractComponentCallbacksC2216p.z0(abstractComponentCallbacksC2216p.b0());
                abstractComponentCallbacksC2216p.f18886w.I();
            }
        }
    }

    public boolean J(MenuItem menuItem) {
        if (this.f18565w < 1) {
            return false;
        }
        for (AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p : this.f18545c.o()) {
            if (abstractComponentCallbacksC2216p != null && abstractComponentCallbacksC2216p.d1(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final boolean J0(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
        return (abstractComponentCallbacksC2216p.f18840F && abstractComponentCallbacksC2216p.f18841G) || abstractComponentCallbacksC2216p.f18886w.p();
    }

    public void K(Menu menu) {
        if (this.f18565w < 1) {
            return;
        }
        for (AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p : this.f18545c.o()) {
            if (abstractComponentCallbacksC2216p != null) {
                abstractComponentCallbacksC2216p.e1(menu);
            }
        }
    }

    public final boolean K0() {
        AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p = this.f18568z;
        if (abstractComponentCallbacksC2216p == null) {
            return true;
        }
        return abstractComponentCallbacksC2216p.a0() && this.f18568z.H().K0();
    }

    public final void L(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
        if (abstractComponentCallbacksC2216p == null || !abstractComponentCallbacksC2216p.equals(f0(abstractComponentCallbacksC2216p.f18869f))) {
            return;
        }
        abstractComponentCallbacksC2216p.i1();
    }

    public boolean L0(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
        if (abstractComponentCallbacksC2216p == null) {
            return false;
        }
        return abstractComponentCallbacksC2216p.b0();
    }

    public void M() {
        S(5);
    }

    public boolean M0(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
        if (abstractComponentCallbacksC2216p == null) {
            return true;
        }
        return abstractComponentCallbacksC2216p.d0();
    }

    public void N(boolean z7, boolean z8) {
        if (z8 && (this.f18566x instanceof F.r)) {
            u1(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p : this.f18545c.o()) {
            if (abstractComponentCallbacksC2216p != null) {
                abstractComponentCallbacksC2216p.g1(z7);
                if (z8) {
                    abstractComponentCallbacksC2216p.f18886w.N(z7, true);
                }
            }
        }
    }

    public boolean N0(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
        if (abstractComponentCallbacksC2216p == null) {
            return true;
        }
        AbstractC2190H abstractC2190H = abstractComponentCallbacksC2216p.f18884u;
        return abstractComponentCallbacksC2216p.equals(abstractC2190H.z0()) && N0(abstractC2190H.f18568z);
    }

    public boolean O(Menu menu) {
        boolean z7 = false;
        if (this.f18565w < 1) {
            return false;
        }
        for (AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p : this.f18545c.o()) {
            if (abstractComponentCallbacksC2216p != null && M0(abstractComponentCallbacksC2216p) && abstractComponentCallbacksC2216p.h1(menu)) {
                z7 = true;
            }
        }
        return z7;
    }

    public boolean O0(int i7) {
        return this.f18565w >= i7;
    }

    public void P() {
        v1();
        L(this.f18523A);
    }

    public boolean P0() {
        return this.f18533K || this.f18534L;
    }

    public void Q() {
        this.f18533K = false;
        this.f18534L = false;
        this.f18540R.q(false);
        S(7);
    }

    public void R() {
        this.f18533K = false;
        this.f18534L = false;
        this.f18540R.q(false);
        S(5);
    }

    public final /* synthetic */ void R0(Configuration configuration) {
        if (K0()) {
            z(configuration, false);
        }
    }

    public final void S(int i7) {
        try {
            this.f18544b = true;
            this.f18545c.d(i7);
            W0(i7, false);
            Iterator it = t().iterator();
            while (it.hasNext()) {
                ((Y) it.next()).q();
            }
            this.f18544b = false;
            a0(true);
        } catch (Throwable th) {
            this.f18544b = false;
            throw th;
        }
    }

    public final /* synthetic */ void S0(Integer num) {
        if (K0() && num.intValue() == 80) {
            F(false);
        }
    }

    public void T() {
        this.f18534L = true;
        this.f18540R.q(true);
        S(4);
    }

    public final /* synthetic */ void T0(F.i iVar) {
        if (K0()) {
            G(iVar.a(), false);
        }
    }

    public void U() {
        S(2);
    }

    public final /* synthetic */ void U0(F.u uVar) {
        if (K0()) {
            N(uVar.a(), false);
        }
    }

    public final void V() {
        if (this.f18536N) {
            this.f18536N = false;
            t1();
        }
    }

    public void V0(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p, Intent intent, int i7, Bundle bundle) {
        if (this.f18528F == null) {
            this.f18566x.A(abstractComponentCallbacksC2216p, intent, i7, bundle);
            return;
        }
        this.f18531I.addLast(new k(abstractComponentCallbacksC2216p.f18869f, i7));
        if (bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        this.f18528F.a(intent);
    }

    public void W(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        String str2 = str + "    ";
        this.f18545c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList arrayList = this.f18547e;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i7 = 0; i7 < size; i7++) {
                AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p = (AbstractComponentCallbacksC2216p) this.f18547e.get(i7);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i7);
                printWriter.print(": ");
                printWriter.println(abstractComponentCallbacksC2216p.toString());
            }
        }
        int size2 = this.f18546d.size();
        if (size2 > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i8 = 0; i8 < size2; i8++) {
                C2201a c2201a = (C2201a) this.f18546d.get(i8);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i8);
                printWriter.print(": ");
                printWriter.println(c2201a.toString());
                c2201a.r(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f18553k.get());
        synchronized (this.f18543a) {
            try {
                int size3 = this.f18543a.size();
                if (size3 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i9 = 0; i9 < size3; i9++) {
                        l lVar = (l) this.f18543a.get(i9);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i9);
                        printWriter.print(": ");
                        printWriter.println(lVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f18566x);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f18567y);
        if (this.f18568z != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f18568z);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f18565w);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f18533K);
        printWriter.print(" mStopped=");
        printWriter.print(this.f18534L);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f18535M);
        if (this.f18532J) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f18532J);
        }
    }

    public void W0(int i7, boolean z7) {
        AbstractC2226z abstractC2226z;
        if (this.f18566x == null && i7 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z7 || i7 != this.f18565w) {
            this.f18565w = i7;
            this.f18545c.t();
            t1();
            if (this.f18532J && (abstractC2226z = this.f18566x) != null && this.f18565w == 7) {
                abstractC2226z.B();
                this.f18532J = false;
            }
        }
    }

    public final void X() {
        Iterator it = t().iterator();
        while (it.hasNext()) {
            ((Y) it.next()).q();
        }
    }

    public void X0() {
        if (this.f18566x == null) {
            return;
        }
        this.f18533K = false;
        this.f18534L = false;
        this.f18540R.q(false);
        for (AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p : this.f18545c.o()) {
            if (abstractComponentCallbacksC2216p != null) {
                abstractComponentCallbacksC2216p.i0();
            }
        }
    }

    public void Y(l lVar, boolean z7) {
        if (!z7) {
            if (this.f18566x == null) {
                if (!this.f18535M) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            q();
        }
        synchronized (this.f18543a) {
            try {
                if (this.f18566x == null) {
                    if (!z7) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f18543a.add(lVar);
                    n1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void Y0(FragmentContainerView fragmentContainerView) {
        View view;
        for (C2196N c2196n : this.f18545c.k()) {
            AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216pK = c2196n.k();
            if (abstractComponentCallbacksC2216pK.f18889z == fragmentContainerView.getId() && (view = abstractComponentCallbacksC2216pK.f18844J) != null && view.getParent() == null) {
                abstractComponentCallbacksC2216pK.f18843I = fragmentContainerView;
                c2196n.b();
            }
        }
    }

    public final void Z(boolean z7) {
        if (this.f18544b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f18566x == null) {
            if (!this.f18535M) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f18566x.w().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z7) {
            q();
        }
        if (this.f18537O == null) {
            this.f18537O = new ArrayList();
            this.f18538P = new ArrayList();
        }
    }

    public void Z0(C2196N c2196n) {
        AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216pK = c2196n.k();
        if (abstractComponentCallbacksC2216pK.f18845K) {
            if (this.f18544b) {
                this.f18536N = true;
            } else {
                abstractComponentCallbacksC2216pK.f18845K = false;
                c2196n.m();
            }
        }
    }

    public boolean a0(boolean z7) {
        Z(z7);
        boolean z8 = false;
        while (o0(this.f18537O, this.f18538P)) {
            z8 = true;
            this.f18544b = true;
            try {
                i1(this.f18537O, this.f18538P);
            } finally {
                r();
            }
        }
        v1();
        V();
        this.f18545c.b();
        return z8;
    }

    public void a1(int i7, int i8, boolean z7) {
        if (i7 >= 0) {
            Y(new m(null, i7, i8), z7);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i7);
    }

    public void b0(l lVar, boolean z7) {
        if (z7 && (this.f18566x == null || this.f18535M)) {
            return;
        }
        Z(z7);
        if (lVar.a(this.f18537O, this.f18538P)) {
            this.f18544b = true;
            try {
                i1(this.f18537O, this.f18538P);
            } finally {
                r();
            }
        }
        v1();
        V();
        this.f18545c.b();
    }

    public boolean b1() {
        return d1(null, -1, 0);
    }

    public boolean c1(int i7, int i8) {
        if (i7 >= 0) {
            return d1(null, i7, i8);
        }
        throw new IllegalArgumentException("Bad id: " + i7);
    }

    public final void d0(ArrayList arrayList, ArrayList arrayList2, int i7, int i8) {
        boolean z7 = ((C2201a) arrayList.get(i7)).f18645r;
        ArrayList arrayList3 = this.f18539Q;
        if (arrayList3 == null) {
            this.f18539Q = new ArrayList();
        } else {
            arrayList3.clear();
        }
        this.f18539Q.addAll(this.f18545c.o());
        AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216pZ0 = z0();
        boolean z8 = false;
        for (int i9 = i7; i9 < i8; i9++) {
            C2201a c2201a = (C2201a) arrayList.get(i9);
            abstractComponentCallbacksC2216pZ0 = !((Boolean) arrayList2.get(i9)).booleanValue() ? c2201a.v(this.f18539Q, abstractComponentCallbacksC2216pZ0) : c2201a.y(this.f18539Q, abstractComponentCallbacksC2216pZ0);
            z8 = z8 || c2201a.f18636i;
        }
        this.f18539Q.clear();
        if (!z7 && this.f18565w >= 1) {
            for (int i10 = i7; i10 < i8; i10++) {
                Iterator it = ((C2201a) arrayList.get(i10)).f18630c.iterator();
                while (it.hasNext()) {
                    AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p = ((AbstractC2198P.a) it.next()).f18648b;
                    if (abstractComponentCallbacksC2216p != null && abstractComponentCallbacksC2216p.f18884u != null) {
                        this.f18545c.r(v(abstractComponentCallbacksC2216p));
                    }
                }
            }
        }
        c0(arrayList, arrayList2, i7, i8);
        boolean zBooleanValue = ((Boolean) arrayList2.get(i8 - 1)).booleanValue();
        if (z8 && !this.f18557o.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                linkedHashSet.addAll(n0((C2201a) it2.next()));
            }
            if (this.f18550h == null) {
                Iterator it3 = this.f18557o.iterator();
                while (it3.hasNext()) {
                    android.support.v4.media.session.b.a(it3.next());
                    Iterator it4 = linkedHashSet.iterator();
                    if (it4.hasNext()) {
                        throw null;
                    }
                }
                Iterator it5 = this.f18557o.iterator();
                while (it5.hasNext()) {
                    android.support.v4.media.session.b.a(it5.next());
                    Iterator it6 = linkedHashSet.iterator();
                    if (it6.hasNext()) {
                        throw null;
                    }
                }
            }
        }
        for (int i11 = i7; i11 < i8; i11++) {
            C2201a c2201a2 = (C2201a) arrayList.get(i11);
            if (zBooleanValue) {
                for (int size = c2201a2.f18630c.size() - 1; size >= 0; size--) {
                    AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p2 = ((AbstractC2198P.a) c2201a2.f18630c.get(size)).f18648b;
                    if (abstractComponentCallbacksC2216p2 != null) {
                        v(abstractComponentCallbacksC2216p2).m();
                    }
                }
            } else {
                Iterator it7 = c2201a2.f18630c.iterator();
                while (it7.hasNext()) {
                    AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p3 = ((AbstractC2198P.a) it7.next()).f18648b;
                    if (abstractComponentCallbacksC2216p3 != null) {
                        v(abstractComponentCallbacksC2216p3).m();
                    }
                }
            }
        }
        W0(this.f18565w, true);
        for (Y y7 : u(arrayList, i7, i8)) {
            y7.B(zBooleanValue);
            y7.x();
            y7.n();
        }
        while (i7 < i8) {
            C2201a c2201a3 = (C2201a) arrayList.get(i7);
            if (((Boolean) arrayList2.get(i7)).booleanValue() && c2201a3.f18728v >= 0) {
                c2201a3.f18728v = -1;
            }
            c2201a3.x();
            i7++;
        }
        if (z8) {
            j1();
        }
    }

    public final boolean d1(String str, int i7, int i8) {
        a0(false);
        Z(true);
        AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p = this.f18523A;
        if (abstractComponentCallbacksC2216p != null && i7 < 0 && str == null && abstractComponentCallbacksC2216p.s().b1()) {
            return true;
        }
        boolean zE1 = e1(this.f18537O, this.f18538P, str, i7, i8);
        if (zE1) {
            this.f18544b = true;
            try {
                i1(this.f18537O, this.f18538P);
            } finally {
                r();
            }
        }
        v1();
        V();
        this.f18545c.b();
        return zE1;
    }

    public boolean e0() {
        boolean zA0 = a0(true);
        m0();
        return zA0;
    }

    public boolean e1(ArrayList arrayList, ArrayList arrayList2, String str, int i7, int i8) {
        int iG0 = g0(str, i7, (i8 & 1) != 0);
        if (iG0 < 0) {
            return false;
        }
        for (int size = this.f18546d.size() - 1; size >= iG0; size--) {
            arrayList.add((C2201a) this.f18546d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public AbstractComponentCallbacksC2216p f0(String str) {
        return this.f18545c.f(str);
    }

    public boolean f1(ArrayList arrayList, ArrayList arrayList2) {
        ArrayList arrayList3 = this.f18546d;
        C2201a c2201a = (C2201a) arrayList3.get(arrayList3.size() - 1);
        this.f18550h = c2201a;
        Iterator it = c2201a.f18630c.iterator();
        while (it.hasNext()) {
            AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p = ((AbstractC2198P.a) it.next()).f18648b;
            if (abstractComponentCallbacksC2216p != null) {
                abstractComponentCallbacksC2216p.f18877n = true;
            }
        }
        return e1(arrayList, arrayList2, null, -1, 0);
    }

    public final int g0(String str, int i7, boolean z7) {
        if (this.f18546d.isEmpty()) {
            return -1;
        }
        if (str == null && i7 < 0) {
            if (z7) {
                return 0;
            }
            return this.f18546d.size() - 1;
        }
        int size = this.f18546d.size() - 1;
        while (size >= 0) {
            C2201a c2201a = (C2201a) this.f18546d.get(size);
            if ((str != null && str.equals(c2201a.w())) || (i7 >= 0 && i7 == c2201a.f18728v)) {
                break;
            }
            size--;
        }
        if (size < 0) {
            return size;
        }
        if (!z7) {
            if (size == this.f18546d.size() - 1) {
                return -1;
            }
            return size + 1;
        }
        while (size > 0) {
            C2201a c2201a2 = (C2201a) this.f18546d.get(size - 1);
            if ((str == null || !str.equals(c2201a2.w())) && (i7 < 0 || i7 != c2201a2.f18728v)) {
                return size;
            }
            size--;
        }
        return size;
    }

    public void g1() {
        Y(new n(), false);
    }

    public void h(C2201a c2201a) {
        this.f18546d.add(c2201a);
    }

    public AbstractComponentCallbacksC2216p h0(int i7) {
        return this.f18545c.g(i7);
    }

    public void h1(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
        if (I0(2)) {
            Log.v("FragmentManager", "remove: " + abstractComponentCallbacksC2216p + " nesting=" + abstractComponentCallbacksC2216p.f18883t);
        }
        boolean zC0 = abstractComponentCallbacksC2216p.c0();
        if (abstractComponentCallbacksC2216p.f18837C && zC0) {
            return;
        }
        this.f18545c.u(abstractComponentCallbacksC2216p);
        if (J0(abstractComponentCallbacksC2216p)) {
            this.f18532J = true;
        }
        abstractComponentCallbacksC2216p.f18876m = true;
        r1(abstractComponentCallbacksC2216p);
    }

    public C2196N i(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
        String str = abstractComponentCallbacksC2216p.f18853S;
        if (str != null) {
            n0.c.f(abstractComponentCallbacksC2216p, str);
        }
        if (I0(2)) {
            Log.v("FragmentManager", "add: " + abstractComponentCallbacksC2216p);
        }
        C2196N c2196nV = v(abstractComponentCallbacksC2216p);
        abstractComponentCallbacksC2216p.f18884u = this;
        this.f18545c.r(c2196nV);
        if (!abstractComponentCallbacksC2216p.f18837C) {
            this.f18545c.a(abstractComponentCallbacksC2216p);
            abstractComponentCallbacksC2216p.f18876m = false;
            if (abstractComponentCallbacksC2216p.f18844J == null) {
                abstractComponentCallbacksC2216p.f18850P = false;
            }
            if (J0(abstractComponentCallbacksC2216p)) {
                this.f18532J = true;
            }
        }
        return c2196nV;
    }

    public AbstractComponentCallbacksC2216p i0(String str) {
        return this.f18545c.h(str);
    }

    public final void i1(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i7 = 0;
        int i8 = 0;
        while (i7 < size) {
            if (!((C2201a) arrayList.get(i7)).f18645r) {
                if (i8 != i7) {
                    d0(arrayList, arrayList2, i8, i7);
                }
                i8 = i7 + 1;
                if (((Boolean) arrayList2.get(i7)).booleanValue()) {
                    while (i8 < size && ((Boolean) arrayList2.get(i8)).booleanValue() && !((C2201a) arrayList.get(i8)).f18645r) {
                        i8++;
                    }
                }
                d0(arrayList, arrayList2, i7, i8);
                i7 = i8 - 1;
            }
            i7++;
        }
        if (i8 != size) {
            d0(arrayList, arrayList2, i8, size);
        }
    }

    public void j(InterfaceC2194L interfaceC2194L) {
        this.f18559q.add(interfaceC2194L);
    }

    public AbstractComponentCallbacksC2216p j0(String str) {
        return this.f18545c.i(str);
    }

    public final void j1() {
        if (this.f18557o.size() <= 0) {
            return;
        }
        android.support.v4.media.session.b.a(this.f18557o.get(0));
        throw null;
    }

    public int k() {
        return this.f18553k.getAndIncrement();
    }

    public void k1(Parcelable parcelable) {
        C2196N c2196n;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable == null) {
            return;
        }
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.f18566x.t().getClassLoader());
                this.f18555m.put(str.substring(7), bundle2);
            }
        }
        HashMap map = new HashMap();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.f18566x.t().getClassLoader());
                map.put(str2.substring(9), bundle);
            }
        }
        this.f18545c.x(map);
        C2192J c2192j = (C2192J) bundle3.getParcelable("state");
        if (c2192j == null) {
            return;
        }
        this.f18545c.v();
        Iterator it = c2192j.f18586a.iterator();
        while (it.hasNext()) {
            Bundle bundleB = this.f18545c.B((String) it.next(), null);
            if (bundleB != null) {
                AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216pJ = this.f18540R.j(((C2195M) bundleB.getParcelable("state")).f18603b);
                if (abstractComponentCallbacksC2216pJ != null) {
                    if (I0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + abstractComponentCallbacksC2216pJ);
                    }
                    c2196n = new C2196N(this.f18558p, this.f18545c, abstractComponentCallbacksC2216pJ, bundleB);
                } else {
                    c2196n = new C2196N(this.f18558p, this.f18545c, this.f18566x.t().getClassLoader(), t0(), bundleB);
                }
                AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216pK = c2196n.k();
                abstractComponentCallbacksC2216pK.f18863b = bundleB;
                abstractComponentCallbacksC2216pK.f18884u = this;
                if (I0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + abstractComponentCallbacksC2216pK.f18869f + "): " + abstractComponentCallbacksC2216pK);
                }
                c2196n.o(this.f18566x.t().getClassLoader());
                this.f18545c.r(c2196n);
                c2196n.s(this.f18565w);
            }
        }
        for (AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p : this.f18540R.m()) {
            if (!this.f18545c.c(abstractComponentCallbacksC2216p.f18869f)) {
                if (I0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + abstractComponentCallbacksC2216p + " that was not found in the set of active Fragments " + c2192j.f18586a);
                }
                this.f18540R.p(abstractComponentCallbacksC2216p);
                abstractComponentCallbacksC2216p.f18884u = this;
                C2196N c2196n2 = new C2196N(this.f18558p, this.f18545c, abstractComponentCallbacksC2216p);
                c2196n2.s(1);
                c2196n2.m();
                abstractComponentCallbacksC2216p.f18876m = true;
                c2196n2.m();
            }
        }
        this.f18545c.w(c2192j.f18587b);
        if (c2192j.f18588c != null) {
            this.f18546d = new ArrayList(c2192j.f18588c.length);
            int i7 = 0;
            while (true) {
                C2202b[] c2202bArr = c2192j.f18588c;
                if (i7 >= c2202bArr.length) {
                    break;
                }
                C2201a c2201aC = c2202bArr[i7].c(this);
                if (I0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i7 + " (index " + c2201aC.f18728v + "): " + c2201aC);
                    PrintWriter printWriter = new PrintWriter(new V("FragmentManager"));
                    c2201aC.s("  ", printWriter, false);
                    printWriter.close();
                }
                this.f18546d.add(c2201aC);
                i7++;
            }
        } else {
            this.f18546d = new ArrayList();
        }
        this.f18553k.set(c2192j.f18589d);
        String str3 = c2192j.f18590e;
        if (str3 != null) {
            AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216pF0 = f0(str3);
            this.f18523A = abstractComponentCallbacksC2216pF0;
            L(abstractComponentCallbacksC2216pF0);
        }
        ArrayList arrayList = c2192j.f18591f;
        if (arrayList != null) {
            for (int i8 = 0; i8 < arrayList.size(); i8++) {
                this.f18554l.put((String) arrayList.get(i8), (C2203c) c2192j.f18592g.get(i8));
            }
        }
        this.f18531I = new ArrayDeque(c2192j.f18593h);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void l(AbstractC2226z abstractC2226z, AbstractC2223w abstractC2223w, AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
        String str;
        if (this.f18566x != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f18566x = abstractC2226z;
        this.f18567y = abstractC2223w;
        this.f18568z = abstractComponentCallbacksC2216p;
        if (abstractComponentCallbacksC2216p != null) {
            j(new g(abstractComponentCallbacksC2216p));
        } else if (abstractC2226z instanceof InterfaceC2194L) {
            j((InterfaceC2194L) abstractC2226z);
        }
        if (this.f18568z != null) {
            v1();
        }
        if (abstractC2226z instanceof d.y) {
            d.y yVar = (d.y) abstractC2226z;
            d.w wVarH = yVar.h();
            this.f18549g = wVarH;
            InterfaceC0967m interfaceC0967m = yVar;
            if (abstractComponentCallbacksC2216p != null) {
                interfaceC0967m = abstractComponentCallbacksC2216p;
            }
            wVarH.h(interfaceC0967m, this.f18552j);
        }
        if (abstractComponentCallbacksC2216p != null) {
            this.f18540R = abstractComponentCallbacksC2216p.f18884u.q0(abstractComponentCallbacksC2216p);
        } else if (abstractC2226z instanceof androidx.lifecycle.N) {
            this.f18540R = C2193K.l(((androidx.lifecycle.N) abstractC2226z).f());
        } else {
            this.f18540R = new C2193K(false);
        }
        this.f18540R.q(P0());
        this.f18545c.A(this.f18540R);
        Object obj = this.f18566x;
        if ((obj instanceof F0.f) && abstractComponentCallbacksC2216p == null) {
            F0.d dVarV = ((F0.f) obj).v();
            dVarV.h("android:support:fragments", new d.c() { // from class: m0.G
                @Override // F0.d.c
                public final Bundle a() {
                    return this.f18520a.Q0();
                }
            });
            Bundle bundleB = dVarV.b("android:support:fragments");
            if (bundleB != null) {
                k1(bundleB);
            }
        }
        Object obj2 = this.f18566x;
        if (obj2 instanceof InterfaceC1539f) {
            AbstractC1538e abstractC1538eE = ((InterfaceC1539f) obj2).e();
            if (abstractComponentCallbacksC2216p != null) {
                str = abstractComponentCallbacksC2216p.f18869f + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
            } else {
                str = "";
            }
            String str2 = "FragmentManager:" + str;
            this.f18528F = abstractC1538eE.m(str2 + "StartActivityForResult", new g.h(), new h());
            this.f18529G = abstractC1538eE.m(str2 + "StartIntentSenderForResult", new j(), new i());
            this.f18530H = abstractC1538eE.m(str2 + "RequestPermissions", new g.g(), new a());
        }
        Object obj3 = this.f18566x;
        if (obj3 instanceof G.c) {
            ((G.c) obj3).l(this.f18560r);
        }
        Object obj4 = this.f18566x;
        if (obj4 instanceof G.d) {
            ((G.d) obj4).n(this.f18561s);
        }
        Object obj5 = this.f18566x;
        if (obj5 instanceof F.q) {
            ((F.q) obj5).m(this.f18562t);
        }
        Object obj6 = this.f18566x;
        if (obj6 instanceof F.r) {
            ((F.r) obj6).p(this.f18563u);
        }
        Object obj7 = this.f18566x;
        if ((obj7 instanceof InterfaceC0681w) && abstractComponentCallbacksC2216p == null) {
            ((InterfaceC0681w) obj7).g(this.f18564v);
        }
    }

    public void m(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
        if (I0(2)) {
            Log.v("FragmentManager", "attach: " + abstractComponentCallbacksC2216p);
        }
        if (abstractComponentCallbacksC2216p.f18837C) {
            abstractComponentCallbacksC2216p.f18837C = false;
            if (abstractComponentCallbacksC2216p.f18875l) {
                return;
            }
            this.f18545c.a(abstractComponentCallbacksC2216p);
            if (I0(2)) {
                Log.v("FragmentManager", "add from attach: " + abstractComponentCallbacksC2216p);
            }
            if (J0(abstractComponentCallbacksC2216p)) {
                this.f18532J = true;
            }
        }
    }

    public final void m0() {
        Iterator it = t().iterator();
        while (it.hasNext()) {
            ((Y) it.next()).r();
        }
    }

    /* JADX INFO: renamed from: m1, reason: merged with bridge method [inline-methods] */
    public Bundle Q0() {
        C2202b[] c2202bArr;
        Bundle bundle = new Bundle();
        m0();
        X();
        a0(true);
        this.f18533K = true;
        this.f18540R.q(true);
        ArrayList arrayListY = this.f18545c.y();
        HashMap mapM = this.f18545c.m();
        if (!mapM.isEmpty()) {
            ArrayList arrayListZ = this.f18545c.z();
            int size = this.f18546d.size();
            if (size > 0) {
                c2202bArr = new C2202b[size];
                for (int i7 = 0; i7 < size; i7++) {
                    c2202bArr[i7] = new C2202b((C2201a) this.f18546d.get(i7));
                    if (I0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i7 + ": " + this.f18546d.get(i7));
                    }
                }
            } else {
                c2202bArr = null;
            }
            C2192J c2192j = new C2192J();
            c2192j.f18586a = arrayListY;
            c2192j.f18587b = arrayListZ;
            c2192j.f18588c = c2202bArr;
            c2192j.f18589d = this.f18553k.get();
            AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p = this.f18523A;
            if (abstractComponentCallbacksC2216p != null) {
                c2192j.f18590e = abstractComponentCallbacksC2216p.f18869f;
            }
            c2192j.f18591f.addAll(this.f18554l.keySet());
            c2192j.f18592g.addAll(this.f18554l.values());
            c2192j.f18593h = new ArrayList(this.f18531I);
            bundle.putParcelable("state", c2192j);
            for (String str : this.f18555m.keySet()) {
                bundle.putBundle("result_" + str, (Bundle) this.f18555m.get(str));
            }
            for (String str2 : mapM.keySet()) {
                bundle.putBundle("fragment_" + str2, (Bundle) mapM.get(str2));
            }
        } else if (I0(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
        }
        return bundle;
    }

    public AbstractC2198P n() {
        return new C2201a(this);
    }

    public Set n0(C2201a c2201a) {
        HashSet hashSet = new HashSet();
        for (int i7 = 0; i7 < c2201a.f18630c.size(); i7++) {
            AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p = ((AbstractC2198P.a) c2201a.f18630c.get(i7)).f18648b;
            if (abstractComponentCallbacksC2216p != null && c2201a.f18636i) {
                hashSet.add(abstractComponentCallbacksC2216p);
            }
        }
        return hashSet;
    }

    public void n1() {
        synchronized (this.f18543a) {
            try {
                if (this.f18543a.size() == 1) {
                    this.f18566x.w().removeCallbacks(this.f18542T);
                    this.f18566x.w().post(this.f18542T);
                    v1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void o() {
        C2201a c2201a = this.f18550h;
        if (c2201a != null) {
            c2201a.f18727u = false;
            c2201a.f();
            e0();
            Iterator it = this.f18557o.iterator();
            if (it.hasNext()) {
                android.support.v4.media.session.b.a(it.next());
                throw null;
            }
        }
    }

    public final boolean o0(ArrayList arrayList, ArrayList arrayList2) {
        synchronized (this.f18543a) {
            if (this.f18543a.isEmpty()) {
                return false;
            }
            try {
                int size = this.f18543a.size();
                boolean zA = false;
                for (int i7 = 0; i7 < size; i7++) {
                    zA |= ((l) this.f18543a.get(i7)).a(arrayList, arrayList2);
                }
                return zA;
            } finally {
                this.f18543a.clear();
                this.f18566x.w().removeCallbacks(this.f18542T);
            }
        }
    }

    public void o1(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p, boolean z7) {
        ViewGroup viewGroupS0 = s0(abstractComponentCallbacksC2216p);
        if (viewGroupS0 == null || !(viewGroupS0 instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupS0).setDrawDisappearingViewsLast(!z7);
    }

    public boolean p() {
        boolean zJ0 = false;
        for (AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p : this.f18545c.l()) {
            if (abstractComponentCallbacksC2216p != null) {
                zJ0 = J0(abstractComponentCallbacksC2216p);
            }
            if (zJ0) {
                return true;
            }
        }
        return false;
    }

    public int p0() {
        return this.f18546d.size() + (this.f18550h != null ? 1 : 0);
    }

    public void p1(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p, AbstractC0963i.b bVar) {
        if (abstractComponentCallbacksC2216p.equals(f0(abstractComponentCallbacksC2216p.f18869f)) && (abstractComponentCallbacksC2216p.f18885v == null || abstractComponentCallbacksC2216p.f18884u == this)) {
            abstractComponentCallbacksC2216p.f18854T = bVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + abstractComponentCallbacksC2216p + " is not an active fragment of FragmentManager " + this);
    }

    public final void q() {
        if (P0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public final C2193K q0(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
        return this.f18540R.k(abstractComponentCallbacksC2216p);
    }

    public void q1(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
        if (abstractComponentCallbacksC2216p == null || (abstractComponentCallbacksC2216p.equals(f0(abstractComponentCallbacksC2216p.f18869f)) && (abstractComponentCallbacksC2216p.f18885v == null || abstractComponentCallbacksC2216p.f18884u == this))) {
            AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p2 = this.f18523A;
            this.f18523A = abstractComponentCallbacksC2216p;
            L(abstractComponentCallbacksC2216p2);
            L(this.f18523A);
            return;
        }
        throw new IllegalArgumentException("Fragment " + abstractComponentCallbacksC2216p + " is not an active fragment of FragmentManager " + this);
    }

    public final void r() {
        this.f18544b = false;
        this.f18538P.clear();
        this.f18537O.clear();
    }

    public AbstractC2223w r0() {
        return this.f18567y;
    }

    public final void r1(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
        ViewGroup viewGroupS0 = s0(abstractComponentCallbacksC2216p);
        if (viewGroupS0 == null || abstractComponentCallbacksC2216p.u() + abstractComponentCallbacksC2216p.y() + abstractComponentCallbacksC2216p.J() + abstractComponentCallbacksC2216p.K() <= 0) {
            return;
        }
        if (viewGroupS0.getTag(AbstractC2153b.f18283c) == null) {
            viewGroupS0.setTag(AbstractC2153b.f18283c, abstractComponentCallbacksC2216p);
        }
        ((AbstractComponentCallbacksC2216p) viewGroupS0.getTag(AbstractC2153b.f18283c)).z1(abstractComponentCallbacksC2216p.I());
    }

    public final void s() {
        AbstractC2226z abstractC2226z = this.f18566x;
        if (abstractC2226z instanceof androidx.lifecycle.N ? this.f18545c.p().o() : abstractC2226z.t() instanceof Activity ? !((Activity) this.f18566x.t()).isChangingConfigurations() : true) {
            Iterator it = this.f18554l.values().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((C2203c) it.next()).f18744a.iterator();
                while (it2.hasNext()) {
                    this.f18545c.p().g((String) it2.next(), false);
                }
            }
        }
    }

    public final ViewGroup s0(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
        ViewGroup viewGroup = abstractComponentCallbacksC2216p.f18843I;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (abstractComponentCallbacksC2216p.f18889z > 0 && this.f18567y.r()) {
            View viewJ = this.f18567y.j(abstractComponentCallbacksC2216p.f18889z);
            if (viewJ instanceof ViewGroup) {
                return (ViewGroup) viewJ;
            }
        }
        return null;
    }

    public void s1(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
        if (I0(2)) {
            Log.v("FragmentManager", "show: " + abstractComponentCallbacksC2216p);
        }
        if (abstractComponentCallbacksC2216p.f18836B) {
            abstractComponentCallbacksC2216p.f18836B = false;
            abstractComponentCallbacksC2216p.f18850P = !abstractComponentCallbacksC2216p.f18850P;
        }
    }

    public final Set t() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f18545c.k().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((C2196N) it.next()).k().f18843I;
            if (viewGroup != null) {
                hashSet.add(Y.v(viewGroup, A0()));
            }
        }
        return hashSet;
    }

    public AbstractC2225y t0() {
        AbstractC2225y abstractC2225y = this.f18524B;
        if (abstractC2225y != null) {
            return abstractC2225y;
        }
        AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p = this.f18568z;
        return abstractComponentCallbacksC2216p != null ? abstractComponentCallbacksC2216p.f18884u.t0() : this.f18525C;
    }

    public final void t1() {
        Iterator it = this.f18545c.k().iterator();
        while (it.hasNext()) {
            Z0((C2196N) it.next());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p = this.f18568z;
        if (abstractComponentCallbacksC2216p != null) {
            sb.append(abstractComponentCallbacksC2216p.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f18568z)));
            sb.append("}");
        } else {
            AbstractC2226z abstractC2226z = this.f18566x;
            if (abstractC2226z != null) {
                sb.append(abstractC2226z.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f18566x)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public Set u(ArrayList arrayList, int i7, int i8) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i7 < i8) {
            Iterator it = ((C2201a) arrayList.get(i7)).f18630c.iterator();
            while (it.hasNext()) {
                AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p = ((AbstractC2198P.a) it.next()).f18648b;
                if (abstractComponentCallbacksC2216p != null && (viewGroup = abstractComponentCallbacksC2216p.f18843I) != null) {
                    hashSet.add(Y.u(viewGroup, this));
                }
            }
            i7++;
        }
        return hashSet;
    }

    public List u0() {
        return this.f18545c.o();
    }

    public final void u1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new V("FragmentManager"));
        AbstractC2226z abstractC2226z = this.f18566x;
        if (abstractC2226z != null) {
            try {
                abstractC2226z.x("  ", null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e7) {
                Log.e("FragmentManager", "Failed dumping state", e7);
                throw runtimeException;
            }
        }
        try {
            W("  ", null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e8) {
            Log.e("FragmentManager", "Failed dumping state", e8);
            throw runtimeException;
        }
    }

    public C2196N v(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
        C2196N c2196nN = this.f18545c.n(abstractComponentCallbacksC2216p.f18869f);
        if (c2196nN != null) {
            return c2196nN;
        }
        C2196N c2196n = new C2196N(this.f18558p, this.f18545c, abstractComponentCallbacksC2216p);
        c2196n.o(this.f18566x.t().getClassLoader());
        c2196n.s(this.f18565w);
        return c2196n;
    }

    public AbstractC2226z v0() {
        return this.f18566x;
    }

    public final void v1() {
        synchronized (this.f18543a) {
            try {
                if (!this.f18543a.isEmpty()) {
                    this.f18552j.j(true);
                    if (I0(3)) {
                        Log.d("FragmentManager", "FragmentManager " + this + " enabling OnBackPressedCallback, caused by non-empty pending actions");
                    }
                    return;
                }
                boolean z7 = p0() > 0 && N0(this.f18568z);
                if (I0(3)) {
                    Log.d("FragmentManager", "OnBackPressedCallback for FragmentManager " + this + " enabled state is " + z7);
                }
                this.f18552j.j(z7);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void w(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
        if (I0(2)) {
            Log.v("FragmentManager", "detach: " + abstractComponentCallbacksC2216p);
        }
        if (abstractComponentCallbacksC2216p.f18837C) {
            return;
        }
        abstractComponentCallbacksC2216p.f18837C = true;
        if (abstractComponentCallbacksC2216p.f18875l) {
            if (I0(2)) {
                Log.v("FragmentManager", "remove from detach: " + abstractComponentCallbacksC2216p);
            }
            this.f18545c.u(abstractComponentCallbacksC2216p);
            if (J0(abstractComponentCallbacksC2216p)) {
                this.f18532J = true;
            }
            r1(abstractComponentCallbacksC2216p);
        }
    }

    public LayoutInflater.Factory2 w0() {
        return this.f18548f;
    }

    public void x() {
        this.f18533K = false;
        this.f18534L = false;
        this.f18540R.q(false);
        S(4);
    }

    public C2184B x0() {
        return this.f18558p;
    }

    public void y() {
        this.f18533K = false;
        this.f18534L = false;
        this.f18540R.q(false);
        S(0);
    }

    public AbstractComponentCallbacksC2216p y0() {
        return this.f18568z;
    }

    public void z(Configuration configuration, boolean z7) {
        if (z7 && (this.f18566x instanceof G.c)) {
            u1(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p : this.f18545c.o()) {
            if (abstractComponentCallbacksC2216p != null) {
                abstractComponentCallbacksC2216p.S0(configuration);
                if (z7) {
                    abstractComponentCallbacksC2216p.f18886w.z(configuration, true);
                }
            }
        }
    }

    public AbstractComponentCallbacksC2216p z0() {
        return this.f18523A;
    }

    /* JADX INFO: renamed from: m0.H$k */
    public static class k implements Parcelable {
        public static final Parcelable.Creator<k> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f18579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f18580b;

        /* JADX INFO: renamed from: m0.H$k$a */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public k createFromParcel(Parcel parcel) {
                return new k(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public k[] newArray(int i7) {
                return new k[i7];
            }
        }

        public k(String str, int i7) {
            this.f18579a = str;
            this.f18580b = i7;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            parcel.writeString(this.f18579a);
            parcel.writeInt(this.f18580b);
        }

        public k(Parcel parcel) {
            this.f18579a = parcel.readString();
            this.f18580b = parcel.readInt();
        }
    }
}
