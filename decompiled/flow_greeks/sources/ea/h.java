package ea;

import com.google.firebase.inappmessaging.model.MessageType;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h extends i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g f8592e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ea.a f8593f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g f8594a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ea.a f8595b;

        public h a(e eVar, Map map) {
            g gVar = this.f8594a;
            if (gVar != null) {
                return new h(eVar, gVar, this.f8595b, map);
            }
            throw new IllegalArgumentException("ImageOnly model must have image data");
        }

        public b b(ea.a aVar) {
            this.f8595b = aVar;
            return this;
        }

        public b c(g gVar) {
            this.f8594a = gVar;
            return this;
        }
    }

    public static b d() {
        return new b();
    }

    @Override // ea.i
    public g b() {
        return this.f8592e;
    }

    public ea.a e() {
        return this.f8593f;
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
        ea.a aVar = this.f8593f;
        return (aVar != null || hVar.f8593f == null) && (aVar == null || aVar.equals(hVar.f8593f)) && this.f8592e.equals(hVar.f8592e);
    }

    public int hashCode() {
        ea.a aVar = this.f8593f;
        return this.f8592e.hashCode() + (aVar != null ? aVar.hashCode() : 0);
    }

    public h(e eVar, g gVar, ea.a aVar, Map map) {
        super(eVar, MessageType.IMAGE_ONLY, map);
        this.f8592e = gVar;
        this.f8593f = aVar;
    }
}
