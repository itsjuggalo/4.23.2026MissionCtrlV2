package H;

import android.app.Person;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f3533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IconCompat f3534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f3536d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3537e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3538f;

    public static class a {
        public static r a(Person person) {
            return new b().f(person.getName()).c(person.getIcon() != null ? IconCompat.b(person.getIcon()) : null).g(person.getUri()).e(person.getKey()).b(person.isBot()).d(person.isImportant()).a();
        }

        public static Person b(r rVar) {
            return new Person.Builder().setName(rVar.e()).setIcon(rVar.c() != null ? rVar.c().u() : null).setUri(rVar.f()).setKey(rVar.d()).setBot(rVar.g()).setImportant(rVar.h()).build();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CharSequence f3539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public IconCompat f3540b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f3541c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f3542d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f3543e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f3544f;

        public r a() {
            return new r(this);
        }

        public b b(boolean z7) {
            this.f3543e = z7;
            return this;
        }

        public b c(IconCompat iconCompat) {
            this.f3540b = iconCompat;
            return this;
        }

        public b d(boolean z7) {
            this.f3544f = z7;
            return this;
        }

        public b e(String str) {
            this.f3542d = str;
            return this;
        }

        public b f(CharSequence charSequence) {
            this.f3539a = charSequence;
            return this;
        }

        public b g(String str) {
            this.f3541c = str;
            return this;
        }
    }

    public r(b bVar) {
        this.f3533a = bVar.f3539a;
        this.f3534b = bVar.f3540b;
        this.f3535c = bVar.f3541c;
        this.f3536d = bVar.f3542d;
        this.f3537e = bVar.f3543e;
        this.f3538f = bVar.f3544f;
    }

    public static r a(Person person) {
        return a.a(person);
    }

    public static r b(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("icon");
        return new b().f(bundle.getCharSequence("name")).c(bundle2 != null ? IconCompat.a(bundle2) : null).g(bundle.getString("uri")).e(bundle.getString("key")).b(bundle.getBoolean("isBot")).d(bundle.getBoolean("isImportant")).a();
    }

    public IconCompat c() {
        return this.f3534b;
    }

    public String d() {
        return this.f3536d;
    }

    public CharSequence e() {
        return this.f3533a;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        String strD = d();
        String strD2 = rVar.d();
        return (strD == null && strD2 == null) ? Objects.equals(Objects.toString(e()), Objects.toString(rVar.e())) && Objects.equals(f(), rVar.f()) && Boolean.valueOf(g()).equals(Boolean.valueOf(rVar.g())) && Boolean.valueOf(h()).equals(Boolean.valueOf(rVar.h())) : Objects.equals(strD, strD2);
    }

    public String f() {
        return this.f3535c;
    }

    public boolean g() {
        return this.f3537e;
    }

    public boolean h() {
        return this.f3538f;
    }

    public int hashCode() {
        String strD = d();
        return strD != null ? strD.hashCode() : Objects.hash(e(), f(), Boolean.valueOf(g()), Boolean.valueOf(h()));
    }

    public String i() {
        String str = this.f3535c;
        if (str != null) {
            return str;
        }
        if (this.f3533a == null) {
            return "";
        }
        return "name:" + ((Object) this.f3533a);
    }

    public Person j() {
        return a.b(this);
    }

    public Bundle k() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("name", this.f3533a);
        IconCompat iconCompat = this.f3534b;
        bundle.putBundle("icon", iconCompat != null ? iconCompat.t() : null);
        bundle.putString("uri", this.f3535c);
        bundle.putString("key", this.f3536d);
        bundle.putBoolean("isBot", this.f3537e);
        bundle.putBoolean("isImportant", this.f3538f);
        return bundle;
    }
}
