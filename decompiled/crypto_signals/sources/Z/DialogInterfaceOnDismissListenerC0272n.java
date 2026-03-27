package Z;

import android.app.Dialog;
import android.content.DialogInterface;

/* JADX INFO: renamed from: Z.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class DialogInterfaceOnDismissListenerC0272n implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DialogInterfaceOnCancelListenerC0274p f3850a;

    public DialogInterfaceOnDismissListenerC0272n(DialogInterfaceOnCancelListenerC0274p dialogInterfaceOnCancelListenerC0274p) {
        this.f3850a = dialogInterfaceOnCancelListenerC0274p;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        DialogInterfaceOnCancelListenerC0274p dialogInterfaceOnCancelListenerC0274p = this.f3850a;
        Dialog dialog = dialogInterfaceOnCancelListenerC0274p.f3862f0;
        if (dialog != null) {
            dialogInterfaceOnCancelListenerC0274p.onDismiss(dialog);
        }
    }
}
