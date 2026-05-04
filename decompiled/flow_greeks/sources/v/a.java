package v;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends FrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f23040h = {R.attr.colorBackground};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final d f23041i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f23042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f23043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f23044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f23045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f23046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Rect f23047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f23048g;

    /* JADX INFO: renamed from: v.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class C0396a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Drawable f23049a;

        public C0396a() {
        }

        @Override // v.c
        public void a(Drawable drawable) {
            this.f23049a = drawable;
            a.this.setBackgroundDrawable(drawable);
        }

        @Override // v.c
        public boolean b() {
            return a.this.getPreventCornerOverlap();
        }

        @Override // v.c
        public boolean c() {
            return a.this.getUseCompatPadding();
        }

        @Override // v.c
        public Drawable d() {
            return this.f23049a;
        }

        @Override // v.c
        public View e() {
            return a.this;
        }

        @Override // v.c
        public void f(int i10, int i11, int i12, int i13) {
            a.this.f23047f.set(i10, i11, i12, i13);
            a aVar = a.this;
            Rect rect = aVar.f23046e;
            a.super.setPadding(i10 + rect.left, i11 + rect.top, i12 + rect.right, i13 + rect.bottom);
        }
    }

    static {
        b bVar = new b();
        f23041i = bVar;
        bVar.i();
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, u.a.f22083a);
    }

    public ColorStateList getCardBackgroundColor() {
        return f23041i.k(this.f23048g);
    }

    public float getCardElevation() {
        return f23041i.a(this.f23048g);
    }

    public int getContentPaddingBottom() {
        return this.f23046e.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f23046e.left;
    }

    public int getContentPaddingRight() {
        return this.f23046e.right;
    }

    public int getContentPaddingTop() {
        return this.f23046e.top;
    }

    public float getMaxCardElevation() {
        return f23041i.h(this.f23048g);
    }

    public boolean getPreventCornerOverlap() {
        return this.f23043b;
    }

    public float getRadius() {
        return f23041i.m(this.f23048g);
    }

    public boolean getUseCompatPadding() {
        return this.f23042a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (f23041i instanceof b) {
            super.onMeasure(i10, i11);
            return;
        }
        int mode = View.MeasureSpec.getMode(i10);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i10 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.d(this.f23048g)), View.MeasureSpec.getSize(i10)), mode);
        }
        int mode2 = View.MeasureSpec.getMode(i11);
        if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
            i11 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.c(this.f23048g)), View.MeasureSpec.getSize(i11)), mode2);
        }
        super.onMeasure(i10, i11);
    }

    public void setCardBackgroundColor(int i10) {
        f23041i.j(this.f23048g, ColorStateList.valueOf(i10));
    }

    public void setCardElevation(float f10) {
        f23041i.n(this.f23048g, f10);
    }

    public void setMaxCardElevation(float f10) {
        f23041i.f(this.f23048g, f10);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i10) {
        this.f23045d = i10;
        super.setMinimumHeight(i10);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i10) {
        this.f23044c = i10;
        super.setMinimumWidth(i10);
    }

    public void setPreventCornerOverlap(boolean z10) {
        if (z10 != this.f23043b) {
            this.f23043b = z10;
            f23041i.b(this.f23048g);
        }
    }

    public void setRadius(float f10) {
        f23041i.g(this.f23048g, f10);
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.f23042a != z10) {
            this.f23042a = z10;
            f23041i.l(this.f23048g);
        }
    }

    public a(Context context, AttributeSet attributeSet, int i10) {
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, i10);
        Rect rect = new Rect();
        this.f23046e = rect;
        this.f23047f = new Rect();
        C0396a c0396a = new C0396a();
        this.f23048g = c0396a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u.d.f22087a, i10, u.c.f22086a);
        if (typedArrayObtainStyledAttributes.hasValue(u.d.f22090d)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(u.d.f22090d);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(f23040h);
            int color = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            colorStateListValueOf = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(u.b.f22085b) : getResources().getColor(u.b.f22084a));
        }
        ColorStateList colorStateList = colorStateListValueOf;
        float dimension = typedArrayObtainStyledAttributes.getDimension(u.d.f22091e, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(u.d.f22092f, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(u.d.f22093g, 0.0f);
        this.f23042a = typedArrayObtainStyledAttributes.getBoolean(u.d.f22095i, false);
        this.f23043b = typedArrayObtainStyledAttributes.getBoolean(u.d.f22094h, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(u.d.f22096j, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(u.d.f22098l, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(u.d.f22100n, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(u.d.f22099m, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(u.d.f22097k, dimensionPixelSize);
        float f10 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f23044c = typedArrayObtainStyledAttributes.getDimensionPixelSize(u.d.f22088b, 0);
        this.f23045d = typedArrayObtainStyledAttributes.getDimensionPixelSize(u.d.f22089c, 0);
        typedArrayObtainStyledAttributes.recycle();
        f23041i.e(c0396a, context, colorStateList, dimension, dimension2, f10);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f23041i.j(this.f23048g, colorStateList);
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
    }
}
