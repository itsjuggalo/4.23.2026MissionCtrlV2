package z;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class i extends e implements h {

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public e[] f25941w0 = new e[4];

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f25942x0 = 0;

    @Override // z.h
    public void a() {
        this.f25942x0 = 0;
        Arrays.fill(this.f25941w0, (Object) null);
    }

    @Override // z.h
    public void b(e eVar) {
        if (eVar == this || eVar == null) {
            return;
        }
        int i7 = this.f25942x0 + 1;
        e[] eVarArr = this.f25941w0;
        if (i7 > eVarArr.length) {
            this.f25941w0 = (e[]) Arrays.copyOf(eVarArr, eVarArr.length * 2);
        }
        e[] eVarArr2 = this.f25941w0;
        int i8 = this.f25942x0;
        eVarArr2[i8] = eVar;
        this.f25942x0 = i8 + 1;
    }

    @Override // z.h
    public void c(f fVar) {
    }
}
