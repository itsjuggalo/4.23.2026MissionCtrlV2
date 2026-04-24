package d1;

import android.graphics.Bitmap;
import q1.AbstractC2628k;
import q1.AbstractC2629l;

/* JADX INFO: renamed from: d1.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1618g implements W0.v, W0.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f16780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final X0.d f16781b;

    public C1618g(Bitmap bitmap, X0.d dVar) {
        this.f16780a = (Bitmap) AbstractC2628k.e(bitmap, "Bitmap must not be null");
        this.f16781b = (X0.d) AbstractC2628k.e(dVar, "BitmapPool must not be null");
    }

    public static C1618g f(Bitmap bitmap, X0.d dVar) {
        if (bitmap == null) {
            return null;
        }
        return new C1618g(bitmap, dVar);
    }

    @Override // W0.r
    public void a() {
        this.f16780a.prepareToDraw();
    }

    @Override // W0.v
    public void b() {
        this.f16781b.c(this.f16780a);
    }

    @Override // W0.v
    public int c() {
        return AbstractC2629l.h(this.f16780a);
    }

    @Override // W0.v
    public Class d() {
        return Bitmap.class;
    }

    @Override // W0.v
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Bitmap get() {
        return this.f16780a;
    }
}
