package P6;

import R5.InterfaceC0868z;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public interface f {

    public static final class a {
        public static String a(f fVar, InterfaceC0868z functionDescriptor) {
            AbstractC2304t.f(functionDescriptor, "functionDescriptor");
            if (fVar.a(functionDescriptor)) {
                return null;
            }
            return fVar.getDescription();
        }
    }

    boolean a(InterfaceC0868z interfaceC0868z);

    String b(InterfaceC0868z interfaceC0868z);

    String getDescription();
}
