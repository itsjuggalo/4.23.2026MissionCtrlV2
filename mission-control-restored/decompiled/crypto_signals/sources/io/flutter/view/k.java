package io.flutter.view;

import android.R;
import android.content.ContentResolver;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import e3.w;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import s1.C0994k;

/* JADX INFO: loaded from: classes.dex */
public final class k extends AccessibilityNodeProvider {
    public static final /* synthetic */ int y = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f7321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0994k f7322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AccessibilityManager f7323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AccessibilityViewEmbedder f7324d;
    public final io.flutter.plugin.platform.p e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ContentResolver f7325f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap f7326g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap f7327h;
    public g i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f7328j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f7329k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f7330l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public g f7331m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public g f7332n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public g f7333o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList f7334p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f7335q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Q3.h f7336r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f7337s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f7338t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final a f7339u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b f7340v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final c f7341w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final L.a f7342x;

    public k(View view, C0994k c0994k, AccessibilityManager accessibilityManager, ContentResolver contentResolver, io.flutter.plugin.platform.p pVar) {
        AccessibilityViewEmbedder accessibilityViewEmbedder = new AccessibilityViewEmbedder(view, 65536);
        this.f7326g = new HashMap();
        this.f7327h = new HashMap();
        this.f7330l = 0;
        this.f7334p = new ArrayList();
        this.f7335q = 0;
        this.f7337s = false;
        this.f7338t = false;
        this.f7339u = new a(this);
        b bVar = new b(this);
        this.f7340v = bVar;
        L.a aVar = new L.a(this, new Handler(), 2);
        this.f7342x = aVar;
        this.f7321a = view;
        this.f7322b = c0994k;
        this.f7323c = accessibilityManager;
        this.f7325f = contentResolver;
        this.f7324d = accessibilityViewEmbedder;
        this.e = pVar;
        bVar.onAccessibilityStateChanged(accessibilityManager.isEnabled());
        accessibilityManager.addAccessibilityStateChangeListener(bVar);
        c cVar = new c(this, accessibilityManager);
        this.f7341w = cVar;
        cVar.onTouchExplorationStateChanged(accessibilityManager.isTouchExplorationEnabled());
        accessibilityManager.addTouchExplorationStateChangeListener(cVar);
        this.f7330l |= 128;
        aVar.onChange(false, null);
        contentResolver.registerContentObserver(Settings.Global.getUriFor("transition_animation_scale"), false, aVar);
        if (Build.VERSION.SDK_INT >= 31 && view != null && view.getResources() != null) {
            int i = view.getResources().getConfiguration().fontWeightAdjustment;
            if (i == Integer.MAX_VALUE || i < 300) {
                this.f7330l &= -9;
            } else {
                this.f7330l |= 8;
            }
            ((FlutterJNI) c0994k.f9531c).setAccessibilityFeatures(this.f7330l);
        }
        ((io.flutter.plugin.platform.o) pVar.f7201b).i.f7136a = this;
        ((io.flutter.plugin.platform.n) pVar.f7202c).f7170h.f7136a = this;
    }

    public final boolean a(View view, View view2, AccessibilityEvent accessibilityEvent) {
        Integer recordFlutterId;
        AccessibilityViewEmbedder accessibilityViewEmbedder = this.f7324d;
        if (!accessibilityViewEmbedder.requestSendAccessibilityEvent(view, view2, accessibilityEvent) || (recordFlutterId = accessibilityViewEmbedder.getRecordFlutterId(view, accessibilityEvent)) == null) {
            return false;
        }
        int eventType = accessibilityEvent.getEventType();
        if (eventType == 8) {
            this.f7329k = recordFlutterId;
            this.f7331m = null;
            return true;
        }
        if (eventType == 128) {
            this.f7333o = null;
            return true;
        }
        if (eventType == 32768) {
            this.f7328j = recordFlutterId;
            this.i = null;
            return true;
        }
        if (eventType != 65536) {
            return true;
        }
        this.f7329k = null;
        this.f7328j = null;
        return true;
    }

