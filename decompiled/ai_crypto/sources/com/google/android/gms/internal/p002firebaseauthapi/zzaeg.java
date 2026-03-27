package com.google.android.gms.internal.p002firebaseauthapi;

import S1.a;
import Z2.O;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: loaded from: classes.dex */
public class zzaeg {
    private final zzaed zza;
    private final a zzb;

    public zzaeg(zzaeg zzaegVar) {
        this(zzaegVar.zza, zzaegVar.zzb);
    }

    public final void zza(String str) {
        try {
            this.zza.zza(str);
        } catch (RemoteException e7) {
            this.zzb.b("RemoteException when sending auto retrieval timeout response.", e7, new Object[0]);
        }
    }

    public void zzb(String str) {
        try {
            this.zza.zzb(str);
        } catch (RemoteException e7) {
            this.zzb.b("RemoteException when sending send verification code response.", e7, new Object[0]);
        }
    }

    public final void zzc(String str) {
        try {
            this.zza.zzc(str);
        } catch (RemoteException e7) {
            this.zzb.b("RemoteException when sending set account info response.", e7, new Object[0]);
        }
    }

    public final void zza(zzagn zzagnVar) {
        try {
            this.zza.zza(zzagnVar);
        } catch (RemoteException e7) {
            this.zzb.b("RemoteException when sending create auth uri response.", e7, new Object[0]);
        }
    }

    public final void zzb() {
        try {
            this.zza.zzb();
        } catch (RemoteException e7) {
            this.zzb.b("RemoteException when sending email verification response.", e7, new Object[0]);
        }
    }

    public final void zzc() {
        try {
            this.zza.zzc();
        } catch (RemoteException e7) {
            this.zzb.b("RemoteException when setting FirebaseUI Version", e7, new Object[0]);
        }
    }

    public zzaeg(zzaed zzaedVar, a aVar) {
        this.zza = (zzaed) AbstractC1207s.k(zzaedVar);
        this.zzb = (a) AbstractC1207s.k(aVar);
    }

    public final void zza() {
        try {
            this.zza.zza();
        } catch (RemoteException e7) {
            this.zzb.b("RemoteException when sending delete account response.", e7, new Object[0]);
        }
    }

    public final void zza(zzaak zzaakVar) {
        try {
            this.zza.zza(zzaakVar);
        } catch (RemoteException e7) {
            this.zzb.b("RemoteException when sending failure result with credential", e7, new Object[0]);
        }
    }

    public final void zza(zzaaj zzaajVar) {
        try {
            this.zza.zza(zzaajVar);
        } catch (RemoteException e7) {
            this.zzb.b("RemoteException when sending failure result for mfa", e7, new Object[0]);
        }
    }

    public final void zza(Status status, O o7) {
        try {
            this.zza.zza(status, o7);
        } catch (RemoteException e7) {
            this.zzb.b("RemoteException when sending failure result.", e7, new Object[0]);
        }
    }

    public void zza(Status status) {
        try {
            this.zza.zza(status);
        } catch (RemoteException e7) {
            this.zzb.b("RemoteException when sending failure result.", e7, new Object[0]);
        }
    }

    public final void zza(zzahj zzahjVar) {
        try {
            this.zza.zza(zzahjVar);
        } catch (RemoteException e7) {
            this.zzb.b("RemoteException when sending Play Integrity Producer project response.", e7, new Object[0]);
        }
    }

    public final void zza(zzahk zzahkVar) {
        try {
            this.zza.zza(zzahkVar);
        } catch (RemoteException e7) {
            this.zzb.b("RemoteException when sending get recaptcha config response.", e7, new Object[0]);
        }
    }

    public final void zza(zzahn zzahnVar, zzahc zzahcVar) {
        try {
            this.zza.zza(zzahnVar, zzahcVar);
        } catch (RemoteException e7) {
            this.zzb.b("RemoteException when sending get token and account info user response", e7, new Object[0]);
        }
    }

    public final void zza(zzahx zzahxVar) {
        try {
            this.zza.zza(zzahxVar);
        } catch (RemoteException e7) {
            this.zzb.b("RemoteException when sending password reset response.", e7, new Object[0]);
        }
    }

    public final void zza(zzahy zzahyVar) {
        try {
            this.zza.zza(zzahyVar);
        } catch (RemoteException e7) {
            this.zzb.b("RemoteException when sending revoke token response.", e7, new Object[0]);
        }
    }

    public final void zza(zzaij zzaijVar) {
        try {
            this.zza.zza(zzaijVar);
        } catch (RemoteException e7) {
            this.zzb.b("RemoteException when sending start mfa enrollment response.", e7, new Object[0]);
        }
    }

    public final void zza(zzahn zzahnVar) {
        try {
            this.zza.zza(zzahnVar);
        } catch (RemoteException e7) {
            this.zzb.b("RemoteException when sending token result.", e7, new Object[0]);
        }
    }

    public final void zza(O o7) {
        try {
            this.zza.zza(o7);
        } catch (RemoteException e7) {
            this.zzb.b("RemoteException when sending verification completed response.", e7, new Object[0]);
        }
    }
}
