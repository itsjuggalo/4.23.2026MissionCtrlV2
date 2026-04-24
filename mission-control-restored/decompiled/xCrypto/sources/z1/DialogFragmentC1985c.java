package z1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: renamed from: z1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class DialogFragmentC1985c extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Dialog f16086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DialogInterface.OnCancelListener f16087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Dialog f16088c;

    public static DialogFragmentC1985c a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        DialogFragmentC1985c dialogFragmentC1985c = new DialogFragmentC1985c();
        Dialog dialog2 = (Dialog) AbstractC0940s.l(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        dialogFragmentC1985c.f16086a = dialog2;
        if (onCancelListener != null) {
            dialogFragmentC1985c.f16087b = onCancelListener;
        }
        return dialogFragmentC1985c;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f16087b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f16086a;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f16088c == null) {
            this.f16088c = new AlertDialog.Builder((Context) AbstractC0940s.k(getActivity())).create();
        }
        return this.f16088c;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
