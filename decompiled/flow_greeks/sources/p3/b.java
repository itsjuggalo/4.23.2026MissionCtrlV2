package p3;

import android.graphics.drawable.BitmapDrawable;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b implements g3.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j3.d f18205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g3.k f18206b;

    public b(j3.d dVar, g3.k kVar) {
        this.f18205a = dVar;
        this.f18206b = kVar;
    }

    @Override // g3.k
    public g3.c b(g3.h hVar) {
        return this.f18206b.b(hVar);
    }

    @Override // g3.d
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(i3.v vVar, File file, g3.h hVar) {
        return this.f18206b.a(new f(((BitmapDrawable) vVar.get()).getBitmap(), this.f18205a), file, hVar);
    }
}
