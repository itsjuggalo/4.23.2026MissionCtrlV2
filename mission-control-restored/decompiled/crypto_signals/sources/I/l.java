package I;

import android.icu.text.DecimalFormatSymbols;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {
    public static DecimalFormatSymbols a(Locale locale) {
        return DecimalFormatSymbols.getInstance(locale);
    }
}
