package P6;

import R5.InterfaceC0856m;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public interface l {

    public static final class a implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6511a = new a();

        @Override // P6.l
        public boolean a(InterfaceC0856m what, InterfaceC0856m from) {
            AbstractC2304t.f(what, "what");
            AbstractC2304t.f(from, "from");
            return true;
        }
    }

    boolean a(InterfaceC0856m interfaceC0856m, InterfaceC0856m interfaceC0856m2);
}
