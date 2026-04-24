package f1;

import W0.r;
import W0.v;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import h1.C1848c;
import q1.AbstractC2628k;

/* JADX INFO: loaded from: classes.dex */
public abstract class j implements v, r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f17382a;

    public j(Drawable drawable) {
        this.f17382a = (Drawable) AbstractC2628k.d(drawable);
    }

    @Override // W0.r
    public void a() {
        Bitmap bitmapE;
        Drawable drawable = this.f17382a;
        if (drawable instanceof BitmapDrawable) {
            bitmapE = ((BitmapDrawable) drawable).getBitmap();
        } else if (!(drawable instanceof C1848c)) {
            return;
        } else {
            bitmapE = ((C1848c) drawable).e();
        }
        bitmapE.prepareToDraw();
    }

    @Override // W0.v
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final Drawable get() {
        Drawable.ConstantState constantState = this.f17382a.getConstantState();
        return constantState == null ? this.f17382a : constantState.newDrawable();
    }
}
