package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import m.J;

/* JADX INFO: loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TypedValue f4286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TypedValue f4287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TypedValue f4288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TypedValue f4289d;
    public TypedValue e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TypedValue f4290f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Rect f4291k;

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f4291k = new Rect();
    }

    public TypedValue getFixedHeightMajor() {
        if (this.e == null) {
            this.e = new TypedValue();
        }
        return this.e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f4290f == null) {
            this.f4290f = new TypedValue();
        }
        return this.f4290f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f4288c == null) {
            this.f4288c = new TypedValue();
        }
        return this.f4288c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f4289d == null) {
            this.f4289d = new TypedValue();
        }
        return this.f4289d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f4286a == null) {
            this.f4286a = new TypedValue();
        }
        return this.f4286a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f4287b == null) {
            this.f4287b = new TypedValue();
        }
        return this.f4287b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00de  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(J j4) {
    }
}
