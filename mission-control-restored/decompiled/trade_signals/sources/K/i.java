package K;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public static int a(Context context, int i8, int i9) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i8, typedValue, true);
        return typedValue.resourceId != 0 ? i8 : i9;
    }

    public static boolean b(TypedArray typedArray, int i8, int i9, boolean z7) {
        return typedArray.getBoolean(i8, typedArray.getBoolean(i9, z7));
    }

    public static Drawable c(TypedArray typedArray, int i8, int i9) {
        Drawable drawable = typedArray.getDrawable(i8);
        return drawable == null ? typedArray.getDrawable(i9) : drawable;
    }

    public static int d(TypedArray typedArray, int i8, int i9, int i10) {
        return typedArray.getInt(i8, typedArray.getInt(i9, i10));
    }

    public static int e(TypedArray typedArray, int i8, int i9, int i10) {
        return typedArray.getResourceId(i8, typedArray.getResourceId(i9, i10));
    }

    public static String f(TypedArray typedArray, int i8, int i9) {
        String string = typedArray.getString(i8);
        return string == null ? typedArray.getString(i9) : string;
    }

    public static CharSequence g(TypedArray typedArray, int i8, int i9) {
        CharSequence text = typedArray.getText(i8);
        return text == null ? typedArray.getText(i9) : text;
    }

    public static CharSequence[] h(TypedArray typedArray, int i8, int i9) {
        CharSequence[] textArray = typedArray.getTextArray(i8);
        return textArray == null ? typedArray.getTextArray(i9) : textArray;
    }
}
