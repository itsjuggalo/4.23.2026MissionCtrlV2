package I0;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* JADX INFO: loaded from: classes.dex */
public class y implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewOverlay f2863a;

    public y(View view) {
        this.f2863a = view.getOverlay();
    }

    @Override // I0.z
    public void a(Drawable drawable) {
        this.f2863a.add(drawable);
    }

    @Override // I0.z
    public void b(Drawable drawable) {
        this.f2863a.remove(drawable);
    }
}
