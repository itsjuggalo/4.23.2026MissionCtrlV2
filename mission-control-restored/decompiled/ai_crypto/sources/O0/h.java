package O0;

import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4028a = new a(null);

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public static /* synthetic */ h b(a aVar, Object obj, String str, j jVar, g gVar, int i7, Object obj2) {
            if ((i7 & 2) != 0) {
                jVar = c.f4011a.a();
            }
            if ((i7 & 4) != 0) {
                gVar = O0.a.f4006a;
            }
            return aVar.a(obj, str, jVar, gVar);
        }

        public final h a(Object obj, String tag, j verificationMode, g logger) {
            r.f(obj, "<this>");
            r.f(tag, "tag");
            r.f(verificationMode, "verificationMode");
            r.f(logger, "logger");
            return new i(obj, tag, verificationMode, logger);
        }

        public a() {
        }
    }

    public abstract Object a();

    public final String b(Object value, String message) {
        r.f(value, "value");
        r.f(message, "message");
        return message + " value: " + value;
    }

    public abstract h c(String str, Q5.k kVar);
}
