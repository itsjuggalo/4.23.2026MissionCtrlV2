package u3;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import g3.h;
import i3.v;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j3.d f22161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f22162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f22163c;

    public c(j3.d dVar, e eVar, e eVar2) {
        this.f22161a = dVar;
        this.f22162b = eVar;
        this.f22163c = eVar2;
    }

    @Override // u3.e
    public v a(v vVar, h hVar) {
        Drawable drawable = (Drawable) vVar.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f22162b.a(p3.f.f(((BitmapDrawable) drawable).getBitmap(), this.f22161a), hVar);
        }
        if (drawable instanceof t3.c) {
            return this.f22163c.a(b(vVar), hVar);
        }
        return null;
    }

    public static v b(v vVar) {
        return vVar;
    }
}
