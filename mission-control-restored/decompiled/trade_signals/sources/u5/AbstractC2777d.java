package u5;

import kotlin.jvm.internal.AbstractC2304t;
import s5.InterfaceC2707e;
import s5.InterfaceC2708f;
import s5.InterfaceC2711i;

/* JADX INFO: renamed from: u5.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2777d extends AbstractC2774a {
    private final InterfaceC2711i _context;
    private transient InterfaceC2707e intercepted;

    public AbstractC2777d(InterfaceC2707e interfaceC2707e) {
        this(interfaceC2707e, interfaceC2707e != null ? interfaceC2707e.getContext() : null);
    }

    @Override // s5.InterfaceC2707e
    public InterfaceC2711i getContext() {
        InterfaceC2711i interfaceC2711i = this._context;
        AbstractC2304t.c(interfaceC2711i);
        return interfaceC2711i;
    }

    public final InterfaceC2707e intercepted() {
        InterfaceC2707e interfaceC2707eR = this.intercepted;
        if (interfaceC2707eR == null) {
            InterfaceC2708f interfaceC2708f = (InterfaceC2708f) getContext().a(InterfaceC2708f.f23114O);
            if (interfaceC2708f == null || (interfaceC2707eR = interfaceC2708f.R(this)) == null) {
                interfaceC2707eR = this;
            }
            this.intercepted = interfaceC2707eR;
        }
        return interfaceC2707eR;
    }

    @Override // u5.AbstractC2774a
    public void releaseIntercepted() {
        InterfaceC2707e interfaceC2707e = this.intercepted;
        if (interfaceC2707e != null && interfaceC2707e != this) {
            InterfaceC2711i.b bVarA = getContext().a(InterfaceC2708f.f23114O);
            AbstractC2304t.c(bVarA);
            ((InterfaceC2708f) bVarA).D(interfaceC2707e);
        }
        this.intercepted = C2776c.f23520a;
    }

    public AbstractC2777d(InterfaceC2707e interfaceC2707e, InterfaceC2711i interfaceC2711i) {
        super(interfaceC2707e);
        this._context = interfaceC2711i;
    }
}
