package a5;

/* JADX INFO: renamed from: a5.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0317y extends I4.a implements I4.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0316x f4164b = new C0316x(I4.e.f649a, new X4.h(1));

    public AbstractC0317y() {
        super(I4.e.f649a);
    }

    public abstract void g(I4.i iVar, Runnable runnable);

    @Override // I4.a, I4.i
    public final I4.g get(I4.h key) {
        I4.g gVar;
        kotlin.jvm.internal.j.e(key, "key");
        if (!(key instanceof C0316x)) {
            if (I4.e.f649a == key) {
                return this;
            }
            return null;
        }
        C0316x c0316x = (C0316x) key;
        I4.h hVar = this.f645a;
        if ((hVar == c0316x || c0316x.f4162b == hVar) && (gVar = (I4.g) c0316x.f4161a.invoke(this)) != null) {
            return gVar;
        }
        return null;
    }

    public boolean h(I4.i iVar) {
        return !(this instanceof A0);
    }

    public AbstractC0317y i(int i) {
        f5.a.a(i);
        return new f5.g(this, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0026 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0027 A[RETURN] */
    @Override // I4.a, I4.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final I4.i minusKey(I4.h r4) {
        /*
            r3 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.j.e(r4, r0)
            boolean r0 = r4 instanceof a5.C0316x
            I4.j r1 = I4.j.f650a
            if (r0 == 0) goto L22
            a5.x r4 = (a5.C0316x) r4
            I4.h r0 = r3.f645a
            if (r0 == r4) goto L17
            I4.h r2 = r4.f4162b
            if (r2 != r0) goto L16
            goto L17
        L16:
            return r3
        L17:
            R4.l r4 = r4.f4161a
            java.lang.Object r4 = r4.invoke(r3)
            I4.g r4 = (I4.g) r4
            if (r4 == 0) goto L27
            goto L26
        L22:
            I4.e r0 = I4.e.f649a
            if (r0 != r4) goto L27
        L26:
            return r1
        L27:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.AbstractC0317y.minusKey(I4.h):I4.i");
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + C.j(this);
    }
}
