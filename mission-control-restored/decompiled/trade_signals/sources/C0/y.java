package C0;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* JADX INFO: loaded from: classes.dex */
public class y implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewOverlay f585a;

    public y(View view) {
        this.f585a = view.getOverlay();
    }

    @Override // C0.z
    public void a(Drawable drawable) {
        this.f585a.add(drawable);
    }

    @Override // C0.z
    public void b(Drawable drawable) {
        this.f585a.remove(drawable);
    }
}
