package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import k0.f;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f17285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypedArray f17286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TypedValue f17287c;

    public j0(Context context, TypedArray typedArray) {
        this.f17285a = context;
        this.f17286b = typedArray;
    }

    public static j0 q(Context context, int i10, int[] iArr) {
        return new j0(context, context.obtainStyledAttributes(i10, iArr));
    }

    public static j0 r(Context context, AttributeSet attributeSet, int[] iArr) {
        return new j0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static j0 s(Context context, AttributeSet attributeSet, int[] iArr, int i10, int i11) {
        return new j0(context, context.obtainStyledAttributes(attributeSet, iArr, i10, i11));
    }

    public boolean a(int i10, boolean z10) {
        return this.f17286b.getBoolean(i10, z10);
    }

    public int b(int i10, int i11) {
        return this.f17286b.getColor(i10, i11);
    }

    public ColorStateList c(int i10) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!this.f17286b.hasValue(i10) || (resourceId = this.f17286b.getResourceId(i10, 0)) == 0 || (colorStateListA = i.a.a(this.f17285a, resourceId)) == null) ? this.f17286b.getColorStateList(i10) : colorStateListA;
    }

    public int d(int i10, int i11) {
        return this.f17286b.getDimensionPixelOffset(i10, i11);
    }

    public int e(int i10, int i11) {
        return this.f17286b.getDimensionPixelSize(i10, i11);
    }

    public Drawable f(int i10) {
        int resourceId;
        return (!this.f17286b.hasValue(i10) || (resourceId = this.f17286b.getResourceId(i10, 0)) == 0) ? this.f17286b.getDrawable(i10) : i.a.b(this.f17285a, resourceId);
    }

    public float g(int i10, float f10) {
        return this.f17286b.getFloat(i10, f10);
    }

    public Typeface h(int i10, int i11, f.e eVar) {
        int resourceId = this.f17286b.getResourceId(i10, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f17287c == null) {
            this.f17287c = new TypedValue();
        }
        return k0.f.f(this.f17285a, resourceId, this.f17287c, i11, eVar);
    }

    public int i(int i10, int i11) {
        return this.f17286b.getInt(i10, i11);
    }

    public int j(int i10, int i11) {
        return this.f17286b.getInteger(i10, i11);
    }

    public int k(int i10, int i11) {
        return this.f17286b.getLayoutDimension(i10, i11);
    }

    public int l(int i10, int i11) {
        return this.f17286b.getResourceId(i10, i11);
    }

    public String m(int i10) {
        return this.f17286b.getString(i10);
    }

    public CharSequence n(int i10) {
        return this.f17286b.getText(i10);
    }

    public TypedArray o() {
        return this.f17286b;
    }

    public boolean p(int i10) {
        return this.f17286b.hasValue(i10);
    }

    public TypedValue t(int i10) {
        return this.f17286b.peekValue(i10);
    }

    public void u() {
        this.f17286b.recycle();
    }
}
