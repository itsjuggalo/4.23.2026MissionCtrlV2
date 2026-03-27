package j$.time.format;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class e implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f[] f19744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f19745b;

    e(List list, boolean z7) {
        this((f[]) list.toArray(new f[list.size()]), z7);
    }

    e(f[] fVarArr, boolean z7) {
        this.f19744a = fVarArr;
        this.f19745b = z7;
    }

    public final e a() {
        return !this.f19745b ? this : new e(this.f19744a, false);
    }

    @Override // j$.time.format.f
    public final boolean o(t tVar, StringBuilder sb) {
        int length = sb.length();
        boolean z7 = this.f19745b;
        if (z7) {
            tVar.g();
        }
        try {
            for (f fVar : this.f19744a) {
                if (!fVar.o(tVar, sb)) {
                    sb.setLength(length);
                    return true;
                }
            }
            if (z7) {
                tVar.a();
            }
            return true;
        } finally {
            if (z7) {
                tVar.a();
            }
        }
    }

    @Override // j$.time.format.f
    public final int q(q qVar, CharSequence charSequence, int i8) {
        boolean z7 = this.f19745b;
        f[] fVarArr = this.f19744a;
        if (!z7) {
            for (f fVar : fVarArr) {
                i8 = fVar.q(qVar, charSequence, i8);
                if (i8 < 0) {
                    break;
                }
            }
            return i8;
        }
        qVar.q();
        int iQ = i8;
        for (f fVar2 : fVarArr) {
            iQ = fVar2.q(qVar, charSequence, iQ);
            if (iQ < 0) {
                qVar.e(false);
                return i8;
            }
        }
        qVar.e(true);
        return iQ;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        f[] fVarArr = this.f19744a;
        if (fVarArr != null) {
            boolean z7 = this.f19745b;
            sb.append(z7 ? "[" : "(");
            for (f fVar : fVarArr) {
                sb.append(fVar);
            }
            sb.append(z7 ? "]" : ")");
        }
        return sb.toString();
    }
}
