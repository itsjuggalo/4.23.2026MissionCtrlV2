package androidx.preference.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import s0.g;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12125b;

    public PreferenceImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.ImageView
    public int getMaxHeight() {
        return this.f12125b;
    }

    @Override // android.widget.ImageView
    public int getMaxWidth() {
        return this.f12124a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i8, int i9) {
        int mode = View.MeasureSpec.getMode(i8);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int size = View.MeasureSpec.getSize(i8);
            int maxWidth = getMaxWidth();
            if (maxWidth != Integer.MAX_VALUE && (maxWidth < size || mode == 0)) {
                i8 = View.MeasureSpec.makeMeasureSpec(maxWidth, Integer.MIN_VALUE);
            }
        }
        int mode2 = View.MeasureSpec.getMode(i9);
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            int size2 = View.MeasureSpec.getSize(i9);
            int maxHeight = getMaxHeight();
            if (maxHeight != Integer.MAX_VALUE && (maxHeight < size2 || mode2 == 0)) {
                i9 = View.MeasureSpec.makeMeasureSpec(maxHeight, Integer.MIN_VALUE);
            }
        }
        super.onMeasure(i8, i9);
    }

    @Override // android.widget.ImageView
    public void setMaxHeight(int i8) {
        this.f12125b = i8;
        super.setMaxHeight(i8);
    }

    @Override // android.widget.ImageView
    public void setMaxWidth(int i8) {
        this.f12124a = i8;
        super.setMaxWidth(i8);
    }

    public PreferenceImageView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f12124a = Integer.MAX_VALUE;
        this.f12125b = Integer.MAX_VALUE;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f23062y0, i8, 0);
        setMaxWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(g.f22957A0, Integer.MAX_VALUE));
        setMaxHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(g.f23064z0, Integer.MAX_VALUE));
        typedArrayObtainStyledAttributes.recycle();
    }
}
