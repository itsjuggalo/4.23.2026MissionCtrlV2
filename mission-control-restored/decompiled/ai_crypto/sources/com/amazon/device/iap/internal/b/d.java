package com.amazon.device.iap.internal.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.amazon.a.a.o.f;
import com.amazon.device.iap.model.Receipt;
import com.revenuecat.purchases.common.Constants;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f10349a = "d";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f10352d = "LAST_CLEANING_TIME";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10350b = d.class.getName() + "_PREFS";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10351c = d.class.getName() + "_CLEANER_PREFS";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f10353e = 604800000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final d f10354f = new d();

    private void e() {
        com.amazon.device.iap.internal.util.b.a(f10349a, "enter old receipts cleanup! ");
        final Context contextB = com.amazon.device.iap.internal.d.f().b();
        f.a(contextB, "context");
        a(System.currentTimeMillis());
        new Handler().post(new Runnable() { // from class: com.amazon.device.iap.internal.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.amazon.device.iap.internal.util.b.a(d.f10349a, "perform house keeping! ");
                    SharedPreferences sharedPreferences = contextB.getSharedPreferences(d.f10350b, 0);
                    for (String str : sharedPreferences.getAll().keySet()) {
                        try {
                            if (System.currentTimeMillis() - c.a(sharedPreferences.getString(str, null)).d() > d.f10353e) {
                                com.amazon.device.iap.internal.util.b.a(d.f10349a, "house keeping - try remove Receipt:" + str + " since it's too old");
                                d.this.a(str);
                            }
                        } catch (b unused) {
                            com.amazon.device.iap.internal.util.b.a(d.f10349a, "house keeping - try remove Receipt:" + str + " since it's invalid ");
                            d.this.a(str);
                        }
                    }
                } catch (Throwable th) {
                    com.amazon.device.iap.internal.util.b.a(d.f10349a, "Error in running cleaning job:" + th);
                }
            }
        });
    }

    private long f() {
        Context contextB = com.amazon.device.iap.internal.d.f().b();
        f.a(contextB, "context");
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j7 = contextB.getSharedPreferences(f10351c, 0).getLong(f10352d, 0L);
        if (j7 != 0) {
            return j7;
        }
        a(jCurrentTimeMillis);
        return jCurrentTimeMillis;
    }

    public void a(String str, String str2, String str3, String str4) {
        com.amazon.device.iap.internal.util.b.a(f10349a, "enter saveReceipt for receipt [" + str4 + "]");
        try {
            f.a(str2, "userId");
            f.a(str3, com.amazon.a.a.o.b.f9916E);
            f.a(str4, "receiptString");
            Context contextB = com.amazon.device.iap.internal.d.f().b();
            f.a(contextB, "context");
            c cVar = new c(str2, str4, str, System.currentTimeMillis());
            SharedPreferences.Editor editorEdit = contextB.getSharedPreferences(f10350b, 0).edit();
            editorEdit.putString(str3, cVar.e());
            editorEdit.commit();
        } catch (Throwable th) {
            com.amazon.device.iap.internal.util.b.a(f10349a, "error in saving pending receipt:" + str + "/" + str4 + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + th.getMessage());
        }
        com.amazon.device.iap.internal.util.b.a(f10349a, "leaving saveReceipt for receipt id [" + str3 + "]");
    }

    public Set<Receipt> b(String str) {
        Context contextB = com.amazon.device.iap.internal.d.f().b();
        f.a(contextB, "context");
        String str2 = f10349a;
        com.amazon.device.iap.internal.util.b.a(str2, "enter getLocalReceipts for user[" + str + "]");
        HashSet hashSet = new HashSet();
        if (f.a(str)) {
            com.amazon.device.iap.internal.util.b.b(str2, "empty UserId: " + str);
            throw new RuntimeException("Invalid UserId:" + str);
        }
        Map<String, ?> all = contextB.getSharedPreferences(f10350b, 0).getAll();
        for (String str3 : all.keySet()) {
            String str4 = (String) all.get(str3);
            try {
                c cVarA = c.a(str4);
                hashSet.add(com.amazon.device.iap.internal.util.c.a(new JSONObject(cVarA.c()), str, cVarA.b()));
            } catch (com.amazon.device.iap.internal.a.f unused) {
                a(str3);
                com.amazon.device.iap.internal.util.b.b(f10349a, "failed to verify signature:[" + str4 + "]");
            } catch (JSONException unused2) {
                a(str3);
                com.amazon.device.iap.internal.util.b.b(f10349a, "failed to convert string to JSON object:[" + str4 + "]");
            } catch (Throwable unused3) {
                com.amazon.device.iap.internal.util.b.b(f10349a, "failed to load the receipt from SharedPreference:[" + str4 + "]");
            }
        }
        com.amazon.device.iap.internal.util.b.a(f10349a, "leaving getLocalReceipts for user[" + str + "], " + hashSet.size() + " local receipts found.");
        if (System.currentTimeMillis() - f() > f10353e) {
            e();
        }
        return hashSet;
    }

    public String c(String str) {
        Context contextB = com.amazon.device.iap.internal.d.f().b();
        f.a(contextB, "context");
        if (!f.a(str)) {
            String string = contextB.getSharedPreferences(f10350b, 0).getString(str, null);
            if (string != null) {
                try {
                    return c.a(string).b();
                } catch (b unused) {
                }
            }
            return null;
        }
        com.amazon.device.iap.internal.util.b.b(f10349a, "empty receiptId: " + str);
        throw new RuntimeException("Invalid ReceiptId:" + str);
    }

    public void a(String str) {
        String str2 = f10349a;
        com.amazon.device.iap.internal.util.b.a(str2, "enter removeReceipt for receipt[" + str + "]");
        Context contextB = com.amazon.device.iap.internal.d.f().b();
        f.a(contextB, "context");
        SharedPreferences.Editor editorEdit = contextB.getSharedPreferences(f10350b, 0).edit();
        editorEdit.remove(str);
        editorEdit.commit();
        com.amazon.device.iap.internal.util.b.a(str2, "leave removeReceipt for receipt[" + str + "]");
    }

    private void a(long j7) {
        Context contextB = com.amazon.device.iap.internal.d.f().b();
        f.a(contextB, "context");
        SharedPreferences.Editor editorEdit = contextB.getSharedPreferences(f10351c, 0).edit();
        editorEdit.putLong(f10352d, j7);
        editorEdit.commit();
    }

    public static d a() {
        return f10354f;
    }
}
