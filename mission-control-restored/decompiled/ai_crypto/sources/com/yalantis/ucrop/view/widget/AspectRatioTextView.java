package com.yalantis.ucrop.view.widget;

import B4.b;
import B4.f;
import G.a;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import java.util.Locale;
import p.C2358t;

/* JADX INFO: loaded from: classes2.dex */
public class AspectRatioTextView extends C2358t {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f13033h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Rect f13034i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Paint f13035j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f13036k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f13037l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f13038m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f13039n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f13040o;

    public AspectRatioTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSelected()) {
            canvas.getClipBounds(this.f13034i);
            Rect rect = this.f13034i;
            float f7 = (rect.right - rect.left) / 2.0f;
            float f8 = rect.bottom - (rect.top / 2.0f);
            int i7 = this.f13036k;
            canvas.drawCircle(f7, f8 - (i7 * 1.5f), i7 / 2.0f, this.f13035j);
        }
    }

    public final void r(int i7) {
        Paint paint = this.f13035j;
        if (paint != null) {
            paint.setColor(i7);
        }
        setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[]{0}}, new int[]{i7, a.getColor(getContext(), B4.a.f751e)}));
    }

    public final void s(TypedArray typedArray) {
        setGravity(1);
        this.f13038m = typedArray.getString(f.f792Y);
        this.f13039n = typedArray.getFloat(f.f793Z, 0.0f);
        float f7 = typedArray.getFloat(f.f795a0, 0.0f);
        this.f13040o = f7;
        float f8 = this.f13039n;
        if (f8 == 0.0f || f7 == 0.0f) {
            this.f13037l = 0.0f;
        } else {
            this.f13037l = f8 / f7;
        }
        this.f13036k = getContext().getResources().getDimensionPixelSize(b.f761h);
        Paint paint = new Paint(1);
        this.f13035j = paint;
        paint.setStyle(Paint.Style.FILL);
        t();
        r(getResources().getColor(B4.a.f752f));
        typedArray.recycle();
    }

    public void setActiveColor(int i7) {
        r(i7);
        invalidate();
    }

    public void setAspectRatio(D4.a aVar) {
        this.f13038m = aVar.a();
        this.f13039n = aVar.c();
        float fD = aVar.d();
        this.f13040o = fD;
        float f7 = this.f13039n;
        if (f7 == 0.0f || fD == 0.0f) {
            this.f13037l = 0.0f;
        } else {
            this.f13037l = f7 / fD;
        }
        t();
    }

    public final void t() {
        if (TextUtils.isEmpty(this.f13038m)) {
            setText(String.format(Locale.US, "%d:%d", Integer.valueOf((int) this.f13039n), Integer.valueOf((int) this.f13040o)));
        } else {
            setText(this.f13038m);
        }
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f13033h = 1.5f;
        this.f13034i = new Rect();
        s(context.obtainStyledAttributes(attributeSet, f.f791X));
    }
}
