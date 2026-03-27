package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: renamed from: o.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1644j extends PopupWindow {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f13857b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f13858a;

    public C1644j(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        a(context, attributeSet, i4, i5);
    }

    public final void a(Context context, AttributeSet attributeSet, int i4, int i5) {
        a0 a0VarR = a0.r(context, attributeSet, g.i.f11878v1, i4, i5);
        if (a0VarR.o(g.i.f11886x1)) {
            b(a0VarR.a(g.i.f11886x1, false));
        }
        setBackgroundDrawable(a0VarR.f(g.i.f11882w1));
        a0VarR.s();
    }

    public final void b(boolean z4) {
        if (f13857b) {
            this.f13858a = z4;
        } else {
            M.f.a(this, z4);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i4, int i5) {
        if (f13857b && this.f13858a) {
            i5 -= view.getHeight();
        }
        super.showAsDropDown(view, i4, i5);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i4, int i5, int i6, int i7) {
        if (f13857b && this.f13858a) {
            i5 -= view.getHeight();
        }
        super.update(view, i4, i5, i6, i7);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i4, int i5, int i6) {
        if (f13857b && this.f13858a) {
            i5 -= view.getHeight();
        }
        super.showAsDropDown(view, i4, i5, i6);
    }
}
