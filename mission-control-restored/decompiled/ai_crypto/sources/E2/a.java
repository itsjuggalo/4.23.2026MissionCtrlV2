package E2;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import n.C2247c;
import n2.AbstractC2252a;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f1620a = {R.attr.theme, AbstractC2252a.f19120x};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1621b = {AbstractC2252a.f19114r};

    public static int a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1620a);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != 0 ? resourceId : resourceId2;
    }

    public static int b(Context context, AttributeSet attributeSet, int i7, int i8) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1621b, i7, i8);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static Context c(Context context, AttributeSet attributeSet, int i7, int i8) {
        int iB = b(context, attributeSet, i7, i8);
        boolean z7 = (context instanceof C2247c) && ((C2247c) context).b() == iB;
        if (iB == 0 || z7) {
            return context;
        }
        C2247c c2247c = new C2247c(context, iB);
        int iA = a(context, attributeSet);
        if (iA != 0) {
            c2247c.getTheme().applyStyle(iA, true);
        }
        return c2247c;
    }
}
