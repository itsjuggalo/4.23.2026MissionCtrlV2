package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ListView;
import g.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class AlertController$RecycleListView extends ListView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f949b;

    public AlertController$RecycleListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.f9840t1);
        this.f949b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(i.f9844u1, -1);
        this.f948a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(i.f9848v1, -1);
    }
}
