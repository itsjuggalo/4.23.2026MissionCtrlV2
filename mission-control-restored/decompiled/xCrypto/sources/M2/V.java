package M2;

import K2.M;
import K2.Z;
import M2.AbstractC0408a;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public abstract class V extends AbstractC0408a.c {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final M.a f2044w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Z.g f2045x;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public K2.l0 f2046s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public K2.Z f2047t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Charset f2048u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f2049v;

    public class a implements M.a {
        @Override // K2.Z.j
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer b(byte[] bArr) {
            if (bArr.length >= 3) {
                return Integer.valueOf(((bArr[0] - 48) * 100) + ((bArr[1] - 48) * 10) + (bArr[2] - 48));
            }
            throw new NumberFormatException("Malformed status code " + new String(bArr, K2.M.f1054a));
        }

        @Override // K2.Z.j
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public byte[] a(Integer num) {
            throw new UnsupportedOperationException();
        }
    }

    static {
        a aVar = new a();
        f2044w = aVar;
        f2045x = K2.M.b(":status", aVar);
    }

    public V(int i4, O0 o02, U0 u02) {
        super(i4, o02, u02);
        this.f2048u = Z1.c.f5968c;
    }

    public static Charset O(K2.Z z4) {
        String str = (String) z4.g(S.f1964j);
        if (str != null) {
            try {
                return Charset.forName(str.split("charset=", 2)[r2.length - 1].trim());
            } catch (Exception unused) {
            }
        }
        return Z1.c.f5968c;
    }

    public static void R(K2.Z z4) {
        z4.e(f2045x);
        z4.e(K2.O.f1057b);
        z4.e(K2.O.f1056a);
    }

    public abstract void P(K2.l0 l0Var, boolean z4, K2.Z z5);

    public final K2.l0 Q(K2.Z z4) {
        K2.l0 l0Var = (K2.l0) z4.g(K2.O.f1057b);
        if (l0Var != null) {
            return l0Var.q((String) z4.g(K2.O.f1056a));
        }
        if (this.f2049v) {
            return K2.l0.f1217g.q("missing GRPC status in response");
        }
        Integer num = (Integer) z4.g(f2045x);
        return (num != null ? S.m(num.intValue()) : K2.l0.f1229s.q("missing HTTP status code")).e("missing GRPC status, inferred error from HTTP status code");
    }

    public void S(y0 y0Var, boolean z4) throws Throwable {
        K2.l0 l0Var = this.f2046s;
        if (l0Var != null) {
            this.f2046s = l0Var.e("DATA-----------------------------\n" + z0.e(y0Var, this.f2048u));
            y0Var.close();
            if (this.f2046s.n().length() > 1000 || z4) {
                P(this.f2046s, false, this.f2047t);
                return;
            }
            return;
        }
        if (!this.f2049v) {
            P(K2.l0.f1229s.q("headers not received before payload"), false, new K2.Z());
            return;
        }
        int iD = y0Var.d();
        D(y0Var);
        if (z4) {
            if (iD > 0) {
                this.f2046s = K2.l0.f1229s.q("Received unexpected EOS on non-empty DATA frame from server");
            } else {
                this.f2046s = K2.l0.f1229s.q("Received unexpected EOS on empty DATA frame from server");
            }
            K2.Z z5 = new K2.Z();
            this.f2047t = z5;
            N(this.f2046s, false, z5);
        }
    }

    /* JADX WARN: Finally extract failed */
    public void T(K2.Z z4) {
        Z1.m.o(z4, "headers");
        K2.l0 l0Var = this.f2046s;
        if (l0Var != null) {
            this.f2046s = l0Var.e("headers: " + z4);
            return;
        }
        try {
            if (this.f2049v) {
                K2.l0 l0VarQ = K2.l0.f1229s.q("Received headers twice");
                this.f2046s = l0VarQ;
                if (l0VarQ != null) {
                    this.f2046s = l0VarQ.e("headers: " + z4);
                    this.f2047t = z4;
                    this.f2048u = O(z4);
                    return;
                }
                return;
            }
            Integer num = (Integer) z4.g(f2045x);
            if (num != null && num.intValue() >= 100 && num.intValue() < 200) {
                K2.l0 l0Var2 = this.f2046s;
                if (l0Var2 != null) {
                    this.f2046s = l0Var2.e("headers: " + z4);
                    this.f2047t = z4;
                    this.f2048u = O(z4);
                    return;
                }
                return;
            }
            this.f2049v = true;
            K2.l0 l0VarV = V(z4);
            this.f2046s = l0VarV;
            if (l0VarV != null) {
                if (l0VarV != null) {
                    this.f2046s = l0VarV.e("headers: " + z4);
                    this.f2047t = z4;
                    this.f2048u = O(z4);
                    return;
                }
                return;
            }
            R(z4);
            E(z4);
            K2.l0 l0Var3 = this.f2046s;
            if (l0Var3 != null) {
                this.f2046s = l0Var3.e("headers: " + z4);
                this.f2047t = z4;
                this.f2048u = O(z4);
            }
        } catch (Throwable th) {
            K2.l0 l0Var4 = this.f2046s;
            if (l0Var4 != null) {
                this.f2046s = l0Var4.e("headers: " + z4);
                this.f2047t = z4;
                this.f2048u = O(z4);
            }
            throw th;
        }
    }

    public void U(K2.Z z4) {
        Z1.m.o(z4, "trailers");
        if (this.f2046s == null && !this.f2049v) {
            K2.l0 l0VarV = V(z4);
            this.f2046s = l0VarV;
            if (l0VarV != null) {
                this.f2047t = z4;
            }
        }
        K2.l0 l0Var = this.f2046s;
        if (l0Var == null) {
            K2.l0 l0VarQ = Q(z4);
            R(z4);
            F(z4, l0VarQ);
        } else {
            K2.l0 l0VarE = l0Var.e("trailers: " + z4);
            this.f2046s = l0VarE;
            P(l0VarE, false, this.f2047t);
        }
    }

    public final K2.l0 V(K2.Z z4) {
        Integer num = (Integer) z4.g(f2045x);
        if (num == null) {
            return K2.l0.f1229s.q("Missing HTTP status code");
        }
        String str = (String) z4.g(S.f1964j);
        if (S.n(str)) {
            return null;
        }
        return S.m(num.intValue()).e("invalid content-type: " + str);
    }

    @Override // M2.AbstractC0408a.c, M2.C0433m0.b
    public /* bridge */ /* synthetic */ void c(boolean z4) {
        super.c(z4);
    }
}
