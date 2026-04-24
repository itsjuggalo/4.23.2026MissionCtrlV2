package U4;

import V4.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V4.j f4994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f4995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j.c f4996c;

    public class a implements j.c {
        public a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:56:0x00d9  */
        @Override // V4.j.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onMethodCall(V4.i r6, V4.j.d r7) {
            /*
                Method dump skipped, instruction units count: 754
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: U4.o.a.onMethodCall(V4.i, V4.j$d):void");
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f4999b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f5000c;

        static {
            int[] iArr = new int[k.values().length];
            f5000c = iArr;
            try {
                iArr[k.LEAN_BACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5000c[k.IMMERSIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5000c[k.IMMERSIVE_STICKY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5000c[k.EDGE_TO_EDGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[l.values().length];
            f4999b = iArr2;
            try {
                iArr2[l.TOP_OVERLAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4999b[l.BOTTOM_OVERLAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[f.values().length];
            f4998a = iArr3;
            try {
                iArr3[f.PORTRAIT_UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4998a[f.PORTRAIT_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4998a[f.LANDSCAPE_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4998a[f.LANDSCAPE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f5002b;

        public c(int i7, String str) {
            this.f5001a = i7;
            this.f5002b = str;
        }
    }

    public enum d {
        LIGHT("Brightness.light"),
        DARK("Brightness.dark");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5006a;

        d(String str) {
            this.f5006a = str;
        }

        public static d b(String str) throws NoSuchFieldException {
            for (d dVar : values()) {
                if (dVar.f5006a.equals(str)) {
                    return dVar;
                }
            }
            throw new NoSuchFieldException("No such Brightness: " + str);
        }
    }

    public enum e {
        PLAIN_TEXT("text/plain");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5009a;

        e(String str) {
            this.f5009a = str;
        }

        public static e b(String str) throws NoSuchFieldException {
            for (e eVar : values()) {
                if (eVar.f5009a.equals(str)) {
                    return eVar;
                }
            }
            throw new NoSuchFieldException("No such ClipboardContentFormat: " + str);
        }
    }

    public enum f {
        PORTRAIT_UP("DeviceOrientation.portraitUp"),
        PORTRAIT_DOWN("DeviceOrientation.portraitDown"),
        LANDSCAPE_LEFT("DeviceOrientation.landscapeLeft"),
        LANDSCAPE_RIGHT("DeviceOrientation.landscapeRight");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5015a;

        f(String str) {
            this.f5015a = str;
        }

        public static f b(String str) throws NoSuchFieldException {
            for (f fVar : values()) {
                if (fVar.f5015a.equals(str)) {
                    return fVar;
                }
            }
            throw new NoSuchFieldException("No such DeviceOrientation: " + str);
        }
    }

    public enum g {
        STANDARD(null),
        LIGHT_IMPACT("HapticFeedbackType.lightImpact"),
        MEDIUM_IMPACT("HapticFeedbackType.mediumImpact"),
        HEAVY_IMPACT("HapticFeedbackType.heavyImpact"),
        SELECTION_CLICK("HapticFeedbackType.selectionClick");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5022a;

        g(String str) {
            this.f5022a = str;
        }

        public static g b(String str) throws NoSuchFieldException {
            for (g gVar : values()) {
                String str2 = gVar.f5022a;
                if ((str2 == null && str == null) || (str2 != null && str2.equals(str))) {
                    return gVar;
                }
            }
            throw new NoSuchFieldException("No such HapticFeedbackType: " + str);
        }
    }

    public interface h {
        void b();

        void f(boolean z7);

        CharSequence g(e eVar);

        void h(List list);

        void i(String str);

        void j(String str);

        void k(g gVar);

        void l(j jVar);

        void m();

        void n(k kVar);

        void o();

        void p(c cVar);

        void q(i iVar);

        void r(int i7);

        boolean s();
    }

    public enum i {
        CLICK("SystemSoundType.click"),
        TICK("SystemSoundType.tick"),
        ALERT("SystemSoundType.alert");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5027a;

        i(String str) {
            this.f5027a = str;
        }

        public static i b(String str) throws NoSuchFieldException {
            for (i iVar : values()) {
                if (iVar.f5027a.equals(str)) {
                    return iVar;
                }
            }
            throw new NoSuchFieldException("No such SoundType: " + str);
        }
    }

    public static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Integer f5028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f5029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Boolean f5030c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f5031d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final d f5032e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Integer f5033f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Boolean f5034g;

        public j(Integer num, d dVar, Boolean bool, Integer num2, d dVar2, Integer num3, Boolean bool2) {
            this.f5028a = num;
            this.f5029b = dVar;
            this.f5030c = bool;
            this.f5031d = num2;
            this.f5032e = dVar2;
            this.f5033f = num3;
            this.f5034g = bool2;
        }
    }

    public enum k {
        LEAN_BACK("SystemUiMode.leanBack"),
        IMMERSIVE("SystemUiMode.immersive"),
        IMMERSIVE_STICKY("SystemUiMode.immersiveSticky"),
        EDGE_TO_EDGE("SystemUiMode.edgeToEdge");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5040a;

        k(String str) {
            this.f5040a = str;
        }

        public static k b(String str) throws NoSuchFieldException {
            for (k kVar : values()) {
                if (kVar.f5040a.equals(str)) {
                    return kVar;
                }
            }
            throw new NoSuchFieldException("No such SystemUiMode: " + str);
        }
    }

    public enum l {
        TOP_OVERLAYS("SystemUiOverlay.top"),
        BOTTOM_OVERLAYS("SystemUiOverlay.bottom");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5044a;

        l(String str) {
            this.f5044a = str;
        }

        public static l b(String str) throws NoSuchFieldException {
            for (l lVar : values()) {
                if (lVar.f5044a.equals(str)) {
                    return lVar;
                }
            }
            throw new NoSuchFieldException("No such SystemUiOverlay: " + str);
        }
    }

    public o(M4.a aVar) {
        a aVar2 = new a();
        this.f4996c = aVar2;
        V4.j jVar = new V4.j(aVar, "flutter/platform", V4.f.f5331a);
        this.f4994a = jVar;
        jVar.e(aVar2);
    }

    public final c g(JSONObject jSONObject) throws JSONException {
        int i7 = jSONObject.getInt("primaryColor");
        if (i7 != 0) {
            i7 |= -16777216;
        }
        return new c(i7, jSONObject.getString("label"));
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0053 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h(org.json.JSONArray r10) {
        /*
            r9 = this;
            r0 = 0
            r1 = r0
            r2 = r1
            r3 = r2
        L4:
            int r4 = r10.length()
            r5 = 4
            r6 = 2
            r7 = 1
            if (r1 >= r4) goto L38
            java.lang.String r4 = r10.getString(r1)
            U4.o$f r4 = U4.o.f.b(r4)
            int[] r8 = U4.o.b.f4998a
            int r4 = r4.ordinal()
            r4 = r8[r4]
            if (r4 == r7) goto L30
            if (r4 == r6) goto L2d
            r6 = 3
            if (r4 == r6) goto L2a
            if (r4 == r5) goto L27
            goto L32
        L27:
            r2 = r2 | 8
            goto L32
        L2a:
            r2 = r2 | 2
            goto L32
        L2d:
            r2 = r2 | 4
            goto L32
        L30:
            r2 = r2 | 1
        L32:
            if (r3 != 0) goto L35
            r3 = r2
        L35:
            int r1 = r1 + 1
            goto L4
        L38:
            if (r2 == 0) goto L57
            r10 = 9
            r1 = 8
            switch(r2) {
                case 2: goto L56;
                case 3: goto L4d;
                case 4: goto L4c;
                case 5: goto L4a;
                case 6: goto L4d;
                case 7: goto L4d;
                case 8: goto L49;
                case 9: goto L4d;
                case 10: goto L46;
                case 11: goto L45;
                case 12: goto L4d;
                case 13: goto L4d;
                case 14: goto L4d;
                case 15: goto L42;
                default: goto L41;
            }
        L41:
            goto L53
        L42:
            r10 = 13
            return r10
        L45:
            return r6
        L46:
            r10 = 11
            return r10
        L49:
            return r1
        L4a:
            r10 = 12
        L4c:
            return r10
        L4d:
            if (r3 == r6) goto L56
            if (r3 == r5) goto L55
            if (r3 == r1) goto L54
        L53:
            return r7
        L54:
            return r1
        L55:
            return r10
        L56:
            return r0
        L57:
            r10 = -1
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: U4.o.h(org.json.JSONArray):int");
    }

    public final j i(JSONObject jSONObject) {
        return new j(!jSONObject.isNull("statusBarColor") ? Integer.valueOf(jSONObject.getInt("statusBarColor")) : null, !jSONObject.isNull("statusBarIconBrightness") ? d.b(jSONObject.getString("statusBarIconBrightness")) : null, !jSONObject.isNull("systemStatusBarContrastEnforced") ? Boolean.valueOf(jSONObject.getBoolean("systemStatusBarContrastEnforced")) : null, !jSONObject.isNull("systemNavigationBarColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarColor")) : null, !jSONObject.isNull("systemNavigationBarIconBrightness") ? d.b(jSONObject.getString("systemNavigationBarIconBrightness")) : null, !jSONObject.isNull("systemNavigationBarDividerColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarDividerColor")) : null, jSONObject.isNull("systemNavigationBarContrastEnforced") ? null : Boolean.valueOf(jSONObject.getBoolean("systemNavigationBarContrastEnforced")));
    }

    public final k j(String str) {
        int i7 = b.f5000c[k.b(str).ordinal()];
        return i7 != 1 ? i7 != 2 ? i7 != 3 ? i7 != 4 ? k.EDGE_TO_EDGE : k.EDGE_TO_EDGE : k.IMMERSIVE_STICKY : k.IMMERSIVE : k.LEAN_BACK;
    }

    public final List k(JSONArray jSONArray) throws NoSuchFieldException {
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < jSONArray.length(); i7++) {
            int i8 = b.f4999b[l.b(jSONArray.getString(i7)).ordinal()];
            if (i8 == 1) {
                arrayList.add(l.TOP_OVERLAYS);
            } else if (i8 == 2) {
                arrayList.add(l.BOTTOM_OVERLAYS);
            }
        }
        return arrayList;
    }

    public void l(h hVar) {
        this.f4995b = hVar;
    }

    public void m(boolean z7) {
        J4.b.f("PlatformChannel", "Sending 'systemUIChange' message.");
        this.f4994a.c("SystemChrome.systemUIChange", Arrays.asList(Boolean.valueOf(z7)));
    }
}
