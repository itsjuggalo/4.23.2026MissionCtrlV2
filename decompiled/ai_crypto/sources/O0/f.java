package O0;

import E5.m;
import F5.AbstractC0552j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class f extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f4023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f4024e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f4025f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l f4026g;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4027a;

        static {
            int[] iArr = new int[j.values().length];
            try {
                iArr[j.STRICT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[j.LOG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[j.QUIET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f4027a = iArr;
        }
    }

    public f(Object value, String tag, String message, g logger, j verificationMode) {
        r.f(value, "value");
        r.f(tag, "tag");
        r.f(message, "message");
        r.f(logger, "logger");
        r.f(verificationMode, "verificationMode");
        this.f4021b = value;
        this.f4022c = tag;
        this.f4023d = message;
        this.f4024e = logger;
        this.f4025f = verificationMode;
        l lVar = new l(b(value, message));
        StackTraceElement[] stackTrace = lVar.getStackTrace();
        r.e(stackTrace, "stackTrace");
        lVar.setStackTrace((StackTraceElement[]) AbstractC0552j.r(stackTrace, 2).toArray(new StackTraceElement[0]));
        this.f4026g = lVar;
    }

    @Override // O0.h
    public Object a() throws l {
        int i7 = a.f4027a[this.f4025f.ordinal()];
        if (i7 == 1) {
            throw this.f4026g;
        }
        if (i7 == 2) {
            this.f4024e.a(this.f4022c, b(this.f4021b, this.f4023d));
            return null;
        }
        if (i7 == 3) {
            return null;
        }
        throw new m();
    }

    @Override // O0.h
    public h c(String message, Q5.k condition) {
        r.f(message, "message");
        r.f(condition, "condition");
        return this;
    }
}
