package com.google.android.gms.internal.p002firebaseauthapi;

import C1.a;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.zzao;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public final class zzaeh extends AsyncTask<Void, Void, zzaek> {
    private static final a zza = new a("FirebaseAuth", "GetAuthDomainTask");
    private final String zzb;
    private final String zzc;
    private final WeakReference<zzaej> zzd;
    private final Uri.Builder zze;
    private final String zzf;
    private final FirebaseApp zzg;

    public zzaeh(String str, String str2, Intent intent, FirebaseApp firebaseApp, zzaej zzaejVar) {
        this.zzb = AbstractC0940s.e(str);
        this.zzg = (FirebaseApp) AbstractC0940s.k(firebaseApp);
        AbstractC0940s.e(str2);
        AbstractC0940s.k(intent);
        String strE = AbstractC0940s.e(intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY"));
        Uri.Builder builderBuildUpon = Uri.parse(zzaejVar.zza(strE)).buildUpon();
        builderBuildUpon.appendPath("getProjectConfig").appendQueryParameter("key", strE).appendQueryParameter("androidPackageName", str).appendQueryParameter("sha1Cert", (String) AbstractC0940s.k(str2));
        this.zzc = builderBuildUpon.build().toString();
        this.zzd = new WeakReference<>(zzaejVar);
        this.zze = zzaejVar.zza(intent, str, str2);
        this.zzf = intent.getStringExtra("com.google.firebase.auth.KEY_CUSTOM_AUTH_DOMAIN");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzaek doInBackground(Void... voidArr) {
        try {
            URL url = new URL(this.zzc);
            zzaej zzaejVar = this.zzd.get();
            HttpURLConnection httpURLConnectionZza = zzaejVar.zza(url);
            httpURLConnectionZza.addRequestProperty("Content-Type", "application/json; charset=UTF-8");
            httpURLConnectionZza.setConnectTimeout(60000);
            new zzaew(zzaejVar.zza(), this.zzg, zzaeu.zza().zzb()).zza(httpURLConnectionZza);
            int responseCode = httpURLConnectionZza.getResponseCode();
            if (responseCode != 200) {
                String strZza = zza(httpURLConnectionZza);
                zza.c(String.format("Error getting project config. Failed with %s %s", strZza, Integer.valueOf(responseCode)), new Object[0]);
                return zzaek.zzb(strZza);
            }
            zzahi zzahiVar = new zzahi();
            zzahiVar.zza(new String(zza(httpURLConnectionZza.getInputStream(), UserMetadata.MAX_ROLLOUT_ASSIGNMENTS)));
            if (!TextUtils.isEmpty(this.zzf)) {
                return !zzahiVar.zza().contains(this.zzf) ? zzaek.zzb("UNAUTHORIZED_DOMAIN") : zzaek.zza(this.zzf);
            }
            for (String str : zzahiVar.zza()) {
                if (zza(str)) {
                    return zzaek.zza(str);
                }
            }
            return null;
        } catch (zzaci e4) {
            zza.c("ConversionException encountered: " + e4.getMessage(), new Object[0]);
            return null;
        } catch (IOException e5) {
            zza.c("IOException occurred: " + e5.getMessage(), new Object[0]);
            return null;
        } catch (NullPointerException e6) {
            zza.c("Null pointer encountered: " + e6.getMessage(), new Object[0]);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ void onCancelled(zzaek zzaekVar) {
        onPostExecute((zzaek) null);
    }

    private static String zza(HttpURLConnection httpURLConnection) {
        try {
            if (httpURLConnection.getResponseCode() < 400) {
                return null;
            }
            InputStream errorStream = httpURLConnection.getErrorStream();
            if (errorStream == null) {
                return "WEB_INTERNAL_ERROR:Could not retrieve the authDomain for this project but did not receive an error response from the network request. Please try again.";
            }
            return (String) zzaep.zza(new String(zza(errorStream, UserMetadata.MAX_ROLLOUT_ASSIGNMENTS)), String.class);
        } catch (IOException e4) {
            zza.h("Error parsing error message from response body in getErrorMessageFromBody. " + String.valueOf(e4), new Object[0]);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final void onPostExecute(zzaek zzaekVar) {
        String strZza;
        String strZzb;
        Uri.Builder builder;
        zzaej zzaejVar = this.zzd.get();
        if (zzaekVar != null) {
            strZza = zzaekVar.zza();
            strZzb = zzaekVar.zzb();
        } else {
            strZza = null;
            strZzb = null;
        }
        if (zzaejVar == null) {
            zza.c("An error has occurred: the handler reference has returned null.", new Object[0]);
        } else if (!TextUtils.isEmpty(strZza) && (builder = this.zze) != null) {
            builder.authority(strZza);
            zzaejVar.zza(this.zze.build(), this.zzb, FirebaseAuth.getInstance(this.zzg).zzc());
        } else {
            zzaejVar.zza(this.zzb, zzao.zza(strZzb));
        }
    }

    private static boolean zza(String str) {
        try {
            String host = new URI("https://" + str).getHost();
            if (host != null) {
                if (host.endsWith("firebaseapp.com")) {
                    return true;
                }
                if (host.endsWith("web.app")) {
                    return true;
                }
            }
        } catch (URISyntaxException e4) {
            zza.c("Error parsing URL for auth domain check: " + str + ". " + e4.getMessage(), new Object[0]);
        }
        return false;
    }

    private static byte[] zza(InputStream inputStream, int i4) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[UserMetadata.MAX_ROLLOUT_ASSIGNMENTS];
            while (true) {
                int i5 = inputStream.read(bArr);
                if (i5 != -1) {
                    byteArrayOutputStream.write(bArr, 0, i5);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
            }
        } catch (Throwable th) {
            byteArrayOutputStream.close();
            throw th;
        }
    }
}
