package P1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: renamed from: P1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class DialogFragmentC0649c extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Dialog f4289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DialogInterface.OnCancelListener f4290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Dialog f4291c;

    public static DialogFragmentC0649c a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        DialogFragmentC0649c dialogFragmentC0649c = new DialogFragmentC0649c();
        Dialog dialog2 = (Dialog) AbstractC1207s.l(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        dialogFragmentC0649c.f4289a = dialog2;
        if (onCancelListener != null) {
            dialogFragmentC0649c.f4290b = onCancelListener;
        }
        return dialogFragmentC0649c;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f4290b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f4289a;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f4291c == null) {
            this.f4291c = new AlertDialog.Builder((Context) AbstractC1207s.k(getActivity())).create();
        }
        return this.f4291c;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
