package j$.time.format;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
final class e implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f[] f17167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f17168b;

    e(ArrayList arrayList, boolean z7) {
        this((f[]) arrayList.toArray(new f[arrayList.size()]), z7);
    }

    e(f[] fVarArr, boolean z7) {
        this.f17167a = fVarArr;
        this.f17168b = z7;
    }

    public final e a() {
        return !this.f17168b ? this : new e(this.f17167a, false);
    }

    @Override // j$.time.format.f
    public final boolean p(t tVar, StringBuilder sb) {
        int length = sb.length();
        boolean z7 = this.f17168b;
        if (z7) {
            tVar.g();
        }
        try {
            for (f fVar : this.f17167a) {
                if (!fVar.p(tVar, sb)) {
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
    public final int r(q qVar, CharSequence charSequence, int i7) {
        boolean z7 = this.f17168b;
        f[] fVarArr = this.f17167a;
        if (z7) {
            qVar.q();
            int iR = i7;
            for (f fVar : fVarArr) {
                iR = fVar.r(qVar, charSequence, iR);
                if (iR < 0) {
                    qVar.e(false);
                    return i7;
                }
            }
            qVar.e(true);
            return iR;
        }
        for (f fVar2 : fVarArr) {
            i7 = fVar2.r(qVar, charSequence, i7);
            if (i7 < 0) {
                break;
            }
        }
        return i7;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        f[] fVarArr = this.f17167a;
        if (fVarArr != null) {
            boolean z7 = this.f17168b;
            sb.append(z7 ? "[" : "(");
            for (f fVar : fVarArr) {
                sb.append(fVar);
            }
            sb.append(z7 ? "]" : ")");
        }
        return sb.toString();
    }
}
