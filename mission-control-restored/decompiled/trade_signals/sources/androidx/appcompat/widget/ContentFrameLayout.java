package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TypedValue f10625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TypedValue f10626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TypedValue f10627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TypedValue f10628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TypedValue f10629e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TypedValue f10630f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Rect f10631g;

    public interface a {
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f10629e == null) {
            this.f10629e = new TypedValue();
        }
        return this.f10629e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f10630f == null) {
            this.f10630f = new TypedValue();
        }
        return this.f10630f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f10627c == null) {
            this.f10627c = new TypedValue();
        }
        return this.f10627c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f10628d == null) {
            this.f10628d = new TypedValue();
        }
        return this.f10628d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f10625a == null) {
            this.f10625a = new TypedValue();
        }
        return this.f10625a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f10626b == null) {
            this.f10626b = new TypedValue();
        }
        return this.f10626b;
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

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f10631g = new Rect();
    }
}
