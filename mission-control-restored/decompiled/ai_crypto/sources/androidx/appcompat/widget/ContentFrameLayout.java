package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TypedValue f6729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TypedValue f6730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TypedValue f6731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TypedValue f6732d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TypedValue f6733e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TypedValue f6734f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Rect f6735g;

    public interface a {
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f6733e == null) {
            this.f6733e = new TypedValue();
        }
        return this.f6733e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f6734f == null) {
            this.f6734f = new TypedValue();
        }
        return this.f6734f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f6731c == null) {
            this.f6731c = new TypedValue();
        }
        return this.f6731c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f6732d == null) {
            this.f6732d = new TypedValue();
        }
        return this.f6732d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f6729a == null) {
            this.f6729a = new TypedValue();
        }
        return this.f6729a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f6730b == null) {
            this.f6730b = new TypedValue();
        }
        return this.f6730b;
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

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f6735g = new Rect();
    }
}
