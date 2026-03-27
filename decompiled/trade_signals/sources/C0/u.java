package C0;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* JADX INFO: loaded from: classes.dex */
public class u implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroupOverlay f583a;

    public u(ViewGroup viewGroup) {
        this.f583a = viewGroup.getOverlay();
    }

    @Override // C0.z
    public void a(Drawable drawable) {
        this.f583a.add(drawable);
    }

    @Override // C0.z
    public void b(Drawable drawable) {
        this.f583a.remove(drawable);
    }

    @Override // C0.v
    public void c(View view) {
        this.f583a.add(view);
    }

    @Override // C0.v
    public void d(View view) {
        this.f583a.remove(view);
    }
}
