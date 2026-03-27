package androidx.constraintlayout.widget;

import C.d;
import C.e;
import C.f;
import C.g;
import C.j;
import D.b;
import D3.m;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import io.flutter.Build;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static F.e f10805x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SparseArray f10806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f10807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f10808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f10811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10812g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10813h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f10814i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f10815j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public F.a f10816k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f10817l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public HashMap f10818m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f10819n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f10820o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f10821p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f10822q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f10823r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f10824s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public SparseArray f10825t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public c f10826u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f10827v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f10828w;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10829a;

        static {
            int[] iArr = new int[e.b.values().length];
            f10829a = iArr;
            try {
                iArr[e.b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10829a[e.b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10829a[e.b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10829a[e.b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static class b extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        public int f10830A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        public int f10831B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        public int f10832C;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        public int f10833D;

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        public boolean f10834E;

        /* JADX INFO: renamed from: F, reason: collision with root package name */
        public boolean f10835F;

        /* JADX INFO: renamed from: G, reason: collision with root package name */
        public float f10836G;

        /* JADX INFO: renamed from: H, reason: collision with root package name */
        public float f10837H;

        /* JADX INFO: renamed from: I, reason: collision with root package name */
        public String f10838I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public float f10839J;

        /* JADX INFO: renamed from: K, reason: collision with root package name */
        public int f10840K;

        /* JADX INFO: renamed from: L, reason: collision with root package name */
        public float f10841L;

        /* JADX INFO: renamed from: M, reason: collision with root package name */
        public float f10842M;

        /* JADX INFO: renamed from: N, reason: collision with root package name */
        public int f10843N;

        /* JADX INFO: renamed from: O, reason: collision with root package name */
        public int f10844O;

        /* JADX INFO: renamed from: P, reason: collision with root package name */
        public int f10845P;

        /* JADX INFO: renamed from: Q, reason: collision with root package name */
        public int f10846Q;

        /* JADX INFO: renamed from: R, reason: collision with root package name */
        public int f10847R;

        /* JADX INFO: renamed from: S, reason: collision with root package name */
        public int f10848S;

        /* JADX INFO: renamed from: T, reason: collision with root package name */
        public int f10849T;

        /* JADX INFO: renamed from: U, reason: collision with root package name */
        public int f10850U;

        /* JADX INFO: renamed from: V, reason: collision with root package name */
        public float f10851V;

        /* JADX INFO: renamed from: W, reason: collision with root package name */
        public float f10852W;

        /* JADX INFO: renamed from: X, reason: collision with root package name */
        public int f10853X;

        /* JADX INFO: renamed from: Y, reason: collision with root package name */
        public int f10854Y;

        /* JADX INFO: renamed from: Z, reason: collision with root package name */
        public int f10855Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10856a;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public boolean f10857a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f10858b;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public boolean f10859b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f10860c;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public String f10861c0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f10862d;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public int f10863d0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f10864e;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public boolean f10865e0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f10866f;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public boolean f10867f0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f10868g;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public boolean f10869g0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f10870h;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public boolean f10871h0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f10872i;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public boolean f10873i0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f10874j;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public boolean f10875j0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f10876k;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public boolean f10877k0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f10878l;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public int f10879l0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f10880m;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public int f10881m0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f10882n;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public int f10883n0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f10884o;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public int f10885o0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f10886p;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public int f10887p0;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f10888q;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public int f10889q0;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public float f10890r;

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        public float f10891r0;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f10892s;

        /* JADX INFO: renamed from: s0, reason: collision with root package name */
        public int f10893s0;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f10894t;

        /* JADX INFO: renamed from: t0, reason: collision with root package name */
        public int f10895t0;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f10896u;

        /* JADX INFO: renamed from: u0, reason: collision with root package name */
        public float f10897u0;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f10898v;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        public C.e f10899v0;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f10900w;

        /* JADX INFO: renamed from: w0, reason: collision with root package name */
        public boolean f10901w0;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f10902x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f10903y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f10904z;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f10905a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f10905a = sparseIntArray;
                sparseIntArray.append(F.d.f1419q2, 64);
                sparseIntArray.append(F.d.f1221T1, 65);
                sparseIntArray.append(F.d.f1296c2, 8);
                sparseIntArray.append(F.d.f1305d2, 9);
                sparseIntArray.append(F.d.f1323f2, 10);
                sparseIntArray.append(F.d.f1332g2, 11);
                sparseIntArray.append(F.d.f1386m2, 12);
                sparseIntArray.append(F.d.f1377l2, 13);
                sparseIntArray.append(F.d.f1141J1, 14);
                sparseIntArray.append(F.d.f1133I1, 15);
                sparseIntArray.append(F.d.f1101E1, 16);
                sparseIntArray.append(F.d.f1117G1, 52);
                sparseIntArray.append(F.d.f1109F1, 53);
                sparseIntArray.append(F.d.f1149K1, 2);
                sparseIntArray.append(F.d.f1165M1, 3);
                sparseIntArray.append(F.d.f1157L1, 4);
                sparseIntArray.append(F.d.f1459v2, 49);
                sparseIntArray.append(F.d.f1467w2, 50);
                sparseIntArray.append(F.d.f1197Q1, 5);
                sparseIntArray.append(F.d.f1205R1, 6);
                sparseIntArray.append(F.d.f1213S1, 7);
                sparseIntArray.append(F.d.f1490z1, 67);
                sparseIntArray.append(F.d.f1402o1, 1);
                sparseIntArray.append(F.d.f1341h2, 17);
                sparseIntArray.append(F.d.f1350i2, 18);
                sparseIntArray.append(F.d.f1189P1, 19);
                sparseIntArray.append(F.d.f1181O1, 20);
                sparseIntArray.append(F.d.f1070A2, 21);
                sparseIntArray.append(F.d.f1094D2, 22);
                sparseIntArray.append(F.d.f1078B2, 23);
                sparseIntArray.append(F.d.f1483y2, 24);
                sparseIntArray.append(F.d.f1086C2, 25);
                sparseIntArray.append(F.d.f1491z2, 26);
                sparseIntArray.append(F.d.f1475x2, 55);
                sparseIntArray.append(F.d.f1102E2, 54);
                sparseIntArray.append(F.d.f1261Y1, 29);
                sparseIntArray.append(F.d.f1395n2, 30);
                sparseIntArray.append(F.d.f1173N1, 44);
                sparseIntArray.append(F.d.f1278a2, 45);
                sparseIntArray.append(F.d.f1411p2, 46);
                sparseIntArray.append(F.d.f1269Z1, 47);
                sparseIntArray.append(F.d.f1403o2, 48);
                sparseIntArray.append(F.d.f1085C1, 27);
                sparseIntArray.append(F.d.f1077B1, 28);
                sparseIntArray.append(F.d.f1427r2, 31);
                sparseIntArray.append(F.d.f1229U1, 32);
                sparseIntArray.append(F.d.f1443t2, 33);
                sparseIntArray.append(F.d.f1435s2, 34);
                sparseIntArray.append(F.d.f1451u2, 35);
                sparseIntArray.append(F.d.f1245W1, 36);
                sparseIntArray.append(F.d.f1237V1, 37);
                sparseIntArray.append(F.d.f1253X1, 38);
                sparseIntArray.append(F.d.f1287b2, 39);
                sparseIntArray.append(F.d.f1368k2, 40);
                sparseIntArray.append(F.d.f1314e2, 41);
                sparseIntArray.append(F.d.f1125H1, 42);
                sparseIntArray.append(F.d.f1093D1, 43);
                sparseIntArray.append(F.d.f1359j2, 51);
                sparseIntArray.append(F.d.f1118G2, 66);
            }
        }

        public b(int i8, int i9) {
            super(i8, i9);
            this.f10856a = -1;
            this.f10858b = -1;
            this.f10860c = -1.0f;
            this.f10862d = true;
            this.f10864e = -1;
            this.f10866f = -1;
            this.f10868g = -1;
            this.f10870h = -1;
            this.f10872i = -1;
            this.f10874j = -1;
            this.f10876k = -1;
            this.f10878l = -1;
            this.f10880m = -1;
            this.f10882n = -1;
            this.f10884o = -1;
            this.f10886p = -1;
            this.f10888q = 0;
            this.f10890r = 0.0f;
            this.f10892s = -1;
            this.f10894t = -1;
            this.f10896u = -1;
            this.f10898v = -1;
            this.f10900w = Integer.MIN_VALUE;
            this.f10902x = Integer.MIN_VALUE;
            this.f10903y = Integer.MIN_VALUE;
            this.f10904z = Integer.MIN_VALUE;
            this.f10830A = Integer.MIN_VALUE;
            this.f10831B = Integer.MIN_VALUE;
            this.f10832C = Integer.MIN_VALUE;
            this.f10833D = 0;
            this.f10834E = true;
            this.f10835F = true;
            this.f10836G = 0.5f;
            this.f10837H = 0.5f;
            this.f10838I = null;
            this.f10839J = 0.0f;
            this.f10840K = 1;
            this.f10841L = -1.0f;
            this.f10842M = -1.0f;
            this.f10843N = 0;
            this.f10844O = 0;
            this.f10845P = 0;
            this.f10846Q = 0;
            this.f10847R = 0;
            this.f10848S = 0;
            this.f10849T = 0;
            this.f10850U = 0;
            this.f10851V = 1.0f;
            this.f10852W = 1.0f;
            this.f10853X = -1;
            this.f10854Y = -1;
            this.f10855Z = -1;
            this.f10857a0 = false;
            this.f10859b0 = false;
            this.f10861c0 = null;
            this.f10863d0 = 0;
            this.f10865e0 = true;
            this.f10867f0 = true;
            this.f10869g0 = false;
            this.f10871h0 = false;
            this.f10873i0 = false;
            this.f10875j0 = false;
            this.f10877k0 = false;
            this.f10879l0 = -1;
            this.f10881m0 = -1;
            this.f10883n0 = -1;
            this.f10885o0 = -1;
            this.f10887p0 = Integer.MIN_VALUE;
            this.f10889q0 = Integer.MIN_VALUE;
            this.f10891r0 = 0.5f;
            this.f10899v0 = new C.e();
            this.f10901w0 = false;
        }

        public void a() {
            this.f10871h0 = false;
            this.f10865e0 = true;
            this.f10867f0 = true;
            int i8 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i8 == -2 && this.f10857a0) {
                this.f10865e0 = false;
                if (this.f10845P == 0) {
                    this.f10845P = 1;
                }
            }
            int i9 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i9 == -2 && this.f10859b0) {
                this.f10867f0 = false;
                if (this.f10846Q == 0) {
                    this.f10846Q = 1;
                }
            }
            if (i8 == 0 || i8 == -1) {
                this.f10865e0 = false;
                if (i8 == 0 && this.f10845P == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.f10857a0 = true;
                }
            }
            if (i9 == 0 || i9 == -1) {
                this.f10867f0 = false;
                if (i9 == 0 && this.f10846Q == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.f10859b0 = true;
                }
            }
            if (this.f10860c == -1.0f && this.f10856a == -1 && this.f10858b == -1) {
                return;
            }
            this.f10871h0 = true;
            this.f10865e0 = true;
            this.f10867f0 = true;
            if (!(this.f10899v0 instanceof g)) {
                this.f10899v0 = new g();
            }
            ((g) this.f10899v0).w1(this.f10855Z);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x00d2  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void resolveLayoutDirection(int r11) {
            /*
                Method dump skipped, instruction units count: 255
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.b.resolveLayoutDirection(int):void");
        }

        public b(Context context, AttributeSet attributeSet) {
            String str;
            super(context, attributeSet);
            this.f10856a = -1;
            this.f10858b = -1;
            this.f10860c = -1.0f;
            this.f10862d = true;
            this.f10864e = -1;
            this.f10866f = -1;
            this.f10868g = -1;
            this.f10870h = -1;
            this.f10872i = -1;
            this.f10874j = -1;
            this.f10876k = -1;
            this.f10878l = -1;
            this.f10880m = -1;
            this.f10882n = -1;
            this.f10884o = -1;
            this.f10886p = -1;
            this.f10888q = 0;
            this.f10890r = 0.0f;
            this.f10892s = -1;
            this.f10894t = -1;
            this.f10896u = -1;
            this.f10898v = -1;
            this.f10900w = Integer.MIN_VALUE;
            this.f10902x = Integer.MIN_VALUE;
            this.f10903y = Integer.MIN_VALUE;
            this.f10904z = Integer.MIN_VALUE;
            this.f10830A = Integer.MIN_VALUE;
            this.f10831B = Integer.MIN_VALUE;
            this.f10832C = Integer.MIN_VALUE;
            this.f10833D = 0;
            this.f10834E = true;
            this.f10835F = true;
            this.f10836G = 0.5f;
            this.f10837H = 0.5f;
            this.f10838I = null;
            this.f10839J = 0.0f;
            this.f10840K = 1;
            this.f10841L = -1.0f;
            this.f10842M = -1.0f;
            this.f10843N = 0;
            this.f10844O = 0;
            this.f10845P = 0;
            this.f10846Q = 0;
            this.f10847R = 0;
            this.f10848S = 0;
            this.f10849T = 0;
            this.f10850U = 0;
            this.f10851V = 1.0f;
            this.f10852W = 1.0f;
            this.f10853X = -1;
            this.f10854Y = -1;
            this.f10855Z = -1;
            this.f10857a0 = false;
            this.f10859b0 = false;
            this.f10861c0 = null;
            this.f10863d0 = 0;
            this.f10865e0 = true;
            this.f10867f0 = true;
            this.f10869g0 = false;
            this.f10871h0 = false;
            this.f10873i0 = false;
            this.f10875j0 = false;
            this.f10877k0 = false;
            this.f10879l0 = -1;
            this.f10881m0 = -1;
            this.f10883n0 = -1;
            this.f10885o0 = -1;
            this.f10887p0 = Integer.MIN_VALUE;
            this.f10889q0 = Integer.MIN_VALUE;
            this.f10891r0 = 0.5f;
            this.f10899v0 = new C.e();
            this.f10901w0 = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, F.d.f1394n1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i8);
                int i9 = a.f10905a.get(index);
                switch (i9) {
                    case 1:
                        this.f10855Z = typedArrayObtainStyledAttributes.getInt(index, this.f10855Z);
                        continue;
                        break;
                    case 2:
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f10886p);
                        this.f10886p = resourceId;
                        if (resourceId == -1) {
                            this.f10886p = typedArrayObtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                        break;
                    case 3:
                        this.f10888q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f10888q);
                        continue;
                        break;
                    case 4:
                        float f8 = typedArrayObtainStyledAttributes.getFloat(index, this.f10890r) % 360.0f;
                        this.f10890r = f8;
                        if (f8 < 0.0f) {
                            this.f10890r = (360.0f - f8) % 360.0f;
                        } else {
                            continue;
                        }
                        break;
                    case 5:
                        this.f10856a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f10856a);
                        continue;
                        break;
                    case 6:
                        this.f10858b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f10858b);
                        continue;
                        break;
                    case 7:
                        this.f10860c = typedArrayObtainStyledAttributes.getFloat(index, this.f10860c);
                        continue;
                        break;
                    case 8:
                        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, this.f10864e);
                        this.f10864e = resourceId2;
                        if (resourceId2 == -1) {
                            this.f10864e = typedArrayObtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                        break;
                    case 9:
                        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, this.f10866f);
                        this.f10866f = resourceId3;
                        if (resourceId3 == -1) {
                            this.f10866f = typedArrayObtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                        break;
                    case 10:
                        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, this.f10868g);
                        this.f10868g = resourceId4;
                        if (resourceId4 == -1) {
                            this.f10868g = typedArrayObtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                        break;
                    case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                        int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, this.f10870h);
                        this.f10870h = resourceId5;
                        if (resourceId5 == -1) {
                            this.f10870h = typedArrayObtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                        break;
                    case 12:
                        int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, this.f10872i);
                        this.f10872i = resourceId6;
                        if (resourceId6 == -1) {
                            this.f10872i = typedArrayObtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                        break;
                    case 13:
                        int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, this.f10874j);
                        this.f10874j = resourceId7;
                        if (resourceId7 == -1) {
                            this.f10874j = typedArrayObtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                        break;
                    case 14:
                        int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, this.f10876k);
                        this.f10876k = resourceId8;
                        if (resourceId8 == -1) {
                            this.f10876k = typedArrayObtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                        break;
                    case 15:
                        int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, this.f10878l);
                        this.f10878l = resourceId9;
                        if (resourceId9 == -1) {
                            this.f10878l = typedArrayObtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                        break;
                    case com.amazon.c.a.a.c.f14230g /* 16 */:
                        int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, this.f10880m);
                        this.f10880m = resourceId10;
                        if (resourceId10 == -1) {
                            this.f10880m = typedArrayObtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                        break;
                    case 17:
                        int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, this.f10892s);
                        this.f10892s = resourceId11;
                        if (resourceId11 == -1) {
                            this.f10892s = typedArrayObtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                        break;
                    case 18:
                        int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, this.f10894t);
                        this.f10894t = resourceId12;
                        if (resourceId12 == -1) {
                            this.f10894t = typedArrayObtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                        break;
                    case 19:
                        int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, this.f10896u);
                        this.f10896u = resourceId13;
                        if (resourceId13 == -1) {
                            this.f10896u = typedArrayObtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                        break;
                    case 20:
                        int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, this.f10898v);
                        this.f10898v = resourceId14;
                        if (resourceId14 == -1) {
                            this.f10898v = typedArrayObtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                        break;
                    case 21:
                        this.f10900w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f10900w);
                        continue;
                        break;
                    case Build.API_LEVELS.API_22 /* 22 */:
                        this.f10902x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f10902x);
                        continue;
                        break;
                    case Build.API_LEVELS.API_23 /* 23 */:
                        this.f10903y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f10903y);
                        continue;
                        break;
                    case Build.API_LEVELS.API_24 /* 24 */:
                        this.f10904z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f10904z);
                        continue;
                        break;
                    case Build.API_LEVELS.API_25 /* 25 */:
                        this.f10830A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f10830A);
                        continue;
                        break;
                    case Build.API_LEVELS.API_26 /* 26 */:
                        this.f10831B = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f10831B);
                        continue;
                        break;
                    case Build.API_LEVELS.API_27 /* 27 */:
                        this.f10857a0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f10857a0);
                        continue;
                        break;
                    case Build.API_LEVELS.API_28 /* 28 */:
                        this.f10859b0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f10859b0);
                        continue;
                        break;
                    case Build.API_LEVELS.API_29 /* 29 */:
                        this.f10836G = typedArrayObtainStyledAttributes.getFloat(index, this.f10836G);
                        continue;
                        break;
                    case Build.API_LEVELS.API_30 /* 30 */:
                        this.f10837H = typedArrayObtainStyledAttributes.getFloat(index, this.f10837H);
                        continue;
                        break;
                    case Build.API_LEVELS.API_31 /* 31 */:
                        int i10 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.f10845P = i10;
                        if (i10 == 1) {
                            str = "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.";
                        }
                        break;
                    case 32:
                        int i11 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.f10846Q = i11;
                        if (i11 == 1) {
                            str = "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.";
                        }
                        break;
                    case Build.API_LEVELS.API_33 /* 33 */:
                        try {
                            this.f10847R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f10847R);
                            continue;
                        } catch (Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f10847R) == -2) {
                                this.f10847R = -2;
                            }
                        }
                        break;
                    case Build.API_LEVELS.API_34 /* 34 */:
                        try {
                            this.f10849T = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f10849T);
                            continue;
                        } catch (Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f10849T) == -2) {
                                this.f10849T = -2;
                            }
                        }
                        break;
                    case Build.API_LEVELS.API_35 /* 35 */:
                        this.f10851V = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.f10851V));
                        this.f10845P = 2;
                        continue;
                        break;
                    case Build.API_LEVELS.API_36 /* 36 */:
                        try {
                            this.f10848S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f10848S);
                            continue;
                        } catch (Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f10848S) == -2) {
                                this.f10848S = -2;
                            }
                        }
                        break;
                    case 37:
                        try {
                            this.f10850U = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f10850U);
                            continue;
                        } catch (Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f10850U) == -2) {
                                this.f10850U = -2;
                            }
                        }
                        break;
                    case 38:
                        this.f10852W = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.f10852W));
                        this.f10846Q = 2;
                        continue;
                        break;
                    default:
                        switch (i9) {
                            case 44:
                                d.m(this, typedArrayObtainStyledAttributes.getString(index));
                                break;
                            case 45:
                                this.f10841L = typedArrayObtainStyledAttributes.getFloat(index, this.f10841L);
                                break;
                            case 46:
                                this.f10842M = typedArrayObtainStyledAttributes.getFloat(index, this.f10842M);
                                break;
                            case 47:
                                this.f10843N = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.f10844O = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.f10853X = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f10853X);
                                break;
                            case 50:
                                this.f10854Y = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f10854Y);
                                break;
                            case 51:
                                this.f10861c0 = typedArrayObtainStyledAttributes.getString(index);
                                break;
                            case 52:
                                int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(index, this.f10882n);
                                this.f10882n = resourceId15;
                                if (resourceId15 == -1) {
                                    this.f10882n = typedArrayObtainStyledAttributes.getInt(index, -1);
                                }
                                break;
                            case 53:
                                int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(index, this.f10884o);
                                this.f10884o = resourceId16;
                                if (resourceId16 == -1) {
                                    this.f10884o = typedArrayObtainStyledAttributes.getInt(index, -1);
                                }
                                break;
                            case 54:
                                this.f10833D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f10833D);
                                break;
                            case 55:
                                this.f10832C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f10832C);
                                break;
                            default:
                                switch (i9) {
                                    case 64:
                                        d.k(this, typedArrayObtainStyledAttributes, index, 0);
                                        this.f10834E = true;
                                        break;
                                    case 65:
                                        d.k(this, typedArrayObtainStyledAttributes, index, 1);
                                        this.f10835F = true;
                                        break;
                                    case 66:
                                        this.f10863d0 = typedArrayObtainStyledAttributes.getInt(index, this.f10863d0);
                                        break;
                                    case 67:
                                        this.f10862d = typedArrayObtainStyledAttributes.getBoolean(index, this.f10862d);
                                        continue;
                                }
                                break;
                        }
                        break;
                }
                Log.e("ConstraintLayout", str);
            }
            typedArrayObtainStyledAttributes.recycle();
            a();
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f10856a = -1;
            this.f10858b = -1;
            this.f10860c = -1.0f;
            this.f10862d = true;
            this.f10864e = -1;
            this.f10866f = -1;
            this.f10868g = -1;
            this.f10870h = -1;
            this.f10872i = -1;
            this.f10874j = -1;
            this.f10876k = -1;
            this.f10878l = -1;
            this.f10880m = -1;
            this.f10882n = -1;
            this.f10884o = -1;
            this.f10886p = -1;
            this.f10888q = 0;
            this.f10890r = 0.0f;
            this.f10892s = -1;
            this.f10894t = -1;
            this.f10896u = -1;
            this.f10898v = -1;
            this.f10900w = Integer.MIN_VALUE;
            this.f10902x = Integer.MIN_VALUE;
            this.f10903y = Integer.MIN_VALUE;
            this.f10904z = Integer.MIN_VALUE;
            this.f10830A = Integer.MIN_VALUE;
            this.f10831B = Integer.MIN_VALUE;
            this.f10832C = Integer.MIN_VALUE;
            this.f10833D = 0;
            this.f10834E = true;
            this.f10835F = true;
            this.f10836G = 0.5f;
            this.f10837H = 0.5f;
            this.f10838I = null;
            this.f10839J = 0.0f;
            this.f10840K = 1;
            this.f10841L = -1.0f;
            this.f10842M = -1.0f;
            this.f10843N = 0;
            this.f10844O = 0;
            this.f10845P = 0;
            this.f10846Q = 0;
            this.f10847R = 0;
            this.f10848S = 0;
            this.f10849T = 0;
            this.f10850U = 0;
            this.f10851V = 1.0f;
            this.f10852W = 1.0f;
            this.f10853X = -1;
            this.f10854Y = -1;
            this.f10855Z = -1;
            this.f10857a0 = false;
            this.f10859b0 = false;
            this.f10861c0 = null;
            this.f10863d0 = 0;
            this.f10865e0 = true;
            this.f10867f0 = true;
            this.f10869g0 = false;
            this.f10871h0 = false;
            this.f10873i0 = false;
            this.f10875j0 = false;
            this.f10877k0 = false;
            this.f10879l0 = -1;
            this.f10881m0 = -1;
            this.f10883n0 = -1;
            this.f10885o0 = -1;
            this.f10887p0 = Integer.MIN_VALUE;
            this.f10889q0 = Integer.MIN_VALUE;
            this.f10891r0 = 0.5f;
            this.f10899v0 = new C.e();
            this.f10901w0 = false;
        }
    }

    public class c implements b.InterfaceC0012b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ConstraintLayout f10906a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f10907b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f10908c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f10909d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f10910e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f10911f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f10912g;

        public c(ConstraintLayout constraintLayout) {
            this.f10906a = constraintLayout;
        }

        @Override // D.b.InterfaceC0012b
        public final void a() {
            int childCount = this.f10906a.getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                this.f10906a.getChildAt(i8);
            }
            int size = this.f10906a.f10807b.size();
            if (size > 0) {
                for (int i9 = 0; i9 < size; i9++) {
                    ((androidx.constraintlayout.widget.c) this.f10906a.f10807b.get(i9)).j(this.f10906a);
                }
            }
        }

        @Override // D.b.InterfaceC0012b
        public final void b(C.e eVar, b.a aVar) {
            int iMakeMeasureSpec;
            int iMakeMeasureSpec2;
            int baseline;
            int iMax;
            int i8;
            int measuredHeight;
            int i9;
            int i10;
            int i11;
            int i12;
            int i13;
            if (eVar == null) {
                return;
            }
            if (eVar.T() == 8 && !eVar.h0()) {
                aVar.f653e = 0;
                aVar.f654f = 0;
                aVar.f655g = 0;
                return;
            }
            if (eVar.I() == null) {
                return;
            }
            e.b bVar = aVar.f649a;
            e.b bVar2 = aVar.f650b;
            int iU = aVar.f651c;
            int iV = aVar.f652d;
            int iS = this.f10907b + this.f10908c;
            int iZ = this.f10909d;
            View view = (View) eVar.q();
            int[] iArr = a.f10829a;
            int i14 = iArr[bVar.ordinal()];
            if (i14 == 1) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iU, 1073741824);
            } else {
                if (i14 == 2) {
                    i12 = this.f10911f;
                    i13 = -2;
                } else if (i14 == 3) {
                    i12 = this.f10911f;
                    iZ += eVar.z();
                    i13 = -1;
                } else if (i14 != 4) {
                    iMakeMeasureSpec = 0;
                } else {
                    iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f10911f, iZ, -2);
                    boolean z7 = eVar.f367w == 1;
                    int i15 = aVar.f658j;
                    if (i15 == b.a.f647l || i15 == b.a.f648m) {
                        boolean z8 = view.getMeasuredHeight() == eVar.v();
                        if (aVar.f658j == b.a.f648m || !z7 || ((z7 && z8) || eVar.l0())) {
                            iU = eVar.U();
                            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iU, 1073741824);
                        }
                    }
                }
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(i12, iZ, i13);
            }
            int i16 = iArr[bVar2.ordinal()];
            if (i16 == 1) {
                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iV, 1073741824);
            } else {
                if (i16 == 2) {
                    i10 = this.f10912g;
                    i11 = -2;
                } else if (i16 == 3) {
                    i10 = this.f10912g;
                    iS += eVar.S();
                    i11 = -1;
                } else if (i16 != 4) {
                    iMakeMeasureSpec2 = 0;
                } else {
                    iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f10912g, iS, -2);
                    boolean z9 = eVar.f369x == 1;
                    int i17 = aVar.f658j;
                    if (i17 == b.a.f647l || i17 == b.a.f648m) {
                        boolean z10 = view.getMeasuredWidth() == eVar.U();
                        if (aVar.f658j == b.a.f648m || !z9 || ((z9 && z10) || eVar.m0())) {
                            iV = eVar.v();
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iV, 1073741824);
                        }
                    }
                }
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(i10, iS, i11);
            }
            f fVar = (f) eVar.I();
            if (fVar != null && j.b(ConstraintLayout.this.f10814i, 256) && view.getMeasuredWidth() == eVar.U() && view.getMeasuredWidth() < fVar.U() && view.getMeasuredHeight() == eVar.v() && view.getMeasuredHeight() < fVar.v() && view.getBaseline() == eVar.n() && !eVar.k0() && d(eVar.A(), iMakeMeasureSpec, eVar.U()) && d(eVar.B(), iMakeMeasureSpec2, eVar.v())) {
                aVar.f653e = eVar.U();
                aVar.f654f = eVar.v();
                aVar.f655g = eVar.n();
                return;
            }
            e.b bVar3 = e.b.MATCH_CONSTRAINT;
            boolean z11 = bVar == bVar3;
            boolean z12 = bVar2 == bVar3;
            e.b bVar4 = e.b.MATCH_PARENT;
            boolean z13 = bVar2 == bVar4 || bVar2 == e.b.FIXED;
            boolean z14 = bVar == bVar4 || bVar == e.b.FIXED;
            boolean z15 = z11 && eVar.f330d0 > 0.0f;
            boolean z16 = z12 && eVar.f330d0 > 0.0f;
            if (view == null) {
                return;
            }
            b bVar5 = (b) view.getLayoutParams();
            int i18 = aVar.f658j;
            if (i18 != b.a.f647l && i18 != b.a.f648m && z11 && eVar.f367w == 0 && z12 && eVar.f369x == 0) {
                i9 = -1;
                measuredHeight = 0;
                baseline = 0;
                iMax = 0;
            } else {
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                eVar.R0(iMakeMeasureSpec, iMakeMeasureSpec2);
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight2 = view.getMeasuredHeight();
                baseline = view.getBaseline();
                int i19 = eVar.f373z;
                iMax = i19 > 0 ? Math.max(i19, measuredWidth) : measuredWidth;
                int i20 = eVar.f287A;
                if (i20 > 0) {
                    iMax = Math.min(i20, iMax);
                }
                int i21 = eVar.f291C;
                if (i21 > 0) {
                    measuredHeight = Math.max(i21, measuredHeight2);
                    i8 = iMakeMeasureSpec;
                } else {
                    i8 = iMakeMeasureSpec;
                    measuredHeight = measuredHeight2;
                }
                int i22 = eVar.f293D;
                if (i22 > 0) {
                    measuredHeight = Math.min(i22, measuredHeight);
                }
                if (!j.b(ConstraintLayout.this.f10814i, 1)) {
                    if (z15 && z13) {
                        iMax = (int) ((measuredHeight * eVar.f330d0) + 0.5f);
                    } else if (z16 && z14) {
                        measuredHeight = (int) ((iMax / eVar.f330d0) + 0.5f);
                    }
                }
                if (measuredWidth != iMax || measuredHeight2 != measuredHeight) {
                    int iMakeMeasureSpec3 = measuredWidth != iMax ? View.MeasureSpec.makeMeasureSpec(iMax, 1073741824) : i8;
                    if (measuredHeight2 != measuredHeight) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
                    }
                    view.measure(iMakeMeasureSpec3, iMakeMeasureSpec2);
                    eVar.R0(iMakeMeasureSpec3, iMakeMeasureSpec2);
                    iMax = view.getMeasuredWidth();
                    measuredHeight = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                }
                i9 = -1;
            }
            boolean z17 = baseline != i9;
            aVar.f657i = (iMax == aVar.f651c && measuredHeight == aVar.f652d) ? false : true;
            if (bVar5.f10869g0) {
                z17 = true;
            }
            if (z17 && baseline != -1 && eVar.n() != baseline) {
                aVar.f657i = true;
            }
            aVar.f653e = iMax;
            aVar.f654f = measuredHeight;
            aVar.f656h = z17;
            aVar.f655g = baseline;
        }

        public void c(int i8, int i9, int i10, int i11, int i12, int i13) {
            this.f10907b = i10;
            this.f10908c = i11;
            this.f10909d = i12;
            this.f10910e = i13;
            this.f10911f = i8;
            this.f10912g = i9;
        }

        public final boolean d(int i8, int i9, int i10) {
            if (i8 == i9) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i8);
            View.MeasureSpec.getSize(i8);
            int mode2 = View.MeasureSpec.getMode(i9);
            int size = View.MeasureSpec.getSize(i9);
            if (mode2 == 1073741824) {
                return (mode == Integer.MIN_VALUE || mode == 0) && i10 == size;
            }
            return false;
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10806a = new SparseArray();
        this.f10807b = new ArrayList(4);
        this.f10808c = new f();
        this.f10809d = 0;
        this.f10810e = 0;
        this.f10811f = Integer.MAX_VALUE;
        this.f10812g = Integer.MAX_VALUE;
        this.f10813h = true;
        this.f10814i = 257;
        this.f10815j = null;
        this.f10816k = null;
        this.f10817l = -1;
        this.f10818m = new HashMap();
        this.f10819n = -1;
        this.f10820o = -1;
        this.f10821p = -1;
        this.f10822q = -1;
        this.f10823r = 0;
        this.f10824s = 0;
        this.f10825t = new SparseArray();
        this.f10826u = new c(this);
        this.f10827v = 0;
        this.f10828w = 0;
        p(attributeSet, 0, 0);
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int iMax2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    public static F.e getSharedValues() {
        if (f10805x == null) {
            f10805x = new F.e();
        }
        return f10805x;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList arrayList = this.f10807b;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i8 = 0; i8 < size; i8++) {
                ((androidx.constraintlayout.widget.c) this.f10807b.get(i8)).k(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(com.amazon.a.a.o.b.f.f14100a);
                    if (strArrSplit.length == 4) {
                        int i10 = Integer.parseInt(strArrSplit[0]);
                        int i11 = Integer.parseInt(strArrSplit[1]);
                        int i12 = Integer.parseInt(strArrSplit[2]);
                        int i13 = (int) ((i10 / 1080.0f) * width);
                        int i14 = (int) ((i11 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f8 = i13;
                        float f9 = i14;
                        float f10 = i13 + ((int) ((i12 / 1080.0f) * width));
                        canvas.drawLine(f8, f9, f10, f9, paint);
                        float f11 = i14 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f10, f9, f10, f11, paint);
                        canvas.drawLine(f10, f11, f8, f11, paint);
                        canvas.drawLine(f8, f11, f8, f9, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f8, f9, f10, f11, paint);
                        canvas.drawLine(f8, f11, f10, f9, paint);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void forceLayout() {
        r();
        super.forceLayout();
    }

    public int getMaxHeight() {
        return this.f10812g;
    }

    public int getMaxWidth() {
        return this.f10811f;
    }

    public int getMinHeight() {
        return this.f10810e;
    }

    public int getMinWidth() {
        return this.f10809d;
    }

    public int getOptimizationLevel() {
        return this.f10808c.F1();
    }

    public String getSceneString() {
        int id;
        StringBuilder sb = new StringBuilder();
        if (this.f10808c.f351o == null) {
            int id2 = getId();
            if (id2 != -1) {
                this.f10808c.f351o = getContext().getResources().getResourceEntryName(id2);
            } else {
                this.f10808c.f351o = "parent";
            }
        }
        if (this.f10808c.r() == null) {
            f fVar = this.f10808c;
            fVar.z0(fVar.f351o);
            Log.v("ConstraintLayout", " setDebugName " + this.f10808c.r());
        }
        for (C.e eVar : this.f10808c.n1()) {
            View view = (View) eVar.q();
            if (view != null) {
                if (eVar.f351o == null && (id = view.getId()) != -1) {
                    eVar.f351o = getContext().getResources().getResourceEntryName(id);
                }
                if (eVar.r() == null) {
                    eVar.z0(eVar.f351o);
                    Log.v("ConstraintLayout", " setDebugName " + eVar.r());
                }
            }
        }
        this.f10808c.M(sb);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0166  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i(boolean r17, android.view.View r18, C.e r19, androidx.constraintlayout.widget.ConstraintLayout.b r20, android.util.SparseArray r21) {
        /*
            Method dump skipped, instruction units count: 570
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.i(boolean, android.view.View, C.e, androidx.constraintlayout.widget.ConstraintLayout$b, android.util.SparseArray):void");
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    public Object l(int i8, Object obj) {
        if (i8 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap map = this.f10818m;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f10818m.get(str);
    }

    public final C.e m(int i8) {
        if (i8 == 0) {
            return this.f10808c;
        }
        View viewFindViewById = (View) this.f10806a.get(i8);
        if (viewFindViewById == null && (viewFindViewById = findViewById(i8)) != null && viewFindViewById != this && viewFindViewById.getParent() == this) {
            onViewAdded(viewFindViewById);
        }
        if (viewFindViewById == this) {
            return this.f10808c;
        }
        if (viewFindViewById == null) {
            return null;
        }
        return ((b) viewFindViewById.getLayoutParams()).f10899v0;
    }

    public View n(int i8) {
        return (View) this.f10806a.get(i8);
    }

    public final C.e o(View view) {
        if (view == this) {
            return this.f10808c;
        }
        if (view == null) {
            return null;
        }
        if (!(view.getLayoutParams() instanceof b)) {
            view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
            if (!(view.getLayoutParams() instanceof b)) {
                return null;
            }
        }
        return ((b) view.getLayoutParams()).f10899v0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            b bVar = (b) childAt.getLayoutParams();
            C.e eVar = bVar.f10899v0;
            if ((childAt.getVisibility() != 8 || bVar.f10871h0 || bVar.f10873i0 || bVar.f10877k0 || zIsInEditMode) && !bVar.f10875j0) {
                int iV = eVar.V();
                int iW = eVar.W();
                childAt.layout(iV, iW, eVar.U() + iV, eVar.v() + iW);
            }
        }
        int size = this.f10807b.size();
        if (size > 0) {
            for (int i13 = 0; i13 < size; i13++) {
                ((androidx.constraintlayout.widget.c) this.f10807b.get(i13)).i(this);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i8, int i9) {
        if (this.f10827v == i8) {
            int i10 = this.f10828w;
        }
        if (!this.f10813h) {
            int childCount = getChildCount();
            int i11 = 0;
            while (true) {
                if (i11 >= childCount) {
                    break;
                }
                if (getChildAt(i11).isLayoutRequested()) {
                    this.f10813h = true;
                    break;
                }
                i11++;
            }
        }
        this.f10827v = i8;
        this.f10828w = i9;
        this.f10808c.T1(q());
        if (this.f10813h) {
            this.f10813h = false;
            if (z()) {
                this.f10808c.V1();
            }
        }
        u(this.f10808c, this.f10814i, i8, i9);
        t(i8, i9, this.f10808c.U(), this.f10808c.v(), this.f10808c.L1(), this.f10808c.J1());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        C.e eVarO = o(view);
        if ((view instanceof e) && !(eVarO instanceof g)) {
            b bVar = (b) view.getLayoutParams();
            g gVar = new g();
            bVar.f10899v0 = gVar;
            bVar.f10871h0 = true;
            gVar.w1(bVar.f10855Z);
        }
        if (view instanceof androidx.constraintlayout.widget.c) {
            androidx.constraintlayout.widget.c cVar = (androidx.constraintlayout.widget.c) view;
            cVar.m();
            ((b) view.getLayoutParams()).f10873i0 = true;
            if (!this.f10807b.contains(cVar)) {
                this.f10807b.add(cVar);
            }
        }
        this.f10806a.put(view.getId(), view);
        this.f10813h = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f10806a.remove(view.getId());
        this.f10808c.p1(o(view));
        this.f10807b.remove(view);
        this.f10813h = true;
    }

    public final void p(AttributeSet attributeSet, int i8, int i9) {
        this.f10808c.y0(this);
        this.f10808c.Q1(this.f10826u);
        this.f10806a.put(getId(), this);
        this.f10815j = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, F.d.f1394n1, i8, i9);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == F.d.f1426r1) {
                    this.f10809d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f10809d);
                } else if (index == F.d.f1434s1) {
                    this.f10810e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f10810e);
                } else if (index == F.d.f1410p1) {
                    this.f10811f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f10811f);
                } else if (index == F.d.f1418q1) {
                    this.f10812g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f10812g);
                } else if (index == F.d.f1110F2) {
                    this.f10814i = typedArrayObtainStyledAttributes.getInt(index, this.f10814i);
                } else if (index == F.d.f1069A1) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            s(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f10816k = null;
                        }
                    }
                } else if (index == F.d.f1466w1) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        d dVar = new d();
                        this.f10815j = dVar;
                        dVar.h(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f10815j = null;
                    }
                    this.f10817l = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f10808c.R1(this.f10814i);
    }

    public boolean q() {
        return (getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection();
    }

    public final void r() {
        this.f10813h = true;
        this.f10819n = -1;
        this.f10820o = -1;
        this.f10821p = -1;
        this.f10822q = -1;
        this.f10823r = 0;
        this.f10824s = 0;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        r();
        super.requestLayout();
    }

    public void s(int i8) {
        this.f10816k = new F.a(getContext(), this, i8);
    }

    public void setConstraintSet(d dVar) {
        this.f10815j = dVar;
    }

    @Override // android.view.View
    public void setId(int i8) {
        this.f10806a.remove(getId());
        super.setId(i8);
        this.f10806a.put(getId(), this);
    }

    public void setMaxHeight(int i8) {
        if (i8 == this.f10812g) {
            return;
        }
        this.f10812g = i8;
        requestLayout();
    }

    public void setMaxWidth(int i8) {
        if (i8 == this.f10811f) {
            return;
        }
        this.f10811f = i8;
        requestLayout();
    }

    public void setMinHeight(int i8) {
        if (i8 == this.f10810e) {
            return;
        }
        this.f10810e = i8;
        requestLayout();
    }

    public void setMinWidth(int i8) {
        if (i8 == this.f10809d) {
            return;
        }
        this.f10809d = i8;
        requestLayout();
    }

    public void setOnConstraintsChanged(F.b bVar) {
        F.a aVar = this.f10816k;
        if (aVar != null) {
            aVar.c(bVar);
        }
    }

    public void setOptimizationLevel(int i8) {
        this.f10814i = i8;
        this.f10808c.R1(i8);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void t(int i8, int i9, int i10, int i11, boolean z7, boolean z8) {
        c cVar = this.f10826u;
        int i12 = cVar.f10910e;
        int iResolveSizeAndState = View.resolveSizeAndState(i10 + cVar.f10909d, i8, 0);
        int iResolveSizeAndState2 = View.resolveSizeAndState(i11 + i12, i9, 0) & 16777215;
        int iMin = Math.min(this.f10811f, iResolveSizeAndState & 16777215);
        int iMin2 = Math.min(this.f10812g, iResolveSizeAndState2);
        if (z7) {
            iMin |= 16777216;
        }
        if (z8) {
            iMin2 |= 16777216;
        }
        setMeasuredDimension(iMin, iMin2);
        this.f10819n = iMin;
        this.f10820o = iMin2;
    }

    public void u(f fVar, int i8, int i9, int i10) {
        int mode = View.MeasureSpec.getMode(i9);
        int size = View.MeasureSpec.getSize(i9);
        int mode2 = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i10);
        int iMax = Math.max(0, getPaddingTop());
        int iMax2 = Math.max(0, getPaddingBottom());
        int i11 = iMax + iMax2;
        int paddingWidth = getPaddingWidth();
        this.f10826u.c(i9, i10, iMax, iMax2, paddingWidth, i11);
        int iMax3 = Math.max(0, getPaddingStart());
        int iMax4 = Math.max(0, getPaddingEnd());
        int iMax5 = (iMax3 > 0 || iMax4 > 0) ? q() ? iMax4 : iMax3 : Math.max(0, getPaddingLeft());
        int i12 = size - paddingWidth;
        int i13 = size2 - i11;
        x(fVar, mode, i12, mode2, i13);
        fVar.M1(i8, mode, i12, mode2, i13, this.f10819n, this.f10820o, iMax5, iMax);
    }

    public final void v() {
        boolean zIsInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            C.e eVarO = o(getChildAt(i8));
            if (eVarO != null) {
                eVarO.r0();
            }
        }
        if (zIsInEditMode) {
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    w(0, resourceName, Integer.valueOf(childAt.getId()));
                    int iIndexOf = resourceName.indexOf(47);
                    if (iIndexOf != -1) {
                        resourceName = resourceName.substring(iIndexOf + 1);
                    }
                    m(childAt.getId()).z0(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.f10817l != -1) {
            for (int i10 = 0; i10 < childCount; i10++) {
                getChildAt(i10).getId();
            }
        }
        d dVar = this.f10815j;
        if (dVar != null) {
            dVar.c(this, true);
        }
        this.f10808c.q1();
        int size = this.f10807b.size();
        if (size > 0) {
            for (int i11 = 0; i11 < size; i11++) {
                ((androidx.constraintlayout.widget.c) this.f10807b.get(i11)).l(this);
            }
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            getChildAt(i12);
        }
        this.f10825t.clear();
        this.f10825t.put(0, this.f10808c);
        this.f10825t.put(getId(), this.f10808c);
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt2 = getChildAt(i13);
            this.f10825t.put(childAt2.getId(), o(childAt2));
        }
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt3 = getChildAt(i14);
            C.e eVarO2 = o(childAt3);
            if (eVarO2 != null) {
                b bVar = (b) childAt3.getLayoutParams();
                this.f10808c.a(eVarO2);
                i(zIsInEditMode, childAt3, eVarO2, bVar, this.f10825t);
            }
        }
    }

    public void w(int i8, Object obj, Object obj2) {
        if (i8 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f10818m == null) {
                this.f10818m = new HashMap();
            }
            String strSubstring = (String) obj;
            int iIndexOf = strSubstring.indexOf("/");
            if (iIndexOf != -1) {
                strSubstring = strSubstring.substring(iIndexOf + 1);
            }
            Integer num = (Integer) obj2;
            num.intValue();
            this.f10818m.put(strSubstring, num);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027 A[PHI: r9
      0x0027: PHI (r9v2 C.e$b) = (r9v1 C.e$b), (r9v8 C.e$b) binds: [B:13:0x0030, B:10:0x0025] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0047 A[PHI: r2
      0x0047: PHI (r2v2 C.e$b) = (r2v1 C.e$b), (r2v4 C.e$b) binds: [B:24:0x0050, B:21:0x0045] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void x(C.f r8, int r9, int r10, int r11, int r12) {
        /*
            r7 = this;
            androidx.constraintlayout.widget.ConstraintLayout$c r0 = r7.f10826u
            int r1 = r0.f10910e
            int r0 = r0.f10909d
            C.e$b r2 = C.e.b.FIXED
            int r3 = r7.getChildCount()
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = 0
            if (r9 == r5) goto L2e
            if (r9 == 0) goto L23
            if (r9 == r4) goto L1a
            r9 = r2
        L18:
            r10 = r6
            goto L33
        L1a:
            int r9 = r7.f10811f
            int r9 = r9 - r0
            int r10 = java.lang.Math.min(r9, r10)
            r9 = r2
            goto L33
        L23:
            C.e$b r9 = C.e.b.WRAP_CONTENT
            if (r3 != 0) goto L18
        L27:
            int r10 = r7.f10809d
            int r10 = java.lang.Math.max(r6, r10)
            goto L33
        L2e:
            C.e$b r9 = C.e.b.WRAP_CONTENT
            if (r3 != 0) goto L33
            goto L27
        L33:
            if (r11 == r5) goto L4e
            if (r11 == 0) goto L43
            if (r11 == r4) goto L3b
        L39:
            r12 = r6
            goto L53
        L3b:
            int r11 = r7.f10812g
            int r11 = r11 - r1
            int r12 = java.lang.Math.min(r11, r12)
            goto L53
        L43:
            C.e$b r2 = C.e.b.WRAP_CONTENT
            if (r3 != 0) goto L39
        L47:
            int r11 = r7.f10810e
            int r12 = java.lang.Math.max(r6, r11)
            goto L53
        L4e:
            C.e$b r2 = C.e.b.WRAP_CONTENT
            if (r3 != 0) goto L53
            goto L47
        L53:
            int r11 = r8.U()
            if (r10 != r11) goto L5f
            int r11 = r8.v()
            if (r12 == r11) goto L62
        L5f:
            r8.I1()
        L62:
            r8.i1(r6)
            r8.j1(r6)
            int r11 = r7.f10811f
            int r11 = r11 - r0
            r8.T0(r11)
            int r11 = r7.f10812g
            int r11 = r11 - r1
            r8.S0(r11)
            r8.W0(r6)
            r8.V0(r6)
            r8.M0(r9)
            r8.g1(r10)
            r8.c1(r2)
            r8.I0(r12)
            int r9 = r7.f10809d
            int r9 = r9 - r0
            r8.W0(r9)
            int r9 = r7.f10810e
            int r9 = r9 - r1
            r8.V0(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.x(C.f, int, int, int, int):void");
    }

    public final void y(C.e eVar, b bVar, SparseArray sparseArray, int i8, d.b bVar2) {
        View view = (View) this.f10806a.get(i8);
        C.e eVar2 = (C.e) sparseArray.get(i8);
        if (eVar2 == null || view == null || !(view.getLayoutParams() instanceof b)) {
            return;
        }
        bVar.f10869g0 = true;
        d.b bVar3 = d.b.BASELINE;
        if (bVar2 == bVar3) {
            b bVar4 = (b) view.getLayoutParams();
            bVar4.f10869g0 = true;
            bVar4.f10899v0.H0(true);
        }
        eVar.m(bVar3).a(eVar2.m(bVar2), bVar.f10833D, bVar.f10832C, true);
        eVar.H0(true);
        eVar.m(d.b.TOP).p();
        eVar.m(d.b.BOTTOM).p();
    }

    public final boolean z() {
        int childCount = getChildCount();
        boolean z7 = false;
        int i8 = 0;
        while (true) {
            if (i8 >= childCount) {
                break;
            }
            if (getChildAt(i8).isLayoutRequested()) {
                z7 = true;
                break;
            }
            i8++;
        }
        if (z7) {
            v();
        }
        return z7;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }
}
