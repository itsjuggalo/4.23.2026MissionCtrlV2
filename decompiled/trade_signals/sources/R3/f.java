package R3;

import android.text.TextUtils;
import com.google.firebase.inappmessaging.model.MessageType;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f extends i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f7141e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n f7142f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f7143g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final R3.a f7144h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final R3.a f7145i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final g f7146j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final g f7147k;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g f7148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g f7149b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f7150c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public R3.a f7151d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public n f7152e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public n f7153f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public R3.a f7154g;

        public f a(e eVar, Map map) {
            R3.a aVar = this.f7151d;
            if (aVar == null) {
                throw new IllegalArgumentException("Card model must have a primary action");
            }
            if (aVar.c() == null) {
                throw new IllegalArgumentException("Card model must have a primary action button");
            }
            R3.a aVar2 = this.f7154g;
            if (aVar2 != null && aVar2.c() == null) {
                throw new IllegalArgumentException("Card model secondary action must be null or have a button");
            }
            if (this.f7152e == null) {
                throw new IllegalArgumentException("Card model must have a title");
            }
            if (this.f7148a == null && this.f7149b == null) {
                throw new IllegalArgumentException("Card model must have at least one image");
            }
            if (TextUtils.isEmpty(this.f7150c)) {
                throw new IllegalArgumentException("Card model must have a background color");
            }
            return new f(eVar, this.f7152e, this.f7153f, this.f7148a, this.f7149b, this.f7150c, this.f7151d, this.f7154g, map);
        }

        public b b(String str) {
            this.f7150c = str;
            return this;
        }

        public b c(n nVar) {
            this.f7153f = nVar;
            return this;
        }

        public b d(g gVar) {
            this.f7149b = gVar;
            return this;
        }

        public b e(g gVar) {
            this.f7148a = gVar;
            return this;
        }

        public b f(R3.a aVar) {
            this.f7151d = aVar;
            return this;
        }

        public b g(R3.a aVar) {
            this.f7154g = aVar;
            return this;
        }

        public b h(n nVar) {
            this.f7152e = nVar;
            return this;
        }
    }

    public f(e eVar, n nVar, n nVar2, g gVar, g gVar2, String str, R3.a aVar, R3.a aVar2, Map map) {
        super(eVar, MessageType.CARD, map);
        this.f7141e = nVar;
        this.f7142f = nVar2;
        this.f7146j = gVar;
        this.f7147k = gVar2;
        this.f7143g = str;
        this.f7144h = aVar;
        this.f7145i = aVar2;
    }

    public static b d() {
        return new b();
    }

    @Override // R3.i
    public g b() {
        return this.f7146j;
    }

    public String e() {
        return this.f7143g;
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
        n nVar = this.f7142f;
        if ((nVar == null && fVar.f7142f != null) || (nVar != null && !nVar.equals(fVar.f7142f))) {
            return false;
        }
        R3.a aVar = this.f7145i;
        if ((aVar == null && fVar.f7145i != null) || (aVar != null && !aVar.equals(fVar.f7145i))) {
            return false;
        }
        g gVar = this.f7146j;
        if ((gVar == null && fVar.f7146j != null) || (gVar != null && !gVar.equals(fVar.f7146j))) {
            return false;
        }
        g gVar2 = this.f7147k;
        return (gVar2 != null || fVar.f7147k == null) && (gVar2 == null || gVar2.equals(fVar.f7147k)) && this.f7141e.equals(fVar.f7141e) && this.f7144h.equals(fVar.f7144h) && this.f7143g.equals(fVar.f7143g);
    }

    public n f() {
        return this.f7142f;
    }

    public g g() {
        return this.f7147k;
    }

    public g h() {
        return this.f7146j;
    }

    public int hashCode() {
        n nVar = this.f7142f;
        int iHashCode = nVar != null ? nVar.hashCode() : 0;
        R3.a aVar = this.f7145i;
        int iHashCode2 = aVar != null ? aVar.hashCode() : 0;
        g gVar = this.f7146j;
        int iHashCode3 = gVar != null ? gVar.hashCode() : 0;
        g gVar2 = this.f7147k;
        return this.f7141e.hashCode() + iHashCode + this.f7143g.hashCode() + this.f7144h.hashCode() + iHashCode2 + iHashCode3 + (gVar2 != null ? gVar2.hashCode() : 0);
    }

    public R3.a i() {
        return this.f7144h;
    }

    public R3.a j() {
        return this.f7145i;
    }

    public n k() {
        return this.f7141e;
    }
}
