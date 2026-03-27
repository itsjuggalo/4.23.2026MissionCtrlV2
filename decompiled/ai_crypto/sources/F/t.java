package F;

import android.app.Person;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f1848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IconCompat f1849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f1851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1852e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1853f;

    public static class a {
        public static t a(Person person) {
            return new b().f(person.getName()).c(person.getIcon() != null ? IconCompat.b(person.getIcon()) : null).g(person.getUri()).e(person.getKey()).b(person.isBot()).d(person.isImportant()).a();
        }

        public static Person b(t tVar) {
            return new Person.Builder().setName(tVar.e()).setIcon(tVar.c() != null ? tVar.c().u() : null).setUri(tVar.f()).setKey(tVar.d()).setBot(tVar.g()).setImportant(tVar.h()).build();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CharSequence f1854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public IconCompat f1855b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f1856c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f1857d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f1858e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f1859f;

        public t a() {
            return new t(this);
        }

        public b b(boolean z7) {
            this.f1858e = z7;
            return this;
        }

        public b c(IconCompat iconCompat) {
            this.f1855b = iconCompat;
            return this;
        }

        public b d(boolean z7) {
            this.f1859f = z7;
            return this;
        }

        public b e(String str) {
            this.f1857d = str;
            return this;
        }

        public b f(CharSequence charSequence) {
            this.f1854a = charSequence;
            return this;
        }

        public b g(String str) {
            this.f1856c = str;
            return this;
        }
    }

    public t(b bVar) {
        this.f1848a = bVar.f1854a;
        this.f1849b = bVar.f1855b;
        this.f1850c = bVar.f1856c;
        this.f1851d = bVar.f1857d;
        this.f1852e = bVar.f1858e;
        this.f1853f = bVar.f1859f;
    }

    public static t a(Person person) {
        return a.a(person);
    }

    public static t b(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("icon");
        return new b().f(bundle.getCharSequence("name")).c(bundle2 != null ? IconCompat.a(bundle2) : null).g(bundle.getString("uri")).e(bundle.getString(SubscriberAttributeKt.JSON_NAME_KEY)).b(bundle.getBoolean("isBot")).d(bundle.getBoolean("isImportant")).a();
    }

    public IconCompat c() {
        return this.f1849b;
    }

    public String d() {
        return this.f1851d;
    }

    public CharSequence e() {
        return this.f1848a;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        String strD = d();
        String strD2 = tVar.d();
        return (strD == null && strD2 == null) ? Objects.equals(Objects.toString(e()), Objects.toString(tVar.e())) && Objects.equals(f(), tVar.f()) && Boolean.valueOf(g()).equals(Boolean.valueOf(tVar.g())) && Boolean.valueOf(h()).equals(Boolean.valueOf(tVar.h())) : Objects.equals(strD, strD2);
    }

    public String f() {
        return this.f1850c;
    }

    public boolean g() {
        return this.f1852e;
    }

    public boolean h() {
        return this.f1853f;
    }

    public int hashCode() {
        String strD = d();
        return strD != null ? strD.hashCode() : Objects.hash(e(), f(), Boolean.valueOf(g()), Boolean.valueOf(h()));
    }

    public String i() {
        String str = this.f1850c;
        if (str != null) {
            return str;
        }
        if (this.f1848a == null) {
            return "";
        }
        return "name:" + ((Object) this.f1848a);
    }

    public Person j() {
        return a.b(this);
    }

    public Bundle k() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("name", this.f1848a);
        IconCompat iconCompat = this.f1849b;
        bundle.putBundle("icon", iconCompat != null ? iconCompat.t() : null);
        bundle.putString("uri", this.f1850c);
        bundle.putString(SubscriberAttributeKt.JSON_NAME_KEY, this.f1851d);
        bundle.putBoolean("isBot", this.f1852e);
        bundle.putBoolean("isImportant", this.f1853f);
        return bundle;
    }
}
