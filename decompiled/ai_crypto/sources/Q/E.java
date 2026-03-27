package Q;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4369b;

    public E(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f4368a | this.f4369b;
    }

    public void b(View view, View view2, int i7) {
        c(view, view2, i7, 0);
    }

    public void c(View view, View view2, int i7, int i8) {
        if (i8 == 1) {
            this.f4369b = i7;
        } else {
            this.f4368a = i7;
        }
    }

    public void d(View view, int i7) {
        if (i7 == 1) {
            this.f4369b = 0;
        } else {
            this.f4368a = 0;
        }
    }
}
