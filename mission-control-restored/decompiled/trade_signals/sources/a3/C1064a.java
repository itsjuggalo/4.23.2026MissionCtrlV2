package a3;

import S2.AbstractC0903j;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;

/* JADX INFO: renamed from: a3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1064a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f9914a;

    public C1064a(Y2.g gVar) {
        this.f9914a = gVar.g("com.crashlytics.settings.json");
    }

    public final File a() {
        return this.f9914a;
    }

    public JSONObject b() throws Throwable {
        Throwable th;
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        P2.g.f().b("Checking for cached settings...");
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File fileA = a();
                if (fileA.exists()) {
                    fileInputStream = new FileInputStream(fileA);
                    try {
                        jSONObject = new JSONObject(AbstractC0903j.B(fileInputStream));
                        fileInputStream2 = fileInputStream;
                    } catch (Exception e8) {
                        e = e8;
                        P2.g.f().e("Failed to fetch cached settings", e);
                        AbstractC0903j.f(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } else {
                    P2.g.f().i("Settings file does not exist.");
                    jSONObject = null;
                }
                AbstractC0903j.f(fileInputStream2, "Error while closing settings cache file.");
                return jSONObject;
            } catch (Throwable th2) {
                th = th2;
                AbstractC0903j.f(null, "Error while closing settings cache file.");
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            AbstractC0903j.f(null, "Error while closing settings cache file.");
            throw th;
        }
    }

    public void c(long j8, JSONObject jSONObject) throws Throwable {
        FileWriter fileWriter;
        P2.g.f().i("Writing settings to cache file...");
        if (jSONObject != null) {
            FileWriter fileWriter2 = null;
            try {
                try {
                    jSONObject.put("expires_at", j8);
                    fileWriter = new FileWriter(a());
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e8) {
                e = e8;
            }
            try {
                fileWriter.write(jSONObject.toString());
                fileWriter.flush();
                AbstractC0903j.f(fileWriter, "Failed to close settings writer.");
            } catch (Exception e9) {
                e = e9;
                fileWriter2 = fileWriter;
                P2.g.f().e("Failed to cache settings", e);
                AbstractC0903j.f(fileWriter2, "Failed to close settings writer.");
            } catch (Throwable th2) {
                th = th2;
                fileWriter2 = fileWriter;
                AbstractC0903j.f(fileWriter2, "Failed to close settings writer.");
                throw th;
            }
        }
    }
}
