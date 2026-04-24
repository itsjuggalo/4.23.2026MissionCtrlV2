package D;

import C.e;
import D.f;
import D.p;

/* JADX INFO: loaded from: classes.dex */
public class l extends p {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int[] f695k = new int[2];

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f696a;

        static {
            int[] iArr = new int[p.b.values().length];
            f696a = iArr;
            try {
                iArr[p.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f696a[p.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f696a[p.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public l(C.e eVar) {
        super(eVar);
        this.f730h.f674e = f.a.LEFT;
        this.f731i.f674e = f.a.RIGHT;
        this.f728f = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x029a, code lost:
    
        if (r14 != 1) goto L134;
     */
    @Override // D.p, D.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(D.d r17) {
        /*
            Method dump skipped, instruction units count: 1035
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D.l.a(D.d):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x01c1  */
    @Override // D.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d() {
        /*
            Method dump skipped, instruction units count: 922
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D.l.d():void");
    }

    @Override // D.p
    public void e() {
        f fVar = this.f730h;
        if (fVar.f679j) {
            this.f724b.i1(fVar.f676g);
        }
    }

    @Override // D.p
    public void f() {
        this.f725c = null;
        this.f730h.c();
        this.f731i.c();
        this.f727e.c();
        this.f729g = false;
    }

    @Override // D.p
    public boolean m() {
        return this.f726d != e.b.MATCH_CONSTRAINT || this.f724b.f367w == 0;
    }

    public final void q(int[] iArr, int i8, int i9, int i10, int i11, float f8, int i12) {
        int i13 = i9 - i8;
        int i14 = i11 - i10;
        if (i12 != -1) {
            if (i12 == 0) {
                iArr[0] = (int) ((i14 * f8) + 0.5f);
                iArr[1] = i14;
                return;
            } else {
                if (i12 != 1) {
                    return;
                }
                iArr[0] = i13;
                iArr[1] = (int) ((i13 * f8) + 0.5f);
                return;
            }
        }
        int i15 = (int) ((i14 * f8) + 0.5f);
        int i16 = (int) ((i13 / f8) + 0.5f);
        if (i15 <= i13) {
            iArr[0] = i15;
            iArr[1] = i14;
        } else if (i16 <= i14) {
            iArr[0] = i13;
            iArr[1] = i16;
        }
    }

    public void r() {
        this.f729g = false;
        this.f730h.c();
        this.f730h.f679j = false;
        this.f731i.c();
        this.f731i.f679j = false;
        this.f727e.f679j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.f724b.r();
    }
}
