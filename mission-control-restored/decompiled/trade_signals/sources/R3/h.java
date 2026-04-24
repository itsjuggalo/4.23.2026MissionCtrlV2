package R3;

import com.google.firebase.inappmessaging.model.MessageType;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class h extends i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g f7159e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public R3.a f7160f;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g f7161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public R3.a f7162b;

        public h a(e eVar, Map map) {
            g gVar = this.f7161a;
            if (gVar != null) {
                return new h(eVar, gVar, this.f7162b, map);
            }
            throw new IllegalArgumentException("ImageOnly model must have image data");
        }

        public b b(R3.a aVar) {
            this.f7162b = aVar;
            return this;
        }

        public b c(g gVar) {
            this.f7161a = gVar;
            return this;
        }
    }

    public h(e eVar, g gVar, R3.a aVar, Map map) {
        super(eVar, MessageType.IMAGE_ONLY, map);
        this.f7159e = gVar;
        this.f7160f = aVar;
    }

    public static b d() {
        return new b();
    }

    @Override // R3.i
    public g b() {
        return this.f7159e;
    }

    public R3.a e() {
        return this.f7160f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (hashCode() != hVar.hashCode()) {
            return false;
        }
        R3.a aVar = this.f7160f;
        return (aVar != null || hVar.f7160f == null) && (aVar == null || aVar.equals(hVar.f7160f)) && this.f7159e.equals(hVar.f7159e);
    }

    public int hashCode() {
        R3.a aVar = this.f7160f;
        return this.f7159e.hashCode() + (aVar != null ? aVar.hashCode() : 0);
    }
}
