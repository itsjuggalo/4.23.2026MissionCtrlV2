package R3;

import android.text.TextUtils;
import com.google.firebase.inappmessaging.model.MessageType;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c extends i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f7124e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n f7125f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g f7126g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final R3.a f7127h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f7128i;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public n f7129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public n f7130b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public g f7131c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public R3.a f7132d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f7133e;

        public c a(e eVar, Map map) {
            if (this.f7129a == null) {
                throw new IllegalArgumentException("Banner model must have a title");
            }
            if (TextUtils.isEmpty(this.f7133e)) {
                throw new IllegalArgumentException("Banner model must have a background color");
            }
            return new c(eVar, this.f7129a, this.f7130b, this.f7131c, this.f7132d, this.f7133e, map);
        }

        public b b(R3.a aVar) {
            this.f7132d = aVar;
            return this;
        }

        public b c(String str) {
            this.f7133e = str;
            return this;
        }

        public b d(n nVar) {
            this.f7130b = nVar;
            return this;
        }

        public b e(g gVar) {
            this.f7131c = gVar;
            return this;
        }

        public b f(n nVar) {
            this.f7129a = nVar;
            return this;
        }
    }

    public c(e eVar, n nVar, n nVar2, g gVar, R3.a aVar, String str, Map map) {
        super(eVar, MessageType.BANNER, map);
        this.f7124e = nVar;
        this.f7125f = nVar2;
        this.f7126g = gVar;
        this.f7127h = aVar;
        this.f7128i = str;
    }

    public static b d() {
        return new b();
    }

    @Override // R3.i
    public g b() {
        return this.f7126g;
    }

    public R3.a e() {
        return this.f7127h;
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
        n nVar = this.f7125f;
        if ((nVar == null && cVar.f7125f != null) || (nVar != null && !nVar.equals(cVar.f7125f))) {
            return false;
        }
        g gVar = this.f7126g;
        if ((gVar == null && cVar.f7126g != null) || (gVar != null && !gVar.equals(cVar.f7126g))) {
            return false;
        }
        R3.a aVar = this.f7127h;
        return (aVar != null || cVar.f7127h == null) && (aVar == null || aVar.equals(cVar.f7127h)) && this.f7124e.equals(cVar.f7124e) && this.f7128i.equals(cVar.f7128i);
    }

    public String f() {
        return this.f7128i;
    }

    public n g() {
        return this.f7125f;
    }

    public n h() {
        return this.f7124e;
    }

    public int hashCode() {
        n nVar = this.f7125f;
        int iHashCode = nVar != null ? nVar.hashCode() : 0;
        g gVar = this.f7126g;
        int iHashCode2 = gVar != null ? gVar.hashCode() : 0;
        R3.a aVar = this.f7127h;
        return this.f7124e.hashCode() + iHashCode + iHashCode2 + (aVar != null ? aVar.hashCode() : 0) + this.f7128i.hashCode();
    }
}
