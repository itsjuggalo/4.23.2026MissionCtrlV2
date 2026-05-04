package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TypedValue f1192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TypedValue f1193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TypedValue f1194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TypedValue f1195d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TypedValue f1196e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TypedValue f1197f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Rect f1198g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f1196e == null) {
            this.f1196e = new TypedValue();
        }
        return this.f1196e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f1197f == null) {
            this.f1197f = new TypedValue();
        }
        return this.f1197f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f1194c == null) {
            this.f1194c = new TypedValue();
        }
        return this.f1194c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f1195d == null) {
            this.f1195d = new TypedValue();
        }
        return this.f1195d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f1192a == null) {
            this.f1192a = new TypedValue();
        }
        return this.f1192a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f1193b == null) {
            this.f1193b = new TypedValue();
        }
        return this.f1193b;
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

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1198g = new Rect();
    }

    public void setAttachListener(a aVar) {
    }
}
