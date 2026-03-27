package U;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f4740a = new String[0];

    public static class a {
        public static void a(EditorInfo editorInfo, CharSequence charSequence, int i7) {
            editorInfo.setInitialSurroundingSubText(charSequence, i7);
        }
    }

    public static String[] a(EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            String[] strArr = editorInfo.contentMimeTypes;
            return strArr != null ? strArr : f4740a;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return f4740a;
        }
        String[] stringArray = bundle.getStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
        if (stringArray == null) {
            stringArray = editorInfo.extras.getStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
        }
        return stringArray != null ? stringArray : f4740a;
    }

    public static boolean b(CharSequence charSequence, int i7, int i8) {
        if (i8 == 0) {
            return Character.isLowSurrogate(charSequence.charAt(i7));
        }
        if (i8 != 1) {
            return false;
        }
        return Character.isHighSurrogate(charSequence.charAt(i7));
    }

    public static boolean c(int i7) {
        int i8 = i7 & 4095;
        return i8 == 129 || i8 == 225 || i8 == 18;
    }

    public static void d(EditorInfo editorInfo, String[] strArr) {
        if (Build.VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = strArr;
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr);
        editorInfo.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr);
    }

    public static void e(EditorInfo editorInfo, CharSequence charSequence, int i7) {
        P.f.g(charSequence);
        if (Build.VERSION.SDK_INT >= 30) {
            a.a(editorInfo, charSequence, i7);
            return;
        }
        int i8 = editorInfo.initialSelStart;
        int i9 = editorInfo.initialSelEnd;
        int i10 = i8 > i9 ? i9 - i7 : i8 - i7;
        int i11 = i8 > i9 ? i8 - i7 : i9 - i7;
        int length = charSequence.length();
        if (i7 < 0 || i10 < 0 || i11 > length) {
            h(editorInfo, null, 0, 0);
            return;
        }
        if (c(editorInfo.inputType)) {
            h(editorInfo, null, 0, 0);
        } else if (length <= 2048) {
            h(editorInfo, charSequence, i10, i11);
        } else {
            i(editorInfo, charSequence, i10, i11);
        }
    }

    public static void f(EditorInfo editorInfo, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            a.a(editorInfo, charSequence, 0);
        } else {
            e(editorInfo, charSequence, 0);
        }
    }

    public static void g(EditorInfo editorInfo, boolean z7) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putBoolean("androidx.core.view.inputmethod.EditorInfoCompat.STYLUS_HANDWRITING_ENABLED", z7);
    }

    public static void h(EditorInfo editorInfo, CharSequence charSequence, int i7, int i8) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", i7);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", i8);
    }

    public static void i(EditorInfo editorInfo, CharSequence charSequence, int i7, int i8) {
        int i9 = i8 - i7;
        int i10 = i9 > 1024 ? 0 : i9;
        int i11 = 2048 - i10;
        int iMin = Math.min(charSequence.length() - i8, i11 - Math.min(i7, (int) (((double) i11) * 0.8d)));
        int iMin2 = Math.min(i7, i11 - iMin);
        int i12 = i7 - iMin2;
        if (b(charSequence, i12, 0)) {
            i12++;
            iMin2--;
        }
        if (b(charSequence, (i8 + iMin) - 1, 1)) {
            iMin--;
        }
        h(editorInfo, i10 != i9 ? TextUtils.concat(charSequence.subSequence(i12, i12 + iMin2), charSequence.subSequence(i8, iMin + i8)) : charSequence.subSequence(i12, iMin2 + i10 + iMin + i12), iMin2, i10 + iMin2);
    }
}
