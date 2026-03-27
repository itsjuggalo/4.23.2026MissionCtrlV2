package androidx.fragment.app;

import H.InterfaceC0279m;
import Y.c;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
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
import androidx.fragment.app.Q;
import androidx.lifecycle.AbstractC0846i;
import androidx.lifecycle.InterfaceC0850m;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.common.Constants;
import e.AbstractC1221c;
import e.AbstractC1222d;
import e.C1219a;
import e.C1224f;
import e.InterfaceC1220b;
import e.InterfaceC1223e;
import f.AbstractC1238a;
import f.C1239b;
import f.C1240c;
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
import o0.d;
import x.InterfaceC1911c;

/* JADX INFO: loaded from: classes.dex */
public abstract class I {

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public static boolean f7245U = false;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public static boolean f7246V = true;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public AbstractComponentCallbacksC0828p f7247A;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public AbstractC1221c f7252F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public AbstractC1221c f7253G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public AbstractC1221c f7254H;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f7256J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public boolean f7257K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public boolean f7258L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public boolean f7259M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public boolean f7260N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public ArrayList f7261O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public ArrayList f7262P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public ArrayList f7263Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public L f7264R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public c.C0078c f7265S;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7268b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f7271e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public androidx.activity.q f7273g;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public A f7290x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public AbstractC0834w f7291y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public AbstractComponentCallbacksC0828p f7292z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f7267a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final P f7269c = new P();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f7270d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final B f7272f = new B(this);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public C0813a f7274h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f7275i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.activity.p f7276j = new b(false);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicInteger f7277k = new AtomicInteger();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map f7278l = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map f7279m = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map f7280n = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList f7281o = new ArrayList();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final C f7282p = new C(this);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final CopyOnWriteArrayList f7283q = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final G.a f7284r = new G.a() { // from class: androidx.fragment.app.D
        @Override // G.a
        public final void accept(Object obj) {
            I.e(this.f7240a, (Configuration) obj);
        }
    };

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final G.a f7285s = new G.a() { // from class: androidx.fragment.app.E
        @Override // G.a
        public final void accept(Object obj) {
            I.a(this.f7241a, (Integer) obj);
        }
    };

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final G.a f7286t = new G.a() { // from class: androidx.fragment.app.F
        @Override // G.a
        public final void accept(Object obj) {
            I.d(this.f7242a, (w.i) obj);
        }
    };

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final G.a f7287u = new G.a() { // from class: androidx.fragment.app.G
        @Override // G.a
        public final void accept(Object obj) {
            I.c(this.f7243a, (w.u) obj);
        }
    };

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final H.r f7288v = new c();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f7289w = -1;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public AbstractC0837z f7248B = null;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public AbstractC0837z f7249C = new d();

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public a0 f7250D = null;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public a0 f7251E = new e();

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public ArrayDeque f7255I = new ArrayDeque();

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public Runnable f7266T = new f();

    public class a implements InterfaceC1220b {
        public a() {
        }

