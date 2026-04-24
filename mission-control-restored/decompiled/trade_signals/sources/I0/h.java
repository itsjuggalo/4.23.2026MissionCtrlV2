package I0;

import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4042a = new a(null);

    public static final class a {
        public a() {
        }

        public static /* synthetic */ h b(a aVar, Object obj, String str, j jVar, g gVar, int i8, Object obj2) {
            if ((i8 & 2) != 0) {
                jVar = c.f4025a.a();
            }
            if ((i8 & 4) != 0) {
                gVar = I0.a.f4018a;
            }
            return aVar.a(obj, str, jVar, gVar);
        }

        public final h a(Object obj, String tag, j verificationMode, g logger) {
            AbstractC2304t.f(obj, "<this>");
            AbstractC2304t.f(tag, "tag");
            AbstractC2304t.f(verificationMode, "verificationMode");
            AbstractC2304t.f(logger, "logger");
            return new i(obj, tag, verificationMode, logger);
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public abstract Object a();

    public final String b(Object value, String message) {
        AbstractC2304t.f(value, "value");
        AbstractC2304t.f(message, "message");
        return message + " value: " + value;
    }

    public abstract h c(String str, B5.k kVar);
}
