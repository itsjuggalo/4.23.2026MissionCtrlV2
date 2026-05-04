package ea;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f8547b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d f8549b;

        public a a() {
            return new a(this.f8548a, this.f8549b);
        }

        public b b(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f8548a = str;
            }
            return this;
        }

        public b c(d dVar) {
            this.f8549b = dVar;
            return this;
        }
    }

    public static b a() {
        return new b();
    }

    public String b() {
        return this.f8546a;
    }

    public d c() {
        return this.f8547b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (hashCode() != aVar.hashCode()) {
            return false;
        }
        String str = this.f8546a;
        if ((str == null && aVar.f8546a != null) || (str != null && !str.equals(aVar.f8546a))) {
            return false;
        }
        d dVar = this.f8547b;
        return (dVar == null && aVar.f8547b == null) || (dVar != null && dVar.equals(aVar.f8547b));
    }

    public int hashCode() {
        String str = this.f8546a;
        int iHashCode = str != null ? str.hashCode() : 0;
        d dVar = this.f8547b;
        return iHashCode + (dVar != null ? dVar.hashCode() : 0);
    }

    public a(String str, d dVar) {
        this.f8546a = str;
        this.f8547b = dVar;
    }
}
