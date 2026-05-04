package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class l extends PopupWindow {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f17292b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f17293a;

    public l(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        a(context, attributeSet, i10, i11);
    }

    public final void a(Context context, AttributeSet attributeSet, int i10, int i11) {
        j0 j0VarS = j0.s(context, attributeSet, g.i.f9824p1, i10, i11);
        if (j0VarS.p(g.i.f9832r1)) {
            b(j0VarS.a(g.i.f9832r1, false));
        }
        setBackgroundDrawable(j0VarS.f(g.i.f9828q1));
        j0VarS.u();
    }

    public final void b(boolean z10) {
        if (f17292b) {
            this.f17293a = z10;
        } else {
            w0.e.a(this, z10);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i10, int i11) {
        if (f17292b && this.f17293a) {
            i11 -= view.getHeight();
        }
        super.showAsDropDown(view, i10, i11);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i10, int i11, int i12, int i13) {
        if (f17292b && this.f17293a) {
            i11 -= view.getHeight();
        }
        super.update(view, i10, i11, i12, i13);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i10, int i11, int i12) {
        if (f17292b && this.f17293a) {
            i11 -= view.getHeight();
        }
        super.showAsDropDown(view, i10, i11, i12);
    }
}
