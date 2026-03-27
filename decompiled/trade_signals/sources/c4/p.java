package c4;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f13467c = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13469b;

    public p(Context context, String str) {
        this.f13468a = context;
        this.f13469b = str;
    }

    public static synchronized p c(Context context, String str) {
        Map map;
        try {
            map = f13467c;
            if (!map.containsKey(str)) {
                map.put(str, new p(context, str));
            }
        } catch (Throwable th) {
            throw th;
        }
        return (p) map.get(str);
    }

    public synchronized Void a() {
        this.f13468a.deleteFile(this.f13469b);
        return null;
    }

    public String b() {
        return this.f13469b;
    }

    public synchronized com.google.firebase.remoteconfig.internal.b d() {
        FileInputStream fileInputStreamOpenFileInput;
        Throwable th;
        try {
            fileInputStreamOpenFileInput = this.f13468a.openFileInput(this.f13469b);
        } catch (FileNotFoundException | JSONException unused) {
            fileInputStreamOpenFileInput = null;
        } catch (Throwable th2) {
            fileInputStreamOpenFileInput = null;
            th = th2;
        }
        try {
            int iAvailable = fileInputStreamOpenFileInput.available();
            byte[] bArr = new byte[iAvailable];
            fileInputStreamOpenFileInput.read(bArr, 0, iAvailable);
            com.google.firebase.remoteconfig.internal.b bVarB = com.google.firebase.remoteconfig.internal.b.b(new JSONObject(new String(bArr, "UTF-8")));
            fileInputStreamOpenFileInput.close();
            return bVarB;
        } catch (FileNotFoundException | JSONException unused2) {
            if (fileInputStreamOpenFileInput != null) {
                fileInputStreamOpenFileInput.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStreamOpenFileInput != null) {
                fileInputStreamOpenFileInput.close();
            }
            throw th;
        }
    }

    public synchronized Void e(com.google.firebase.remoteconfig.internal.b bVar) {
        FileOutputStream fileOutputStreamOpenFileOutput = this.f13468a.openFileOutput(this.f13469b, 0);
        try {
            fileOutputStreamOpenFileOutput.write(bVar.toString().getBytes("UTF-8"));
        } finally {
            fileOutputStreamOpenFileOutput.close();
        }
        return null;
    }
}
