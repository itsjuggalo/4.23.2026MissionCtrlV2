package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import o.a0;

/* JADX INFO: loaded from: classes.dex */
public class ActivityChooserView$InnerLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f6572a = {R.attr.background};

    public ActivityChooserView$InnerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a0 a0VarQ = a0.q(context, attributeSet, f6572a);
        setBackgroundDrawable(a0VarQ.f(0));
        a0VarQ.s();
    }
}
