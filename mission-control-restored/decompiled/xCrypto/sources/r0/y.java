package r0;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* JADX INFO: loaded from: classes.dex */
public class y implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewOverlay f14479a;

    public y(View view) {
        this.f14479a = view.getOverlay();
    }

    @Override // r0.z
    public void a(Drawable drawable) {
        this.f14479a.add(drawable);
    }

    @Override // r0.z
    public void b(Drawable drawable) {
        this.f14479a.remove(drawable);
    }
}
