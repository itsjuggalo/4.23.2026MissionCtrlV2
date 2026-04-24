package M;

import android.content.res.Configuration;
import android.os.LocaleList;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    public static class a {
        public static LocaleList a(Configuration configuration) {
            return configuration.getLocales();
        }

        public static void b(Configuration configuration, i iVar) {
            configuration.setLocales((LocaleList) iVar.i());
        }
    }

    public static i a(Configuration configuration) {
        return i.j(a.a(configuration));
    }

    public static void b(Configuration configuration, i iVar) {
        a.b(configuration, iVar);
    }
}
