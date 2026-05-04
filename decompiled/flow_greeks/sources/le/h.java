package le;

import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h implements ve.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f15623b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ef.f f15624a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final h a(Object value, ef.f fVar) {
            kotlin.jvm.internal.t.f(value, "value");
            return f.l(value.getClass()) ? new v(fVar, (Enum) value) : value instanceof Annotation ? new i(fVar, (Annotation) value) : value instanceof Object[] ? new l(fVar, (Object[]) value) : value instanceof Class ? new r(fVar, (Class) value) : new x(fVar, value);
        }

        public a() {
        }
    }

    public /* synthetic */ h(ef.f fVar, kotlin.jvm.internal.k kVar) {
        this(fVar);
    }

    @Override // ve.b
    public ef.f getName() {
        return this.f15624a;
    }

    public h(ef.f fVar) {
        this.f15624a = fVar;
    }
}
