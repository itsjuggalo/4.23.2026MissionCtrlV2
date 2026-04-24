package X5;

import h6.InterfaceC1893b;
import java.lang.annotation.Annotation;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: X5.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0992h implements InterfaceC1893b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f9427b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q6.f f9428a;

    /* JADX INFO: renamed from: X5.h$a */
    public static final class a {
        public a() {
        }

        public final AbstractC0992h a(Object value, q6.f fVar) {
            AbstractC2304t.f(value, "value");
            return AbstractC0990f.l(value.getClass()) ? new v(fVar, (Enum) value) : value instanceof Annotation ? new i(fVar, (Annotation) value) : value instanceof Object[] ? new l(fVar, (Object[]) value) : value instanceof Class ? new r(fVar, (Class) value) : new x(fVar, value);
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public AbstractC0992h(q6.f fVar) {
        this.f9428a = fVar;
    }

    @Override // h6.InterfaceC1893b
    public q6.f getName() {
        return this.f9428a;
    }

    public /* synthetic */ AbstractC0992h(q6.f fVar, AbstractC2296k abstractC2296k) {
        this(fVar);
    }
}
