package p2;

import Q.N;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f21489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21493e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f21494f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f21495g = true;

    public d(View view) {
        this.f21489a = view;
    }

    public void a() {
        View view = this.f21489a;
        N.W(view, this.f21492d - (view.getTop() - this.f21490b));
        View view2 = this.f21489a;
        N.V(view2, this.f21493e - (view2.getLeft() - this.f21491c));
    }

    public int b() {
        return this.f21492d;
    }

    public void c() {
        this.f21490b = this.f21489a.getTop();
        this.f21491c = this.f21489a.getLeft();
    }

    public boolean d(int i7) {
        if (!this.f21495g || this.f21493e == i7) {
            return false;
        }
        this.f21493e = i7;
        a();
        return true;
    }

    public boolean e(int i7) {
        if (!this.f21494f || this.f21492d == i7) {
            return false;
        }
        this.f21492d = i7;
        a();
        return true;
    }
}
