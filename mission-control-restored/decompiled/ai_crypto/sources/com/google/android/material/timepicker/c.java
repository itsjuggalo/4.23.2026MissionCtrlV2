package com.google.android.material.timepicker;

import C2.g;
import C2.i;
import Q.N;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import n2.j;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends ConstraintLayout {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Runnable f11830x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f11831y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public g f11832z;

    public c(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        LayoutInflater.from(context).inflate(n2.g.f19220f, this);
        N.p0(this, t());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f19538o3, i7, 0);
        this.f11831y = typedArrayObtainStyledAttributes.getDimensionPixelSize(j.f19545p3, 0);
        this.f11830x = new Runnable() { // from class: com.google.android.material.timepicker.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f11829a.x();
            }
        };
        typedArrayObtainStyledAttributes.recycle();
    }

    public static boolean w(View view) {
        return "skip".equals(view.getTag());
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void addView(View view, int i7, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i7, layoutParams);
        if (view.getId() == -1) {
            view.setId(N.j());
        }
        y();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        x();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        y();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i7) {
        this.f11832z.U(ColorStateList.valueOf(i7));
    }

    public final Drawable t() {
        g gVar = new g();
        this.f11832z = gVar;
        gVar.S(new i(0.5f));
        this.f11832z.U(ColorStateList.valueOf(-1));
        return this.f11832z;
    }

    public int u() {
        return this.f11831y;
    }

    public void v(int i7) {
        this.f11831y = i7;
        x();
    }

    public void x() {
        int childCount = getChildCount();
        int i7 = 1;
        for (int i8 = 0; i8 < childCount; i8++) {
            if (w(getChildAt(i8))) {
                i7++;
            }
        }
        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
        cVar.g(this);
        float f7 = 0.0f;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getId() != n2.e.f19189b && !w(childAt)) {
                cVar.h(childAt.getId(), n2.e.f19189b, this.f11831y, f7);
                f7 += 360.0f / (childCount - i7);
            }
        }
        cVar.c(this);
    }

    public final void y() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f11830x);
            handler.post(this.f11830x);
        }
    }
}
