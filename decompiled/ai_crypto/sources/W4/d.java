package W4;

import U4.l;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f5435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f5436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l.b f5437c;

    public class a implements l.b {
        public a() {
        }

        @Override // U4.l.b
        public String a(String str, String str2) {
            Context contextCreateConfigurationContext = d.this.f5436b;
            if (str2 != null) {
                Locale localeB = d.b(str2);
                Configuration configuration = new Configuration(d.this.f5436b.getResources().getConfiguration());
                configuration.setLocale(localeB);
                contextCreateConfigurationContext = d.this.f5436b.createConfigurationContext(configuration);
            }
            int identifier = contextCreateConfigurationContext.getResources().getIdentifier(str, "string", d.this.f5436b.getPackageName());
            if (identifier != 0) {
                return contextCreateConfigurationContext.getResources().getString(identifier);
            }
            return null;
        }
    }

    public d(Context context, l lVar) {
        a aVar = new a();
        this.f5437c = aVar;
        this.f5436b = context;
        this.f5435a = lVar;
        lVar.c(aVar);
    }

    public static Locale b(String str) {
        Locale.Builder builder = new Locale.Builder();
        String[] strArrSplit = str.replace('_', '-').split("-");
        builder.setLanguage(strArrSplit[0]);
        int i7 = 1;
        if (strArrSplit.length > 1 && strArrSplit[1].length() == 4) {
            builder.setScript(strArrSplit[1]);
            i7 = 2;
        }
        if (strArrSplit.length > i7 && strArrSplit[i7].length() >= 2 && strArrSplit[i7].length() <= 3) {
            builder.setRegion(strArrSplit[i7]);
        }
        return builder.build();
    }

    public Locale c(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 26) {
            LocaleList locales = this.f5436b.getResources().getConfiguration().getLocales();
            for (int i7 = 0; i7 < locales.size(); i7++) {
                Locale locale = locales.get(i7);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Locale locale2 = (Locale) it.next();
                    if (locale.equals(locale2)) {
                        return locale2;
                    }
                }
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    Locale locale3 = (Locale) it2.next();
                    if (locale.getLanguage().equals(locale3.toLanguageTag())) {
                        return locale3;
                    }
                }
                Iterator it3 = list.iterator();
                while (it3.hasNext()) {
                    Locale locale4 = (Locale) it3.next();
                    if (locale.getLanguage().equals(locale4.getLanguage())) {
                        return locale4;
                    }
                }
            }
            return (Locale) list.get(0);
        }
        ArrayList arrayList = new ArrayList();
        LocaleList locales2 = this.f5436b.getResources().getConfiguration().getLocales();
        int size = locales2.size();
        for (int i8 = 0; i8 < size; i8++) {
            Locale locale5 = locales2.get(i8);
            String language = locale5.getLanguage();
            if (!locale5.getScript().isEmpty()) {
                language = language + "-" + locale5.getScript();
            }
            if (!locale5.getCountry().isEmpty()) {
                language = language + "-" + locale5.getCountry();
            }
            arrayList.add(b.a(language));
            c.a();
            arrayList.add(b.a(locale5.getLanguage()));
            c.a();
            arrayList.add(b.a(locale5.getLanguage() + "-*"));
        }
        Locale localeLookup = Locale.lookup(arrayList, list);
        return localeLookup != null ? localeLookup : (Locale) list.get(0);
    }

    public void d(Configuration configuration) {
        ArrayList arrayList = new ArrayList();
        LocaleList locales = configuration.getLocales();
        int size = locales.size();
        for (int i7 = 0; i7 < size; i7++) {
            arrayList.add(locales.get(i7));
        }
        this.f5435a.b(arrayList);
    }
}
