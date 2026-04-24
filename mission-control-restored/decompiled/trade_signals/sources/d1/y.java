package d1;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import q1.AbstractC2628k;

/* JADX INFO: loaded from: classes.dex */
public final class y implements W0.v, W0.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f16836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final W0.v f16837b;

    public y(Resources resources, W0.v vVar) {
        this.f16836a = (Resources) AbstractC2628k.d(resources);
        this.f16837b = (W0.v) AbstractC2628k.d(vVar);
    }

    public static W0.v f(Resources resources, W0.v vVar) {
        if (vVar == null) {
            return null;
        }
        return new y(resources, vVar);
    }

    @Override // W0.r
    public void a() {
        W0.v vVar = this.f16837b;
        if (vVar instanceof W0.r) {
            ((W0.r) vVar).a();
        }
    }

    @Override // W0.v
    public void b() {
        this.f16837b.b();
    }

    @Override // W0.v
    public int c() {
        return this.f16837b.c();
    }

    @Override // W0.v
    public Class d() {
        return BitmapDrawable.class;
    }

    @Override // W0.v
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f16836a, (Bitmap) this.f16837b.get());
    }
}
