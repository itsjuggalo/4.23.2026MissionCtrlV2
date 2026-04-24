package u1;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.gms.common.internal.I;

/* JADX INFO: renamed from: u1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class DialogFragmentC1201c extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AlertDialog f10277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DialogInterface.OnCancelListener f10278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AlertDialog f10279c;

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f10278b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        AlertDialog alertDialog = this.f10277a;
        if (alertDialog != null) {
            return alertDialog;
        }
        setShowsDialog(false);
        if (this.f10279c == null) {
            Activity activity = getActivity();
            I.g(activity);
            this.f10279c = new AlertDialog.Builder(activity).create();
        }
        return this.f10279c;
    }
}
