package com.google.android.material.snackbar;

import Q.N;
import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import n2.c;
import n2.e;

/* JADX INFO: loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f11659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Button f11660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11661c;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static void a(View view, int i7, int i8) {
        if (N.R(view)) {
            N.A0(view, N.E(view), i7, N.D(view), i8);
        } else {
            view.setPadding(view.getPaddingLeft(), i7, view.getPaddingRight(), i8);
        }
    }

    public final boolean b(int i7, int i8, int i9) {
        boolean z7;
        if (i7 != getOrientation()) {
            setOrientation(i7);
            z7 = true;
        } else {
            z7 = false;
        }
        if (this.f11659a.getPaddingTop() == i8 && this.f11659a.getPaddingBottom() == i9) {
            return z7;
        }
        a(this.f11659a, i8, i9);
        return true;
    }

    public Button getActionView() {
        return this.f11660b;
    }

    public TextView getMessageView() {
        return this.f11659a;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f11659a = (TextView) findViewById(e.f19179E);
        this.f11660b = (Button) findViewById(e.f19178D);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i7, int i8) {
        super.onMeasure(i7, i8);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(c.f19145d);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(c.f19144c);
        Layout layout = this.f11659a.getLayout();
        boolean z7 = layout != null && layout.getLineCount() > 1;
        if (!z7 || this.f11661c <= 0 || this.f11660b.getMeasuredWidth() <= this.f11661c) {
            if (!z7) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!b(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!b(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i7, i8);
    }

    public void setMaxInlineActionWidth(int i7) {
        this.f11661c = i7;
    }
}
