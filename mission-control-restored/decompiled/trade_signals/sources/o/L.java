package o;

import K.f;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import i.AbstractC1906a;

/* JADX INFO: loaded from: classes.dex */
public class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypedArray f21775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TypedValue f21776c;

    public L(Context context, TypedArray typedArray) {
        this.f21774a = context;
        this.f21775b = typedArray;
    }

    public static L q(Context context, int i8, int[] iArr) {
        return new L(context, context.obtainStyledAttributes(i8, iArr));
    }

    public static L r(Context context, AttributeSet attributeSet, int[] iArr) {
        return new L(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static L s(Context context, AttributeSet attributeSet, int[] iArr, int i8, int i9) {
        return new L(context, context.obtainStyledAttributes(attributeSet, iArr, i8, i9));
    }

    public boolean a(int i8, boolean z7) {
        return this.f21775b.getBoolean(i8, z7);
    }

    public int b(int i8, int i9) {
        return this.f21775b.getColor(i8, i9);
    }

    public ColorStateList c(int i8) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!this.f21775b.hasValue(i8) || (resourceId = this.f21775b.getResourceId(i8, 0)) == 0 || (colorStateListA = AbstractC1906a.a(this.f21774a, resourceId)) == null) ? this.f21775b.getColorStateList(i8) : colorStateListA;
    }

    public int d(int i8, int i9) {
        return this.f21775b.getDimensionPixelOffset(i8, i9);
    }

    public int e(int i8, int i9) {
        return this.f21775b.getDimensionPixelSize(i8, i9);
    }

    public Drawable f(int i8) {
        int resourceId;
        return (!this.f21775b.hasValue(i8) || (resourceId = this.f21775b.getResourceId(i8, 0)) == 0) ? this.f21775b.getDrawable(i8) : AbstractC1906a.b(this.f21774a, resourceId);
    }

    public float g(int i8, float f8) {
        return this.f21775b.getFloat(i8, f8);
    }

    public Typeface h(int i8, int i9, f.e eVar) {
        int resourceId = this.f21775b.getResourceId(i8, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f21776c == null) {
            this.f21776c = new TypedValue();
        }
        return K.f.f(this.f21774a, resourceId, this.f21776c, i9, eVar);
    }

    public int i(int i8, int i9) {
        return this.f21775b.getInt(i8, i9);
    }

    public int j(int i8, int i9) {
        return this.f21775b.getInteger(i8, i9);
    }

    public int k(int i8, int i9) {
        return this.f21775b.getLayoutDimension(i8, i9);
    }

    public int l(int i8, int i9) {
        return this.f21775b.getResourceId(i8, i9);
    }

    public String m(int i8) {
        return this.f21775b.getString(i8);
    }

    public CharSequence n(int i8) {
        return this.f21775b.getText(i8);
    }

    public TypedArray o() {
        return this.f21775b;
    }

    public boolean p(int i8) {
        return this.f21775b.hasValue(i8);
    }

    public TypedValue t(int i8) {
        return this.f21775b.peekValue(i8);
    }

    public void u() {
        this.f21775b.recycle();
    }
}
