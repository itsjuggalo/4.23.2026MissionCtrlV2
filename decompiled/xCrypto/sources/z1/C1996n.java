package z1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0826n;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: renamed from: z1.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1996n extends DialogInterfaceOnCancelListenerC0826n {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Dialog f16110r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public DialogInterface.OnCancelListener f16111s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Dialog f16112t;

    public static C1996n x(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        C1996n c1996n = new C1996n();
        Dialog dialog2 = (Dialog) AbstractC0940s.l(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        c1996n.f16110r = dialog2;
        if (onCancelListener != null) {
            c1996n.f16111s = onCancelListener;
        }
        return c1996n;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0826n, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f16111s;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0826n
    public Dialog q(Bundle bundle) {
        Dialog dialog = this.f16110r;
        if (dialog != null) {
            return dialog;
        }
        u(false);
        if (this.f16112t == null) {
            this.f16112t = new AlertDialog.Builder((Context) AbstractC0940s.k(getContext())).create();
        }
        return this.f16112t;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0826n
    public void w(androidx.fragment.app.I i4, String str) {
        super.w(i4, str);
    }
}
