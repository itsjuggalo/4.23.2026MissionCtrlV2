package com.google.android.material.datepicker;

import Q.N;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import z2.AbstractC2881c;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f11507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ColorStateList f11508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ColorStateList f11509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ColorStateList f11510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f11511e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C2.k f11512f;

    public b(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i7, C2.k kVar, Rect rect) {
        P.f.d(rect.left);
        P.f.d(rect.top);
        P.f.d(rect.right);
        P.f.d(rect.bottom);
        this.f11507a = rect;
        this.f11508b = colorStateList2;
        this.f11509c = colorStateList;
        this.f11510d = colorStateList3;
        this.f11511e = i7;
        this.f11512f = kVar;
    }

    public static b a(Context context, int i7) {
        P.f.a(i7 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i7, n2.j.f19600x2);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(n2.j.f19607y2, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(n2.j.f19261A2, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(n2.j.f19614z2, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(n2.j.f19268B2, 0));
        ColorStateList colorStateListA = AbstractC2881c.a(context, typedArrayObtainStyledAttributes, n2.j.f19275C2);
        ColorStateList colorStateListA2 = AbstractC2881c.a(context, typedArrayObtainStyledAttributes, n2.j.f19310H2);
        ColorStateList colorStateListA3 = AbstractC2881c.a(context, typedArrayObtainStyledAttributes, n2.j.f19296F2);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(n2.j.f19303G2, 0);
        C2.k kVarM = C2.k.b(context, typedArrayObtainStyledAttributes.getResourceId(n2.j.f19282D2, 0), typedArrayObtainStyledAttributes.getResourceId(n2.j.f19289E2, 0)).m();
        typedArrayObtainStyledAttributes.recycle();
        return new b(colorStateListA, colorStateListA2, colorStateListA3, dimensionPixelSize, kVarM, rect);
    }

    public void b(TextView textView) {
        C2.g gVar = new C2.g();
        C2.g gVar2 = new C2.g();
        gVar.setShapeAppearanceModel(this.f11512f);
        gVar2.setShapeAppearanceModel(this.f11512f);
        gVar.U(this.f11509c);
        gVar.Z(this.f11511e, this.f11510d);
        textView.setTextColor(this.f11508b);
        RippleDrawable rippleDrawable = new RippleDrawable(this.f11508b.withAlpha(30), gVar, gVar2);
        Rect rect = this.f11507a;
        N.p0(textView, new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
