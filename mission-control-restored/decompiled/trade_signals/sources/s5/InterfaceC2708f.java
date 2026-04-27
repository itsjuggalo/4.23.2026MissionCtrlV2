package s5;

import kotlin.jvm.internal.AbstractC2304t;
import s5.InterfaceC2711i;

/* JADX INFO: renamed from: s5.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC2708f extends InterfaceC2711i.b {

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public static final b f23114O = b.f23115a;

    /* JADX INFO: renamed from: s5.f$a */
    public static final class a {
        public static InterfaceC2711i.b a(InterfaceC2708f interfaceC2708f, InterfaceC2711i.c key) {
            AbstractC2304t.f(key, "key");
            if (!(key instanceof AbstractC2704b)) {
                if (InterfaceC2708f.f23114O != key) {
                    return null;
                }
                AbstractC2304t.d(interfaceC2708f, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return interfaceC2708f;
            }
            AbstractC2704b abstractC2704b = (AbstractC2704b) key;
            if (!abstractC2704b.a(interfaceC2708f.getKey())) {
                return null;
            }
            InterfaceC2711i.b bVarB = abstractC2704b.b(interfaceC2708f);
            if (bVarB instanceof InterfaceC2711i.b) {
                return bVarB;
            }
            return null;
        }

        public static InterfaceC2711i b(InterfaceC2708f interfaceC2708f, InterfaceC2711i.c key) {
            AbstractC2304t.f(key, "key");
            if (!(key instanceof AbstractC2704b)) {
                return InterfaceC2708f.f23114O == key ? C2712j.f23116a : interfaceC2708f;
            }
            AbstractC2704b abstractC2704b = (AbstractC2704b) key;
            return (!abstractC2704b.a(interfaceC2708f.getKey()) || abstractC2704b.b(interfaceC2708f) == null) ? interfaceC2708f : C2712j.f23116a;
        }
    }

    /* JADX INFO: renamed from: s5.f$b */
    public static final class b implements InterfaceC2711i.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f23115a = new b();
    }

    void D(InterfaceC2707e interfaceC2707e);

    InterfaceC2707e R(InterfaceC2707e interfaceC2707e);
}
