package p0;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class v extends ViewGroup.MarginLayoutParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f9055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9056b;

    public v(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9055a = new Rect();
        this.f9056b = true;
    }

    public v(int i, int i6) {
        super(i, i6);
        this.f9055a = new Rect();
        this.f9056b = true;
    }

    public v(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f9055a = new Rect();
        this.f9056b = true;
    }

    public v(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f9055a = new Rect();
        this.f9056b = true;
    }

    public v(v vVar) {
        super((ViewGroup.LayoutParams) vVar);
        this.f9055a = new Rect();
        this.f9056b = true;
    }
}
