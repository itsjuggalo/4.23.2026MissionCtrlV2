package p;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import h.AbstractC1664i;

/* JADX INFO: renamed from: p.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2355p extends PopupWindow {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f21397b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f21398a;

    public C2355p(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        a(context, attributeSet, i7, i8);
    }

    public final void a(Context context, AttributeSet attributeSet, int i7, int i8) {
        S sT = S.t(context, attributeSet, AbstractC1664i.f14664t1, i7, i8);
        if (sT.q(AbstractC1664i.f14672v1)) {
            b(sT.a(AbstractC1664i.f14672v1, false));
        }
        setBackgroundDrawable(sT.g(AbstractC1664i.f14668u1));
        sT.u();
    }

    public final void b(boolean z7) {
        if (f21397b) {
            this.f21398a = z7;
        } else {
            V.f.a(this, z7);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i7, int i8) {
        if (f21397b && this.f21398a) {
            i8 -= view.getHeight();
        }
        super.showAsDropDown(view, i7, i8);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i7, int i8, int i9, int i10) {
        if (f21397b && this.f21398a) {
            i8 -= view.getHeight();
        }
        super.update(view, i7, i8, i9, i10);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i7, int i8, int i9) {
        if (f21397b && this.f21398a) {
            i8 -= view.getHeight();
        }
        super.showAsDropDown(view, i7, i8, i9);
    }
}
