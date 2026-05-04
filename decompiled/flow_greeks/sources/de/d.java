package de;

import dd.q;
import dd.r;
import de.f;
import java.util.List;
import kotlin.jvm.internal.t;
import wf.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends qf.f {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(n storageManager, b containingClass) {
        super(storageManager, containingClass);
        t.f(storageManager, "storageManager");
        t.f(containingClass, "containingClass");
    }

    @Override // qf.f
    public List j() {
        fe.e eVarM = m();
        t.d(eVarM, "null cannot be cast to non-null type org.jetbrains.kotlin.builtins.functions.FunctionClassDescriptor");
        f fVarU0 = ((b) eVarM).U0();
        return t.b(fVarU0, f.a.f8069e) ? q.e(e.E.a((b) m(), false)) : t.b(fVarU0, f.d.f8072e) ? q.e(e.E.a((b) m(), true)) : r.k();
    }
}
