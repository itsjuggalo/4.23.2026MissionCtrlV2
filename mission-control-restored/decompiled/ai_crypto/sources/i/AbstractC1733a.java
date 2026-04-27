package i;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import h.AbstractC1664i;

/* JADX INFO: renamed from: i.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1733a extends ViewGroup.MarginLayoutParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14980a;

    public AbstractC1733a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14980a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1664i.f14654r);
        this.f14980a = typedArrayObtainStyledAttributes.getInt(AbstractC1664i.f14658s, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public AbstractC1733a(int i7, int i8) {
        super(i7, i8);
        this.f14980a = 8388627;
    }

    public AbstractC1733a(AbstractC1733a abstractC1733a) {
        super((ViewGroup.MarginLayoutParams) abstractC1733a);
        this.f14980a = 0;
        this.f14980a = abstractC1733a.f14980a;
    }

    public AbstractC1733a(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f14980a = 0;
    }
}
