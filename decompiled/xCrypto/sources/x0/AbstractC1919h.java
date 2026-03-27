package x0;

import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: x0.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1919h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f15713a = new a(null);

    /* JADX INFO: renamed from: x0.h$a */
    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public static /* synthetic */ AbstractC1919h b(a aVar, Object obj, String str, EnumC1921j enumC1921j, InterfaceC1918g interfaceC1918g, int i4, Object obj2) {
            if ((i4 & 2) != 0) {
                enumC1921j = C1914c.f15696a.a();
            }
            if ((i4 & 4) != 0) {
                interfaceC1918g = C1912a.f15691a;
            }
            return aVar.a(obj, str, enumC1921j, interfaceC1918g);
        }

        public final AbstractC1919h a(Object obj, String tag, EnumC1921j verificationMode, InterfaceC1918g logger) {
            r.f(obj, "<this>");
            r.f(tag, "tag");
            r.f(verificationMode, "verificationMode");
            r.f(logger, "logger");
            return new C1920i(obj, tag, verificationMode, logger);
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

    public abstract AbstractC1919h c(String str, i3.k kVar);
}
