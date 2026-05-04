package n2;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class w implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewOverlay f16604a;

    public w(View view) {
        this.f16604a = view.getOverlay();
    }

    @Override // n2.x
    public void a(Drawable drawable) {
        this.f16604a.add(drawable);
    }

    @Override // n2.x
    public void b(Drawable drawable) {
        this.f16604a.remove(drawable);
    }
}
