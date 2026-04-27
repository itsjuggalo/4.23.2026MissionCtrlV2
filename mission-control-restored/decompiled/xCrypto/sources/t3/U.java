package t3;

import a3.AbstractC0787c;

/* JADX INFO: loaded from: classes3.dex */
public class U extends AbstractC1802a implements T {
    public U(Z2.i iVar, boolean z4) {
        super(iVar, true, z4);
    }

    public static /* synthetic */ Object O0(U u4, Z2.e eVar) throws Throwable {
        Object objZ = u4.z(eVar);
        AbstractC0787c.e();
        return objZ;
    }

    @Override // t3.T
    public Object await(Z2.e eVar) {
        return O0(this, eVar);
    }

    @Override // t3.T
    public Object getCompleted() {
        return T();
    }
}
