package U2;

import S2.AbstractC0903j;
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

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f8113b = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Y2.g f8114a;

    public class a extends JSONObject {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f8115a;

        public a(String str) throws JSONException {
            this.f8115a = str;
            put("userId", str);
        }
    }

    public g(Y2.g gVar) {
        this.f8114a = gVar;
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
        for (int i8 = 0; i8 < jSONArray.length(); i8++) {
            String string = jSONArray.getString(i8);
            try {
                arrayList.add(j.a(string));
            } catch (Exception e8) {
                P2.g.f().l("Failed de-serializing rollouts state. " + string, e8);
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
        for (int i8 = 0; i8 < list.size(); i8++) {
            try {
                jSONArray.put(new JSONObject(j.f8141a.b(list.get(i8))));
            } catch (JSONException e8) {
                P2.g.f().l("Exception parsing rollout assignment!", e8);
            }
        }
        map.put("rolloutsState", jSONArray);
        return new JSONObject(map).toString();
    }

    public static void m(File file) {
        if (file.exists() && file.delete()) {
            P2.g.f().g("Deleted corrupt file: " + file.getAbsolutePath());
        }
    }

    public static void n(File file, String str) {
        if (file.exists() && file.delete()) {
            P2.g.f().g(String.format("Deleted corrupt file: %s\nReason: %s", file.getAbsolutePath(), str));
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
        return this.f8114a.q(str, "internal-keys");
    }

    public File b(String str) {
        return this.f8114a.q(str, "keys");
    }

    public File c(String str) {
        return this.f8114a.q(str, "rollouts-state");
    }

    public File d(String str) {
        return this.f8114a.q(str, "user-data");
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
        Exception e8;
        File fileA = z7 ? a(str) : b(str);
        if (!fileA.exists() || fileA.length() == 0) {
            n(fileA, "The file has a length of zero for session: " + str);
            return Collections.emptyMap();
        }
        try {
            try {
                fileInputStream = new FileInputStream(fileA);
                try {
                    Map mapE = e(AbstractC0903j.B(fileInputStream));
                    AbstractC0903j.f(fileInputStream, "Failed to close user metadata file.");
                    return mapE;
                } catch (Exception e9) {
                    e8 = e9;
                    P2.g.f().l("Error deserializing user metadata.", e8);
                    m(fileA);
                    AbstractC0903j.f(fileInputStream, "Failed to close user metadata file.");
                    return Collections.emptyMap();
                }
            } catch (Throwable th2) {
                th = th2;
                AbstractC0903j.f(, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e10) {
            fileInputStream = null;
            e8 = e10;
        } catch (Throwable th3) {
            ?? r12 = 0;
            th = th3;
            AbstractC0903j.f(r12, "Failed to close user metadata file.");
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
            } catch (Exception e8) {
                e = e8;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            List listF = f(AbstractC0903j.B(fileInputStream));
            P2.g.f().b("Loaded rollouts state:\n" + listF + "\nfor session " + str);
            AbstractC0903j.f(fileInputStream, "Failed to close rollouts state file.");
            return listF;
        } catch (Exception e9) {
            e = e9;
            fileInputStream2 = fileInputStream;
            P2.g.f().l("Error deserializing rollouts state.", e);
            m(fileC);
            AbstractC0903j.f(fileInputStream2, "Failed to close rollouts state file.");
            return Collections.emptyList();
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            AbstractC0903j.f(fileInputStream2, "Failed to close rollouts state file.");
            throw th;
        }
    }

    public String k(String str) throws Throwable {
        FileInputStream fileInputStream;
        File fileD = d(str);
        FileInputStream fileInputStream2 = null;
        if (!fileD.exists() || fileD.length() == 0) {
            P2.g.f().b("No userId set for session " + str);
            m(fileD);
            return null;
        }
        try {
            fileInputStream = new FileInputStream(fileD);
            try {
                try {
                    String strG = g(AbstractC0903j.B(fileInputStream));
                    P2.g.f().b("Loaded userId " + strG + " for session " + str);
                    AbstractC0903j.f(fileInputStream, "Failed to close user metadata file.");
                    return strG;
                } catch (Exception e8) {
                    e = e8;
                    P2.g.f().l("Error deserializing user metadata.", e);
                    m(fileD);
                    AbstractC0903j.f(fileInputStream, "Failed to close user metadata file.");
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                AbstractC0903j.f(fileInputStream2, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            AbstractC0903j.f(fileInputStream2, "Failed to close user metadata file.");
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
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileA), f8113b));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e8) {
            e = e8;
        }
        try {
            bufferedWriter.write(strH);
            bufferedWriter.flush();
            AbstractC0903j.f(bufferedWriter, "Failed to close key/value metadata file.");
        } catch (Exception e9) {
            e = e9;
            bufferedWriter2 = bufferedWriter;
            P2.g.f().l("Error serializing key/value metadata.", e);
            m(fileA);
            AbstractC0903j.f(bufferedWriter2, "Failed to close key/value metadata file.");
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            AbstractC0903j.f(bufferedWriter2, "Failed to close key/value metadata file.");
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
        Exception e8;
        File fileC = c(str);
        ?? IsEmpty = list.isEmpty();
        if (IsEmpty != 0) {
            n(fileC, "Rollout state is empty for session: " + str);
            return;
        }
        try {
            try {
                String strL = l(list);
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileC), f8113b));
                try {
                    bufferedWriter.write(strL);
                    bufferedWriter.flush();
                    IsEmpty = bufferedWriter;
                } catch (Exception e9) {
                    e8 = e9;
                    P2.g.f().l("Error serializing rollouts state.", e8);
                    m(fileC);
                    IsEmpty = bufferedWriter;
                }
            } catch (Throwable th2) {
                th = th2;
                AbstractC0903j.f(IsEmpty, "Failed to close rollouts state file.");
                throw th;
            }
        } catch (Exception e10) {
            bufferedWriter = null;
            e8 = e10;
        } catch (Throwable th3) {
            IsEmpty = 0;
            th = th3;
            AbstractC0903j.f(IsEmpty, "Failed to close rollouts state file.");
            throw th;
        }
        AbstractC0903j.f(IsEmpty, "Failed to close rollouts state file.");
    }

    public void t(String str, String str2) throws Throwable {
        String strO;
        BufferedWriter bufferedWriter;
        File fileD = d(str);
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                strO = o(str2);
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileD), f8113b));
            } catch (Exception e8) {
                e = e8;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bufferedWriter.write(strO);
            bufferedWriter.flush();
            AbstractC0903j.f(bufferedWriter, "Failed to close user metadata file.");
        } catch (Exception e9) {
            e = e9;
            bufferedWriter2 = bufferedWriter;
            P2.g.f().l("Error serializing user metadata.", e);
            AbstractC0903j.f(bufferedWriter2, "Failed to close user metadata file.");
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            AbstractC0903j.f(bufferedWriter2, "Failed to close user metadata file.");
            throw th;
        }
    }
}
