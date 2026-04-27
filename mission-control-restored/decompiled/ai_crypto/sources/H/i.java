package H;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public static int a(Context context, int i7, int i8) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i7, typedValue, true);
        return typedValue.resourceId != 0 ? i7 : i8;
    }

    public static boolean b(TypedArray typedArray, int i7, int i8, boolean z7) {
        return typedArray.getBoolean(i7, typedArray.getBoolean(i8, z7));
    }

    public static Drawable c(TypedArray typedArray, int i7, int i8) {
        Drawable drawable = typedArray.getDrawable(i7);
        return drawable == null ? typedArray.getDrawable(i8) : drawable;
    }

    public static int d(TypedArray typedArray, int i7, int i8, int i9) {
        return typedArray.getInt(i7, typedArray.getInt(i8, i9));
    }

    public static int e(TypedArray typedArray, int i7, int i8, int i9) {
        return typedArray.getResourceId(i7, typedArray.getResourceId(i8, i9));
    }

    public static String f(TypedArray typedArray, int i7, int i8) {
        String string = typedArray.getString(i7);
        return string == null ? typedArray.getString(i8) : string;
    }

    public static CharSequence g(TypedArray typedArray, int i7, int i8) {
        CharSequence text = typedArray.getText(i7);
        return text == null ? typedArray.getText(i8) : text;
    }

    public static CharSequence[] h(TypedArray typedArray, int i7, int i8) {
        CharSequence[] textArray = typedArray.getTextArray(i7);
        return textArray == null ? typedArray.getTextArray(i8) : textArray;
    }
}
