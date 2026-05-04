package androidx.fragment.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0 f2348a;

    public y(a0 a0Var) {
        this.f2348a = a0Var;
    }

    public static y b(a0 a0Var) {
        return new y((a0) s0.f.e(a0Var, "callbacks == null"));
    }

    public void a(p pVar) {
        i0 i0VarG = this.f2348a.g();
        a0 a0Var = this.f2348a;
        i0VarG.m(a0Var, a0Var, pVar);
    }

    public void c() {
        this.f2348a.g().y();
    }

    public boolean d(MenuItem menuItem) {
        return this.f2348a.g().B(menuItem);
    }

    public void e() {
        this.f2348a.g().C();
    }

    public void f() {
        this.f2348a.g().E();
    }

    public void g() {
        this.f2348a.g().N();
    }

    public void h() {
        this.f2348a.g().R();
    }

    public void i() {
        this.f2348a.g().S();
    }

    public void j() {
        this.f2348a.g().U();
    }

    public boolean k() {
        return this.f2348a.g().b0(true);
    }

    public i0 l() {
        return this.f2348a.g();
    }

    public void m() {
        this.f2348a.g().V0();
    }

    public View n(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f2348a.g().x0().onCreateView(view, str, context, attributeSet);
    }
}
