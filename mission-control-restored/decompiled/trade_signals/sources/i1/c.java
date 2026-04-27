package i1;

import U0.h;
import W0.v;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import d1.C1618g;
import h1.C1848c;

/* JADX INFO: loaded from: classes.dex */
public final class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final X0.d f18754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f18755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f18756c;

    public c(X0.d dVar, e eVar, e eVar2) {
        this.f18754a = dVar;
        this.f18755b = eVar;
        this.f18756c = eVar2;
    }

    @Override // i1.e
    public v a(v vVar, h hVar) {
        Drawable drawable = (Drawable) vVar.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f18755b.a(C1618g.f(((BitmapDrawable) drawable).getBitmap(), this.f18754a), hVar);
        }
        if (drawable instanceof C1848c) {
            return this.f18756c.a(b(vVar), hVar);
        }
        return null;
    }

    public static v b(v vVar) {
        return vVar;
    }
}
