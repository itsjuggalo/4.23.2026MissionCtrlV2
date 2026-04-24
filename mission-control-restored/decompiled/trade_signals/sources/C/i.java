package C;

import D.o;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class i extends e implements h {

    /* JADX INFO: renamed from: L0, reason: collision with root package name */
    public e[] f421L0 = new e[4];

    /* JADX INFO: renamed from: M0, reason: collision with root package name */
    public int f422M0 = 0;

    @Override // C.h
    public void a(e eVar) {
        if (eVar == this || eVar == null) {
            return;
        }
        int i8 = this.f422M0 + 1;
        e[] eVarArr = this.f421L0;
        if (i8 > eVarArr.length) {
            this.f421L0 = (e[]) Arrays.copyOf(eVarArr, eVarArr.length * 2);
        }
        e[] eVarArr2 = this.f421L0;
        int i9 = this.f422M0;
        eVarArr2[i9] = eVar;
        this.f422M0 = i9 + 1;
    }

    @Override // C.h
    public void b() {
        this.f422M0 = 0;
        Arrays.fill(this.f421L0, (Object) null);
    }

    public void n1(ArrayList arrayList, int i8, o oVar) {
        for (int i9 = 0; i9 < this.f422M0; i9++) {
            oVar.a(this.f421L0[i9]);
        }
        for (int i10 = 0; i10 < this.f422M0; i10++) {
            D.i.a(this.f421L0[i10], i8, arrayList, oVar);
        }
    }

    public int o1(int i8) {
        int i9;
        int i10;
        for (int i11 = 0; i11 < this.f422M0; i11++) {
            e eVar = this.f421L0[i11];
            if (i8 == 0 && (i10 = eVar.f304I0) != -1) {
                return i10;
            }
            if (i8 == 1 && (i9 = eVar.f306J0) != -1) {
                return i9;
            }
        }
        return -1;
    }

    @Override // C.h
    public void c(f fVar) {
    }
}
