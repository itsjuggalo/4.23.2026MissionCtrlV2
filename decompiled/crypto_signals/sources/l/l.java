package l;

import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes.dex */
public final class l implements PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f8026a;

    public l(n nVar) {
        this.f8026a = nVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f8026a.c();
    }
}
