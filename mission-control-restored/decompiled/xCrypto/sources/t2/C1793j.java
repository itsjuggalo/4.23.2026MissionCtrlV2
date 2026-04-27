package t2;

import java.io.IOException;
import q2.q;
import q2.u;
import q2.v;
import q2.w;
import q2.x;
import x2.C1925a;
import y2.C1946a;

/* JADX INFO: renamed from: t2.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1793j extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x f14787b = g(u.f14287b);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f14788a;

    /* JADX INFO: renamed from: t2.j$a */
    public class a implements x {
        public a() {
        }

        @Override // q2.x
        public w create(q2.e eVar, C1925a c1925a) {
            if (c1925a.c() == Number.class) {
                return C1793j.this;
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: t2.j$b */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14790a;

        static {
            int[] iArr = new int[y2.b.values().length];
            f14790a = iArr;
            try {
                iArr[y2.b.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14790a[y2.b.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14790a[y2.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public C1793j(v vVar) {
        this.f14788a = vVar;
    }

    public static x f(v vVar) {
        return vVar == u.f14287b ? f14787b : g(vVar);
    }

    public static x g(v vVar) {
        return new C1793j(vVar).new a();
    }

    @Override // q2.w
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Number c(C1946a c1946a) throws IOException {
        y2.b bVarR0 = c1946a.r0();
        int i4 = b.f14790a[bVarR0.ordinal()];
        if (i4 == 1) {
            c1946a.n0();
            return null;
        }
        if (i4 == 2 || i4 == 3) {
            return this.f14788a.a(c1946a);
        }
        throw new q("Expecting number, got: " + bVarR0 + "; at path " + c1946a.K());
    }

    @Override // q2.w
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void e(y2.c cVar, Number number) throws IOException {
        cVar.r0(number);
    }
}
