package h;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import g.i;

/* JADX INFO: renamed from: h.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1270a extends ViewGroup.MarginLayoutParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11970a;

    public AbstractC1270a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11970a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.f11860r);
        this.f11970a = typedArrayObtainStyledAttributes.getInt(i.f11864s, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public AbstractC1270a(int i4, int i5) {
        super(i4, i5);
        this.f11970a = 8388627;
    }

    public AbstractC1270a(AbstractC1270a abstractC1270a) {
        super((ViewGroup.MarginLayoutParams) abstractC1270a);
        this.f11970a = 0;
        this.f11970a = abstractC1270a.f11970a;
    }

    public AbstractC1270a(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f11970a = 0;
    }
}
