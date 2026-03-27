package T5;

import R5.InterfaceC0848e;
import java.util.Collection;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;
import q6.f;

/* JADX INFO: loaded from: classes2.dex */
public interface a {

    /* JADX INFO: renamed from: T5.a$a, reason: collision with other inner class name */
    public static final class C0116a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0116a f8000a = new C0116a();

        @Override // T5.a
        public Collection a(InterfaceC0848e classDescriptor) {
            AbstractC2304t.f(classDescriptor, "classDescriptor");
            return AbstractC2595q.i();
        }

        @Override // T5.a
        public Collection b(InterfaceC0848e classDescriptor) {
            AbstractC2304t.f(classDescriptor, "classDescriptor");
            return AbstractC2595q.i();
        }

        @Override // T5.a
        public Collection c(f name, InterfaceC0848e classDescriptor) {
            AbstractC2304t.f(name, "name");
            AbstractC2304t.f(classDescriptor, "classDescriptor");
            return AbstractC2595q.i();
        }

        @Override // T5.a
        public Collection e(InterfaceC0848e classDescriptor) {
            AbstractC2304t.f(classDescriptor, "classDescriptor");
            return AbstractC2595q.i();
        }
    }

    Collection a(InterfaceC0848e interfaceC0848e);

    Collection b(InterfaceC0848e interfaceC0848e);

    Collection c(f fVar, InterfaceC0848e interfaceC0848e);

    Collection e(InterfaceC0848e interfaceC0848e);
}
