package h;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import g.i;

/* JADX INFO: renamed from: h.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1841a extends ViewGroup.MarginLayoutParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f18308a;

    public AbstractC1841a(int i8, int i9) {
        super(i8, i9);
        this.f18308a = 8388627;
    }

    public AbstractC1841a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18308a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.f17929r);
        this.f18308a = typedArrayObtainStyledAttributes.getInt(i.f17933s, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public AbstractC1841a(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f18308a = 0;
    }

    public AbstractC1841a(AbstractC1841a abstractC1841a) {
        super((ViewGroup.MarginLayoutParams) abstractC1841a);
        this.f18308a = 0;
        this.f18308a = abstractC1841a.f18308a;
    }
}
