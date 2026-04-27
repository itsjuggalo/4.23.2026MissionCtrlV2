package D;

import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
public class W extends android.support.v4.media.session.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Window f220a;

    public W(Window window) {
        this.f220a = window;
    }

    @Override // android.support.v4.media.session.a
    public final void x(boolean z6) {
        Window window = this.f220a;
        if (!z6) {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-8193));
        } else {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() | 8192);
        }
    }
}
