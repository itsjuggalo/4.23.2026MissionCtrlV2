package z9;

import android.view.View;
import android.widget.ScrollView;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f25615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f25616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f25617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f25618d;

    public d(View view, boolean z10) {
        this.f25615a = view;
        this.f25616b = z10;
    }

    public int a() {
        if (this.f25615a.getVisibility() == 8) {
            return 0;
        }
        View view = this.f25615a;
        if (!(view instanceof ScrollView)) {
            return view.getMeasuredHeight();
        }
        ScrollView scrollView = (ScrollView) view;
        return scrollView.getPaddingBottom() + scrollView.getPaddingTop() + scrollView.getChildAt(0).getMeasuredHeight();
    }

    public int b() {
        return this.f25618d;
    }

    public View c() {
        return this.f25615a;
    }

    public boolean d() {
        return this.f25616b;
    }

    public void e(int i10, int i11) {
        b.b(this.f25615a, i10, i11);
    }

    public void f(int i10, int i11) {
        this.f25617c = i10;
        this.f25618d = i11;
    }
}
