package p3;

import android.graphics.drawable.Drawable;
import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c0 implements g3.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r3.g f18216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j3.d f18217b;

    public c0(r3.g gVar, j3.d dVar) {
        this.f18216a = gVar;
        this.f18217b = dVar;
    }

    @Override // g3.j
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public i3.v a(Uri uri, int i10, int i11, g3.h hVar) {
        i3.v vVarA = this.f18216a.a(uri, i10, i11, hVar);
        if (vVarA == null) {
            return null;
        }
        return q.a(this.f18217b, (Drawable) vVarA.get(), i10, i11);
    }

    @Override // g3.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(Uri uri, g3.h hVar) {
        return "android.resource".equals(uri.getScheme());
    }
}
