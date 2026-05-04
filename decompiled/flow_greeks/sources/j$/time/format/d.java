package j$.time.format;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e[] f13637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f13638b;

    /* JADX WARN: Illegal instructions before constructor call */
    public d(List list, boolean z10) {
        ArrayList arrayList = (ArrayList) list;
        this((e[]) arrayList.toArray(new e[arrayList.size()]), z10);
    }

    public d(e[] eVarArr, boolean z10) {
        this.f13637a = eVarArr;
        this.f13638b = z10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        if (r2 != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
    
        return true;
     */
    @Override // j$.time.format.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean s(j$.time.format.s r8, java.lang.StringBuilder r9) {
        /*
            r7 = this;
            int r0 = r9.length()
            r1 = 1
            boolean r2 = r7.f13638b
            if (r2 == 0) goto Le
            int r3 = r8.f13682c
            int r3 = r3 + r1
            r8.f13682c = r3
        Le:
            j$.time.format.e[] r3 = r7.f13637a     // Catch: java.lang.Throwable -> L27
            int r4 = r3.length     // Catch: java.lang.Throwable -> L27
            r5 = 0
        L12:
            if (r5 >= r4) goto L2c
            r6 = r3[r5]     // Catch: java.lang.Throwable -> L27
            boolean r6 = r6.s(r8, r9)     // Catch: java.lang.Throwable -> L27
            if (r6 != 0) goto L29
            r9.setLength(r0)     // Catch: java.lang.Throwable -> L27
            if (r2 == 0) goto L2f
        L21:
            int r9 = r8.f13682c
            int r9 = r9 - r1
            r8.f13682c = r9
            return r1
        L27:
            r9 = move-exception
            goto L30
        L29:
            int r5 = r5 + 1
            goto L12
        L2c:
            if (r2 == 0) goto L2f
            goto L21
        L2f:
            return r1
        L30:
            if (r2 == 0) goto L37
            int r0 = r8.f13682c
            int r0 = r0 - r1
            r8.f13682c = r0
        L37:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.d.s(j$.time.format.s, java.lang.StringBuilder):boolean");
    }

    @Override // j$.time.format.e
    public final int A(p pVar, CharSequence charSequence, int i10) {
        boolean z10 = this.f13638b;
        e[] eVarArr = this.f13637a;
        int i11 = 0;
        if (z10) {
            ArrayList arrayList = pVar.f13675d;
            w wVarC = pVar.c();
            wVarC.getClass();
            w wVar = new w();
            ((HashMap) wVar.f13686a).putAll(wVarC.f13686a);
            wVar.f13687b = wVarC.f13687b;
            wVar.f13688c = wVarC.f13688c;
            wVar.f13689d = wVarC.f13689d;
            arrayList.add(wVar);
            int length = eVarArr.length;
            int iA = i10;
            while (i11 < length) {
                iA = eVarArr[i11].A(pVar, charSequence, iA);
                if (iA < 0) {
                    pVar.f13675d.remove(r8.size() - 1);
                    return i10;
                }
                i11++;
            }
            pVar.f13675d.remove(r8.size() - 2);
            return iA;
        }
        int length2 = eVarArr.length;
        while (i11 < length2) {
            i10 = eVarArr[i11].A(pVar, charSequence, i10);
            if (i10 < 0) {
                return i10;
            }
            i11++;
        }
        return i10;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        e[] eVarArr = this.f13637a;
        if (eVarArr != null) {
            boolean z10 = this.f13638b;
            sb2.append(z10 ? "[" : "(");
            for (e eVar : eVarArr) {
                sb2.append(eVar);
            }
            sb2.append(z10 ? "]" : ")");
        }
        return sb2.toString();
    }
}
