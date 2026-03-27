package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import i.AbstractC1284a;
import y.AbstractC1931f;

/* JADX INFO: loaded from: classes.dex */
public class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypedArray f13805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TypedValue f13806c;

    public a0(Context context, TypedArray typedArray) {
        this.f13804a = context;
        this.f13805b = typedArray;
    }

    public static a0 p(Context context, int i4, int[] iArr) {
        return new a0(context, context.obtainStyledAttributes(i4, iArr));
    }

    public static a0 q(Context context, AttributeSet attributeSet, int[] iArr) {
        return new a0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static a0 r(Context context, AttributeSet attributeSet, int[] iArr, int i4, int i5) {
        return new a0(context, context.obtainStyledAttributes(attributeSet, iArr, i4, i5));
    }

    public boolean a(int i4, boolean z4) {
        return this.f13805b.getBoolean(i4, z4);
    }

    public int b(int i4, int i5) {
        return this.f13805b.getColor(i4, i5);
    }

    public ColorStateList c(int i4) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!this.f13805b.hasValue(i4) || (resourceId = this.f13805b.getResourceId(i4, 0)) == 0 || (colorStateListA = AbstractC1284a.a(this.f13804a, resourceId)) == null) ? this.f13805b.getColorStateList(i4) : colorStateListA;
    }

    public int d(int i4, int i5) {
        return this.f13805b.getDimensionPixelOffset(i4, i5);
    }

    public int e(int i4, int i5) {
        return this.f13805b.getDimensionPixelSize(i4, i5);
    }

    public Drawable f(int i4) {
        int resourceId;
        return (!this.f13805b.hasValue(i4) || (resourceId = this.f13805b.getResourceId(i4, 0)) == 0) ? this.f13805b.getDrawable(i4) : AbstractC1284a.b(this.f13804a, resourceId);
    }

    public float g(int i4, float f4) {
        return this.f13805b.getFloat(i4, f4);
    }

    public Typeface h(int i4, int i5, AbstractC1931f.d dVar) {
        int resourceId = this.f13805b.getResourceId(i4, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f13806c == null) {
            this.f13806c = new TypedValue();
        }
        return AbstractC1931f.d(this.f13804a, resourceId, this.f13806c, i5, dVar);
    }

    public int i(int i4, int i5) {
        return this.f13805b.getInt(i4, i5);
    }

    public int j(int i4, int i5) {
        return this.f13805b.getInteger(i4, i5);
    }

    public int k(int i4, int i5) {
        return this.f13805b.getLayoutDimension(i4, i5);
    }

    public int l(int i4, int i5) {
        return this.f13805b.getResourceId(i4, i5);
    }

    public String m(int i4) {
        return this.f13805b.getString(i4);
    }

    public CharSequence n(int i4) {
        return this.f13805b.getText(i4);
    }

    public boolean o(int i4) {
        return this.f13805b.hasValue(i4);
    }

    public void s() {
        this.f13805b.recycle();
    }
}
