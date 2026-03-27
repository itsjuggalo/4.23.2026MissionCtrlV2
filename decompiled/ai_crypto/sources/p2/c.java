package p2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends CoordinatorLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f21486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21488c;

    public c() {
        this.f21487b = 0;
        this.f21488c = 0;
    }

    public int E() {
        d dVar = this.f21486a;
        if (dVar != null) {
            return dVar.b();
        }
        return 0;
    }

    public void F(CoordinatorLayout coordinatorLayout, View view, int i7) {
        coordinatorLayout.G(view, i7);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i7) {
        F(coordinatorLayout, view, i7);
        if (this.f21486a == null) {
            this.f21486a = new d(view);
        }
        this.f21486a.c();
        this.f21486a.a();
        int i8 = this.f21487b;
        if (i8 != 0) {
            this.f21486a.e(i8);
            this.f21487b = 0;
        }
        int i9 = this.f21488c;
        if (i9 == 0) {
            return true;
        }
        this.f21486a.d(i9);
        this.f21488c = 0;
        return true;
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21487b = 0;
        this.f21488c = 0;
    }
}
