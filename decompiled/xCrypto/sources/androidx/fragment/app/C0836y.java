package androidx.fragment.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: renamed from: androidx.fragment.app.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0836y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f7614a;

    public C0836y(A a4) {
        this.f7614a = a4;
    }

    public static C0836y b(A a4) {
        return new C0836y((A) G.e.c(a4, "callbacks == null"));
    }

    public void a(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        I iG = this.f7614a.g();
        A a4 = this.f7614a;
        iG.m(a4, a4, abstractComponentCallbacksC0828p);
    }

    public void c() {
        this.f7614a.g().y();
    }

    public boolean d(MenuItem menuItem) {
        return this.f7614a.g().B(menuItem);
    }

    public void e() {
        this.f7614a.g().C();
    }

    public void f() {
        this.f7614a.g().E();
    }

    public void g() {
        this.f7614a.g().N();
    }

    public void h() {
        this.f7614a.g().R();
    }

    public void i() {
        this.f7614a.g().S();
    }

    public void j() {
        this.f7614a.g().U();
    }

    public boolean k() {
        return this.f7614a.g().b0(true);
    }

    public I l() {
        return this.f7614a.g();
    }

    public void m() {
        this.f7614a.g().V0();
    }

    public View n(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f7614a.g().x0().onCreateView(view, str, context, attributeSet);
    }
}
