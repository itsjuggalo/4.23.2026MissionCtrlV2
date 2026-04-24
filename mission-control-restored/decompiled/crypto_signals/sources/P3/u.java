package P3;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Parcelable;
import android.view.KeyEvent;
import b0.C0377f;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import com.google.android.gms.internal.p002firebaseauthapi.zzajb;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import i2.AbstractC0669o;
import i2.I;
import j2.C0742s;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import s1.C0987d;
import s1.C0994k;
import s2.C1007j;
import s2.InterfaceC1008k;

/* JADX INFO: loaded from: classes.dex */
public class u implements androidx.lifecycle.C, InterfaceC1008k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static u f2599d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f2602c;

    public static String c(JSONObject jSONObject, String str) {
        if (!jSONObject.has(str) || jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.getString(str);
    }

    public static u k(Object obj) {
        return new u(obj, false, 4);
    }

    public static u l(Serializable serializable) {
        return new u(serializable, true, 4);
    }

    public static I n(Intent intent) {
        Parcelable.Creator<zzajb> creator = zzajb.CREATOR;
        byte[] byteArrayExtra = intent.getByteArrayExtra("com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST");
        return I.p(((zzajb) (byteArrayExtra == null ? null : y5.a.m(byteArrayExtra, creator))).zzc(true));
    }

    public static void p(Context context) {
        u uVar = f2599d;
        uVar.f2601b = false;
        if (((BroadcastReceiver) uVar.f2602c) != null) {
            g0.c cVarA = g0.c.a(context);
            BroadcastReceiver broadcastReceiver = (BroadcastReceiver) f2599d.f2602c;
            synchronized (cVarA.f6553b) {
                try {
                    ArrayList arrayList = (ArrayList) cVarA.f6553b.remove(broadcastReceiver);
                    if (arrayList != null) {
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            g0.b bVar = (g0.b) arrayList.get(size);
                            bVar.f6549d = true;
                            for (int i = 0; i < bVar.f6546a.countActions(); i++) {
                                String action = bVar.f6546a.getAction(i);
                                ArrayList arrayList2 = (ArrayList) cVarA.f6554c.get(action);
                                if (arrayList2 != null) {
                                    for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                                        g0.b bVar2 = (g0.b) arrayList2.get(size2);
                                        if (bVar2.f6547b == broadcastReceiver) {
                                            bVar2.f6549d = true;
                                            arrayList2.remove(size2);
                                        }
                                    }
                                    if (arrayList2.size() <= 0) {
                                        cVarA.f6554c.remove(action);
                                    }
                                }
                            }
                        }
                    }
                } finally {
                }
            }
        }
        f2599d.f2602c = null;
    }

    @Override // s2.InterfaceC1008k
    public void a(C1007j c1007j, int i) {
        boolean z6 = this.f2601b;
        StringBuilder sb = (StringBuilder) this.f2602c;
        if (z6) {
            this.f2601b = false;
        } else {
            sb.append(", ");
        }
        sb.append(i);
    }

    public com.google.firebase.storage.j b() {
        com.google.firebase.storage.j jVar = new com.google.firebase.storage.j();
        jVar.f5568a = null;
        jVar.f5569b = null;
        jVar.f5570c = null;
        jVar.f5571d = k("");
        jVar.e = null;
        jVar.f5572f = null;
        jVar.f5573g = null;
        jVar.i = null;
        jVar.f5575j = k("");
        jVar.f5576k = k("");
        jVar.f5577l = k("");
        jVar.f5578m = k("");
        jVar.f5579n = k(Collections.EMPTY_MAP);
        com.google.firebase.storage.j jVar2 = (com.google.firebase.storage.j) this.f2602c;
        com.google.android.gms.common.internal.I.g(jVar2);
        jVar.f5568a = jVar2.f5568a;
        jVar.f5569b = jVar2.f5569b;
        jVar.f5571d = jVar2.f5571d;
        jVar.f5575j = jVar2.f5575j;
        jVar.f5576k = jVar2.f5576k;
        jVar.f5577l = jVar2.f5577l;
        jVar.f5578m = jVar2.f5578m;
        jVar.f5579n = jVar2.f5579n;
        if (this.f2601b) {
            jVar.i = jVar2.i;
            jVar.f5574h = jVar2.f5574h;
            jVar.f5573g = jVar2.f5573g;
            jVar.f5572f = jVar2.f5572f;
            jVar.e = jVar2.e;
            jVar.f5570c = jVar2.f5570c;
        }
        return jVar;
    }

    public void d() {
        this.f2601b = false;
    }

    public void e(boolean z6) {
        if (this.f2601b) {
            throw new IllegalStateException("The onKeyEventHandledCallback should be called exactly once.");
        }
        this.f2601b = true;
        v vVar = (v) this.f2602c;
        int i = vVar.f2604b - 1;
        vVar.f2604b = i;
        boolean z7 = z6 | vVar.f2603a;
        vVar.f2603a = z7;
        if (i != 0 || z7) {
            return;
        }
        ((C0994k) vVar.f2606d).R((KeyEvent) vVar.f2605c);
    }

    public void f(char c6) {
        A.k kVar = (A.k) this.f2602c;
        kVar.a(kVar.f29b, 1);
        char[] cArr = (char[]) kVar.f30c;
        int i = kVar.f29b;
        kVar.f29b = i + 1;
        cArr[i] = c6;
    }

    public void g(String str, String str2) {
        com.google.firebase.storage.j jVar = (com.google.firebase.storage.j) this.f2602c;
        if (!jVar.f5579n.f2601b) {
            jVar.f5579n = l(new HashMap());
        }
        ((Map) jVar.f5579n.f2602c).put(str, str2);
    }

    public void i(IllegalStateException illegalStateException) {
        if (this.f2601b) {
            return;
        }
        this.f2601b = true;
        u uVar = ((C0377f) this.f2602c).e;
        synchronized (uVar) {
            if (!uVar.f2601b) {
                uVar.f2601b = true;
                uVar.f2602c = illegalStateException;
                uVar.notifyAll();
            }
        }
    }

    @Override // androidx.lifecycle.C
    public void m(Object obj) {
        this.f2601b = true;
        Y3.j jVar = (Y3.j) this.f2602c;
        jVar.getClass();
        SignInHubActivity signInHubActivity = (SignInHubActivity) jVar.f3665b;
        signInHubActivity.setResult(signInHubActivity.f5052E, signInHubActivity.f5053F);
        signInHubActivity.finish();
    }

    public void o(Activity activity, BroadcastReceiver broadcastReceiver) {
        this.f2602c = broadcastReceiver;
        g0.c cVarA = g0.c.a(activity);
        IntentFilter intentFilter = new IntentFilter("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        synchronized (cVarA.f6553b) {
            try {
                g0.b bVar = new g0.b(intentFilter, broadcastReceiver);
                ArrayList arrayList = (ArrayList) cVarA.f6553b.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    cVarA.f6553b.put(broadcastReceiver, arrayList);
                }
                arrayList.add(bVar);
                for (int i = 0; i < intentFilter.countActions(); i++) {
                    String action = intentFilter.getAction(i);
                    ArrayList arrayList2 = (ArrayList) cVarA.f6554c.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                        cVarA.f6554c.put(action, arrayList2);
                    }
                    arrayList2.add(bVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean q(Activity activity, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, AbstractC0669o abstractC0669o) {
        if (this.f2601b) {
            return false;
        }
        o(activity, new C0742s(this, activity, taskCompletionSource, firebaseAuth, abstractC0669o));
        this.f2601b = true;
        return true;
    }

    public String toString() {
        switch (this.f2600a) {
            case 5:
                return ((Y3.j) this.f2602c).toString();
            case 6:
                String str = (String) this.f2602c;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
                sb.append("{");
                sb.append(str);
                sb.append("}");
                sb.append(this.f2601b);
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ u(Object obj, int i) {
        this.f2600a = i;
        this.f2602c = obj;
        this.f2601b = true;
    }

    public /* synthetic */ u(Object obj, boolean z6, int i) {
        this.f2600a = i;
        this.f2601b = z6;
        this.f2602c = obj;
    }

    public u(C0377f c0377f) {
        this.f2600a = 1;
        this.f2602c = c0377f;
    }

    public u(v vVar) {
        this.f2600a = 0;
        this.f2602c = vVar;
        this.f2601b = false;
    }

    public u(C0987d c0987d, Y3.j jVar) {
        this.f2600a = 5;
        this.f2601b = false;
        this.f2602c = jVar;
    }

    public u(JSONObject jSONObject, com.google.firebase.storage.m mVar) throws JSONException {
        this.f2600a = 3;
        com.google.firebase.storage.j jVar = new com.google.firebase.storage.j();
        this.f2602c = jVar;
        jVar.f5570c = jSONObject.optString("generation");
        jVar.f5568a = jSONObject.optString("name");
        jVar.f5569b = jSONObject.optString("bucket");
        jVar.e = jSONObject.optString("metageneration");
        jVar.f5572f = jSONObject.optString("timeCreated");
        jVar.f5573g = jSONObject.optString("updated");
        jVar.f5574h = jSONObject.optLong("size");
        jVar.i = jSONObject.optString("md5Hash");
        if (jSONObject.has("metadata") && !jSONObject.isNull("metadata")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("metadata");
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                g(next, jSONObject2.getString(next));
            }
        }
        String strC = c(jSONObject, "contentType");
        if (strC != null) {
            ((com.google.firebase.storage.j) this.f2602c).f5571d = l(strC);
        }
        String strC2 = c(jSONObject, "cacheControl");
        if (strC2 != null) {
            ((com.google.firebase.storage.j) this.f2602c).f5575j = l(strC2);
        }
        String strC3 = c(jSONObject, "contentDisposition");
        if (strC3 != null) {
            ((com.google.firebase.storage.j) this.f2602c).f5576k = l(strC3);
        }
        String strC4 = c(jSONObject, "contentEncoding");
        if (strC4 != null) {
            ((com.google.firebase.storage.j) this.f2602c).f5577l = l(strC4);
        }
        String strC5 = c(jSONObject, "contentLanguage");
        if (strC5 != null) {
            ((com.google.firebase.storage.j) this.f2602c).f5578m = l(strC5);
        }
        this.f2601b = true;
        ((com.google.firebase.storage.j) this.f2602c).getClass();
    }

    public void h() {
    }

    public void j() {
    }
}
