package u5;

import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.InterfaceC2300o;
import kotlin.jvm.internal.O;
import s5.InterfaceC2707e;

/* JADX INFO: renamed from: u5.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2785l extends AbstractC2777d implements InterfaceC2300o {
    private final int arity;

    public AbstractC2785l(int i8, InterfaceC2707e interfaceC2707e) {
        super(interfaceC2707e);
        this.arity = i8;
    }

    @Override // kotlin.jvm.internal.InterfaceC2300o
    public int getArity() {
        return this.arity;
    }

    @Override // u5.AbstractC2774a
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String strI = O.i(this);
        AbstractC2304t.e(strI, "renderLambdaToString(...)");
        return strI;
    }
}
