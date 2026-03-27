package v;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class b implements d {
    @Override // v.d
    public float a(c cVar) {
        return cVar.e().getElevation();
    }

    @Override // v.d
    public void b(c cVar) {
        f(cVar, h(cVar));
    }

    @Override // v.d
    public float c(c cVar) {
        return m(cVar) * 2.0f;
    }

    @Override // v.d
    public float d(c cVar) {
        return m(cVar) * 2.0f;
    }

    @Override // v.d
    public void e(c cVar, Context context, ColorStateList colorStateList, float f8, float f9, float f10) {
        cVar.a(new e(colorStateList, f8));
        View viewE = cVar.e();
        viewE.setClipToOutline(true);
        viewE.setElevation(f9);
        f(cVar, f10);
    }

    @Override // v.d
    public void f(c cVar, float f8) {
        o(cVar).g(f8, cVar.c(), cVar.b());
        p(cVar);
    }

    @Override // v.d
    public void g(c cVar, float f8) {
        o(cVar).h(f8);
    }

    @Override // v.d
    public float h(c cVar) {
        return o(cVar).c();
    }

    @Override // v.d
    public void j(c cVar, ColorStateList colorStateList) {
        o(cVar).f(colorStateList);
    }

    @Override // v.d
    public ColorStateList k(c cVar) {
        return o(cVar).b();
    }

    @Override // v.d
    public void l(c cVar) {
        f(cVar, h(cVar));
    }

    @Override // v.d
    public float m(c cVar) {
        return o(cVar).d();
    }

    @Override // v.d
    public void n(c cVar, float f8) {
        cVar.e().setElevation(f8);
    }

    public final e o(c cVar) {
        return (e) cVar.d();
    }

    public void p(c cVar) {
        if (!cVar.c()) {
            cVar.f(0, 0, 0, 0);
            return;
        }
        float fH = h(cVar);
        float fM = m(cVar);
        int iCeil = (int) Math.ceil(f.a(fH, fM, cVar.b()));
        int iCeil2 = (int) Math.ceil(f.b(fH, fM, cVar.b()));
        cVar.f(iCeil, iCeil2, iCeil, iCeil2);
    }

    @Override // v.d
    public void i() {
    }
}
