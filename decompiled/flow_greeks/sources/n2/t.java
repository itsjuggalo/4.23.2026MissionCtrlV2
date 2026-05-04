package n2;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class t implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroupOverlay f16602a;

    public t(ViewGroup viewGroup) {
        this.f16602a = viewGroup.getOverlay();
    }

    @Override // n2.x
    public void a(Drawable drawable) {
        this.f16602a.add(drawable);
    }

    @Override // n2.x
    public void b(Drawable drawable) {
        this.f16602a.remove(drawable);
    }

    @Override // n2.u
    public void c(View view) {
        this.f16602a.add(view);
    }

    @Override // n2.u
    public void d(View view) {
        this.f16602a.remove(view);
    }
}
