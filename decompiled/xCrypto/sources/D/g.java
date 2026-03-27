package D;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f294b = a(new Locale[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f295a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Locale[] f296a = {new Locale("en", "XA"), new Locale("ar", "XB")};

        public static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }

        public static boolean b(Locale locale) {
            for (Locale locale2 : f296a) {
                if (locale2.equals(locale)) {
                    return true;
                }
            }
            return false;
        }

        public static boolean c(Locale locale, Locale locale2) {
            if (locale.equals(locale2)) {
                return true;
            }
            if (!locale.getLanguage().equals(locale2.getLanguage()) || b(locale) || b(locale2)) {
                return false;
            }
            String strA = F.a.a(locale);
            if (!strA.isEmpty()) {
                return strA.equals(F.a.a(locale2));
            }
            String country = locale.getCountry();
            return country.isEmpty() || country.equals(locale2.getCountry());
        }
    }

    public static class b {
        public static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        public static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        public static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    public g(h hVar) {
        this.f295a = hVar;
    }

    public static g a(Locale... localeArr) {
        return j(b.a(localeArr));
    }

    public static g b(String str) {
        if (str == null || str.isEmpty()) {
            return e();
        }
        String[] strArrSplit = str.split(com.amazon.a.a.o.b.f.f8804a, -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i4 = 0; i4 < length; i4++) {
            localeArr[i4] = a.a(strArrSplit[i4]);
        }
        return a(localeArr);
    }

    public static g d() {
        return j(b.c());
    }

    public static g e() {
        return f294b;
    }

    public static g j(LocaleList localeList) {
        return new g(new i(localeList));
    }

    public Locale c(int i4) {
        return this.f295a.get(i4);
    }

    public boolean equals(Object obj) {
        return (obj instanceof g) && this.f295a.equals(((g) obj).f295a);
    }

    public boolean f() {
        return this.f295a.isEmpty();
    }

    public int g() {
        return this.f295a.size();
    }

    public String h() {
        return this.f295a.a();
    }

    public int hashCode() {
        return this.f295a.hashCode();
    }

    public Object i() {
        return this.f295a.b();
    }

    public String toString() {
        return this.f295a.toString();
    }
}
