package io.flutter.view;

import U4.a;
import android.R;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.net.Uri;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LocaleSpan;
import android.text.style.TtsSpan;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import io.flutter.plugin.platform.InterfaceC2020q;
import io.flutter.view.e;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import q5.InterfaceC2565d;

/* JADX INFO: loaded from: classes2.dex */
public class e extends AccessibilityNodeProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f16881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final U4.a f16882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AccessibilityManager f16883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AccessibilityViewEmbedder f16884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceC2020q f16885e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ContentResolver f16886f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map f16887g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f16888h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public l f16889i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f16890j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f16891k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f16892l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public l f16893m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public l f16894n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public l f16895o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List f16896p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f16897q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Integer f16898r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public k f16899s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f16900t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f16901u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final a.b f16902v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final AccessibilityManager.AccessibilityStateChangeListener f16903w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final AccessibilityManager.TouchExplorationStateChangeListener f16904x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ContentObserver f16905y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f16880z = ((g.SCROLL_RIGHT.f16947a | g.SCROLL_LEFT.f16947a) | g.SCROLL_UP.f16947a) | g.SCROLL_DOWN.f16947a;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final int f16877A = ((((((((((i.HAS_CHECKED_STATE.f16985a | i.IS_CHECKED.f16985a) | i.IS_SELECTED.f16985a) | i.IS_TEXT_FIELD.f16985a) | i.IS_FOCUSED.f16985a) | i.HAS_ENABLED_STATE.f16985a) | i.IS_ENABLED.f16985a) | i.IS_IN_MUTUALLY_EXCLUSIVE_GROUP.f16985a) | i.HAS_TOGGLED_STATE.f16985a) | i.IS_TOGGLED.f16985a) | i.IS_FOCUSABLE.f16985a) | i.IS_SLIDER.f16985a;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static int f16878B = 267386881;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static int f16879C = (g.DID_GAIN_ACCESSIBILITY_FOCUS.f16947a & g.DID_LOSE_ACCESSIBILITY_FOCUS.f16947a) & g.SHOW_ON_SCREEN.f16947a;

    public class a implements a.b {
        public a() {
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.a
        public void a(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            for (ByteBuffer byteBuffer2 : byteBufferArr) {
                byteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
            }
            e.this.c0(byteBuffer, strArr, byteBufferArr);
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.a
        public void b(ByteBuffer byteBuffer, String[] strArr) {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            e.this.b0(byteBuffer, strArr);
        }

        @Override // U4.a.b
        public void c(int i7) {
            e.this.S(i7, 1);
        }

        @Override // U4.a.b
        public void d(String str) {
            if (Build.VERSION.SDK_INT >= 36) {
                J4.b.g("AccessibilityBridge", "Using AnnounceSemanticsEvent for accessibility is deprecated on Android. Migrate to using semantic properties for a more robust and accessible user experience.\nFlutter: If you are unsure why you are seeing this bug, it might be because you are using a widget that calls this method. See https://github.com/flutter/flutter/issues/165510 for more details.\nAndroid documentation: https://developer.android.com/reference/android/view/View#announceForAccessibility(java.lang.CharSequence)");
            }
            e.this.f16881a.announceForAccessibility(str);
        }

        @Override // U4.a.b
        public void e(String str) {
            if (Build.VERSION.SDK_INT >= 28) {
                return;
            }
            AccessibilityEvent accessibilityEventH = e.this.H(0, 32);
            accessibilityEventH.getText().add(str);
            e.this.T(accessibilityEventH);
        }

        @Override // U4.a.b
        public void f(int i7) {
            e.this.S(i7, 8);
        }

        @Override // U4.a.b
        public void g(int i7) {
            e.this.S(i7, 2);
        }
    }

    public class b implements AccessibilityManager.AccessibilityStateChangeListener {
        public b() {
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public void onAccessibilityStateChanged(boolean z7) {
            if (e.this.f16901u) {
                return;
            }
            if (z7) {
                e.this.f16882b.g(e.this.f16902v);
                e.this.f16882b.e();
            } else {
                e.this.X(false);
                e.this.f16882b.g(null);
                e.this.f16882b.d();
            }
            if (e.this.f16899s != null) {
                e.this.f16899s.a(z7, e.this.f16883c.isTouchExplorationEnabled());
            }
        }
    }

    public class c extends ContentObserver {
        public c(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z7) {
            onChange(z7, null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z7, Uri uri) {
            if (e.this.f16901u) {
                return;
            }
            if (Settings.Global.getFloat(e.this.f16886f, "transition_animation_scale", 1.0f) == 0.0f) {
                e.f(e.this, f.DISABLE_ANIMATIONS.f16921a);
            } else {
                e.e(e.this, ~f.DISABLE_ANIMATIONS.f16921a);
            }
            e.this.U();
        }
    }

    public class d implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityManager f16909a;

        public d(AccessibilityManager accessibilityManager) {
            this.f16909a = accessibilityManager;
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z7) {
            if (e.this.f16901u) {
                return;
            }
            if (!z7) {
                e.this.X(false);
                e.this.M();
            }
            if (e.this.f16899s != null) {
                e.this.f16899s.a(this.f16909a.isEnabled(), z7);
            }
        }
    }

    /* JADX INFO: renamed from: io.flutter.view.e$e, reason: collision with other inner class name */
    public static /* synthetic */ class C0262e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16911a;

        static {
            int[] iArr = new int[o.values().length];
            f16911a = iArr;
            try {
                iArr[o.SPELLOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16911a[o.LOCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16911a[o.URL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum f {
        ACCESSIBLE_NAVIGATION(1),
        INVERT_COLORS(2),
        DISABLE_ANIMATIONS(4),
        BOLD_TEXT(8),
        REDUCE_MOTION(16),
        HIGH_CONTRAST(32),
        ON_OFF_SWITCH_LABELS(64),
        NO_ANNOUNCE(128);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f16921a;

        f(int i7) {
            this.f16921a = i7;
        }
    }

    public enum g {
        TAP(1),
        LONG_PRESS(2),
        SCROLL_LEFT(4),
        SCROLL_RIGHT(8),
        SCROLL_UP(16),
        SCROLL_DOWN(32),
        INCREASE(64),
        DECREASE(128),
        SHOW_ON_SCREEN(256),
        MOVE_CURSOR_FORWARD_BY_CHARACTER(512),
        MOVE_CURSOR_BACKWARD_BY_CHARACTER(1024),
        SET_SELECTION(2048),
        COPY(4096),
        CUT(8192),
        PASTE(16384),
        DID_GAIN_ACCESSIBILITY_FOCUS(32768),
        DID_LOSE_ACCESSIBILITY_FOCUS(65536),
        CUSTOM_ACTION(131072),
        DISMISS(262144),
        MOVE_CURSOR_FORWARD_BY_WORD(524288),
        MOVE_CURSOR_BACKWARD_BY_WORD(1048576),
        SET_TEXT(2097152),
        FOCUS(4194304),
        SCROLL_TO_OFFSET(8388608);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f16947a;

        g(int i7) {
            this.f16947a = i7;
        }
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16948a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f16949b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f16950c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f16951d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f16952e;
    }

    public enum i {
        HAS_CHECKED_STATE(1),
        IS_CHECKED(2),
        IS_SELECTED(4),
        IS_BUTTON(8),
        IS_TEXT_FIELD(16),
        IS_FOCUSED(32),
        HAS_ENABLED_STATE(64),
        IS_ENABLED(128),
        IS_IN_MUTUALLY_EXCLUSIVE_GROUP(256),
        IS_HEADER(512),
        IS_OBSCURED(1024),
        SCOPES_ROUTE(2048),
        NAMES_ROUTE(4096),
        IS_HIDDEN(8192),
        IS_IMAGE(16384),
        IS_LIVE_REGION(32768),
        HAS_TOGGLED_STATE(65536),
        IS_TOGGLED(131072),
        HAS_IMPLICIT_SCROLLING(262144),
        IS_MULTILINE(524288),
        IS_READ_ONLY(1048576),
        IS_FOCUSABLE(2097152),
        IS_LINK(4194304),
        IS_SLIDER(8388608),
        IS_KEYBOARD_KEY(16777216),
        IS_CHECK_STATE_MIXED(33554432),
        HAS_EXPANDED_STATE(67108864),
        IS_EXPANDED(134217728),
        HAS_SELECTED_STATE(268435456),
        HAS_REQUIRED_STATE(536870912),
        IS_REQUIRED(1073741824);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f16985a;

        i(int i7) {
            this.f16985a = i7;
        }
    }

    public static class j extends n {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f16986d;

        public j() {
            super(null);
        }

        public /* synthetic */ j(a aVar) {
            this();
        }
    }

    public interface k {
        void a(boolean z7, boolean z8);
    }

    public static class l {

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        public String f16987A;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        public p f16989C;

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        public long f16991E;

        /* JADX INFO: renamed from: F, reason: collision with root package name */
        public int f16992F;

        /* JADX INFO: renamed from: G, reason: collision with root package name */
        public int f16993G;

        /* JADX INFO: renamed from: H, reason: collision with root package name */
        public int f16994H;

        /* JADX INFO: renamed from: I, reason: collision with root package name */
        public float f16995I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public float f16996J;

        /* JADX INFO: renamed from: K, reason: collision with root package name */
        public float f16997K;

        /* JADX INFO: renamed from: L, reason: collision with root package name */
        public String f16998L;

        /* JADX INFO: renamed from: M, reason: collision with root package name */
        public String f16999M;

        /* JADX INFO: renamed from: N, reason: collision with root package name */
        public float f17000N;

        /* JADX INFO: renamed from: O, reason: collision with root package name */
        public float f17001O;

        /* JADX INFO: renamed from: P, reason: collision with root package name */
        public float f17002P;

        /* JADX INFO: renamed from: Q, reason: collision with root package name */
        public float f17003Q;

        /* JADX INFO: renamed from: R, reason: collision with root package name */
        public float[] f17004R;

        /* JADX INFO: renamed from: S, reason: collision with root package name */
        public l f17005S;

        /* JADX INFO: renamed from: V, reason: collision with root package name */
        public List f17008V;

        /* JADX INFO: renamed from: W, reason: collision with root package name */
        public h f17009W;

        /* JADX INFO: renamed from: X, reason: collision with root package name */
        public h f17010X;

        /* JADX INFO: renamed from: Z, reason: collision with root package name */
        public float[] f17012Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f17013a;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public float[] f17016b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f17017c;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public Rect f17018c0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f17019d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f17020e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f17021f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f17022g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f17023h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f17024i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f17025j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f17026k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f17027l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f17028m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f17029n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f17030o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f17031p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public List f17032q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public String f17033r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public List f17034s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public String f17035t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public List f17036u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public String f17037v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public List f17038w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public String f17039x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public List f17040y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public String f17041z;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f17015b = -1;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        public int f16988B = -1;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        public boolean f16990D = false;

        /* JADX INFO: renamed from: T, reason: collision with root package name */
        public List f17006T = new ArrayList();

        /* JADX INFO: renamed from: U, reason: collision with root package name */
        public List f17007U = new ArrayList();

        /* JADX INFO: renamed from: Y, reason: collision with root package name */
        public boolean f17011Y = true;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public boolean f17014a0 = true;

        public l(e eVar) {
            this.f17013a = eVar;
        }

        public static boolean A0(l lVar, InterfaceC2565d interfaceC2565d) {
            return (lVar == null || lVar.j0(interfaceC2565d) == null) ? false : true;
        }

        public static /* synthetic */ int n(l lVar, int i7) {
            int i8 = lVar.f17023h + i7;
            lVar.f17023h = i8;
            return i8;
        }

        public static /* synthetic */ int o(l lVar, int i7) {
            int i8 = lVar.f17023h - i7;
            lVar.f17023h = i8;
            return i8;
        }

        public final void B0(float[] fArr, float[] fArr2, float[] fArr3) {
            Matrix.multiplyMV(fArr, 0, fArr2, 0, fArr3, 0);
            float f7 = fArr[3];
            fArr[0] = fArr[0] / f7;
            fArr[1] = fArr[1] / f7;
            fArr[2] = fArr[2] / f7;
            fArr[3] = 0.0f;
        }

        public final void C0(float[] fArr, Set set, boolean z7) {
            set.add(this);
            if (this.f17014a0) {
                z7 = true;
            }
            if (z7) {
                if (this.f17016b0 == null) {
                    this.f17016b0 = new float[16];
                }
                if (this.f17004R == null) {
                    this.f17004R = new float[16];
                }
                Matrix.multiplyMM(this.f17016b0, 0, fArr, 0, this.f17004R, 0);
                float[] fArr2 = {this.f17000N, this.f17001O, 0.0f, 1.0f};
                float[] fArr3 = new float[4];
                float[] fArr4 = new float[4];
                float[] fArr5 = new float[4];
                float[] fArr6 = new float[4];
                B0(fArr3, this.f17016b0, fArr2);
                fArr2[0] = this.f17002P;
                fArr2[1] = this.f17001O;
                B0(fArr4, this.f17016b0, fArr2);
                fArr2[0] = this.f17002P;
                fArr2[1] = this.f17003Q;
                B0(fArr5, this.f17016b0, fArr2);
                fArr2[0] = this.f17000N;
                fArr2[1] = this.f17003Q;
                B0(fArr6, this.f17016b0, fArr2);
                if (this.f17018c0 == null) {
                    this.f17018c0 = new Rect();
                }
                this.f17018c0.set(Math.round(z0(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(z0(fArr3[1], fArr4[1], fArr5[1], fArr6[1])), Math.round(y0(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(y0(fArr3[1], fArr4[1], fArr5[1], fArr6[1])));
                this.f17014a0 = false;
            }
            int i7 = -1;
            for (l lVar : this.f17006T) {
                lVar.f16988B = i7;
                i7 = lVar.f17015b;
                lVar.C0(this.f17016b0, set, z7);
            }
        }

        public final void D0(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
            this.f16990D = true;
            this.f16998L = this.f17033r;
            this.f16999M = this.f17031p;
            this.f16991E = this.f17017c;
            this.f16992F = this.f17019d;
            this.f16993G = this.f17022g;
            this.f16994H = this.f17023h;
            this.f16995I = this.f17027l;
            this.f16996J = this.f17028m;
            this.f16997K = this.f17029n;
            this.f17017c = byteBuffer.getLong();
            this.f17019d = byteBuffer.getInt();
            this.f17020e = byteBuffer.getInt();
            this.f17021f = byteBuffer.getInt();
            this.f17022g = byteBuffer.getInt();
            this.f17023h = byteBuffer.getInt();
            this.f17024i = byteBuffer.getInt();
            this.f17025j = byteBuffer.getInt();
            this.f17026k = byteBuffer.getInt();
            this.f17027l = byteBuffer.getFloat();
            this.f17028m = byteBuffer.getFloat();
            this.f17029n = byteBuffer.getFloat();
            int i7 = byteBuffer.getInt();
            this.f17030o = i7 == -1 ? null : strArr[i7];
            int i8 = byteBuffer.getInt();
            this.f17031p = i8 == -1 ? null : strArr[i8];
            this.f17032q = o0(byteBuffer, byteBufferArr);
            int i9 = byteBuffer.getInt();
            this.f17033r = i9 == -1 ? null : strArr[i9];
            this.f17034s = o0(byteBuffer, byteBufferArr);
            int i10 = byteBuffer.getInt();
            this.f17035t = i10 == -1 ? null : strArr[i10];
            this.f17036u = o0(byteBuffer, byteBufferArr);
            int i11 = byteBuffer.getInt();
            this.f17037v = i11 == -1 ? null : strArr[i11];
            this.f17038w = o0(byteBuffer, byteBufferArr);
            int i12 = byteBuffer.getInt();
            this.f17039x = i12 == -1 ? null : strArr[i12];
            this.f17040y = o0(byteBuffer, byteBufferArr);
            int i13 = byteBuffer.getInt();
            this.f17041z = i13 == -1 ? null : strArr[i13];
            int i14 = byteBuffer.getInt();
            this.f16987A = i14 == -1 ? null : strArr[i14];
            this.f16989C = p.b(byteBuffer.getInt());
            this.f17000N = byteBuffer.getFloat();
            this.f17001O = byteBuffer.getFloat();
            this.f17002P = byteBuffer.getFloat();
            this.f17003Q = byteBuffer.getFloat();
            if (this.f17004R == null) {
                this.f17004R = new float[16];
            }
            for (int i15 = 0; i15 < 16; i15++) {
                this.f17004R[i15] = byteBuffer.getFloat();
            }
            this.f17011Y = true;
            this.f17014a0 = true;
            int i16 = byteBuffer.getInt();
            this.f17006T.clear();
            this.f17007U.clear();
            for (int i17 = 0; i17 < i16; i17++) {
                l lVarY = this.f17013a.y(byteBuffer.getInt());
                lVarY.f17005S = this;
                this.f17006T.add(lVarY);
            }
            for (int i18 = 0; i18 < i16; i18++) {
                l lVarY2 = this.f17013a.y(byteBuffer.getInt());
                lVarY2.f17005S = this;
                this.f17007U.add(lVarY2);
            }
            int i19 = byteBuffer.getInt();
            if (i19 == 0) {
                this.f17008V = null;
                return;
            }
            List list = this.f17008V;
            if (list == null) {
                this.f17008V = new ArrayList(i19);
            } else {
                list.clear();
            }
            for (int i20 = 0; i20 < i19; i20++) {
                h hVarX = this.f17013a.x(byteBuffer.getInt());
                if (hVarX.f16950c == g.TAP.f16947a) {
                    this.f17009W = hVarX;
                } else if (hVarX.f16950c == g.LONG_PRESS.f16947a) {
                    this.f17010X = hVarX;
                } else {
                    this.f17008V.add(hVarX);
                }
                this.f17008V.add(hVarX);
            }
        }

        public final void e0(List list) {
            if (v0(i.SCOPES_ROUTE)) {
                list.add(this);
            }
            Iterator it = this.f17006T.iterator();
            while (it.hasNext()) {
                ((l) it.next()).e0(list);
            }
        }

        public final SpannableString f0(String str, List list) {
            if (str == null) {
                return null;
            }
            SpannableString spannableString = new SpannableString(str);
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    n nVar = (n) it.next();
                    int i7 = C0262e.f16911a[nVar.f17044c.ordinal()];
                    if (i7 == 1) {
                        spannableString.setSpan(new TtsSpan.Builder("android.type.verbatim").build(), nVar.f17042a, nVar.f17043b, 0);
                    } else if (i7 == 2) {
                        spannableString.setSpan(new LocaleSpan(Locale.forLanguageTag(((j) nVar).f16986d)), nVar.f17042a, nVar.f17043b, 0);
                    } else if (i7 == 3) {
                        spannableString.setSpan(new URLSpan(((q) nVar).f17053d), nVar.f17042a, nVar.f17043b, 0);
                    }
                }
            }
            return spannableString;
        }

        public final boolean g0() {
            String str;
            String str2 = this.f17031p;
            if (str2 == null && this.f16999M == null) {
                return false;
            }
            return str2 == null || (str = this.f16999M) == null || !str2.equals(str);
        }

        public final boolean h0() {
            return (Float.isNaN(this.f17027l) || Float.isNaN(this.f16995I) || this.f16995I == this.f17027l) ? false : true;
        }

        public final void i0() {
            if (this.f17011Y) {
                this.f17011Y = false;
                if (this.f17012Z == null) {
                    this.f17012Z = new float[16];
                }
                if (Matrix.invertM(this.f17012Z, 0, this.f17004R, 0)) {
                    return;
                }
                Arrays.fill(this.f17012Z, 0.0f);
            }
        }

        public final l j0(InterfaceC2565d interfaceC2565d) {
            for (l lVar = this.f17005S; lVar != null; lVar = lVar.f17005S) {
                if (interfaceC2565d.test(lVar)) {
                    return lVar;
                }
            }
            return null;
        }

        public final Rect k0() {
            return this.f17018c0;
        }

        public final CharSequence l0() {
            return f0(this.f17039x, this.f17040y);
        }

        public final CharSequence m0() {
            List arrayList = this.f17032q;
            String str = this.f16987A;
            if (str != null && str.length() > 0) {
                arrayList = arrayList == null ? new ArrayList() : new ArrayList(arrayList);
                q qVar = new q(null);
                qVar.f17042a = 0;
                qVar.f17043b = this.f17031p.length();
                qVar.f17053d = this.f16987A;
                qVar.f17044c = o.URL;
                arrayList.add(qVar);
            }
            return f0(this.f17031p, arrayList);
        }

        public final String n0() {
            String str;
            if (v0(i.NAMES_ROUTE) && (str = this.f17031p) != null && !str.isEmpty()) {
                return this.f17031p;
            }
            Iterator it = this.f17006T.iterator();
            while (it.hasNext()) {
                String strN0 = ((l) it.next()).n0();
                if (strN0 != null && !strN0.isEmpty()) {
                    return strN0;
                }
            }
            return null;
        }

        public final List o0(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) {
            int i7 = byteBuffer.getInt();
            a aVar = null;
            if (i7 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i7);
            for (int i8 = 0; i8 < i7; i8++) {
                int i9 = byteBuffer.getInt();
                int i10 = byteBuffer.getInt();
                o oVar = o.values()[byteBuffer.getInt()];
                int i11 = C0262e.f16911a[oVar.ordinal()];
                if (i11 == 1) {
                    byteBuffer.getInt();
                    m mVar = new m(aVar);
                    mVar.f17042a = i9;
                    mVar.f17043b = i10;
                    mVar.f17044c = oVar;
                    arrayList.add(mVar);
                } else if (i11 == 2) {
                    ByteBuffer byteBuffer2 = byteBufferArr[byteBuffer.getInt()];
                    j jVar = new j(aVar);
                    jVar.f17042a = i9;
                    jVar.f17043b = i10;
                    jVar.f17044c = oVar;
                    jVar.f16986d = Charset.forName("UTF-8").decode(byteBuffer2).toString();
                    arrayList.add(jVar);
                }
            }
            return arrayList;
        }

        public final CharSequence p0() {
            CharSequence[] charSequenceArr = {m0(), l0()};
            CharSequence charSequenceConcat = null;
            for (int i7 = 0; i7 < 2; i7++) {
                CharSequence charSequence = charSequenceArr[i7];
                if (charSequence != null && charSequence.length() > 0) {
                    charSequenceConcat = (charSequenceConcat == null || charSequenceConcat.length() == 0) ? charSequence : TextUtils.concat(charSequenceConcat, ", ", charSequence);
                }
            }
            return charSequenceConcat;
        }

        public final CharSequence q0() {
            return f0(this.f17033r, this.f17034s);
        }

        public final CharSequence r0() {
            CharSequence[] charSequenceArr = {q0(), m0(), l0()};
            CharSequence charSequenceConcat = null;
            for (int i7 = 0; i7 < 3; i7++) {
                CharSequence charSequence = charSequenceArr[i7];
                if (charSequence != null && charSequence.length() > 0) {
                    charSequenceConcat = (charSequenceConcat == null || charSequenceConcat.length() == 0) ? charSequence : TextUtils.concat(charSequenceConcat, ", ", charSequence);
                }
            }
            return charSequenceConcat;
        }

        public final boolean s0(g gVar) {
            return (gVar.f16947a & this.f16992F) != 0;
        }

        public final boolean t0(i iVar) {
            return (this.f16991E & ((long) iVar.f16985a)) != 0;
        }

        public final boolean u0(g gVar) {
            return (gVar.f16947a & this.f17019d) != 0;
        }

        public final boolean v0(i iVar) {
            return (this.f17017c & ((long) iVar.f16985a)) != 0;
        }

        public final l w0(float[] fArr, boolean z7) {
            float f7 = fArr[3];
            boolean z8 = false;
            float f8 = fArr[0] / f7;
            float f9 = fArr[1] / f7;
            if (f8 < this.f17000N || f8 >= this.f17002P || f9 < this.f17001O || f9 >= this.f17003Q) {
                return null;
            }
            float[] fArr2 = new float[4];
            for (l lVar : this.f17007U) {
                if (!lVar.v0(i.IS_HIDDEN)) {
                    lVar.i0();
                    Matrix.multiplyMV(fArr2, 0, lVar.f17012Z, 0, fArr, 0);
                    l lVarW0 = lVar.w0(fArr2, z7);
                    if (lVarW0 != null) {
                        return lVarW0;
                    }
                }
            }
            if (z7 && this.f17024i != -1) {
                z8 = true;
            }
            if (x0() || z8) {
                return this;
            }
            return null;
        }

        public final boolean x0() {
            String str;
            String str2;
            String str3;
            if (v0(i.SCOPES_ROUTE)) {
                return false;
            }
            if (v0(i.IS_FOCUSABLE)) {
                return true;
            }
            return ((this.f17019d & (~e.f16880z)) == 0 && (this.f17017c & ((long) e.f16877A)) == 0 && ((str = this.f17031p) == null || str.isEmpty()) && (((str2 = this.f17033r) == null || str2.isEmpty()) && ((str3 = this.f17039x) == null || str3.isEmpty()))) ? false : true;
        }

        public final float y0(float f7, float f8, float f9, float f10) {
            return Math.max(f7, Math.max(f8, Math.max(f9, f10)));
        }

        public final float z0(float f7, float f8, float f9, float f10) {
            return Math.min(f7, Math.min(f8, Math.min(f9, f10)));
        }
    }

    public static class m extends n {
        public m() {
            super(null);
        }

        public /* synthetic */ m(a aVar) {
            this();
        }
    }

    public static class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f17042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f17043b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public o f17044c;

        public n() {
        }

        public /* synthetic */ n(a aVar) {
            this();
        }
    }

    public enum o {
        SPELLOUT,
        LOCALE,
        URL
    }

    public enum p {
        UNKNOWN,
        LTR,
        RTL;

        public static p b(int i7) {
            return i7 != 1 ? i7 != 2 ? UNKNOWN : LTR : RTL;
        }
    }

    public static class q extends n {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f17053d;

        public q() {
            super(null);
        }

        public /* synthetic */ q(a aVar) {
            this();
        }
    }

    public e(View view, U4.a aVar, AccessibilityManager accessibilityManager, ContentResolver contentResolver, InterfaceC2020q interfaceC2020q) {
        this(view, aVar, accessibilityManager, contentResolver, new AccessibilityViewEmbedder(view, 65536), interfaceC2020q);
    }

    public static /* synthetic */ boolean E(l lVar, l lVar2) {
        return lVar2 == lVar;
    }

    public static /* synthetic */ boolean F(l lVar) {
        return lVar.v0(i.HAS_IMPLICIT_SCROLLING);
    }

    public static /* synthetic */ int e(e eVar, int i7) {
        int i8 = i7 & eVar.f16892l;
        eVar.f16892l = i8;
        return i8;
    }

    public static /* synthetic */ int f(e eVar, int i7) {
        int i8 = i7 | eVar.f16892l;
        eVar.f16892l = i8;
        return i8;
    }

    public final void A(float f7, float f8, boolean z7) {
        l lVarW0;
        if (this.f16887g.isEmpty() || (lVarW0 = z().w0(new float[]{f7, f8, 0.0f, 1.0f}, z7)) == this.f16895o) {
            return;
        }
        if (lVarW0 != null) {
            S(lVarW0.f17015b, 128);
        }
        l lVar = this.f16895o;
        if (lVar != null) {
            S(lVar.f17015b, 256);
        }
        this.f16895o = lVarW0;
    }

    public boolean B() {
        return this.f16883c.isEnabled();
    }

    public final boolean C(l lVar) {
        if (lVar.v0(i.SCOPES_ROUTE)) {
            return false;
        }
        return (lVar.r0() == null && (lVar.f17019d & (~f16879C)) == 0) ? false : true;
    }

    public boolean D() {
        return this.f16883c.isTouchExplorationEnabled();
    }

    public AccessibilityEvent G(int i7) {
        return AccessibilityEvent.obtain(i7);
    }

    public final AccessibilityEvent H(int i7, int i8) {
        AccessibilityEvent accessibilityEventG = G(i8);
        accessibilityEventG.setPackageName(this.f16881a.getContext().getPackageName());
        accessibilityEventG.setSource(this.f16881a, i7);
        return accessibilityEventG;
    }

    public AccessibilityNodeInfo I(View view) {
        return AccessibilityNodeInfo.obtain(view);
    }

    public AccessibilityNodeInfo J(View view, int i7) {
        return AccessibilityNodeInfo.obtain(view, i7);
    }

    public boolean K(MotionEvent motionEvent) {
        return L(motionEvent, false);
    }

    public boolean L(MotionEvent motionEvent, boolean z7) {
        if (!this.f16883c.isTouchExplorationEnabled() || this.f16887g.isEmpty()) {
            return false;
        }
        l lVarW0 = z().w0(new float[]{motionEvent.getX(), motionEvent.getY(), 0.0f, 1.0f}, z7);
        if (lVarW0 != null && lVarW0.f17024i != -1) {
            if (z7) {
                return false;
            }
            return this.f16884d.onAccessibilityHoverEvent(lVarW0.f17015b, motionEvent);
        }
        if (motionEvent.getAction() == 9 || motionEvent.getAction() == 7) {
            A(motionEvent.getX(), motionEvent.getY(), z7);
        } else {
            if (motionEvent.getAction() != 10) {
                J4.b.a("flutter", "unexpected accessibility hover event: " + motionEvent);
                return false;
            }
            M();
        }
        return true;
    }

    public final void M() {
        l lVar = this.f16895o;
        if (lVar != null) {
            S(lVar.f17015b, 256);
            this.f16895o = null;
        }
    }

    public final void N(l lVar) {
        String strN0 = lVar.n0();
        if (strN0 == null) {
            strN0 = " ";
        }
        if (Build.VERSION.SDK_INT >= 28) {
            W(strN0);
            return;
        }
        AccessibilityEvent accessibilityEventH = H(lVar.f17015b, 32);
        accessibilityEventH.getText().add(strN0);
        T(accessibilityEventH);
    }

    public final boolean O(l lVar, int i7, Bundle bundle, boolean z7) {
        int i8 = bundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
        boolean z8 = bundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
        int i9 = lVar.f17022g;
        int i10 = lVar.f17023h;
        Q(lVar, i8, z7, z8);
        if (i9 != lVar.f17022g || i10 != lVar.f17023h) {
            String str = lVar.f17033r != null ? lVar.f17033r : "";
            AccessibilityEvent accessibilityEventH = H(lVar.f17015b, 8192);
            accessibilityEventH.getText().add(str);
            accessibilityEventH.setFromIndex(lVar.f17022g);
            accessibilityEventH.setToIndex(lVar.f17023h);
            accessibilityEventH.setItemCount(str.length());
            T(accessibilityEventH);
        }
        if (i8 == 1) {
            if (z7) {
                g gVar = g.MOVE_CURSOR_FORWARD_BY_CHARACTER;
                if (lVar.u0(gVar)) {
                    this.f16882b.c(i7, gVar, Boolean.valueOf(z8));
                    return true;
                }
            }
            if (z7) {
                return false;
            }
            g gVar2 = g.MOVE_CURSOR_BACKWARD_BY_CHARACTER;
            if (!lVar.u0(gVar2)) {
                return false;
            }
            this.f16882b.c(i7, gVar2, Boolean.valueOf(z8));
            return true;
        }
        if (i8 != 2) {
            return i8 == 4 || i8 == 8 || i8 == 16;
        }
        if (z7) {
            g gVar3 = g.MOVE_CURSOR_FORWARD_BY_WORD;
            if (lVar.u0(gVar3)) {
                this.f16882b.c(i7, gVar3, Boolean.valueOf(z8));
                return true;
            }
        }
        if (z7) {
            return false;
        }
        g gVar4 = g.MOVE_CURSOR_BACKWARD_BY_WORD;
        if (!lVar.u0(gVar4)) {
            return false;
        }
        this.f16882b.c(i7, gVar4, Boolean.valueOf(z8));
        return true;
    }

    public final boolean P(l lVar, int i7, Bundle bundle) {
        String string = (bundle == null || !bundle.containsKey("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE")) ? "" : bundle.getString("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");
        this.f16882b.c(i7, g.SET_TEXT, string);
        lVar.f17033r = string;
        lVar.f17034s = null;
        return true;
    }

    public final void Q(l lVar, int i7, boolean z7, boolean z8) {
        if (lVar.f17023h < 0 || lVar.f17022g < 0) {
            return;
        }
        if (i7 != 1) {
            if (i7 != 2) {
                if (i7 != 4) {
                    if (i7 == 8 || i7 == 16) {
                        if (z7) {
                            lVar.f17023h = lVar.f17033r.length();
                        } else {
                            lVar.f17023h = 0;
                        }
                    }
                } else if (z7 && lVar.f17023h < lVar.f17033r.length()) {
                    Matcher matcher = Pattern.compile("(?!^)(\\n)").matcher(lVar.f17033r.substring(lVar.f17023h));
                    if (matcher.find()) {
                        l.n(lVar, matcher.start(1));
                    } else {
                        lVar.f17023h = lVar.f17033r.length();
                    }
                } else if (!z7 && lVar.f17023h > 0) {
                    Matcher matcher2 = Pattern.compile("(?s:.*)(\\n)").matcher(lVar.f17033r.substring(0, lVar.f17023h));
                    if (matcher2.find()) {
                        lVar.f17023h = matcher2.start(1);
                    } else {
                        lVar.f17023h = 0;
                    }
                }
            } else if (z7 && lVar.f17023h < lVar.f17033r.length()) {
                Matcher matcher3 = Pattern.compile("\\p{L}(\\b)").matcher(lVar.f17033r.substring(lVar.f17023h));
                matcher3.find();
                if (matcher3.find()) {
                    l.n(lVar, matcher3.start(1));
                } else {
                    lVar.f17023h = lVar.f17033r.length();
                }
            } else if (!z7 && lVar.f17023h > 0) {
                Matcher matcher4 = Pattern.compile("(?s:.*)(\\b)\\p{L}").matcher(lVar.f17033r.substring(0, lVar.f17023h));
                if (matcher4.find()) {
                    lVar.f17023h = matcher4.start(1);
                }
            }
        } else if (z7 && lVar.f17023h < lVar.f17033r.length()) {
            l.n(lVar, 1);
        } else if (!z7 && lVar.f17023h > 0) {
            l.o(lVar, 1);
        }
        if (z8) {
            return;
        }
        lVar.f17022g = lVar.f17023h;
    }

    public void R() {
        this.f16901u = true;
        this.f16885e.d();
        Z(null);
        this.f16883c.removeAccessibilityStateChangeListener(this.f16903w);
        this.f16883c.removeTouchExplorationStateChangeListener(this.f16904x);
        this.f16886f.unregisterContentObserver(this.f16905y);
        this.f16882b.g(null);
    }

    public void S(int i7, int i8) {
        if (this.f16883c.isEnabled()) {
            T(H(i7, i8));
        }
    }

    public final void T(AccessibilityEvent accessibilityEvent) {
        if (this.f16883c.isEnabled()) {
            this.f16881a.getParent().requestSendAccessibilityEvent(this.f16881a, accessibilityEvent);
        }
    }

    public final void U() {
        this.f16882b.f(this.f16892l);
    }

    public final void V(int i7) {
        AccessibilityEvent accessibilityEventH = H(i7, 2048);
        accessibilityEventH.setContentChangeTypes(1);
        T(accessibilityEventH);
    }

    public final void W(String str) {
        this.f16881a.setAccessibilityPaneTitle(str);
    }

    public final void X(boolean z7) {
        if (this.f16900t == z7) {
            return;
        }
        this.f16900t = z7;
        if (z7) {
            this.f16892l |= f.ACCESSIBLE_NAVIGATION.f16921a;
        } else {
            this.f16892l &= ~f.ACCESSIBLE_NAVIGATION.f16921a;
        }
        U();
    }

    public final void Y() {
        View view = this.f16881a;
        if (view == null || view.getResources() == null) {
            return;
        }
        int i7 = this.f16881a.getResources().getConfiguration().fontWeightAdjustment;
        if (i7 == Integer.MAX_VALUE || i7 < 300) {
            this.f16892l &= ~f.BOLD_TEXT.f16921a;
        } else {
            this.f16892l |= f.BOLD_TEXT.f16921a;
        }
        U();
    }

    public void Z(k kVar) {
        this.f16899s = kVar;
    }

    public final boolean a0(final l lVar) {
        return lVar.f17025j > 0 && (l.A0(this.f16889i, new InterfaceC2565d() { // from class: io.flutter.view.c
            @Override // q5.InterfaceC2565d
            public final boolean test(Object obj) {
                return e.E(lVar, (e.l) obj);
            }
        }) || !l.A0(this.f16889i, new InterfaceC2565d() { // from class: io.flutter.view.d
            @Override // q5.InterfaceC2565d
            public final boolean test(Object obj) {
                return e.F((e.l) obj);
            }
        }));
    }

    public void b0(ByteBuffer byteBuffer, String[] strArr) {
        while (byteBuffer.hasRemaining()) {
            h hVarX = x(byteBuffer.getInt());
            hVarX.f16950c = byteBuffer.getInt();
            int i7 = byteBuffer.getInt();
            String str = null;
            hVarX.f16951d = i7 == -1 ? null : strArr[i7];
            int i8 = byteBuffer.getInt();
            if (i8 != -1) {
                str = strArr[i8];
            }
            hVarX.f16952e = str;
        }
    }

    public void c0(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
        l lVar;
        l lVar2;
        float f7;
        float f8;
        View viewB;
        ArrayList<l> arrayList = new ArrayList();
        while (byteBuffer.hasRemaining()) {
            l lVarY = y(byteBuffer.getInt());
            lVarY.D0(byteBuffer, strArr, byteBufferArr);
            if (!lVarY.v0(i.IS_HIDDEN)) {
                if (lVarY.v0(i.IS_FOCUSED)) {
                    this.f16893m = lVarY;
                }
                if (lVarY.f16990D) {
                    arrayList.add(lVarY);
                }
                if (lVarY.f17024i != -1 && !this.f16885e.c(lVarY.f17024i) && (viewB = this.f16885e.b(lVarY.f17024i)) != null) {
                    viewB.setImportantForAccessibility(0);
                }
            }
        }
        HashSet hashSet = new HashSet();
        l lVarZ = z();
        ArrayList<l> arrayList2 = new ArrayList();
        if (lVarZ != null) {
            float[] fArr = new float[16];
            Matrix.setIdentityM(fArr, 0);
            lVarZ.C0(fArr, hashSet, false);
            lVarZ.e0(arrayList2);
        }
        l lVar3 = null;
        for (l lVar4 : arrayList2) {
            if (!this.f16896p.contains(Integer.valueOf(lVar4.f17015b))) {
                lVar3 = lVar4;
            }
        }
        if (lVar3 == null && arrayList2.size() > 0) {
            lVar3 = (l) arrayList2.get(arrayList2.size() - 1);
        }
        if (lVar3 != null && (lVar3.f17015b != this.f16897q || arrayList2.size() != this.f16896p.size())) {
            this.f16897q = lVar3.f17015b;
            N(lVar3);
        }
        this.f16896p.clear();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            this.f16896p.add(Integer.valueOf(((l) it.next()).f17015b));
        }
        Iterator it2 = this.f16887g.entrySet().iterator();
        while (it2.hasNext()) {
            l lVar5 = (l) ((Map.Entry) it2.next()).getValue();
            if (!hashSet.contains(lVar5)) {
                d0(lVar5);
                it2.remove();
            }
        }
        V(0);
        for (l lVar6 : arrayList) {
            if (lVar6.h0()) {
                AccessibilityEvent accessibilityEventH = H(lVar6.f17015b, 4096);
                float f9 = lVar6.f17027l;
                float f10 = lVar6.f17028m;
                if (Float.isInfinite(lVar6.f17028m)) {
                    if (f9 > 70000.0f) {
                        f9 = 70000.0f;
                    }
                    f10 = 100000.0f;
                }
                if (Float.isInfinite(lVar6.f17029n)) {
                    f7 = f10 + 100000.0f;
                    if (f9 < -70000.0f) {
                        f9 = -70000.0f;
                    }
                    f8 = f9 + 100000.0f;
                } else {
                    f7 = f10 - lVar6.f17029n;
                    f8 = f9 - lVar6.f17029n;
                }
                if (lVar6.s0(g.SCROLL_UP) || lVar6.s0(g.SCROLL_DOWN)) {
                    accessibilityEventH.setScrollY((int) f8);
                    accessibilityEventH.setMaxScrollY((int) f7);
                } else if (lVar6.s0(g.SCROLL_LEFT) || lVar6.s0(g.SCROLL_RIGHT)) {
                    accessibilityEventH.setScrollX((int) f8);
                    accessibilityEventH.setMaxScrollX((int) f7);
                }
                if (lVar6.f17025j > 0) {
                    accessibilityEventH.setItemCount(lVar6.f17025j);
                    accessibilityEventH.setFromIndex(lVar6.f17026k);
                    Iterator it3 = lVar6.f17007U.iterator();
                    int i7 = 0;
                    while (it3.hasNext()) {
                        if (!((l) it3.next()).v0(i.IS_HIDDEN)) {
                            i7++;
                        }
                    }
                    accessibilityEventH.setToIndex((lVar6.f17026k + i7) - 1);
                }
                T(accessibilityEventH);
            }
            if (lVar6.v0(i.IS_LIVE_REGION) && lVar6.g0()) {
                V(lVar6.f17015b);
            }
            l lVar7 = this.f16889i;
            if (lVar7 != null && lVar7.f17015b == lVar6.f17015b) {
                i iVar = i.IS_SELECTED;
                if (!lVar6.t0(iVar) && lVar6.v0(iVar)) {
                    AccessibilityEvent accessibilityEventH2 = H(lVar6.f17015b, 4);
                    accessibilityEventH2.getText().add(lVar6.f17031p);
                    T(accessibilityEventH2);
                }
            }
            l lVar8 = this.f16893m;
            if (lVar8 != null && lVar8.f17015b == lVar6.f17015b && ((lVar2 = this.f16894n) == null || lVar2.f17015b != this.f16893m.f17015b)) {
                this.f16894n = this.f16893m;
                T(H(lVar6.f17015b, 8));
            } else if (this.f16893m == null) {
                this.f16894n = null;
            }
            l lVar9 = this.f16893m;
            if (lVar9 != null && lVar9.f17015b == lVar6.f17015b) {
                i iVar2 = i.IS_TEXT_FIELD;
                if (lVar6.t0(iVar2) && lVar6.v0(iVar2) && ((lVar = this.f16889i) == null || lVar.f17015b == this.f16893m.f17015b)) {
                    String str = lVar6.f16998L != null ? lVar6.f16998L : "";
                    String str2 = lVar6.f17033r != null ? lVar6.f17033r : "";
                    AccessibilityEvent accessibilityEventU = u(lVar6.f17015b, str, str2);
                    if (accessibilityEventU != null) {
                        T(accessibilityEventU);
                    }
                    if (lVar6.f16993G != lVar6.f17022g || lVar6.f16994H != lVar6.f17023h) {
                        AccessibilityEvent accessibilityEventH3 = H(lVar6.f17015b, 8192);
                        accessibilityEventH3.getText().add(str2);
                        accessibilityEventH3.setFromIndex(lVar6.f17022g);
                        accessibilityEventH3.setToIndex(lVar6.f17023h);
                        accessibilityEventH3.setItemCount(str2.length());
                        T(accessibilityEventH3);
                    }
                }
            }
        }
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i7) {
        int i8;
        boolean z7 = true;
        X(true);
        if (i7 >= 65536) {
            return this.f16884d.createAccessibilityNodeInfo(i7);
        }
        if (i7 == -1) {
            AccessibilityNodeInfo accessibilityNodeInfoI = I(this.f16881a);
            this.f16881a.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoI);
            if (this.f16887g.containsKey(0)) {
                accessibilityNodeInfoI.addChild(this.f16881a, 0);
            }
            accessibilityNodeInfoI.setImportantForAccessibility(false);
            return accessibilityNodeInfoI;
        }
        l lVar = (l) this.f16887g.get(Integer.valueOf(i7));
        if (lVar == null) {
            return null;
        }
        if (lVar.f17024i != -1 && this.f16885e.c(lVar.f17024i)) {
            View viewB = this.f16885e.b(lVar.f17024i);
            if (viewB == null) {
                return null;
            }
            return this.f16884d.getRootNode(viewB, lVar.f17015b, lVar.k0());
        }
        AccessibilityNodeInfo accessibilityNodeInfoJ = J(this.f16881a, i7);
        int i9 = Build.VERSION.SDK_INT;
        accessibilityNodeInfoJ.setImportantForAccessibility(C(lVar));
        accessibilityNodeInfoJ.setViewIdResourceName("");
        if (lVar.f17030o != null) {
            accessibilityNodeInfoJ.setViewIdResourceName(lVar.f17030o);
        }
        accessibilityNodeInfoJ.setPackageName(this.f16881a.getContext().getPackageName());
        accessibilityNodeInfoJ.setClassName("android.view.View");
        accessibilityNodeInfoJ.setSource(this.f16881a, i7);
        accessibilityNodeInfoJ.setFocusable(lVar.x0());
        l lVar2 = this.f16893m;
        if (lVar2 != null) {
            accessibilityNodeInfoJ.setFocused(lVar2.f17015b == i7);
        }
        l lVar3 = this.f16889i;
        if (lVar3 != null) {
            accessibilityNodeInfoJ.setAccessibilityFocused(lVar3.f17015b == i7);
        }
        i iVar = i.IS_TEXT_FIELD;
        if (lVar.v0(iVar)) {
            accessibilityNodeInfoJ.setPassword(lVar.v0(i.IS_OBSCURED));
            if (!lVar.v0(i.IS_READ_ONLY)) {
                accessibilityNodeInfoJ.setClassName("android.widget.EditText");
            }
            accessibilityNodeInfoJ.setEditable(!lVar.v0(r9));
            if (lVar.f17022g != -1 && lVar.f17023h != -1) {
                accessibilityNodeInfoJ.setTextSelection(lVar.f17022g, lVar.f17023h);
            }
            l lVar4 = this.f16889i;
            if (lVar4 != null && lVar4.f17015b == i7) {
                accessibilityNodeInfoJ.setLiveRegion(1);
            }
            if (lVar.u0(g.MOVE_CURSOR_FORWARD_BY_CHARACTER)) {
                accessibilityNodeInfoJ.addAction(256);
                i8 = 1;
            } else {
                i8 = 0;
            }
            if (lVar.u0(g.MOVE_CURSOR_BACKWARD_BY_CHARACTER)) {
                accessibilityNodeInfoJ.addAction(512);
                i8 = 1;
            }
            if (lVar.u0(g.MOVE_CURSOR_FORWARD_BY_WORD)) {
                accessibilityNodeInfoJ.addAction(256);
                i8 |= 2;
            }
            if (lVar.u0(g.MOVE_CURSOR_BACKWARD_BY_WORD)) {
                accessibilityNodeInfoJ.addAction(512);
                i8 |= 2;
            }
            accessibilityNodeInfoJ.setMovementGranularities(i8);
            if (lVar.f17020e >= 0) {
                int length = lVar.f17033r == null ? 0 : lVar.f17033r.length();
                int unused = lVar.f17021f;
                int unused2 = lVar.f17020e;
                accessibilityNodeInfoJ.setMaxTextLength((length - lVar.f17021f) + lVar.f17020e);
            }
        }
        if (lVar.u0(g.SET_SELECTION)) {
            accessibilityNodeInfoJ.addAction(131072);
        }
        if (lVar.u0(g.COPY)) {
            accessibilityNodeInfoJ.addAction(16384);
        }
        if (lVar.u0(g.CUT)) {
            accessibilityNodeInfoJ.addAction(65536);
        }
        if (lVar.u0(g.PASTE)) {
            accessibilityNodeInfoJ.addAction(32768);
        }
        if (lVar.u0(g.SET_TEXT)) {
            accessibilityNodeInfoJ.addAction(2097152);
        }
        if (lVar.v0(i.IS_BUTTON)) {
            accessibilityNodeInfoJ.setClassName("android.widget.Button");
        }
        if (lVar.v0(i.IS_IMAGE)) {
            accessibilityNodeInfoJ.setClassName("android.widget.ImageView");
        }
        if (lVar.u0(g.DISMISS)) {
            accessibilityNodeInfoJ.setDismissable(true);
            accessibilityNodeInfoJ.addAction(1048576);
        }
        if (lVar.f17005S != null) {
            accessibilityNodeInfoJ.setParent(this.f16881a, lVar.f17005S.f17015b);
        } else {
            accessibilityNodeInfoJ.setParent(this.f16881a);
        }
        if (lVar.f16988B != -1) {
            accessibilityNodeInfoJ.setTraversalAfter(this.f16881a, lVar.f16988B);
        }
        Rect rectK0 = lVar.k0();
        if (lVar.f17005S != null) {
            Rect rectK02 = lVar.f17005S.k0();
            Rect rect = new Rect(rectK0);
            rect.offset(-rectK02.left, -rectK02.top);
            accessibilityNodeInfoJ.setBoundsInParent(rect);
        } else {
            accessibilityNodeInfoJ.setBoundsInParent(rectK0);
        }
        accessibilityNodeInfoJ.setBoundsInScreen(w(rectK0));
        accessibilityNodeInfoJ.setVisibleToUser(true);
        accessibilityNodeInfoJ.setEnabled(!lVar.v0(i.HAS_ENABLED_STATE) || lVar.v0(i.IS_ENABLED));
        if (lVar.u0(g.TAP)) {
            if (lVar.f17009W != null) {
                accessibilityNodeInfoJ.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, lVar.f17009W.f16952e));
                accessibilityNodeInfoJ.setClickable(true);
            } else {
                accessibilityNodeInfoJ.addAction(16);
                accessibilityNodeInfoJ.setClickable(true);
            }
        } else if (lVar.v0(i.IS_SLIDER)) {
            accessibilityNodeInfoJ.addAction(16);
            accessibilityNodeInfoJ.setClickable(true);
        }
        if (lVar.u0(g.LONG_PRESS)) {
            if (lVar.f17010X != null) {
                accessibilityNodeInfoJ.addAction(new AccessibilityNodeInfo.AccessibilityAction(32, lVar.f17010X.f16952e));
                accessibilityNodeInfoJ.setLongClickable(true);
            } else {
                accessibilityNodeInfoJ.addAction(32);
                accessibilityNodeInfoJ.setLongClickable(true);
            }
        }
        g gVar = g.SCROLL_LEFT;
        if (lVar.u0(gVar) || lVar.u0(g.SCROLL_UP) || lVar.u0(g.SCROLL_RIGHT) || lVar.u0(g.SCROLL_DOWN)) {
            accessibilityNodeInfoJ.setScrollable(true);
            if (lVar.v0(i.HAS_IMPLICIT_SCROLLING)) {
                if (lVar.u0(gVar) || lVar.u0(g.SCROLL_RIGHT)) {
                    if (a0(lVar)) {
                        accessibilityNodeInfoJ.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(0, lVar.f17025j, false));
                    } else {
                        accessibilityNodeInfoJ.setClassName("android.widget.HorizontalScrollView");
                    }
                } else if (a0(lVar)) {
                    accessibilityNodeInfoJ.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(lVar.f17025j, 0, false));
                } else {
                    accessibilityNodeInfoJ.setClassName("android.widget.ScrollView");
                }
            }
            if (lVar.u0(gVar) || lVar.u0(g.SCROLL_UP)) {
                accessibilityNodeInfoJ.addAction(4096);
            }
            if (lVar.u0(g.SCROLL_RIGHT) || lVar.u0(g.SCROLL_DOWN)) {
                accessibilityNodeInfoJ.addAction(8192);
            }
        }
        g gVar2 = g.INCREASE;
        if (lVar.u0(gVar2) || lVar.u0(g.DECREASE)) {
            accessibilityNodeInfoJ.setClassName("android.widget.SeekBar");
            if (lVar.u0(gVar2)) {
                accessibilityNodeInfoJ.addAction(4096);
            }
            if (lVar.u0(g.DECREASE)) {
                accessibilityNodeInfoJ.addAction(8192);
            }
        }
        if (lVar.v0(i.IS_LIVE_REGION)) {
            accessibilityNodeInfoJ.setLiveRegion(1);
        }
        if (lVar.v0(iVar)) {
            accessibilityNodeInfoJ.setText(lVar.q0());
            if (i9 >= 28) {
                accessibilityNodeInfoJ.setHintText(lVar.p0());
            }
        } else if (!lVar.v0(i.SCOPES_ROUTE)) {
            CharSequence charSequenceR0 = lVar.r0();
            if (i9 < 28 && lVar.f17041z != null) {
                charSequenceR0 = ((Object) (charSequenceR0 != null ? charSequenceR0 : "")) + "\n" + lVar.f17041z;
            }
            if (charSequenceR0 != null) {
                accessibilityNodeInfoJ.setContentDescription(charSequenceR0);
            }
        }
        if (i9 >= 28 && lVar.f17041z != null) {
            accessibilityNodeInfoJ.setTooltipText(lVar.f17041z);
            if (lVar.r0() == null) {
                accessibilityNodeInfoJ.setContentDescription(lVar.f17041z);
            }
        }
        boolean zV0 = lVar.v0(i.HAS_CHECKED_STATE);
        boolean zV02 = lVar.v0(i.HAS_TOGGLED_STATE);
        if (!zV0 && !zV02) {
            z7 = false;
        }
        accessibilityNodeInfoJ.setCheckable(z7);
        if (zV0) {
            accessibilityNodeInfoJ.setChecked(lVar.v0(i.IS_CHECKED));
            if (lVar.v0(i.IS_IN_MUTUALLY_EXCLUSIVE_GROUP)) {
                accessibilityNodeInfoJ.setClassName("android.widget.RadioButton");
            } else {
                accessibilityNodeInfoJ.setClassName("android.widget.CheckBox");
            }
        } else if (zV02) {
            accessibilityNodeInfoJ.setChecked(lVar.v0(i.IS_TOGGLED));
            accessibilityNodeInfoJ.setClassName("android.widget.Switch");
        }
        accessibilityNodeInfoJ.setSelected(lVar.v0(i.IS_SELECTED));
        if (i9 >= 28) {
            accessibilityNodeInfoJ.setHeading(lVar.v0(i.IS_HEADER));
        }
        l lVar5 = this.f16889i;
        if (lVar5 == null || lVar5.f17015b != i7) {
            accessibilityNodeInfoJ.addAction(64);
        } else {
            accessibilityNodeInfoJ.addAction(128);
        }
        if (lVar.f17008V != null) {
            for (h hVar : lVar.f17008V) {
                accessibilityNodeInfoJ.addAction(new AccessibilityNodeInfo.AccessibilityAction(hVar.f16948a, hVar.f16951d));
            }
        }
        for (l lVar6 : lVar.f17006T) {
            if (!lVar6.v0(i.IS_HIDDEN)) {
                if (lVar6.f17024i != -1) {
                    View viewB2 = this.f16885e.b(lVar6.f17024i);
                    if (!this.f16885e.c(lVar6.f17024i)) {
                        viewB2.setImportantForAccessibility(0);
                        accessibilityNodeInfoJ.addChild(viewB2);
                    }
                }
                accessibilityNodeInfoJ.addChild(this.f16881a, lVar6.f17015b);
            }
        }
        return accessibilityNodeInfoJ;
    }

    public final void d0(l lVar) {
        View viewB;
        Integer num;
        lVar.f17005S = null;
        if (lVar.f17024i != -1 && (num = this.f16890j) != null && this.f16884d.platformViewOfNode(num.intValue()) == this.f16885e.b(lVar.f17024i)) {
            S(this.f16890j.intValue(), 65536);
            this.f16890j = null;
        }
        if (lVar.f17024i != -1 && (viewB = this.f16885e.b(lVar.f17024i)) != null) {
            viewB.setImportantForAccessibility(4);
        }
        l lVar2 = this.f16889i;
        if (lVar2 == lVar) {
            S(lVar2.f17015b, 65536);
            this.f16889i = null;
        }
        if (this.f16893m == lVar) {
            this.f16893m = null;
        }
        if (this.f16895o == lVar) {
            this.f16895o = null;
        }
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public AccessibilityNodeInfo findFocus(int i7) {
        if (i7 == 1) {
            l lVar = this.f16893m;
            if (lVar != null) {
                return createAccessibilityNodeInfo(lVar.f17015b);
            }
            Integer num = this.f16891k;
            if (num != null) {
                return createAccessibilityNodeInfo(num.intValue());
            }
        } else if (i7 != 2) {
            return null;
        }
        l lVar2 = this.f16889i;
        if (lVar2 != null) {
            return createAccessibilityNodeInfo(lVar2.f17015b);
        }
        Integer num2 = this.f16890j;
        if (num2 != null) {
            return createAccessibilityNodeInfo(num2.intValue());
        }
        return null;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public boolean performAction(int i7, int i8, Bundle bundle) {
        if (i7 >= 65536) {
            boolean zPerformAction = this.f16884d.performAction(i7, i8, bundle);
            if (zPerformAction && i8 == 128) {
                this.f16890j = null;
            }
            return zPerformAction;
        }
        l lVar = (l) this.f16887g.get(Integer.valueOf(i7));
        if (lVar == null) {
            return false;
        }
        switch (i8) {
            case com.amazon.c.a.a.c.f10119g /* 16 */:
                this.f16882b.b(i7, g.TAP);
                return true;
            case com.amazon.c.a.a.c.f10120h /* 32 */:
                this.f16882b.b(i7, g.LONG_PRESS);
                return true;
            case 64:
                if (this.f16889i == null) {
                    this.f16881a.invalidate();
                }
                this.f16889i = lVar;
                this.f16882b.b(i7, g.DID_GAIN_ACCESSIBILITY_FOCUS);
                HashMap map = new HashMap();
                map.put("type", "didGainFocus");
                map.put("nodeId", Integer.valueOf(lVar.f17015b));
                this.f16882b.f4951a.c(map);
                S(i7, 32768);
                if (lVar.u0(g.INCREASE) || lVar.u0(g.DECREASE)) {
                    S(i7, 4);
                }
                return true;
            case 128:
                l lVar2 = this.f16889i;
                if (lVar2 != null && lVar2.f17015b == i7) {
                    this.f16889i = null;
                }
                Integer num = this.f16890j;
                if (num != null && num.intValue() == i7) {
                    this.f16890j = null;
                }
                this.f16882b.b(i7, g.DID_LOSE_ACCESSIBILITY_FOCUS);
                S(i7, 65536);
                return true;
            case 256:
                return O(lVar, i7, bundle, true);
            case 512:
                return O(lVar, i7, bundle, false);
            case 4096:
                g gVar = g.SCROLL_UP;
                if (lVar.u0(gVar)) {
                    this.f16882b.b(i7, gVar);
                } else {
                    g gVar2 = g.SCROLL_LEFT;
                    if (lVar.u0(gVar2)) {
                        this.f16882b.b(i7, gVar2);
                    } else {
                        g gVar3 = g.INCREASE;
                        if (!lVar.u0(gVar3)) {
                            return false;
                        }
                        lVar.f17033r = lVar.f17035t;
                        lVar.f17034s = lVar.f17036u;
                        S(i7, 4);
                        this.f16882b.b(i7, gVar3);
                    }
                }
                return true;
            case 8192:
                g gVar4 = g.SCROLL_DOWN;
                if (lVar.u0(gVar4)) {
                    this.f16882b.b(i7, gVar4);
                } else {
                    g gVar5 = g.SCROLL_RIGHT;
                    if (lVar.u0(gVar5)) {
                        this.f16882b.b(i7, gVar5);
                    } else {
                        g gVar6 = g.DECREASE;
                        if (!lVar.u0(gVar6)) {
                            return false;
                        }
                        lVar.f17033r = lVar.f17037v;
                        lVar.f17034s = lVar.f17038w;
                        S(i7, 4);
                        this.f16882b.b(i7, gVar6);
                    }
                }
                return true;
            case 16384:
                this.f16882b.b(i7, g.COPY);
                return true;
            case 32768:
                this.f16882b.b(i7, g.PASTE);
                return true;
            case 65536:
                this.f16882b.b(i7, g.CUT);
                return true;
            case 131072:
                HashMap map2 = new HashMap();
                if (bundle != null && bundle.containsKey("ACTION_ARGUMENT_SELECTION_START_INT") && bundle.containsKey("ACTION_ARGUMENT_SELECTION_END_INT")) {
                    map2.put("base", Integer.valueOf(bundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT")));
                    map2.put("extent", Integer.valueOf(bundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT")));
                } else {
                    map2.put("base", Integer.valueOf(lVar.f17023h));
                    map2.put("extent", Integer.valueOf(lVar.f17023h));
                }
                this.f16882b.c(i7, g.SET_SELECTION, map2);
                l lVar3 = (l) this.f16887g.get(Integer.valueOf(i7));
                lVar3.f17022g = ((Integer) map2.get("base")).intValue();
                lVar3.f17023h = ((Integer) map2.get("extent")).intValue();
                return true;
            case 1048576:
                this.f16882b.b(i7, g.DISMISS);
                return true;
            case 2097152:
                return P(lVar, i7, bundle);
            case R.id.accessibilityActionShowOnScreen:
                this.f16882b.b(i7, g.SHOW_ON_SCREEN);
                return true;
            default:
                h hVar = (h) this.f16888h.get(Integer.valueOf(i8 - f16878B));
                if (hVar == null) {
                    return false;
                }
                this.f16882b.c(i7, g.CUSTOM_ACTION, Integer.valueOf(hVar.f16949b));
                return true;
        }
    }

    public final AccessibilityEvent u(int i7, String str, String str2) {
        AccessibilityEvent accessibilityEventH = H(i7, 16);
        accessibilityEventH.setBeforeText(str);
        accessibilityEventH.getText().add(str2);
        int i8 = 0;
        while (i8 < str.length() && i8 < str2.length() && str.charAt(i8) == str2.charAt(i8)) {
            i8++;
        }
        if (i8 >= str.length() && i8 >= str2.length()) {
            return null;
        }
        accessibilityEventH.setFromIndex(i8);
        int length = str.length() - 1;
        int length2 = str2.length() - 1;
        while (length >= i8 && length2 >= i8 && str.charAt(length) == str2.charAt(length2)) {
            length--;
            length2--;
        }
        accessibilityEventH.setRemovedCount((length - i8) + 1);
        accessibilityEventH.setAddedCount((length2 - i8) + 1);
        return accessibilityEventH;
    }

    public boolean v(View view, View view2, AccessibilityEvent accessibilityEvent) {
        Integer recordFlutterId;
        if (!this.f16884d.requestSendAccessibilityEvent(view, view2, accessibilityEvent) || (recordFlutterId = this.f16884d.getRecordFlutterId(view, accessibilityEvent)) == null) {
            return false;
        }
        int eventType = accessibilityEvent.getEventType();
        if (eventType == 8) {
            this.f16891k = recordFlutterId;
            this.f16893m = null;
            return true;
        }
        if (eventType == 128) {
            this.f16895o = null;
            return true;
        }
        if (eventType == 32768) {
            this.f16890j = recordFlutterId;
            this.f16889i = null;
            return true;
        }
        if (eventType != 65536) {
            return true;
        }
        this.f16891k = null;
        this.f16890j = null;
        return true;
    }

    public final Rect w(Rect rect) {
        Rect rect2 = new Rect(rect);
        int[] iArr = new int[2];
        this.f16881a.getLocationOnScreen(iArr);
        rect2.offset(iArr[0], iArr[1]);
        return rect2;
    }

    public final h x(int i7) {
        h hVar = (h) this.f16888h.get(Integer.valueOf(i7));
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h();
        hVar2.f16949b = i7;
        hVar2.f16948a = f16878B + i7;
        this.f16888h.put(Integer.valueOf(i7), hVar2);
        return hVar2;
    }

    public final l y(int i7) {
        l lVar = (l) this.f16887g.get(Integer.valueOf(i7));
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(this);
        lVar2.f17015b = i7;
        this.f16887g.put(Integer.valueOf(i7), lVar2);
        return lVar2;
    }

    public final l z() {
        return (l) this.f16887g.get(0);
    }

    public e(View view, U4.a aVar, AccessibilityManager accessibilityManager, ContentResolver contentResolver, AccessibilityViewEmbedder accessibilityViewEmbedder, InterfaceC2020q interfaceC2020q) {
        this.f16887g = new HashMap();
        this.f16888h = new HashMap();
        this.f16892l = 0;
        this.f16896p = new ArrayList();
        this.f16897q = 0;
        this.f16898r = 0;
        this.f16900t = false;
        this.f16901u = false;
        this.f16902v = new a();
        b bVar = new b();
        this.f16903w = bVar;
        c cVar = new c(new Handler());
        this.f16905y = cVar;
        this.f16881a = view;
        this.f16882b = aVar;
        this.f16883c = accessibilityManager;
        this.f16886f = contentResolver;
        this.f16884d = accessibilityViewEmbedder;
        this.f16885e = interfaceC2020q;
        bVar.onAccessibilityStateChanged(accessibilityManager.isEnabled());
        accessibilityManager.addAccessibilityStateChangeListener(bVar);
        d dVar = new d(accessibilityManager);
        this.f16904x = dVar;
        dVar.onTouchExplorationStateChanged(accessibilityManager.isTouchExplorationEnabled());
        accessibilityManager.addTouchExplorationStateChangeListener(dVar);
        this.f16892l |= f.NO_ANNOUNCE.f16921a;
        cVar.onChange(false);
        contentResolver.registerContentObserver(Settings.Global.getUriFor("transition_animation_scale"), false, cVar);
        if (Build.VERSION.SDK_INT >= 31) {
            Y();
        }
        interfaceC2020q.a(this);
    }
}
