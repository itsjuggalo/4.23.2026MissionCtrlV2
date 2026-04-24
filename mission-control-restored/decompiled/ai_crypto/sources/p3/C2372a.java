package p3;

import e3.C1478g;
import h3.AbstractC1695i;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;

/* JADX INFO: renamed from: p3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2372a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f21496a;

    public C2372a(n3.g gVar) {
        this.f21496a = gVar.g("com.crashlytics.settings.json");
    }

    public final File a() {
        return this.f21496a;
    }

    public JSONObject b() throws Throwable {
        Throwable th;
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        C1478g.f().b("Checking for cached settings...");
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File fileA = a();
                if (fileA.exists()) {
                    fileInputStream = new FileInputStream(fileA);
                    try {
                        jSONObject = new JSONObject(AbstractC1695i.B(fileInputStream));
                        fileInputStream2 = fileInputStream;
                    } catch (Exception e7) {
                        e = e7;
                        C1478g.f().e("Failed to fetch cached settings", e);
                        AbstractC1695i.f(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } else {
                    C1478g.f().i("Settings file does not exist.");
                    jSONObject = null;
                }
                AbstractC1695i.f(fileInputStream2, "Error while closing settings cache file.");
                return jSONObject;
            } catch (Throwable th2) {
                th = th2;
                AbstractC1695i.f(null, "Error while closing settings cache file.");
                throw th;
            }
        } catch (Exception e8) {
            e = e8;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            AbstractC1695i.f(null, "Error while closing settings cache file.");
            throw th;
        }
    }

    public void c(long j7, JSONObject jSONObject) throws Throwable {
        FileWriter fileWriter;
        C1478g.f().i("Writing settings to cache file...");
        if (jSONObject != null) {
            FileWriter fileWriter2 = null;
            try {
                try {
                    jSONObject.put("expires_at", j7);
                    fileWriter = new FileWriter(a());
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e7) {
                e = e7;
            }
            try {
                fileWriter.write(jSONObject.toString());
                fileWriter.flush();
                AbstractC1695i.f(fileWriter, "Failed to close settings writer.");
            } catch (Exception e8) {
                e = e8;
                fileWriter2 = fileWriter;
                C1478g.f().e("Failed to cache settings", e);
                AbstractC1695i.f(fileWriter2, "Failed to close settings writer.");
            } catch (Throwable th2) {
                th = th2;
                fileWriter2 = fileWriter;
                AbstractC1695i.f(fileWriter2, "Failed to close settings writer.");
                throw th;
            }
        }
    }
}
