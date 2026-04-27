package l5;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import l5.q;

/* JADX INFO: renamed from: l5.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2181c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f18400a;

    /* JADX INFO: renamed from: l5.c$a */
    public enum a {
        IMAGE,
        VIDEO
    }

    public C2181c(Context context) {
        this.f18400a = context;
    }

    public void a() {
        this.f18400a.getSharedPreferences("flutter_image_picker_shared_preference", 0).edit().clear().apply();
    }

    public Map b() {
        Set<String> stringSet;
        HashMap map = new HashMap();
        boolean z7 = false;
        SharedPreferences sharedPreferences = this.f18400a.getSharedPreferences("flutter_image_picker_shared_preference", 0);
        boolean z8 = true;
        if (sharedPreferences.contains("flutter_image_picker_image_path") && (stringSet = sharedPreferences.getStringSet("flutter_image_picker_image_path", null)) != null) {
            map.put("pathList", new ArrayList(stringSet));
            z7 = true;
        }
        if (sharedPreferences.contains("flutter_image_picker_error_code")) {
            q.a.C0304a c0304a = new q.a.C0304a();
            c0304a.b(sharedPreferences.getString("flutter_image_picker_error_code", ""));
            if (sharedPreferences.contains("flutter_image_picker_error_message")) {
                c0304a.c(sharedPreferences.getString("flutter_image_picker_error_message", ""));
            }
            map.put("error", c0304a.a());
        } else {
            z8 = z7;
        }
        if (z8) {
            if (sharedPreferences.contains("flutter_image_picker_type")) {
                map.put("type", sharedPreferences.getString("flutter_image_picker_type", "").equals("video") ? q.c.VIDEO : q.c.IMAGE);
            }
            if (sharedPreferences.contains("flutter_image_picker_max_width")) {
                map.put("maxWidth", Double.valueOf(Double.longBitsToDouble(sharedPreferences.getLong("flutter_image_picker_max_width", 0L))));
            }
            if (sharedPreferences.contains("flutter_image_picker_max_height")) {
                map.put("maxHeight", Double.valueOf(Double.longBitsToDouble(sharedPreferences.getLong("flutter_image_picker_max_height", 0L))));
            }
            map.put("imageQuality", Integer.valueOf(sharedPreferences.getInt("flutter_image_picker_image_quality", 100)));
        }
        return map;
    }

    public String c() {
        return this.f18400a.getSharedPreferences("flutter_image_picker_shared_preference", 0).getString("flutter_image_picker_pending_image_uri", "");
    }

    public void d(q.g gVar) {
        SharedPreferences.Editor editorEdit = this.f18400a.getSharedPreferences("flutter_image_picker_shared_preference", 0).edit();
        if (gVar.c() != null) {
            editorEdit.putLong("flutter_image_picker_max_width", Double.doubleToRawLongBits(gVar.c().doubleValue()));
        }
        if (gVar.b() != null) {
            editorEdit.putLong("flutter_image_picker_max_height", Double.doubleToRawLongBits(gVar.b().doubleValue()));
        }
        editorEdit.putInt("flutter_image_picker_image_quality", gVar.d().intValue());
        editorEdit.apply();
    }

    public void e(Uri uri) {
        this.f18400a.getSharedPreferences("flutter_image_picker_shared_preference", 0).edit().putString("flutter_image_picker_pending_image_uri", uri.getPath()).apply();
    }

    public void f(ArrayList arrayList, String str, String str2) {
        SharedPreferences.Editor editorEdit = this.f18400a.getSharedPreferences("flutter_image_picker_shared_preference", 0).edit();
        if (arrayList != null) {
            editorEdit.putStringSet("flutter_image_picker_image_path", new HashSet(arrayList));
        }
        if (str != null) {
            editorEdit.putString("flutter_image_picker_error_code", str);
        }
        if (str2 != null) {
            editorEdit.putString("flutter_image_picker_error_message", str2);
        }
        editorEdit.apply();
    }

    public void g(a aVar) {
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 0) {
            h("image");
        } else {
            if (iOrdinal != 1) {
                return;
            }
            h("video");
        }
    }

    public final void h(String str) {
        this.f18400a.getSharedPreferences("flutter_image_picker_shared_preference", 0).edit().putString("flutter_image_picker_type", str).apply();
    }
}
