package Z;

import android.app.Dialog;
import android.content.DialogInterface;

/* JADX INFO: renamed from: Z.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class DialogInterfaceOnCancelListenerC0271m implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DialogInterfaceOnCancelListenerC0274p f3849a;

    public DialogInterfaceOnCancelListenerC0271m(DialogInterfaceOnCancelListenerC0274p dialogInterfaceOnCancelListenerC0274p) {
        this.f3849a = dialogInterfaceOnCancelListenerC0274p;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterfaceOnCancelListenerC0274p dialogInterfaceOnCancelListenerC0274p = this.f3849a;
        Dialog dialog = dialogInterfaceOnCancelListenerC0274p.f3862f0;
        if (dialog != null) {
            dialogInterfaceOnCancelListenerC0274p.onCancel(dialog);
        }
    }
}
