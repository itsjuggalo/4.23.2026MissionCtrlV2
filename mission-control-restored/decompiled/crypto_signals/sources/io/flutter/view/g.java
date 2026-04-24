package io.flutter.view;

import android.graphics.Rect;
import android.opengl.Matrix;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LocaleSpan;
import android.text.style.TtsSpan;
import android.text.style.URLSpan;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public String f7270A;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public long f7273D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public int f7274E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public int f7275F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public int f7276G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public float f7277H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public String f7278I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public String f7279J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public float f7280K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public float f7281L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public float f7282M;
    public float N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public float[] f7283O;
    public g P;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public ArrayList f7286S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public e f7287T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public e f7288U;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public float[] f7290W;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public float[] f7292Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public Rect f7293Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f7294a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f7296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7297d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f7298f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f7299g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f7300h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f7301j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f7302k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f7303l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f7304m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f7305n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f7306o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f7307p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList f7308q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f7309r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ArrayList f7310s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f7311t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ArrayList f7312u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f7313v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ArrayList f7314w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f7315x;
    public ArrayList y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f7316z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7295b = -1;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public int f7271B = -1;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public boolean f7272C = false;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public final ArrayList f7284Q = new ArrayList();

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public final ArrayList f7285R = new ArrayList();

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public boolean f7289V = true;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public boolean f7291X = true;

    public g(k kVar) {
        this.f7294a = kVar;
    }

    public static boolean a(g gVar, d dVar) {
        return (gVar.f7297d & dVar.f7264a) != 0;
    }

    public static CharSequence b(g gVar) {
        CharSequence[] charSequenceArr = {d(gVar.f7309r, gVar.f7310s), gVar.e(), d(gVar.f7315x, gVar.y)};
        CharSequence charSequenceConcat = null;
        for (int i = 0; i < 3; i++) {
            CharSequence charSequence = charSequenceArr[i];
            if (charSequence != null && charSequence.length() > 0) {
                charSequenceConcat = (charSequenceConcat == null || charSequenceConcat.length() == 0) ? charSequence : TextUtils.concat(charSequenceConcat, ", ", charSequence);
            }
        }
        return charSequenceConcat;
    }

    public static SpannableString d(String str, ArrayList arrayList) {
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                i iVar = (i) it.next();
                int iC = S.i.c(iVar.f7319c);
                if (iC == 0) {
                    spannableString.setSpan(new TtsSpan.Builder("android.type.verbatim").build(), iVar.f7317a, iVar.f7318b, 0);
                } else if (iC == 1) {
                    spannableString.setSpan(new LocaleSpan(Locale.forLanguageTag(((f) iVar).f7269d)), iVar.f7317a, iVar.f7318b, 0);
                } else if (iC == 2) {
                    spannableString.setSpan(new URLSpan(((j) iVar).f7320d), iVar.f7317a, iVar.f7318b, 0);
                }
            }
        }
        return spannableString;
    }

    public static ArrayList g(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) {
        int i = byteBuffer.getInt();
        if (i == -1) {
            return null;
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i6 = 0; i6 < i; i6++) {
            int i7 = byteBuffer.getInt();
            int i8 = byteBuffer.getInt();
            int i9 = S.i.d(3)[byteBuffer.getInt()];
            int iC = S.i.c(i9);
            if (iC == 0) {
                byteBuffer.getInt();
                h hVar = new h();
                hVar.f7317a = i7;
                hVar.f7318b = i8;
                hVar.f7319c = i9;
                arrayList.add(hVar);
            } else if (iC == 1) {
                ByteBuffer byteBuffer2 = byteBufferArr[byteBuffer.getInt()];
                f fVar = new f();
                fVar.f7317a = i7;
                fVar.f7318b = i8;
                fVar.f7319c = i9;
                fVar.f7269d = Charset.forName("UTF-8").decode(byteBuffer2).toString();
                arrayList.add(fVar);
            }
        }
        return arrayList;
    }

    public static void k(float[] fArr, float[] fArr2, float[] fArr3) {
        Matrix.multiplyMV(fArr, 0, fArr2, 0, fArr3, 0);
        float f6 = fArr[3];
        fArr[0] = fArr[0] / f6;
        fArr[1] = fArr[1] / f6;
        fArr[2] = fArr[2] / f6;
        fArr[3] = 0.0f;
    }

    public final void c(ArrayList arrayList) {
        if (h(12)) {
            arrayList.add(this);
        }
        Iterator it = this.f7284Q.iterator();
        while (it.hasNext()) {
            ((g) it.next()).c(arrayList);
        }
    }

    public final SpannableString e() {
        ArrayList arrayList = this.f7308q;
        String str = this.f7270A;
        if (str != null && str.length() > 0) {
            arrayList = arrayList == null ? new ArrayList() : new ArrayList(arrayList);
            j jVar = new j();
            jVar.f7317a = 0;
            jVar.f7318b = this.f7307p.length();
            jVar.f7320d = this.f7270A;
            jVar.f7319c = 3;
            arrayList.add(jVar);
        }
        return d(this.f7307p, arrayList);
    }

    public final String f() {
        String str;
        if (h(13) && (str = this.f7307p) != null && !str.isEmpty()) {
            return this.f7307p;
        }
        Iterator it = this.f7284Q.iterator();
        while (it.hasNext()) {
            String strF = ((g) it.next()).f();
            if (strF != null && !strF.isEmpty()) {
                return strF;
            }
        }
        return null;
    }

    public final boolean h(int i) {
        return (this.f7296c & ((long) a3.d.b(i))) != 0;
    }

    public final g i(float[] fArr, boolean z6) {
        float f6 = fArr[3];
        boolean z7 = false;
        float f7 = fArr[0] / f6;
        float f8 = fArr[1] / f6;
        if (f7 < this.f7280K || f7 >= this.f7282M || f8 < this.f7281L || f8 >= this.N) {
            return null;
        }
        float[] fArr2 = new float[4];
        for (g gVar : this.f7285R) {
            if (!gVar.h(14)) {
                if (gVar.f7289V) {
                    gVar.f7289V = false;
                    if (gVar.f7290W == null) {
                        gVar.f7290W = new float[16];
                    }
                    if (!Matrix.invertM(gVar.f7290W, 0, gVar.f7283O, 0)) {
                        Arrays.fill(gVar.f7290W, 0.0f);
                    }
                }
                float[] fArr3 = fArr;
                Matrix.multiplyMV(fArr2, 0, gVar.f7290W, 0, fArr3, 0);
                g gVarI = gVar.i(fArr2, z6);
                if (gVarI != null) {
                    return gVarI;
                }
                fArr = fArr3;
            }
        }
        if (z6 && this.i != -1) {
            z7 = true;
        }
        if (j() || z7) {
            return this;
        }
        return null;
    }

    public final boolean j() {
        if (h(12)) {
            return false;
        }
        if (h(22)) {
            return true;
        }
        int i = this.f7297d;
        int i6 = k.y;
        if ((i & (-61)) != 0 || (this.f7296c & ((long) 10682871)) != 0) {
            return true;
        }
        String str = this.f7307p;
        if (str != null && !str.isEmpty()) {
            return true;
        }
        String str2 = this.f7309r;
        if (str2 != null && !str2.isEmpty()) {
            return true;
        }
        String str3 = this.f7315x;
        return (str3 == null || str3.isEmpty()) ? false : true;
    }

    public final void l(float[] fArr, HashSet hashSet, boolean z6) {
        hashSet.add(this);
        if (this.f7291X) {
            z6 = true;
        }
        if (z6) {
            if (this.f7292Y == null) {
                this.f7292Y = new float[16];
            }
            if (this.f7283O == null) {
                this.f7283O = new float[16];
            }
            Matrix.multiplyMM(this.f7292Y, 0, fArr, 0, this.f7283O, 0);
            float[] fArr2 = {this.f7280K, this.f7281L, 0.0f, 1.0f};
            float[] fArr3 = new float[4];
            float[] fArr4 = new float[4];
            float[] fArr5 = new float[4];
            float[] fArr6 = new float[4];
            k(fArr3, this.f7292Y, fArr2);
            fArr2[0] = this.f7282M;
            fArr2[1] = this.f7281L;
            k(fArr4, this.f7292Y, fArr2);
            fArr2[0] = this.f7282M;
            fArr2[1] = this.N;
            k(fArr5, this.f7292Y, fArr2);
            fArr2[0] = this.f7280K;
            fArr2[1] = this.N;
            k(fArr6, this.f7292Y, fArr2);
            if (this.f7293Z == null) {
                this.f7293Z = new Rect();
            }
            this.f7293Z.set(Math.round(Math.min(fArr3[0], Math.min(fArr4[0], Math.min(fArr5[0], fArr6[0])))), Math.round(Math.min(fArr3[1], Math.min(fArr4[1], Math.min(fArr5[1], fArr6[1])))), Math.round(Math.max(fArr3[0], Math.max(fArr4[0], Math.max(fArr5[0], fArr6[0])))), Math.round(Math.max(fArr3[1], Math.max(fArr4[1], Math.max(fArr5[1], fArr6[1])))));
            this.f7291X = false;
        }
        int i = -1;
        for (g gVar : this.f7284Q) {
            gVar.f7271B = i;
            i = gVar.f7295b;
            gVar.l(this.f7292Y, hashSet, z6);
        }
    }
}
