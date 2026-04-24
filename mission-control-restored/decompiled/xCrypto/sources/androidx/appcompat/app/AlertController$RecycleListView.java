package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ListView;
import g.i;

/* JADX INFO: loaded from: classes.dex */
public class AlertController$RecycleListView extends ListView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6321b;

    public AlertController$RecycleListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.f11894z1);
        this.f6321b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(i.f11680A1, -1);
        this.f6320a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(i.f11684B1, -1);
    }
}
