package v;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import u.AbstractC2760a;
import u.AbstractC2761b;
import u.AbstractC2762c;
import u.AbstractC2763d;

/* JADX INFO: renamed from: v.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2832a extends FrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f23683h = {R.attr.colorBackground};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final d f23684i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f23685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f23686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f23687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f23688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f23689e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Rect f23690f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f23691g;

    /* JADX INFO: renamed from: v.a$a, reason: collision with other inner class name */
    public class C0412a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Drawable f23692a;

        public C0412a() {
        }

        @Override // v.c
        public void a(Drawable drawable) {
            this.f23692a = drawable;
            AbstractC2832a.this.setBackgroundDrawable(drawable);
        }

        @Override // v.c
        public boolean b() {
            return AbstractC2832a.this.getPreventCornerOverlap();
        }

        @Override // v.c
        public boolean c() {
            return AbstractC2832a.this.getUseCompatPadding();
        }

        @Override // v.c
        public Drawable d() {
            return this.f23692a;
        }

        @Override // v.c
        public View e() {
            return AbstractC2832a.this;
        }

        @Override // v.c
        public void f(int i8, int i9, int i10, int i11) {
            AbstractC2832a.this.f23690f.set(i8, i9, i10, i11);
            AbstractC2832a abstractC2832a = AbstractC2832a.this;
            Rect rect = abstractC2832a.f23689e;
            AbstractC2832a.super.setPadding(i8 + rect.left, i9 + rect.top, i10 + rect.right, i11 + rect.bottom);
        }
    }

    static {
        b bVar = new b();
        f23684i = bVar;
        bVar.i();
    }

    public AbstractC2832a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC2760a.f23481a);
    }

    public ColorStateList getCardBackgroundColor() {
        return f23684i.k(this.f23691g);
    }

    public float getCardElevation() {
        return f23684i.a(this.f23691g);
    }

    public int getContentPaddingBottom() {
        return this.f23689e.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f23689e.left;
    }

    public int getContentPaddingRight() {
        return this.f23689e.right;
    }

    public int getContentPaddingTop() {
        return this.f23689e.top;
    }

    public float getMaxCardElevation() {
        return f23684i.h(this.f23691g);
    }

    public boolean getPreventCornerOverlap() {
        return this.f23686b;
    }

    public float getRadius() {
        return f23684i.m(this.f23691g);
    }

    public boolean getUseCompatPadding() {
        return this.f23685a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i8, int i9) {
        if (!(f23684i instanceof b)) {
            int mode = View.MeasureSpec.getMode(i8);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i8 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.d(this.f23691g)), View.MeasureSpec.getSize(i8)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i9);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i9 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.c(this.f23691g)), View.MeasureSpec.getSize(i9)), mode2);
            }
        }
        super.onMeasure(i8, i9);
    }

    public void setCardBackgroundColor(int i8) {
        f23684i.j(this.f23691g, ColorStateList.valueOf(i8));
    }

    public void setCardElevation(float f8) {
        f23684i.n(this.f23691g, f8);
    }

    public void setMaxCardElevation(float f8) {
        f23684i.f(this.f23691g, f8);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i8) {
        this.f23688d = i8;
        super.setMinimumHeight(i8);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i8) {
        this.f23687c = i8;
        super.setMinimumWidth(i8);
    }

    public void setPreventCornerOverlap(boolean z7) {
        if (z7 != this.f23686b) {
            this.f23686b = z7;
            f23684i.b(this.f23691g);
        }
    }

    public void setRadius(float f8) {
        f23684i.g(this.f23691g, f8);
    }

    public void setUseCompatPadding(boolean z7) {
        if (this.f23685a != z7) {
            this.f23685a = z7;
            f23684i.l(this.f23691g);
        }
    }

    public AbstractC2832a(Context context, AttributeSet attributeSet, int i8) {
        Resources resources;
        int i9;
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, i8);
        Rect rect = new Rect();
        this.f23689e = rect;
        this.f23690f = new Rect();
        C0412a c0412a = new C0412a();
        this.f23691g = c0412a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC2763d.f23485a, i8, AbstractC2762c.f23484a);
        if (typedArrayObtainStyledAttributes.hasValue(AbstractC2763d.f23488d)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(AbstractC2763d.f23488d);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(f23683h);
            int color = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                resources = getResources();
                i9 = AbstractC2761b.f23483b;
            } else {
                resources = getResources();
                i9 = AbstractC2761b.f23482a;
            }
            colorStateListValueOf = ColorStateList.valueOf(resources.getColor(i9));
        }
        ColorStateList colorStateList = colorStateListValueOf;
        float dimension = typedArrayObtainStyledAttributes.getDimension(AbstractC2763d.f23489e, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(AbstractC2763d.f23490f, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(AbstractC2763d.f23491g, 0.0f);
        this.f23685a = typedArrayObtainStyledAttributes.getBoolean(AbstractC2763d.f23493i, false);
        this.f23686b = typedArrayObtainStyledAttributes.getBoolean(AbstractC2763d.f23492h, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC2763d.f23494j, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC2763d.f23496l, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC2763d.f23498n, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC2763d.f23497m, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC2763d.f23495k, dimensionPixelSize);
        float f8 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f23687c = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC2763d.f23486b, 0);
        this.f23688d = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC2763d.f23487c, 0);
        typedArrayObtainStyledAttributes.recycle();
        f23684i.e(c0412a, context, colorStateList, dimension, dimension2, f8);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f23684i.j(this.f23691g, colorStateList);
    }

    @Override // android.view.View
    public void setPadding(int i8, int i9, int i10, int i11) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i8, int i9, int i10, int i11) {
    }
}
