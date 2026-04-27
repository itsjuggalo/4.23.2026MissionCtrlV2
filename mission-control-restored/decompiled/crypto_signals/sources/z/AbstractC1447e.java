package z;

import android.content.res.Configuration;
import android.os.LocaleList;

/* JADX INFO: renamed from: z.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1447e {
    public static LocaleList a(Configuration configuration) {
        return configuration.getLocales();
    }

    public static void b(Configuration configuration, C1451i c1451i) {
        configuration.setLocales(c1451i.f11726a.f11727a);
    }
}
