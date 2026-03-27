package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ListView;
import g.i;

/* JADX INFO: loaded from: classes.dex */
public class AlertController$RecycleListView extends ListView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10364b;

    public AlertController$RecycleListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.f17939t1);
        this.f10364b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(i.f17943u1, -1);
        this.f10363a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(i.f17947v1, -1);
    }
}
