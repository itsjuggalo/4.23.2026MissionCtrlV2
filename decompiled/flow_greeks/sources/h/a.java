package h;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import g.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends ViewGroup.MarginLayoutParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10789a;

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10789a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.f9830r);
        this.f10789a = typedArrayObtainStyledAttributes.getInt(i.f9834s, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public a(int i10, int i11) {
        super(i10, i11);
        this.f10789a = 8388627;
    }

    public a(a aVar) {
        super((ViewGroup.MarginLayoutParams) aVar);
        this.f10789a = 0;
        this.f10789a = aVar.f10789a;
    }

    public a(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f10789a = 0;
    }
}
