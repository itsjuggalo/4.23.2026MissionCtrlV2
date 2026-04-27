package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.amazon.a.a.o.b.f;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import k4.C2105D;
import org.xmlpull.v1.XmlPullParserException;
import w.C2769a;
import x.AbstractC2813a;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f7105d = {0, 4, 8};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static SparseIntArray f7106e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f7107a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7108b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap f7109c = new HashMap();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f7111b = new d();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final C0121c f7112c = new C0121c();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f7113d = new b();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final e f7114e = new e();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public HashMap f7115f = new HashMap();

        public void b(ConstraintLayout.b bVar) {
            b bVar2 = this.f7113d;
            bVar.f7037d = bVar2.f7157h;
            bVar.f7039e = bVar2.f7159i;
            bVar.f7041f = bVar2.f7161j;
            bVar.f7043g = bVar2.f7163k;
            bVar.f7045h = bVar2.f7164l;
            bVar.f7047i = bVar2.f7165m;
            bVar.f7049j = bVar2.f7166n;
            bVar.f7051k = bVar2.f7167o;
            bVar.f7053l = bVar2.f7168p;
            bVar.f7061p = bVar2.f7169q;
            bVar.f7062q = bVar2.f7170r;
            bVar.f7063r = bVar2.f7171s;
            bVar.f7064s = bVar2.f7172t;
            ((ViewGroup.MarginLayoutParams) bVar).leftMargin = bVar2.f7120D;
            ((ViewGroup.MarginLayoutParams) bVar).rightMargin = bVar2.f7121E;
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = bVar2.f7122F;
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = bVar2.f7123G;
            bVar.f7069x = bVar2.f7131O;
            bVar.f7070y = bVar2.f7130N;
            bVar.f7066u = bVar2.f7127K;
            bVar.f7068w = bVar2.f7129M;
            bVar.f7071z = bVar2.f7173u;
            bVar.f7005A = bVar2.f7174v;
            bVar.f7055m = bVar2.f7176x;
            bVar.f7057n = bVar2.f7177y;
            bVar.f7059o = bVar2.f7178z;
            bVar.f7006B = bVar2.f7175w;
            bVar.f7021Q = bVar2.f7117A;
            bVar.f7022R = bVar2.f7118B;
            bVar.f7010F = bVar2.f7132P;
            bVar.f7009E = bVar2.f7133Q;
            bVar.f7012H = bVar2.f7135S;
            bVar.f7011G = bVar2.f7134R;
            bVar.f7024T = bVar2.f7158h0;
            bVar.f7025U = bVar2.f7160i0;
            bVar.f7013I = bVar2.f7136T;
            bVar.f7014J = bVar2.f7137U;
            bVar.f7017M = bVar2.f7138V;
            bVar.f7018N = bVar2.f7139W;
            bVar.f7015K = bVar2.f7140X;
            bVar.f7016L = bVar2.f7141Y;
            bVar.f7019O = bVar2.f7142Z;
            bVar.f7020P = bVar2.f7144a0;
            bVar.f7023S = bVar2.f7119C;
            bVar.f7035c = bVar2.f7155g;
            bVar.f7031a = bVar2.f7151e;
            bVar.f7033b = bVar2.f7153f;
            ((ViewGroup.MarginLayoutParams) bVar).width = bVar2.f7147c;
            ((ViewGroup.MarginLayoutParams) bVar).height = bVar2.f7149d;
            String str = bVar2.f7156g0;
            if (str != null) {
                bVar.f7026V = str;
            }
            bVar.setMarginStart(bVar2.f7125I);
            bVar.setMarginEnd(this.f7113d.f7124H);
            bVar.a();
        }

        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = new a();
            aVar.f7113d.a(this.f7113d);
            aVar.f7112c.a(this.f7112c);
            aVar.f7111b.a(this.f7111b);
            aVar.f7114e.a(this.f7114e);
            aVar.f7110a = this.f7110a;
            return aVar;
        }

        public final void d(int i7, ConstraintLayout.b bVar) {
            this.f7110a = i7;
            b bVar2 = this.f7113d;
            bVar2.f7157h = bVar.f7037d;
            bVar2.f7159i = bVar.f7039e;
            bVar2.f7161j = bVar.f7041f;
            bVar2.f7163k = bVar.f7043g;
            bVar2.f7164l = bVar.f7045h;
            bVar2.f7165m = bVar.f7047i;
            bVar2.f7166n = bVar.f7049j;
            bVar2.f7167o = bVar.f7051k;
            bVar2.f7168p = bVar.f7053l;
            bVar2.f7169q = bVar.f7061p;
            bVar2.f7170r = bVar.f7062q;
            bVar2.f7171s = bVar.f7063r;
            bVar2.f7172t = bVar.f7064s;
            bVar2.f7173u = bVar.f7071z;
            bVar2.f7174v = bVar.f7005A;
            bVar2.f7175w = bVar.f7006B;
            bVar2.f7176x = bVar.f7055m;
            bVar2.f7177y = bVar.f7057n;
            bVar2.f7178z = bVar.f7059o;
            bVar2.f7117A = bVar.f7021Q;
            bVar2.f7118B = bVar.f7022R;
            bVar2.f7119C = bVar.f7023S;
            bVar2.f7155g = bVar.f7035c;
            bVar2.f7151e = bVar.f7031a;
            bVar2.f7153f = bVar.f7033b;
            bVar2.f7147c = ((ViewGroup.MarginLayoutParams) bVar).width;
            bVar2.f7149d = ((ViewGroup.MarginLayoutParams) bVar).height;
            bVar2.f7120D = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
            bVar2.f7121E = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
            bVar2.f7122F = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            bVar2.f7123G = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
            bVar2.f7132P = bVar.f7010F;
            bVar2.f7133Q = bVar.f7009E;
            bVar2.f7135S = bVar.f7012H;
            bVar2.f7134R = bVar.f7011G;
            bVar2.f7158h0 = bVar.f7024T;
            bVar2.f7160i0 = bVar.f7025U;
            bVar2.f7136T = bVar.f7013I;
            bVar2.f7137U = bVar.f7014J;
            bVar2.f7138V = bVar.f7017M;
            bVar2.f7139W = bVar.f7018N;
            bVar2.f7140X = bVar.f7015K;
            bVar2.f7141Y = bVar.f7016L;
            bVar2.f7142Z = bVar.f7019O;
            bVar2.f7144a0 = bVar.f7020P;
            bVar2.f7156g0 = bVar.f7026V;
            bVar2.f7127K = bVar.f7066u;
            bVar2.f7129M = bVar.f7068w;
            bVar2.f7126J = bVar.f7065t;
            bVar2.f7128L = bVar.f7067v;
            bVar2.f7131O = bVar.f7069x;
            bVar2.f7130N = bVar.f7070y;
            bVar2.f7124H = bVar.getMarginEnd();
            this.f7113d.f7125I = bVar.getMarginStart();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public static SparseIntArray f7116k0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7147c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7149d;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public int[] f7152e0;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public String f7154f0;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public String f7156g0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7143a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7145b = false;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7151e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f7153f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f7155g = -1.0f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f7157h = -1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f7159i = -1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f7161j = -1;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f7163k = -1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f7164l = -1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f7165m = -1;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f7166n = -1;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f7167o = -1;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f7168p = -1;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f7169q = -1;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f7170r = -1;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f7171s = -1;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f7172t = -1;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public float f7173u = 0.5f;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public float f7174v = 0.5f;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public String f7175w = null;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f7176x = -1;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f7177y = 0;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public float f7178z = 0.0f;

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        public int f7117A = -1;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        public int f7118B = -1;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        public int f7119C = -1;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        public int f7120D = -1;

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        public int f7121E = -1;

        /* JADX INFO: renamed from: F, reason: collision with root package name */
        public int f7122F = -1;

        /* JADX INFO: renamed from: G, reason: collision with root package name */
        public int f7123G = -1;

        /* JADX INFO: renamed from: H, reason: collision with root package name */
        public int f7124H = -1;

        /* JADX INFO: renamed from: I, reason: collision with root package name */
        public int f7125I = -1;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public int f7126J = -1;

        /* JADX INFO: renamed from: K, reason: collision with root package name */
        public int f7127K = -1;

        /* JADX INFO: renamed from: L, reason: collision with root package name */
        public int f7128L = -1;

        /* JADX INFO: renamed from: M, reason: collision with root package name */
        public int f7129M = -1;

        /* JADX INFO: renamed from: N, reason: collision with root package name */
        public int f7130N = -1;

        /* JADX INFO: renamed from: O, reason: collision with root package name */
        public int f7131O = -1;

        /* JADX INFO: renamed from: P, reason: collision with root package name */
        public float f7132P = -1.0f;

        /* JADX INFO: renamed from: Q, reason: collision with root package name */
        public float f7133Q = -1.0f;

        /* JADX INFO: renamed from: R, reason: collision with root package name */
        public int f7134R = 0;

        /* JADX INFO: renamed from: S, reason: collision with root package name */
        public int f7135S = 0;

        /* JADX INFO: renamed from: T, reason: collision with root package name */
        public int f7136T = 0;

        /* JADX INFO: renamed from: U, reason: collision with root package name */
        public int f7137U = 0;

        /* JADX INFO: renamed from: V, reason: collision with root package name */
        public int f7138V = -1;

        /* JADX INFO: renamed from: W, reason: collision with root package name */
        public int f7139W = -1;

        /* JADX INFO: renamed from: X, reason: collision with root package name */
        public int f7140X = -1;

        /* JADX INFO: renamed from: Y, reason: collision with root package name */
        public int f7141Y = -1;

        /* JADX INFO: renamed from: Z, reason: collision with root package name */
        public float f7142Z = 1.0f;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public float f7144a0 = 1.0f;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public int f7146b0 = -1;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public int f7148c0 = 0;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public int f7150d0 = -1;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public boolean f7158h0 = false;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public boolean f7160i0 = false;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public boolean f7162j0 = true;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f7116k0 = sparseIntArray;
            sparseIntArray.append(B.d.f654q3, 24);
            f7116k0.append(B.d.f660r3, 25);
            f7116k0.append(B.d.f672t3, 28);
            f7116k0.append(B.d.f678u3, 29);
            f7116k0.append(B.d.f708z3, 35);
            f7116k0.append(B.d.f702y3, 34);
            f7116k0.append(B.d.f564b3, 4);
            f7116k0.append(B.d.f558a3, 3);
            f7116k0.append(B.d.f547Y2, 1);
            f7116k0.append(B.d.f431E3, 6);
            f7116k0.append(B.d.f437F3, 7);
            f7116k0.append(B.d.f606i3, 17);
            f7116k0.append(B.d.f612j3, 18);
            f7116k0.append(B.d.f618k3, 19);
            f7116k0.append(B.d.f460J2, 26);
            f7116k0.append(B.d.f684v3, 31);
            f7116k0.append(B.d.f690w3, 32);
            f7116k0.append(B.d.f600h3, 10);
            f7116k0.append(B.d.f594g3, 9);
            f7116k0.append(B.d.f455I3, 13);
            f7116k0.append(B.d.f473L3, 16);
            f7116k0.append(B.d.f461J3, 14);
            f7116k0.append(B.d.f443G3, 11);
            f7116k0.append(B.d.f467K3, 15);
            f7116k0.append(B.d.f449H3, 12);
            f7116k0.append(B.d.f419C3, 38);
            f7116k0.append(B.d.f642o3, 37);
            f7116k0.append(B.d.f636n3, 39);
            f7116k0.append(B.d.f413B3, 40);
            f7116k0.append(B.d.f630m3, 20);
            f7116k0.append(B.d.f407A3, 36);
            f7116k0.append(B.d.f588f3, 5);
            f7116k0.append(B.d.f648p3, 76);
            f7116k0.append(B.d.f696x3, 76);
            f7116k0.append(B.d.f666s3, 76);
            f7116k0.append(B.d.f552Z2, 76);
            f7116k0.append(B.d.f542X2, 76);
            f7116k0.append(B.d.f478M2, 23);
            f7116k0.append(B.d.f490O2, 27);
            f7116k0.append(B.d.f502Q2, 30);
            f7116k0.append(B.d.f508R2, 8);
            f7116k0.append(B.d.f484N2, 33);
            f7116k0.append(B.d.f496P2, 2);
            f7116k0.append(B.d.f466K2, 22);
            f7116k0.append(B.d.f472L2, 21);
            f7116k0.append(B.d.f570c3, 61);
            f7116k0.append(B.d.f582e3, 62);
            f7116k0.append(B.d.f576d3, 63);
            f7116k0.append(B.d.f425D3, 69);
            f7116k0.append(B.d.f624l3, 70);
            f7116k0.append(B.d.f532V2, 71);
            f7116k0.append(B.d.f520T2, 72);
            f7116k0.append(B.d.f526U2, 73);
            f7116k0.append(B.d.f537W2, 74);
            f7116k0.append(B.d.f514S2, 75);
        }

        public void a(b bVar) {
            this.f7143a = bVar.f7143a;
            this.f7147c = bVar.f7147c;
            this.f7145b = bVar.f7145b;
            this.f7149d = bVar.f7149d;
            this.f7151e = bVar.f7151e;
            this.f7153f = bVar.f7153f;
            this.f7155g = bVar.f7155g;
            this.f7157h = bVar.f7157h;
            this.f7159i = bVar.f7159i;
            this.f7161j = bVar.f7161j;
            this.f7163k = bVar.f7163k;
            this.f7164l = bVar.f7164l;
            this.f7165m = bVar.f7165m;
            this.f7166n = bVar.f7166n;
            this.f7167o = bVar.f7167o;
            this.f7168p = bVar.f7168p;
            this.f7169q = bVar.f7169q;
            this.f7170r = bVar.f7170r;
            this.f7171s = bVar.f7171s;
            this.f7172t = bVar.f7172t;
            this.f7173u = bVar.f7173u;
            this.f7174v = bVar.f7174v;
            this.f7175w = bVar.f7175w;
            this.f7176x = bVar.f7176x;
            this.f7177y = bVar.f7177y;
            this.f7178z = bVar.f7178z;
            this.f7117A = bVar.f7117A;
            this.f7118B = bVar.f7118B;
            this.f7119C = bVar.f7119C;
            this.f7120D = bVar.f7120D;
            this.f7121E = bVar.f7121E;
            this.f7122F = bVar.f7122F;
            this.f7123G = bVar.f7123G;
            this.f7124H = bVar.f7124H;
            this.f7125I = bVar.f7125I;
            this.f7126J = bVar.f7126J;
            this.f7127K = bVar.f7127K;
            this.f7128L = bVar.f7128L;
            this.f7129M = bVar.f7129M;
            this.f7130N = bVar.f7130N;
            this.f7131O = bVar.f7131O;
            this.f7132P = bVar.f7132P;
            this.f7133Q = bVar.f7133Q;
            this.f7134R = bVar.f7134R;
            this.f7135S = bVar.f7135S;
            this.f7136T = bVar.f7136T;
            this.f7137U = bVar.f7137U;
            this.f7138V = bVar.f7138V;
            this.f7139W = bVar.f7139W;
            this.f7140X = bVar.f7140X;
            this.f7141Y = bVar.f7141Y;
            this.f7142Z = bVar.f7142Z;
            this.f7144a0 = bVar.f7144a0;
            this.f7146b0 = bVar.f7146b0;
            this.f7148c0 = bVar.f7148c0;
            this.f7150d0 = bVar.f7150d0;
            this.f7156g0 = bVar.f7156g0;
            int[] iArr = bVar.f7152e0;
            if (iArr != null) {
                this.f7152e0 = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.f7152e0 = null;
            }
            this.f7154f0 = bVar.f7154f0;
            this.f7158h0 = bVar.f7158h0;
            this.f7160i0 = bVar.f7160i0;
            this.f7162j0 = bVar.f7162j0;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, B.d.f454I2);
            this.f7145b = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                int i8 = f7116k0.get(index);
                if (i8 == 80) {
                    this.f7158h0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f7158h0);
                } else if (i8 != 81) {
                    switch (i8) {
                        case 1:
                            this.f7168p = c.n(typedArrayObtainStyledAttributes, index, this.f7168p);
                            break;
                        case 2:
                            this.f7123G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7123G);
                            break;
                        case 3:
                            this.f7167o = c.n(typedArrayObtainStyledAttributes, index, this.f7167o);
                            break;
                        case 4:
                            this.f7166n = c.n(typedArrayObtainStyledAttributes, index, this.f7166n);
                            break;
                        case 5:
                            this.f7175w = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        case 6:
                            this.f7117A = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f7117A);
                            break;
                        case 7:
                            this.f7118B = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f7118B);
                            break;
                        case 8:
                            this.f7124H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7124H);
                            break;
                        case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            this.f7172t = c.n(typedArrayObtainStyledAttributes, index, this.f7172t);
                            break;
                        case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            this.f7171s = c.n(typedArrayObtainStyledAttributes, index, this.f7171s);
                            break;
                        case 11:
                            this.f7129M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7129M);
                            break;
                        case 12:
                            this.f7130N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7130N);
                            break;
                        case 13:
                            this.f7126J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7126J);
                            break;
                        case 14:
                            this.f7128L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7128L);
                            break;
                        case 15:
                            this.f7131O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7131O);
                            break;
                        case com.amazon.c.a.a.c.f10119g /* 16 */:
                            this.f7127K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7127K);
                            break;
                        case C2105D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                            this.f7151e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f7151e);
                            break;
                        case C2105D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                            this.f7153f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f7153f);
                            break;
                        case 19:
                            this.f7155g = typedArrayObtainStyledAttributes.getFloat(index, this.f7155g);
                            break;
                        case 20:
                            this.f7173u = typedArrayObtainStyledAttributes.getFloat(index, this.f7173u);
                            break;
                        case 21:
                            this.f7149d = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f7149d);
                            break;
                        case 22:
                            this.f7147c = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f7147c);
                            break;
                        case 23:
                            this.f7120D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7120D);
                            break;
                        case 24:
                            this.f7157h = c.n(typedArrayObtainStyledAttributes, index, this.f7157h);
                            break;
                        case 25:
                            this.f7159i = c.n(typedArrayObtainStyledAttributes, index, this.f7159i);
                            break;
                        case 26:
                            this.f7119C = typedArrayObtainStyledAttributes.getInt(index, this.f7119C);
                            break;
                        case 27:
                            this.f7121E = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7121E);
                            break;
                        case 28:
                            this.f7161j = c.n(typedArrayObtainStyledAttributes, index, this.f7161j);
                            break;
                        case 29:
                            this.f7163k = c.n(typedArrayObtainStyledAttributes, index, this.f7163k);
                            break;
                        case 30:
                            this.f7125I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7125I);
                            break;
                        case 31:
                            this.f7169q = c.n(typedArrayObtainStyledAttributes, index, this.f7169q);
                            break;
                        case com.amazon.c.a.a.c.f10120h /* 32 */:
                            this.f7170r = c.n(typedArrayObtainStyledAttributes, index, this.f7170r);
                            break;
                        case 33:
                            this.f7122F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7122F);
                            break;
                        case 34:
                            this.f7165m = c.n(typedArrayObtainStyledAttributes, index, this.f7165m);
                            break;
                        case 35:
                            this.f7164l = c.n(typedArrayObtainStyledAttributes, index, this.f7164l);
                            break;
                        case 36:
                            this.f7174v = typedArrayObtainStyledAttributes.getFloat(index, this.f7174v);
                            break;
                        case 37:
                            this.f7133Q = typedArrayObtainStyledAttributes.getFloat(index, this.f7133Q);
                            break;
                        case 38:
                            this.f7132P = typedArrayObtainStyledAttributes.getFloat(index, this.f7132P);
                            break;
                        case 39:
                            this.f7134R = typedArrayObtainStyledAttributes.getInt(index, this.f7134R);
                            break;
                        case 40:
                            this.f7135S = typedArrayObtainStyledAttributes.getInt(index, this.f7135S);
                            break;
                        default:
                            switch (i8) {
                                case 54:
                                    this.f7136T = typedArrayObtainStyledAttributes.getInt(index, this.f7136T);
                                    break;
                                case 55:
                                    this.f7137U = typedArrayObtainStyledAttributes.getInt(index, this.f7137U);
                                    break;
                                case 56:
                                    this.f7138V = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7138V);
                                    break;
                                case 57:
                                    this.f7139W = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7139W);
                                    break;
                                case 58:
                                    this.f7140X = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7140X);
                                    break;
                                case 59:
                                    this.f7141Y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7141Y);
                                    break;
                                default:
                                    switch (i8) {
                                        case 61:
                                            this.f7176x = c.n(typedArrayObtainStyledAttributes, index, this.f7176x);
                                            break;
                                        case 62:
                                            this.f7177y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7177y);
                                            break;
                                        case 63:
                                            this.f7178z = typedArrayObtainStyledAttributes.getFloat(index, this.f7178z);
                                            break;
                                        default:
                                            switch (i8) {
                                                case 69:
                                                    this.f7142Z = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 70:
                                                    this.f7144a0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 71:
                                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                    break;
                                                case 72:
                                                    this.f7146b0 = typedArrayObtainStyledAttributes.getInt(index, this.f7146b0);
                                                    break;
                                                case 73:
                                                    this.f7148c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7148c0);
                                                    break;
                                                case 74:
                                                    this.f7154f0 = typedArrayObtainStyledAttributes.getString(index);
                                                    break;
                                                case 75:
                                                    this.f7162j0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f7162j0);
                                                    break;
                                                case 76:
                                                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f7116k0.get(index));
                                                    break;
                                                case 77:
                                                    this.f7156g0 = typedArrayObtainStyledAttributes.getString(index);
                                                    break;
                                                default:
                                                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f7116k0.get(index));
                                                    break;
                                            }
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                } else {
                    this.f7160i0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f7160i0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.c$c, reason: collision with other inner class name */
    public static class C0121c {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static SparseIntArray f7179h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7180a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7181b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f7182c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7183d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7184e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f7185f = Float.NaN;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f7186g = Float.NaN;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f7179h = sparseIntArray;
            sparseIntArray.append(B.d.f538W3, 1);
            f7179h.append(B.d.f548Y3, 2);
            f7179h.append(B.d.f553Z3, 3);
            f7179h.append(B.d.f533V3, 4);
            f7179h.append(B.d.f527U3, 5);
            f7179h.append(B.d.f543X3, 6);
        }

        public void a(C0121c c0121c) {
            this.f7180a = c0121c.f7180a;
            this.f7181b = c0121c.f7181b;
            this.f7182c = c0121c.f7182c;
            this.f7183d = c0121c.f7183d;
            this.f7184e = c0121c.f7184e;
            this.f7186g = c0121c.f7186g;
            this.f7185f = c0121c.f7185f;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, B.d.f521T3);
            this.f7180a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                switch (f7179h.get(index)) {
                    case 1:
                        this.f7186g = typedArrayObtainStyledAttributes.getFloat(index, this.f7186g);
                        break;
                    case 2:
                        this.f7183d = typedArrayObtainStyledAttributes.getInt(index, this.f7183d);
                        break;
                    case 3:
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            this.f7182c = typedArrayObtainStyledAttributes.getString(index);
                        } else {
                            this.f7182c = C2769a.f24937c[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                        }
                        break;
                    case 4:
                        this.f7184e = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f7181b = c.n(typedArrayObtainStyledAttributes, index, this.f7181b);
                        break;
                    case 6:
                        this.f7185f = typedArrayObtainStyledAttributes.getFloat(index, this.f7185f);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7187a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7188b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7189c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f7190d = 1.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f7191e = Float.NaN;

        public void a(d dVar) {
            this.f7187a = dVar.f7187a;
            this.f7188b = dVar.f7188b;
            this.f7190d = dVar.f7190d;
            this.f7191e = dVar.f7191e;
            this.f7189c = dVar.f7189c;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, B.d.f607i4);
            this.f7187a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == B.d.f619k4) {
                    this.f7190d = typedArrayObtainStyledAttributes.getFloat(index, this.f7190d);
                } else if (index == B.d.f613j4) {
                    this.f7188b = typedArrayObtainStyledAttributes.getInt(index, this.f7188b);
                    this.f7188b = c.f7105d[this.f7188b];
                } else if (index == B.d.f631m4) {
                    this.f7189c = typedArrayObtainStyledAttributes.getInt(index, this.f7189c);
                } else if (index == B.d.f625l4) {
                    this.f7191e = typedArrayObtainStyledAttributes.getFloat(index, this.f7191e);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class e {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static SparseIntArray f7192n;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7193a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f7194b = 0.0f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f7195c = 0.0f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f7196d = 0.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f7197e = 1.0f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f7198f = 1.0f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f7199g = Float.NaN;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f7200h = Float.NaN;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f7201i = 0.0f;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f7202j = 0.0f;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f7203k = 0.0f;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f7204l = false;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f7205m = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f7192n = sparseIntArray;
            sparseIntArray.append(B.d.f444G4, 1);
            f7192n.append(B.d.f450H4, 2);
            f7192n.append(B.d.f456I4, 3);
            f7192n.append(B.d.f432E4, 4);
            f7192n.append(B.d.f438F4, 5);
            f7192n.append(B.d.f408A4, 6);
            f7192n.append(B.d.f414B4, 7);
            f7192n.append(B.d.f420C4, 8);
            f7192n.append(B.d.f426D4, 9);
            f7192n.append(B.d.f462J4, 10);
            f7192n.append(B.d.f468K4, 11);
        }

        public void a(e eVar) {
            this.f7193a = eVar.f7193a;
            this.f7194b = eVar.f7194b;
            this.f7195c = eVar.f7195c;
            this.f7196d = eVar.f7196d;
            this.f7197e = eVar.f7197e;
            this.f7198f = eVar.f7198f;
            this.f7199g = eVar.f7199g;
            this.f7200h = eVar.f7200h;
            this.f7201i = eVar.f7201i;
            this.f7202j = eVar.f7202j;
            this.f7203k = eVar.f7203k;
            this.f7204l = eVar.f7204l;
            this.f7205m = eVar.f7205m;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, B.d.f709z4);
            this.f7193a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                switch (f7192n.get(index)) {
                    case 1:
                        this.f7194b = typedArrayObtainStyledAttributes.getFloat(index, this.f7194b);
                        break;
                    case 2:
                        this.f7195c = typedArrayObtainStyledAttributes.getFloat(index, this.f7195c);
                        break;
                    case 3:
                        this.f7196d = typedArrayObtainStyledAttributes.getFloat(index, this.f7196d);
                        break;
                    case 4:
                        this.f7197e = typedArrayObtainStyledAttributes.getFloat(index, this.f7197e);
                        break;
                    case 5:
                        this.f7198f = typedArrayObtainStyledAttributes.getFloat(index, this.f7198f);
                        break;
                    case 6:
                        this.f7199g = typedArrayObtainStyledAttributes.getDimension(index, this.f7199g);
                        break;
                    case 7:
                        this.f7200h = typedArrayObtainStyledAttributes.getDimension(index, this.f7200h);
                        break;
                    case 8:
                        this.f7201i = typedArrayObtainStyledAttributes.getDimension(index, this.f7201i);
                        break;
                    case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                        this.f7202j = typedArrayObtainStyledAttributes.getDimension(index, this.f7202j);
                        break;
                    case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                        this.f7203k = typedArrayObtainStyledAttributes.getDimension(index, this.f7203k);
                        break;
                    case 11:
                        this.f7204l = true;
                        this.f7205m = typedArrayObtainStyledAttributes.getDimension(index, this.f7205m);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f7106e = sparseIntArray;
        sparseIntArray.append(B.d.f675u0, 25);
        f7106e.append(B.d.f681v0, 26);
        f7106e.append(B.d.f693x0, 29);
        f7106e.append(B.d.f699y0, 30);
        f7106e.append(B.d.f428E0, 36);
        f7106e.append(B.d.f422D0, 35);
        f7106e.append(B.d.f567c0, 4);
        f7106e.append(B.d.f561b0, 3);
        f7106e.append(B.d.f549Z, 1);
        f7106e.append(B.d.f476M0, 6);
        f7106e.append(B.d.f482N0, 7);
        f7106e.append(B.d.f609j0, 17);
        f7106e.append(B.d.f615k0, 18);
        f7106e.append(B.d.f621l0, 19);
        f7106e.append(B.d.f662s, 27);
        f7106e.append(B.d.f705z0, 32);
        f7106e.append(B.d.f404A0, 33);
        f7106e.append(B.d.f603i0, 10);
        f7106e.append(B.d.f597h0, 9);
        f7106e.append(B.d.f500Q0, 13);
        f7106e.append(B.d.f518T0, 16);
        f7106e.append(B.d.f506R0, 14);
        f7106e.append(B.d.f488O0, 11);
        f7106e.append(B.d.f512S0, 15);
        f7106e.append(B.d.f494P0, 12);
        f7106e.append(B.d.f446H0, 40);
        f7106e.append(B.d.f663s0, 39);
        f7106e.append(B.d.f657r0, 41);
        f7106e.append(B.d.f440G0, 42);
        f7106e.append(B.d.f651q0, 20);
        f7106e.append(B.d.f434F0, 37);
        f7106e.append(B.d.f591g0, 5);
        f7106e.append(B.d.f669t0, 82);
        f7106e.append(B.d.f416C0, 82);
        f7106e.append(B.d.f687w0, 82);
        f7106e.append(B.d.f555a0, 82);
        f7106e.append(B.d.f544Y, 82);
        f7106e.append(B.d.f692x, 24);
        f7106e.append(B.d.f704z, 28);
        f7106e.append(B.d.f469L, 31);
        f7106e.append(B.d.f475M, 8);
        f7106e.append(B.d.f698y, 34);
        f7106e.append(B.d.f403A, 2);
        f7106e.append(B.d.f680v, 23);
        f7106e.append(B.d.f686w, 21);
        f7106e.append(B.d.f674u, 22);
        f7106e.append(B.d.f409B, 43);
        f7106e.append(B.d.f487O, 44);
        f7106e.append(B.d.f457J, 45);
        f7106e.append(B.d.f463K, 46);
        f7106e.append(B.d.f451I, 60);
        f7106e.append(B.d.f439G, 47);
        f7106e.append(B.d.f445H, 48);
        f7106e.append(B.d.f415C, 49);
        f7106e.append(B.d.f421D, 50);
        f7106e.append(B.d.f427E, 51);
        f7106e.append(B.d.f433F, 52);
        f7106e.append(B.d.f481N, 53);
        f7106e.append(B.d.f452I0, 54);
        f7106e.append(B.d.f627m0, 55);
        f7106e.append(B.d.f458J0, 56);
        f7106e.append(B.d.f633n0, 57);
        f7106e.append(B.d.f464K0, 58);
        f7106e.append(B.d.f639o0, 59);
        f7106e.append(B.d.f573d0, 61);
        f7106e.append(B.d.f585f0, 62);
        f7106e.append(B.d.f579e0, 63);
        f7106e.append(B.d.f493P, 64);
        f7106e.append(B.d.f540X0, 65);
        f7106e.append(B.d.f529V, 66);
        f7106e.append(B.d.f545Y0, 67);
        f7106e.append(B.d.f530V0, 79);
        f7106e.append(B.d.f668t, 38);
        f7106e.append(B.d.f524U0, 68);
        f7106e.append(B.d.f470L0, 69);
        f7106e.append(B.d.f645p0, 70);
        f7106e.append(B.d.f517T, 71);
        f7106e.append(B.d.f505R, 72);
        f7106e.append(B.d.f511S, 73);
        f7106e.append(B.d.f523U, 74);
        f7106e.append(B.d.f499Q, 75);
        f7106e.append(B.d.f535W0, 76);
        f7106e.append(B.d.f410B0, 77);
        f7106e.append(B.d.f550Z0, 78);
        f7106e.append(B.d.f539X, 80);
        f7106e.append(B.d.f534W, 81);
    }

    public static int n(TypedArray typedArray, int i7, int i8) {
        int resourceId = typedArray.getResourceId(i7, i8);
        return resourceId == -1 ? typedArray.getInt(i7, -1) : resourceId;
    }

    public void c(ConstraintLayout constraintLayout) {
        d(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void d(ConstraintLayout constraintLayout, boolean z7) {
        int childCount = constraintLayout.getChildCount();
        HashSet<Integer> hashSet = new HashSet(this.f7109c.keySet());
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = constraintLayout.getChildAt(i7);
            int id = childAt.getId();
            if (!this.f7109c.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + AbstractC2813a.a(childAt));
            } else {
                if (this.f7108b && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (this.f7109c.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        a aVar = (a) this.f7109c.get(Integer.valueOf(id));
                        if (childAt instanceof Barrier) {
                            aVar.f7113d.f7150d0 = 1;
                        }
                        int i8 = aVar.f7113d.f7150d0;
                        if (i8 != -1 && i8 == 1) {
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id);
                            barrier.setType(aVar.f7113d.f7146b0);
                            barrier.setMargin(aVar.f7113d.f7148c0);
                            barrier.setAllowsGoneWidget(aVar.f7113d.f7162j0);
                            b bVar = aVar.f7113d;
                            int[] iArr = bVar.f7152e0;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str = bVar.f7154f0;
                                if (str != null) {
                                    bVar.f7152e0 = i(barrier, str);
                                    barrier.setReferencedIds(aVar.f7113d.f7152e0);
                                }
                            }
                        }
                        ConstraintLayout.b bVar2 = (ConstraintLayout.b) childAt.getLayoutParams();
                        bVar2.a();
                        aVar.b(bVar2);
                        if (z7) {
                            androidx.constraintlayout.widget.a.c(childAt, aVar.f7115f);
                        }
                        childAt.setLayoutParams(bVar2);
                        d dVar = aVar.f7111b;
                        if (dVar.f7189c == 0) {
                            childAt.setVisibility(dVar.f7188b);
                        }
                        childAt.setAlpha(aVar.f7111b.f7190d);
                        childAt.setRotation(aVar.f7114e.f7194b);
                        childAt.setRotationX(aVar.f7114e.f7195c);
                        childAt.setRotationY(aVar.f7114e.f7196d);
                        childAt.setScaleX(aVar.f7114e.f7197e);
                        childAt.setScaleY(aVar.f7114e.f7198f);
                        if (!Float.isNaN(aVar.f7114e.f7199g)) {
                            childAt.setPivotX(aVar.f7114e.f7199g);
                        }
                        if (!Float.isNaN(aVar.f7114e.f7200h)) {
                            childAt.setPivotY(aVar.f7114e.f7200h);
                        }
                        childAt.setTranslationX(aVar.f7114e.f7201i);
                        childAt.setTranslationY(aVar.f7114e.f7202j);
                        childAt.setTranslationZ(aVar.f7114e.f7203k);
                        e eVar = aVar.f7114e;
                        if (eVar.f7204l) {
                            childAt.setElevation(eVar.f7205m);
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            }
        }
        for (Integer num : hashSet) {
            a aVar2 = (a) this.f7109c.get(num);
            int i9 = aVar2.f7113d.f7150d0;
            if (i9 != -1 && i9 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                b bVar3 = aVar2.f7113d;
                int[] iArr2 = bVar3.f7152e0;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str2 = bVar3.f7154f0;
                    if (str2 != null) {
                        bVar3.f7152e0 = i(barrier2, str2);
                        barrier2.setReferencedIds(aVar2.f7113d.f7152e0);
                    }
                }
                barrier2.setType(aVar2.f7113d.f7146b0);
                barrier2.setMargin(aVar2.f7113d.f7148c0);
                ConstraintLayout.b bVarD = constraintLayout.generateDefaultLayoutParams();
                barrier2.k();
                aVar2.b(bVarD);
                constraintLayout.addView(barrier2, bVarD);
            }
            if (aVar2.f7113d.f7143a) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.b bVarD2 = constraintLayout.generateDefaultLayoutParams();
                aVar2.b(bVarD2);
                constraintLayout.addView(guideline, bVarD2);
            }
        }
    }

    public void e(int i7, int i8) {
        if (this.f7109c.containsKey(Integer.valueOf(i7))) {
            a aVar = (a) this.f7109c.get(Integer.valueOf(i7));
            switch (i8) {
                case 1:
                    b bVar = aVar.f7113d;
                    bVar.f7159i = -1;
                    bVar.f7157h = -1;
                    bVar.f7120D = -1;
                    bVar.f7126J = -1;
                    return;
                case 2:
                    b bVar2 = aVar.f7113d;
                    bVar2.f7163k = -1;
                    bVar2.f7161j = -1;
                    bVar2.f7121E = -1;
                    bVar2.f7128L = -1;
                    return;
                case 3:
                    b bVar3 = aVar.f7113d;
                    bVar3.f7165m = -1;
                    bVar3.f7164l = -1;
                    bVar3.f7122F = -1;
                    bVar3.f7127K = -1;
                    return;
                case 4:
                    b bVar4 = aVar.f7113d;
                    bVar4.f7166n = -1;
                    bVar4.f7167o = -1;
                    bVar4.f7123G = -1;
                    bVar4.f7129M = -1;
                    return;
                case 5:
                    aVar.f7113d.f7168p = -1;
                    return;
                case 6:
                    b bVar5 = aVar.f7113d;
                    bVar5.f7169q = -1;
                    bVar5.f7170r = -1;
                    bVar5.f7125I = -1;
                    bVar5.f7131O = -1;
                    return;
                case 7:
                    b bVar6 = aVar.f7113d;
                    bVar6.f7171s = -1;
                    bVar6.f7172t = -1;
                    bVar6.f7124H = -1;
                    bVar6.f7130N = -1;
                    return;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
        }
    }

    public void f(Context context, int i7) {
        g((ConstraintLayout) LayoutInflater.from(context).inflate(i7, (ViewGroup) null));
    }

    public void g(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f7109c.clear();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = constraintLayout.getChildAt(i7);
            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f7108b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f7109c.containsKey(Integer.valueOf(id))) {
                this.f7109c.put(Integer.valueOf(id), new a());
            }
            a aVar = (a) this.f7109c.get(Integer.valueOf(id));
            aVar.f7115f = androidx.constraintlayout.widget.a.a(this.f7107a, childAt);
            aVar.d(id, bVar);
            aVar.f7111b.f7188b = childAt.getVisibility();
            aVar.f7111b.f7190d = childAt.getAlpha();
            aVar.f7114e.f7194b = childAt.getRotation();
            aVar.f7114e.f7195c = childAt.getRotationX();
            aVar.f7114e.f7196d = childAt.getRotationY();
            aVar.f7114e.f7197e = childAt.getScaleX();
            aVar.f7114e.f7198f = childAt.getScaleY();
            float pivotX = childAt.getPivotX();
            float pivotY = childAt.getPivotY();
            if (pivotX != 0.0d || pivotY != 0.0d) {
                e eVar = aVar.f7114e;
                eVar.f7199g = pivotX;
                eVar.f7200h = pivotY;
            }
            aVar.f7114e.f7201i = childAt.getTranslationX();
            aVar.f7114e.f7202j = childAt.getTranslationY();
            aVar.f7114e.f7203k = childAt.getTranslationZ();
            e eVar2 = aVar.f7114e;
            if (eVar2.f7204l) {
                eVar2.f7205m = childAt.getElevation();
            }
            if (childAt instanceof Barrier) {
                Barrier barrier = (Barrier) childAt;
                aVar.f7113d.f7162j0 = barrier.l();
                aVar.f7113d.f7152e0 = barrier.getReferencedIds();
                aVar.f7113d.f7146b0 = barrier.getType();
                aVar.f7113d.f7148c0 = barrier.getMargin();
            }
        }
    }

    public void h(int i7, int i8, int i9, float f7) {
        b bVar = k(i7).f7113d;
        bVar.f7176x = i8;
        bVar.f7177y = i9;
        bVar.f7178z = f7;
    }

    public final int[] i(View view, String str) {
        int iIntValue;
        Object objF;
        String[] strArrSplit = str.split(f.f9989a);
        Context context = view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i7 = 0;
        int i8 = 0;
        while (i7 < strArrSplit.length) {
            String strTrim = strArrSplit[i7].trim();
            try {
                iIntValue = B.c.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, DiagnosticsEntry.ID_KEY, context.getPackageName());
            }
            if (iIntValue == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (objF = ((ConstraintLayout) view.getParent()).f(0, strTrim)) != null && (objF instanceof Integer)) {
                iIntValue = ((Integer) objF).intValue();
            }
            iArr[i8] = iIntValue;
            i7++;
            i8++;
        }
        return i8 != strArrSplit.length ? Arrays.copyOf(iArr, i8) : iArr;
    }

    public final a j(Context context, AttributeSet attributeSet) {
        a aVar = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, B.d.f656r);
        o(context, aVar, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    public final a k(int i7) {
        if (!this.f7109c.containsKey(Integer.valueOf(i7))) {
            this.f7109c.put(Integer.valueOf(i7), new a());
        }
        return (a) this.f7109c.get(Integer.valueOf(i7));
    }

    public void l(Context context, int i7) {
        XmlResourceParser xml = context.getResources().getXml(i7);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a aVarJ = j(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        aVarJ.f7113d.f7143a = true;
                    }
                    this.f7109c.put(Integer.valueOf(aVarJ.f7110a), aVarJ);
                }
            }
        } catch (IOException e7) {
            e7.printStackTrace();
        } catch (XmlPullParserException e8) {
            e8.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x017d, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m(android.content.Context r9, org.xmlpull.v1.XmlPullParser r10) {
        /*
            Method dump skipped, instruction units count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.c.m(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public final void o(Context context, a aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i7 = 0; i7 < indexCount; i7++) {
            int index = typedArray.getIndex(i7);
            if (index != B.d.f668t && B.d.f469L != index && B.d.f475M != index) {
                aVar.f7112c.f7180a = true;
                aVar.f7113d.f7145b = true;
                aVar.f7111b.f7187a = true;
                aVar.f7114e.f7193a = true;
            }
            switch (f7106e.get(index)) {
                case 1:
                    b bVar = aVar.f7113d;
                    bVar.f7168p = n(typedArray, index, bVar.f7168p);
                    break;
                case 2:
                    b bVar2 = aVar.f7113d;
                    bVar2.f7123G = typedArray.getDimensionPixelSize(index, bVar2.f7123G);
                    break;
                case 3:
                    b bVar3 = aVar.f7113d;
                    bVar3.f7167o = n(typedArray, index, bVar3.f7167o);
                    break;
                case 4:
                    b bVar4 = aVar.f7113d;
                    bVar4.f7166n = n(typedArray, index, bVar4.f7166n);
                    break;
                case 5:
                    aVar.f7113d.f7175w = typedArray.getString(index);
                    break;
                case 6:
                    b bVar5 = aVar.f7113d;
                    bVar5.f7117A = typedArray.getDimensionPixelOffset(index, bVar5.f7117A);
                    break;
                case 7:
                    b bVar6 = aVar.f7113d;
                    bVar6.f7118B = typedArray.getDimensionPixelOffset(index, bVar6.f7118B);
                    break;
                case 8:
                    b bVar7 = aVar.f7113d;
                    bVar7.f7124H = typedArray.getDimensionPixelSize(index, bVar7.f7124H);
                    break;
                case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    b bVar8 = aVar.f7113d;
                    bVar8.f7172t = n(typedArray, index, bVar8.f7172t);
                    break;
                case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    b bVar9 = aVar.f7113d;
                    bVar9.f7171s = n(typedArray, index, bVar9.f7171s);
                    break;
                case 11:
                    b bVar10 = aVar.f7113d;
                    bVar10.f7129M = typedArray.getDimensionPixelSize(index, bVar10.f7129M);
                    break;
                case 12:
                    b bVar11 = aVar.f7113d;
                    bVar11.f7130N = typedArray.getDimensionPixelSize(index, bVar11.f7130N);
                    break;
                case 13:
                    b bVar12 = aVar.f7113d;
                    bVar12.f7126J = typedArray.getDimensionPixelSize(index, bVar12.f7126J);
                    break;
                case 14:
                    b bVar13 = aVar.f7113d;
                    bVar13.f7128L = typedArray.getDimensionPixelSize(index, bVar13.f7128L);
                    break;
                case 15:
                    b bVar14 = aVar.f7113d;
                    bVar14.f7131O = typedArray.getDimensionPixelSize(index, bVar14.f7131O);
                    break;
                case com.amazon.c.a.a.c.f10119g /* 16 */:
                    b bVar15 = aVar.f7113d;
                    bVar15.f7127K = typedArray.getDimensionPixelSize(index, bVar15.f7127K);
                    break;
                case C2105D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    b bVar16 = aVar.f7113d;
                    bVar16.f7151e = typedArray.getDimensionPixelOffset(index, bVar16.f7151e);
                    break;
                case C2105D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                    b bVar17 = aVar.f7113d;
                    bVar17.f7153f = typedArray.getDimensionPixelOffset(index, bVar17.f7153f);
                    break;
                case 19:
                    b bVar18 = aVar.f7113d;
                    bVar18.f7155g = typedArray.getFloat(index, bVar18.f7155g);
                    break;
                case 20:
                    b bVar19 = aVar.f7113d;
                    bVar19.f7173u = typedArray.getFloat(index, bVar19.f7173u);
                    break;
                case 21:
                    b bVar20 = aVar.f7113d;
                    bVar20.f7149d = typedArray.getLayoutDimension(index, bVar20.f7149d);
                    break;
                case 22:
                    d dVar = aVar.f7111b;
                    dVar.f7188b = typedArray.getInt(index, dVar.f7188b);
                    d dVar2 = aVar.f7111b;
                    dVar2.f7188b = f7105d[dVar2.f7188b];
                    break;
                case 23:
                    b bVar21 = aVar.f7113d;
                    bVar21.f7147c = typedArray.getLayoutDimension(index, bVar21.f7147c);
                    break;
                case 24:
                    b bVar22 = aVar.f7113d;
                    bVar22.f7120D = typedArray.getDimensionPixelSize(index, bVar22.f7120D);
                    break;
                case 25:
                    b bVar23 = aVar.f7113d;
                    bVar23.f7157h = n(typedArray, index, bVar23.f7157h);
                    break;
                case 26:
                    b bVar24 = aVar.f7113d;
                    bVar24.f7159i = n(typedArray, index, bVar24.f7159i);
                    break;
                case 27:
                    b bVar25 = aVar.f7113d;
                    bVar25.f7119C = typedArray.getInt(index, bVar25.f7119C);
                    break;
                case 28:
                    b bVar26 = aVar.f7113d;
                    bVar26.f7121E = typedArray.getDimensionPixelSize(index, bVar26.f7121E);
                    break;
                case 29:
                    b bVar27 = aVar.f7113d;
                    bVar27.f7161j = n(typedArray, index, bVar27.f7161j);
                    break;
                case 30:
                    b bVar28 = aVar.f7113d;
                    bVar28.f7163k = n(typedArray, index, bVar28.f7163k);
                    break;
                case 31:
                    b bVar29 = aVar.f7113d;
                    bVar29.f7125I = typedArray.getDimensionPixelSize(index, bVar29.f7125I);
                    break;
                case com.amazon.c.a.a.c.f10120h /* 32 */:
                    b bVar30 = aVar.f7113d;
                    bVar30.f7169q = n(typedArray, index, bVar30.f7169q);
                    break;
                case 33:
                    b bVar31 = aVar.f7113d;
                    bVar31.f7170r = n(typedArray, index, bVar31.f7170r);
                    break;
                case 34:
                    b bVar32 = aVar.f7113d;
                    bVar32.f7122F = typedArray.getDimensionPixelSize(index, bVar32.f7122F);
                    break;
                case 35:
                    b bVar33 = aVar.f7113d;
                    bVar33.f7165m = n(typedArray, index, bVar33.f7165m);
                    break;
                case 36:
                    b bVar34 = aVar.f7113d;
                    bVar34.f7164l = n(typedArray, index, bVar34.f7164l);
                    break;
                case 37:
                    b bVar35 = aVar.f7113d;
                    bVar35.f7174v = typedArray.getFloat(index, bVar35.f7174v);
                    break;
                case 38:
                    aVar.f7110a = typedArray.getResourceId(index, aVar.f7110a);
                    break;
                case 39:
                    b bVar36 = aVar.f7113d;
                    bVar36.f7133Q = typedArray.getFloat(index, bVar36.f7133Q);
                    break;
                case 40:
                    b bVar37 = aVar.f7113d;
                    bVar37.f7132P = typedArray.getFloat(index, bVar37.f7132P);
                    break;
                case 41:
                    b bVar38 = aVar.f7113d;
                    bVar38.f7134R = typedArray.getInt(index, bVar38.f7134R);
                    break;
                case 42:
                    b bVar39 = aVar.f7113d;
                    bVar39.f7135S = typedArray.getInt(index, bVar39.f7135S);
                    break;
                case 43:
                    d dVar3 = aVar.f7111b;
                    dVar3.f7190d = typedArray.getFloat(index, dVar3.f7190d);
                    break;
                case 44:
                    e eVar = aVar.f7114e;
                    eVar.f7204l = true;
                    eVar.f7205m = typedArray.getDimension(index, eVar.f7205m);
                    break;
                case 45:
                    e eVar2 = aVar.f7114e;
                    eVar2.f7195c = typedArray.getFloat(index, eVar2.f7195c);
                    break;
                case 46:
                    e eVar3 = aVar.f7114e;
                    eVar3.f7196d = typedArray.getFloat(index, eVar3.f7196d);
                    break;
                case 47:
                    e eVar4 = aVar.f7114e;
                    eVar4.f7197e = typedArray.getFloat(index, eVar4.f7197e);
                    break;
                case 48:
                    e eVar5 = aVar.f7114e;
                    eVar5.f7198f = typedArray.getFloat(index, eVar5.f7198f);
                    break;
                case 49:
                    e eVar6 = aVar.f7114e;
                    eVar6.f7199g = typedArray.getDimension(index, eVar6.f7199g);
                    break;
                case 50:
                    e eVar7 = aVar.f7114e;
                    eVar7.f7200h = typedArray.getDimension(index, eVar7.f7200h);
                    break;
                case 51:
                    e eVar8 = aVar.f7114e;
                    eVar8.f7201i = typedArray.getDimension(index, eVar8.f7201i);
                    break;
                case 52:
                    e eVar9 = aVar.f7114e;
                    eVar9.f7202j = typedArray.getDimension(index, eVar9.f7202j);
                    break;
                case 53:
                    e eVar10 = aVar.f7114e;
                    eVar10.f7203k = typedArray.getDimension(index, eVar10.f7203k);
                    break;
                case 54:
                    b bVar40 = aVar.f7113d;
                    bVar40.f7136T = typedArray.getInt(index, bVar40.f7136T);
                    break;
                case 55:
                    b bVar41 = aVar.f7113d;
                    bVar41.f7137U = typedArray.getInt(index, bVar41.f7137U);
                    break;
                case 56:
                    b bVar42 = aVar.f7113d;
                    bVar42.f7138V = typedArray.getDimensionPixelSize(index, bVar42.f7138V);
                    break;
                case 57:
                    b bVar43 = aVar.f7113d;
                    bVar43.f7139W = typedArray.getDimensionPixelSize(index, bVar43.f7139W);
                    break;
                case 58:
                    b bVar44 = aVar.f7113d;
                    bVar44.f7140X = typedArray.getDimensionPixelSize(index, bVar44.f7140X);
                    break;
                case 59:
                    b bVar45 = aVar.f7113d;
                    bVar45.f7141Y = typedArray.getDimensionPixelSize(index, bVar45.f7141Y);
                    break;
                case 60:
                    e eVar11 = aVar.f7114e;
                    eVar11.f7194b = typedArray.getFloat(index, eVar11.f7194b);
                    break;
                case 61:
                    b bVar46 = aVar.f7113d;
                    bVar46.f7176x = n(typedArray, index, bVar46.f7176x);
                    break;
                case 62:
                    b bVar47 = aVar.f7113d;
                    bVar47.f7177y = typedArray.getDimensionPixelSize(index, bVar47.f7177y);
                    break;
                case 63:
                    b bVar48 = aVar.f7113d;
                    bVar48.f7178z = typedArray.getFloat(index, bVar48.f7178z);
                    break;
                case 64:
                    C0121c c0121c = aVar.f7112c;
                    c0121c.f7181b = n(typedArray, index, c0121c.f7181b);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        aVar.f7112c.f7182c = typedArray.getString(index);
                    } else {
                        aVar.f7112c.f7182c = C2769a.f24937c[typedArray.getInteger(index, 0)];
                    }
                    break;
                case 66:
                    aVar.f7112c.f7184e = typedArray.getInt(index, 0);
                    break;
                case 67:
                    C0121c c0121c2 = aVar.f7112c;
                    c0121c2.f7186g = typedArray.getFloat(index, c0121c2.f7186g);
                    break;
                case 68:
                    d dVar4 = aVar.f7111b;
                    dVar4.f7191e = typedArray.getFloat(index, dVar4.f7191e);
                    break;
                case 69:
                    aVar.f7113d.f7142Z = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    aVar.f7113d.f7144a0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    b bVar49 = aVar.f7113d;
                    bVar49.f7146b0 = typedArray.getInt(index, bVar49.f7146b0);
                    break;
                case 73:
                    b bVar50 = aVar.f7113d;
                    bVar50.f7148c0 = typedArray.getDimensionPixelSize(index, bVar50.f7148c0);
                    break;
                case 74:
                    aVar.f7113d.f7154f0 = typedArray.getString(index);
                    break;
                case 75:
                    b bVar51 = aVar.f7113d;
                    bVar51.f7162j0 = typedArray.getBoolean(index, bVar51.f7162j0);
                    break;
                case 76:
                    C0121c c0121c3 = aVar.f7112c;
                    c0121c3.f7183d = typedArray.getInt(index, c0121c3.f7183d);
                    break;
                case 77:
                    aVar.f7113d.f7156g0 = typedArray.getString(index);
                    break;
                case 78:
                    d dVar5 = aVar.f7111b;
                    dVar5.f7189c = typedArray.getInt(index, dVar5.f7189c);
                    break;
                case 79:
                    C0121c c0121c4 = aVar.f7112c;
                    c0121c4.f7185f = typedArray.getFloat(index, c0121c4.f7185f);
                    break;
                case 80:
                    b bVar52 = aVar.f7113d;
                    bVar52.f7158h0 = typedArray.getBoolean(index, bVar52.f7158h0);
                    break;
                case 81:
                    b bVar53 = aVar.f7113d;
                    bVar53.f7160i0 = typedArray.getBoolean(index, bVar53.f7160i0);
                    break;
                case 82:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f7106e.get(index));
                    break;
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f7106e.get(index));
                    break;
            }
        }
    }
}
