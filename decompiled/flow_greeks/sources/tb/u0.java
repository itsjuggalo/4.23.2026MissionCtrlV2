package tb;

import java.nio.charset.Charset;
import rb.m0;
import rb.y0;
import tb.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class u0 extends a.c {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final m0.a f21762w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final y0.g f21763x;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public rb.k1 f21764s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public rb.y0 f21765t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Charset f21766u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f21767v;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements m0.a {
        @Override // rb.y0.j
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer b(byte[] bArr) {
            if (bArr.length >= 3) {
                return Integer.valueOf(((bArr[0] - 48) * 100) + ((bArr[1] - 48) * 10) + (bArr[2] - 48));
            }
            throw new NumberFormatException("Malformed status code " + new String(bArr, rb.m0.f19649a));
        }

        @Override // rb.y0.j
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public byte[] a(Integer num) {
            throw new UnsupportedOperationException();
        }
    }

    static {
        a aVar = new a();
        f21762w = aVar;
        f21763x = rb.m0.b(":status", aVar);
    }

    public u0(int i10, n2 n2Var, t2 t2Var) {
        super(i10, n2Var, t2Var);
        this.f21766u = p6.d.f18313c;
    }

    public static Charset O(rb.y0 y0Var) {
        String str = (String) y0Var.g(r0.f21633j);
        if (str != null) {
            try {
                return Charset.forName(str.split("charset=", 2)[r2.length - 1].trim());
            } catch (Exception unused) {
            }
        }
        return p6.d.f18313c;
    }

    public static void R(rb.y0 y0Var) {
        y0Var.e(f21763x);
        y0Var.e(rb.o0.f19657b);
        y0Var.e(rb.o0.f19656a);
    }

    public abstract void P(rb.k1 k1Var, boolean z10, rb.y0 y0Var);

    public final rb.k1 Q(rb.y0 y0Var) {
        rb.k1 k1Var = (rb.k1) y0Var.g(rb.o0.f19657b);
        if (k1Var != null) {
            return k1Var.r((String) y0Var.g(rb.o0.f19656a));
        }
        if (this.f21767v) {
            return rb.k1.f19594g.r("missing GRPC status in response");
        }
        Integer num = (Integer) y0Var.g(f21763x);
        return (num != null ? r0.m(num.intValue()) : rb.k1.f19606s.r("missing HTTP status code")).f("missing GRPC status, inferred error from HTTP status code");
    }

    public void S(x1 x1Var, boolean z10) throws Throwable {
        rb.k1 k1Var = this.f21764s;
        if (k1Var != null) {
            this.f21764s = k1Var.f("DATA-----------------------------\n" + y1.e(x1Var, this.f21766u));
            x1Var.close();
            if (this.f21764s.o().length() > 1000 || z10) {
                P(this.f21764s, false, this.f21765t);
                return;
            }
            return;
        }
        if (!this.f21767v) {
            P(rb.k1.f19606s.r("headers not received before payload"), false, new rb.y0());
            return;
        }
        int iD = x1Var.d();
        D(x1Var);
        if (z10) {
            if (iD > 0) {
                this.f21764s = rb.k1.f19606s.r("Received unexpected EOS on non-empty DATA frame from server");
            } else {
                this.f21764s = rb.k1.f19606s.r("Received unexpected EOS on empty DATA frame from server");
            }
            rb.y0 y0Var = new rb.y0();
            this.f21765t = y0Var;
            N(this.f21764s, false, y0Var);
        }
    }

    /* JADX WARN: Finally extract failed */
    public void T(rb.y0 y0Var) {
        p6.n.o(y0Var, "headers");
        rb.k1 k1Var = this.f21764s;
        if (k1Var != null) {
            this.f21764s = k1Var.f("headers: " + y0Var);
            return;
        }
        try {
            if (this.f21767v) {
                rb.k1 k1VarR = rb.k1.f19606s.r("Received headers twice");
                this.f21764s = k1VarR;
                if (k1VarR != null) {
                    this.f21764s = k1VarR.f("headers: " + y0Var);
                    this.f21765t = y0Var;
                    this.f21766u = O(y0Var);
                    return;
                }
                return;
            }
            Integer num = (Integer) y0Var.g(f21763x);
            if (num != null && num.intValue() >= 100 && num.intValue() < 200) {
                rb.k1 k1Var2 = this.f21764s;
                if (k1Var2 != null) {
                    this.f21764s = k1Var2.f("headers: " + y0Var);
                    this.f21765t = y0Var;
                    this.f21766u = O(y0Var);
                    return;
                }
                return;
            }
            this.f21767v = true;
            rb.k1 k1VarV = V(y0Var);
            this.f21764s = k1VarV;
            if (k1VarV != null) {
                if (k1VarV != null) {
                    this.f21764s = k1VarV.f("headers: " + y0Var);
                    this.f21765t = y0Var;
                    this.f21766u = O(y0Var);
                    return;
                }
                return;
            }
            R(y0Var);
            E(y0Var);
            rb.k1 k1Var3 = this.f21764s;
            if (k1Var3 != null) {
                this.f21764s = k1Var3.f("headers: " + y0Var);
                this.f21765t = y0Var;
                this.f21766u = O(y0Var);
            }
        } catch (Throwable th) {
            rb.k1 k1Var4 = this.f21764s;
            if (k1Var4 != null) {
                this.f21764s = k1Var4.f("headers: " + y0Var);
                this.f21765t = y0Var;
                this.f21766u = O(y0Var);
            }
            throw th;
        }
    }

    public void U(rb.y0 y0Var) {
        p6.n.o(y0Var, "trailers");
        if (this.f21764s == null && !this.f21767v) {
            rb.k1 k1VarV = V(y0Var);
            this.f21764s = k1VarV;
            if (k1VarV != null) {
                this.f21765t = y0Var;
            }
        }
        rb.k1 k1Var = this.f21764s;
        if (k1Var == null) {
            rb.k1 k1VarQ = Q(y0Var);
            R(y0Var);
            F(y0Var, k1VarQ);
        } else {
            rb.k1 k1VarF = k1Var.f("trailers: " + y0Var);
            this.f21764s = k1VarF;
            P(k1VarF, false, this.f21765t);
        }
    }

    public final rb.k1 V(rb.y0 y0Var) {
        Integer num = (Integer) y0Var.g(f21763x);
        if (num == null) {
            return rb.k1.f19606s.r("Missing HTTP status code");
        }
        String str = (String) y0Var.g(r0.f21633j);
        if (r0.n(str)) {
            return null;
        }
        return r0.m(num.intValue()).f("invalid content-type: " + str);
    }

    @Override // tb.a.c, tb.l1.b
    public /* bridge */ /* synthetic */ void c(boolean z10) {
        super.c(z10);
    }
}
