package p3;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f implements i3.v, i3.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f18228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j3.d f18229b;

    public f(Bitmap bitmap, j3.d dVar) {
        this.f18228a = (Bitmap) c4.k.f(bitmap, "Bitmap must not be null");
        this.f18229b = (j3.d) c4.k.f(dVar, "BitmapPool must not be null");
    }

    public static f f(Bitmap bitmap, j3.d dVar) {
        if (bitmap == null) {
            return null;
        }
        return new f(bitmap, dVar);
    }

    @Override // i3.r
    public void a() {
        this.f18228a.prepareToDraw();
    }

    @Override // i3.v
    public void b() {
        this.f18229b.c(this.f18228a);
    }

    @Override // i3.v
    public int c() {
        return c4.l.h(this.f18228a);
    }

    @Override // i3.v
    public Class d() {
        return Bitmap.class;
    }

    @Override // i3.v
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Bitmap get() {
        return this.f18228a;
    }
}
