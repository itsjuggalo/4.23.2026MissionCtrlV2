package z2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import j.AbstractC2040a;
import p.S;

/* JADX INFO: renamed from: z2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2881c {
    public static ColorStateList a(Context context, TypedArray typedArray, int i7) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!typedArray.hasValue(i7) || (resourceId = typedArray.getResourceId(i7, 0)) == 0 || (colorStateListA = AbstractC2040a.a(context, resourceId)) == null) ? typedArray.getColorStateList(i7) : colorStateListA;
    }

    public static ColorStateList b(Context context, S s7, int i7) {
        int iM;
        ColorStateList colorStateListA;
        return (!s7.q(i7) || (iM = s7.m(i7, 0)) == 0 || (colorStateListA = AbstractC2040a.a(context, iM)) == null) ? s7.c(i7) : colorStateListA;
    }

    public static Drawable c(Context context, TypedArray typedArray, int i7) {
        int resourceId;
        Drawable drawableB;
        return (!typedArray.hasValue(i7) || (resourceId = typedArray.getResourceId(i7, 0)) == 0 || (drawableB = AbstractC2040a.b(context, resourceId)) == null) ? typedArray.getDrawable(i7) : drawableB;
    }

    public static int d(TypedArray typedArray, int i7, int i8) {
        return typedArray.hasValue(i7) ? i7 : i8;
    }

    public static C2882d e(Context context, TypedArray typedArray, int i7) {
        int resourceId;
        if (!typedArray.hasValue(i7) || (resourceId = typedArray.getResourceId(i7, 0)) == 0) {
            return null;
        }
        return new C2882d(context, resourceId);
    }

    public static boolean f(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static boolean g(Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }
}
