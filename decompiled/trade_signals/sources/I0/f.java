package I0;

import kotlin.jvm.internal.AbstractC2304t;
import o5.C2487o;
import p5.AbstractC2592n;

/* JADX INFO: loaded from: classes.dex */
public final class f extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f4037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f4038e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f4039f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l f4040g;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4041a;

        static {
            int[] iArr = new int[j.values().length];
            try {
                iArr[j.f4047a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[j.f4048b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[j.f4049c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f4041a = iArr;
        }
    }

    public f(Object value, String tag, String message, g logger, j verificationMode) {
        AbstractC2304t.f(value, "value");
        AbstractC2304t.f(tag, "tag");
        AbstractC2304t.f(message, "message");
        AbstractC2304t.f(logger, "logger");
        AbstractC2304t.f(verificationMode, "verificationMode");
        this.f4035b = value;
        this.f4036c = tag;
        this.f4037d = message;
        this.f4038e = logger;
        this.f4039f = verificationMode;
        l lVar = new l(b(value, message));
        StackTraceElement[] stackTrace = lVar.getStackTrace();
        AbstractC2304t.e(stackTrace, "getStackTrace(...)");
        lVar.setStackTrace((StackTraceElement[]) AbstractC2592n.z(stackTrace, 2).toArray(new StackTraceElement[0]));
        this.f4040g = lVar;
    }

    @Override // I0.h
    public Object a() throws l {
        int i8 = a.f4041a[this.f4039f.ordinal()];
        if (i8 == 1) {
            throw this.f4040g;
        }
        if (i8 == 2) {
            this.f4038e.a(this.f4036c, b(this.f4035b, this.f4037d));
            return null;
        }
        if (i8 == 3) {
            return null;
        }
        throw new C2487o();
    }

    @Override // I0.h
    public h c(String message, B5.k condition) {
        AbstractC2304t.f(message, "message");
        AbstractC2304t.f(condition, "condition");
        return this;
    }
}
