package com.google.android.recaptcha.internal;

import W2.j;
import W2.k;
import g3.m;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class zzfa implements zzey {
    private final j zza;

    public zzfa() {
        int i4 = zzav.zza;
        this.zza = k.b(zzez.zza);
    }

    @Override // com.google.android.recaptcha.internal.zzey
    public final zzsc zza(String str, zzto zztoVar) throws zzbd {
        zzew zzewVarZza = null;
        try {
            try {
                try {
                    zzewVarZza = ((zzex) this.zza.getValue()).zza(str);
                    zzewVarZza.zzc();
                    zzewVarZza.zze(zztoVar.zzd());
                    zzsc zzscVar = (zzsc) zzewVarZza.zza(zzsc.zzi());
                    zzewVarZza.zzd();
                    return zzscVar;
                } catch (zzbd e4) {
                    if (zzewVarZza == null || !r.b(e4.zza(), zzba.zzau)) {
                        throw e4;
                    }
                    try {
                        throw zzbc.zza(zztu.zzg(zzewVarZza.zzb().getErrorStream()).zzi());
                    } catch (Exception e5) {
                        throw new zzbd(zzbb.zzc, zzba.zzG, e5.getMessage());
                    }
                }
            } catch (Exception e6) {
                throw new zzbd(zzbb.zzc, zzba.zzF, e6.getMessage());
            }
        } catch (Throwable th) {
            if (zzewVarZza != null) {
                zzewVarZza.zzd();
            }
            throw th;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzey
    public final String zzb(String str) throws zzbd {
        try {
            try {
                URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
                r.d(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestProperty("Accept", "application/x-protobuffer");
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() != 200) {
                    throw new zzbd(zzbb.zzc, new zzba(httpURLConnection.getResponseCode()), null);
                }
                try {
                    return m.d(r.b("gzip", httpURLConnection.getContentEncoding()) ? new InputStreamReader(new GZIPInputStream(httpURLConnection.getInputStream())) : new InputStreamReader(httpURLConnection.getInputStream()));
                } catch (Exception unused) {
                    throw new zzbd(zzbb.zzc, zzba.zzP, null);
                }
            } catch (Exception unused2) {
                throw new zzbd(zzbb.zzc, zzba.zzO, null);
            }
        } catch (Exception unused3) {
            throw new zzbd(zzbb.zzb, zzba.zzN, null);
        }
    }
}
