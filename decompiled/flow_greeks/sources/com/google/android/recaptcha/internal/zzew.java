package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import kotlin.jvm.internal.t;
import nd.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzew {
    private final HttpURLConnection zza;

    public zzew(HttpURLConnection httpURLConnection) {
        this.zza = httpURLConnection;
    }

    private final InputStream zzf() throws zzbd {
        try {
            return this.zza.getInputStream();
        } catch (UnknownServiceException e10) {
            throw new zzbd(zzbb.zzc, zzba.zzaf, e10.getMessage());
        } catch (IOException e11) {
            throw new zzbd(zzbb.zzc, zzba.zzae, e11.getMessage());
        } catch (Exception e12) {
            throw new zzbd(zzbb.zzc, zzba.zzak, e12.getMessage());
        }
    }

    private final OutputStream zzg() throws zzbd {
        try {
            return this.zza.getOutputStream();
        } catch (UnknownServiceException e10) {
            throw new zzbd(zzbb.zzc, zzba.zzaf, e10.getMessage());
        } catch (IOException e11) {
            throw new zzbd(zzbb.zzc, zzba.zzae, e11.getMessage());
        } catch (Exception e12) {
            throw new zzbd(zzbb.zzc, zzba.zzak, e12.getMessage());
        }
    }

    public final zzoi zza(zzoi zzoiVar) throws zzbd {
        try {
            int responseCode = this.zza.getResponseCode();
            if (responseCode != 200) {
                if (responseCode == 400) {
                    throw new zzbd(zzbb.zzc, zzba.zzau, null);
                }
                if (responseCode != 503 && responseCode != 403) {
                    if (responseCode != 404) {
                        throw new zzbd(zzbb.zzc, zzba.zzK, null);
                    }
                    throw new zzbd(zzbb.zzc, zzba.zzi, null);
                }
                throw new zzbd(zzbb.zzi, zzba.zzJ, null);
            }
            byte[] bArrC = a.c(zzf());
            if (bArrC.length == 0) {
                throw new zzbd(zzbb.zzc, zzba.zzat, null);
            }
            try {
                Object objZzb = zzoiVar.zzD().zzb(bArrC);
                t.d(objZzb, "null cannot be cast to non-null type T of com.google.android.libraries.abuse.recaptcha.network.CaptchaFeConnection.getResponse");
                return (zzoi) objZzb;
            } catch (Exception e10) {
                throw new zzbd(zzbb.zzc, zzba.zzG, e10.getMessage());
            }
        } catch (Exception e11) {
            throw new zzbd(zzbb.zzc, zzba.zzah, e11.getMessage());
        }
    }

    public final HttpURLConnection zzb() {
        return this.zza;
    }

    public final void zzc() throws zzbd {
        try {
            this.zza.connect();
        } catch (SocketTimeoutException e10) {
            throw new zzbd(zzbb.zzc, zzba.zzac, e10.getMessage());
        } catch (IOException e11) {
            throw new zzbd(zzbb.zzc, zzba.zzad, e11.getMessage());
        } catch (Exception e12) {
            throw new zzbd(zzbb.zzc, zzba.zzaj, e12.getMessage());
        }
    }

    public final void zzd() {
        this.zza.disconnect();
    }

    public final void zze(byte[] bArr) throws zzbd {
        try {
            zzg().write(bArr);
        } catch (zzbd e10) {
            throw e10;
        } catch (IOException e11) {
            throw new zzbd(zzbb.zzc, zzba.zzag, e11.getMessage());
        } catch (Exception e12) {
            throw new zzbd(zzbb.zzc, zzba.zzal, e12.getMessage());
        }
    }
}
