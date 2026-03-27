package com.google.android.recaptcha.internal;

import X2.AbstractC0769p;
import android.net.TrafficStats;
import android.webkit.URLUtil;
import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import io.flutter.Build;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import kotlin.jvm.internal.r;
import p2.C1698D;

/* JADX INFO: loaded from: classes.dex */
public final class zzeu implements zzet {
    private final String zza;

    public zzeu(String str) {
        this.zza = str;
    }

    private static final void zzb(byte[] bArr) {
        for (zzrc zzrcVar : zzrf.zzk(bArr).zzl()) {
            String str = "INIT_TOTAL";
            List listJ = AbstractC0769p.j("INIT_TOTAL", "EXECUTE_TOTAL");
            switch (zzrcVar.zzY()) {
                case 2:
                    str = "UNKNOWN";
                    break;
                case 3:
                    str = "INIT_NATIVE";
                    break;
                case 4:
                    str = "INIT_NETWORK";
                    break;
                case 5:
                    str = "INIT_JS";
                    break;
                case 6:
                    break;
                case 7:
                    str = "EXECUTE_NATIVE";
                    break;
                case 8:
                    str = "EXECUTE_JS";
                    break;
                case 9:
                    str = "EXECUTE_TOTAL";
                    break;
                case 10:
                    str = "CHALLENGE_ACCOUNT_NATIVE";
                    break;
                case 11:
                    str = "CHALLENGE_ACCOUNT_JS";
                    break;
                case 12:
                    str = "CHALLENGE_ACCOUNT_TOTAL";
                    break;
                case 13:
                    str = "VERIFY_PIN_NATIVE";
                    break;
                case 14:
                    str = "VERIFY_PIN_JS";
                    break;
                case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                    str = "VERIFY_PIN_TOTAL";
                    break;
                case 16:
                    str = "RUN_PROGRAM";
                    break;
                case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    str = "FETCH_ALLOWLIST";
                    break;
                case C1698D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                    str = "JS_LOAD";
                    break;
                case 19:
                    str = "WEB_VIEW_RELOAD_JS";
                    break;
                case FirestoreIndexValueWriter.INDEX_TYPE_TIMESTAMP /* 20 */:
                    str = "INIT_NETWORK_MRI_ACTION";
                    break;
                case Build.API_LEVELS.API_21 /* 21 */:
                    str = "INIT_DOWNLOAD_JS";
                    break;
                case Build.API_LEVELS.API_22 /* 22 */:
                    str = "VALIDATE_INPUT";
                    break;
                case Build.API_LEVELS.API_23 /* 23 */:
                    str = "DOWNLOAD_JS";
                    break;
                case 24:
                    str = "SAVE_CACHE_JS";
                    break;
                case 25:
                    str = "LOAD_CACHE_JS";
                    break;
                case Build.API_LEVELS.API_26 /* 26 */:
                    str = "LOAD_WEBVIEW";
                    break;
                case Build.API_LEVELS.API_27 /* 27 */:
                    str = "COLLECT_SIGNALS";
                    break;
                case Build.API_LEVELS.API_28 /* 28 */:
                    str = "FETCH_TOKEN";
                    break;
                case Build.API_LEVELS.API_29 /* 29 */:
                    str = "POST_EXECUTE";
                    break;
                case 30:
                    str = "SIGNAL_MANAGER_INITIALIZATION";
                    break;
                case Build.API_LEVELS.API_31 /* 31 */:
                    str = "SIGNAL_MANAGER_COLLECT_SIGNALS";
                    break;
                case 32:
                    str = "WEBVIEW_ENGINE_INITIALIATION";
                    break;
                case Build.API_LEVELS.API_33 /* 33 */:
                    str = "WEBVIEW_ENGINE_SIGNAL_COLLECTION";
                    break;
                case Build.API_LEVELS.API_34 /* 34 */:
                    str = "NATIVE_ENGINE_INITIALIZATION";
                    break;
                case Build.API_LEVELS.API_35 /* 35 */:
                    str = "NATIVE_ENGINE_SIGNAL_COLLECTION";
                    break;
                case Build.API_LEVELS.API_36 /* 36 */:
                    str = "NATIVE_SIGNAL_INITIALIZATION";
                    break;
                case FirestoreIndexValueWriter.INDEX_TYPE_REFERENCE /* 37 */:
                    str = "NATIVE_SIGNAL_COLLECTION";
                    break;
                case 38:
                    str = "PIA_WARMUP";
                    break;
                case 39:
                    str = "GMSCORE_ENGINE_INITIALIZATION";
                    break;
                case 40:
                    str = "GMSCORE_ENGINE_SIGNAL_COLLECTION";
                    break;
                case 41:
                    str = "INIT_ATTEMPT";
                    break;
                case 42:
                    str = "WEBVIEW_INITIALIZATION";
                    break;
                default:
                    str = "UNRECOGNIZED";
                    break;
            }
            if (listJ.contains(str) && zzrcVar.zzX()) {
                zzrcVar.zzM();
                zzrcVar.zzN();
                zzrcVar.zzY();
                zzrcVar.zzg().zzk();
                zzrcVar.zzg().zzf();
                zzrcVar.zzZ();
            } else {
                zzrcVar.zzM();
                zzrcVar.zzN();
                zzrcVar.zzY();
                zzrcVar.zzZ();
            }
        }
    }

    @Override // com.google.android.recaptcha.internal.zzet
    public final boolean zza(byte[] bArr) {
        HttpURLConnection httpURLConnection;
        try {
            TrafficStats.setThreadStatsTag((int) Thread.currentThread().getId());
            zzb(bArr);
            if (URLUtil.isHttpUrl(this.zza)) {
                URLConnection uRLConnectionOpenConnection = new URL(this.zza).openConnection();
                r.d(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            } else {
                if (!URLUtil.isHttpsUrl(this.zza)) {
                    throw new MalformedURLException("Recaptcha server url only allows using Http or Https.");
                }
                URLConnection uRLConnectionOpenConnection2 = new URL(this.zza).openConnection();
                r.d(uRLConnectionOpenConnection2, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
                httpURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection2;
            }
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-protobuffer");
            httpURLConnection.connect();
            httpURLConnection.getOutputStream().write(bArr);
            return httpURLConnection.getResponseCode() == 200;
        } catch (Exception e4) {
            e4.getMessage();
            return false;
        }
    }
}
