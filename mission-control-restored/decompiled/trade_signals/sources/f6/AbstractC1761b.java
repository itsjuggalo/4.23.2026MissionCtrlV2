package f6;

import I6.I0;
import R5.m0;
import kotlin.jvm.internal.AbstractC2304t;
import p5.Q;

/* JADX INFO: renamed from: f6.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1761b {
    public static final C1760a a(I0 i02, boolean z7, boolean z8, m0 m0Var) {
        AbstractC2304t.f(i02, "<this>");
        return new C1760a(i02, null, z8, z7, m0Var != null ? Q.c(m0Var) : null, null, 34, null);
    }

    public static /* synthetic */ C1760a b(I0 i02, boolean z7, boolean z8, m0 m0Var, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z7 = false;
        }
        if ((i8 & 2) != 0) {
            z8 = false;
        }
        if ((i8 & 4) != 0) {
            m0Var = null;
        }
        return a(i02, z7, z8, m0Var);
    }
}
