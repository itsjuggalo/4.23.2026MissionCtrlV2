package m;

import androidx.appcompat.widget.ActionBarOverlayLayout;

/* JADX INFO: renamed from: m.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0809c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ActionBarOverlayLayout f8338b;

    public /* synthetic */ RunnableC0809c(ActionBarOverlayLayout actionBarOverlayLayout, int i) {
        this.f8337a = i;
        this.f8338b = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8337a) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = this.f8338b;
                actionBarOverlayLayout.h();
                actionBarOverlayLayout.f4271x = actionBarOverlayLayout.f4255c.animate().translationY(0.0f).setListener(actionBarOverlayLayout.y);
                break;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.f8338b;
                actionBarOverlayLayout2.h();
                actionBarOverlayLayout2.f4271x = actionBarOverlayLayout2.f4255c.animate().translationY(-actionBarOverlayLayout2.f4255c.getHeight()).setListener(actionBarOverlayLayout2.y);
                break;
        }
    }
}
