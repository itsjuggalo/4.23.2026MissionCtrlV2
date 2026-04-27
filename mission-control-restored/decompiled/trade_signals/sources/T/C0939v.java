package T;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: T.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0939v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7879b;

    public C0939v(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f7878a | this.f7879b;
    }

    public void b(View view, View view2, int i8) {
        c(view, view2, i8, 0);
    }

    public void c(View view, View view2, int i8, int i9) {
        if (i9 == 1) {
            this.f7879b = i8;
        } else {
            this.f7878a = i8;
        }
    }

    public void d(View view, int i8) {
        if (i8 == 1) {
            this.f7879b = 0;
        } else {
            this.f7878a = 0;
        }
    }
}
