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
import bb.d0;
import com.amazon.a.a.o.b.f;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.events.EventsManager;
import com.revenuecat.purchases.utils.PurchaseParamsValidator;
import io.flutter.Build;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f1450f = {0, 4, 8};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static SparseIntArray f1451g = new SparseIntArray();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static SparseIntArray f1452h = new SparseIntArray();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1453a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1454b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap f1455c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1456d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashMap f1457e = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f1459b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final C0019d f1460c = new C0019d();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c f1461d = new c();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final b f1462e = new b();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final e f1463f = new e();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public HashMap f1464g = new HashMap();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public C0018a f1465h;

        /* JADX INFO: renamed from: androidx.constraintlayout.widget.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class C0018a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int[] f1466a = new int[10];

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int[] f1467b = new int[10];

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f1468c = 0;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int[] f1469d = new int[10];

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public float[] f1470e = new float[10];

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public int f1471f = 0;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int[] f1472g = new int[5];

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public String[] f1473h = new String[5];

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public int f1474i = 0;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int[] f1475j = new int[4];

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public boolean[] f1476k = new boolean[4];

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public int f1477l = 0;

            public void a(int i10, float f10) {
                int i11 = this.f1471f;
                int[] iArr = this.f1469d;
                if (i11 >= iArr.length) {
                    this.f1469d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.f1470e;
                    this.f1470e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.f1469d;
                int i12 = this.f1471f;
                iArr2[i12] = i10;
                float[] fArr2 = this.f1470e;
                this.f1471f = i12 + 1;
                fArr2[i12] = f10;
            }

            public void b(int i10, int i11) {
                int i12 = this.f1468c;
                int[] iArr = this.f1466a;
                if (i12 >= iArr.length) {
                    this.f1466a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.f1467b;
                    this.f1467b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f1466a;
                int i13 = this.f1468c;
                iArr3[i13] = i10;
                int[] iArr4 = this.f1467b;
                this.f1468c = i13 + 1;
                iArr4[i13] = i11;
            }

            public void c(int i10, String str) {
                int i11 = this.f1474i;
                int[] iArr = this.f1472g;
                if (i11 >= iArr.length) {
                    this.f1472g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.f1473h;
                    this.f1473h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.f1472g;
                int i12 = this.f1474i;
                iArr2[i12] = i10;
                String[] strArr2 = this.f1473h;
                this.f1474i = i12 + 1;
                strArr2[i12] = str;
            }

            public void d(int i10, boolean z10) {
                int i11 = this.f1477l;
                int[] iArr = this.f1475j;
                if (i11 >= iArr.length) {
                    this.f1475j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.f1476k;
                    this.f1476k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.f1475j;
                int i12 = this.f1477l;
                iArr2[i12] = i10;
                boolean[] zArr2 = this.f1476k;
                this.f1477l = i12 + 1;
                zArr2[i12] = z10;
            }
        }

        public void b(ConstraintLayout.b bVar) {
            b bVar2 = this.f1462e;
            bVar.f1370e = bVar2.f1497j;
            bVar.f1372f = bVar2.f1499k;
            bVar.f1374g = bVar2.f1501l;
            bVar.f1376h = bVar2.f1503m;
            bVar.f1378i = bVar2.f1505n;
            bVar.f1380j = bVar2.f1507o;
            bVar.f1382k = bVar2.f1509p;
            bVar.f1384l = bVar2.f1511q;
            bVar.f1386m = bVar2.f1513r;
            bVar.f1388n = bVar2.f1514s;
            bVar.f1390o = bVar2.f1515t;
            bVar.f1398s = bVar2.f1516u;
            bVar.f1400t = bVar2.f1517v;
            bVar.f1402u = bVar2.f1518w;
            bVar.f1404v = bVar2.f1519x;
            ((ViewGroup.MarginLayoutParams) bVar).leftMargin = bVar2.H;
            ((ViewGroup.MarginLayoutParams) bVar).rightMargin = bVar2.I;
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = bVar2.J;
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = bVar2.K;
            bVar.A = bVar2.T;
            bVar.B = bVar2.S;
            bVar.f1408x = bVar2.P;
            bVar.f1410z = bVar2.R;
            bVar.G = bVar2.f1520y;
            bVar.H = bVar2.f1521z;
            bVar.f1392p = bVar2.B;
            bVar.f1394q = bVar2.C;
            bVar.f1396r = bVar2.D;
            bVar.I = bVar2.A;
            bVar.X = bVar2.E;
            bVar.Y = bVar2.F;
            bVar.M = bVar2.V;
            bVar.L = bVar2.W;
            bVar.O = bVar2.Y;
            bVar.N = bVar2.X;
            bVar.f1363a0 = bVar2.f1506n0;
            bVar.f1365b0 = bVar2.f1508o0;
            bVar.P = bVar2.Z;
            bVar.Q = bVar2.f1480a0;
            bVar.T = bVar2.f1482b0;
            bVar.U = bVar2.f1484c0;
            bVar.R = bVar2.f1486d0;
            bVar.S = bVar2.f1488e0;
            bVar.V = bVar2.f1490f0;
            bVar.W = bVar2.f1492g0;
            bVar.Z = bVar2.G;
            bVar.f1366c = bVar2.f1493h;
            bVar.f1362a = bVar2.f1489f;
            bVar.f1364b = bVar2.f1491g;
            ((ViewGroup.MarginLayoutParams) bVar).width = bVar2.f1485d;
            ((ViewGroup.MarginLayoutParams) bVar).height = bVar2.f1487e;
            String str = bVar2.f1504m0;
            if (str != null) {
                bVar.f1367c0 = str;
            }
            bVar.f1369d0 = bVar2.f1512q0;
            bVar.setMarginStart(bVar2.M);
            bVar.setMarginEnd(this.f1462e.L);
            bVar.a();
        }

        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = new a();
            aVar.f1462e.a(this.f1462e);
            aVar.f1461d.a(this.f1461d);
            aVar.f1460c.a(this.f1460c);
            aVar.f1463f.a(this.f1463f);
            aVar.f1458a = this.f1458a;
            aVar.f1465h = this.f1465h;
            return aVar;
        }

        public final void d(int i10, ConstraintLayout.b bVar) {
            this.f1458a = i10;
            b bVar2 = this.f1462e;
            bVar2.f1497j = bVar.f1370e;
            bVar2.f1499k = bVar.f1372f;
            bVar2.f1501l = bVar.f1374g;
            bVar2.f1503m = bVar.f1376h;
            bVar2.f1505n = bVar.f1378i;
            bVar2.f1507o = bVar.f1380j;
            bVar2.f1509p = bVar.f1382k;
            bVar2.f1511q = bVar.f1384l;
            bVar2.f1513r = bVar.f1386m;
            bVar2.f1514s = bVar.f1388n;
            bVar2.f1515t = bVar.f1390o;
            bVar2.f1516u = bVar.f1398s;
            bVar2.f1517v = bVar.f1400t;
            bVar2.f1518w = bVar.f1402u;
            bVar2.f1519x = bVar.f1404v;
            bVar2.f1520y = bVar.G;
            bVar2.f1521z = bVar.H;
            bVar2.A = bVar.I;
            bVar2.B = bVar.f1392p;
            bVar2.C = bVar.f1394q;
            bVar2.D = bVar.f1396r;
            bVar2.E = bVar.X;
            bVar2.F = bVar.Y;
            bVar2.G = bVar.Z;
            bVar2.f1493h = bVar.f1366c;
            bVar2.f1489f = bVar.f1362a;
            bVar2.f1491g = bVar.f1364b;
            bVar2.f1485d = ((ViewGroup.MarginLayoutParams) bVar).width;
            bVar2.f1487e = ((ViewGroup.MarginLayoutParams) bVar).height;
            bVar2.H = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
            bVar2.I = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
            bVar2.J = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            bVar2.K = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
            bVar2.N = bVar.D;
            bVar2.V = bVar.M;
            bVar2.W = bVar.L;
            bVar2.Y = bVar.O;
            bVar2.X = bVar.N;
            bVar2.f1506n0 = bVar.f1363a0;
            bVar2.f1508o0 = bVar.f1365b0;
            bVar2.Z = bVar.P;
            bVar2.f1480a0 = bVar.Q;
            bVar2.f1482b0 = bVar.T;
            bVar2.f1484c0 = bVar.U;
            bVar2.f1486d0 = bVar.R;
            bVar2.f1488e0 = bVar.S;
            bVar2.f1490f0 = bVar.V;
            bVar2.f1492g0 = bVar.W;
            bVar2.f1504m0 = bVar.f1367c0;
            bVar2.P = bVar.f1408x;
            bVar2.R = bVar.f1410z;
            bVar2.O = bVar.f1406w;
            bVar2.Q = bVar.f1409y;
            bVar2.T = bVar.A;
            bVar2.S = bVar.B;
            bVar2.U = bVar.C;
            bVar2.f1512q0 = bVar.f1369d0;
            bVar2.L = bVar.getMarginEnd();
            this.f1462e.M = bVar.getMarginStart();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        public static SparseIntArray f1478r0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1485d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1487e;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public int[] f1500k0;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public String f1502l0;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public String f1504m0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1479a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1481b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f1483c = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1489f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f1491g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f1493h = -1.0f;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f1495i = true;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f1497j = -1;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f1499k = -1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f1501l = -1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f1503m = -1;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f1505n = -1;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f1507o = -1;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f1509p = -1;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f1511q = -1;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f1513r = -1;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f1514s = -1;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f1515t = -1;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f1516u = -1;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f1517v = -1;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f1518w = -1;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f1519x = -1;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public float f1520y = 0.5f;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public float f1521z = 0.5f;
        public String A = null;
        public int B = -1;
        public int C = 0;
        public float D = 0.0f;
        public int E = -1;
        public int F = -1;
        public int G = -1;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public int N = 0;
        public int O = Integer.MIN_VALUE;
        public int P = Integer.MIN_VALUE;
        public int Q = Integer.MIN_VALUE;
        public int R = Integer.MIN_VALUE;
        public int S = Integer.MIN_VALUE;
        public int T = Integer.MIN_VALUE;
        public int U = Integer.MIN_VALUE;
        public float V = -1.0f;
        public float W = -1.0f;
        public int X = 0;
        public int Y = 0;
        public int Z = 0;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public int f1480a0 = 0;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public int f1482b0 = 0;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public int f1484c0 = 0;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public int f1486d0 = 0;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public int f1488e0 = 0;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public float f1490f0 = 1.0f;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public float f1492g0 = 1.0f;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public int f1494h0 = -1;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public int f1496i0 = 0;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public int f1498j0 = -1;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public boolean f1506n0 = false;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public boolean f1508o0 = false;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public boolean f1510p0 = true;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public int f1512q0 = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1478r0 = sparseIntArray;
            sparseIntArray.append(f0.d.f9247w5, 24);
            f1478r0.append(f0.d.f9255x5, 25);
            f1478r0.append(f0.d.f9271z5, 28);
            f1478r0.append(f0.d.A5, 29);
            f1478r0.append(f0.d.F5, 35);
            f1478r0.append(f0.d.E5, 34);
            f1478r0.append(f0.d.f9112g5, 4);
            f1478r0.append(f0.d.f9103f5, 3);
            f1478r0.append(f0.d.f9085d5, 1);
            f1478r0.append(f0.d.L5, 6);
            f1478r0.append(f0.d.M5, 7);
            f1478r0.append(f0.d.f9175n5, 17);
            f1478r0.append(f0.d.f9183o5, 18);
            f1478r0.append(f0.d.f9191p5, 19);
            f1478r0.append(f0.d.Z4, 90);
            f1478r0.append(f0.d.L4, 26);
            f1478r0.append(f0.d.B5, 31);
            f1478r0.append(f0.d.C5, 32);
            f1478r0.append(f0.d.f9166m5, 10);
            f1478r0.append(f0.d.f9157l5, 9);
            f1478r0.append(f0.d.P5, 13);
            f1478r0.append(f0.d.S5, 16);
            f1478r0.append(f0.d.Q5, 14);
            f1478r0.append(f0.d.N5, 11);
            f1478r0.append(f0.d.R5, 15);
            f1478r0.append(f0.d.O5, 12);
            f1478r0.append(f0.d.I5, 38);
            f1478r0.append(f0.d.f9231u5, 37);
            f1478r0.append(f0.d.f9223t5, 39);
            f1478r0.append(f0.d.H5, 40);
            f1478r0.append(f0.d.f9215s5, 20);
            f1478r0.append(f0.d.G5, 36);
            f1478r0.append(f0.d.f9148k5, 5);
            f1478r0.append(f0.d.f9239v5, 91);
            f1478r0.append(f0.d.D5, 91);
            f1478r0.append(f0.d.f9263y5, 91);
            f1478r0.append(f0.d.f9094e5, 91);
            f1478r0.append(f0.d.f9076c5, 91);
            f1478r0.append(f0.d.O4, 23);
            f1478r0.append(f0.d.Q4, 27);
            f1478r0.append(f0.d.S4, 30);
            f1478r0.append(f0.d.T4, 8);
            f1478r0.append(f0.d.P4, 33);
            f1478r0.append(f0.d.R4, 2);
            f1478r0.append(f0.d.M4, 22);
            f1478r0.append(f0.d.N4, 21);
            f1478r0.append(f0.d.J5, 41);
            f1478r0.append(f0.d.f9199q5, 42);
            f1478r0.append(f0.d.f9067b5, 41);
            f1478r0.append(f0.d.f9058a5, 42);
            f1478r0.append(f0.d.T5, 76);
            f1478r0.append(f0.d.f9121h5, 61);
            f1478r0.append(f0.d.f9139j5, 62);
            f1478r0.append(f0.d.f9130i5, 63);
            f1478r0.append(f0.d.K5, 69);
            f1478r0.append(f0.d.f9207r5, 70);
            f1478r0.append(f0.d.X4, 71);
            f1478r0.append(f0.d.V4, 72);
            f1478r0.append(f0.d.W4, 73);
            f1478r0.append(f0.d.Y4, 74);
            f1478r0.append(f0.d.U4, 75);
        }

        public void a(b bVar) {
            this.f1479a = bVar.f1479a;
            this.f1485d = bVar.f1485d;
            this.f1481b = bVar.f1481b;
            this.f1487e = bVar.f1487e;
            this.f1489f = bVar.f1489f;
            this.f1491g = bVar.f1491g;
            this.f1493h = bVar.f1493h;
            this.f1495i = bVar.f1495i;
            this.f1497j = bVar.f1497j;
            this.f1499k = bVar.f1499k;
            this.f1501l = bVar.f1501l;
            this.f1503m = bVar.f1503m;
            this.f1505n = bVar.f1505n;
            this.f1507o = bVar.f1507o;
            this.f1509p = bVar.f1509p;
            this.f1511q = bVar.f1511q;
            this.f1513r = bVar.f1513r;
            this.f1514s = bVar.f1514s;
            this.f1515t = bVar.f1515t;
            this.f1516u = bVar.f1516u;
            this.f1517v = bVar.f1517v;
            this.f1518w = bVar.f1518w;
            this.f1519x = bVar.f1519x;
            this.f1520y = bVar.f1520y;
            this.f1521z = bVar.f1521z;
            this.A = bVar.A;
            this.B = bVar.B;
            this.C = bVar.C;
            this.D = bVar.D;
            this.E = bVar.E;
            this.F = bVar.F;
            this.G = bVar.G;
            this.H = bVar.H;
            this.I = bVar.I;
            this.J = bVar.J;
            this.K = bVar.K;
            this.L = bVar.L;
            this.M = bVar.M;
            this.N = bVar.N;
            this.O = bVar.O;
            this.P = bVar.P;
            this.Q = bVar.Q;
            this.R = bVar.R;
            this.S = bVar.S;
            this.T = bVar.T;
            this.U = bVar.U;
            this.V = bVar.V;
            this.W = bVar.W;
            this.X = bVar.X;
            this.Y = bVar.Y;
            this.Z = bVar.Z;
            this.f1480a0 = bVar.f1480a0;
            this.f1482b0 = bVar.f1482b0;
            this.f1484c0 = bVar.f1484c0;
            this.f1486d0 = bVar.f1486d0;
            this.f1488e0 = bVar.f1488e0;
            this.f1490f0 = bVar.f1490f0;
            this.f1492g0 = bVar.f1492g0;
            this.f1494h0 = bVar.f1494h0;
            this.f1496i0 = bVar.f1496i0;
            this.f1498j0 = bVar.f1498j0;
            this.f1504m0 = bVar.f1504m0;
            int[] iArr = bVar.f1500k0;
            if (iArr == null || bVar.f1502l0 != null) {
                this.f1500k0 = null;
            } else {
                this.f1500k0 = Arrays.copyOf(iArr, iArr.length);
            }
            this.f1502l0 = bVar.f1502l0;
            this.f1506n0 = bVar.f1506n0;
            this.f1508o0 = bVar.f1508o0;
            this.f1510p0 = bVar.f1510p0;
            this.f1512q0 = bVar.f1512q0;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f0.d.K4);
            this.f1481b = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                int i11 = f1478r0.get(index);
                switch (i11) {
                    case 1:
                        this.f1513r = d.j(typedArrayObtainStyledAttributes, index, this.f1513r);
                        break;
                    case 2:
                        this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.K);
                        break;
                    case 3:
                        this.f1511q = d.j(typedArrayObtainStyledAttributes, index, this.f1511q);
                        break;
                    case 4:
                        this.f1509p = d.j(typedArrayObtainStyledAttributes, index, this.f1509p);
                        break;
                    case 5:
                        this.A = typedArrayObtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.E = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.E);
                        break;
                    case 7:
                        this.F = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.F);
                        break;
                    case 8:
                        this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.L);
                        break;
                    case 9:
                        this.f1519x = d.j(typedArrayObtainStyledAttributes, index, this.f1519x);
                        break;
                    case 10:
                        this.f1518w = d.j(typedArrayObtainStyledAttributes, index, this.f1518w);
                        break;
                    case 11:
                        this.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.R);
                        break;
                    case 12:
                        this.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.S);
                        break;
                    case 13:
                        this.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.O);
                        break;
                    case 14:
                        this.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                        break;
                    case 15:
                        this.T = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.T);
                        break;
                    case 16:
                        this.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.P);
                        break;
                    case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                        this.f1489f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1489f);
                        break;
                    case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                        this.f1491g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1491g);
                        break;
                    case 19:
                        this.f1493h = typedArrayObtainStyledAttributes.getFloat(index, this.f1493h);
                        break;
                    case 20:
                        this.f1520y = typedArrayObtainStyledAttributes.getFloat(index, this.f1520y);
                        break;
                    case Build.API_LEVELS.API_21 /* 21 */:
                        this.f1487e = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f1487e);
                        break;
                    case Build.API_LEVELS.API_22 /* 22 */:
                        this.f1485d = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f1485d);
                        break;
                    case Build.API_LEVELS.API_23 /* 23 */:
                        this.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.H);
                        break;
                    case 24:
                        this.f1497j = d.j(typedArrayObtainStyledAttributes, index, this.f1497j);
                        break;
                    case Build.API_LEVELS.API_25 /* 25 */:
                        this.f1499k = d.j(typedArrayObtainStyledAttributes, index, this.f1499k);
                        break;
                    case Build.API_LEVELS.API_26 /* 26 */:
                        this.G = typedArrayObtainStyledAttributes.getInt(index, this.G);
                        break;
                    case Build.API_LEVELS.API_27 /* 27 */:
                        this.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.I);
                        break;
                    case Build.API_LEVELS.API_28 /* 28 */:
                        this.f1501l = d.j(typedArrayObtainStyledAttributes, index, this.f1501l);
                        break;
                    case Build.API_LEVELS.API_29 /* 29 */:
                        this.f1503m = d.j(typedArrayObtainStyledAttributes, index, this.f1503m);
                        break;
                    case Build.API_LEVELS.API_30 /* 30 */:
                        this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.M);
                        break;
                    case Build.API_LEVELS.API_31 /* 31 */:
                        this.f1516u = d.j(typedArrayObtainStyledAttributes, index, this.f1516u);
                        break;
                    case 32:
                        this.f1517v = d.j(typedArrayObtainStyledAttributes, index, this.f1517v);
                        break;
                    case Build.API_LEVELS.API_33 /* 33 */:
                        this.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.J);
                        break;
                    case Build.API_LEVELS.API_34 /* 34 */:
                        this.f1507o = d.j(typedArrayObtainStyledAttributes, index, this.f1507o);
                        break;
                    case Build.API_LEVELS.API_35 /* 35 */:
                        this.f1505n = d.j(typedArrayObtainStyledAttributes, index, this.f1505n);
                        break;
                    case Build.API_LEVELS.API_36 /* 36 */:
                        this.f1521z = typedArrayObtainStyledAttributes.getFloat(index, this.f1521z);
                        break;
                    case 37:
                        this.W = typedArrayObtainStyledAttributes.getFloat(index, this.W);
                        break;
                    case 38:
                        this.V = typedArrayObtainStyledAttributes.getFloat(index, this.V);
                        break;
                    case 39:
                        this.X = typedArrayObtainStyledAttributes.getInt(index, this.X);
                        break;
                    case 40:
                        this.Y = typedArrayObtainStyledAttributes.getInt(index, this.Y);
                        break;
                    case 41:
                        d.k(this, typedArrayObtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        d.k(this, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i11) {
                            case 61:
                                this.B = d.j(typedArrayObtainStyledAttributes, index, this.B);
                                break;
                            case 62:
                                this.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                break;
                            case 63:
                                this.D = typedArrayObtainStyledAttributes.getFloat(index, this.D);
                                break;
                            default:
                                switch (i11) {
                                    case 69:
                                        this.f1490f0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 70:
                                        this.f1492g0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 71:
                                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                        break;
                                    case 72:
                                        this.f1494h0 = typedArrayObtainStyledAttributes.getInt(index, this.f1494h0);
                                        break;
                                    case 73:
                                        this.f1496i0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1496i0);
                                        break;
                                    case 74:
                                        this.f1502l0 = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 75:
                                        this.f1510p0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f1510p0);
                                        break;
                                    case 76:
                                        this.f1512q0 = typedArrayObtainStyledAttributes.getInt(index, this.f1512q0);
                                        break;
                                    case 77:
                                        this.f1514s = d.j(typedArrayObtainStyledAttributes, index, this.f1514s);
                                        break;
                                    case 78:
                                        this.f1515t = d.j(typedArrayObtainStyledAttributes, index, this.f1515t);
                                        break;
                                    case 79:
                                        this.U = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.U);
                                        break;
                                    case 80:
                                        this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.N);
                                        break;
                                    case 81:
                                        this.Z = typedArrayObtainStyledAttributes.getInt(index, this.Z);
                                        break;
                                    case 82:
                                        this.f1480a0 = typedArrayObtainStyledAttributes.getInt(index, this.f1480a0);
                                        break;
                                    case 83:
                                        this.f1484c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1484c0);
                                        break;
                                    case 84:
                                        this.f1482b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1482b0);
                                        break;
                                    case 85:
                                        this.f1488e0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1488e0);
                                        break;
                                    case 86:
                                        this.f1486d0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1486d0);
                                        break;
                                    case 87:
                                        this.f1506n0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f1506n0);
                                        break;
                                    case 88:
                                        this.f1508o0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f1508o0);
                                        break;
                                    case 89:
                                        this.f1504m0 = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 90:
                                        this.f1495i = typedArrayObtainStyledAttributes.getBoolean(index, this.f1495i);
                                        break;
                                    case 91:
                                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f1478r0.get(index));
                                        break;
                                    default:
                                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f1478r0.get(index));
                                        break;
                                }
                                break;
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static SparseIntArray f1522o;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1523a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1524b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1525c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f1526d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1527e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1528f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f1529g = Float.NaN;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f1530h = -1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f1531i = Float.NaN;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f1532j = Float.NaN;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f1533k = -1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f1534l = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f1535m = -3;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f1536n = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1522o = sparseIntArray;
            sparseIntArray.append(f0.d.f9104f6, 1);
            f1522o.append(f0.d.f9122h6, 2);
            f1522o.append(f0.d.f9158l6, 3);
            f1522o.append(f0.d.f9095e6, 4);
            f1522o.append(f0.d.f9086d6, 5);
            f1522o.append(f0.d.f9077c6, 6);
            f1522o.append(f0.d.f9113g6, 7);
            f1522o.append(f0.d.f9149k6, 8);
            f1522o.append(f0.d.f9140j6, 9);
            f1522o.append(f0.d.f9131i6, 10);
        }

        public void a(c cVar) {
            this.f1523a = cVar.f1523a;
            this.f1524b = cVar.f1524b;
            this.f1526d = cVar.f1526d;
            this.f1527e = cVar.f1527e;
            this.f1528f = cVar.f1528f;
            this.f1531i = cVar.f1531i;
            this.f1529g = cVar.f1529g;
            this.f1530h = cVar.f1530h;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f0.d.f9068b6);
            this.f1523a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                switch (f1522o.get(index)) {
                    case 1:
                        this.f1531i = typedArrayObtainStyledAttributes.getFloat(index, this.f1531i);
                        break;
                    case 2:
                        this.f1527e = typedArrayObtainStyledAttributes.getInt(index, this.f1527e);
                        break;
                    case 3:
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            this.f1526d = typedArrayObtainStyledAttributes.getString(index);
                        } else {
                            this.f1526d = a0.a.f5c[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                        }
                        break;
                    case 4:
                        this.f1528f = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f1524b = d.j(typedArrayObtainStyledAttributes, index, this.f1524b);
                        break;
                    case 6:
                        this.f1525c = typedArrayObtainStyledAttributes.getInteger(index, this.f1525c);
                        break;
                    case 7:
                        this.f1529g = typedArrayObtainStyledAttributes.getFloat(index, this.f1529g);
                        break;
                    case 8:
                        this.f1533k = typedArrayObtainStyledAttributes.getInteger(index, this.f1533k);
                        break;
                    case 9:
                        this.f1532j = typedArrayObtainStyledAttributes.getFloat(index, this.f1532j);
                        break;
                    case 10:
                        int i11 = typedArrayObtainStyledAttributes.peekValue(index).type;
                        if (i11 == 1) {
                            int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            this.f1536n = resourceId;
                            if (resourceId != -1) {
                                this.f1535m = -2;
                            }
                        } else if (i11 == 3) {
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            this.f1534l = string;
                            if (string.indexOf("/") > 0) {
                                this.f1536n = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                this.f1535m = -2;
                            } else {
                                this.f1535m = -1;
                            }
                        } else {
                            this.f1535m = typedArrayObtainStyledAttributes.getInteger(index, this.f1536n);
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0019d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1537a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1538b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1539c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f1540d = 1.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f1541e = Float.NaN;

        public void a(C0019d c0019d) {
            this.f1537a = c0019d.f1537a;
            this.f1538b = c0019d.f1538b;
            this.f1540d = c0019d.f1540d;
            this.f1541e = c0019d.f1541e;
            this.f1539c = c0019d.f1539c;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f0.d.f9248w6);
            this.f1537a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == f0.d.f9264y6) {
                    this.f1540d = typedArrayObtainStyledAttributes.getFloat(index, this.f1540d);
                } else if (index == f0.d.f9256x6) {
                    this.f1538b = typedArrayObtainStyledAttributes.getInt(index, this.f1538b);
                    this.f1538b = d.f1450f[this.f1538b];
                } else if (index == f0.d.A6) {
                    this.f1539c = typedArrayObtainStyledAttributes.getInt(index, this.f1539c);
                } else if (index == f0.d.f9272z6) {
                    this.f1541e = typedArrayObtainStyledAttributes.getFloat(index, this.f1541e);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class e {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static SparseIntArray f1542o;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1543a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f1544b = 0.0f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f1545c = 0.0f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f1546d = 0.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f1547e = 1.0f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f1548f = 1.0f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f1549g = Float.NaN;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f1550h = Float.NaN;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f1551i = -1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f1552j = 0.0f;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f1553k = 0.0f;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f1554l = 0.0f;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f1555m = false;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f1556n = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1542o = sparseIntArray;
            sparseIntArray.append(f0.d.V6, 1);
            f1542o.append(f0.d.W6, 2);
            f1542o.append(f0.d.X6, 3);
            f1542o.append(f0.d.T6, 4);
            f1542o.append(f0.d.U6, 5);
            f1542o.append(f0.d.P6, 6);
            f1542o.append(f0.d.Q6, 7);
            f1542o.append(f0.d.R6, 8);
            f1542o.append(f0.d.S6, 9);
            f1542o.append(f0.d.Y6, 10);
            f1542o.append(f0.d.Z6, 11);
            f1542o.append(f0.d.f9060a7, 12);
        }

        public void a(e eVar) {
            this.f1543a = eVar.f1543a;
            this.f1544b = eVar.f1544b;
            this.f1545c = eVar.f1545c;
            this.f1546d = eVar.f1546d;
            this.f1547e = eVar.f1547e;
            this.f1548f = eVar.f1548f;
            this.f1549g = eVar.f1549g;
            this.f1550h = eVar.f1550h;
            this.f1551i = eVar.f1551i;
            this.f1552j = eVar.f1552j;
            this.f1553k = eVar.f1553k;
            this.f1554l = eVar.f1554l;
            this.f1555m = eVar.f1555m;
            this.f1556n = eVar.f1556n;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f0.d.O6);
            this.f1543a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                switch (f1542o.get(index)) {
                    case 1:
                        this.f1544b = typedArrayObtainStyledAttributes.getFloat(index, this.f1544b);
                        break;
                    case 2:
                        this.f1545c = typedArrayObtainStyledAttributes.getFloat(index, this.f1545c);
                        break;
                    case 3:
                        this.f1546d = typedArrayObtainStyledAttributes.getFloat(index, this.f1546d);
                        break;
                    case 4:
                        this.f1547e = typedArrayObtainStyledAttributes.getFloat(index, this.f1547e);
                        break;
                    case 5:
                        this.f1548f = typedArrayObtainStyledAttributes.getFloat(index, this.f1548f);
                        break;
                    case 6:
                        this.f1549g = typedArrayObtainStyledAttributes.getDimension(index, this.f1549g);
                        break;
                    case 7:
                        this.f1550h = typedArrayObtainStyledAttributes.getDimension(index, this.f1550h);
                        break;
                    case 8:
                        this.f1552j = typedArrayObtainStyledAttributes.getDimension(index, this.f1552j);
                        break;
                    case 9:
                        this.f1553k = typedArrayObtainStyledAttributes.getDimension(index, this.f1553k);
                        break;
                    case 10:
                        this.f1554l = typedArrayObtainStyledAttributes.getDimension(index, this.f1554l);
                        break;
                    case 11:
                        this.f1555m = true;
                        this.f1556n = typedArrayObtainStyledAttributes.getDimension(index, this.f1556n);
                        break;
                    case 12:
                        this.f1551i = d.j(typedArrayObtainStyledAttributes, index, this.f1551i);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static {
        f1451g.append(f0.d.A0, 25);
        f1451g.append(f0.d.B0, 26);
        f1451g.append(f0.d.D0, 29);
        f1451g.append(f0.d.E0, 30);
        f1451g.append(f0.d.K0, 36);
        f1451g.append(f0.d.J0, 35);
        f1451g.append(f0.d.f9116h0, 4);
        f1451g.append(f0.d.f9107g0, 3);
        f1451g.append(f0.d.f9071c0, 1);
        f1451g.append(f0.d.f9089e0, 91);
        f1451g.append(f0.d.f9080d0, 92);
        f1451g.append(f0.d.T0, 6);
        f1451g.append(f0.d.U0, 7);
        f1451g.append(f0.d.f9178o0, 17);
        f1451g.append(f0.d.f9186p0, 18);
        f1451g.append(f0.d.f9194q0, 19);
        f1451g.append(f0.d.Y, 99);
        f1451g.append(f0.d.f9225u, 27);
        f1451g.append(f0.d.F0, 32);
        f1451g.append(f0.d.G0, 33);
        f1451g.append(f0.d.f9170n0, 10);
        f1451g.append(f0.d.f9161m0, 9);
        f1451g.append(f0.d.X0, 13);
        f1451g.append(f0.d.f9054a1, 16);
        f1451g.append(f0.d.Y0, 14);
        f1451g.append(f0.d.V0, 11);
        f1451g.append(f0.d.Z0, 15);
        f1451g.append(f0.d.W0, 12);
        f1451g.append(f0.d.N0, 40);
        f1451g.append(f0.d.f9258y0, 39);
        f1451g.append(f0.d.f9250x0, 41);
        f1451g.append(f0.d.M0, 42);
        f1451g.append(f0.d.f9242w0, 20);
        f1451g.append(f0.d.L0, 37);
        f1451g.append(f0.d.f9152l0, 5);
        f1451g.append(f0.d.f9266z0, 87);
        f1451g.append(f0.d.I0, 87);
        f1451g.append(f0.d.C0, 87);
        f1451g.append(f0.d.f9098f0, 87);
        f1451g.append(f0.d.f9062b0, 87);
        f1451g.append(f0.d.f9265z, 24);
        f1451g.append(f0.d.B, 28);
        f1451g.append(f0.d.N, 31);
        f1451g.append(f0.d.O, 8);
        f1451g.append(f0.d.A, 34);
        f1451g.append(f0.d.C, 2);
        f1451g.append(f0.d.f9249x, 23);
        f1451g.append(f0.d.f9257y, 21);
        f1451g.append(f0.d.O0, 95);
        f1451g.append(f0.d.f9202r0, 96);
        f1451g.append(f0.d.f9241w, 22);
        f1451g.append(f0.d.D, 43);
        f1451g.append(f0.d.Q, 44);
        f1451g.append(f0.d.L, 45);
        f1451g.append(f0.d.M, 46);
        f1451g.append(f0.d.K, 60);
        f1451g.append(f0.d.I, 47);
        f1451g.append(f0.d.J, 48);
        f1451g.append(f0.d.E, 49);
        f1451g.append(f0.d.F, 50);
        f1451g.append(f0.d.G, 51);
        f1451g.append(f0.d.H, 52);
        f1451g.append(f0.d.P, 53);
        f1451g.append(f0.d.P0, 54);
        f1451g.append(f0.d.f9210s0, 55);
        f1451g.append(f0.d.Q0, 56);
        f1451g.append(f0.d.f9218t0, 57);
        f1451g.append(f0.d.R0, 58);
        f1451g.append(f0.d.f9226u0, 59);
        f1451g.append(f0.d.f9125i0, 61);
        f1451g.append(f0.d.f9143k0, 62);
        f1451g.append(f0.d.f9134j0, 63);
        f1451g.append(f0.d.R, 64);
        f1451g.append(f0.d.f9144k1, 65);
        f1451g.append(f0.d.X, 66);
        f1451g.append(f0.d.f9153l1, 67);
        f1451g.append(f0.d.f9081d1, 79);
        f1451g.append(f0.d.f9233v, 38);
        f1451g.append(f0.d.f9072c1, 68);
        f1451g.append(f0.d.S0, 69);
        f1451g.append(f0.d.f9234v0, 70);
        f1451g.append(f0.d.f9063b1, 97);
        f1451g.append(f0.d.V, 71);
        f1451g.append(f0.d.T, 72);
        f1451g.append(f0.d.U, 73);
        f1451g.append(f0.d.W, 74);
        f1451g.append(f0.d.S, 75);
        f1451g.append(f0.d.f9090e1, 76);
        f1451g.append(f0.d.H0, 77);
        f1451g.append(f0.d.f9162m1, 78);
        f1451g.append(f0.d.f9053a0, 80);
        f1451g.append(f0.d.Z, 81);
        f1451g.append(f0.d.f9099f1, 82);
        f1451g.append(f0.d.f9135j1, 83);
        f1451g.append(f0.d.f9126i1, 84);
        f1451g.append(f0.d.f9117h1, 85);
        f1451g.append(f0.d.f9108g1, 86);
        f1452h.append(f0.d.P3, 6);
        f1452h.append(f0.d.P3, 7);
        f1452h.append(f0.d.K2, 27);
        f1452h.append(f0.d.S3, 13);
        f1452h.append(f0.d.V3, 16);
        f1452h.append(f0.d.T3, 14);
        f1452h.append(f0.d.Q3, 11);
        f1452h.append(f0.d.U3, 15);
        f1452h.append(f0.d.R3, 12);
        f1452h.append(f0.d.J3, 40);
        f1452h.append(f0.d.C3, 39);
        f1452h.append(f0.d.B3, 41);
        f1452h.append(f0.d.I3, 42);
        f1452h.append(f0.d.A3, 20);
        f1452h.append(f0.d.H3, 37);
        f1452h.append(f0.d.f9229u3, 5);
        f1452h.append(f0.d.D3, 87);
        f1452h.append(f0.d.G3, 87);
        f1452h.append(f0.d.E3, 87);
        f1452h.append(f0.d.f9205r3, 87);
        f1452h.append(f0.d.f9197q3, 87);
        f1452h.append(f0.d.P2, 24);
        f1452h.append(f0.d.R2, 28);
        f1452h.append(f0.d.f9083d3, 31);
        f1452h.append(f0.d.f9092e3, 8);
        f1452h.append(f0.d.Q2, 34);
        f1452h.append(f0.d.S2, 2);
        f1452h.append(f0.d.N2, 23);
        f1452h.append(f0.d.O2, 21);
        f1452h.append(f0.d.K3, 95);
        f1452h.append(f0.d.f9237v3, 96);
        f1452h.append(f0.d.M2, 22);
        f1452h.append(f0.d.T2, 43);
        f1452h.append(f0.d.f9110g3, 44);
        f1452h.append(f0.d.f9065b3, 45);
        f1452h.append(f0.d.f9074c3, 46);
        f1452h.append(f0.d.f9056a3, 60);
        f1452h.append(f0.d.Y2, 47);
        f1452h.append(f0.d.Z2, 48);
        f1452h.append(f0.d.U2, 49);
        f1452h.append(f0.d.V2, 50);
        f1452h.append(f0.d.W2, 51);
        f1452h.append(f0.d.X2, 52);
        f1452h.append(f0.d.f9101f3, 53);
        f1452h.append(f0.d.L3, 54);
        f1452h.append(f0.d.f9245w3, 55);
        f1452h.append(f0.d.M3, 56);
        f1452h.append(f0.d.f9253x3, 57);
        f1452h.append(f0.d.N3, 58);
        f1452h.append(f0.d.f9261y3, 59);
        f1452h.append(f0.d.f9221t3, 62);
        f1452h.append(f0.d.f9213s3, 63);
        f1452h.append(f0.d.f9119h3, 64);
        f1452h.append(f0.d.f9111g4, 65);
        f1452h.append(f0.d.f9173n3, 66);
        f1452h.append(f0.d.f9120h4, 67);
        f1452h.append(f0.d.Y3, 79);
        f1452h.append(f0.d.L2, 38);
        f1452h.append(f0.d.Z3, 98);
        f1452h.append(f0.d.X3, 68);
        f1452h.append(f0.d.O3, 69);
        f1452h.append(f0.d.f9269z3, 70);
        f1452h.append(f0.d.f9155l3, 71);
        f1452h.append(f0.d.f9137j3, 72);
        f1452h.append(f0.d.f9146k3, 73);
        f1452h.append(f0.d.f9164m3, 74);
        f1452h.append(f0.d.f9128i3, 75);
        f1452h.append(f0.d.f9057a4, 76);
        f1452h.append(f0.d.F3, 77);
        f1452h.append(f0.d.f9129i4, 78);
        f1452h.append(f0.d.f9189p3, 80);
        f1452h.append(f0.d.f9181o3, 81);
        f1452h.append(f0.d.f9066b4, 82);
        f1452h.append(f0.d.f9102f4, 83);
        f1452h.append(f0.d.f9093e4, 84);
        f1452h.append(f0.d.f9084d4, 85);
        f1452h.append(f0.d.f9075c4, 86);
        f1452h.append(f0.d.W3, 97);
    }

    public static int j(TypedArray typedArray, int i10, int i11) {
        int resourceId = typedArray.getResourceId(i10, i11);
        return resourceId == -1 ? typedArray.getInt(i10, -1) : resourceId;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void k(java.lang.Object r4, android.content.res.TypedArray r5, int r6, int r7) {
        /*
            if (r4 != 0) goto L4
            goto L71
        L4:
            android.util.TypedValue r0 = r5.peekValue(r6)
            int r0 = r0.type
            r1 = 3
            if (r0 == r1) goto L72
            r1 = 5
            r2 = 0
            if (r0 == r1) goto L2b
            int r5 = r5.getInt(r6, r2)
            r6 = -4
            r0 = -2
            if (r5 == r6) goto L27
            r6 = -3
            if (r5 == r6) goto L21
            if (r5 == r0) goto L23
            r6 = -1
            if (r5 == r6) goto L23
        L21:
            r5 = r2
            goto L30
        L23:
            r3 = r2
            r2 = r5
            r5 = r3
            goto L30
        L27:
            r2 = 1
            r5 = r2
            r2 = r0
            goto L30
        L2b:
            int r5 = r5.getDimensionPixelSize(r6, r2)
            goto L23
        L30:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.ConstraintLayout.b
            if (r6 == 0) goto L42
            androidx.constraintlayout.widget.ConstraintLayout$b r4 = (androidx.constraintlayout.widget.ConstraintLayout.b) r4
            if (r7 != 0) goto L3d
            r4.width = r2
            r4.f1363a0 = r5
            return
        L3d:
            r4.height = r2
            r4.f1365b0 = r5
            return
        L42:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.d.b
            if (r6 == 0) goto L54
            androidx.constraintlayout.widget.d$b r4 = (androidx.constraintlayout.widget.d.b) r4
            if (r7 != 0) goto L4f
            r4.f1485d = r2
            r4.f1506n0 = r5
            return
        L4f:
            r4.f1487e = r2
            r4.f1508o0 = r5
            return
        L54:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.d.a.C0018a
            if (r6 == 0) goto L71
            androidx.constraintlayout.widget.d$a$a r4 = (androidx.constraintlayout.widget.d.a.C0018a) r4
            if (r7 != 0) goto L67
            r6 = 23
            r4.b(r6, r2)
            r6 = 80
            r4.d(r6, r5)
            return
        L67:
            r6 = 21
            r4.b(r6, r2)
            r6 = 81
            r4.d(r6, r5)
        L71:
            return
        L72:
            java.lang.String r5 = r5.getString(r6)
            l(r4, r5, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.d.k(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    public static void l(Object obj, String str, int i10) {
        if (str == null) {
            return;
        }
        int iIndexOf = str.indexOf(61);
        int length = str.length();
        if (iIndexOf <= 0 || iIndexOf >= length - 1) {
            return;
        }
        String strSubstring = str.substring(0, iIndexOf);
        String strSubstring2 = str.substring(iIndexOf + 1);
        if (strSubstring2.length() > 0) {
            String strTrim = strSubstring.trim();
            String strTrim2 = strSubstring2.trim();
            if ("ratio".equalsIgnoreCase(strTrim)) {
                if (obj instanceof ConstraintLayout.b) {
                    ConstraintLayout.b bVar = (ConstraintLayout.b) obj;
                    if (i10 == 0) {
                        ((ViewGroup.MarginLayoutParams) bVar).width = 0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) bVar).height = 0;
                    }
                    m(bVar, strTrim2);
                    return;
                }
                if (obj instanceof b) {
                    ((b) obj).A = strTrim2;
                    return;
                } else {
                    if (obj instanceof a.C0018a) {
                        ((a.C0018a) obj).c(5, strTrim2);
                        return;
                    }
                    return;
                }
            }
            try {
                if ("weight".equalsIgnoreCase(strTrim)) {
                    float f10 = Float.parseFloat(strTrim2);
                    if (obj instanceof ConstraintLayout.b) {
                        ConstraintLayout.b bVar2 = (ConstraintLayout.b) obj;
                        if (i10 == 0) {
                            ((ViewGroup.MarginLayoutParams) bVar2).width = 0;
                            bVar2.L = f10;
                            return;
                        } else {
                            ((ViewGroup.MarginLayoutParams) bVar2).height = 0;
                            bVar2.M = f10;
                            return;
                        }
                    }
                    if (obj instanceof b) {
                        b bVar3 = (b) obj;
                        if (i10 == 0) {
                            bVar3.f1485d = 0;
                            bVar3.W = f10;
                            return;
                        } else {
                            bVar3.f1487e = 0;
                            bVar3.V = f10;
                            return;
                        }
                    }
                    if (obj instanceof a.C0018a) {
                        a.C0018a c0018a = (a.C0018a) obj;
                        if (i10 == 0) {
                            c0018a.b(23, 0);
                            c0018a.a(39, f10);
                            return;
                        } else {
                            c0018a.b(21, 0);
                            c0018a.a(40, f10);
                            return;
                        }
                    }
                    return;
                }
                if ("parent".equalsIgnoreCase(strTrim)) {
                    float fMax = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(strTrim2)));
                    if (obj instanceof ConstraintLayout.b) {
                        ConstraintLayout.b bVar4 = (ConstraintLayout.b) obj;
                        if (i10 == 0) {
                            ((ViewGroup.MarginLayoutParams) bVar4).width = 0;
                            bVar4.V = fMax;
                            bVar4.P = 2;
                            return;
                        } else {
                            ((ViewGroup.MarginLayoutParams) bVar4).height = 0;
                            bVar4.W = fMax;
                            bVar4.Q = 2;
                            return;
                        }
                    }
                    if (obj instanceof b) {
                        b bVar5 = (b) obj;
                        if (i10 == 0) {
                            bVar5.f1485d = 0;
                            bVar5.f1490f0 = fMax;
                            bVar5.Z = 2;
                            return;
                        } else {
                            bVar5.f1487e = 0;
                            bVar5.f1492g0 = fMax;
                            bVar5.f1480a0 = 2;
                            return;
                        }
                    }
                    if (obj instanceof a.C0018a) {
                        a.C0018a c0018a2 = (a.C0018a) obj;
                        if (i10 == 0) {
                            c0018a2.b(23, 0);
                            c0018a2.b(54, 2);
                        } else {
                            c0018a2.b(21, 0);
                            c0018a2.b(55, 2);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    public static void m(ConstraintLayout.b bVar, String str) {
        float fAbs = Float.NaN;
        int i10 = -1;
        if (str != null) {
            int length = str.length();
            int iIndexOf = str.indexOf(44);
            int i11 = 0;
            if (iIndexOf > 0 && iIndexOf < length - 1) {
                String strSubstring = str.substring(0, iIndexOf);
                if (strSubstring.equalsIgnoreCase("W")) {
                    i10 = 0;
                } else if (strSubstring.equalsIgnoreCase("H")) {
                    i10 = 1;
                }
                i11 = iIndexOf + 1;
            }
            int iIndexOf2 = str.indexOf(58);
            try {
                if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                    String strSubstring2 = str.substring(i11);
                    if (strSubstring2.length() > 0) {
                        fAbs = Float.parseFloat(strSubstring2);
                    }
                } else {
                    String strSubstring3 = str.substring(i11, iIndexOf2);
                    String strSubstring4 = str.substring(iIndexOf2 + 1);
                    if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                        float f10 = Float.parseFloat(strSubstring3);
                        float f11 = Float.parseFloat(strSubstring4);
                        if (f10 > 0.0f && f11 > 0.0f) {
                            fAbs = i10 == 1 ? Math.abs(f11 / f10) : Math.abs(f10 / f11);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        bVar.I = str;
        bVar.J = fAbs;
        bVar.K = i10;
    }

    public static void o(Context context, a aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        a.C0018a c0018a = new a.C0018a();
        aVar.f1465h = c0018a;
        aVar.f1461d.f1523a = false;
        aVar.f1462e.f1481b = false;
        aVar.f1460c.f1537a = false;
        aVar.f1463f.f1543a = false;
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArray.getIndex(i10);
            switch (f1452h.get(index)) {
                case 2:
                    c0018a.b(2, typedArray.getDimensionPixelSize(index, aVar.f1462e.K));
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case Build.API_LEVELS.API_25 /* 25 */:
                case Build.API_LEVELS.API_26 /* 26 */:
                case Build.API_LEVELS.API_29 /* 29 */:
                case Build.API_LEVELS.API_30 /* 30 */:
                case 32:
                case Build.API_LEVELS.API_33 /* 33 */:
                case Build.API_LEVELS.API_35 /* 35 */:
                case Build.API_LEVELS.API_36 /* 36 */:
                case 61:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f1451g.get(index));
                    break;
                case 5:
                    c0018a.c(5, typedArray.getString(index));
                    break;
                case 6:
                    c0018a.b(6, typedArray.getDimensionPixelOffset(index, aVar.f1462e.E));
                    break;
                case 7:
                    c0018a.b(7, typedArray.getDimensionPixelOffset(index, aVar.f1462e.F));
                    break;
                case 8:
                    c0018a.b(8, typedArray.getDimensionPixelSize(index, aVar.f1462e.L));
                    break;
                case 11:
                    c0018a.b(11, typedArray.getDimensionPixelSize(index, aVar.f1462e.R));
                    break;
                case 12:
                    c0018a.b(12, typedArray.getDimensionPixelSize(index, aVar.f1462e.S));
                    break;
                case 13:
                    c0018a.b(13, typedArray.getDimensionPixelSize(index, aVar.f1462e.O));
                    break;
                case 14:
                    c0018a.b(14, typedArray.getDimensionPixelSize(index, aVar.f1462e.Q));
                    break;
                case 15:
                    c0018a.b(15, typedArray.getDimensionPixelSize(index, aVar.f1462e.T));
                    break;
                case 16:
                    c0018a.b(16, typedArray.getDimensionPixelSize(index, aVar.f1462e.P));
                    break;
                case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    c0018a.b(17, typedArray.getDimensionPixelOffset(index, aVar.f1462e.f1489f));
                    break;
                case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                    c0018a.b(18, typedArray.getDimensionPixelOffset(index, aVar.f1462e.f1491g));
                    break;
                case 19:
                    c0018a.a(19, typedArray.getFloat(index, aVar.f1462e.f1493h));
                    break;
                case 20:
                    c0018a.a(20, typedArray.getFloat(index, aVar.f1462e.f1520y));
                    break;
                case Build.API_LEVELS.API_21 /* 21 */:
                    c0018a.b(21, typedArray.getLayoutDimension(index, aVar.f1462e.f1487e));
                    break;
                case Build.API_LEVELS.API_22 /* 22 */:
                    c0018a.b(22, f1450f[typedArray.getInt(index, aVar.f1460c.f1538b)]);
                    break;
                case Build.API_LEVELS.API_23 /* 23 */:
                    c0018a.b(23, typedArray.getLayoutDimension(index, aVar.f1462e.f1485d));
                    break;
                case 24:
                    c0018a.b(24, typedArray.getDimensionPixelSize(index, aVar.f1462e.H));
                    break;
                case Build.API_LEVELS.API_27 /* 27 */:
                    c0018a.b(27, typedArray.getInt(index, aVar.f1462e.G));
                    break;
                case Build.API_LEVELS.API_28 /* 28 */:
                    c0018a.b(28, typedArray.getDimensionPixelSize(index, aVar.f1462e.I));
                    break;
                case Build.API_LEVELS.API_31 /* 31 */:
                    c0018a.b(31, typedArray.getDimensionPixelSize(index, aVar.f1462e.M));
                    break;
                case Build.API_LEVELS.API_34 /* 34 */:
                    c0018a.b(34, typedArray.getDimensionPixelSize(index, aVar.f1462e.J));
                    break;
                case 37:
                    c0018a.a(37, typedArray.getFloat(index, aVar.f1462e.f1521z));
                    break;
                case 38:
                    int resourceId = typedArray.getResourceId(index, aVar.f1458a);
                    aVar.f1458a = resourceId;
                    c0018a.b(38, resourceId);
                    break;
                case 39:
                    c0018a.a(39, typedArray.getFloat(index, aVar.f1462e.W));
                    break;
                case 40:
                    c0018a.a(40, typedArray.getFloat(index, aVar.f1462e.V));
                    break;
                case 41:
                    c0018a.b(41, typedArray.getInt(index, aVar.f1462e.X));
                    break;
                case 42:
                    c0018a.b(42, typedArray.getInt(index, aVar.f1462e.Y));
                    break;
                case 43:
                    c0018a.a(43, typedArray.getFloat(index, aVar.f1460c.f1540d));
                    break;
                case 44:
                    c0018a.d(44, true);
                    c0018a.a(44, typedArray.getDimension(index, aVar.f1463f.f1556n));
                    break;
                case 45:
                    c0018a.a(45, typedArray.getFloat(index, aVar.f1463f.f1545c));
                    break;
                case 46:
                    c0018a.a(46, typedArray.getFloat(index, aVar.f1463f.f1546d));
                    break;
                case 47:
                    c0018a.a(47, typedArray.getFloat(index, aVar.f1463f.f1547e));
                    break;
                case 48:
                    c0018a.a(48, typedArray.getFloat(index, aVar.f1463f.f1548f));
                    break;
                case PurchaseParamsValidator.MAX_NUMBER_OF_ADD_ON_PRODUCTS /* 49 */:
                    c0018a.a(49, typedArray.getDimension(index, aVar.f1463f.f1549g));
                    break;
                case EventsManager.EVENTS_TO_CLEAR_ON_LIMIT /* 50 */:
                    c0018a.a(50, typedArray.getDimension(index, aVar.f1463f.f1550h));
                    break;
                case 51:
                    c0018a.a(51, typedArray.getDimension(index, aVar.f1463f.f1552j));
                    break;
                case 52:
                    c0018a.a(52, typedArray.getDimension(index, aVar.f1463f.f1553k));
                    break;
                case 53:
                    c0018a.a(53, typedArray.getDimension(index, aVar.f1463f.f1554l));
                    break;
                case 54:
                    c0018a.b(54, typedArray.getInt(index, aVar.f1462e.Z));
                    break;
                case 55:
                    c0018a.b(55, typedArray.getInt(index, aVar.f1462e.f1480a0));
                    break;
                case 56:
                    c0018a.b(56, typedArray.getDimensionPixelSize(index, aVar.f1462e.f1482b0));
                    break;
                case 57:
                    c0018a.b(57, typedArray.getDimensionPixelSize(index, aVar.f1462e.f1484c0));
                    break;
                case 58:
                    c0018a.b(58, typedArray.getDimensionPixelSize(index, aVar.f1462e.f1486d0));
                    break;
                case 59:
                    c0018a.b(59, typedArray.getDimensionPixelSize(index, aVar.f1462e.f1488e0));
                    break;
                case 60:
                    c0018a.a(60, typedArray.getFloat(index, aVar.f1463f.f1544b));
                    break;
                case 62:
                    c0018a.b(62, typedArray.getDimensionPixelSize(index, aVar.f1462e.C));
                    break;
                case 63:
                    c0018a.a(63, typedArray.getFloat(index, aVar.f1462e.D));
                    break;
                case 64:
                    c0018a.b(64, j(typedArray, index, aVar.f1461d.f1524b));
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        c0018a.c(65, typedArray.getString(index));
                    } else {
                        c0018a.c(65, a0.a.f5c[typedArray.getInteger(index, 0)]);
                    }
                    break;
                case 66:
                    c0018a.b(66, typedArray.getInt(index, 0));
                    break;
                case 67:
                    c0018a.a(67, typedArray.getFloat(index, aVar.f1461d.f1531i));
                    break;
                case 68:
                    c0018a.a(68, typedArray.getFloat(index, aVar.f1460c.f1541e));
                    break;
                case 69:
                    c0018a.a(69, typedArray.getFloat(index, 1.0f));
                    break;
                case 70:
                    c0018a.a(70, typedArray.getFloat(index, 1.0f));
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    c0018a.b(72, typedArray.getInt(index, aVar.f1462e.f1494h0));
                    break;
                case 73:
                    c0018a.b(73, typedArray.getDimensionPixelSize(index, aVar.f1462e.f1496i0));
                    break;
                case 74:
                    c0018a.c(74, typedArray.getString(index));
                    break;
                case 75:
                    c0018a.d(75, typedArray.getBoolean(index, aVar.f1462e.f1510p0));
                    break;
                case 76:
                    c0018a.b(76, typedArray.getInt(index, aVar.f1461d.f1527e));
                    break;
                case 77:
                    c0018a.c(77, typedArray.getString(index));
                    break;
                case 78:
                    c0018a.b(78, typedArray.getInt(index, aVar.f1460c.f1539c));
                    break;
                case 79:
                    c0018a.a(79, typedArray.getFloat(index, aVar.f1461d.f1529g));
                    break;
                case 80:
                    c0018a.d(80, typedArray.getBoolean(index, aVar.f1462e.f1506n0));
                    break;
                case 81:
                    c0018a.d(81, typedArray.getBoolean(index, aVar.f1462e.f1508o0));
                    break;
                case 82:
                    c0018a.b(82, typedArray.getInteger(index, aVar.f1461d.f1525c));
                    break;
                case 83:
                    c0018a.b(83, j(typedArray, index, aVar.f1463f.f1551i));
                    break;
                case 84:
                    c0018a.b(84, typedArray.getInteger(index, aVar.f1461d.f1533k));
                    break;
                case 85:
                    c0018a.a(85, typedArray.getFloat(index, aVar.f1461d.f1532j));
                    break;
                case 86:
                    int i11 = typedArray.peekValue(index).type;
                    if (i11 == 1) {
                        aVar.f1461d.f1536n = typedArray.getResourceId(index, -1);
                        c0018a.b(89, aVar.f1461d.f1536n);
                        c cVar = aVar.f1461d;
                        if (cVar.f1536n != -1) {
                            cVar.f1535m = -2;
                            c0018a.b(88, -2);
                        }
                    } else if (i11 == 3) {
                        aVar.f1461d.f1534l = typedArray.getString(index);
                        c0018a.c(90, aVar.f1461d.f1534l);
                        if (aVar.f1461d.f1534l.indexOf("/") > 0) {
                            aVar.f1461d.f1536n = typedArray.getResourceId(index, -1);
                            c0018a.b(89, aVar.f1461d.f1536n);
                            aVar.f1461d.f1535m = -2;
                            c0018a.b(88, -2);
                        } else {
                            aVar.f1461d.f1535m = -1;
                            c0018a.b(88, -1);
                        }
                    } else {
                        c cVar2 = aVar.f1461d;
                        cVar2.f1535m = typedArray.getInteger(index, cVar2.f1536n);
                        c0018a.b(88, aVar.f1461d.f1535m);
                    }
                    break;
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f1451g.get(index));
                    break;
                case 93:
                    c0018a.b(93, typedArray.getDimensionPixelSize(index, aVar.f1462e.N));
                    break;
                case 94:
                    c0018a.b(94, typedArray.getDimensionPixelSize(index, aVar.f1462e.U));
                    break;
                case 95:
                    k(c0018a, typedArray, index, 0);
                    break;
                case 96:
                    k(c0018a, typedArray, index, 1);
                    break;
                case 97:
                    c0018a.b(97, typedArray.getInt(index, aVar.f1462e.f1512q0));
                    break;
                case 98:
                    if (e0.b.f8299y) {
                        int resourceId2 = typedArray.getResourceId(index, aVar.f1458a);
                        aVar.f1458a = resourceId2;
                        if (resourceId2 == -1) {
                            aVar.f1459b = typedArray.getString(index);
                        }
                    } else if (typedArray.peekValue(index).type == 3) {
                        aVar.f1459b = typedArray.getString(index);
                    } else {
                        aVar.f1458a = typedArray.getResourceId(index, aVar.f1458a);
                    }
                    break;
                case 99:
                    c0018a.d(99, typedArray.getBoolean(index, aVar.f1462e.f1495i));
                    break;
            }
        }
    }

    public void c(ConstraintLayout constraintLayout, boolean z10) {
        int childCount = constraintLayout.getChildCount();
        HashSet<Integer> hashSet = new HashSet(this.f1457e.keySet());
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            int id2 = childAt.getId();
            if (!this.f1457e.containsKey(Integer.valueOf(id2))) {
                Log.w("ConstraintSet", "id unknown " + e0.a.a(childAt));
            } else {
                if (this.f1456d && id2 == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id2 != -1) {
                    if (this.f1457e.containsKey(Integer.valueOf(id2))) {
                        hashSet.remove(Integer.valueOf(id2));
                        a aVar = (a) this.f1457e.get(Integer.valueOf(id2));
                        if (aVar != null) {
                            if (childAt instanceof androidx.constraintlayout.widget.a) {
                                aVar.f1462e.f1498j0 = 1;
                                androidx.constraintlayout.widget.a aVar2 = (androidx.constraintlayout.widget.a) childAt;
                                aVar2.setId(id2);
                                aVar2.setType(aVar.f1462e.f1494h0);
                                aVar2.setMargin(aVar.f1462e.f1496i0);
                                aVar2.setAllowsGoneWidget(aVar.f1462e.f1510p0);
                                b bVar = aVar.f1462e;
                                int[] iArr = bVar.f1500k0;
                                if (iArr != null) {
                                    aVar2.setReferencedIds(iArr);
                                } else {
                                    String str = bVar.f1502l0;
                                    if (str != null) {
                                        bVar.f1500k0 = f(aVar2, str);
                                        aVar2.setReferencedIds(aVar.f1462e.f1500k0);
                                    }
                                }
                            }
                            ConstraintLayout.b bVar2 = (ConstraintLayout.b) childAt.getLayoutParams();
                            bVar2.a();
                            aVar.b(bVar2);
                            if (z10) {
                                androidx.constraintlayout.widget.b.c(childAt, aVar.f1464g);
                            }
                            childAt.setLayoutParams(bVar2);
                            C0019d c0019d = aVar.f1460c;
                            if (c0019d.f1539c == 0) {
                                childAt.setVisibility(c0019d.f1538b);
                            }
                            childAt.setAlpha(aVar.f1460c.f1540d);
                            childAt.setRotation(aVar.f1463f.f1544b);
                            childAt.setRotationX(aVar.f1463f.f1545c);
                            childAt.setRotationY(aVar.f1463f.f1546d);
                            childAt.setScaleX(aVar.f1463f.f1547e);
                            childAt.setScaleY(aVar.f1463f.f1548f);
                            e eVar = aVar.f1463f;
                            if (eVar.f1551i != -1) {
                                if (((View) childAt.getParent()).findViewById(aVar.f1463f.f1551i) != null) {
                                    float top = (r4.getTop() + r4.getBottom()) / 2.0f;
                                    float left = (r4.getLeft() + r4.getRight()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(left - childAt.getLeft());
                                        childAt.setPivotY(top - childAt.getTop());
                                    }
                                }
                            } else {
                                if (!Float.isNaN(eVar.f1549g)) {
                                    childAt.setPivotX(aVar.f1463f.f1549g);
                                }
                                if (!Float.isNaN(aVar.f1463f.f1550h)) {
                                    childAt.setPivotY(aVar.f1463f.f1550h);
                                }
                            }
                            childAt.setTranslationX(aVar.f1463f.f1552j);
                            childAt.setTranslationY(aVar.f1463f.f1553k);
                            childAt.setTranslationZ(aVar.f1463f.f1554l);
                            e eVar2 = aVar.f1463f;
                            if (eVar2.f1555m) {
                                childAt.setElevation(eVar2.f1556n);
                            }
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id2);
                    }
                }
            }
        }
        for (Integer num : hashSet) {
            a aVar3 = (a) this.f1457e.get(num);
            if (aVar3 != null) {
                if (aVar3.f1462e.f1498j0 == 1) {
                    androidx.constraintlayout.widget.a aVar4 = new androidx.constraintlayout.widget.a(constraintLayout.getContext());
                    aVar4.setId(num.intValue());
                    b bVar3 = aVar3.f1462e;
                    int[] iArr2 = bVar3.f1500k0;
                    if (iArr2 != null) {
                        aVar4.setReferencedIds(iArr2);
                    } else {
                        String str2 = bVar3.f1502l0;
                        if (str2 != null) {
                            bVar3.f1500k0 = f(aVar4, str2);
                            aVar4.setReferencedIds(aVar3.f1462e.f1500k0);
                        }
                    }
                    aVar4.setType(aVar3.f1462e.f1494h0);
                    aVar4.setMargin(aVar3.f1462e.f1496i0);
                    ConstraintLayout.b bVarJ = constraintLayout.generateDefaultLayoutParams();
                    aVar4.m();
                    aVar3.b(bVarJ);
                    constraintLayout.addView(aVar4, bVarJ);
                }
                if (aVar3.f1462e.f1479a) {
                    View eVar3 = new androidx.constraintlayout.widget.e(constraintLayout.getContext());
                    eVar3.setId(num.intValue());
                    ConstraintLayout.b bVarJ2 = constraintLayout.generateDefaultLayoutParams();
                    aVar3.b(bVarJ2);
                    constraintLayout.addView(eVar3, bVarJ2);
                }
            }
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt2 = constraintLayout.getChildAt(i11);
            if (childAt2 instanceof androidx.constraintlayout.widget.c) {
                ((androidx.constraintlayout.widget.c) childAt2).d(constraintLayout);
            }
        }
    }

    public void d(Context context, int i10) {
        e((ConstraintLayout) LayoutInflater.from(context).inflate(i10, (ViewGroup) null));
    }

    public void e(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f1457e.clear();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (this.f1456d && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f1457e.containsKey(Integer.valueOf(id2))) {
                this.f1457e.put(Integer.valueOf(id2), new a());
            }
            a aVar = (a) this.f1457e.get(Integer.valueOf(id2));
            if (aVar != null) {
                aVar.f1464g = androidx.constraintlayout.widget.b.a(this.f1455c, childAt);
                aVar.d(id2, bVar);
                aVar.f1460c.f1538b = childAt.getVisibility();
                aVar.f1460c.f1540d = childAt.getAlpha();
                aVar.f1463f.f1544b = childAt.getRotation();
                aVar.f1463f.f1545c = childAt.getRotationX();
                aVar.f1463f.f1546d = childAt.getRotationY();
                aVar.f1463f.f1547e = childAt.getScaleX();
                aVar.f1463f.f1548f = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    e eVar = aVar.f1463f;
                    eVar.f1549g = pivotX;
                    eVar.f1550h = pivotY;
                }
                aVar.f1463f.f1552j = childAt.getTranslationX();
                aVar.f1463f.f1553k = childAt.getTranslationY();
                aVar.f1463f.f1554l = childAt.getTranslationZ();
                e eVar2 = aVar.f1463f;
                if (eVar2.f1555m) {
                    eVar2.f1556n = childAt.getElevation();
                }
                if (childAt instanceof androidx.constraintlayout.widget.a) {
                    androidx.constraintlayout.widget.a aVar2 = (androidx.constraintlayout.widget.a) childAt;
                    aVar.f1462e.f1510p0 = aVar2.getAllowsGoneWidget();
                    aVar.f1462e.f1500k0 = aVar2.getReferencedIds();
                    aVar.f1462e.f1494h0 = aVar2.getType();
                    aVar.f1462e.f1496i0 = aVar2.getMargin();
                }
            }
        }
    }

    public final int[] f(View view, String str) {
        int iIntValue;
        Object objL;
        String[] strArrSplit = str.split(f.f4598a);
        Context context = view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i10 = 0;
        int i11 = 0;
        while (i10 < strArrSplit.length) {
            String strTrim = strArrSplit[i10].trim();
            try {
                iIntValue = f0.c.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, DiagnosticsEntry.ID_KEY, context.getPackageName());
            }
            if (iIntValue == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (objL = ((ConstraintLayout) view.getParent()).l(0, strTrim)) != null && (objL instanceof Integer)) {
                iIntValue = ((Integer) objL).intValue();
            }
            iArr[i11] = iIntValue;
            i10++;
            i11++;
        }
        return i11 != strArrSplit.length ? Arrays.copyOf(iArr, i11) : iArr;
    }

    public final a g(Context context, AttributeSet attributeSet, boolean z10) {
        a aVar = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z10 ? f0.d.J2 : f0.d.f9217t);
        n(context, aVar, typedArrayObtainStyledAttributes, z10);
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    public void h(Context context, int i10) {
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a aVarG = g(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        aVarG.f1462e.f1479a = true;
                    }
                    this.f1457e.put(Integer.valueOf(aVarG.f1458a), aVarG);
                }
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:120:0x01aa, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i(android.content.Context r8, org.xmlpull.v1.XmlPullParser r9) {
        /*
            Method dump skipped, instruction units count: 500
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.d.i(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public final void n(Context context, a aVar, TypedArray typedArray, boolean z10) {
        if (z10) {
            o(context, aVar, typedArray);
            return;
        }
        int indexCount = typedArray.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArray.getIndex(i10);
            if (index != f0.d.f9233v && f0.d.N != index && f0.d.O != index) {
                aVar.f1461d.f1523a = true;
                aVar.f1462e.f1481b = true;
                aVar.f1460c.f1537a = true;
                aVar.f1463f.f1543a = true;
            }
            switch (f1451g.get(index)) {
                case 1:
                    b bVar = aVar.f1462e;
                    bVar.f1513r = j(typedArray, index, bVar.f1513r);
                    break;
                case 2:
                    b bVar2 = aVar.f1462e;
                    bVar2.K = typedArray.getDimensionPixelSize(index, bVar2.K);
                    break;
                case 3:
                    b bVar3 = aVar.f1462e;
                    bVar3.f1511q = j(typedArray, index, bVar3.f1511q);
                    break;
                case 4:
                    b bVar4 = aVar.f1462e;
                    bVar4.f1509p = j(typedArray, index, bVar4.f1509p);
                    break;
                case 5:
                    aVar.f1462e.A = typedArray.getString(index);
                    break;
                case 6:
                    b bVar5 = aVar.f1462e;
                    bVar5.E = typedArray.getDimensionPixelOffset(index, bVar5.E);
                    break;
                case 7:
                    b bVar6 = aVar.f1462e;
                    bVar6.F = typedArray.getDimensionPixelOffset(index, bVar6.F);
                    break;
                case 8:
                    b bVar7 = aVar.f1462e;
                    bVar7.L = typedArray.getDimensionPixelSize(index, bVar7.L);
                    break;
                case 9:
                    b bVar8 = aVar.f1462e;
                    bVar8.f1519x = j(typedArray, index, bVar8.f1519x);
                    break;
                case 10:
                    b bVar9 = aVar.f1462e;
                    bVar9.f1518w = j(typedArray, index, bVar9.f1518w);
                    break;
                case 11:
                    b bVar10 = aVar.f1462e;
                    bVar10.R = typedArray.getDimensionPixelSize(index, bVar10.R);
                    break;
                case 12:
                    b bVar11 = aVar.f1462e;
                    bVar11.S = typedArray.getDimensionPixelSize(index, bVar11.S);
                    break;
                case 13:
                    b bVar12 = aVar.f1462e;
                    bVar12.O = typedArray.getDimensionPixelSize(index, bVar12.O);
                    break;
                case 14:
                    b bVar13 = aVar.f1462e;
                    bVar13.Q = typedArray.getDimensionPixelSize(index, bVar13.Q);
                    break;
                case 15:
                    b bVar14 = aVar.f1462e;
                    bVar14.T = typedArray.getDimensionPixelSize(index, bVar14.T);
                    break;
                case 16:
                    b bVar15 = aVar.f1462e;
                    bVar15.P = typedArray.getDimensionPixelSize(index, bVar15.P);
                    break;
                case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    b bVar16 = aVar.f1462e;
                    bVar16.f1489f = typedArray.getDimensionPixelOffset(index, bVar16.f1489f);
                    break;
                case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                    b bVar17 = aVar.f1462e;
                    bVar17.f1491g = typedArray.getDimensionPixelOffset(index, bVar17.f1491g);
                    break;
                case 19:
                    b bVar18 = aVar.f1462e;
                    bVar18.f1493h = typedArray.getFloat(index, bVar18.f1493h);
                    break;
                case 20:
                    b bVar19 = aVar.f1462e;
                    bVar19.f1520y = typedArray.getFloat(index, bVar19.f1520y);
                    break;
                case Build.API_LEVELS.API_21 /* 21 */:
                    b bVar20 = aVar.f1462e;
                    bVar20.f1487e = typedArray.getLayoutDimension(index, bVar20.f1487e);
                    break;
                case Build.API_LEVELS.API_22 /* 22 */:
                    C0019d c0019d = aVar.f1460c;
                    c0019d.f1538b = typedArray.getInt(index, c0019d.f1538b);
                    C0019d c0019d2 = aVar.f1460c;
                    c0019d2.f1538b = f1450f[c0019d2.f1538b];
                    break;
                case Build.API_LEVELS.API_23 /* 23 */:
                    b bVar21 = aVar.f1462e;
                    bVar21.f1485d = typedArray.getLayoutDimension(index, bVar21.f1485d);
                    break;
                case 24:
                    b bVar22 = aVar.f1462e;
                    bVar22.H = typedArray.getDimensionPixelSize(index, bVar22.H);
                    break;
                case Build.API_LEVELS.API_25 /* 25 */:
                    b bVar23 = aVar.f1462e;
                    bVar23.f1497j = j(typedArray, index, bVar23.f1497j);
                    break;
                case Build.API_LEVELS.API_26 /* 26 */:
                    b bVar24 = aVar.f1462e;
                    bVar24.f1499k = j(typedArray, index, bVar24.f1499k);
                    break;
                case Build.API_LEVELS.API_27 /* 27 */:
                    b bVar25 = aVar.f1462e;
                    bVar25.G = typedArray.getInt(index, bVar25.G);
                    break;
                case Build.API_LEVELS.API_28 /* 28 */:
                    b bVar26 = aVar.f1462e;
                    bVar26.I = typedArray.getDimensionPixelSize(index, bVar26.I);
                    break;
                case Build.API_LEVELS.API_29 /* 29 */:
                    b bVar27 = aVar.f1462e;
                    bVar27.f1501l = j(typedArray, index, bVar27.f1501l);
                    break;
                case Build.API_LEVELS.API_30 /* 30 */:
                    b bVar28 = aVar.f1462e;
                    bVar28.f1503m = j(typedArray, index, bVar28.f1503m);
                    break;
                case Build.API_LEVELS.API_31 /* 31 */:
                    b bVar29 = aVar.f1462e;
                    bVar29.M = typedArray.getDimensionPixelSize(index, bVar29.M);
                    break;
                case 32:
                    b bVar30 = aVar.f1462e;
                    bVar30.f1516u = j(typedArray, index, bVar30.f1516u);
                    break;
                case Build.API_LEVELS.API_33 /* 33 */:
                    b bVar31 = aVar.f1462e;
                    bVar31.f1517v = j(typedArray, index, bVar31.f1517v);
                    break;
                case Build.API_LEVELS.API_34 /* 34 */:
                    b bVar32 = aVar.f1462e;
                    bVar32.J = typedArray.getDimensionPixelSize(index, bVar32.J);
                    break;
                case Build.API_LEVELS.API_35 /* 35 */:
                    b bVar33 = aVar.f1462e;
                    bVar33.f1507o = j(typedArray, index, bVar33.f1507o);
                    break;
                case Build.API_LEVELS.API_36 /* 36 */:
                    b bVar34 = aVar.f1462e;
                    bVar34.f1505n = j(typedArray, index, bVar34.f1505n);
                    break;
                case 37:
                    b bVar35 = aVar.f1462e;
                    bVar35.f1521z = typedArray.getFloat(index, bVar35.f1521z);
                    break;
                case 38:
                    aVar.f1458a = typedArray.getResourceId(index, aVar.f1458a);
                    break;
                case 39:
                    b bVar36 = aVar.f1462e;
                    bVar36.W = typedArray.getFloat(index, bVar36.W);
                    break;
                case 40:
                    b bVar37 = aVar.f1462e;
                    bVar37.V = typedArray.getFloat(index, bVar37.V);
                    break;
                case 41:
                    b bVar38 = aVar.f1462e;
                    bVar38.X = typedArray.getInt(index, bVar38.X);
                    break;
                case 42:
                    b bVar39 = aVar.f1462e;
                    bVar39.Y = typedArray.getInt(index, bVar39.Y);
                    break;
                case 43:
                    C0019d c0019d3 = aVar.f1460c;
                    c0019d3.f1540d = typedArray.getFloat(index, c0019d3.f1540d);
                    break;
                case 44:
                    e eVar = aVar.f1463f;
                    eVar.f1555m = true;
                    eVar.f1556n = typedArray.getDimension(index, eVar.f1556n);
                    break;
                case 45:
                    e eVar2 = aVar.f1463f;
                    eVar2.f1545c = typedArray.getFloat(index, eVar2.f1545c);
                    break;
                case 46:
                    e eVar3 = aVar.f1463f;
                    eVar3.f1546d = typedArray.getFloat(index, eVar3.f1546d);
                    break;
                case 47:
                    e eVar4 = aVar.f1463f;
                    eVar4.f1547e = typedArray.getFloat(index, eVar4.f1547e);
                    break;
                case 48:
                    e eVar5 = aVar.f1463f;
                    eVar5.f1548f = typedArray.getFloat(index, eVar5.f1548f);
                    break;
                case PurchaseParamsValidator.MAX_NUMBER_OF_ADD_ON_PRODUCTS /* 49 */:
                    e eVar6 = aVar.f1463f;
                    eVar6.f1549g = typedArray.getDimension(index, eVar6.f1549g);
                    break;
                case EventsManager.EVENTS_TO_CLEAR_ON_LIMIT /* 50 */:
                    e eVar7 = aVar.f1463f;
                    eVar7.f1550h = typedArray.getDimension(index, eVar7.f1550h);
                    break;
                case 51:
                    e eVar8 = aVar.f1463f;
                    eVar8.f1552j = typedArray.getDimension(index, eVar8.f1552j);
                    break;
                case 52:
                    e eVar9 = aVar.f1463f;
                    eVar9.f1553k = typedArray.getDimension(index, eVar9.f1553k);
                    break;
                case 53:
                    e eVar10 = aVar.f1463f;
                    eVar10.f1554l = typedArray.getDimension(index, eVar10.f1554l);
                    break;
                case 54:
                    b bVar40 = aVar.f1462e;
                    bVar40.Z = typedArray.getInt(index, bVar40.Z);
                    break;
                case 55:
                    b bVar41 = aVar.f1462e;
                    bVar41.f1480a0 = typedArray.getInt(index, bVar41.f1480a0);
                    break;
                case 56:
                    b bVar42 = aVar.f1462e;
                    bVar42.f1482b0 = typedArray.getDimensionPixelSize(index, bVar42.f1482b0);
                    break;
                case 57:
                    b bVar43 = aVar.f1462e;
                    bVar43.f1484c0 = typedArray.getDimensionPixelSize(index, bVar43.f1484c0);
                    break;
                case 58:
                    b bVar44 = aVar.f1462e;
                    bVar44.f1486d0 = typedArray.getDimensionPixelSize(index, bVar44.f1486d0);
                    break;
                case 59:
                    b bVar45 = aVar.f1462e;
                    bVar45.f1488e0 = typedArray.getDimensionPixelSize(index, bVar45.f1488e0);
                    break;
                case 60:
                    e eVar11 = aVar.f1463f;
                    eVar11.f1544b = typedArray.getFloat(index, eVar11.f1544b);
                    break;
                case 61:
                    b bVar46 = aVar.f1462e;
                    bVar46.B = j(typedArray, index, bVar46.B);
                    break;
                case 62:
                    b bVar47 = aVar.f1462e;
                    bVar47.C = typedArray.getDimensionPixelSize(index, bVar47.C);
                    break;
                case 63:
                    b bVar48 = aVar.f1462e;
                    bVar48.D = typedArray.getFloat(index, bVar48.D);
                    break;
                case 64:
                    c cVar = aVar.f1461d;
                    cVar.f1524b = j(typedArray, index, cVar.f1524b);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        aVar.f1461d.f1526d = typedArray.getString(index);
                    } else {
                        aVar.f1461d.f1526d = a0.a.f5c[typedArray.getInteger(index, 0)];
                    }
                    break;
                case 66:
                    aVar.f1461d.f1528f = typedArray.getInt(index, 0);
                    break;
                case 67:
                    c cVar2 = aVar.f1461d;
                    cVar2.f1531i = typedArray.getFloat(index, cVar2.f1531i);
                    break;
                case 68:
                    C0019d c0019d4 = aVar.f1460c;
                    c0019d4.f1541e = typedArray.getFloat(index, c0019d4.f1541e);
                    break;
                case 69:
                    aVar.f1462e.f1490f0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    aVar.f1462e.f1492g0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    b bVar49 = aVar.f1462e;
                    bVar49.f1494h0 = typedArray.getInt(index, bVar49.f1494h0);
                    break;
                case 73:
                    b bVar50 = aVar.f1462e;
                    bVar50.f1496i0 = typedArray.getDimensionPixelSize(index, bVar50.f1496i0);
                    break;
                case 74:
                    aVar.f1462e.f1502l0 = typedArray.getString(index);
                    break;
                case 75:
                    b bVar51 = aVar.f1462e;
                    bVar51.f1510p0 = typedArray.getBoolean(index, bVar51.f1510p0);
                    break;
                case 76:
                    c cVar3 = aVar.f1461d;
                    cVar3.f1527e = typedArray.getInt(index, cVar3.f1527e);
                    break;
                case 77:
                    aVar.f1462e.f1504m0 = typedArray.getString(index);
                    break;
                case 78:
                    C0019d c0019d5 = aVar.f1460c;
                    c0019d5.f1539c = typedArray.getInt(index, c0019d5.f1539c);
                    break;
                case 79:
                    c cVar4 = aVar.f1461d;
                    cVar4.f1529g = typedArray.getFloat(index, cVar4.f1529g);
                    break;
                case 80:
                    b bVar52 = aVar.f1462e;
                    bVar52.f1506n0 = typedArray.getBoolean(index, bVar52.f1506n0);
                    break;
                case 81:
                    b bVar53 = aVar.f1462e;
                    bVar53.f1508o0 = typedArray.getBoolean(index, bVar53.f1508o0);
                    break;
                case 82:
                    c cVar5 = aVar.f1461d;
                    cVar5.f1525c = typedArray.getInteger(index, cVar5.f1525c);
                    break;
                case 83:
                    e eVar12 = aVar.f1463f;
                    eVar12.f1551i = j(typedArray, index, eVar12.f1551i);
                    break;
                case 84:
                    c cVar6 = aVar.f1461d;
                    cVar6.f1533k = typedArray.getInteger(index, cVar6.f1533k);
                    break;
                case 85:
                    c cVar7 = aVar.f1461d;
                    cVar7.f1532j = typedArray.getFloat(index, cVar7.f1532j);
                    break;
                case 86:
                    int i11 = typedArray.peekValue(index).type;
                    if (i11 == 1) {
                        aVar.f1461d.f1536n = typedArray.getResourceId(index, -1);
                        c cVar8 = aVar.f1461d;
                        if (cVar8.f1536n != -1) {
                            cVar8.f1535m = -2;
                        }
                    } else if (i11 == 3) {
                        aVar.f1461d.f1534l = typedArray.getString(index);
                        if (aVar.f1461d.f1534l.indexOf("/") > 0) {
                            aVar.f1461d.f1536n = typedArray.getResourceId(index, -1);
                            aVar.f1461d.f1535m = -2;
                        } else {
                            aVar.f1461d.f1535m = -1;
                        }
                    } else {
                        c cVar9 = aVar.f1461d;
                        cVar9.f1535m = typedArray.getInteger(index, cVar9.f1536n);
                    }
                    break;
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f1451g.get(index));
                    break;
                case 88:
                case 89:
                case 90:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f1451g.get(index));
                    break;
                case 91:
                    b bVar54 = aVar.f1462e;
                    bVar54.f1514s = j(typedArray, index, bVar54.f1514s);
                    break;
                case 92:
                    b bVar55 = aVar.f1462e;
                    bVar55.f1515t = j(typedArray, index, bVar55.f1515t);
                    break;
                case 93:
                    b bVar56 = aVar.f1462e;
                    bVar56.N = typedArray.getDimensionPixelSize(index, bVar56.N);
                    break;
                case 94:
                    b bVar57 = aVar.f1462e;
                    bVar57.U = typedArray.getDimensionPixelSize(index, bVar57.U);
                    break;
                case 95:
                    k(aVar.f1462e, typedArray, index, 0);
                    break;
                case 96:
                    k(aVar.f1462e, typedArray, index, 1);
                    break;
                case 97:
                    b bVar58 = aVar.f1462e;
                    bVar58.f1512q0 = typedArray.getInt(index, bVar58.f1512q0);
                    break;
            }
        }
        b bVar59 = aVar.f1462e;
        if (bVar59.f1502l0 != null) {
            bVar59.f1500k0 = null;
        }
    }
}
