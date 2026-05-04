package p0;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f18167b = a(new Locale[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f18168a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {
        public static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        public static LocaleList b() {
            return LocaleList.getDefault();
        }
    }

    public g(h hVar) {
        this.f18168a = hVar;
    }

    public static g a(Locale... localeArr) {
        return f(a.a(localeArr));
    }

    public static g c() {
        return f(a.b());
    }

    public static g f(LocaleList localeList) {
        return new g(new i(localeList));
    }

    public Locale b(int i10) {
        return this.f18168a.get(i10);
    }

    public int d() {
        return this.f18168a.size();
    }

    public String e() {
        return this.f18168a.a();
    }

    public boolean equals(Object obj) {
        return (obj instanceof g) && this.f18168a.equals(((g) obj).f18168a);
    }

    public int hashCode() {
        return this.f18168a.hashCode();
    }

    public String toString() {
        return this.f18168a.toString();
    }
}
