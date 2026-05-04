package ea;

import android.text.TextUtils;
import com.google.firebase.inappmessaging.model.MessageType;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f extends i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f8574e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n f8575f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f8576g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ea.a f8577h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ea.a f8578i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final g f8579j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final g f8580k;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g f8581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g f8582b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f8583c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ea.a f8584d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public n f8585e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public n f8586f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ea.a f8587g;

        public f a(e eVar, Map map) {
            ea.a aVar = this.f8584d;
            if (aVar == null) {
                throw new IllegalArgumentException("Card model must have a primary action");
            }
            if (aVar.c() == null) {
                throw new IllegalArgumentException("Card model must have a primary action button");
            }
            ea.a aVar2 = this.f8587g;
            if (aVar2 != null && aVar2.c() == null) {
                throw new IllegalArgumentException("Card model secondary action must be null or have a button");
            }
            if (this.f8585e == null) {
                throw new IllegalArgumentException("Card model must have a title");
            }
            if (this.f8581a == null && this.f8582b == null) {
                throw new IllegalArgumentException("Card model must have at least one image");
            }
            if (TextUtils.isEmpty(this.f8583c)) {
                throw new IllegalArgumentException("Card model must have a background color");
            }
            return new f(eVar, this.f8585e, this.f8586f, this.f8581a, this.f8582b, this.f8583c, this.f8584d, this.f8587g, map);
        }

        public b b(String str) {
            this.f8583c = str;
            return this;
        }

        public b c(n nVar) {
            this.f8586f = nVar;
            return this;
        }

        public b d(g gVar) {
            this.f8582b = gVar;
            return this;
        }

        public b e(g gVar) {
            this.f8581a = gVar;
            return this;
        }

        public b f(ea.a aVar) {
            this.f8584d = aVar;
            return this;
        }

        public b g(ea.a aVar) {
            this.f8587g = aVar;
            return this;
        }

        public b h(n nVar) {
            this.f8585e = nVar;
            return this;
        }
    }

    public static b d() {
        return new b();
    }

    @Override // ea.i
    public g b() {
        return this.f8579j;
    }

    public String e() {
        return this.f8576g;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (hashCode() != fVar.hashCode()) {
            return false;
        }
        n nVar = this.f8575f;
        if ((nVar == null && fVar.f8575f != null) || (nVar != null && !nVar.equals(fVar.f8575f))) {
            return false;
        }
        ea.a aVar = this.f8578i;
        if ((aVar == null && fVar.f8578i != null) || (aVar != null && !aVar.equals(fVar.f8578i))) {
            return false;
        }
        g gVar = this.f8579j;
        if ((gVar == null && fVar.f8579j != null) || (gVar != null && !gVar.equals(fVar.f8579j))) {
            return false;
        }
        g gVar2 = this.f8580k;
        return (gVar2 != null || fVar.f8580k == null) && (gVar2 == null || gVar2.equals(fVar.f8580k)) && this.f8574e.equals(fVar.f8574e) && this.f8577h.equals(fVar.f8577h) && this.f8576g.equals(fVar.f8576g);
    }

    public n f() {
        return this.f8575f;
    }

    public g g() {
        return this.f8580k;
    }

    public g h() {
        return this.f8579j;
    }

    public int hashCode() {
        n nVar = this.f8575f;
        int iHashCode = nVar != null ? nVar.hashCode() : 0;
        ea.a aVar = this.f8578i;
        int iHashCode2 = aVar != null ? aVar.hashCode() : 0;
        g gVar = this.f8579j;
        int iHashCode3 = gVar != null ? gVar.hashCode() : 0;
        g gVar2 = this.f8580k;
        return this.f8574e.hashCode() + iHashCode + this.f8576g.hashCode() + this.f8577h.hashCode() + iHashCode2 + iHashCode3 + (gVar2 != null ? gVar2.hashCode() : 0);
    }

    public ea.a i() {
        return this.f8577h;
    }

    public ea.a j() {
        return this.f8578i;
    }

    public n k() {
        return this.f8574e;
    }

    public f(e eVar, n nVar, n nVar2, g gVar, g gVar2, String str, ea.a aVar, ea.a aVar2, Map map) {
        super(eVar, MessageType.CARD, map);
        this.f8574e = nVar;
        this.f8575f = nVar2;
        this.f8579j = gVar;
        this.f8580k = gVar2;
        this.f8576g = str;
        this.f8577h = aVar;
        this.f8578i = aVar2;
    }
}
