package R;

import android.text.Html;
import android.text.Spanned;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: R.a$a, reason: collision with other inner class name */
    public static class C0094a {
        public static Spanned a(String str, int i8) {
            return Html.fromHtml(str, i8);
        }

        public static Spanned b(String str, int i8, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
            return Html.fromHtml(str, i8, imageGetter, tagHandler);
        }

        public static String c(Spanned spanned, int i8) {
            return Html.toHtml(spanned, i8);
        }
    }

    public static Spanned a(String str, int i8) {
        return C0094a.a(str, i8);
    }
}
