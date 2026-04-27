package n1;

import android.graphics.drawable.Drawable;
import q1.AbstractC2629l;

/* JADX INFO: renamed from: n1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2387a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m1.c f21558c;

    public AbstractC2387a() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // n1.d
    public final void g(c cVar) {
        cVar.e(this.f21556a, this.f21557b);
    }

    @Override // n1.d
    public final m1.c i() {
        return this.f21558c;
    }

    @Override // n1.d
    public final void k(m1.c cVar) {
        this.f21558c = cVar;
    }

    public AbstractC2387a(int i8, int i9) {
        if (AbstractC2629l.t(i8, i9)) {
            this.f21556a = i8;
            this.f21557b = i9;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i8 + " and height: " + i9);
    }

    @Override // j1.l
    public void a() {
    }

    @Override // j1.l
    public void c() {
    }

    @Override // j1.l
    public void f() {
    }

    @Override // n1.d
    public final void b(c cVar) {
    }

    @Override // n1.d
    public void e(Drawable drawable) {
    }

    @Override // n1.d
    public void h(Drawable drawable) {
    }
}
