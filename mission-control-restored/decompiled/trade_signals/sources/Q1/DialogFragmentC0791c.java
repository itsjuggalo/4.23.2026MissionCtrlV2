package Q1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.gms.common.internal.AbstractC1294n;

/* JADX INFO: renamed from: Q1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class DialogFragmentC0791c extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Dialog f6683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DialogInterface.OnCancelListener f6684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Dialog f6685c;

    public static DialogFragmentC0791c a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        DialogFragmentC0791c dialogFragmentC0791c = new DialogFragmentC0791c();
        Dialog dialog2 = (Dialog) AbstractC1294n.k(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        dialogFragmentC0791c.f6683a = dialog2;
        if (onCancelListener != null) {
            dialogFragmentC0791c.f6684b = onCancelListener;
        }
        return dialogFragmentC0791c;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f6684b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f6683a;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f6685c == null) {
            this.f6685c = new AlertDialog.Builder((Context) AbstractC1294n.j(getActivity())).create();
        }
        return this.f6685c;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
