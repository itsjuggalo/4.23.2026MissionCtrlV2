package x0;

import W2.m;
import X2.AbstractC0765l;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: x0.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1917f extends AbstractC1919h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f15706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f15707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f15708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceC1918g f15709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final EnumC1921j f15710f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l f15711g;

    /* JADX INFO: renamed from: x0.f$a */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15712a;

        static {
            int[] iArr = new int[EnumC1921j.values().length];
            try {
                iArr[EnumC1921j.STRICT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC1921j.LOG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC1921j.QUIET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f15712a = iArr;
        }
    }

    public C1917f(Object value, String tag, String message, InterfaceC1918g logger, EnumC1921j verificationMode) {
        r.f(value, "value");
        r.f(tag, "tag");
        r.f(message, "message");
        r.f(logger, "logger");
        r.f(verificationMode, "verificationMode");
        this.f15706b = value;
        this.f15707c = tag;
        this.f15708d = message;
        this.f15709e = logger;
        this.f15710f = verificationMode;
        l lVar = new l(b(value, message));
        StackTraceElement[] stackTrace = lVar.getStackTrace();
        r.e(stackTrace, "stackTrace");
        lVar.setStackTrace((StackTraceElement[]) AbstractC0765l.s(stackTrace, 2).toArray(new StackTraceElement[0]));
        this.f15711g = lVar;
    }

    @Override // x0.AbstractC1919h
    public Object a() throws l {
        int i4 = a.f15712a[this.f15710f.ordinal()];
        if (i4 == 1) {
            throw this.f15711g;
        }
        if (i4 == 2) {
            this.f15709e.a(this.f15707c, b(this.f15706b, this.f15708d));
            return null;
        }
        if (i4 == 3) {
            return null;
        }
        throw new m();
    }

    @Override // x0.AbstractC1919h
    public AbstractC1919h c(String message, i3.k condition) {
        r.f(message, "message");
        r.f(condition, "condition");
        return this;
    }
}
