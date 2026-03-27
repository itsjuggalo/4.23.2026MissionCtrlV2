package f;

import g.f;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: f.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1541h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f.e f14023a = f.b.f14235a;

    /* JADX INFO: renamed from: f.h$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f.e f14024a = f.b.f14235a;

        public final C1541h a() {
            C1541h c1541h = new C1541h();
            c1541h.b(this.f14024a);
            return c1541h;
        }

        public final a b(f.e mediaType) {
            r.f(mediaType, "mediaType");
            this.f14024a = mediaType;
            return this;
        }
    }

    public final f.e a() {
        return this.f14023a;
    }

    public final void b(f.e eVar) {
        r.f(eVar, "<set-?>");
        this.f14023a = eVar;
    }
}
