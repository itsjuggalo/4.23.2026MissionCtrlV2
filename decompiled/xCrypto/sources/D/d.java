package D;

import android.content.res.Configuration;
import android.os.LocaleList;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    public static class a {
        public static LocaleList a(Configuration configuration) {
            return configuration.getLocales();
        }

        public static void b(Configuration configuration, g gVar) {
            configuration.setLocales((LocaleList) gVar.i());
        }
    }

    public static g a(Configuration configuration) {
        return g.j(a.a(configuration));
    }

    public static void b(Configuration configuration, g gVar) {
        a.b(configuration, gVar);
    }
}
