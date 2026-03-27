package Y4;

import Q4.a;
import R4.c;
import U4.s;
import V4.j;
import V4.l;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Q4.a, R4.a, l, s.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f5642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PackageManager f5643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f5644e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map f5645f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map f5646g = new HashMap();

    public a(s sVar) {
        this.f5642c = sVar;
        this.f5643d = sVar.f5111b;
        sVar.b(this);
    }

    @Override // U4.s.b
    public void a(String str, String str2, boolean z7, j.d dVar) {
        if (this.f5644e == null) {
            dVar.b("error", "Plugin not bound to an Activity", null);
            return;
        }
        Map map = this.f5645f;
        if (map == null) {
            dVar.b("error", "Can not process text actions before calling queryTextActions", null);
            return;
        }
        ResolveInfo resolveInfo = (ResolveInfo) map.get(str);
        if (resolveInfo == null) {
            dVar.b("error", "Text processing activity not found", null);
            return;
        }
        int iHashCode = dVar.hashCode();
        this.f5646g.put(Integer.valueOf(iHashCode), dVar);
        Intent intent = new Intent();
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        intent.setClassName(activityInfo.packageName, activityInfo.name);
        intent.setAction("android.intent.action.PROCESS_TEXT");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.PROCESS_TEXT", str2);
        intent.putExtra("android.intent.extra.PROCESS_TEXT_READONLY", z7);
        this.f5644e.g().startActivityForResult(intent, iHashCode);
    }

    @Override // U4.s.b
    public Map b() {
        if (this.f5645f == null) {
            c();
        }
        HashMap map = new HashMap();
        for (String str : this.f5645f.keySet()) {
            map.put(str, ((ResolveInfo) this.f5645f.get(str)).loadLabel(this.f5643d).toString());
        }
        return map;
    }

    public final void c() {
        this.f5645f = new HashMap();
        int i7 = Build.VERSION.SDK_INT;
        Intent type = new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        for (ResolveInfo resolveInfo : i7 >= 33 ? this.f5643d.queryIntentActivities(type, PackageManager.ResolveInfoFlags.of(0L)) : this.f5643d.queryIntentActivities(type, 0)) {
            String str = resolveInfo.activityInfo.name;
            resolveInfo.loadLabel(this.f5643d).toString();
            this.f5645f.put(str, resolveInfo);
        }
    }

    @Override // V4.l
    public boolean onActivityResult(int i7, int i8, Intent intent) {
        if (!this.f5646g.containsKey(Integer.valueOf(i7))) {
            return false;
        }
        ((j.d) this.f5646g.remove(Integer.valueOf(i7))).a(i8 == -1 ? intent.getStringExtra("android.intent.extra.PROCESS_TEXT") : null);
        return true;
    }

    @Override // R4.a
    public void onAttachedToActivity(c cVar) {
        this.f5644e = cVar;
        cVar.f(this);
    }

    @Override // R4.a
    public void onDetachedFromActivity() {
        this.f5644e.d(this);
        this.f5644e = null;
    }

    @Override // R4.a
    public void onDetachedFromActivityForConfigChanges() {
        this.f5644e.d(this);
        this.f5644e = null;
    }

    @Override // R4.a
    public void onReattachedToActivityForConfigChanges(c cVar) {
        this.f5644e = cVar;
        cVar.f(this);
    }

    @Override // Q4.a
    public void onAttachedToEngine(a.b bVar) {
    }

    @Override // Q4.a
    public void onDetachedFromEngine(a.b bVar) {
    }
}
