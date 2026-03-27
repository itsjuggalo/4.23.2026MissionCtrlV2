package r0;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* JADX INFO: loaded from: classes.dex */
public class u implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroupOverlay f14477a;

    public u(ViewGroup viewGroup) {
        this.f14477a = viewGroup.getOverlay();
    }

    @Override // r0.z
    public void a(Drawable drawable) {
        this.f14477a.add(drawable);
    }

    @Override // r0.z
    public void b(Drawable drawable) {
        this.f14477a.remove(drawable);
    }

    @Override // r0.v
    public void c(View view) {
        this.f14477a.add(view);
    }

    @Override // r0.v
    public void d(View view) {
        this.f14477a.remove(view);
    }
}
