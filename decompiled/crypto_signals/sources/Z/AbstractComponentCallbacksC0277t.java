package Z;

import K2.m0;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.C0364v;
import androidx.lifecycle.EnumC0357n;
import androidx.lifecycle.InterfaceC0352i;
import androidx.lifecycle.InterfaceC0362t;
import d.C0506j;
import d0.C0520b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import u.AbstractC1193h;

/* JADX INFO: renamed from: Z.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractComponentCallbacksC0277t implements ComponentCallbacks, View.OnCreateContextMenuListener, InterfaceC0362t, androidx.lifecycle.Z, InterfaceC0352i, q0.e {

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public static final Object f3877V = new Object();

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int f3878A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public int f3879B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public String f3880C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public boolean f3881D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public boolean f3882E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public boolean f3883F;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public boolean f3885H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public ViewGroup f3886I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f3887J;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public C0276s f3889L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public boolean f3890M;
    public boolean N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public String f3891O;
    public EnumC0357n P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public C0364v f3892Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public final androidx.lifecycle.B f3893R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public m0 f3894S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public final ArrayList f3895T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public final C0275q f3896U;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bundle f3898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SparseArray f3899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bundle f3900d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bundle f3901f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AbstractComponentCallbacksC0277t f3902k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3904m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f3906o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f3907p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f3908q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f3909r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f3910s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f3911t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f3912u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f3913v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public P f3914w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public C0281x f3915x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public AbstractComponentCallbacksC0277t f3916z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3897a = -1;
    public String e = UUID.randomUUID().toString();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f3903l = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Boolean f3905n = null;
    public P y = new P();

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final boolean f3884G = true;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public boolean f3888K = true;

    public AbstractComponentCallbacksC0277t() {
        new A.b(this, 12);
        this.P = EnumC0357n.e;
        this.f3893R = new androidx.lifecycle.B();
        new AtomicInteger();
        this.f3895T = new ArrayList();
        this.f3896U = new C0275q(this);
        o();
    }

    public void A() {
        this.f3885H = true;
    }

    public abstract void B(Bundle bundle);

    public abstract void C();

    public abstract void D();

    public void E(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.y.Q();
        this.f3912u = true;
        f();
    }

    public final Context F() {
        C0281x c0281x = this.f3915x;
        AbstractActivityC0282y abstractActivityC0282y = c0281x == null ? null : c0281x.f3924d;
        if (abstractActivityC0282y != null) {
            return abstractActivityC0282y;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final void G(int i, int i6, int i7, int i8) {
        if (this.f3889L == null && i == 0 && i6 == 0 && i7 == 0 && i8 == 0) {
            return;
        }
        k().f3870b = i;
        k().f3871c = i6;
        k().f3872d = i7;
        k().e = i8;
    }

    @Override // q0.e
    public final Y3.i b() {
        return (Y3.i) this.f3894S.f951c;
    }

    @Override // androidx.lifecycle.InterfaceC0352i
    public final C0520b d() {
        Application application;
        Context applicationContext = F().getApplicationContext();
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
        if (application == null && P.K(3)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + F().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        C0520b c0520b = new C0520b(0);
        LinkedHashMap linkedHashMap = (LinkedHashMap) c0520b.f1130a;
        if (application != null) {
            linkedHashMap.put(androidx.lifecycle.U.f4663a, application);
        }
        linkedHashMap.put(androidx.lifecycle.N.f4646a, this);
        linkedHashMap.put(androidx.lifecycle.N.f4647b, this);
        Bundle bundle = this.f3901f;
        if (bundle != null) {
            linkedHashMap.put(androidx.lifecycle.N.f4648c, bundle);
        }
        return c0520b;
    }

    @Override // androidx.lifecycle.Z
    public final androidx.lifecycle.Y f() {
        if (this.f3914w == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (m() == 1) {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        HashMap map = this.f3914w.N.f3768f;
        androidx.lifecycle.Y y = (androidx.lifecycle.Y) map.get(this.e);
        if (y != null) {
            return y;
        }
        androidx.lifecycle.Y y6 = new androidx.lifecycle.Y();
        map.put(this.e, y6);
        return y6;
    }

    @Override // androidx.lifecycle.InterfaceC0362t
    public final C0364v h() {
        return this.f3892Q;
    }

    public y5.a i() {
        return new r(this);
    }

    public void j(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f3878A));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f3879B));
        printWriter.print(" mTag=");
        printWriter.println(this.f3880C);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f3897a);
        printWriter.print(" mWho=");
        printWriter.print(this.e);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f3913v);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f3906o);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f3907p);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f3909r);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f3910s);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f3881D);
        printWriter.print(" mDetached=");
        printWriter.print(this.f3882E);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f3884G);
        printWriter.print(" mHasMenu=");
        printWriter.println(false);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f3883F);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f3888K);
        if (this.f3914w != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f3914w);
        }
        if (this.f3915x != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f3915x);
        }
        if (this.f3916z != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f3916z);
        }
        if (this.f3901f != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f3901f);
        }
        if (this.f3898b != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f3898b);
        }
        if (this.f3899c != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f3899c);
        }
        if (this.f3900d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.f3900d);
        }
        AbstractComponentCallbacksC0277t abstractComponentCallbacksC0277tK = this.f3902k;
        if (abstractComponentCallbacksC0277tK == null) {
            P p3 = this.f3914w;
            abstractComponentCallbacksC0277tK = (p3 == null || (str2 = this.f3903l) == null) ? null : p3.f3738c.k(str2);
        }
        if (abstractComponentCallbacksC0277tK != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(abstractComponentCallbacksC0277tK);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f3904m);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        C0276s c0276s = this.f3889L;
        printWriter.println(c0276s == null ? false : c0276s.f3869a);
        C0276s c0276s2 = this.f3889L;
        if ((c0276s2 == null ? 0 : c0276s2.f3870b) != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            C0276s c0276s3 = this.f3889L;
            printWriter.println(c0276s3 == null ? 0 : c0276s3.f3870b);
        }
        C0276s c0276s4 = this.f3889L;
        if ((c0276s4 == null ? 0 : c0276s4.f3871c) != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            C0276s c0276s5 = this.f3889L;
            printWriter.println(c0276s5 == null ? 0 : c0276s5.f3871c);
        }
        C0276s c0276s6 = this.f3889L;
        if ((c0276s6 == null ? 0 : c0276s6.f3872d) != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            C0276s c0276s7 = this.f3889L;
            printWriter.println(c0276s7 == null ? 0 : c0276s7.f3872d);
        }
        C0276s c0276s8 = this.f3889L;
        if ((c0276s8 == null ? 0 : c0276s8.e) != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            C0276s c0276s9 = this.f3889L;
            printWriter.println(c0276s9 != null ? c0276s9.e : 0);
        }
        if (this.f3886I != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f3886I);
        }
        C0281x c0281x = this.f3915x;
        if ((c0281x != null ? c0281x.f3924d : null) != null) {
            new Y3.d(this, f()).y(str, printWriter);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.y + ":");
        this.y.w(a3.d.j(str, "  "), fileDescriptor, printWriter, strArr);
    }

    public final C0276s k() {
        if (this.f3889L == null) {
            C0276s c0276s = new C0276s();
            Object obj = f3877V;
            c0276s.f3874g = obj;
            c0276s.f3875h = obj;
            c0276s.i = obj;
            c0276s.f3876j = null;
            this.f3889L = c0276s;
        }
        return this.f3889L;
    }

    public final P l() {
        if (this.f3915x != null) {
            return this.y;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public final int m() {
        EnumC0357n enumC0357n = this.P;
        return (enumC0357n == EnumC0357n.f4682b || this.f3916z == null) ? enumC0357n.ordinal() : Math.min(enumC0357n.ordinal(), this.f3916z.m());
    }

    public final P n() {
        P p3 = this.f3914w;
        if (p3 != null) {
            return p3;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public final void o() {
        this.f3892Q = new C0364v(this);
        this.f3894S = new m0((q0.e) this);
        ArrayList arrayList = this.f3895T;
        C0275q c0275q = this.f3896U;
        if (arrayList.contains(c0275q)) {
            return;
        }
        if (this.f3897a < 0) {
            arrayList.add(c0275q);
            return;
        }
        AbstractComponentCallbacksC0277t abstractComponentCallbacksC0277t = c0275q.f3867a;
        abstractComponentCallbacksC0277t.f3894S.h();
        androidx.lifecycle.N.d(abstractComponentCallbacksC0277t);
        Bundle bundle = abstractComponentCallbacksC0277t.f3898b;
        abstractComponentCallbacksC0277t.f3894S.i(bundle != null ? bundle.getBundle("registryState") : null);
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        this.f3885H = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        C0281x c0281x = this.f3915x;
        AbstractActivityC0282y abstractActivityC0282y = c0281x == null ? null : c0281x.f3923c;
        if (abstractActivityC0282y != null) {
            abstractActivityC0282y.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        this.f3885H = true;
    }

    public final void p() {
        o();
        this.f3891O = this.e;
        this.e = UUID.randomUUID().toString();
        this.f3906o = false;
        this.f3907p = false;
        this.f3909r = false;
        this.f3910s = false;
        this.f3911t = false;
        this.f3913v = 0;
        this.f3914w = null;
        this.y = new P();
        this.f3915x = null;
        this.f3878A = 0;
        this.f3879B = 0;
        this.f3880C = null;
        this.f3881D = false;
        this.f3882E = false;
    }

    public final boolean q() {
        if (this.f3881D) {
            return true;
        }
        P p3 = this.f3914w;
        if (p3 != null) {
            AbstractComponentCallbacksC0277t abstractComponentCallbacksC0277t = this.f3916z;
            p3.getClass();
            if (abstractComponentCallbacksC0277t == null ? false : abstractComponentCallbacksC0277t.q()) {
                return true;
            }
        }
        return false;
    }

    public final boolean r() {
        return this.f3913v > 0;
    }

    public void s() {
        this.f3885H = true;
    }

    public final void startActivityForResult(Intent intent, int i) throws Exception {
        if (this.f3915x == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        P pN = n();
        if (pN.f3723B == null) {
            C0281x c0281x = pN.f3755v;
            c0281x.getClass();
            kotlin.jvm.internal.j.e(intent, "intent");
            if (i != -1) {
                throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
            }
            AbstractC1193h.startActivity(c0281x.f3924d, intent, null);
            return;
        }
        String str = this.e;
        L l6 = new L();
        l6.f3717a = str;
        l6.f3718b = i;
        pN.f3726E.addLast(l6);
        f.d dVar = pN.f3723B;
        C0506j c0506j = (C0506j) dVar.f6383c;
        LinkedHashMap linkedHashMap = c0506j.f5894b;
        String str2 = (String) dVar.f6382b;
        Object obj = linkedHashMap.get(str2);
        F1.h hVar = (F1.h) dVar.f6384d;
        if (obj == null) {
            throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + hVar + " and input " + intent + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
        }
        int iIntValue = ((Number) obj).intValue();
        ArrayList arrayList = c0506j.f5896d;
        arrayList.add(str2);
        try {
            c0506j.b(iIntValue, hVar, intent);
        } catch (Exception e) {
            arrayList.remove(str2);
            throw e;
        }
    }

    public void t(int i, int i6, Intent intent) {
        if (P.K(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i + " resultCode: " + i6 + " data: " + intent);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.e);
        if (this.f3878A != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f3878A));
        }
        if (this.f3880C != null) {
            sb.append(" tag=");
            sb.append(this.f3880C);
        }
        sb.append(")");
        return sb.toString();
    }

    public void u(AbstractActivityC0282y abstractActivityC0282y) {
        this.f3885H = true;
        C0281x c0281x = this.f3915x;
        if ((c0281x == null ? null : c0281x.f3923c) != null) {
            this.f3885H = true;
        }
    }

    public void v(Bundle bundle) {
        Bundle bundle2;
        this.f3885H = true;
        Bundle bundle3 = this.f3898b;
        if (bundle3 != null && (bundle2 = bundle3.getBundle("childFragmentManager")) != null) {
            this.y.V(bundle2);
            P p3 = this.y;
            p3.f3728G = false;
            p3.f3729H = false;
            p3.N.i = false;
            p3.u(1);
        }
        P p6 = this.y;
        if (p6.f3754u >= 1) {
            return;
        }
        p6.f3728G = false;
        p6.f3729H = false;
        p6.N.i = false;
        p6.u(1);
    }

    public void w() {
        this.f3885H = true;
    }

    public void x() {
        this.f3885H = true;
    }

    public void y() {
        this.f3885H = true;
    }

    public LayoutInflater z(Bundle bundle) {
        C0281x c0281x = this.f3915x;
        if (c0281x == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        AbstractActivityC0282y abstractActivityC0282y = c0281x.f3926k;
        LayoutInflater layoutInflaterCloneInContext = abstractActivityC0282y.getLayoutInflater().cloneInContext(abstractActivityC0282y);
        layoutInflaterCloneInContext.setFactory2(this.y.f3740f);
        return layoutInflaterCloneInContext;
    }
}
