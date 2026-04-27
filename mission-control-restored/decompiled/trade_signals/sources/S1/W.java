package S1;

import android.app.Dialog;

/* JADX INFO: loaded from: classes.dex */
public final class W extends E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Dialog f7378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ X f7379b;

    public W(X x8, Dialog dialog) {
        this.f7379b = x8;
        this.f7378a = dialog;
    }

    @Override // S1.E
    public final void a() {
        this.f7379b.f7381b.o();
        if (this.f7378a.isShowing()) {
            this.f7378a.dismiss();
        }
    }
}
