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
import androidx.lifecycle.InterfaceC0850m;

/* JADX INFO: renamed from: androidx.fragment.app.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class DialogInterfaceOnCancelListenerC0826n extends AbstractComponentCallbacksC0828p implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f7535a;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f7544k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Dialog f7546m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f7547n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f7548o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f7549p;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Runnable f7536b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DialogInterface.OnCancelListener f7537c = new b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DialogInterface.OnDismissListener f7538e = new c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f7539f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f7540g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f7541h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f7542i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f7543j = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public androidx.lifecycle.s f7545l = new d();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f7550q = false;

    /* JADX INFO: renamed from: androidx.fragment.app.n$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DialogInterfaceOnCancelListenerC0826n.this.f7538e.onDismiss(DialogInterfaceOnCancelListenerC0826n.this.f7546m);
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.n$b */
    public class b implements DialogInterface.OnCancelListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (DialogInterfaceOnCancelListenerC0826n.this.f7546m != null) {
                DialogInterfaceOnCancelListenerC0826n dialogInterfaceOnCancelListenerC0826n = DialogInterfaceOnCancelListenerC0826n.this;
                dialogInterfaceOnCancelListenerC0826n.onCancel(dialogInterfaceOnCancelListenerC0826n.f7546m);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.n$c */
    public class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (DialogInterfaceOnCancelListenerC0826n.this.f7546m != null) {
                DialogInterfaceOnCancelListenerC0826n dialogInterfaceOnCancelListenerC0826n = DialogInterfaceOnCancelListenerC0826n.this;
                dialogInterfaceOnCancelListenerC0826n.onDismiss(dialogInterfaceOnCancelListenerC0826n.f7546m);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.n$d */
    public class d implements androidx.lifecycle.s {
        public d() {
        }

        @Override // androidx.lifecycle.s
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(InterfaceC0850m interfaceC0850m) {
            if (interfaceC0850m == null || !DialogInterfaceOnCancelListenerC0826n.this.f7542i) {
                return;
            }
            View viewRequireView = DialogInterfaceOnCancelListenerC0826n.this.requireView();
            if (viewRequireView.getParent() != null) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
            if (DialogInterfaceOnCancelListenerC0826n.this.f7546m != null) {
                if (I.J0(3)) {
                    Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + DialogInterfaceOnCancelListenerC0826n.this.f7546m);
                }
                DialogInterfaceOnCancelListenerC0826n.this.f7546m.setContentView(viewRequireView);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.n$e */
    public class e extends AbstractC0834w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC0834w f7555a;

        public e(AbstractC0834w abstractC0834w) {
            this.f7555a = abstractC0834w;
        }

        @Override // androidx.fragment.app.AbstractC0834w
        public View c(int i4) {
            return this.f7555a.d() ? this.f7555a.c(i4) : DialogInterfaceOnCancelListenerC0826n.this.r(i4);
        }

        @Override // androidx.fragment.app.AbstractC0834w
        public boolean d() {
            return this.f7555a.d() || DialogInterfaceOnCancelListenerC0826n.this.s();
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0828p
    public AbstractC0834w createFragmentContainer() {
        return new e(super.createFragmentContainer());
    }

    public final void o(boolean z4, boolean z5, boolean z6) {
        if (this.f7548o) {
            return;
        }
        this.f7548o = true;
        this.f7549p = false;
        Dialog dialog = this.f7546m;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f7546m.dismiss();
            if (!z5) {
                if (Looper.myLooper() == this.f7535a.getLooper()) {
                    onDismiss(this.f7546m);
                } else {
                    this.f7535a.post(this.f7536b);
                }
            }
        }
        this.f7547n = true;
        if (this.f7543j >= 0) {
            if (z6) {
                getParentFragmentManager().a1(this.f7543j, 1);
            } else {
                getParentFragmentManager().Y0(this.f7543j, 1, z4);
            }
            this.f7543j = -1;
            return;
        }
        Q qO = getParentFragmentManager().o();
        qO.m(true);
        qO.l(this);
        if (z6) {
            qO.h();
        } else if (z4) {
            qO.g();
        } else {
            qO.f();
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0828p
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0828p
    public void onAttach(Context context) {
        super.onAttach(context);
        getViewLifecycleOwnerLiveData().observeForever(this.f7545l);
        if (this.f7549p) {
            return;
        }
        this.f7548o = false;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0828p
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7535a = new Handler();
        this.f7542i = this.mContainerId == 0;
        if (bundle != null) {
            this.f7539f = bundle.getInt("android:style", 0);
            this.f7540g = bundle.getInt("android:theme", 0);
            this.f7541h = bundle.getBoolean("android:cancelable", true);
            this.f7542i = bundle.getBoolean("android:showsDialog", this.f7542i);
            this.f7543j = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0828p
    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.f7546m;
        if (dialog != null) {
            this.f7547n = true;
            dialog.setOnDismissListener(null);
            this.f7546m.dismiss();
            if (!this.f7548o) {
                onDismiss(this.f7546m);
            }
            this.f7546m = null;
            this.f7550q = false;
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0828p
    public void onDetach() {
        super.onDetach();
        if (!this.f7549p && !this.f7548o) {
            this.f7548o = true;
        }
        getViewLifecycleOwnerLiveData().removeObserver(this.f7545l);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f7547n) {
            return;
        }
        if (I.J0(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        o(true, true, false);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0828p
    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        LayoutInflater layoutInflaterOnGetLayoutInflater = super.onGetLayoutInflater(bundle);
        if (this.f7542i && !this.f7544k) {
            t(bundle);
            if (I.J0(2)) {
                Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
            }
            Dialog dialog = this.f7546m;
            if (dialog != null) {
                return layoutInflaterOnGetLayoutInflater.cloneInContext(dialog.getContext());
            }
        } else if (I.J0(2)) {
            String str = "getting layout inflater for DialogFragment " + this;
            if (!this.f7542i) {
                Log.d("FragmentManager", "mShowsDialog = false: " + str);
                return layoutInflaterOnGetLayoutInflater;
            }
            Log.d("FragmentManager", "mCreatingDialog = true: " + str);
        }
        return layoutInflaterOnGetLayoutInflater;
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0828p
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Dialog dialog = this.f7546m;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i4 = this.f7539f;
        if (i4 != 0) {
            bundle.putInt("android:style", i4);
        }
        int i5 = this.f7540g;
        if (i5 != 0) {
            bundle.putInt("android:theme", i5);
        }
        boolean z4 = this.f7541h;
        if (!z4) {
            bundle.putBoolean("android:cancelable", z4);
        }
        boolean z5 = this.f7542i;
        if (!z5) {
            bundle.putBoolean("android:showsDialog", z5);
        }
        int i6 = this.f7543j;
        if (i6 != -1) {
            bundle.putInt("android:backStackId", i6);
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0828p
    public void onStart() {
        super.onStart();
        Dialog dialog = this.f7546m;
        if (dialog != null) {
            this.f7547n = false;
            dialog.show();
            View decorView = this.f7546m.getWindow().getDecorView();
            androidx.lifecycle.O.a(decorView, this);
            androidx.lifecycle.P.a(decorView, this);
            o0.g.a(decorView, this);
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0828p
    public void onStop() {
        super.onStop();
        Dialog dialog = this.f7546m;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0828p
    public void onViewStateRestored(Bundle bundle) {
        Bundle bundle2;
        super.onViewStateRestored(bundle);
        if (this.f7546m == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f7546m.onRestoreInstanceState(bundle2);
    }

    public int p() {
        return this.f7540g;
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0828p
    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.performCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView != null || this.f7546m == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f7546m.onRestoreInstanceState(bundle2);
    }

    public Dialog q(Bundle bundle) {
        if (I.J0(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new androidx.activity.l(requireContext(), p());
    }

    public View r(int i4) {
        Dialog dialog = this.f7546m;
        if (dialog != null) {
            return dialog.findViewById(i4);
        }
        return null;
    }

    public boolean s() {
        return this.f7550q;
    }

    public final void t(Bundle bundle) {
        if (this.f7542i && !this.f7550q) {
            try {
                this.f7544k = true;
                Dialog dialogQ = q(bundle);
                this.f7546m = dialogQ;
                if (this.f7542i) {
                    v(dialogQ, this.f7539f);
                    Context context = getContext();
                    if (context instanceof Activity) {
                        this.f7546m.setOwnerActivity((Activity) context);
                    }
                    this.f7546m.setCancelable(this.f7541h);
                    this.f7546m.setOnCancelListener(this.f7537c);
                    this.f7546m.setOnDismissListener(this.f7538e);
                    this.f7550q = true;
                } else {
                    this.f7546m = null;
                }
                this.f7544k = false;
            } catch (Throwable th) {
                this.f7544k = false;
                throw th;
            }
        }
    }

    public void u(boolean z4) {
        this.f7542i = z4;
    }

    public void v(Dialog dialog, int i4) {
        if (i4 != 1 && i4 != 2) {
            if (i4 != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    public void w(I i4, String str) {
        this.f7548o = false;
        this.f7549p = true;
        Q qO = i4.o();
        qO.m(true);
        qO.d(this, str);
        qO.f();
    }
}
