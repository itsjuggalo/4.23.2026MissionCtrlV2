package ke;

import fe.g1;
import fe.h1;
import java.lang.annotation.Annotation;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements g1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Annotation f14828b;

    public b(Annotation annotation) {
        t.f(annotation, "annotation");
        this.f14828b = annotation;
    }

    @Override // fe.g1
    public h1 a() {
        h1 NO_SOURCE_FILE = h1.f9484a;
        t.e(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }

    public final Annotation d() {
        return this.f14828b;
    }
}
