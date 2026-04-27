package M3;

import android.view.View;
import android.widget.ScrollView;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f5351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5354d;

    public d(View view, boolean z7) {
        this.f5351a = view;
        this.f5352b = z7;
    }

    public int a() {
        if (this.f5351a.getVisibility() == 8) {
            return 0;
        }
        View view = this.f5351a;
        if (!(view instanceof ScrollView)) {
            return view.getMeasuredHeight();
        }
        ScrollView scrollView = (ScrollView) view;
        return scrollView.getPaddingBottom() + scrollView.getPaddingTop() + scrollView.getChildAt(0).getMeasuredHeight();
    }

    public int b() {
        return this.f5354d;
    }

    public View c() {
        return this.f5351a;
    }

    public boolean d() {
        return this.f5352b;
    }

    public void e(int i8, int i9) {
        b.b(this.f5351a, i8, i9);
    }

    public void f(int i8, int i9) {
        this.f5353c = i8;
        this.f5354d = i9;
    }
}
