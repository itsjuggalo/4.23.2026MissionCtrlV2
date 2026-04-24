package A2;

import C2.g;
import C2.k;
import C2.n;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class a extends Drawable implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f97a;

    @Override // android.graphics.drawable.Drawable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a mutate() {
        this.f97a = new b(this.f97a);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.f97a;
        if (bVar.f99b) {
            bVar.f98a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f97a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f97a.f98a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f97a.f98a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        if (this.f97a.f98a.setState(iArr)) {
            zOnStateChange = true;
        }
        boolean zB = A2.b.b(iArr);
        b bVar = this.f97a;
        if (bVar.f99b == zB) {
            return zOnStateChange;
        }
        bVar.f99b = zB;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i7) {
        this.f97a.f98a.setAlpha(i7);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f97a.f98a.setColorFilter(colorFilter);
    }

    @Override // C2.n
    public void setShapeAppearanceModel(k kVar) {
        this.f97a.f98a.setShapeAppearanceModel(kVar);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i7) {
        this.f97a.f98a.setTint(i7);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f97a.f98a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f97a.f98a.setTintMode(mode);
    }

    public a(k kVar) {
        this(new b(new g(kVar)));
    }

    public static final class b extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g f98a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f99b;

        public b(g gVar) {
            this.f98a = gVar;
            this.f99b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a newDrawable() {
            return new a(new b(this));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        public b(b bVar) {
            this.f98a = (g) bVar.f98a.getConstantState().newDrawable();
            this.f99b = bVar.f99b;
        }
    }

    public a(b bVar) {
        this.f97a = bVar;
    }
}
