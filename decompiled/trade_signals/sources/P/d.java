package P;

import android.content.res.Configuration;
import android.os.LocaleList;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    public static class a {
        public static LocaleList a(Configuration configuration) {
            return configuration.getLocales();
        }

        public static void b(Configuration configuration, g gVar) {
            configuration.setLocales((LocaleList) gVar.f());
        }
    }

    public static g a(Configuration configuration) {
        return g.g(a.a(configuration));
    }
}
