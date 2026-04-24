package P;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f6253b = a(new Locale[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f6254a;

    public static class a {
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
        this.f6254a = hVar;
    }

    public static g a(Locale... localeArr) {
        return g(a.a(localeArr));
    }

    public static g c() {
        return g(a.c());
    }

    public static g g(LocaleList localeList) {
        return new g(new i(localeList));
    }

    public Locale b(int i8) {
        return this.f6254a.get(i8);
    }

    public int d() {
        return this.f6254a.size();
    }

    public String e() {
        return this.f6254a.a();
    }

    public boolean equals(Object obj) {
        return (obj instanceof g) && this.f6254a.equals(((g) obj).f6254a);
    }

    public Object f() {
        return this.f6254a.b();
    }

    public int hashCode() {
        return this.f6254a.hashCode();
    }

    public String toString() {
        return this.f6254a.toString();
    }
}
