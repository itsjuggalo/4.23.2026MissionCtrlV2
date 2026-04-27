package H;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: H.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0288w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f588b;

    public C0288w(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f587a | this.f588b;
    }

    public void b(View view, View view2, int i4) {
        c(view, view2, i4, 0);
    }

    public void c(View view, View view2, int i4, int i5) {
        if (i5 == 1) {
            this.f588b = i4;
        } else {
            this.f587a = i4;
        }
    }

    public void d(View view, int i4) {
        if (i4 == 1) {
            this.f588b = 0;
        } else {
            this.f587a = 0;
        }
    }
}
