package com.google.firebase.auth.internal;

import C1.a;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.p002firebaseauthapi.zzaag;
import com.google.android.gms.internal.p002firebaseauthapi.zzahn;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorGenerator;
import com.google.firebase.auth.TotpMultiFactorInfo;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzcb {
    private Context zza;
    private String zzb;
    private SharedPreferences zzc;
    private a zzd;

    public zzcb(Context context, String str) {
        AbstractC0940s.k(context);
        this.zzb = AbstractC0940s.e(str);
        this.zza = context.getApplicationContext();
        this.zzc = this.zza.getSharedPreferences(String.format("com.google.firebase.auth.api.Store.%s", this.zzb), 0);
        this.zzd = new a("StorageHelpers", new String[0]);
    }

    private final void zzb(String str) {
        this.zzc.edit().remove(str).apply();
    }

    private final String zzd(FirebaseUser firebaseUser) {
        boolean z4;
        JSONObject jSONObject = new JSONObject();
        if (!zzaf.class.isAssignableFrom(firebaseUser.getClass())) {
            return null;
        }
        zzaf zzafVar = (zzaf) firebaseUser;
        try {
            jSONObject.put("cachedTokenState", zzafVar.zze());
            jSONObject.put("applicationName", zzafVar.zza().getName());
            jSONObject.put("type", "com.google.firebase.auth.internal.DefaultFirebaseUser");
            if (zzafVar.zzj() != null) {
                JSONArray jSONArray = new JSONArray();
                List<zzab> listZzj = zzafVar.zzj();
                int size = listZzj.size();
                if (listZzj.size() > 30) {
                    this.zzd.h("Provider user info list size larger than max size, truncating list to %d. Actual list size: %d", 30, Integer.valueOf(listZzj.size()));
                    size = 30;
                }
                int i4 = 0;
                boolean z5 = false;
                while (true) {
                    z4 = true;
                    if (i4 >= size) {
                        break;
                    }
                    zzab zzabVar = listZzj.get(i4);
                    if (zzabVar.getProviderId().equals(FirebaseAuthProvider.PROVIDER_ID)) {
                        z5 = true;
                    }
                    if (i4 == size - 1 && !z5) {
                        break;
                    }
                    jSONArray.put(zzabVar.zzb());
                    i4++;
                }
                if (!z5) {
                    for (int i5 = size - 1; i5 < listZzj.size() && i5 >= 0; i5++) {
                        zzab zzabVar2 = listZzj.get(i5);
                        if (zzabVar2.getProviderId().equals(FirebaseAuthProvider.PROVIDER_ID)) {
                            jSONArray.put(zzabVar2.zzb());
                            break;
                        }
                        if (i5 == listZzj.size() - 1) {
                            jSONArray.put(zzabVar2.zzb());
                        }
                    }
                    z4 = z5;
                    if (!z4) {
                        this.zzd.h("Malformed user object! No Firebase Auth provider id found. Provider user info list size: %d, trimmed size: %d", Integer.valueOf(listZzj.size()), Integer.valueOf(size));
                        if (listZzj.size() < 5) {
                            StringBuilder sb = new StringBuilder("Provider user info list:\n");
                            Iterator<zzab> it = listZzj.iterator();
                            while (it.hasNext()) {
                                sb.append(String.format("Provider - %s\n", it.next().getProviderId()));
                            }
                            this.zzd.h(sb.toString(), new Object[0]);
                        }
                    }
                }
                jSONObject.put("userInfos", jSONArray);
            }
            jSONObject.put("anonymous", zzafVar.isAnonymous());
            jSONObject.put(DiagnosticsEntry.VERSION_KEY, "2");
            if (zzafVar.getMetadata() != null) {
                jSONObject.put("userMetadata", ((zzah) zzafVar.getMetadata()).zza());
            }
            List<MultiFactorInfo> enrolledFactors = ((zzaj) zzafVar.getMultiFactor()).getEnrolledFactors();
            if (enrolledFactors != null && !enrolledFactors.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i6 = 0; i6 < enrolledFactors.size(); i6++) {
                    jSONArray2.put(enrolledFactors.get(i6).toJson());
                }
                jSONObject.put("userMultiFactorInfo", jSONArray2);
            }
            List<com.google.firebase.auth.zzal> listZzf = zzafVar.zzf();
            if (listZzf != null && !listZzf.isEmpty()) {
                JSONArray jSONArray3 = new JSONArray();
                for (int i7 = 0; i7 < listZzf.size(); i7++) {
                    jSONArray3.put(com.google.firebase.auth.zzal.zza(listZzf.get(i7)));
                }
                jSONObject.put("passkeyInfo", jSONArray3);
            }
            return jSONObject.toString();
        } catch (Exception e4) {
            this.zzd.i("Failed to turn object into JSON", e4, new Object[0]);
            throw new zzaag(e4);
        }
    }

    public final FirebaseUser zza() {
        String strZza = zza("com.google.firebase.auth.FIREBASE_USER");
        if (TextUtils.isEmpty(strZza)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(strZza);
            if (jSONObject.has("type") && "com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(jSONObject.optString("type"))) {
                return zza(jSONObject);
            }
        } catch (Exception unused) {
            this.zzd.e("Failed to restore user data from persistent storage.", new Object[0]);
        }
        return null;
    }

    public final void zzc(FirebaseUser firebaseUser) {
        AbstractC0940s.k(firebaseUser);
        String strZzd = zzd(firebaseUser);
        if (TextUtils.isEmpty(strZzd)) {
            return;
        }
        zza("com.google.firebase.auth.FIREBASE_USER", strZzd);
    }

    public final void zzb() {
        zzb("com.google.firebase.auth.FIREBASE_USER");
    }

    public final void zzb(FirebaseUser firebaseUser) {
        AbstractC0940s.k(firebaseUser);
        zzb(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.getUid()));
    }

    public final zzahn zza(FirebaseUser firebaseUser) {
        AbstractC0940s.k(firebaseUser);
        String strZza = zza(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.getUid()));
        if (strZza == null) {
            return null;
        }
        try {
            return zzahn.zzb(strZza);
        } catch (zzaag unused) {
            this.zzd.e("Failed to restore token data from persistent storage.", new Object[0]);
            return null;
        }
    }

    private final zzaf zza(JSONObject jSONObject) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        MultiFactorInfo multiFactorInfoZza;
        zzah zzahVarZza;
        try {
            String string = jSONObject.getString("cachedTokenState");
            String string2 = jSONObject.getString("applicationName");
            boolean z4 = jSONObject.getBoolean("anonymous");
            String string3 = jSONObject.getString(DiagnosticsEntry.VERSION_KEY);
            String str = string3 != null ? string3 : "2";
            JSONArray jSONArray3 = jSONObject.getJSONArray("userInfos");
            int length = jSONArray3.length();
            if (length == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i4 = 0; i4 < length; i4++) {
                arrayList.add(zzab.zza(jSONArray3.getString(i4)));
            }
            zzaf zzafVar = new zzaf(FirebaseApp.getInstance(string2), arrayList);
            if (!TextUtils.isEmpty(string)) {
                zzafVar.zza(zzahn.zzb(string));
            }
            if (!z4) {
                zzafVar.zzb();
            }
            zzafVar.zza(str);
            if (jSONObject.has("userMetadata") && (zzahVarZza = zzah.zza(jSONObject.getJSONObject("userMetadata"))) != null) {
                zzafVar.zza(zzahVarZza);
            }
            if (jSONObject.has("userMultiFactorInfo") && (jSONArray2 = jSONObject.getJSONArray("userMultiFactorInfo")) != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i5 = 0; i5 < jSONArray2.length(); i5++) {
                    JSONObject jSONObject2 = new JSONObject(jSONArray2.getString(i5));
                    String strOptString = jSONObject2.optString(MultiFactorInfo.FACTOR_ID_KEY);
                    if ("phone".equals(strOptString)) {
                        multiFactorInfoZza = PhoneMultiFactorInfo.zza(jSONObject2);
                    } else {
                        multiFactorInfoZza = Objects.equals(strOptString, TotpMultiFactorGenerator.FACTOR_ID) ? TotpMultiFactorInfo.zza(jSONObject2) : null;
                    }
                    arrayList2.add(multiFactorInfoZza);
                }
                zzafVar.zzc(arrayList2);
            }
            if (jSONObject.has("passkeyInfo") && (jSONArray = jSONObject.getJSONArray("passkeyInfo")) != null) {
                ArrayList arrayList3 = new ArrayList();
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    arrayList3.add(com.google.firebase.auth.zzal.zza(new JSONObject(jSONArray.getString(i6))));
                }
                zzafVar.zzb(arrayList3);
            }
            return zzafVar;
        } catch (zzaag e4) {
            e = e4;
            this.zzd.j(e);
            return null;
        } catch (ArrayIndexOutOfBoundsException e5) {
            e = e5;
            this.zzd.j(e);
            return null;
        } catch (IllegalArgumentException e6) {
            e = e6;
            this.zzd.j(e);
            return null;
        } catch (JSONException e7) {
            e = e7;
            this.zzd.j(e);
            return null;
        }
    }

    private final String zza(String str) {
        String string = this.zzc.getString(str, null);
        if (string != null) {
            return string.startsWith("ENCRYPTED:") ? zzby.zza(this.zza, this.zzb).zza(string.substring(10)) : string;
        }
        return null;
    }

    private final void zza(String str, String str2) {
        String strZzb = zzby.zza(this.zza, this.zzb).zzb(str2);
        if (strZzb != null) {
            this.zzc.edit().putString(str, "ENCRYPTED:" + strZzb).apply();
        }
    }

    public final void zza(FirebaseUser firebaseUser, zzahn zzahnVar) {
        AbstractC0940s.k(firebaseUser);
        AbstractC0940s.k(zzahnVar);
        zza(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.getUid()), zzahnVar.zzf());
    }
}
