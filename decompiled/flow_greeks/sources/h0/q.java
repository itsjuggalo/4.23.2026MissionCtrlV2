package h0;

import android.app.Person;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f10906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IconCompat f10907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f10909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f10910e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f10911f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {
        public static q a(Person person) {
            return new b().f(person.getName()).c(person.getIcon() != null ? IconCompat.b(person.getIcon()) : null).g(person.getUri()).e(person.getKey()).b(person.isBot()).d(person.isImportant()).a();
        }

        public static Person b(q qVar) {
            return new Person.Builder().setName(qVar.e()).setIcon(qVar.c() != null ? qVar.c().u() : null).setUri(qVar.f()).setKey(qVar.d()).setBot(qVar.g()).setImportant(qVar.h()).build();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CharSequence f10912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public IconCompat f10913b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f10914c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f10915d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f10916e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f10917f;

        public q a() {
            return new q(this);
        }

        public b b(boolean z10) {
            this.f10916e = z10;
            return this;
        }

        public b c(IconCompat iconCompat) {
            this.f10913b = iconCompat;
            return this;
        }

        public b d(boolean z10) {
            this.f10917f = z10;
            return this;
        }

        public b e(String str) {
            this.f10915d = str;
            return this;
        }

        public b f(CharSequence charSequence) {
            this.f10912a = charSequence;
            return this;
        }

        public b g(String str) {
            this.f10914c = str;
            return this;
        }
    }

    public q(b bVar) {
        this.f10906a = bVar.f10912a;
        this.f10907b = bVar.f10913b;
        this.f10908c = bVar.f10914c;
        this.f10909d = bVar.f10915d;
        this.f10910e = bVar.f10916e;
        this.f10911f = bVar.f10917f;
    }

    public static q a(Person person) {
        return a.a(person);
    }

    public static q b(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("icon");
        return new b().f(bundle.getCharSequence("name")).c(bundle2 != null ? IconCompat.a(bundle2) : null).g(bundle.getString("uri")).e(bundle.getString("key")).b(bundle.getBoolean("isBot")).d(bundle.getBoolean("isImportant")).a();
    }

    public IconCompat c() {
        return this.f10907b;
    }

    public String d() {
        return this.f10909d;
    }

    public CharSequence e() {
        return this.f10906a;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        String strD = d();
        String strD2 = qVar.d();
        return (strD == null && strD2 == null) ? Objects.equals(Objects.toString(e()), Objects.toString(qVar.e())) && Objects.equals(f(), qVar.f()) && Boolean.valueOf(g()).equals(Boolean.valueOf(qVar.g())) && Boolean.valueOf(h()).equals(Boolean.valueOf(qVar.h())) : Objects.equals(strD, strD2);
    }

    public String f() {
        return this.f10908c;
    }

    public boolean g() {
        return this.f10910e;
    }

    public boolean h() {
        return this.f10911f;
    }

    public int hashCode() {
        String strD = d();
        return strD != null ? strD.hashCode() : Objects.hash(e(), f(), Boolean.valueOf(g()), Boolean.valueOf(h()));
    }

    public String i() {
        String str = this.f10908c;
        if (str != null) {
            return str;
        }
        if (this.f10906a == null) {
            return "";
        }
        return "name:" + ((Object) this.f10906a);
    }

    public Person j() {
        return a.b(this);
    }

    public Bundle k() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("name", this.f10906a);
        IconCompat iconCompat = this.f10907b;
        bundle.putBundle("icon", iconCompat != null ? iconCompat.t() : null);
        bundle.putString("uri", this.f10908c);
        bundle.putString("key", this.f10909d);
        bundle.putBoolean("isBot", this.f10910e);
        bundle.putBoolean("isImportant", this.f10911f);
        return bundle;
    }
}