    public final e b(int i) {
        HashMap map = this.f7327h;
        e eVar = (e) map.get(Integer.valueOf(i));
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e();
        eVar2.f7267c = -1;
        eVar2.f7266b = i;
        eVar2.f7265a = 267386881 + i;
        map.put(Integer.valueOf(i), eVar2);
        return eVar2;
    }

    public final g c(int i) {
        HashMap map = this.f7326g;
        g gVar = (g) map.get(Integer.valueOf(i));
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this);
        gVar2.f7295b = i;
        map.put(Integer.valueOf(i), gVar2);
        return gVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        char c6;
        String str;
        int i6;
        int i7;
        i(true);
        AccessibilityViewEmbedder accessibilityViewEmbedder = this.f7324d;
        if (i >= 65536) {
            return accessibilityViewEmbedder.createAccessibilityNodeInfo(i);
        }
        HashMap map = this.f7326g;
        View view = this.f7321a;
        if (i == -1) {
            AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(view);
            view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
            if (map.containsKey(0)) {
                accessibilityNodeInfoObtain.addChild(view, 0);
            }
            accessibilityNodeInfoObtain.setImportantForAccessibility(false);
            return accessibilityNodeInfoObtain;
        }
        g gVar = (g) map.get(Integer.valueOf(i));
        if (gVar != null) {
            int i8 = gVar.i;
            io.flutter.plugin.platform.p pVar = this.e;
            if (i8 == -1 || !pVar.t(i8)) {
                AccessibilityNodeInfo accessibilityNodeInfoObtain2 = AccessibilityNodeInfo.obtain(view, i);
                int i9 = Build.VERSION.SDK_INT;
                accessibilityNodeInfoObtain2.setImportantForAccessibility((gVar.h(12) || (g.b(gVar) == null && gVar.f7297d == 0)) ? false : true);
                accessibilityNodeInfoObtain2.setViewIdResourceName("");
                String str2 = gVar.f7306o;
                if (str2 != null) {
                    accessibilityNodeInfoObtain2.setViewIdResourceName(str2);
                }
                accessibilityNodeInfoObtain2.setPackageName(view.getContext().getPackageName());
                accessibilityNodeInfoObtain2.setClassName("android.view.View");
                accessibilityNodeInfoObtain2.setSource(view, i);
                accessibilityNodeInfoObtain2.setFocusable(gVar.j());
                g gVar2 = this.f7331m;
                if (gVar2 != null) {
                    accessibilityNodeInfoObtain2.setFocused(gVar2.f7295b == i);
                }
                g gVar3 = this.i;
                if (gVar3 != null) {
                    accessibilityNodeInfoObtain2.setAccessibilityFocused(gVar3.f7295b == i);
                }
                if (gVar.h(5)) {
                    accessibilityNodeInfoObtain2.setPassword(gVar.h(11));
                    if (!gVar.h(21)) {
                        accessibilityNodeInfoObtain2.setClassName("android.widget.EditText");
                    }
                    accessibilityNodeInfoObtain2.setEditable(!gVar.h(21));
                    int i10 = gVar.f7299g;
                    if (i10 != -1 && (i7 = gVar.f7300h) != -1) {
                        accessibilityNodeInfoObtain2.setTextSelection(i10, i7);
                    }
                    g gVar4 = this.i;
                    if (gVar4 != null && gVar4.f7295b == i) {
                        accessibilityNodeInfoObtain2.setLiveRegion(1);
                    }
                    if (g.a(gVar, d.MOVE_CURSOR_FORWARD_BY_CHARACTER)) {
                        accessibilityNodeInfoObtain2.addAction(256);
                        i6 = 1;
                    } else {
                        i6 = 0;
                    }
                    if (g.a(gVar, d.MOVE_CURSOR_BACKWARD_BY_CHARACTER)) {
                        accessibilityNodeInfoObtain2.addAction(512);
                        i6 = 1;
                    }
                    if (g.a(gVar, d.MOVE_CURSOR_FORWARD_BY_WORD)) {
                        accessibilityNodeInfoObtain2.addAction(256);
                        i6 |= 2;
                    }
                    if (g.a(gVar, d.MOVE_CURSOR_BACKWARD_BY_WORD)) {
                        accessibilityNodeInfoObtain2.addAction(512);
                        i6 |= 2;
                    }
                    accessibilityNodeInfoObtain2.setMovementGranularities(i6);
                    c6 = 0;
                    if (gVar.e >= 0) {
                        String str3 = gVar.f7309r;
                        accessibilityNodeInfoObtain2.setMaxTextLength(((str3 == null ? 0 : str3.length()) - gVar.f7298f) + gVar.e);
                        c6 = 0;
                    }
                } else {
                    c6 = 0;
                }
                if (g.a(gVar, d.SET_SELECTION)) {
                    accessibilityNodeInfoObtain2.addAction(131072);
                }
                if (g.a(gVar, d.COPY)) {
                    accessibilityNodeInfoObtain2.addAction(16384);
                }
                if (g.a(gVar, d.CUT)) {
                    accessibilityNodeInfoObtain2.addAction(65536);
                }
                if (g.a(gVar, d.PASTE)) {
                    accessibilityNodeInfoObtain2.addAction(32768);
                }
                if (g.a(gVar, d.SET_TEXT)) {
                    accessibilityNodeInfoObtain2.addAction(2097152);
                }
                if (gVar.h(4)) {
                    accessibilityNodeInfoObtain2.setClassName("android.widget.Button");
                }
                if (gVar.h(15)) {
                    accessibilityNodeInfoObtain2.setClassName("android.widget.ImageView");
                }
                if (g.a(gVar, d.DISMISS)) {
                    accessibilityNodeInfoObtain2.setDismissable(true);
                    accessibilityNodeInfoObtain2.addAction(1048576);
                }
                g gVar5 = gVar.P;
                if (gVar5 != null) {
                    accessibilityNodeInfoObtain2.setParent(view, gVar5.f7295b);
                } else {
                    accessibilityNodeInfoObtain2.setParent(view);
                }
                int i11 = gVar.f7271B;
                if (i11 != -1) {
                    accessibilityNodeInfoObtain2.setTraversalAfter(view, i11);
                }
                Rect rect = gVar.f7293Z;
                g gVar6 = gVar.P;
                if (gVar6 != null) {
                    Rect rect2 = gVar6.f7293Z;
                    Rect rect3 = new Rect(rect);
                    rect3.offset(-rect2.left, -rect2.top);
                    accessibilityNodeInfoObtain2.setBoundsInParent(rect3);
                } else {
                    accessibilityNodeInfoObtain2.setBoundsInParent(rect);
                }
                Rect rect4 = new Rect(rect);
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                rect4.offset(iArr[c6], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(rect4);
                accessibilityNodeInfoObtain2.setVisibleToUser(true);
                accessibilityNodeInfoObtain2.setEnabled((!gVar.h(7) || gVar.h(8)) ? 1 : c6);
                if (g.a(gVar, d.TAP)) {
                    if (gVar.f7287T != null) {
                        accessibilityNodeInfoObtain2.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, gVar.f7287T.e));
                        accessibilityNodeInfoObtain2.setClickable(true);
                    } else {
                        accessibilityNodeInfoObtain2.addAction(16);
                        accessibilityNodeInfoObtain2.setClickable(true);
                    }
                } else if (gVar.h(24)) {
                    accessibilityNodeInfoObtain2.addAction(16);
                    accessibilityNodeInfoObtain2.setClickable(true);
                }
                if (g.a(gVar, d.LONG_PRESS)) {
                    if (gVar.f7288U != null) {
                        accessibilityNodeInfoObtain2.addAction(new AccessibilityNodeInfo.AccessibilityAction(32, gVar.f7288U.e));
                        accessibilityNodeInfoObtain2.setLongClickable(true);
                    } else {
                        accessibilityNodeInfoObtain2.addAction(32);
                        accessibilityNodeInfoObtain2.setLongClickable(true);
                    }
                }
                d dVar = d.SCROLL_LEFT;
                boolean zA = g.a(gVar, dVar);
                d dVar2 = d.SCROLL_DOWN;
                d dVar3 = d.SCROLL_UP;
                d dVar4 = d.SCROLL_RIGHT;
                if (zA || g.a(gVar, dVar3) || g.a(gVar, dVar4) || g.a(gVar, dVar2)) {
                    accessibilityNodeInfoObtain2.setScrollable(true);
                    if (gVar.h(19)) {
                        if (g.a(gVar, dVar) || g.a(gVar, dVar4)) {
                            boolean z6 = c6;
                            if (j(gVar)) {
                                accessibilityNodeInfoObtain2.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(z6 ? 1 : 0, gVar.f7301j, z6));
                            } else {
                                accessibilityNodeInfoObtain2.setClassName("android.widget.HorizontalScrollView");
                            }
                        } else if (j(gVar)) {
                            boolean z7 = c6;
                            accessibilityNodeInfoObtain2.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(gVar.f7301j, z7 ? 1 : 0, z7));
                        } else {
                            accessibilityNodeInfoObtain2.setClassName("android.widget.ScrollView");
                        }
                    }
                    if (g.a(gVar, dVar) || g.a(gVar, dVar3)) {
                        accessibilityNodeInfoObtain2.addAction(4096);
                    }
                    if (g.a(gVar, dVar4) || g.a(gVar, dVar2)) {
                        accessibilityNodeInfoObtain2.addAction(8192);
                    }
                }
                d dVar5 = d.INCREASE;
                boolean zA2 = g.a(gVar, dVar5);
                d dVar6 = d.DECREASE;
                if (zA2 || g.a(gVar, dVar6)) {
                    accessibilityNodeInfoObtain2.setClassName("android.widget.SeekBar");
                    if (g.a(gVar, dVar5)) {
                        accessibilityNodeInfoObtain2.addAction(4096);
                    }
                    if (g.a(gVar, dVar6)) {
                        accessibilityNodeInfoObtain2.addAction(8192);
                    }
                }
                if (gVar.h(16)) {
                    accessibilityNodeInfoObtain2.setLiveRegion(1);
                }
                if (gVar.h(5)) {
                    accessibilityNodeInfoObtain2.setText(g.d(gVar.f7309r, gVar.f7310s));
                    if (i9 >= 28) {
                        CharSequence[] charSequenceArr = {gVar.e(), g.d(gVar.f7315x, gVar.y)};
                        int i12 = 0;
                        CharSequence charSequence = null;
                        for (int i13 = 2; i12 < i13; i13 = 2) {
                            CharSequence charSequenceConcat = charSequenceArr[i12];
                            if (charSequenceConcat != null && charSequenceConcat.length() > 0) {
                                if (charSequence != null && charSequence.length() != 0) {
                                    charSequenceConcat = TextUtils.concat(charSequence, ", ", charSequenceConcat);
                                }
                                charSequence = charSequenceConcat;
                            }
                            i12++;
                        }
                        accessibilityNodeInfoObtain2.setHintText(charSequence);
                    }
                } else if (!gVar.h(12)) {
                    CharSequence charSequenceB = g.b(gVar);
                    if (i9 < 28 && gVar.f7316z != null) {
                        charSequenceB = ((Object) (charSequenceB != null ? charSequenceB : "")) + "\n" + gVar.f7316z;
                    }
                    if (charSequenceB != null) {
                        accessibilityNodeInfoObtain2.setContentDescription(charSequenceB);
                    }
                }
                int i14 = Build.VERSION.SDK_INT;
                if (i14 >= 28 && (str = gVar.f7316z) != null) {
                    accessibilityNodeInfoObtain2.setTooltipText(str);
                    if (g.b(gVar) == null) {
                        accessibilityNodeInfoObtain2.setContentDescription(gVar.f7316z);
                    }
                }
                boolean z8 = true;
                boolean zH = gVar.h(1);
                boolean zH2 = gVar.h(17);
                if (!zH && !zH2) {
                    z8 = false;
                }
                accessibilityNodeInfoObtain2.setCheckable(z8);
                if (zH) {
                    accessibilityNodeInfoObtain2.setChecked(gVar.h(2));
                    if (gVar.h(9)) {
                        accessibilityNodeInfoObtain2.setClassName("android.widget.RadioButton");
                    } else {
                        accessibilityNodeInfoObtain2.setClassName("android.widget.CheckBox");
                    }
                } else if (zH2) {
                    accessibilityNodeInfoObtain2.setChecked(gVar.h(18));
                    accessibilityNodeInfoObtain2.setClassName("android.widget.Switch");
                }
                accessibilityNodeInfoObtain2.setSelected(gVar.h(3));
                if (i14 >= 28) {
                    accessibilityNodeInfoObtain2.setHeading(gVar.h(10));
                }
                g gVar7 = this.i;
                if (gVar7 == null || gVar7.f7295b != i) {
                    accessibilityNodeInfoObtain2.addAction(64);
                } else {
                    accessibilityNodeInfoObtain2.addAction(128);
                }
                ArrayList<e> arrayList = gVar.f7286S;
                if (arrayList != null) {
                    for (e eVar : arrayList) {
                        accessibilityNodeInfoObtain2.addAction(new AccessibilityNodeInfo.AccessibilityAction(eVar.f7265a, eVar.f7268d));
                    }
                }
                for (g gVar8 : gVar.f7284Q) {
                    if (!gVar8.h(14)) {
                        int i15 = gVar8.i;
                        if (i15 != -1) {
                            View viewI = pVar.i(i15);
                            if (!pVar.t(gVar8.i)) {
                                viewI.setImportantForAccessibility(0);
                                accessibilityNodeInfoObtain2.addChild(viewI);
                            }
                        }
                        accessibilityNodeInfoObtain2.addChild(view, gVar8.f7295b);
                    }
                }
                return accessibilityNodeInfoObtain2;
            }
            View viewI2 = pVar.i(gVar.i);
            if (viewI2 != null) {
                return accessibilityViewEmbedder.getRootNode(viewI2, gVar.f7295b, gVar.f7293Z);
            }
        }
        return null;
    }

    public final AccessibilityEvent d(int i, int i6) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i6);
        View view = this.f7321a;
        accessibilityEventObtain.setPackageName(view.getContext().getPackageName());
        accessibilityEventObtain.setSource(view, i);
        return accessibilityEventObtain;
    }

    public final boolean e(MotionEvent motionEvent, boolean z6) {
        g gVarI;
        if (this.f7323c.isTouchExplorationEnabled()) {
            HashMap map = this.f7326g;
            if (!map.isEmpty()) {
                g gVarI2 = ((g) map.get(0)).i(new float[]{motionEvent.getX(), motionEvent.getY(), 0.0f, 1.0f}, z6);
                if (gVarI2 == null || gVarI2.i == -1) {
                    if (motionEvent.getAction() == 9 || motionEvent.getAction() == 7) {
                        float x6 = motionEvent.getX();
                        float y6 = motionEvent.getY();
                        if (!map.isEmpty() && (gVarI = ((g) map.get(0)).i(new float[]{x6, y6, 0.0f, 1.0f}, z6)) != this.f7333o) {
                            if (gVarI != null) {
                                g(gVarI.f7295b, 128);
                            }
                            g gVar = this.f7333o;
                            if (gVar != null) {
                                g(gVar.f7295b, 256);
                            }
                            this.f7333o = gVarI;
                        }
                    } else {
                        if (motionEvent.getAction() != 10) {
                            motionEvent.toString();
                            return false;
                        }
                        g gVar2 = this.f7333o;
                        if (gVar2 != null) {
                            g(gVar2.f7295b, 256);
                            this.f7333o = null;
                        }
                    }
                    return true;
                }
                if (!z6) {
                    return this.f7324d.onAccessibilityHoverEvent(gVarI2.f7295b, motionEvent);
                }
            }
        }
        return false;
    }

    public final boolean f(g gVar, int i, Bundle bundle, boolean z6) {
        int i6;
        int i7 = bundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
        boolean z7 = bundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
        int i8 = gVar.f7299g;
        int i9 = gVar.f7300h;
        if (i9 >= 0 && i8 >= 0) {
            if (i7 != 1) {
                if (i7 != 2) {
                    if (i7 != 4) {
                        if (i7 == 8 || i7 == 16) {
                            if (z6) {
                                gVar.f7300h = gVar.f7309r.length();
                            } else {
                                gVar.f7300h = 0;
                            }
                        }
                    } else if (z6 && i9 < gVar.f7309r.length()) {
                        Matcher matcher = Pattern.compile("(?!^)(\\n)").matcher(gVar.f7309r.substring(gVar.f7300h));
                        if (matcher.find()) {
                            gVar.f7300h += matcher.start(1);
                        } else {
                            gVar.f7300h = gVar.f7309r.length();
                        }
                    } else if (!z6 && gVar.f7300h > 0) {
                        Matcher matcher2 = Pattern.compile("(?s:.*)(\\n)").matcher(gVar.f7309r.substring(0, gVar.f7300h));
                        if (matcher2.find()) {
                            gVar.f7300h = matcher2.start(1);
                        } else {
                            gVar.f7300h = 0;
                        }
                    }
                } else if (z6 && i9 < gVar.f7309r.length()) {
                    Matcher matcher3 = Pattern.compile("\\p{L}(\\b)").matcher(gVar.f7309r.substring(gVar.f7300h));
                    matcher3.find();
                    if (matcher3.find()) {
                        gVar.f7300h += matcher3.start(1);
                    } else {
                        gVar.f7300h = gVar.f7309r.length();
                    }
                } else if (!z6 && gVar.f7300h > 0) {
                    Matcher matcher4 = Pattern.compile("(?s:.*)(\\b)\\p{L}").matcher(gVar.f7309r.substring(0, gVar.f7300h));
                    if (matcher4.find()) {
                        gVar.f7300h = matcher4.start(1);
                    }
                }
            } else if (z6 && i9 < gVar.f7309r.length()) {
                gVar.f7300h++;
            } else if (!z6 && (i6 = gVar.f7300h) > 0) {
                gVar.f7300h = i6 - 1;
            }
            if (!z7) {
                gVar.f7299g = gVar.f7300h;
            }
        }
        if (i8 != gVar.f7299g || i9 != gVar.f7300h) {
            String str = gVar.f7309r;
            if (str == null) {
                str = "";
            }
            AccessibilityEvent accessibilityEventD = d(gVar.f7295b, 8192);
            accessibilityEventD.getText().add(str);
            accessibilityEventD.setFromIndex(gVar.f7299g);
            accessibilityEventD.setToIndex(gVar.f7300h);
            accessibilityEventD.setItemCount(str.length());
            h(accessibilityEventD);
        }
        C0994k c0994k = this.f7322b;
        if (i7 == 1) {
            if (z6) {
                d dVar = d.MOVE_CURSOR_FORWARD_BY_CHARACTER;
                if (g.a(gVar, dVar)) {
                    c0994k.F(i, dVar, Boolean.valueOf(z7));
                    return true;
                }
            }
            if (!z6) {
                d dVar2 = d.MOVE_CURSOR_BACKWARD_BY_CHARACTER;
                if (g.a(gVar, dVar2)) {
                    c0994k.F(i, dVar2, Boolean.valueOf(z7));
                    return true;
                }
            }
        } else if (i7 == 2) {
            if (z6) {
                d dVar3 = d.MOVE_CURSOR_FORWARD_BY_WORD;
                if (g.a(gVar, dVar3)) {
                    c0994k.F(i, dVar3, Boolean.valueOf(z7));
                    return true;
                }
            }
            if (!z6) {
                d dVar4 = d.MOVE_CURSOR_BACKWARD_BY_WORD;
                if (g.a(gVar, dVar4)) {
                    c0994k.F(i, dVar4, Boolean.valueOf(z7));
                    return true;
                }
            }
        } else if (i7 == 4 || i7 == 8 || i7 == 16) {
            return true;
        }
        return false;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo findFocus(int i) {
        if (i == 1) {
            g gVar = this.f7331m;
            if (gVar != null) {
                return createAccessibilityNodeInfo(gVar.f7295b);
            }
            Integer num = this.f7329k;
            if (num != null) {
                return createAccessibilityNodeInfo(num.intValue());
            }
        } else if (i != 2) {
            return null;
        }
        g gVar2 = this.i;
        if (gVar2 != null) {
            return createAccessibilityNodeInfo(gVar2.f7295b);
        }
        Integer num2 = this.f7328j;
        if (num2 != null) {
            return createAccessibilityNodeInfo(num2.intValue());
        }
        return null;
    }

    public final void g(int i, int i6) {
        if (this.f7323c.isEnabled()) {
            h(d(i, i6));
        }
    }

    public final void h(AccessibilityEvent accessibilityEvent) {
        if (this.f7323c.isEnabled()) {
            View view = this.f7321a;
            view.getParent().requestSendAccessibilityEvent(view, accessibilityEvent);
        }
    }

    public final void i(boolean z6) {
        if (this.f7337s == z6) {
            return;
        }
        this.f7337s = z6;
        if (z6) {
            this.f7330l |= 1;
        } else {
            this.f7330l &= -2;
        }
        ((FlutterJNI) this.f7322b.f9531c).setAccessibilityFeatures(this.f7330l);
    }

    public final boolean j(g gVar) {
        if (gVar.f7301j <= 0) {
            return false;
        }
        g gVar2 = this.i;
        g gVar3 = null;
        if (gVar2 != null) {
            g gVar4 = gVar2.P;
            while (true) {
                if (gVar4 == null) {
                    gVar4 = null;
                    break;
                }
                if (gVar4 == gVar) {
                    break;
                }
                gVar4 = gVar4.P;
            }
            if (gVar4 != null) {
                return true;
            }
        }
        g gVar5 = this.i;
        if (gVar5 == null) {
            return true;
        }
        g gVar6 = gVar5.P;
        while (true) {
            if (gVar6 == null) {
                break;
            }
            if (gVar6.h(19)) {
                gVar3 = gVar6;
                break;
            }
            gVar6 = gVar6.P;
        }
        return gVar3 == null;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int i, int i6, Bundle bundle) {
        if (i >= 65536) {
            boolean zPerformAction = this.f7324d.performAction(i, i6, bundle);
            if (zPerformAction && i6 == 128) {
                this.f7328j = null;
            }
            return zPerformAction;
        }
        HashMap map = this.f7326g;
        g gVar = (g) map.get(Integer.valueOf(i));
        if (gVar != null) {
            d dVar = d.INCREASE;
            d dVar2 = d.DECREASE;
            C0994k c0994k = this.f7322b;
            switch (i6) {
                case 16:
                    c0994k.E(i, d.TAP);
                    return true;
                case 32:
                    c0994k.E(i, d.LONG_PRESS);
                    return true;
                case 64:
                    if (this.i == null) {
                        this.f7321a.invalidate();
                    }
                    this.i = gVar;
                    c0994k.E(i, d.DID_GAIN_ACCESSIBILITY_FOCUS);
                    HashMap map2 = new HashMap();
                    map2.put("type", "didGainFocus");
                    map2.put("nodeId", Integer.valueOf(gVar.f7295b));
                    ((w) c0994k.f9530b).K(map2, null);
                    g(i, 32768);
                    if (!g.a(gVar, dVar) && !g.a(gVar, dVar2)) {
                        return true;
                    }
                    g(i, 4);
                    return true;
                case 128:
                    g gVar2 = this.i;
                    if (gVar2 != null && gVar2.f7295b == i) {
                        this.i = null;
                    }
                    Integer num = this.f7328j;
                    if (num != null && num.intValue() == i) {
                        this.f7328j = null;
                    }
                    c0994k.E(i, d.DID_LOSE_ACCESSIBILITY_FOCUS);
                    g(i, 65536);
                    return true;
                case 256:
                    return f(gVar, i, bundle, true);
                case 512:
                    return f(gVar, i, bundle, false);
                case 4096:
                    d dVar3 = d.SCROLL_UP;
                    if (g.a(gVar, dVar3)) {
                        c0994k.E(i, dVar3);
                        return true;
                    }
                    d dVar4 = d.SCROLL_LEFT;
                    if (g.a(gVar, dVar4)) {
                        c0994k.E(i, dVar4);
                        return true;
                    }
                    if (g.a(gVar, dVar)) {
                        gVar.f7309r = gVar.f7311t;
                        gVar.f7310s = gVar.f7312u;
                        g(i, 4);
                        c0994k.E(i, dVar);
                        return true;
                    }
                    break;
                case 8192:
                    d dVar5 = d.SCROLL_DOWN;
                    if (g.a(gVar, dVar5)) {
                        c0994k.E(i, dVar5);
                        return true;
                    }
                    d dVar6 = d.SCROLL_RIGHT;
                    if (g.a(gVar, dVar6)) {
                        c0994k.E(i, dVar6);
                        return true;
                    }
                    if (g.a(gVar, dVar2)) {
                        gVar.f7309r = gVar.f7313v;
                        gVar.f7310s = gVar.f7314w;
                        g(i, 4);
                        c0994k.E(i, dVar2);
                        return true;
                    }
                    break;
                case 16384:
                    c0994k.E(i, d.COPY);
                    return true;
                case 32768:
                    c0994k.E(i, d.PASTE);
                    return true;
                case 65536:
                    c0994k.E(i, d.CUT);
                    return true;
                case 131072:
                    HashMap map3 = new HashMap();
                    if (bundle != null && bundle.containsKey("ACTION_ARGUMENT_SELECTION_START_INT") && bundle.containsKey("ACTION_ARGUMENT_SELECTION_END_INT")) {
                        map3.put("base", Integer.valueOf(bundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT")));
                        map3.put("extent", Integer.valueOf(bundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT")));
                    } else {
                        map3.put("base", Integer.valueOf(gVar.f7300h));
                        map3.put("extent", Integer.valueOf(gVar.f7300h));
                    }
                    c0994k.F(i, d.SET_SELECTION, map3);
                    g gVar3 = (g) map.get(Integer.valueOf(i));
                    gVar3.f7299g = ((Integer) map3.get("base")).intValue();
                    gVar3.f7300h = ((Integer) map3.get("extent")).intValue();
                    return true;
                case 1048576:
                    c0994k.E(i, d.DISMISS);
                    return true;
                case 2097152:
                    String string = (bundle == null || !bundle.containsKey("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE")) ? "" : bundle.getString("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");
                    c0994k.F(i, d.SET_TEXT, string);
                    gVar.f7309r = string;
                    gVar.f7310s = null;
                    return true;
                case R.id.accessibilityActionShowOnScreen:
                    c0994k.E(i, d.SHOW_ON_SCREEN);
                    return true;
                default:
                    e eVar = (e) this.f7327h.get(Integer.valueOf(i6 - 267386881));
                    if (eVar != null) {
                        c0994k.F(i, d.CUSTOM_ACTION, Integer.valueOf(eVar.f7266b));
                        return true;
                    }
                    break;
            }
        }
        return false;
    }
}
