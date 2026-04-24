package androidx.fragment.app;

import T.InterfaceC0930l;
import T.InterfaceC0935q;
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
import androidx.lifecycle.AbstractC1157i;
import e.C1656a;
import e.InterfaceC1657b;
import e.f;
import f.AbstractC1725a;
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
import l0.AbstractC2310b;
import m0.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class I {

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public static boolean f11541U = false;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public static boolean f11542V = true;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public AbstractComponentCallbacksC1139p f11543A;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public e.c f11548F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public e.c f11549G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public e.c f11550H;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f11552J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public boolean f11553K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public boolean f11554L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public boolean f11555M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public boolean f11556N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public ArrayList f11557O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public ArrayList f11558P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public ArrayList f11559Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public L f11560R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public c.C0355c f11561S;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11564b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f11567e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public androidx.activity.q f11569g;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public A f11586x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public AbstractC1145w f11587y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public AbstractComponentCallbacksC1139p f11588z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f11563a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final P f11565c = new P();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f11566d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final B f11568f = new B(this);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public C1124a f11570h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f11571i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.activity.p f11572j = new b(false);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicInteger f11573k = new AtomicInteger();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map f11574l = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map f11575m = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map f11576n = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList f11577o = new ArrayList();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final C f11578p = new C(this);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final CopyOnWriteArrayList f11579q = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final S.a f11580r = new S.a() { // from class: androidx.fragment.app.D
        @Override // S.a
        public final void accept(Object obj) {
            this.f11536a.S0((Configuration) obj);
        }
    };

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final S.a f11581s = new S.a() { // from class: androidx.fragment.app.E
        @Override // S.a
        public final void accept(Object obj) {
            this.f11537a.T0((Integer) obj);
        }
    };

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final S.a f11582t = new S.a() { // from class: androidx.fragment.app.F
        @Override // S.a
        public final void accept(Object obj) {
            this.f11538a.U0((H.g) obj);
        }
    };

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final S.a f11583u = new S.a() { // from class: androidx.fragment.app.G
        @Override // S.a
        public final void accept(Object obj) {
            this.f11539a.V0((H.s) obj);
        }
    };

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final InterfaceC0935q f11584v = new c();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f11585w = -1;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public AbstractC1148z f11544B = null;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public AbstractC1148z f11545C = new d();

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public a0 f11546D = null;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public a0 f11547E = new e();

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public ArrayDeque f11551I = new ArrayDeque();

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public Runnable f11562T = new f();

    public class a implements InterfaceC1657b {
        public a() {
        }

        @Override // e.InterfaceC1657b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Map map) {
            StringBuilder sb;
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i8 = 0; i8 < arrayList.size(); i8++) {
                iArr[i8] = ((Boolean) arrayList.get(i8)).booleanValue() ? 0 : -1;
            }
            k kVar = (k) I.this.f11551I.pollFirst();
            if (kVar == null) {
                sb = new StringBuilder();
                sb.append("No permissions were requested for ");
                sb.append(this);
            } else {
                String str = kVar.f11599a;
                int i9 = kVar.f11600b;
                AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139pI = I.this.f11565c.i(str);
                if (abstractComponentCallbacksC1139pI != null) {
                    abstractComponentCallbacksC1139pI.onRequestPermissionsResult(i9, strArr, iArr);
                    return;
                } else {
                    sb = new StringBuilder();
                    sb.append("Permission request result delivered for unknown Fragment ");
                    sb.append(str);
                }
            }
            Log.w("FragmentManager", sb.toString());
        }
    }

    public class b extends androidx.activity.p {
        public b(boolean z7) {
            super(z7);
        }

        @Override // androidx.activity.p
        public void handleOnBackCancelled() {
            if (I.J0(3)) {
                Log.d("FragmentManager", "handleOnBackCancelled. PREDICTIVE_BACK = " + I.f11542V + " fragment manager " + I.this);
            }
            if (I.f11542V) {
                I.this.p();
                I.this.f11570h = null;
            }
        }

        @Override // androidx.activity.p
        public void handleOnBackPressed() {
            if (I.J0(3)) {
                Log.d("FragmentManager", "handleOnBackPressed. PREDICTIVE_BACK = " + I.f11542V + " fragment manager " + I.this);
            }
            I.this.F0();
        }

        @Override // androidx.activity.p
        public void handleOnBackProgressed(androidx.activity.b bVar) {
            if (I.J0(2)) {
                Log.v("FragmentManager", "handleOnBackProgressed. PREDICTIVE_BACK = " + I.f11542V + " fragment manager " + I.this);
            }
            I i8 = I.this;
            if (i8.f11570h != null) {
                Iterator it = i8.v(new ArrayList(Collections.singletonList(I.this.f11570h)), 0, 1).iterator();
                while (it.hasNext()) {
                    ((Z) it.next()).y(bVar);
                }
                Iterator it2 = I.this.f11577o.iterator();
                if (it2.hasNext()) {
                    android.support.v4.media.session.b.a(it2.next());
                    throw null;
                }
            }
        }

        @Override // androidx.activity.p
        public void handleOnBackStarted(androidx.activity.b bVar) {
            if (I.J0(3)) {
                Log.d("FragmentManager", "handleOnBackStarted. PREDICTIVE_BACK = " + I.f11542V + " fragment manager " + I.this);
            }
            if (I.f11542V) {
                I.this.Y();
                I.this.j1();
            }
        }
    }

    public class c implements InterfaceC0935q {
        public c() {
        }

        @Override // T.InterfaceC0935q
        public boolean a(MenuItem menuItem) {
            return I.this.K(menuItem);
        }

        @Override // T.InterfaceC0935q
        public void b(Menu menu) {
            I.this.L(menu);
        }

        @Override // T.InterfaceC0935q
        public void c(Menu menu, MenuInflater menuInflater) {
            I.this.D(menu, menuInflater);
        }

        @Override // T.InterfaceC0935q
        public void d(Menu menu) {
            I.this.P(menu);
        }
    }

    public class d extends AbstractC1148z {
        public d() {
        }

        @Override // androidx.fragment.app.AbstractC1148z
        public AbstractComponentCallbacksC1139p a(ClassLoader classLoader, String str) {
            return I.this.w0().b(I.this.w0().f(), str, null);
        }
    }

    public class e implements a0 {
        public e() {
        }

        @Override // androidx.fragment.app.a0
        public Z a(ViewGroup viewGroup) {
            return new C1129f(viewGroup);
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
        public final /* synthetic */ AbstractComponentCallbacksC1139p f11595a;

        public g(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
            this.f11595a = abstractComponentCallbacksC1139p;
        }

        @Override // androidx.fragment.app.M
        public void a(I i8, AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
            this.f11595a.onAttachFragment(abstractComponentCallbacksC1139p);
        }
    }

    public class h implements InterfaceC1657b {
        public h() {
        }

        @Override // e.InterfaceC1657b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C1656a c1656a) {
            k kVar = (k) I.this.f11551I.pollLast();
            if (kVar == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = kVar.f11599a;
            int i8 = kVar.f11600b;
            AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139pI = I.this.f11565c.i(str);
            if (abstractComponentCallbacksC1139pI != null) {
                abstractComponentCallbacksC1139pI.onActivityResult(i8, c1656a.b(), c1656a.a());
                return;
            }
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }
    }

    public class i implements InterfaceC1657b {
        public i() {
        }

        @Override // e.InterfaceC1657b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C1656a c1656a) {
            k kVar = (k) I.this.f11551I.pollFirst();
            if (kVar == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = kVar.f11599a;
            int i8 = kVar.f11600b;
            AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139pI = I.this.f11565c.i(str);
            if (abstractComponentCallbacksC1139pI != null) {
                abstractComponentCallbacksC1139pI.onActivityResult(i8, c1656a.b(), c1656a.a());
                return;
            }
            Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
        }
    }

    public static class j extends AbstractC1725a {
        @Override // f.AbstractC1725a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(Context context, e.f fVar) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent intentA = fVar.a();
            if (intentA != null && (bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (intentA.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    fVar = new f.a(fVar.d()).b(null).c(fVar.c(), fVar.b()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", fVar);
            if (I.J0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // f.AbstractC1725a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public C1656a c(int i8, Intent intent) {
            return new C1656a(i8, intent);
        }
    }

    public static class k implements Parcelable {
        public static final Parcelable.Creator<k> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f11600b;

        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public k createFromParcel(Parcel parcel) {
                return new k(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public k[] newArray(int i8) {
                return new k[i8];
            }
        }

        public k(Parcel parcel) {
            this.f11599a = parcel.readString();
            this.f11600b = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i8) {
            parcel.writeString(this.f11599a);
            parcel.writeInt(this.f11600b);
        }

        public k(String str, int i8) {
            this.f11599a = str;
            this.f11600b = i8;
        }
    }

    public interface l {
        boolean a(ArrayList arrayList, ArrayList arrayList2);
    }

    public class m implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f11601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f11602b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f11603c;

        public m(String str, int i8, int i9) {
            this.f11601a = str;
            this.f11602b = i8;
            this.f11603c = i9;
        }

        @Override // androidx.fragment.app.I.l
        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p = I.this.f11543A;
            if (abstractComponentCallbacksC1139p == null || this.f11602b >= 0 || this.f11601a != null || !abstractComponentCallbacksC1139p.getChildFragmentManager().e1()) {
                return I.this.h1(arrayList, arrayList2, this.f11601a, this.f11602b, this.f11603c);
            }
            return false;
        }
    }

    public class n implements l {
        public n() {
        }

        @Override // androidx.fragment.app.I.l
        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            boolean zI1 = I.this.i1(arrayList, arrayList2);
            I i8 = I.this;
            i8.f11571i = true;
            if (!i8.f11577o.isEmpty() && arrayList.size() > 0) {
                ((Boolean) arrayList2.get(arrayList.size() - 1)).booleanValue();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    linkedHashSet.addAll(I.this.o0((C1124a) it.next()));
                }
                Iterator it2 = I.this.f11577o.iterator();
                while (it2.hasNext()) {
                    android.support.v4.media.session.b.a(it2.next());
                    Iterator it3 = linkedHashSet.iterator();
                    if (it3.hasNext()) {
                        throw null;
                    }
                }
            }
            return zI1;
        }
    }

    public static AbstractComponentCallbacksC1139p D0(View view) {
        Object tag = view.getTag(AbstractC2310b.f20509a);
        if (tag instanceof AbstractComponentCallbacksC1139p) {
            return (AbstractComponentCallbacksC1139p) tag;
        }
        return null;
    }

    public static boolean J0(int i8) {
        return f11541U || Log.isLoggable("FragmentManager", i8);
    }

    public static void d0(ArrayList arrayList, ArrayList arrayList2, int i8, int i9) {
        while (i8 < i9) {
            C1124a c1124a = (C1124a) arrayList.get(i8);
            if (((Boolean) arrayList2.get(i8)).booleanValue()) {
                c1124a.n(-1);
                c1124a.s();
            } else {
                c1124a.n(1);
                c1124a.r();
            }
            i8++;
        }
    }

    public static I l0(View view) {
        AbstractActivityC1143u abstractActivityC1143u;
        AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139pM0 = m0(view);
        if (abstractComponentCallbacksC1139pM0 != null) {
            if (abstractComponentCallbacksC1139pM0.isAdded()) {
                return abstractComponentCallbacksC1139pM0.getChildFragmentManager();
            }
            throw new IllegalStateException("The Fragment " + abstractComponentCallbacksC1139pM0 + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        Context context = view.getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                abstractActivityC1143u = null;
                break;
            }
            if (context instanceof AbstractActivityC1143u) {
                abstractActivityC1143u = (AbstractActivityC1143u) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (abstractActivityC1143u != null) {
            return abstractActivityC1143u.getSupportFragmentManager();
        }
        throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
    }

    public static AbstractComponentCallbacksC1139p m0(View view) {
        while (view != null) {
            AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139pD0 = D0(view);
            if (abstractComponentCallbacksC1139pD0 != null) {
                return abstractComponentCallbacksC1139pD0;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    public static int p1(int i8) {
        int i9 = 4097;
        if (i8 == 4097) {
            return 8194;
        }
        if (i8 != 8194) {
            i9 = 8197;
            if (i8 == 8197) {
                return 4100;
            }
            if (i8 == 4099) {
                return 4099;
            }
            if (i8 != 4100) {
                return 0;
            }
        }
        return i9;
    }

    public void A(Configuration configuration, boolean z7) {
        if (z7 && (this.f11586x instanceof I.c)) {
            y1(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p : this.f11565c.o()) {
            if (abstractComponentCallbacksC1139p != null) {
                abstractComponentCallbacksC1139p.performConfigurationChanged(configuration);
                if (z7) {
                    abstractComponentCallbacksC1139p.mChildFragmentManager.A(configuration, true);
                }
            }
        }
    }

    public AbstractComponentCallbacksC1139p A0() {
        return this.f11543A;
    }

    public boolean B(MenuItem menuItem) {
        if (this.f11585w < 1) {
            return false;
        }
        for (AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p : this.f11565c.o()) {
            if (abstractComponentCallbacksC1139p != null && abstractComponentCallbacksC1139p.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public a0 B0() {
        a0 a0Var = this.f11546D;
        if (a0Var != null) {
            return a0Var;
        }
        AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p = this.f11588z;
        return abstractComponentCallbacksC1139p != null ? abstractComponentCallbacksC1139p.mFragmentManager.B0() : this.f11547E;
    }

    public void C() {
        this.f11553K = false;
        this.f11554L = false;
        this.f11560R.q(false);
        T(1);
    }

    public c.C0355c C0() {
        return this.f11561S;
    }

    public boolean D(Menu menu, MenuInflater menuInflater) {
        if (this.f11585w < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z7 = false;
        for (AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p : this.f11565c.o()) {
            if (abstractComponentCallbacksC1139p != null && N0(abstractComponentCallbacksC1139p) && abstractComponentCallbacksC1139p.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(abstractComponentCallbacksC1139p);
                z7 = true;
            }
        }
        if (this.f11567e != null) {
            for (int i8 = 0; i8 < this.f11567e.size(); i8++) {
                AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p2 = (AbstractComponentCallbacksC1139p) this.f11567e.get(i8);
                if (arrayList == null || !arrayList.contains(abstractComponentCallbacksC1139p2)) {
                    abstractComponentCallbacksC1139p2.onDestroyOptionsMenu();
                }
            }
        }
        this.f11567e = arrayList;
        return z7;
    }

    public void E() {
        this.f11555M = true;
        b0(true);
        Y();
        t();
        T(-1);
        Object obj = this.f11586x;
        if (obj instanceof I.d) {
            ((I.d) obj).removeOnTrimMemoryListener(this.f11581s);
        }
        Object obj2 = this.f11586x;
        if (obj2 instanceof I.c) {
            ((I.c) obj2).removeOnConfigurationChangedListener(this.f11580r);
        }
        Object obj3 = this.f11586x;
        if (obj3 instanceof H.o) {
            ((H.o) obj3).removeOnMultiWindowModeChangedListener(this.f11582t);
        }
        Object obj4 = this.f11586x;
        if (obj4 instanceof H.p) {
            ((H.p) obj4).removeOnPictureInPictureModeChangedListener(this.f11583u);
        }
        Object obj5 = this.f11586x;
        if ((obj5 instanceof InterfaceC0930l) && this.f11588z == null) {
            ((InterfaceC0930l) obj5).removeMenuProvider(this.f11584v);
        }
        this.f11586x = null;
        this.f11587y = null;
        this.f11588z = null;
        if (this.f11569g != null) {
            this.f11572j.remove();
            this.f11569g = null;
        }
        e.c cVar = this.f11548F;
        if (cVar != null) {
            cVar.c();
            this.f11549G.c();
            this.f11550H.c();
        }
    }

    public androidx.lifecycle.M E0(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
        return this.f11560R.n(abstractComponentCallbacksC1139p);
    }

    public void F() {
        T(1);
    }

    public void F0() {
        b0(true);
        if (!f11542V || this.f11570h == null) {
            if (this.f11572j.isEnabled()) {
                if (J0(3)) {
                    Log.d("FragmentManager", "Calling popBackStackImmediate via onBackPressed callback");
                }
                e1();
                return;
            } else {
                if (J0(3)) {
                    Log.d("FragmentManager", "Calling onBackPressed via onBackPressed callback");
                }
                this.f11569g.k();
                return;
            }
        }
        if (!this.f11577o.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(o0(this.f11570h));
            Iterator it = this.f11577o.iterator();
            while (it.hasNext()) {
                android.support.v4.media.session.b.a(it.next());
                Iterator it2 = linkedHashSet.iterator();
                if (it2.hasNext()) {
                    throw null;
                }
            }
        }
        Iterator it3 = this.f11570h.f11650c.iterator();
        while (it3.hasNext()) {
            AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p = ((Q.a) it3.next()).f11668b;
            if (abstractComponentCallbacksC1139p != null) {
                abstractComponentCallbacksC1139p.mTransitioning = false;
            }
        }
        Iterator it4 = v(new ArrayList(Collections.singletonList(this.f11570h)), 0, 1).iterator();
        while (it4.hasNext()) {
            ((Z) it4.next()).f();
        }
        this.f11570h = null;
        z1();
        if (J0(3)) {
            Log.d("FragmentManager", "Op is being set to null");
            Log.d("FragmentManager", "OnBackPressedCallback enabled=" + this.f11572j.isEnabled() + " for  FragmentManager " + this);
        }
    }

    public void G(boolean z7) {
        if (z7 && (this.f11586x instanceof I.d)) {
            y1(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p : this.f11565c.o()) {
            if (abstractComponentCallbacksC1139p != null) {
                abstractComponentCallbacksC1139p.performLowMemory();
                if (z7) {
                    abstractComponentCallbacksC1139p.mChildFragmentManager.G(true);
                }
            }
        }
    }

    public void G0(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
        if (J0(2)) {
            Log.v("FragmentManager", "hide: " + abstractComponentCallbacksC1139p);
        }
        if (abstractComponentCallbacksC1139p.mHidden) {
            return;
        }
        abstractComponentCallbacksC1139p.mHidden = true;
        abstractComponentCallbacksC1139p.mHiddenChanged = true ^ abstractComponentCallbacksC1139p.mHiddenChanged;
        v1(abstractComponentCallbacksC1139p);
    }

    public void H(boolean z7, boolean z8) {
        if (z8 && (this.f11586x instanceof H.o)) {
            y1(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p : this.f11565c.o()) {
            if (abstractComponentCallbacksC1139p != null) {
                abstractComponentCallbacksC1139p.performMultiWindowModeChanged(z7);
                if (z8) {
                    abstractComponentCallbacksC1139p.mChildFragmentManager.H(z7, true);
                }
            }
        }
    }

    public void H0(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
        if (abstractComponentCallbacksC1139p.mAdded && K0(abstractComponentCallbacksC1139p)) {
            this.f11552J = true;
        }
    }

    public void I(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
        Iterator it = this.f11579q.iterator();
        while (it.hasNext()) {
            ((M) it.next()).a(this, abstractComponentCallbacksC1139p);
        }
    }

    public boolean I0() {
        return this.f11555M;
    }

    public void J() {
        for (AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p : this.f11565c.l()) {
            if (abstractComponentCallbacksC1139p != null) {
                abstractComponentCallbacksC1139p.onHiddenChanged(abstractComponentCallbacksC1139p.isHidden());
                abstractComponentCallbacksC1139p.mChildFragmentManager.J();
            }
        }
    }

    public boolean K(MenuItem menuItem) {
        if (this.f11585w < 1) {
            return false;
        }
        for (AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p : this.f11565c.o()) {
            if (abstractComponentCallbacksC1139p != null && abstractComponentCallbacksC1139p.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final boolean K0(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
        return (abstractComponentCallbacksC1139p.mHasMenu && abstractComponentCallbacksC1139p.mMenuVisible) || abstractComponentCallbacksC1139p.mChildFragmentManager.q();
    }

    public void L(Menu menu) {
        if (this.f11585w < 1) {
            return;
        }
        for (AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p : this.f11565c.o()) {
            if (abstractComponentCallbacksC1139p != null) {
                abstractComponentCallbacksC1139p.performOptionsMenuClosed(menu);
            }
        }
    }

    public final boolean L0() {
        AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p = this.f11588z;
        if (abstractComponentCallbacksC1139p == null) {
            return true;
        }
        return abstractComponentCallbacksC1139p.isAdded() && this.f11588z.getParentFragmentManager().L0();
    }

    public final void M(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
        if (abstractComponentCallbacksC1139p == null || !abstractComponentCallbacksC1139p.equals(g0(abstractComponentCallbacksC1139p.mWho))) {
            return;
        }
        abstractComponentCallbacksC1139p.performPrimaryNavigationFragmentChanged();
    }

    public boolean M0(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
        if (abstractComponentCallbacksC1139p == null) {
            return false;
        }
        return abstractComponentCallbacksC1139p.isHidden();
    }

    public void N() {
        T(5);
    }

    public boolean N0(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
        if (abstractComponentCallbacksC1139p == null) {
            return true;
        }
        return abstractComponentCallbacksC1139p.isMenuVisible();
    }

    public void O(boolean z7, boolean z8) {
        if (z8 && (this.f11586x instanceof H.p)) {
            y1(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p : this.f11565c.o()) {
            if (abstractComponentCallbacksC1139p != null) {
                abstractComponentCallbacksC1139p.performPictureInPictureModeChanged(z7);
                if (z8) {
                    abstractComponentCallbacksC1139p.mChildFragmentManager.O(z7, true);
                }
            }
        }
    }

    public boolean O0(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
        if (abstractComponentCallbacksC1139p == null) {
            return true;
        }
        I i8 = abstractComponentCallbacksC1139p.mFragmentManager;
        return abstractComponentCallbacksC1139p.equals(i8.A0()) && O0(i8.f11588z);
    }

    public boolean P(Menu menu) {
        boolean z7 = false;
        if (this.f11585w < 1) {
            return false;
        }
        for (AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p : this.f11565c.o()) {
            if (abstractComponentCallbacksC1139p != null && N0(abstractComponentCallbacksC1139p) && abstractComponentCallbacksC1139p.performPrepareOptionsMenu(menu)) {
                z7 = true;
            }
        }
        return z7;
    }

    public boolean P0(int i8) {
        return this.f11585w >= i8;
    }

    public void Q() {
        z1();
        M(this.f11543A);
    }

    public boolean Q0() {
        return this.f11553K || this.f11554L;
    }

    public void R() {
        this.f11553K = false;
        this.f11554L = false;
        this.f11560R.q(false);
        T(7);
    }

    public void S() {
        this.f11553K = false;
        this.f11554L = false;
        this.f11560R.q(false);
        T(5);
    }

    public final /* synthetic */ void S0(Configuration configuration) {
        if (L0()) {
            A(configuration, false);
        }
    }

    public final void T(int i8) {
        try {
            this.f11564b = true;
            this.f11565c.d(i8);
            Z0(i8, false);
            Iterator it = u().iterator();
            while (it.hasNext()) {
                ((Z) it.next()).q();
            }
            this.f11564b = false;
            b0(true);
        } catch (Throwable th) {
            this.f11564b = false;
            throw th;
        }
    }

    public final /* synthetic */ void T0(Integer num) {
        if (L0() && num.intValue() == 80) {
            G(false);
        }
    }

    public void U() {
        this.f11554L = true;
        this.f11560R.q(true);
        T(4);
    }

    public final /* synthetic */ void U0(H.g gVar) {
        if (L0()) {
            H(gVar.a(), false);
        }
    }

    public void V() {
        T(2);
    }

    public final /* synthetic */ void V0(H.s sVar) {
        if (L0()) {
            O(sVar.a(), false);
        }
    }

    public final void W() {
        if (this.f11556N) {
            this.f11556N = false;
            x1();
        }
    }

    public void W0(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p, String[] strArr, int i8) {
        if (this.f11550H == null) {
            this.f11586x.l(abstractComponentCallbacksC1139p, strArr, i8);
            return;
        }
        this.f11551I.addLast(new k(abstractComponentCallbacksC1139p.mWho, i8));
        this.f11550H.a(strArr);
    }

    public void X(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        String str2 = str + "    ";
        this.f11565c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList arrayList = this.f11567e;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i8 = 0; i8 < size; i8++) {
                AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p = (AbstractComponentCallbacksC1139p) this.f11567e.get(i8);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i8);
                printWriter.print(": ");
                printWriter.println(abstractComponentCallbacksC1139p.toString());
            }
        }
        int size2 = this.f11566d.size();
        if (size2 > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i9 = 0; i9 < size2; i9++) {
                C1124a c1124a = (C1124a) this.f11566d.get(i9);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i9);
                printWriter.print(": ");
                printWriter.println(c1124a.toString());
                c1124a.p(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f11573k.get());
        synchronized (this.f11563a) {
            try {
                int size3 = this.f11563a.size();
                if (size3 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i10 = 0; i10 < size3; i10++) {
                        l lVar = (l) this.f11563a.get(i10);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i10);
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
        printWriter.println(this.f11586x);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f11587y);
        if (this.f11588z != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f11588z);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f11585w);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f11553K);
        printWriter.print(" mStopped=");
        printWriter.print(this.f11554L);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f11555M);
        if (this.f11552J) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f11552J);
        }
    }

    public void X0(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p, Intent intent, int i8, Bundle bundle) {
        if (this.f11548F == null) {
            this.f11586x.n(abstractComponentCallbacksC1139p, intent, i8, bundle);
            return;
        }
        this.f11551I.addLast(new k(abstractComponentCallbacksC1139p.mWho, i8));
        if (bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        this.f11548F.a(intent);
    }

    public final void Y() {
        Iterator it = u().iterator();
        while (it.hasNext()) {
            ((Z) it.next()).q();
        }
    }

    public void Y0(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p, IntentSender intentSender, int i8, Intent intent, int i9, int i10, int i11, Bundle bundle) {
        Intent intent2;
        if (this.f11549G == null) {
            this.f11586x.o(abstractComponentCallbacksC1139p, intentSender, i8, intent, i9, i10, i11, bundle);
            return;
        }
        if (bundle != null) {
            if (intent == null) {
                intent2 = new Intent();
                intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            } else {
                intent2 = intent;
            }
            if (J0(2)) {
                Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent2 + " for fragment " + abstractComponentCallbacksC1139p);
            }
            intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        } else {
            intent2 = intent;
        }
        e.f fVarA = new f.a(intentSender).b(intent2).c(i10, i9).a();
        this.f11551I.addLast(new k(abstractComponentCallbacksC1139p.mWho, i8));
        if (J0(2)) {
            Log.v("FragmentManager", "Fragment " + abstractComponentCallbacksC1139p + "is launching an IntentSender for result ");
        }
        this.f11549G.a(fVarA);
    }

    public void Z(l lVar, boolean z7) {
        if (!z7) {
            if (this.f11586x == null) {
                if (!this.f11555M) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            r();
        }
        synchronized (this.f11563a) {
            try {
                if (this.f11586x == null) {
                    if (!z7) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f11563a.add(lVar);
                    r1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void Z0(int i8, boolean z7) {
        A a8;
        if (this.f11586x == null && i8 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z7 || i8 != this.f11585w) {
            this.f11585w = i8;
            this.f11565c.t();
            x1();
            if (this.f11552J && (a8 = this.f11586x) != null && this.f11585w == 7) {
                a8.p();
                this.f11552J = false;
            }
        }
    }

    public final void a0(boolean z7) {
        if (this.f11564b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f11586x == null) {
            if (!this.f11555M) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f11586x.h().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z7) {
            r();
        }
        if (this.f11557O == null) {
            this.f11557O = new ArrayList();
            this.f11558P = new ArrayList();
        }
    }

    public void a1() {
        if (this.f11586x == null) {
            return;
        }
        this.f11553K = false;
        this.f11554L = false;
        this.f11560R.q(false);
        for (AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p : this.f11565c.o()) {
            if (abstractComponentCallbacksC1139p != null) {
                abstractComponentCallbacksC1139p.noteStateNotSaved();
            }
        }
    }

    public boolean b0(boolean z7) {
        a0(z7);
        boolean z8 = false;
        while (p0(this.f11557O, this.f11558P)) {
            z8 = true;
            this.f11564b = true;
            try {
                l1(this.f11557O, this.f11558P);
            } finally {
                s();
            }
        }
        z1();
        W();
        this.f11565c.b();
        return z8;
    }

    public void b1(C1146x c1146x) {
        View view;
        for (O o8 : this.f11565c.k()) {
            AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139pK = o8.k();
            if (abstractComponentCallbacksC1139pK.mContainerId == c1146x.getId() && (view = abstractComponentCallbacksC1139pK.mView) != null && view.getParent() == null) {
                abstractComponentCallbacksC1139pK.mContainer = c1146x;
                o8.b();
            }
        }
    }

    public void c0(l lVar, boolean z7) {
        if (z7 && (this.f11586x == null || this.f11555M)) {
            return;
        }
        a0(z7);
        if (lVar.a(this.f11557O, this.f11558P)) {
            this.f11564b = true;
            try {
                l1(this.f11557O, this.f11558P);
            } finally {
                s();
            }
        }
        z1();
        W();
        this.f11565c.b();
    }

    public void c1(O o8) {
        AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139pK = o8.k();
        if (abstractComponentCallbacksC1139pK.mDeferStart) {
            if (this.f11564b) {
                this.f11556N = true;
            } else {
                abstractComponentCallbacksC1139pK.mDeferStart = false;
                o8.m();
            }
        }
    }

    public void d1(int i8, int i9, boolean z7) {
        if (i8 >= 0) {
            Z(new m(null, i8, i9), z7);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i8);
    }

    public final void e0(ArrayList arrayList, ArrayList arrayList2, int i8, int i9) {
        boolean z7 = ((C1124a) arrayList.get(i8)).f11665r;
        ArrayList arrayList3 = this.f11559Q;
        if (arrayList3 == null) {
            this.f11559Q = new ArrayList();
        } else {
            arrayList3.clear();
        }
        this.f11559Q.addAll(this.f11565c.o());
        AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139pA0 = A0();
        boolean z8 = false;
        for (int i10 = i8; i10 < i9; i10++) {
            C1124a c1124a = (C1124a) arrayList.get(i10);
            abstractComponentCallbacksC1139pA0 = !((Boolean) arrayList2.get(i10)).booleanValue() ? c1124a.t(this.f11559Q, abstractComponentCallbacksC1139pA0) : c1124a.w(this.f11559Q, abstractComponentCallbacksC1139pA0);
            z8 = z8 || c1124a.f11656i;
        }
        this.f11559Q.clear();
        if (!z7 && this.f11585w >= 1) {
            for (int i11 = i8; i11 < i9; i11++) {
                Iterator it = ((C1124a) arrayList.get(i11)).f11650c.iterator();
                while (it.hasNext()) {
                    AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p = ((Q.a) it.next()).f11668b;
                    if (abstractComponentCallbacksC1139p != null && abstractComponentCallbacksC1139p.mFragmentManager != null) {
                        this.f11565c.r(w(abstractComponentCallbacksC1139p));
                    }
                }
            }
        }
        d0(arrayList, arrayList2, i8, i9);
        boolean zBooleanValue = ((Boolean) arrayList2.get(i9 - 1)).booleanValue();
        if (z8 && !this.f11577o.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                linkedHashSet.addAll(o0((C1124a) it2.next()));
            }
            if (this.f11570h == null) {
                Iterator it3 = this.f11577o.iterator();
                while (it3.hasNext()) {
                    android.support.v4.media.session.b.a(it3.next());
                    Iterator it4 = linkedHashSet.iterator();
                    if (it4.hasNext()) {
                        throw null;
                    }
                }
                Iterator it5 = this.f11577o.iterator();
                while (it5.hasNext()) {
                    android.support.v4.media.session.b.a(it5.next());
                    Iterator it6 = linkedHashSet.iterator();
                    if (it6.hasNext()) {
                        throw null;
                    }
                }
            }
        }
        for (int i12 = i8; i12 < i9; i12++) {
            C1124a c1124a2 = (C1124a) arrayList.get(i12);
            if (zBooleanValue) {
                for (int size = c1124a2.f11650c.size() - 1; size >= 0; size--) {
                    AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p2 = ((Q.a) c1124a2.f11650c.get(size)).f11668b;
                    if (abstractComponentCallbacksC1139p2 != null) {
                        w(abstractComponentCallbacksC1139p2).m();
                    }
                }
            } else {
                Iterator it7 = c1124a2.f11650c.iterator();
                while (it7.hasNext()) {
                    AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p3 = ((Q.a) it7.next()).f11668b;
                    if (abstractComponentCallbacksC1139p3 != null) {
                        w(abstractComponentCallbacksC1139p3).m();
                    }
                }
            }
        }
        Z0(this.f11585w, true);
        for (Z z9 : v(arrayList, i8, i9)) {
            z9.B(zBooleanValue);
            z9.x();
            z9.n();
        }
        while (i8 < i9) {
            C1124a c1124a3 = (C1124a) arrayList.get(i8);
            if (((Boolean) arrayList2.get(i8)).booleanValue() && c1124a3.f11748v >= 0) {
                c1124a3.f11748v = -1;
            }
            c1124a3.v();
            i8++;
        }
        if (z8) {
            n1();
        }
    }

    public boolean e1() {
        return g1(null, -1, 0);
    }

    public boolean f0() {
        boolean zB0 = b0(true);
        n0();
        return zB0;
    }

    public boolean f1(int i8, int i9) {
        if (i8 >= 0) {
            return g1(null, i8, i9);
        }
        throw new IllegalArgumentException("Bad id: " + i8);
    }

    public AbstractComponentCallbacksC1139p g0(String str) {
        return this.f11565c.f(str);
    }

    public final boolean g1(String str, int i8, int i9) {
        b0(false);
        a0(true);
        AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p = this.f11543A;
        if (abstractComponentCallbacksC1139p != null && i8 < 0 && str == null && abstractComponentCallbacksC1139p.getChildFragmentManager().e1()) {
            return true;
        }
        boolean zH1 = h1(this.f11557O, this.f11558P, str, i8, i9);
        if (zH1) {
            this.f11564b = true;
            try {
                l1(this.f11557O, this.f11558P);
            } finally {
                s();
            }
        }
        z1();
        W();
        this.f11565c.b();
        return zH1;
    }

    public void h(C1124a c1124a) {
        this.f11566d.add(c1124a);
    }

    public final int h0(String str, int i8, boolean z7) {
        if (this.f11566d.isEmpty()) {
            return -1;
        }
        if (str == null && i8 < 0) {
            if (z7) {
                return 0;
            }
            return this.f11566d.size() - 1;
        }
        int size = this.f11566d.size() - 1;
        while (size >= 0) {
            C1124a c1124a = (C1124a) this.f11566d.get(size);
            if ((str != null && str.equals(c1124a.u())) || (i8 >= 0 && i8 == c1124a.f11748v)) {
                break;
            }
            size--;
        }
        if (size < 0) {
            return size;
        }
        if (!z7) {
            if (size == this.f11566d.size() - 1) {
                return -1;
            }
            return size + 1;
        }
        while (size > 0) {
            C1124a c1124a2 = (C1124a) this.f11566d.get(size - 1);
            if ((str == null || !str.equals(c1124a2.u())) && (i8 < 0 || i8 != c1124a2.f11748v)) {
                return size;
            }
            size--;
        }
        return size;
    }

    public boolean h1(ArrayList arrayList, ArrayList arrayList2, String str, int i8, int i9) {
        int iH0 = h0(str, i8, (i9 & 1) != 0);
        if (iH0 < 0) {
            return false;
        }
        for (int size = this.f11566d.size() - 1; size >= iH0; size--) {
            arrayList.add((C1124a) this.f11566d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public O i(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
        String str = abstractComponentCallbacksC1139p.mPreviousWho;
        if (str != null) {
            m0.c.f(abstractComponentCallbacksC1139p, str);
        }
        if (J0(2)) {
            Log.v("FragmentManager", "add: " + abstractComponentCallbacksC1139p);
        }
        O oW = w(abstractComponentCallbacksC1139p);
        abstractComponentCallbacksC1139p.mFragmentManager = this;
        this.f11565c.r(oW);
        if (!abstractComponentCallbacksC1139p.mDetached) {
            this.f11565c.a(abstractComponentCallbacksC1139p);
            abstractComponentCallbacksC1139p.mRemoving = false;
            if (abstractComponentCallbacksC1139p.mView == null) {
                abstractComponentCallbacksC1139p.mHiddenChanged = false;
            }
            if (K0(abstractComponentCallbacksC1139p)) {
                this.f11552J = true;
            }
        }
        return oW;
    }

    public AbstractComponentCallbacksC1139p i0(int i8) {
        return this.f11565c.g(i8);
    }

    public boolean i1(ArrayList arrayList, ArrayList arrayList2) {
        ArrayList arrayList3 = this.f11566d;
        C1124a c1124a = (C1124a) arrayList3.get(arrayList3.size() - 1);
        this.f11570h = c1124a;
        Iterator it = c1124a.f11650c.iterator();
        while (it.hasNext()) {
            AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p = ((Q.a) it.next()).f11668b;
            if (abstractComponentCallbacksC1139p != null) {
                abstractComponentCallbacksC1139p.mTransitioning = true;
            }
        }
        return h1(arrayList, arrayList2, null, -1, 0);
    }

    public void j(M m8) {
        this.f11579q.add(m8);
    }

    public AbstractComponentCallbacksC1139p j0(String str) {
        return this.f11565c.h(str);
    }

    public void j1() {
        Z(new n(), false);
    }

    public void k(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
        this.f11560R.f(abstractComponentCallbacksC1139p);
    }

    public AbstractComponentCallbacksC1139p k0(String str) {
        return this.f11565c.i(str);
    }

    public void k1(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
        if (J0(2)) {
            Log.v("FragmentManager", "remove: " + abstractComponentCallbacksC1139p + " nesting=" + abstractComponentCallbacksC1139p.mBackStackNesting);
        }
        boolean z7 = !abstractComponentCallbacksC1139p.isInBackStack();
        if (!abstractComponentCallbacksC1139p.mDetached || z7) {
            this.f11565c.u(abstractComponentCallbacksC1139p);
            if (K0(abstractComponentCallbacksC1139p)) {
                this.f11552J = true;
            }
            abstractComponentCallbacksC1139p.mRemoving = true;
            v1(abstractComponentCallbacksC1139p);
        }
    }

    public int l() {
        return this.f11573k.getAndIncrement();
    }

    public final void l1(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i8 = 0;
        int i9 = 0;
        while (i8 < size) {
            if (!((C1124a) arrayList.get(i8)).f11665r) {
                if (i9 != i8) {
                    e0(arrayList, arrayList2, i9, i8);
                }
                i9 = i8 + 1;
                if (((Boolean) arrayList2.get(i8)).booleanValue()) {
                    while (i9 < size && ((Boolean) arrayList2.get(i9)).booleanValue() && !((C1124a) arrayList.get(i9)).f11665r) {
                        i9++;
                    }
                }
                e0(arrayList, arrayList2, i8, i9);
                i8 = i9 - 1;
            }
            i8++;
        }
        if (i9 != size) {
            e0(arrayList, arrayList2, i9, size);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m(androidx.fragment.app.A r4, androidx.fragment.app.AbstractC1145w r5, androidx.fragment.app.AbstractComponentCallbacksC1139p r6) {
        /*
            Method dump skipped, instruction units count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.I.m(androidx.fragment.app.A, androidx.fragment.app.w, androidx.fragment.app.p):void");
    }

    public void m1(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
        this.f11560R.p(abstractComponentCallbacksC1139p);
    }

    public void n(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
        if (J0(2)) {
            Log.v("FragmentManager", "attach: " + abstractComponentCallbacksC1139p);
        }
        if (abstractComponentCallbacksC1139p.mDetached) {
            abstractComponentCallbacksC1139p.mDetached = false;
            if (abstractComponentCallbacksC1139p.mAdded) {
                return;
            }
            this.f11565c.a(abstractComponentCallbacksC1139p);
            if (J0(2)) {
                Log.v("FragmentManager", "add from attach: " + abstractComponentCallbacksC1139p);
            }
            if (K0(abstractComponentCallbacksC1139p)) {
                this.f11552J = true;
            }
        }
    }

    public final void n0() {
        Iterator it = u().iterator();
        while (it.hasNext()) {
            ((Z) it.next()).r();
        }
    }

    public final void n1() {
        if (this.f11577o.size() <= 0) {
            return;
        }
        android.support.v4.media.session.b.a(this.f11577o.get(0));
        throw null;
    }

    public Q o() {
        return new C1124a(this);
    }

    public Set o0(C1124a c1124a) {
        HashSet hashSet = new HashSet();
        for (int i8 = 0; i8 < c1124a.f11650c.size(); i8++) {
            AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p = ((Q.a) c1124a.f11650c.get(i8)).f11668b;
            if (abstractComponentCallbacksC1139p != null && c1124a.f11656i) {
                hashSet.add(abstractComponentCallbacksC1139p);
            }
        }
        return hashSet;
    }

    public void o1(Parcelable parcelable) {
        O o8;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable == null) {
            return;
        }
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.f11586x.f().getClassLoader());
                this.f11575m.put(str.substring(7), bundle2);
            }
        }
        HashMap map = new HashMap();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.f11586x.f().getClassLoader());
                map.put(str2.substring(9), bundle);
            }
        }
        this.f11565c.x(map);
        K k8 = (K) bundle3.getParcelable("state");
        if (k8 == null) {
            return;
        }
        this.f11565c.v();
        Iterator it = k8.f11606a.iterator();
        while (it.hasNext()) {
            Bundle bundleB = this.f11565c.B((String) it.next(), null);
            if (bundleB != null) {
                AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139pJ = this.f11560R.j(((N) bundleB.getParcelable("state")).f11623b);
                if (abstractComponentCallbacksC1139pJ != null) {
                    if (J0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + abstractComponentCallbacksC1139pJ);
                    }
                    o8 = new O(this.f11578p, this.f11565c, abstractComponentCallbacksC1139pJ, bundleB);
                } else {
                    o8 = new O(this.f11578p, this.f11565c, this.f11586x.f().getClassLoader(), u0(), bundleB);
                }
                AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139pK = o8.k();
                abstractComponentCallbacksC1139pK.mSavedFragmentState = bundleB;
                abstractComponentCallbacksC1139pK.mFragmentManager = this;
                if (J0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + abstractComponentCallbacksC1139pK.mWho + "): " + abstractComponentCallbacksC1139pK);
                }
                o8.o(this.f11586x.f().getClassLoader());
                this.f11565c.r(o8);
                o8.s(this.f11585w);
            }
        }
        for (AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p : this.f11560R.m()) {
            if (!this.f11565c.c(abstractComponentCallbacksC1139p.mWho)) {
                if (J0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + abstractComponentCallbacksC1139p + " that was not found in the set of active Fragments " + k8.f11606a);
                }
                this.f11560R.p(abstractComponentCallbacksC1139p);
                abstractComponentCallbacksC1139p.mFragmentManager = this;
                O o9 = new O(this.f11578p, this.f11565c, abstractComponentCallbacksC1139p);
                o9.s(1);
                o9.m();
                abstractComponentCallbacksC1139p.mRemoving = true;
                o9.m();
            }
        }
        this.f11565c.w(k8.f11607b);
        if (k8.f11608c != null) {
            this.f11566d = new ArrayList(k8.f11608c.length);
            int i8 = 0;
            while (true) {
                C1125b[] c1125bArr = k8.f11608c;
                if (i8 >= c1125bArr.length) {
                    break;
                }
                C1124a c1124aB = c1125bArr[i8].b(this);
                if (J0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i8 + " (index " + c1124aB.f11748v + "): " + c1124aB);
                    PrintWriter printWriter = new PrintWriter(new W("FragmentManager"));
                    c1124aB.q("  ", printWriter, false);
                    printWriter.close();
                }
                this.f11566d.add(c1124aB);
                i8++;
            }
        } else {
            this.f11566d = new ArrayList();
        }
        this.f11573k.set(k8.f11609d);
        String str3 = k8.f11610e;
        if (str3 != null) {
            AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139pG0 = g0(str3);
            this.f11543A = abstractComponentCallbacksC1139pG0;
            M(abstractComponentCallbacksC1139pG0);
        }
        ArrayList arrayList = k8.f11611f;
        if (arrayList != null) {
            for (int i9 = 0; i9 < arrayList.size(); i9++) {
                this.f11574l.put((String) arrayList.get(i9), (C1126c) k8.f11612g.get(i9));
            }
        }
        this.f11551I = new ArrayDeque(k8.f11613h);
    }

    public void p() {
        C1124a c1124a = this.f11570h;
        if (c1124a != null) {
            c1124a.f11747u = false;
            c1124a.f();
            f0();
            Iterator it = this.f11577o.iterator();
            if (it.hasNext()) {
                android.support.v4.media.session.b.a(it.next());
                throw null;
            }
        }
    }

    public final boolean p0(ArrayList arrayList, ArrayList arrayList2) {
        synchronized (this.f11563a) {
            if (this.f11563a.isEmpty()) {
                return false;
            }
            try {
                int size = this.f11563a.size();
                boolean zA = false;
                for (int i8 = 0; i8 < size; i8++) {
                    zA |= ((l) this.f11563a.get(i8)).a(arrayList, arrayList2);
                }
                return zA;
            } finally {
                this.f11563a.clear();
                this.f11586x.h().removeCallbacks(this.f11562T);
            }
        }
    }

    public boolean q() {
        boolean zK0 = false;
        for (AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p : this.f11565c.l()) {
            if (abstractComponentCallbacksC1139p != null) {
                zK0 = K0(abstractComponentCallbacksC1139p);
            }
            if (zK0) {
                return true;
            }
        }
        return false;
    }

    public int q0() {
        return this.f11566d.size() + (this.f11570h != null ? 1 : 0);
    }

    /* JADX INFO: renamed from: q1, reason: merged with bridge method [inline-methods] */
    public Bundle R0() {
        C1125b[] c1125bArr;
        Bundle bundle = new Bundle();
        n0();
        Y();
        b0(true);
        this.f11553K = true;
        this.f11560R.q(true);
        ArrayList arrayListY = this.f11565c.y();
        HashMap mapM = this.f11565c.m();
        if (!mapM.isEmpty()) {
            ArrayList arrayListZ = this.f11565c.z();
            int size = this.f11566d.size();
            if (size > 0) {
                c1125bArr = new C1125b[size];
                for (int i8 = 0; i8 < size; i8++) {
                    c1125bArr[i8] = new C1125b((C1124a) this.f11566d.get(i8));
                    if (J0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i8 + ": " + this.f11566d.get(i8));
                    }
                }
            } else {
                c1125bArr = null;
            }
            K k8 = new K();
            k8.f11606a = arrayListY;
            k8.f11607b = arrayListZ;
            k8.f11608c = c1125bArr;
            k8.f11609d = this.f11573k.get();
            AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p = this.f11543A;
            if (abstractComponentCallbacksC1139p != null) {
                k8.f11610e = abstractComponentCallbacksC1139p.mWho;
            }
            k8.f11611f.addAll(this.f11574l.keySet());
            k8.f11612g.addAll(this.f11574l.values());
            k8.f11613h = new ArrayList(this.f11551I);
            bundle.putParcelable("state", k8);
            for (String str : this.f11575m.keySet()) {
                bundle.putBundle("result_" + str, (Bundle) this.f11575m.get(str));
            }
            for (String str2 : mapM.keySet()) {
                bundle.putBundle("fragment_" + str2, (Bundle) mapM.get(str2));
            }
        } else if (J0(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
        }
        return bundle;
    }

    public final void r() {
        if (Q0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public final L r0(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
        return this.f11560R.k(abstractComponentCallbacksC1139p);
    }

    public void r1() {
        synchronized (this.f11563a) {
            try {
                if (this.f11563a.size() == 1) {
                    this.f11586x.h().removeCallbacks(this.f11562T);
                    this.f11586x.h().post(this.f11562T);
                    z1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void s() {
        this.f11564b = false;
        this.f11558P.clear();
        this.f11557O.clear();
    }

    public AbstractC1145w s0() {
        return this.f11587y;
    }

    public void s1(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p, boolean z7) {
        ViewGroup viewGroupT0 = t0(abstractComponentCallbacksC1139p);
        if (viewGroupT0 == null || !(viewGroupT0 instanceof C1146x)) {
            return;
        }
        ((C1146x) viewGroupT0).setDrawDisappearingViewsLast(!z7);
    }

    public final void t() {
        A a8 = this.f11586x;
        if (a8 instanceof androidx.lifecycle.N ? this.f11565c.p().o() : a8.f() instanceof Activity ? !((Activity) this.f11586x.f()).isChangingConfigurations() : true) {
            Iterator it = this.f11574l.values().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((C1126c) it.next()).f11764a.iterator();
                while (it2.hasNext()) {
                    this.f11565c.p().h((String) it2.next(), false);
                }
            }
        }
    }

    public final ViewGroup t0(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
        ViewGroup viewGroup = abstractComponentCallbacksC1139p.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (abstractComponentCallbacksC1139p.mContainerId > 0 && this.f11587y.d()) {
            View viewC = this.f11587y.c(abstractComponentCallbacksC1139p.mContainerId);
            if (viewC instanceof ViewGroup) {
                return (ViewGroup) viewC;
            }
        }
        return null;
    }

    public void t1(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p, AbstractC1157i.b bVar) {
        if (abstractComponentCallbacksC1139p.equals(g0(abstractComponentCallbacksC1139p.mWho)) && (abstractComponentCallbacksC1139p.mHost == null || abstractComponentCallbacksC1139p.mFragmentManager == this)) {
            abstractComponentCallbacksC1139p.mMaxState = bVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + abstractComponentCallbacksC1139p + " is not an active fragment of FragmentManager " + this);
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p = this.f11588z;
        if (abstractComponentCallbacksC1139p != null) {
            sb.append(abstractComponentCallbacksC1139p.getClass().getSimpleName());
            sb.append("{");
            obj = this.f11588z;
        } else {
            A a8 = this.f11586x;
            if (a8 == null) {
                sb.append("null");
                sb.append("}}");
                return sb.toString();
            }
            sb.append(a8.getClass().getSimpleName());
            sb.append("{");
            obj = this.f11586x;
        }
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
        sb.append("}");
        sb.append("}}");
        return sb.toString();
    }

    public final Set u() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f11565c.k().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((O) it.next()).k().mContainer;
            if (viewGroup != null) {
                hashSet.add(Z.v(viewGroup, B0()));
            }
        }
        return hashSet;
    }

    public AbstractC1148z u0() {
        AbstractC1148z abstractC1148z = this.f11544B;
        if (abstractC1148z != null) {
            return abstractC1148z;
        }
        AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p = this.f11588z;
        return abstractComponentCallbacksC1139p != null ? abstractComponentCallbacksC1139p.mFragmentManager.u0() : this.f11545C;
    }

    public void u1(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
        if (abstractComponentCallbacksC1139p == null || (abstractComponentCallbacksC1139p.equals(g0(abstractComponentCallbacksC1139p.mWho)) && (abstractComponentCallbacksC1139p.mHost == null || abstractComponentCallbacksC1139p.mFragmentManager == this))) {
            AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p2 = this.f11543A;
            this.f11543A = abstractComponentCallbacksC1139p;
            M(abstractComponentCallbacksC1139p2);
            M(this.f11543A);
            return;
        }
        throw new IllegalArgumentException("Fragment " + abstractComponentCallbacksC1139p + " is not an active fragment of FragmentManager " + this);
    }

    public Set v(ArrayList arrayList, int i8, int i9) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i8 < i9) {
            Iterator it = ((C1124a) arrayList.get(i8)).f11650c.iterator();
            while (it.hasNext()) {
                AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p = ((Q.a) it.next()).f11668b;
                if (abstractComponentCallbacksC1139p != null && (viewGroup = abstractComponentCallbacksC1139p.mContainer) != null) {
                    hashSet.add(Z.u(viewGroup, this));
                }
            }
            i8++;
        }
        return hashSet;
    }

    public List v0() {
        return this.f11565c.o();
    }

    public final void v1(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
        ViewGroup viewGroupT0 = t0(abstractComponentCallbacksC1139p);
        if (viewGroupT0 == null || abstractComponentCallbacksC1139p.getEnterAnim() + abstractComponentCallbacksC1139p.getExitAnim() + abstractComponentCallbacksC1139p.getPopEnterAnim() + abstractComponentCallbacksC1139p.getPopExitAnim() <= 0) {
            return;
        }
        if (viewGroupT0.getTag(AbstractC2310b.f20511c) == null) {
            viewGroupT0.setTag(AbstractC2310b.f20511c, abstractComponentCallbacksC1139p);
        }
        ((AbstractComponentCallbacksC1139p) viewGroupT0.getTag(AbstractC2310b.f20511c)).setPopDirection(abstractComponentCallbacksC1139p.getPopDirection());
    }

    public O w(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
        O oN = this.f11565c.n(abstractComponentCallbacksC1139p.mWho);
        if (oN != null) {
            return oN;
        }
        O o8 = new O(this.f11578p, this.f11565c, abstractComponentCallbacksC1139p);
        o8.o(this.f11586x.f().getClassLoader());
        o8.s(this.f11585w);
        return o8;
    }

    public A w0() {
        return this.f11586x;
    }

    public void w1(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
        if (J0(2)) {
            Log.v("FragmentManager", "show: " + abstractComponentCallbacksC1139p);
        }
        if (abstractComponentCallbacksC1139p.mHidden) {
            abstractComponentCallbacksC1139p.mHidden = false;
            abstractComponentCallbacksC1139p.mHiddenChanged = !abstractComponentCallbacksC1139p.mHiddenChanged;
        }
    }

    public void x(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
        if (J0(2)) {
            Log.v("FragmentManager", "detach: " + abstractComponentCallbacksC1139p);
        }
        if (abstractComponentCallbacksC1139p.mDetached) {
            return;
        }
        abstractComponentCallbacksC1139p.mDetached = true;
        if (abstractComponentCallbacksC1139p.mAdded) {
            if (J0(2)) {
                Log.v("FragmentManager", "remove from detach: " + abstractComponentCallbacksC1139p);
            }
            this.f11565c.u(abstractComponentCallbacksC1139p);
            if (K0(abstractComponentCallbacksC1139p)) {
                this.f11552J = true;
            }
            v1(abstractComponentCallbacksC1139p);
        }
    }

    public LayoutInflater.Factory2 x0() {
        return this.f11568f;
    }

    public final void x1() {
        Iterator it = this.f11565c.k().iterator();
        while (it.hasNext()) {
            c1((O) it.next());
        }
    }

    public void y() {
        this.f11553K = false;
        this.f11554L = false;
        this.f11560R.q(false);
        T(4);
    }

    public C y0() {
        return this.f11578p;
    }

    public final void y1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new W("FragmentManager"));
        A a8 = this.f11586x;
        try {
            if (a8 != null) {
                a8.i("  ", null, printWriter, new String[0]);
            } else {
                X("  ", null, printWriter, new String[0]);
            }
            throw runtimeException;
        } catch (Exception e8) {
            Log.e("FragmentManager", "Failed dumping state", e8);
            throw runtimeException;
        }
    }

    public void z() {
        this.f11553K = false;
        this.f11554L = false;
        this.f11560R.q(false);
        T(0);
    }

    public AbstractComponentCallbacksC1139p z0() {
        return this.f11588z;
    }

    public final void z1() {
        synchronized (this.f11563a) {
            try {
                if (!this.f11563a.isEmpty()) {
                    this.f11572j.setEnabled(true);
                    if (J0(3)) {
                        Log.d("FragmentManager", "FragmentManager " + this + " enabling OnBackPressedCallback, caused by non-empty pending actions");
                    }
                    return;
                }
                boolean z7 = q0() > 0 && O0(this.f11588z);
                if (J0(3)) {
                    Log.d("FragmentManager", "OnBackPressedCallback for FragmentManager " + this + " enabled state is " + z7);
                }
                this.f11572j.setEnabled(z7);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
