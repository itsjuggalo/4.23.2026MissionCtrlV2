package U4;

import V4.j;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V4.j f5155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f5156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j.c f5157c;

    public class a implements j.c {
        public a() {
        }

        @Override // V4.j.c
        public void onMethodCall(V4.i iVar, j.d dVar) {
            Object obj;
            Bundle bundle;
            if (z.this.f5156b == null) {
            }
            String str = iVar.f5332a;
            obj = iVar.f5333b;
            J4.b.f("TextInputChannel", "Received '" + str + "' message.");
            str.hashCode();
            switch (str) {
                case "TextInput.setPlatformViewClient":
                    try {
                        JSONObject jSONObject = (JSONObject) obj;
                        z.this.f5156b.c(jSONObject.getInt("platformViewId"), jSONObject.optBoolean("usesVirtualDisplay", false));
                        dVar.a(null);
                        break;
                    } catch (JSONException e7) {
                        dVar.b("error", e7.getMessage(), null);
                        return;
                    }
                    break;
                case "TextInput.setEditingState":
                    try {
                        z.this.f5156b.j(e.a((JSONObject) obj));
                        dVar.a(null);
                        break;
                    } catch (JSONException e8) {
                        dVar.b("error", e8.getMessage(), null);
                        return;
                    }
                    break;
                case "TextInput.setClient":
                    try {
                        JSONArray jSONArray = (JSONArray) obj;
                        z.this.f5156b.h(jSONArray.getInt(0), b.a(jSONArray.getJSONObject(1)));
                        dVar.a(null);
                        break;
                    } catch (NoSuchFieldException | JSONException e9) {
                        dVar.b("error", e9.getMessage(), null);
                        return;
                    }
                    break;
                case "TextInput.hide":
                    z.this.f5156b.i();
                    dVar.a(null);
                    break;
                case "TextInput.show":
                    z.this.f5156b.a();
                    dVar.a(null);
                    break;
                case "TextInput.sendAppPrivateCommand":
                    try {
                        JSONObject jSONObject2 = (JSONObject) obj;
                        String string = jSONObject2.getString("action");
                        String string2 = jSONObject2.getString("data");
                        if (string2 == null || string2.isEmpty()) {
                            bundle = null;
                        } else {
                            bundle = new Bundle();
                            bundle.putString("data", string2);
                        }
                        z.this.f5156b.b(string, bundle);
                        dVar.a(null);
                        break;
                    } catch (JSONException e10) {
                        dVar.b("error", e10.getMessage(), null);
                        return;
                    }
                    break;
                case "TextInput.setEditableSizeAndTransform":
                    try {
                        JSONObject jSONObject3 = (JSONObject) obj;
                        double d7 = jSONObject3.getDouble("width");
                        double d8 = jSONObject3.getDouble("height");
                        JSONArray jSONArray2 = jSONObject3.getJSONArray("transform");
                        double[] dArr = new double[16];
                        for (int i7 = 0; i7 < 16; i7++) {
                            dArr[i7] = jSONArray2.getDouble(i7);
                        }
                        z.this.f5156b.d(d7, d8, dArr);
                        dVar.a(null);
                        break;
                    } catch (JSONException e11) {
                        dVar.b("error", e11.getMessage(), null);
                        return;
                    }
                    break;
                case "TextInput.finishAutofillContext":
                    z.this.f5156b.f(((Boolean) obj).booleanValue());
                    dVar.a(null);
                    break;
                case "TextInput.clearClient":
                    z.this.f5156b.g();
                    dVar.a(null);
                    break;
                case "TextInput.requestAutofill":
                    z.this.f5156b.e();
                    dVar.a(null);
                    break;
                default:
                    dVar.c();
                    break;
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f5159a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f5160b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f5161c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f5162d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f5163e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final d f5164f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final c f5165g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Integer f5166h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f5167i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final a f5168j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final String[] f5169k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final b[] f5170l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Locale[] f5171m;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f5172a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String[] f5173b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final e f5174c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final String f5175d;

            public a(String str, String[] strArr, String str2, e eVar) {
                this.f5172a = str;
                this.f5173b = strArr;
                this.f5175d = str2;
                this.f5174c = eVar;
            }

            public static a a(JSONObject jSONObject) throws JSONException {
                String string = jSONObject.getString("uniqueIdentifier");
                JSONArray jSONArray = jSONObject.getJSONArray("hints");
                String string2 = jSONObject.isNull("hintText") ? null : jSONObject.getString("hintText");
                JSONObject jSONObject2 = jSONObject.getJSONObject("editingValue");
                String[] strArr = new String[jSONArray.length()];
                for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                    strArr[i7] = b(jSONArray.getString(i7));
                }
                return new a(string, strArr, string2, e.a(jSONObject2));
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Removed duplicated region for block: B:7:0x002d  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public static java.lang.String b(java.lang.String r17) {
                /*
                    Method dump skipped, instruction units count: 802
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: U4.z.b.a.b(java.lang.String):java.lang.String");
            }
        }

        public b(boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, d dVar, c cVar, Integer num, String str, a aVar, String[] strArr, b[] bVarArr, Locale[] localeArr) {
            this.f5159a = z7;
            this.f5160b = z8;
            this.f5161c = z9;
            this.f5162d = z10;
            this.f5163e = z11;
            this.f5164f = dVar;
            this.f5165g = cVar;
            this.f5166h = num;
            this.f5167i = str;
            this.f5168j = aVar;
            this.f5169k = strArr;
            this.f5170l = bVarArr;
            this.f5171m = localeArr;
        }

        public static b a(JSONObject jSONObject) throws JSONException {
            b[] bVarArr;
            Locale[] localeArr;
            String string = jSONObject.getString("inputAction");
            if (string == null) {
                throw new JSONException("Configuration JSON missing 'inputAction' property.");
            }
            if (jSONObject.isNull("fields")) {
                bVarArr = null;
            } else {
                JSONArray jSONArray = jSONObject.getJSONArray("fields");
                int length = jSONArray.length();
                b[] bVarArr2 = new b[length];
                for (int i7 = 0; i7 < length; i7++) {
                    bVarArr2[i7] = a(jSONArray.getJSONObject(i7));
                }
                bVarArr = bVarArr2;
            }
            Integer numB = b(string);
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray2 = jSONObject.isNull("contentCommitMimeTypes") ? null : jSONObject.getJSONArray("contentCommitMimeTypes");
            if (jSONArray2 != null) {
                for (int i8 = 0; i8 < jSONArray2.length(); i8++) {
                    arrayList.add(jSONArray2.optString(i8));
                }
            }
            if (jSONObject.isNull("hintLocales")) {
                localeArr = null;
            } else {
                JSONArray jSONArray3 = jSONObject.getJSONArray("hintLocales");
                Locale[] localeArr2 = new Locale[jSONArray3.length()];
                for (int i9 = 0; i9 < jSONArray3.length(); i9++) {
                    localeArr2[i9] = Locale.forLanguageTag(jSONArray3.optString(i9));
                }
                localeArr = localeArr2;
            }
            return new b(jSONObject.optBoolean("obscureText"), jSONObject.optBoolean("autocorrect", true), jSONObject.optBoolean("enableSuggestions"), jSONObject.optBoolean("enableIMEPersonalizedLearning"), jSONObject.optBoolean("enableDeltaModel"), d.b(jSONObject.getString("textCapitalization")), c.a(jSONObject.getJSONObject("inputType")), numB, jSONObject.isNull("actionLabel") ? null : jSONObject.getString("actionLabel"), jSONObject.isNull("autofill") ? null : a.a(jSONObject.getJSONObject("autofill")), (String[]) arrayList.toArray(new String[arrayList.size()]), bVarArr, localeArr);
        }

        public static Integer b(String str) {
            str.hashCode();
            switch (str) {
                case "TextInputAction.unspecified":
                    return 0;
                case "TextInputAction.done":
                    return 6;
                case "TextInputAction.next":
                    return 5;
                case "TextInputAction.none":
                    return 1;
                case "TextInputAction.send":
                    return 4;
                case "TextInputAction.search":
                    return 3;
                case "TextInputAction.go":
                    return 2;
                case "TextInputAction.newline":
                    return 1;
                case "TextInputAction.previous":
                    return 7;
                default:
                    return 0;
            }
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f5176a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f5177b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f5178c;

        public c(g gVar, boolean z7, boolean z8) {
            this.f5176a = gVar;
            this.f5177b = z7;
            this.f5178c = z8;
        }

        public static c a(JSONObject jSONObject) {
            return new c(g.b(jSONObject.getString("name")), jSONObject.optBoolean("signed", false), jSONObject.optBoolean("decimal", false));
        }
    }

    public enum d {
        CHARACTERS("TextCapitalization.characters"),
        WORDS("TextCapitalization.words"),
        SENTENCES("TextCapitalization.sentences"),
        NONE("TextCapitalization.none");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5184a;

        d(String str) {
            this.f5184a = str;
        }

        public static d b(String str) throws NoSuchFieldException {
            for (d dVar : values()) {
                if (dVar.f5184a.equals(str)) {
                    return dVar;
                }
            }
            throw new NoSuchFieldException("No such TextCapitalization: " + str);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5185a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f5186b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f5187c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f5188d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f5189e;

        public e(String str, int i7, int i8, int i9, int i10) {
            if (!(i7 == -1 && i8 == -1) && (i7 < 0 || i8 < 0)) {
                throw new IndexOutOfBoundsException("invalid selection: (" + String.valueOf(i7) + ", " + String.valueOf(i8) + ")");
            }
            if (!(i9 == -1 && i10 == -1) && (i9 < 0 || i9 > i10)) {
                throw new IndexOutOfBoundsException("invalid composing range: (" + String.valueOf(i9) + ", " + String.valueOf(i10) + ")");
            }
            if (i10 > str.length()) {
                throw new IndexOutOfBoundsException("invalid composing start: " + String.valueOf(i9));
            }
            if (i7 > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection start: " + String.valueOf(i7));
            }
            if (i8 > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection end: " + String.valueOf(i8));
            }
            this.f5185a = str;
            this.f5186b = i7;
            this.f5187c = i8;
            this.f5188d = i9;
            this.f5189e = i10;
        }

        public static e a(JSONObject jSONObject) {
            return new e(jSONObject.getString("text"), jSONObject.getInt("selectionBase"), jSONObject.getInt("selectionExtent"), jSONObject.getInt("composingBase"), jSONObject.getInt("composingExtent"));
        }

        public boolean b() {
            int i7 = this.f5188d;
            return i7 >= 0 && this.f5189e > i7;
        }

        public boolean c() {
            return this.f5186b >= 0;
        }
    }

    public interface f {
        void a();

        void b(String str, Bundle bundle);

        void c(int i7, boolean z7);

        void d(double d7, double d8, double[] dArr);

        void e();

        void f(boolean z7);

        void g();

        void h(int i7, b bVar);

        void i();

        void j(e eVar);
    }

    public enum g {
        TEXT("TextInputType.text"),
        DATETIME("TextInputType.datetime"),
        NAME("TextInputType.name"),
        POSTAL_ADDRESS("TextInputType.address"),
        NUMBER("TextInputType.number"),
        PHONE("TextInputType.phone"),
        MULTILINE("TextInputType.multiline"),
        EMAIL_ADDRESS("TextInputType.emailAddress"),
        URL("TextInputType.url"),
        VISIBLE_PASSWORD("TextInputType.visiblePassword"),
        NONE("TextInputType.none"),
        WEB_SEARCH("TextInputType.webSearch"),
        TWITTER("TextInputType.twitter");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5204a;

        g(String str) {
            this.f5204a = str;
        }

        public static g b(String str) throws NoSuchFieldException {
            for (g gVar : values()) {
                if (gVar.f5204a.equals(str)) {
                    return gVar;
                }
            }
            throw new NoSuchFieldException("No such TextInputType: " + str);
        }
    }

    public z(M4.a aVar) {
        a aVar2 = new a();
        this.f5157c = aVar2;
        V4.j jVar = new V4.j(aVar, "flutter/textinput", V4.f.f5331a);
        this.f5155a = jVar;
        jVar.e(aVar2);
    }

    public static HashMap c(ArrayList arrayList) {
        HashMap map = new HashMap();
        JSONArray jSONArray = new JSONArray();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.put(((io.flutter.plugin.editing.s) it.next()).b());
        }
        map.put("deltas", jSONArray);
        return map;
    }

    public static HashMap d(String str, int i7, int i8, int i9, int i10) {
        HashMap map = new HashMap();
        map.put("text", str);
        map.put("selectionBase", Integer.valueOf(i7));
        map.put("selectionExtent", Integer.valueOf(i8));
        map.put("composingBase", Integer.valueOf(i9));
        map.put("composingExtent", Integer.valueOf(i10));
        return map;
    }

    public void b(int i7, Map map) {
        J4.b.f("TextInputChannel", "Sending 'commitContent' message.");
        this.f5155a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i7), "TextInputAction.commitContent", map));
    }

    public void e(int i7) {
        J4.b.f("TextInputChannel", "Sending 'done' message.");
        this.f5155a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i7), "TextInputAction.done"));
    }

    public void f(int i7) {
        J4.b.f("TextInputChannel", "Sending 'go' message.");
        this.f5155a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i7), "TextInputAction.go"));
    }

    public void g(int i7) {
        J4.b.f("TextInputChannel", "Sending 'newline' message.");
        this.f5155a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i7), "TextInputAction.newline"));
    }

    public void h(int i7) {
        J4.b.f("TextInputChannel", "Sending 'next' message.");
        this.f5155a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i7), "TextInputAction.next"));
    }

    public void i(int i7, String str, Bundle bundle) {
        HashMap map = new HashMap();
        map.put("action", str);
        if (bundle != null) {
            HashMap map2 = new HashMap();
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj instanceof byte[]) {
                    map2.put(str2, bundle.getByteArray(str2));
                } else if (obj instanceof Byte) {
                    map2.put(str2, Byte.valueOf(bundle.getByte(str2)));
                } else if (obj instanceof char[]) {
                    map2.put(str2, bundle.getCharArray(str2));
                } else if (obj instanceof Character) {
                    map2.put(str2, Character.valueOf(bundle.getChar(str2)));
                } else if (obj instanceof CharSequence[]) {
                    map2.put(str2, bundle.getCharSequenceArray(str2));
                } else if (obj instanceof CharSequence) {
                    map2.put(str2, bundle.getCharSequence(str2));
                } else if (obj instanceof float[]) {
                    map2.put(str2, bundle.getFloatArray(str2));
                } else if (obj instanceof Float) {
                    map2.put(str2, Float.valueOf(bundle.getFloat(str2)));
                }
            }
            map.put("data", map2);
        }
        this.f5155a.c("TextInputClient.performPrivateCommand", Arrays.asList(Integer.valueOf(i7), map));
    }

    public void j(int i7) {
        J4.b.f("TextInputChannel", "Sending 'previous' message.");
        this.f5155a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i7), "TextInputAction.previous"));
    }

    public void k() {
        this.f5155a.c("TextInputClient.requestExistingInputState", null);
    }

    public void l(int i7) {
        J4.b.f("TextInputChannel", "Sending 'search' message.");
        this.f5155a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i7), "TextInputAction.search"));
    }

    public void m(int i7) {
        J4.b.f("TextInputChannel", "Sending 'send' message.");
        this.f5155a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i7), "TextInputAction.send"));
    }

    public void n(f fVar) {
        this.f5156b = fVar;
    }

    public void o(int i7) {
        J4.b.f("TextInputChannel", "Sending 'unspecified' message.");
        this.f5155a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i7), "TextInputAction.unspecified"));
    }

    public void p(int i7, String str, int i8, int i9, int i10, int i11) {
        J4.b.f("TextInputChannel", "Sending message to update editing state: \nText: " + str + "\nSelection start: " + i8 + "\nSelection end: " + i9 + "\nComposing start: " + i10 + "\nComposing end: " + i11);
        this.f5155a.c("TextInputClient.updateEditingState", Arrays.asList(Integer.valueOf(i7), d(str, i8, i9, i10, i11)));
    }

    public void q(int i7, ArrayList arrayList) {
        J4.b.f("TextInputChannel", "Sending message to update editing state with deltas: \nNumber of deltas: " + arrayList.size());
        this.f5155a.c("TextInputClient.updateEditingStateWithDeltas", Arrays.asList(Integer.valueOf(i7), c(arrayList)));
    }

    public void r(int i7, HashMap map) {
        J4.b.f("TextInputChannel", "Sending message to update editing state for " + String.valueOf(map.size()) + " field(s).");
        HashMap map2 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            e eVar = (e) entry.getValue();
            map2.put((String) entry.getKey(), d(eVar.f5185a, eVar.f5186b, eVar.f5187c, -1, -1));
        }
        this.f5155a.c("TextInputClient.updateEditingStateWithTag", Arrays.asList(Integer.valueOf(i7), map2));
    }
}
