package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TypedValue f6576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TypedValue f6577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TypedValue f6578c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TypedValue f6579e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TypedValue f6580f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TypedValue f6581g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Rect f6582h;

    public interface a {
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(Rect rect) {
        fitSystemWindows(rect);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f6580f == null) {
            this.f6580f = new TypedValue();
        }
        return this.f6580f;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f6581g == null) {
            this.f6581g = new TypedValue();
        }
        return this.f6581g;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f6578c == null) {
            this.f6578c = new TypedValue();
        }
        return this.f6578c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f6579e == null) {
            this.f6579e = new TypedValue();
        }
        return this.f6579e;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f6576a == null) {
            this.f6576a = new TypedValue();
        }
        return this.f6576a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f6577b == null) {
            this.f6577b = new TypedValue();
        }
        return this.f6577b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00db  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(a aVar) {
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f6582h = new Rect();
    }
}
