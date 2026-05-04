package p3;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class z implements i3.v, i3.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f18299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i3.v f18300b;

    public z(Resources resources, i3.v vVar) {
        this.f18299a = (Resources) c4.k.e(resources);
        this.f18300b = (i3.v) c4.k.e(vVar);
    }

    public static i3.v f(Resources resources, i3.v vVar) {
        if (vVar == null) {
            return null;
        }
        return new z(resources, vVar);
    }

    @Override // i3.r
    public void a() {
        i3.v vVar = this.f18300b;
        if (vVar instanceof i3.r) {
            ((i3.r) vVar).a();
        }
    }

    @Override // i3.v
    public void b() {
        this.f18300b.b();
    }

    @Override // i3.v
    public int c() {
        return this.f18300b.c();
    }

    @Override // i3.v
    public Class d() {
        return BitmapDrawable.class;
    }

    @Override // i3.v
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f18299a, (Bitmap) this.f18300b.get());
    }
}
