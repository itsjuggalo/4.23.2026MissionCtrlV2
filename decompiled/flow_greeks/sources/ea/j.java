package ea;

import android.text.TextUtils;
import com.google.firebase.inappmessaging.model.MessageType;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class j extends i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f8600e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n f8601f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g f8602g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ea.a f8603h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f8604i;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public n f8605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public n f8606b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public g f8607c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ea.a f8608d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f8609e;

        public j a(e eVar, Map map) {
            if (this.f8605a == null) {
                throw new IllegalArgumentException("Modal model must have a title");
            }
            ea.a aVar = this.f8608d;
            if (aVar != null && aVar.c() == null) {
                throw new IllegalArgumentException("Modal model action must be null or have a button");
            }
            if (TextUtils.isEmpty(this.f8609e)) {
                throw new IllegalArgumentException("Modal model must have a background color");
            }
            return new j(eVar, this.f8605a, this.f8606b, this.f8607c, this.f8608d, this.f8609e, map);
        }

        public b b(ea.a aVar) {
            this.f8608d = aVar;
            return this;
        }

        public b c(String str) {
            this.f8609e = str;
            return this;
        }

        public b d(n nVar) {
            this.f8606b = nVar;
            return this;
        }

        public b e(g gVar) {
            this.f8607c = gVar;
            return this;
        }

        public b f(n nVar) {
            this.f8605a = nVar;
            return this;
        }
    }

    public static b d() {
        return new b();
    }

    @Override // ea.i
    public g b() {
        return this.f8602g;
    }

    public ea.a e() {
        return this.f8603h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (hashCode() != jVar.hashCode()) {
            return false;
        }
        n nVar = this.f8601f;
        if ((nVar == null && jVar.f8601f != null) || (nVar != null && !nVar.equals(jVar.f8601f))) {
            return false;
        }
        ea.a aVar = this.f8603h;
        if ((aVar == null && jVar.f8603h != null) || (aVar != null && !aVar.equals(jVar.f8603h))) {
            return false;
        }
        g gVar = this.f8602g;
        return (gVar != null || jVar.f8602g == null) && (gVar == null || gVar.equals(jVar.f8602g)) && this.f8600e.equals(jVar.f8600e) && this.f8604i.equals(jVar.f8604i);
    }

    public String f() {
        return this.f8604i;
    }

    public n g() {
        return this.f8601f;
    }

    public n h() {
        return this.f8600e;
    }

    public int hashCode() {
        n nVar = this.f8601f;
        int iHashCode = nVar != null ? nVar.hashCode() : 0;
        ea.a aVar = this.f8603h;
        int iHashCode2 = aVar != null ? aVar.hashCode() : 0;
        g gVar = this.f8602g;
        return this.f8600e.hashCode() + iHashCode + this.f8604i.hashCode() + iHashCode2 + (gVar != null ? gVar.hashCode() : 0);
    }

    public j(e eVar, n nVar, n nVar2, g gVar, ea.a aVar, String str, Map map) {
        super(eVar, MessageType.MODAL, map);
        this.f8600e = nVar;
        this.f8601f = nVar2;
        this.f8602g = gVar;
        this.f8603h = aVar;
        this.f8604i = str;
    }
}
