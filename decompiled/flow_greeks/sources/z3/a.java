package z3;

import android.graphics.drawable.Drawable;
import c4.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f25591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f25592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y3.c f25593c;

    public a() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // z3.d
    public final void d(y3.c cVar) {
        this.f25593c = cVar;
    }

    @Override // z3.d
    public final void f(c cVar) {
        cVar.e(this.f25591a, this.f25592b);
    }

    @Override // z3.d
    public final y3.c j() {
        return this.f25593c;
    }

    public a(int i10, int i11) {
        if (l.t(i10, i11)) {
            this.f25591a = i10;
            this.f25592b = i11;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i10 + " and height: " + i11);
    }

    @Override // v3.l
    public void a() {
    }

    @Override // v3.l
    public void e() {
    }

    @Override // v3.l
    public void h() {
    }

    @Override // z3.d
    public final void b(c cVar) {
    }

    @Override // z3.d
    public void g(Drawable drawable) {
    }

    @Override // z3.d
    public void i(Drawable drawable) {
    }
}
