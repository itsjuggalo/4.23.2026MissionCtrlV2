package w4;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONObject;
import p0.C0899k;
import p0.C0901m;
import q2.AbstractC0928g;
import y2.C1425b;
import y2.InterfaceC1426c;

/* JADX INFO: renamed from: w4.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1343j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f11289b;

    public InputStream a() {
        InputStream inputStream = (InputStream) this.f11289b;
        this.f11289b = null;
        return inputStream;
    }

    public C1425b b(JSONObject jSONObject) {
        InterfaceC1426c c0901m;
        int i = jSONObject.getInt("settings_version");
        if (i != 3) {
            Log.e("FirebaseCrashlytics", "Could not determine SettingsJsonTransform for settings version " + i + ". Using default settings values.", null);
            c0901m = new C0899k();
        } else {
            c0901m = new C0901m();
        }
        return c0901m.b((p0.p) this.f11289b, jSONObject);
    }

    public JSONObject c() throws Throwable {
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        FileInputStream fileInputStream2 = null;
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Checking for cached settings...", null);
        }
        try {
            File file = (File) this.f11289b;
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    try {
                        jSONObject = new JSONObject(AbstractC0928g.i(fileInputStream));
                        fileInputStream2 = fileInputStream;
                    } catch (Exception e) {
                        e = e;
                        Log.e("FirebaseCrashlytics", "Failed to fetch cached settings", e);
                        AbstractC0928g.b(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    AbstractC0928g.b(fileInputStream2, "Error while closing settings cache file.");
                    throw th;
                }
            } else {
                if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                    Log.v("FirebaseCrashlytics", "Settings file does not exist.", null);
                }
                jSONObject = null;
            }
            AbstractC0928g.b(fileInputStream2, "Error while closing settings cache file.");
            return jSONObject;
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            AbstractC0928g.b(fileInputStream2, "Error while closing settings cache file.");
            throw th;
        }
    }

    public void d(u4.Z z6, byte[] bArr) {
        E4.b.c();
        try {
            String str = "/" + ((String) ((x4.j) this.f11289b).f11539j.f5096d);
            if (bArr != null) {
                ((x4.j) this.f11289b).f11546q = true;
                str = str + "?" + W1.e.f3348c.c(bArr);
            }
            synchronized (((x4.j) this.f11289b).f11543n.f11535w) {
                x4.i.j(((x4.j) this.f11289b).f11543n, z6, str);
            }
            E4.b.f460a.getClass();
        } catch (Throwable th) {
            try {
                E4.b.f460a.getClass();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public String toString() {
        switch (this.f11288a) {
            case 8:
                StringBuilder sb = new StringBuilder();
                String[] strArr = (String[]) this.f11289b;
                int length = strArr.length / 2;
                for (int i = 0; i < length; i++) {
                    int i6 = i * 2;
                    String str = null;
                    sb.append((i6 < 0 || i6 >= strArr.length) ? null : strArr[i6]);
                    sb.append(": ");
                    int i7 = i6 + 1;
                    if (i7 >= 0 && i7 < strArr.length) {
                        str = strArr[i7];
                    }
                    sb.append(str);
                    sb.append("\n");
                }
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ C1343j(Object obj, int i) {
        this.f11288a = i;
        this.f11289b = obj;
    }

    public C1343j(w2.c cVar) {
        this.f11288a = 6;
        this.f11289b = new File((File) cVar.f10725c, "com.crashlytics.settings.json");
    }

    public C1343j(C1341i0 c1341i0) {
        this.f11288a = 8;
        ArrayList arrayList = c1341i0.f11285b;
        this.f11289b = (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
