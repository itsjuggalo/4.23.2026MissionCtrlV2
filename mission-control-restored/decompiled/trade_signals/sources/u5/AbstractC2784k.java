package u5;

import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.InterfaceC2300o;
import kotlin.jvm.internal.O;
import s5.InterfaceC2707e;

/* JADX INFO: renamed from: u5.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2784k extends AbstractC2783j implements InterfaceC2300o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23527a;

    public AbstractC2784k(int i8, InterfaceC2707e interfaceC2707e) {
        super(interfaceC2707e);
        this.f23527a = i8;
    }

    @Override // kotlin.jvm.internal.InterfaceC2300o
    public int getArity() {
        return this.f23527a;
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
