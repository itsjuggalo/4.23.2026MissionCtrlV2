package d1;

import android.graphics.drawable.Drawable;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public class B implements U0.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f1.l f16749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final X0.d f16750b;

    public B(f1.l lVar, X0.d dVar) {
        this.f16749a = lVar;
        this.f16750b = dVar;
    }

    @Override // U0.j
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public W0.v a(Uri uri, int i8, int i9, U0.h hVar) {
        W0.v vVarA = this.f16749a.a(uri, i8, i9, hVar);
        if (vVarA == null) {
            return null;
        }
        return s.a(this.f16750b, (Drawable) vVarA.get(), i8, i9);
    }

    @Override // U0.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(Uri uri, U0.h hVar) {
        return "android.resource".equals(uri.getScheme());
    }
}
