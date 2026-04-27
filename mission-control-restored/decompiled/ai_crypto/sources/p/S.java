package p;

import H.f;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import j.AbstractC2040a;

/* JADX INFO: loaded from: classes.dex */
public class S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypedArray f21303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TypedValue f21304c;

    public S(Context context, TypedArray typedArray) {
        this.f21302a = context;
        this.f21303b = typedArray;
    }

    public static S r(Context context, int i7, int[] iArr) {
        return new S(context, context.obtainStyledAttributes(i7, iArr));
    }

    public static S s(Context context, AttributeSet attributeSet, int[] iArr) {
        return new S(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static S t(Context context, AttributeSet attributeSet, int[] iArr, int i7, int i8) {
        return new S(context, context.obtainStyledAttributes(attributeSet, iArr, i7, i8));
    }

    public boolean a(int i7, boolean z7) {
        return this.f21303b.getBoolean(i7, z7);
    }

    public int b(int i7, int i8) {
        return this.f21303b.getColor(i7, i8);
    }

    public ColorStateList c(int i7) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!this.f21303b.hasValue(i7) || (resourceId = this.f21303b.getResourceId(i7, 0)) == 0 || (colorStateListA = AbstractC2040a.a(this.f21302a, resourceId)) == null) ? this.f21303b.getColorStateList(i7) : colorStateListA;
    }

    public float d(int i7, float f7) {
        return this.f21303b.getDimension(i7, f7);
    }

    public int e(int i7, int i8) {
        return this.f21303b.getDimensionPixelOffset(i7, i8);
    }

    public int f(int i7, int i8) {
        return this.f21303b.getDimensionPixelSize(i7, i8);
    }

    public Drawable g(int i7) {
        int resourceId;
        return (!this.f21303b.hasValue(i7) || (resourceId = this.f21303b.getResourceId(i7, 0)) == 0) ? this.f21303b.getDrawable(i7) : AbstractC2040a.b(this.f21302a, resourceId);
    }

    public float h(int i7, float f7) {
        return this.f21303b.getFloat(i7, f7);
    }

    public Typeface i(int i7, int i8, f.e eVar) {
        int resourceId = this.f21303b.getResourceId(i7, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f21304c == null) {
            this.f21304c = new TypedValue();
        }
        return H.f.h(this.f21302a, resourceId, this.f21304c, i8, eVar);
    }

    public int j(int i7, int i8) {
        return this.f21303b.getInt(i7, i8);
    }

    public int k(int i7, int i8) {
        return this.f21303b.getInteger(i7, i8);
    }

    public int l(int i7, int i8) {
        return this.f21303b.getLayoutDimension(i7, i8);
    }

    public int m(int i7, int i8) {
        return this.f21303b.getResourceId(i7, i8);
    }

    public String n(int i7) {
        return this.f21303b.getString(i7);
    }

    public CharSequence o(int i7) {
        return this.f21303b.getText(i7);
    }

    public TypedArray p() {
        return this.f21303b;
    }

    public boolean q(int i7) {
        return this.f21303b.hasValue(i7);
    }

    public void u() {
        this.f21303b.recycle();
    }
}
