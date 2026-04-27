package s2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: renamed from: s2.C, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1770C {
    public static String a(int i4) {
        if (i4 == 0) {
            return "EEEE, MMMM d, yyyy";
        }
        if (i4 == 1) {
            return "MMMM d, yyyy";
        }
        if (i4 == 2) {
            return "MMM d, yyyy";
        }
        if (i4 == 3) {
            return "M/d/yy";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i4);
    }

    public static String b(int i4) {
        if (i4 == 0 || i4 == 1) {
            return "h:mm:ss a z";
        }
        if (i4 == 2) {
            return "h:mm:ss a";
        }
        if (i4 == 3) {
            return "h:mm a";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i4);
    }

    public static DateFormat c(int i4, int i5) {
        return new SimpleDateFormat(a(i4) + " " + b(i5), Locale.US);
    }
}
