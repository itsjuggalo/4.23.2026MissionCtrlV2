package Z;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cryptosignals.ap.android.R;
import d.DialogC0509m;

/* JADX INFO: renamed from: Z.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class DialogInterfaceOnCancelListenerC0274p extends AbstractComponentCallbacksC0277t implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public final DialogInterfaceOnCancelListenerC0271m f3853W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public final DialogInterfaceOnDismissListenerC0272n f3854X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public int f3855Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public int f3856Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f3857a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f3858b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f3859c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f3860d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final Y3.j f3861e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public Dialog f3862f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public boolean f3863g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public boolean f3864h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public boolean f3865i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f3866j0;

    public DialogInterfaceOnCancelListenerC0274p() {
        new A.b(this, 11);
        this.f3853W = new DialogInterfaceOnCancelListenerC0271m(this);
        this.f3854X = new DialogInterfaceOnDismissListenerC0272n(this);
        this.f3855Y = 0;
        this.f3856Z = 0;
        this.f3857a0 = true;
        this.f3858b0 = true;
        this.f3859c0 = -1;
        this.f3861e0 = new Y3.j(this, 3);
        this.f3866j0 = false;
    }

    @Override // Z.AbstractComponentCallbacksC0277t
    public final void B(Bundle bundle) {
        Dialog dialog = this.f3862f0;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i = this.f3855Y;
        if (i != 0) {
            bundle.putInt("android:style", i);
        }
        int i6 = this.f3856Z;
        if (i6 != 0) {
            bundle.putInt("android:theme", i6);
        }
        boolean z6 = this.f3857a0;
        if (!z6) {
            bundle.putBoolean("android:cancelable", z6);
        }
        boolean z7 = this.f3858b0;
        if (!z7) {
            bundle.putBoolean("android:showsDialog", z7);
        }
        int i7 = this.f3859c0;
        if (i7 != -1) {
            bundle.putInt("android:backStackId", i7);
        }
    }

    @Override // Z.AbstractComponentCallbacksC0277t
    public final void C() {
        this.f3885H = true;
        Dialog dialog = this.f3862f0;
        if (dialog != null) {
            this.f3863g0 = false;
            dialog.show();
            View decorView = this.f3862f0.getWindow().getDecorView();
            kotlin.jvm.internal.j.e(decorView, "<this>");
            decorView.setTag(R.id.view_tree_lifecycle_owner, this);
            decorView.setTag(R.id.view_tree_view_model_store_owner, this);
            decorView.setTag(R.id.view_tree_saved_state_registry_owner, this);
        }
    }

    @Override // Z.AbstractComponentCallbacksC0277t
    public final void D() {
        this.f3885H = true;
        Dialog dialog = this.f3862f0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // Z.AbstractComponentCallbacksC0277t
    public final void E(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.E(layoutInflater, viewGroup, bundle);
        if (this.f3862f0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f3862f0.onRestoreInstanceState(bundle2);
    }

    public Dialog H() {
        if (P.K(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new DialogC0509m(F(), this.f3856Z);
    }

    @Override // Z.AbstractComponentCallbacksC0277t
    public final y5.a i() {
        return new C0273o(this, new r(this));
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        if (this.f3863g0) {
            return;
        }
        if (P.K(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        if (this.f3864h0) {
            return;
        }
        this.f3864h0 = true;
        this.f3865i0 = false;
        Dialog dialog = this.f3862f0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f3862f0.dismiss();
        }
        this.f3863g0 = true;
        if (this.f3859c0 >= 0) {
            P pN = n();
            int i = this.f3859c0;
            if (i < 0) {
                throw new IllegalArgumentException(a3.d.f(i, "Bad id: "));
            }
            pN.y(new N(pN, i), true);
            this.f3859c0 = -1;
            return;
        }
        C0259a c0259a = new C0259a(n());
        c0259a.f3810o = true;
        P p3 = this.f3914w;
        if (p3 == null || p3 == c0259a.f3811p) {
            c0259a.b(new W(3, this));
            c0259a.d(true);
        } else {
            throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + toString() + " is already attached to a FragmentManager.");
        }
    }

    @Override // Z.AbstractComponentCallbacksC0277t
    public final void s() {
        this.f3885H = true;
    }

    @Override // Z.AbstractComponentCallbacksC0277t
    public final void u(AbstractActivityC0282y abstractActivityC0282y) {
        super.u(abstractActivityC0282y);
        this.f3893R.e(this.f3861e0);
        if (this.f3865i0) {
            return;
        }
        this.f3864h0 = false;
    }

    @Override // Z.AbstractComponentCallbacksC0277t
    public final void v(Bundle bundle) {
        super.v(bundle);
        new Handler();
        this.f3858b0 = this.f3879B == 0;
        if (bundle != null) {
            this.f3855Y = bundle.getInt("android:style", 0);
            this.f3856Z = bundle.getInt("android:theme", 0);
            this.f3857a0 = bundle.getBoolean("android:cancelable", true);
            this.f3858b0 = bundle.getBoolean("android:showsDialog", this.f3858b0);
            this.f3859c0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // Z.AbstractComponentCallbacksC0277t
    public final void x() {
        this.f3885H = true;
        Dialog dialog = this.f3862f0;
        if (dialog != null) {
            this.f3863g0 = true;
            dialog.setOnDismissListener(null);
            this.f3862f0.dismiss();
            if (!this.f3864h0) {
                onDismiss(this.f3862f0);
            }
            this.f3862f0 = null;
            this.f3866j0 = false;
        }
    }

    @Override // Z.AbstractComponentCallbacksC0277t
    public final void y() {
        this.f3885H = true;
        if (!this.f3865i0 && !this.f3864h0) {
            this.f3864h0 = true;
        }
        this.f3893R.i(this.f3861e0);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0044 A[Catch: all -> 0x004e, TryCatch #0 {all -> 0x004e, blocks: (B:12:0x001a, B:14:0x0027, B:24:0x003f, B:29:0x0048, B:32:0x0050, B:27:0x0044, B:20:0x0031, B:22:0x0037, B:23:0x003c, B:33:0x0068), top: B:52:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0048 A[Catch: all -> 0x004e, TryCatch #0 {all -> 0x004e, blocks: (B:12:0x001a, B:14:0x0027, B:24:0x003f, B:29:0x0048, B:32:0x0050, B:27:0x0044, B:20:0x0031, B:22:0x0037, B:23:0x003c, B:33:0x0068), top: B:52:0x001a }] */
    @Override // Z.AbstractComponentCallbacksC0277t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.LayoutInflater z(android.os.Bundle r9) {
        /*
            Method dump skipped, instruction units count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Z.DialogInterfaceOnCancelListenerC0274p.z(android.os.Bundle):android.view.LayoutInflater");
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }
}
