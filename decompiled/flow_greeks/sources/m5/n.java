package m5;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class n extends androidx.fragment.app.n {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Dialog f15951q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public DialogInterface.OnCancelListener f15952r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Dialog f15953s;

    public static n x(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        n nVar = new n();
        Dialog dialog2 = (Dialog) com.google.android.gms.common.internal.s.l(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        nVar.f15951q = dialog2;
        if (onCancelListener != null) {
            nVar.f15952r = onCancelListener;
        }
        return nVar;
    }

    @Override // androidx.fragment.app.n, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f15952r;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.n
    public Dialog q(Bundle bundle) {
        Dialog dialog = this.f15951q;
        if (dialog != null) {
            return dialog;
        }
        u(false);
        if (this.f15953s == null) {
            this.f15953s = new AlertDialog.Builder((Context) com.google.android.gms.common.internal.s.k(getContext())).create();
        }
        return this.f15953s;
    }

    @Override // androidx.fragment.app.n
    public void w(androidx.fragment.app.i0 i0Var, String str) {
        super.w(i0Var, str);
    }
}
