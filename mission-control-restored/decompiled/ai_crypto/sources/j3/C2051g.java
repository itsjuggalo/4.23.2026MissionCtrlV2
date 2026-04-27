package j3;

import e3.C1478g;
import h3.AbstractC1695i;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: j3.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2051g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f17391b = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n3.g f17392a;

    /* JADX INFO: renamed from: j3.g$a */
    public class a extends JSONObject {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17393a;

        public a(String str) throws JSONException {
            this.f17393a = str;
            put("userId", str);
        }
    }

    public C2051g(n3.g gVar) {
        this.f17392a = gVar;
    }

    public static Map e(String str) {
        JSONObject jSONObject = new JSONObject(str);
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, p(jSONObject, next));
        }
        return map;
    }

    public static List f(String str) throws JSONException {
        JSONArray jSONArray = new JSONObject(str).getJSONArray("rolloutsState");
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < jSONArray.length(); i7++) {
            String string = jSONArray.getString(i7);
            try {
                arrayList.add(AbstractC2054j.a(string));
            } catch (Exception e7) {
                C1478g.f().l("Failed de-serializing rollouts state. " + string, e7);
            }
        }
        return arrayList;
    }

    public static String h(Map map) {
        return new JSONObject(map).toString();
    }

    public static String l(List list) {
        HashMap map = new HashMap();
        JSONArray jSONArray = new JSONArray();
        for (int i7 = 0; i7 < list.size(); i7++) {
            try {
                jSONArray.put(new JSONObject(AbstractC2054j.f17419a.b(list.get(i7))));
            } catch (JSONException e7) {
                C1478g.f().l("Exception parsing rollout assignment!", e7);
            }
        }
        map.put("rolloutsState", jSONArray);
        return new JSONObject(map).toString();
    }

    public static void m(File file) {
        if (file.exists() && file.delete()) {
            C1478g.f().g("Deleted corrupt file: " + file.getAbsolutePath());
        }
    }

    public static void n(File file, String str) {
        if (file.exists() && file.delete()) {
            C1478g.f().g(String.format("Deleted corrupt file: %s\nReason: %s", file.getAbsolutePath(), str));
        }
    }

    public static String o(String str) {
        return new a(str).toString();
    }

    public static String p(JSONObject jSONObject, String str) {
        if (jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str, null);
    }

    public File a(String str) {
        return this.f17392a.q(str, "internal-keys");
    }

    public File b(String str) {
        return this.f17392a.q(str, "keys");
    }

    public File c(String str) {
        return this.f17392a.q(str, "rollouts-state");
    }

    public File d(String str) {
        return this.f17392a.q(str, "user-data");
    }

    public final String g(String str) {
        return p(new JSONObject(str), "userId");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.Closeable] */
    public Map i(String str, boolean z7) throws Throwable {
        Throwable th;
        FileInputStream fileInputStream;
        Exception e7;
        File fileA = z7 ? a(str) : b(str);
        if (!fileA.exists() || fileA.length() == 0) {
            n(fileA, "The file has a length of zero for session: " + str);
            return Collections.emptyMap();
        }
        try {
            try {
                fileInputStream = new FileInputStream(fileA);
                try {
                    Map mapE = e(AbstractC1695i.B(fileInputStream));
                    AbstractC1695i.f(fileInputStream, "Failed to close user metadata file.");
                    return mapE;
                } catch (Exception e8) {
                    e7 = e8;
                    C1478g.f().l("Error deserializing user metadata.", e7);
                    m(fileA);
                    AbstractC1695i.f(fileInputStream, "Failed to close user metadata file.");
                    return Collections.emptyMap();
                }
            } catch (Throwable th2) {
                th = th2;
                AbstractC1695i.f(, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e9) {
            fileInputStream = null;
            e7 = e9;
        } catch (Throwable th3) {
            ?? r12 = 0;
            th = th3;
            AbstractC1695i.f(r12, "Failed to close user metadata file.");
            throw th;
        }
    }

    public List j(String str) throws Throwable {
        FileInputStream fileInputStream;
        File fileC = c(str);
        if (!fileC.exists() || fileC.length() == 0) {
            n(fileC, "The file has a length of zero for session: " + str);
            return Collections.emptyList();
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(fileC);
            } catch (Exception e7) {
                e = e7;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            List listF = f(AbstractC1695i.B(fileInputStream));
            C1478g.f().b("Loaded rollouts state:\n" + listF + "\nfor session " + str);
            AbstractC1695i.f(fileInputStream, "Failed to close rollouts state file.");
            return listF;
        } catch (Exception e8) {
            e = e8;
            fileInputStream2 = fileInputStream;
            C1478g.f().l("Error deserializing rollouts state.", e);
            m(fileC);
            AbstractC1695i.f(fileInputStream2, "Failed to close rollouts state file.");
            return Collections.emptyList();
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            AbstractC1695i.f(fileInputStream2, "Failed to close rollouts state file.");
            throw th;
        }
    }

    public String k(String str) throws Throwable {
        FileInputStream fileInputStream;
        File fileD = d(str);
        FileInputStream fileInputStream2 = null;
        if (!fileD.exists() || fileD.length() == 0) {
            C1478g.f().b("No userId set for session " + str);
            m(fileD);
            return null;
        }
        try {
            fileInputStream = new FileInputStream(fileD);
            try {
                try {
                    String strG = g(AbstractC1695i.B(fileInputStream));
                    C1478g.f().b("Loaded userId " + strG + " for session " + str);
                    AbstractC1695i.f(fileInputStream, "Failed to close user metadata file.");
                    return strG;
                } catch (Exception e7) {
                    e = e7;
                    C1478g.f().l("Error deserializing user metadata.", e);
                    m(fileD);
                    AbstractC1695i.f(fileInputStream, "Failed to close user metadata file.");
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                AbstractC1695i.f(fileInputStream2, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e8) {
            e = e8;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            AbstractC1695i.f(fileInputStream2, "Failed to close user metadata file.");
            throw th;
        }
    }

    public void q(String str, Map map) throws Throwable {
        r(str, map, false);
    }

    public void r(String str, Map map, boolean z7) throws Throwable {
        String strH;
        BufferedWriter bufferedWriter;
        File fileA = z7 ? a(str) : b(str);
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                strH = h(map);
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileA), f17391b));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e7) {
            e = e7;
        }
        try {
            bufferedWriter.write(strH);
            bufferedWriter.flush();
            AbstractC1695i.f(bufferedWriter, "Failed to close key/value metadata file.");
        } catch (Exception e8) {
            e = e8;
            bufferedWriter2 = bufferedWriter;
            C1478g.f().l("Error serializing key/value metadata.", e);
            m(fileA);
            AbstractC1695i.f(bufferedWriter2, "Failed to close key/value metadata file.");
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            AbstractC1695i.f(bufferedWriter2, "Failed to close key/value metadata file.");
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public void s(String str, List list) throws Throwable {
        Throwable th;
        BufferedWriter bufferedWriter;
        Exception e7;
        File fileC = c(str);
        ?? IsEmpty = list.isEmpty();
        if (IsEmpty != 0) {
            n(fileC, "Rollout state is empty for session: " + str);
            return;
        }
        try {
            try {
                String strL = l(list);
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileC), f17391b));
                try {
                    bufferedWriter.write(strL);
                    bufferedWriter.flush();
                    IsEmpty = bufferedWriter;
                } catch (Exception e8) {
                    e7 = e8;
                    C1478g.f().l("Error serializing rollouts state.", e7);
                    m(fileC);
                    IsEmpty = bufferedWriter;
                }
            } catch (Throwable th2) {
                th = th2;
                AbstractC1695i.f(IsEmpty, "Failed to close rollouts state file.");
                throw th;
            }
        } catch (Exception e9) {
            bufferedWriter = null;
            e7 = e9;
        } catch (Throwable th3) {
            IsEmpty = 0;
            th = th3;
            AbstractC1695i.f(IsEmpty, "Failed to close rollouts state file.");
            throw th;
        }
        AbstractC1695i.f(IsEmpty, "Failed to close rollouts state file.");
    }

    public void t(String str, String str2) throws Throwable {
        String strO;
        BufferedWriter bufferedWriter;
        File fileD = d(str);
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                strO = o(str2);
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileD), f17391b));
            } catch (Exception e7) {
                e = e7;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bufferedWriter.write(strO);
            bufferedWriter.flush();
            AbstractC1695i.f(bufferedWriter, "Failed to close user metadata file.");
        } catch (Exception e8) {
            e = e8;
            bufferedWriter2 = bufferedWriter;
            C1478g.f().l("Error serializing user metadata.", e);
            AbstractC1695i.f(bufferedWriter2, "Failed to close user metadata file.");
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            AbstractC1695i.f(bufferedWriter2, "Failed to close user metadata file.");
            throw th;
        }
    }
}
