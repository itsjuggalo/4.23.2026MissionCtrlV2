package ea;

import android.text.TextUtils;
import com.google.firebase.inappmessaging.model.MessageType;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c extends i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f8557e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n f8558f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g f8559g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ea.a f8560h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f8561i;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public n f8562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public n f8563b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public g f8564c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ea.a f8565d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f8566e;

        public c a(e eVar, Map map) {
            if (this.f8562a == null) {
                throw new IllegalArgumentException("Banner model must have a title");
            }
            if (TextUtils.isEmpty(this.f8566e)) {
                throw new IllegalArgumentException("Banner model must have a background color");
            }
            return new c(eVar, this.f8562a, this.f8563b, this.f8564c, this.f8565d, this.f8566e, map);
        }

        public b b(ea.a aVar) {
            this.f8565d = aVar;
            return this;
        }

        public b c(String str) {
            this.f8566e = str;
            return this;
        }

        public b d(n nVar) {
            this.f8563b = nVar;
            return this;
        }

        public b e(g gVar) {
            this.f8564c = gVar;
            return this;
        }

        public b f(n nVar) {
            this.f8562a = nVar;
            return this;
        }
    }

    public static b d() {
        return new b();
    }

    @Override // ea.i
    public g b() {
        return this.f8559g;
    }

    public ea.a e() {
        return this.f8560h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (hashCode() != cVar.hashCode()) {
            return false;
        }
        n nVar = this.f8558f;
        if ((nVar == null && cVar.f8558f != null) || (nVar != null && !nVar.equals(cVar.f8558f))) {
            return false;
        }
        g gVar = this.f8559g;
        if ((gVar == null && cVar.f8559g != null) || (gVar != null && !gVar.equals(cVar.f8559g))) {
            return false;
        }
        ea.a aVar = this.f8560h;
        return (aVar != null || cVar.f8560h == null) && (aVar == null || aVar.equals(cVar.f8560h)) && this.f8557e.equals(cVar.f8557e) && this.f8561i.equals(cVar.f8561i);
    }

    public String f() {
        return this.f8561i;
    }

    public n g() {
        return this.f8558f;
    }

    public n h() {
        return this.f8557e;
    }

    public int hashCode() {
        n nVar = this.f8558f;
        int iHashCode = nVar != null ? nVar.hashCode() : 0;
        g gVar = this.f8559g;
        int iHashCode2 = gVar != null ? gVar.hashCode() : 0;
        ea.a aVar = this.f8560h;
        return this.f8557e.hashCode() + iHashCode + iHashCode2 + (aVar != null ? aVar.hashCode() : 0) + this.f8561i.hashCode();
    }

    public c(e eVar, n nVar, n nVar2, g gVar, ea.a aVar, String str, Map map) {
        super(eVar, MessageType.BANNER, map);
        this.f8557e = nVar;
        this.f8558f = nVar2;
        this.f8559g = gVar;
        this.f8560h = aVar;
        this.f8561i = str;
    }
}