        @Override // e.InterfaceC1220b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Map map) {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                iArr[i4] = ((Boolean) arrayList.get(i4)).booleanValue() ? 0 : -1;
            }
            k kVar = (k) I.this.f7255I.pollFirst();
            if (kVar == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            String str = kVar.f7303a;
            int i5 = kVar.f7304b;
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pI = I.this.f7269c.i(str);
            if (abstractComponentCallbacksC0828pI != null) {
                abstractComponentCallbacksC0828pI.onRequestPermissionsResult(i5, strArr, iArr);
                return;
            }
            Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
        }
    }

    public class b extends androidx.activity.p {
        public b(boolean z4) {
            super(z4);
        }

        @Override // androidx.activity.p
        public void handleOnBackCancelled() {
            if (I.J0(3)) {
                Log.d("FragmentManager", "handleOnBackCancelled. PREDICTIVE_BACK = " + I.f7246V + " fragment manager " + I.this);
            }
            if (I.f7246V) {
                I.this.p();
                I.this.f7274h = null;
            }
        }

        @Override // androidx.activity.p
        public void handleOnBackPressed() {
            if (I.J0(3)) {
                Log.d("FragmentManager", "handleOnBackPressed. PREDICTIVE_BACK = " + I.f7246V + " fragment manager " + I.this);
            }
            I.this.F0();
        }

        @Override // androidx.activity.p
        public void handleOnBackProgressed(androidx.activity.b bVar) {
            if (I.J0(2)) {
                Log.v("FragmentManager", "handleOnBackProgressed. PREDICTIVE_BACK = " + I.f7246V + " fragment manager " + I.this);
            }
            I i4 = I.this;
            if (i4.f7274h != null) {
                Iterator it = i4.v(new ArrayList(Collections.singletonList(I.this.f7274h)), 0, 1).iterator();
                while (it.hasNext()) {
                    ((Z) it.next()).y(bVar);
                }
                Iterator it2 = I.this.f7281o.iterator();
                if (it2.hasNext()) {
                    android.support.v4.media.session.b.a(it2.next());
                    throw null;
                }
            }
        }

        @Override // androidx.activity.p
        public void handleOnBackStarted(androidx.activity.b bVar) {
            if (I.J0(3)) {
                Log.d("FragmentManager", "handleOnBackStarted. PREDICTIVE_BACK = " + I.f7246V + " fragment manager " + I.this);
            }
            if (I.f7246V) {
                I.this.Y();
                I.this.e1();
            }
        }
    }

    public class c implements H.r {
        public c() {
        }

        @Override // H.r
        public boolean a(MenuItem menuItem) {
            return I.this.K(menuItem);
        }

        @Override // H.r
        public void b(Menu menu) {
            I.this.L(menu);
        }

        @Override // H.r
        public void c(Menu menu, MenuInflater menuInflater) {
            I.this.D(menu, menuInflater);
        }

        @Override // H.r
        public void d(Menu menu) {
            I.this.P(menu);
        }
    }

    public class d extends AbstractC0837z {
        public d() {
        }

        @Override // androidx.fragment.app.AbstractC0837z
        public AbstractComponentCallbacksC0828p a(ClassLoader classLoader, String str) {
            return I.this.w0().b(I.this.w0().f(), str, null);
        }
    }

    public class e implements a0 {
        public e() {
        }

        @Override // androidx.fragment.app.a0
        public Z a(ViewGroup viewGroup) {
            return new C0818f(viewGroup);
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            I.this.b0(true);
        }
    }

    public class g implements M {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractComponentCallbacksC0828p f7299a;

        public g(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
            this.f7299a = abstractComponentCallbacksC0828p;
        }

        @Override // androidx.fragment.app.M
        public void a(I i4, AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
            this.f7299a.onAttachFragment(abstractComponentCallbacksC0828p);
        }
    }

    public class h implements InterfaceC1220b {
        public h() {
        }

        @Override // e.InterfaceC1220b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C1219a c1219a) {
            k kVar = (k) I.this.f7255I.pollLast();
            if (kVar == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = kVar.f7303a;
            int i4 = kVar.f7304b;
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pI = I.this.f7269c.i(str);
            if (abstractComponentCallbacksC0828pI != null) {
                abstractComponentCallbacksC0828pI.onActivityResult(i4, c1219a.b(), c1219a.a());
                return;
            }
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }
    }

    public class i implements InterfaceC1220b {
        public i() {
        }

        @Override // e.InterfaceC1220b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C1219a c1219a) {
            k kVar = (k) I.this.f7255I.pollFirst();
            if (kVar == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = kVar.f7303a;
            int i4 = kVar.f7304b;
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pI = I.this.f7269c.i(str);
            if (abstractComponentCallbacksC0828pI != null) {
                abstractComponentCallbacksC0828pI.onActivityResult(i4, c1219a.b(), c1219a.a());
                return;
            }
            Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
        }
    }

    public static class j extends AbstractC1238a {
        @Override // f.AbstractC1238a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(Context context, C1224f c1224f) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent intentA = c1224f.a();
            if (intentA != null && (bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (intentA.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    c1224f = new C1224f.a(c1224f.d()).b(null).c(c1224f.c(), c1224f.b()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", c1224f);
            if (I.J0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // f.AbstractC1238a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public C1219a c(int i4, Intent intent) {
            return new C1219a(i4, intent);
        }
    }

    public interface l {
        boolean a(ArrayList arrayList, ArrayList arrayList2);
    }

    public class m implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7306b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f7307c;

        public m(String str, int i4, int i5) {
            this.f7305a = str;
            this.f7306b = i4;
            this.f7307c = i5;
        }

        @Override // androidx.fragment.app.I.l
        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = I.this.f7247A;
            if (abstractComponentCallbacksC0828p == null || this.f7306b >= 0 || this.f7305a != null || !abstractComponentCallbacksC0828p.getChildFragmentManager().Z0()) {
                return I.this.c1(arrayList, arrayList2, this.f7305a, this.f7306b, this.f7307c);
            }
            return false;
        }
    }

    public class n implements l {
        public n() {
        }

        @Override // androidx.fragment.app.I.l
        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            boolean zD1 = I.this.d1(arrayList, arrayList2);
            I i4 = I.this;
            i4.f7275i = true;
            if (!i4.f7281o.isEmpty() && arrayList.size() > 0) {
                ((Boolean) arrayList2.get(arrayList.size() - 1)).booleanValue();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    linkedHashSet.addAll(I.this.o0((C0813a) it.next()));
                }
                Iterator it2 = I.this.f7281o.iterator();
                while (it2.hasNext()) {
                    android.support.v4.media.session.b.a(it2.next());
                    Iterator it3 = linkedHashSet.iterator();
                    if (it3.hasNext()) {
                        throw null;
                    }
                }
            }
            return zD1;
        }
    }

    public static AbstractComponentCallbacksC0828p D0(View view) {
        Object tag = view.getTag(X.b.f5519a);
        if (tag instanceof AbstractComponentCallbacksC0828p) {
            return (AbstractComponentCallbacksC0828p) tag;
        }
        return null;
    }

    public static boolean J0(int i4) {
        return f7245U || Log.isLoggable("FragmentManager", i4);
    }

    public static /* synthetic */ void a(I i4, Integer num) {
        if (i4.L0() && num.intValue() == 80) {
            i4.G(false);
        }
    }

    public static /* synthetic */ void c(I i4, w.u uVar) {
        if (i4.L0()) {
            i4.O(uVar.a(), false);
        }
    }

    public static /* synthetic */ void d(I i4, w.i iVar) {
        if (i4.L0()) {
            i4.H(iVar.a(), false);
        }
    }

    public static void d0(ArrayList arrayList, ArrayList arrayList2, int i4, int i5) {
        while (i4 < i5) {
            C0813a c0813a = (C0813a) arrayList.get(i4);
            if (((Boolean) arrayList2.get(i4)).booleanValue()) {
                c0813a.n(-1);
                c0813a.s();
            } else {
                c0813a.n(1);
                c0813a.r();
            }
            i4++;
        }
    }

    public static /* synthetic */ void e(I i4, Configuration configuration) {
        if (i4.L0()) {
            i4.A(configuration, false);
        }
    }

    public static int k1(int i4) {
        if (i4 == 4097) {
            return 8194;
        }
        if (i4 == 8194) {
            return 4097;
        }
        if (i4 == 8197) {
            return 4100;
        }
        if (i4 != 4099) {
            return i4 != 4100 ? 0 : 8197;
        }
        return 4099;
    }

    public static I l0(View view) {
        AbstractActivityC0832u abstractActivityC0832u;
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pM0 = m0(view);
        if (abstractComponentCallbacksC0828pM0 != null) {
            if (abstractComponentCallbacksC0828pM0.isAdded()) {
                return abstractComponentCallbacksC0828pM0.getChildFragmentManager();
            }
            throw new IllegalStateException("The Fragment " + abstractComponentCallbacksC0828pM0 + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        Context context = view.getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                abstractActivityC0832u = null;
                break;
            }
            if (context instanceof AbstractActivityC0832u) {
                abstractActivityC0832u = (AbstractActivityC0832u) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (abstractActivityC0832u != null) {
            return abstractActivityC0832u.getSupportFragmentManager();
        }
        throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
    }

    public static AbstractComponentCallbacksC0828p m0(View view) {
        while (view != null) {
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pD0 = D0(view);
            if (abstractComponentCallbacksC0828pD0 != null) {
                return abstractComponentCallbacksC0828pD0;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    public void A(Configuration configuration, boolean z4) {
        if (z4 && (this.f7290x instanceof InterfaceC1911c)) {
            t1(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p : this.f7269c.o()) {
            if (abstractComponentCallbacksC0828p != null) {
                abstractComponentCallbacksC0828p.performConfigurationChanged(configuration);
                if (z4) {
                    abstractComponentCallbacksC0828p.mChildFragmentManager.A(configuration, true);
                }
            }
        }
    }

    public AbstractComponentCallbacksC0828p A0() {
        return this.f7247A;
    }

    public boolean B(MenuItem menuItem) {
        if (this.f7289w < 1) {
            return false;
        }
        for (AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p : this.f7269c.o()) {
            if (abstractComponentCallbacksC0828p != null && abstractComponentCallbacksC0828p.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public a0 B0() {
        a0 a0Var = this.f7250D;
        if (a0Var != null) {
            return a0Var;
        }
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = this.f7292z;
        return abstractComponentCallbacksC0828p != null ? abstractComponentCallbacksC0828p.mFragmentManager.B0() : this.f7251E;
    }

    public void C() {
        this.f7257K = false;
        this.f7258L = false;
        this.f7264R.q(false);
        T(1);
    }

    public c.C0078c C0() {
        return this.f7265S;
    }

    public boolean D(Menu menu, MenuInflater menuInflater) {
        if (this.f7289w < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z4 = false;
        for (AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p : this.f7269c.o()) {
            if (abstractComponentCallbacksC0828p != null && N0(abstractComponentCallbacksC0828p) && abstractComponentCallbacksC0828p.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(abstractComponentCallbacksC0828p);
                z4 = true;
            }
        }
        if (this.f7271e != null) {
            for (int i4 = 0; i4 < this.f7271e.size(); i4++) {
                AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p2 = (AbstractComponentCallbacksC0828p) this.f7271e.get(i4);
                if (arrayList == null || !arrayList.contains(abstractComponentCallbacksC0828p2)) {
                    abstractComponentCallbacksC0828p2.onDestroyOptionsMenu();
                }
            }
        }
        this.f7271e = arrayList;
        return z4;
    }

    public void E() {
        this.f7259M = true;
        b0(true);
        Y();
        t();
        T(-1);
        Object obj = this.f7290x;
        if (obj instanceof x.d) {
            ((x.d) obj).removeOnTrimMemoryListener(this.f7285s);
        }
        Object obj2 = this.f7290x;
        if (obj2 instanceof InterfaceC1911c) {
            ((InterfaceC1911c) obj2).removeOnConfigurationChangedListener(this.f7284r);
        }
        Object obj3 = this.f7290x;
        if (obj3 instanceof w.q) {
            ((w.q) obj3).removeOnMultiWindowModeChangedListener(this.f7286t);
        }
        Object obj4 = this.f7290x;
        if (obj4 instanceof w.r) {
            ((w.r) obj4).removeOnPictureInPictureModeChangedListener(this.f7287u);
        }
        Object obj5 = this.f7290x;
        if ((obj5 instanceof InterfaceC0279m) && this.f7292z == null) {
            ((InterfaceC0279m) obj5).removeMenuProvider(this.f7288v);
        }
        this.f7290x = null;
        this.f7291y = null;
        this.f7292z = null;
        if (this.f7273g != null) {
            this.f7276j.remove();
            this.f7273g = null;
        }
        AbstractC1221c abstractC1221c = this.f7252F;
        if (abstractC1221c != null) {
            abstractC1221c.c();
            this.f7253G.c();
            this.f7254H.c();
        }
    }

    public androidx.lifecycle.M E0(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        return this.f7264R.n(abstractComponentCallbacksC0828p);
    }

    public void F() {
        T(1);
    }

    public void F0() {
        b0(true);
        if (!f7246V || this.f7274h == null) {
            if (this.f7276j.isEnabled()) {
                if (J0(3)) {
                    Log.d("FragmentManager", "Calling popBackStackImmediate via onBackPressed callback");
                }
                Z0();
                return;
            } else {
                if (J0(3)) {
                    Log.d("FragmentManager", "Calling onBackPressed via onBackPressed callback");
                }
                this.f7273g.k();
                return;
            }
        }
        if (!this.f7281o.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(o0(this.f7274h));
            Iterator it = this.f7281o.iterator();
            while (it.hasNext()) {
                android.support.v4.media.session.b.a(it.next());
                Iterator it2 = linkedHashSet.iterator();
                if (it2.hasNext()) {
                    throw null;
                }
            }
        }
        Iterator it3 = this.f7274h.f7354c.iterator();
        while (it3.hasNext()) {
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = ((Q.a) it3.next()).f7372b;
            if (abstractComponentCallbacksC0828p != null) {
                abstractComponentCallbacksC0828p.mTransitioning = false;
            }
        }
        Iterator it4 = v(new ArrayList(Collections.singletonList(this.f7274h)), 0, 1).iterator();
        while (it4.hasNext()) {
            ((Z) it4.next()).f();
        }
        this.f7274h = null;
        u1();
        if (J0(3)) {
            Log.d("FragmentManager", "Op is being set to null");
            Log.d("FragmentManager", "OnBackPressedCallback enabled=" + this.f7276j.isEnabled() + " for  FragmentManager " + this);
        }
    }

    public void G(boolean z4) {
        if (z4 && (this.f7290x instanceof x.d)) {
            t1(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p : this.f7269c.o()) {
            if (abstractComponentCallbacksC0828p != null) {
                abstractComponentCallbacksC0828p.performLowMemory();
                if (z4) {
                    abstractComponentCallbacksC0828p.mChildFragmentManager.G(true);
                }
            }
        }
    }

    public void G0(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        if (J0(2)) {
            Log.v("FragmentManager", "hide: " + abstractComponentCallbacksC0828p);
        }
        if (abstractComponentCallbacksC0828p.mHidden) {
            return;
        }
        abstractComponentCallbacksC0828p.mHidden = true;
        abstractComponentCallbacksC0828p.mHiddenChanged = true ^ abstractComponentCallbacksC0828p.mHiddenChanged;
        q1(abstractComponentCallbacksC0828p);
    }

    public void H(boolean z4, boolean z5) {
        if (z5 && (this.f7290x instanceof w.q)) {
            t1(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p : this.f7269c.o()) {
            if (abstractComponentCallbacksC0828p != null) {
                abstractComponentCallbacksC0828p.performMultiWindowModeChanged(z4);
                if (z5) {
                    abstractComponentCallbacksC0828p.mChildFragmentManager.H(z4, true);
                }
            }
        }
    }

    public void H0(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        if (abstractComponentCallbacksC0828p.mAdded && K0(abstractComponentCallbacksC0828p)) {
            this.f7256J = true;
        }
    }

    public void I(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        Iterator it = this.f7283q.iterator();
        while (it.hasNext()) {
            ((M) it.next()).a(this, abstractComponentCallbacksC0828p);
        }
    }

    public boolean I0() {
        return this.f7259M;
    }

    public void J() {
        for (AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p : this.f7269c.l()) {
            if (abstractComponentCallbacksC0828p != null) {
                abstractComponentCallbacksC0828p.onHiddenChanged(abstractComponentCallbacksC0828p.isHidden());
                abstractComponentCallbacksC0828p.mChildFragmentManager.J();
            }
        }
    }

    public boolean K(MenuItem menuItem) {
        if (this.f7289w < 1) {
            return false;
        }
        for (AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p : this.f7269c.o()) {
            if (abstractComponentCallbacksC0828p != null && abstractComponentCallbacksC0828p.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final boolean K0(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        return (abstractComponentCallbacksC0828p.mHasMenu && abstractComponentCallbacksC0828p.mMenuVisible) || abstractComponentCallbacksC0828p.mChildFragmentManager.q();
    }

    public void L(Menu menu) {
        if (this.f7289w < 1) {
            return;
        }
        for (AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p : this.f7269c.o()) {
            if (abstractComponentCallbacksC0828p != null) {
                abstractComponentCallbacksC0828p.performOptionsMenuClosed(menu);
            }
        }
    }

    public final boolean L0() {
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = this.f7292z;
        if (abstractComponentCallbacksC0828p == null) {
            return true;
        }
        return abstractComponentCallbacksC0828p.isAdded() && this.f7292z.getParentFragmentManager().L0();
    }

    public final void M(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        if (abstractComponentCallbacksC0828p == null || !abstractComponentCallbacksC0828p.equals(g0(abstractComponentCallbacksC0828p.mWho))) {
            return;
        }
        abstractComponentCallbacksC0828p.performPrimaryNavigationFragmentChanged();
    }

    public boolean M0(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        if (abstractComponentCallbacksC0828p == null) {
            return false;
        }
        return abstractComponentCallbacksC0828p.isHidden();
    }

    public void N() {
        T(5);
    }

    public boolean N0(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        if (abstractComponentCallbacksC0828p == null) {
            return true;
        }
        return abstractComponentCallbacksC0828p.isMenuVisible();
    }

    public void O(boolean z4, boolean z5) {
        if (z5 && (this.f7290x instanceof w.r)) {
            t1(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p : this.f7269c.o()) {
            if (abstractComponentCallbacksC0828p != null) {
                abstractComponentCallbacksC0828p.performPictureInPictureModeChanged(z4);
                if (z5) {
                    abstractComponentCallbacksC0828p.mChildFragmentManager.O(z4, true);
                }
            }
        }
    }

    public boolean O0(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        if (abstractComponentCallbacksC0828p == null) {
            return true;
        }
        I i4 = abstractComponentCallbacksC0828p.mFragmentManager;
        return abstractComponentCallbacksC0828p.equals(i4.A0()) && O0(i4.f7292z);
    }

    public boolean P(Menu menu) {
        boolean z4 = false;
        if (this.f7289w < 1) {
            return false;
        }
        for (AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p : this.f7269c.o()) {
            if (abstractComponentCallbacksC0828p != null && N0(abstractComponentCallbacksC0828p) && abstractComponentCallbacksC0828p.performPrepareOptionsMenu(menu)) {
                z4 = true;
            }
        }
        return z4;
    }

    public boolean P0(int i4) {
        return this.f7289w >= i4;
    }

    public void Q() {
        u1();
        M(this.f7247A);
    }

    public boolean Q0() {
        return this.f7257K || this.f7258L;
    }

    public void R() {
        this.f7257K = false;
        this.f7258L = false;
        this.f7264R.q(false);
        T(7);
    }

    public void R0(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p, String[] strArr, int i4) {
        if (this.f7254H == null) {
            this.f7290x.l(abstractComponentCallbacksC0828p, strArr, i4);
            return;
        }
        this.f7255I.addLast(new k(abstractComponentCallbacksC0828p.mWho, i4));
        this.f7254H.a(strArr);
    }

    public void S() {
        this.f7257K = false;
        this.f7258L = false;
        this.f7264R.q(false);
        T(5);
    }

    public void S0(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p, Intent intent, int i4, Bundle bundle) {
        if (this.f7252F == null) {
            this.f7290x.n(abstractComponentCallbacksC0828p, intent, i4, bundle);
            return;
        }
        this.f7255I.addLast(new k(abstractComponentCallbacksC0828p.mWho, i4));
        if (bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        this.f7252F.a(intent);
    }

    public final void T(int i4) {
        try {
            this.f7268b = true;
            this.f7269c.d(i4);
            U0(i4, false);
            Iterator it = u().iterator();
            while (it.hasNext()) {
                ((Z) it.next()).q();
            }
            this.f7268b = false;
            b0(true);
        } catch (Throwable th) {
            this.f7268b = false;
            throw th;
        }
    }

    public void T0(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p, IntentSender intentSender, int i4, Intent intent, int i5, int i6, int i7, Bundle bundle) {
        if (this.f7253G == null) {
            this.f7290x.o(abstractComponentCallbacksC0828p, intentSender, i4, intent, i5, i6, i7, bundle);
            return;
        }
        if (bundle != null) {
            if (intent == null) {
                intent = new Intent();
                intent.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            }
            if (J0(2)) {
                Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent + " for fragment " + abstractComponentCallbacksC0828p);
            }
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        C1224f c1224fA = new C1224f.a(intentSender).b(intent).c(i6, i5).a();
        this.f7255I.addLast(new k(abstractComponentCallbacksC0828p.mWho, i4));
        if (J0(2)) {
            Log.v("FragmentManager", "Fragment " + abstractComponentCallbacksC0828p + "is launching an IntentSender for result ");
        }
        this.f7253G.a(c1224fA);
    }

    public void U() {
        this.f7258L = true;
        this.f7264R.q(true);
        T(4);
    }

    public void U0(int i4, boolean z4) {
        A a4;
        if (this.f7290x == null && i4 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z4 || i4 != this.f7289w) {
            this.f7289w = i4;
            this.f7269c.t();
            s1();
            if (this.f7256J && (a4 = this.f7290x) != null && this.f7289w == 7) {
                a4.p();
                this.f7256J = false;
            }
        }
    }

    public void V() {
        T(2);
    }

    public void V0() {
        if (this.f7290x == null) {
            return;
        }
        this.f7257K = false;
        this.f7258L = false;
        this.f7264R.q(false);
        for (AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p : this.f7269c.o()) {
            if (abstractComponentCallbacksC0828p != null) {
                abstractComponentCallbacksC0828p.noteStateNotSaved();
            }
        }
    }

    public final void W() {
        if (this.f7260N) {
            this.f7260N = false;
            s1();
        }
    }

    public void W0(C0835x c0835x) {
        View view;
        for (O o4 : this.f7269c.k()) {
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pK = o4.k();
            if (abstractComponentCallbacksC0828pK.mContainerId == c0835x.getId() && (view = abstractComponentCallbacksC0828pK.mView) != null && view.getParent() == null) {
                abstractComponentCallbacksC0828pK.mContainer = c0835x;
                o4.b();
            }
        }
    }

    public void X(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        String str2 = str + "    ";
        this.f7269c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList arrayList = this.f7271e;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i4 = 0; i4 < size; i4++) {
                AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = (AbstractComponentCallbacksC0828p) this.f7271e.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(abstractComponentCallbacksC0828p.toString());
            }
        }
        int size2 = this.f7270d.size();
        if (size2 > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i5 = 0; i5 < size2; i5++) {
                C0813a c0813a = (C0813a) this.f7270d.get(i5);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(c0813a.toString());
                c0813a.p(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f7277k.get());
        synchronized (this.f7267a) {
            try {
                int size3 = this.f7267a.size();
                if (size3 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i6 = 0; i6 < size3; i6++) {
                        l lVar = (l) this.f7267a.get(i6);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i6);
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
        printWriter.println(this.f7290x);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f7291y);
        if (this.f7292z != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f7292z);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f7289w);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f7257K);
        printWriter.print(" mStopped=");
        printWriter.print(this.f7258L);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f7259M);
        if (this.f7256J) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f7256J);
        }
    }

    public void X0(O o4) {
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pK = o4.k();
        if (abstractComponentCallbacksC0828pK.mDeferStart) {
            if (this.f7268b) {
                this.f7260N = true;
            } else {
                abstractComponentCallbacksC0828pK.mDeferStart = false;
                o4.m();
            }
        }
    }

    public final void Y() {
        Iterator it = u().iterator();
        while (it.hasNext()) {
            ((Z) it.next()).q();
        }
    }

    public void Y0(int i4, int i5, boolean z4) {
        if (i4 >= 0) {
            Z(new m(null, i4, i5), z4);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i4);
    }

    public void Z(l lVar, boolean z4) {
        if (!z4) {
            if (this.f7290x == null) {
                if (!this.f7259M) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            r();
        }
        synchronized (this.f7267a) {
            try {
                if (this.f7290x == null) {
                    if (!z4) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f7267a.add(lVar);
                    m1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean Z0() {
        return b1(null, -1, 0);
    }

    public final void a0(boolean z4) {
        if (this.f7268b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f7290x == null) {
            if (!this.f7259M) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f7290x.h().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z4) {
            r();
        }
        if (this.f7261O == null) {
            this.f7261O = new ArrayList();
            this.f7262P = new ArrayList();
        }
    }

    public boolean a1(int i4, int i5) {
        if (i4 >= 0) {
            return b1(null, i4, i5);
        }
        throw new IllegalArgumentException("Bad id: " + i4);
    }

    public boolean b0(boolean z4) {
        a0(z4);
        boolean z5 = false;
        while (p0(this.f7261O, this.f7262P)) {
            z5 = true;
            this.f7268b = true;
            try {
                g1(this.f7261O, this.f7262P);
            } finally {
                s();
            }
        }
        u1();
        W();
        this.f7269c.b();
        return z5;
    }

    public final boolean b1(String str, int i4, int i5) {
        b0(false);
        a0(true);
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = this.f7247A;
        if (abstractComponentCallbacksC0828p != null && i4 < 0 && str == null && abstractComponentCallbacksC0828p.getChildFragmentManager().Z0()) {
            return true;
        }
        boolean zC1 = c1(this.f7261O, this.f7262P, str, i4, i5);
        if (zC1) {
            this.f7268b = true;
            try {
                g1(this.f7261O, this.f7262P);
            } finally {
                s();
            }
        }
        u1();
        W();
        this.f7269c.b();
        return zC1;
    }

    public void c0(l lVar, boolean z4) {
        if (z4 && (this.f7290x == null || this.f7259M)) {
            return;
        }
        a0(z4);
        if (lVar.a(this.f7261O, this.f7262P)) {
            this.f7268b = true;
            try {
                g1(this.f7261O, this.f7262P);
            } finally {
                s();
            }
        }
        u1();
        W();
        this.f7269c.b();
    }

    public boolean c1(ArrayList arrayList, ArrayList arrayList2, String str, int i4, int i5) {
        int iH0 = h0(str, i4, (i5 & 1) != 0);
        if (iH0 < 0) {
            return false;
        }
        for (int size = this.f7270d.size() - 1; size >= iH0; size--) {
            arrayList.add((C0813a) this.f7270d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public boolean d1(ArrayList arrayList, ArrayList arrayList2) {
        ArrayList arrayList3 = this.f7270d;
        C0813a c0813a = (C0813a) arrayList3.get(arrayList3.size() - 1);
        this.f7274h = c0813a;
        Iterator it = c0813a.f7354c.iterator();
        while (it.hasNext()) {
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = ((Q.a) it.next()).f7372b;
            if (abstractComponentCallbacksC0828p != null) {
                abstractComponentCallbacksC0828p.mTransitioning = true;
            }
        }
        return c1(arrayList, arrayList2, null, -1, 0);
    }

    public final void e0(ArrayList arrayList, ArrayList arrayList2, int i4, int i5) {
        boolean z4 = ((C0813a) arrayList.get(i4)).f7369r;
        ArrayList arrayList3 = this.f7263Q;
        if (arrayList3 == null) {
            this.f7263Q = new ArrayList();
        } else {
            arrayList3.clear();
        }
        this.f7263Q.addAll(this.f7269c.o());
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pA0 = A0();
        boolean z5 = false;
        for (int i6 = i4; i6 < i5; i6++) {
            C0813a c0813a = (C0813a) arrayList.get(i6);
            abstractComponentCallbacksC0828pA0 = !((Boolean) arrayList2.get(i6)).booleanValue() ? c0813a.t(this.f7263Q, abstractComponentCallbacksC0828pA0) : c0813a.w(this.f7263Q, abstractComponentCallbacksC0828pA0);
            z5 = z5 || c0813a.f7360i;
        }
        this.f7263Q.clear();
        if (!z4 && this.f7289w >= 1) {
            for (int i7 = i4; i7 < i5; i7++) {
                Iterator it = ((C0813a) arrayList.get(i7)).f7354c.iterator();
                while (it.hasNext()) {
                    AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = ((Q.a) it.next()).f7372b;
                    if (abstractComponentCallbacksC0828p != null && abstractComponentCallbacksC0828p.mFragmentManager != null) {
                        this.f7269c.r(w(abstractComponentCallbacksC0828p));
                    }
                }
            }
        }
        d0(arrayList, arrayList2, i4, i5);
        boolean zBooleanValue = ((Boolean) arrayList2.get(i5 - 1)).booleanValue();
        if (z5 && !this.f7281o.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                linkedHashSet.addAll(o0((C0813a) it2.next()));
            }
            if (this.f7274h == null) {
                Iterator it3 = this.f7281o.iterator();
                while (it3.hasNext()) {
                    android.support.v4.media.session.b.a(it3.next());
                    Iterator it4 = linkedHashSet.iterator();
                    if (it4.hasNext()) {
                        throw null;
                    }
                }
                Iterator it5 = this.f7281o.iterator();
                while (it5.hasNext()) {
                    android.support.v4.media.session.b.a(it5.next());
                    Iterator it6 = linkedHashSet.iterator();
                    if (it6.hasNext()) {
                        throw null;
                    }
                }
            }
        }
        for (int i8 = i4; i8 < i5; i8++) {
            C0813a c0813a2 = (C0813a) arrayList.get(i8);
            if (zBooleanValue) {
                for (int size = c0813a2.f7354c.size() - 1; size >= 0; size--) {
                    AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p2 = ((Q.a) c0813a2.f7354c.get(size)).f7372b;
                    if (abstractComponentCallbacksC0828p2 != null) {
                        w(abstractComponentCallbacksC0828p2).m();
                    }
                }
            } else {
                Iterator it7 = c0813a2.f7354c.iterator();
                while (it7.hasNext()) {
                    AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p3 = ((Q.a) it7.next()).f7372b;
                    if (abstractComponentCallbacksC0828p3 != null) {
                        w(abstractComponentCallbacksC0828p3).m();
                    }
                }
            }
        }
        U0(this.f7289w, true);
        for (Z z6 : v(arrayList, i4, i5)) {
            z6.B(zBooleanValue);
            z6.x();
            z6.n();
        }
        while (i4 < i5) {
            C0813a c0813a3 = (C0813a) arrayList.get(i4);
            if (((Boolean) arrayList2.get(i4)).booleanValue() && c0813a3.f7452v >= 0) {
                c0813a3.f7452v = -1;
            }
            c0813a3.v();
            i4++;
        }
        if (z5) {
            i1();
        }
    }

    public void e1() {
        Z(new n(), false);
    }

    public boolean f0() {
        boolean zB0 = b0(true);
        n0();
        return zB0;
    }

    public void f1(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        if (J0(2)) {
            Log.v("FragmentManager", "remove: " + abstractComponentCallbacksC0828p + " nesting=" + abstractComponentCallbacksC0828p.mBackStackNesting);
        }
        boolean zIsInBackStack = abstractComponentCallbacksC0828p.isInBackStack();
        if (abstractComponentCallbacksC0828p.mDetached && zIsInBackStack) {
            return;
        }
        this.f7269c.u(abstractComponentCallbacksC0828p);
        if (K0(abstractComponentCallbacksC0828p)) {
            this.f7256J = true;
        }
        abstractComponentCallbacksC0828p.mRemoving = true;
        q1(abstractComponentCallbacksC0828p);
    }

    public AbstractComponentCallbacksC0828p g0(String str) {
        return this.f7269c.f(str);
    }

    public final void g1(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i4 = 0;
        int i5 = 0;
        while (i4 < size) {
            if (!((C0813a) arrayList.get(i4)).f7369r) {
                if (i5 != i4) {
                    e0(arrayList, arrayList2, i5, i4);
                }
                i5 = i4 + 1;
                if (((Boolean) arrayList2.get(i4)).booleanValue()) {
                    while (i5 < size && ((Boolean) arrayList2.get(i5)).booleanValue() && !((C0813a) arrayList.get(i5)).f7369r) {
                        i5++;
                    }
                }
                e0(arrayList, arrayList2, i4, i5);
                i4 = i5 - 1;
            }
            i4++;
        }
        if (i5 != size) {
            e0(arrayList, arrayList2, i5, size);
        }
    }

    public void h(C0813a c0813a) {
        this.f7270d.add(c0813a);
    }

    public final int h0(String str, int i4, boolean z4) {
        if (this.f7270d.isEmpty()) {
            return -1;
        }
        if (str == null && i4 < 0) {
            if (z4) {
                return 0;
            }
            return this.f7270d.size() - 1;
        }
        int size = this.f7270d.size() - 1;
        while (size >= 0) {
            C0813a c0813a = (C0813a) this.f7270d.get(size);
            if ((str != null && str.equals(c0813a.u())) || (i4 >= 0 && i4 == c0813a.f7452v)) {
                break;
            }
            size--;
        }
        if (size < 0) {
            return size;
        }
        if (!z4) {
            if (size == this.f7270d.size() - 1) {
                return -1;
            }
            return size + 1;
        }
        while (size > 0) {
            C0813a c0813a2 = (C0813a) this.f7270d.get(size - 1);
            if ((str == null || !str.equals(c0813a2.u())) && (i4 < 0 || i4 != c0813a2.f7452v)) {
                break;
            }
            size--;
        }
        return size;
    }

    public void h1(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        this.f7264R.p(abstractComponentCallbacksC0828p);
    }

    public O i(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        String str = abstractComponentCallbacksC0828p.mPreviousWho;
        if (str != null) {
            Y.c.f(abstractComponentCallbacksC0828p, str);
        }
        if (J0(2)) {
            Log.v("FragmentManager", "add: " + abstractComponentCallbacksC0828p);
        }
        O oW = w(abstractComponentCallbacksC0828p);
        abstractComponentCallbacksC0828p.mFragmentManager = this;
        this.f7269c.r(oW);
        if (!abstractComponentCallbacksC0828p.mDetached) {
            this.f7269c.a(abstractComponentCallbacksC0828p);
            abstractComponentCallbacksC0828p.mRemoving = false;
            if (abstractComponentCallbacksC0828p.mView == null) {
                abstractComponentCallbacksC0828p.mHiddenChanged = false;
            }
            if (K0(abstractComponentCallbacksC0828p)) {
                this.f7256J = true;
            }
        }
        return oW;
    }

    public AbstractComponentCallbacksC0828p i0(int i4) {
        return this.f7269c.g(i4);
    }

    public final void i1() {
        if (this.f7281o.size() <= 0) {
            return;
        }
        android.support.v4.media.session.b.a(this.f7281o.get(0));
        throw null;
    }

    public void j(M m4) {
        this.f7283q.add(m4);
    }

    public AbstractComponentCallbacksC0828p j0(String str) {
        return this.f7269c.h(str);
    }

    public void j1(Parcelable parcelable) {
        O o4;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable == null) {
            return;
        }
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.f7290x.f().getClassLoader());
                this.f7279m.put(str.substring(7), bundle2);
            }
        }
        HashMap map = new HashMap();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.f7290x.f().getClassLoader());
                map.put(str2.substring(9), bundle);
            }
        }
        this.f7269c.x(map);
        K k4 = (K) bundle3.getParcelable("state");
        if (k4 == null) {
            return;
        }
        this.f7269c.v();
        Iterator it = k4.f7310a.iterator();
        while (it.hasNext()) {
            Bundle bundleB = this.f7269c.B((String) it.next(), null);
            if (bundleB != null) {
                AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pJ = this.f7264R.j(((N) bundleB.getParcelable("state")).f7327b);
                if (abstractComponentCallbacksC0828pJ != null) {
                    if (J0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + abstractComponentCallbacksC0828pJ);
                    }
                    o4 = new O(this.f7282p, this.f7269c, abstractComponentCallbacksC0828pJ, bundleB);
                } else {
                    o4 = new O(this.f7282p, this.f7269c, this.f7290x.f().getClassLoader(), u0(), bundleB);
                }
                AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pK = o4.k();
                abstractComponentCallbacksC0828pK.mSavedFragmentState = bundleB;
                abstractComponentCallbacksC0828pK.mFragmentManager = this;
                if (J0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + abstractComponentCallbacksC0828pK.mWho + "): " + abstractComponentCallbacksC0828pK);
                }
                o4.o(this.f7290x.f().getClassLoader());
                this.f7269c.r(o4);
                o4.s(this.f7289w);
            }
        }
        for (AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p : this.f7264R.m()) {
            if (!this.f7269c.c(abstractComponentCallbacksC0828p.mWho)) {
                if (J0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + abstractComponentCallbacksC0828p + " that was not found in the set of active Fragments " + k4.f7310a);
                }
                this.f7264R.p(abstractComponentCallbacksC0828p);
                abstractComponentCallbacksC0828p.mFragmentManager = this;
                O o5 = new O(this.f7282p, this.f7269c, abstractComponentCallbacksC0828p);
                o5.s(1);
                o5.m();
                abstractComponentCallbacksC0828p.mRemoving = true;
                o5.m();
            }
        }
        this.f7269c.w(k4.f7311b);
        if (k4.f7312c != null) {
            this.f7270d = new ArrayList(k4.f7312c.length);
            int i4 = 0;
            while (true) {
                C0814b[] c0814bArr = k4.f7312c;
                if (i4 >= c0814bArr.length) {
                    break;
                }
                C0813a c0813aB = c0814bArr[i4].b(this);
                if (J0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i4 + " (index " + c0813aB.f7452v + "): " + c0813aB);
                    PrintWriter printWriter = new PrintWriter(new W("FragmentManager"));
                    c0813aB.q("  ", printWriter, false);
                    printWriter.close();
                }
                this.f7270d.add(c0813aB);
                i4++;
            }
        } else {
            this.f7270d = new ArrayList();
        }
        this.f7277k.set(k4.f7313d);
        String str3 = k4.f7314e;
        if (str3 != null) {
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pG0 = g0(str3);
            this.f7247A = abstractComponentCallbacksC0828pG0;
            M(abstractComponentCallbacksC0828pG0);
        }
        ArrayList arrayList = k4.f7315f;
        if (arrayList != null) {
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                this.f7278l.put((String) arrayList.get(i5), (C0815c) k4.f7316g.get(i5));
            }
        }
        this.f7255I = new ArrayDeque(k4.f7317h);
    }

    public void k(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        this.f7264R.f(abstractComponentCallbacksC0828p);
    }

    public AbstractComponentCallbacksC0828p k0(String str) {
        return this.f7269c.i(str);
    }

    public int l() {
        return this.f7277k.getAndIncrement();
    }

    public Bundle l1() {
        C0814b[] c0814bArr;
        Bundle bundle = new Bundle();
        n0();
        Y();
        b0(true);
        this.f7257K = true;
        this.f7264R.q(true);
        ArrayList arrayListY = this.f7269c.y();
        HashMap mapM = this.f7269c.m();
        if (!mapM.isEmpty()) {
            ArrayList arrayListZ = this.f7269c.z();
            int size = this.f7270d.size();
            if (size > 0) {
                c0814bArr = new C0814b[size];
                for (int i4 = 0; i4 < size; i4++) {
                    c0814bArr[i4] = new C0814b((C0813a) this.f7270d.get(i4));
                    if (J0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i4 + ": " + this.f7270d.get(i4));
                    }
                }
            } else {
                c0814bArr = null;
            }
            K k4 = new K();
            k4.f7310a = arrayListY;
            k4.f7311b = arrayListZ;
            k4.f7312c = c0814bArr;
            k4.f7313d = this.f7277k.get();
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = this.f7247A;
            if (abstractComponentCallbacksC0828p != null) {
                k4.f7314e = abstractComponentCallbacksC0828p.mWho;
            }
            k4.f7315f.addAll(this.f7278l.keySet());
            k4.f7316g.addAll(this.f7278l.values());
            k4.f7317h = new ArrayList(this.f7255I);
            bundle.putParcelable("state", k4);
            for (String str : this.f7279m.keySet()) {
                bundle.putBundle("result_" + str, (Bundle) this.f7279m.get(str));
            }
            for (String str2 : mapM.keySet()) {
                bundle.putBundle("fragment_" + str2, (Bundle) mapM.get(str2));
            }
        } else if (J0(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return bundle;
        }
        return bundle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void m(A a4, AbstractC0834w abstractC0834w, AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        String str;
        if (this.f7290x != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f7290x = a4;
        this.f7291y = abstractC0834w;
        this.f7292z = abstractComponentCallbacksC0828p;
        if (abstractComponentCallbacksC0828p != null) {
            j(new g(abstractComponentCallbacksC0828p));
        } else if (a4 instanceof M) {
            j((M) a4);
        }
        if (this.f7292z != null) {
            u1();
        }
        if (a4 instanceof androidx.activity.s) {
            androidx.activity.s sVar = (androidx.activity.s) a4;
            androidx.activity.q onBackPressedDispatcher = sVar.getOnBackPressedDispatcher();
            this.f7273g = onBackPressedDispatcher;
            InterfaceC0850m interfaceC0850m = sVar;
            if (abstractComponentCallbacksC0828p != null) {
                interfaceC0850m = abstractComponentCallbacksC0828p;
            }
            onBackPressedDispatcher.h(interfaceC0850m, this.f7276j);
        }
        if (abstractComponentCallbacksC0828p != null) {
            this.f7264R = abstractComponentCallbacksC0828p.mFragmentManager.r0(abstractComponentCallbacksC0828p);
        } else if (a4 instanceof androidx.lifecycle.N) {
            this.f7264R = L.l(((androidx.lifecycle.N) a4).getViewModelStore());
        } else {
            this.f7264R = new L(false);
        }
        this.f7264R.q(Q0());
        this.f7269c.A(this.f7264R);
        Object obj = this.f7290x;
        if ((obj instanceof o0.f) && abstractComponentCallbacksC0828p == null) {
            o0.d savedStateRegistry = ((o0.f) obj).getSavedStateRegistry();
            savedStateRegistry.h("android:support:fragments", new d.c() { // from class: androidx.fragment.app.H
                @Override // o0.d.c
                public final Bundle a() {
                    return this.f7244a.l1();
                }
            });
            Bundle bundleB = savedStateRegistry.b("android:support:fragments");
            if (bundleB != null) {
                j1(bundleB);
            }
        }
        Object obj2 = this.f7290x;
        if (obj2 instanceof InterfaceC1223e) {
            AbstractC1222d activityResultRegistry = ((InterfaceC1223e) obj2).getActivityResultRegistry();
            if (abstractComponentCallbacksC0828p != null) {
                str = abstractComponentCallbacksC0828p.mWho + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
            } else {
                str = "";
            }
            String str2 = "FragmentManager:" + str;
            this.f7252F = activityResultRegistry.j(str2 + "StartActivityForResult", new C1240c(), new h());
            this.f7253G = activityResultRegistry.j(str2 + "StartIntentSenderForResult", new j(), new i());
            this.f7254H = activityResultRegistry.j(str2 + "RequestPermissions", new C1239b(), new a());
        }
        Object obj3 = this.f7290x;
        if (obj3 instanceof InterfaceC1911c) {
            ((InterfaceC1911c) obj3).addOnConfigurationChangedListener(this.f7284r);
        }
        Object obj4 = this.f7290x;
        if (obj4 instanceof x.d) {
            ((x.d) obj4).addOnTrimMemoryListener(this.f7285s);
        }
        Object obj5 = this.f7290x;
        if (obj5 instanceof w.q) {
            ((w.q) obj5).addOnMultiWindowModeChangedListener(this.f7286t);
        }
        Object obj6 = this.f7290x;
        if (obj6 instanceof w.r) {
            ((w.r) obj6).addOnPictureInPictureModeChangedListener(this.f7287u);
        }
        Object obj7 = this.f7290x;
        if ((obj7 instanceof InterfaceC0279m) && abstractComponentCallbacksC0828p == null) {
            ((InterfaceC0279m) obj7).addMenuProvider(this.f7288v);
        }
    }

    public void m1() {
        synchronized (this.f7267a) {
            try {
                if (this.f7267a.size() == 1) {
                    this.f7290x.h().removeCallbacks(this.f7266T);
                    this.f7290x.h().post(this.f7266T);
                    u1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void n(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        if (J0(2)) {
            Log.v("FragmentManager", "attach: " + abstractComponentCallbacksC0828p);
        }
        if (abstractComponentCallbacksC0828p.mDetached) {
            abstractComponentCallbacksC0828p.mDetached = false;
            if (abstractComponentCallbacksC0828p.mAdded) {
                return;
            }
            this.f7269c.a(abstractComponentCallbacksC0828p);
            if (J0(2)) {
                Log.v("FragmentManager", "add from attach: " + abstractComponentCallbacksC0828p);
            }
            if (K0(abstractComponentCallbacksC0828p)) {
                this.f7256J = true;
            }
        }
    }

    public final void n0() {
        Iterator it = u().iterator();
        while (it.hasNext()) {
            ((Z) it.next()).r();
        }
    }

    public void n1(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p, boolean z4) {
        ViewGroup viewGroupT0 = t0(abstractComponentCallbacksC0828p);
        if (viewGroupT0 == null || !(viewGroupT0 instanceof C0835x)) {
            return;
        }
        ((C0835x) viewGroupT0).setDrawDisappearingViewsLast(!z4);
    }

    public Q o() {
        return new C0813a(this);
    }

    public Set o0(C0813a c0813a) {
        HashSet hashSet = new HashSet();
        for (int i4 = 0; i4 < c0813a.f7354c.size(); i4++) {
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = ((Q.a) c0813a.f7354c.get(i4)).f7372b;
            if (abstractComponentCallbacksC0828p != null && c0813a.f7360i) {
                hashSet.add(abstractComponentCallbacksC0828p);
            }
        }
        return hashSet;
    }

    public void o1(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p, AbstractC0846i.b bVar) {
        if (abstractComponentCallbacksC0828p.equals(g0(abstractComponentCallbacksC0828p.mWho)) && (abstractComponentCallbacksC0828p.mHost == null || abstractComponentCallbacksC0828p.mFragmentManager == this)) {
            abstractComponentCallbacksC0828p.mMaxState = bVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + abstractComponentCallbacksC0828p + " is not an active fragment of FragmentManager " + this);
    }

    public void p() {
        C0813a c0813a = this.f7274h;
        if (c0813a != null) {
            c0813a.f7451u = false;
            c0813a.f();
            f0();
            Iterator it = this.f7281o.iterator();
            if (it.hasNext()) {
                android.support.v4.media.session.b.a(it.next());
                throw null;
            }
        }
    }

    public final boolean p0(ArrayList arrayList, ArrayList arrayList2) {
        synchronized (this.f7267a) {
            if (this.f7267a.isEmpty()) {
                return false;
            }
            try {
                int size = this.f7267a.size();
                boolean zA = false;
                for (int i4 = 0; i4 < size; i4++) {
                    zA |= ((l) this.f7267a.get(i4)).a(arrayList, arrayList2);
                }
                return zA;
            } finally {
                this.f7267a.clear();
                this.f7290x.h().removeCallbacks(this.f7266T);
            }
        }
    }

    public void p1(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        if (abstractComponentCallbacksC0828p == null || (abstractComponentCallbacksC0828p.equals(g0(abstractComponentCallbacksC0828p.mWho)) && (abstractComponentCallbacksC0828p.mHost == null || abstractComponentCallbacksC0828p.mFragmentManager == this))) {
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p2 = this.f7247A;
            this.f7247A = abstractComponentCallbacksC0828p;
            M(abstractComponentCallbacksC0828p2);
            M(this.f7247A);
            return;
        }
        throw new IllegalArgumentException("Fragment " + abstractComponentCallbacksC0828p + " is not an active fragment of FragmentManager " + this);
    }

    public boolean q() {
        boolean zK0 = false;
        for (AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p : this.f7269c.l()) {
            if (abstractComponentCallbacksC0828p != null) {
                zK0 = K0(abstractComponentCallbacksC0828p);
            }
            if (zK0) {
                return true;
            }
        }
        return false;
    }

    public int q0() {
        return this.f7270d.size() + (this.f7274h != null ? 1 : 0);
    }

    public final void q1(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        ViewGroup viewGroupT0 = t0(abstractComponentCallbacksC0828p);
        if (viewGroupT0 == null || abstractComponentCallbacksC0828p.getEnterAnim() + abstractComponentCallbacksC0828p.getExitAnim() + abstractComponentCallbacksC0828p.getPopEnterAnim() + abstractComponentCallbacksC0828p.getPopExitAnim() <= 0) {
            return;
        }
        if (viewGroupT0.getTag(X.b.f5521c) == null) {
            viewGroupT0.setTag(X.b.f5521c, abstractComponentCallbacksC0828p);
        }
        ((AbstractComponentCallbacksC0828p) viewGroupT0.getTag(X.b.f5521c)).setPopDirection(abstractComponentCallbacksC0828p.getPopDirection());
    }

    public final void r() {
        if (Q0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public final L r0(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        return this.f7264R.k(abstractComponentCallbacksC0828p);
    }

    public void r1(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        if (J0(2)) {
            Log.v("FragmentManager", "show: " + abstractComponentCallbacksC0828p);
        }
        if (abstractComponentCallbacksC0828p.mHidden) {
            abstractComponentCallbacksC0828p.mHidden = false;
            abstractComponentCallbacksC0828p.mHiddenChanged = !abstractComponentCallbacksC0828p.mHiddenChanged;
        }
    }

    public final void s() {
        this.f7268b = false;
        this.f7262P.clear();
        this.f7261O.clear();
    }

    public AbstractC0834w s0() {
        return this.f7291y;
    }

    public final void s1() {
        Iterator it = this.f7269c.k().iterator();
        while (it.hasNext()) {
            X0((O) it.next());
        }
    }

    public final void t() {
        A a4 = this.f7290x;
        if (a4 instanceof androidx.lifecycle.N ? this.f7269c.p().o() : a4.f() instanceof Activity ? !((Activity) this.f7290x.f()).isChangingConfigurations() : true) {
            Iterator it = this.f7278l.values().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((C0815c) it.next()).f7468a.iterator();
                while (it2.hasNext()) {
                    this.f7269c.p().h((String) it2.next(), false);
                }
            }
        }
    }

    public final ViewGroup t0(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        ViewGroup viewGroup = abstractComponentCallbacksC0828p.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (abstractComponentCallbacksC0828p.mContainerId > 0 && this.f7291y.d()) {
            View viewC = this.f7291y.c(abstractComponentCallbacksC0828p.mContainerId);
            if (viewC instanceof ViewGroup) {
                return (ViewGroup) viewC;
            }
        }
        return null;
    }

    public final void t1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new W("FragmentManager"));
        A a4 = this.f7290x;
        if (a4 != null) {
            try {
                a4.i("  ", null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e4) {
                Log.e("FragmentManager", "Failed dumping state", e4);
                throw runtimeException;
            }
        }
        try {
            X("  ", null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e5) {
            Log.e("FragmentManager", "Failed dumping state", e5);
            throw runtimeException;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = this.f7292z;
        if (abstractComponentCallbacksC0828p != null) {
            sb.append(abstractComponentCallbacksC0828p.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f7292z)));
            sb.append("}");
        } else {
            A a4 = this.f7290x;
            if (a4 != null) {
                sb.append(a4.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f7290x)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public final Set u() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f7269c.k().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((O) it.next()).k().mContainer;
            if (viewGroup != null) {
                hashSet.add(Z.v(viewGroup, B0()));
            }
        }
        return hashSet;
    }

    public AbstractC0837z u0() {
        AbstractC0837z abstractC0837z = this.f7248B;
        if (abstractC0837z != null) {
            return abstractC0837z;
        }
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = this.f7292z;
        return abstractComponentCallbacksC0828p != null ? abstractComponentCallbacksC0828p.mFragmentManager.u0() : this.f7249C;
    }

    public final void u1() {
        synchronized (this.f7267a) {
            try {
                if (!this.f7267a.isEmpty()) {
                    this.f7276j.setEnabled(true);
                    if (J0(3)) {
                        Log.d("FragmentManager", "FragmentManager " + this + " enabling OnBackPressedCallback, caused by non-empty pending actions");
                    }
                    return;
                }
                boolean z4 = q0() > 0 && O0(this.f7292z);
                if (J0(3)) {
                    Log.d("FragmentManager", "OnBackPressedCallback for FragmentManager " + this + " enabled state is " + z4);
                }
                this.f7276j.setEnabled(z4);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Set v(ArrayList arrayList, int i4, int i5) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i4 < i5) {
            Iterator it = ((C0813a) arrayList.get(i4)).f7354c.iterator();
            while (it.hasNext()) {
                AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = ((Q.a) it.next()).f7372b;
                if (abstractComponentCallbacksC0828p != null && (viewGroup = abstractComponentCallbacksC0828p.mContainer) != null) {
                    hashSet.add(Z.u(viewGroup, this));
                }
            }
            i4++;
        }
        return hashSet;
    }

    public List v0() {
        return this.f7269c.o();
    }

    public O w(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        O oN = this.f7269c.n(abstractComponentCallbacksC0828p.mWho);
        if (oN != null) {
            return oN;
        }
        O o4 = new O(this.f7282p, this.f7269c, abstractComponentCallbacksC0828p);
        o4.o(this.f7290x.f().getClassLoader());
        o4.s(this.f7289w);
        return o4;
    }

    public A w0() {
        return this.f7290x;
    }

    public void x(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        if (J0(2)) {
            Log.v("FragmentManager", "detach: " + abstractComponentCallbacksC0828p);
        }
        if (abstractComponentCallbacksC0828p.mDetached) {
            return;
        }
        abstractComponentCallbacksC0828p.mDetached = true;
        if (abstractComponentCallbacksC0828p.mAdded) {
            if (J0(2)) {
                Log.v("FragmentManager", "remove from detach: " + abstractComponentCallbacksC0828p);
            }
            this.f7269c.u(abstractComponentCallbacksC0828p);
            if (K0(abstractComponentCallbacksC0828p)) {
                this.f7256J = true;
            }
            q1(abstractComponentCallbacksC0828p);
        }
    }

    public LayoutInflater.Factory2 x0() {
        return this.f7272f;
    }

    public void y() {
        this.f7257K = false;
        this.f7258L = false;
        this.f7264R.q(false);
        T(4);
    }

    public C y0() {
        return this.f7282p;
    }

    public void z() {
        this.f7257K = false;
        this.f7258L = false;
        this.f7264R.q(false);
        T(0);
    }

    public AbstractComponentCallbacksC0828p z0() {
        return this.f7292z;
    }

    public static class k implements Parcelable {
        public static final Parcelable.Creator<k> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7304b;

        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public k createFromParcel(Parcel parcel) {
                return new k(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public k[] newArray(int i4) {
                return new k[i4];
            }
        }

        public k(String str, int i4) {
            this.f7303a = str;
            this.f7304b = i4;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeString(this.f7303a);
            parcel.writeInt(this.f7304b);
        }

        public k(Parcel parcel) {
            this.f7303a = parcel.readString();
            this.f7304b = parcel.readInt();
        }
    }
}
