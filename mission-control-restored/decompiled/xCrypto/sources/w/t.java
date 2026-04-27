package w;

import android.app.Person;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f15521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IconCompat f15522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f15523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f15524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f15525e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f15526f;

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
        public CharSequence f15527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public IconCompat f15528b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f15529c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f15530d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f15531e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f15532f;

        public t a() {
            return new t(this);
        }

        public b b(boolean z4) {
            this.f15531e = z4;
            return this;
        }

        public b c(IconCompat iconCompat) {
            this.f15528b = iconCompat;
            return this;
        }

        public b d(boolean z4) {
            this.f15532f = z4;
            return this;
        }

        public b e(String str) {
            this.f15530d = str;
            return this;
        }

        public b f(CharSequence charSequence) {
            this.f15527a = charSequence;
            return this;
        }

        public b g(String str) {
            this.f15529c = str;
            return this;
        }
    }

    public t(b bVar) {
        this.f15521a = bVar.f15527a;
        this.f15522b = bVar.f15528b;
        this.f15523c = bVar.f15529c;
        this.f15524d = bVar.f15530d;
        this.f15525e = bVar.f15531e;
        this.f15526f = bVar.f15532f;
    }

    public static t a(Person person) {
        return a.a(person);
    }

    public static t b(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("icon");
        return new b().f(bundle.getCharSequence("name")).c(bundle2 != null ? IconCompat.a(bundle2) : null).g(bundle.getString("uri")).e(bundle.getString("key")).b(bundle.getBoolean("isBot")).d(bundle.getBoolean("isImportant")).a();
    }

    public IconCompat c() {
        return this.f15522b;
    }

    public String d() {
        return this.f15524d;
    }

    public CharSequence e() {
        return this.f15521a;
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
        return this.f15523c;
    }

    public boolean g() {
        return this.f15525e;
    }

    public boolean h() {
        return this.f15526f;
    }

    public int hashCode() {
        String strD = d();
        return strD != null ? strD.hashCode() : Objects.hash(e(), f(), Boolean.valueOf(g()), Boolean.valueOf(h()));
    }

    public String i() {
        String str = this.f15523c;
        if (str != null) {
            return str;
        }
        if (this.f15521a == null) {
            return "";
        }
        return "name:" + ((Object) this.f15521a);
    }

    public Person j() {
        return a.b(this);
    }

    public Bundle k() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("name", this.f15521a);
        IconCompat iconCompat = this.f15522b;
        bundle.putBundle("icon", iconCompat != null ? iconCompat.t() : null);
        bundle.putString("uri", this.f15523c);
        bundle.putString("key", this.f15524d);
        bundle.putBoolean("isBot", this.f15525e);
        bundle.putBoolean("isImportant", this.f15526f);
        return bundle;
    }
}
