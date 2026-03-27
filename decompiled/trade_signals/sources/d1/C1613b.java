package d1;

import android.graphics.drawable.BitmapDrawable;
import java.io.File;

/* JADX INFO: renamed from: d1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1613b implements U0.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final X0.d f16774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final U0.k f16775b;

    public C1613b(X0.d dVar, U0.k kVar) {
        this.f16774a = dVar;
        this.f16775b = kVar;
    }

    @Override // U0.k
    public U0.c b(U0.h hVar) {
        return this.f16775b.b(hVar);
    }

    @Override // U0.d
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(W0.v vVar, File file, U0.h hVar) {
        return this.f16775b.a(new C1618g(((BitmapDrawable) vVar.get()).getBitmap(), this.f16774a), file, hVar);
    }
}
