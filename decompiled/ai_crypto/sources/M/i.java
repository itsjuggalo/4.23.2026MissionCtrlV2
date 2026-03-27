package M;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f3716b = a(new Locale[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f3717a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Locale[] f3718a = {new Locale("en", "XA"), new Locale("ar", "XB")};

        public static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }

        public static boolean b(Locale locale) {
            for (Locale locale2 : f3718a) {
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
            String strA = O.b.a(locale);
            if (!strA.isEmpty()) {
                return strA.equals(O.b.a(locale2));
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

    public i(j jVar) {
        this.f3717a = jVar;
    }

    public static i a(Locale... localeArr) {
        return j(b.a(localeArr));
    }

    public static i b(String str) {
        if (str == null || str.isEmpty()) {
            return e();
        }
        String[] strArrSplit = str.split(com.amazon.a.a.o.b.f.f9989a, -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i7 = 0; i7 < length; i7++) {
            localeArr[i7] = a.a(strArrSplit[i7]);
        }
        return a(localeArr);
    }

    public static i d() {
        return j(b.c());
    }

    public static i e() {
        return f3716b;
    }

    public static i j(LocaleList localeList) {
        return new i(new k(localeList));
    }

    public Locale c(int i7) {
        return this.f3717a.get(i7);
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && this.f3717a.equals(((i) obj).f3717a);
    }

    public boolean f() {
        return this.f3717a.isEmpty();
    }

    public int g() {
        return this.f3717a.size();
    }

    public String h() {
        return this.f3717a.a();
    }

    public int hashCode() {
        return this.f3717a.hashCode();
    }

    public Object i() {
        return this.f3717a.b();
    }

    public String toString() {
        return this.f3717a.toString();
    }
}
