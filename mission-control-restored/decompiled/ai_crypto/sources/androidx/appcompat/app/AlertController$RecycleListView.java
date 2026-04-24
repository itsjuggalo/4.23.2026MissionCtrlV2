package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ListView;
import h.AbstractC1664i;

/* JADX INFO: loaded from: classes.dex */
public class AlertController$RecycleListView extends ListView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6471b;

    public AlertController$RecycleListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1664i.f14680x1);
        this.f6471b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(AbstractC1664i.f14684y1, -1);
        this.f6470a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(AbstractC1664i.f14688z1, -1);
    }
}
