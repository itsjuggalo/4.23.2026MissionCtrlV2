package s5;

import kotlin.jvm.internal.AbstractC2304t;
import s5.InterfaceC2711i;

/* JADX INFO: renamed from: s5.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2704b implements InterfaceC2711i.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final B5.k f23110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2711i.c f23111b;

    public AbstractC2704b(InterfaceC2711i.c baseKey, B5.k safeCast) {
        AbstractC2304t.f(baseKey, "baseKey");
        AbstractC2304t.f(safeCast, "safeCast");
        this.f23110a = safeCast;
        this.f23111b = baseKey instanceof AbstractC2704b ? ((AbstractC2704b) baseKey).f23111b : baseKey;
    }

    public final boolean a(InterfaceC2711i.c key) {
        AbstractC2304t.f(key, "key");
        return key == this || this.f23111b == key;
    }

    public final InterfaceC2711i.b b(InterfaceC2711i.b element) {
        AbstractC2304t.f(element, "element");
        return (InterfaceC2711i.b) this.f23110a.invoke(element);
    }
}
