package androidx.fragment.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class n extends p implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f2179a;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2188j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Dialog f2190l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f2191m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f2192n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f2193o;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Runnable f2180b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DialogInterface.OnCancelListener f2181c = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DialogInterface.OnDismissListener f2182d = new c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2183e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2184f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2185g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2186h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2187i = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public androidx.lifecycle.s f2189k = new d();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f2194p = false;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.f2182d.onDismiss(n.this.f2190l);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements DialogInterface.OnCancelListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (n.this.f2190l != null) {
                n nVar = n.this;
                nVar.onCancel(nVar.f2190l);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (n.this.f2190l != null) {
                n nVar = n.this;
                nVar.onDismiss(nVar.f2190l);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements androidx.lifecycle.s {
        public d() {
        }

        @Override // androidx.lifecycle.s
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(androidx.lifecycle.m mVar) {
            if (mVar == null || !n.this.f2186h) {
                return;
            }
            View viewRequireView = n.this.requireView();
            if (viewRequireView.getParent() != null) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
            if (n.this.f2190l != null) {
                if (i0.J0(3)) {
                    Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + n.this.f2190l);
                }
                n.this.f2190l.setContentView(viewRequireView);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class e extends w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f2199a;

        public e(w wVar) {
            this.f2199a = wVar;
        }

        @Override // androidx.fragment.app.w
        public View c(int i10) {
            return this.f2199a.d() ? this.f2199a.c(i10) : n.this.r(i10);
        }

        @Override // androidx.fragment.app.w
        public boolean d() {
            return this.f2199a.d() || n.this.s();
        }
    }

    @Override // androidx.fragment.app.p
    public w createFragmentContainer() {
        return new e(super.createFragmentContainer());
    }

    public final void o(boolean z10, boolean z11, boolean z12) {
        if (this.f2192n) {
            return;
        }
        this.f2192n = true;
        this.f2193o = false;
        Dialog dialog = this.f2190l;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f2190l.dismiss();
            if (!z11) {
                if (Looper.myLooper() == this.f2179a.getLooper()) {
                    onDismiss(this.f2190l);
                } else {
                    this.f2179a.post(this.f2180b);
                }
            }
        }
        this.f2191m = true;
        if (this.f2187i >= 0) {
            if (z12) {
                getParentFragmentManager().a1(this.f2187i, 1);
            } else {
                getParentFragmentManager().Y0(this.f2187i, 1, z10);
            }
            this.f2187i = -1;
            return;
        }
        q0 q0VarO = getParentFragmentManager().o();
        q0VarO.m(true);
        q0VarO.l(this);
        if (z12) {
            q0VarO.h();
        } else if (z10) {
            q0VarO.g();
        } else {
            q0VarO.f();
        }
    }

    @Override // androidx.fragment.app.p
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.p
    public void onAttach(Context context) {
        super.onAttach(context);
        getViewLifecycleOwnerLiveData().observeForever(this.f2189k);
        if (this.f2193o) {
            return;
        }
        this.f2192n = false;
    }

    @Override // androidx.fragment.app.p
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2179a = new Handler();
        this.f2186h = this.mContainerId == 0;
        if (bundle != null) {
            this.f2183e = bundle.getInt("android:style", 0);
            this.f2184f = bundle.getInt("android:theme", 0);
            this.f2185g = bundle.getBoolean("android:cancelable", true);
            this.f2186h = bundle.getBoolean("android:showsDialog", this.f2186h);
            this.f2187i = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.p
    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.f2190l;
        if (dialog != null) {
            this.f2191m = true;
            dialog.setOnDismissListener(null);
            this.f2190l.dismiss();
            if (!this.f2192n) {
                onDismiss(this.f2190l);
            }
            this.f2190l = null;
            this.f2194p = false;
        }
    }

    @Override // androidx.fragment.app.p
    public void onDetach() {
        super.onDetach();
        if (!this.f2193o && !this.f2192n) {
            this.f2192n = true;
        }
        getViewLifecycleOwnerLiveData().removeObserver(this.f2189k);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f2191m) {
            return;
        }
        if (i0.J0(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        o(true, true, false);
    }

    @Override // androidx.fragment.app.p
    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        LayoutInflater layoutInflaterOnGetLayoutInflater = super.onGetLayoutInflater(bundle);
        if (this.f2186h && !this.f2188j) {
            t(bundle);
            if (i0.J0(2)) {
                Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
            }
            Dialog dialog = this.f2190l;
            if (dialog != null) {
                return layoutInflaterOnGetLayoutInflater.cloneInContext(dialog.getContext());
            }
        } else if (i0.J0(2)) {
            String str = "getting layout inflater for DialogFragment " + this;
            if (!this.f2186h) {
                Log.d("FragmentManager", "mShowsDialog = false: " + str);
                return layoutInflaterOnGetLayoutInflater;
            }
            Log.d("FragmentManager", "mCreatingDialog = true: " + str);
        }
        return layoutInflaterOnGetLayoutInflater;
    }

    @Override // androidx.fragment.app.p
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Dialog dialog = this.f2190l;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i10 = this.f2183e;
        if (i10 != 0) {
            bundle.putInt("android:style", i10);
        }
        int i11 = this.f2184f;
        if (i11 != 0) {
            bundle.putInt("android:theme", i11);
        }
        boolean z10 = this.f2185g;
        if (!z10) {
            bundle.putBoolean("android:cancelable", z10);
        }
        boolean z11 = this.f2186h;
        if (!z11) {
            bundle.putBoolean("android:showsDialog", z11);
        }
        int i12 = this.f2187i;
        if (i12 != -1) {
            bundle.putInt("android:backStackId", i12);
        }
    }

    @Override // androidx.fragment.app.p
    public void onStart() {
        super.onStart();
        Dialog dialog = this.f2190l;
        if (dialog != null) {
            this.f2191m = false;
            dialog.show();
            View decorView = this.f2190l.getWindow().getDecorView();
            androidx.lifecycle.n0.a(decorView, this);
            androidx.lifecycle.o0.a(decorView, this);
            k2.g.a(decorView, this);
        }
    }

    @Override // androidx.fragment.app.p
    public void onStop() {
        super.onStop();
        Dialog dialog = this.f2190l;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.p
    public void onViewStateRestored(Bundle bundle) {
        Bundle bundle2;
        super.onViewStateRestored(bundle);
        if (this.f2190l == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f2190l.onRestoreInstanceState(bundle2);
    }

    public int p() {
        return this.f2184f;
    }

    @Override // androidx.fragment.app.p
    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.performCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView != null || this.f2190l == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f2190l.onRestoreInstanceState(bundle2);
    }

    public Dialog q(Bundle bundle) {
        if (i0.J0(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new androidx.activity.k(requireContext(), p());
    }

    public View r(int i10) {
        Dialog dialog = this.f2190l;
        if (dialog != null) {
            return dialog.findViewById(i10);
        }
        return null;
    }

    public boolean s() {
        return this.f2194p;
    }

    public final void t(Bundle bundle) {
        if (this.f2186h && !this.f2194p) {
            try {
                this.f2188j = true;
                Dialog dialogQ = q(bundle);
                this.f2190l = dialogQ;
                if (this.f2186h) {
                    v(dialogQ, this.f2183e);
                    Context context = getContext();
                    if (context instanceof Activity) {
                        this.f2190l.setOwnerActivity((Activity) context);
                    }
                    this.f2190l.setCancelable(this.f2185g);
                    this.f2190l.setOnCancelListener(this.f2181c);
                    this.f2190l.setOnDismissListener(this.f2182d);
                    this.f2194p = true;
                } else {
                    this.f2190l = null;
                }
                this.f2188j = false;
            } catch (Throwable th) {
                this.f2188j = false;
                throw th;
            }
        }
    }

    public void u(boolean z10) {
        this.f2186h = z10;
    }

    public void v(Dialog dialog, int i10) {
        if (i10 != 1 && i10 != 2) {
            if (i10 != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    public void w(i0 i0Var, String str) {
        this.f2192n = false;
        this.f2193o = true;
        q0 q0VarO = i0Var.o();
        q0VarO.m(true);
        q0VarO.d(this, str);
        q0VarO.f();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }
}
