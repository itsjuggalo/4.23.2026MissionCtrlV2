package androidx.constraintlayout.widget;

import D3.m;
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
import io.flutter.Build;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f10944f = {0, 4, 8};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static SparseIntArray f10945g = new SparseIntArray();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static SparseIntArray f10946h = new SparseIntArray();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10947a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10948b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap f10949c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10950d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashMap f10951e = new HashMap();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10952a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10953b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final C0178d f10954c = new C0178d();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c f10955d = new c();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final b f10956e = new b();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final e f10957f = new e();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public HashMap f10958g = new HashMap();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public C0177a f10959h;

        /* JADX INFO: renamed from: androidx.constraintlayout.widget.d$a$a, reason: collision with other inner class name */
        public static class C0177a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int[] f10960a = new int[10];

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int[] f10961b = new int[10];

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f10962c = 0;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int[] f10963d = new int[10];

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public float[] f10964e = new float[10];

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public int f10965f = 0;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int[] f10966g = new int[5];

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public String[] f10967h = new String[5];

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public int f10968i = 0;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int[] f10969j = new int[4];

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public boolean[] f10970k = new boolean[4];

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public int f10971l = 0;

            public void a(int i8, float f8) {
                int i9 = this.f10965f;
                int[] iArr = this.f10963d;
                if (i9 >= iArr.length) {
                    this.f10963d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.f10964e;
                    this.f10964e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.f10963d;
                int i10 = this.f10965f;
                iArr2[i10] = i8;
                float[] fArr2 = this.f10964e;
                this.f10965f = i10 + 1;
                fArr2[i10] = f8;
            }

            public void b(int i8, int i9) {
                int i10 = this.f10962c;
                int[] iArr = this.f10960a;
                if (i10 >= iArr.length) {
                    this.f10960a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.f10961b;
                    this.f10961b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f10960a;
                int i11 = this.f10962c;
                iArr3[i11] = i8;
                int[] iArr4 = this.f10961b;
                this.f10962c = i11 + 1;
                iArr4[i11] = i9;
            }

            public void c(int i8, String str) {
                int i9 = this.f10968i;
                int[] iArr = this.f10966g;
                if (i9 >= iArr.length) {
                    this.f10966g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.f10967h;
                    this.f10967h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.f10966g;
                int i10 = this.f10968i;
                iArr2[i10] = i8;
                String[] strArr2 = this.f10967h;
                this.f10968i = i10 + 1;
                strArr2[i10] = str;
            }

            public void d(int i8, boolean z7) {
                int i9 = this.f10971l;
                int[] iArr = this.f10969j;
                if (i9 >= iArr.length) {
                    this.f10969j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.f10970k;
                    this.f10970k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.f10969j;
                int i10 = this.f10971l;
                iArr2[i10] = i8;
                boolean[] zArr2 = this.f10970k;
                this.f10971l = i10 + 1;
                zArr2[i10] = z7;
            }
        }

        public void b(ConstraintLayout.b bVar) {
            b bVar2 = this.f10956e;
            bVar.f10864e = bVar2.f11017j;
            bVar.f10866f = bVar2.f11019k;
            bVar.f10868g = bVar2.f11021l;
            bVar.f10870h = bVar2.f11023m;
            bVar.f10872i = bVar2.f11025n;
            bVar.f10874j = bVar2.f11027o;
            bVar.f10876k = bVar2.f11029p;
            bVar.f10878l = bVar2.f11031q;
            bVar.f10880m = bVar2.f11033r;
            bVar.f10882n = bVar2.f11034s;
            bVar.f10884o = bVar2.f11035t;
            bVar.f10892s = bVar2.f11036u;
            bVar.f10894t = bVar2.f11037v;
            bVar.f10896u = bVar2.f11038w;
            bVar.f10898v = bVar2.f11039x;
            ((ViewGroup.MarginLayoutParams) bVar).leftMargin = bVar2.f10980H;
            ((ViewGroup.MarginLayoutParams) bVar).rightMargin = bVar2.f10981I;
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = bVar2.f10982J;
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = bVar2.f10983K;
            bVar.f10830A = bVar2.f10992T;
            bVar.f10831B = bVar2.f10991S;
            bVar.f10902x = bVar2.f10988P;
            bVar.f10904z = bVar2.f10990R;
            bVar.f10836G = bVar2.f11040y;
            bVar.f10837H = bVar2.f11041z;
            bVar.f10886p = bVar2.f10974B;
            bVar.f10888q = bVar2.f10975C;
            bVar.f10890r = bVar2.f10976D;
            bVar.f10838I = bVar2.f10973A;
            bVar.f10853X = bVar2.f10977E;
            bVar.f10854Y = bVar2.f10978F;
            bVar.f10842M = bVar2.f10994V;
            bVar.f10841L = bVar2.f10995W;
            bVar.f10844O = bVar2.f10997Y;
            bVar.f10843N = bVar2.f10996X;
            bVar.f10857a0 = bVar2.f11026n0;
            bVar.f10859b0 = bVar2.f11028o0;
            bVar.f10845P = bVar2.f10998Z;
            bVar.f10846Q = bVar2.f11000a0;
            bVar.f10849T = bVar2.f11002b0;
            bVar.f10850U = bVar2.f11004c0;
            bVar.f10847R = bVar2.f11006d0;
            bVar.f10848S = bVar2.f11008e0;
            bVar.f10851V = bVar2.f11010f0;
            bVar.f10852W = bVar2.f11012g0;
            bVar.f10855Z = bVar2.f10979G;
            bVar.f10860c = bVar2.f11013h;
            bVar.f10856a = bVar2.f11009f;
            bVar.f10858b = bVar2.f11011g;
            ((ViewGroup.MarginLayoutParams) bVar).width = bVar2.f11005d;
            ((ViewGroup.MarginLayoutParams) bVar).height = bVar2.f11007e;
            String str = bVar2.f11024m0;
            if (str != null) {
                bVar.f10861c0 = str;
            }
            bVar.f10863d0 = bVar2.f11032q0;
            bVar.setMarginStart(bVar2.f10985M);
            bVar.setMarginEnd(this.f10956e.f10984L);
            bVar.a();
        }

        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = new a();
            aVar.f10956e.a(this.f10956e);
            aVar.f10955d.a(this.f10955d);
            aVar.f10954c.a(this.f10954c);
            aVar.f10957f.a(this.f10957f);
            aVar.f10952a = this.f10952a;
            aVar.f10959h = this.f10959h;
            return aVar;
        }

        public final void d(int i8, ConstraintLayout.b bVar) {
            this.f10952a = i8;
            b bVar2 = this.f10956e;
            bVar2.f11017j = bVar.f10864e;
            bVar2.f11019k = bVar.f10866f;
            bVar2.f11021l = bVar.f10868g;
            bVar2.f11023m = bVar.f10870h;
            bVar2.f11025n = bVar.f10872i;
            bVar2.f11027o = bVar.f10874j;
            bVar2.f11029p = bVar.f10876k;
            bVar2.f11031q = bVar.f10878l;
            bVar2.f11033r = bVar.f10880m;
            bVar2.f11034s = bVar.f10882n;
            bVar2.f11035t = bVar.f10884o;
            bVar2.f11036u = bVar.f10892s;
            bVar2.f11037v = bVar.f10894t;
            bVar2.f11038w = bVar.f10896u;
            bVar2.f11039x = bVar.f10898v;
            bVar2.f11040y = bVar.f10836G;
            bVar2.f11041z = bVar.f10837H;
            bVar2.f10973A = bVar.f10838I;
            bVar2.f10974B = bVar.f10886p;
            bVar2.f10975C = bVar.f10888q;
            bVar2.f10976D = bVar.f10890r;
            bVar2.f10977E = bVar.f10853X;
            bVar2.f10978F = bVar.f10854Y;
            bVar2.f10979G = bVar.f10855Z;
            bVar2.f11013h = bVar.f10860c;
            bVar2.f11009f = bVar.f10856a;
            bVar2.f11011g = bVar.f10858b;
            bVar2.f11005d = ((ViewGroup.MarginLayoutParams) bVar).width;
            bVar2.f11007e = ((ViewGroup.MarginLayoutParams) bVar).height;
            bVar2.f10980H = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
            bVar2.f10981I = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
            bVar2.f10982J = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            bVar2.f10983K = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
            bVar2.f10986N = bVar.f10833D;
            bVar2.f10994V = bVar.f10842M;
            bVar2.f10995W = bVar.f10841L;
            bVar2.f10997Y = bVar.f10844O;
            bVar2.f10996X = bVar.f10843N;
            bVar2.f11026n0 = bVar.f10857a0;
            bVar2.f11028o0 = bVar.f10859b0;
            bVar2.f10998Z = bVar.f10845P;
            bVar2.f11000a0 = bVar.f10846Q;
            bVar2.f11002b0 = bVar.f10849T;
            bVar2.f11004c0 = bVar.f10850U;
            bVar2.f11006d0 = bVar.f10847R;
            bVar2.f11008e0 = bVar.f10848S;
            bVar2.f11010f0 = bVar.f10851V;
            bVar2.f11012g0 = bVar.f10852W;
            bVar2.f11024m0 = bVar.f10861c0;
            bVar2.f10988P = bVar.f10902x;
            bVar2.f10990R = bVar.f10904z;
            bVar2.f10987O = bVar.f10900w;
            bVar2.f10989Q = bVar.f10903y;
            bVar2.f10992T = bVar.f10830A;
            bVar2.f10991S = bVar.f10831B;
            bVar2.f10993U = bVar.f10832C;
            bVar2.f11032q0 = bVar.f10863d0;
            bVar2.f10984L = bVar.getMarginEnd();
            this.f10956e.f10985M = bVar.getMarginStart();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        public static SparseIntArray f10972r0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f11005d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f11007e;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public int[] f11020k0;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public String f11022l0;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public String f11024m0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f10999a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f11001b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f11003c = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f11009f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f11011g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f11013h = -1.0f;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f11015i = true;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f11017j = -1;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f11019k = -1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f11021l = -1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f11023m = -1;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f11025n = -1;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f11027o = -1;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f11029p = -1;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f11031q = -1;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f11033r = -1;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f11034s = -1;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f11035t = -1;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f11036u = -1;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f11037v = -1;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f11038w = -1;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f11039x = -1;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public float f11040y = 0.5f;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public float f11041z = 0.5f;

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        public String f10973A = null;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        public int f10974B = -1;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        public int f10975C = 0;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        public float f10976D = 0.0f;

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        public int f10977E = -1;

        /* JADX INFO: renamed from: F, reason: collision with root package name */
        public int f10978F = -1;

        /* JADX INFO: renamed from: G, reason: collision with root package name */
        public int f10979G = -1;

        /* JADX INFO: renamed from: H, reason: collision with root package name */
        public int f10980H = 0;

        /* JADX INFO: renamed from: I, reason: collision with root package name */
        public int f10981I = 0;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public int f10982J = 0;

        /* JADX INFO: renamed from: K, reason: collision with root package name */
        public int f10983K = 0;

        /* JADX INFO: renamed from: L, reason: collision with root package name */
        public int f10984L = 0;

        /* JADX INFO: renamed from: M, reason: collision with root package name */
        public int f10985M = 0;

        /* JADX INFO: renamed from: N, reason: collision with root package name */
        public int f10986N = 0;

        /* JADX INFO: renamed from: O, reason: collision with root package name */
        public int f10987O = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: P, reason: collision with root package name */
        public int f10988P = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: Q, reason: collision with root package name */
        public int f10989Q = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: R, reason: collision with root package name */
        public int f10990R = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: S, reason: collision with root package name */
        public int f10991S = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: T, reason: collision with root package name */
        public int f10992T = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: U, reason: collision with root package name */
        public int f10993U = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: V, reason: collision with root package name */
        public float f10994V = -1.0f;

        /* JADX INFO: renamed from: W, reason: collision with root package name */
        public float f10995W = -1.0f;

        /* JADX INFO: renamed from: X, reason: collision with root package name */
        public int f10996X = 0;

        /* JADX INFO: renamed from: Y, reason: collision with root package name */
        public int f10997Y = 0;

        /* JADX INFO: renamed from: Z, reason: collision with root package name */
        public int f10998Z = 0;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public int f11000a0 = 0;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public int f11002b0 = 0;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public int f11004c0 = 0;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public int f11006d0 = 0;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public int f11008e0 = 0;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public float f11010f0 = 1.0f;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public float f11012g0 = 1.0f;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public int f11014h0 = -1;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public int f11016i0 = 0;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public int f11018j0 = -1;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public boolean f11026n0 = false;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public boolean f11028o0 = false;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public boolean f11030p0 = true;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public int f11032q0 = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f10972r0 = sparseIntArray;
            sparseIntArray.append(F.d.f1470w5, 24);
            f10972r0.append(F.d.f1478x5, 25);
            f10972r0.append(F.d.f1494z5, 28);
            f10972r0.append(F.d.f1073A5, 29);
            f10972r0.append(F.d.f1113F5, 35);
            f10972r0.append(F.d.f1105E5, 34);
            f10972r0.append(F.d.f1335g5, 4);
            f10972r0.append(F.d.f1326f5, 3);
            f10972r0.append(F.d.f1308d5, 1);
            f10972r0.append(F.d.f1161L5, 6);
            f10972r0.append(F.d.f1169M5, 7);
            f10972r0.append(F.d.f1398n5, 17);
            f10972r0.append(F.d.f1406o5, 18);
            f10972r0.append(F.d.f1414p5, 19);
            f10972r0.append(F.d.f1272Z4, 90);
            f10972r0.append(F.d.f1160L4, 26);
            f10972r0.append(F.d.f1081B5, 31);
            f10972r0.append(F.d.f1089C5, 32);
            f10972r0.append(F.d.f1389m5, 10);
            f10972r0.append(F.d.f1380l5, 9);
            f10972r0.append(F.d.f1193P5, 13);
            f10972r0.append(F.d.f1217S5, 16);
            f10972r0.append(F.d.f1201Q5, 14);
            f10972r0.append(F.d.f1177N5, 11);
            f10972r0.append(F.d.f1209R5, 15);
            f10972r0.append(F.d.f1185O5, 12);
            f10972r0.append(F.d.f1137I5, 38);
            f10972r0.append(F.d.f1454u5, 37);
            f10972r0.append(F.d.f1446t5, 39);
            f10972r0.append(F.d.f1129H5, 40);
            f10972r0.append(F.d.f1438s5, 20);
            f10972r0.append(F.d.f1121G5, 36);
            f10972r0.append(F.d.f1371k5, 5);
            f10972r0.append(F.d.f1462v5, 91);
            f10972r0.append(F.d.f1097D5, 91);
            f10972r0.append(F.d.f1486y5, 91);
            f10972r0.append(F.d.f1317e5, 91);
            f10972r0.append(F.d.f1299c5, 91);
            f10972r0.append(F.d.f1184O4, 23);
            f10972r0.append(F.d.f1200Q4, 27);
            f10972r0.append(F.d.f1216S4, 30);
            f10972r0.append(F.d.f1224T4, 8);
            f10972r0.append(F.d.f1192P4, 33);
            f10972r0.append(F.d.f1208R4, 2);
            f10972r0.append(F.d.f1168M4, 22);
            f10972r0.append(F.d.f1176N4, 21);
            f10972r0.append(F.d.f1145J5, 41);
            f10972r0.append(F.d.f1422q5, 42);
            f10972r0.append(F.d.f1290b5, 41);
            f10972r0.append(F.d.f1281a5, 42);
            f10972r0.append(F.d.f1225T5, 76);
            f10972r0.append(F.d.f1344h5, 61);
            f10972r0.append(F.d.f1362j5, 62);
            f10972r0.append(F.d.f1353i5, 63);
            f10972r0.append(F.d.f1153K5, 69);
            f10972r0.append(F.d.f1430r5, 70);
            f10972r0.append(F.d.f1256X4, 71);
            f10972r0.append(F.d.f1240V4, 72);
            f10972r0.append(F.d.f1248W4, 73);
            f10972r0.append(F.d.f1264Y4, 74);
            f10972r0.append(F.d.f1232U4, 75);
        }

        public void a(b bVar) {
            this.f10999a = bVar.f10999a;
            this.f11005d = bVar.f11005d;
            this.f11001b = bVar.f11001b;
            this.f11007e = bVar.f11007e;
            this.f11009f = bVar.f11009f;
            this.f11011g = bVar.f11011g;
            this.f11013h = bVar.f11013h;
            this.f11015i = bVar.f11015i;
            this.f11017j = bVar.f11017j;
            this.f11019k = bVar.f11019k;
            this.f11021l = bVar.f11021l;
            this.f11023m = bVar.f11023m;
            this.f11025n = bVar.f11025n;
            this.f11027o = bVar.f11027o;
            this.f11029p = bVar.f11029p;
            this.f11031q = bVar.f11031q;
            this.f11033r = bVar.f11033r;
            this.f11034s = bVar.f11034s;
            this.f11035t = bVar.f11035t;
            this.f11036u = bVar.f11036u;
            this.f11037v = bVar.f11037v;
            this.f11038w = bVar.f11038w;
            this.f11039x = bVar.f11039x;
            this.f11040y = bVar.f11040y;
            this.f11041z = bVar.f11041z;
            this.f10973A = bVar.f10973A;
            this.f10974B = bVar.f10974B;
            this.f10975C = bVar.f10975C;
            this.f10976D = bVar.f10976D;
            this.f10977E = bVar.f10977E;
            this.f10978F = bVar.f10978F;
            this.f10979G = bVar.f10979G;
            this.f10980H = bVar.f10980H;
            this.f10981I = bVar.f10981I;
            this.f10982J = bVar.f10982J;
            this.f10983K = bVar.f10983K;
            this.f10984L = bVar.f10984L;
            this.f10985M = bVar.f10985M;
            this.f10986N = bVar.f10986N;
            this.f10987O = bVar.f10987O;
            this.f10988P = bVar.f10988P;
            this.f10989Q = bVar.f10989Q;
            this.f10990R = bVar.f10990R;
            this.f10991S = bVar.f10991S;
            this.f10992T = bVar.f10992T;
            this.f10993U = bVar.f10993U;
            this.f10994V = bVar.f10994V;
            this.f10995W = bVar.f10995W;
            this.f10996X = bVar.f10996X;
            this.f10997Y = bVar.f10997Y;
            this.f10998Z = bVar.f10998Z;
            this.f11000a0 = bVar.f11000a0;
            this.f11002b0 = bVar.f11002b0;
            this.f11004c0 = bVar.f11004c0;
            this.f11006d0 = bVar.f11006d0;
            this.f11008e0 = bVar.f11008e0;
            this.f11010f0 = bVar.f11010f0;
            this.f11012g0 = bVar.f11012g0;
            this.f11014h0 = bVar.f11014h0;
            this.f11016i0 = bVar.f11016i0;
            this.f11018j0 = bVar.f11018j0;
            this.f11024m0 = bVar.f11024m0;
            int[] iArr = bVar.f11020k0;
            if (iArr == null || bVar.f11022l0 != null) {
                this.f11020k0 = null;
            } else {
                this.f11020k0 = Arrays.copyOf(iArr, iArr.length);
            }
            this.f11022l0 = bVar.f11022l0;
            this.f11026n0 = bVar.f11026n0;
            this.f11028o0 = bVar.f11028o0;
            this.f11030p0 = bVar.f11030p0;
            this.f11032q0 = bVar.f11032q0;
        }

        public void b(Context context, AttributeSet attributeSet) {
            StringBuilder sb;
            String str;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, F.d.f1152K4);
            this.f11001b = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i8);
                int i9 = f10972r0.get(index);
                switch (i9) {
                    case 1:
                        this.f11033r = d.j(typedArrayObtainStyledAttributes, index, this.f11033r);
                        break;
                    case 2:
                        this.f10983K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f10983K);
                        break;
                    case 3:
                        this.f11031q = d.j(typedArrayObtainStyledAttributes, index, this.f11031q);
                        break;
                    case 4:
                        this.f11029p = d.j(typedArrayObtainStyledAttributes, index, this.f11029p);
                        break;
                    case 5:
                        this.f10973A = typedArrayObtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.f10977E = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f10977E);
                        break;
                    case 7:
                        this.f10978F = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f10978F);
                        break;
                    case 8:
                        this.f10984L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f10984L);
                        break;
                    case 9:
                        this.f11039x = d.j(typedArrayObtainStyledAttributes, index, this.f11039x);
                        break;
                    case 10:
                        this.f11038w = d.j(typedArrayObtainStyledAttributes, index, this.f11038w);
                        break;
                    case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                        this.f10990R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f10990R);
                        break;
                    case 12:
                        this.f10991S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f10991S);
                        break;
                    case 13:
                        this.f10987O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f10987O);
                        break;
                    case 14:
                        this.f10989Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f10989Q);
                        break;
                    case 15:
                        this.f10992T = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f10992T);
                        break;
                    case com.amazon.c.a.a.c.f14230g /* 16 */:
                        this.f10988P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f10988P);
                        break;
                    case 17:
                        this.f11009f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f11009f);
                        break;
                    case 18:
                        this.f11011g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f11011g);
                        break;
                    case 19:
                        this.f11013h = typedArrayObtainStyledAttributes.getFloat(index, this.f11013h);
                        break;
                    case 20:
                        this.f11040y = typedArrayObtainStyledAttributes.getFloat(index, this.f11040y);
                        break;
                    case 21:
                        this.f11007e = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f11007e);
                        break;
                    case Build.API_LEVELS.API_22 /* 22 */:
                        this.f11005d = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f11005d);
                        break;
                    case Build.API_LEVELS.API_23 /* 23 */:
                        this.f10980H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f10980H);
                        break;
                    case Build.API_LEVELS.API_24 /* 24 */:
                        this.f11017j = d.j(typedArrayObtainStyledAttributes, index, this.f11017j);
                        break;
                    case Build.API_LEVELS.API_25 /* 25 */:
                        this.f11019k = d.j(typedArrayObtainStyledAttributes, index, this.f11019k);
                        break;
                    case Build.API_LEVELS.API_26 /* 26 */:
                        this.f10979G = typedArrayObtainStyledAttributes.getInt(index, this.f10979G);
                        break;
                    case Build.API_LEVELS.API_27 /* 27 */:
                        this.f10981I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f10981I);
                        break;
                    case Build.API_LEVELS.API_28 /* 28 */:
                        this.f11021l = d.j(typedArrayObtainStyledAttributes, index, this.f11021l);
                        break;
                    case Build.API_LEVELS.API_29 /* 29 */:
                        this.f11023m = d.j(typedArrayObtainStyledAttributes, index, this.f11023m);
                        break;
                    case Build.API_LEVELS.API_30 /* 30 */:
                        this.f10985M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f10985M);
                        break;
                    case Build.API_LEVELS.API_31 /* 31 */:
                        this.f11036u = d.j(typedArrayObtainStyledAttributes, index, this.f11036u);
                        break;
                    case 32:
                        this.f11037v = d.j(typedArrayObtainStyledAttributes, index, this.f11037v);
                        break;
                    case Build.API_LEVELS.API_33 /* 33 */:
                        this.f10982J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f10982J);
                        break;
                    case Build.API_LEVELS.API_34 /* 34 */:
                        this.f11027o = d.j(typedArrayObtainStyledAttributes, index, this.f11027o);
                        break;
                    case Build.API_LEVELS.API_35 /* 35 */:
                        this.f11025n = d.j(typedArrayObtainStyledAttributes, index, this.f11025n);
                        break;
                    case Build.API_LEVELS.API_36 /* 36 */:
                        this.f11041z = typedArrayObtainStyledAttributes.getFloat(index, this.f11041z);
                        break;
                    case 37:
                        this.f10995W = typedArrayObtainStyledAttributes.getFloat(index, this.f10995W);
                        break;
                    case 38:
                        this.f10994V = typedArrayObtainStyledAttributes.getFloat(index, this.f10994V);
                        break;
                    case 39:
                        this.f10996X = typedArrayObtainStyledAttributes.getInt(index, this.f10996X);
                        break;
                    case 40:
                        this.f10997Y = typedArrayObtainStyledAttributes.getInt(index, this.f10997Y);
                        break;
                    case 41:
                        d.k(this, typedArrayObtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        d.k(this, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i9) {
                            case 61:
                                this.f10974B = d.j(typedArrayObtainStyledAttributes, index, this.f10974B);
                                break;
                            case 62:
                                this.f10975C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f10975C);
                                break;
                            case 63:
                                this.f10976D = typedArrayObtainStyledAttributes.getFloat(index, this.f10976D);
                                break;
                            default:
                                switch (i9) {
                                    case 69:
                                        this.f11010f0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        continue;
                                    case 70:
                                        this.f11012g0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        continue;
                                    case 71:
                                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                        continue;
                                    case 72:
                                        this.f11014h0 = typedArrayObtainStyledAttributes.getInt(index, this.f11014h0);
                                        continue;
                                    case 73:
                                        this.f11016i0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11016i0);
                                        continue;
                                    case 74:
                                        this.f11022l0 = typedArrayObtainStyledAttributes.getString(index);
                                        continue;
                                    case 75:
                                        this.f11030p0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f11030p0);
                                        continue;
                                    case 76:
                                        this.f11032q0 = typedArrayObtainStyledAttributes.getInt(index, this.f11032q0);
                                        continue;
                                    case 77:
                                        this.f11034s = d.j(typedArrayObtainStyledAttributes, index, this.f11034s);
                                        continue;
                                    case 78:
                                        this.f11035t = d.j(typedArrayObtainStyledAttributes, index, this.f11035t);
                                        continue;
                                    case 79:
                                        this.f10993U = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f10993U);
                                        continue;
                                    case 80:
                                        this.f10986N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f10986N);
                                        continue;
                                    case 81:
                                        this.f10998Z = typedArrayObtainStyledAttributes.getInt(index, this.f10998Z);
                                        continue;
                                    case 82:
                                        this.f11000a0 = typedArrayObtainStyledAttributes.getInt(index, this.f11000a0);
                                        continue;
                                    case 83:
                                        this.f11004c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11004c0);
                                        continue;
                                    case 84:
                                        this.f11002b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11002b0);
                                        continue;
                                    case 85:
                                        this.f11008e0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11008e0);
                                        continue;
                                    case 86:
                                        this.f11006d0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11006d0);
                                        continue;
                                    case 87:
                                        this.f11026n0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f11026n0);
                                        continue;
                                    case 88:
                                        this.f11028o0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f11028o0);
                                        continue;
                                    case 89:
                                        this.f11024m0 = typedArrayObtainStyledAttributes.getString(index);
                                        continue;
                                    case 90:
                                        this.f11015i = typedArrayObtainStyledAttributes.getBoolean(index, this.f11015i);
                                        continue;
                                    case 91:
                                        sb = new StringBuilder();
                                        str = "unused attribute 0x";
                                        break;
                                    default:
                                        sb = new StringBuilder();
                                        str = "Unknown attribute 0x";
                                        break;
                                }
                                sb.append(str);
                                sb.append(Integer.toHexString(index));
                                sb.append("   ");
                                sb.append(f10972r0.get(index));
                                Log.w("ConstraintSet", sb.toString());
                                break;
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class c {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static SparseIntArray f11042o;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f11043a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f11044b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f11045c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f11046d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f11047e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f11048f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f11049g = Float.NaN;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f11050h = -1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f11051i = Float.NaN;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f11052j = Float.NaN;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f11053k = -1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f11054l = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f11055m = -3;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f11056n = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f11042o = sparseIntArray;
            sparseIntArray.append(F.d.f1327f6, 1);
            f11042o.append(F.d.f1345h6, 2);
            f11042o.append(F.d.f1381l6, 3);
            f11042o.append(F.d.f1318e6, 4);
            f11042o.append(F.d.f1309d6, 5);
            f11042o.append(F.d.f1300c6, 6);
            f11042o.append(F.d.f1336g6, 7);
            f11042o.append(F.d.f1372k6, 8);
            f11042o.append(F.d.f1363j6, 9);
            f11042o.append(F.d.f1354i6, 10);
        }

        public void a(c cVar) {
            this.f11043a = cVar.f11043a;
            this.f11044b = cVar.f11044b;
            this.f11046d = cVar.f11046d;
            this.f11047e = cVar.f11047e;
            this.f11048f = cVar.f11048f;
            this.f11051i = cVar.f11051i;
            this.f11049g = cVar.f11049g;
            this.f11050h = cVar.f11050h;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, F.d.f1291b6);
            this.f11043a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i8);
                switch (f11042o.get(index)) {
                    case 1:
                        this.f11051i = typedArrayObtainStyledAttributes.getFloat(index, this.f11051i);
                        break;
                    case 2:
                        this.f11047e = typedArrayObtainStyledAttributes.getInt(index, this.f11047e);
                        break;
                    case 3:
                        this.f11046d = typedArrayObtainStyledAttributes.peekValue(index).type == 3 ? typedArrayObtainStyledAttributes.getString(index) : A.a.f4c[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                        break;
                    case 4:
                        this.f11048f = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f11044b = d.j(typedArrayObtainStyledAttributes, index, this.f11044b);
                        break;
                    case 6:
                        this.f11045c = typedArrayObtainStyledAttributes.getInteger(index, this.f11045c);
                        break;
                    case 7:
                        this.f11049g = typedArrayObtainStyledAttributes.getFloat(index, this.f11049g);
                        break;
                    case 8:
                        this.f11053k = typedArrayObtainStyledAttributes.getInteger(index, this.f11053k);
                        break;
                    case 9:
                        this.f11052j = typedArrayObtainStyledAttributes.getFloat(index, this.f11052j);
                        break;
                    case 10:
                        int i9 = typedArrayObtainStyledAttributes.peekValue(index).type;
                        if (i9 == 1) {
                            int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            this.f11056n = resourceId;
                            if (resourceId != -1) {
                                this.f11055m = -2;
                            }
                        } else if (i9 == 3) {
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            this.f11054l = string;
                            if (string.indexOf("/") > 0) {
                                this.f11056n = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                this.f11055m = -2;
                            } else {
                                this.f11055m = -1;
                            }
                        } else {
                            this.f11055m = typedArrayObtainStyledAttributes.getInteger(index, this.f11056n);
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.d$d, reason: collision with other inner class name */
    public static class C0178d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f11057a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f11058b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f11059c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f11060d = 1.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f11061e = Float.NaN;

        public void a(C0178d c0178d) {
            this.f11057a = c0178d.f11057a;
            this.f11058b = c0178d.f11058b;
            this.f11060d = c0178d.f11060d;
            this.f11061e = c0178d.f11061e;
            this.f11059c = c0178d.f11059c;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, F.d.f1471w6);
            this.f11057a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i8);
                if (index == F.d.f1487y6) {
                    this.f11060d = typedArrayObtainStyledAttributes.getFloat(index, this.f11060d);
                } else if (index == F.d.f1479x6) {
                    this.f11058b = typedArrayObtainStyledAttributes.getInt(index, this.f11058b);
                    this.f11058b = d.f10944f[this.f11058b];
                } else if (index == F.d.f1074A6) {
                    this.f11059c = typedArrayObtainStyledAttributes.getInt(index, this.f11059c);
                } else if (index == F.d.f1495z6) {
                    this.f11061e = typedArrayObtainStyledAttributes.getFloat(index, this.f11061e);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class e {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static SparseIntArray f11062o;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f11063a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f11064b = 0.0f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f11065c = 0.0f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f11066d = 0.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f11067e = 1.0f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f11068f = 1.0f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f11069g = Float.NaN;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f11070h = Float.NaN;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f11071i = -1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f11072j = 0.0f;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f11073k = 0.0f;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f11074l = 0.0f;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f11075m = false;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f11076n = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f11062o = sparseIntArray;
            sparseIntArray.append(F.d.f1242V6, 1);
            f11062o.append(F.d.f1250W6, 2);
            f11062o.append(F.d.f1258X6, 3);
            f11062o.append(F.d.f1226T6, 4);
            f11062o.append(F.d.f1234U6, 5);
            f11062o.append(F.d.f1194P6, 6);
            f11062o.append(F.d.f1202Q6, 7);
            f11062o.append(F.d.f1210R6, 8);
            f11062o.append(F.d.f1218S6, 9);
            f11062o.append(F.d.f1266Y6, 10);
            f11062o.append(F.d.f1274Z6, 11);
            f11062o.append(F.d.f1283a7, 12);
        }

        public void a(e eVar) {
            this.f11063a = eVar.f11063a;
            this.f11064b = eVar.f11064b;
            this.f11065c = eVar.f11065c;
            this.f11066d = eVar.f11066d;
            this.f11067e = eVar.f11067e;
            this.f11068f = eVar.f11068f;
            this.f11069g = eVar.f11069g;
            this.f11070h = eVar.f11070h;
            this.f11071i = eVar.f11071i;
            this.f11072j = eVar.f11072j;
            this.f11073k = eVar.f11073k;
            this.f11074l = eVar.f11074l;
            this.f11075m = eVar.f11075m;
            this.f11076n = eVar.f11076n;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, F.d.f1186O6);
            this.f11063a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i8);
                switch (f11062o.get(index)) {
                    case 1:
                        this.f11064b = typedArrayObtainStyledAttributes.getFloat(index, this.f11064b);
                        break;
                    case 2:
                        this.f11065c = typedArrayObtainStyledAttributes.getFloat(index, this.f11065c);
                        break;
                    case 3:
                        this.f11066d = typedArrayObtainStyledAttributes.getFloat(index, this.f11066d);
                        break;
                    case 4:
                        this.f11067e = typedArrayObtainStyledAttributes.getFloat(index, this.f11067e);
                        break;
                    case 5:
                        this.f11068f = typedArrayObtainStyledAttributes.getFloat(index, this.f11068f);
                        break;
                    case 6:
                        this.f11069g = typedArrayObtainStyledAttributes.getDimension(index, this.f11069g);
                        break;
                    case 7:
                        this.f11070h = typedArrayObtainStyledAttributes.getDimension(index, this.f11070h);
                        break;
                    case 8:
                        this.f11072j = typedArrayObtainStyledAttributes.getDimension(index, this.f11072j);
                        break;
                    case 9:
                        this.f11073k = typedArrayObtainStyledAttributes.getDimension(index, this.f11073k);
                        break;
                    case 10:
                        this.f11074l = typedArrayObtainStyledAttributes.getDimension(index, this.f11074l);
                        break;
                    case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                        this.f11075m = true;
                        this.f11076n = typedArrayObtainStyledAttributes.getDimension(index, this.f11076n);
                        break;
                    case 12:
                        this.f11071i = d.j(typedArrayObtainStyledAttributes, index, this.f11071i);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static {
        f10945g.append(F.d.f1068A0, 25);
        f10945g.append(F.d.f1076B0, 26);
        f10945g.append(F.d.f1092D0, 29);
        f10945g.append(F.d.f1100E0, 30);
        f10945g.append(F.d.f1148K0, 36);
        f10945g.append(F.d.f1140J0, 35);
        f10945g.append(F.d.f1339h0, 4);
        f10945g.append(F.d.f1330g0, 3);
        f10945g.append(F.d.f1294c0, 1);
        f10945g.append(F.d.f1312e0, 91);
        f10945g.append(F.d.f1303d0, 92);
        f10945g.append(F.d.f1220T0, 6);
        f10945g.append(F.d.f1228U0, 7);
        f10945g.append(F.d.f1401o0, 17);
        f10945g.append(F.d.f1409p0, 18);
        f10945g.append(F.d.f1417q0, 19);
        f10945g.append(F.d.f1259Y, 99);
        f10945g.append(F.d.f1448u, 27);
        f10945g.append(F.d.f1108F0, 32);
        f10945g.append(F.d.f1116G0, 33);
        f10945g.append(F.d.f1393n0, 10);
        f10945g.append(F.d.f1384m0, 9);
        f10945g.append(F.d.f1252X0, 13);
        f10945g.append(F.d.f1277a1, 16);
        f10945g.append(F.d.f1260Y0, 14);
        f10945g.append(F.d.f1236V0, 11);
        f10945g.append(F.d.f1268Z0, 15);
        f10945g.append(F.d.f1244W0, 12);
        f10945g.append(F.d.f1172N0, 40);
        f10945g.append(F.d.f1481y0, 39);
        f10945g.append(F.d.f1473x0, 41);
        f10945g.append(F.d.f1164M0, 42);
        f10945g.append(F.d.f1465w0, 20);
        f10945g.append(F.d.f1156L0, 37);
        f10945g.append(F.d.f1375l0, 5);
        f10945g.append(F.d.f1489z0, 87);
        f10945g.append(F.d.f1132I0, 87);
        f10945g.append(F.d.f1084C0, 87);
        f10945g.append(F.d.f1321f0, 87);
        f10945g.append(F.d.f1285b0, 87);
        f10945g.append(F.d.f1488z, 24);
        f10945g.append(F.d.f1075B, 28);
        f10945g.append(F.d.f1171N, 31);
        f10945g.append(F.d.f1179O, 8);
        f10945g.append(F.d.f1067A, 34);
        f10945g.append(F.d.f1083C, 2);
        f10945g.append(F.d.f1472x, 23);
        f10945g.append(F.d.f1480y, 21);
        f10945g.append(F.d.f1180O0, 95);
        f10945g.append(F.d.f1425r0, 96);
        f10945g.append(F.d.f1464w, 22);
        f10945g.append(F.d.f1091D, 43);
        f10945g.append(F.d.f1195Q, 44);
        f10945g.append(F.d.f1155L, 45);
        f10945g.append(F.d.f1163M, 46);
        f10945g.append(F.d.f1147K, 60);
        f10945g.append(F.d.f1131I, 47);
        f10945g.append(F.d.f1139J, 48);
        f10945g.append(F.d.f1099E, 49);
        f10945g.append(F.d.f1107F, 50);
        f10945g.append(F.d.f1115G, 51);
        f10945g.append(F.d.f1123H, 52);
        f10945g.append(F.d.f1187P, 53);
        f10945g.append(F.d.f1188P0, 54);
        f10945g.append(F.d.f1433s0, 55);
        f10945g.append(F.d.f1196Q0, 56);
        f10945g.append(F.d.f1441t0, 57);
        f10945g.append(F.d.f1204R0, 58);
        f10945g.append(F.d.f1449u0, 59);
        f10945g.append(F.d.f1348i0, 61);
        f10945g.append(F.d.f1366k0, 62);
        f10945g.append(F.d.f1357j0, 63);
        f10945g.append(F.d.f1203R, 64);
        f10945g.append(F.d.f1367k1, 65);
        f10945g.append(F.d.f1251X, 66);
        f10945g.append(F.d.f1376l1, 67);
        f10945g.append(F.d.f1304d1, 79);
        f10945g.append(F.d.f1456v, 38);
        f10945g.append(F.d.f1295c1, 68);
        f10945g.append(F.d.f1212S0, 69);
        f10945g.append(F.d.f1457v0, 70);
        f10945g.append(F.d.f1286b1, 97);
        f10945g.append(F.d.f1235V, 71);
        f10945g.append(F.d.f1219T, 72);
        f10945g.append(F.d.f1227U, 73);
        f10945g.append(F.d.f1243W, 74);
        f10945g.append(F.d.f1211S, 75);
        f10945g.append(F.d.f1313e1, 76);
        f10945g.append(F.d.f1124H0, 77);
        f10945g.append(F.d.f1385m1, 78);
        f10945g.append(F.d.f1276a0, 80);
        f10945g.append(F.d.f1267Z, 81);
        f10945g.append(F.d.f1322f1, 82);
        f10945g.append(F.d.f1358j1, 83);
        f10945g.append(F.d.f1349i1, 84);
        f10945g.append(F.d.f1340h1, 85);
        f10945g.append(F.d.f1331g1, 86);
        f10946h.append(F.d.f1191P3, 6);
        f10946h.append(F.d.f1191P3, 7);
        f10946h.append(F.d.f1150K2, 27);
        f10946h.append(F.d.f1215S3, 13);
        f10946h.append(F.d.f1239V3, 16);
        f10946h.append(F.d.f1223T3, 14);
        f10946h.append(F.d.f1199Q3, 11);
        f10946h.append(F.d.f1231U3, 15);
        f10946h.append(F.d.f1207R3, 12);
        f10946h.append(F.d.f1143J3, 40);
        f10946h.append(F.d.f1087C3, 39);
        f10946h.append(F.d.f1079B3, 41);
        f10946h.append(F.d.f1135I3, 42);
        f10946h.append(F.d.f1071A3, 20);
        f10946h.append(F.d.f1127H3, 37);
        f10946h.append(F.d.f1452u3, 5);
        f10946h.append(F.d.f1095D3, 87);
        f10946h.append(F.d.f1119G3, 87);
        f10946h.append(F.d.f1103E3, 87);
        f10946h.append(F.d.f1428r3, 87);
        f10946h.append(F.d.f1420q3, 87);
        f10946h.append(F.d.f1190P2, 24);
        f10946h.append(F.d.f1206R2, 28);
        f10946h.append(F.d.f1306d3, 31);
        f10946h.append(F.d.f1315e3, 8);
        f10946h.append(F.d.f1198Q2, 34);
        f10946h.append(F.d.f1214S2, 2);
        f10946h.append(F.d.f1174N2, 23);
        f10946h.append(F.d.f1182O2, 21);
        f10946h.append(F.d.f1151K3, 95);
        f10946h.append(F.d.f1460v3, 96);
        f10946h.append(F.d.f1166M2, 22);
        f10946h.append(F.d.f1222T2, 43);
        f10946h.append(F.d.f1333g3, 44);
        f10946h.append(F.d.f1288b3, 45);
        f10946h.append(F.d.f1297c3, 46);
        f10946h.append(F.d.f1279a3, 60);
        f10946h.append(F.d.f1262Y2, 47);
        f10946h.append(F.d.f1270Z2, 48);
        f10946h.append(F.d.f1230U2, 49);
        f10946h.append(F.d.f1238V2, 50);
        f10946h.append(F.d.f1246W2, 51);
        f10946h.append(F.d.f1254X2, 52);
        f10946h.append(F.d.f1324f3, 53);
        f10946h.append(F.d.f1159L3, 54);
        f10946h.append(F.d.f1468w3, 55);
        f10946h.append(F.d.f1167M3, 56);
        f10946h.append(F.d.f1476x3, 57);
        f10946h.append(F.d.f1175N3, 58);
        f10946h.append(F.d.f1484y3, 59);
        f10946h.append(F.d.f1444t3, 62);
        f10946h.append(F.d.f1436s3, 63);
        f10946h.append(F.d.f1342h3, 64);
        f10946h.append(F.d.f1334g4, 65);
        f10946h.append(F.d.f1396n3, 66);
        f10946h.append(F.d.f1343h4, 67);
        f10946h.append(F.d.f1263Y3, 79);
        f10946h.append(F.d.f1158L2, 38);
        f10946h.append(F.d.f1271Z3, 98);
        f10946h.append(F.d.f1255X3, 68);
        f10946h.append(F.d.f1183O3, 69);
        f10946h.append(F.d.f1492z3, 70);
        f10946h.append(F.d.f1378l3, 71);
        f10946h.append(F.d.f1360j3, 72);
        f10946h.append(F.d.f1369k3, 73);
        f10946h.append(F.d.f1387m3, 74);
        f10946h.append(F.d.f1351i3, 75);
        f10946h.append(F.d.f1280a4, 76);
        f10946h.append(F.d.f1111F3, 77);
        f10946h.append(F.d.f1352i4, 78);
        f10946h.append(F.d.f1412p3, 80);
        f10946h.append(F.d.f1404o3, 81);
        f10946h.append(F.d.f1289b4, 82);
        f10946h.append(F.d.f1325f4, 83);
        f10946h.append(F.d.f1316e4, 84);
        f10946h.append(F.d.f1307d4, 85);
        f10946h.append(F.d.f1298c4, 86);
        f10946h.append(F.d.f1247W3, 97);
    }

    public static int j(TypedArray typedArray, int i8, int i9) {
        int resourceId = typedArray.getResourceId(i8, i9);
        return resourceId == -1 ? typedArray.getInt(i8, -1) : resourceId;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void k(java.lang.Object r4, android.content.res.TypedArray r5, int r6, int r7) {
        /*
            if (r4 != 0) goto L3
            return
        L3:
            android.util.TypedValue r0 = r5.peekValue(r6)
            int r0 = r0.type
            r1 = 3
            if (r0 == r1) goto L6f
            r1 = 5
            r2 = 0
            if (r0 == r1) goto L2a
            int r5 = r5.getInt(r6, r2)
            r6 = -4
            r0 = -2
            if (r5 == r6) goto L26
            r6 = -3
            if (r5 == r6) goto L20
            if (r5 == r0) goto L22
            r6 = -1
            if (r5 == r6) goto L22
        L20:
            r5 = r2
            goto L2f
        L22:
            r3 = r2
            r2 = r5
            r5 = r3
            goto L2f
        L26:
            r2 = 1
            r5 = r2
            r2 = r0
            goto L2f
        L2a:
            int r5 = r5.getDimensionPixelSize(r6, r2)
            goto L22
        L2f:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.ConstraintLayout.b
            if (r6 == 0) goto L41
            androidx.constraintlayout.widget.ConstraintLayout$b r4 = (androidx.constraintlayout.widget.ConstraintLayout.b) r4
            if (r7 != 0) goto L3c
            r4.width = r2
            r4.f10857a0 = r5
            goto L6e
        L3c:
            r4.height = r2
            r4.f10859b0 = r5
            goto L6e
        L41:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.d.b
            if (r6 == 0) goto L53
            androidx.constraintlayout.widget.d$b r4 = (androidx.constraintlayout.widget.d.b) r4
            if (r7 != 0) goto L4e
            r4.f11005d = r2
            r4.f11026n0 = r5
            goto L6e
        L4e:
            r4.f11007e = r2
            r4.f11028o0 = r5
            goto L6e
        L53:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.d.a.C0177a
            if (r6 == 0) goto L6e
            androidx.constraintlayout.widget.d$a$a r4 = (androidx.constraintlayout.widget.d.a.C0177a) r4
            if (r7 != 0) goto L66
            r6 = 23
            r4.b(r6, r2)
            r6 = 80
        L62:
            r4.d(r6, r5)
            goto L6e
        L66:
            r6 = 21
            r4.b(r6, r2)
            r6 = 81
            goto L62
        L6e:
            return
        L6f:
            java.lang.String r5 = r5.getString(r6)
            l(r4, r5, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.d.k(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    public static void l(Object obj, String str, int i8) {
        int i9;
        int i10;
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
                    if (i8 == 0) {
                        ((ViewGroup.MarginLayoutParams) bVar).width = 0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) bVar).height = 0;
                    }
                    m(bVar, strTrim2);
                    return;
                }
                if (obj instanceof b) {
                    ((b) obj).f10973A = strTrim2;
                    return;
                } else {
                    if (obj instanceof a.C0177a) {
                        ((a.C0177a) obj).c(5, strTrim2);
                        return;
                    }
                    return;
                }
            }
            try {
                if ("weight".equalsIgnoreCase(strTrim)) {
                    float f8 = Float.parseFloat(strTrim2);
                    if (obj instanceof ConstraintLayout.b) {
                        ConstraintLayout.b bVar2 = (ConstraintLayout.b) obj;
                        if (i8 == 0) {
                            ((ViewGroup.MarginLayoutParams) bVar2).width = 0;
                            bVar2.f10841L = f8;
                            return;
                        } else {
                            ((ViewGroup.MarginLayoutParams) bVar2).height = 0;
                            bVar2.f10842M = f8;
                            return;
                        }
                    }
                    if (obj instanceof b) {
                        b bVar3 = (b) obj;
                        if (i8 == 0) {
                            bVar3.f11005d = 0;
                            bVar3.f10995W = f8;
                            return;
                        } else {
                            bVar3.f11007e = 0;
                            bVar3.f10994V = f8;
                            return;
                        }
                    }
                    if (obj instanceof a.C0177a) {
                        a.C0177a c0177a = (a.C0177a) obj;
                        if (i8 == 0) {
                            c0177a.b(23, 0);
                            i10 = 39;
                        } else {
                            c0177a.b(21, 0);
                            i10 = 40;
                        }
                        c0177a.a(i10, f8);
                        return;
                    }
                    return;
                }
                if ("parent".equalsIgnoreCase(strTrim)) {
                    float fMax = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(strTrim2)));
                    if (obj instanceof ConstraintLayout.b) {
                        ConstraintLayout.b bVar4 = (ConstraintLayout.b) obj;
                        if (i8 == 0) {
                            ((ViewGroup.MarginLayoutParams) bVar4).width = 0;
                            bVar4.f10851V = fMax;
                            bVar4.f10845P = 2;
                            return;
                        } else {
                            ((ViewGroup.MarginLayoutParams) bVar4).height = 0;
                            bVar4.f10852W = fMax;
                            bVar4.f10846Q = 2;
                            return;
                        }
                    }
                    if (obj instanceof b) {
                        b bVar5 = (b) obj;
                        if (i8 == 0) {
                            bVar5.f11005d = 0;
                            bVar5.f11010f0 = fMax;
                            bVar5.f10998Z = 2;
                            return;
                        } else {
                            bVar5.f11007e = 0;
                            bVar5.f11012g0 = fMax;
                            bVar5.f11000a0 = 2;
                            return;
                        }
                    }
                    if (obj instanceof a.C0177a) {
                        a.C0177a c0177a2 = (a.C0177a) obj;
                        if (i8 == 0) {
                            c0177a2.b(23, 0);
                            i9 = 54;
                        } else {
                            c0177a2.b(21, 0);
                            i9 = 55;
                        }
                        c0177a2.b(i9, 2);
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    public static void m(ConstraintLayout.b bVar, String str) {
        float fAbs = Float.NaN;
        int i8 = -1;
        if (str != null) {
            int length = str.length();
            int iIndexOf = str.indexOf(44);
            int i9 = 0;
            if (iIndexOf > 0 && iIndexOf < length - 1) {
                String strSubstring = str.substring(0, iIndexOf);
                if (strSubstring.equalsIgnoreCase("W")) {
                    i8 = 0;
                } else if (strSubstring.equalsIgnoreCase("H")) {
                    i8 = 1;
                }
                i9 = iIndexOf + 1;
            }
            int iIndexOf2 = str.indexOf(58);
            try {
                if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                    String strSubstring2 = str.substring(i9);
                    if (strSubstring2.length() > 0) {
                        fAbs = Float.parseFloat(strSubstring2);
                    }
                } else {
                    String strSubstring3 = str.substring(i9, iIndexOf2);
                    String strSubstring4 = str.substring(iIndexOf2 + 1);
                    if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                        float f8 = Float.parseFloat(strSubstring3);
                        float f9 = Float.parseFloat(strSubstring4);
                        if (f8 > 0.0f && f9 > 0.0f) {
                            fAbs = i8 == 1 ? Math.abs(f9 / f8) : Math.abs(f8 / f9);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        bVar.f10838I = str;
        bVar.f10839J = fAbs;
        bVar.f10840K = i8;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void o(android.content.Context r11, androidx.constraintlayout.widget.d.a r12, android.content.res.TypedArray r13) {
        /*
            Method dump skipped, instruction units count: 1360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.d.o(android.content.Context, androidx.constraintlayout.widget.d$a, android.content.res.TypedArray):void");
    }

    public void c(ConstraintLayout constraintLayout, boolean z7) {
        int childCount = constraintLayout.getChildCount();
        HashSet<Integer> hashSet = new HashSet(this.f10951e.keySet());
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = constraintLayout.getChildAt(i8);
            int id = childAt.getId();
            if (!this.f10951e.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + E.a.a(childAt));
            } else {
                if (this.f10950d && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (this.f10951e.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        a aVar = (a) this.f10951e.get(Integer.valueOf(id));
                        if (aVar != null) {
                            if (childAt instanceof androidx.constraintlayout.widget.a) {
                                aVar.f10956e.f11018j0 = 1;
                                androidx.constraintlayout.widget.a aVar2 = (androidx.constraintlayout.widget.a) childAt;
                                aVar2.setId(id);
                                aVar2.setType(aVar.f10956e.f11014h0);
                                aVar2.setMargin(aVar.f10956e.f11016i0);
                                aVar2.setAllowsGoneWidget(aVar.f10956e.f11030p0);
                                b bVar = aVar.f10956e;
                                int[] iArr = bVar.f11020k0;
                                if (iArr != null) {
                                    aVar2.setReferencedIds(iArr);
                                } else {
                                    String str = bVar.f11022l0;
                                    if (str != null) {
                                        bVar.f11020k0 = f(aVar2, str);
                                        aVar2.setReferencedIds(aVar.f10956e.f11020k0);
                                    }
                                }
                            }
                            ConstraintLayout.b bVar2 = (ConstraintLayout.b) childAt.getLayoutParams();
                            bVar2.a();
                            aVar.b(bVar2);
                            if (z7) {
                                androidx.constraintlayout.widget.b.c(childAt, aVar.f10958g);
                            }
                            childAt.setLayoutParams(bVar2);
                            C0178d c0178d = aVar.f10954c;
                            if (c0178d.f11059c == 0) {
                                childAt.setVisibility(c0178d.f11058b);
                            }
                            childAt.setAlpha(aVar.f10954c.f11060d);
                            childAt.setRotation(aVar.f10957f.f11064b);
                            childAt.setRotationX(aVar.f10957f.f11065c);
                            childAt.setRotationY(aVar.f10957f.f11066d);
                            childAt.setScaleX(aVar.f10957f.f11067e);
                            childAt.setScaleY(aVar.f10957f.f11068f);
                            e eVar = aVar.f10957f;
                            if (eVar.f11071i != -1) {
                                if (((View) childAt.getParent()).findViewById(aVar.f10957f.f11071i) != null) {
                                    float top = (r4.getTop() + r4.getBottom()) / 2.0f;
                                    float left = (r4.getLeft() + r4.getRight()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(left - childAt.getLeft());
                                        childAt.setPivotY(top - childAt.getTop());
                                    }
                                }
                            } else {
                                if (!Float.isNaN(eVar.f11069g)) {
                                    childAt.setPivotX(aVar.f10957f.f11069g);
                                }
                                if (!Float.isNaN(aVar.f10957f.f11070h)) {
                                    childAt.setPivotY(aVar.f10957f.f11070h);
                                }
                            }
                            childAt.setTranslationX(aVar.f10957f.f11072j);
                            childAt.setTranslationY(aVar.f10957f.f11073k);
                            childAt.setTranslationZ(aVar.f10957f.f11074l);
                            e eVar2 = aVar.f10957f;
                            if (eVar2.f11075m) {
                                childAt.setElevation(eVar2.f11076n);
                            }
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            }
        }
        for (Integer num : hashSet) {
            a aVar3 = (a) this.f10951e.get(num);
            if (aVar3 != null) {
                if (aVar3.f10956e.f11018j0 == 1) {
                    androidx.constraintlayout.widget.a aVar4 = new androidx.constraintlayout.widget.a(constraintLayout.getContext());
                    aVar4.setId(num.intValue());
                    b bVar3 = aVar3.f10956e;
                    int[] iArr2 = bVar3.f11020k0;
                    if (iArr2 != null) {
                        aVar4.setReferencedIds(iArr2);
                    } else {
                        String str2 = bVar3.f11022l0;
                        if (str2 != null) {
                            bVar3.f11020k0 = f(aVar4, str2);
                            aVar4.setReferencedIds(aVar3.f10956e.f11020k0);
                        }
                    }
                    aVar4.setType(aVar3.f10956e.f11014h0);
                    aVar4.setMargin(aVar3.f10956e.f11016i0);
                    ConstraintLayout.b bVarJ = constraintLayout.generateDefaultLayoutParams();
                    aVar4.m();
                    aVar3.b(bVarJ);
                    constraintLayout.addView(aVar4, bVarJ);
                }
                if (aVar3.f10956e.f10999a) {
                    View eVar3 = new androidx.constraintlayout.widget.e(constraintLayout.getContext());
                    eVar3.setId(num.intValue());
                    ConstraintLayout.b bVarJ2 = constraintLayout.generateDefaultLayoutParams();
                    aVar3.b(bVarJ2);
                    constraintLayout.addView(eVar3, bVarJ2);
                }
            }
        }
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt2 = constraintLayout.getChildAt(i9);
            if (childAt2 instanceof androidx.constraintlayout.widget.c) {
                ((androidx.constraintlayout.widget.c) childAt2).d(constraintLayout);
            }
        }
    }

    public void d(Context context, int i8) {
        e((ConstraintLayout) LayoutInflater.from(context).inflate(i8, (ViewGroup) null));
    }

    public void e(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f10951e.clear();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = constraintLayout.getChildAt(i8);
            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f10950d && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f10951e.containsKey(Integer.valueOf(id))) {
                this.f10951e.put(Integer.valueOf(id), new a());
            }
            a aVar = (a) this.f10951e.get(Integer.valueOf(id));
            if (aVar != null) {
                aVar.f10958g = androidx.constraintlayout.widget.b.a(this.f10949c, childAt);
                aVar.d(id, bVar);
                aVar.f10954c.f11058b = childAt.getVisibility();
                aVar.f10954c.f11060d = childAt.getAlpha();
                aVar.f10957f.f11064b = childAt.getRotation();
                aVar.f10957f.f11065c = childAt.getRotationX();
                aVar.f10957f.f11066d = childAt.getRotationY();
                aVar.f10957f.f11067e = childAt.getScaleX();
                aVar.f10957f.f11068f = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    e eVar = aVar.f10957f;
                    eVar.f11069g = pivotX;
                    eVar.f11070h = pivotY;
                }
                aVar.f10957f.f11072j = childAt.getTranslationX();
                aVar.f10957f.f11073k = childAt.getTranslationY();
                aVar.f10957f.f11074l = childAt.getTranslationZ();
                e eVar2 = aVar.f10957f;
                if (eVar2.f11075m) {
                    eVar2.f11076n = childAt.getElevation();
                }
                if (childAt instanceof androidx.constraintlayout.widget.a) {
                    androidx.constraintlayout.widget.a aVar2 = (androidx.constraintlayout.widget.a) childAt;
                    aVar.f10956e.f11030p0 = aVar2.getAllowsGoneWidget();
                    aVar.f10956e.f11020k0 = aVar2.getReferencedIds();
                    aVar.f10956e.f11014h0 = aVar2.getType();
                    aVar.f10956e.f11016i0 = aVar2.getMargin();
                }
            }
        }
    }

    public final int[] f(View view, String str) {
        int iIntValue;
        Object objL;
        String[] strArrSplit = str.split(f.f14100a);
        Context context = view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i8 = 0;
        int i9 = 0;
        while (i8 < strArrSplit.length) {
            String strTrim = strArrSplit[i8].trim();
            try {
                iIntValue = F.c.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, DiagnosticsEntry.ID_KEY, context.getPackageName());
            }
            if (iIntValue == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (objL = ((ConstraintLayout) view.getParent()).l(0, strTrim)) != null && (objL instanceof Integer)) {
                iIntValue = ((Integer) objL).intValue();
            }
            iArr[i9] = iIntValue;
            i8++;
            i9++;
        }
        return i9 != strArrSplit.length ? Arrays.copyOf(iArr, i9) : iArr;
    }

    public final a g(Context context, AttributeSet attributeSet, boolean z7) {
        a aVar = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z7 ? F.d.f1142J2 : F.d.f1440t);
        n(context, aVar, typedArrayObtainStyledAttributes, z7);
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    public void h(Context context, int i8) {
        XmlResourceParser xml = context.getResources().getXml(i8);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a aVarG = g(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        aVarG.f10956e.f10999a = true;
                    }
                    this.f10951e.put(Integer.valueOf(aVarG.f10952a), aVarG);
                }
            }
        } catch (IOException e8) {
            e8.printStackTrace();
        } catch (XmlPullParserException e9) {
            e9.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:123:0x01cf, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            Method dump skipped, instruction units count: 562
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.d.i(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public final void n(Context context, a aVar, TypedArray typedArray, boolean z7) {
        c cVar;
        String string;
        c cVar2;
        StringBuilder sb;
        String str;
        if (z7) {
            o(context, aVar, typedArray);
            return;
        }
        int indexCount = typedArray.getIndexCount();
        for (int i8 = 0; i8 < indexCount; i8++) {
            int index = typedArray.getIndex(i8);
            if (index != F.d.f1456v && F.d.f1171N != index && F.d.f1179O != index) {
                aVar.f10955d.f11043a = true;
                aVar.f10956e.f11001b = true;
                aVar.f10954c.f11057a = true;
                aVar.f10957f.f11063a = true;
            }
            switch (f10945g.get(index)) {
                case 1:
                    b bVar = aVar.f10956e;
                    bVar.f11033r = j(typedArray, index, bVar.f11033r);
                    continue;
                    break;
                case 2:
                    b bVar2 = aVar.f10956e;
                    bVar2.f10983K = typedArray.getDimensionPixelSize(index, bVar2.f10983K);
                    continue;
                    break;
                case 3:
                    b bVar3 = aVar.f10956e;
                    bVar3.f11031q = j(typedArray, index, bVar3.f11031q);
                    continue;
                    break;
                case 4:
                    b bVar4 = aVar.f10956e;
                    bVar4.f11029p = j(typedArray, index, bVar4.f11029p);
                    continue;
                    break;
                case 5:
                    aVar.f10956e.f10973A = typedArray.getString(index);
                    continue;
                    break;
                case 6:
                    b bVar5 = aVar.f10956e;
                    bVar5.f10977E = typedArray.getDimensionPixelOffset(index, bVar5.f10977E);
                    continue;
                    break;
                case 7:
                    b bVar6 = aVar.f10956e;
                    bVar6.f10978F = typedArray.getDimensionPixelOffset(index, bVar6.f10978F);
                    continue;
                    break;
                case 8:
                    b bVar7 = aVar.f10956e;
                    bVar7.f10984L = typedArray.getDimensionPixelSize(index, bVar7.f10984L);
                    continue;
                    break;
                case 9:
                    b bVar8 = aVar.f10956e;
                    bVar8.f11039x = j(typedArray, index, bVar8.f11039x);
                    continue;
                    break;
                case 10:
                    b bVar9 = aVar.f10956e;
                    bVar9.f11038w = j(typedArray, index, bVar9.f11038w);
                    continue;
                    break;
                case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                    b bVar10 = aVar.f10956e;
                    bVar10.f10990R = typedArray.getDimensionPixelSize(index, bVar10.f10990R);
                    continue;
                    break;
                case 12:
                    b bVar11 = aVar.f10956e;
                    bVar11.f10991S = typedArray.getDimensionPixelSize(index, bVar11.f10991S);
                    continue;
                    break;
                case 13:
                    b bVar12 = aVar.f10956e;
                    bVar12.f10987O = typedArray.getDimensionPixelSize(index, bVar12.f10987O);
                    continue;
                    break;
                case 14:
                    b bVar13 = aVar.f10956e;
                    bVar13.f10989Q = typedArray.getDimensionPixelSize(index, bVar13.f10989Q);
                    continue;
                    break;
                case 15:
                    b bVar14 = aVar.f10956e;
                    bVar14.f10992T = typedArray.getDimensionPixelSize(index, bVar14.f10992T);
                    continue;
                    break;
                case com.amazon.c.a.a.c.f14230g /* 16 */:
                    b bVar15 = aVar.f10956e;
                    bVar15.f10988P = typedArray.getDimensionPixelSize(index, bVar15.f10988P);
                    continue;
                    break;
                case 17:
                    b bVar16 = aVar.f10956e;
                    bVar16.f11009f = typedArray.getDimensionPixelOffset(index, bVar16.f11009f);
                    continue;
                    break;
                case 18:
                    b bVar17 = aVar.f10956e;
                    bVar17.f11011g = typedArray.getDimensionPixelOffset(index, bVar17.f11011g);
                    continue;
                    break;
                case 19:
                    b bVar18 = aVar.f10956e;
                    bVar18.f11013h = typedArray.getFloat(index, bVar18.f11013h);
                    continue;
                    break;
                case 20:
                    b bVar19 = aVar.f10956e;
                    bVar19.f11040y = typedArray.getFloat(index, bVar19.f11040y);
                    continue;
                    break;
                case 21:
                    b bVar20 = aVar.f10956e;
                    bVar20.f11007e = typedArray.getLayoutDimension(index, bVar20.f11007e);
                    continue;
                    break;
                case Build.API_LEVELS.API_22 /* 22 */:
                    C0178d c0178d = aVar.f10954c;
                    c0178d.f11058b = typedArray.getInt(index, c0178d.f11058b);
                    C0178d c0178d2 = aVar.f10954c;
                    c0178d2.f11058b = f10944f[c0178d2.f11058b];
                    continue;
                    break;
                case Build.API_LEVELS.API_23 /* 23 */:
                    b bVar21 = aVar.f10956e;
                    bVar21.f11005d = typedArray.getLayoutDimension(index, bVar21.f11005d);
                    continue;
                    break;
                case Build.API_LEVELS.API_24 /* 24 */:
                    b bVar22 = aVar.f10956e;
                    bVar22.f10980H = typedArray.getDimensionPixelSize(index, bVar22.f10980H);
                    continue;
                    break;
                case Build.API_LEVELS.API_25 /* 25 */:
                    b bVar23 = aVar.f10956e;
                    bVar23.f11017j = j(typedArray, index, bVar23.f11017j);
                    continue;
                    break;
                case Build.API_LEVELS.API_26 /* 26 */:
                    b bVar24 = aVar.f10956e;
                    bVar24.f11019k = j(typedArray, index, bVar24.f11019k);
                    continue;
                    break;
                case Build.API_LEVELS.API_27 /* 27 */:
                    b bVar25 = aVar.f10956e;
                    bVar25.f10979G = typedArray.getInt(index, bVar25.f10979G);
                    continue;
                    break;
                case Build.API_LEVELS.API_28 /* 28 */:
                    b bVar26 = aVar.f10956e;
                    bVar26.f10981I = typedArray.getDimensionPixelSize(index, bVar26.f10981I);
                    continue;
                    break;
                case Build.API_LEVELS.API_29 /* 29 */:
                    b bVar27 = aVar.f10956e;
                    bVar27.f11021l = j(typedArray, index, bVar27.f11021l);
                    continue;
                    break;
                case Build.API_LEVELS.API_30 /* 30 */:
                    b bVar28 = aVar.f10956e;
                    bVar28.f11023m = j(typedArray, index, bVar28.f11023m);
                    continue;
                    break;
                case Build.API_LEVELS.API_31 /* 31 */:
                    b bVar29 = aVar.f10956e;
                    bVar29.f10985M = typedArray.getDimensionPixelSize(index, bVar29.f10985M);
                    continue;
                    break;
                case 32:
                    b bVar30 = aVar.f10956e;
                    bVar30.f11036u = j(typedArray, index, bVar30.f11036u);
                    continue;
                    break;
                case Build.API_LEVELS.API_33 /* 33 */:
                    b bVar31 = aVar.f10956e;
                    bVar31.f11037v = j(typedArray, index, bVar31.f11037v);
                    continue;
                    break;
                case Build.API_LEVELS.API_34 /* 34 */:
                    b bVar32 = aVar.f10956e;
                    bVar32.f10982J = typedArray.getDimensionPixelSize(index, bVar32.f10982J);
                    continue;
                    break;
                case Build.API_LEVELS.API_35 /* 35 */:
                    b bVar33 = aVar.f10956e;
                    bVar33.f11027o = j(typedArray, index, bVar33.f11027o);
                    continue;
                    break;
                case Build.API_LEVELS.API_36 /* 36 */:
                    b bVar34 = aVar.f10956e;
                    bVar34.f11025n = j(typedArray, index, bVar34.f11025n);
                    continue;
                    break;
                case 37:
                    b bVar35 = aVar.f10956e;
                    bVar35.f11041z = typedArray.getFloat(index, bVar35.f11041z);
                    continue;
                    break;
                case 38:
                    aVar.f10952a = typedArray.getResourceId(index, aVar.f10952a);
                    continue;
                    break;
                case 39:
                    b bVar36 = aVar.f10956e;
                    bVar36.f10995W = typedArray.getFloat(index, bVar36.f10995W);
                    continue;
                    break;
                case 40:
                    b bVar37 = aVar.f10956e;
                    bVar37.f10994V = typedArray.getFloat(index, bVar37.f10994V);
                    continue;
                    break;
                case 41:
                    b bVar38 = aVar.f10956e;
                    bVar38.f10996X = typedArray.getInt(index, bVar38.f10996X);
                    continue;
                    break;
                case 42:
                    b bVar39 = aVar.f10956e;
                    bVar39.f10997Y = typedArray.getInt(index, bVar39.f10997Y);
                    continue;
                    break;
                case 43:
                    C0178d c0178d3 = aVar.f10954c;
                    c0178d3.f11060d = typedArray.getFloat(index, c0178d3.f11060d);
                    continue;
                    break;
                case 44:
                    e eVar = aVar.f10957f;
                    eVar.f11075m = true;
                    eVar.f11076n = typedArray.getDimension(index, eVar.f11076n);
                    continue;
                    break;
                case 45:
                    e eVar2 = aVar.f10957f;
                    eVar2.f11065c = typedArray.getFloat(index, eVar2.f11065c);
                    continue;
                    break;
                case 46:
                    e eVar3 = aVar.f10957f;
                    eVar3.f11066d = typedArray.getFloat(index, eVar3.f11066d);
                    continue;
                    break;
                case 47:
                    e eVar4 = aVar.f10957f;
                    eVar4.f11067e = typedArray.getFloat(index, eVar4.f11067e);
                    continue;
                    break;
                case 48:
                    e eVar5 = aVar.f10957f;
                    eVar5.f11068f = typedArray.getFloat(index, eVar5.f11068f);
                    continue;
                    break;
                case 49:
                    e eVar6 = aVar.f10957f;
                    eVar6.f11069g = typedArray.getDimension(index, eVar6.f11069g);
                    continue;
                    break;
                case 50:
                    e eVar7 = aVar.f10957f;
                    eVar7.f11070h = typedArray.getDimension(index, eVar7.f11070h);
                    continue;
                    break;
                case 51:
                    e eVar8 = aVar.f10957f;
                    eVar8.f11072j = typedArray.getDimension(index, eVar8.f11072j);
                    continue;
                    break;
                case 52:
                    e eVar9 = aVar.f10957f;
                    eVar9.f11073k = typedArray.getDimension(index, eVar9.f11073k);
                    continue;
                    break;
                case 53:
                    e eVar10 = aVar.f10957f;
                    eVar10.f11074l = typedArray.getDimension(index, eVar10.f11074l);
                    continue;
                    break;
                case 54:
                    b bVar40 = aVar.f10956e;
                    bVar40.f10998Z = typedArray.getInt(index, bVar40.f10998Z);
                    continue;
                    break;
                case 55:
                    b bVar41 = aVar.f10956e;
                    bVar41.f11000a0 = typedArray.getInt(index, bVar41.f11000a0);
                    continue;
                    break;
                case 56:
                    b bVar42 = aVar.f10956e;
                    bVar42.f11002b0 = typedArray.getDimensionPixelSize(index, bVar42.f11002b0);
                    continue;
                    break;
                case 57:
                    b bVar43 = aVar.f10956e;
                    bVar43.f11004c0 = typedArray.getDimensionPixelSize(index, bVar43.f11004c0);
                    continue;
                    break;
                case 58:
                    b bVar44 = aVar.f10956e;
                    bVar44.f11006d0 = typedArray.getDimensionPixelSize(index, bVar44.f11006d0);
                    continue;
                    break;
                case 59:
                    b bVar45 = aVar.f10956e;
                    bVar45.f11008e0 = typedArray.getDimensionPixelSize(index, bVar45.f11008e0);
                    continue;
                    break;
                case 60:
                    e eVar11 = aVar.f10957f;
                    eVar11.f11064b = typedArray.getFloat(index, eVar11.f11064b);
                    continue;
                    break;
                case 61:
                    b bVar46 = aVar.f10956e;
                    bVar46.f10974B = j(typedArray, index, bVar46.f10974B);
                    continue;
                    break;
                case 62:
                    b bVar47 = aVar.f10956e;
                    bVar47.f10975C = typedArray.getDimensionPixelSize(index, bVar47.f10975C);
                    continue;
                    break;
                case 63:
                    b bVar48 = aVar.f10956e;
                    bVar48.f10976D = typedArray.getFloat(index, bVar48.f10976D);
                    continue;
                    break;
                case 64:
                    c cVar3 = aVar.f10955d;
                    cVar3.f11044b = j(typedArray, index, cVar3.f11044b);
                    continue;
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        cVar = aVar.f10955d;
                        string = typedArray.getString(index);
                    } else {
                        cVar = aVar.f10955d;
                        string = A.a.f4c[typedArray.getInteger(index, 0)];
                    }
                    cVar.f11046d = string;
                    continue;
                    break;
                case 66:
                    aVar.f10955d.f11048f = typedArray.getInt(index, 0);
                    continue;
                    break;
                case 67:
                    c cVar4 = aVar.f10955d;
                    cVar4.f11051i = typedArray.getFloat(index, cVar4.f11051i);
                    continue;
                    break;
                case 68:
                    C0178d c0178d4 = aVar.f10954c;
                    c0178d4.f11061e = typedArray.getFloat(index, c0178d4.f11061e);
                    continue;
                    break;
                case 69:
                    aVar.f10956e.f11010f0 = typedArray.getFloat(index, 1.0f);
                    continue;
                    break;
                case 70:
                    aVar.f10956e.f11012g0 = typedArray.getFloat(index, 1.0f);
                    continue;
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    continue;
                    break;
                case 72:
                    b bVar49 = aVar.f10956e;
                    bVar49.f11014h0 = typedArray.getInt(index, bVar49.f11014h0);
                    continue;
                    break;
                case 73:
                    b bVar50 = aVar.f10956e;
                    bVar50.f11016i0 = typedArray.getDimensionPixelSize(index, bVar50.f11016i0);
                    continue;
                    break;
                case 74:
                    aVar.f10956e.f11022l0 = typedArray.getString(index);
                    continue;
                    break;
                case 75:
                    b bVar51 = aVar.f10956e;
                    bVar51.f11030p0 = typedArray.getBoolean(index, bVar51.f11030p0);
                    continue;
                    break;
                case 76:
                    c cVar5 = aVar.f10955d;
                    cVar5.f11047e = typedArray.getInt(index, cVar5.f11047e);
                    continue;
                    break;
                case 77:
                    aVar.f10956e.f11024m0 = typedArray.getString(index);
                    continue;
                    break;
                case 78:
                    C0178d c0178d5 = aVar.f10954c;
                    c0178d5.f11059c = typedArray.getInt(index, c0178d5.f11059c);
                    continue;
                    break;
                case 79:
                    c cVar6 = aVar.f10955d;
                    cVar6.f11049g = typedArray.getFloat(index, cVar6.f11049g);
                    continue;
                    break;
                case 80:
                    b bVar52 = aVar.f10956e;
                    bVar52.f11026n0 = typedArray.getBoolean(index, bVar52.f11026n0);
                    continue;
                    break;
                case 81:
                    b bVar53 = aVar.f10956e;
                    bVar53.f11028o0 = typedArray.getBoolean(index, bVar53.f11028o0);
                    continue;
                    break;
                case 82:
                    c cVar7 = aVar.f10955d;
                    cVar7.f11045c = typedArray.getInteger(index, cVar7.f11045c);
                    continue;
                    break;
                case 83:
                    e eVar12 = aVar.f10957f;
                    eVar12.f11071i = j(typedArray, index, eVar12.f11071i);
                    continue;
                    break;
                case 84:
                    c cVar8 = aVar.f10955d;
                    cVar8.f11053k = typedArray.getInteger(index, cVar8.f11053k);
                    continue;
                    break;
                case 85:
                    c cVar9 = aVar.f10955d;
                    cVar9.f11052j = typedArray.getFloat(index, cVar9.f11052j);
                    continue;
                    break;
                case 86:
                    int i9 = typedArray.peekValue(index).type;
                    if (i9 == 1) {
                        aVar.f10955d.f11056n = typedArray.getResourceId(index, -1);
                        cVar2 = aVar.f10955d;
                        if (cVar2.f11056n != -1) {
                            cVar2.f11055m = -2;
                        } else {
                            continue;
                        }
                    } else if (i9 == 3) {
                        aVar.f10955d.f11054l = typedArray.getString(index);
                        if (aVar.f10955d.f11054l.indexOf("/") > 0) {
                            aVar.f10955d.f11056n = typedArray.getResourceId(index, -1);
                            cVar2 = aVar.f10955d;
                            cVar2.f11055m = -2;
                        } else {
                            aVar.f10955d.f11055m = -1;
                        }
                    } else {
                        c cVar10 = aVar.f10955d;
                        cVar10.f11055m = typedArray.getInteger(index, cVar10.f11056n);
                    }
                    break;
                case 87:
                    sb = new StringBuilder();
                    str = "unused attribute 0x";
                    break;
                case 88:
                case 89:
                case 90:
                default:
                    sb = new StringBuilder();
                    str = "Unknown attribute 0x";
                    break;
                case 91:
                    b bVar54 = aVar.f10956e;
                    bVar54.f11034s = j(typedArray, index, bVar54.f11034s);
                    continue;
                    break;
                case 92:
                    b bVar55 = aVar.f10956e;
                    bVar55.f11035t = j(typedArray, index, bVar55.f11035t);
                    continue;
                    break;
                case 93:
                    b bVar56 = aVar.f10956e;
                    bVar56.f10986N = typedArray.getDimensionPixelSize(index, bVar56.f10986N);
                    continue;
                    break;
                case 94:
                    b bVar57 = aVar.f10956e;
                    bVar57.f10993U = typedArray.getDimensionPixelSize(index, bVar57.f10993U);
                    continue;
                    break;
                case 95:
                    k(aVar.f10956e, typedArray, index, 0);
                    continue;
                    break;
                case 96:
                    k(aVar.f10956e, typedArray, index, 1);
                    continue;
                    break;
                case 97:
                    b bVar58 = aVar.f10956e;
                    bVar58.f11032q0 = typedArray.getInt(index, bVar58.f11032q0);
                    continue;
                    break;
            }
            sb.append(str);
            sb.append(Integer.toHexString(index));
            sb.append("   ");
            sb.append(f10945g.get(index));
            Log.w("ConstraintSet", sb.toString());
        }
        b bVar59 = aVar.f10956e;
        if (bVar59.f11022l0 != null) {
            bVar59.f11020k0 = null;
        }
    }
}
