package t0;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20556b;

    public u(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f20555a | this.f20556b;
    }

    public void b(View view, View view2, int i10) {
        c(view, view2, i10, 0);
    }

    public void c(View view, View view2, int i10, int i11) {
        if (i11 == 1) {
            this.f20556b = i10;
        } else {
            this.f20555a = i10;
        }
    }

    public void d(View view, int i10) {
        if (i10 == 1) {
            this.f20556b = 0;
        } else {
            this.f20555a = 0;
        }
    }
}
