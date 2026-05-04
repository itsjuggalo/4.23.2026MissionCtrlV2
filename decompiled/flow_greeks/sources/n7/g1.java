package n7;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.internal.p002firebaseauthapi.zzaao;
import com.google.android.gms.internal.p002firebaseauthapi.zzahv;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.flutter.plugins.firebase.auth.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f16766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SharedPreferences f16768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p5.a f16769d;

    public g1(Context context, String str) {
        com.google.android.gms.common.internal.s.k(context);
        this.f16767b = com.google.android.gms.common.internal.s.e(str);
        this.f16766a = context.getApplicationContext();
        this.f16768c = this.f16766a.getSharedPreferences(String.format("com.google.firebase.auth.api.Store.%s", this.f16767b), 0);
        this.f16769d = new p5.a("StorageHelpers", new String[0]);
    }

    public final zzahv a(m7.a0 a0Var) {
        com.google.android.gms.common.internal.s.k(a0Var);
        String strB = b(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", a0Var.a()));
        if (strB == null) {
            return null;
        }
        try {
            return zzahv.zzb(strB);
        } catch (zzaao unused) {
            this.f16769d.e("Failed to restore token data from persistent storage.", new Object[0]);
            return null;
        }
    }

    public final String b(String str) {
        String string = this.f16768c.getString(str, null);
        if (string != null) {
            return string.startsWith("ENCRYPTED:") ? c1.b(this.f16766a, this.f16767b).a(string.substring(10)) : string;
        }
        return null;
    }

    public final m7.a0 c() {
        String strB = b("com.google.firebase.auth.FIREBASE_USER");
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(strB);
            if (jSONObject.has("type") && "com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(jSONObject.optString("type"))) {
                return d(jSONObject);
            }
        } catch (Exception unused) {
            this.f16769d.e("Failed to restore user data from persistent storage.", new Object[0]);
        }
        return null;
    }

    public final i d(JSONObject jSONObject) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        k kVarA;
        try {
            String string = jSONObject.getString("cachedTokenState");
            String string2 = jSONObject.getString("applicationName");
            boolean z10 = jSONObject.getBoolean("anonymous");
            String string3 = jSONObject.getString(DiagnosticsEntry.VERSION_KEY);
            String str = string3 != null ? string3 : "2";
            JSONArray jSONArray3 = jSONObject.getJSONArray("userInfos");
            int length = jSONArray3.length();
            if (length == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i10 = 0; i10 < length; i10++) {
                arrayList.add(e.R(jSONArray3.getString(i10)));
            }
            i iVar = new i(a7.g.p(string2), arrayList);
            if (!TextUtils.isEmpty(string)) {
                iVar.o0(zzahv.zzb(string));
            }
            if (!z10) {
                iVar.p0();
            }
            iVar.u0(str);
            if (jSONObject.has("userMetadata") && (kVarA = k.a(jSONObject.getJSONObject("userMetadata"))) != null) {
                iVar.w0(kVarA);
            }
            if (jSONObject.has("userMultiFactorInfo") && (jSONArray2 = jSONObject.getJSONArray("userMultiFactorInfo")) != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                    JSONObject jSONObject2 = new JSONObject(jSONArray2.getString(i11));
                    String strOptString = jSONObject2.optString("factorIdKey");
                    arrayList2.add(Constants.SIGN_IN_METHOD_PHONE.equals(strOptString) ? m7.r0.U(jSONObject2) : Objects.equals(strOptString, "totp") ? m7.x0.U(jSONObject2) : null);
                }
                iVar.s0(arrayList2);
            }
            if (jSONObject.has("passkeyInfo") && (jSONArray = jSONObject.getJSONArray("passkeyInfo")) != null) {
                ArrayList arrayList3 = new ArrayList();
                for (int i12 = 0; i12 < jSONArray.length(); i12++) {
                    arrayList3.add(m7.p1.S(new JSONObject(jSONArray.getString(i12))));
                }
                iVar.q0(arrayList3);
            }
            return iVar;
        } catch (zzaao e10) {
            e = e10;
            this.f16769d.j(e);
            return null;
        } catch (ArrayIndexOutOfBoundsException e11) {
            e = e11;
            this.f16769d.j(e);
            return null;
        } catch (IllegalArgumentException e12) {
            e = e12;
            this.f16769d.j(e);
            return null;
        } catch (JSONException e13) {
            e = e13;
            this.f16769d.j(e);
            return null;
        }
    }

    public final void e(String str, String str2) {
        String strD = c1.b(this.f16766a, this.f16767b).d(str2);
        if (strD != null) {
            this.f16768c.edit().putString(str, "ENCRYPTED:" + strD).apply();
        }
    }

    public final void f(m7.a0 a0Var, zzahv zzahvVar) {
        com.google.android.gms.common.internal.s.k(a0Var);
        com.google.android.gms.common.internal.s.k(zzahvVar);
        e(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", a0Var.a()), zzahvVar.zzf());
    }

    public final void g() {
        h("com.google.firebase.auth.FIREBASE_USER");
    }

    public final void h(String str) {
        this.f16768c.edit().remove(str).apply();
    }

    public final void i(m7.a0 a0Var) {
        com.google.android.gms.common.internal.s.k(a0Var);
        h(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", a0Var.a()));
    }

    public final void j(m7.a0 a0Var) {
        com.google.android.gms.common.internal.s.k(a0Var);
        String strK = k(a0Var);
        if (TextUtils.isEmpty(strK)) {
            return;
        }
        e("com.google.firebase.auth.FIREBASE_USER", strK);
    }

    public final String k(m7.a0 a0Var) {
        boolean z10;
        JSONObject jSONObject = new JSONObject();
        if (!(a0Var instanceof i)) {
            return null;
        }
        i iVar = (i) a0Var;
        try {
            jSONObject.put("cachedTokenState", iVar.zze());
            jSONObject.put("applicationName", iVar.m0().q());
            jSONObject.put("type", "com.google.firebase.auth.internal.DefaultFirebaseUser");
            if (iVar.A0() != null) {
                JSONArray jSONArray = new JSONArray();
                List listA0 = iVar.A0();
                int size = listA0.size();
                if (listA0.size() > 30) {
                    this.f16769d.h("Provider user info list size larger than max size, truncating list to %d. Actual list size: %d", 30, Integer.valueOf(listA0.size()));
                    size = 30;
                }
                int i10 = 0;
                boolean z11 = false;
                while (true) {
                    z10 = true;
                    if (i10 >= size) {
                        break;
                    }
                    e eVar = (e) listA0.get(i10);
                    if (eVar.c().equals("firebase")) {
                        z11 = true;
                    }
                    if (i10 == size - 1 && !z11) {
                        break;
                    }
                    jSONArray.put(eVar.S());
                    i10++;
                }
                if (!z11) {
                    for (int i11 = size - 1; i11 < listA0.size() && i11 >= 0; i11++) {
                        e eVar2 = (e) listA0.get(i11);
                        if (eVar2.c().equals("firebase")) {
                            jSONArray.put(eVar2.S());
                            break;
                        }
                        if (i11 == listA0.size() - 1) {
                            jSONArray.put(eVar2.S());
                        }
                    }
                    z10 = z11;
                    if (!z10) {
                        this.f16769d.h("Malformed user object! No Firebase Auth provider id found. Provider user info list size: %d, trimmed size: %d", Integer.valueOf(listA0.size()), Integer.valueOf(size));
                        if (listA0.size() < 5) {
                            StringBuilder sb2 = new StringBuilder("Provider user info list:\n");
                            Iterator it = listA0.iterator();
                            while (it.hasNext()) {
                                sb2.append(String.format("Provider - %s\n", ((e) it.next()).c()));
                            }
                            this.f16769d.h(sb2.toString(), new Object[0]);
                        }
                    }
                }
                jSONObject.put("userInfos", jSONArray);
            }
            jSONObject.put("anonymous", iVar.X());
            jSONObject.put(DiagnosticsEntry.VERSION_KEY, "2");
            if (iVar.T() != null) {
                jSONObject.put("userMetadata", ((k) iVar.T()).b());
            }
            List listB = ((m) iVar.U()).b();
            if (listB != null && !listB.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i12 = 0; i12 < listB.size(); i12++) {
                    jSONArray2.put(((m7.j0) listB.get(i12)).T());
                }
                jSONObject.put("userMultiFactorInfo", jSONArray2);
            }
            List listT0 = iVar.t0();
            if (listT0 != null && !listT0.isEmpty()) {
                JSONArray jSONArray3 = new JSONArray();
                for (int i13 = 0; i13 < listT0.size(); i13++) {
                    jSONArray3.put(m7.p1.T((m7.p1) listT0.get(i13)));
                }
                jSONObject.put("passkeyInfo", jSONArray3);
            }
            return jSONObject.toString();
        } catch (Exception e10) {
            this.f16769d.i("Failed to turn object into JSON", e10, new Object[0]);
            throw new zzaao(e10);
        }
    }
}
