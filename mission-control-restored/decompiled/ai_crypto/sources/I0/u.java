package I0;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* JADX INFO: loaded from: classes.dex */
public class u implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroupOverlay f2861a;

    public u(ViewGroup viewGroup) {
        this.f2861a = viewGroup.getOverlay();
    }

    @Override // I0.z
    public void a(Drawable drawable) {
        this.f2861a.add(drawable);
    }

    @Override // I0.z
    public void b(Drawable drawable) {
        this.f2861a.remove(drawable);
    }

    @Override // I0.v
    public void c(View view) {
        this.f2861a.add(view);
    }

    @Override // I0.v
    public void d(View view) {
        this.f2861a.remove(view);
    }
}
