package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: renamed from: o.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2443l extends PopupWindow {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f21848b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f21849a;

    public C2443l(Context context, AttributeSet attributeSet, int i8, int i9) {
        super(context, attributeSet, i8, i9);
        a(context, attributeSet, i8, i9);
    }

    public final void a(Context context, AttributeSet attributeSet, int i8, int i9) {
        L lS = L.s(context, attributeSet, g.i.f17923p1, i8, i9);
        if (lS.p(g.i.f17931r1)) {
            b(lS.a(g.i.f17931r1, false));
        }
        setBackgroundDrawable(lS.f(g.i.f17927q1));
        lS.u();
    }

    public final void b(boolean z7) {
        if (f21848b) {
            this.f21849a = z7;
        } else {
            Y.e.a(this, z7);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i8, int i9) {
        if (f21848b && this.f21849a) {
            i9 -= view.getHeight();
        }
        super.showAsDropDown(view, i8, i9);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i8, int i9, int i10, int i11) {
        if (f21848b && this.f21849a) {
            i9 -= view.getHeight();
        }
        super.update(view, i8, i9, i10, i11);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i8, int i9, int i10) {
        if (f21848b && this.f21849a) {
            i9 -= view.getHeight();
        }
        super.showAsDropDown(view, i8, i9, i10);
    }
}
