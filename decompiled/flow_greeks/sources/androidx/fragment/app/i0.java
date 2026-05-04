package androidx.fragment.app;

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
import androidx.fragment.app.q0;
import androidx.lifecycle.i;
import com.revenuecat.purchases.common.Constants;
import e.f;
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
import k2.d;
import v1.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i0 {
    public static boolean U = false;
    public static boolean V = true;
    public p A;
    public e.c F;
    public e.c G;
    public e.c H;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public ArrayList O;
    public ArrayList P;
    public ArrayList Q;
    public l0 R;
    public c.C0398c S;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2112b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f2115e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public androidx.activity.p f2117g;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public a0 f2134x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public w f2135y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public p f2136z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f2111a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p0 f2113c = new p0();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f2114d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b0 f2116f = new b0(this);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public androidx.fragment.app.a f2118h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2119i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.activity.o f2120j = new b(false);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicInteger f2121k = new AtomicInteger();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map f2122l = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map f2123m = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map f2124n = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList f2125o = new ArrayList();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c0 f2126p = new c0(this);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final CopyOnWriteArrayList f2127q = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final s0.a f2128r = new s0.a() { // from class: androidx.fragment.app.d0
        @Override // s0.a
        public final void accept(Object obj) {
            i0.e(this.f2052a, (Configuration) obj);
        }
    };

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final s0.a f2129s = new s0.a() { // from class: androidx.fragment.app.e0
        @Override // s0.a
        public final void accept(Object obj) {
            i0.a(this.f2056a, (Integer) obj);
        }
    };

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final s0.a f2130t = new s0.a() { // from class: androidx.fragment.app.f0
        @Override // s0.a
        public final void accept(Object obj) {
            i0.d(this.f2103a, (h0.g) obj);
        }
    };

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final s0.a f2131u = new s0.a() { // from class: androidx.fragment.app.g0
        @Override // s0.a
        public final void accept(Object obj) {
            i0.c(this.f2105a, (h0.r) obj);
        }
    };

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final t0.p f2132v = new c();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2133w = -1;
    public z B = null;
    public z C = new d();
    public z0 D = null;
    public z0 E = new e();
    public ArrayDeque I = new ArrayDeque();
    public Runnable T = new f();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements e.b {
        public a() {
        }

        @Override // e.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Map map) {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                iArr[i10] = ((Boolean) arrayList.get(i10)).booleanValue() ? 0 : -1;
            }
            k kVar = (k) i0.this.I.pollFirst();
            if (kVar == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            String str = kVar.f2147a;
            int i11 = kVar.f2148b;
            p pVarI = i0.this.f2113c.i(str);
            if (pVarI != null) {
                pVarI.onRequestPermissionsResult(i11, strArr, iArr);
                return;
            }
            Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b extends androidx.activity.o {
        public b(boolean z10) {
            super(z10);
        }

        @Override // androidx.activity.o
        public void handleOnBackCancelled() {
            if (i0.J0(3)) {
                Log.d("FragmentManager", "handleOnBackCancelled. PREDICTIVE_BACK = " + i0.V + " fragment manager " + i0.this);
            }
            if (i0.V) {
                i0.this.p();
                i0.this.f2118h = null;
            }
        }

        @Override // androidx.activity.o
        public void handleOnBackPressed() {
            if (i0.J0(3)) {
                Log.d("FragmentManager", "handleOnBackPressed. PREDICTIVE_BACK = " + i0.V + " fragment manager " + i0.this);
            }
            i0.this.F0();
        }

        @Override // androidx.activity.o
        public void handleOnBackProgressed(androidx.activity.b bVar) {
            if (i0.J0(2)) {
                Log.v("FragmentManager", "handleOnBackProgressed. PREDICTIVE_BACK = " + i0.V + " fragment manager " + i0.this);
            }
            i0 i0Var = i0.this;
            if (i0Var.f2118h != null) {
                Iterator it = i0Var.v(new ArrayList(Collections.singletonList(i0.this.f2118h)), 0, 1).iterator();
                while (it.hasNext()) {
                    ((y0) it.next()).y(bVar);
                }
                Iterator it2 = i0.this.f2125o.iterator();
                if (it2.hasNext()) {
                    android.support.v4.media.session.b.a(it2.next());
                    throw null;
                }
            }
        }

        @Override // androidx.activity.o
        public void handleOnBackStarted(androidx.activity.b bVar) {
            if (i0.J0(3)) {
                Log.d("FragmentManager", "handleOnBackStarted. PREDICTIVE_BACK = " + i0.V + " fragment manager " + i0.this);
            }
            if (i0.V) {
                i0.this.Y();
                i0.this.e1();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements t0.p {
        public c() {
        }

        @Override // t0.p
        public boolean a(MenuItem menuItem) {
            return i0.this.K(menuItem);
        }

        @Override // t0.p
        public void b(Menu menu) {
            i0.this.L(menu);
        }

        @Override // t0.p
        public void c(Menu menu, MenuInflater menuInflater) {
            i0.this.D(menu, menuInflater);
        }

        @Override // t0.p
        public void d(Menu menu) {
            i0.this.P(menu);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d extends z {
        public d() {
        }

        @Override // androidx.fragment.app.z
        public p a(ClassLoader classLoader, String str) {
            return i0.this.w0().b(i0.this.w0().f(), str, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class e implements z0 {
        public e() {
        }

        @Override // androidx.fragment.app.z0
        public y0 a(ViewGroup viewGroup) {
            return new androidx.fragment.app.f(viewGroup);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i0.this.b0(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class g implements m0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f2143a;

        public g(p pVar) {
            this.f2143a = pVar;
        }

        @Override // androidx.fragment.app.m0
        public void a(i0 i0Var, p pVar) {
            this.f2143a.onAttachFragment(pVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class h implements e.b {
        public h() {
        }

        @Override // e.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(e.a aVar) {
            k kVar = (k) i0.this.I.pollLast();
            if (kVar == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = kVar.f2147a;
            int i10 = kVar.f2148b;
            p pVarI = i0.this.f2113c.i(str);
            if (pVarI != null) {
                pVarI.onActivityResult(i10, aVar.b(), aVar.a());
                return;
            }
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class i implements e.b {
        public i() {
        }

        @Override // e.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(e.a aVar) {
            k kVar = (k) i0.this.I.pollFirst();
            if (kVar == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = kVar.f2147a;
            int i10 = kVar.f2148b;
            p pVarI = i0.this.f2113c.i(str);
            if (pVarI != null) {
                pVarI.onActivityResult(i10, aVar.b(), aVar.a());
                return;
            }
            Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class j extends f.a {
        @Override // f.a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(Context context, e.f fVar) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent intentA = fVar.a();
            if (intentA != null && (bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (intentA.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    fVar = new f.a(fVar.e()).b(null).c(fVar.d(), fVar.b()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", fVar);
            if (i0.J0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // f.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public e.a c(int i10, Intent intent) {
            return new e.a(i10, intent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface l {
        boolean a(ArrayList arrayList, ArrayList arrayList2);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class m implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2150b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f2151c;

        public m(String str, int i10, int i11) {
            this.f2149a = str;
            this.f2150b = i10;
            this.f2151c = i11;
        }

        @Override // androidx.fragment.app.i0.l
        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            p pVar = i0.this.A;
            if (pVar == null || this.f2150b >= 0 || this.f2149a != null || !pVar.getChildFragmentManager().Z0()) {
                return i0.this.c1(arrayList, arrayList2, this.f2149a, this.f2150b, this.f2151c);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class n implements l {
        public n() {
        }

        @Override // androidx.fragment.app.i0.l
        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            boolean zD1 = i0.this.d1(arrayList, arrayList2);
            i0 i0Var = i0.this;
            i0Var.f2119i = true;
            if (!i0Var.f2125o.isEmpty() && arrayList.size() > 0) {
                ((Boolean) arrayList2.get(arrayList.size() - 1)).booleanValue();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    linkedHashSet.addAll(i0.this.o0((androidx.fragment.app.a) it.next()));
                }
                Iterator it2 = i0.this.f2125o.iterator();
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

    public static p D0(View view) {
        Object tag = view.getTag(u1.b.f22142a);
        if (tag instanceof p) {
            return (p) tag;
        }
        return null;
    }

    public static boolean J0(int i10) {
        return U || Log.isLoggable("FragmentManager", i10);
    }

    public static /* synthetic */ void a(i0 i0Var, Integer num) {
        if (i0Var.L0() && num.intValue() == 80) {
            i0Var.G(false);
        }
    }

    public static /* synthetic */ void c(i0 i0Var, h0.r rVar) {
        if (i0Var.L0()) {
            i0Var.O(rVar.a(), false);
        }
    }

    public static /* synthetic */ void d(i0 i0Var, h0.g gVar) {
        if (i0Var.L0()) {
            i0Var.H(gVar.a(), false);
        }
    }

    public static void d0(ArrayList arrayList, ArrayList arrayList2, int i10, int i11) {
        while (i10 < i11) {
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) arrayList.get(i10);
            if (((Boolean) arrayList2.get(i10)).booleanValue()) {
                aVar.n(-1);
                aVar.s();
            } else {
                aVar.n(1);
                aVar.r();
            }
            i10++;
        }
    }

    public static /* synthetic */ void e(i0 i0Var, Configuration configuration) {
        if (i0Var.L0()) {
            i0Var.A(configuration, false);
        }
    }

    public static int k1(int i10) {
        if (i10 == 4097) {
            return 8194;
        }
        if (i10 == 8194) {
            return 4097;
        }
        if (i10 == 8197) {
            return 4100;
        }
        if (i10 != 4099) {
            return i10 != 4100 ? 0 : 8197;
        }
        return 4099;
    }

    public static i0 l0(View view) {
        u uVar;
        p pVarM0 = m0(view);
        if (pVarM0 != null) {
            if (pVarM0.isAdded()) {
                return pVarM0.getChildFragmentManager();
            }
            throw new IllegalStateException("The Fragment " + pVarM0 + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        Context context = view.getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                uVar = null;
                break;
            }
            if (context instanceof u) {
                uVar = (u) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (uVar != null) {
            return uVar.getSupportFragmentManager();
        }
        throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
    }

    public static p m0(View view) {
        while (view != null) {
            p pVarD0 = D0(view);
            if (pVarD0 != null) {
                return pVarD0;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    public void A(Configuration configuration, boolean z10) {
        if (z10 && (this.f2134x instanceof i0.c)) {
            t1(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (p pVar : this.f2113c.o()) {
            if (pVar != null) {
                pVar.performConfigurationChanged(configuration);
                if (z10) {
                    pVar.mChildFragmentManager.A(configuration, true);
                }
            }
        }
    }

    public p A0() {
        return this.A;
    }

    public boolean B(MenuItem menuItem) {
        if (this.f2133w < 1) {
            return false;
        }
        for (p pVar : this.f2113c.o()) {
            if (pVar != null && pVar.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public z0 B0() {
        z0 z0Var = this.D;
        if (z0Var != null) {
            return z0Var;
        }
        p pVar = this.f2136z;
        return pVar != null ? pVar.mFragmentManager.B0() : this.E;
    }

    public void C() {
        this.K = false;
        this.L = false;
        this.R.q(false);
        T(1);
    }

    public c.C0398c C0() {
        return this.S;
    }

    public boolean D(Menu menu, MenuInflater menuInflater) {
        if (this.f2133w < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z10 = false;
        for (p pVar : this.f2113c.o()) {
            if (pVar != null && N0(pVar) && pVar.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(pVar);
                z10 = true;
            }
        }
        if (this.f2115e != null) {
            for (int i10 = 0; i10 < this.f2115e.size(); i10++) {
                p pVar2 = (p) this.f2115e.get(i10);
                if (arrayList == null || !arrayList.contains(pVar2)) {
                    pVar2.onDestroyOptionsMenu();
                }
            }
        }
        this.f2115e = arrayList;
        return z10;
    }

    public void E() {
        this.M = true;
        b0(true);
        Y();
        t();
        T(-1);
        Object obj = this.f2134x;
        if (obj instanceof i0.d) {
            ((i0.d) obj).removeOnTrimMemoryListener(this.f2129s);
        }
        Object obj2 = this.f2134x;
        if (obj2 instanceof i0.c) {
            ((i0.c) obj2).removeOnConfigurationChangedListener(this.f2128r);
        }
        Object obj3 = this.f2134x;
        if (obj3 instanceof h0.n) {
            ((h0.n) obj3).removeOnMultiWindowModeChangedListener(this.f2130t);
        }
        Object obj4 = this.f2134x;
        if (obj4 instanceof h0.o) {
            ((h0.o) obj4).removeOnPictureInPictureModeChangedListener(this.f2131u);
        }
        Object obj5 = this.f2134x;
        if ((obj5 instanceof t0.k) && this.f2136z == null) {
            ((t0.k) obj5).removeMenuProvider(this.f2132v);
        }
        this.f2134x = null;
        this.f2135y = null;
        this.f2136z = null;
        if (this.f2117g != null) {
            this.f2120j.remove();
            this.f2117g = null;
        }
        e.c cVar = this.F;
        if (cVar != null) {
            cVar.c();
            this.G.c();
            this.H.c();
        }
    }

    public androidx.lifecycle.l0 E0(p pVar) {
        return this.R.n(pVar);
    }

    public void F() {
        T(1);
    }

    public void F0() {
        b0(true);
        if (!V || this.f2118h == null) {
            if (this.f2120j.isEnabled()) {
                if (J0(3)) {
                    Log.d("FragmentManager", "Calling popBackStackImmediate via onBackPressed callback");
                }
                Z0();
                return;
            } else {
                if (J0(3)) {
                    Log.d("FragmentManager", "Calling onBackPressed via onBackPressed callback");
                }
                this.f2117g.k();
                return;
            }
        }
        if (!this.f2125o.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(o0(this.f2118h));
            Iterator it = this.f2125o.iterator();
            while (it.hasNext()) {
                android.support.v4.media.session.b.a(it.next());
                Iterator it2 = linkedHashSet.iterator();
                if (it2.hasNext()) {
                    throw null;
                }
            }
        }
        Iterator it3 = this.f2118h.f2270c.iterator();
        while (it3.hasNext()) {
            p pVar = ((q0.a) it3.next()).f2288b;
            if (pVar != null) {
                pVar.mTransitioning = false;
            }
        }
        Iterator it4 = v(new ArrayList(Collections.singletonList(this.f2118h)), 0, 1).iterator();
        while (it4.hasNext()) {
            ((y0) it4.next()).f();
        }
        this.f2118h = null;
        u1();
        if (J0(3)) {
            Log.d("FragmentManager", "Op is being set to null");
            Log.d("FragmentManager", "OnBackPressedCallback enabled=" + this.f2120j.isEnabled() + " for  FragmentManager " + this);
        }
    }

    public void G(boolean z10) {
        if (z10 && (this.f2134x instanceof i0.d)) {
            t1(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (p pVar : this.f2113c.o()) {
            if (pVar != null) {
                pVar.performLowMemory();
                if (z10) {
                    pVar.mChildFragmentManager.G(true);
                }
            }
        }
    }

    public void G0(p pVar) {
        if (J0(2)) {
            Log.v("FragmentManager", "hide: " + pVar);
        }
        if (pVar.mHidden) {
            return;
        }
        pVar.mHidden = true;
        pVar.mHiddenChanged = true ^ pVar.mHiddenChanged;
        q1(pVar);
    }

    public void H(boolean z10, boolean z11) {
        if (z11 && (this.f2134x instanceof h0.n)) {
            t1(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (p pVar : this.f2113c.o()) {
            if (pVar != null) {
                pVar.performMultiWindowModeChanged(z10);
                if (z11) {
                    pVar.mChildFragmentManager.H(z10, true);
                }
            }
        }
    }

    public void H0(p pVar) {
        if (pVar.mAdded && K0(pVar)) {
            this.J = true;
        }
    }

    public void I(p pVar) {
        Iterator it = this.f2127q.iterator();
        while (it.hasNext()) {
            ((m0) it.next()).a(this, pVar);
        }
    }

    public boolean I0() {
        return this.M;
    }

    public void J() {
        for (p pVar : this.f2113c.l()) {
            if (pVar != null) {
                pVar.onHiddenChanged(pVar.isHidden());
                pVar.mChildFragmentManager.J();
            }
        }
    }

    public boolean K(MenuItem menuItem) {
        if (this.f2133w < 1) {
            return false;
        }
        for (p pVar : this.f2113c.o()) {
            if (pVar != null && pVar.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final boolean K0(p pVar) {
        return (pVar.mHasMenu && pVar.mMenuVisible) || pVar.mChildFragmentManager.q();
    }

    public void L(Menu menu) {
        if (this.f2133w < 1) {
            return;
        }
        for (p pVar : this.f2113c.o()) {
            if (pVar != null) {
                pVar.performOptionsMenuClosed(menu);
            }
        }
    }

    public final boolean L0() {
        p pVar = this.f2136z;
        if (pVar == null) {
            return true;
        }
        return pVar.isAdded() && this.f2136z.getParentFragmentManager().L0();
    }

    public final void M(p pVar) {
        if (pVar == null || !pVar.equals(g0(pVar.mWho))) {
            return;
        }
        pVar.performPrimaryNavigationFragmentChanged();
    }

    public boolean M0(p pVar) {
        if (pVar == null) {
            return false;
        }
        return pVar.isHidden();
    }

    public void N() {
        T(5);
    }

    public boolean N0(p pVar) {
        if (pVar == null) {
            return true;
        }
        return pVar.isMenuVisible();
    }

    public void O(boolean z10, boolean z11) {
        if (z11 && (this.f2134x instanceof h0.o)) {
            t1(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (p pVar : this.f2113c.o()) {
            if (pVar != null) {
                pVar.performPictureInPictureModeChanged(z10);
                if (z11) {
                    pVar.mChildFragmentManager.O(z10, true);
                }
            }
        }
    }

    public boolean O0(p pVar) {
        if (pVar == null) {
            return true;
        }
        i0 i0Var = pVar.mFragmentManager;
        return pVar.equals(i0Var.A0()) && O0(i0Var.f2136z);
    }

    public boolean P(Menu menu) {
        boolean z10 = false;
        if (this.f2133w < 1) {
            return false;
        }
        for (p pVar : this.f2113c.o()) {
            if (pVar != null && N0(pVar) && pVar.performPrepareOptionsMenu(menu)) {
                z10 = true;
            }
        }
        return z10;
    }

    public boolean P0(int i10) {
        return this.f2133w >= i10;
    }

    public void Q() {
        u1();
        M(this.A);
    }

    public boolean Q0() {
        return this.K || this.L;
    }

    public void R() {
        this.K = false;
        this.L = false;
        this.R.q(false);
        T(7);
    }

    public void R0(p pVar, String[] strArr, int i10) {
        if (this.H == null) {
            this.f2134x.l(pVar, strArr, i10);
            return;
        }
        this.I.addLast(new k(pVar.mWho, i10));
        this.H.a(strArr);
    }

    public void S() {
        this.K = false;
        this.L = false;
        this.R.q(false);
        T(5);
    }

    public void S0(p pVar, Intent intent, int i10, Bundle bundle) {
        if (this.F == null) {
            this.f2134x.n(pVar, intent, i10, bundle);
            return;
        }
        this.I.addLast(new k(pVar.mWho, i10));
        if (bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        this.F.a(intent);
    }

    public final void T(int i10) {
        try {
            this.f2112b = true;
            this.f2113c.d(i10);
            U0(i10, false);
            Iterator it = u().iterator();
            while (it.hasNext()) {
                ((y0) it.next()).q();
            }
            this.f2112b = false;
            b0(true);
        } catch (Throwable th) {
            this.f2112b = false;
            throw th;
        }
    }

    public void T0(p pVar, IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) {
        if (this.G == null) {
            this.f2134x.o(pVar, intentSender, i10, intent, i11, i12, i13, bundle);
            return;
        }
        if (bundle != null) {
            if (intent == null) {
                intent = new Intent();
                intent.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            }
            if (J0(2)) {
                Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent + " for fragment " + pVar);
            }
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        e.f fVarA = new f.a(intentSender).b(intent).c(i12, i11).a();
        this.I.addLast(new k(pVar.mWho, i10));
        if (J0(2)) {
            Log.v("FragmentManager", "Fragment " + pVar + "is launching an IntentSender for result ");
        }
        this.G.a(fVarA);
    }

    public void U() {
        this.L = true;
        this.R.q(true);
        T(4);
    }

    public void U0(int i10, boolean z10) {
        a0 a0Var;
        if (this.f2134x == null && i10 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z10 || i10 != this.f2133w) {
            this.f2133w = i10;
            this.f2113c.t();
            s1();
            if (this.J && (a0Var = this.f2134x) != null && this.f2133w == 7) {
                a0Var.p();
                this.J = false;
            }
        }
    }

    public void V() {
        T(2);
    }

    public void V0() {
        if (this.f2134x == null) {
            return;
        }
        this.K = false;
        this.L = false;
        this.R.q(false);
        for (p pVar : this.f2113c.o()) {
            if (pVar != null) {
                pVar.noteStateNotSaved();
            }
        }
    }

    public final void W() {
        if (this.N) {
            this.N = false;
            s1();
        }
    }

    public void W0(x xVar) {
        View view;
        for (o0 o0Var : this.f2113c.k()) {
            p pVarK = o0Var.k();
            if (pVarK.mContainerId == xVar.getId() && (view = pVarK.mView) != null && view.getParent() == null) {
                pVarK.mContainer = xVar;
                o0Var.b();
            }
        }
    }

    public void X(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        String str2 = str + "    ";
        this.f2113c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList arrayList = this.f2115e;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i10 = 0; i10 < size; i10++) {
                p pVar = (p) this.f2115e.get(i10);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(pVar.toString());
            }
        }
        int size2 = this.f2114d.size();
        if (size2 > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i11 = 0; i11 < size2; i11++) {
                androidx.fragment.app.a aVar = (androidx.fragment.app.a) this.f2114d.get(i11);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.p(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f2121k.get());
        synchronized (this.f2111a) {
            try {
                int size3 = this.f2111a.size();
                if (size3 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i12 = 0; i12 < size3; i12++) {
                        l lVar = (l) this.f2111a.get(i12);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i12);
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
        printWriter.println(this.f2134x);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f2135y);
        if (this.f2136z != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f2136z);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f2133w);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.K);
        printWriter.print(" mStopped=");
        printWriter.print(this.L);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.M);
        if (this.J) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.J);
        }
    }

    public void X0(o0 o0Var) {
        p pVarK = o0Var.k();
        if (pVarK.mDeferStart) {
            if (this.f2112b) {
                this.N = true;
            } else {
                pVarK.mDeferStart = false;
                o0Var.m();
            }
        }
    }

    public final void Y() {
        Iterator it = u().iterator();
        while (it.hasNext()) {
            ((y0) it.next()).q();
        }
    }

    public void Y0(int i10, int i11, boolean z10) {
        if (i10 >= 0) {
            Z(new m(null, i10, i11), z10);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i10);
    }

    public void Z(l lVar, boolean z10) {
        if (!z10) {
            if (this.f2134x == null) {
                if (!this.M) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            r();
        }
        synchronized (this.f2111a) {
            try {
                if (this.f2134x == null) {
                    if (!z10) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f2111a.add(lVar);
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

    public final void a0(boolean z10) {
        if (this.f2112b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f2134x == null) {
            if (!this.M) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f2134x.h().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z10) {
            r();
        }
        if (this.O == null) {
            this.O = new ArrayList();
            this.P = new ArrayList();
        }
    }

    public boolean a1(int i10, int i11) {
        if (i10 >= 0) {
            return b1(null, i10, i11);
        }
        throw new IllegalArgumentException("Bad id: " + i10);
    }

    public boolean b0(boolean z10) {
        a0(z10);
        boolean z11 = false;
        while (p0(this.O, this.P)) {
            z11 = true;
            this.f2112b = true;
            try {
                g1(this.O, this.P);
            } finally {
                s();
            }
        }
        u1();
        W();
        this.f2113c.b();
        return z11;
    }

    public final boolean b1(String str, int i10, int i11) {
        b0(false);
        a0(true);
        p pVar = this.A;
        if (pVar != null && i10 < 0 && str == null && pVar.getChildFragmentManager().Z0()) {
            return true;
        }
        boolean zC1 = c1(this.O, this.P, str, i10, i11);
        if (zC1) {
            this.f2112b = true;
            try {
                g1(this.O, this.P);
            } finally {
                s();
            }
        }
        u1();
        W();
        this.f2113c.b();
        return zC1;
    }

    public void c0(l lVar, boolean z10) {
        if (z10 && (this.f2134x == null || this.M)) {
            return;
        }
        a0(z10);
        if (lVar.a(this.O, this.P)) {
            this.f2112b = true;
            try {
                g1(this.O, this.P);
            } finally {
                s();
            }
        }
        u1();
        W();
        this.f2113c.b();
    }

    public boolean c1(ArrayList arrayList, ArrayList arrayList2, String str, int i10, int i11) {
        int iH0 = h0(str, i10, (i11 & 1) != 0);
        if (iH0 < 0) {
            return false;
        }
        for (int size = this.f2114d.size() - 1; size >= iH0; size--) {
            arrayList.add((androidx.fragment.app.a) this.f2114d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public boolean d1(ArrayList arrayList, ArrayList arrayList2) {
        ArrayList arrayList3 = this.f2114d;
        androidx.fragment.app.a aVar = (androidx.fragment.app.a) arrayList3.get(arrayList3.size() - 1);
        this.f2118h = aVar;
        Iterator it = aVar.f2270c.iterator();
        while (it.hasNext()) {
            p pVar = ((q0.a) it.next()).f2288b;
            if (pVar != null) {
                pVar.mTransitioning = true;
            }
        }
        return c1(arrayList, arrayList2, null, -1, 0);
    }

    public final void e0(ArrayList arrayList, ArrayList arrayList2, int i10, int i11) {
        boolean z10 = ((androidx.fragment.app.a) arrayList.get(i10)).f2285r;
        ArrayList arrayList3 = this.Q;
        if (arrayList3 == null) {
            this.Q = new ArrayList();
        } else {
            arrayList3.clear();
        }
        this.Q.addAll(this.f2113c.o());
        p pVarA0 = A0();
        boolean z11 = false;
        for (int i12 = i10; i12 < i11; i12++) {
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) arrayList.get(i12);
            pVarA0 = !((Boolean) arrayList2.get(i12)).booleanValue() ? aVar.t(this.Q, pVarA0) : aVar.w(this.Q, pVarA0);
            z11 = z11 || aVar.f2276i;
        }
        this.Q.clear();
        if (!z10 && this.f2133w >= 1) {
            for (int i13 = i10; i13 < i11; i13++) {
                Iterator it = ((androidx.fragment.app.a) arrayList.get(i13)).f2270c.iterator();
                while (it.hasNext()) {
                    p pVar = ((q0.a) it.next()).f2288b;
                    if (pVar != null && pVar.mFragmentManager != null) {
                        this.f2113c.r(w(pVar));
                    }
                }
            }
        }
        d0(arrayList, arrayList2, i10, i11);
        boolean zBooleanValue = ((Boolean) arrayList2.get(i11 - 1)).booleanValue();
        if (z11 && !this.f2125o.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                linkedHashSet.addAll(o0((androidx.fragment.app.a) it2.next()));
            }
            if (this.f2118h == null) {
                Iterator it3 = this.f2125o.iterator();
                while (it3.hasNext()) {
                    android.support.v4.media.session.b.a(it3.next());
                    Iterator it4 = linkedHashSet.iterator();
                    if (it4.hasNext()) {
                        throw null;
                    }
                }
                Iterator it5 = this.f2125o.iterator();
                while (it5.hasNext()) {
                    android.support.v4.media.session.b.a(it5.next());
                    Iterator it6 = linkedHashSet.iterator();
                    if (it6.hasNext()) {
                        throw null;
                    }
                }
            }
        }
        for (int i14 = i10; i14 < i11; i14++) {
            androidx.fragment.app.a aVar2 = (androidx.fragment.app.a) arrayList.get(i14);
            if (zBooleanValue) {
                for (int size = aVar2.f2270c.size() - 1; size >= 0; size--) {
                    p pVar2 = ((q0.a) aVar2.f2270c.get(size)).f2288b;
                    if (pVar2 != null) {
                        w(pVar2).m();
                    }
                }
            } else {
                Iterator it7 = aVar2.f2270c.iterator();
                while (it7.hasNext()) {
                    p pVar3 = ((q0.a) it7.next()).f2288b;
                    if (pVar3 != null) {
                        w(pVar3).m();
                    }
                }
            }
        }
        U0(this.f2133w, true);
        for (y0 y0Var : v(arrayList, i10, i11)) {
            y0Var.B(zBooleanValue);
            y0Var.x();
            y0Var.n();
        }
        while (i10 < i11) {
            androidx.fragment.app.a aVar3 = (androidx.fragment.app.a) arrayList.get(i10);
            if (((Boolean) arrayList2.get(i10)).booleanValue() && aVar3.f2022v >= 0) {
                aVar3.f2022v = -1;
            }
            aVar3.v();
            i10++;
        }
        if (z11) {
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

    public void f1(p pVar) {
        if (J0(2)) {
            Log.v("FragmentManager", "remove: " + pVar + " nesting=" + pVar.mBackStackNesting);
        }
        boolean zIsInBackStack = pVar.isInBackStack();
        if (pVar.mDetached && zIsInBackStack) {
            return;
        }
        this.f2113c.u(pVar);
        if (K0(pVar)) {
            this.J = true;
        }
        pVar.mRemoving = true;
        q1(pVar);
    }

    public p g0(String str) {
        return this.f2113c.f(str);
    }

    public final void g1(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (i10 < size) {
            if (!((androidx.fragment.app.a) arrayList.get(i10)).f2285r) {
                if (i11 != i10) {
                    e0(arrayList, arrayList2, i11, i10);
                }
                i11 = i10 + 1;
                if (((Boolean) arrayList2.get(i10)).booleanValue()) {
                    while (i11 < size && ((Boolean) arrayList2.get(i11)).booleanValue() && !((androidx.fragment.app.a) arrayList.get(i11)).f2285r) {
                        i11++;
                    }
                }
                e0(arrayList, arrayList2, i10, i11);
                i10 = i11 - 1;
            }
            i10++;
        }
        if (i11 != size) {
            e0(arrayList, arrayList2, i11, size);
        }
    }

    public void h(androidx.fragment.app.a aVar) {
        this.f2114d.add(aVar);
    }

    public final int h0(String str, int i10, boolean z10) {
        if (this.f2114d.isEmpty()) {
            return -1;
        }
        if (str == null && i10 < 0) {
            if (z10) {
                return 0;
            }
            return this.f2114d.size() - 1;
        }
        int size = this.f2114d.size() - 1;
        while (size >= 0) {
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) this.f2114d.get(size);
            if ((str != null && str.equals(aVar.u())) || (i10 >= 0 && i10 == aVar.f2022v)) {
                break;
            }
            size--;
        }
        if (size < 0) {
            return size;
        }
        if (!z10) {
            if (size == this.f2114d.size() - 1) {
                return -1;
            }
            return size + 1;
        }
        while (size > 0) {
            androidx.fragment.app.a aVar2 = (androidx.fragment.app.a) this.f2114d.get(size - 1);
            if ((str == null || !str.equals(aVar2.u())) && (i10 < 0 || i10 != aVar2.f2022v)) {
                break;
            }
            size--;
        }
        return size;
    }

    public void h1(p pVar) {
        this.R.p(pVar);
    }

    public o0 i(p pVar) {
        String str = pVar.mPreviousWho;
        if (str != null) {
            v1.c.f(pVar, str);
        }
        if (J0(2)) {
            Log.v("FragmentManager", "add: " + pVar);
        }
        o0 o0VarW = w(pVar);
        pVar.mFragmentManager = this;
        this.f2113c.r(o0VarW);
        if (!pVar.mDetached) {
            this.f2113c.a(pVar);
            pVar.mRemoving = false;
            if (pVar.mView == null) {
                pVar.mHiddenChanged = false;
            }
            if (K0(pVar)) {
                this.J = true;
            }
        }
        return o0VarW;
    }

    public p i0(int i10) {
        return this.f2113c.g(i10);
    }

    public final void i1() {
        if (this.f2125o.size() <= 0) {
            return;
        }
        android.support.v4.media.session.b.a(this.f2125o.get(0));
        throw null;
    }

    public void j(m0 m0Var) {
        this.f2127q.add(m0Var);
    }

    public p j0(String str) {
        return this.f2113c.h(str);
    }

    public void j1(Parcelable parcelable) {
        o0 o0Var;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable == null) {
            return;
        }
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.f2134x.f().getClassLoader());
                this.f2123m.put(str.substring(7), bundle2);
            }
        }
        HashMap map = new HashMap();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.f2134x.f().getClassLoader());
                map.put(str2.substring(9), bundle);
            }
        }
        this.f2113c.x(map);
        k0 k0Var = (k0) bundle3.getParcelable("state");
        if (k0Var == null) {
            return;
        }
        this.f2113c.v();
        Iterator it = k0Var.f2160a.iterator();
        while (it.hasNext()) {
            Bundle bundleB = this.f2113c.B((String) it.next(), null);
            if (bundleB != null) {
                p pVarJ = this.R.j(((n0) bundleB.getParcelable("state")).f2202b);
                if (pVarJ != null) {
                    if (J0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + pVarJ);
                    }
                    o0Var = new o0(this.f2126p, this.f2113c, pVarJ, bundleB);
                } else {
                    o0Var = new o0(this.f2126p, this.f2113c, this.f2134x.f().getClassLoader(), u0(), bundleB);
                }
                p pVarK = o0Var.k();
                pVarK.mSavedFragmentState = bundleB;
                pVarK.mFragmentManager = this;
                if (J0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + pVarK.mWho + "): " + pVarK);
                }
                o0Var.o(this.f2134x.f().getClassLoader());
                this.f2113c.r(o0Var);
                o0Var.s(this.f2133w);
            }
        }
        for (p pVar : this.R.m()) {
            if (!this.f2113c.c(pVar.mWho)) {
                if (J0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + pVar + " that was not found in the set of active Fragments " + k0Var.f2160a);
                }
                this.R.p(pVar);
                pVar.mFragmentManager = this;
                o0 o0Var2 = new o0(this.f2126p, this.f2113c, pVar);
                o0Var2.s(1);
                o0Var2.m();
                pVar.mRemoving = true;
                o0Var2.m();
            }
        }
        this.f2113c.w(k0Var.f2161b);
        if (k0Var.f2162c != null) {
            this.f2114d = new ArrayList(k0Var.f2162c.length);
            int i10 = 0;
            while (true) {
                androidx.fragment.app.b[] bVarArr = k0Var.f2162c;
                if (i10 >= bVarArr.length) {
                    break;
                }
                androidx.fragment.app.a aVarB = bVarArr[i10].b(this);
                if (J0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i10 + " (index " + aVarB.f2022v + "): " + aVarB);
                    PrintWriter printWriter = new PrintWriter(new v0("FragmentManager"));
                    aVarB.q("  ", printWriter, false);
                    printWriter.close();
                }
                this.f2114d.add(aVarB);
                i10++;
            }
        } else {
            this.f2114d = new ArrayList();
        }
        this.f2121k.set(k0Var.f2163d);
        String str3 = k0Var.f2164e;
        if (str3 != null) {
            p pVarG0 = g0(str3);
            this.A = pVarG0;
            M(pVarG0);
        }
        ArrayList arrayList = k0Var.f2165f;
        if (arrayList != null) {
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                this.f2122l.put((String) arrayList.get(i11), (androidx.fragment.app.c) k0Var.f2166g.get(i11));
            }
        }
        this.I = new ArrayDeque(k0Var.f2167h);
    }

    public void k(p pVar) {
        this.R.f(pVar);
    }

    public p k0(String str) {
        return this.f2113c.i(str);
    }

    public int l() {
        return this.f2121k.getAndIncrement();
    }

    public Bundle l1() {
        androidx.fragment.app.b[] bVarArr;
        Bundle bundle = new Bundle();
        n0();
        Y();
        b0(true);
        this.K = true;
        this.R.q(true);
        ArrayList arrayListY = this.f2113c.y();
        HashMap mapM = this.f2113c.m();
        if (!mapM.isEmpty()) {
            ArrayList arrayListZ = this.f2113c.z();
            int size = this.f2114d.size();
            if (size > 0) {
                bVarArr = new androidx.fragment.app.b[size];
                for (int i10 = 0; i10 < size; i10++) {
                    bVarArr[i10] = new androidx.fragment.app.b((androidx.fragment.app.a) this.f2114d.get(i10));
                    if (J0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i10 + ": " + this.f2114d.get(i10));
                    }
                }
            } else {
                bVarArr = null;
            }
            k0 k0Var = new k0();
            k0Var.f2160a = arrayListY;
            k0Var.f2161b = arrayListZ;
            k0Var.f2162c = bVarArr;
            k0Var.f2163d = this.f2121k.get();
            p pVar = this.A;
            if (pVar != null) {
                k0Var.f2164e = pVar.mWho;
            }
            k0Var.f2165f.addAll(this.f2122l.keySet());
            k0Var.f2166g.addAll(this.f2122l.values());
            k0Var.f2167h = new ArrayList(this.I);
            bundle.putParcelable("state", k0Var);
            for (String str : this.f2123m.keySet()) {
                bundle.putBundle("result_" + str, (Bundle) this.f2123m.get(str));
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
    public void m(a0 a0Var, w wVar, p pVar) {
        String str;
        if (this.f2134x != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f2134x = a0Var;
        this.f2135y = wVar;
        this.f2136z = pVar;
        if (pVar != null) {
            j(new g(pVar));
        } else if (a0Var instanceof m0) {
            j((m0) a0Var);
        }
        if (this.f2136z != null) {
            u1();
        }
        if (a0Var instanceof androidx.activity.r) {
            androidx.activity.r rVar = (androidx.activity.r) a0Var;
            androidx.activity.p onBackPressedDispatcher = rVar.getOnBackPressedDispatcher();
            this.f2117g = onBackPressedDispatcher;
            androidx.lifecycle.m mVar = rVar;
            if (pVar != null) {
                mVar = pVar;
            }
            onBackPressedDispatcher.h(mVar, this.f2120j);
        }
        if (pVar != null) {
            this.R = pVar.mFragmentManager.r0(pVar);
        } else if (a0Var instanceof androidx.lifecycle.m0) {
            this.R = l0.l(((androidx.lifecycle.m0) a0Var).getViewModelStore());
        } else {
            this.R = new l0(false);
        }
        this.R.q(Q0());
        this.f2113c.A(this.R);
        Object obj = this.f2134x;
        if ((obj instanceof k2.f) && pVar == null) {
            k2.d savedStateRegistry = ((k2.f) obj).getSavedStateRegistry();
            savedStateRegistry.h("android:support:fragments", new d.c() { // from class: androidx.fragment.app.h0
                @Override // k2.d.c
                public final Bundle a() {
                    return this.f2108a.l1();
                }
            });
            Bundle bundleB = savedStateRegistry.b("android:support:fragments");
            if (bundleB != null) {
                j1(bundleB);
            }
        }
        Object obj2 = this.f2134x;
        if (obj2 instanceof e.e) {
            e.d activityResultRegistry = ((e.e) obj2).getActivityResultRegistry();
            if (pVar != null) {
                str = pVar.mWho + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
            } else {
                str = "";
            }
            String str2 = "FragmentManager:" + str;
            this.F = activityResultRegistry.j(str2 + "StartActivityForResult", new f.c(), new h());
            this.G = activityResultRegistry.j(str2 + "StartIntentSenderForResult", new j(), new i());
            this.H = activityResultRegistry.j(str2 + "RequestPermissions", new f.b(), new a());
        }
        Object obj3 = this.f2134x;
        if (obj3 instanceof i0.c) {
            ((i0.c) obj3).addOnConfigurationChangedListener(this.f2128r);
        }
        Object obj4 = this.f2134x;
        if (obj4 instanceof i0.d) {
            ((i0.d) obj4).addOnTrimMemoryListener(this.f2129s);
        }
        Object obj5 = this.f2134x;
        if (obj5 instanceof h0.n) {
            ((h0.n) obj5).addOnMultiWindowModeChangedListener(this.f2130t);
        }
        Object obj6 = this.f2134x;
        if (obj6 instanceof h0.o) {
            ((h0.o) obj6).addOnPictureInPictureModeChangedListener(this.f2131u);
        }
        Object obj7 = this.f2134x;
        if ((obj7 instanceof t0.k) && pVar == null) {
            ((t0.k) obj7).addMenuProvider(this.f2132v);
        }
    }

    public void m1() {
        synchronized (this.f2111a) {
            try {
                if (this.f2111a.size() == 1) {
                    this.f2134x.h().removeCallbacks(this.T);
                    this.f2134x.h().post(this.T);
                    u1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void n(p pVar) {
        if (J0(2)) {
            Log.v("FragmentManager", "attach: " + pVar);
        }
        if (pVar.mDetached) {
            pVar.mDetached = false;
            if (pVar.mAdded) {
                return;
            }
            this.f2113c.a(pVar);
            if (J0(2)) {
                Log.v("FragmentManager", "add from attach: " + pVar);
            }
            if (K0(pVar)) {
                this.J = true;
            }
        }
    }

    public final void n0() {
        Iterator it = u().iterator();
        while (it.hasNext()) {
            ((y0) it.next()).r();
        }
    }

    public void n1(p pVar, boolean z10) {
        ViewGroup viewGroupT0 = t0(pVar);
        if (viewGroupT0 == null || !(viewGroupT0 instanceof x)) {
            return;
        }
        ((x) viewGroupT0).setDrawDisappearingViewsLast(!z10);
    }

    public q0 o() {
        return new androidx.fragment.app.a(this);
    }

    public Set o0(androidx.fragment.app.a aVar) {
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 < aVar.f2270c.size(); i10++) {
            p pVar = ((q0.a) aVar.f2270c.get(i10)).f2288b;
            if (pVar != null && aVar.f2276i) {
                hashSet.add(pVar);
            }
        }
        return hashSet;
    }

    public void o1(p pVar, i.b bVar) {
        if (pVar.equals(g0(pVar.mWho)) && (pVar.mHost == null || pVar.mFragmentManager == this)) {
            pVar.mMaxState = bVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + pVar + " is not an active fragment of FragmentManager " + this);
    }

    public void p() {
        androidx.fragment.app.a aVar = this.f2118h;
        if (aVar != null) {
            aVar.f2021u = false;
            aVar.f();
            f0();
            Iterator it = this.f2125o.iterator();
            if (it.hasNext()) {
                android.support.v4.media.session.b.a(it.next());
                throw null;
            }
        }
    }

    public final boolean p0(ArrayList arrayList, ArrayList arrayList2) {
        synchronized (this.f2111a) {
            if (this.f2111a.isEmpty()) {
                return false;
            }
            try {
                int size = this.f2111a.size();
                boolean zA = false;
                for (int i10 = 0; i10 < size; i10++) {
                    zA |= ((l) this.f2111a.get(i10)).a(arrayList, arrayList2);
                }
                return zA;
            } finally {
                this.f2111a.clear();
                this.f2134x.h().removeCallbacks(this.T);
            }
        }
    }

    public void p1(p pVar) {
        if (pVar == null || (pVar.equals(g0(pVar.mWho)) && (pVar.mHost == null || pVar.mFragmentManager == this))) {
            p pVar2 = this.A;
            this.A = pVar;
            M(pVar2);
            M(this.A);
            return;
        }
        throw new IllegalArgumentException("Fragment " + pVar + " is not an active fragment of FragmentManager " + this);
    }

    public boolean q() {
        boolean zK0 = false;
        for (p pVar : this.f2113c.l()) {
            if (pVar != null) {
                zK0 = K0(pVar);
            }
            if (zK0) {
                return true;
            }
        }
        return false;
    }

    public int q0() {
        return this.f2114d.size() + (this.f2118h != null ? 1 : 0);
    }

    public final void q1(p pVar) {
        ViewGroup viewGroupT0 = t0(pVar);
        if (viewGroupT0 == null || pVar.getEnterAnim() + pVar.getExitAnim() + pVar.getPopEnterAnim() + pVar.getPopExitAnim() <= 0) {
            return;
        }
        if (viewGroupT0.getTag(u1.b.f22144c) == null) {
            viewGroupT0.setTag(u1.b.f22144c, pVar);
        }
        ((p) viewGroupT0.getTag(u1.b.f22144c)).setPopDirection(pVar.getPopDirection());
    }

    public final void r() {
        if (Q0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public final l0 r0(p pVar) {
        return this.R.k(pVar);
    }

    public void r1(p pVar) {
        if (J0(2)) {
            Log.v("FragmentManager", "show: " + pVar);
        }
        if (pVar.mHidden) {
            pVar.mHidden = false;
            pVar.mHiddenChanged = !pVar.mHiddenChanged;
        }
    }

    public final void s() {
        this.f2112b = false;
        this.P.clear();
        this.O.clear();
    }

    public w s0() {
        return this.f2135y;
    }

    public final void s1() {
        Iterator it = this.f2113c.k().iterator();
        while (it.hasNext()) {
            X0((o0) it.next());
        }
    }

    public final void t() {
        a0 a0Var = this.f2134x;
        if (a0Var instanceof androidx.lifecycle.m0 ? this.f2113c.p().o() : a0Var.f() instanceof Activity ? !((Activity) this.f2134x.f()).isChangingConfigurations() : true) {
            Iterator it = this.f2122l.values().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((androidx.fragment.app.c) it.next()).f2046a.iterator();
                while (it2.hasNext()) {
                    this.f2113c.p().h((String) it2.next(), false);
                }
            }
        }
    }

    public final ViewGroup t0(p pVar) {
        ViewGroup viewGroup = pVar.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (pVar.mContainerId > 0 && this.f2135y.d()) {
            View viewC = this.f2135y.c(pVar.mContainerId);
            if (viewC instanceof ViewGroup) {
                return (ViewGroup) viewC;
            }
        }
        return null;
    }

    public final void t1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new v0("FragmentManager"));
        a0 a0Var = this.f2134x;
        if (a0Var != null) {
            try {
                a0Var.i("  ", null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e10) {
                Log.e("FragmentManager", "Failed dumping state", e10);
                throw runtimeException;
            }
        }
        try {
            X("  ", null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e11) {
            Log.e("FragmentManager", "Failed dumping state", e11);
            throw runtimeException;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        p pVar = this.f2136z;
        if (pVar != null) {
            sb2.append(pVar.getClass().getSimpleName());
            sb2.append("{");
            sb2.append(Integer.toHexString(System.identityHashCode(this.f2136z)));
            sb2.append("}");
        } else {
            a0 a0Var = this.f2134x;
            if (a0Var != null) {
                sb2.append(a0Var.getClass().getSimpleName());
                sb2.append("{");
                sb2.append(Integer.toHexString(System.identityHashCode(this.f2134x)));
                sb2.append("}");
            } else {
                sb2.append("null");
            }
        }
        sb2.append("}}");
        return sb2.toString();
    }

    public final Set u() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f2113c.k().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((o0) it.next()).k().mContainer;
            if (viewGroup != null) {
                hashSet.add(y0.v(viewGroup, B0()));
            }
        }
        return hashSet;
    }

    public z u0() {
        z zVar = this.B;
        if (zVar != null) {
            return zVar;
        }
        p pVar = this.f2136z;
        return pVar != null ? pVar.mFragmentManager.u0() : this.C;
    }

    public final void u1() {
        synchronized (this.f2111a) {
            try {
                if (!this.f2111a.isEmpty()) {
                    this.f2120j.setEnabled(true);
                    if (J0(3)) {
                        Log.d("FragmentManager", "FragmentManager " + this + " enabling OnBackPressedCallback, caused by non-empty pending actions");
                    }
                    return;
                }
                boolean z10 = q0() > 0 && O0(this.f2136z);
                if (J0(3)) {
                    Log.d("FragmentManager", "OnBackPressedCallback for FragmentManager " + this + " enabled state is " + z10);
                }
                this.f2120j.setEnabled(z10);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Set v(ArrayList arrayList, int i10, int i11) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i10 < i11) {
            Iterator it = ((androidx.fragment.app.a) arrayList.get(i10)).f2270c.iterator();
            while (it.hasNext()) {
                p pVar = ((q0.a) it.next()).f2288b;
                if (pVar != null && (viewGroup = pVar.mContainer) != null) {
                    hashSet.add(y0.u(viewGroup, this));
                }
            }
            i10++;
        }
        return hashSet;
    }

    public List v0() {
        return this.f2113c.o();
    }

    public o0 w(p pVar) {
        o0 o0VarN = this.f2113c.n(pVar.mWho);
        if (o0VarN != null) {
            return o0VarN;
        }
        o0 o0Var = new o0(this.f2126p, this.f2113c, pVar);
        o0Var.o(this.f2134x.f().getClassLoader());
        o0Var.s(this.f2133w);
        return o0Var;
    }

    public a0 w0() {
        return this.f2134x;
    }

    public void x(p pVar) {
        if (J0(2)) {
            Log.v("FragmentManager", "detach: " + pVar);
        }
        if (pVar.mDetached) {
            return;
        }
        pVar.mDetached = true;
        if (pVar.mAdded) {
            if (J0(2)) {
                Log.v("FragmentManager", "remove from detach: " + pVar);
            }
            this.f2113c.u(pVar);
            if (K0(pVar)) {
                this.J = true;
            }
            q1(pVar);
        }
    }

    public LayoutInflater.Factory2 x0() {
        return this.f2116f;
    }

    public void y() {
        this.K = false;
        this.L = false;
        this.R.q(false);
        T(4);
    }

    public c0 y0() {
        return this.f2126p;
    }

    public void z() {
        this.K = false;
        this.L = false;
        this.R.q(false);
        T(0);
    }

    public p z0() {
        return this.f2136z;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class k implements Parcelable {
        public static final Parcelable.Creator<k> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2147a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2148b;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public k createFromParcel(Parcel parcel) {
                return new k(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public k[] newArray(int i10) {
                return new k[i10];
            }
        }

        public k(String str, int i10) {
            this.f2147a = str;
            this.f2148b = i10;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f2147a);
            parcel.writeInt(this.f2148b);
        }

        public k(Parcel parcel) {
            this.f2147a = parcel.readString();
            this.f2148b = parcel.readInt();
        }
    }
}
