package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.AbstractC0940s;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public final class zzafm {
    private static final boolean zza(int i4) {
        return i4 >= 200 && i4 < 300;
    }

    private static void zza(HttpURLConnection httpURLConnection, zzafn<?> zzafnVar, Type type) {
        try {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                InputStream inputStream = zza(responseCode) ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream();
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        } else {
                            sb.append(line);
                        }
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                bufferedReader.close();
                String string = sb.toString();
                if (zza(responseCode)) {
                    zzafnVar.zza((zzaer) zzaep.zza(string, type));
                } else {
                    zzafnVar.zza((String) zzaep.zza(string, String.class));
                }
                httpURLConnection.disconnect();
            } catch (zzaci e4) {
                e = e4;
                zzafnVar.zza(e.getMessage());
                httpURLConnection.disconnect();
            } catch (SocketTimeoutException unused) {
                zzafnVar.zza("TIMEOUT");
                httpURLConnection.disconnect();
            } catch (IOException e5) {
                e = e5;
                zzafnVar.zza(e.getMessage());
                httpURLConnection.disconnect();
            }
        } catch (Throwable th3) {
            httpURLConnection.disconnect();
            throw th3;
        }
    }

    public static void zza(String str, zzafn<?> zzafnVar, Type type, zzaew zzaewVar) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(60000);
            zzaewVar.zza(httpURLConnection);
            zza(httpURLConnection, zzafnVar, type);
        } catch (SocketTimeoutException unused) {
            zzafnVar.zza("TIMEOUT");
        } catch (UnknownHostException unused2) {
            zzafnVar.zza("<<Network Error>>");
        } catch (IOException e4) {
            zzafnVar.zza(e4.getMessage());
        }
    }

    public static void zza(String str, zzaes zzaesVar, zzafn<?> zzafnVar, Type type, zzaew zzaewVar) {
        try {
            AbstractC0940s.k(zzaesVar);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoOutput(true);
            byte[] bytes = zzaesVar.zza().getBytes(Charset.defaultCharset());
            httpURLConnection.setFixedLengthStreamingMode(bytes.length);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setConnectTimeout(60000);
            zzaewVar.zza(httpURLConnection);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream(), bytes.length);
            try {
                bufferedOutputStream.write(bytes, 0, bytes.length);
                bufferedOutputStream.close();
                zza(httpURLConnection, zzafnVar, type);
            } catch (Throwable th) {
                try {
                    bufferedOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (SocketTimeoutException unused) {
            zzafnVar.zza("TIMEOUT");
        } catch (IOException e4) {
            e = e4;
            zzafnVar.zza(e.getMessage());
        } catch (NullPointerException e5) {
            e = e5;
            zzafnVar.zza(e.getMessage());
        } catch (UnknownHostException unused2) {
            zzafnVar.zza("<<Network Error>>");
        } catch (JSONException e6) {
            e = e6;
            zzafnVar.zza(e.getMessage());
        }
    }
}
