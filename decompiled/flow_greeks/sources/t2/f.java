package t2;

import cd.o;
import dd.n;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f20649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f20651d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f20652e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f20653f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m f20654g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20655a;

        static {
            int[] iArr = new int[j.values().length];
            try {
                iArr[j.f20661a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[j.f20662b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[j.f20663c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f20655a = iArr;
        }
    }

    public f(Object value, String tag, String message, g logger, j verificationMode) {
        t.f(value, "value");
        t.f(tag, "tag");
        t.f(message, "message");
        t.f(logger, "logger");
        t.f(verificationMode, "verificationMode");
        this.f20649b = value;
        this.f20650c = tag;
        this.f20651d = message;
        this.f20652e = logger;
        this.f20653f = verificationMode;
        m mVar = new m(b(value, message));
        StackTraceElement[] stackTrace = mVar.getStackTrace();
        t.e(stackTrace, "getStackTrace(...)");
        mVar.setStackTrace((StackTraceElement[]) n.z(stackTrace, 2).toArray(new StackTraceElement[0]));
        this.f20654g = mVar;
    }

    @Override // t2.h
    public Object a() throws m {
        int i10 = a.f20655a[this.f20653f.ordinal()];
        if (i10 == 1) {
            throw this.f20654g;
        }
        if (i10 == 2) {
            this.f20652e.a(this.f20650c, b(this.f20649b, this.f20651d));
            return null;
        }
        if (i10 == 3) {
            return null;
        }
        throw new o();
    }

    @Override // t2.h
    public h c(String message, pd.k condition) {
        t.f(message, "message");
        t.f(condition, "condition");
        return this;
    }
}
