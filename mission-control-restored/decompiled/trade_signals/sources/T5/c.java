package T5;

import R5.InterfaceC0848e;
import R5.g0;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public interface c {

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8001a = new a();

        @Override // T5.c
        public boolean d(InterfaceC0848e classDescriptor, g0 functionDescriptor) {
            AbstractC2304t.f(classDescriptor, "classDescriptor");
            AbstractC2304t.f(functionDescriptor, "functionDescriptor");
            return true;
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f8002a = new b();

        @Override // T5.c
        public boolean d(InterfaceC0848e classDescriptor, g0 functionDescriptor) {
            AbstractC2304t.f(classDescriptor, "classDescriptor");
            AbstractC2304t.f(functionDescriptor, "functionDescriptor");
            return !functionDescriptor.getAnnotations().r(d.a());
        }
    }

    boolean d(InterfaceC0848e interfaceC0848e, g0 g0Var);
}
